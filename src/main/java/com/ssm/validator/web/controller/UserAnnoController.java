package com.ssm.validator.web.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ssm.validator.model.UserAnno;

@Controller(value = "validAnnoUserController")
@RequestMapping("/validatorAnno")
public class UserAnnoController {

    @RequestMapping(value = "/init", method = RequestMethod.GET)
    public String upload() {
        return "/validator/validatorAnno";
    }

    @RequestMapping("/annologin")
    public String login(@Valid @ModelAttribute("userAnno") UserAnno user, Errors result) {
        if (result.hasErrors()) {
            return "/validator/validatorAnno";
        }
        return "redirect:/upload/init";
    }

}
