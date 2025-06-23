package androidx.navigation.serialization;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.os.Bundle;
import androidx.navigation.NavType;
import java.util.Map;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes.dex */
final class BundleArgStore extends ArgStore {

    @OOXIXo
    private final Bundle bundle;

    @OOXIXo
    private final Map<String, NavType<?>> typeMap;

    /* JADX WARN: Multi-variable type inference failed */
    public BundleArgStore(@OOXIXo Bundle bundle, @OOXIXo Map<String, ? extends NavType<?>> typeMap) {
        IIX0o.x0xO0oo(bundle, "bundle");
        IIX0o.x0xO0oo(typeMap, "typeMap");
        this.bundle = bundle;
        this.typeMap = typeMap;
    }

    @Override // androidx.navigation.serialization.ArgStore
    public boolean contains(@OOXIXo String key) {
        IIX0o.x0xO0oo(key, "key");
        return this.bundle.containsKey(key);
    }

    @Override // androidx.navigation.serialization.ArgStore
    @oOoXoXO
    public Object get(@OOXIXo String key) {
        IIX0o.x0xO0oo(key, "key");
        NavType<?> navType = this.typeMap.get(key);
        if (navType != null) {
            return navType.get(this.bundle, key);
        }
        return null;
    }
}
