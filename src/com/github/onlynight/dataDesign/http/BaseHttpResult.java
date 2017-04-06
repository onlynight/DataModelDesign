package com.github.onlynight.datadesign.http;

/**
 * Created by lion on 2017/4/6.
 * http request base result
 */
public class BaseHttpResult {

    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
