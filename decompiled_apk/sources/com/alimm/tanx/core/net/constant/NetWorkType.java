package com.alimm.tanx.core.net.constant;

/* loaded from: classes.dex */
public enum NetWorkType {
    NETWORK_NO(-1, "NET_NONE"),
    NETWORK_UNKNOWN(0, "NET_UNKNOWN"),
    NETWORK_2G(2, "2G"),
    NETWORK_3G(3, "3G"),
    NETWORK_4G(4, "4G"),
    NETWORK_WIFI(1, "WIFI");

    private final int key;
    private final String msg;

    NetWorkType(int i, String str) {
        this.key = i;
        this.msg = str;
    }

    public int getKey() {
        return this.key;
    }

    public String getMsg() {
        return this.msg;
    }
}
