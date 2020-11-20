package com.gec.exception;

/**
 * @author Brice
 * @title: MyExecption
 * @projectName springDemo
 * @description: TODO
 * @date 2020/11/1414:51
 */
public class MyExecption extends Exception {
    private String msg;

    public MyExecption() {
    }

    public MyExecption(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
