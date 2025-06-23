package com.baidu.ar.baidumap;

/* loaded from: classes7.dex */
public enum BusinessSoType {
    engine("main"),
    eglCore("egl_core"),
    localRecognize("local_recognize"),
    cloudRecognize("cloud_recognize");

    private final String lu;

    BusinessSoType(String str) {
        this.lu = str;
    }

    public String getBusiness() {
        String str = this.lu;
        return str == null ? "" : str;
    }
}
