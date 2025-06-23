package com.kwad.sdk.core.config.item;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class m extends q {
    private JSONObject auC;

    public m(String str) {
        this(str, "{}");
    }

    public final int dv(String str) {
        JSONObject jSONObject;
        if (str != null && (jSONObject = this.auC) != null) {
            try {
                return jSONObject.optInt(str);
            } catch (Exception unused) {
            }
        }
        return -1;
    }

    private m(String str, String str2) {
        super(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.config.item.b
    public void setValue(String str) {
        super.setValue((m) str);
        try {
            this.auC = new JSONObject(getValue());
        } catch (NullPointerException e) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e);
        } catch (JSONException e2) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e2);
        }
    }
}
