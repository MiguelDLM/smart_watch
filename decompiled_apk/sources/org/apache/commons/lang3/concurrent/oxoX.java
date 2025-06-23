package org.apache.commons.lang3.concurrent;

import java.lang.Thread;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;
import org.apache.commons.lang3.xoIxX;

/* loaded from: classes6.dex */
public class oxoX implements ThreadFactory {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public final Thread.UncaughtExceptionHandler f32716IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public final ThreadFactory f32717Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public final String f32718Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public final Boolean f32719OxxIIOOXO;

    /* renamed from: XO, reason: collision with root package name */
    public final AtomicLong f32720XO;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public final Integer f32721oI0IIXIo;

    /* loaded from: classes6.dex */
    public static class II0xO0 implements org.apache.commons.lang3.builder.oIX0oI<oxoX> {

        /* renamed from: IXxxXO, reason: collision with root package name */
        public String f32722IXxxXO;

        /* renamed from: Oo, reason: collision with root package name */
        public Thread.UncaughtExceptionHandler f32723Oo;

        /* renamed from: Oxx0xo, reason: collision with root package name */
        public Integer f32724Oxx0xo;

        /* renamed from: XO, reason: collision with root package name */
        public ThreadFactory f32725XO;

        /* renamed from: oI0IIXIo, reason: collision with root package name */
        public Boolean f32726oI0IIXIo;

        public II0xO0 II0XooXoX(String str) {
            xoIxX.xo0x(str, "Naming pattern must not be null!", new Object[0]);
            this.f32722IXxxXO = str;
            return this;
        }

        public II0xO0 OOXIXo(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            xoIxX.xo0x(uncaughtExceptionHandler, "Uncaught exception handler must not be null!", new Object[0]);
            this.f32723Oo = uncaughtExceptionHandler;
            return this;
        }

        public II0xO0 Oxx0IOOO(boolean z) {
            this.f32726oI0IIXIo = Boolean.valueOf(z);
            return this;
        }

        @Override // org.apache.commons.lang3.builder.oIX0oI
        /* renamed from: XO, reason: merged with bridge method [inline-methods] */
        public oxoX build() {
            oxoX oxox = new oxoX(this);
            xoIox();
            return oxox;
        }

        public II0xO0 oOoXoXO(ThreadFactory threadFactory) {
            xoIxX.xo0x(threadFactory, "Wrapped ThreadFactory must not be null!", new Object[0]);
            this.f32725XO = threadFactory;
            return this;
        }

        public void xoIox() {
            this.f32725XO = null;
            this.f32723Oo = null;
            this.f32722IXxxXO = null;
            this.f32724Oxx0xo = null;
            this.f32726oI0IIXIo = null;
        }

        public II0xO0 xxIXOIIO(int i) {
            this.f32724Oxx0xo = Integer.valueOf(i);
            return this;
        }
    }

    public final Integer I0Io() {
        return this.f32721oI0IIXIo;
    }

    public final String II0xO0() {
        return this.f32718Oxx0xo;
    }

    public final void Oxx0IOOO(Thread thread) {
        if (II0xO0() != null) {
            thread.setName(String.format(II0xO0(), Long.valueOf(this.f32720XO.incrementAndGet())));
        }
        if (X0o0xo() != null) {
            thread.setUncaughtExceptionHandler(X0o0xo());
        }
        if (I0Io() != null) {
            thread.setPriority(I0Io().intValue());
        }
        if (oIX0oI() != null) {
            thread.setDaemon(oIX0oI().booleanValue());
        }
    }

    public final Thread.UncaughtExceptionHandler X0o0xo() {
        return this.f32716IXxxXO;
    }

    public final ThreadFactory XO() {
        return this.f32717Oo;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread newThread = XO().newThread(runnable);
        Oxx0IOOO(newThread);
        return newThread;
    }

    public final Boolean oIX0oI() {
        return this.f32719OxxIIOOXO;
    }

    public long oxoX() {
        return this.f32720XO.get();
    }

    public oxoX(II0xO0 iI0xO0) {
        if (iI0xO0.f32725XO != null) {
            this.f32717Oo = iI0xO0.f32725XO;
        } else {
            this.f32717Oo = Executors.defaultThreadFactory();
        }
        this.f32718Oxx0xo = iI0xO0.f32722IXxxXO;
        this.f32721oI0IIXIo = iI0xO0.f32724Oxx0xo;
        this.f32719OxxIIOOXO = iI0xO0.f32726oI0IIXIo;
        this.f32716IXxxXO = iI0xO0.f32723Oo;
        this.f32720XO = new AtomicLong();
    }
}
