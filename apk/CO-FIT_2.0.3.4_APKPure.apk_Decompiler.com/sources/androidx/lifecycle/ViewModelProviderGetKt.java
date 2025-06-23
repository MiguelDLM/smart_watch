package androidx.lifecycle;

import OXOo.OOXIXo;
import XO0OX.xxIXOIIO;
import androidx.annotation.MainThread;
import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.jvm.internal.IIX0o;

@xxIXOIIO(name = "ViewModelProviderGetKt")
public final class ViewModelProviderGetKt {
    @OOXIXo
    public static final CreationExtras defaultCreationExtras(@OOXIXo ViewModelStoreOwner viewModelStoreOwner) {
        IIX0o.x0xO0oo(viewModelStoreOwner, "owner");
        if (viewModelStoreOwner instanceof HasDefaultViewModelProviderFactory) {
            return ((HasDefaultViewModelProviderFactory) viewModelStoreOwner).getDefaultViewModelCreationExtras();
        }
        return CreationExtras.Empty.INSTANCE;
    }

    @MainThread
    public static final /* synthetic */ <VM extends ViewModel> VM get(ViewModelProvider viewModelProvider) {
        IIX0o.x0xO0oo(viewModelProvider, "<this>");
        IIX0o.OxI(4, "VM");
        return viewModelProvider.get(ViewModel.class);
    }
}
