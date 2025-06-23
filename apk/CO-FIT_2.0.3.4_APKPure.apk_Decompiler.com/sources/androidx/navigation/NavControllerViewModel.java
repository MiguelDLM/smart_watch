package androidx.navigation;

import OXOo.OOXIXo;
import XO0OX.x0XOIxOo;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;

public final class NavControllerViewModel extends ViewModel implements NavViewModelStoreProvider {
    @OOXIXo
    public static final Companion Companion = new Companion((IIXOooo) null);
    /* access modifiers changed from: private */
    @OOXIXo
    public static final ViewModelProvider.Factory FACTORY = new NavControllerViewModel$Companion$FACTORY$1();
    @OOXIXo
    private final Map<String, ViewModelStore> viewModelStores = new LinkedHashMap();

    @XX({"SMAP\nNavControllerViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NavControllerViewModel.kt\nandroidx/navigation/NavControllerViewModel$Companion\n+ 2 ViewModelProvider.kt\nandroidx/lifecycle/ViewModelProviderGetKt\n*L\n1#1,83:1\n374#2:84\n*S KotlinDebug\n*F\n+ 1 NavControllerViewModel.kt\nandroidx/navigation/NavControllerViewModel$Companion\n*L\n79#1:84\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        @x0XOIxOo
        @OOXIXo
        public final NavControllerViewModel getInstance(@OOXIXo ViewModelStore viewModelStore) {
            IIX0o.x0xO0oo(viewModelStore, "viewModelStore");
            return (NavControllerViewModel) new ViewModelProvider(viewModelStore, NavControllerViewModel.FACTORY, (CreationExtras) null, 4, (IIXOooo) null).get(NavControllerViewModel.class);
        }

        private Companion() {
        }
    }

    @x0XOIxOo
    @OOXIXo
    public static final NavControllerViewModel getInstance(@OOXIXo ViewModelStore viewModelStore) {
        return Companion.getInstance(viewModelStore);
    }

    public final void clear(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "backStackEntryId");
        ViewModelStore remove = this.viewModelStores.remove(str);
        if (remove != null) {
            remove.clear();
        }
    }

    @OOXIXo
    public ViewModelStore getViewModelStore(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "backStackEntryId");
        ViewModelStore viewModelStore = this.viewModelStores.get(str);
        if (viewModelStore != null) {
            return viewModelStore;
        }
        ViewModelStore viewModelStore2 = new ViewModelStore();
        this.viewModelStores.put(str, viewModelStore2);
        return viewModelStore2;
    }

    public void onCleared() {
        for (ViewModelStore clear : this.viewModelStores.values()) {
            clear.clear();
        }
        this.viewModelStores.clear();
    }

    @OOXIXo
    public String toString() {
        StringBuilder sb = new StringBuilder("NavControllerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} ViewModelStores (");
        Iterator<String> it = this.viewModelStores.keySet().iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(HexStringBuilder.COMMENT_END_CHAR);
        String sb2 = sb.toString();
        IIX0o.oO(sb2, "sb.toString()");
        return sb2;
    }
}
