package com.kwad.sdk.i;

import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.c;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.g;
import com.kwad.sdk.utils.s;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public class a {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    @KsJson
    /* renamed from: com.kwad.sdk.i.a$a, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0867a extends com.kwad.sdk.commercial.c.a {
        public String aGE;
        public int aKM;
        public String sdkVersion;
    }

    @KsJson
    /* loaded from: classes11.dex */
    public static class b extends com.kwad.sdk.commercial.c.a {
        public int aKN;
        public String aKO;
        public String aKP;
        public String aKQ;
        public String aKR;
        public String aKS;
    }

    public static void Kb() {
        g.execute(new az() { // from class: com.kwad.sdk.i.a.1
            @Override // com.kwad.sdk.utils.az
            public final void doTask() {
                a.Kc();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Kc() {
        C0867a a2;
        JSONObject jSONObject = (JSONObject) d.CK().getAppConfigData(null, new com.kwad.sdk.f.b<JSONObject, JSONObject>() { // from class: com.kwad.sdk.i.a.2
            private static JSONObject o(JSONObject jSONObject2) {
                return jSONObject2.optJSONObject("sdkTTPerfMonitor");
            }

            @Override // com.kwad.sdk.f.b
            public final /* synthetic */ JSONObject apply(JSONObject jSONObject2) {
                return o(jSONObject2);
            }
        });
        if (jSONObject == null) {
            return;
        }
        b bVar = new b();
        try {
            bVar.parseJson(jSONObject);
            if (bVar.aKN == 1 && (a2 = a(ServiceProvider.getContext().getClassLoader(), bVar)) != null) {
                com.kwad.sdk.commercial.b.d(c.Br().cz(ILoggerReporter.Category.APM_LOG).i(0.01d).N("ad_sdk_tt_sdk_info", "sv").t(a2).a(com.kwai.adclient.kscommerciallogger.model.a.aUS));
            }
        } catch (Throwable unused) {
        }
    }

    @Nullable
    private static C0867a a(ClassLoader classLoader, b bVar) {
        Class<?> a2 = s.a(bVar.aKO, classLoader);
        if (a2 == null) {
            return null;
        }
        C0867a c0867a = new C0867a();
        c0867a.aKM = s.classExists(bVar.aKP) ? 1 : 0;
        Object callStaticMethod = s.callStaticMethod(a2, bVar.aKQ, new Object[0]);
        c0867a.sdkVersion = (String) s.callMethod(callStaticMethod, bVar.aKR, new Object[0]);
        c0867a.aGE = (String) s.callMethod(callStaticMethod, bVar.aKS, new Object[0]);
        return c0867a;
    }
}
