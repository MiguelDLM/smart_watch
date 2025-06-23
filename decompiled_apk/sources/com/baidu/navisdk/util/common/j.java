package com.baidu.navisdk.util.common;

import android.content.res.Configuration;
import kotlin.OOXIXo;

@OOXIXo(message = "pro navi user RGScreenConfigUtil.kt")
/* loaded from: classes8.dex */
public final class j {

    @OXOo.OOXIXo
    public static final j b = new j();

    /* renamed from: a, reason: collision with root package name */
    @OXOo.OOXIXo
    private static Configuration f9234a = new Configuration();

    private j() {
    }

    public final boolean a() {
        int i;
        boolean z;
        Configuration configuration = f9234a;
        int i2 = configuration.screenHeightDp;
        if (i2 == 0 || (i = configuration.screenWidthDp) == 0) {
            return false;
        }
        float f = i;
        float f2 = i2;
        float f3 = ((f * 1.0f) / f2) * 1.0f;
        float f4 = ((f2 * 1.0f) / f) * 1.0f;
        float a2 = com.baidu.navisdk.module.cloudconfig.a.b().a("wide_screen_scale", 0.8f);
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            StringBuilder sb = new StringBuilder();
            sb.append("isWideScreen = ");
            if (f3 >= a2 && f4 >= a2) {
                z = true;
            } else {
                z = false;
            }
            sb.append(z);
            sb.append(" screenWidthDp = ");
            sb.append(f9234a.screenWidthDp);
            sb.append(" screenHeightDp = ");
            sb.append(f9234a.screenHeightDp);
            sb.append(" portScale = ");
            sb.append(f3);
            sb.append(" landScale = ");
            sb.append(f4);
            gVar.e("BNWideScreenUtils", sb.toString());
        }
        if (f3 < a2 || f4 < a2) {
            return false;
        }
        return true;
    }
}
