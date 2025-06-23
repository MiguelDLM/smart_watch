package com.kwad.sdk.k.a;

import android.content.Context;
import android.provider.Settings;
import androidx.annotation.Nullable;
import com.kwad.sdk.utils.t;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class d extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {
    public int aOc = 0;
    public int aOd = 0;
    public int aOe = 0;
    public int aOf = 0;
    public int aOg = 0;
    public int aOh = 0;
    public int aOi = 0;

    public d(Context context) {
        if (context != null) {
            bM(Settings.Secure.getInt(context.getContentResolver(), "adb_enabled", 0) > 0);
        }
    }

    private void a(d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        dVar.aOc = jSONObject.optInt("isRoot");
        dVar.aOd = jSONObject.optInt("isXPosed");
        dVar.aOe = jSONObject.optInt("isFrameworkHooked");
        dVar.aOf = jSONObject.optInt("isVirtual");
        dVar.aOg = jSONObject.optInt("isAdbEnabled");
        dVar.aOh = jSONObject.optInt("isEmulator");
        dVar.aOi = jSONObject.optInt("isGroupControl");
        super.afterParseJson(jSONObject);
    }

    private static JSONObject b(d dVar, JSONObject jSONObject) {
        t.putValue(jSONObject, "isRoot", dVar.aOc);
        t.putValue(jSONObject, "isXPosed", dVar.aOd);
        t.putValue(jSONObject, "isFrameworkHooked", dVar.aOe);
        t.putValue(jSONObject, "isVirtual", dVar.aOf);
        t.putValue(jSONObject, "isAdbEnabled", dVar.aOg);
        t.putValue(jSONObject, "isEmulator", dVar.aOh);
        t.putValue(jSONObject, "isGroupControl", dVar.aOi);
        return jSONObject;
    }

    private void bM(boolean z) {
        this.aOg = bP(z);
    }

    private static int bP(boolean z) {
        return z ? 1 : 2;
    }

    public final void bJ(boolean z) {
        this.aOc = bP(z);
    }

    public final void bK(boolean z) {
        this.aOd = bP(z);
    }

    public final void bL(boolean z) {
        this.aOe = bP(z);
    }

    public final void bN(boolean z) {
        this.aOh = bP(z);
    }

    public final void bO(boolean z) {
        this.aOi = bP(z);
    }

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
        a(this, jSONObject);
        afterParseJson(jSONObject);
    }

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject b = b(this, new JSONObject());
        afterToJson(b);
        return b;
    }
}
