package com.bigdata.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //声明这是一个控制器
@RequestMapping("") //访问路径 ，等价于url-pattern
public class IndexController {

    @RequestMapping("/") //访问路径
    public String index() {
        System.out.println("执行首页!!!");
        return "index";
    }

    @RequestMapping("/login")
    public String login() {
        System.out.println("执行登录");
        return "view/login";
    }

    @RequestMapping("/regist")
    public String regist() {
        System.out.println("执行注册");
        return "view/regist";
    }
}
