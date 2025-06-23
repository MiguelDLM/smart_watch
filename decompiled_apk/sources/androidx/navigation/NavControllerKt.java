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
/* loaded from: classes.dex */
public final class NavControllerKt {
    @OOXIXo(message = "Use routes to create your NavGraph instead", replaceWith = @kotlin.XX(expression = "createGraph(startDestination = startDestination.toString(), route = id.toString()) { builder.invoke() }", imports = {}))
    @OXOo.OOXIXo
    public static final NavGraph createGraph(@OXOo.OOXIXo NavController navController, @IdRes int i, @IdRes int i2, @OXOo.OOXIXo oOoXoXO<? super NavGraphBuilder, oXIO0o0XI> builder) {
        IIX0o.x0xO0oo(navController, "<this>");
        IIX0o.x0xO0oo(builder, "builder");
        NavGraphBuilder navGraphBuilder = new NavGraphBuilder(navController.getNavigatorProvider(), i, i2);
        builder.invoke(navGraphBuilder);
        return navGraphBuilder.build();
    }

    public static /* synthetic */ NavGraph createGraph$default(NavController navController, int i, int i2, oOoXoXO builder, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        IIX0o.x0xO0oo(navController, "<this>");
        IIX0o.x0xO0oo(builder, "builder");
        NavGraphBuilder navGraphBuilder = new NavGraphBuilder(navController.getNavigatorProvider(), i, i2);
        builder.invoke(navGraphBuilder);
        return navGraphBuilder.build();
    }

    @OXOo.OOXIXo
    public static final NavGraph createGraph(@OXOo.OOXIXo NavController navController, @OXOo.OOXIXo String startDestination, @OXOo.oOoXoXO String str, @OXOo.OOXIXo oOoXoXO<? super NavGraphBuilder, oXIO0o0XI> builder) {
        IIX0o.x0xO0oo(navController, "<this>");
        IIX0o.x0xO0oo(startDestination, "startDestination");
        IIX0o.x0xO0oo(builder, "builder");
        NavGraphBuilder navGraphBuilder = new NavGraphBuilder(navController.getNavigatorProvider(), startDestination, str);
        builder.invoke(navGraphBuilder);
        return navGraphBuilder.build();
    }

    public static /* synthetic */ NavGraph createGraph$default(NavController navController, String startDestination, String str, oOoXoXO builder, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        IIX0o.x0xO0oo(navController, "<this>");
        IIX0o.x0xO0oo(startDestination, "startDestination");
        IIX0o.x0xO0oo(builder, "builder");
        NavGraphBuilder navGraphBuilder = new NavGraphBuilder(navController.getNavigatorProvider(), startDestination, str);
        builder.invoke(navGraphBuilder);
        return navGraphBuilder.build();
    }

    @OXOo.OOXIXo
    public static final NavGraph createGraph(@OXOo.OOXIXo NavController navController, @OXOo.OOXIXo oxoX<?> startDestination, @OXOo.oOoXoXO oxoX<?> oxox, @OXOo.OOXIXo Map<Oxx0xo, NavType<?>> typeMap, @OXOo.OOXIXo oOoXoXO<? super NavGraphBuilder, oXIO0o0XI> builder) {
        IIX0o.x0xO0oo(navController, "<this>");
        IIX0o.x0xO0oo(startDestination, "startDestination");
        IIX0o.x0xO0oo(typeMap, "typeMap");
        IIX0o.x0xO0oo(builder, "builder");
        NavGraphBuilder navGraphBuilder = new NavGraphBuilder(navController.getNavigatorProvider(), startDestination, oxox, typeMap);
        builder.invoke(navGraphBuilder);
        return navGraphBuilder.build();
    }

    @OXOo.OOXIXo
    public static final NavGraph createGraph(@OXOo.OOXIXo NavController navController, @OXOo.OOXIXo Object startDestination, @OXOo.oOoXoXO oxoX<?> oxox, @OXOo.OOXIXo Map<Oxx0xo, NavType<?>> typeMap, @OXOo.OOXIXo oOoXoXO<? super NavGraphBuilder, oXIO0o0XI> builder) {
        IIX0o.x0xO0oo(navController, "<this>");
        IIX0o.x0xO0oo(startDestination, "startDestination");
        IIX0o.x0xO0oo(typeMap, "typeMap");
        IIX0o.x0xO0oo(builder, "builder");
        NavGraphBuilder navGraphBuilder = new NavGraphBuilder(navController.getNavigatorProvider(), startDestination, oxox, typeMap);
        builder.invoke(navGraphBuilder);
        return navGraphBuilder.build();
    }

    public static /* synthetic */ NavGraph createGraph$default(NavController navController, oxoX startDestination, oxoX oxox, Map typeMap, oOoXoXO builder, int i, Object obj) {
        if ((i & 2) != 0) {
            oxox = null;
        }
        if ((i & 4) != 0) {
            typeMap = o0.O0xOxO();
        }
        IIX0o.x0xO0oo(navController, "<this>");
        IIX0o.x0xO0oo(startDestination, "startDestination");
        IIX0o.x0xO0oo(typeMap, "typeMap");
        IIX0o.x0xO0oo(builder, "builder");
        NavGraphBuilder navGraphBuilder = new NavGraphBuilder(navController.getNavigatorProvider(), (oxoX<?>) startDestination, (oxoX<?>) oxox, (Map<Oxx0xo, NavType<?>>) typeMap);
        builder.invoke(navGraphBuilder);
        return navGraphBuilder.build();
    }

    public static /* synthetic */ NavGraph createGraph$default(NavController navController, Object startDestination, oxoX oxox, Map typeMap, oOoXoXO builder, int i, Object obj) {
        if ((i & 2) != 0) {
            oxox = null;
        }
        if ((i & 4) != 0) {
            typeMap = o0.O0xOxO();
        }
        IIX0o.x0xO0oo(navController, "<this>");
        IIX0o.x0xO0oo(startDestination, "startDestination");
        IIX0o.x0xO0oo(typeMap, "typeMap");
        IIX0o.x0xO0oo(builder, "builder");
        NavGraphBuilder navGraphBuilder = new NavGraphBuilder(navController.getNavigatorProvider(), startDestination, (oxoX<?>) oxox, (Map<Oxx0xo, NavType<?>>) typeMap);
        builder.invoke(navGraphBuilder);
        return navGraphBuilder.build();
    }
}
