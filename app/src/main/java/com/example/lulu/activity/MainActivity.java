package com.example.lulu.activity;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.lulu.Constant;
import com.example.lulu.R;
import com.example.lulu.fragment.MyFragment;
import com.example.lulu.fragment.SortFragment;
import com.example.lulu.fragment.TiYanFragment;
import com.example.lulu.fragment.VipFragment;
import com.example.lulu.fragment.YiRenFragment;
import com.example.lulu.okhttp.PayModel;
import com.example.lulu.okhttp.PayModelCallBack;
import com.example.lulu.utils.ChannelUtils;
import com.example.lulu.utils.MD5Util;
import com.squareup.okhttp.Request;
import com.zhy.http.okhttp.OkHttpUtils;

import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class MainActivity extends AppCompatActivity {
    //    TextView titleTv;
    FrameLayout frameLayout;
    RadioGroup radioGroup;
    RadioButton tiYanRb, vipRb, sortRb, yiRenRb, myRb;
    private TiYanFragment tiYanFragment;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        titleTv = findViewById(R.id.titleTv);
        frameLayout = findViewById(R.id.frameLayout);
        radioGroup = findViewById(R.id.radioGroup);
        tiYanRb = findViewById(R.id.tiYanRb);
        vipRb = findViewById(R.id.vipRb);
        sortRb = findViewById(R.id.sortRb);
        yiRenRb = findViewById(R.id.yiRenRb);
        myRb = findViewById(R.id.myRb);
        tiYanFragment = new TiYanFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.frameLayout, tiYanFragment).commit();
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.tiYanRb:
//                        titleTv.setText("体验区");
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, tiYanFragment).commit();
                        break;
                    case R.id.vipRb:
//                        titleTv.setText("会员区");
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new VipFragment()).commit();
                        break;
                    case R.id.sortRb:
//                        titleTv.setText("分类");
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new SortFragment()).commit();
                        break;
                    case R.id.yiRenRb:
//                        titleTv.setText("艺人");
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new YiRenFragment()).commit();
                        break;
                    case R.id.myRb:
//                        titleTv.setText("我的");
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new MyFragment()).commit();
                        break;
                }
            }
        });
//        OkHttpUtils
//                .get()
//                .url(Constant.API_BASE_URL+"message/message_consumer/user/")
//                .addParams("token", "DwJMdPwkbpBaGBlURqc1U1D1EklmmLxX")
//                .addParams("thread_id", "6862")
//                .build()
//                .execute(new TiYanModelCallBack() {
//                    @Override
//                    public void onError(Request request, Exception e) {
//                        Log.e("TAG", "onError: " );
//                    }
//
//                    @Override
//                    public void onResponse(TiYanModel response) {
//                        Log.e("TAG", "onResponse: "+response.getCode());
//                    }
//                });
//
//        OkHttpUtils
//                .post()
//                .url(Constant.API_BASE_URL+"friend/group/create/")
//                .addParams("token", "DwJMdPwkbpBaGBlURqc1U1D1EklmmLxX")
//                .addParams("name", "6862")
//                .build()
//                .execute(new OneModelCallBack() {
//                    @Override
//                    public void onError(Request request, Exception e) {
//                        Log.e("TAG", "onError1: " );
//                    }
//
//                    @Override
//                    public void onResponse(OneModel response) {
//                        Log.e("TAG", "onResponse1: "+response.getCode());
//                    }
//                });

        //获取支付网关
//        OkHttpUtils
//                .post()
//                .url(Constant.PAY_ADDRESS)
//                .addParams("account", Constant.ACCOUNT)
//                .addParams("key", Constant.KEY)
//                .build()
//                .execute(new NetModelCallBack() {
//                    @Override
//                    public void onError(Request request, Exception e) {
//                        Log.e("TAG", "onError1: ");
//                    }
//
//                    @Override
//                    public void onResponse(NetModel response) {
//                        Log.e("TAG", "onResponse: " + response.getUrl());
//                        Log.e("TAG", "onResponse: " + response.getMsg());
//                    }
//                });
        String channel = ChannelUtils.getAppMetaData(this,"UMENG_CHANNEL");
        Log.e("TAG", "onCreate: "+channel );
        //时间戳
        long timeStamp = System.currentTimeMillis();
//        1100到9900随机数
        int randomNum = new Random().nextInt(8800) + 1100;
        //订单号
        String orderNum = channel + "_" + timeStamp + "_" + randomNum;
        //支付类型 1:[wxwap]微信WAP 2:[wxsm]微信扫码 3:[wxgzh]微信公众号 4:[zfbwap]支付宝WAP 5:[zfbsm]支付宝扫码
        String payType = "wxwap";
        //金额
        String payPrice = "0.01";
        //商品描述
        String goodsDescribe = "vip";
        //透传参数
        String ext = channel + "|" + orderNum;

//        account={value}&callback={value}&money={value}&notify={value}&order={value}&paytype={value}&{商户key}
        // 把参数的值传进去SortedMap集合里面
        SortedMap<Object, Object> parameters = new TreeMap<Object, Object>();
        parameters.put("account", Constant.ACCOUNT);
        parameters.put("callback","https://www.sogou.com/" );
        parameters.put("money",payPrice);
        parameters.put("notify","https://www.baidu.com/" );
        parameters.put("order", orderNum);
        parameters.put("paytype",payType );
        Log.e("TAG", "onCreate: "+parameters.toString() );
        String characterEncoding = "UTF-8";
        //签名算法
        String mySign = createSign(characterEncoding, parameters);
        Log.e("tag","我的签名是：" + mySign);

        //请求支付
        OkHttpUtils
                .post()
                .url(Constant.POST_PAY)
                .addParams("account", Constant.ACCOUNT)
                .addParams("order",orderNum)
                .addParams("paytype",payType )
                .addParams("type", "")
                .addParams("money",payPrice)
                .addParams("body",goodsDescribe)
                .addParams("ext",ext)
                .addParams("notify","https://www.baidu.com/")
                .addParams("callback","https://www.sogou.com/" )
                .addParams("ip","" )
                .addParams("sign",mySign )
                .build()
                .execute(new PayModelCallBack() {
                    @Override
                    public void onError(Request request, Exception e) {
                        Log.e("TAG", "onError1: ");
                    }

                    @Override
                    public void onResponse(PayModel response) {
                        String payStr = response.getPayurl();
                        Log.e("TAG", "onResponse: " + payStr);
                        Log.e("TAG", "onResponse: " + response.getMsg());
                    }
                });

    }

    /**
     * 微信支付签名算法sign
     *
     * @param characterEncoding
     * @param parameters
     * @return
     */
    public static String createSign(String characterEncoding,
                                    SortedMap<Object, Object> parameters) {
        StringBuffer sb = new StringBuffer();
        Set es = parameters.entrySet();// 所有参与传参的参数按照accsii排序（升序）
        Iterator it = es.iterator();
        while (it.hasNext()) {
            @SuppressWarnings("rawtypes")
            Map.Entry entry = (Map.Entry) it.next();
            String k = (String) entry.getKey();
            Object v = entry.getValue();
            if (null != v && !"".equals(v) && !"sign".equals(k)
                    && !"key".equals(k)) {
                sb.append(k + "=" + v + "&");
            }
        }
        sb.append("key=" + Constant.KEY); //KEY是商户秘钥
        String sign = MD5Util.MD5Encode(sb.toString(), characterEncoding)
                .toUpperCase();
        return sign;
    }
}
