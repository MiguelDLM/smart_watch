package androidx.savedstate;

import OXOo.OOXIXo;
import androidx.lifecycle.LifecycleOwner;

public interface SavedStateRegistryOwner extends LifecycleOwner {
    @OOXIXo
    SavedStateRegistry getSavedStateRegistry();
}
