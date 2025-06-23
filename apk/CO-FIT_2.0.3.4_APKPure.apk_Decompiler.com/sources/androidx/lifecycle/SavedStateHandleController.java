package androidx.lifecycle;

import OXOo.OOXIXo;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.Lifecycle;
import androidx.savedstate.SavedStateRegistry;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nSavedStateHandleController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SavedStateHandleController.kt\nandroidx/lifecycle/SavedStateHandleController\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,41:1\n1#2:42\n*E\n"})
public final class SavedStateHandleController implements LifecycleEventObserver {
    @OOXIXo
    private final SavedStateHandle handle;
    private boolean isAttached;
    @OOXIXo
    private final String key;

    public SavedStateHandleController(@OOXIXo String str, @OOXIXo SavedStateHandle savedStateHandle) {
        IIX0o.x0xO0oo(str, "key");
        IIX0o.x0xO0oo(savedStateHandle, "handle");
        this.key = str;
        this.handle = savedStateHandle;
    }

    public final void attachToLifecycle(@OOXIXo SavedStateRegistry savedStateRegistry, @OOXIXo Lifecycle lifecycle) {
        IIX0o.x0xO0oo(savedStateRegistry, "registry");
        IIX0o.x0xO0oo(lifecycle, RequestParameters.SUBRESOURCE_LIFECYCLE);
        if (!this.isAttached) {
            this.isAttached = true;
            lifecycle.addObserver(this);
            savedStateRegistry.registerSavedStateProvider(this.key, this.handle.savedStateProvider());
            return;
        }
        throw new IllegalStateException("Already attached to lifecycleOwner");
    }

    @OOXIXo
    public final SavedStateHandle getHandle() {
        return this.handle;
    }

    public final boolean isAttached() {
        return this.isAttached;
    }

    public void onStateChanged(@OOXIXo LifecycleOwner lifecycleOwner, @OOXIXo Lifecycle.Event event) {
        IIX0o.x0xO0oo(lifecycleOwner, "source");
        IIX0o.x0xO0oo(event, NotificationCompat.CATEGORY_EVENT);
        if (event == Lifecycle.Event.ON_DESTROY) {
            this.isAttached = false;
            lifecycleOwner.getLifecycle().removeObserver(this);
        }
    }
}
