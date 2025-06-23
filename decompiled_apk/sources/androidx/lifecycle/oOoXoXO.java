package androidx.lifecycle;

import XO0OX.x0XOIxOo;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.ViewModelInitializer;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes.dex */
public final /* synthetic */ class oOoXoXO {
    static {
        ViewModelProvider.Factory.Companion companion = ViewModelProvider.Factory.Companion;
    }

    @x0XOIxOo
    @OXOo.OOXIXo
    public static ViewModelProvider.Factory I0Io(@OXOo.OOXIXo ViewModelInitializer<?>... viewModelInitializerArr) {
        return ViewModelProvider.Factory.Companion.from(viewModelInitializerArr);
    }

    @OXOo.OOXIXo
    public static ViewModel II0xO0(ViewModelProvider.Factory factory, @OXOo.OOXIXo Class modelClass, @OXOo.OOXIXo CreationExtras extras) {
        IIX0o.x0xO0oo(modelClass, "modelClass");
        IIX0o.x0xO0oo(extras, "extras");
        return factory.create(modelClass);
    }

    @OXOo.OOXIXo
    public static ViewModel oIX0oI(ViewModelProvider.Factory factory, @OXOo.OOXIXo Class modelClass) {
        IIX0o.x0xO0oo(modelClass, "modelClass");
        throw new UnsupportedOperationException("Factory.create(String) is unsupported.  This Factory requires `CreationExtras` to be passed into `create` method.");
    }
}
