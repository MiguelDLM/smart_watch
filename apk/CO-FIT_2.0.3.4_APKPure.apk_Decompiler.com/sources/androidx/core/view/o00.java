package androidx.core.view;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

public final /* synthetic */ class o00 implements LifecycleEventObserver {

    /* renamed from: Oo  reason: collision with root package name */
    public final /* synthetic */ MenuProvider f378Oo;

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ MenuHostHelper f379XO;

    public /* synthetic */ o00(MenuHostHelper menuHostHelper, MenuProvider menuProvider) {
        this.f379XO = menuHostHelper;
        this.f378Oo = menuProvider;
    }

    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        this.f379XO.lambda$addMenuProvider$0(this.f378Oo, lifecycleOwner, event);
    }
}
