package com.angcyo.dsladapter.internal;

import android.view.View;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.oXIO0o0XI;

/* loaded from: classes7.dex */
public class ThrottleClickListener implements View.OnClickListener {

    /* renamed from: IIXOooo, reason: collision with root package name */
    public static long f5395IIXOooo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Oox.oOoXoXO<View, oXIO0o0XI> f5398IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Oox.IXxxXO<Long, Long, View, Boolean> f5399Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public long f5400Oxx0xo;

    /* renamed from: XO, reason: collision with root package name */
    public long f5401XO;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final oIX0oI f5397oI0IIXIo = new oIX0oI(null);

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public static long f5396OxxIIOOXO = 400;

    /* loaded from: classes7.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(IIXOooo iIXOooo) {
            this();
        }

        public final void I0Io(long j) {
            ThrottleClickListener.f5396OxxIIOOXO = j;
        }

        public final long II0xO0() {
            return ThrottleClickListener.f5395IIXOooo;
        }

        public final long oIX0oI() {
            return ThrottleClickListener.f5396OxxIIOOXO;
        }

        public final void oxoX(long j) {
            ThrottleClickListener.f5395IIXOooo = j;
        }

        public oIX0oI() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ThrottleClickListener(long j, @OXOo.OOXIXo Oox.IXxxXO<? super Long, ? super Long, ? super View, Boolean> throttle, @OXOo.OOXIXo Oox.oOoXoXO<? super View, oXIO0o0XI> action) {
        IIX0o.x0xO0oo(throttle, "throttle");
        IIX0o.x0xO0oo(action, "action");
        this.f5401XO = j;
        this.f5399Oo = throttle;
        this.f5398IXxxXO = action;
    }

    public final long II0XooXoX() {
        return this.f5400Oxx0xo;
    }

    public final long Oxx0IOOO() {
        return this.f5401XO;
    }

    @OXOo.OOXIXo
    public final Oox.oOoXoXO<View, oXIO0o0XI> X0o0xo() {
        return this.f5398IXxxXO;
    }

    @OXOo.OOXIXo
    public final Oox.IXxxXO<Long, Long, View, Boolean> XO() {
        return this.f5399Oo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@OXOo.OOXIXo View v) {
        IIX0o.x0xO0oo(v, "v");
        long currentTimeMillis = System.currentTimeMillis();
        if (!this.f5399Oo.invoke(Long.valueOf(this.f5400Oxx0xo), Long.valueOf(currentTimeMillis), v).booleanValue()) {
            this.f5398IXxxXO.invoke(v);
            this.f5400Oxx0xo = currentTimeMillis;
        }
    }

    public final void xoIox(long j) {
        this.f5400Oxx0xo = j;
    }

    public final void xxIXOIIO(long j) {
        this.f5401XO = j;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ ThrottleClickListener(final long r1, Oox.IXxxXO r3, Oox.oOoXoXO r4, int r5, kotlin.jvm.internal.IIXOooo r6) {
        /*
            r0 = this;
            r6 = r5 & 1
            if (r6 == 0) goto L6
            long r1 = com.angcyo.dsladapter.internal.ThrottleClickListener.f5396OxxIIOOXO
        L6:
            r5 = r5 & 2
            if (r5 == 0) goto Lf
            com.angcyo.dsladapter.internal.ThrottleClickListener$1 r3 = new com.angcyo.dsladapter.internal.ThrottleClickListener$1
            r3.<init>()
        Lf:
            r0.<init>(r1, r3, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.angcyo.dsladapter.internal.ThrottleClickListener.<init>(long, Oox.IXxxXO, Oox.oOoXoXO, int, kotlin.jvm.internal.IIXOooo):void");
    }
}
