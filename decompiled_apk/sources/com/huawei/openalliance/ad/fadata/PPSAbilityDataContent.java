package com.huawei.openalliance.ad.fadata;

import com.huawei.openalliance.ad.annotations.DataKeep;

@DataKeep
/* loaded from: classes10.dex */
public class PPSAbilityDataContent {
    private String abilityId;
    private String abilityName;
    private String appName;
    private String brief;
    private String faParams;
    private String logoUrl;
    private String moduleName;
    private String packageName;
    private String serviceName;

    public String B() {
        return this.moduleName;
    }

    public String Code() {
        return this.faParams;
    }

    public String I() {
        return this.packageName;
    }

    public String V() {
        return this.abilityName;
    }

    public String Z() {
        return this.serviceName;
    }

    public void Code(String str) {
        this.faParams = str;
    }

    public void V(String str) {
        this.abilityName = str;
    }
}
