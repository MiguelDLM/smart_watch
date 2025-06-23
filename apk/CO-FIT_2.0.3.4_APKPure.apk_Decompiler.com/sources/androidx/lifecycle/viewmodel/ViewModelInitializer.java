package androidx.lifecycle.viewmodel;

import OXOo.OOXIXo;
import Oox.oOoXoXO;
import androidx.lifecycle.ViewModel;
import kotlin.jvm.internal.IIX0o;

public final class ViewModelInitializer<T extends ViewModel> {
    @OOXIXo
    private final Class<T> clazz;
    @OOXIXo
    private final oOoXoXO<CreationExtras, T> initializer;

    public ViewModelInitializer(@OOXIXo Class<T> cls, @OOXIXo oOoXoXO<? super CreationExtras, ? extends T> oooxoxo) {
        IIX0o.x0xO0oo(cls, "clazz");
        IIX0o.x0xO0oo(oooxoxo, "initializer");
        this.clazz = cls;
        this.initializer = oooxoxo;
    }

    @OOXIXo
    public final Class<T> getClazz$lifecycle_viewmodel_release() {
        return this.clazz;
    }

    @OOXIXo
    public final oOoXoXO<CreationExtras, T> getInitializer$lifecycle_viewmodel_release() {
        return this.initializer;
    }
}
