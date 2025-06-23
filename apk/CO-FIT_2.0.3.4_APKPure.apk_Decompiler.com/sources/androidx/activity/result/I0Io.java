package androidx.activity.result;

import androidx.activity.result.contract.ActivityResultContract;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

public final /* synthetic */ class I0Io implements LifecycleEventObserver {

    /* renamed from: IXxxXO  reason: collision with root package name */
    public final /* synthetic */ ActivityResultCallback f268IXxxXO;

    /* renamed from: Oo  reason: collision with root package name */
    public final /* synthetic */ String f269Oo;

    /* renamed from: Oxx0xo  reason: collision with root package name */
    public final /* synthetic */ ActivityResultContract f270Oxx0xo;

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ ActivityResultRegistry f271XO;

    public /* synthetic */ I0Io(ActivityResultRegistry activityResultRegistry, String str, ActivityResultCallback activityResultCallback, ActivityResultContract activityResultContract) {
        this.f271XO = activityResultRegistry;
        this.f269Oo = str;
        this.f268IXxxXO = activityResultCallback;
        this.f270Oxx0xo = activityResultContract;
    }

    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        ActivityResultRegistry.register$lambda$1(this.f271XO, this.f269Oo, this.f268IXxxXO, this.f270Oxx0xo, lifecycleOwner, event);
    }
}
