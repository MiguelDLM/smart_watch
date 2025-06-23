package androidx.navigation.serialization;

import Oox.oIX0oI;
import kotlin.jvm.internal.Lambda;
import kotlin.oXIO0o0XI;
import kotlin.reflect.oxoX;
import kotlinx.serialization.Oxx0IOOO;
import kotlinx.serialization.descriptors.II0xO0;

public final class RouteSerializerKt$generateRoutePattern$1 extends Lambda implements oIX0oI<oXIO0o0XI> {
    final /* synthetic */ Oxx0IOOO<T> $this_generateRoutePattern;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RouteSerializerKt$generateRoutePattern$1(Oxx0IOOO<T> oxx0IOOO) {
        super(0);
        this.$this_generateRoutePattern = oxx0IOOO;
    }

    public final void invoke() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cannot generate route pattern from polymorphic class ");
        oxoX<?> oIX0oI2 = II0xO0.oIX0oI(this.$this_generateRoutePattern.oIX0oI());
        sb.append(oIX0oI2 != null ? oIX0oI2.xoXoI() : null);
        sb.append(". Routes can only be generated from concrete classes or objects.");
        throw new IllegalArgumentException(sb.toString());
    }
}
