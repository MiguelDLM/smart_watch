package com.kwad.sdk.core.request.model;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.huawei.openalliance.ad.uriaction.i;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bk;
import com.kwad.sdk.utils.k;
import com.kwad.sdk.utils.t;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class a implements com.kwad.sdk.core.b {
    private static JSONObject aAp;
    private String aAq;
    private String appId;
    private String name;
    private String packageName;
    private String version;

    public static JSONObject FI() {
        if (!l(aAp)) {
            aAp = FJ().toJson();
        }
        return aAp;
    }

    public static a FJ() {
        a aVar = new a();
        try {
            aVar.appId = ServiceProvider.Lx().appId;
            aVar.name = ServiceProvider.Lx().appName;
            aVar.packageName = ServiceProvider.Lw().getPackageName();
            aVar.version = k.cd(ServiceProvider.Lw());
            aVar.aAq = com.kwad.sdk.utils.e.bT(ServiceProvider.Lw());
            if (!TextUtils.isEmpty(bk.getAppId())) {
                aVar.appId = bk.getAppId();
            }
            if (!TextUtils.isEmpty(bk.getPackageName())) {
                aVar.packageName = bk.getPackageName();
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
        return aVar;
    }

    private static boolean l(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        String optString = jSONObject.optString(i.Code);
        String optString2 = jSONObject.optString("name");
        if (TextUtils.isEmpty(optString2) || TextUtils.isEmpty(optString) || !optString.equals(ServiceProvider.Lx().appId) || !optString2.equals(ServiceProvider.Lx().appName)) {
            return false;
        }
        return true;
    }

    @Override // com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        t.putValue(jSONObject, i.Code, this.appId);
        t.putValue(jSONObject, "name", this.name);
        t.putValue(jSONObject, "packageName", this.packageName);
        t.putValue(jSONObject, "version", this.version);
        t.putValue(jSONObject, "sha1", this.aAq);
        return jSONObject;
    }
}
