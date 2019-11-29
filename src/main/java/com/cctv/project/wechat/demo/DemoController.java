package com.cctv.project.wechat.demo;

import com.cctv.project.wechat.ShiroUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: Wechat->DemoController
 * @description:
 * @author: yanhao
 * @create: 2019-11-29 09:19
 **/
@Controller
@RequestMapping("wx")
public class DemoController {

    @GetMapping("/demo")
    @ResponseBody
    public String getDemo(){
        return ShiroUtils.getLoginName();
    }
}
