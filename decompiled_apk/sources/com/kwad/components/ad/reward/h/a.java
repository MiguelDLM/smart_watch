package com.kwad.components.ad.reward.h;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.utils.y;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class a {
    public static long rN = -1;
    public static int rO;

    public static void G(Context context) {
        b bVar = new b();
        if (f(System.currentTimeMillis())) {
            rO++;
        } else {
            rO = 1;
        }
        long currentTimeMillis = System.currentTimeMillis();
        rN = currentTimeMillis;
        bVar.rP = rO;
        bVar.gM = currentTimeMillis;
        y.ac(context, bVar.toJson().toString());
    }

    public static int cM() {
        if (!f(System.currentTimeMillis())) {
            rO = 0;
        }
        return rO;
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
            String Mo = y.Mo();
            if (TextUtils.isEmpty(Mo)) {
                return 0L;
            }
            b bVar = new b();
            try {
                bVar.parseJson(new JSONObject(Mo));
                rN = bVar.gM;
                rO = bVar.rP;
            } catch (Exception e) {
                c.printStackTraceOnly(e);
            }
            return rN;
        }
        return j;
    }
}
