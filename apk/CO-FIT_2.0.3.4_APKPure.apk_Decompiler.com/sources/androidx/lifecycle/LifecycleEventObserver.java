package androidx.lifecycle;

import OXOo.OOXIXo;
import androidx.lifecycle.Lifecycle;

public interface LifecycleEventObserver extends LifecycleObserver {
    void onStateChanged(@OOXIXo LifecycleOwner lifecycleOwner, @OOXIXo Lifecycle.Event event);
}
