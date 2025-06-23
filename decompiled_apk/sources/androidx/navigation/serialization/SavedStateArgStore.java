package androidx.navigation.serialization;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.os.Bundle;
import androidx.core.os.BundleKt;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.NavType;
import java.util.Map;
import kotlin.Xo0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nRouteDecoder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RouteDecoder.kt\nandroidx/navigation/serialization/SavedStateArgStore\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,183:1\n1#2:184\n*E\n"})
/* loaded from: classes.dex */
final class SavedStateArgStore extends ArgStore {

    @OOXIXo
    private final SavedStateHandle handle;

    @OOXIXo
    private final Map<String, NavType<?>> typeMap;

    /* JADX WARN: Multi-variable type inference failed */
    public SavedStateArgStore(@OOXIXo SavedStateHandle handle, @OOXIXo Map<String, ? extends NavType<?>> typeMap) {
        IIX0o.x0xO0oo(handle, "handle");
        IIX0o.x0xO0oo(typeMap, "typeMap");
        this.handle = handle;
        this.typeMap = typeMap;
    }

    @Override // androidx.navigation.serialization.ArgStore
    public boolean contains(@OOXIXo String key) {
        IIX0o.x0xO0oo(key, "key");
        return this.handle.contains(key);
    }

    @Override // androidx.navigation.serialization.ArgStore
    @oOoXoXO
    public Object get(@OOXIXo String key) {
        IIX0o.x0xO0oo(key, "key");
        Bundle bundleOf = BundleKt.bundleOf(Xo0.oIX0oI(key, this.handle.get(key)));
        NavType<?> navType = this.typeMap.get(key);
        if (navType != null) {
            return navType.get(bundleOf, key);
        }
        throw new IllegalStateException(("Failed to find type for " + key + " when decoding " + this.handle).toString());
    }
}
