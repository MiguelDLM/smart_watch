package androidx.lifecycle;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.os.Handler;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.Lifecycle;
import kotlin.jvm.internal.IIX0o;

public class ServiceLifecycleDispatcher {
    @OOXIXo
    private final Handler handler = new Handler();
    @oOoXoXO
    private DispatchRunnable lastDispatchRunnable;
    @OOXIXo
    private final LifecycleRegistry registry;

    public static final class DispatchRunnable implements Runnable {
        @OOXIXo
        private final Lifecycle.Event event;
        @OOXIXo
        private final LifecycleRegistry registry;
        private boolean wasExecuted;

        public DispatchRunnable(@OOXIXo LifecycleRegistry lifecycleRegistry, @OOXIXo Lifecycle.Event event2) {
            IIX0o.x0xO0oo(lifecycleRegistry, "registry");
            IIX0o.x0xO0oo(event2, NotificationCompat.CATEGORY_EVENT);
            this.registry = lifecycleRegistry;
            this.event = event2;
        }

        @OOXIXo
        public final Lifecycle.Event getEvent() {
            return this.event;
        }

        public void run() {
            if (!this.wasExecuted) {
                this.registry.handleLifecycleEvent(this.event);
                this.wasExecuted = true;
            }
        }
    }

    public ServiceLifecycleDispatcher(@OOXIXo LifecycleOwner lifecycleOwner) {
        IIX0o.x0xO0oo(lifecycleOwner, "provider");
        this.registry = new LifecycleRegistry(lifecycleOwner);
    }

    private final void postDispatchRunnable(Lifecycle.Event event) {
        DispatchRunnable dispatchRunnable = this.lastDispatchRunnable;
        if (dispatchRunnable != null) {
            dispatchRunnable.run();
        }
        DispatchRunnable dispatchRunnable2 = new DispatchRunnable(this.registry, event);
        this.lastDispatchRunnable = dispatchRunnable2;
        Handler handler2 = this.handler;
        IIX0o.ooOOo0oXI(dispatchRunnable2);
        handler2.postAtFrontOfQueue(dispatchRunnable2);
    }

    @OOXIXo
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
