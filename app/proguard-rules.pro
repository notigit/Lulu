# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in D:\DevEnv\android-sdk-windows/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

-ignorewarnings
-optimizationpasses 9
-dontusemixedcaseclassnames
-dontskipnonpubliclibraryclasses
-dontpreverify
-verbose
-optimizations !code/simplification/arithmetic,!field/*,!class/merging/*

-dontwarn android.support.**
-dontwarn android.os.**
-keep class android.os.**{*;}
-keep class android.support.**{ *; }
-keep interface android.support.**{ *; }
-keep class sun.misc.Unsafe { *; }
-keep class com.fasterxml.jackson.**{ *; }
-keepnames class com.fasterxml.jackson.**{ *; }
-keep interface com.fasterxml.jackson.**{ *; }

-keep public class * extends android.support.**
-keep public class * extends android.app.*
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider
-keep public class * extends android.view.View

-dontwarn cn.jpush.**
-keep class cn.jpush.** { *; }
-dontwarn com.google.**
-keep class com.google.gson.** {*;}

-keepattributes Signature
-keepattributes *Annotation*, EnclosingMethod
-keep public class com.tgf.kcwc.entity.NodeEntity
-keep public class com.tgf.exhibition.http.json.** {
   public <fields>;
   public void set*(***);
   public *** get*();
 }
# -keep public class com.tgf.exhibition.http.msg.** {
   #   public <fields>;
   #   public void set*(***);
   #   public *** get*();
   # }

-keepclasseswithmembers class * {
    public <init>(android.content.Context);
}
-keepclasseswithmembernames class * {
    native <methods>;
}

-keepclasseswithmembers class * {
    public <init>(android.content.Context, android.util.AttributeSet);
}

-keepclasseswithmembers class * {
    public <init>(android.content.Context, android.util.AttributeSet, int);
}

-keepclassmembers class * extends android.app.Activity {
   public void *(android.view.View);
}

-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

-keep class * implements android.os.Parcelable {
  public static final android.os.Parcelable$Creator *;
}
# keep rx
-keep class rx.**{*;}
-keep class android.net**{*;}
-dontwarn rx.**
-dontwarn android.net**
 #保持 Serializable 不被混淆
 -keepnames class * implements java.io.Serializable{}
 -keepattributes Signature
 -keep  class com.tgf.kcwc.mvp.**{*;}
 -keep class  com.tgf.kcwc.entity.**{*;}
 -keep class  com.tgf.kcwc.view.richeditor.**{*;}
 #greenDao混淆
-keep class de.greenrobot.dao.** {*;}
-keepclassmembers class * extends de.greenrobot.dao.AbstractDao {
    public static java.lang.String TABLENAME;
}
#===============okio==============
-dontwarn okio.**
-dontwarn com.squareup.okhttp.**
-dontwarn retrofit2.Platform$Java8
#======facebook=====
-keep class com.facebook.**{*;}
-keep interface com.facebook.** {*;}
-keep enum com.facebook.** {*;}
-dontwarn com.facebook.**
#=======squareup======
-keep class com.squareup.**{*;}
-dontwarn com.squareup.**


# 极光推送
-dontoptimize
-dontpreverify
-dontwarn cn.jpush.**
-keep class cn.jpush.** { *; }


# 微信支付
-dontwarn com.tencent.mm.**
-dontwarn com.tencent.wxop.stat.**
-keep class com.tencent.mm.** {*;}
-keep class com.tencent.wxop.stat.**{*;}

-keep public class com.tgf.kcwc.util.GlideConfiguration
-keep class cn.pedant.SweetAlert.** {*;}

# 新浪微博
-keep class com.sina.weibo.sdk.* { *; }
-keep class android.support.v4.* { *; }
-keep class com.tencent.* { *; }
-keep class com.baidu.* { *; }
-keep class lombok.ast.ecj.* { *; }
-dontwarn android.support.v4.**
-dontwarn com.tencent.**s
-dontwarn com.baidu.**


#============高德地图===============
-dontwarn com.amap.api.**
-dontwarn com.autonavi.**
-keep class com.amap.api.**{*;}
-keep class com.autonavi.**{*;}
# 地图服务
-dontwarn com.amap.api.services.**
-keep class com.map.api.services.** {*;}
# 3D地图
-dontwarn com.amap.api.mapcore.**
-dontwarn com.amap.api.maps.**
-dontwarn com.autonavi.amap.mapcore.**
-keep class com.amap.api.mapcore.**{*;}
-keep class com.amap.api.maps.**{*;}
-keep class com.autonavi.amap.mapcore.**{*;}

# 定制选择器
-keep class cn.qqtheme.framework.entity.**{*;}


# 二维码扫描
-keep class me.dm7.**{*;}
-keep class com.google.zxing.** {*;}
-keep class me.dm7.barcodescanner.core.**{*;}
-keep class me.dm7.barcodescanner.zbar.**{*;}
-keep class me.dm7.barcodescanner.zxing.**{*;}
-keep class net.sourceforge.zbar.**{*;}
-dontwarn com.google.zxing.**

# 定位
-dontwarn com.amap.api.location.**
-dontwarn com.aps.**
-keep class com.amap.api.location.**{*;}
-keep class com.aps.**{*;}
# 导航
-dontwarn com.amap.api.navi.**
-dontwarn com.autonavi.**
-keep class com.amap.api.navi.** {*;}
-keep class com.autonavi.** {*;}


  #=============环信混淆=====
-keep class  com.hianalytics.android.** {*;}
-keep class  com.huawei.hms.** {*;}
-keep class  com.xiaomi.** {*;}
-keep class com.hyphenate.** {*;}
-keep class com.superrtc.** {*;}
-keep class com.hyphenate.chat.** {*;}
-keep class org.jivesoftware.** {*;}
-keep class org.apache.** {*;}
-dontwarn  com.hyphenate.**
-keepclasseswithmembers class * extends EaseChatRow{
    <fields>;
    <methods>;
}
#=============== 有盟SDK ====================
-keepclassmembers class * {
   public <init> (org.json.JSONObject);
}
-keep public class com.tgf.kcwc.R$*{
public static final int *;
}



#=================支付宝================

-keep class com.alipay.android.app.IAlixPay{*;}
-keep class com.alipay.android.app.IAlixPay$Stub{*;}
-keep class com.alipay.android.app.IRemoteServiceCallback{*;}
-keep class com.alipay.android.app.IRemoteServiceCallback$Stub{*;}
-keep class com.alipay.sdk.app.PayTask{ public *;}
-keep class com.alipay.sdk.app.AuthTask{ public *;}
-keep class com.alipay.sdk.app.H5PayCallback {
    <fields>;
    <methods>;
}
-keep class com.alipay.android.phone.mrpc.core.** { *; }
-keep class com.alipay.apmobilesecuritysdk.** { *; }
-keep class com.alipay.mobile.framework.service.annotation.** { *; }
-keep class com.alipay.mobilesecuritysdk.face.** { *; }
-keep class com.alipay.tscenter.biz.rpc.** { *; }
-keep class org.json.alipay.** { *; }
-keep class com.alipay.tscenter.** { *; }
-keep class com.ta.utdid2.** { *;}
-keep class com.ut.device.** { *;}






-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

-keep class **$Properties
   #记录生成的日志数据,gradle build时在本项目根目录输出
   # apk 包内所有 class 的内部结构
   -dump class_files.txt
   # 未混淆的类和成员
   -printseeds seeds.txt
   # 列出从 apk 中删除的代码
   -printusage unused.txt
   # 混淆前后的映射
   -printmapping mapping.txt