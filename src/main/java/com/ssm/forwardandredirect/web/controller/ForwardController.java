package com.ssm.forwardandredirect.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/forward")
public class ForwardController {

    // 请求转发
    // 返回ModelAndView
    @RequestMapping(value = "/modelAndView", method = RequestMethod.GET)
    public ModelAndView testForward(ModelAndView model,
            @RequestParam(value = "id", defaultValue = "1", required = false) Long id) {

        model.addObject("user", "u");
        model.setViewName("forward:index.jsp");

        return model;
    }

    // 请求转发
    // 返回字符串
    @RequestMapping(value = "/string", method = RequestMethod.GET)
    public String testForward() {

        return "forward:/index.action";
    }

}
