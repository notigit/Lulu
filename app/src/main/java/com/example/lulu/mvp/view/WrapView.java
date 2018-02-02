package com.example.lulu.mvp.view;

/**
 * Author：Jenny
 * Date:2016/12/13 09:36
 * E-mail：fishloveqin@gmail.com
 * 对MVP 模式的View层进行包装，主要是全局的参数配置
 */

public interface WrapView extends  BaseView {
    /**
     * 请求数据时调用
     * @param active  true  为显示， false为不显示
     */
    void setLoadingIndicator(boolean active);

    /**
     * 请求数据失败异常时调用
     */
    void showLoadingTasksError();
}
