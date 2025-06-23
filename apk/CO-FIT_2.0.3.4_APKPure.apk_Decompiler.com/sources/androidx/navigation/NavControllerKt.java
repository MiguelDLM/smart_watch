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

@XX({"SMAP\nNavController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NavController.kt\nandroidx/navigation/NavControllerKt\n+ 2 NavGraphBuilder.kt\nandroidx/navigation/NavGraphBuilderKt\n*L\n1#1,2927:1\n45#2:2928\n59#2:2929\n77#2:2930\n95#2:2931\n*S KotlinDebug\n*F\n+ 1 NavController.kt\nandroidx/navigation/NavControllerKt\n*L\n2879#1:2928\n2892#1:2929\n2909#1:2930\n2926#1:2931\n*E\n"})
public final class NavControllerKt {
    @OOXIXo(message = "Use routes to create your NavGraph instead", replaceWith = @kotlin.XX(expression = "createGraph(startDestination = startDestination.toString(), route = id.toString()) { builder.invoke() }", imports = {}))
    @OXOo.OOXIXo
    public static final NavGraph createGraph(@OXOo.OOXIXo NavController navController, @IdRes int i, @IdRes int i2, @OXOo.OOXIXo oOoXoXO<? super NavGraphBuilder, oXIO0o0XI> oooxoxo) {
        IIX0o.x0xO0oo(navController, "<this>");
        IIX0o.x0xO0oo(oooxoxo, "builder");
        NavGraphBuilder navGraphBuilder = new NavGraphBuilder(navController.getNavigatorProvider(), i, i2);
        oooxoxo.invoke(navGraphBuilder);
        return navGraphBuilder.build();
    }

    public static /* synthetic */ NavGraph createGraph$default(NavController navController, int i, int i2, oOoXoXO oooxoxo, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        IIX0o.x0xO0oo(navController, "<this>");
        IIX0o.x0xO0oo(oooxoxo, "builder");
        NavGraphBuilder navGraphBuilder = new NavGraphBuilder(navController.getNavigatorProvider(), i, i2);
        oooxoxo.invoke(navGraphBuilder);
        return navGraphBuilder.build();
    }

    @OXOo.OOXIXo
    public static final NavGraph createGraph(@OXOo.OOXIXo NavController navController, @OXOo.OOXIXo String str, @OXOo.oOoXoXO String str2, @OXOo.OOXIXo oOoXoXO<? super NavGraphBuilder, oXIO0o0XI> oooxoxo) {
        IIX0o.x0xO0oo(navController, "<this>");
        IIX0o.x0xO0oo(str, "startDestination");
        IIX0o.x0xO0oo(oooxoxo, "builder");
        NavGraphBuilder navGraphBuilder = new NavGraphBuilder(navController.getNavigatorProvider(), str, str2);
        oooxoxo.invoke(navGraphBuilder);
        return navGraphBuilder.build();
    }

    public static /* synthetic */ NavGraph createGraph$default(NavController navController, String str, String str2, oOoXoXO oooxoxo, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        IIX0o.x0xO0oo(navController, "<this>");
        IIX0o.x0xO0oo(str, "startDestination");
        IIX0o.x0xO0oo(oooxoxo, "builder");
        NavGraphBuilder navGraphBuilder = new NavGraphBuilder(navController.getNavigatorProvider(), str, str2);
        oooxoxo.invoke(navGraphBuilder);
        return navGraphBuilder.build();
    }

    @OXOo.OOXIXo
    public static final NavGraph createGraph(@OXOo.OOXIXo NavController navController, @OXOo.OOXIXo oxoX<?> oxox, @OXOo.oOoXoXO oxoX<?> oxox2, @OXOo.OOXIXo Map<Oxx0xo, NavType<?>> map, @OXOo.OOXIXo oOoXoXO<? super NavGraphBuilder, oXIO0o0XI> oooxoxo) {
        IIX0o.x0xO0oo(navController, "<this>");
        IIX0o.x0xO0oo(oxox, "startDestination");
        IIX0o.x0xO0oo(map, "typeMap");
        IIX0o.x0xO0oo(oooxoxo, "builder");
        NavGraphBuilder navGraphBuilder = new NavGraphBuilder(navController.getNavigatorProvider(), oxox, oxox2, map);
        oooxoxo.invoke(navGraphBuilder);
        return navGraphBuilder.build();
    }

    @OXOo.OOXIXo
    public static final NavGraph createGraph(@OXOo.OOXIXo NavController navController, @OXOo.OOXIXo Object obj, @OXOo.oOoXoXO oxoX<?> oxox, @OXOo.OOXIXo Map<Oxx0xo, NavType<?>> map, @OXOo.OOXIXo oOoXoXO<? super NavGraphBuilder, oXIO0o0XI> oooxoxo) {
        IIX0o.x0xO0oo(navController, "<this>");
        IIX0o.x0xO0oo(obj, "startDestination");
        IIX0o.x0xO0oo(map, "typeMap");
        IIX0o.x0xO0oo(oooxoxo, "builder");
        NavGraphBuilder navGraphBuilder = new NavGraphBuilder(navController.getNavigatorProvider(), obj, oxox, map);
        oooxoxo.invoke(navGraphBuilder);
        return navGraphBuilder.build();
    }

    public static /* synthetic */ NavGraph createGraph$default(NavController navController, oxoX oxox, oxoX oxox2, Map map, oOoXoXO oooxoxo, int i, Object obj) {
        if ((i & 2) != 0) {
            oxox2 = null;
        }
        if ((i & 4) != 0) {
            map = o0.O0xOxO();
        }
        IIX0o.x0xO0oo(navController, "<this>");
        IIX0o.x0xO0oo(oxox, "startDestination");
        IIX0o.x0xO0oo(map, "typeMap");
        IIX0o.x0xO0oo(oooxoxo, "builder");
        NavGraphBuilder navGraphBuilder = new NavGraphBuilder(navController.getNavigatorProvider(), (oxoX<?>) oxox, (oxoX<?>) oxox2, (Map<Oxx0xo, NavType<?>>) map);
        oooxoxo.invoke(navGraphBuilder);
        return navGraphBuilder.build();
    }

    public static /* synthetic */ NavGraph createGraph$default(NavController navController, Object obj, oxoX oxox, Map map, oOoXoXO oooxoxo, int i, Object obj2) {
        if ((i & 2) != 0) {
            oxox = null;
        }
        if ((i & 4) != 0) {
            map = o0.O0xOxO();
        }
        IIX0o.x0xO0oo(navController, "<this>");
        IIX0o.x0xO0oo(obj, "startDestination");
        IIX0o.x0xO0oo(map, "typeMap");
        IIX0o.x0xO0oo(oooxoxo, "builder");
        NavGraphBuilder navGraphBuilder = new NavGraphBuilder(navController.getNavigatorProvider(), obj, (oxoX<?>) oxox, (Map<Oxx0xo, NavType<?>>) map);
        oooxoxo.invoke(navGraphBuilder);
        return navGraphBuilder.build();
    }
}
