package com.kwad.sdk.n;

import android.content.Context;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.az;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class k {
    private static final AtomicBoolean Kc = new AtomicBoolean(false);
    private static a aUv;

    @KsJson
    /* loaded from: classes11.dex */
    public static class a extends com.kwad.sdk.core.response.a.a {
        public List<String> aUx;
        public List<C0872a> aUy;

        @KsJson
        /* renamed from: com.kwad.sdk.n.k$a$a, reason: collision with other inner class name */
        /* loaded from: classes11.dex */
        public static class C0872a extends com.kwad.sdk.core.response.a.a {
            public String aUA;
            public String aUz;
        }
    }

    public static void OL() {
        if (Kc.getAndSet(true)) {
            return;
        }
        com.kwad.sdk.utils.g.execute(new az() { // from class: com.kwad.sdk.n.k.1
            @Override // com.kwad.sdk.utils.az
            public final void doTask() {
                a unused = k.aUv = new a();
                try {
                    k.aUv.parseJson((JSONObject) ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).getAppConfigData(null, new com.kwad.sdk.f.b<JSONObject, JSONObject>() { // from class: com.kwad.sdk.n.k.1.1
                        private static JSONObject o(JSONObject jSONObject) {
                            if (jSONObject != null) {
                                jSONObject.optJSONObject("wrapperBlackConfig");
                                return null;
                            }
                            return null;
                        }

                        @Override // com.kwad.sdk.f.b
                        public final /* synthetic */ JSONObject apply(JSONObject jSONObject) {
                            return o(jSONObject);
                        }
                    }));
                } catch (Throwable unused2) {
                }
            }
        });
    }

    public static boolean dA(Context context) {
        a aVar = aUv;
        if (aVar == null || ai.I(aVar.aUx) || ai.I(aUv.aUy) || !a(context, aUv)) {
            return false;
        }
        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            if (a(stackTraceElement, aUv)) {
                return true;
            }
        }
        return false;
    }

    private static boolean a(Context context, a aVar) {
        String name = context.getClass().getName();
        Iterator it = new CopyOnWriteArrayList(aVar.aUx).iterator();
        while (it.hasNext()) {
            if (ai.a((String) it.next(), name)) {
                com.kwad.sdk.core.e.c.d("WrapperBlackHelper", "isBlackClass");
                return true;
            }
        }
        return false;
    }

    private static boolean a(StackTraceElement stackTraceElement, a aVar) {
        String className = stackTraceElement.getClassName();
        String methodName = stackTraceElement.getMethodName();
        for (a.C0872a c0872a : new CopyOnWriteArrayList(aVar.aUy)) {
            String str = c0872a.aUz;
            String str2 = c0872a.aUA;
            if (ai.a(str, className) && ai.a(str2, methodName)) {
                com.kwad.sdk.core.e.c.d("WrapperBlackHelper", "isBlackMethod");
                return true;
            }
        }
        return false;
    }
}
