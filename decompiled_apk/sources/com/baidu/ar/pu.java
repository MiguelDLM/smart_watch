package com.baidu.ar;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.methods.HttpTrace;

/* loaded from: classes7.dex */
public enum pu {
    ERROR(40, com.baidu.mobads.sdk.internal.cb.l),
    WARN(30, "WARN"),
    INFO(20, "INFO"),
    DEBUG(10, "DEBUG"),
    TRACE(0, HttpTrace.METHOD_NAME);

    private int Kh;
    private String Ki;

    pu(int i, String str) {
        this.Kh = i;
        this.Ki = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.Ki;
    }
}
