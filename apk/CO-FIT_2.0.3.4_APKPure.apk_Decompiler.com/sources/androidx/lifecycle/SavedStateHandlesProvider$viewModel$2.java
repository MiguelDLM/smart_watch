package androidx.lifecycle;

import OXOo.OOXIXo;
import Oox.oIX0oI;
import kotlin.jvm.internal.Lambda;

public final class SavedStateHandlesProvider$viewModel$2 extends Lambda implements oIX0oI<SavedStateHandlesVM> {
    final /* synthetic */ ViewModelStoreOwner $viewModelStoreOwner;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SavedStateHandlesProvider$viewModel$2(ViewModelStoreOwner viewModelStoreOwner) {
        super(0);
        this.$viewModelStoreOwner = viewModelStoreOwner;
    }

    @OOXIXo
    public final SavedStateHandlesVM invoke() {
        return SavedStateHandleSupport.getSavedStateHandlesVM(this.$viewModelStoreOwner);
    }
}
