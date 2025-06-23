package androidx.lifecycle;

import OXOo.OOXIXo;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.Lifecycle;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.I0Io;
import kotlin.jvm.internal.IIX0o;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Ox0O;
import kotlinx.coroutines.Xo0;
import kotlinx.coroutines.oXIO0o0XI;
import kotlinx.coroutines.xoIox;

public final class LifecycleCoroutineScopeImpl extends LifecycleCoroutineScope implements LifecycleEventObserver {
    @OOXIXo
    private final CoroutineContext coroutineContext;
    @OOXIXo
    private final Lifecycle lifecycle;

    public LifecycleCoroutineScopeImpl(@OOXIXo Lifecycle lifecycle2, @OOXIXo CoroutineContext coroutineContext2) {
        IIX0o.x0xO0oo(lifecycle2, RequestParameters.SUBRESOURCE_LIFECYCLE);
        IIX0o.x0xO0oo(coroutineContext2, "coroutineContext");
        this.lifecycle = lifecycle2;
        this.coroutineContext = coroutineContext2;
        if (getLifecycle$lifecycle_common().getCurrentState() == Lifecycle.State.DESTROYED) {
            Ox0O.xxIXOIIO(getCoroutineContext(), (CancellationException) null, 1, (Object) null);
        }
    }

    @OOXIXo
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    @OOXIXo
    public Lifecycle getLifecycle$lifecycle_common() {
        return this.lifecycle;
    }

    public void onStateChanged(@OOXIXo LifecycleOwner lifecycleOwner, @OOXIXo Lifecycle.Event event) {
        IIX0o.x0xO0oo(lifecycleOwner, "source");
        IIX0o.x0xO0oo(event, NotificationCompat.CATEGORY_EVENT);
        if (getLifecycle$lifecycle_common().getCurrentState().compareTo(Lifecycle.State.DESTROYED) <= 0) {
            getLifecycle$lifecycle_common().removeObserver(this);
            Ox0O.xxIXOIIO(getCoroutineContext(), (CancellationException) null, 1, (Object) null);
        }
    }

    public final void register() {
        oXIO0o0XI unused = xoIox.XO(this, Xo0.X0o0xo().IIXOooo(), (CoroutineStart) null, new LifecycleCoroutineScopeImpl$register$1(this, (I0Io<? super LifecycleCoroutineScopeImpl$register$1>) null), 2, (Object) null);
    }
}
