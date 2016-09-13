package com.ssm.validator.web.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ssm.validator.model.UserVaild;
import com.ssm.validator.web.validator.UserValidator;

@Controller(value = "validUserController")
@RequestMapping("/validator")
public class UserVaildController {

    @InitBinder
    public void initBinder(DataBinder binder) {
        binder.setValidator(new UserValidator());
    }

    @RequestMapping(value = "/init", method = RequestMethod.GET)
    public String upload() {
        return "/validator/validator";
    }

    @RequestMapping("/login")
    public String login(@Valid @ModelAttribute("userVaild") UserVaild user, BindingResult result) {
        if (result.hasErrors()) {
            return "/validator/validator";
        }
        return "redirect:/upload/init";
    }

}