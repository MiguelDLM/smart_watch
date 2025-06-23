package androidx.lifecycle.viewmodel;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes.dex */
public final class MutableCreationExtras extends CreationExtras {
    /* JADX WARN: Multi-variable type inference failed */
    public MutableCreationExtras() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // androidx.lifecycle.viewmodel.CreationExtras
    @oOoXoXO
    public <T> T get(@OOXIXo CreationExtras.Key<T> key) {
        IIX0o.x0xO0oo(key, "key");
        return (T) getMap$lifecycle_viewmodel_release().get(key);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> void set(@OOXIXo CreationExtras.Key<T> key, T t) {
        IIX0o.x0xO0oo(key, "key");
        getMap$lifecycle_viewmodel_release().put(key, t);
    }

    public MutableCreationExtras(@OOXIXo CreationExtras initialExtras) {
        IIX0o.x0xO0oo(initialExtras, "initialExtras");
        getMap$lifecycle_viewmodel_release().putAll(initialExtras.getMap$lifecycle_viewmodel_release());
    }

    public /* synthetic */ MutableCreationExtras(CreationExtras creationExtras, int i, IIXOooo iIXOooo) {
        this((i & 1) != 0 ? CreationExtras.Empty.INSTANCE : creationExtras);
    }
}
