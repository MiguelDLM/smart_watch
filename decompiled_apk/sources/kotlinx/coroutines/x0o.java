package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.coroutines.CoroutineContext;

/* loaded from: classes6.dex */
public final class x0o {
    public static final void I0Io(@OXOo.OOXIXo xII xii, @OXOo.OOXIXo String str, @OXOo.oOoXoXO Throwable th) {
        oxoX(xii, XX0xXo.oIX0oI(str, th));
    }

    @OXOo.oOoXoXO
    public static final Object II0XooXoX(@OXOo.OOXIXo kotlin.coroutines.I0Io<? super CoroutineContext> i0Io) {
        return i0Io.getContext();
    }

    @OXOo.OOXIXo
    public static final xII II0xO0() {
        return new kotlinx.coroutines.internal.II0XooXoX(x0.I0Io(null, 1, null).plus(Xo0.X0o0xo()));
    }

    public static final boolean OOXIXo(@OXOo.OOXIXo xII xii) {
        oXIO0o0XI oxio0o0xi = (oXIO0o0XI) xii.getCoroutineContext().get(oXIO0o0XI.f30343xxIXOIIO);
        if (oxio0o0xi != null) {
            return oxio0o0xi.isActive();
        }
        return true;
    }

    @OXOo.oOoXoXO
    public static final <R> Object Oxx0IOOO(@OXOo.OOXIXo Oox.x0xO0oo<? super xII, ? super kotlin.coroutines.I0Io<? super R>, ? extends Object> x0xo0oo, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super R> i0Io) {
        kotlinx.coroutines.internal.Xx000oIo xx000oIo = new kotlinx.coroutines.internal.Xx000oIo(i0Io.getContext(), i0Io);
        Object X0o0xo2 = o0xIoII.II0xO0.X0o0xo(xx000oIo, xx000oIo, x0xo0oo);
        if (X0o0xo2 == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
            IXIxx0.XO.I0Io(i0Io);
        }
        return X0o0xo2;
    }

    public static /* synthetic */ void X0o0xo(xII xii, String str, Throwable th, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        I0Io(xii, str, th);
    }

    public static /* synthetic */ void XO(xII xii, CancellationException cancellationException, int i, Object obj) {
        if ((i & 1) != 0) {
            cancellationException = null;
        }
        oxoX(xii, cancellationException);
    }

    @OXOo.OOXIXo
    public static final xII oIX0oI(@OXOo.OOXIXo CoroutineContext coroutineContext) {
        XI0IXoo I0Io2;
        if (coroutineContext.get(oXIO0o0XI.f30343xxIXOIIO) == null) {
            I0Io2 = Ox0O.I0Io(null, 1, null);
            coroutineContext = coroutineContext.plus(I0Io2);
        }
        return new kotlinx.coroutines.internal.II0XooXoX(coroutineContext);
    }

    public static /* synthetic */ void oOoXoXO(xII xii) {
    }

    @OXOo.OOXIXo
    public static final xII ooOOo0oXI(@OXOo.OOXIXo xII xii, @OXOo.OOXIXo CoroutineContext coroutineContext) {
        return new kotlinx.coroutines.internal.II0XooXoX(xii.getCoroutineContext().plus(coroutineContext));
    }

    public static final void oxoX(@OXOo.OOXIXo xII xii, @OXOo.oOoXoXO CancellationException cancellationException) {
        oXIO0o0XI oxio0o0xi = (oXIO0o0XI) xii.getCoroutineContext().get(oXIO0o0XI.f30343xxIXOIIO);
        if (oxio0o0xi != null) {
            oxio0o0xi.II0xO0(cancellationException);
            return;
        }
        throw new IllegalStateException(("Scope cannot be cancelled because it does not have a job: " + xii).toString());
    }

    public static final void xoIox(@OXOo.OOXIXo xII xii) {
        IIX0.O0xOxO(xii.getCoroutineContext());
    }

    public static final Object xxIXOIIO(kotlin.coroutines.I0Io<? super CoroutineContext> i0Io) {
        kotlin.jvm.internal.xxX.X0o0xo(3);
        throw null;
    }
}
