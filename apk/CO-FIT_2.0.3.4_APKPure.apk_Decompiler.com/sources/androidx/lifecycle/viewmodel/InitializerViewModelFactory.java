package androidx.lifecycle.viewmodel;

import OXOo.OOXIXo;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.oOoXoXO;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nInitializerViewModelFactory.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InitializerViewModelFactory.kt\nandroidx/lifecycle/viewmodel/InitializerViewModelFactory\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,115:1\n13579#2,2:116\n*S KotlinDebug\n*F\n+ 1 InitializerViewModelFactory.kt\nandroidx/lifecycle/viewmodel/InitializerViewModelFactory\n*L\n105#1:116,2\n*E\n"})
public final class InitializerViewModelFactory implements ViewModelProvider.Factory {
    @OOXIXo
    private final ViewModelInitializer<?>[] initializers;

    public InitializerViewModelFactory(@OOXIXo ViewModelInitializer<?>... viewModelInitializerArr) {
        IIX0o.x0xO0oo(viewModelInitializerArr, "initializers");
        this.initializers = viewModelInitializerArr;
    }

    public /* synthetic */ ViewModel create(Class cls) {
        return oOoXoXO.oIX0oI(this, cls);
    }

    @OOXIXo
    public <T extends ViewModel> T create(@OOXIXo Class<T> cls, @OOXIXo CreationExtras creationExtras) {
        IIX0o.x0xO0oo(cls, "modelClass");
        IIX0o.x0xO0oo(creationExtras, "extras");
        T t = null;
        for (ViewModelInitializer<?> viewModelInitializer : this.initializers) {
            if (IIX0o.Oxx0IOOO(viewModelInitializer.getClazz$lifecycle_viewmodel_release(), cls)) {
                T invoke = viewModelInitializer.getInitializer$lifecycle_viewmodel_release().invoke(creationExtras);
                t = invoke instanceof ViewModel ? (ViewModel) invoke : null;
            }
        }
        if (t != null) {
            return t;
        }
        throw new IllegalArgumentException("No initializer set for given class " + cls.getName());
    }
}
