package com.kwad.components.ad.adbit;

import androidx.annotation.NonNull;
import com.kwad.sdk.utils.t;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class a {

    @NonNull
    public Map<String, String> bA;

    @NonNull
    public JSONObject bz;

    public a(@NonNull JSONObject jSONObject, @NonNull Map<String, String> map) {
        this.bz = jSONObject;
        this.bA = map;
    }

    public final String N() {
        for (String str : this.bA.keySet()) {
            t.putValue(this.bz, str, this.bA.get(str));
        }
        return this.bz.toString();
    }
}
