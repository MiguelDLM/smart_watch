package androidx.navigation;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

public final /* synthetic */ class oIX0oI implements LifecycleEventObserver {

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ NavController f420XO;

    public /* synthetic */ oIX0oI(NavController navController) {
        this.f420XO = navController;
    }

    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        NavController.lifecycleObserver$lambda$2(this.f420XO, lifecycleOwner, event);
    }
}
