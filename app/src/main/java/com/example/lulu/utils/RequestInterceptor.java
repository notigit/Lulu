package com.example.lulu.utils;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Author:Jenny
 * Date:16/12/8 17:17
 * E-mail:fishloveqin@gmail.com
 * 网络请求、响应拦截器
 **/
public class RequestInterceptor implements Interceptor {
  public static Context appContext;
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request oldRequest = chain.request();
        Request.Builder requestBuilder = oldRequest.newBuilder();
        // 添加head
        //        Headers.Builder headBuilder = oldRequest.headers().newBuilder();
        //        headBuilder.add("apikey", "a7802d983b3d58ed6e70ed71bb0c7f14");
        //        requestBuilder.headers(headBuilder.build());
        // 重新组成新的请求
        Request newRequest = null;
        if (oldRequest.method().equals("POST")) {
            //添加Post参数
            //Logger.d("RequestInterceptor", oldRequest.body().contentType().type());
            if (oldRequest.body().contentType().subtype().equals("x-www-form-urlencoded")) {
                FormBody old = (FormBody) oldRequest.body();
                FormBody.Builder formBodyBuilder = new FormBody.Builder();
                for (int i = 0; i < old.size(); i++) {
                    formBodyBuilder.addEncoded(old.encodedName(i), old.encodedValue(i));
                }
                //                formBodyBuilder.addEncoded("platform", "1");
                // task_status=pending&request_from=app&slog_force_client_id=slog_beb3be&scene_id=30&user_token=5d632c74fa5bda572a614ba4e2312688
                //formBodyBuilder.addEncoded("request_from", "app");
                //formBodyBuilder.addEncoded("slog_force_client_id", "slog_beb3be");
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(oldRequest.url() + "?");

                FormBody body = formBodyBuilder.build();
                int size = body.size();
                for (int i = 0; i < size; i++) {

                    stringBuilder.append(body.encodedName(i) + "=" + body.encodedValue(i));
                    stringBuilder.append("&");
                }
                String str = stringBuilder.toString();
               Log.e("lulu","All request post parameters:"+str.substring(0, str.length() - 1));
                newRequest = requestBuilder.method(oldRequest.method(), formBodyBuilder.build())
                    .build();
            } else {
                newRequest = oldRequest;
            }

        } else {
            //添加Get参数 userToken=&requsetFrom=&slogForceClientId=&sceneId=&status=&areaId=&jobtypeId=
            HttpUrl.Builder authorizedUrlBuilder = oldRequest.url().newBuilder();
            // authorizedUrlBuilder.addQueryParameter("request_from", "app");
            //authorizedUrlBuilder.addQueryParameter("slog_force_client_id", "slog_beb3be");
            newRequest = requestBuilder.url(authorizedUrlBuilder.build()).build();

            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(oldRequest.url());
//            HttpUrl build = authorizedUrlBuilder.build();
//            int size = build.querySize();

            //            for (int i = 0; i < size; i++) {
            //
            //                stringBuilder
            //                    .append(build.queryParameterName(i) + "=" + build.queryParameterValue(i));
            //                stringBuilder.append("&");
            //                System.out.println("size:"+stringBuilder.toString());
            //            }
            String str = stringBuilder.toString();
            Log.e("tag","All request get parameters:" + str);

        }

        Response response = chain.proceed(newRequest);
        if (response.body() != null) {
            MediaType mediaType = response.body().contentType();
            String body = response.body().string();
            try {
                JSONObject json = new JSONObject(body);
              int  code=  json.optInt("code");
              //不需要拦截
//                if(Constants.HTTP_LOGIN_ERROR == code||Constants.HTTP_LOGIN_OUT== code){
//                    if(appContext!=null){
//                        IOUtils.loginOut(appContext,Constants.KEY_ACCOUNT_FILE);
//                        Intent toIntent = new Intent(appContext, LoginActivity.class);
//                        toIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                        appContext.startActivity(toIntent);
//                    }
//                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            Log.e("tag",body);
            try {
                return response.newBuilder().body(ResponseBody.create(mediaType, body)).build();
            }catch (Exception e){
              String  bodyStr =" {\"code\":501,\"msg\":\"解析失败\",\"data\":{}}";
                return response.newBuilder().body(ResponseBody.create(mediaType, bodyStr)).build();
            }
//            return response.newBuilder().body(ResponseBody.create(mediaType, body)).build();
        }

        return response;
    }

}