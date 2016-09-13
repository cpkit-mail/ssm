package com.ssm.chat.web.socket.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.ssm.chat.web.vo.Greeting;

@Controller
public class ChatController {

    private static final Log log = LogFactory.getLog(ChatController.class);

    @MessageMapping("/socket/message")
    @SendTo("/chat/receive/tweet")
    public Greeting chat(String message) throws Exception {
        long time = System.currentTimeMillis();
        log.info(time + ":" + message);

        return new Greeting(time, true, message);
    }

}