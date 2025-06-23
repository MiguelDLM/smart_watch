package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Result;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.ThreadContextKt;

@kotlin.jvm.internal.XX({"SMAP\nDispatchedTask.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DispatchedTask.kt\nkotlinx/coroutines/DispatchedTask\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 CoroutineContext.kt\nkotlinx/coroutines/CoroutineContextKt\n+ 4 DispatchedTask.kt\nkotlinx/coroutines/DispatchedTaskKt\n+ 5 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n+ 6 Exceptions.kt\nkotlinx/coroutines/ExceptionsKt\n*L\n1#1,222:1\n1#2:223\n107#3,10:224\n118#3,2:238\n220#4:234\n221#4:237\n61#5,2:235\n75#6:240\n*S KotlinDebug\n*F\n+ 1 DispatchedTask.kt\nkotlinx/coroutines/DispatchedTask\n*L\n90#1:224,10\n90#1:238,2\n103#1:234\n103#1:237\n103#1:235,2\n142#1:240\n*E\n"})
@kotlin.o0
/* loaded from: classes6.dex */
public abstract class XX0<T> extends XXIoX0.xxIXOIIO {

    /* renamed from: IXxxXO, reason: collision with root package name */
    @XO0OX.XO
    public int f29778IXxxXO;

    public XX0(int i) {
        this.f29778IXxxXO = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T Oxx0IOOO(@OXOo.oOoXoXO Object obj) {
        return obj;
    }

    @OXOo.OOXIXo
    public abstract kotlin.coroutines.I0Io<T> X0o0xo();

    @OXOo.oOoXoXO
    public Throwable XO(@OXOo.oOoXoXO Object obj) {
        xxX xxx2;
        if (obj instanceof xxX) {
            xxx2 = (xxX) obj;
        } else {
            xxx2 = null;
        }
        if (xxx2 == null) {
            return null;
        }
        return xxx2.f30502oIX0oI;
    }

    public void oxoX(@OXOo.oOoXoXO Object obj, @OXOo.OOXIXo Throwable th) {
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object m287constructorimpl;
        Oxx<?> oxx;
        oXIO0o0XI oxio0o0xi;
        Object m287constructorimpl2;
        XXIoX0.xoIox xoiox = this.f4080Oo;
        try {
            kotlin.coroutines.I0Io<T> X0o0xo2 = X0o0xo();
            kotlin.jvm.internal.IIX0o.x0XOIxOo(X0o0xo2, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTask>");
            kotlinx.coroutines.internal.oOoXoXO oooxoxo = (kotlinx.coroutines.internal.oOoXoXO) X0o0xo2;
            kotlin.coroutines.I0Io<T> i0Io = oooxoxo.f30302oI0IIXIo;
            Object obj = oooxoxo.f30299IIXOooo;
            CoroutineContext context = i0Io.getContext();
            Object I0Io2 = ThreadContextKt.I0Io(context, obj);
            if (I0Io2 != ThreadContextKt.f30273oIX0oI) {
                oxx = CoroutineContextKt.Oxx0IOOO(i0Io, context, I0Io2);
            } else {
                oxx = null;
            }
            try {
                CoroutineContext context2 = i0Io.getContext();
                Object xoIox2 = xoIox();
                Throwable XO2 = XO(xoIox2);
                if (XO2 == null && I0X0x0oIo.I0Io(this.f29778IXxxXO)) {
                    oxio0o0xi = (oXIO0o0XI) context2.get(oXIO0o0XI.f30343xxIXOIIO);
                } else {
                    oxio0o0xi = null;
                }
                if (oxio0o0xi != null && !oxio0o0xi.isActive()) {
                    CancellationException xI2 = oxio0o0xi.xI();
                    oxoX(xoIox2, xI2);
                    Result.oIX0oI oix0oi = Result.Companion;
                    i0Io.resumeWith(Result.m287constructorimpl(kotlin.I0oOoX.oIX0oI(xI2)));
                } else if (XO2 != null) {
                    Result.oIX0oI oix0oi2 = Result.Companion;
                    i0Io.resumeWith(Result.m287constructorimpl(kotlin.I0oOoX.oIX0oI(XO2)));
                } else {
                    Result.oIX0oI oix0oi3 = Result.Companion;
                    i0Io.resumeWith(Result.m287constructorimpl(Oxx0IOOO(xoIox2)));
                }
                kotlin.oXIO0o0XI oxio0o0xi2 = kotlin.oXIO0o0XI.f29392oIX0oI;
                if (oxx == null || oxx.OooI()) {
                    ThreadContextKt.oIX0oI(context, I0Io2);
                }
                try {
                    Result.oIX0oI oix0oi4 = Result.Companion;
                    xoiox.xxIXOIIO();
                    m287constructorimpl2 = Result.m287constructorimpl(oxio0o0xi2);
                } catch (Throwable th) {
                    Result.oIX0oI oix0oi5 = Result.Companion;
                    m287constructorimpl2 = Result.m287constructorimpl(kotlin.I0oOoX.oIX0oI(th));
                }
                xxIXOIIO(null, Result.m290exceptionOrNullimpl(m287constructorimpl2));
            } catch (Throwable th2) {
                if (oxx == null || oxx.OooI()) {
                    ThreadContextKt.oIX0oI(context, I0Io2);
                }
                throw th2;
            }
        } catch (Throwable th3) {
            try {
                Result.oIX0oI oix0oi6 = Result.Companion;
                xoiox.xxIXOIIO();
                m287constructorimpl = Result.m287constructorimpl(kotlin.oXIO0o0XI.f29392oIX0oI);
            } catch (Throwable th4) {
                Result.oIX0oI oix0oi7 = Result.Companion;
                m287constructorimpl = Result.m287constructorimpl(kotlin.I0oOoX.oIX0oI(th4));
            }
            xxIXOIIO(th3, Result.m290exceptionOrNullimpl(m287constructorimpl));
        }
    }

    @OXOo.oOoXoXO
    public abstract Object xoIox();

    public final void xxIXOIIO(@OXOo.oOoXoXO Throwable th, @OXOo.oOoXoXO Throwable th2) {
        if (th == null && th2 == null) {
            return;
        }
        if (th != null && th2 != null) {
            kotlin.oO.oIX0oI(th, th2);
        }
        if (th == null) {
            th = th2;
        }
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(th);
        Xx000oIo.II0xO0(X0o0xo().getContext(), new CoroutinesInternalError("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th));
    }
}
