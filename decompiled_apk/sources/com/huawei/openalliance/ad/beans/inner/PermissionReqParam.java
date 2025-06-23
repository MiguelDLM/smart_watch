package com.huawei.openalliance.ad.beans.inner;

import com.huawei.openalliance.ad.annotations.DataKeep;

@DataKeep
/* loaded from: classes10.dex */
public class PermissionReqParam {
    private String appCountry;
    private String appLanguage;
    private String packageName;

    public PermissionReqParam() {
    }

    public String Code() {
        return this.packageName;
    }

    public String I() {
        return this.appCountry;
    }

    public String V() {
        return this.appLanguage;
    }

    public PermissionReqParam(String str, String str2, String str3) {
        this.packageName = str;
        this.appLanguage = str2;
        this.appCountry = str3;
    }

    public void Code(String str) {
        this.packageName = str;
    }

    public void I(String str) {
        this.appCountry = str;
    }

    public void V(String str) {
        this.appLanguage = str;
    }
}
