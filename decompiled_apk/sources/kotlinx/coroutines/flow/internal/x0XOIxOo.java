package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.CoroutineContext;

/* loaded from: classes6.dex */
public final class x0XOIxOo<T> implements kotlin.coroutines.I0Io<T>, IXIxx0.I0Io {

    /* renamed from: Oo, reason: collision with root package name */
    @OXOo.OOXIXo
    public final CoroutineContext f30200Oo;

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final kotlin.coroutines.I0Io<T> f30201XO;

    /* JADX WARN: Multi-variable type inference failed */
    public x0XOIxOo(@OXOo.OOXIXo kotlin.coroutines.I0Io<? super T> i0Io, @OXOo.OOXIXo CoroutineContext coroutineContext) {
        this.f30201XO = i0Io;
        this.f30200Oo = coroutineContext;
    }

    @Override // IXIxx0.I0Io
    @OXOo.oOoXoXO
    public IXIxx0.I0Io getCallerFrame() {
        kotlin.coroutines.I0Io<T> i0Io = this.f30201XO;
        if (i0Io instanceof IXIxx0.I0Io) {
            return (IXIxx0.I0Io) i0Io;
        }
        return null;
    }

    @Override // kotlin.coroutines.I0Io
    @OXOo.OOXIXo
    public CoroutineContext getContext() {
        return this.f30200Oo;
    }

    @Override // IXIxx0.I0Io
    @OXOo.oOoXoXO
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlin.coroutines.I0Io
    public void resumeWith(@OXOo.OOXIXo Object obj) {
        this.f30201XO.resumeWith(obj);
    }
}
