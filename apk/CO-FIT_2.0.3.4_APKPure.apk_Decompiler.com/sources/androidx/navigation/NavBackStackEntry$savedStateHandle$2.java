package androidx.navigation;

import Oox.oIX0oI;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.navigation.NavBackStackEntry;
import kotlin.jvm.internal.Lambda;

public final class NavBackStackEntry$savedStateHandle$2 extends Lambda implements oIX0oI<SavedStateHandle> {
    final /* synthetic */ NavBackStackEntry this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavBackStackEntry$savedStateHandle$2(NavBackStackEntry navBackStackEntry) {
        super(0);
        this.this$0 = navBackStackEntry;
    }

    public final SavedStateHandle invoke() {
        if (!this.this$0.savedStateRegistryAttached) {
            throw new IllegalStateException("You cannot access the NavBackStackEntry's SavedStateHandle until it is added to the NavController's back stack (i.e., the Lifecycle of the NavBackStackEntry reaches the CREATED state).");
        } else if (this.this$0.getLifecycle().getCurrentState() != Lifecycle.State.DESTROYED) {
            return ((NavBackStackEntry.SavedStateViewModel) new ViewModelProvider((ViewModelStoreOwner) this.this$0, (ViewModelProvider.Factory) new NavBackStackEntry.NavResultSavedStateFactory(this.this$0)).get(NavBackStackEntry.SavedStateViewModel.class)).getHandle();
        } else {
            throw new IllegalStateException("You cannot access the NavBackStackEntry's SavedStateHandle after the NavBackStackEntry is destroyed.");
        }
    }
}
