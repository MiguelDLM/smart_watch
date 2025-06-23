package com.baidu.mobads.sdk.api;

/* loaded from: classes7.dex */
public enum CpuLpFontSize {
    SMALL("sml"),
    REGULAR("reg"),
    LARGE("lrg"),
    EXTRA_LARGE("xlg"),
    XX_LARGE("xxl");

    String mValue;

    CpuLpFontSize(String str) {
        this.mValue = str;
    }

    public String getValue() {
        return this.mValue;
    }
}
