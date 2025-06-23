package androidx.activity;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

public final /* synthetic */ class I0Io implements LifecycleEventObserver {

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ ComponentActivity f249XO;

    public /* synthetic */ I0Io(ComponentActivity componentActivity) {
        this.f249XO = componentActivity;
    }

    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        ComponentActivity._init_$lambda$3(this.f249XO, lifecycleOwner, event);
    }
}
