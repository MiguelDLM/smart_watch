package com.huawei.hms.ads.consent.bean;

import com.huawei.hms.ads.annotation.AllApi;
import com.huawei.openalliance.ad.annotations.DataKeep;
import com.huawei.openalliance.ad.annotations.a;
import java.util.List;

@DataKeep
/* loaded from: classes10.dex */
public class ConsentSyncReq {

    @a
    private String accessToken;
    private List<String> adProviderIds;
    private int consentStatus;

    @a
    private String deviceId;
    private int deviceIdType;
    private String pkgName;
    private String sdkversion;
    private Long timestamp;

    @AllApi
    public ConsentSyncReq(List<String> list, int i, String str) {
        this.adProviderIds = list;
        this.consentStatus = i;
        this.pkgName = str;
    }

    @AllApi
    public String getAccessToken() {
        return this.accessToken;
    }

    @AllApi
    public List<String> getAdProviderIds() {
        return this.adProviderIds;
    }

    @AllApi
    public int getConsentStatus() {
        return this.consentStatus;
    }

    @AllApi
    public String getDeviceId() {
        return this.deviceId;
    }

    @AllApi
    public int getDeviceIdType() {
        return this.deviceIdType;
    }

    @AllApi
    public String getPkgName() {
        return this.pkgName;
    }

    @AllApi
    public String getSdkversion() {
        return this.sdkversion;
    }

    @AllApi
    public Long getTimestamp() {
        return this.timestamp;
    }

    @AllApi
    public void setAccessToken(String str) {
        this.accessToken = str;
    }

    @AllApi
    public void setAdProviderIds(List<String> list) {
        this.adProviderIds = list;
    }

    @AllApi
    public void setConsentStatus(int i) {
        this.consentStatus = i;
    }

    @AllApi
    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    @AllApi
    public void setDeviceIdType(int i) {
        this.deviceIdType = i;
    }

    @AllApi
    public void setPkgName(String str) {
        this.pkgName = str;
    }

    @AllApi
    public void setSdkversion(String str) {
        this.sdkversion = str;
    }

    @AllApi
    public void setTimestamp(Long l) {
        this.timestamp = l;
    }
}
