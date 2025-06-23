package kotlinx.coroutines;

import kotlin.Result;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.ThreadContextKt;

@kotlin.jvm.internal.XX({"SMAP\nDispatchedTask.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DispatchedTask.kt\nkotlinx/coroutines/DispatchedTaskKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 DispatchedContinuation.kt\nkotlinx/coroutines/internal/DispatchedContinuation\n+ 4 CoroutineContext.kt\nkotlinx/coroutines/CoroutineContextKt\n+ 5 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n*L\n1#1,222:1\n200#1,17:240\n1#2:223\n255#3:224\n256#3,2:235\n258#3:239\n107#4,10:225\n118#4,2:237\n61#5,2:257\n*S KotlinDebug\n*F\n+ 1 DispatchedTask.kt\nkotlinx/coroutines/DispatchedTaskKt\n*L\n190#1:240,17\n178#1:224\n178#1:235,2\n178#1:239\n178#1:225,10\n178#1:237,2\n220#1:257,2\n*E\n"})
/* loaded from: classes6.dex */
public final class I0X0x0oIo {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final int f29684I0Io = 2;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final int f29685II0xO0 = 1;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final int f29686X0o0xo = -1;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final int f29687oIX0oI = 0;

    /* renamed from: oxoX, reason: collision with root package name */
    public static final int f29688oxoX = 4;

    public static final boolean I0Io(int i) {
        return i == 1 || i == 2;
    }

    public static final void II0XooXoX(@OXOo.OOXIXo XX0<?> xx02, @OXOo.OOXIXo x0xO x0xo, @OXOo.OOXIXo Oox.oIX0oI<kotlin.oXIO0o0XI> oix0oi) {
        x0xo.xxX(true);
        try {
            oix0oi.invoke();
            do {
            } while (x0xo.IO());
            kotlin.jvm.internal.xxX.oxoX(1);
        } catch (Throwable th) {
            try {
                xx02.xxIXOIIO(th, null);
                kotlin.jvm.internal.xxX.oxoX(1);
            } catch (Throwable th2) {
                kotlin.jvm.internal.xxX.oxoX(1);
                x0xo.IIXOooo(true);
                kotlin.jvm.internal.xxX.I0Io(1);
                throw th2;
            }
        }
        x0xo.IIXOooo(true);
        kotlin.jvm.internal.xxX.I0Io(1);
    }

    @kotlin.o0
    public static /* synthetic */ void II0xO0() {
    }

    public static final void Oxx0IOOO(@OXOo.OOXIXo kotlin.coroutines.I0Io<?> i0Io, @OXOo.OOXIXo Throwable th) {
        Result.oIX0oI oix0oi = Result.Companion;
        i0Io.resumeWith(Result.m287constructorimpl(kotlin.I0oOoX.oIX0oI(th)));
    }

    public static final <T> void X0o0xo(@OXOo.OOXIXo XX0<? super T> xx02, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super T> i0Io, boolean z) {
        Object Oxx0IOOO2;
        Oxx<?> oxx;
        boolean OooI2;
        Object xoIox2 = xx02.xoIox();
        Throwable XO2 = xx02.XO(xoIox2);
        if (XO2 != null) {
            Result.oIX0oI oix0oi = Result.Companion;
            Oxx0IOOO2 = kotlin.I0oOoX.oIX0oI(XO2);
        } else {
            Result.oIX0oI oix0oi2 = Result.Companion;
            Oxx0IOOO2 = xx02.Oxx0IOOO(xoIox2);
        }
        Object m287constructorimpl = Result.m287constructorimpl(Oxx0IOOO2);
        if (z) {
            kotlin.jvm.internal.IIX0o.x0XOIxOo(i0Io, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTaskKt.resume>");
            kotlinx.coroutines.internal.oOoXoXO oooxoxo = (kotlinx.coroutines.internal.oOoXoXO) i0Io;
            kotlin.coroutines.I0Io<T> i0Io2 = oooxoxo.f30302oI0IIXIo;
            Object obj = oooxoxo.f30299IIXOooo;
            CoroutineContext context = i0Io2.getContext();
            Object I0Io2 = ThreadContextKt.I0Io(context, obj);
            if (I0Io2 != ThreadContextKt.f30273oIX0oI) {
                oxx = CoroutineContextKt.Oxx0IOOO(i0Io2, context, I0Io2);
            } else {
                oxx = null;
            }
            try {
                oooxoxo.f30302oI0IIXIo.resumeWith(m287constructorimpl);
                kotlin.oXIO0o0XI oxio0o0xi = kotlin.oXIO0o0XI.f29392oIX0oI;
                if (oxx != null) {
                    if (!OooI2) {
                        return;
                    }
                }
                return;
            } finally {
                if (oxx == null || oxx.OooI()) {
                    ThreadContextKt.oIX0oI(context, I0Io2);
                }
            }
        }
        i0Io.resumeWith(m287constructorimpl);
    }

    public static final void XO(XX0<?> xx02) {
        x0xO II0xO02 = IO0XoXxO.f29694oIX0oI.II0xO0();
        if (II0xO02.oo0xXOI0I()) {
            II0xO02.X0IIOO(xx02);
            return;
        }
        II0xO02.xxX(true);
        try {
            X0o0xo(xx02, xx02.X0o0xo(), true);
            do {
            } while (II0xO02.IO());
        } finally {
            try {
            } finally {
            }
        }
    }

    public static final <T> void oIX0oI(@OXOo.OOXIXo XX0<? super T> xx02, int i) {
        boolean z;
        kotlin.coroutines.I0Io<? super T> X0o0xo2 = xx02.X0o0xo();
        if (i == 4) {
            z = true;
        } else {
            z = false;
        }
        if (!z && (X0o0xo2 instanceof kotlinx.coroutines.internal.oOoXoXO) && I0Io(i) == I0Io(xx02.f29778IXxxXO)) {
            CoroutineDispatcher coroutineDispatcher = ((kotlinx.coroutines.internal.oOoXoXO) X0o0xo2).f30300Oxx0xo;
            CoroutineContext context = X0o0xo2.getContext();
            if (coroutineDispatcher.isDispatchNeeded(context)) {
                coroutineDispatcher.dispatch(context, xx02);
                return;
            } else {
                XO(xx02);
                return;
            }
        }
        X0o0xo(xx02, X0o0xo2, z);
    }

    public static final boolean oxoX(int i) {
        return i == 2;
    }
}
