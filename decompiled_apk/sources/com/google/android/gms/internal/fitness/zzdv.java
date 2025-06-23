package com.google.android.gms.internal.fitness;

import com.google.android.gms.fitness.result.DailyTotalResult;

/* loaded from: classes9.dex */
final class zzdv extends zzbp {
    final /* synthetic */ zzdw zza;

    public zzdv(zzdw zzdwVar) {
        this.zza = zzdwVar;
    }

    @Override // com.google.android.gms.internal.fitness.zzbq
    public final void zzd(DailyTotalResult dailyTotalResult) {
        this.zza.setResult((zzdw) dailyTotalResult);
    }
}
