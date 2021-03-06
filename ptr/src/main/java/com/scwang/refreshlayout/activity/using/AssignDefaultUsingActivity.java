package com.scwang.refreshlayout.activity.using;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.scwang.refreshlayout.R;
import com.swallow.SmartRefreshLayout;
import com.swallow.api.DefaultRefreshFooterCreater;
import com.swallow.api.DefaultRefreshHeaderCreater;
import com.swallow.api.RefreshFooter;
import com.swallow.api.RefreshHeader;
import com.swallow.api.RefreshLayout;
import com.swallow.constant.RefreshState;
import com.swallow.constant.SpinnerStyle;
import com.swallow.footer.ClassicsFooter;
import com.swallow.header.ClassicsHeader;
import com.swallow.listener.SimpleMultiPurposeListener;

/**
 * 全局指定默认的Header和Footer
 */
public class AssignDefaultUsingActivity extends AppCompatActivity {

    private static boolean isFirstEnter = true;

    /*
     * 关键代码，需要在布局生成之前设置，建议代码放在 Application 中
     */
    static {
        //设置全局的Header构建器
        SmartRefreshLayout.setDefaultRefreshHeaderCreater(new DefaultRefreshHeaderCreater() {
            @NonNull
            @Override
            public RefreshHeader createRefreshHeader(Context context, RefreshLayout layout) {
                ClassicsHeader header = new ClassicsHeader(context).setSpinnerStyle(SpinnerStyle.FixedBehind);
                header.setPrimaryColors(ContextCompat.getColor(context, R.color.colorPrimary), ContextCompat.getColor(context, android.R.color.white));
                return header;//指定为经典Header，默认是 贝塞尔雷达Header
            }
        });
        //设置全局的Footer构建器
        SmartRefreshLayout.setDefaultRefreshFooterCreater(new DefaultRefreshFooterCreater() {
            @NonNull
            @Override
            public RefreshFooter createRefreshFooter(Context context, RefreshLayout layout) {
                layout.setEnableLoadmoreWhenContentNotFull(true);
                ClassicsFooter footer = new ClassicsFooter(context);
                footer.setBackgroundResource(android.R.color.white);
                footer.setSpinnerStyle(SpinnerStyle.Scale);//设置为拉伸模式
                return footer;//指定为经典Footer，默认是 BallPulseFooter
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_using_assign_default);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        /**
         * 以下代码仅仅为了演示效果而已，不是必须的
         * 关键代码在构造函数中
         */
        final RefreshLayout refreshLayout = (RefreshLayout) findViewById(R.id.refreshLayout);
        if (isFirstEnter) {
            isFirstEnter = false;
            //触发上啦加载
            refreshLayout.autoLoadmore();
            //通过多功能监听接口实现 在第一次加载完成之后 自动刷新
            refreshLayout.setOnMultiPurposeListener(new SimpleMultiPurposeListener() {
                @Override
                public void onStateChanged(RefreshLayout refreshLayout, RefreshState oldState, RefreshState newState) {
                    if (oldState == RefreshState.LoadFinish
                            && newState == RefreshState.None) {
                        refreshLayout.autoRefresh();
                        refreshLayout.setOnMultiPurposeListener(null);
                    }
                }
            });
        }
    }

}
