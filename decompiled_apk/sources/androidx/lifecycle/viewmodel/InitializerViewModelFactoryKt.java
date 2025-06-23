package androidx.lifecycle.viewmodel;

import OXOo.OOXIXo;
import Oox.oOoXoXO;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IO;
import kotlin.oXIO0o0XI;

/* loaded from: classes.dex */
public final class InitializerViewModelFactoryKt {
    public static final /* synthetic */ <VM extends ViewModel> void initializer(InitializerViewModelFactoryBuilder initializerViewModelFactoryBuilder, oOoXoXO<? super CreationExtras, ? extends VM> initializer) {
        IIX0o.x0xO0oo(initializerViewModelFactoryBuilder, "<this>");
        IIX0o.x0xO0oo(initializer, "initializer");
        IIX0o.OxI(4, "VM");
        initializerViewModelFactoryBuilder.addInitializer(IO.oxoX(ViewModel.class), initializer);
    }

    @OOXIXo
    public static final ViewModelProvider.Factory viewModelFactory(@OOXIXo oOoXoXO<? super InitializerViewModelFactoryBuilder, oXIO0o0XI> builder) {
        IIX0o.x0xO0oo(builder, "builder");
        InitializerViewModelFactoryBuilder initializerViewModelFactoryBuilder = new InitializerViewModelFactoryBuilder();
        builder.invoke(initializerViewModelFactoryBuilder);
        return initializerViewModelFactoryBuilder.build();
    }
}
