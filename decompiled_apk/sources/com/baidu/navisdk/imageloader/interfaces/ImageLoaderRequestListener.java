package com.baidu.navisdk.imageloader.interfaces;

/* loaded from: classes7.dex */
public interface ImageLoaderRequestListener<T> {
    void onFail(Throwable th, Object obj);

    void onSuccess(T t, Object obj);
}
