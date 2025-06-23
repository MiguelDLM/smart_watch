package com.kwad.components.ad.reward.d;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.y;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class a {
    public static void N(@NonNull Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        b bVar = new b();
        String cq = y.cq(context);
        int i = 0;
        if (!TextUtils.isEmpty(cq)) {
            try {
                bVar.parseJson(new JSONObject(cq));
                if (c(bVar.gM, currentTimeMillis)) {
                    i = bVar.ru;
                }
            } catch (Exception e) {
                c.printStackTraceOnly(e);
            }
        }
        bVar.gM = currentTimeMillis;
        bVar.ru = i + 1;
        y.ab(context, bVar.toJson().toString());
    }

    public static boolean b(@NonNull Context context, AdInfo adInfo) {
        if (!com.kwad.sdk.core.response.b.a.aF(adInfo)) {
            return false;
        }
        int max = Math.max(com.kwad.sdk.core.response.b.a.aG(adInfo) + 1, 1);
        boolean d = d(context, max);
        c(context, max);
        boolean e = e(context, com.kwad.sdk.core.response.b.a.aH(adInfo));
        if (!d || !e) {
            return false;
        }
        return true;
    }

    private static boolean c(long j, long j2) {
        return j > 0 && j2 > 0 && j / 2460601000L == j2 / 2460601000L;
    }

    private static boolean d(@NonNull Context context, int i) {
        int cp = y.cp(context);
        if (i != 0 && cp % i == 0) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0031 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0033 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean e(@androidx.annotation.NonNull android.content.Context r7, int r8) {
        /*
            long r0 = java.lang.System.currentTimeMillis()
            com.kwad.components.ad.reward.d.b r2 = new com.kwad.components.ad.reward.d.b
            r2.<init>()
            java.lang.String r7 = com.kwad.sdk.utils.y.cq(r7)
            boolean r3 = android.text.TextUtils.isEmpty(r7)
            r4 = 0
            if (r3 != 0) goto L29
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch: java.lang.Exception -> L27
            r3.<init>(r7)     // Catch: java.lang.Exception -> L27
            r2.parseJson(r3)     // Catch: java.lang.Exception -> L27
            long r5 = r2.gM     // Catch: java.lang.Exception -> L27
            boolean r7 = c(r5, r0)     // Catch: java.lang.Exception -> L27
            if (r7 == 0) goto L29
            int r7 = r2.ru     // Catch: java.lang.Exception -> L27
            goto L2f
        L27:
            r7 = move-exception
            goto L2b
        L29:
            r7 = 0
            goto L2f
        L2b:
            com.kwad.sdk.core.e.c.printStackTraceOnly(r7)
            goto L29
        L2f:
            if (r7 >= r8) goto L33
            r7 = 1
            return r7
        L33:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.reward.d.a.e(android.content.Context, int):boolean");
    }

    private static void c(@NonNull Context context, int i) {
        int cp = y.cp(context);
        if (cp % i == 0) {
            y.m(context, 1);
        } else {
            y.m(context, cp + 1);
        }
    }
}
