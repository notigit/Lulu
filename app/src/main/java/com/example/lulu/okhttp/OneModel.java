package com.example.lulu.okhttp;

import java.util.List;

/**
 * Created by 10264 on 2018/2/6.
 */

public class OneModel {

    /**
     * code : 20002
     * msg : 您不是销售人员
     * data : []
     */

    private int code;
    private String msg;
    private List<?> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }
}
