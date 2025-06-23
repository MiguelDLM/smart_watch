package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes.dex */
public final class SavedStateHandleAttacher implements LifecycleEventObserver {

    @OXOo.OOXIXo
    private final SavedStateHandlesProvider provider;

    public SavedStateHandleAttacher(@OXOo.OOXIXo SavedStateHandlesProvider provider) {
        IIX0o.x0xO0oo(provider, "provider");
        this.provider = provider;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(@OXOo.OOXIXo LifecycleOwner source, @OXOo.OOXIXo Lifecycle.Event event) {
        IIX0o.x0xO0oo(source, "source");
        IIX0o.x0xO0oo(event, "event");
        if (event == Lifecycle.Event.ON_CREATE) {
            source.getLifecycle().removeObserver(this);
            this.provider.performRestore();
        } else {
            throw new IllegalStateException(("Next event must be ON_CREATE, it was " + event).toString());
        }
    }
}
