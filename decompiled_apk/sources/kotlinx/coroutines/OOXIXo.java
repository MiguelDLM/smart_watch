package kotlinx.coroutines;

import java.util.concurrent.Future;

/* loaded from: classes6.dex */
public final class OOXIXo extends ooOOo0oXI {

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Future<?> f29745XO;

    public OOXIXo(@OXOo.OOXIXo Future<?> future) {
        this.f29745XO = future;
    }

    @Override // Oox.oOoXoXO
    public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(Throwable th) {
        xoIox(th);
        return kotlin.oXIO0o0XI.f29392oIX0oI;
    }

    @OXOo.OOXIXo
    public String toString() {
        return "CancelFutureOnCancel[" + this.f29745XO + ']';
    }

    @Override // kotlinx.coroutines.x0XOIxOo
    public void xoIox(@OXOo.oOoXoXO Throwable th) {
        if (th != null) {
            this.f29745XO.cancel(false);
        }
    }
}
