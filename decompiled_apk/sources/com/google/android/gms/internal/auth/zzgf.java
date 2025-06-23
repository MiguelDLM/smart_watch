package com.google.android.gms.internal.auth;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public final class zzgf {
    private static final zzgf zza = new zzgf();
    private final ConcurrentMap zzc = new ConcurrentHashMap();
    private final zzgj zzb = new zzfp();

    private zzgf() {
    }

    public static zzgf zza() {
        return zza;
    }

    public final zzgi zzb(Class cls) {
        zzfa.zzc(cls, "messageType");
        zzgi zzgiVar = (zzgi) this.zzc.get(cls);
        if (zzgiVar == null) {
            zzgiVar = this.zzb.zza(cls);
            zzfa.zzc(cls, "messageType");
            zzgi zzgiVar2 = (zzgi) this.zzc.putIfAbsent(cls, zzgiVar);
            if (zzgiVar2 != null) {
                return zzgiVar2;
            }
        }
        return zzgiVar;
    }
}
