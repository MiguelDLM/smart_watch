package com.kwad.components.ad.interstitial.d;

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
    public long jD = -1;
    public int jE = 0;

    public static void I(Context context) {
        String Mr = y.Mr();
        a aVar = new a();
        if (TextUtils.isEmpty(Mr)) {
            aVar.jE = 1;
            aVar.jD = System.currentTimeMillis();
            y.af(context, aVar.toJson().toString());
            return;
        }
        try {
            aVar.parseJson(new JSONObject(Mr));
            if (c(aVar.jD, System.currentTimeMillis())) {
                aVar.jE++;
            } else {
                aVar.jE = 1;
                aVar.jD = System.currentTimeMillis();
            }
            y.af(context, aVar.toJson().toString());
        } catch (Exception e) {
            c.printStackTrace(e);
        }
    }

    private static boolean c(long j, long j2) {
        if (j > 0 && j2 > 0) {
            try {
                return gL.format(new Date(j)).equals(gL.format(new Date(j2)));
            } catch (Exception e) {
                c.printStackTrace(e);
            }
        }
        return false;
    }

    public static int cO() {
        String Mr = y.Mr();
        if (TextUtils.isEmpty(Mr)) {
            return 0;
        }
        a aVar = new a();
        try {
            aVar.parseJson(new JSONObject(Mr));
            if (!c(aVar.jD, System.currentTimeMillis())) {
                return 0;
            }
            return aVar.jE;
        } catch (Exception e) {
            c.printStackTrace(e);
            return 0;
        }
    }
}
