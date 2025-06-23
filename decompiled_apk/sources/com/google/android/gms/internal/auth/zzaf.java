package com.google.android.gms.internal.auth;

import com.google.android.gms.common.api.Status;

/* loaded from: classes9.dex */
final class zzaf extends zzah {
    final /* synthetic */ zzag zza;

    public zzaf(zzag zzagVar) {
        this.zza = zzagVar;
    }

    @Override // com.google.android.gms.internal.auth.zzah, com.google.android.gms.auth.account.zzb
    public final void zzc(boolean z) {
        Status status;
        zzag zzagVar = this.zza;
        if (z) {
            status = Status.RESULT_SUCCESS;
        } else {
            status = zzal.zza;
        }
        zzagVar.setResult((zzag) new zzak(status));
    }
}
