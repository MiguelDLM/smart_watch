package com.google.android.gms.internal.auth;

/* loaded from: classes9.dex */
final class zzhb extends zzgz {
    @Override // com.google.android.gms.internal.auth.zzgz
    public final /* bridge */ /* synthetic */ Object zza(Object obj) {
        zzev zzevVar = (zzev) obj;
        zzha zzhaVar = zzevVar.zzc;
        if (zzhaVar == zzha.zza()) {
            zzha zzd = zzha.zzd();
            zzevVar.zzc = zzd;
            return zzd;
        }
        return zzhaVar;
    }

    @Override // com.google.android.gms.internal.auth.zzgz
    public final /* synthetic */ Object zzb(Object obj) {
        return ((zzev) obj).zzc;
    }

    @Override // com.google.android.gms.internal.auth.zzgz
    public final /* bridge */ /* synthetic */ Object zzc(Object obj, Object obj2) {
        if (!zzha.zza().equals(obj2)) {
            if (zzha.zza().equals(obj)) {
                return zzha.zzc((zzha) obj, (zzha) obj2);
            }
            ((zzha) obj).zzb((zzha) obj2);
            return obj;
        }
        return obj;
    }

    @Override // com.google.android.gms.internal.auth.zzgz
    public final /* bridge */ /* synthetic */ void zzd(Object obj, int i, long j) {
        ((zzha) obj).zzh(i << 3, Long.valueOf(j));
    }

    @Override // com.google.android.gms.internal.auth.zzgz
    public final void zze(Object obj) {
        ((zzev) obj).zzc.zzf();
    }

    @Override // com.google.android.gms.internal.auth.zzgz
    public final /* synthetic */ void zzf(Object obj, Object obj2) {
        ((zzev) obj).zzc = (zzha) obj2;
    }
}
