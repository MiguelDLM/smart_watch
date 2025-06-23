package androidx.navigation;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.xxIXOIIO;
import androidx.annotation.IdRes;
import androidx.annotation.RestrictTo;
import androidx.exifinterface.media.ExifInterface;
import androidx.navigation.NavDestination;
import androidx.navigation.serialization.RouteSerializerKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IO;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import kotlin.reflect.Oxx0xo;
import kotlin.reflect.oxoX;
import kotlinx.serialization.Oxx0IOOO;
import kotlinx.serialization.OxxIIOOXO;

@NavDestinationDsl
@XX({"SMAP\nNavDestinationBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NavDestinationBuilder.kt\nandroidx/navigation/NavDestinationBuilder\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,398:1\n1855#2,2:399\n1855#2,2:401\n1855#2,2:405\n215#3,2:403\n215#3,2:407\n*S KotlinDebug\n*F\n+ 1 NavDestinationBuilder.kt\nandroidx/navigation/NavDestinationBuilder\n*L\n95#1:399,2\n238#1:401,2\n295#1:405,2\n294#1:403,2\n296#1:407,2\n*E\n"})
/* loaded from: classes.dex */
public class NavDestinationBuilder<D extends NavDestination> {

    @OOXIXo
    private Map<Integer, NavAction> actions;

    @OOXIXo
    private Map<String, NavArgument> arguments;

    @OOXIXo
    private List<NavDeepLink> deepLinks;
    private final int id;

    @oOoXoXO
    private CharSequence label;

    @OOXIXo
    private final Navigator<? extends D> navigator;

    @oOoXoXO
    private final String route;
    private Map<Oxx0xo, ? extends NavType<?>> typeMap;

    public NavDestinationBuilder(@OOXIXo Navigator<? extends D> navigator, @IdRes int i, @oOoXoXO String str) {
        IIX0o.x0xO0oo(navigator, "navigator");
        this.navigator = navigator;
        this.id = i;
        this.route = str;
        this.arguments = new LinkedHashMap();
        this.deepLinks = new ArrayList();
        this.actions = new LinkedHashMap();
    }

    @kotlin.OOXIXo(message = "Building NavDestinations using IDs with the Kotlin DSL has been deprecated in favor of using routes. When using routes there is no need for actions.")
    public final void action(int i, @OOXIXo Oox.oOoXoXO<? super NavActionBuilder, oXIO0o0XI> actionBuilder) {
        IIX0o.x0xO0oo(actionBuilder, "actionBuilder");
        Map<Integer, NavAction> map = this.actions;
        Integer valueOf = Integer.valueOf(i);
        NavActionBuilder navActionBuilder = new NavActionBuilder();
        actionBuilder.invoke(navActionBuilder);
        map.put(valueOf, navActionBuilder.build$navigation_common_release());
    }

    public final void argument(@OOXIXo String name, @OOXIXo Oox.oOoXoXO<? super NavArgumentBuilder, oXIO0o0XI> argumentBuilder) {
        IIX0o.x0xO0oo(name, "name");
        IIX0o.x0xO0oo(argumentBuilder, "argumentBuilder");
        Map<String, NavArgument> map = this.arguments;
        NavArgumentBuilder navArgumentBuilder = new NavArgumentBuilder();
        argumentBuilder.invoke(navArgumentBuilder);
        map.put(name, navArgumentBuilder.build());
    }

    @OOXIXo
    public D build() {
        D instantiateDestination = instantiateDestination();
        instantiateDestination.setLabel(this.label);
        for (Map.Entry<String, NavArgument> entry : this.arguments.entrySet()) {
            instantiateDestination.addArgument(entry.getKey(), entry.getValue());
        }
        Iterator<T> it = this.deepLinks.iterator();
        while (it.hasNext()) {
            instantiateDestination.addDeepLink((NavDeepLink) it.next());
        }
        for (Map.Entry<Integer, NavAction> entry2 : this.actions.entrySet()) {
            instantiateDestination.putAction(entry2.getKey().intValue(), entry2.getValue());
        }
        String str = this.route;
        if (str != null) {
            instantiateDestination.setRoute(str);
        }
        int i = this.id;
        if (i != -1) {
            instantiateDestination.setId(i);
        }
        return instantiateDestination;
    }

    public final void deepLink(@OOXIXo String uriPattern) {
        IIX0o.x0xO0oo(uriPattern, "uriPattern");
        this.deepLinks.add(new NavDeepLink(uriPattern));
    }

    @xxIXOIIO(name = "deepLinkSafeArgs")
    public final /* synthetic */ <T> void deepLinkSafeArgs(String basePath) {
        IIX0o.x0xO0oo(basePath, "basePath");
        IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
        deepLink(basePath, IO.oxoX(Object.class), new Oox.oOoXoXO<NavDeepLinkDslBuilder, oXIO0o0XI>() { // from class: androidx.navigation.NavDestinationBuilder$deepLink$1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(NavDeepLinkDslBuilder deepLink) {
                IIX0o.x0xO0oo(deepLink, "$this$deepLink");
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(NavDeepLinkDslBuilder navDeepLinkDslBuilder) {
                invoke2(navDeepLinkDslBuilder);
                return oXIO0o0XI.f29392oIX0oI;
            }
        });
    }

    public final int getId() {
        return this.id;
    }

    @oOoXoXO
    public final CharSequence getLabel() {
        return this.label;
    }

    @OOXIXo
    public final Navigator<? extends D> getNavigator() {
        return this.navigator;
    }

    @oOoXoXO
    public final String getRoute() {
        return this.route;
    }

    @OOXIXo
    public D instantiateDestination() {
        return this.navigator.createDestination();
    }

    public final void setLabel(@oOoXoXO CharSequence charSequence) {
        this.label = charSequence;
    }

    public final void argument(@OOXIXo String name, @OOXIXo NavArgument argument) {
        IIX0o.x0xO0oo(name, "name");
        IIX0o.x0xO0oo(argument, "argument");
        this.arguments.put(name, argument);
    }

    public final void deepLink(@OOXIXo Oox.oOoXoXO<? super NavDeepLinkDslBuilder, oXIO0o0XI> navDeepLink) {
        IIX0o.x0xO0oo(navDeepLink, "navDeepLink");
        List<NavDeepLink> list = this.deepLinks;
        NavDeepLinkDslBuilder navDeepLinkDslBuilder = new NavDeepLinkDslBuilder();
        navDeepLink.invoke(navDeepLinkDslBuilder);
        list.add(navDeepLinkDslBuilder.build$navigation_common_release());
    }

    public final /* synthetic */ <T> void deepLink(String basePath, Oox.oOoXoXO<? super NavDeepLinkDslBuilder, oXIO0o0XI> navDeepLink) {
        IIX0o.x0xO0oo(basePath, "basePath");
        IIX0o.x0xO0oo(navDeepLink, "navDeepLink");
        IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
        deepLink(basePath, IO.oxoX(Object.class), navDeepLink);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final <T> void deepLink(@OOXIXo String basePath, @OOXIXo oxoX<T> route, @OOXIXo Oox.oOoXoXO<? super NavDeepLinkDslBuilder, oXIO0o0XI> navDeepLink) {
        IIX0o.x0xO0oo(basePath, "basePath");
        IIX0o.x0xO0oo(route, "route");
        IIX0o.x0xO0oo(navDeepLink, "navDeepLink");
        if (this.typeMap != null) {
            Oxx0IOOO Oxx0IOOO2 = OxxIIOOXO.Oxx0IOOO(route);
            Map<Oxx0xo, ? extends NavType<?>> map = this.typeMap;
            Map<Oxx0xo, ? extends NavType<?>> map2 = null;
            if (map == null) {
                IIX0o.XOxIOxOx("typeMap");
                map = null;
            }
            for (NamedNavArgument namedNavArgument : RouteSerializerKt.generateNavArguments(Oxx0IOOO2, map)) {
                NavArgument navArgument = this.arguments.get(namedNavArgument.getName());
                if (navArgument == null || !IIX0o.Oxx0IOOO(navArgument.getType(), namedNavArgument.getArgument().getType())) {
                    throw new IllegalArgumentException(("Cannot add deeplink from KClass [" + route + "]. DeepLink contains unknown argument [" + namedNavArgument.getName() + "]. Ensure deeplink arguments matches the destination's route from KClass").toString());
                }
            }
            Map<Oxx0xo, ? extends NavType<?>> map3 = this.typeMap;
            if (map3 == null) {
                IIX0o.XOxIOxOx("typeMap");
            } else {
                map2 = map3;
            }
            deepLink(NavDeepLinkDslBuilderKt.navDeepLink(basePath, route, map2, navDeepLink));
            return;
        }
        throw new IllegalStateException(("Cannot add deeplink from KClass [" + route + "]. Use the NavDestinationBuilder constructor that takes a KClass with the same arguments.").toString());
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @kotlin.OOXIXo(message = "Use routes to build your NavDestination instead", replaceWith = @kotlin.XX(expression = "NavDestinationBuilder(navigator, route = id.toString())", imports = {}))
    public NavDestinationBuilder(@OOXIXo Navigator<? extends D> navigator, @IdRes int i) {
        this(navigator, i, (String) null);
        IIX0o.x0xO0oo(navigator, "navigator");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NavDestinationBuilder(@OOXIXo Navigator<? extends D> navigator, @oOoXoXO String str) {
        this(navigator, -1, str);
        IIX0o.x0xO0oo(navigator, "navigator");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public NavDestinationBuilder(@OXOo.OOXIXo androidx.navigation.Navigator<? extends D> r5, @OXOo.oOoXoXO kotlin.reflect.oxoX<?> r6, @OXOo.OOXIXo java.util.Map<kotlin.reflect.Oxx0xo, androidx.navigation.NavType<?>> r7) {
        /*
            r4 = this;
            java.lang.String r0 = "navigator"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r5, r0)
            java.lang.String r0 = "typeMap"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r7, r0)
            if (r6 == 0) goto L17
            kotlinx.serialization.Oxx0IOOO r0 = kotlinx.serialization.OxxIIOOXO.Oxx0IOOO(r6)
            if (r0 == 0) goto L17
            int r0 = androidx.navigation.serialization.RouteSerializerKt.generateHashCode(r0)
            goto L18
        L17:
            r0 = -1
        L18:
            r1 = 0
            if (r6 == 0) goto L26
            kotlinx.serialization.Oxx0IOOO r2 = kotlinx.serialization.OxxIIOOXO.Oxx0IOOO(r6)
            if (r2 == 0) goto L26
            r3 = 2
            java.lang.String r1 = androidx.navigation.serialization.RouteSerializerKt.generateRoutePattern$default(r2, r7, r1, r3, r1)
        L26:
            r4.<init>(r5, r0, r1)
            if (r6 == 0) goto L53
            kotlinx.serialization.Oxx0IOOO r5 = kotlinx.serialization.OxxIIOOXO.Oxx0IOOO(r6)
            java.util.List r5 = androidx.navigation.serialization.RouteSerializerKt.generateNavArguments(r5, r7)
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.Iterator r5 = r5.iterator()
        L39:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L53
            java.lang.Object r6 = r5.next()
            androidx.navigation.NamedNavArgument r6 = (androidx.navigation.NamedNavArgument) r6
            java.util.Map<java.lang.String, androidx.navigation.NavArgument> r0 = r4.arguments
            java.lang.String r1 = r6.getName()
            androidx.navigation.NavArgument r6 = r6.getArgument()
            r0.put(r1, r6)
            goto L39
        L53:
            r4.typeMap = r7
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavDestinationBuilder.<init>(androidx.navigation.Navigator, kotlin.reflect.oxoX, java.util.Map):void");
    }

    public final void deepLink(@OOXIXo NavDeepLink navDeepLink) {
        IIX0o.x0xO0oo(navDeepLink, "navDeepLink");
        this.deepLinks.add(navDeepLink);
    }
}
