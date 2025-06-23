package com.baidu.mobads.sdk.internal;

import android.content.Context;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.mobads.sdk.api.IPromoteInstallAdInfo;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class ap implements IPromoteInstallAdInfo {

    /* renamed from: a, reason: collision with root package name */
    private final aq f6229a;
    private final Context b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;

    public ap(JSONObject jSONObject, Context context, aq aqVar) {
        this.f6229a = aqVar;
        this.b = context;
        try {
            this.c = jSONObject.optString("pk");
            this.d = jSONObject.optString(com.huawei.openalliance.ad.constant.x.cD);
            this.e = jSONObject.optString("appname");
            this.f = jSONObject.optString("bidlayer");
            this.g = jSONObject.optString("publisher");
            this.h = jSONObject.optString(HttpConstants.APP_VERSION);
            this.i = jSONObject.optString("privacy_link");
            this.j = jSONObject.optString("permission_link");
            this.k = jSONObject.optString("function_link");
        } catch (Throwable unused) {
        }
    }

    @Override // com.baidu.mobads.sdk.api.IPromoteInstallAdInfo
    public String getAppPublisher() {
        return this.g;
    }

    @Override // com.baidu.mobads.sdk.api.IPromoteInstallAdInfo
    public String getAppVersion() {
        return this.h;
    }

    @Override // com.baidu.mobads.sdk.api.IPromoteInstallAdInfo
    public String getBrandName() {
        return this.e;
    }

    @Override // com.baidu.mobads.sdk.api.IPromoteInstallAdInfo
    public String getECPMLevel() {
        return this.f;
    }

    @Override // com.baidu.mobads.sdk.api.IPromoteInstallAdInfo
    public String getFunctionUrl() {
        return this.k;
    }

    @Override // com.baidu.mobads.sdk.api.IPromoteInstallAdInfo
    public String getIconUrl() {
        return this.d;
    }

    @Override // com.baidu.mobads.sdk.api.IPromoteInstallAdInfo
    public String getPermissionUrl() {
        return this.j;
    }

    @Override // com.baidu.mobads.sdk.api.IPromoteInstallAdInfo
    public String getPrivacyUrl() {
        return this.i;
    }

    @Override // com.baidu.mobads.sdk.api.IPromoteInstallAdInfo
    public String getUnionLogoUrl() {
        return "http://union.baidu.com";
    }

    @Override // com.baidu.mobads.sdk.api.IPromoteInstallAdInfo
    public void handleAdInstall() {
        aq aqVar = this.f6229a;
        if (aqVar != null) {
            aqVar.a(this.b, this.c);
        }
    }
}
