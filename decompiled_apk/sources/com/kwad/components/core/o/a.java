package com.kwad.components.core.o;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.core.proxy.a.b;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.collector.f;
import com.kwad.sdk.components.c;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.report.g;
import com.kwad.sdk.core.report.n;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.l;
import com.kwad.sdk.utils.t;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class a {
    private static boolean RR = false;

    /* renamed from: com.kwad.components.core.o.a$a, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static final class C0798a {
        private static final a RT = new a();
    }

    public static n G(long j) {
        return new n(j);
    }

    private static n a(long j, AdTemplate adTemplate, String str) {
        return new n(j, adTemplate, str);
    }

    private static n b(long j, AdTemplate adTemplate) {
        return new n(j, adTemplate);
    }

    public static a qI() {
        return C0798a.RT;
    }

    public final void aD(int i) {
        n G = G(10104L);
        G.azp = i;
        g.a2(G);
    }

    public final void aE(int i) {
        n G = G(10107L);
        G.azq = i;
        g.a2(G);
    }

    public final void ap(Context context) {
        n G = G(11L);
        com.kwad.sdk.components.n nVar = (com.kwad.sdk.components.n) c.f(com.kwad.sdk.components.n.class);
        if (nVar != null) {
            JSONArray[] b = nVar.b(context, d.zm());
            G.azh = b[0];
            G.azi = b[1];
            g.a2(G);
        }
    }

    public final void av(@NonNull AdTemplate adTemplate) {
        g.a2(b(10007L, adTemplate));
    }

    public final void aw(@NonNull AdTemplate adTemplate) {
        g.a2(b(10208L, adTemplate));
    }

    public final void ax(@NonNull AdTemplate adTemplate) {
        g.a2(b(10209L, adTemplate));
    }

    public final void c(@NonNull AdTemplate adTemplate, int i, int i2) {
        n b = b(10002L, adTemplate);
        b.Fx();
        if (e.dK(adTemplate)) {
            b.azo = com.kwad.sdk.core.response.b.a.K(e.dS(adTemplate));
        } else {
            b.azo = e.dU(adTemplate);
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("what", i);
            jSONObject.put("extra", i2);
            b.errorMsg = jSONObject.toString();
        } catch (JSONException e) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e);
        }
        g.a2(b);
    }

    public final void e(@NonNull JSONObject jSONObject, int i) {
        n G = G(10201L);
        t.putValue(jSONObject, "appChangeType", i);
        G.azs = jSONObject;
        g.a2(G);
    }

    public final void f(AdTemplate adTemplate, int i, String str) {
        n b = b(10109L, adTemplate);
        b.azq = 1;
        b.azr = str;
        g.a2(b);
    }

    public final void g(@NonNull AdTemplate adTemplate, long j) {
        n b = b(10202L, adTemplate);
        b.azx = j;
        g.a2(b);
    }

    public final void h(AdTemplate adTemplate, long j) {
        n b = b(10206L, adTemplate);
        b.azN = j;
        g.a2(b);
    }

    public final void i(AdTemplate adTemplate, long j) {
        n b = b(10207L, adTemplate);
        b.azO = j;
        g.a2(b);
    }

    public final n m(String str, String str2) {
        n G = G(12200L);
        G.azW = str;
        G.azX = str2;
        return G;
    }

    public final void qJ() {
        if (RR) {
            return;
        }
        RR = true;
        com.kwad.sdk.utils.g.execute(new az() { // from class: com.kwad.components.core.o.a.1
            @Override // com.kwad.sdk.utils.az
            public final void doTask() {
                n G = a.G(8L);
                G.azP = f.Bg();
                g.a2(G);
            }
        });
    }

    public final void qK() {
        g.a2(G(10101L));
    }

    public final void qL() {
        g.a2(G(10106L));
    }

    public final void a(@NonNull AdTemplate adTemplate, String str, String str2) {
        n b = b(10003L, adTemplate);
        b.azo = str;
        b.errorMsg = str2;
        g.a2(b);
    }

    public final void b(@NonNull AdTemplate adTemplate, int i, int i2) {
        n b = b(12006L, adTemplate);
        b.Ye = i;
        b.are = i2;
        g.a2(b);
    }

    public final void g(@NonNull AdTemplate adTemplate, int i, String str) {
        n b = b(107L, adTemplate);
        b.errorCode = i;
        b.errorMsg = str;
        g.a2(b);
    }

    public final void e(AdTemplate adTemplate, int i) {
        n b = b(10108L, adTemplate);
        b.azq = i;
        g.a2(b);
    }

    public final void f(@NonNull AdTemplate adTemplate, int i) {
        if (d.Dg()) {
            AdInfo dS = e.dS(adTemplate);
            n G = G(20000L);
            G.timestamp = System.currentTimeMillis();
            G.azY = i;
            G.trace = dS.trace;
            G.azZ = BuildConfig.VERSION_CODE;
            G.posId = e.dL(adTemplate);
            g.a2(G);
        }
    }

    public final void a(int i, @NonNull AdTemplate adTemplate, String str) {
        g.a2(a(i, adTemplate, str));
    }

    public final void b(@NonNull AdTemplate adTemplate, String str, String str2) {
        n b = b(10005L, adTemplate);
        if (e.dK(adTemplate)) {
            b.azo = com.kwad.sdk.core.response.b.a.K(e.dS(adTemplate));
        } else {
            b.azo = e.dU(adTemplate);
        }
        b.azo = str;
        b.errorMsg = str2;
        g.a2(b);
    }

    public final void a(@NonNull AdTemplate adTemplate, long j, long j2, int i) {
        n b = b(10203L, adTemplate);
        b.WF = j;
        b.blockDuration = j2;
        b.aze = i;
        g.a2(b);
    }

    public final void e(String str, String str2, boolean z) {
        g.a(m(str, str2), z);
    }

    public final void a(boolean z, List<Integer> list) {
        n G = G(10204L);
        G.azz = z;
        if (list.size() > 0) {
            JSONArray jSONArray = new JSONArray();
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next());
            }
            G.azy = jSONArray;
        }
        g.a2(G);
    }

    public final void c(@NonNull JSONArray jSONArray) {
        n G = G(10200L);
        G.azt = jSONArray;
        g.a2(G);
    }

    public final void b(@NonNull AdTemplate adTemplate, long j, int i) {
        n b = b(104L, adTemplate);
        b.clickTime = l.eo(adTemplate);
        b.azD = j;
        b.azE = i;
        g.a2(b);
    }

    public final void a(SceneImpl sceneImpl, boolean z, String str) {
        n G = G(10216L);
        G.azz = z;
        G.azA = str;
        G.adScene = sceneImpl;
        g.a2(G);
    }

    public final void a(b bVar) {
        n G = G(10215L);
        G.RH = bVar.RH;
        G.RO = bVar.RO;
        G.RP = bVar.RP;
        G.RQ = bVar.RQ;
        g.a2(G);
    }

    public final void a(long j, int i) {
        if (d.Dg()) {
            n G = G(20000L);
            G.timestamp = System.currentTimeMillis();
            G.azY = i;
            G.posId = j;
            G.azZ = BuildConfig.VERSION_CODE;
            g.a2(G);
        }
    }
}
