package kotlinx.coroutines.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;

/* loaded from: classes6.dex */
public class Xx000oIo<T> extends kotlinx.coroutines.oIX0oI<T> implements IXIxx0.I0Io {

    /* renamed from: Oxx0xo, reason: collision with root package name */
    @OXOo.OOXIXo
    @XO0OX.XO
    public final kotlin.coroutines.I0Io<T> f30289Oxx0xo;

    /* JADX WARN: Multi-variable type inference failed */
    public Xx000oIo(@OXOo.OOXIXo CoroutineContext coroutineContext, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super T> i0Io) {
        super(coroutineContext, true, true);
        this.f30289Oxx0xo = i0Io;
    }

    @Override // kotlinx.coroutines.JobSupport
    public void I0X0x0oIo(@OXOo.oOoXoXO Object obj) {
        ooOOo0oXI.X0o0xo(IntrinsicsKt__IntrinsicsJvmKt.X0o0xo(this.f30289Oxx0xo), kotlinx.coroutines.xI.oIX0oI(obj, this.f30289Oxx0xo), null, 2, null);
    }

    @Override // kotlinx.coroutines.JobSupport
    public final boolean O0() {
        return true;
    }

    @Override // kotlinx.coroutines.oIX0oI
    public void OX(@OXOo.oOoXoXO Object obj) {
        kotlin.coroutines.I0Io<T> i0Io = this.f30289Oxx0xo;
        i0Io.resumeWith(kotlinx.coroutines.xI.oIX0oI(obj, i0Io));
    }

    @Override // IXIxx0.I0Io
    @OXOo.oOoXoXO
    public final IXIxx0.I0Io getCallerFrame() {
        kotlin.coroutines.I0Io<T> i0Io = this.f30289Oxx0xo;
        if (i0Io instanceof IXIxx0.I0Io) {
            return (IXIxx0.I0Io) i0Io;
        }
        return null;
    }

    @Override // IXIxx0.I0Io
    @OXOo.oOoXoXO
    public final StackTraceElement getStackTraceElement() {
        return null;
    }
}
