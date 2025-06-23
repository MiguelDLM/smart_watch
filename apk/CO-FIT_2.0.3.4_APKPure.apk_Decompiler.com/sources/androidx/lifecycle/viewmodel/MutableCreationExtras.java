package androidx.lifecycle.viewmodel;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

public final class MutableCreationExtras extends CreationExtras {
    public MutableCreationExtras() {
        this((CreationExtras) null, 1, (IIXOooo) null);
    }

    @oOoXoXO
    public <T> T get(@OOXIXo CreationExtras.Key<T> key) {
        IIX0o.x0xO0oo(key, "key");
        return getMap$lifecycle_viewmodel_release().get(key);
    }

    public final <T> void set(@OOXIXo CreationExtras.Key<T> key, T t) {
        IIX0o.x0xO0oo(key, "key");
        getMap$lifecycle_viewmodel_release().put(key, t);
    }

    public MutableCreationExtras(@OOXIXo CreationExtras creationExtras) {
        IIX0o.x0xO0oo(creationExtras, "initialExtras");
        getMap$lifecycle_viewmodel_release().putAll(creationExtras.getMap$lifecycle_viewmodel_release());
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MutableCreationExtras(CreationExtras creationExtras, int i, IIXOooo iIXOooo) {
        this((i & 1) != 0 ? CreationExtras.Empty.INSTANCE : creationExtras);
    }
}
