package com.ssm.validator.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ssm.validator.group.Group;
import com.ssm.validator.group.GroupA;
import com.ssm.validator.group.GroupB;
import com.ssm.validator.model.UserGroup;

@Controller(value = "validGroupUserController")
@RequestMapping("/validatorGroup")
public class UserGroupController {

    @RequestMapping(value = "/init", method = RequestMethod.GET)
    public String upload() {
        return "/validator/validatorGroup";
    }

    @RequestMapping("/nogroup")
    public String login(@Validated @ModelAttribute("userGroup") UserGroup user, Errors result) {
        if (result.hasErrors()) {
            return "/validator/validatorGroup";
        }
        return "redirect:/upload/init";
    }

    @RequestMapping("/group")
    public String group(@Validated(Group.class) @ModelAttribute("userGroup") UserGroup user, Errors result) {
        if (result.hasErrors()) {
            return "/validator/validatorGroup";
        }
        return "redirect:/upload/init";
    }

    @RequestMapping("/groupa")
    public String groupa(@Validated(GroupA.class) @ModelAttribute("userGroup") UserGroup user, Errors result) {
        if (result.hasErrors()) {
            return "/validator/validatorGroup";
        }
        return "redirect:/upload/init";
    }

    @RequestMapping("/groupb")
    public String groupb(@Validated(GroupB.class) @ModelAttribute("userGroup") UserGroup user, Errors result) {
        if (result.hasErrors()) {
            return "/validator/validatorGroup";
        }
        return "redirect:/upload/init";
    }

}
