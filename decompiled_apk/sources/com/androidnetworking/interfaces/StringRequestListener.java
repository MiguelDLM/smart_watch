package com.androidnetworking.interfaces;

import com.androidnetworking.error.ANError;

/* loaded from: classes.dex */
public interface StringRequestListener {
    void onError(ANError aNError);

    void onResponse(String str);
}
