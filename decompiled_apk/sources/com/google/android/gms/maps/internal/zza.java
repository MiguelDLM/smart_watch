package com.google.android.gms.maps.internal;

import androidx.annotation.Nullable;

/* loaded from: classes9.dex */
public final class zza {
    public static byte zza(@Nullable Boolean bool) {
        if (bool != null) {
            if (!bool.booleanValue()) {
                return (byte) 0;
            }
            return (byte) 1;
        }
        return (byte) -1;
    }

    @Nullable
    public static Boolean zzb(byte b) {
        if (b == 0) {
            return Boolean.FALSE;
        }
        if (b != 1) {
            return null;
        }
        return Boolean.TRUE;
    }
}
