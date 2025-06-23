package com.androidnetworking.interfaces;

import com.androidnetworking.error.ANError;
import okhttp3.Response;

/* loaded from: classes.dex */
public interface OkHttpResponseListener {
    void onError(ANError aNError);

    void onResponse(Response response);
}
