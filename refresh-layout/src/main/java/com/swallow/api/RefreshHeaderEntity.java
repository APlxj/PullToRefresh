package com.swallow.api;

import android.content.Context;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import com.swallow.constant.RefreshState;
import com.swallow.constant.SpinnerStyle;

/**
 * 类描述：
 * 创建人：swallow.li
 * 创建时间：
 * Email: swallow.li@kemai.cn
 * 修改备注：
 */
public abstract class RefreshHeaderEntity extends LinearLayout implements RefreshHeader {

    public static final int TIME = 1000;

    public RefreshHeaderEntity(Context context) {
        super(context);
        initView(context);
    }

    public RefreshHeaderEntity(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public RefreshHeaderEntity(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    public abstract void initView(Context context);

    @Override
    public void onPullingDown(float percent, int offset, int headerHeight, int extendHeight) {

    }

    @Override
    public void onReleasing(float percent, int offset, int headerHeight, int extendHeight) {

    }

    @Override
    public void onRefreshReleased(RefreshLayout layout, int headerHeight, int extendHeight) {

    }

    @NonNull
    @Override
    public abstract View getView();

    @Override
    public abstract SpinnerStyle getSpinnerStyle();

    @Override
    public void setPrimaryColors(@ColorInt int... colors) {

    }

    @Override
    public void onInitialized(RefreshKernel kernel, int height, int extendHeight) {

    }

    @Override
    public void onHorizontalDrag(float percentX, int offsetX, int offsetMax) {

    }

    @Override
    public abstract void onStartAnimator(RefreshLayout layout, int height, int extendHeight);

    @Override
    public abstract int onFinish(RefreshLayout layout, boolean success);

    @Override
    public boolean isSupportHorizontalDrag() {
        return false;
    }

    @Override
    public abstract void onStateChanged(RefreshLayout refreshLayout, RefreshState oldState, RefreshState newState);
}
