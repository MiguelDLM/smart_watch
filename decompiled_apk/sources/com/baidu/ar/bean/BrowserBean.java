package com.baidu.ar.bean;

/* loaded from: classes7.dex */
public class BrowserBean {
    public static final String TYPE = "type";
    public static final String URL = "url";
    private int browserType;
    private String browserUrl;

    /* loaded from: classes7.dex */
    public enum OPENTYPE {
        DEFAULT_TYPE,
        SHOUBAI_O2O_TYPE,
        INTERNAL_TYPE
    }

    public int getBrowserType() {
        return this.browserType;
    }

    public String getBrowserUrl() {
        return this.browserUrl;
    }

    public void setBrowserType(int i) {
        this.browserType = i;
    }

    public void setBrowserUrl(String str) {
        this.browserUrl = str;
    }
}
