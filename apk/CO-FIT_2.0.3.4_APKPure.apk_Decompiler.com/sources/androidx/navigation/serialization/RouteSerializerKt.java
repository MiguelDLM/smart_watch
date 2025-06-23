package androidx.navigation.serialization;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import Oox.IXxxXO;
import Oox.oIX0oI;
import XO0OX.xxIXOIIO;
import androidx.annotation.RestrictTo;
import androidx.navigation.NamedNavArgument;
import androidx.navigation.NamedNavArgumentKt;
import androidx.navigation.NavType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.o0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IO;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import kotlin.reflect.Oxx0xo;
import kotlinx.serialization.Oxx0IOOO;
import kotlinx.serialization.OxxIIOOXO;
import kotlinx.serialization.PolymorphicSerializer;
import kotlinx.serialization.descriptors.XO;
import kotlinx.serialization.descriptors.xxIXOIIO;

@XX({"SMAP\nRouteSerializer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RouteSerializer.kt\nandroidx/navigation/serialization/RouteSerializerKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,225:1\n1#2:226\n*E\n"})
public final class RouteSerializerKt {
    private static final <T> void assertNotAbstractClass(Oxx0IOOO<T> oxx0IOOO, oIX0oI<oXIO0o0XI> oix0oi) {
        if (oxx0IOOO instanceof PolymorphicSerializer) {
            oix0oi.invoke();
        }
    }

    /* access modifiers changed from: private */
    public static final NavType<Object> computeNavType(XO xo2, Map<Oxx0xo, ? extends NavType<?>> map) {
        T t;
        NavType<?> navType;
        Iterator<T> it = map.keySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (NavTypeConverterKt.matchKType(xo2, (Oxx0xo) t)) {
                break;
            }
        }
        Oxx0xo oxx0xo = (Oxx0xo) t;
        if (oxx0xo != null) {
            navType = (NavType) map.get(oxx0xo);
        } else {
            navType = null;
        }
        if (!(navType instanceof NavType)) {
            navType = null;
        }
        if (navType == null) {
            navType = NavTypeConverterKt.getNavType(xo2);
        }
        if (IIX0o.Oxx0IOOO(navType, UNKNOWN.INSTANCE)) {
            return null;
        }
        IIX0o.x0XOIxOo(navType, "null cannot be cast to non-null type androidx.navigation.NavType<kotlin.Any?>");
        return navType;
    }

    @xxIXOIIO(name = "forEachIndexedKType")
    private static final <T> void forEachIndexedKType(Oxx0IOOO<T> oxx0IOOO, Map<Oxx0xo, ? extends NavType<?>> map, IXxxXO<? super Integer, ? super String, ? super NavType<Object>, oXIO0o0XI> iXxxXO) {
        int XO2 = oxx0IOOO.oIX0oI().XO();
        int i = 0;
        while (i < XO2) {
            String Oxx0IOOO2 = oxx0IOOO.oIX0oI().Oxx0IOOO(i);
            NavType<Object> computeNavType = computeNavType(oxx0IOOO.oIX0oI().X0o0xo(i), map);
            if (computeNavType != null) {
                iXxxXO.invoke(Integer.valueOf(i), Oxx0IOOO2, computeNavType);
                i++;
            } else {
                throw new IllegalArgumentException(unknownNavTypeErrorMessage(Oxx0IOOO2, oxx0IOOO.oIX0oI().X0o0xo(i).xxIXOIIO(), oxx0IOOO.oIX0oI().xxIXOIIO(), map.toString()));
            }
        }
    }

    public static /* synthetic */ void forEachIndexedKType$default(Oxx0IOOO oxx0IOOO, Map map, IXxxXO iXxxXO, int i, Object obj) {
        if ((i & 1) != 0) {
            map = o0.O0xOxO();
        }
        forEachIndexedKType(oxx0IOOO, map, iXxxXO);
    }

    @xxIXOIIO(name = "forEachIndexedName")
    private static final <T> void forEachIndexedName(Oxx0IOOO<T> oxx0IOOO, Map<String, ? extends NavType<Object>> map, IXxxXO<? super Integer, ? super String, ? super NavType<Object>, oXIO0o0XI> iXxxXO) {
        int XO2 = oxx0IOOO.oIX0oI().XO();
        int i = 0;
        while (i < XO2) {
            String Oxx0IOOO2 = oxx0IOOO.oIX0oI().Oxx0IOOO(i);
            NavType navType = (NavType) map.get(Oxx0IOOO2);
            if (navType != null) {
                iXxxXO.invoke(Integer.valueOf(i), Oxx0IOOO2, navType);
                i++;
            } else {
                throw new IllegalStateException(("Cannot locate NavType for argument [" + Oxx0IOOO2 + ']').toString());
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final <T> int generateHashCode(@OOXIXo Oxx0IOOO<T> oxx0IOOO) {
        IIX0o.x0xO0oo(oxx0IOOO, "<this>");
        int hashCode = oxx0IOOO.oIX0oI().xxIXOIIO().hashCode();
        int XO2 = oxx0IOOO.oIX0oI().XO();
        for (int i = 0; i < XO2; i++) {
            hashCode = (hashCode * 31) + oxx0IOOO.oIX0oI().Oxx0IOOO(i).hashCode();
        }
        return hashCode;
    }

    @OOXIXo
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final <T> List<NamedNavArgument> generateNavArguments(@OOXIXo Oxx0IOOO<T> oxx0IOOO, @OOXIXo Map<Oxx0xo, ? extends NavType<?>> map) {
        IIX0o.x0xO0oo(oxx0IOOO, "<this>");
        IIX0o.x0xO0oo(map, "typeMap");
        assertNotAbstractClass(oxx0IOOO, new RouteSerializerKt$generateNavArguments$1(oxx0IOOO));
        int XO2 = oxx0IOOO.oIX0oI().XO();
        ArrayList arrayList = new ArrayList(XO2);
        for (int i = 0; i < XO2; i++) {
            String Oxx0IOOO2 = oxx0IOOO.oIX0oI().Oxx0IOOO(i);
            arrayList.add(NamedNavArgumentKt.navArgument(Oxx0IOOO2, new RouteSerializerKt$generateNavArguments$2$1(oxx0IOOO, i, map, Oxx0IOOO2)));
        }
        return arrayList;
    }

    public static /* synthetic */ List generateNavArguments$default(Oxx0IOOO oxx0IOOO, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            map = o0.O0xOxO();
        }
        return generateNavArguments(oxx0IOOO, map);
    }

    @OOXIXo
    public static final <T> String generateRoutePattern(@OOXIXo Oxx0IOOO<T> oxx0IOOO, @OOXIXo Map<Oxx0xo, ? extends NavType<?>> map, @oOoXoXO String str) {
        RouteBuilder routeBuilder;
        IIX0o.x0xO0oo(oxx0IOOO, "<this>");
        IIX0o.x0xO0oo(map, "typeMap");
        assertNotAbstractClass(oxx0IOOO, new RouteSerializerKt$generateRoutePattern$1(oxx0IOOO));
        if (str != null) {
            routeBuilder = new RouteBuilder(str, oxx0IOOO);
        } else {
            routeBuilder = new RouteBuilder(oxx0IOOO);
        }
        forEachIndexedKType(oxx0IOOO, map, new RouteSerializerKt$generateRoutePattern$2(routeBuilder));
        return routeBuilder.build();
    }

    public static /* synthetic */ String generateRoutePattern$default(Oxx0IOOO oxx0IOOO, Map map, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            map = o0.O0xOxO();
        }
        if ((i & 2) != 0) {
            str = null;
        }
        return generateRoutePattern(oxx0IOOO, map, str);
    }

    @OOXIXo
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final <T> String generateRouteWithArgs(@OOXIXo T t, @OOXIXo Map<String, ? extends NavType<Object>> map) {
        IIX0o.x0xO0oo(t, "route");
        IIX0o.x0xO0oo(map, "typeMap");
        Oxx0IOOO Oxx0IOOO2 = OxxIIOOXO.Oxx0IOOO(IO.oxoX(t.getClass()));
        Map<String, List<String>> encodeToArgMap = new RouteEncoder(Oxx0IOOO2, map).encodeToArgMap(t);
        RouteBuilder routeBuilder = new RouteBuilder(Oxx0IOOO2);
        forEachIndexedName(Oxx0IOOO2, map, new RouteSerializerKt$generateRouteWithArgs$1(encodeToArgMap, routeBuilder));
        return routeBuilder.build();
    }

    public static final boolean isValueClass(@OOXIXo XO xo2) {
        IIX0o.x0xO0oo(xo2, "<this>");
        if (!IIX0o.Oxx0IOOO(xo2.oIX0oI(), xxIXOIIO.oIX0oI.f20373oIX0oI) || !xo2.isInline() || xo2.XO() != 1) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static final String unknownNavTypeErrorMessage(String str, String str2, String str3, String str4) {
        return "Route " + str3 + " could not find any NavType for argument " + str + " of type " + str2 + " - typeMap received was " + str4;
    }
}
