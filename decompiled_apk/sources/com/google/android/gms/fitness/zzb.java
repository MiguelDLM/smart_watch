package com.google.android.gms.fitness;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.fitness.request.zzab;
import com.google.android.gms.fitness.request.zzbc;
import com.google.android.gms.internal.fitness.zzcd;
import com.google.android.gms.internal.fitness.zzcw;
import com.google.android.gms.internal.fitness.zzfb;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes9.dex */
final class zzb implements RemoteCall {
    final /* synthetic */ ListenerHolder zza;

    public zzb(BleClient bleClient, ListenerHolder listenerHolder) {
        this.zza = listenerHolder;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final /* bridge */ /* synthetic */ void accept(Object obj, Object obj2) throws RemoteException {
        com.google.android.gms.internal.fitness.zzm zzmVar = (com.google.android.gms.internal.fitness.zzm) obj;
        TaskCompletionSource taskCompletionSource = (TaskCompletionSource) obj2;
        com.google.android.gms.fitness.request.zze zzd = com.google.android.gms.fitness.request.zzc.zza().zzd(this.zza);
        if (zzd == null) {
            taskCompletionSource.setResult(Boolean.FALSE);
        } else {
            ((zzcd) zzmVar.getService()).zzg(new zzbc((zzab) zzd, (zzcw) zzfb.zze(taskCompletionSource)));
        }
    }
}
