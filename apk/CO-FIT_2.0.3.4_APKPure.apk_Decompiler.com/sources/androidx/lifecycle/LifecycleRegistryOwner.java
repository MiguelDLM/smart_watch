package androidx.lifecycle;

import androidx.annotation.NonNull;

@Deprecated
public interface LifecycleRegistryOwner extends LifecycleOwner {
    @NonNull
    /* bridge */ /* synthetic */ Lifecycle getLifecycle();

    @NonNull
    LifecycleRegistry getLifecycle();
}
