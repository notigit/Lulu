package com.example.lulu.mvp.presenter;

import com.example.lulu.mvp.Service.TiYanService;
import com.example.lulu.mvp.ServiceFactory;
import com.example.lulu.mvp.model.ResponseMessage;
import com.example.lulu.mvp.model.TiYanModel;
import com.example.lulu.mvp.view.TiYanView;
import com.example.lulu.utils.RXUtil;

import rx.*;
import rx.functions.Action0;

/**
 * Created by Administrator on 2018/2/2.
 */

public class TiYanPresenter extends WrapPresenter<TiYanView> {
    TiYanView view;
    TiYanService service;
    rx.Subscription subscription;

    @Override
    public void attachView(TiYanView view) {
        this.view = view;
        service = ServiceFactory.getTiYanService();
    }

    public void getTiYan(String id, String token) {
        subscription = RXUtil.execute(service.getNewContactList(id, token), new Observer<ResponseMessage<TiYanModel>>() {
            @Override
            public void onCompleted() {
//                view.setLoadingIndicator(false);
            }

            @Override
            public void onError(Throwable e) {
//                view.setLoadingIndicator(false);
            }

            @Override
            public void onNext(ResponseMessage<TiYanModel> tiYanModelResponseMessage) {
                if (tiYanModelResponseMessage.statusCode == 0) {
                    view.showSuccess(tiYanModelResponseMessage.data);
                } else {
                    view.showFail(tiYanModelResponseMessage.data);
                }
            }
        }, new Action0() {
            @Override
            public void call() {
//                view.setLoadingIndicator(true);
            }
        });
        mSubscriptions.add(subscription);
    }
}
