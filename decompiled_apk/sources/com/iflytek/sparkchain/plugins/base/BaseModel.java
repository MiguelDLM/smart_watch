package com.iflytek.sparkchain.plugins.base;

import com.google.gson.Gson;

/* loaded from: classes10.dex */
public abstract class BaseModel {
    public String toJsonString() {
        return new Gson().toJson(this);
    }

    public String toString() {
        return toJsonString();
    }
}
