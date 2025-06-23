package androidx.savedstate;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

public final /* synthetic */ class oIX0oI implements LifecycleEventObserver {

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ SavedStateRegistry f484XO;

    public /* synthetic */ oIX0oI(SavedStateRegistry savedStateRegistry) {
        this.f484XO = savedStateRegistry;
    }

    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        SavedStateRegistry.performAttach$lambda$4(this.f484XO, lifecycleOwner, event);
    }
}
