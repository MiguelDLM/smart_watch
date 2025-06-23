package o0xIoII;

import IXIxx0.XO;
import OXOo.OOXIXo;
import Oox.oOoXoXO;
import Oox.x0xO0oo;
import kotlin.I0oOoX;
import kotlin.Result;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.I0Io;
import kotlin.jvm.internal.XX;
import kotlin.jvm.internal.XoX;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.internal.ThreadContextKt;
import kotlinx.coroutines.internal.Xx000oIo;
import kotlinx.coroutines.xI0oxI00;
import kotlinx.coroutines.xxX;

@XX({"SMAP\nUndispatched.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Undispatched.kt\nkotlinx/coroutines/intrinsics/UndispatchedKt\n+ 2 ProbesSupport.kt\nkotlinx/coroutines/internal/ProbesSupportKt\n+ 3 CoroutineContext.kt\nkotlinx/coroutines/CoroutineContextKt\n+ 4 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n*L\n1#1,127:1\n55#1:128\n56#1,11:130\n55#1:141\n56#1,2:143\n58#1,9:150\n55#1:159\n56#1,2:161\n58#1,9:168\n97#1,4:178\n114#1,6:182\n120#1,5:190\n97#1,4:195\n114#1,6:199\n120#1,5:207\n11#2:129\n11#2:142\n11#2:160\n11#2:177\n95#3,5:145\n95#3,5:163\n61#4,2:188\n61#4,2:205\n61#4,2:212\n61#4,2:214\n*S KotlinDebug\n*F\n+ 1 Undispatched.kt\nkotlinx/coroutines/intrinsics/UndispatchedKt\n*L\n18#1:128\n18#1:130,11\n29#1:141\n29#1:143,2\n29#1:150,9\n42#1:159\n42#1:161,2\n42#1:168,9\n77#1:178,4\n77#1:182,6\n77#1:190,5\n88#1:195,4\n88#1:199,6\n88#1:207,5\n18#1:129\n29#1:142\n42#1:160\n55#1:177\n30#1:145,5\n43#1:163,5\n77#1:188,2\n88#1:205,2\n119#1:212,2\n120#1:214,2\n*E\n"})
/* loaded from: classes6.dex */
public final class II0xO0 {
    public static final <T> void I0Io(@OOXIXo oOoXoXO<? super I0Io<? super T>, ? extends Object> oooxoxo, @OOXIXo I0Io<? super T> i0Io) {
        I0Io oIX0oI2 = XO.oIX0oI(i0Io);
        try {
            Object invoke = ((oOoXoXO) XoX.Oo(oooxoxo, 1)).invoke(oIX0oI2);
            if (invoke != kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
                Result.oIX0oI oix0oi = Result.Companion;
                oIX0oI2.resumeWith(Result.m287constructorimpl(invoke));
            }
        } catch (Throwable th) {
            Result.oIX0oI oix0oi2 = Result.Companion;
            oIX0oI2.resumeWith(Result.m287constructorimpl(I0oOoX.oIX0oI(th)));
        }
    }

    public static final <R, T> void II0xO0(@OOXIXo x0xO0oo<? super R, ? super I0Io<? super T>, ? extends Object> x0xo0oo, R r, @OOXIXo I0Io<? super T> i0Io) {
        I0Io oIX0oI2 = XO.oIX0oI(i0Io);
        try {
            CoroutineContext context = i0Io.getContext();
            Object I0Io2 = ThreadContextKt.I0Io(context, null);
            try {
                Object invoke = ((x0xO0oo) XoX.Oo(x0xo0oo, 2)).invoke(r, oIX0oI2);
                if (invoke != kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
                    Result.oIX0oI oix0oi = Result.Companion;
                    oIX0oI2.resumeWith(Result.m287constructorimpl(invoke));
                }
            } finally {
                ThreadContextKt.oIX0oI(context, I0Io2);
            }
        } catch (Throwable th) {
            Result.oIX0oI oix0oi2 = Result.Companion;
            oIX0oI2.resumeWith(Result.m287constructorimpl(I0oOoX.oIX0oI(th)));
        }
    }

    public static final <T> Object Oxx0IOOO(Xx000oIo<? super T> xx000oIo, oOoXoXO<? super Throwable, Boolean> oooxoxo, Oox.oIX0oI<? extends Object> oix0oi) {
        Object xxx2;
        try {
            xxx2 = oix0oi.invoke();
        } catch (Throwable th) {
            xxx2 = new xxX(th, false, 2, null);
        }
        if (xxx2 == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
            return kotlin.coroutines.intrinsics.II0xO0.oOoXoXO();
        }
        Object OoO2 = xx000oIo.OoO(xxx2);
        if (OoO2 == xI0oxI00.f30473II0xO0) {
            return kotlin.coroutines.intrinsics.II0xO0.oOoXoXO();
        }
        if (OoO2 instanceof xxX) {
            xxX xxx3 = (xxX) OoO2;
            if (!oooxoxo.invoke(xxx3.f30502oIX0oI).booleanValue()) {
                if (xxx2 instanceof xxX) {
                    throw ((xxX) xxx2).f30502oIX0oI;
                }
                return xxx2;
            }
            throw xxx3.f30502oIX0oI;
        }
        return xI0oxI00.II0XooXoX(OoO2);
    }

    @OXOo.oOoXoXO
    public static final <T, R> Object X0o0xo(@OOXIXo Xx000oIo<? super T> xx000oIo, R r, @OOXIXo x0xO0oo<? super R, ? super I0Io<? super T>, ? extends Object> x0xo0oo) {
        Object xxx2;
        try {
            xxx2 = ((x0xO0oo) XoX.Oo(x0xo0oo, 2)).invoke(r, xx000oIo);
        } catch (Throwable th) {
            xxx2 = new xxX(th, false, 2, null);
        }
        if (xxx2 == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
            return kotlin.coroutines.intrinsics.II0xO0.oOoXoXO();
        }
        Object OoO2 = xx000oIo.OoO(xxx2);
        if (OoO2 == xI0oxI00.f30473II0xO0) {
            return kotlin.coroutines.intrinsics.II0xO0.oOoXoXO();
        }
        if (!(OoO2 instanceof xxX)) {
            return xI0oxI00.II0XooXoX(OoO2);
        }
        throw ((xxX) OoO2).f30502oIX0oI;
    }

    @OXOo.oOoXoXO
    public static final <T, R> Object XO(@OOXIXo Xx000oIo<? super T> xx000oIo, R r, @OOXIXo x0xO0oo<? super R, ? super I0Io<? super T>, ? extends Object> x0xo0oo) {
        Object xxx2;
        try {
            xxx2 = ((x0xO0oo) XoX.Oo(x0xo0oo, 2)).invoke(r, xx000oIo);
        } catch (Throwable th) {
            xxx2 = new xxX(th, false, 2, null);
        }
        if (xxx2 == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
            return kotlin.coroutines.intrinsics.II0xO0.oOoXoXO();
        }
        Object OoO2 = xx000oIo.OoO(xxx2);
        if (OoO2 == xI0oxI00.f30473II0xO0) {
            return kotlin.coroutines.intrinsics.II0xO0.oOoXoXO();
        }
        if (OoO2 instanceof xxX) {
            Throwable th2 = ((xxX) OoO2).f30502oIX0oI;
            if (th2 instanceof TimeoutCancellationException) {
                if (((TimeoutCancellationException) th2).coroutine == xx000oIo) {
                    if (xxx2 instanceof xxX) {
                        throw ((xxX) xxx2).f30502oIX0oI;
                    }
                } else {
                    throw th2;
                }
            } else {
                throw th2;
            }
        } else {
            xxx2 = xI0oxI00.II0XooXoX(OoO2);
        }
        return xxx2;
    }

    public static final <T> void oIX0oI(@OOXIXo oOoXoXO<? super I0Io<? super T>, ? extends Object> oooxoxo, @OOXIXo I0Io<? super T> i0Io) {
        I0Io oIX0oI2 = XO.oIX0oI(i0Io);
        try {
            CoroutineContext context = i0Io.getContext();
            Object I0Io2 = ThreadContextKt.I0Io(context, null);
            try {
                Object invoke = ((oOoXoXO) XoX.Oo(oooxoxo, 1)).invoke(oIX0oI2);
                if (invoke != kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
                    Result.oIX0oI oix0oi = Result.Companion;
                    oIX0oI2.resumeWith(Result.m287constructorimpl(invoke));
                }
            } finally {
                ThreadContextKt.oIX0oI(context, I0Io2);
            }
        } catch (Throwable th) {
            Result.oIX0oI oix0oi2 = Result.Companion;
            oIX0oI2.resumeWith(Result.m287constructorimpl(I0oOoX.oIX0oI(th)));
        }
    }

    public static final <T> void oxoX(I0Io<? super T> i0Io, oOoXoXO<? super I0Io<? super T>, ? extends Object> oooxoxo) {
        I0Io oIX0oI2 = XO.oIX0oI(i0Io);
        try {
            Object invoke = oooxoxo.invoke(oIX0oI2);
            if (invoke != kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
                Result.oIX0oI oix0oi = Result.Companion;
                oIX0oI2.resumeWith(Result.m287constructorimpl(invoke));
            }
        } catch (Throwable th) {
            Result.oIX0oI oix0oi2 = Result.Companion;
            oIX0oI2.resumeWith(Result.m287constructorimpl(I0oOoX.oIX0oI(th)));
        }
    }
}
