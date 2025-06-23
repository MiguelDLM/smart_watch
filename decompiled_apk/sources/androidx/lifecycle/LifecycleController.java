package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.lifecycle.Lifecycle;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlinx.coroutines.oXIO0o0XI;

@XX({"SMAP\nLifecycleController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LifecycleController.kt\nandroidx/lifecycle/LifecycleController\n*L\n1#1,70:1\n57#1,3:71\n57#1,3:74\n*S KotlinDebug\n*F\n+ 1 LifecycleController.kt\nandroidx/lifecycle/LifecycleController\n*L\n49#1:71,3\n36#1:74,3\n*E\n"})
@MainThread
/* loaded from: classes.dex */
public final class LifecycleController {

    @OXOo.OOXIXo
    private final DispatchQueue dispatchQueue;

    @OXOo.OOXIXo
    private final Lifecycle lifecycle;

    @OXOo.OOXIXo
    private final Lifecycle.State minState;

    @OXOo.OOXIXo
    private final LifecycleEventObserver observer;

    public LifecycleController(@OXOo.OOXIXo Lifecycle lifecycle, @OXOo.OOXIXo Lifecycle.State minState, @OXOo.OOXIXo DispatchQueue dispatchQueue, @OXOo.OOXIXo final oXIO0o0XI parentJob) {
        IIX0o.x0xO0oo(lifecycle, "lifecycle");
        IIX0o.x0xO0oo(minState, "minState");
        IIX0o.x0xO0oo(dispatchQueue, "dispatchQueue");
        IIX0o.x0xO0oo(parentJob, "parentJob");
        this.lifecycle = lifecycle;
        this.minState = minState;
        this.dispatchQueue = dispatchQueue;
        LifecycleEventObserver lifecycleEventObserver = new LifecycleEventObserver() { // from class: androidx.lifecycle.XO
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                LifecycleController.observer$lambda$0(LifecycleController.this, parentJob, lifecycleOwner, event);
            }
        };
        this.observer = lifecycleEventObserver;
        if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
            oXIO0o0XI.oIX0oI.II0xO0(parentJob, null, 1, null);
            finish();
        } else {
            lifecycle.addObserver(lifecycleEventObserver);
        }
    }

    private final void handleDestroy(oXIO0o0XI oxio0o0xi) {
        oXIO0o0XI.oIX0oI.II0xO0(oxio0o0xi, null, 1, null);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void observer$lambda$0(LifecycleController this$0, oXIO0o0XI parentJob, LifecycleOwner source, Lifecycle.Event event) {
        IIX0o.x0xO0oo(this$0, "this$0");
        IIX0o.x0xO0oo(parentJob, "$parentJob");
        IIX0o.x0xO0oo(source, "source");
        IIX0o.x0xO0oo(event, "<anonymous parameter 1>");
        if (source.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) {
            oXIO0o0XI.oIX0oI.II0xO0(parentJob, null, 1, null);
            this$0.finish();
        } else if (source.getLifecycle().getCurrentState().compareTo(this$0.minState) < 0) {
            this$0.dispatchQueue.pause();
        } else {
            this$0.dispatchQueue.resume();
        }
    }

    @MainThread
    public final void finish() {
        this.lifecycle.removeObserver(this.observer);
        this.dispatchQueue.finish();
    }
}
