package com.kwad.sdk.crash.online.monitor.a;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

@KsJson
/* loaded from: classes11.dex */
public class a extends com.kwad.sdk.core.response.a.a {
    public List<String> aId = new ArrayList();
    public List<String> aIe = new ArrayList();
    public List<String> aIf = new ArrayList();
    public List<String> aIg = new ArrayList();
    public List<b> aIh = new ArrayList();
    public Map<String, b> aIi = new HashMap();
    public int aIj;
    public int aIk;
    public int aIl;
    public double apu;

    public final boolean IF() {
        if ((this.aIl & 4) != 0) {
            return true;
        }
        return false;
    }

    public final boolean IG() {
        if ((this.aIl & 1) != 0) {
            return true;
        }
        return false;
    }

    public final boolean IH() {
        if ((this.aIl & 2) != 0) {
            return true;
        }
        return false;
    }

    public final boolean II() {
        if (this.aIl == 0) {
            return true;
        }
        return false;
    }

    @Override // com.kwad.sdk.core.response.a.a
    public void afterParseJson(JSONObject jSONObject) {
        super.afterParseJson(jSONObject);
        List<b> list = this.aIh;
        if (list != null) {
            for (b bVar : list) {
                this.aIi.put(bVar.appId, bVar);
            }
            this.aIh.clear();
        }
    }

    @Nullable
    public final b fM(String str) {
        b bVar = null;
        if (this.aIi == null) {
            return null;
        }
        if (!TextUtils.isEmpty(str)) {
            bVar = this.aIi.get(str);
        }
        if (bVar == null) {
            return this.aIi.get("000000000");
        }
        return bVar;
    }
}
