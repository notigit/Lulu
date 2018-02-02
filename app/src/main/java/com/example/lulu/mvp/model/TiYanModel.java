package com.example.lulu.mvp.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by Administrator on 2018/2/2.
 */

public class TiYanModel {
    public Thread thread;
    @JsonProperty("reception_user")
    public ReceptionUser ReceptionUser;
    public List<Chat> chat;

    public static class Thread {
        public int id;
        public String title;
    }

    public static class ReceptionUser {
        public int id;
        public int sex;
        public int age;
        @JsonProperty("is_model")
        public int isModel;
        @JsonProperty("is_vip")
        public int isVip;
        @JsonProperty("is_master")
        public int isMaster;
        @JsonProperty("is_doyen")
        public int isDoyen;
        @JsonProperty("im_user_id")
        public String imUserId;
        public String nickname;
        public String avatar;
        public String tel;
    }

    public static class Chat {
        public int id;
        public int sex;
        public int age;
        public int num;
        @JsonProperty("is_model")
        public int isModel;
        @JsonProperty("is_vip")
        public int isVip;
        @JsonProperty("is_master")
        public int isMaster;
        @JsonProperty("is_doyen")
        public int isDoyen;
        @JsonProperty("im_user_id")
        public String imUserId;
        @JsonProperty("brand_logo")
        public String brandLogo;
        public String nickname;
        public String avatar;
        public String tel;
        public boolean isSelected;
        public int msgTotal;
    }
}
