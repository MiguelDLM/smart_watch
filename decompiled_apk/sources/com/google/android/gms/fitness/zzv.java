package com.google.android.gms.fitness;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.fitness.request.zzah;
import com.google.android.gms.fitness.request.zzaj;
import com.google.android.gms.fitness.request.zzao;
import com.google.android.gms.internal.fitness.zzbf;
import com.google.android.gms.internal.fitness.zzcj;
import com.google.android.gms.internal.fitness.zzcw;
import com.google.android.gms.internal.fitness.zzfb;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes9.dex */
final class zzv implements RemoteCall {
    final /* synthetic */ ListenerHolder zza;

    public zzv(SensorsClient sensorsClient, ListenerHolder listenerHolder) {
        this.zza = listenerHolder;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final /* bridge */ /* synthetic */ void accept(Object obj, Object obj2) throws RemoteException {
        zzbf zzbfVar = (zzbf) obj;
        TaskCompletionSource taskCompletionSource = (TaskCompletionSource) obj2;
        zzaj zzd = zzah.zza().zzd(this.zza);
        if (zzd == null) {
            taskCompletionSource.setResult(Boolean.FALSE);
        } else {
            ((zzcj) zzbfVar.getService()).zzf(new zzao((com.google.android.gms.fitness.data.zzv) zzd, (PendingIntent) null, (zzcw) zzfb.zze(taskCompletionSource)));
        }
    }
}
