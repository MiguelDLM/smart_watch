package com.androidnetworking.interfaces;

import com.androidnetworking.error.ANError;
import org.json.JSONObject;

/* loaded from: classes.dex */
public interface JSONObjectRequestListener {
    void onError(ANError aNError);

    void onResponse(JSONObject jSONObject);
}
