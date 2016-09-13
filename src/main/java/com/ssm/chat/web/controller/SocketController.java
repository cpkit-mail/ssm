package com.ssm.chat.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chat")
public class SocketController {

    @RequestMapping("/hello")
    public String hello() {
        return "chat/socket";
    }

}
