//package com.example.lulu.utils;
//
//import com.tencent.mm.sdk.modelmsg.SendAuth;
//import com.tencent.mm.sdk.modelpay.PayReq;
//import com.tencent.mm.sdk.openapi.IWXAPI;
//import com.tgf.kcwc.common.Constants;
//
//public class PayUtil {
//
//    /**
//     * 微信支付
//     *
//     * @param wxapi
//     * @param appId
//     * @param partnerId
//     * @param prepayId
//     * @param packageValue
//     * @param nonceStr
//     * @param timeStamp
//     * @param sign
//     */
//    public static void weixinPay(IWXAPI wxapi, String appId, String partnerId, String prepayId,
//                                 String packageValue, String nonceStr, String timeStamp,
//                                 String sign) {
//
//        PayReq request = new PayReq();
//        request.appId = appId;
//        request.partnerId = partnerId;
//        request.prepayId = prepayId;
//        request.packageValue = packageValue;
//        request.nonceStr = nonceStr;
//        request.timeStamp = timeStamp;
//        request.sign = sign;
//        wxapi.sendReq(request);
//    }
//
//    /**
//     * @param wxapi
//     * @param appId
//     * @param partnerId
//     * @param prepayId
//     * @param packageValue
//     * @param nonceStr
//     * @param timeStamp
//     * @param sign
//     * @param type         1：代金券 3:参展申请 4:个人积分 5: 充值
//     */
//    public static void weixinPay(IWXAPI wxapi, String appId, String partnerId, String prepayId,
//                                 String packageValue, String nonceStr, String timeStamp,
//                                 String sign, String type) {
//
//        PayReq request = new PayReq();
//        request.appId = appId;
//        request.partnerId = partnerId;
//        request.prepayId = prepayId;
//        request.packageValue = packageValue;
//        request.nonceStr = nonceStr;
//        request.timeStamp = timeStamp;
//        request.sign = sign;
//        request.extData = type;
//        wxapi.sendReq(request);
//    }
//
//    public static void sendAuth(IWXAPI iwxapi) {
//
//        final SendAuth.Req req = new SendAuth.Req();
//        req.scope = "snsapi_userinfo";
//        req.state = Constants.WX_CASH_STATE;
//        iwxapi.sendReq(req);
//    }
//}
