package com.huawei.hms.ads;

/* loaded from: classes10.dex */
public enum jk {
    BACK("back"),
    FORWARD("forward"),
    SAVE_PAGE("savePage"),
    REFRESH("refresh"),
    ADD_TO("addTo"),
    FIND_IN_PAGE("findInPage"),
    TRANSLATE("translate"),
    OPEN_IN_BROWSER("openInBrowser"),
    NONE("none");

    private String L;

    jk(String str) {
        this.L = str;
    }

    public String Code() {
        return this.L;
    }
}
