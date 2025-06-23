package com.kwad.components.core.webview.jshandler;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.utils.bo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class ad implements com.kwad.sdk.core.webview.c.a {
    private final com.kwad.sdk.core.webview.b WQ;
    private final boolean Xw = false;
    private com.kwad.sdk.core.network.l<com.kwad.components.core.request.a, AdResultData> iJ;

    /* loaded from: classes11.dex */
    public static final class a implements com.kwad.sdk.core.b {
        AdResultData mAdResultData;

        public a(AdResultData adResultData) {
            this.mAdResultData = adResultData;
        }

        @Override // com.kwad.sdk.core.b
        public final void parseJson(@Nullable JSONObject jSONObject) {
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject json;
            AdResultData adResultData = this.mAdResultData;
            if (adResultData == null || (json = adResultData.toJson()) == null) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            for (AdTemplate adTemplate : this.mAdResultData.getAdTemplateList()) {
                if (!TextUtils.isEmpty(adTemplate.mOriginJString)) {
                    try {
                        jSONArray.put(new JSONObject(adTemplate.mOriginJString));
                    } catch (JSONException e) {
                        com.kwad.sdk.core.e.c.printStackTrace(e);
                        jSONArray.put(adTemplate.toJson());
                    }
                } else {
                    jSONArray.put(adTemplate.toJson());
                }
            }
            com.kwad.sdk.utils.t.putValue(json, "impAdInfo", jSONArray);
            return json;
        }
    }

    public ad(com.kwad.sdk.core.webview.b bVar) {
        this.WQ = bVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "getKsAdData";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        com.kwad.sdk.core.network.l<com.kwad.components.core.request.a, AdResultData> lVar = this.iJ;
        if (lVar != null) {
            lVar.cancel();
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        if (this.Xw) {
            AdTemplate adTemplate = this.WQ.getAdTemplate();
            ImpInfo impInfo = new ImpInfo(adTemplate.mAdScene);
            if (adTemplate.mAdScene != null) {
                impInfo.pageScene = r1.getPageScene();
            }
            impInfo.subPageScene = 106L;
            impInfo.adScene.setAdNum(12);
            impInfo.sdkExtraData = com.kwad.sdk.core.response.b.e.eb(adTemplate);
            a(impInfo, cVar);
            return;
        }
        if (this.WQ.Hx()) {
            cVar.onError(-1, "native adTemplate is null");
        } else {
            cVar.a(new a(this.WQ.hl()));
        }
    }

    private void a(final ImpInfo impInfo, final com.kwad.sdk.core.webview.c.c cVar) {
        com.kwad.sdk.core.network.l<com.kwad.components.core.request.a, AdResultData> lVar = this.iJ;
        if (lVar != null) {
            lVar.cancel();
        }
        com.kwad.sdk.core.network.l<com.kwad.components.core.request.a, AdResultData> lVar2 = new com.kwad.sdk.core.network.l<com.kwad.components.core.request.a, AdResultData>() { // from class: com.kwad.components.core.webview.jshandler.ad.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.l
            @NonNull
            /* renamed from: aa, reason: merged with bridge method [inline-methods] */
            public AdResultData parseData(String str) {
                JSONObject jSONObject = new JSONObject(str);
                AdResultData adResultData = new AdResultData(impInfo.adScene);
                adResultData.parseJson(jSONObject);
                return adResultData;
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: no, reason: merged with bridge method [inline-methods] */
            public com.kwad.components.core.request.a createRequest() {
                return new com.kwad.components.core.request.a(impInfo);
            }
        };
        this.iJ = lVar2;
        lVar2.request(new com.kwad.sdk.core.network.o<com.kwad.components.core.request.a, AdResultData>() { // from class: com.kwad.components.core.webview.jshandler.ad.2
            private void c(@NonNull final AdResultData adResultData) {
                String str;
                if (adResultData.isAdResultDataEmpty()) {
                    StringBuilder sb = new StringBuilder("onError:");
                    Integer valueOf = Integer.valueOf(com.kwad.sdk.core.network.e.awK.errorCode);
                    if (TextUtils.isEmpty(adResultData.testErrorMsg)) {
                        str = com.kwad.sdk.core.network.e.awK.msg;
                    } else {
                        str = adResultData.testErrorMsg;
                    }
                    sb.append(String.format("code:%s__msg:%s", valueOf, str));
                    com.kwad.sdk.core.e.c.d("WebCardGetKsAdDataHandler", sb.toString());
                    bo.runOnUiThread(new com.kwad.sdk.utils.az() { // from class: com.kwad.components.core.webview.jshandler.ad.2.1
                        @Override // com.kwad.sdk.utils.az
                        public final void doTask() {
                            cVar.a(adResultData);
                        }
                    });
                    return;
                }
                bo.runOnUiThread(new com.kwad.sdk.utils.az() { // from class: com.kwad.components.core.webview.jshandler.ad.2.2
                    @Override // com.kwad.sdk.utils.az
                    public final void doTask() {
                        cVar.a(adResultData);
                    }
                });
            }

            private void h(int i, String str) {
                com.kwad.sdk.core.e.c.d("WebCardGetKsAdDataHandler", "requestAggregateAd onError code:" + i + " msg: " + str);
                ad.this.a(cVar);
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onError(@NonNull com.kwad.sdk.core.network.f fVar, int i, String str) {
                h(i, str);
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onSuccess(@NonNull com.kwad.sdk.core.network.f fVar, @NonNull BaseResultData baseResultData) {
                c((AdResultData) baseResultData);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final com.kwad.sdk.core.webview.c.c cVar) {
        bo.runOnUiThread(new com.kwad.sdk.utils.az() { // from class: com.kwad.components.core.webview.jshandler.ad.3
            @Override // com.kwad.sdk.utils.az
            public final void doTask() {
                AdResultData adResultData = new AdResultData();
                adResultData.setAdTemplateList(new ArrayList());
                cVar.a(adResultData);
            }
        });
    }
}
