package com.google.android.gms.internal.auth;

/* loaded from: classes9.dex */
abstract class zzhl {
    public abstract int zza(int i, byte[] bArr, int i2, int i3);

    public final boolean zzb(byte[] bArr, int i, int i2) {
        if (zza(0, bArr, i, i2) != 0) {
            return false;
        }
        return true;
    }
}
