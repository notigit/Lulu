package com.example.lulu.mvp.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *  Author：Jenny
 * Date:2016/12/8 20:13
 * E-mail：fishloveqin@gmail.com
 *  json数据模型抽象
 * 
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseMessage<T> implements Serializable {
    @JsonProperty("code")
    public int    statusCode;

    @JsonProperty("msg")
    public String statusMessage;

    @JsonProperty("data")
    public T      data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseMessage{" + "statusCode=" + statusCode + ", statusMessage='" + statusMessage
               + '\'' + ", data=" + data + '}';
    }
}
