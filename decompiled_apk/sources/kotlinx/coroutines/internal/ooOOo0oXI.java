package kotlinx.coroutines.internal;

import java.util.concurrent.CancellationException;
import kotlin.Result;
import kotlin.coroutines.CoroutineContext;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.IO0XoXxO;
import kotlinx.coroutines.OX00O0xII;
import kotlinx.coroutines.Oxx;
import kotlinx.coroutines.x0xO;

@kotlin.jvm.internal.XX({"SMAP\nDispatchedContinuation.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DispatchedContinuation.kt\nkotlinx/coroutines/internal/DispatchedContinuationKt\n+ 2 DispatchedContinuation.kt\nkotlinx/coroutines/internal/DispatchedContinuation\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 DispatchedTask.kt\nkotlinx/coroutines/DispatchedTaskKt\n+ 5 CoroutineContext.kt\nkotlinx/coroutines/CoroutineContextKt\n*L\n1#1,317:1\n297#1,5:325\n302#1,12:331\n314#1:387\n301#1:389\n302#1,12:391\n314#1:420\n217#2,7:318\n224#2:346\n243#2,8:347\n225#2:355\n255#2:356\n256#2,2:367\n258#2:371\n227#2:372\n229#2:388\n1#3:330\n1#3:390\n1#3:421\n200#4,3:343\n203#4,14:373\n200#4,17:403\n200#4,17:422\n107#5,10:357\n118#5,2:369\n*S KotlinDebug\n*F\n+ 1 DispatchedContinuation.kt\nkotlinx/coroutines/internal/DispatchedContinuationKt\n*L\n282#1:325,5\n282#1:331,12\n282#1:387\n287#1:389\n287#1:391,12\n287#1:420\n282#1:318,7\n282#1:346\n282#1:347,8\n282#1:355\n282#1:356\n282#1:367,2\n282#1:371\n282#1:372\n282#1:388\n282#1:330\n287#1:390\n282#1:343,3\n282#1:373,14\n287#1:403,17\n313#1:422,17\n282#1:357,10\n282#1:369,2\n*E\n"})
/* loaded from: classes6.dex */
public final class ooOOo0oXI {

    /* renamed from: oIX0oI */
    @OXOo.OOXIXo
    public static final x0o f30304oIX0oI = new x0o("UNDEFINED");

    /* renamed from: II0xO0 */
    @OXOo.OOXIXo
    @XO0OX.XO
    public static final x0o f30303II0xO0 = new x0o("REUSABLE_CLAIMED");

    public static /* synthetic */ boolean I0Io(oOoXoXO oooxoxo, Object obj, int i, boolean z, Oox.oIX0oI oix0oi, int i2, Object obj2) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        x0xO II0xO02 = IO0XoXxO.f29694oIX0oI.II0xO0();
        if (z && II0xO02.Xx000oIo()) {
            return false;
        }
        if (II0xO02.oo0xXOI0I()) {
            oooxoxo.f30301OxxIIOOXO = obj;
            oooxoxo.f29778IXxxXO = i;
            II0xO02.X0IIOO(oooxoxo);
            return true;
        }
        II0xO02.xxX(true);
        try {
            oix0oi.invoke();
            do {
            } while (II0xO02.IO());
            kotlin.jvm.internal.xxX.oxoX(1);
        } catch (Throwable th) {
            try {
                oooxoxo.xxIXOIIO(th, null);
                kotlin.jvm.internal.xxX.oxoX(1);
            } catch (Throwable th2) {
                kotlin.jvm.internal.xxX.oxoX(1);
                II0xO02.IIXOooo(true);
                kotlin.jvm.internal.xxX.I0Io(1);
                throw th2;
            }
        }
        II0xO02.IIXOooo(true);
        kotlin.jvm.internal.xxX.I0Io(1);
        return false;
    }

    public static final boolean II0xO0(oOoXoXO<?> oooxoxo, Object obj, int i, boolean z, Oox.oIX0oI<oXIO0o0XI> oix0oi) {
        x0xO II0xO02 = IO0XoXxO.f29694oIX0oI.II0xO0();
        if (z && II0xO02.Xx000oIo()) {
            return false;
        }
        if (II0xO02.oo0xXOI0I()) {
            oooxoxo.f30301OxxIIOOXO = obj;
            oooxoxo.f29778IXxxXO = i;
            II0xO02.X0IIOO(oooxoxo);
            return true;
        }
        II0xO02.xxX(true);
        try {
            oix0oi.invoke();
            do {
            } while (II0xO02.IO());
            kotlin.jvm.internal.xxX.oxoX(1);
        } catch (Throwable th) {
            try {
                oooxoxo.xxIXOIIO(th, null);
                kotlin.jvm.internal.xxX.oxoX(1);
            } catch (Throwable th2) {
                kotlin.jvm.internal.xxX.oxoX(1);
                II0xO02.IIXOooo(true);
                kotlin.jvm.internal.xxX.I0Io(1);
                throw th2;
            }
        }
        II0xO02.IIXOooo(true);
        kotlin.jvm.internal.xxX.I0Io(1);
        return false;
    }

    public static /* synthetic */ void X0o0xo(kotlin.coroutines.I0Io i0Io, Object obj, Oox.oOoXoXO oooxoxo, int i, Object obj2) {
        if ((i & 2) != 0) {
            oooxoxo = null;
        }
        oxoX(i0Io, obj, oooxoxo);
    }

    public static final boolean XO(@OXOo.OOXIXo oOoXoXO<? super oXIO0o0XI> oooxoxo) {
        oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
        x0xO II0xO02 = IO0XoXxO.f29694oIX0oI.II0xO0();
        if (II0xO02.Xx000oIo()) {
            return false;
        }
        if (II0xO02.oo0xXOI0I()) {
            oooxoxo.f30301OxxIIOOXO = oxio0o0xi;
            oooxoxo.f29778IXxxXO = 1;
            II0xO02.X0IIOO(oooxoxo);
            return true;
        }
        II0xO02.xxX(true);
        try {
            oooxoxo.run();
            do {
            } while (II0xO02.IO());
        } finally {
            try {
                return false;
            } finally {
            }
        }
        return false;
    }

    public static final /* synthetic */ x0o oIX0oI() {
        return f30304oIX0oI;
    }

    @OX00O0xII
    public static final <T> void oxoX(@OXOo.OOXIXo kotlin.coroutines.I0Io<? super T> i0Io, @OXOo.OOXIXo Object obj, @OXOo.oOoXoXO Oox.oOoXoXO<? super Throwable, oXIO0o0XI> oooxoxo) {
        Oxx<?> oxx;
        if (i0Io instanceof oOoXoXO) {
            oOoXoXO oooxoxo2 = (oOoXoXO) i0Io;
            Object II0xO02 = kotlinx.coroutines.xI.II0xO0(obj, oooxoxo);
            if (oooxoxo2.f30300Oxx0xo.isDispatchNeeded(oooxoxo2.getContext())) {
                oooxoxo2.f30301OxxIIOOXO = II0xO02;
                oooxoxo2.f29778IXxxXO = 1;
                oooxoxo2.f30300Oxx0xo.dispatch(oooxoxo2.getContext(), oooxoxo2);
                return;
            }
            x0xO II0xO03 = IO0XoXxO.f29694oIX0oI.II0xO0();
            if (II0xO03.oo0xXOI0I()) {
                oooxoxo2.f30301OxxIIOOXO = II0xO02;
                oooxoxo2.f29778IXxxXO = 1;
                II0xO03.X0IIOO(oooxoxo2);
                return;
            }
            II0xO03.xxX(true);
            try {
                kotlinx.coroutines.oXIO0o0XI oxio0o0xi = (kotlinx.coroutines.oXIO0o0XI) oooxoxo2.getContext().get(kotlinx.coroutines.oXIO0o0XI.f30343xxIXOIIO);
                if (oxio0o0xi != null && !oxio0o0xi.isActive()) {
                    CancellationException xI2 = oxio0o0xi.xI();
                    oooxoxo2.oxoX(II0xO02, xI2);
                    Result.oIX0oI oix0oi = Result.Companion;
                    oooxoxo2.resumeWith(Result.m287constructorimpl(kotlin.I0oOoX.oIX0oI(xI2)));
                } else {
                    kotlin.coroutines.I0Io<T> i0Io2 = oooxoxo2.f30302oI0IIXIo;
                    Object obj2 = oooxoxo2.f30299IIXOooo;
                    CoroutineContext context = i0Io2.getContext();
                    Object I0Io2 = ThreadContextKt.I0Io(context, obj2);
                    if (I0Io2 != ThreadContextKt.f30273oIX0oI) {
                        oxx = CoroutineContextKt.Oxx0IOOO(i0Io2, context, I0Io2);
                    } else {
                        oxx = null;
                    }
                    try {
                        oooxoxo2.f30302oI0IIXIo.resumeWith(obj);
                        oXIO0o0XI oxio0o0xi2 = oXIO0o0XI.f29392oIX0oI;
                    } finally {
                        if (oxx == null || oxx.OooI()) {
                            ThreadContextKt.oIX0oI(context, I0Io2);
                        }
                    }
                }
                do {
                } while (II0xO03.IO());
            } finally {
                try {
                    return;
                } finally {
                }
            }
            return;
        }
        i0Io.resumeWith(obj);
    }
}
