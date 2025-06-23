package androidx.lifecycle.viewmodel;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.IIX0o;

public abstract class CreationExtras {
    @OOXIXo
    private final Map<Key<?>, Object> map = new LinkedHashMap();

    public static final class Empty extends CreationExtras {
        @OOXIXo
        public static final Empty INSTANCE = new Empty();

        private Empty() {
        }

        @oOoXoXO
        public <T> T get(@OOXIXo Key<T> key) {
            IIX0o.x0xO0oo(key, "key");
            return null;
        }
    }

    public interface Key<T> {
    }

    @oOoXoXO
    public abstract <T> T get(@OOXIXo Key<T> key);

    @OOXIXo
    public final Map<Key<?>, Object> getMap$lifecycle_viewmodel_release() {
        return this.map;
    }
}
