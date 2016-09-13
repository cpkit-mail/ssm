package com.ssm.i18n.web.controller;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "i18nUserController")
@RequestMapping("/i18n")
public class UserI18nController {

    @Resource
    private MessageSource messageSource;

    @RequestMapping(value = "/init", method = RequestMethod.GET)
    public String init() {
        return "/i18n/message";
    }

    @RequestMapping(value = "/init", method = RequestMethod.POST)
    public ModelAndView mAndV(String lng) {

        String chglng = lng;
        if (lng != null) {
            if (lng.startsWith("{") && lng.endsWith("}")) {
                chglng = lng.substring(1, lng.length() - 1);
            }
            try {
                chglng = messageSource.getMessage(chglng, new Object[] {}, Locale.getDefault());
            } catch (NoSuchMessageException e) {
                chglng = "No Such Key!!";
            }
        }

        ModelAndView mav = new ModelAndView("/i18n/message");
        mav.addObject("chglng", chglng);

        return mav;
    }

    @RequestMapping(value = "/init2", method = RequestMethod.POST)
    public Map<String, String> upload(String lng) {

        String chglng = lng;
        if (lng != null) {
            if (lng.startsWith("{") && lng.endsWith("}")) {
                chglng = lng.substring(1, lng.length() - 1);
            }
            try {
                chglng = messageSource.getMessage(chglng, new Object[] {}, Locale.getDefault());
            } catch (NoSuchMessageException e) {
                chglng = "No Such Key!!";
            }
        }

        Map<String, String> map = new HashMap<String, String>();
        map.put("chglng", chglng);

        return map;
    }

}
