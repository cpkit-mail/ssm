package com.ssm.page.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ssm.page.model.PageModel;
import com.ssm.page.service.IPageService;

@Controller
@RequestMapping("/page")
public class PageController {

    @Resource
    private IPageService pageService;

    @RequestMapping(value = "/allUser", method = RequestMethod.GET)
    public String toIndex(Model model) {

        List<PageModel> users = this.pageService.getAllUser();
        model.addAttribute("users", users);

        return "user";
    }
}
