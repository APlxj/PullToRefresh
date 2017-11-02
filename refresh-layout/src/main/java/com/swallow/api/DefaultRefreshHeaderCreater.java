package com.swallow.api;

import android.content.Context;
import android.support.annotation.NonNull;

/**
 * 默认Header创建器
 */
public interface DefaultRefreshHeaderCreater {
    @NonNull
    RefreshHeader createRefreshHeader(Context context, RefreshLayout layout);
}
