package com.kwad.components.ad.fullscreen.b;

import android.content.Context;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class a {
    public static void E(Context context) {
        b F = F(context);
        long currentTimeMillis = System.currentTimeMillis();
        if (F == null) {
            F = new b(currentTimeMillis, 1);
        } else if (!F.f(currentTimeMillis)) {
            F.gM = currentTimeMillis;
            F.gN = 1;
        } else {
            F.gN++;
        }
        a(context, F);
    }

    @Nullable
    private static b F(Context context) {
        if (context == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(context.getSharedPreferences("ksadsdk_fullscreen_local_ad_count", 0).getString("key_local_info", null));
            b bVar = new b();
            bVar.parseJson(jSONObject);
            return bVar;
        } catch (Exception e) {
            c.printStackTraceOnly(e);
            return null;
        }
    }

    public static boolean a(Context context, AdTemplate adTemplate) {
        b F = F(context);
        return (F == null || !F.w(com.kwad.components.ad.fullscreen.a.b.bO())) && com.kwad.sdk.core.response.b.b.di(adTemplate);
    }

    private static void a(Context context, b bVar) {
        if (context != null && bVar != null) {
            context.getSharedPreferences("ksadsdk_fullscreen_local_ad_count", 0).edit().putString("key_local_info", bVar.toJson().toString()).apply();
        } else {
            c.d("FullScreenLocalHelper", "saveFullScreenLocalInfo illegal arguments.");
        }
    }
}
