package com.bytedance.android.live.base.api.callback;

/* loaded from: classes8.dex */
public interface CommonCallback<T, D> {
    void onFail(D d);

    void onSuccess(T t);
}
