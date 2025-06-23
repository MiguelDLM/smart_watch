package com.google.android.gms.internal.fitness;

/* loaded from: classes9.dex */
final class zzfu extends zzfq {
    private final zzfw zza;

    public zzfu(zzfw zzfwVar, int i) {
        super(zzfwVar.size(), i);
        this.zza = zzfwVar;
    }

    @Override // com.google.android.gms.internal.fitness.zzfq
    public final Object zza(int i) {
        return this.zza.get(i);
    }
}
