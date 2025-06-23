package com.google.android.gms.auth.api.accounttransfer;

import android.os.RemoteException;
import com.baidu.ar.auth.FeatureCodes;
import com.google.android.gms.internal.auth.zzau;
import com.google.android.gms.internal.auth.zzav;

/* loaded from: classes9.dex */
final class zzi extends zzn {
    final /* synthetic */ zzav zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzi(AccountTransferClient accountTransferClient, int i, zzav zzavVar) {
        super(FeatureCodes.BEAUTY_MAKEUP);
        this.zza = zzavVar;
    }

    @Override // com.google.android.gms.auth.api.accounttransfer.zzl
    public final void zza(zzau zzauVar) throws RemoteException {
        zzauVar.zzf(this.zzc, this.zza);
    }
}
