package kotlinx.coroutines.sync;

import OXOo.OOXIXo;
import kotlin.jvm.internal.xxX;
import kotlinx.coroutines.internal.I0oOoX;
import kotlinx.coroutines.internal.x0o;

/* loaded from: classes6.dex */
public final class SemaphoreKt {

    /* renamed from: I0Io, reason: collision with root package name */
    @OOXIXo
    public static final x0o f30456I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    @OOXIXo
    public static final x0o f30457II0xO0;

    /* renamed from: X0o0xo, reason: collision with root package name */
    @OOXIXo
    public static final x0o f30458X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public static final int f30459XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final int f30460oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    @OOXIXo
    public static final x0o f30461oxoX;

    static {
        int X0o0xo2;
        int X0o0xo3;
        X0o0xo2 = I0oOoX.X0o0xo("kotlinx.coroutines.semaphore.maxSpinCycles", 100, 0, 0, 12, null);
        f30460oIX0oI = X0o0xo2;
        f30457II0xO0 = new x0o("PERMIT");
        f30456I0Io = new x0o("TAKEN");
        f30461oxoX = new x0o("BROKEN");
        f30458X0o0xo = new x0o("CANCELLED");
        X0o0xo3 = I0oOoX.X0o0xo("kotlinx.coroutines.semaphore.segmentSize", 16, 0, 0, 12, null);
        f30459XO = X0o0xo3;
    }

    public static /* synthetic */ II0xO0 II0xO0(int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return oIX0oI(i, i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @OXOo.oOoXoXO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <T> java.lang.Object OOXIXo(@OXOo.OOXIXo kotlinx.coroutines.sync.II0xO0 r4, @OXOo.OOXIXo Oox.oIX0oI<? extends T> r5, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super T> r6) {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.sync.SemaphoreKt$withPermit$1
            if (r0 == 0) goto L13
            r0 = r6
            kotlinx.coroutines.sync.SemaphoreKt$withPermit$1 r0 = (kotlinx.coroutines.sync.SemaphoreKt$withPermit$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.sync.SemaphoreKt$withPermit$1 r0 = new kotlinx.coroutines.sync.SemaphoreKt$withPermit$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r4 = r0.L$1
            r5 = r4
            Oox.oIX0oI r5 = (Oox.oIX0oI) r5
            java.lang.Object r4 = r0.L$0
            kotlinx.coroutines.sync.II0xO0 r4 = (kotlinx.coroutines.sync.II0xO0) r4
            kotlin.I0oOoX.x0XOIxOo(r6)
            goto L4a
        L32:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3a:
            kotlin.I0oOoX.x0XOIxOo(r6)
            r0.L$0 = r4
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r6 = r4.I0Io(r0)
            if (r6 != r1) goto L4a
            return r1
        L4a:
            java.lang.Object r5 = r5.invoke()     // Catch: java.lang.Throwable -> L58
            kotlin.jvm.internal.xxX.oxoX(r3)
            r4.release()
            kotlin.jvm.internal.xxX.I0Io(r3)
            return r5
        L58:
            r5 = move-exception
            kotlin.jvm.internal.xxX.oxoX(r3)
            r4.release()
            kotlin.jvm.internal.xxX.I0Io(r3)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.sync.SemaphoreKt.OOXIXo(kotlinx.coroutines.sync.II0xO0, Oox.oIX0oI, kotlin.coroutines.I0Io):java.lang.Object");
    }

    @OOXIXo
    public static final II0xO0 oIX0oI(int i, int i2) {
        return new SemaphoreImpl(i, i2);
    }

    public static final <T> Object oOoXoXO(II0xO0 iI0xO0, Oox.oIX0oI<? extends T> oix0oi, kotlin.coroutines.I0Io<? super T> i0Io) {
        xxX.X0o0xo(0);
        iI0xO0.I0Io(i0Io);
        xxX.X0o0xo(1);
        try {
            return oix0oi.invoke();
        } finally {
            xxX.oxoX(1);
            iI0xO0.release();
            xxX.I0Io(1);
        }
    }

    public static final I0Io xoIox(long j, I0Io i0Io) {
        return new I0Io(j, i0Io, 0);
    }
}
