package androidx.navigation.serialization;

import Oox.IXxxXO;
import androidx.navigation.NavType;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Lambda;
import kotlin.oXIO0o0XI;

public final class RouteSerializerKt$generateRouteWithArgs$1 extends Lambda implements IXxxXO<Integer, String, NavType<Object>, oXIO0o0XI> {
    final /* synthetic */ Map<String, List<String>> $argMap;
    final /* synthetic */ RouteBuilder<? extends T> $builder;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RouteSerializerKt$generateRouteWithArgs$1(Map<String, ? extends List<String>> map, RouteBuilder<? extends T> routeBuilder) {
        super(3);
        this.$argMap = map;
        this.$builder = routeBuilder;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke(((Number) obj).intValue(), (String) obj2, (NavType<Object>) (NavType) obj3);
        return oXIO0o0XI.f19155oIX0oI;
    }

    public final void invoke(int i, String str, NavType<Object> navType) {
        IIX0o.x0xO0oo(str, "argName");
        IIX0o.x0xO0oo(navType, "navType");
        List<String> list = this.$argMap.get(str);
        IIX0o.ooOOo0oXI(list);
        this.$builder.appendArg(i, str, navType, list);
    }
}
