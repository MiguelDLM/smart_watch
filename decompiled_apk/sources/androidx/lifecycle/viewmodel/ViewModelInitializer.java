package androidx.lifecycle.viewmodel;

import OXOo.OOXIXo;
import Oox.oOoXoXO;
import androidx.lifecycle.ViewModel;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes.dex */
public final class ViewModelInitializer<T extends ViewModel> {

    @OOXIXo
    private final Class<T> clazz;

    @OOXIXo
    private final oOoXoXO<CreationExtras, T> initializer;

    /* JADX WARN: Multi-variable type inference failed */
    public ViewModelInitializer(@OOXIXo Class<T> clazz, @OOXIXo oOoXoXO<? super CreationExtras, ? extends T> initializer) {
        IIX0o.x0xO0oo(clazz, "clazz");
        IIX0o.x0xO0oo(initializer, "initializer");
        this.clazz = clazz;
        this.initializer = initializer;
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
