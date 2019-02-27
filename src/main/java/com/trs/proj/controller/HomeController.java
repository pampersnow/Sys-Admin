package com.trs.proj.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping({"/","/index"})
    public String index(){
        return "/index";
    }
	@RequestMapping("/login")
    public String login(HttpServletRequest request, Map<String,Object> map) throws Exception{
        System.out.println("登录页面");
        // 登录失败从request中获取shiro处理的异常信息。
        // shiroLoginFailure:就是shiro异常类的全类名.
        String exception = (String) request.getAttribute("shiroLoginFailure");
        System.out.println("exception="+exception);
        String msg = "";
        if (exception!=null){
            if (UnknownAccountException.class.getName().equals(exception)){
            	String card = request.getHeader("User-Agent");
            	System.out.println(card);
                System.out.println("账号不存在");
                msg = "账号不存在";
            } else if (IncorrectCredentialsException.class.getName().equals(exception)){
                System.out.println("密码不正确");
                msg = "密码不正确";
            } else if ("kaptchaValidateFailed".equals(exception)){
                System.out.println("验证码不正确");
            } else {
                msg ="else  "+exception;
                System.out.println("else  "+exception);
            }
        }
        map.put("msg",msg);
        return "login";
    }
 
    @RequestMapping("/403")
    public String unauthorizaRole(){
        System.out.println("没有权限");
        return "/403";
    }
 
    @RequestMapping("/registered")
    public String registered(){
        return "/registered";
    }
}
