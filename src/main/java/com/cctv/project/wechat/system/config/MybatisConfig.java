package com.cctv.project.wechat.system.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author by yanhao
 * @Classname MybatisConfig
 * @Description mybatis包扫描
 * @Date 2019/9/11 9:31 上午
 */
@Configuration
@MapperScan("com.cctv.project.wechat.**.mapper")
public class MybatisConfig {

}
