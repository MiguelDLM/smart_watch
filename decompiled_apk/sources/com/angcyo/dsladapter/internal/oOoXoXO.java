package com.angcyo.dsladapter.internal;

import android.os.Handler;
import android.os.Looper;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.oXIO0o0XI;

/* loaded from: classes7.dex */
public final class oOoXoXO extends Handler {

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final int f5412Oxx0IOOO = 2;

    /* renamed from: X0o0xo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final oIX0oI f5413X0o0xo = new oIX0oI(null);

    /* renamed from: XO, reason: collision with root package name */
    public static final int f5414XO = 1;

    /* renamed from: I0Io, reason: collision with root package name */
    @OXOo.oOoXoXO
    public II0xO0 f5415I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.oOoXoXO
    public II0xO0 f5416II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public int f5417oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public long f5418oxoX;

    /* loaded from: classes7.dex */
    public final class II0xO0 implements Runnable {

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ oOoXoXO f5419Oo;

        /* renamed from: XO, reason: collision with root package name */
        @OXOo.OOXIXo
        public final Runnable f5420XO;

        public II0xO0(@OXOo.OOXIXo oOoXoXO oooxoxo, Runnable raw) {
            IIX0o.x0xO0oo(raw, "raw");
            this.f5419Oo = oooxoxo;
            this.f5420XO = raw;
        }

        @OXOo.OOXIXo
        public final Runnable oIX0oI() {
            return this.f5420XO;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f5419Oo.f5418oxoX = 0L;
            this.f5420XO.run();
            this.f5419Oo.I0Io();
        }
    }

    /* loaded from: classes7.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(IIXOooo iIXOooo) {
            this();
        }

        public oIX0oI() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public oOoXoXO() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ void OOXIXo(oOoXoXO oooxoxo, Runnable runnable, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        oooxoxo.II0XooXoX(runnable, j);
    }

    public static final void oOoXoXO(Oox.oIX0oI tmp0) {
        IIX0o.x0xO0oo(tmp0, "$tmp0");
        tmp0.invoke();
    }

    public static /* synthetic */ void xoIox(oOoXoXO oooxoxo, long j, Runnable runnable, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 0;
        }
        oooxoxo.Oxx0IOOO(j, runnable);
    }

    public static /* synthetic */ void xxIXOIIO(oOoXoXO oooxoxo, long j, Oox.oIX0oI oix0oi, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 0;
        }
        oooxoxo.XO(j, oix0oi);
    }

    public final void I0Io() {
        II0xO0 iI0xO0 = this.f5416II0xO0;
        if (iI0xO0 != null) {
            removeCallbacks(iI0xO0);
        }
        II0xO0 iI0xO02 = this.f5415I0Io;
        if (iI0xO02 != null) {
            removeCallbacks(iI0xO02);
        }
        this.f5416II0xO0 = null;
        this.f5415I0Io = null;
    }

    public final void II0XooXoX(@OXOo.OOXIXo Runnable runnable, long j) {
        IIX0o.x0xO0oo(runnable, "runnable");
        Oxx0IOOO(j, runnable);
    }

    public final void Oxx0IOOO(long j, @OXOo.OOXIXo Runnable runnable) {
        IIX0o.x0xO0oo(runnable, "runnable");
        I0Io();
        if (this.f5417oIX0oI == 1) {
            long currentTimeMillis = System.currentTimeMillis();
            long j2 = currentTimeMillis - this.f5418oxoX;
            if (j2 >= j) {
                if (!post(new II0xO0(this, runnable))) {
                    runnable.run();
                }
                this.f5418oxoX = currentTimeMillis;
                return;
            } else {
                II0xO0 iI0xO0 = new II0xO0(this, runnable);
                this.f5415I0Io = iI0xO0;
                postDelayed(iI0xO0, Math.max(j - j2, j));
                return;
            }
        }
        II0xO0 iI0xO02 = new II0xO0(this, runnable);
        this.f5416II0xO0 = iI0xO02;
        postDelayed(iI0xO02, j);
    }

    public final boolean X0o0xo() {
        if (this.f5416II0xO0 == null && this.f5415I0Io == null) {
            return false;
        }
        return true;
    }

    public final void XO(long j, @OXOo.OOXIXo final Oox.oIX0oI<oXIO0o0XI> run) {
        IIX0o.x0xO0oo(run, "run");
        Oxx0IOOO(j, new Runnable() { // from class: com.angcyo.dsladapter.internal.OOXIXo
            @Override // java.lang.Runnable
            public final void run() {
                oOoXoXO.oOoXoXO(Oox.oIX0oI.this);
            }
        });
    }

    public final void ooOOo0oXI(int i) {
        int i2 = this.f5417oIX0oI;
        this.f5417oIX0oI = i;
        if (i2 != i) {
            I0Io();
        }
    }

    public final int oxoX() {
        return this.f5417oIX0oI;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public oOoXoXO(@OXOo.OOXIXo Looper looper) {
        super(looper);
        IIX0o.x0xO0oo(looper, "looper");
        this.f5417oIX0oI = 2;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ oOoXoXO(android.os.Looper r1, int r2, kotlin.jvm.internal.IIXOooo r3) {
        /*
            r0 = this;
            r2 = r2 & 1
            if (r2 == 0) goto Ld
            android.os.Looper r1 = android.os.Looper.getMainLooper()
            java.lang.String r2 = "getMainLooper()"
            kotlin.jvm.internal.IIX0o.oO(r1, r2)
        Ld:
            r0.<init>(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.angcyo.dsladapter.internal.oOoXoXO.<init>(android.os.Looper, int, kotlin.jvm.internal.IIXOooo):void");
    }
}
