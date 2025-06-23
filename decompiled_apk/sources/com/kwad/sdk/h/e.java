package com.kwad.sdk.h;

import androidx.annotation.Nullable;
import com.baidu.platform.comapi.map.MapBundleKey;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public final class e implements com.kwad.sdk.h.b {
    public int aKi;
    public b aKj;
    public a aKk;
    public double apu;

    /* loaded from: classes11.dex */
    public static class a implements com.kwad.sdk.h.b {
        public List<String> aKl;
        public List<String> aKm;
        public List<String> aKn;

        public final void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.aKl = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("levelList");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.aKl.add(optJSONArray.optString(i));
                }
            }
            this.aKm = new ArrayList();
            JSONArray optJSONArray2 = jSONObject.optJSONArray("tagList");
            if (optJSONArray2 != null) {
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    this.aKm.add(optJSONArray2.optString(i2));
                }
            }
            this.aKn = new ArrayList();
            JSONArray optJSONArray3 = jSONObject.optJSONArray("keywordList");
            if (optJSONArray3 != null) {
                for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                    this.aKn.add(optJSONArray3.optString(i3));
                }
            }
        }

        @Override // com.kwad.sdk.h.b
        public final JSONObject toJson() {
            return null;
        }
    }

    /* loaded from: classes11.dex */
    public static class b implements com.kwad.sdk.h.b {
        public static int OK = 1;
        public static int aKo = -1;
        public static int aKp;
        public List<String> aGm;
        public List<String> aGn;
        public List<String> aKq;
        public int aKr = aKo;

        public final boolean JH() {
            if (this.aKr == OK) {
                return true;
            }
            return false;
        }

        public final void bD(boolean z) {
            int i;
            if (z) {
                i = OK;
            } else {
                i = aKp;
            }
            this.aKr = i;
        }

        public final void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.aGm = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("appIdList");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.aGm.add(optJSONArray.optString(i));
                }
            }
            this.aGn = new ArrayList();
            JSONArray optJSONArray2 = jSONObject.optJSONArray("sdkVersionList");
            if (optJSONArray2 != null) {
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    this.aGn.add(optJSONArray2.optString(i2));
                }
            }
            this.aKq = new ArrayList();
            JSONArray optJSONArray3 = jSONObject.optJSONArray("deviceIdList");
            if (optJSONArray3 != null) {
                for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                    this.aKq.add(optJSONArray3.optString(i3));
                }
            }
        }

        @Override // com.kwad.sdk.h.b
        public final JSONObject toJson() {
            return null;
        }
    }

    public final void parseJson(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.apu = jSONObject.optDouble(MapBundleKey.OfflineMapKey.OFFLINE_RATION);
        this.aKi = jSONObject.optInt("kcType", 1);
        b bVar = new b();
        this.aKj = bVar;
        bVar.parseJson(jSONObject.optJSONObject("scopeConfig"));
        a aVar = new a();
        this.aKk = aVar;
        aVar.parseJson(jSONObject.optJSONObject("logConfig"));
    }

    @Override // com.kwad.sdk.h.b
    public final JSONObject toJson() {
        return null;
    }
}
