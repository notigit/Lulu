package com.example.lulu.utils;

import android.util.Log;

import com.example.lulu.Constant;

import java.io.InputStream;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.plugins.RxJavaErrorHandler;
import rx.plugins.RxJavaPlugins;
import rx.schedulers.Schedulers;

/**
 * Author:Jenny
 * Date:16/6/28 16:47
 * E-mail:fishloveqin@gmail.com
 * RXAndroid 与Retrofit网络请求工具类
 **/
public class RXUtil {

    static OkHttpClient mClient = null;

    public static SSLSocketFactory getSslSocketFactory(InputStream certificates) {
        SSLContext sslContext = null;
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");

            Certificate ca;
            try {
                ca = certificateFactory.generateCertificate(certificates);

            } finally {
                certificates.close();
            }

            // Create a KeyStore containing our trusted CAs
            String keyStoreType = KeyStore.getDefaultType();
            KeyStore keyStore = KeyStore.getInstance(keyStoreType);
            keyStore.load(null, null);
            keyStore.setCertificateEntry("ca", ca);

            // Create a TrustManager that trusts the CAs in our KeyStore
            String tmfAlgorithm = TrustManagerFactory.getDefaultAlgorithm();
            TrustManagerFactory tmf = TrustManagerFactory.getInstance(tmfAlgorithm);
            tmf.init(keyStore);

            // Create an SSLContext that uses our TrustManager
            sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, tmf.getTrustManagers(), null);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return sslContext != null ? sslContext.getSocketFactory() : null;
    }

    private static String BASE_URL = Constant.API_BASE_URL;

    public static class Factory {
        public static <T> T create(Class<T> t) {

            Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(JacksonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create()).client(OK_BUILD.build())
                .build();
            return (T) retrofit.create(t);
        }
    }

    public static <T> Subscription execute(Observable<T> t, Observer<T> t1) {

        return t.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
            .subscribe(t1);
    }

    public static <T> Subscription execute(Observable<T> t, Observer<T> t1, Action0 action) {

        return t.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe(action).subscribeOn(AndroidSchedulers.mainThread()).subscribe(t1);
    }

    public final static OkHttpClient.Builder OK_BUILD = new OkHttpClient.Builder();
    private final static int                 TIME_OUT = 30 * 1000;

    static {
        OK_BUILD.connectTimeout(TIME_OUT, java.util.concurrent.TimeUnit.MILLISECONDS);
        OK_BUILD.readTimeout(TIME_OUT, java.util.concurrent.TimeUnit.MILLISECONDS);
        OK_BUILD.writeTimeout(TIME_OUT, java.util.concurrent.TimeUnit.MILLISECONDS);
        //        OK_BUILD.cache(new Cache())
        OK_BUILD.addInterceptor(new RequestInterceptor());

    }

    static {
        RxJavaPlugins.getInstance().registerErrorHandler(new RxJavaErrorHandler() {
            @Override
            public void handleError(Throwable e) {

                Log.e("lulu","RXSystemError:"+e.getMessage());
                e.printStackTrace();
            }
        });
    }
}
