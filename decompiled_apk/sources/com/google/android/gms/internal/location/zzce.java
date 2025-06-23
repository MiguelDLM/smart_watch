package com.google.android.gms.internal.location;

import java.util.concurrent.Executor;

/* loaded from: classes9.dex */
final /* synthetic */ class zzce implements Executor {
    static final /* synthetic */ zzce zza = new zzce();

    private /* synthetic */ zzce() {
    }

    @Override // java.util.concurrent.Executor
    public final /* synthetic */ void execute(Runnable runnable) {
        runnable.run();
    }
}
