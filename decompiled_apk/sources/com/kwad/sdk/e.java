package com.kwad.sdk;

/* loaded from: classes11.dex */
public final class e {
    public static final e als = new e(10000, "其他异常");
    public static final e alt = new e(10001, "初始化参数异常");
    public static final e alu = new e(11001, "SDK未调用init方法");
    public int code;
    public String msg;

    public e(int i, String str) {
        this.code = i;
        this.msg = str;
    }
}
