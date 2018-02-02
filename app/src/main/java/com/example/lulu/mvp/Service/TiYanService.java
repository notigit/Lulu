package com.example.lulu.mvp.Service;

import com.example.lulu.mvp.model.ResponseMessage;
import com.example.lulu.mvp.model.TiYanModel;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Administrator on 2018/2/2.
 */

public interface TiYanService {
    /**
     * 测试接口
     * @param id
     * @param token
     * @return
     */
    @GET("message/message_consumer/user")
    Observable<ResponseMessage<TiYanModel>> getNewContactList(@Query("thread_id") String id,
                                                              @Query("token") String token);
}
