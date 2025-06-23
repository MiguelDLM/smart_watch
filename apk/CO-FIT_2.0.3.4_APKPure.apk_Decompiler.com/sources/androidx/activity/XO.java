package androidx.activity;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

public final /* synthetic */ class XO implements LifecycleEventObserver {

    /* renamed from: Oo  reason: collision with root package name */
    public final /* synthetic */ ComponentActivity f262Oo;

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ OnBackPressedDispatcher f263XO;

    public /* synthetic */ XO(OnBackPressedDispatcher onBackPressedDispatcher, ComponentActivity componentActivity) {
        this.f263XO = onBackPressedDispatcher;
        this.f262Oo = componentActivity;
    }

    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        ComponentActivity.addObserverForBackInvoker$lambda$7(this.f263XO, this.f262Oo, lifecycleOwner, event);
    }
}
