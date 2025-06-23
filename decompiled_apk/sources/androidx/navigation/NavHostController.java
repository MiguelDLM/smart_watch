package androidx.navigation;

import OXOo.OOXIXo;
import android.content.Context;
import androidx.activity.OnBackPressedDispatcher;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStore;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes.dex */
public class NavHostController extends NavController {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NavHostController(@OOXIXo Context context) {
        super(context);
        IIX0o.x0xO0oo(context, "context");
    }

    @Override // androidx.navigation.NavController
    public final void enableOnBackPressed(boolean z) {
        super.enableOnBackPressed(z);
    }

    @Override // androidx.navigation.NavController
    public final void setLifecycleOwner(@OOXIXo LifecycleOwner owner) {
        IIX0o.x0xO0oo(owner, "owner");
        super.setLifecycleOwner(owner);
    }

    @Override // androidx.navigation.NavController
    public final void setOnBackPressedDispatcher(@OOXIXo OnBackPressedDispatcher dispatcher) {
        IIX0o.x0xO0oo(dispatcher, "dispatcher");
        super.setOnBackPressedDispatcher(dispatcher);
    }

    @Override // androidx.navigation.NavController
    public final void setViewModelStore(@OOXIXo ViewModelStore viewModelStore) {
        IIX0o.x0xO0oo(viewModelStore, "viewModelStore");
        super.setViewModelStore(viewModelStore);
    }
}
