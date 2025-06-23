package com.kwad.sdk.b;

import android.content.Context;
import com.kuaishou.weapon.p0.WeaponHI;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: classes11.dex */
public final class a {
    public static void init(Context context) {
        if (!com.kwad.framework.a.a.IV.booleanValue()) {
            return;
        }
        try {
            WeaponHI.init(context, new b());
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
