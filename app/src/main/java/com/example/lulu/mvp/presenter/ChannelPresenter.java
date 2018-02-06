package com.example.lulu.mvp.presenter;

import com.example.lulu.mvp.ServiceFactory;
import com.example.lulu.mvp.model.ChannelModel;
import com.example.lulu.mvp.Service.ChannelService;
import com.example.lulu.mvp.view.ChannelView;
import com.example.lulu.utils.RXUtil;

import rx.Observer;
import rx.Subscription;

/**
 * Created by 10264 on 2018/2/6.
 */

public class ChannelPresenter extends WrapPresenter<ChannelView>{
    ChannelService service;
    ChannelView view;
    Subscription subscription;

    @Override
    public void attachView(ChannelView view) {
        this.view = view;
        service = ServiceFactory.getChannelService();
    }
    public void getChannel(String channel){
        subscription = RXUtil.execute(service.getChannel(channel), new Observer<ChannelModel>() {
            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(ChannelModel channelModel) {
                if (channelModel.getError_code() == 0){
                    view.showSuccess(channelModel);
                }else {

                }
            }
        });
    }
}
