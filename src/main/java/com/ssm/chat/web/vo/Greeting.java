package com.ssm.chat.web.vo;

public class Greeting {

    private long code;
    private String message;

    public Greeting(long time, boolean b, String message) {
        this.code = time;
        this.message = message;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
