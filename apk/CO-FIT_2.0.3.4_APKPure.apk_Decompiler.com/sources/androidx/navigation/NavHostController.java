package androidx.navigation;

import OXOo.OOXIXo;
import android.content.Context;
import androidx.activity.OnBackPressedDispatcher;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStore;
import com.huawei.openalliance.ad.constant.bn;
import kotlin.jvm.internal.IIX0o;

public class NavHostController extends NavController {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavHostController(@OOXIXo Context context) {
        super(context);
        IIX0o.x0xO0oo(context, bn.f.o);
    }

    public final void enableOnBackPressed(boolean z) {
        super.enableOnBackPressed(z);
    }

    public final void setLifecycleOwner(@OOXIXo LifecycleOwner lifecycleOwner) {
        IIX0o.x0xO0oo(lifecycleOwner, "owner");
        super.setLifecycleOwner(lifecycleOwner);
    }

    public final void setOnBackPressedDispatcher(@OOXIXo OnBackPressedDispatcher onBackPressedDispatcher) {
        IIX0o.x0xO0oo(onBackPressedDispatcher, "dispatcher");
        super.setOnBackPressedDispatcher(onBackPressedDispatcher);
    }

    public final void setViewModelStore(@OOXIXo ViewModelStore viewModelStore) {
        IIX0o.x0xO0oo(viewModelStore, "viewModelStore");
        super.setViewModelStore(viewModelStore);
    }
}
