package com.kwad.sdk.crash.online.monitor;

import android.text.TextUtils;
import com.kwad.sdk.crash.online.monitor.a.c;
import com.kwad.sdk.crash.online.monitor.block.e;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.g;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class a {
    private static volatile boolean hasInit = false;

    private static c Iy() {
        c cVar = new c();
        com.kwad.sdk.crash.online.monitor.a.a aVar = new com.kwad.sdk.crash.online.monitor.a.a();
        cVar.aIs = aVar;
        aVar.aIj = 5;
        return cVar;
    }

    public static /* synthetic */ boolean access$002(boolean z) {
        hasInit = true;
        return true;
    }

    public static void cM(final String str) {
        g.execute(new az() { // from class: com.kwad.sdk.crash.online.monitor.a.1
            @Override // com.kwad.sdk.utils.az
            public final void doTask() {
                if (a.hasInit) {
                    return;
                }
                com.kwad.sdk.core.e.c.d("perfMonitor.MonitorManager", "configStr:" + str);
                c fE = a.fE(str);
                com.kwad.sdk.core.e.c.d("perfMonitor.MonitorManager", fE.toJson().toString());
                e.d(fE.aIs);
                a.access$002(true);
            }
        });
    }

    public static c fE(String str) {
        if (TextUtils.isEmpty(str)) {
            return Iy();
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            c cVar = new c();
            cVar.parseJson(jSONObject);
            return cVar;
        } catch (Exception e) {
            com.kwad.sdk.core.e.c.w("perfMonitor.MonitorManager", e);
            return Iy();
        }
    }
}
