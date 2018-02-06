package com.example.lulu.mvp;


import com.example.lulu.mvp.Service.ChannelService;
import com.example.lulu.utils.RXUtil;

/**
 * 网络接口服务工厂
 */
public final class ServiceFactory {

    private ServiceFactory() {

    }

    private static ChannelService channelService;

    public static synchronized ChannelService getChannelService() {
        if (channelService == null) {
            channelService = RXUtil.Factory.create(ChannelService.class);
        }
        return channelService;
    }
}