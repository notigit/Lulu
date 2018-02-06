package com.example.lulu.okhttp;

import com.example.lulu.mvp.model.TiYanModel;
import com.google.gson.Gson;
import com.squareup.okhttp.Response;
import com.zhy.http.okhttp.callback.Callback;

import java.io.IOException;

/**
 * Created by 10264 on 2018/2/6.
 */

public abstract class OneModelCallBack extends Callback<OneModel> {
    //非UI线程，支持任何耗时操作
    @Override
    public OneModel parseNetworkResponse(Response response) throws IOException {
        String string = response.body().string();
        OneModel user = new Gson().fromJson(string, OneModel.class);
        return user;
    }
}
