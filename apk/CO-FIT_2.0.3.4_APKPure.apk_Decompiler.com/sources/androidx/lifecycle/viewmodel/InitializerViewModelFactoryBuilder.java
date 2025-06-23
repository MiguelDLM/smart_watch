package androidx.lifecycle.viewmodel;

import OXOo.OOXIXo;
import Oox.oOoXoXO;
import XO0OX.II0xO0;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.reflect.oxoX;

@ViewModelFactoryDsl
@XX({"SMAP\nInitializerViewModelFactory.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InitializerViewModelFactory.kt\nandroidx/lifecycle/viewmodel/InitializerViewModelFactoryBuilder\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,115:1\n37#2,2:116\n*S KotlinDebug\n*F\n+ 1 InitializerViewModelFactory.kt\nandroidx/lifecycle/viewmodel/InitializerViewModelFactoryBuilder\n*L\n54#1:116,2\n*E\n"})
public final class InitializerViewModelFactoryBuilder {
    @OOXIXo
    private final List<ViewModelInitializer<?>> initializers = new ArrayList();

    public final <T extends ViewModel> void addInitializer(@OOXIXo oxoX<T> oxox, @OOXIXo oOoXoXO<? super CreationExtras, ? extends T> oooxoxo) {
        IIX0o.x0xO0oo(oxox, "clazz");
        IIX0o.x0xO0oo(oooxoxo, "initializer");
        this.initializers.add(new ViewModelInitializer(II0xO0.X0o0xo(oxox), oooxoxo));
    }

    @OOXIXo
    public final ViewModelProvider.Factory build() {
        ViewModelInitializer[] viewModelInitializerArr = (ViewModelInitializer[]) this.initializers.toArray(new ViewModelInitializer[0]);
        return new InitializerViewModelFactory((ViewModelInitializer[]) Arrays.copyOf(viewModelInitializerArr, viewModelInitializerArr.length));
    }
}
