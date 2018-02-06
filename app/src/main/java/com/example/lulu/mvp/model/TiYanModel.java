package com.example.lulu.mvp.model;

import java.util.List;

/**
 * Created by Administrator on 2018/2/2.
 */

public class TiYanModel {

    /**
     * code : 0
     * msg :
     * data : {"thread":{"id":6862,"title":"173测试测试"},"reception_user":{"id":1237,"nickname":"no","avatar":"/avatar/1712/18/aa47952504a00c6ef0776f81240a1914.png","sex":1,"is_model":0,"is_doyen":0,"tel":"17319259905","age":48,"is_vip":0,"is_master":0,"im_user_id":"im_development_1237_kcwc"},"chat":[{"id":110,"nickname":"叶子","avatar":"/thread/1801/17/4ca6f6873a43cce08364685f1f25d4dc.jpeg","sex":1,"is_model":1,"is_doyen":1,"tel":"18716636959","age":27,"is_vip":1,"is_master":1,"brand_logo":"","im_user_id":"im_development_110_kcwc","num":0}]}
     */

    private int code;
    private String msg;
    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * thread : {"id":6862,"title":"173测试测试"}
         * reception_user : {"id":1237,"nickname":"no","avatar":"/avatar/1712/18/aa47952504a00c6ef0776f81240a1914.png","sex":1,"is_model":0,"is_doyen":0,"tel":"17319259905","age":48,"is_vip":0,"is_master":0,"im_user_id":"im_development_1237_kcwc"}
         * chat : [{"id":110,"nickname":"叶子","avatar":"/thread/1801/17/4ca6f6873a43cce08364685f1f25d4dc.jpeg","sex":1,"is_model":1,"is_doyen":1,"tel":"18716636959","age":27,"is_vip":1,"is_master":1,"brand_logo":"","im_user_id":"im_development_110_kcwc","num":0}]
         */

        private ThreadBean thread;
        private ReceptionUserBean reception_user;
        private List<ChatBean> chat;

        public ThreadBean getThread() {
            return thread;
        }

        public void setThread(ThreadBean thread) {
            this.thread = thread;
        }

        public ReceptionUserBean getReception_user() {
            return reception_user;
        }

        public void setReception_user(ReceptionUserBean reception_user) {
            this.reception_user = reception_user;
        }

        public List<ChatBean> getChat() {
            return chat;
        }

        public void setChat(List<ChatBean> chat) {
            this.chat = chat;
        }

        public static class ThreadBean {
            /**
             * id : 6862
             * title : 173测试测试
             */

            private int id;
            private String title;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }
        }

        public static class ReceptionUserBean {
            /**
             * id : 1237
             * nickname : no
             * avatar : /avatar/1712/18/aa47952504a00c6ef0776f81240a1914.png
             * sex : 1
             * is_model : 0
             * is_doyen : 0
             * tel : 17319259905
             * age : 48
             * is_vip : 0
             * is_master : 0
             * im_user_id : im_development_1237_kcwc
             */

            private int id;
            private String nickname;
            private String avatar;
            private int sex;
            private int is_model;
            private int is_doyen;
            private String tel;
            private int age;
            private int is_vip;
            private int is_master;
            private String im_user_id;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public int getSex() {
                return sex;
            }

            public void setSex(int sex) {
                this.sex = sex;
            }

            public int getIs_model() {
                return is_model;
            }

            public void setIs_model(int is_model) {
                this.is_model = is_model;
            }

            public int getIs_doyen() {
                return is_doyen;
            }

            public void setIs_doyen(int is_doyen) {
                this.is_doyen = is_doyen;
            }

            public String getTel() {
                return tel;
            }

            public void setTel(String tel) {
                this.tel = tel;
            }

            public int getAge() {
                return age;
            }

            public void setAge(int age) {
                this.age = age;
            }

            public int getIs_vip() {
                return is_vip;
            }

            public void setIs_vip(int is_vip) {
                this.is_vip = is_vip;
            }

            public int getIs_master() {
                return is_master;
            }

            public void setIs_master(int is_master) {
                this.is_master = is_master;
            }

            public String getIm_user_id() {
                return im_user_id;
            }

            public void setIm_user_id(String im_user_id) {
                this.im_user_id = im_user_id;
            }
        }

        public static class ChatBean {
            /**
             * id : 110
             * nickname : 叶子
             * avatar : /thread/1801/17/4ca6f6873a43cce08364685f1f25d4dc.jpeg
             * sex : 1
             * is_model : 1
             * is_doyen : 1
             * tel : 18716636959
             * age : 27
             * is_vip : 1
             * is_master : 1
             * brand_logo :
             * im_user_id : im_development_110_kcwc
             * num : 0
             */

            private int id;
            private String nickname;
            private String avatar;
            private int sex;
            private int is_model;
            private int is_doyen;
            private String tel;
            private int age;
            private int is_vip;
            private int is_master;
            private String brand_logo;
            private String im_user_id;
            private int num;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public int getSex() {
                return sex;
            }

            public void setSex(int sex) {
                this.sex = sex;
            }

            public int getIs_model() {
                return is_model;
            }

            public void setIs_model(int is_model) {
                this.is_model = is_model;
            }

            public int getIs_doyen() {
                return is_doyen;
            }

            public void setIs_doyen(int is_doyen) {
                this.is_doyen = is_doyen;
            }

            public String getTel() {
                return tel;
            }

            public void setTel(String tel) {
                this.tel = tel;
            }

            public int getAge() {
                return age;
            }

            public void setAge(int age) {
                this.age = age;
            }

            public int getIs_vip() {
                return is_vip;
            }

            public void setIs_vip(int is_vip) {
                this.is_vip = is_vip;
            }

            public int getIs_master() {
                return is_master;
            }

            public void setIs_master(int is_master) {
                this.is_master = is_master;
            }

            public String getBrand_logo() {
                return brand_logo;
            }

            public void setBrand_logo(String brand_logo) {
                this.brand_logo = brand_logo;
            }

            public String getIm_user_id() {
                return im_user_id;
            }

            public void setIm_user_id(String im_user_id) {
                this.im_user_id = im_user_id;
            }

            public int getNum() {
                return num;
            }

            public void setNum(int num) {
                this.num = num;
            }
        }
    }
}
