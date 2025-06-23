package com.google.android.gms.internal.auth;

import android.accounts.Account;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Status;

/* loaded from: classes9.dex */
final class zzad extends zzah {
    final /* synthetic */ zzae zza;

    public zzad(zzae zzaeVar) {
        this.zza = zzaeVar;
    }

    @Override // com.google.android.gms.internal.auth.zzah, com.google.android.gms.auth.account.zzb
    public final void zzb(@Nullable Account account) {
        Status status;
        zzae zzaeVar = this.zza;
        if (account != null) {
            status = Status.RESULT_SUCCESS;
        } else {
            status = zzal.zza;
        }
        zzaeVar.setResult((zzae) new zzai(status, account));
    }
}
