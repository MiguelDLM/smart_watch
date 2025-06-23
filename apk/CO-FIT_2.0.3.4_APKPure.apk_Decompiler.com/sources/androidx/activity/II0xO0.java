package androidx.activity;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

public final /* synthetic */ class II0xO0 implements LifecycleEventObserver {

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ ComponentActivity f253XO;

    public /* synthetic */ II0xO0(ComponentActivity componentActivity) {
        this.f253XO = componentActivity;
    }

    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        ComponentActivity._init_$lambda$2(this.f253XO, lifecycleOwner, event);
    }
}
