package com.androidnetworking.interfaces;

import com.androidnetworking.error.ANError;
import org.json.JSONArray;

/* loaded from: classes.dex */
public interface JSONArrayRequestListener {
    void onError(ANError aNError);

    void onResponse(JSONArray jSONArray);
}
