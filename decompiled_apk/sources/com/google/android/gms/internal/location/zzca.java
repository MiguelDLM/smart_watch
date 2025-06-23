package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes9.dex */
final /* synthetic */ class zzca implements RemoteCall {
    static final /* synthetic */ zzca zza = new zzca();

    private /* synthetic */ zzca() {
    }

    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final /* synthetic */ void accept(Object obj, Object obj2) {
        ((zzdz) obj).zzB((TaskCompletionSource) obj2);
    }
}
