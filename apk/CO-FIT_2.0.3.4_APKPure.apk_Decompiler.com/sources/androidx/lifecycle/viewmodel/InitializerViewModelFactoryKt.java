package androidx.lifecycle.viewmodel;

import OXOo.OOXIXo;
import Oox.oOoXoXO;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IO;
import kotlin.oXIO0o0XI;

public final class InitializerViewModelFactoryKt {
    public static final /* synthetic */ <VM extends ViewModel> void initializer(InitializerViewModelFactoryBuilder initializerViewModelFactoryBuilder, oOoXoXO<? super CreationExtras, ? extends VM> oooxoxo) {
        IIX0o.x0xO0oo(initializerViewModelFactoryBuilder, "<this>");
        IIX0o.x0xO0oo(oooxoxo, "initializer");
        IIX0o.OxI(4, "VM");
        initializerViewModelFactoryBuilder.addInitializer(IO.oxoX(ViewModel.class), oooxoxo);
    }

    @OOXIXo
    public static final ViewModelProvider.Factory viewModelFactory(@OOXIXo oOoXoXO<? super InitializerViewModelFactoryBuilder, oXIO0o0XI> oooxoxo) {
        IIX0o.x0xO0oo(oooxoxo, "builder");
        InitializerViewModelFactoryBuilder initializerViewModelFactoryBuilder = new InitializerViewModelFactoryBuilder();
        oooxoxo.invoke(initializerViewModelFactoryBuilder);
        return initializerViewModelFactoryBuilder.build();
    }
}
