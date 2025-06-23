package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import androidx.savedstate.SavedStateRegistry;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nSavedStateHandleController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SavedStateHandleController.kt\nandroidx/lifecycle/SavedStateHandleController\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,41:1\n1#2:42\n*E\n"})
/* loaded from: classes.dex */
public final class SavedStateHandleController implements LifecycleEventObserver {

    @OXOo.OOXIXo
    private final SavedStateHandle handle;
    private boolean isAttached;

    @OXOo.OOXIXo
    private final String key;

    public SavedStateHandleController(@OXOo.OOXIXo String key, @OXOo.OOXIXo SavedStateHandle handle) {
        IIX0o.x0xO0oo(key, "key");
        IIX0o.x0xO0oo(handle, "handle");
        this.key = key;
        this.handle = handle;
    }

    public final void attachToLifecycle(@OXOo.OOXIXo SavedStateRegistry registry, @OXOo.OOXIXo Lifecycle lifecycle) {
        IIX0o.x0xO0oo(registry, "registry");
        IIX0o.x0xO0oo(lifecycle, "lifecycle");
        if (!this.isAttached) {
            this.isAttached = true;
            lifecycle.addObserver(this);
            registry.registerSavedStateProvider(this.key, this.handle.savedStateProvider());
            return;
        }
        throw new IllegalStateException("Already attached to lifecycleOwner");
    }

    @OXOo.OOXIXo
    public final SavedStateHandle getHandle() {
        return this.handle;
    }

    public final boolean isAttached() {
        return this.isAttached;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(@OXOo.OOXIXo LifecycleOwner source, @OXOo.OOXIXo Lifecycle.Event event) {
        IIX0o.x0xO0oo(source, "source");
        IIX0o.x0xO0oo(event, "event");
        if (event == Lifecycle.Event.ON_DESTROY) {
            this.isAttached = false;
            source.getLifecycle().removeObserver(this);
        }
    }
}
