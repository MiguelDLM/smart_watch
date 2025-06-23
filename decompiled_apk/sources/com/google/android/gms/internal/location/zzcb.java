package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes9.dex */
final /* synthetic */ class zzcb implements RemoteCall {
    static final /* synthetic */ zzcb zza = new zzcb();

    private /* synthetic */ zzcb() {
    }

    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final /* synthetic */ void accept(Object obj, Object obj2) {
        ((zzdz) obj).zzy((TaskCompletionSource) obj2);
    }
}
