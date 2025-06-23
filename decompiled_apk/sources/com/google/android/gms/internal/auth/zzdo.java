package com.google.android.gms.internal.auth;

import java.io.Serializable;

/* loaded from: classes9.dex */
public final class zzdo {
    public static zzdj zza(zzdj zzdjVar) {
        if (!(zzdjVar instanceof zzdm) && !(zzdjVar instanceof zzdk)) {
            if (zzdjVar instanceof Serializable) {
                return new zzdk(zzdjVar);
            }
            return new zzdm(zzdjVar);
        }
        return zzdjVar;
    }

    public static zzdj zzb(Object obj) {
        return new zzdn(obj);
    }
}
