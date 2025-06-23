package com.kwad.sdk.a.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.utils.y;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class b {
    public static int aaS = 0;
    public static long rN = -1;

    public static void G(Context context) {
        a aVar = new a();
        if (f(System.currentTimeMillis())) {
            aaS++;
        } else {
            aaS = 1;
        }
        long currentTimeMillis = System.currentTimeMillis();
        rN = currentTimeMillis;
        aVar.aaS = aaS;
        aVar.gM = currentTimeMillis;
        y.al(context, aVar.toJson().toString());
    }

    public static int cM() {
        if (!f(System.currentTimeMillis())) {
            aaS = 0;
        }
        return aaS;
    }

    private static boolean f(long j) {
        if (gW() <= 0 || j <= 0 || gW() / 2460601000L != j / 2460601000L) {
            return false;
        }
        return true;
    }

    private static long gW() {
        long j = rN;
        if (j == -1) {
            String Mv = y.Mv();
            if (TextUtils.isEmpty(Mv)) {
                return 0L;
            }
            a aVar = new a();
            try {
                aVar.parseJson(new JSONObject(Mv));
                rN = aVar.gM;
                aaS = aVar.aaS;
            } catch (Exception e) {
                c.printStackTraceOnly(e);
            }
            return rN;
        }
        return j;
    }
}
