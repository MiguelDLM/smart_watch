package com.kwad.sdk.crash.online.monitor.block;

import android.text.TextUtils;
import android.util.Log;
import com.kwad.sdk.m.d;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.h;

/* loaded from: classes11.dex */
public final class c {
    private static volatile boolean aHU;

    private static String a(com.kwad.sdk.crash.online.monitor.a.b bVar) {
        String str;
        if (bVar != null && !TextUtils.isEmpty(bVar.aIn)) {
            str = bVar.aIn;
        } else {
            str = "b25SZXBvcnRJc3N1ZQ==";
        }
        String str2 = new String(com.kwad.sdk.core.a.c.Ee().decode(str));
        com.kwad.sdk.core.e.c.d("perfMonitor.Injector", "report methodName:" + str2);
        return str2;
    }

    public static void b(com.kwad.sdk.crash.online.monitor.a.a aVar) {
        if (aHU) {
            return;
        }
        try {
            com.kwad.sdk.crash.online.monitor.a.b c = c(aVar);
            com.kwad.sdk.m.d.a(b(c), a(c), new d.a() { // from class: com.kwad.sdk.crash.online.monitor.block.c.1
                @Override // com.kwad.sdk.m.d.a
                public final void a(String str, long j, long j2, String str2, String str3) {
                    f.a(str, j, j2, str2, str3, false);
                }

                @Override // com.kwad.sdk.m.d.a
                public final void onError(String str) {
                    c.onError(str);
                }
            });
            aHU = true;
        } catch (Exception e) {
            onError(Log.getStackTraceString(e));
        }
    }

    private static com.kwad.sdk.crash.online.monitor.a.b c(com.kwad.sdk.crash.online.monitor.a.a aVar) {
        String str;
        h hVar = (h) ServiceProvider.get(h.class);
        if (hVar != null) {
            str = hVar.getAppId();
        } else {
            str = "";
        }
        if (!TextUtils.isEmpty(str)) {
            return aVar.fM(str);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void onError(String str) {
        f.fL(str);
        com.kwad.sdk.core.e.c.w("perfMonitor.Injector", str);
    }

    private static String b(com.kwad.sdk.crash.online.monitor.a.b bVar) {
        String str;
        if (bVar != null && !TextUtils.isEmpty(bVar.aIm)) {
            str = bVar.aIm;
        } else {
            str = "Y29tLnRlbmNlbnQubWF0cml4LnBsdWdpbi5QbHVnaW5MaXN0ZW5lcg==";
        }
        String str2 = new String(com.kwad.sdk.core.a.c.Ee().decode(str));
        com.kwad.sdk.core.e.c.d("perfMonitor.Injector", "ListenerName:" + str2);
        return str2;
    }
}
