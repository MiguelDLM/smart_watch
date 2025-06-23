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

public final class NavGraphBuilderKt {
    @OOXIXo(message = "Use routes to build your NavGraph instead", replaceWith = @XX(expression = "navigation(startDestination = startDestination.toString(), route = id.toString()) { builder.invoke() }", imports = {}))
    @OXOo.OOXIXo
    public static final NavGraph navigation(@OXOo.OOXIXo NavigatorProvider navigatorProvider, @IdRes int i, @IdRes int i2, @OXOo.OOXIXo oOoXoXO<? super NavGraphBuilder, oXIO0o0XI> oooxoxo) {
        IIX0o.x0xO0oo(navigatorProvider, "<this>");
        IIX0o.x0xO0oo(oooxoxo, "builder");
        NavGraphBuilder navGraphBuilder = new NavGraphBuilder(navigatorProvider, i, i2);
        oooxoxo.invoke(navGraphBuilder);
        return navGraphBuilder.build();
    }

    public static /* synthetic */ NavGraph navigation$default(NavigatorProvider navigatorProvider, int i, int i2, oOoXoXO oooxoxo, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        IIX0o.x0xO0oo(navigatorProvider, "<this>");
        IIX0o.x0xO0oo(oooxoxo, "builder");
        NavGraphBuilder navGraphBuilder = new NavGraphBuilder(navigatorProvider, i, i2);
        oooxoxo.invoke(navGraphBuilder);
        return navGraphBuilder.build();
    }

    @OXOo.OOXIXo
    public static final NavGraph navigation(@OXOo.OOXIXo NavigatorProvider navigatorProvider, @OXOo.OOXIXo String str, @OXOo.oOoXoXO String str2, @OXOo.OOXIXo oOoXoXO<? super NavGraphBuilder, oXIO0o0XI> oooxoxo) {
        IIX0o.x0xO0oo(navigatorProvider, "<this>");
        IIX0o.x0xO0oo(str, "startDestination");
        IIX0o.x0xO0oo(oooxoxo, "builder");
        NavGraphBuilder navGraphBuilder = new NavGraphBuilder(navigatorProvider, str, str2);
        oooxoxo.invoke(navGraphBuilder);
        return navGraphBuilder.build();
    }

    @OXOo.OOXIXo
    public static final NavGraph navigation(@OXOo.OOXIXo NavigatorProvider navigatorProvider, @OXOo.OOXIXo oxoX<?> oxox, @OXOo.oOoXoXO oxoX<?> oxox2, @OXOo.OOXIXo Map<Oxx0xo, NavType<?>> map, @OXOo.OOXIXo oOoXoXO<? super NavGraphBuilder, oXIO0o0XI> oooxoxo) {
        IIX0o.x0xO0oo(navigatorProvider, "<this>");
        IIX0o.x0xO0oo(oxox, "startDestination");
        IIX0o.x0xO0oo(map, "typeMap");
        IIX0o.x0xO0oo(oooxoxo, "builder");
        NavGraphBuilder navGraphBuilder = new NavGraphBuilder(navigatorProvider, oxox, oxox2, map);
        oooxoxo.invoke(navGraphBuilder);
        return navGraphBuilder.build();
    }

    public static /* synthetic */ NavGraph navigation$default(NavigatorProvider navigatorProvider, String str, String str2, oOoXoXO oooxoxo, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        IIX0o.x0xO0oo(navigatorProvider, "<this>");
        IIX0o.x0xO0oo(str, "startDestination");
        IIX0o.x0xO0oo(oooxoxo, "builder");
        NavGraphBuilder navGraphBuilder = new NavGraphBuilder(navigatorProvider, str, str2);
        oooxoxo.invoke(navGraphBuilder);
        return navGraphBuilder.build();
    }

    @OXOo.OOXIXo
    public static final NavGraph navigation(@OXOo.OOXIXo NavigatorProvider navigatorProvider, @OXOo.OOXIXo Object obj, @OXOo.oOoXoXO oxoX<?> oxox, @OXOo.OOXIXo Map<Oxx0xo, NavType<?>> map, @OXOo.OOXIXo oOoXoXO<? super NavGraphBuilder, oXIO0o0XI> oooxoxo) {
        IIX0o.x0xO0oo(navigatorProvider, "<this>");
        IIX0o.x0xO0oo(obj, "startDestination");
        IIX0o.x0xO0oo(map, "typeMap");
        IIX0o.x0xO0oo(oooxoxo, "builder");
        NavGraphBuilder navGraphBuilder = new NavGraphBuilder(navigatorProvider, obj, oxox, map);
        oooxoxo.invoke(navGraphBuilder);
        return navGraphBuilder.build();
    }

    @OOXIXo(message = "Use routes to build your nested NavGraph instead", replaceWith = @XX(expression = "navigation(startDestination = startDestination.toString(), route = id.toString()) { builder.invoke() }", imports = {}))
    public static final void navigation(@OXOo.OOXIXo NavGraphBuilder navGraphBuilder, @IdRes int i, @IdRes int i2, @OXOo.OOXIXo oOoXoXO<? super NavGraphBuilder, oXIO0o0XI> oooxoxo) {
        IIX0o.x0xO0oo(navGraphBuilder, "<this>");
        IIX0o.x0xO0oo(oooxoxo, "builder");
        NavGraphBuilder navGraphBuilder2 = new NavGraphBuilder(navGraphBuilder.getProvider(), i, i2);
        oooxoxo.invoke(navGraphBuilder2);
        navGraphBuilder.destination(navGraphBuilder2);
    }

    public static /* synthetic */ NavGraph navigation$default(NavigatorProvider navigatorProvider, oxoX oxox, oxoX oxox2, Map map, oOoXoXO oooxoxo, int i, Object obj) {
        if ((i & 2) != 0) {
            oxox2 = null;
        }
        if ((i & 4) != 0) {
            map = o0.O0xOxO();
        }
        IIX0o.x0xO0oo(navigatorProvider, "<this>");
        IIX0o.x0xO0oo(oxox, "startDestination");
        IIX0o.x0xO0oo(map, "typeMap");
        IIX0o.x0xO0oo(oooxoxo, "builder");
        NavGraphBuilder navGraphBuilder = new NavGraphBuilder(navigatorProvider, (oxoX<?>) oxox, (oxoX<?>) oxox2, (Map<Oxx0xo, NavType<?>>) map);
        oooxoxo.invoke(navGraphBuilder);
        return navGraphBuilder.build();
    }

    public static final void navigation(@OXOo.OOXIXo NavGraphBuilder navGraphBuilder, @OXOo.OOXIXo String str, @OXOo.OOXIXo String str2, @OXOo.OOXIXo oOoXoXO<? super NavGraphBuilder, oXIO0o0XI> oooxoxo) {
        IIX0o.x0xO0oo(navGraphBuilder, "<this>");
        IIX0o.x0xO0oo(str, "startDestination");
        IIX0o.x0xO0oo(str2, "route");
        IIX0o.x0xO0oo(oooxoxo, "builder");
        NavGraphBuilder navGraphBuilder2 = new NavGraphBuilder(navGraphBuilder.getProvider(), str, str2);
        oooxoxo.invoke(navGraphBuilder2);
        navGraphBuilder.destination(navGraphBuilder2);
    }

    public static final /* synthetic */ <T> void navigation(NavGraphBuilder navGraphBuilder, oxoX<?> oxox, Map<Oxx0xo, NavType<?>> map, oOoXoXO<? super NavGraphBuilder, oXIO0o0XI> oooxoxo) {
        IIX0o.x0xO0oo(navGraphBuilder, "<this>");
        IIX0o.x0xO0oo(oxox, "startDestination");
        IIX0o.x0xO0oo(map, "typeMap");
        IIX0o.x0xO0oo(oooxoxo, "builder");
        NavigatorProvider provider = navGraphBuilder.getProvider();
        IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
        NavGraphBuilder navGraphBuilder2 = new NavGraphBuilder(provider, oxox, (oxoX<?>) IO.oxoX(Object.class), map);
        oooxoxo.invoke(navGraphBuilder2);
        navGraphBuilder.destination(navGraphBuilder2);
    }

    public static final /* synthetic */ <T> void navigation(NavGraphBuilder navGraphBuilder, Object obj, Map<Oxx0xo, NavType<?>> map, oOoXoXO<? super NavGraphBuilder, oXIO0o0XI> oooxoxo) {
        IIX0o.x0xO0oo(navGraphBuilder, "<this>");
        IIX0o.x0xO0oo(obj, "startDestination");
        IIX0o.x0xO0oo(map, "typeMap");
        IIX0o.x0xO0oo(oooxoxo, "builder");
        NavigatorProvider provider = navGraphBuilder.getProvider();
        IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
        NavGraphBuilder navGraphBuilder2 = new NavGraphBuilder(provider, obj, (oxoX<?>) IO.oxoX(Object.class), map);
        oooxoxo.invoke(navGraphBuilder2);
        navGraphBuilder.destination(navGraphBuilder2);
    }

    public static /* synthetic */ NavGraph navigation$default(NavigatorProvider navigatorProvider, Object obj, oxoX oxox, Map map, oOoXoXO oooxoxo, int i, Object obj2) {
        if ((i & 2) != 0) {
            oxox = null;
        }
        if ((i & 4) != 0) {
            map = o0.O0xOxO();
        }
        IIX0o.x0xO0oo(navigatorProvider, "<this>");
        IIX0o.x0xO0oo(obj, "startDestination");
        IIX0o.x0xO0oo(map, "typeMap");
        IIX0o.x0xO0oo(oooxoxo, "builder");
        NavGraphBuilder navGraphBuilder = new NavGraphBuilder(navigatorProvider, obj, (oxoX<?>) oxox, (Map<Oxx0xo, NavType<?>>) map);
        oooxoxo.invoke(navGraphBuilder);
        return navGraphBuilder.build();
    }

    public static /* synthetic */ void navigation$default(NavGraphBuilder navGraphBuilder, oxoX oxox, Map map, oOoXoXO oooxoxo, int i, Object obj) {
        if ((i & 2) != 0) {
            map = o0.O0xOxO();
        }
        IIX0o.x0xO0oo(navGraphBuilder, "<this>");
        IIX0o.x0xO0oo(oxox, "startDestination");
        IIX0o.x0xO0oo(map, "typeMap");
        IIX0o.x0xO0oo(oooxoxo, "builder");
        NavigatorProvider provider = navGraphBuilder.getProvider();
        IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
        NavGraphBuilder navGraphBuilder2 = new NavGraphBuilder(provider, (oxoX<?>) oxox, (oxoX<?>) IO.oxoX(Object.class), (Map<Oxx0xo, NavType<?>>) map);
        oooxoxo.invoke(navGraphBuilder2);
        navGraphBuilder.destination(navGraphBuilder2);
    }

    public static /* synthetic */ void navigation$default(NavGraphBuilder navGraphBuilder, Object obj, Map map, oOoXoXO oooxoxo, int i, Object obj2) {
        if ((i & 2) != 0) {
            map = o0.O0xOxO();
        }
        IIX0o.x0xO0oo(navGraphBuilder, "<this>");
        IIX0o.x0xO0oo(obj, "startDestination");
        IIX0o.x0xO0oo(map, "typeMap");
        IIX0o.x0xO0oo(oooxoxo, "builder");
        NavigatorProvider provider = navGraphBuilder.getProvider();
        IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
        NavGraphBuilder navGraphBuilder2 = new NavGraphBuilder(provider, obj, (oxoX<?>) IO.oxoX(Object.class), (Map<Oxx0xo, NavType<?>>) map);
        oooxoxo.invoke(navGraphBuilder2);
        navGraphBuilder.destination(navGraphBuilder2);
    }
}
