package com.alibaba.sdk.android.oss.common;

/* loaded from: classes.dex */
public enum HttpProtocol {
    HTTP("http"),
    HTTPS("https");

    private final String httpProtocol;

    HttpProtocol(String str) {
        this.httpProtocol = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.httpProtocol;
    }
}
