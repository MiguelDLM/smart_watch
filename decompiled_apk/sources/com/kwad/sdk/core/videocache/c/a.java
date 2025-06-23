package com.kwad.sdk.core.videocache.c;

import android.content.Context;
import com.garmin.fit.O0Xx;
import com.kwad.sdk.core.videocache.f;

/* loaded from: classes11.dex */
public final class a {
    private static f aDP;

    public static f b(Context context, int i, int i2) {
        f fVar = aDP;
        if (fVar == null) {
            f c = c(context, i, i2);
            aDP = c;
            return c;
        }
        return fVar;
    }

    public static f by(Context context) {
        return b(context, 0, 0);
    }

    private static f c(Context context, int i, int i2) {
        return new f.a(context).az(O0Xx.f12382xxX).ds(i).dt(i2).Hb();
    }
}
