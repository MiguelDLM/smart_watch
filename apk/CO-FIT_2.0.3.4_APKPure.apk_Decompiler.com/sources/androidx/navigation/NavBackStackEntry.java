package androidx.navigation;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.MainThread;
import androidx.annotation.RestrictTo;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.AbstractSavedStateViewModelFactory;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.SavedStateHandleSupport;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.MutableCreationExtras;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.util.Set;
import java.util.UUID;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nNavBackStackEntry.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NavBackStackEntry.kt\nandroidx/navigation/NavBackStackEntry\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,309:1\n1#2:310\n1726#3,3:311\n1855#3,2:314\n*S KotlinDebug\n*F\n+ 1 NavBackStackEntry.kt\nandroidx/navigation/NavBackStackEntry\n*L\n256#1:311,3\n265#1:314,2\n*E\n"})
public final class NavBackStackEntry implements LifecycleOwner, ViewModelStoreOwner, HasDefaultViewModelProviderFactory, SavedStateRegistryOwner {
    @OOXIXo
    public static final Companion Companion = new Companion((IIXOooo) null);
    @OOXIXo
    private LifecycleRegistry _lifecycle;
    /* access modifiers changed from: private */
    @oOoXoXO
    public final Context context;
    @OOXIXo
    private final X0IIOO defaultFactory$delegate;
    @OOXIXo
    private final ViewModelProvider.Factory defaultViewModelProviderFactory;
    @OOXIXo
    private NavDestination destination;
    @OOXIXo
    private Lifecycle.State hostLifecycleState;
    @OOXIXo
    private final String id;
    @oOoXoXO
    private final Bundle immutableArgs;
    @OOXIXo
    private Lifecycle.State maxLifecycle;
    @oOoXoXO
    private final Bundle savedState;
    @OOXIXo
    private final X0IIOO savedStateHandle$delegate;
    /* access modifiers changed from: private */
    public boolean savedStateRegistryAttached;
    @OOXIXo
    private final SavedStateRegistryController savedStateRegistryController;
    @oOoXoXO
    private final NavViewModelStoreProvider viewModelStoreProvider;

    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        public static /* synthetic */ NavBackStackEntry create$default(Companion companion, Context context, NavDestination navDestination, Bundle bundle, Lifecycle.State state, NavViewModelStoreProvider navViewModelStoreProvider, String str, Bundle bundle2, int i, Object obj) {
            Bundle bundle3;
            Lifecycle.State state2;
            NavViewModelStoreProvider navViewModelStoreProvider2;
            String str2;
            Bundle bundle4;
            if ((i & 4) != 0) {
                bundle3 = null;
            } else {
                bundle3 = bundle;
            }
            if ((i & 8) != 0) {
                state2 = Lifecycle.State.CREATED;
            } else {
                state2 = state;
            }
            if ((i & 16) != 0) {
                navViewModelStoreProvider2 = null;
            } else {
                navViewModelStoreProvider2 = navViewModelStoreProvider;
            }
            if ((i & 32) != 0) {
                String uuid = UUID.randomUUID().toString();
                IIX0o.oO(uuid, "randomUUID().toString()");
                str2 = uuid;
            } else {
                str2 = str;
            }
            if ((i & 64) != 0) {
                bundle4 = null;
            } else {
                bundle4 = bundle2;
            }
            return companion.create(context, navDestination, bundle3, state2, navViewModelStoreProvider2, str2, bundle4);
        }

        @OOXIXo
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public final NavBackStackEntry create(@oOoXoXO Context context, @OOXIXo NavDestination navDestination, @oOoXoXO Bundle bundle, @OOXIXo Lifecycle.State state, @oOoXoXO NavViewModelStoreProvider navViewModelStoreProvider, @OOXIXo String str, @oOoXoXO Bundle bundle2) {
            IIX0o.x0xO0oo(navDestination, "destination");
            IIX0o.x0xO0oo(state, "hostLifecycleState");
            String str2 = str;
            IIX0o.x0xO0oo(str2, "id");
            return new NavBackStackEntry(context, navDestination, bundle, state, navViewModelStoreProvider, str2, bundle2, (IIXOooo) null);
        }

        private Companion() {
        }
    }

    public static final class NavResultSavedStateFactory extends AbstractSavedStateViewModelFactory {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public NavResultSavedStateFactory(@OOXIXo SavedStateRegistryOwner savedStateRegistryOwner) {
            super(savedStateRegistryOwner, (Bundle) null);
            IIX0o.x0xO0oo(savedStateRegistryOwner, "owner");
        }

        @OOXIXo
        public <T extends ViewModel> T create(@OOXIXo String str, @OOXIXo Class<T> cls, @OOXIXo SavedStateHandle savedStateHandle) {
            IIX0o.x0xO0oo(str, "key");
            IIX0o.x0xO0oo(cls, "modelClass");
            IIX0o.x0xO0oo(savedStateHandle, "handle");
            return new SavedStateViewModel(savedStateHandle);
        }
    }

    public static final class SavedStateViewModel extends ViewModel {
        @OOXIXo
        private final SavedStateHandle handle;

        public SavedStateViewModel(@OOXIXo SavedStateHandle savedStateHandle) {
            IIX0o.x0xO0oo(savedStateHandle, "handle");
            this.handle = savedStateHandle;
        }

        @OOXIXo
        public final SavedStateHandle getHandle() {
            return this.handle;
        }
    }

    public /* synthetic */ NavBackStackEntry(Context context2, NavDestination navDestination, Bundle bundle, Lifecycle.State state, NavViewModelStoreProvider navViewModelStoreProvider, String str, Bundle bundle2, IIXOooo iIXOooo) {
        this(context2, navDestination, bundle, state, navViewModelStoreProvider, str, bundle2);
    }

    private final SavedStateViewModelFactory getDefaultFactory() {
        return (SavedStateViewModelFactory) this.defaultFactory$delegate.getValue();
    }

    public boolean equals(@oOoXoXO Object obj) {
        Set<String> keySet;
        Object obj2;
        if (obj == null || !(obj instanceof NavBackStackEntry)) {
            return false;
        }
        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj;
        if (!IIX0o.Oxx0IOOO(this.id, navBackStackEntry.id) || !IIX0o.Oxx0IOOO(this.destination, navBackStackEntry.destination) || !IIX0o.Oxx0IOOO(getLifecycle(), navBackStackEntry.getLifecycle()) || !IIX0o.Oxx0IOOO(getSavedStateRegistry(), navBackStackEntry.getSavedStateRegistry())) {
            return false;
        }
        if (!IIX0o.Oxx0IOOO(this.immutableArgs, navBackStackEntry.immutableArgs)) {
            Bundle bundle = this.immutableArgs;
            if (bundle == null || (keySet = bundle.keySet()) == null) {
                return false;
            }
            if (!keySet.isEmpty()) {
                for (String str : keySet) {
                    Object obj3 = this.immutableArgs.get(str);
                    Bundle bundle2 = navBackStackEntry.immutableArgs;
                    if (bundle2 != null) {
                        obj2 = bundle2.get(str);
                    } else {
                        obj2 = null;
                    }
                    if (!IIX0o.Oxx0IOOO(obj3, obj2)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    @oOoXoXO
    public final Bundle getArguments() {
        if (this.immutableArgs == null) {
            return null;
        }
        return new Bundle(this.immutableArgs);
    }

    @OOXIXo
    public CreationExtras getDefaultViewModelCreationExtras() {
        Context context2;
        Application application = null;
        MutableCreationExtras mutableCreationExtras = new MutableCreationExtras((CreationExtras) null, 1, (IIXOooo) null);
        Context context3 = this.context;
        if (context3 != null) {
            context2 = context3.getApplicationContext();
        } else {
            context2 = null;
        }
        if (context2 instanceof Application) {
            application = (Application) context2;
        }
        if (application != null) {
            mutableCreationExtras.set(ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY, application);
        }
        mutableCreationExtras.set(SavedStateHandleSupport.SAVED_STATE_REGISTRY_OWNER_KEY, this);
        mutableCreationExtras.set(SavedStateHandleSupport.VIEW_MODEL_STORE_OWNER_KEY, this);
        Bundle arguments = getArguments();
        if (arguments != null) {
            mutableCreationExtras.set(SavedStateHandleSupport.DEFAULT_ARGS_KEY, arguments);
        }
        return mutableCreationExtras;
    }

    @OOXIXo
    public ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        return this.defaultViewModelProviderFactory;
    }

    @OOXIXo
    public final NavDestination getDestination() {
        return this.destination;
    }

    @OOXIXo
    public final String getId() {
        return this.id;
    }

    @OOXIXo
    public Lifecycle getLifecycle() {
        return this._lifecycle;
    }

    @OOXIXo
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final Lifecycle.State getMaxLifecycle() {
        return this.maxLifecycle;
    }

    @MainThread
    @OOXIXo
    public final SavedStateHandle getSavedStateHandle() {
        return (SavedStateHandle) this.savedStateHandle$delegate.getValue();
    }

    @OOXIXo
    public SavedStateRegistry getSavedStateRegistry() {
        return this.savedStateRegistryController.getSavedStateRegistry();
    }

    @OOXIXo
    public ViewModelStore getViewModelStore() {
        if (!this.savedStateRegistryAttached) {
            throw new IllegalStateException("You cannot access the NavBackStackEntry's ViewModels until it is added to the NavController's back stack (i.e., the Lifecycle of the NavBackStackEntry reaches the CREATED state).");
        } else if (getLifecycle().getCurrentState() != Lifecycle.State.DESTROYED) {
            NavViewModelStoreProvider navViewModelStoreProvider = this.viewModelStoreProvider;
            if (navViewModelStoreProvider != null) {
                return navViewModelStoreProvider.getViewModelStore(this.id);
            }
            throw new IllegalStateException("You must call setViewModelStore() on your NavHostController before accessing the ViewModelStore of a navigation graph.");
        } else {
            throw new IllegalStateException("You cannot access the NavBackStackEntry's ViewModels after the NavBackStackEntry is destroyed.");
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void handleLifecycleEvent(@OOXIXo Lifecycle.Event event) {
        IIX0o.x0xO0oo(event, NotificationCompat.CATEGORY_EVENT);
        this.hostLifecycleState = event.getTargetState();
        updateState();
    }

    public int hashCode() {
        Set<String> keySet;
        int i;
        int hashCode = (this.id.hashCode() * 31) + this.destination.hashCode();
        Bundle bundle = this.immutableArgs;
        if (!(bundle == null || (keySet = bundle.keySet()) == null)) {
            for (String str : keySet) {
                int i2 = hashCode * 31;
                Object obj = this.immutableArgs.get(str);
                if (obj != null) {
                    i = obj.hashCode();
                } else {
                    i = 0;
                }
                hashCode = i2 + i;
            }
        }
        return (((hashCode * 31) + getLifecycle().hashCode()) * 31) + getSavedStateRegistry().hashCode();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void saveState(@OOXIXo Bundle bundle) {
        IIX0o.x0xO0oo(bundle, "outBundle");
        this.savedStateRegistryController.performSave(bundle);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void setDestination(@OOXIXo NavDestination navDestination) {
        IIX0o.x0xO0oo(navDestination, "<set-?>");
        this.destination = navDestination;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void setMaxLifecycle(@OOXIXo Lifecycle.State state) {
        IIX0o.x0xO0oo(state, "maxState");
        this.maxLifecycle = state;
        updateState();
    }

    @OOXIXo
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(NavBackStackEntry.class.getSimpleName());
        sb.append(HexStringBuilder.COMMENT_BEGIN_CHAR + this.id + HexStringBuilder.COMMENT_END_CHAR);
        sb.append(" destination=");
        sb.append(this.destination);
        String sb2 = sb.toString();
        IIX0o.oO(sb2, "sb.toString()");
        return sb2;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void updateState() {
        if (!this.savedStateRegistryAttached) {
            this.savedStateRegistryController.performAttach();
            this.savedStateRegistryAttached = true;
            if (this.viewModelStoreProvider != null) {
                SavedStateHandleSupport.enableSavedStateHandles(this);
            }
            this.savedStateRegistryController.performRestore(this.savedState);
        }
        if (this.hostLifecycleState.ordinal() < this.maxLifecycle.ordinal()) {
            this._lifecycle.setCurrentState(this.hostLifecycleState);
        } else {
            this._lifecycle.setCurrentState(this.maxLifecycle);
        }
    }

    private NavBackStackEntry(Context context2, NavDestination navDestination, Bundle bundle, Lifecycle.State state, NavViewModelStoreProvider navViewModelStoreProvider, String str, Bundle bundle2) {
        this.context = context2;
        this.destination = navDestination;
        this.immutableArgs = bundle;
        this.hostLifecycleState = state;
        this.viewModelStoreProvider = navViewModelStoreProvider;
        this.id = str;
        this.savedState = bundle2;
        this._lifecycle = new LifecycleRegistry(this);
        this.savedStateRegistryController = SavedStateRegistryController.Companion.create(this);
        this.defaultFactory$delegate = XIxXXX0x0.oIX0oI(new NavBackStackEntry$defaultFactory$2(this));
        this.savedStateHandle$delegate = XIxXXX0x0.oIX0oI(new NavBackStackEntry$savedStateHandle$2(this));
        this.maxLifecycle = Lifecycle.State.INITIALIZED;
        this.defaultViewModelProviderFactory = getDefaultFactory();
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ NavBackStackEntry(android.content.Context r11, androidx.navigation.NavDestination r12, android.os.Bundle r13, androidx.lifecycle.Lifecycle.State r14, androidx.navigation.NavViewModelStoreProvider r15, java.lang.String r16, android.os.Bundle r17, int r18, kotlin.jvm.internal.IIXOooo r19) {
        /*
            r10 = this;
            r0 = r18 & 4
            r1 = 0
            if (r0 == 0) goto L_0x0007
            r5 = r1
            goto L_0x0008
        L_0x0007:
            r5 = r13
        L_0x0008:
            r0 = r18 & 8
            if (r0 == 0) goto L_0x0010
            androidx.lifecycle.Lifecycle$State r0 = androidx.lifecycle.Lifecycle.State.CREATED
            r6 = r0
            goto L_0x0011
        L_0x0010:
            r6 = r14
        L_0x0011:
            r0 = r18 & 16
            if (r0 == 0) goto L_0x0017
            r7 = r1
            goto L_0x0018
        L_0x0017:
            r7 = r15
        L_0x0018:
            r0 = r18 & 32
            if (r0 == 0) goto L_0x002b
            java.util.UUID r0 = java.util.UUID.randomUUID()
            java.lang.String r0 = r0.toString()
            java.lang.String r2 = "randomUUID().toString()"
            kotlin.jvm.internal.IIX0o.oO(r0, r2)
            r8 = r0
            goto L_0x002d
        L_0x002b:
            r8 = r16
        L_0x002d:
            r0 = r18 & 64
            if (r0 == 0) goto L_0x0033
            r9 = r1
            goto L_0x0035
        L_0x0033:
            r9 = r17
        L_0x0035:
            r2 = r10
            r3 = r11
            r4 = r12
            r2.<init>(r3, r4, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavBackStackEntry.<init>(android.content.Context, androidx.navigation.NavDestination, android.os.Bundle, androidx.lifecycle.Lifecycle$State, androidx.navigation.NavViewModelStoreProvider, java.lang.String, android.os.Bundle, int, kotlin.jvm.internal.IIXOooo):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NavBackStackEntry(NavBackStackEntry navBackStackEntry, Bundle bundle, int i, IIXOooo iIXOooo) {
        this(navBackStackEntry, (i & 2) != 0 ? navBackStackEntry.getArguments() : bundle);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public NavBackStackEntry(@OOXIXo NavBackStackEntry navBackStackEntry, @oOoXoXO Bundle bundle) {
        this(navBackStackEntry.context, navBackStackEntry.destination, bundle, navBackStackEntry.hostLifecycleState, navBackStackEntry.viewModelStoreProvider, navBackStackEntry.id, navBackStackEntry.savedState);
        IIX0o.x0xO0oo(navBackStackEntry, "entry");
        this.hostLifecycleState = navBackStackEntry.hostLifecycleState;
        setMaxLifecycle(navBackStackEntry.maxLifecycle);
    }
}
