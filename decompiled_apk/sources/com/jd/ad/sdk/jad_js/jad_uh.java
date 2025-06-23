package com.jd.ad.sdk.jad_js;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/* loaded from: classes10.dex */
public class jad_uh<T> {
    public static Executor jad_er = Executors.newCachedThreadPool();
    public final Set<jad_ob<T>> jad_an = new LinkedHashSet(1);
    public final Set<jad_ob<Throwable>> jad_bo = new LinkedHashSet(1);
    public final Handler jad_cp = new Handler(Looper.getMainLooper());

    @Nullable
    public volatile jad_sf<T> jad_dq = null;

    /* loaded from: classes10.dex */
    public class jad_an extends FutureTask<jad_sf<T>> {
        public jad_an(Callable<jad_sf<T>> callable) {
            super(callable);
        }

        @Override // java.util.concurrent.FutureTask
        public void done() {
            if (isCancelled()) {
                return;
            }
            try {
                jad_uh.this.jad_an(get());
            } catch (InterruptedException | ExecutionException e) {
                jad_uh.this.jad_an(new jad_sf<>(e));
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public jad_uh(Callable<jad_sf<T>> callable, boolean z) {
        if (!z) {
            jad_er.execute(new jad_an(callable));
            return;
        }
        try {
            jad_an(callable.call());
        } catch (Throwable th) {
            jad_an(new jad_sf<>(th));
        }
    }

    public synchronized jad_uh<T> jad_an(jad_ob<Throwable> jad_obVar) {
        try {
            if (this.jad_dq != null && this.jad_dq.jad_bo != null) {
                jad_obVar.jad_an(this.jad_dq.jad_bo);
            }
            this.jad_bo.add(jad_obVar);
        } catch (Throwable th) {
            throw th;
        }
        return this;
    }

    public synchronized jad_uh<T> jad_bo(jad_ob<T> jad_obVar) {
        try {
            if (this.jad_dq != null && this.jad_dq.jad_an != null) {
                jad_obVar.jad_an(this.jad_dq.jad_an);
            }
            this.jad_an.add(jad_obVar);
        } catch (Throwable th) {
            throw th;
        }
        return this;
    }

    public final void jad_an(@Nullable jad_sf<T> jad_sfVar) {
        if (this.jad_dq == null) {
            this.jad_dq = jad_sfVar;
            this.jad_cp.post(new jad_tg(this));
            return;
        }
        throw new IllegalStateException("A task may only be set once.");
    }
}
