package androidx.navigation.serialization;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.os.Bundle;
import androidx.navigation.NavType;
import java.util.Map;
import kotlin.jvm.internal.IIX0o;

final class BundleArgStore extends ArgStore {
    @OOXIXo
    private final Bundle bundle;
    @OOXIXo
    private final Map<String, NavType<?>> typeMap;

    public BundleArgStore(@OOXIXo Bundle bundle2, @OOXIXo Map<String, ? extends NavType<?>> map) {
        IIX0o.x0xO0oo(bundle2, "bundle");
        IIX0o.x0xO0oo(map, "typeMap");
        this.bundle = bundle2;
        this.typeMap = map;
    }

    public boolean contains(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "key");
        return this.bundle.containsKey(str);
    }

    @oOoXoXO
    public Object get(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "key");
        NavType navType = this.typeMap.get(str);
        if (navType != null) {
            return navType.get(this.bundle, str);
        }
        return null;
    }
}
