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
final class SavedStateArgStore extends ArgStore {
    @OOXIXo
    private final SavedStateHandle handle;
    @OOXIXo
    private final Map<String, NavType<?>> typeMap;

    public SavedStateArgStore(@OOXIXo SavedStateHandle savedStateHandle, @OOXIXo Map<String, ? extends NavType<?>> map) {
        IIX0o.x0xO0oo(savedStateHandle, "handle");
        IIX0o.x0xO0oo(map, "typeMap");
        this.handle = savedStateHandle;
        this.typeMap = map;
    }

    public boolean contains(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "key");
        return this.handle.contains(str);
    }

    @oOoXoXO
    public Object get(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "key");
        Bundle bundleOf = BundleKt.bundleOf(Xo0.oIX0oI(str, this.handle.get(str)));
        NavType<?> navType = this.typeMap.get(str);
        if (navType != null) {
            return navType.get(bundleOf, str);
        }
        throw new IllegalStateException(("Failed to find type for " + str + " when decoding " + this.handle).toString());
    }
}
