package com.google.android.gms.internal.fitness;

import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.fitness.result.BleDevicesResult;

/* loaded from: classes9.dex */
final class zzde extends zzfe {
    private final BaseImplementation.ResultHolder zza;

    @Override // com.google.android.gms.internal.fitness.zzff
    public final void zzb(BleDevicesResult bleDevicesResult) {
        this.zza.setResult(bleDevicesResult);
    }
}
