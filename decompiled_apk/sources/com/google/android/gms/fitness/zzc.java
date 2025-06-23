package com.google.android.gms.fitness;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.fitness.request.StartBleScanRequest;
import com.google.android.gms.fitness.request.zzab;
import com.google.android.gms.internal.fitness.zzcd;
import com.google.android.gms.internal.fitness.zzcw;
import com.google.android.gms.internal.fitness.zzfb;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.List;

/* loaded from: classes9.dex */
final class zzc implements RemoteCall {
    final /* synthetic */ ListenerHolder zza;
    final /* synthetic */ List zzb;
    final /* synthetic */ int zzc;

    public zzc(BleClient bleClient, ListenerHolder listenerHolder, List list, int i) {
        this.zza = listenerHolder;
        this.zzb = list;
        this.zzc = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final /* bridge */ /* synthetic */ void accept(Object obj, Object obj2) throws RemoteException {
        com.google.android.gms.fitness.request.zze zzb = com.google.android.gms.fitness.request.zzc.zza().zzb(this.zza);
        zzfb zzd = zzfb.zzd((TaskCompletionSource) obj2);
        ((zzcd) ((com.google.android.gms.internal.fitness.zzm) obj).getService()).zzf(new StartBleScanRequest(this.zzb, (zzab) zzb, this.zzc, (zzcw) zzd));
    }
}
