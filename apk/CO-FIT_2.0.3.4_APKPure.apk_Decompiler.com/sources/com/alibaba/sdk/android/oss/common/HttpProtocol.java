package com.alibaba.sdk.android.oss.common;

public enum HttpProtocol {
    HTTP("http"),
    HTTPS("https");
    
    private final String httpProtocol;

    private HttpProtocol(String str) {
        this.httpProtocol = str;
    }

    public String toString() {
        return this.httpProtocol;
    }
}
