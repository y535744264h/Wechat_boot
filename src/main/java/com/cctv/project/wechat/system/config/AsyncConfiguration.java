package com.cctv.project.wechat.system.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @program: noah->AsyncConfiguration
 * @description:
 * @author: yanhao
 * @create: 2019-11-22 16:02
 **/
@Configuration
@EnableAsync
public class AsyncConfiguration {

    /** 核心线程池大小 **/
    private int corePoolSize = 10;

    /** 最大可创建的线程数 **/
    private int maxPoolSize = 100;

    /** 队列最大长度 **/
    private int queueCapacity = 1000;

    /** 线程池维护线程所允许的空闲时间 **/
    private int keepAliveSeconds = 300;

    @Bean(name = "asyncServiceExecutor")
    public Executor asyncServiceExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //配置核心线程数
        executor.setCorePoolSize(corePoolSize);
        //配置最大线程数
        executor.setMaxPoolSize(maxPoolSize);
        //配置队列大小
        executor.setQueueCapacity(queueCapacity);
        //配置线程池中的线程的名称前缀
        executor.setThreadNamePrefix("Noah-Async-");
        // rejection-policy：当pool已经达到max size的时候，如何处理新任务
        // CALLER_RUNS：不在新线程中执行任务，而是有调用者所在的线程来执行
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        //执行初始化
        executor.initialize();
        return executor;
    }

}
