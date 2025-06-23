package com.androidnetworking.interfaces;

import com.androidnetworking.error.ANError;

/* loaded from: classes.dex */
public interface ParsedRequestListener<T> {
    void onError(ANError aNError);

    void onResponse(T t);
}
