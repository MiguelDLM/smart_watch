package kotlinx.coroutines.debug.internal;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import kotlin.o0;

@o0
/* loaded from: classes6.dex */
public final class xxIXOIIO implements IXIxx0.I0Io {

    /* renamed from: Oo, reason: collision with root package name */
    @OOXIXo
    @XO0OX.XO
    public final StackTraceElement f29953Oo;

    /* renamed from: XO, reason: collision with root package name */
    @oOoXoXO
    public final IXIxx0.I0Io f29954XO;

    public xxIXOIIO(@oOoXoXO IXIxx0.I0Io i0Io, @OOXIXo StackTraceElement stackTraceElement) {
        this.f29954XO = i0Io;
        this.f29953Oo = stackTraceElement;
    }

    @Override // IXIxx0.I0Io
    @oOoXoXO
    public IXIxx0.I0Io getCallerFrame() {
        return this.f29954XO;
    }

    @Override // IXIxx0.I0Io
    @OOXIXo
    public StackTraceElement getStackTraceElement() {
        return this.f29953Oo;
    }
}
