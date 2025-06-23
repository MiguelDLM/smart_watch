package androidx.navigation;

import OXOo.OOXIXo;
import java.util.List;

public abstract class CollectionNavType<T> extends NavType<T> {
    public CollectionNavType(boolean z) {
        super(z);
    }

    public abstract T emptyCollection();

    @OOXIXo
    public abstract List<String> serializeAsValues(T t);
}
