package kotlinx.coroutines.sync;

import OXOo.OOXIXo;
import kotlin.jvm.internal.xxX;
import kotlinx.coroutines.internal.x0o;

/* loaded from: classes6.dex */
public final class MutexKt {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final int f30441I0Io = 0;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f30442II0XooXoX = 2;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final int f30444Oxx0IOOO = 1;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final int f30445X0o0xo = 2;

    /* renamed from: XO, reason: collision with root package name */
    public static final int f30446XO = 0;

    /* renamed from: oxoX, reason: collision with root package name */
    public static final int f30448oxoX = 1;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OOXIXo
    public static final x0o f30447oIX0oI = new x0o("NO_OWNER");

    /* renamed from: II0xO0, reason: collision with root package name */
    @OOXIXo
    public static final x0o f30443II0xO0 = new x0o("ALREADY_LOCKED_BY_OWNER");

    public static /* synthetic */ oIX0oI II0xO0(boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return oIX0oI(z);
    }

    public static /* synthetic */ Object Oxx0IOOO(oIX0oI oix0oi, Object obj, Oox.oIX0oI oix0oi2, kotlin.coroutines.I0Io i0Io, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = null;
        }
        xxX.X0o0xo(0);
        oix0oi.II0XooXoX(obj, i0Io);
        xxX.X0o0xo(1);
        try {
            return oix0oi2.invoke();
        } finally {
            xxX.oxoX(1);
            oix0oi.xxIXOIIO(obj);
            xxX.I0Io(1);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @OXOo.oOoXoXO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <T> java.lang.Object X0o0xo(@OXOo.OOXIXo kotlinx.coroutines.sync.oIX0oI r4, @OXOo.oOoXoXO java.lang.Object r5, @OXOo.OOXIXo Oox.oIX0oI<? extends T> r6, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super T> r7) {
        /*
            boolean r0 = r7 instanceof kotlinx.coroutines.sync.MutexKt$withLock$1
            if (r0 == 0) goto L13
            r0 = r7
            kotlinx.coroutines.sync.MutexKt$withLock$1 r0 = (kotlinx.coroutines.sync.MutexKt$withLock$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.sync.MutexKt$withLock$1 r0 = new kotlinx.coroutines.sync.MutexKt$withLock$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r4 = r0.L$2
            r6 = r4
            Oox.oIX0oI r6 = (Oox.oIX0oI) r6
            java.lang.Object r5 = r0.L$1
            java.lang.Object r4 = r0.L$0
            kotlinx.coroutines.sync.oIX0oI r4 = (kotlinx.coroutines.sync.oIX0oI) r4
            kotlin.I0oOoX.x0XOIxOo(r7)
            goto L4e
        L34:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3c:
            kotlin.I0oOoX.x0XOIxOo(r7)
            r0.L$0 = r4
            r0.L$1 = r5
            r0.L$2 = r6
            r0.label = r3
            java.lang.Object r7 = r4.II0XooXoX(r5, r0)
            if (r7 != r1) goto L4e
            return r1
        L4e:
            java.lang.Object r6 = r6.invoke()     // Catch: java.lang.Throwable -> L5c
            kotlin.jvm.internal.xxX.oxoX(r3)
            r4.xxIXOIIO(r5)
            kotlin.jvm.internal.xxX.I0Io(r3)
            return r6
        L5c:
            r6 = move-exception
            kotlin.jvm.internal.xxX.oxoX(r3)
            r4.xxIXOIIO(r5)
            kotlin.jvm.internal.xxX.I0Io(r3)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.sync.MutexKt.X0o0xo(kotlinx.coroutines.sync.oIX0oI, java.lang.Object, Oox.oIX0oI, kotlin.coroutines.I0Io):java.lang.Object");
    }

    public static final <T> Object XO(oIX0oI oix0oi, Object obj, Oox.oIX0oI<? extends T> oix0oi2, kotlin.coroutines.I0Io<? super T> i0Io) {
        xxX.X0o0xo(0);
        oix0oi.II0XooXoX(obj, i0Io);
        xxX.X0o0xo(1);
        try {
            return oix0oi2.invoke();
        } finally {
            xxX.oxoX(1);
            oix0oi.xxIXOIIO(obj);
            xxX.I0Io(1);
        }
    }

    @OOXIXo
    public static final oIX0oI oIX0oI(boolean z) {
        return new MutexImpl(z);
    }
}
