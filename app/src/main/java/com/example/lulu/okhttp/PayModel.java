package com.example.lulu.okhttp;

/**
 * Created by 10264 on 2018/2/9.
 */

public class PayModel {

    /**
     * code : 1
     * msg : ok
     * payurl : http://api.llqqxx.cc/9db8AVNSCAB/RVgQHUQFTUF/YBWlBSVldUBVtSBlAAHA8NVg/EEAgQIBVdTA1/QFAgEIClJaB/ldXUlYBUVV/RW1dR
     */

    private int code;
    private String msg;
    private String payurl;

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

    public String getPayurl() {
        return payurl;
    }

    public void setPayurl(String payurl) {
        this.payurl = payurl;
    }
}
