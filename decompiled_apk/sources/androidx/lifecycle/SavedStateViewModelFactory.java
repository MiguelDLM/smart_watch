package androidx.lifecycle;

import android.annotation.SuppressLint;
import android.app.Application;
import android.os.Bundle;
import androidx.annotation.RestrictTo;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import java.lang.reflect.Constructor;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes.dex */
public final class SavedStateViewModelFactory extends ViewModelProvider.OnRequeryFactory implements ViewModelProvider.Factory {

    @OXOo.oOoXoXO
    private Application application;

    @OXOo.oOoXoXO
    private Bundle defaultArgs;

    @OXOo.OOXIXo
    private final ViewModelProvider.Factory factory;

    @OXOo.oOoXoXO
    private Lifecycle lifecycle;

    @OXOo.oOoXoXO
    private SavedStateRegistry savedStateRegistry;

    public SavedStateViewModelFactory() {
        this.factory = new ViewModelProvider.AndroidViewModelFactory();
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    @OXOo.OOXIXo
    public <T extends ViewModel> T create(@OXOo.OOXIXo Class<T> modelClass, @OXOo.OOXIXo CreationExtras extras) {
        Constructor findMatchingConstructor;
        IIX0o.x0xO0oo(modelClass, "modelClass");
        IIX0o.x0xO0oo(extras, "extras");
        String str = (String) extras.get(ViewModelProvider.NewInstanceFactory.VIEW_MODEL_KEY);
        if (str != null) {
            if (extras.get(SavedStateHandleSupport.SAVED_STATE_REGISTRY_OWNER_KEY) != null && extras.get(SavedStateHandleSupport.VIEW_MODEL_STORE_OWNER_KEY) != null) {
                Application application = (Application) extras.get(ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY);
                boolean isAssignableFrom = AndroidViewModel.class.isAssignableFrom(modelClass);
                if (isAssignableFrom && application != null) {
                    findMatchingConstructor = SavedStateViewModelFactoryKt.findMatchingConstructor(modelClass, SavedStateViewModelFactoryKt.access$getANDROID_VIEWMODEL_SIGNATURE$p());
                } else {
                    findMatchingConstructor = SavedStateViewModelFactoryKt.findMatchingConstructor(modelClass, SavedStateViewModelFactoryKt.access$getVIEWMODEL_SIGNATURE$p());
                }
                if (findMatchingConstructor == null) {
                    return (T) this.factory.create(modelClass, extras);
                }
                return (!isAssignableFrom || application == null) ? (T) SavedStateViewModelFactoryKt.newInstance(modelClass, findMatchingConstructor, SavedStateHandleSupport.createSavedStateHandle(extras)) : (T) SavedStateViewModelFactoryKt.newInstance(modelClass, findMatchingConstructor, application, SavedStateHandleSupport.createSavedStateHandle(extras));
            }
            if (this.lifecycle != null) {
                return (T) create(str, modelClass);
            }
            throw new IllegalStateException("SAVED_STATE_REGISTRY_OWNER_KEY andVIEW_MODEL_STORE_OWNER_KEY must be provided in the creation extras tosuccessfully create a ViewModel.");
        }
        throw new IllegalStateException("VIEW_MODEL_KEY must always be provided by ViewModelProvider");
    }

    @Override // androidx.lifecycle.ViewModelProvider.OnRequeryFactory
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void onRequery(@OXOo.OOXIXo ViewModel viewModel) {
        IIX0o.x0xO0oo(viewModel, "viewModel");
        if (this.lifecycle != null) {
            SavedStateRegistry savedStateRegistry = this.savedStateRegistry;
            IIX0o.ooOOo0oXI(savedStateRegistry);
            Lifecycle lifecycle = this.lifecycle;
            IIX0o.ooOOo0oXI(lifecycle);
            LegacySavedStateHandleController.attachHandleIfNeeded(viewModel, savedStateRegistry, lifecycle);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SavedStateViewModelFactory(@OXOo.oOoXoXO Application application, @OXOo.OOXIXo SavedStateRegistryOwner owner) {
        this(application, owner, null);
        IIX0o.x0xO0oo(owner, "owner");
    }

    @SuppressLint({"LambdaLast"})
    public SavedStateViewModelFactory(@OXOo.oOoXoXO Application application, @OXOo.OOXIXo SavedStateRegistryOwner owner, @OXOo.oOoXoXO Bundle bundle) {
        ViewModelProvider.AndroidViewModelFactory androidViewModelFactory;
        IIX0o.x0xO0oo(owner, "owner");
        this.savedStateRegistry = owner.getSavedStateRegistry();
        this.lifecycle = owner.getLifecycle();
        this.defaultArgs = bundle;
        this.application = application;
        if (application != null) {
            androidViewModelFactory = ViewModelProvider.AndroidViewModelFactory.Companion.getInstance(application);
        } else {
            androidViewModelFactory = new ViewModelProvider.AndroidViewModelFactory();
        }
        this.factory = androidViewModelFactory;
    }

    @OXOo.OOXIXo
    public final <T extends ViewModel> T create(@OXOo.OOXIXo String key, @OXOo.OOXIXo Class<T> modelClass) {
        Constructor findMatchingConstructor;
        T t;
        Application application;
        IIX0o.x0xO0oo(key, "key");
        IIX0o.x0xO0oo(modelClass, "modelClass");
        Lifecycle lifecycle = this.lifecycle;
        if (lifecycle != null) {
            boolean isAssignableFrom = AndroidViewModel.class.isAssignableFrom(modelClass);
            if (isAssignableFrom && this.application != null) {
                findMatchingConstructor = SavedStateViewModelFactoryKt.findMatchingConstructor(modelClass, SavedStateViewModelFactoryKt.access$getANDROID_VIEWMODEL_SIGNATURE$p());
            } else {
                findMatchingConstructor = SavedStateViewModelFactoryKt.findMatchingConstructor(modelClass, SavedStateViewModelFactoryKt.access$getVIEWMODEL_SIGNATURE$p());
            }
            if (findMatchingConstructor == null) {
                return this.application != null ? (T) this.factory.create(modelClass) : (T) ViewModelProvider.NewInstanceFactory.Companion.getInstance().create(modelClass);
            }
            SavedStateRegistry savedStateRegistry = this.savedStateRegistry;
            IIX0o.ooOOo0oXI(savedStateRegistry);
            SavedStateHandleController create = LegacySavedStateHandleController.create(savedStateRegistry, lifecycle, key, this.defaultArgs);
            if (!isAssignableFrom || (application = this.application) == null) {
                t = (T) SavedStateViewModelFactoryKt.newInstance(modelClass, findMatchingConstructor, create.getHandle());
            } else {
                IIX0o.ooOOo0oXI(application);
                t = (T) SavedStateViewModelFactoryKt.newInstance(modelClass, findMatchingConstructor, application, create.getHandle());
            }
            t.setTagIfAbsent("androidx.lifecycle.savedstate.vm.tag", create);
            return t;
        }
        throw new UnsupportedOperationException("SavedStateViewModelFactory constructed with empty constructor supports only calls to create(modelClass: Class<T>, extras: CreationExtras).");
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    @OXOo.OOXIXo
    public <T extends ViewModel> T create(@OXOo.OOXIXo Class<T> modelClass) {
        IIX0o.x0xO0oo(modelClass, "modelClass");
        String canonicalName = modelClass.getCanonicalName();
        if (canonicalName != null) {
            return (T) create(canonicalName, modelClass);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }
}
