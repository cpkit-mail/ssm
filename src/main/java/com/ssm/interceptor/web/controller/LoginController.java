package com.ssm.interceptor.web.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssm.kernel.service.IUserService;

@Controller
@RequestMapping("/interceptor")
public class LoginController {

    @Resource
    private IUserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String toIndex(HttpServletRequest request, Model model, @RequestParam("user") String user,
            @RequestParam("password") String password) {

        if (StringUtils.isEmpty(user)) {
            throw new IllegalArgumentException("user不能为空");
        }

        request.getSession().setAttribute("user", user);

        // 登陆的验证通过后,在从session里获取前画面的url
        String url = (String) request.getSession().getAttribute("redirectUrl");
        request.getSession().removeAttribute("redirectUrl");

        // 转向到前画面
        return "redirect:" + url;
    }

}
