package com.bigdata.controller;

import com.bigdata.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/reg")
@SessionAttributes("state")
public class RegistController {
    @Autowired
    private UserService userService;

    @RequestMapping("/action")
    public String action(HttpServletRequest req, HttpSession session, String code, String mp, String pwd, int gender) {
        // 比对验证码
        String realCap = (String) session.getAttribute("captcha");
        if (realCap.equalsIgnoreCase(code)) {
            // 登录后留取状态标记
            int result = userService.regist(mp, pwd, gender);
            System.out.println("result" + "----- " + result);
            if (result == 2) {
                session.setAttribute("state", "ok:" + mp);
                req.setAttribute("mp", mp);
                req.setAttribute("pwd", pwd);
                req.setAttribute("alert", "注册成功！");
                return "view/ok";
            } else if (result == 1) {
                req.setAttribute("alert", "用户名已经被注册，请重新注册！");
                return "view/err";
            }
        } else {
            req.setAttribute("alert", "验证码错误！");
            return "view/err";
        }
        req.setAttribute("alert", "注册失败！请重新注册！");
        return "view/err";
    }

}
