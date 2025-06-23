package com.kwad.sdk.h;

import androidx.annotation.NonNull;
import java.util.Iterator;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public final class k implements b {
    public JSONObject aKI = new JSONObject();
    public String actionId = UUID.randomUUID().toString();

    public k(String str, String str2, i iVar) {
        JSONObject JJ = h.JN().JR().JJ();
        Iterator<String> keys = JJ.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            c.a(JJ, next, JJ.opt(next));
        }
        c.putValue(this.aKI, "customKey", str);
        c.putValue(this.aKI, "customValue", str2);
        c.putValue(this.aKI, "timestamp", iVar.aKF);
        c.putValue(this.aKI, "actionId", this.actionId);
    }

    @Override // com.kwad.sdk.h.b
    public final JSONObject toJson() {
        return this.aKI;
    }

    @NonNull
    public final String toString() {
        return this.aKI.toString();
    }
}
