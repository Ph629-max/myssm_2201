package com.bigdata.controller;

import com.bigdata.entity.User;
import com.bigdata.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
@SessionAttributes("state")
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping("/action")
    public String action(HttpServletRequest req, HttpSession session, String code, String mp, String pwd) {
        // 比对验证码
        String realCap = (String) session.getAttribute("captcha");
        if (realCap.equalsIgnoreCase(code)) {
            // 登录后留取状态标记
            System.out.println(mp + "-----" + pwd);
            int result = userService.login(mp, pwd);
            if (result == 1) {
                session.setAttribute("state", mp);
                req.setAttribute("mp", mp);
                req.setAttribute("pwd", pwd);
                req.setAttribute("alert", "登录成功！");

                System.out.println("----------" + session.getAttribute("state"));
                //return "view/index";
                return "redirect:/mgr/index"; // 重定向
            }
        } else {
            req.setAttribute("alert", "验证码错误！");
            return "view/err";
        }
        req.setAttribute("alert", "登录失败！请重新尝试！");
        return "view/err";
    }

}
