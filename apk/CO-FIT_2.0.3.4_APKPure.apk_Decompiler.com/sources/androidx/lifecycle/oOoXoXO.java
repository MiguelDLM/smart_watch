package androidx.lifecycle;

import OXOo.OOXIXo;
import XO0OX.x0XOIxOo;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.ViewModelInitializer;
import kotlin.jvm.internal.IIX0o;

public final /* synthetic */ class oOoXoXO {
    static {
        ViewModelProvider.Factory.Companion companion = ViewModelProvider.Factory.Companion;
    }

    @x0XOIxOo
    @OOXIXo
    public static ViewModelProvider.Factory I0Io(@OOXIXo ViewModelInitializer<?>... viewModelInitializerArr) {
        return ViewModelProvider.Factory.Companion.from(viewModelInitializerArr);
    }

    @OOXIXo
    public static ViewModel II0xO0(ViewModelProvider.Factory factory, @OOXIXo Class cls, @OOXIXo CreationExtras creationExtras) {
        IIX0o.x0xO0oo(cls, "modelClass");
        IIX0o.x0xO0oo(creationExtras, "extras");
        return factory.create(cls);
    }

    @OOXIXo
    public static ViewModel oIX0oI(ViewModelProvider.Factory factory, @OOXIXo Class cls) {
        IIX0o.x0xO0oo(cls, "modelClass");
        throw new UnsupportedOperationException("Factory.create(String) is unsupported.  This Factory requires `CreationExtras` to be passed into `create` method.");
    }
}
