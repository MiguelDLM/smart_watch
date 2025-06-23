package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;

@kotlin.jvm.internal.XX({"SMAP\nDelay.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/DelayKt\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,162:1\n314#2,11:163\n314#2,11:174\n*S KotlinDebug\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/DelayKt\n*L\n106#1:163,11\n127#1:174,11\n*E\n"})
/* loaded from: classes6.dex */
public final class DelayKt {
    @OXOo.oOoXoXO
    public static final Object I0Io(long j, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super kotlin.oXIO0o0XI> i0Io) {
        Object II0xO02 = II0xO0(X0o0xo(j), i0Io);
        if (II0xO02 == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
            return II0xO02;
        }
        return kotlin.oXIO0o0XI.f29392oIX0oI;
    }

    @OXOo.oOoXoXO
    public static final Object II0xO0(long j, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super kotlin.oXIO0o0XI> i0Io) {
        if (j <= 0) {
            return kotlin.oXIO0o0XI.f29392oIX0oI;
        }
        x0xO0oo x0xo0oo = new x0xO0oo(IntrinsicsKt__IntrinsicsJvmKt.X0o0xo(i0Io), 1);
        x0xo0oo.IO();
        if (j < Long.MAX_VALUE) {
            oxoX(x0xo0oo.getContext()).OOXIXo(j, x0xo0oo);
        }
        Object o002 = x0xo0oo.o00();
        if (o002 == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
            IXIxx0.XO.I0Io(i0Io);
        }
        if (o002 == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
            return o002;
        }
        return kotlin.oXIO0o0XI.f29392oIX0oI;
    }

    public static final long X0o0xo(long j) {
        if (kotlin.time.oxoX.oOoXoXO(j, kotlin.time.oxoX.f29647Oo.XX()) > 0) {
            return X0.IIXOooo.IIXOooo(kotlin.time.oxoX.oOXoIIIo(j), 1L);
        }
        return 0L;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @OXOo.oOoXoXO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object oIX0oI(@OXOo.OOXIXo kotlin.coroutines.I0Io<?> r4) {
        /*
            boolean r0 = r4 instanceof kotlinx.coroutines.DelayKt$awaitCancellation$1
            if (r0 == 0) goto L13
            r0 = r4
            kotlinx.coroutines.DelayKt$awaitCancellation$1 r0 = (kotlinx.coroutines.DelayKt$awaitCancellation$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.DelayKt$awaitCancellation$1 r0 = new kotlinx.coroutines.DelayKt$awaitCancellation$1
            r0.<init>(r4)
        L18:
            java.lang.Object r4 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 == r3) goto L2d
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r0)
            throw r4
        L2d:
            kotlin.I0oOoX.x0XOIxOo(r4)
            goto L52
        L31:
            kotlin.I0oOoX.x0XOIxOo(r4)
            r0.label = r3
            kotlinx.coroutines.x0xO0oo r4 = new kotlinx.coroutines.x0xO0oo
            kotlin.coroutines.I0Io r2 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.X0o0xo(r0)
            r4.<init>(r2, r3)
            r4.IO()
            java.lang.Object r4 = r4.o00()
            java.lang.Object r2 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()
            if (r4 != r2) goto L4f
            IXIxx0.XO.I0Io(r0)
        L4f:
            if (r4 != r1) goto L52
            return r1
        L52:
            kotlin.KotlinNothingValueException r4 = new kotlin.KotlinNothingValueException
            r4.<init>()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.DelayKt.oIX0oI(kotlin.coroutines.I0Io):java.lang.Object");
    }

    @OXOo.OOXIXo
    public static final XoX oxoX(@OXOo.OOXIXo CoroutineContext coroutineContext) {
        XoX xoX2;
        CoroutineContext.oIX0oI oix0oi = coroutineContext.get(kotlin.coroutines.oxoX.f29196Oxx0IOOO);
        if (oix0oi instanceof XoX) {
            xoX2 = (XoX) oix0oi;
        } else {
            xoX2 = null;
        }
        if (xoX2 == null) {
            return XX.oIX0oI();
        }
        return xoX2;
    }
}
