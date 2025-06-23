package com.huawei.hms.ads.consent.bean.network;

import com.huawei.hms.ads.annotation.AllApi;
import com.huawei.openalliance.ad.annotations.DataKeep;

@DataKeep
/* loaded from: classes10.dex */
public class ConsentConfigReq {
    private String consentVersion;
    private String countryCode;
    private Integer debugFlag;
    private String langCode;
    private String pkgName;

    @AllApi
    public String getConsentVersion() {
        return this.consentVersion;
    }

    @AllApi
    public String getCountryCode() {
        return this.countryCode;
    }

    @AllApi
    public Integer getDebugFlag() {
        return this.debugFlag;
    }

    @AllApi
    public String getLangCode() {
        return this.langCode;
    }

    @AllApi
    public String getPkgName() {
        return this.pkgName;
    }

    @AllApi
    public void setConsentVersion(String str) {
        this.consentVersion = str;
    }

    @AllApi
    public void setCountryCode(String str) {
        this.countryCode = str;
    }

    @AllApi
    public void setDebugFlag(Integer num) {
        this.debugFlag = num;
    }

    @AllApi
    public void setLangCode(String str) {
        this.langCode = str;
    }

    @AllApi
    public void setPkgName(String str) {
        this.pkgName = str;
    }
}
