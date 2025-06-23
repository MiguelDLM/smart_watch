package com.airbnb.lottie;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/* loaded from: classes.dex */
public class IXxxXO<T> {

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static Executor f4771X0o0xo = Executors.newCachedThreadPool();

    /* renamed from: I0Io, reason: collision with root package name */
    public final Handler f4772I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public final Set<oOoXoXO<Throwable>> f4773II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final Set<oOoXoXO<T>> f4774oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    @Nullable
    public volatile x0xO0oo<T> f4775oxoX;

    /* loaded from: classes.dex */
    public class II0xO0 extends FutureTask<x0xO0oo<T>> {
        public II0xO0(Callable<x0xO0oo<T>> callable) {
            super(callable);
        }

        @Override // java.util.concurrent.FutureTask
        public void done() {
            if (!isCancelled()) {
                try {
                    IXxxXO.this.oOoXoXO(get());
                } catch (InterruptedException | ExecutionException e) {
                    IXxxXO.this.oOoXoXO(new x0xO0oo(e));
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class oIX0oI implements Runnable {
        public oIX0oI() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (IXxxXO.this.f4775oxoX != null) {
                x0xO0oo x0xo0oo = IXxxXO.this.f4775oxoX;
                if (x0xo0oo.II0xO0() != null) {
                    IXxxXO.this.xxIXOIIO(x0xo0oo.II0xO0());
                } else {
                    IXxxXO.this.Oxx0IOOO(x0xo0oo.oIX0oI());
                }
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public IXxxXO(Callable<x0xO0oo<T>> callable) {
        this(callable, false);
    }

    public final void II0XooXoX() {
        this.f4772I0Io.post(new oIX0oI());
    }

    public synchronized IXxxXO<T> OOXIXo(oOoXoXO<T> oooxoxo) {
        this.f4774oIX0oI.remove(oooxoxo);
        return this;
    }

    public final synchronized void Oxx0IOOO(Throwable th) {
        ArrayList arrayList = new ArrayList(this.f4773II0xO0);
        if (arrayList.isEmpty()) {
            IIXOooo.XO.XO("Lottie encountered an error but no failure listener was added:", th);
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((oOoXoXO) it.next()).onResult(th);
        }
    }

    public synchronized IXxxXO<T> X0o0xo(oOoXoXO<Throwable> oooxoxo) {
        try {
            if (this.f4775oxoX != null && this.f4775oxoX.oIX0oI() != null) {
                oooxoxo.onResult(this.f4775oxoX.oIX0oI());
            }
            this.f4773II0xO0.add(oooxoxo);
        } catch (Throwable th) {
            throw th;
        }
        return this;
    }

    public synchronized IXxxXO<T> XO(oOoXoXO<T> oooxoxo) {
        try {
            if (this.f4775oxoX != null && this.f4775oxoX.II0xO0() != null) {
                oooxoxo.onResult(this.f4775oxoX.II0xO0());
            }
            this.f4774oIX0oI.add(oooxoxo);
        } catch (Throwable th) {
            throw th;
        }
        return this;
    }

    public final void oOoXoXO(@Nullable x0xO0oo<T> x0xo0oo) {
        if (this.f4775oxoX == null) {
            this.f4775oxoX = x0xo0oo;
            II0XooXoX();
            return;
        }
        throw new IllegalStateException("A task may only be set once.");
    }

    public synchronized IXxxXO<T> xoIox(oOoXoXO<Throwable> oooxoxo) {
        this.f4773II0xO0.remove(oooxoxo);
        return this;
    }

    public final synchronized void xxIXOIIO(T t) {
        Iterator it = new ArrayList(this.f4774oIX0oI).iterator();
        while (it.hasNext()) {
            ((oOoXoXO) it.next()).onResult(t);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public IXxxXO(Callable<x0xO0oo<T>> callable, boolean z) {
        this.f4774oIX0oI = new LinkedHashSet(1);
        this.f4773II0xO0 = new LinkedHashSet(1);
        this.f4772I0Io = new Handler(Looper.getMainLooper());
        this.f4775oxoX = null;
        if (z) {
            try {
                oOoXoXO(callable.call());
                return;
            } catch (Throwable th) {
                oOoXoXO(new x0xO0oo<>(th));
                return;
            }
        }
        f4771X0o0xo.execute(new II0xO0(callable));
    }
}
