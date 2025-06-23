package androidx.navigation;

import Oox.oOoXoXO;
import androidx.navigation.serialization.RouteSerializerKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.OI0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nNavGraph.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NavGraph.kt\nandroidx/navigation/NavGraph$setStartDestination$2\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,677:1\n453#2:678\n403#2:679\n1238#3,4:680\n*S KotlinDebug\n*F\n+ 1 NavGraph.kt\nandroidx/navigation/NavGraph$setStartDestination$2\n*L\n480#1:678\n480#1:679\n480#1:680,4\n*E\n"})
public final class NavGraph$setStartDestination$2 extends Lambda implements oOoXoXO<NavDestination, String> {
    final /* synthetic */ T $startDestRoute;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavGraph$setStartDestination$2(T t) {
        super(1);
        this.$startDestRoute = t;
    }

    public final String invoke(NavDestination navDestination) {
        IIX0o.x0xO0oo(navDestination, "startDestination");
        Map<String, NavArgument> arguments = navDestination.getArguments();
        LinkedHashMap linkedHashMap = new LinkedHashMap(OI0.xoIox(arguments.size()));
        for (Map.Entry entry : arguments.entrySet()) {
            linkedHashMap.put(entry.getKey(), ((NavArgument) entry.getValue()).getType());
        }
        return RouteSerializerKt.generateRouteWithArgs(this.$startDestRoute, linkedHashMap);
    }
}
