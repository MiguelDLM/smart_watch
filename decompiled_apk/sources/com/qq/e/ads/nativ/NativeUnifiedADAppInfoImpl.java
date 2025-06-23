package com.qq.e.ads.nativ;

import org.json.JSONObject;

/* loaded from: classes11.dex */
public class NativeUnifiedADAppInfoImpl implements NativeUnifiedADAppMiitInfo {

    /* renamed from: a, reason: collision with root package name */
    private final String f19420a;
    private final String b;
    private final long c;
    private final String d;
    private final String e;
    private final String f;
    private final String g;
    private final String h;
    private final String i;

    /* loaded from: classes11.dex */
    public interface Keys {
        public static final String APP_NAME = "app_name";
        public static final String AUTHOR_NAME = "author_name";
        public static final String DESCRIPTION_URL = "description_url";
        public static final String ICP_NUMBER = "icp_number";
        public static final String PACKAGE_SIZE = "package_size";
        public static final String PERMISSION_URL = "permission_url";
        public static final String PRIVACY_AGREEMENT = "privacy_agreement";
        public static final String SUITABLE_AGE = "suitable_age";
        public static final String VERSION_NAME = "version_name";
    }

    public NativeUnifiedADAppInfoImpl(JSONObject jSONObject) {
        this.f19420a = jSONObject.optString("app_name");
        this.b = jSONObject.optString(Keys.AUTHOR_NAME);
        this.c = jSONObject.optLong(Keys.PACKAGE_SIZE);
        this.d = jSONObject.optString(Keys.PERMISSION_URL);
        this.e = jSONObject.optString(Keys.PRIVACY_AGREEMENT);
        this.f = jSONObject.optString(Keys.VERSION_NAME);
        this.g = jSONObject.optString(Keys.DESCRIPTION_URL);
        this.h = jSONObject.optString(Keys.ICP_NUMBER);
        this.i = jSONObject.optString(Keys.SUITABLE_AGE);
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo
    public String getAppName() {
        return this.f19420a;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo
    public String getAuthorName() {
        return this.b;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo
    public String getDescriptionUrl() {
        return this.g;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo
    public String getIcpNumber() {
        return this.h;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo
    public long getPackageSizeBytes() {
        return this.c;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo
    public String getPermissionsUrl() {
        return this.d;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo
    public String getPrivacyAgreement() {
        return this.e;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo
    public String getSuitableAge() {
        return this.i;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo
    public String getVersionName() {
        return this.f;
    }
}
