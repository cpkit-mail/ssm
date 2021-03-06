package com.ssm.aop.web.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ssm.kernel.model.User;
import com.ssm.kernel.service.IUserService;

@Controller(value = "aopUserController")
@RequestMapping("/aop")
public class UserController {

    @Resource
    private IUserService userService;

    @RequestMapping(value = "/userInfo/{id}", method = RequestMethod.GET)
    public String toIndex(HttpServletRequest request, Model model, @PathVariable("id") String id) {

        if (StringUtils.isEmpty(id)) {
            throw new IllegalArgumentException("id不能为空");
        }

        int userId = Integer.parseInt(id);
        User user = this.userService.getUserById(userId);
        model.addAttribute("user", user);

        return "user";
    }
}
