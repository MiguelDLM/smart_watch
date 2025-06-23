package androidx.navigation;

import Oox.oOoXoXO;
import androidx.annotation.IdRes;
import androidx.exifinterface.media.ExifInterface;
import java.util.Map;
import kotlin.OOXIXo;
import kotlin.XX;
import kotlin.collections.o0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IO;
import kotlin.oXIO0o0XI;
import kotlin.reflect.Oxx0xo;
import kotlin.reflect.oxoX;

/* loaded from: classes.dex */
public final class NavGraphBuilderKt {
    @OOXIXo(message = "Use routes to build your NavGraph instead", replaceWith = @XX(expression = "navigation(startDestination = startDestination.toString(), route = id.toString()) { builder.invoke() }", imports = {}))
    @OXOo.OOXIXo
    public static final NavGraph navigation(@OXOo.OOXIXo NavigatorProvider navigatorProvider, @IdRes int i, @IdRes int i2, @OXOo.OOXIXo oOoXoXO<? super NavGraphBuilder, oXIO0o0XI> builder) {
        IIX0o.x0xO0oo(navigatorProvider, "<this>");
        IIX0o.x0xO0oo(builder, "builder");
        NavGraphBuilder navGraphBuilder = new NavGraphBuilder(navigatorProvider, i, i2);
        builder.invoke(navGraphBuilder);
        return navGraphBuilder.build();
    }

    public static /* synthetic */ NavGraph navigation$default(NavigatorProvider navigatorProvider, int i, int i2, oOoXoXO builder, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        IIX0o.x0xO0oo(navigatorProvider, "<this>");
        IIX0o.x0xO0oo(builder, "builder");
        NavGraphBuilder navGraphBuilder = new NavGraphBuilder(navigatorProvider, i, i2);
        builder.invoke(navGraphBuilder);
        return navGraphBuilder.build();
    }

    @OXOo.OOXIXo
    public static final NavGraph navigation(@OXOo.OOXIXo NavigatorProvider navigatorProvider, @OXOo.OOXIXo String startDestination, @OXOo.oOoXoXO String str, @OXOo.OOXIXo oOoXoXO<? super NavGraphBuilder, oXIO0o0XI> builder) {
        IIX0o.x0xO0oo(navigatorProvider, "<this>");
        IIX0o.x0xO0oo(startDestination, "startDestination");
        IIX0o.x0xO0oo(builder, "builder");
        NavGraphBuilder navGraphBuilder = new NavGraphBuilder(navigatorProvider, startDestination, str);
        builder.invoke(navGraphBuilder);
        return navGraphBuilder.build();
    }

    @OXOo.OOXIXo
    public static final NavGraph navigation(@OXOo.OOXIXo NavigatorProvider navigatorProvider, @OXOo.OOXIXo oxoX<?> startDestination, @OXOo.oOoXoXO oxoX<?> oxox, @OXOo.OOXIXo Map<Oxx0xo, NavType<?>> typeMap, @OXOo.OOXIXo oOoXoXO<? super NavGraphBuilder, oXIO0o0XI> builder) {
        IIX0o.x0xO0oo(navigatorProvider, "<this>");
        IIX0o.x0xO0oo(startDestination, "startDestination");
        IIX0o.x0xO0oo(typeMap, "typeMap");
        IIX0o.x0xO0oo(builder, "builder");
        NavGraphBuilder navGraphBuilder = new NavGraphBuilder(navigatorProvider, startDestination, oxox, typeMap);
        builder.invoke(navGraphBuilder);
        return navGraphBuilder.build();
    }

    public static /* synthetic */ NavGraph navigation$default(NavigatorProvider navigatorProvider, String startDestination, String str, oOoXoXO builder, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        IIX0o.x0xO0oo(navigatorProvider, "<this>");
        IIX0o.x0xO0oo(startDestination, "startDestination");
        IIX0o.x0xO0oo(builder, "builder");
        NavGraphBuilder navGraphBuilder = new NavGraphBuilder(navigatorProvider, startDestination, str);
        builder.invoke(navGraphBuilder);
        return navGraphBuilder.build();
    }

    @OXOo.OOXIXo
    public static final NavGraph navigation(@OXOo.OOXIXo NavigatorProvider navigatorProvider, @OXOo.OOXIXo Object startDestination, @OXOo.oOoXoXO oxoX<?> oxox, @OXOo.OOXIXo Map<Oxx0xo, NavType<?>> typeMap, @OXOo.OOXIXo oOoXoXO<? super NavGraphBuilder, oXIO0o0XI> builder) {
        IIX0o.x0xO0oo(navigatorProvider, "<this>");
        IIX0o.x0xO0oo(startDestination, "startDestination");
        IIX0o.x0xO0oo(typeMap, "typeMap");
        IIX0o.x0xO0oo(builder, "builder");
        NavGraphBuilder navGraphBuilder = new NavGraphBuilder(navigatorProvider, startDestination, oxox, typeMap);
        builder.invoke(navGraphBuilder);
        return navGraphBuilder.build();
    }

    @OOXIXo(message = "Use routes to build your nested NavGraph instead", replaceWith = @XX(expression = "navigation(startDestination = startDestination.toString(), route = id.toString()) { builder.invoke() }", imports = {}))
    public static final void navigation(@OXOo.OOXIXo NavGraphBuilder navGraphBuilder, @IdRes int i, @IdRes int i2, @OXOo.OOXIXo oOoXoXO<? super NavGraphBuilder, oXIO0o0XI> builder) {
        IIX0o.x0xO0oo(navGraphBuilder, "<this>");
        IIX0o.x0xO0oo(builder, "builder");
        NavGraphBuilder navGraphBuilder2 = new NavGraphBuilder(navGraphBuilder.getProvider(), i, i2);
        builder.invoke(navGraphBuilder2);
        navGraphBuilder.destination(navGraphBuilder2);
    }

    public static /* synthetic */ NavGraph navigation$default(NavigatorProvider navigatorProvider, oxoX startDestination, oxoX oxox, Map typeMap, oOoXoXO builder, int i, Object obj) {
        if ((i & 2) != 0) {
            oxox = null;
        }
        if ((i & 4) != 0) {
            typeMap = o0.O0xOxO();
        }
        IIX0o.x0xO0oo(navigatorProvider, "<this>");
        IIX0o.x0xO0oo(startDestination, "startDestination");
        IIX0o.x0xO0oo(typeMap, "typeMap");
        IIX0o.x0xO0oo(builder, "builder");
        NavGraphBuilder navGraphBuilder = new NavGraphBuilder(navigatorProvider, (oxoX<?>) startDestination, (oxoX<?>) oxox, (Map<Oxx0xo, NavType<?>>) typeMap);
        builder.invoke(navGraphBuilder);
        return navGraphBuilder.build();
    }

    public static final void navigation(@OXOo.OOXIXo NavGraphBuilder navGraphBuilder, @OXOo.OOXIXo String startDestination, @OXOo.OOXIXo String route, @OXOo.OOXIXo oOoXoXO<? super NavGraphBuilder, oXIO0o0XI> builder) {
        IIX0o.x0xO0oo(navGraphBuilder, "<this>");
        IIX0o.x0xO0oo(startDestination, "startDestination");
        IIX0o.x0xO0oo(route, "route");
        IIX0o.x0xO0oo(builder, "builder");
        NavGraphBuilder navGraphBuilder2 = new NavGraphBuilder(navGraphBuilder.getProvider(), startDestination, route);
        builder.invoke(navGraphBuilder2);
        navGraphBuilder.destination(navGraphBuilder2);
    }

    public static final /* synthetic */ <T> void navigation(NavGraphBuilder navGraphBuilder, oxoX<?> startDestination, Map<Oxx0xo, NavType<?>> typeMap, oOoXoXO<? super NavGraphBuilder, oXIO0o0XI> builder) {
        IIX0o.x0xO0oo(navGraphBuilder, "<this>");
        IIX0o.x0xO0oo(startDestination, "startDestination");
        IIX0o.x0xO0oo(typeMap, "typeMap");
        IIX0o.x0xO0oo(builder, "builder");
        NavigatorProvider provider = navGraphBuilder.getProvider();
        IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
        NavGraphBuilder navGraphBuilder2 = new NavGraphBuilder(provider, startDestination, (oxoX<?>) IO.oxoX(Object.class), typeMap);
        builder.invoke(navGraphBuilder2);
        navGraphBuilder.destination(navGraphBuilder2);
    }

    public static final /* synthetic */ <T> void navigation(NavGraphBuilder navGraphBuilder, Object startDestination, Map<Oxx0xo, NavType<?>> typeMap, oOoXoXO<? super NavGraphBuilder, oXIO0o0XI> builder) {
        IIX0o.x0xO0oo(navGraphBuilder, "<this>");
        IIX0o.x0xO0oo(startDestination, "startDestination");
        IIX0o.x0xO0oo(typeMap, "typeMap");
        IIX0o.x0xO0oo(builder, "builder");
        NavigatorProvider provider = navGraphBuilder.getProvider();
        IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
        NavGraphBuilder navGraphBuilder2 = new NavGraphBuilder(provider, startDestination, (oxoX<?>) IO.oxoX(Object.class), typeMap);
        builder.invoke(navGraphBuilder2);
        navGraphBuilder.destination(navGraphBuilder2);
    }

    public static /* synthetic */ NavGraph navigation$default(NavigatorProvider navigatorProvider, Object startDestination, oxoX oxox, Map typeMap, oOoXoXO builder, int i, Object obj) {
        if ((i & 2) != 0) {
            oxox = null;
        }
        if ((i & 4) != 0) {
            typeMap = o0.O0xOxO();
        }
        IIX0o.x0xO0oo(navigatorProvider, "<this>");
        IIX0o.x0xO0oo(startDestination, "startDestination");
        IIX0o.x0xO0oo(typeMap, "typeMap");
        IIX0o.x0xO0oo(builder, "builder");
        NavGraphBuilder navGraphBuilder = new NavGraphBuilder(navigatorProvider, startDestination, (oxoX<?>) oxox, (Map<Oxx0xo, NavType<?>>) typeMap);
        builder.invoke(navGraphBuilder);
        return navGraphBuilder.build();
    }

    public static /* synthetic */ void navigation$default(NavGraphBuilder navGraphBuilder, oxoX startDestination, Map typeMap, oOoXoXO builder, int i, Object obj) {
        if ((i & 2) != 0) {
            typeMap = o0.O0xOxO();
        }
        IIX0o.x0xO0oo(navGraphBuilder, "<this>");
        IIX0o.x0xO0oo(startDestination, "startDestination");
        IIX0o.x0xO0oo(typeMap, "typeMap");
        IIX0o.x0xO0oo(builder, "builder");
        NavigatorProvider provider = navGraphBuilder.getProvider();
        IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
        NavGraphBuilder navGraphBuilder2 = new NavGraphBuilder(provider, (oxoX<?>) startDestination, (oxoX<?>) IO.oxoX(Object.class), (Map<Oxx0xo, NavType<?>>) typeMap);
        builder.invoke(navGraphBuilder2);
        navGraphBuilder.destination(navGraphBuilder2);
    }

    public static /* synthetic */ void navigation$default(NavGraphBuilder navGraphBuilder, Object startDestination, Map typeMap, oOoXoXO builder, int i, Object obj) {
        if ((i & 2) != 0) {
            typeMap = o0.O0xOxO();
        }
        IIX0o.x0xO0oo(navGraphBuilder, "<this>");
        IIX0o.x0xO0oo(startDestination, "startDestination");
        IIX0o.x0xO0oo(typeMap, "typeMap");
        IIX0o.x0xO0oo(builder, "builder");
        NavigatorProvider provider = navGraphBuilder.getProvider();
        IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
        NavGraphBuilder navGraphBuilder2 = new NavGraphBuilder(provider, startDestination, (oxoX<?>) IO.oxoX(Object.class), (Map<Oxx0xo, NavType<?>>) typeMap);
        builder.invoke(navGraphBuilder2);
        navGraphBuilder.destination(navGraphBuilder2);
    }
}
