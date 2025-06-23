package androidx.navigation;

import Oox.oOoXoXO;
import androidx.annotation.IdRes;
import java.util.Map;
import kotlin.OOXIXo;
import kotlin.collections.o0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import kotlin.reflect.Oxx0xo;
import kotlin.reflect.oxoX;

@XX({"SMAP\nNavHost.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NavHost.kt\nandroidx/navigation/NavHostKt\n+ 2 NavController.kt\nandroidx/navigation/NavControllerKt\n+ 3 NavGraphBuilder.kt\nandroidx/navigation/NavGraphBuilderKt\n*L\n1#1,105:1\n2879#2:106\n2892#2:108\n2909#2:110\n2926#2:112\n45#3:107\n59#3:109\n77#3:111\n95#3:113\n*S KotlinDebug\n*F\n+ 1 NavHost.kt\nandroidx/navigation/NavHostKt\n*L\n63#1:106\n70#1:108\n87#1:110\n104#1:112\n63#1:107\n70#1:109\n87#1:111\n104#1:113\n*E\n"})
public final class NavHostKt {
    @OOXIXo(message = "Use routes to create your NavGraph instead", replaceWith = @kotlin.XX(expression = "createGraph(startDestination = startDestination.toString(), route = id.toString()) { builder.invoke() }", imports = {}))
    @OXOo.OOXIXo
    public static final NavGraph createGraph(@OXOo.OOXIXo NavHost navHost, @IdRes int i, @IdRes int i2, @OXOo.OOXIXo oOoXoXO<? super NavGraphBuilder, oXIO0o0XI> oooxoxo) {
        IIX0o.x0xO0oo(navHost, "<this>");
        IIX0o.x0xO0oo(oooxoxo, "builder");
        NavGraphBuilder navGraphBuilder = new NavGraphBuilder(navHost.getNavController().getNavigatorProvider(), i, i2);
        oooxoxo.invoke(navGraphBuilder);
        return navGraphBuilder.build();
    }

    public static /* synthetic */ NavGraph createGraph$default(NavHost navHost, int i, int i2, oOoXoXO oooxoxo, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        IIX0o.x0xO0oo(navHost, "<this>");
        IIX0o.x0xO0oo(oooxoxo, "builder");
        NavGraphBuilder navGraphBuilder = new NavGraphBuilder(navHost.getNavController().getNavigatorProvider(), i, i2);
        oooxoxo.invoke(navGraphBuilder);
        return navGraphBuilder.build();
    }

    @OXOo.OOXIXo
    public static final NavGraph createGraph(@OXOo.OOXIXo NavHost navHost, @OXOo.OOXIXo String str, @OXOo.oOoXoXO String str2, @OXOo.OOXIXo oOoXoXO<? super NavGraphBuilder, oXIO0o0XI> oooxoxo) {
        IIX0o.x0xO0oo(navHost, "<this>");
        IIX0o.x0xO0oo(str, "startDestination");
        IIX0o.x0xO0oo(oooxoxo, "builder");
        NavGraphBuilder navGraphBuilder = new NavGraphBuilder(navHost.getNavController().getNavigatorProvider(), str, str2);
        oooxoxo.invoke(navGraphBuilder);
        return navGraphBuilder.build();
    }

    public static /* synthetic */ NavGraph createGraph$default(NavHost navHost, String str, String str2, oOoXoXO oooxoxo, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        IIX0o.x0xO0oo(navHost, "<this>");
        IIX0o.x0xO0oo(str, "startDestination");
        IIX0o.x0xO0oo(oooxoxo, "builder");
        NavGraphBuilder navGraphBuilder = new NavGraphBuilder(navHost.getNavController().getNavigatorProvider(), str, str2);
        oooxoxo.invoke(navGraphBuilder);
        return navGraphBuilder.build();
    }

    @OXOo.OOXIXo
    public static final NavGraph createGraph(@OXOo.OOXIXo NavHost navHost, @OXOo.OOXIXo oxoX<?> oxox, @OXOo.oOoXoXO oxoX<?> oxox2, @OXOo.OOXIXo Map<Oxx0xo, NavType<?>> map, @OXOo.OOXIXo oOoXoXO<? super NavGraphBuilder, oXIO0o0XI> oooxoxo) {
        IIX0o.x0xO0oo(navHost, "<this>");
        IIX0o.x0xO0oo(oxox, "startDestination");
        IIX0o.x0xO0oo(map, "typeMap");
        IIX0o.x0xO0oo(oooxoxo, "builder");
        NavGraphBuilder navGraphBuilder = new NavGraphBuilder(navHost.getNavController().getNavigatorProvider(), oxox, oxox2, map);
        oooxoxo.invoke(navGraphBuilder);
        return navGraphBuilder.build();
    }

    public static /* synthetic */ NavGraph createGraph$default(NavHost navHost, oxoX oxox, oxoX oxox2, Map map, oOoXoXO oooxoxo, int i, Object obj) {
        if ((i & 2) != 0) {
            oxox2 = null;
        }
        if ((i & 4) != 0) {
            map = o0.O0xOxO();
        }
        IIX0o.x0xO0oo(navHost, "<this>");
        IIX0o.x0xO0oo(oxox, "startDestination");
        IIX0o.x0xO0oo(map, "typeMap");
        IIX0o.x0xO0oo(oooxoxo, "builder");
        NavGraphBuilder navGraphBuilder = new NavGraphBuilder(navHost.getNavController().getNavigatorProvider(), (oxoX<?>) oxox, (oxoX<?>) oxox2, (Map<Oxx0xo, NavType<?>>) map);
        oooxoxo.invoke(navGraphBuilder);
        return navGraphBuilder.build();
    }

    @OXOo.OOXIXo
    public static final NavGraph createGraph(@OXOo.OOXIXo NavHost navHost, @OXOo.OOXIXo Object obj, @OXOo.oOoXoXO oxoX<?> oxox, @OXOo.OOXIXo Map<Oxx0xo, NavType<?>> map, @OXOo.OOXIXo oOoXoXO<? super NavGraphBuilder, oXIO0o0XI> oooxoxo) {
        IIX0o.x0xO0oo(navHost, "<this>");
        IIX0o.x0xO0oo(obj, "startDestination");
        IIX0o.x0xO0oo(map, "typeMap");
        IIX0o.x0xO0oo(oooxoxo, "builder");
        NavGraphBuilder navGraphBuilder = new NavGraphBuilder(navHost.getNavController().getNavigatorProvider(), obj, oxox, map);
        oooxoxo.invoke(navGraphBuilder);
        return navGraphBuilder.build();
    }

    public static /* synthetic */ NavGraph createGraph$default(NavHost navHost, Object obj, oxoX oxox, Map map, oOoXoXO oooxoxo, int i, Object obj2) {
        if ((i & 2) != 0) {
            oxox = null;
        }
        if ((i & 4) != 0) {
            map = o0.O0xOxO();
        }
        IIX0o.x0xO0oo(navHost, "<this>");
        IIX0o.x0xO0oo(obj, "startDestination");
        IIX0o.x0xO0oo(map, "typeMap");
        IIX0o.x0xO0oo(oooxoxo, "builder");
        NavGraphBuilder navGraphBuilder = new NavGraphBuilder(navHost.getNavController().getNavigatorProvider(), obj, (oxoX<?>) oxox, (Map<Oxx0xo, NavType<?>>) map);
        oooxoxo.invoke(navGraphBuilder);
        return navGraphBuilder.build();
    }
}
