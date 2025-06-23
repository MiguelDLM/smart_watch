package androidx.navigation;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import androidx.annotation.IdRes;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.reflect.Oxx0xo;
import kotlin.reflect.oxoX;
import kotlinx.serialization.OxxIIOOXO;

@NavDestinationDsl
@XX({"SMAP\nNavGraphBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NavGraphBuilder.kt\nandroidx/navigation/NavGraphBuilder\n+ 2 NavigatorProvider.kt\nandroidx/navigation/NavigatorProviderKt\n*L\n1#1,305:1\n157#2:306\n157#2:307\n157#2:308\n157#2:309\n*S KotlinDebug\n*F\n+ 1 NavGraphBuilder.kt\nandroidx/navigation/NavGraphBuilder\n*L\n197#1:306\n214#1:307\n235#1:308\n256#1:309\n*E\n"})
public class NavGraphBuilder extends NavDestinationBuilder<NavGraph> {
    @OOXIXo
    private final List<NavDestination> destinations = new ArrayList();
    @OOXIXo
    private final NavigatorProvider provider;
    @oOoXoXO
    private oxoX<?> startDestinationClass;
    @IdRes
    private int startDestinationId;
    @oOoXoXO
    private Object startDestinationObject;
    @oOoXoXO
    private String startDestinationRoute;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @kotlin.OOXIXo(message = "Use routes to build your NavGraph instead", replaceWith = @kotlin.XX(expression = "NavGraphBuilder(provider, startDestination = startDestination.toString(), route = id.toString())", imports = {}))
    public NavGraphBuilder(@OOXIXo NavigatorProvider navigatorProvider, @IdRes int i, @IdRes int i2) {
        super(navigatorProvider.getNavigator(NavGraphNavigator.class), i);
        IIX0o.x0xO0oo(navigatorProvider, "provider");
        this.provider = navigatorProvider;
        this.startDestinationId = i2;
    }

    public final void addDestination(@OOXIXo NavDestination navDestination) {
        IIX0o.x0xO0oo(navDestination, "destination");
        this.destinations.add(navDestination);
    }

    public final <D extends NavDestination> void destination(@OOXIXo NavDestinationBuilder<? extends D> navDestinationBuilder) {
        IIX0o.x0xO0oo(navDestinationBuilder, "navDestination");
        this.destinations.add(navDestinationBuilder.build());
    }

    @OOXIXo
    public final NavigatorProvider getProvider() {
        return this.provider;
    }

    public final void unaryPlus(@OOXIXo NavDestination navDestination) {
        IIX0o.x0xO0oo(navDestination, "<this>");
        addDestination(navDestination);
    }

    @OOXIXo
    public NavGraph build() {
        NavGraph navGraph = (NavGraph) super.build();
        navGraph.addDestinations((Collection<? extends NavDestination>) this.destinations);
        int i = this.startDestinationId;
        if (i != 0 || this.startDestinationRoute != null || this.startDestinationClass != null || this.startDestinationObject != null) {
            String str = this.startDestinationRoute;
            if (str != null) {
                IIX0o.ooOOo0oXI(str);
                navGraph.setStartDestination(str);
            } else {
                oxoX<?> oxox = this.startDestinationClass;
                if (oxox != null) {
                    IIX0o.ooOOo0oXI(oxox);
                    navGraph.setStartDestination(OxxIIOOXO.Oxx0IOOO(oxox), NavGraphBuilder$build$1$1.INSTANCE);
                } else {
                    Object obj = this.startDestinationObject;
                    if (obj != null) {
                        IIX0o.ooOOo0oXI(obj);
                        navGraph.setStartDestination(obj);
                    } else {
                        navGraph.setStartDestination(i);
                    }
                }
            }
            return navGraph;
        } else if (getRoute() != null) {
            throw new IllegalStateException("You must set a start destination route");
        } else {
            throw new IllegalStateException("You must set a start destination id");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavGraphBuilder(@OOXIXo NavigatorProvider navigatorProvider, @OOXIXo String str, @oOoXoXO String str2) {
        super(navigatorProvider.getNavigator(NavGraphNavigator.class), str2);
        IIX0o.x0xO0oo(navigatorProvider, "provider");
        IIX0o.x0xO0oo(str, "startDestination");
        this.provider = navigatorProvider;
        this.startDestinationRoute = str;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavGraphBuilder(@OOXIXo NavigatorProvider navigatorProvider, @OOXIXo oxoX<?> oxox, @oOoXoXO oxoX<?> oxox2, @OOXIXo Map<Oxx0xo, NavType<?>> map) {
        super(navigatorProvider.getNavigator(NavGraphNavigator.class), oxox2, map);
        IIX0o.x0xO0oo(navigatorProvider, "provider");
        IIX0o.x0xO0oo(oxox, "startDestination");
        IIX0o.x0xO0oo(map, "typeMap");
        this.provider = navigatorProvider;
        this.startDestinationClass = oxox;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavGraphBuilder(@OOXIXo NavigatorProvider navigatorProvider, @OOXIXo Object obj, @oOoXoXO oxoX<?> oxox, @OOXIXo Map<Oxx0xo, NavType<?>> map) {
        super(navigatorProvider.getNavigator(NavGraphNavigator.class), oxox, map);
        IIX0o.x0xO0oo(navigatorProvider, "provider");
        IIX0o.x0xO0oo(obj, "startDestination");
        IIX0o.x0xO0oo(map, "typeMap");
        this.provider = navigatorProvider;
        this.startDestinationObject = obj;
    }
}
