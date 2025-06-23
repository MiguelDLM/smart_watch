package androidx.savedstate;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.annotation.MainThread;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.savedstate.Recreator;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;

@SuppressLint({"RestrictedApi"})
@XX({"SMAP\nSavedStateRegistry.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SavedStateRegistry.kt\nandroidx/savedstate/SavedStateRegistry\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,272:1\n1#2:273\n*E\n"})
public final class SavedStateRegistry {
    @OOXIXo
    private static final Companion Companion = new Companion((IIXOooo) null);
    @Deprecated
    @OOXIXo
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

    public interface AutoRecreated {
        void onRecreated(@OOXIXo SavedStateRegistryOwner savedStateRegistryOwner);
    }

    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public interface SavedStateProvider {
        @OOXIXo
        Bundle saveState();
    }

    /* access modifiers changed from: private */
    public static final void performAttach$lambda$4(SavedStateRegistry savedStateRegistry, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        IIX0o.x0xO0oo(savedStateRegistry, "this$0");
        IIX0o.x0xO0oo(lifecycleOwner, "<anonymous parameter 0>");
        IIX0o.x0xO0oo(event, NotificationCompat.CATEGORY_EVENT);
        if (event == Lifecycle.Event.ON_START) {
            savedStateRegistry.isAllowingSavingState = true;
        } else if (event == Lifecycle.Event.ON_STOP) {
            savedStateRegistry.isAllowingSavingState = false;
        }
    }

    @MainThread
    @oOoXoXO
    public final Bundle consumeRestoredStateForKey(@OOXIXo String str) {
        Bundle bundle;
        IIX0o.x0xO0oo(str, "key");
        if (this.isRestored) {
            Bundle bundle2 = this.restoredState;
            if (bundle2 == null) {
                return null;
            }
            if (bundle2 != null) {
                bundle = bundle2.getBundle(str);
            } else {
                bundle = null;
            }
            Bundle bundle3 = this.restoredState;
            if (bundle3 != null) {
                bundle3.remove(str);
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
    public final SavedStateProvider getSavedStateProvider(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "key");
        Iterator<Map.Entry<String, SavedStateProvider>> it = this.components.iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            IIX0o.oO(next, "components");
            SavedStateProvider savedStateProvider = (SavedStateProvider) next.getValue();
            if (IIX0o.Oxx0IOOO((String) next.getKey(), str)) {
                return savedStateProvider;
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
        IIX0o.x0xO0oo(lifecycle, RequestParameters.SUBRESOURCE_LIFECYCLE);
        if (!this.attached) {
            lifecycle.addObserver(new oIX0oI(this));
            this.attached = true;
            return;
        }
        throw new IllegalStateException("SavedStateRegistry was already attached.");
    }

    @MainThread
    public final void performRestore$savedstate_release(@oOoXoXO Bundle bundle) {
        Bundle bundle2;
        if (!this.attached) {
            throw new IllegalStateException("You must call performAttach() before calling performRestore(Bundle).");
        } else if (!this.isRestored) {
            if (bundle != null) {
                bundle2 = bundle.getBundle(SAVED_COMPONENTS_KEY);
            } else {
                bundle2 = null;
            }
            this.restoredState = bundle2;
            this.isRestored = true;
        } else {
            throw new IllegalStateException("SavedStateRegistry was already restored.");
        }
    }

    @MainThread
    public final void performSave(@OOXIXo Bundle bundle) {
        IIX0o.x0xO0oo(bundle, "outBundle");
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = this.restoredState;
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
        SafeIterableMap<K, V>.IteratorWithAdditions iteratorWithAdditions = this.components.iteratorWithAdditions();
        IIX0o.oO(iteratorWithAdditions, "this.components.iteratorWithAdditions()");
        while (iteratorWithAdditions.hasNext()) {
            Map.Entry entry = (Map.Entry) iteratorWithAdditions.next();
            bundle2.putBundle((String) entry.getKey(), ((SavedStateProvider) entry.getValue()).saveState());
        }
        if (!bundle2.isEmpty()) {
            bundle.putBundle(SAVED_COMPONENTS_KEY, bundle2);
        }
    }

    @MainThread
    public final void registerSavedStateProvider(@OOXIXo String str, @OOXIXo SavedStateProvider savedStateProvider) {
        IIX0o.x0xO0oo(str, "key");
        IIX0o.x0xO0oo(savedStateProvider, "provider");
        if (this.components.putIfAbsent(str, savedStateProvider) != null) {
            throw new IllegalArgumentException("SavedStateProvider with the given key is already registered");
        }
    }

    @MainThread
    public final void runOnNextRecreation(@OOXIXo Class<? extends AutoRecreated> cls) {
        IIX0o.x0xO0oo(cls, "clazz");
        if (this.isAllowingSavingState) {
            Recreator.SavedStateProvider savedStateProvider = this.recreatorProvider;
            if (savedStateProvider == null) {
                savedStateProvider = new Recreator.SavedStateProvider(this);
            }
            this.recreatorProvider = savedStateProvider;
            try {
                cls.getDeclaredConstructor((Class[]) null);
                Recreator.SavedStateProvider savedStateProvider2 = this.recreatorProvider;
                if (savedStateProvider2 != null) {
                    String name = cls.getName();
                    IIX0o.oO(name, "clazz.name");
                    savedStateProvider2.add(name);
                }
            } catch (NoSuchMethodException e) {
                throw new IllegalArgumentException("Class " + cls.getSimpleName() + " must have default constructor in order to be automatically recreated", e);
            }
        } else {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }

    public final void setAllowingSavingState$savedstate_release(boolean z) {
        this.isAllowingSavingState = z;
    }

    @MainThread
    public final void unregisterSavedStateProvider(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "key");
        this.components.remove(str);
    }
}
