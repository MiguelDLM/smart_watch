package com.huawei.hms.ads.consent.bean;

import android.text.TextUtils;
import com.huawei.hms.ads.annotation.AllApi;
import com.huawei.openalliance.ad.annotations.DataKeep;

@DataKeep
/* loaded from: classes10.dex */
public class AdProvider {
    private String id = "";
    private String name = "";
    private String serviceArea = "";
    private String privacyPolicyUrl = "";

    @AllApi
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AdProvider adProvider = (AdProvider) obj;
        return this.id.equals(adProvider.id) && this.name.equals(adProvider.name) && this.serviceArea.equals(adProvider.serviceArea) && this.privacyPolicyUrl.equals(adProvider.privacyPolicyUrl);
    }

    @AllApi
    public String getId() {
        return this.id;
    }

    @AllApi
    public String getName() {
        return this.name;
    }

    @AllApi
    public String getPrivacyPolicyUrl() {
        return this.privacyPolicyUrl;
    }

    @AllApi
    public String getServiceArea() {
        return this.serviceArea;
    }

    @AllApi
    public int hashCode() {
        return (((((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + this.serviceArea.hashCode()) * 31) + this.privacyPolicyUrl.hashCode();
    }

    @AllApi
    public void setId(String str) {
        this.id = str;
    }

    @AllApi
    public void setName(String str) {
        this.name = str;
    }

    @AllApi
    public void setPrivacyPolicyUrl(String str) {
        this.privacyPolicyUrl = str;
    }

    @AllApi
    public void setServiceArea(String str) {
        this.serviceArea = str;
    }

    @AllApi
    public boolean valid() {
        return (TextUtils.isEmpty(this.id) || TextUtils.isEmpty(this.name) || TextUtils.isEmpty(this.privacyPolicyUrl)) ? false : true;
    }

    @AllApi
    public boolean validPart() {
        return (TextUtils.isEmpty(this.id) || TextUtils.isEmpty(this.name)) ? false : true;
    }
}
