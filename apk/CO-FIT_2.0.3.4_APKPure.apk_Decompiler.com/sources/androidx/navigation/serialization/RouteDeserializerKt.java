package androidx.navigation.serialization;

import OXOo.OOXIXo;
import android.os.Bundle;
import androidx.annotation.RestrictTo;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.NavType;
import java.util.Map;
import kotlin.jvm.internal.IIX0o;
import kotlinx.serialization.Oxx0IOOO;

public final class RouteDeserializerKt {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final <T> T decodeArguments(@OOXIXo Oxx0IOOO<T> oxx0IOOO, @OOXIXo Bundle bundle, @OOXIXo Map<String, ? extends NavType<?>> map) {
        IIX0o.x0xO0oo(oxx0IOOO, "<this>");
        IIX0o.x0xO0oo(bundle, "bundle");
        IIX0o.x0xO0oo(map, "typeMap");
        return new RouteDecoder(bundle, map).decodeRouteWithArgs$navigation_common_release(oxx0IOOO);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final <T> T decodeArguments(@OOXIXo Oxx0IOOO<T> oxx0IOOO, @OOXIXo SavedStateHandle savedStateHandle, @OOXIXo Map<String, ? extends NavType<?>> map) {
        IIX0o.x0xO0oo(oxx0IOOO, "<this>");
        IIX0o.x0xO0oo(savedStateHandle, "handle");
        IIX0o.x0xO0oo(map, "typeMap");
        return new RouteDecoder(savedStateHandle, map).decodeRouteWithArgs$navigation_common_release(oxx0IOOO);
    }
}
