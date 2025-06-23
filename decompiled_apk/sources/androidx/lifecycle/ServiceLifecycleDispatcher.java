package androidx.lifecycle;

import android.os.Handler;
import androidx.lifecycle.Lifecycle;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes.dex */
public class ServiceLifecycleDispatcher {

    @OXOo.OOXIXo
    private final Handler handler;

    @OXOo.oOoXoXO
    private DispatchRunnable lastDispatchRunnable;

    @OXOo.OOXIXo
    private final LifecycleRegistry registry;

    /* loaded from: classes.dex */
    public static final class DispatchRunnable implements Runnable {

        @OXOo.OOXIXo
        private final Lifecycle.Event event;

        @OXOo.OOXIXo
        private final LifecycleRegistry registry;
        private boolean wasExecuted;

        public DispatchRunnable(@OXOo.OOXIXo LifecycleRegistry registry, @OXOo.OOXIXo Lifecycle.Event event) {
            IIX0o.x0xO0oo(registry, "registry");
            IIX0o.x0xO0oo(event, "event");
            this.registry = registry;
            this.event = event;
        }

        @OXOo.OOXIXo
        public final Lifecycle.Event getEvent() {
            return this.event;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.wasExecuted) {
                this.registry.handleLifecycleEvent(this.event);
                this.wasExecuted = true;
            }
        }
    }

    public ServiceLifecycleDispatcher(@OXOo.OOXIXo LifecycleOwner provider) {
        IIX0o.x0xO0oo(provider, "provider");
        this.registry = new LifecycleRegistry(provider);
        this.handler = new Handler();
    }

    private final void postDispatchRunnable(Lifecycle.Event event) {
        DispatchRunnable dispatchRunnable = this.lastDispatchRunnable;
        if (dispatchRunnable != null) {
            dispatchRunnable.run();
        }
        DispatchRunnable dispatchRunnable2 = new DispatchRunnable(this.registry, event);
        this.lastDispatchRunnable = dispatchRunnable2;
        Handler handler = this.handler;
        IIX0o.ooOOo0oXI(dispatchRunnable2);
        handler.postAtFrontOfQueue(dispatchRunnable2);
    }

    @OXOo.OOXIXo
    public Lifecycle getLifecycle() {
        return this.registry;
    }

    public void onServicePreSuperOnBind() {
        postDispatchRunnable(Lifecycle.Event.ON_START);
    }

    public void onServicePreSuperOnCreate() {
        postDispatchRunnable(Lifecycle.Event.ON_CREATE);
    }

    public void onServicePreSuperOnDestroy() {
        postDispatchRunnable(Lifecycle.Event.ON_STOP);
        postDispatchRunnable(Lifecycle.Event.ON_DESTROY);
    }

    public void onServicePreSuperOnStart() {
        postDispatchRunnable(Lifecycle.Event.ON_START);
    }
}
