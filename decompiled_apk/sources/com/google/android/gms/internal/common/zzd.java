package com.google.android.gms.internal.common;

import android.os.Build;

/* loaded from: classes9.dex */
public final class zzd {
    public static final int zza;

    static {
        zza = Build.VERSION.SDK_INT >= 23 ? 67108864 : 0;
    }
}
