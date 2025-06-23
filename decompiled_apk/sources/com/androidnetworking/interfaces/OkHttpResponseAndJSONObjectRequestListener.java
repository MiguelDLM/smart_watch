package com.androidnetworking.interfaces;

import com.androidnetworking.error.ANError;
import okhttp3.Response;
import org.json.JSONObject;

/* loaded from: classes.dex */
public interface OkHttpResponseAndJSONObjectRequestListener {
    void onError(ANError aNError);

    void onResponse(Response response, JSONObject jSONObject);
}
