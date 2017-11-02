package com.swallow.listener;


import com.swallow.api.RefreshLayout;
import com.swallow.constant.RefreshState;

/**
 * 刷新状态改变监听器
 */
public interface OnStateChangedListener {
    /**
     * 状态改变事件 {@link RefreshState}
     * @param refreshLayout RefreshLayout
     * @param oldState 改变之前的状态
     * @param newState 改变之后的状态
     */
    void onStateChanged(RefreshLayout refreshLayout, RefreshState oldState, RefreshState newState);
}
