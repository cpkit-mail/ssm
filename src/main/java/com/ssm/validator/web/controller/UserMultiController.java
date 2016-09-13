package com.ssm.validator.web.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ssm.validator.model.UserAnno;
import com.ssm.validator.model.UserGroup;

@Controller(value = "validMultiUserController")
@RequestMapping("/validatorMulti")
public class UserMultiController {

    @InitBinder("usera")
    // 注意:@ModelAttribute里面的参数要跟定义的@InitBinder里面的值对应，否则是取不到值的。
    public void initBinderUserAnno(WebDataBinder binder) {
        // 不同的Model有相同的属性的处理
        // 使用@InitBinder，在每次进行数据绑定的时候，都会回调这个注解的方法
        // 使用前缀usera来区分，设置UserAnno usera
        // 这个方式对URI上的参数无效，仅对parameter区的数据有效
        binder.setFieldDefaultPrefix("usera.");
    }

    @InitBinder("userb")
    public void initBinderUserGroup(WebDataBinder binder) {
        // 使用前缀userb来区分，设置UserAnno userb
        binder.setFieldDefaultPrefix("userb.");
    }

    @RequestMapping(value = "/init", method = RequestMethod.GET)
    public String upload() {
        return "/validator/validatorMulti";
    }

    @RequestMapping("/login")
    public String login(@Valid @ModelAttribute("usera") UserAnno usera, Errors aErrors,
            @Valid @ModelAttribute("userb") UserGroup userb, Errors bErrors) {

        if (aErrors.hasErrors() || bErrors.hasErrors()) {
            // 如果a模型对象验证失败或者b模型对象验证失败
            return "/validator/validatorMulti";
        }

        return "redirect:/upload/init";
    }

}