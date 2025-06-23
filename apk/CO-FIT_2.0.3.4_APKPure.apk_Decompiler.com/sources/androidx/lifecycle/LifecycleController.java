package androidx.lifecycle;

import OXOo.OOXIXo;
import androidx.annotation.MainThread;
import androidx.lifecycle.Lifecycle;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlinx.coroutines.oXIO0o0XI;

@XX({"SMAP\nLifecycleController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LifecycleController.kt\nandroidx/lifecycle/LifecycleController\n*L\n1#1,70:1\n57#1,3:71\n57#1,3:74\n*S KotlinDebug\n*F\n+ 1 LifecycleController.kt\nandroidx/lifecycle/LifecycleController\n*L\n49#1:71,3\n36#1:74,3\n*E\n"})
@MainThread
public final class LifecycleController {
    @OOXIXo
    private final DispatchQueue dispatchQueue;
    @OOXIXo
    private final Lifecycle lifecycle;
    @OOXIXo
    private final Lifecycle.State minState;
    @OOXIXo
    private final LifecycleEventObserver observer;

    public LifecycleController(@OOXIXo Lifecycle lifecycle2, @OOXIXo Lifecycle.State state, @OOXIXo DispatchQueue dispatchQueue2, @OOXIXo oXIO0o0XI oxio0o0xi) {
        IIX0o.x0xO0oo(lifecycle2, RequestParameters.SUBRESOURCE_LIFECYCLE);
        IIX0o.x0xO0oo(state, "minState");
        IIX0o.x0xO0oo(dispatchQueue2, "dispatchQueue");
        IIX0o.x0xO0oo(oxio0o0xi, "parentJob");
        this.lifecycle = lifecycle2;
        this.minState = state;
        this.dispatchQueue = dispatchQueue2;
        XO xo2 = new XO(this, oxio0o0xi);
        this.observer = xo2;
        if (lifecycle2.getCurrentState() == Lifecycle.State.DESTROYED) {
            oXIO0o0XI.oIX0oI.II0xO0(oxio0o0xi, (CancellationException) null, 1, (Object) null);
            finish();
            return;
        }
        lifecycle2.addObserver(xo2);
    }

    private final void handleDestroy(oXIO0o0XI oxio0o0xi) {
        oXIO0o0XI.oIX0oI.II0xO0(oxio0o0xi, (CancellationException) null, 1, (Object) null);
        finish();
    }

    /* access modifiers changed from: private */
    public static final void observer$lambda$0(LifecycleController lifecycleController, oXIO0o0XI oxio0o0xi, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        IIX0o.x0xO0oo(lifecycleController, "this$0");
        IIX0o.x0xO0oo(oxio0o0xi, "$parentJob");
        IIX0o.x0xO0oo(lifecycleOwner, "source");
        IIX0o.x0xO0oo(event, "<anonymous parameter 1>");
        if (lifecycleOwner.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) {
            oXIO0o0XI.oIX0oI.II0xO0(oxio0o0xi, (CancellationException) null, 1, (Object) null);
            lifecycleController.finish();
        } else if (lifecycleOwner.getLifecycle().getCurrentState().compareTo(lifecycleController.minState) < 0) {
            lifecycleController.dispatchQueue.pause();
        } else {
            lifecycleController.dispatchQueue.resume();
        }
    }

    @MainThread
    public final void finish() {
        this.lifecycle.removeObserver(this.observer);
        this.dispatchQueue.finish();
    }
}
