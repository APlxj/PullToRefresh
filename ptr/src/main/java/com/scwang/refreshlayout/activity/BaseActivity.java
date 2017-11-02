package com.scwang.refreshlayout.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import com.swallow.listener.IRefresh;


/**
 * 类描述：
 * 创建人：swallow.li
 * 创建时间：
 * Email: swallow.li@kemai.cn
 * 修改备注：
 */
public class BaseActivity extends AppCompatActivity implements IRefresh {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void pullOnLoad(int i) {

    }

    @Override
    public void release(int i) {

    }

    @Override
    public void loading(int i) {

    }

    @Override
    public void loadFialed(int i) {

    }

    @Override
    public void loadSucceed(int i) {

    }
}
