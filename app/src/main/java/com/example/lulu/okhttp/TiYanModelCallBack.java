package com.example.lulu.okhttp;

import com.example.lulu.mvp.model.TiYanModel;
import com.google.gson.Gson;
import com.squareup.okhttp.Response;
import com.zhy.http.okhttp.callback.Callback;

import java.io.IOException;

/**
 * Created by 10264 on 2018/2/6.
 */

public abstract class TiYanModelCallBack extends Callback<TiYanModel> {
    //非UI线程，支持任何耗时操作
    @Override
    public TiYanModel parseNetworkResponse(Response response) throws IOException {
        String string = response.body().string();
        TiYanModel user = new Gson().fromJson(string, TiYanModel.class);
        return user;
    }
}
