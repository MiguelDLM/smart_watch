package com.kwad.sdk.core.network.idc.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.utils.t;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class b implements com.kwad.sdk.core.b {
    private final Map<String, List<String>> axZ = new ConcurrentHashMap();

    @NonNull
    private Map<String, List<String>> EK() {
        return this.axZ;
    }

    public static b eg(String str) {
        b bVar = new b();
        try {
            bVar.parseJson(new JSONObject(str));
        } catch (JSONException e) {
            c.printStackTraceOnly(e);
        }
        return bVar;
    }

    @NonNull
    public final Set<String> EL() {
        return this.axZ.keySet();
    }

    public final void a(b bVar) {
        this.axZ.clear();
        if (bVar != null) {
            this.axZ.putAll(bVar.EK());
        }
    }

    @NonNull
    public final List<String> ef(String str) {
        List<String> list = this.axZ.get(str);
        if (list == null) {
            return Collections.emptyList();
        }
        return list;
    }

    public final boolean isEmpty() {
        return this.axZ.isEmpty();
    }

    @Override // com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (!TextUtils.isEmpty(next)) {
                hashMap.put(next, t.h(jSONObject.optJSONArray(next)));
            }
        }
        this.axZ.clear();
        this.axZ.putAll(hashMap);
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        Map<String, List<String>> map = this.axZ;
        JSONObject jSONObject = new JSONObject();
        for (String str : map.keySet()) {
            t.putValue(jSONObject, str, t.O(map.get(str)));
        }
        return jSONObject;
    }
}
