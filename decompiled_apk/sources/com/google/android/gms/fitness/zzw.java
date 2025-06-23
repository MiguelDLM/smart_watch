package com.google.android.gms.fitness;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.fitness.request.SensorRequest;
import com.google.android.gms.fitness.request.zzah;
import com.google.android.gms.fitness.request.zzal;
import com.google.android.gms.internal.fitness.zzbf;
import com.google.android.gms.internal.fitness.zzcj;
import com.google.android.gms.internal.fitness.zzfb;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes9.dex */
final class zzw implements RemoteCall {
    final /* synthetic */ ListenerHolder zza;
    final /* synthetic */ SensorRequest zzb;

    public zzw(SensorsClient sensorsClient, ListenerHolder listenerHolder, SensorRequest sensorRequest) {
        this.zza = listenerHolder;
        this.zzb = sensorRequest;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final /* bridge */ /* synthetic */ void accept(Object obj, Object obj2) throws RemoteException {
        ((zzcj) ((zzbf) obj).getService()).zze(new zzal(this.zzb, zzah.zza().zzb(this.zza), null, zzfb.zzd((TaskCompletionSource) obj2)));
    }
}
