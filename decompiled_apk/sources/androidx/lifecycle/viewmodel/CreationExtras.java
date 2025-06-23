package androidx.lifecycle.viewmodel;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes.dex */
public abstract class CreationExtras {

    @OOXIXo
    private final Map<Key<?>, Object> map = new LinkedHashMap();

    /* loaded from: classes.dex */
    public static final class Empty extends CreationExtras {

        @OOXIXo
        public static final Empty INSTANCE = new Empty();

        private Empty() {
        }

        @Override // androidx.lifecycle.viewmodel.CreationExtras
        @oOoXoXO
        public <T> T get(@OOXIXo Key<T> key) {
            IIX0o.x0xO0oo(key, "key");
            return null;
        }
    }

    /* loaded from: classes.dex */
    public interface Key<T> {
    }

    @oOoXoXO
    public abstract <T> T get(@OOXIXo Key<T> key);

    @OOXIXo
    public final Map<Key<?>, Object> getMap$lifecycle_viewmodel_release() {
        return this.map;
    }
}
