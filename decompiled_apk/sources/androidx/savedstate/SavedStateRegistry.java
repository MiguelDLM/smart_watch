package androidx.savedstate;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.annotation.MainThread;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.savedstate.Recreator;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nSavedStateRegistry.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SavedStateRegistry.kt\nandroidx/savedstate/SavedStateRegistry\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,272:1\n1#2:273\n*E\n"})
@SuppressLint({"RestrictedApi"})
/* loaded from: classes.dex */
public final class SavedStateRegistry {

    @OOXIXo
    private static final Companion Companion = new Companion(null);

    @OOXIXo
    @Deprecated
    private static final String SAVED_COMPONENTS_KEY = "androidx.lifecycle.BundlableSavedStateRegistry.key";
    private boolean attached;

    @OOXIXo
    private final SafeIterableMap<String, SavedStateProvider> components = new SafeIterableMap<>();
    private boolean isAllowingSavingState = true;
    private boolean isRestored;

    @oOoXoXO
    private Recreator.SavedStateProvider recreatorProvider;

    @oOoXoXO
    private Bundle restoredState;

    /* loaded from: classes.dex */
    public interface AutoRecreated {
        void onRecreated(@OOXIXo SavedStateRegistryOwner savedStateRegistryOwner);
    }

    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    /* loaded from: classes.dex */
    public interface SavedStateProvider {
        @OOXIXo
        Bundle saveState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void performAttach$lambda$4(SavedStateRegistry this$0, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        IIX0o.x0xO0oo(this$0, "this$0");
        IIX0o.x0xO0oo(lifecycleOwner, "<anonymous parameter 0>");
        IIX0o.x0xO0oo(event, "event");
        if (event == Lifecycle.Event.ON_START) {
            this$0.isAllowingSavingState = true;
        } else if (event == Lifecycle.Event.ON_STOP) {
            this$0.isAllowingSavingState = false;
        }
    }

    @oOoXoXO
    @MainThread
    public final Bundle consumeRestoredStateForKey(@OOXIXo String key) {
        Bundle bundle;
        IIX0o.x0xO0oo(key, "key");
        if (this.isRestored) {
            Bundle bundle2 = this.restoredState;
            if (bundle2 == null) {
                return null;
            }
            if (bundle2 != null) {
                bundle = bundle2.getBundle(key);
            } else {
                bundle = null;
            }
            Bundle bundle3 = this.restoredState;
            if (bundle3 != null) {
                bundle3.remove(key);
            }
            Bundle bundle4 = this.restoredState;
            if (bundle4 == null || bundle4.isEmpty()) {
                this.restoredState = null;
            }
            return bundle;
        }
        throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component");
    }

    @oOoXoXO
    public final SavedStateProvider getSavedStateProvider(@OOXIXo String key) {
        IIX0o.x0xO0oo(key, "key");
        Iterator<Map.Entry<String, SavedStateProvider>> it = this.components.iterator();
        while (it.hasNext()) {
            Map.Entry<String, SavedStateProvider> components = it.next();
            IIX0o.oO(components, "components");
            String key2 = components.getKey();
            SavedStateProvider value = components.getValue();
            if (IIX0o.Oxx0IOOO(key2, key)) {
                return value;
            }
        }
        return null;
    }

    public final boolean isAllowingSavingState$savedstate_release() {
        return this.isAllowingSavingState;
    }

    @MainThread
    public final boolean isRestored() {
        return this.isRestored;
    }

    @MainThread
    public final void performAttach$savedstate_release(@OOXIXo Lifecycle lifecycle) {
        IIX0o.x0xO0oo(lifecycle, "lifecycle");
        if (!this.attached) {
            lifecycle.addObserver(new LifecycleEventObserver() { // from class: androidx.savedstate.oIX0oI
                @Override // androidx.lifecycle.LifecycleEventObserver
                public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                    SavedStateRegistry.performAttach$lambda$4(SavedStateRegistry.this, lifecycleOwner, event);
                }
            });
            this.attached = true;
            return;
        }
        throw new IllegalStateException("SavedStateRegistry was already attached.");
    }

    @MainThread
    public final void performRestore$savedstate_release(@oOoXoXO Bundle bundle) {
        Bundle bundle2;
        if (this.attached) {
            if (!this.isRestored) {
                if (bundle != null) {
                    bundle2 = bundle.getBundle(SAVED_COMPONENTS_KEY);
                } else {
                    bundle2 = null;
                }
                this.restoredState = bundle2;
                this.isRestored = true;
                return;
            }
            throw new IllegalStateException("SavedStateRegistry was already restored.");
        }
        throw new IllegalStateException("You must call performAttach() before calling performRestore(Bundle).");
    }

    @MainThread
    public final void performSave(@OOXIXo Bundle outBundle) {
        IIX0o.x0xO0oo(outBundle, "outBundle");
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.restoredState;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        SafeIterableMap<String, SavedStateProvider>.IteratorWithAdditions iteratorWithAdditions = this.components.iteratorWithAdditions();
        IIX0o.oO(iteratorWithAdditions, "this.components.iteratorWithAdditions()");
        while (iteratorWithAdditions.hasNext()) {
            Map.Entry next = iteratorWithAdditions.next();
            bundle.putBundle((String) next.getKey(), ((SavedStateProvider) next.getValue()).saveState());
        }
        if (!bundle.isEmpty()) {
            outBundle.putBundle(SAVED_COMPONENTS_KEY, bundle);
        }
    }

    @MainThread
    public final void registerSavedStateProvider(@OOXIXo String key, @OOXIXo SavedStateProvider provider) {
        IIX0o.x0xO0oo(key, "key");
        IIX0o.x0xO0oo(provider, "provider");
        if (this.components.putIfAbsent(key, provider) == null) {
        } else {
            throw new IllegalArgumentException("SavedStateProvider with the given key is already registered");
        }
    }

    @MainThread
    public final void runOnNextRecreation(@OOXIXo Class<? extends AutoRecreated> clazz) {
        IIX0o.x0xO0oo(clazz, "clazz");
        if (this.isAllowingSavingState) {
            Recreator.SavedStateProvider savedStateProvider = this.recreatorProvider;
            if (savedStateProvider == null) {
                savedStateProvider = new Recreator.SavedStateProvider(this);
            }
            this.recreatorProvider = savedStateProvider;
            try {
                clazz.getDeclaredConstructor(null);
                Recreator.SavedStateProvider savedStateProvider2 = this.recreatorProvider;
                if (savedStateProvider2 != null) {
                    String name = clazz.getName();
                    IIX0o.oO(name, "clazz.name");
                    savedStateProvider2.add(name);
                    return;
                }
                return;
            } catch (NoSuchMethodException e) {
                throw new IllegalArgumentException("Class " + clazz.getSimpleName() + " must have default constructor in order to be automatically recreated", e);
            }
        }
        throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
    }

    public final void setAllowingSavingState$savedstate_release(boolean z) {
        this.isAllowingSavingState = z;
    }

    @MainThread
    public final void unregisterSavedStateProvider(@OOXIXo String key) {
        IIX0o.x0xO0oo(key, "key");
        this.components.remove(key);
    }
}
