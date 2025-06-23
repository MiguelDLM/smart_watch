package androidx.navigation.serialization;

import OXOo.OOXIXo;
import Oox.IXxxXO;
import Oox.oIX0oI;
import Oox.oOoXoXO;
import XO0OX.xxIXOIIO;
import androidx.annotation.RestrictTo;
import androidx.navigation.NamedNavArgument;
import androidx.navigation.NamedNavArgumentKt;
import androidx.navigation.NavArgumentBuilder;
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
import kotlin.reflect.oxoX;
import kotlinx.serialization.Oxx0IOOO;
import kotlinx.serialization.OxxIIOOXO;
import kotlinx.serialization.PolymorphicSerializer;
import kotlinx.serialization.descriptors.II0xO0;
import kotlinx.serialization.descriptors.XO;
import kotlinx.serialization.descriptors.xxIXOIIO;

@XX({"SMAP\nRouteSerializer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RouteSerializer.kt\nandroidx/navigation/serialization/RouteSerializerKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,225:1\n1#2:226\n*E\n"})
/* loaded from: classes.dex */
public final class RouteSerializerKt {
    private static final <T> void assertNotAbstractClass(Oxx0IOOO<T> oxx0IOOO, oIX0oI<oXIO0o0XI> oix0oi) {
        if (oxx0IOOO instanceof PolymorphicSerializer) {
            oix0oi.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NavType<Object> computeNavType(XO xo2, Map<Oxx0xo, ? extends NavType<?>> map) {
        Object obj;
        NavType<?> navType;
        Iterator<T> it = map.keySet().iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (NavTypeConverterKt.matchKType(xo2, (Oxx0xo) obj)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        Oxx0xo oxx0xo = (Oxx0xo) obj;
        if (oxx0xo != null) {
            navType = map.get(oxx0xo);
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
        for (int i = 0; i < XO2; i++) {
            String Oxx0IOOO2 = oxx0IOOO.oIX0oI().Oxx0IOOO(i);
            NavType<Object> computeNavType = computeNavType(oxx0IOOO.oIX0oI().X0o0xo(i), map);
            if (computeNavType != null) {
                iXxxXO.invoke(Integer.valueOf(i), Oxx0IOOO2, computeNavType);
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
        for (int i = 0; i < XO2; i++) {
            String Oxx0IOOO2 = oxx0IOOO.oIX0oI().Oxx0IOOO(i);
            NavType<Object> navType = map.get(Oxx0IOOO2);
            if (navType != null) {
                iXxxXO.invoke(Integer.valueOf(i), Oxx0IOOO2, navType);
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
    public static final <T> List<NamedNavArgument> generateNavArguments(@OOXIXo final Oxx0IOOO<T> oxx0IOOO, @OOXIXo final Map<Oxx0xo, ? extends NavType<?>> typeMap) {
        IIX0o.x0xO0oo(oxx0IOOO, "<this>");
        IIX0o.x0xO0oo(typeMap, "typeMap");
        assertNotAbstractClass(oxx0IOOO, new oIX0oI<oXIO0o0XI>() { // from class: androidx.navigation.serialization.RouteSerializerKt$generateNavArguments$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // Oox.oIX0oI
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke() {
                invoke2();
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                throw new IllegalArgumentException("Cannot generate NavArguments for polymorphic serializer " + oxx0IOOO + ". Arguments can only be generated from concrete classes or objects.");
            }
        });
        int XO2 = oxx0IOOO.oIX0oI().XO();
        ArrayList arrayList = new ArrayList(XO2);
        for (final int i = 0; i < XO2; i++) {
            final String Oxx0IOOO2 = oxx0IOOO.oIX0oI().Oxx0IOOO(i);
            arrayList.add(NamedNavArgumentKt.navArgument(Oxx0IOOO2, new oOoXoXO<NavArgumentBuilder, oXIO0o0XI>() { // from class: androidx.navigation.serialization.RouteSerializerKt$generateNavArguments$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(NavArgumentBuilder navArgumentBuilder) {
                    invoke2(navArgumentBuilder);
                    return oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(NavArgumentBuilder navArgument) {
                    NavType<?> computeNavType;
                    String unknownNavTypeErrorMessage;
                    IIX0o.x0xO0oo(navArgument, "$this$navArgument");
                    XO X0o0xo2 = oxx0IOOO.oIX0oI().X0o0xo(i);
                    boolean I0Io2 = X0o0xo2.I0Io();
                    computeNavType = RouteSerializerKt.computeNavType(X0o0xo2, typeMap);
                    if (computeNavType == null) {
                        unknownNavTypeErrorMessage = RouteSerializerKt.unknownNavTypeErrorMessage(Oxx0IOOO2, X0o0xo2.xxIXOIIO(), oxx0IOOO.oIX0oI().xxIXOIIO(), typeMap.toString());
                        throw new IllegalArgumentException(unknownNavTypeErrorMessage);
                    }
                    navArgument.setType(computeNavType);
                    navArgument.setNullable(I0Io2);
                    if (oxx0IOOO.oIX0oI().xoIox(i)) {
                        navArgument.setUnknownDefaultValuePresent$navigation_common_release(true);
                    }
                }
            }));
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
    public static final <T> String generateRoutePattern(@OOXIXo final Oxx0IOOO<T> oxx0IOOO, @OOXIXo Map<Oxx0xo, ? extends NavType<?>> typeMap, @OXOo.oOoXoXO String str) {
        final RouteBuilder routeBuilder;
        IIX0o.x0xO0oo(oxx0IOOO, "<this>");
        IIX0o.x0xO0oo(typeMap, "typeMap");
        assertNotAbstractClass(oxx0IOOO, new oIX0oI<oXIO0o0XI>() { // from class: androidx.navigation.serialization.RouteSerializerKt$generateRoutePattern$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // Oox.oIX0oI
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke() {
                invoke2();
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StringBuilder sb = new StringBuilder();
                sb.append("Cannot generate route pattern from polymorphic class ");
                oxoX<?> oIX0oI2 = II0xO0.oIX0oI(oxx0IOOO.oIX0oI());
                sb.append(oIX0oI2 != null ? oIX0oI2.xoXoI() : null);
                sb.append(". Routes can only be generated from concrete classes or objects.");
                throw new IllegalArgumentException(sb.toString());
            }
        });
        if (str != null) {
            routeBuilder = new RouteBuilder(str, oxx0IOOO);
        } else {
            routeBuilder = new RouteBuilder(oxx0IOOO);
        }
        forEachIndexedKType(oxx0IOOO, typeMap, new IXxxXO<Integer, String, NavType<Object>, oXIO0o0XI>() { // from class: androidx.navigation.serialization.RouteSerializerKt$generateRoutePattern$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // Oox.IXxxXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Integer num, String str2, NavType<Object> navType) {
                invoke(num.intValue(), str2, navType);
                return oXIO0o0XI.f29392oIX0oI;
            }

            public final void invoke(int i, String argName, NavType<Object> navType) {
                IIX0o.x0xO0oo(argName, "argName");
                IIX0o.x0xO0oo(navType, "navType");
                routeBuilder.appendPattern(i, argName, navType);
            }
        });
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
    public static final <T> String generateRouteWithArgs(@OOXIXo T route, @OOXIXo Map<String, ? extends NavType<Object>> typeMap) {
        IIX0o.x0xO0oo(route, "route");
        IIX0o.x0xO0oo(typeMap, "typeMap");
        Oxx0IOOO Oxx0IOOO2 = OxxIIOOXO.Oxx0IOOO(IO.oxoX(route.getClass()));
        final Map<String, List<String>> encodeToArgMap = new RouteEncoder(Oxx0IOOO2, typeMap).encodeToArgMap(route);
        final RouteBuilder routeBuilder = new RouteBuilder(Oxx0IOOO2);
        forEachIndexedName(Oxx0IOOO2, typeMap, new IXxxXO<Integer, String, NavType<Object>, oXIO0o0XI>() { // from class: androidx.navigation.serialization.RouteSerializerKt$generateRouteWithArgs$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // Oox.IXxxXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Integer num, String str, NavType<Object> navType) {
                invoke(num.intValue(), str, navType);
                return oXIO0o0XI.f29392oIX0oI;
            }

            public final void invoke(int i, String argName, NavType<Object> navType) {
                IIX0o.x0xO0oo(argName, "argName");
                IIX0o.x0xO0oo(navType, "navType");
                List<String> list = encodeToArgMap.get(argName);
                IIX0o.ooOOo0oXI(list);
                routeBuilder.appendArg(i, argName, navType, list);
            }
        });
        return routeBuilder.build();
    }

    public static final boolean isValueClass(@OOXIXo XO xo2) {
        IIX0o.x0xO0oo(xo2, "<this>");
        if (IIX0o.Oxx0IOOO(xo2.oIX0oI(), xxIXOIIO.oIX0oI.f30610oIX0oI) && xo2.isInline() && xo2.XO() == 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String unknownNavTypeErrorMessage(String str, String str2, String str3, String str4) {
        return "Route " + str3 + " could not find any NavType for argument " + str + " of type " + str2 + " - typeMap received was " + str4;
    }
}
