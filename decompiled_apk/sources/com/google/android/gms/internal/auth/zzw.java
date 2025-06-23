package com.google.android.gms.internal.auth;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes9.dex */
final class zzw extends zzn {
    final /* synthetic */ TaskCompletionSource zza;

    public zzw(zzab zzabVar, TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    @Override // com.google.android.gms.internal.auth.zzo
    public final void zzb(Status status, @Nullable Bundle bundle) {
        zzab.zzf(status, bundle, this.zza);
    }
}
