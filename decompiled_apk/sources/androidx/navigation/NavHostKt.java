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
/* loaded from: classes.dex */
public final class NavHostKt {
    @OOXIXo(message = "Use routes to create your NavGraph instead", replaceWith = @kotlin.XX(expression = "createGraph(startDestination = startDestination.toString(), route = id.toString()) { builder.invoke() }", imports = {}))
    @OXOo.OOXIXo
    public static final NavGraph createGraph(@OXOo.OOXIXo NavHost navHost, @IdRes int i, @IdRes int i2, @OXOo.OOXIXo oOoXoXO<? super NavGraphBuilder, oXIO0o0XI> builder) {
        IIX0o.x0xO0oo(navHost, "<this>");
        IIX0o.x0xO0oo(builder, "builder");
        NavGraphBuilder navGraphBuilder = new NavGraphBuilder(navHost.getNavController().getNavigatorProvider(), i, i2);
        builder.invoke(navGraphBuilder);
        return navGraphBuilder.build();
    }

    public static /* synthetic */ NavGraph createGraph$default(NavHost navHost, int i, int i2, oOoXoXO builder, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        IIX0o.x0xO0oo(navHost, "<this>");
        IIX0o.x0xO0oo(builder, "builder");
        NavGraphBuilder navGraphBuilder = new NavGraphBuilder(navHost.getNavController().getNavigatorProvider(), i, i2);
        builder.invoke(navGraphBuilder);
        return navGraphBuilder.build();
    }

    @OXOo.OOXIXo
    public static final NavGraph createGraph(@OXOo.OOXIXo NavHost navHost, @OXOo.OOXIXo String startDestination, @OXOo.oOoXoXO String str, @OXOo.OOXIXo oOoXoXO<? super NavGraphBuilder, oXIO0o0XI> builder) {
        IIX0o.x0xO0oo(navHost, "<this>");
        IIX0o.x0xO0oo(startDestination, "startDestination");
        IIX0o.x0xO0oo(builder, "builder");
        NavGraphBuilder navGraphBuilder = new NavGraphBuilder(navHost.getNavController().getNavigatorProvider(), startDestination, str);
        builder.invoke(navGraphBuilder);
        return navGraphBuilder.build();
    }

    public static /* synthetic */ NavGraph createGraph$default(NavHost navHost, String startDestination, String str, oOoXoXO builder, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        IIX0o.x0xO0oo(navHost, "<this>");
        IIX0o.x0xO0oo(startDestination, "startDestination");
        IIX0o.x0xO0oo(builder, "builder");
        NavGraphBuilder navGraphBuilder = new NavGraphBuilder(navHost.getNavController().getNavigatorProvider(), startDestination, str);
        builder.invoke(navGraphBuilder);
        return navGraphBuilder.build();
    }

    @OXOo.OOXIXo
    public static final NavGraph createGraph(@OXOo.OOXIXo NavHost navHost, @OXOo.OOXIXo oxoX<?> startDestination, @OXOo.oOoXoXO oxoX<?> oxox, @OXOo.OOXIXo Map<Oxx0xo, NavType<?>> typeMap, @OXOo.OOXIXo oOoXoXO<? super NavGraphBuilder, oXIO0o0XI> builder) {
        IIX0o.x0xO0oo(navHost, "<this>");
        IIX0o.x0xO0oo(startDestination, "startDestination");
        IIX0o.x0xO0oo(typeMap, "typeMap");
        IIX0o.x0xO0oo(builder, "builder");
        NavGraphBuilder navGraphBuilder = new NavGraphBuilder(navHost.getNavController().getNavigatorProvider(), startDestination, oxox, typeMap);
        builder.invoke(navGraphBuilder);
        return navGraphBuilder.build();
    }

    public static /* synthetic */ NavGraph createGraph$default(NavHost navHost, oxoX startDestination, oxoX oxox, Map typeMap, oOoXoXO builder, int i, Object obj) {
        if ((i & 2) != 0) {
            oxox = null;
        }
        if ((i & 4) != 0) {
            typeMap = o0.O0xOxO();
        }
        IIX0o.x0xO0oo(navHost, "<this>");
        IIX0o.x0xO0oo(startDestination, "startDestination");
        IIX0o.x0xO0oo(typeMap, "typeMap");
        IIX0o.x0xO0oo(builder, "builder");
        NavGraphBuilder navGraphBuilder = new NavGraphBuilder(navHost.getNavController().getNavigatorProvider(), (oxoX<?>) startDestination, (oxoX<?>) oxox, (Map<Oxx0xo, NavType<?>>) typeMap);
        builder.invoke(navGraphBuilder);
        return navGraphBuilder.build();
    }

    @OXOo.OOXIXo
    public static final NavGraph createGraph(@OXOo.OOXIXo NavHost navHost, @OXOo.OOXIXo Object startDestination, @OXOo.oOoXoXO oxoX<?> oxox, @OXOo.OOXIXo Map<Oxx0xo, NavType<?>> typeMap, @OXOo.OOXIXo oOoXoXO<? super NavGraphBuilder, oXIO0o0XI> builder) {
        IIX0o.x0xO0oo(navHost, "<this>");
        IIX0o.x0xO0oo(startDestination, "startDestination");
        IIX0o.x0xO0oo(typeMap, "typeMap");
        IIX0o.x0xO0oo(builder, "builder");
        NavGraphBuilder navGraphBuilder = new NavGraphBuilder(navHost.getNavController().getNavigatorProvider(), startDestination, oxox, typeMap);
        builder.invoke(navGraphBuilder);
        return navGraphBuilder.build();
    }

    public static /* synthetic */ NavGraph createGraph$default(NavHost navHost, Object startDestination, oxoX oxox, Map typeMap, oOoXoXO builder, int i, Object obj) {
        if ((i & 2) != 0) {
            oxox = null;
        }
        if ((i & 4) != 0) {
            typeMap = o0.O0xOxO();
        }
        IIX0o.x0xO0oo(navHost, "<this>");
        IIX0o.x0xO0oo(startDestination, "startDestination");
        IIX0o.x0xO0oo(typeMap, "typeMap");
        IIX0o.x0xO0oo(builder, "builder");
        NavGraphBuilder navGraphBuilder = new NavGraphBuilder(navHost.getNavController().getNavigatorProvider(), startDestination, (oxoX<?>) oxox, (Map<Oxx0xo, NavType<?>>) typeMap);
        builder.invoke(navGraphBuilder);
        return navGraphBuilder.build();
    }
}
