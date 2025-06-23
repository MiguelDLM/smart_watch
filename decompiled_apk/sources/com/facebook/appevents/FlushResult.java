package com.facebook.appevents;

import java.util.Arrays;

/* loaded from: classes8.dex */
public enum FlushResult {
    SUCCESS,
    SERVER_ERROR,
    NO_CONNECTIVITY,
    UNKNOWN_ERROR;

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static FlushResult[] valuesCustom() {
        FlushResult[] valuesCustom = values();
        return (FlushResult[]) Arrays.copyOf(valuesCustom, valuesCustom.length);
    }
}
