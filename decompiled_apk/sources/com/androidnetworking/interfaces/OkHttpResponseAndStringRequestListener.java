package com.androidnetworking.interfaces;

import com.androidnetworking.error.ANError;
import okhttp3.Response;

/* loaded from: classes.dex */
public interface OkHttpResponseAndStringRequestListener {
    void onError(ANError aNError);

    void onResponse(Response response, String str);
}
