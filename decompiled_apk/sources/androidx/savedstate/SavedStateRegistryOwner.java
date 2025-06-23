package androidx.savedstate;

import OXOo.OOXIXo;
import androidx.lifecycle.LifecycleOwner;

/* loaded from: classes.dex */
public interface SavedStateRegistryOwner extends LifecycleOwner {
    @OOXIXo
    SavedStateRegistry getSavedStateRegistry();
}
