package com.airbnb.lottie;

import IIXOooo.XO;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class IXxxXO<T> {

    /* renamed from: X0o0xo  reason: collision with root package name */
    public static Executor f777X0o0xo = Executors.newCachedThreadPool();

    /* renamed from: I0Io  reason: collision with root package name */
    public final Handler f778I0Io;

    /* renamed from: II0xO0  reason: collision with root package name */
    public final Set<oOoXoXO<Throwable>> f779II0xO0;

    /* renamed from: oIX0oI  reason: collision with root package name */
    public final Set<oOoXoXO<T>> f780oIX0oI;
    @Nullable

    /* renamed from: oxoX  reason: collision with root package name */
    public volatile x0xO0oo<T> f781oxoX;

    public class II0xO0 extends FutureTask<x0xO0oo<T>> {
        public II0xO0(Callable<x0xO0oo<T>> callable) {
            super(callable);
        }

        public void done() {
            if (!isCancelled()) {
                try {
                    IXxxXO.this.oOoXoXO((x0xO0oo) get());
                } catch (InterruptedException | ExecutionException e) {
                    IXxxXO.this.oOoXoXO(new x0xO0oo(e));
                }
            }
        }
    }

    public class oIX0oI implements Runnable {
        public oIX0oI() {
        }

        public void run() {
            if (IXxxXO.this.f781oxoX != null) {
                x0xO0oo oIX0oI2 = IXxxXO.this.f781oxoX;
                if (oIX0oI2.II0xO0() != null) {
                    IXxxXO.this.xxIXOIIO(oIX0oI2.II0xO0());
                } else {
                    IXxxXO.this.Oxx0IOOO(oIX0oI2.oIX0oI());
                }
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public IXxxXO(Callable<x0xO0oo<T>> callable) {
        this(callable, false);
    }

    public final void II0XooXoX() {
        this.f778I0Io.post(new oIX0oI());
    }

    public synchronized IXxxXO<T> OOXIXo(oOoXoXO<T> oooxoxo) {
        this.f780oIX0oI.remove(oooxoxo);
        return this;
    }

    public final synchronized void Oxx0IOOO(Throwable th) {
        ArrayList<oOoXoXO> arrayList = new ArrayList<>(this.f779II0xO0);
        if (arrayList.isEmpty()) {
            XO.XO("Lottie encountered an error but no failure listener was added:", th);
            return;
        }
        for (oOoXoXO onResult : arrayList) {
            onResult.onResult(th);
        }
    }

    public synchronized IXxxXO<T> X0o0xo(oOoXoXO<Throwable> oooxoxo) {
        try {
            if (!(this.f781oxoX == null || this.f781oxoX.oIX0oI() == null)) {
                oooxoxo.onResult(this.f781oxoX.oIX0oI());
            }
            this.f779II0xO0.add(oooxoxo);
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return this;
    }

    public synchronized IXxxXO<T> XO(oOoXoXO<T> oooxoxo) {
        try {
            if (!(this.f781oxoX == null || this.f781oxoX.II0xO0() == null)) {
                oooxoxo.onResult(this.f781oxoX.II0xO0());
            }
            this.f780oIX0oI.add(oooxoxo);
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return this;
    }

    public final void oOoXoXO(@Nullable x0xO0oo<T> x0xo0oo) {
        if (this.f781oxoX == null) {
            this.f781oxoX = x0xo0oo;
            II0XooXoX();
            return;
        }
        throw new IllegalStateException("A task may only be set once.");
    }

    public synchronized IXxxXO<T> xoIox(oOoXoXO<Throwable> oooxoxo) {
        this.f779II0xO0.remove(oooxoxo);
        return this;
    }

    public final synchronized void xxIXOIIO(T t) {
        for (oOoXoXO onResult : new ArrayList(this.f780oIX0oI)) {
            onResult.onResult(t);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public IXxxXO(Callable<x0xO0oo<T>> callable, boolean z) {
        this.f780oIX0oI = new LinkedHashSet(1);
        this.f779II0xO0 = new LinkedHashSet(1);
        this.f778I0Io = new Handler(Looper.getMainLooper());
        this.f781oxoX = null;
        if (z) {
            try {
                oOoXoXO(callable.call());
            } catch (Throwable th) {
                oOoXoXO(new x0xO0oo(th));
            }
        } else {
            f777X0o0xo.execute(new II0xO0(callable));
        }
    }
}
