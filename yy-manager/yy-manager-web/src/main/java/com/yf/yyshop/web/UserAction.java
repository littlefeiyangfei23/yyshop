package com.yf.yyshop.web;

import com.yf.yyshop.pojo.po.YyUser;
import com.yf.yyshop.service.UserService;
import com.yf.yyshop.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;


@Controller
@Scope("prototype")
public class UserAction {
    private Logger logger= LoggerFactory.getLogger(this.getClass());
//
    @Autowired
    private UserService userService;

    /*登录
       * ajax加注解@ResponseBody ，在这里，return "index" 不是返回逻辑视图，而是字符串 登录
       */
    @RequestMapping("/userlogin")
    @ResponseBody
    public String doLogin(YyUser yyUser, HttpSession session) throws Exception {
        String mess = "2";
        System.out.println("111");
       if (yyUser != null) {
            if (yyUser.getUsername().equals("")) {
                mess = "0";// 用户名不为空
            } else if (yyUser.getUpwd().equals("")) {
                mess = "1";// 密码不为空
            } else {
                YyUser findUser = userService.findByUsername(yyUser);
                if (findUser != null) {
                    // 匹配密码
                    if (findUser.getUpwd().equals(yyUser.getUpwd())) {
                        // 密码也相等，就放入session中
                        session.setAttribute("sessionUser", findUser);
                        return "index";
                    } else {
                        mess = "2";// 用户名或密码错误
                    }
                } else {
                    mess = "2";
                }
            }
        }
        return mess;
    }


    /*用户注册
       * ajax加注解@ResponseBody ，在这里，return "index" 不是返回逻辑视图，而是字符串 登录
       */
    @RequestMapping("/userRegister")
    @ResponseBody
    public String doRegister(YyUser yyUser, HttpSession session) throws Exception {
        String mess = "2";
        System.out.println("111");
        if (yyUser != null) {
            if (yyUser.getUsername().equals("")) {
                mess = "0";// 用户名不为空
            } else if (yyUser.getUpwd().equals("")) {
                mess = "1";// 密码不为空
            } else {
                YyUser findUser = userService.findByUsername(yyUser);
                if (findUser == null) {
                        session.setAttribute("sessionUser", findUser);
                        return "index";

                } else {
                    mess = "2";//用户名已存在
                }
            }
        }
        return mess;
    }
}
