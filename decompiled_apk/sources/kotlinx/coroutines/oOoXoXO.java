package kotlinx.coroutines;

import java.util.concurrent.Future;

/* loaded from: classes6.dex */
public final class oOoXoXO extends xx0X0 {

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Future<?> f30341oI0IIXIo;

    public oOoXoXO(@OXOo.OOXIXo Future<?> future) {
        this.f30341oI0IIXIo = future;
    }

    @Override // Oox.oOoXoXO
    public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(Throwable th) {
        o00(th);
        return kotlin.oXIO0o0XI.f29392oIX0oI;
    }

    @Override // kotlinx.coroutines.xXxxox0I
    public void o00(@OXOo.oOoXoXO Throwable th) {
        if (th != null) {
            this.f30341oI0IIXIo.cancel(false);
        }
    }
}
