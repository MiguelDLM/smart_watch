package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.jvm.internal.IIX0o;

@XO0OX.xxIXOIIO(name = "ViewModelProviderGetKt")
/* loaded from: classes.dex */
public final class ViewModelProviderGetKt {
    @OXOo.OOXIXo
    public static final CreationExtras defaultCreationExtras(@OXOo.OOXIXo ViewModelStoreOwner owner) {
        IIX0o.x0xO0oo(owner, "owner");
        if (owner instanceof HasDefaultViewModelProviderFactory) {
            return ((HasDefaultViewModelProviderFactory) owner).getDefaultViewModelCreationExtras();
        }
        return CreationExtras.Empty.INSTANCE;
    }

    @MainThread
    public static final /* synthetic */ <VM extends ViewModel> VM get(ViewModelProvider viewModelProvider) {
        IIX0o.x0xO0oo(viewModelProvider, "<this>");
        IIX0o.OxI(4, "VM");
        return (VM) viewModelProvider.get(ViewModel.class);
    }
}
