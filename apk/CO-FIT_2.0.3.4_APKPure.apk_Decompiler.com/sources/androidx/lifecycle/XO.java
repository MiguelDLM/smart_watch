package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import kotlinx.coroutines.oXIO0o0XI;

public final /* synthetic */ class XO implements LifecycleEventObserver {

    /* renamed from: Oo  reason: collision with root package name */
    public final /* synthetic */ oXIO0o0XI f407Oo;

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ LifecycleController f408XO;

    public /* synthetic */ XO(LifecycleController lifecycleController, oXIO0o0XI oxio0o0xi) {
        this.f408XO = lifecycleController;
        this.f407Oo = oxio0o0xi;
    }

    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        LifecycleController.observer$lambda$0(this.f408XO, this.f407Oo, lifecycleOwner, event);
    }
}
