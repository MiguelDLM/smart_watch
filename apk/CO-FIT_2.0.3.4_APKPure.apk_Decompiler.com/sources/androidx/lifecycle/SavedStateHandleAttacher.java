package androidx.lifecycle;

import OXOo.OOXIXo;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.Lifecycle;
import kotlin.jvm.internal.IIX0o;

public final class SavedStateHandleAttacher implements LifecycleEventObserver {
    @OOXIXo
    private final SavedStateHandlesProvider provider;

    public SavedStateHandleAttacher(@OOXIXo SavedStateHandlesProvider savedStateHandlesProvider) {
        IIX0o.x0xO0oo(savedStateHandlesProvider, "provider");
        this.provider = savedStateHandlesProvider;
    }

    public void onStateChanged(@OOXIXo LifecycleOwner lifecycleOwner, @OOXIXo Lifecycle.Event event) {
        IIX0o.x0xO0oo(lifecycleOwner, "source");
        IIX0o.x0xO0oo(event, NotificationCompat.CATEGORY_EVENT);
        if (event == Lifecycle.Event.ON_CREATE) {
            lifecycleOwner.getLifecycle().removeObserver(this);
            this.provider.performRestore();
            return;
        }
        throw new IllegalStateException(("Next event must be ON_CREATE, it was " + event).toString());
    }
}
