package com.google.android.gms.internal.fitness;

import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.fitness.result.SessionReadResult;

/* loaded from: classes9.dex */
final class zzev extends zzcp {
    private final BaseImplementation.ResultHolder zza;

    @Override // com.google.android.gms.internal.fitness.zzcq
    public final void zzd(SessionReadResult sessionReadResult) {
        this.zza.setResult(sessionReadResult);
    }
}
