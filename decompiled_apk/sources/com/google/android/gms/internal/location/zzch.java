package com.google.android.gms.internal.location;

import java.util.concurrent.Executor;

/* loaded from: classes9.dex */
final /* synthetic */ class zzch implements Executor {
    static final /* synthetic */ zzch zza = new zzch();

    private /* synthetic */ zzch() {
    }

    @Override // java.util.concurrent.Executor
    public final /* synthetic */ void execute(Runnable runnable) {
        runnable.run();
    }
}
