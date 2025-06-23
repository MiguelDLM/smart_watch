package com.google.android.gms.common.util;

import android.os.Looper;

/* loaded from: classes9.dex */
public final class zzb {
    public static boolean zza() {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            return true;
        }
        return false;
    }
}
