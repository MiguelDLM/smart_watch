package com.kwad.components.core.webview.jshandler;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bh;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public class ak implements com.kwad.sdk.core.webview.c.a {
    private final com.kwad.sdk.core.webview.b WQ;
    private int Yc = 0;
    private a Yd;

    /* loaded from: classes11.dex */
    public interface a {
        void onAdShow();
    }

    /* loaded from: classes11.dex */
    public static final class b extends com.kwad.sdk.core.report.a implements com.kwad.sdk.core.b {
        private String JK;
        private String Lh;
        private int Ye;
        private int actionType;
        private AdTemplate adTemplate;

        public final int getActionType() {
            return this.actionType;
        }

        public final String nm() {
            return this.JK;
        }

        @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
        public final void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.actionType = jSONObject.optInt(SDKConstants.PARAM_GAME_REQUESTS_ACTION_TYPE);
            this.Ye = jSONObject.optInt("refreshType");
            this.Lh = jSONObject.optString("payload");
            this.JK = jSONObject.optString("creativeId");
            try {
                if (jSONObject.has("adTemplate")) {
                    String string = jSONObject.getString("adTemplate");
                    if (this.adTemplate == null) {
                        this.adTemplate = new AdTemplate();
                    }
                    this.adTemplate.parseJson(new JSONObject(string));
                }
            } catch (Exception e) {
                com.kwad.sdk.core.e.c.printStackTraceOnly(e);
            }
            if (this.adTemplate == null && jSONObject.has("adCacheId")) {
                this.adTemplate = com.kwad.sdk.core.response.b.c.a(com.kwad.components.core.n.a.d.a.a.at(jSONObject.optInt("adCacheId")), this.JK);
            }
        }

        public final String sT() {
            return this.Lh;
        }

        @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.t.putValue(jSONObject, SDKConstants.PARAM_GAME_REQUESTS_ACTION_TYPE, this.actionType);
            com.kwad.sdk.utils.t.putValue(jSONObject, "payload", this.Lh);
            com.kwad.sdk.utils.t.putValue(jSONObject, "refreshType", this.Ye);
            com.kwad.sdk.utils.t.a(jSONObject, "adTemplate", this.adTemplate);
            com.kwad.sdk.utils.t.putValue(jSONObject, "creativeId", this.JK);
            return jSONObject;
        }
    }

    public ak(com.kwad.sdk.core.webview.b bVar) {
        this.WQ = bVar;
    }

    private AdTemplate c(@NonNull b bVar) {
        if (bVar.adTemplate != null) {
            return bVar.adTemplate;
        }
        return this.WQ.de(bVar.JK);
    }

    public void a(com.kwad.sdk.core.adlog.c.b bVar) {
    }

    public void b(boolean z, AdTemplate adTemplate, @Nullable JSONObject jSONObject, @Nullable com.kwad.sdk.core.adlog.c.b bVar) {
        com.kwad.components.core.s.b.rC().a(adTemplate, null, bVar);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "log";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    public final void a(a aVar) {
        this.Yd = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        try {
            b bVar = new b();
            bVar.parseJson(new JSONObject(str));
            if (c(bVar) == null) {
                cVar.onError(-1, "native adTemplate is null");
            }
            a(bVar);
            cVar.a(null);
        } catch (JSONException e) {
            com.kwad.sdk.core.e.c.printStackTrace(e);
            cVar.onError(-1, e.getMessage());
        }
    }

    @SuppressLint({"SwitchIntDef"})
    public void a(@NonNull b bVar) {
        com.kwad.sdk.core.e.c.d("WebCardLogHandler", "handleH5Log actionType actionType" + bVar.actionType);
        if (bVar.actionType == 1) {
            com.kwad.sdk.core.adlog.c.b dm = new com.kwad.sdk.core.adlog.c.b().dm(bVar.Lh);
            a aVar = this.Yd;
            if (aVar != null) {
                aVar.onAdShow();
            }
            if (bVar.adTemplate != null) {
                dm.cO(this.Yc);
                b(true, bVar.adTemplate, null, dm);
                return;
            } else {
                if (bh.isNullString(bVar.nm())) {
                    b(true, this.WQ.getAdTemplate(), null, dm);
                    return;
                }
                for (AdTemplate adTemplate : this.WQ.Hw()) {
                    if (bh.isEquals(bVar.nm(), String.valueOf(com.kwad.sdk.core.response.b.e.ec(adTemplate)))) {
                        b(false, adTemplate, null, dm);
                        return;
                    }
                }
                return;
            }
        }
        if (bVar.actionType != 2) {
            if (bVar.actionType == 12006) {
                com.kwad.components.core.o.a.qI().b(c(bVar), bVar.Ye, this.Yc);
                return;
            }
            if (bVar.actionType != 140) {
                if (bVar.actionType == 141) {
                    com.kwad.sdk.core.adlog.c.e(c(bVar), this.WQ.mReportExtData, new com.kwad.sdk.core.adlog.c.b().dm(bVar.Lh));
                    return;
                } else {
                    com.kwad.sdk.core.adlog.c.a(c(bVar), bVar.actionType, this.WQ.mReportExtData, bVar.Lh);
                    com.kwad.components.core.webview.tachikoma.d.a.tC().aZ(bVar.Lh);
                    return;
                }
            }
            com.kwad.sdk.core.adlog.c.d(c(bVar), this.WQ.mReportExtData, new com.kwad.sdk.core.adlog.c.b().dm(bVar.Lh));
            return;
        }
        com.kwad.sdk.widget.e eVar = this.WQ.aEW;
        com.kwad.sdk.core.adlog.c.b dm2 = new com.kwad.sdk.core.adlog.c.b().cO(this.Yc).dm(bVar.Lh);
        if (eVar != null) {
            dm2.f(eVar.getTouchCoords());
        }
        a(dm2);
        com.kwad.sdk.core.adlog.c.a(c(bVar), dm2, this.WQ.mReportExtData);
    }
}
