package androidx.lifecycle;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.os.Bundle;
import androidx.annotation.RestrictTo;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

public abstract class AbstractSavedStateViewModelFactory extends ViewModelProvider.OnRequeryFactory implements ViewModelProvider.Factory {
    @OOXIXo
    public static final Companion Companion = new Companion((IIXOooo) null);
    @OOXIXo
    public static final String TAG_SAVED_STATE_HANDLE_CONTROLLER = "androidx.lifecycle.savedstate.vm.tag";
    @oOoXoXO
    private Bundle defaultArgs;
    @oOoXoXO
    private Lifecycle lifecycle;
    @oOoXoXO
    private SavedStateRegistry savedStateRegistry;

    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public AbstractSavedStateViewModelFactory() {
    }

    @OOXIXo
    public <T extends ViewModel> T create(@OOXIXo Class<T> cls, @OOXIXo CreationExtras creationExtras) {
        IIX0o.x0xO0oo(cls, "modelClass");
        IIX0o.x0xO0oo(creationExtras, "extras");
        String str = (String) creationExtras.get(ViewModelProvider.NewInstanceFactory.VIEW_MODEL_KEY);
        if (str == null) {
            throw new IllegalStateException("VIEW_MODEL_KEY must always be provided by ViewModelProvider");
        } else if (this.savedStateRegistry != null) {
            return create(str, cls);
        } else {
            return create(str, cls, SavedStateHandleSupport.createSavedStateHandle(creationExtras));
        }
    }

    @OOXIXo
    public abstract <T extends ViewModel> T create(@OOXIXo String str, @OOXIXo Class<T> cls, @OOXIXo SavedStateHandle savedStateHandle);

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void onRequery(@OOXIXo ViewModel viewModel) {
        IIX0o.x0xO0oo(viewModel, "viewModel");
        SavedStateRegistry savedStateRegistry2 = this.savedStateRegistry;
        if (savedStateRegistry2 != null) {
            IIX0o.ooOOo0oXI(savedStateRegistry2);
            Lifecycle lifecycle2 = this.lifecycle;
            IIX0o.ooOOo0oXI(lifecycle2);
            LegacySavedStateHandleController.attachHandleIfNeeded(viewModel, savedStateRegistry2, lifecycle2);
        }
    }

    public AbstractSavedStateViewModelFactory(@OOXIXo SavedStateRegistryOwner savedStateRegistryOwner, @oOoXoXO Bundle bundle) {
        IIX0o.x0xO0oo(savedStateRegistryOwner, "owner");
        this.savedStateRegistry = savedStateRegistryOwner.getSavedStateRegistry();
        this.lifecycle = savedStateRegistryOwner.getLifecycle();
        this.defaultArgs = bundle;
    }

    private final <T extends ViewModel> T create(String str, Class<T> cls) {
        SavedStateRegistry savedStateRegistry2 = this.savedStateRegistry;
        IIX0o.ooOOo0oXI(savedStateRegistry2);
        Lifecycle lifecycle2 = this.lifecycle;
        IIX0o.ooOOo0oXI(lifecycle2);
        SavedStateHandleController create = LegacySavedStateHandleController.create(savedStateRegistry2, lifecycle2, str, this.defaultArgs);
        T create2 = create(str, cls, create.getHandle());
        create2.setTagIfAbsent("androidx.lifecycle.savedstate.vm.tag", create);
        return create2;
    }

    @OOXIXo
    public <T extends ViewModel> T create(@OOXIXo Class<T> cls) {
        IIX0o.x0xO0oo(cls, "modelClass");
        String canonicalName = cls.getCanonicalName();
        if (canonicalName == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        } else if (this.lifecycle != null) {
            return create(canonicalName, cls);
        } else {
            throw new UnsupportedOperationException("AbstractSavedStateViewModelFactory constructed with empty constructor supports only calls to create(modelClass: Class<T>, extras: CreationExtras).");
        }
    }
}
