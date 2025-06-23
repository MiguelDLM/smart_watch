package com.google.android.gms.fitness;

import com.google.android.gms.fitness.result.DataReadResult;
import com.google.android.gms.fitness.result.LocalDataReadResponse;
import com.google.android.gms.internal.fitness.zzbs;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes9.dex */
final class zzs extends zzbs {
    final /* synthetic */ TaskCompletionSource zza;

    public zzs(LocalRecordingClient localRecordingClient, TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    @Override // com.google.android.gms.internal.fitness.zzbt
    public final void zzb(DataReadResult dataReadResult) {
        this.zza.trySetResult(new LocalDataReadResponse(dataReadResult));
    }
}
