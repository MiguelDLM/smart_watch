package com.kwad.sdk.collector.a;

import com.huawei.openalliance.ad.constant.bn;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.core.network.d;
import com.kwad.sdk.h;
import com.kwad.sdk.utils.t;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class a extends d {
    private C0840a aoI;

    /* renamed from: com.kwad.sdk.collector.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0840a {
        private List<String> aoJ;

        public C0840a(List<String> list) {
            this.aoJ = list;
        }

        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            t.putValue(jSONObject, "packageName", this.aoJ);
            return jSONObject;
        }
    }

    public a(List<String> list) {
        C0840a c0840a = new C0840a(list);
        this.aoI = c0840a;
        putBody("targetAppInfo", c0840a.toJson());
        putBody(bn.f.Code, BuildConfig.VERSION_NAME);
        putBody("sdkVersionCode", BuildConfig.VERSION_CODE);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final String getUrl() {
        return h.yJ();
    }
}
