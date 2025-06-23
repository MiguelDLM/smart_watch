package com.kwad.sdk.k.a;

import androidx.annotation.Nullable;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.h;
import com.kwad.sdk.utils.ba;
import com.kwad.sdk.utils.t;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class b extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {
    public int aNZ;
    public int aOa;
    public int aOb;

    public b(int i, int i2, int i3) {
        this.aNZ = i;
        this.aOa = i2;
        this.aOb = i3;
    }

    public static synchronized b Lg() {
        synchronized (b.class) {
            if (!((h) ServiceProvider.get(h.class)).zi()) {
                return null;
            }
            return ba.Lg();
        }
    }

    private static void a(b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.aNZ = jSONObject.optInt("cellId", -1);
        bVar.aOa = jSONObject.optInt("lac", -1);
        bVar.aOb = jSONObject.optInt("bsss", -1);
    }

    private static JSONObject b(b bVar, JSONObject jSONObject) {
        t.putValue(jSONObject, "cellId", bVar.aNZ);
        t.putValue(jSONObject, "lac", bVar.aOa);
        t.putValue(jSONObject, "bsss", bVar.aOb);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
        a(this, jSONObject);
        super.afterParseJson(jSONObject);
    }

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public final JSONObject toJson() {
        return b(this, new JSONObject());
    }
}
