package oO0IXx;

import com.univocity.parsers.common.DataProcessingException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/* loaded from: classes13.dex */
public class ooOOo0oXI implements xxX {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public volatile I0Io f31946II0XooXoX;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public I0Io f31948Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public Future<Void> f31949X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public com.univocity.parsers.common.oO f31950XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final xxX f31951oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public long f31952oxoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    public boolean f31947II0xO0 = false;

    /* renamed from: I0Io, reason: collision with root package name */
    public final ExecutorService f31945I0Io = Executors.newSingleThreadExecutor();

    /* loaded from: classes13.dex */
    public static class I0Io {

        /* renamed from: II0xO0, reason: collision with root package name */
        public I0Io f31953II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final String[] f31954oIX0oI;

        public I0Io(String[] strArr) {
            this.f31954oIX0oI = strArr;
        }
    }

    /* loaded from: classes13.dex */
    public class II0xO0 implements Callable<Void> {
        public II0xO0() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
        public Void call() {
            while (ooOOo0oXI.this.f31946II0XooXoX == null && !ooOOo0oXI.this.f31947II0xO0) {
                Thread.yield();
            }
            while (!ooOOo0oXI.this.f31947II0xO0) {
                ooOOo0oXI.II0xO0(ooOOo0oXI.this);
                ooOOo0oXI.this.f31951oIX0oI.x0XOIxOo(ooOOo0oXI.this.f31946II0XooXoX.f31954oIX0oI, ooOOo0oXI.this.f31950XO);
                while (ooOOo0oXI.this.f31946II0XooXoX.f31953II0xO0 == null) {
                    if (ooOOo0oXI.this.f31947II0xO0 && ooOOo0oXI.this.f31946II0XooXoX.f31953II0xO0 == null) {
                        return null;
                    }
                }
                ooOOo0oXI ooooo0oxi = ooOOo0oXI.this;
                ooooo0oxi.f31946II0XooXoX = ooooo0oxi.f31946II0XooXoX.f31953II0xO0;
            }
            while (ooOOo0oXI.this.f31946II0XooXoX != null) {
                ooOOo0oXI.II0xO0(ooOOo0oXI.this);
                ooOOo0oXI.this.f31951oIX0oI.x0XOIxOo(ooOOo0oXI.this.f31946II0XooXoX.f31954oIX0oI, ooOOo0oXI.this.f31950XO);
                ooOOo0oXI ooooo0oxi2 = ooOOo0oXI.this;
                ooooo0oxi2.f31946II0XooXoX = ooooo0oxi2.f31946II0XooXoX.f31953II0xO0;
            }
            return null;
        }
    }

    /* loaded from: classes13.dex */
    public class oIX0oI extends com.univocity.parsers.common.x0xO0oo {
        public oIX0oI(com.univocity.parsers.common.oO oOVar) {
            super(oOVar);
        }

        @Override // com.univocity.parsers.common.x0xO0oo, com.univocity.parsers.common.oO
        public long xoIox() {
            return ooOOo0oXI.this.f31952oxoX;
        }
    }

    public ooOOo0oXI(xxX xxx2) {
        if (xxx2 != null) {
            this.f31951oIX0oI = xxx2;
            return;
        }
        throw new IllegalArgumentException("Row processor cannot be null");
    }

    public static /* synthetic */ long II0xO0(ooOOo0oXI ooooo0oxi) {
        long j = ooooo0oxi.f31952oxoX;
        ooooo0oxi.f31952oxoX = 1 + j;
        return j;
    }

    @Override // oO0IXx.xxX
    public final void XO(com.univocity.parsers.common.oO oOVar) {
        this.f31951oIX0oI.XO(oOVar);
        this.f31947II0xO0 = true;
        try {
            this.f31949X0o0xo.get();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        } catch (ExecutionException e) {
            throw new DataProcessingException("Error executing process", e);
        }
    }

    @Override // oO0IXx.xxX
    public final void oO(com.univocity.parsers.common.oO oOVar) {
        this.f31951oIX0oI.oO(oOVar);
        this.f31950XO = new oIX0oI(oOVar);
        xxIXOIIO();
    }

    @Override // oO0IXx.xxX
    public final void x0XOIxOo(String[] strArr, com.univocity.parsers.common.oO oOVar) {
        I0Io i0Io = this.f31948Oxx0IOOO;
        if (i0Io == null) {
            I0Io i0Io2 = new I0Io(strArr);
            this.f31948Oxx0IOOO = i0Io2;
            this.f31946II0XooXoX = i0Io2;
        } else {
            i0Io.f31953II0xO0 = new I0Io(strArr);
            this.f31948Oxx0IOOO = this.f31948Oxx0IOOO.f31953II0xO0;
        }
    }

    public final void xxIXOIIO() {
        this.f31947II0xO0 = false;
        this.f31952oxoX = 0L;
        this.f31949X0o0xo = this.f31945I0Io.submit(new II0xO0());
    }
}
