package com.google.android.gms.fitness.service;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.result.DataSourcesResult;
import com.google.android.gms.internal.fitness.zzbw;
import com.google.android.gms.internal.fitness.zzcw;
import com.google.android.gms.internal.fitness.zzfg;
import com.google.android.gms.internal.fitness.zzfi;
import com.google.android.gms.internal.fitness.zzfk;

/* loaded from: classes9.dex */
final class zzb extends zzfk {
    private final FitnessSensorService zza;

    @Override // com.google.android.gms.internal.fitness.zzfl
    public final void zzb(zzfg zzfgVar, zzbw zzbwVar) throws RemoteException {
        this.zza.zza();
        zzbwVar.zzb(new DataSourcesResult(this.zza.onFindDataSources(zzfgVar.zza()), Status.RESULT_SUCCESS));
    }

    @Override // com.google.android.gms.internal.fitness.zzfl
    public final void zzc(FitnessSensorServiceRequest fitnessSensorServiceRequest, zzcw zzcwVar) throws RemoteException {
        this.zza.zza();
        if (this.zza.onRegister(fitnessSensorServiceRequest)) {
            zzcwVar.zzb(Status.RESULT_SUCCESS);
        } else {
            zzcwVar.zzb(new Status(13));
        }
    }

    @Override // com.google.android.gms.internal.fitness.zzfl
    public final void zzd(zzfi zzfiVar, zzcw zzcwVar) throws RemoteException {
        this.zza.zza();
        if (this.zza.onUnregister(zzfiVar.zza())) {
            zzcwVar.zzb(Status.RESULT_SUCCESS);
        } else {
            zzcwVar.zzb(new Status(13));
        }
    }
}
