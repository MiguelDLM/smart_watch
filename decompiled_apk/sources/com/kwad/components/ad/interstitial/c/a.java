package com.kwad.components.ad.interstitial.c;

import android.content.Context;
import android.text.TextUtils;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.utils.y;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;

@KsJson
/* loaded from: classes11.dex */
public class a extends com.kwad.sdk.core.response.a.a {
    private static SimpleDateFormat gL = new SimpleDateFormat("yyyy-MM-dd");
    public long gM = -1;
    public int jA = 0;

    public static void G(Context context) {
        String Mn = y.Mn();
        a aVar = new a();
        if (TextUtils.isEmpty(Mn)) {
            aVar.jA = 1;
            aVar.gM = System.currentTimeMillis();
            y.aa(context, aVar.toJson().toString());
            return;
        }
        try {
            aVar.parseJson(new JSONObject(Mn));
            if (c(aVar.gM, System.currentTimeMillis())) {
                aVar.jA++;
            } else {
                aVar.jA = 1;
                aVar.gM = System.currentTimeMillis();
            }
            y.aa(context, aVar.toJson().toString());
        } catch (Exception e) {
            c.printStackTraceOnly(e);
        }
    }

    private static boolean c(long j, long j2) {
        if (j > 0 && j2 > 0) {
            try {
                return gL.format(new Date(j)).equals(gL.format(new Date(j2)));
            } catch (Exception e) {
                c.printStackTraceOnly(e);
            }
        }
        return false;
    }

    public static int cM() {
        String Mn = y.Mn();
        if (TextUtils.isEmpty(Mn)) {
            return 0;
        }
        a aVar = new a();
        try {
            aVar.parseJson(new JSONObject(Mn));
            if (!c(aVar.gM, System.currentTimeMillis())) {
                return 0;
            }
            return aVar.jA;
        } catch (Exception e) {
            c.printStackTraceOnly(e);
            return 0;
        }
    }
}
