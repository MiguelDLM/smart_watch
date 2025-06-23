package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.IIX0o;
import kotlinx.coroutines.Ox0O;
import kotlinx.coroutines.Xo0;

/* loaded from: classes.dex */
public final class LifecycleCoroutineScopeImpl extends LifecycleCoroutineScope implements LifecycleEventObserver {

    @OXOo.OOXIXo
    private final CoroutineContext coroutineContext;

    @OXOo.OOXIXo
    private final Lifecycle lifecycle;

    public LifecycleCoroutineScopeImpl(@OXOo.OOXIXo Lifecycle lifecycle, @OXOo.OOXIXo CoroutineContext coroutineContext) {
        IIX0o.x0xO0oo(lifecycle, "lifecycle");
        IIX0o.x0xO0oo(coroutineContext, "coroutineContext");
        this.lifecycle = lifecycle;
        this.coroutineContext = coroutineContext;
        if (getLifecycle$lifecycle_common().getCurrentState() == Lifecycle.State.DESTROYED) {
            Ox0O.xxIXOIIO(getCoroutineContext(), null, 1, null);
        }
    }

    @Override // kotlinx.coroutines.xII
    @OXOo.OOXIXo
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    @Override // androidx.lifecycle.LifecycleCoroutineScope
    @OXOo.OOXIXo
    public Lifecycle getLifecycle$lifecycle_common() {
        return this.lifecycle;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(@OXOo.OOXIXo LifecycleOwner source, @OXOo.OOXIXo Lifecycle.Event event) {
        IIX0o.x0xO0oo(source, "source");
        IIX0o.x0xO0oo(event, "event");
        if (getLifecycle$lifecycle_common().getCurrentState().compareTo(Lifecycle.State.DESTROYED) <= 0) {
            getLifecycle$lifecycle_common().removeObserver(this);
            Ox0O.xxIXOIIO(getCoroutineContext(), null, 1, null);
        }
    }

    public final void register() {
        kotlinx.coroutines.xoIox.XO(this, Xo0.X0o0xo().o00(), null, new LifecycleCoroutineScopeImpl$register$1(this, null), 2, null);
    }
}
