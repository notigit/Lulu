package com.example.lulu.mvp.model;

/**
 * Created by 10264 on 2018/2/6.
 */

public class ChannelModel {

    /**
     * error_code : 4000
     * data : {"msg":"该渠道不存在"}
     */

    private int error_code;
    private DataBean data;

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * msg : 该渠道不存在
         */

        private String msg;

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }
    }
}
