package androidx.core.view;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

public final /* synthetic */ class xoXoI implements LifecycleEventObserver {

    /* renamed from: IXxxXO  reason: collision with root package name */
    public final /* synthetic */ MenuProvider f382IXxxXO;

    /* renamed from: Oo  reason: collision with root package name */
    public final /* synthetic */ Lifecycle.State f383Oo;

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ MenuHostHelper f384XO;

    public /* synthetic */ xoXoI(MenuHostHelper menuHostHelper, Lifecycle.State state, MenuProvider menuProvider) {
        this.f384XO = menuHostHelper;
        this.f383Oo = state;
        this.f382IXxxXO = menuProvider;
    }

    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        this.f384XO.lambda$addMenuProvider$1(this.f383Oo, this.f382IXxxXO, lifecycleOwner, event);
    }
}
