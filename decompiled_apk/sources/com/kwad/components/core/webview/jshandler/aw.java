package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.openalliance.ad.inter.data.AdEventType;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class aw extends com.kwad.components.core.webview.tachikoma.a.w {

    /* loaded from: classes11.dex */
    public static final class a implements com.kwad.sdk.core.b {
        private String YD;

        @Override // com.kwad.sdk.core.b
        public final void parseJson(@Nullable JSONObject jSONObject) {
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.t.putValue(jSONObject, "lifeStatus", this.YD);
            return jSONObject;
        }
    }

    private void aP(String str) {
        a aVar = new a();
        aVar.YD = str;
        b(aVar);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "registerLifecycleListener";
    }

    public final void sV() {
        aP(AdEventType.SHOW_START);
    }

    public final void sW() {
        aP("showEnd");
    }

    public final void sX() {
        aP("hideStart");
    }

    public final void sY() {
        aP("hideEnd");
    }

    public final void sZ() {
        aP("pageVisiable");
    }

    public final void ta() {
        aP("pageInvisiable");
    }
}
