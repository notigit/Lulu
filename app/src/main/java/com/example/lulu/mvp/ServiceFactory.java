package com.example.lulu.mvp;


import com.example.lulu.mvp.Service.TiYanService;
import com.example.lulu.utils.RXUtil;

/**
 * 网络接口服务工厂
 */
public final class ServiceFactory {

    private ServiceFactory() {

    }
    private static TiYanService tiYanService;
    public static synchronized TiYanService getTiYanService() {
        if (tiYanService == null) {
            tiYanService = RXUtil.Factory.create(TiYanService.class);
        }
        return tiYanService;
    }
}