package kotlinx.coroutines.flow;

import kotlin.DeprecationLevel;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.IIX0o;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.xxIXOIIO;
import kotlinx.coroutines.oXIO0o0XI;

/* loaded from: classes6.dex */
public final /* synthetic */ class II0XooXoX {
    public static /* synthetic */ X0o0xo I0Io(X0o0xo x0o0xo, int i, int i2, Object obj) {
        X0o0xo oIX0oI2;
        if ((i2 & 1) != 0) {
            i = -2;
        }
        oIX0oI2 = oIX0oI(x0o0xo, i);
        return oIX0oI2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> II0XooXoX(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo CoroutineContext coroutineContext) {
        XO(coroutineContext);
        if (!IIX0o.Oxx0IOOO(coroutineContext, EmptyCoroutineContext.INSTANCE)) {
            if (x0o0xo instanceof kotlinx.coroutines.flow.internal.xxIXOIIO) {
                return xxIXOIIO.oIX0oI.oIX0oI((kotlinx.coroutines.flow.internal.xxIXOIIO) x0o0xo, coroutineContext, 0, null, 6, null);
            }
            return new kotlinx.coroutines.flow.internal.X0o0xo(x0o0xo, coroutineContext, 0, null, 12, null);
        }
        return x0o0xo;
    }

    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> II0xO0(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, int i, @OXOo.OOXIXo BufferOverflow bufferOverflow) {
        int i2;
        BufferOverflow bufferOverflow2;
        if (i < 0 && i != -2 && i != -1) {
            throw new IllegalArgumentException(("Buffer size should be non-negative, BUFFERED, or CONFLATED, but was " + i).toString());
        }
        if (i == -1 && bufferOverflow != BufferOverflow.SUSPEND) {
            throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow");
        }
        if (i == -1) {
            bufferOverflow2 = BufferOverflow.DROP_OLDEST;
            i2 = 0;
        } else {
            i2 = i;
            bufferOverflow2 = bufferOverflow;
        }
        if (x0o0xo instanceof kotlinx.coroutines.flow.internal.xxIXOIIO) {
            return xxIXOIIO.oIX0oI.oIX0oI((kotlinx.coroutines.flow.internal.xxIXOIIO) x0o0xo, null, i2, bufferOverflow2, 1, null);
        }
        return new kotlinx.coroutines.flow.internal.X0o0xo(x0o0xo, null, i2, bufferOverflow2, 2, null);
    }

    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> Oxx0IOOO(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo) {
        X0o0xo<T> oxoX2;
        oxoX2 = oxoX(x0o0xo, -1, null, 2, null);
        return oxoX2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> X0o0xo(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo) {
        if (!(x0o0xo instanceof oIX0oI)) {
            return new CancellableFlowImpl(x0o0xo);
        }
        return x0o0xo;
    }

    public static final void XO(CoroutineContext coroutineContext) {
        if (coroutineContext.get(oXIO0o0XI.f30343xxIXOIIO) == null) {
            return;
        }
        throw new IllegalArgumentException(("Flow context cannot contain job in it. Had " + coroutineContext).toString());
    }

    @kotlin.OOXIXo(level = DeprecationLevel.HIDDEN, message = "Since 1.4.0, binary compatibility with earlier versions")
    public static final /* synthetic */ X0o0xo oIX0oI(X0o0xo x0o0xo, int i) {
        X0o0xo oxoX2;
        oxoX2 = oxoX(x0o0xo, i, null, 2, null);
        return oxoX2;
    }

    public static /* synthetic */ X0o0xo oxoX(X0o0xo x0o0xo, int i, BufferOverflow bufferOverflow, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = -2;
        }
        if ((i2 & 2) != 0) {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        return Oxx0IOOO.oO(x0o0xo, i, bufferOverflow);
    }
}
