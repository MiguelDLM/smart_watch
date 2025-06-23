package com.facebook;

import java.util.Arrays;

/* loaded from: classes8.dex */
public enum HttpMethod {
    GET,
    POST,
    DELETE;

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static HttpMethod[] valuesCustom() {
        HttpMethod[] valuesCustom = values();
        return (HttpMethod[]) Arrays.copyOf(valuesCustom, valuesCustom.length);
    }
}
