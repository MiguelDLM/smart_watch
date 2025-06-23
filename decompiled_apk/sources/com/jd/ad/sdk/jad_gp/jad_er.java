package com.jd.ad.sdk.jad_gp;

import androidx.annotation.NonNull;
import java.util.concurrent.Executor;

/* loaded from: classes10.dex */
public final class jad_er {
    public static final Executor jad_an = new jad_an();
    public static final Executor jad_bo = new jad_bo();

    /* loaded from: classes10.dex */
    public class jad_an implements Executor {
        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable runnable) {
            jad_ly.jad_bo().post(runnable);
        }
    }

    /* loaded from: classes10.dex */
    public class jad_bo implements Executor {
        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable runnable) {
            runnable.run();
        }
    }
}
