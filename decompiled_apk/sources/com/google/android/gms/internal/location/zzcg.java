package com.google.android.gms.internal.location;

import java.util.concurrent.Executor;

/* loaded from: classes9.dex */
final /* synthetic */ class zzcg implements Executor {
    static final /* synthetic */ zzcg zza = new zzcg();

    private /* synthetic */ zzcg() {
    }

    @Override // java.util.concurrent.Executor
    public final /* synthetic */ void execute(Runnable runnable) {
        runnable.run();
    }
}
