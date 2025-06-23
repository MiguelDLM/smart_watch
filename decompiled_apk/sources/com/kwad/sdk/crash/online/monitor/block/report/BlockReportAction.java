package com.kwad.sdk.crash.online.monitor.block.report;

import com.kwad.sdk.core.report.e;
import com.kwad.sdk.utils.t;
import java.io.Serializable;
import java.util.UUID;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public class BlockReportAction extends e implements Serializable {
    private static final long serialVersionUID = 8432448382850235426L;
    public String msg;

    public BlockReportAction(String str) {
        this.actionId = UUID.randomUUID().toString();
        this.msg = str;
    }

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public void parseJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.actionId = jSONObject.optString("actionId");
        this.msg = jSONObject.optString("msg");
    }

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        t.putValue(jSONObject, "actionId", this.actionId);
        t.putValue(jSONObject, "msg", this.msg);
        return jSONObject;
    }

    public BlockReportAction(JSONObject jSONObject) {
        parseJson(jSONObject);
    }
}
