package com.google.android.gms.internal.fitness;

import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.fitness.result.SessionStopResult;

/* loaded from: classes9.dex */
final class zzex extends zzcs {
    private final BaseImplementation.ResultHolder zza;

    @Override // com.google.android.gms.internal.fitness.zzct
    public final void zzd(SessionStopResult sessionStopResult) {
        this.zza.setResult(sessionStopResult);
    }
}
