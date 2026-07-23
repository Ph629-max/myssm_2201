package com.bigdata.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;

@Controller //声明这是一个控制器
@RequestMapping("/mgr") //访问路径 ，等价于url-pattern
@SessionAttributes("state")
public class ManagerController {

    @RequestMapping("/index")
    public String index() {
        return "view/mgrindex";
    }

    @RequestMapping("/userlist")
    public String userlist() {
        return "view/userlist";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("state"); // 清除登录状态
        session.invalidate(); // 销毁会话
        return "redirect:/";
    }

}
