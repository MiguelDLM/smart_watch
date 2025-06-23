package com.kwad.sdk.core.request.model;

import android.location.Location;
import androidx.annotation.Nullable;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aw;
import com.kwad.sdk.utils.t;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class c implements com.kwad.sdk.core.b {
    private static c aAR;
    private double latitude;
    private double longitude;
    private int type;

    public static c FL() {
        Location location;
        c cVar = aAR;
        if (cVar != null) {
            return cVar;
        }
        try {
            aAR = new c();
            com.kwad.sdk.utils.c.a ci = aw.ci(((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext());
            if (ci != null && (location = ci.aTt) != null) {
                aAR.latitude = location.getLatitude();
                aAR.longitude = ci.aTt.getLongitude();
                aAR.type = ci.type;
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
        return aAR;
    }

    @Override // com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        t.putValue(jSONObject, "latitude", this.latitude);
        t.putValue(jSONObject, "longitude", this.longitude);
        t.putValue(jSONObject, "type", this.type);
        return jSONObject;
    }
}
