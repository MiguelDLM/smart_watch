package androidx.navigation;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.oOoXoXO;
import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.jvm.internal.IIX0o;

public final class NavControllerViewModel$Companion$FACTORY$1 implements ViewModelProvider.Factory {
    public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
        return oOoXoXO.II0xO0(this, cls, creationExtras);
    }

    public <T extends ViewModel> T create(Class<T> cls) {
        IIX0o.x0xO0oo(cls, "modelClass");
        return new NavControllerViewModel();
    }
}
