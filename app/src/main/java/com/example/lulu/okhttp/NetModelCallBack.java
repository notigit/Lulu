package com.example.lulu.okhttp;

import com.google.gson.Gson;
import com.squareup.okhttp.Response;
import com.zhy.http.okhttp.callback.Callback;

import java.io.IOException;

/**
 * Created by 10264 on 2018/2/9.
 */

public abstract class NetModelCallBack extends Callback<NetModel> {
    //非UI线程，支持任何耗时操作
    @Override
    public NetModel parseNetworkResponse(Response response) throws IOException {
        String string = response.body().string();
        NetModel user = new Gson().fromJson(string, NetModel.class);
        return user;
    }
}
