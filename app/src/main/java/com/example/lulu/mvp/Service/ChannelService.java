package com.example.lulu.mvp.Service;

import com.example.lulu.mvp.model.ChannelModel;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by 10264 on 2018/2/6.
 */

public interface ChannelService {
    @POST("channel.php")
    @FormUrlEncoded
    Observable<ChannelModel> getChannel(@Field("channel") String channel);
}
