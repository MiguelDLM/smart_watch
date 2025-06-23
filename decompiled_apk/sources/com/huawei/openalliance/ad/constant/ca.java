package com.huawei.openalliance.ad.constant;

import com.baidu.navisdk.ui.widget.BNWebViewClient;

@com.huawei.openalliance.ad.annotations.b
/* loaded from: classes10.dex */
public enum ca {
    HTTP(BNWebViewClient.URL_HTTP_PREFIX),
    HTTPS(BNWebViewClient.URL_HTTPS_PREFIX),
    FILE("file://"),
    CONTENT("content://"),
    ASSET("asset://"),
    RES("res://");

    String S;

    ca(String str) {
        this.S = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.S;
    }
}
