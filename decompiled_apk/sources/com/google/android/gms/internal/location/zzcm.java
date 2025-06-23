package com.google.android.gms.internal.location;

import java.util.concurrent.Executor;

/* loaded from: classes9.dex */
final /* synthetic */ class zzcm implements Executor {
    static final /* synthetic */ zzcm zza = new zzcm();

    private /* synthetic */ zzcm() {
    }

    @Override // java.util.concurrent.Executor
    public final /* synthetic */ void execute(Runnable runnable) {
        runnable.run();
    }
}
