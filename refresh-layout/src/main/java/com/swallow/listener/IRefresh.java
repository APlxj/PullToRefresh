package com.swallow.listener;

/**
 * 类描述：
 * 创建人：swallow.li
 * 创建时间：
 * Email: swallow.li@kemai.cn
 * 修改备注：
 */
public interface IRefresh {
    /**
     * 上拉时调用
     */
    void pullOnLoad(int i);

    /**
     * 释放
     */
    void release(int i);

    /**
     * 加载过程
     */
    void loading(int i);

    /**
     * 加载失败
     */
    void loadFialed(int i);

    /**
     * 加载成功、完成
     */
    void loadSucceed(int i);
}
