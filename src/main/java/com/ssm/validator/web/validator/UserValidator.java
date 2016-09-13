package com.ssm.validator.web.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ssm.validator.model.UserVaild;

public class UserValidator implements Validator {

    public boolean supports(Class<?> clazz) {

        // 定义了该UserValidator只支持对User对象进行校验
        return UserVaild.class.equals(clazz);
    }

    // 校验User对象的username和password不为empty的情况，这里的empty包括null和空字符串两种情况
    public void validate(Object obj, Errors errors) {

        // ValidationUtils类是Spring中提供的一个工具类。Errors就是Spring用来存放错误信息的对象。
        ValidationUtils.rejectIfEmpty(errors, "userName", null, "UserName is empty.");
        UserVaild user = (UserVaild) obj;
        if (null == user.getPassword() || "".equals(user.getPassword())) {
            errors.rejectValue("password", null, "Password is empty.");
        }

    }

}