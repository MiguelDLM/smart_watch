package kotlinx.coroutines;

import java.util.concurrent.Future;

/* loaded from: classes6.dex */
public final class O0Xx implements I0oOIX {

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Future<?> f29733XO;

    public O0Xx(@OXOo.OOXIXo Future<?> future) {
        this.f29733XO = future;
    }

    @Override // kotlinx.coroutines.I0oOIX
    public void dispose() {
        this.f29733XO.cancel(false);
    }

    @OXOo.OOXIXo
    public String toString() {
        return "DisposableFutureHandle[" + this.f29733XO + ']';
    }
}
