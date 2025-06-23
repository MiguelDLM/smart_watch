package androidx.navigation;

import OXOo.OOXIXo;
import androidx.annotation.RestrictTo;
import androidx.lifecycle.ViewModelStore;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public interface NavViewModelStoreProvider {
    @OOXIXo
    ViewModelStore getViewModelStore(@OOXIXo String str);
}
