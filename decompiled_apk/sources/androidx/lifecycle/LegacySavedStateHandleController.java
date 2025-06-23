package androidx.lifecycle;

import XO0OX.x0XOIxOo;
import android.os.Bundle;
import androidx.lifecycle.LegacySavedStateHandleController;
import androidx.lifecycle.Lifecycle;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import java.util.Iterator;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes.dex */
public final class LegacySavedStateHandleController {

    @OXOo.OOXIXo
    public static final LegacySavedStateHandleController INSTANCE = new LegacySavedStateHandleController();

    @OXOo.OOXIXo
    public static final String TAG_SAVED_STATE_HANDLE_CONTROLLER = "androidx.lifecycle.savedstate.vm.tag";

    /* loaded from: classes.dex */
    public static final class OnRecreation implements SavedStateRegistry.AutoRecreated {
        @Override // androidx.savedstate.SavedStateRegistry.AutoRecreated
        public void onRecreated(@OXOo.OOXIXo SavedStateRegistryOwner owner) {
            IIX0o.x0xO0oo(owner, "owner");
            if (owner instanceof ViewModelStoreOwner) {
                ViewModelStore viewModelStore = ((ViewModelStoreOwner) owner).getViewModelStore();
                SavedStateRegistry savedStateRegistry = owner.getSavedStateRegistry();
                Iterator<String> it = viewModelStore.keys().iterator();
                while (it.hasNext()) {
                    ViewModel viewModel = viewModelStore.get(it.next());
                    IIX0o.ooOOo0oXI(viewModel);
                    LegacySavedStateHandleController.attachHandleIfNeeded(viewModel, savedStateRegistry, owner.getLifecycle());
                }
                if (!viewModelStore.keys().isEmpty()) {
                    savedStateRegistry.runOnNextRecreation(OnRecreation.class);
                    return;
                }
                return;
            }
            throw new IllegalStateException("Internal error: OnRecreation should be registered only on components that implement ViewModelStoreOwner");
        }
    }

    private LegacySavedStateHandleController() {
    }

    @x0XOIxOo
    public static final void attachHandleIfNeeded(@OXOo.OOXIXo ViewModel viewModel, @OXOo.OOXIXo SavedStateRegistry registry, @OXOo.OOXIXo Lifecycle lifecycle) {
        IIX0o.x0xO0oo(viewModel, "viewModel");
        IIX0o.x0xO0oo(registry, "registry");
        IIX0o.x0xO0oo(lifecycle, "lifecycle");
        SavedStateHandleController savedStateHandleController = (SavedStateHandleController) viewModel.getTag("androidx.lifecycle.savedstate.vm.tag");
        if (savedStateHandleController != null && !savedStateHandleController.isAttached()) {
            savedStateHandleController.attachToLifecycle(registry, lifecycle);
            INSTANCE.tryToAddRecreator(registry, lifecycle);
        }
    }

    @x0XOIxOo
    @OXOo.OOXIXo
    public static final SavedStateHandleController create(@OXOo.OOXIXo SavedStateRegistry registry, @OXOo.OOXIXo Lifecycle lifecycle, @OXOo.oOoXoXO String str, @OXOo.oOoXoXO Bundle bundle) {
        IIX0o.x0xO0oo(registry, "registry");
        IIX0o.x0xO0oo(lifecycle, "lifecycle");
        IIX0o.ooOOo0oXI(str);
        SavedStateHandleController savedStateHandleController = new SavedStateHandleController(str, SavedStateHandle.Companion.createHandle(registry.consumeRestoredStateForKey(str), bundle));
        savedStateHandleController.attachToLifecycle(registry, lifecycle);
        INSTANCE.tryToAddRecreator(registry, lifecycle);
        return savedStateHandleController;
    }

    private final void tryToAddRecreator(final SavedStateRegistry savedStateRegistry, final Lifecycle lifecycle) {
        Lifecycle.State currentState = lifecycle.getCurrentState();
        if (currentState != Lifecycle.State.INITIALIZED && !currentState.isAtLeast(Lifecycle.State.STARTED)) {
            lifecycle.addObserver(new LifecycleEventObserver() { // from class: androidx.lifecycle.LegacySavedStateHandleController$tryToAddRecreator$1
                @Override // androidx.lifecycle.LifecycleEventObserver
                public void onStateChanged(@OXOo.OOXIXo LifecycleOwner source, @OXOo.OOXIXo Lifecycle.Event event) {
                    IIX0o.x0xO0oo(source, "source");
                    IIX0o.x0xO0oo(event, "event");
                    if (event == Lifecycle.Event.ON_START) {
                        Lifecycle.this.removeObserver(this);
                        savedStateRegistry.runOnNextRecreation(LegacySavedStateHandleController.OnRecreation.class);
                    }
                }
            });
        } else {
            savedStateRegistry.runOnNextRecreation(OnRecreation.class);
        }
    }
}
