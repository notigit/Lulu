package com.example.lulu.mvp.presenter;

import java.util.ArrayList;
import java.util.List;

import rx.Subscription;

/**
 * Author：Jenny
 * Date:2016/12/22 20:00
 * E-mail：fishloveqin@gmail.com
 */

public abstract class WrapPresenter<V> implements BasePresenter<V> {

    protected List<Subscription> mSubscriptions = new ArrayList<Subscription>();

    @Override
    public void detachView() {
        int size = mSubscriptions.size();
        for (int i = 0; i < size; i++) {

            Subscription subscription = mSubscriptions.get(i);
            if (subscription != null && !subscription.isUnsubscribed()) {
                subscription.unsubscribe();
            }
        }
    }



}
