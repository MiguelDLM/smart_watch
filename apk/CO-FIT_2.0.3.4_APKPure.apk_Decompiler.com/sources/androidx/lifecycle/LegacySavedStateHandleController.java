package androidx.lifecycle;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.x0XOIxOo;
import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import kotlin.jvm.internal.IIX0o;

public final class LegacySavedStateHandleController {
    @OOXIXo
    public static final LegacySavedStateHandleController INSTANCE = new LegacySavedStateHandleController();
    @OOXIXo
    public static final String TAG_SAVED_STATE_HANDLE_CONTROLLER = "androidx.lifecycle.savedstate.vm.tag";

    public static final class OnRecreation implements SavedStateRegistry.AutoRecreated {
        public void onRecreated(@OOXIXo SavedStateRegistryOwner savedStateRegistryOwner) {
            IIX0o.x0xO0oo(savedStateRegistryOwner, "owner");
            if (savedStateRegistryOwner instanceof ViewModelStoreOwner) {
                ViewModelStore viewModelStore = ((ViewModelStoreOwner) savedStateRegistryOwner).getViewModelStore();
                SavedStateRegistry savedStateRegistry = savedStateRegistryOwner.getSavedStateRegistry();
                for (String str : viewModelStore.keys()) {
                    ViewModel viewModel = viewModelStore.get(str);
                    IIX0o.ooOOo0oXI(viewModel);
                    LegacySavedStateHandleController.attachHandleIfNeeded(viewModel, savedStateRegistry, savedStateRegistryOwner.getLifecycle());
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
    public static final void attachHandleIfNeeded(@OOXIXo ViewModel viewModel, @OOXIXo SavedStateRegistry savedStateRegistry, @OOXIXo Lifecycle lifecycle) {
        IIX0o.x0xO0oo(viewModel, "viewModel");
        IIX0o.x0xO0oo(savedStateRegistry, "registry");
        IIX0o.x0xO0oo(lifecycle, RequestParameters.SUBRESOURCE_LIFECYCLE);
        SavedStateHandleController savedStateHandleController = (SavedStateHandleController) viewModel.getTag("androidx.lifecycle.savedstate.vm.tag");
        if (savedStateHandleController != null && !savedStateHandleController.isAttached()) {
            savedStateHandleController.attachToLifecycle(savedStateRegistry, lifecycle);
            INSTANCE.tryToAddRecreator(savedStateRegistry, lifecycle);
        }
    }

    @x0XOIxOo
    @OOXIXo
    public static final SavedStateHandleController create(@OOXIXo SavedStateRegistry savedStateRegistry, @OOXIXo Lifecycle lifecycle, @oOoXoXO String str, @oOoXoXO Bundle bundle) {
        IIX0o.x0xO0oo(savedStateRegistry, "registry");
        IIX0o.x0xO0oo(lifecycle, RequestParameters.SUBRESOURCE_LIFECYCLE);
        IIX0o.ooOOo0oXI(str);
        SavedStateHandleController savedStateHandleController = new SavedStateHandleController(str, SavedStateHandle.Companion.createHandle(savedStateRegistry.consumeRestoredStateForKey(str), bundle));
        savedStateHandleController.attachToLifecycle(savedStateRegistry, lifecycle);
        INSTANCE.tryToAddRecreator(savedStateRegistry, lifecycle);
        return savedStateHandleController;
    }

    private final void tryToAddRecreator(SavedStateRegistry savedStateRegistry, Lifecycle lifecycle) {
        Lifecycle.State currentState = lifecycle.getCurrentState();
        if (currentState == Lifecycle.State.INITIALIZED || currentState.isAtLeast(Lifecycle.State.STARTED)) {
            savedStateRegistry.runOnNextRecreation(OnRecreation.class);
        } else {
            lifecycle.addObserver(new LegacySavedStateHandleController$tryToAddRecreator$1(lifecycle, savedStateRegistry));
        }
    }
}
