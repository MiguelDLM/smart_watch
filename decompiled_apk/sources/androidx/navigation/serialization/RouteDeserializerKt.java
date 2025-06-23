package androidx.navigation.serialization;

import OXOo.OOXIXo;
import android.os.Bundle;
import androidx.annotation.RestrictTo;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.NavType;
import java.util.Map;
import kotlin.jvm.internal.IIX0o;
import kotlinx.serialization.Oxx0IOOO;

/* loaded from: classes.dex */
public final class RouteDeserializerKt {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final <T> T decodeArguments(@OOXIXo Oxx0IOOO<T> oxx0IOOO, @OOXIXo Bundle bundle, @OOXIXo Map<String, ? extends NavType<?>> typeMap) {
        IIX0o.x0xO0oo(oxx0IOOO, "<this>");
        IIX0o.x0xO0oo(bundle, "bundle");
        IIX0o.x0xO0oo(typeMap, "typeMap");
        return (T) new RouteDecoder(bundle, typeMap).decodeRouteWithArgs$navigation_common_release(oxx0IOOO);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final <T> T decodeArguments(@OOXIXo Oxx0IOOO<T> oxx0IOOO, @OOXIXo SavedStateHandle handle, @OOXIXo Map<String, ? extends NavType<?>> typeMap) {
        IIX0o.x0xO0oo(oxx0IOOO, "<this>");
        IIX0o.x0xO0oo(handle, "handle");
        IIX0o.x0xO0oo(typeMap, "typeMap");
        return (T) new RouteDecoder(handle, typeMap).decodeRouteWithArgs$navigation_common_release(oxx0IOOO);
    }
}
