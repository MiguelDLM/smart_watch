package kotlinx.coroutines;

import java.util.Iterator;
import java.util.concurrent.CancellationException;
import kotlin.DeprecationLevel;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.oXIO0o0XI;

@kotlin.jvm.internal.XX({"SMAP\nJob.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Job.kt\nkotlinx/coroutines/JobKt__JobKt\n+ 2 CompletionHandler.kt\nkotlinx/coroutines/CompletionHandlerKt\n+ 3 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,685:1\n13#2:686\n1295#3,2:687\n1295#3,2:689\n1295#3,2:691\n1295#3,2:693\n*S KotlinDebug\n*F\n+ 1 Job.kt\nkotlinx/coroutines/JobKt__JobKt\n*L\n494#1:686\n521#1:687,2\n535#1:689,2\n629#1:691,2\n653#1:693,2\n*E\n"})
/* loaded from: classes6.dex */
public final /* synthetic */ class Ox0O {
    public static /* synthetic */ XI0IXoo I0Io(oXIO0o0XI oxio0o0xi, int i, Object obj) {
        if ((i & 1) != 0) {
            oxio0o0xi = null;
        }
        return IIX0.oIX0oI(oxio0o0xi);
    }

    @kotlin.OOXIXo(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final /* synthetic */ boolean II0XooXoX(CoroutineContext coroutineContext, Throwable th) {
        JobSupport jobSupport;
        CoroutineContext.oIX0oI oix0oi = coroutineContext.get(oXIO0o0XI.f30343xxIXOIIO);
        if (oix0oi instanceof JobSupport) {
            jobSupport = (JobSupport) oix0oi;
        } else {
            jobSupport = null;
        }
        if (jobSupport == null) {
            return false;
        }
        jobSupport.I0oOIX(XI0IXoo(th, jobSupport));
        return true;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    @XO0OX.xxIXOIIO(name = "Job")
    public static final /* synthetic */ oXIO0o0XI II0xO0(oXIO0o0XI oxio0o0xi) {
        return IIX0.oIX0oI(oxio0o0xi);
    }

    public static /* synthetic */ void IIXOooo(oXIO0o0XI oxio0o0xi, CancellationException cancellationException, int i, Object obj) {
        if ((i & 1) != 0) {
            cancellationException = null;
        }
        IIX0.IXxxXO(oxio0o0xi, cancellationException);
    }

    public static final void IXxxXO(@OXOo.OOXIXo oXIO0o0XI oxio0o0xi, @OXOo.oOoXoXO CancellationException cancellationException) {
        Iterator<oXIO0o0XI> it = oxio0o0xi.xXxxox0I().iterator();
        while (it.hasNext()) {
            it.next().II0xO0(cancellationException);
        }
    }

    @OXOo.OOXIXo
    public static final oXIO0o0XI O0xOxO(@OXOo.OOXIXo CoroutineContext coroutineContext) {
        oXIO0o0XI oxio0o0xi = (oXIO0o0XI) coroutineContext.get(oXIO0o0XI.f30343xxIXOIIO);
        if (oxio0o0xi != null) {
            return oxio0o0xi;
        }
        throw new IllegalStateException(("Current context doesn't contain Job in it: " + coroutineContext).toString());
    }

    public static /* synthetic */ boolean OOXIXo(CoroutineContext coroutineContext, Throwable th, int i, Object obj) {
        boolean II0XooXoX2;
        if ((i & 1) != 0) {
            th = null;
        }
        II0XooXoX2 = II0XooXoX(coroutineContext, th);
        return II0XooXoX2;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final /* synthetic */ void Oo(oXIO0o0XI oxio0o0xi, Throwable th) {
        JobSupport jobSupport;
        for (oXIO0o0XI oxio0o0xi2 : oxio0o0xi.xXxxox0I()) {
            if (oxio0o0xi2 instanceof JobSupport) {
                jobSupport = (JobSupport) oxio0o0xi2;
            } else {
                jobSupport = null;
            }
            if (jobSupport != null) {
                jobSupport.I0oOIX(XI0IXoo(th, oxio0o0xi));
            }
        }
    }

    public static final void OxI(@OXOo.OOXIXo oXIO0o0XI oxio0o0xi) {
        if (oxio0o0xi.isActive()) {
        } else {
            throw oxio0o0xi.xI();
        }
    }

    public static final void Oxx0IOOO(@OXOo.OOXIXo oXIO0o0XI oxio0o0xi, @OXOo.OOXIXo String str, @OXOo.oOoXoXO Throwable th) {
        oxio0o0xi.II0xO0(XX0xXo.oIX0oI(str, th));
    }

    public static /* synthetic */ void Oxx0xo(CoroutineContext coroutineContext, Throwable th, int i, Object obj) {
        if ((i & 1) != 0) {
            th = null;
        }
        x0XOIxOo(coroutineContext, th);
    }

    public static /* synthetic */ void OxxIIOOXO(oXIO0o0XI oxio0o0xi, Throwable th, int i, Object obj) {
        if ((i & 1) != 0) {
            th = null;
        }
        Oo(oxio0o0xi, th);
    }

    public static final boolean X0IIOO(@OXOo.OOXIXo CoroutineContext coroutineContext) {
        oXIO0o0XI oxio0o0xi = (oXIO0o0XI) coroutineContext.get(oXIO0o0XI.f30343xxIXOIIO);
        if (oxio0o0xi != null) {
            return oxio0o0xi.isActive();
        }
        return true;
    }

    public static final Throwable XI0IXoo(Throwable th, oXIO0o0XI oxio0o0xi) {
        if (th == null) {
            return new JobCancellationException("Job was cancelled", null, oxio0o0xi);
        }
        return th;
    }

    public static final void XO(@OXOo.OOXIXo CoroutineContext coroutineContext, @OXOo.oOoXoXO CancellationException cancellationException) {
        oXIO0o0XI oxio0o0xi = (oXIO0o0XI) coroutineContext.get(oXIO0o0XI.f30343xxIXOIIO);
        if (oxio0o0xi != null) {
            oxio0o0xi.II0xO0(cancellationException);
        }
    }

    public static final void o00(@OXOo.OOXIXo CoroutineContext coroutineContext) {
        oXIO0o0XI oxio0o0xi = (oXIO0o0XI) coroutineContext.get(oXIO0o0XI.f30343xxIXOIIO);
        if (oxio0o0xi != null) {
            IIX0.X0IIOO(oxio0o0xi);
        }
    }

    public static /* synthetic */ void oI0IIXIo(CoroutineContext coroutineContext, CancellationException cancellationException, int i, Object obj) {
        if ((i & 1) != 0) {
            cancellationException = null;
        }
        IIX0.oO(coroutineContext, cancellationException);
    }

    @OXOo.OOXIXo
    public static final XI0IXoo oIX0oI(@OXOo.oOoXoXO oXIO0o0XI oxio0o0xi) {
        return new O0X(oxio0o0xi);
    }

    public static final void oO(@OXOo.OOXIXo CoroutineContext coroutineContext, @OXOo.oOoXoXO CancellationException cancellationException) {
        kotlin.sequences.ooOOo0oXI<oXIO0o0XI> xXxxox0I2;
        oXIO0o0XI oxio0o0xi = (oXIO0o0XI) coroutineContext.get(oXIO0o0XI.f30343xxIXOIIO);
        if (oxio0o0xi != null && (xXxxox0I2 = oxio0o0xi.xXxxox0I()) != null) {
            Iterator<oXIO0o0XI> it = xXxxox0I2.iterator();
            while (it.hasNext()) {
                it.next().II0xO0(cancellationException);
            }
        }
    }

    @OXOo.oOoXoXO
    public static final Object oOoXoXO(@OXOo.OOXIXo oXIO0o0XI oxio0o0xi, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super kotlin.oXIO0o0XI> i0Io) {
        oXIO0o0XI.oIX0oI.II0xO0(oxio0o0xi, null, 1, null);
        Object oOXoIIIo2 = oxio0o0xi.oOXoIIIo(i0Io);
        if (oOXoIIIo2 == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
            return oOXoIIIo2;
        }
        return kotlin.oXIO0o0XI.f29392oIX0oI;
    }

    public static /* synthetic */ oXIO0o0XI oxoX(oXIO0o0XI oxio0o0xi, int i, Object obj) {
        oXIO0o0XI II0xO02;
        if ((i & 1) != 0) {
            oxio0o0xi = null;
        }
        II0xO02 = II0xO0(oxio0o0xi);
        return II0xO02;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final /* synthetic */ void x0XOIxOo(CoroutineContext coroutineContext, Throwable th) {
        JobSupport jobSupport;
        oXIO0o0XI oxio0o0xi = (oXIO0o0XI) coroutineContext.get(oXIO0o0XI.f30343xxIXOIIO);
        if (oxio0o0xi == null) {
            return;
        }
        for (oXIO0o0XI oxio0o0xi2 : oxio0o0xi.xXxxox0I()) {
            if (oxio0o0xi2 instanceof JobSupport) {
                jobSupport = (JobSupport) oxio0o0xi2;
            } else {
                jobSupport = null;
            }
            if (jobSupport != null) {
                jobSupport.I0oOIX(XI0IXoo(th, oxio0o0xi));
            }
        }
    }

    public static /* synthetic */ void xoIox(oXIO0o0XI oxio0o0xi, String str, Throwable th, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        IIX0.Oxx0IOOO(oxio0o0xi, str, th);
    }

    @OXOo.OOXIXo
    public static final I0oOIX xoXoI(@OXOo.OOXIXo oXIO0o0XI oxio0o0xi, @OXOo.OOXIXo I0oOIX i0oOIX) {
        return oxio0o0xi.Oo(new IoOoo(i0oOIX));
    }

    public static /* synthetic */ void xxIXOIIO(CoroutineContext coroutineContext, CancellationException cancellationException, int i, Object obj) {
        if ((i & 1) != 0) {
            cancellationException = null;
        }
        IIX0.XO(coroutineContext, cancellationException);
    }
}
