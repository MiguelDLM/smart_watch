package androidx.navigation;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import androidx.annotation.IdRes;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.reflect.Oxx0xo;
import kotlin.reflect.oxoX;
import kotlinx.serialization.OxxIIOOXO;

@NavDestinationDsl
@XX({"SMAP\nNavGraphBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NavGraphBuilder.kt\nandroidx/navigation/NavGraphBuilder\n+ 2 NavigatorProvider.kt\nandroidx/navigation/NavigatorProviderKt\n*L\n1#1,305:1\n157#2:306\n157#2:307\n157#2:308\n157#2:309\n*S KotlinDebug\n*F\n+ 1 NavGraphBuilder.kt\nandroidx/navigation/NavGraphBuilder\n*L\n197#1:306\n214#1:307\n235#1:308\n256#1:309\n*E\n"})
/* loaded from: classes.dex */
public class NavGraphBuilder extends NavDestinationBuilder<NavGraph> {

    @OOXIXo
    private final List<NavDestination> destinations;

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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @kotlin.OOXIXo(message = "Use routes to build your NavGraph instead", replaceWith = @kotlin.XX(expression = "NavGraphBuilder(provider, startDestination = startDestination.toString(), route = id.toString())", imports = {}))
    public NavGraphBuilder(@OOXIXo NavigatorProvider provider, @IdRes int i, @IdRes int i2) {
        super(provider.getNavigator(NavGraphNavigator.class), i);
        IIX0o.x0xO0oo(provider, "provider");
        this.destinations = new ArrayList();
        this.provider = provider;
        this.startDestinationId = i2;
    }

    public final void addDestination(@OOXIXo NavDestination destination) {
        IIX0o.x0xO0oo(destination, "destination");
        this.destinations.add(destination);
    }

    public final <D extends NavDestination> void destination(@OOXIXo NavDestinationBuilder<? extends D> navDestination) {
        IIX0o.x0xO0oo(navDestination, "navDestination");
        this.destinations.add(navDestination.build());
    }

    @OOXIXo
    public final NavigatorProvider getProvider() {
        return this.provider;
    }

    public final void unaryPlus(@OOXIXo NavDestination navDestination) {
        IIX0o.x0xO0oo(navDestination, "<this>");
        addDestination(navDestination);
    }

    @Override // androidx.navigation.NavDestinationBuilder
    @OOXIXo
    public NavGraph build() {
        NavGraph navGraph = (NavGraph) super.build();
        navGraph.addDestinations(this.destinations);
        int i = this.startDestinationId;
        if (i == 0 && this.startDestinationRoute == null && this.startDestinationClass == null && this.startDestinationObject == null) {
            if (getRoute() != null) {
                throw new IllegalStateException("You must set a start destination route");
            }
            throw new IllegalStateException("You must set a start destination id");
        }
        String str = this.startDestinationRoute;
        if (str != null) {
            IIX0o.ooOOo0oXI(str);
            navGraph.setStartDestination(str);
        } else {
            oxoX<?> oxox = this.startDestinationClass;
            if (oxox != null) {
                IIX0o.ooOOo0oXI(oxox);
                navGraph.setStartDestination(OxxIIOOXO.Oxx0IOOO(oxox), new Oox.oOoXoXO<NavDestination, String>() { // from class: androidx.navigation.NavGraphBuilder$build$1$1
                    @Override // Oox.oOoXoXO
                    public final String invoke(NavDestination it) {
                        IIX0o.x0xO0oo(it, "it");
                        String route = it.getRoute();
                        IIX0o.ooOOo0oXI(route);
                        return route;
                    }
                });
            } else {
                Object obj = this.startDestinationObject;
                if (obj != null) {
                    IIX0o.ooOOo0oXI(obj);
                    navGraph.setStartDestination((NavGraph) obj);
                } else {
                    navGraph.setStartDestination(i);
                }
            }
        }
        return navGraph;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NavGraphBuilder(@OOXIXo NavigatorProvider provider, @OOXIXo String startDestination, @oOoXoXO String str) {
        super(provider.getNavigator(NavGraphNavigator.class), str);
        IIX0o.x0xO0oo(provider, "provider");
        IIX0o.x0xO0oo(startDestination, "startDestination");
        this.destinations = new ArrayList();
        this.provider = provider;
        this.startDestinationRoute = startDestination;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NavGraphBuilder(@OOXIXo NavigatorProvider provider, @OOXIXo oxoX<?> startDestination, @oOoXoXO oxoX<?> oxox, @OOXIXo Map<Oxx0xo, NavType<?>> typeMap) {
        super(provider.getNavigator(NavGraphNavigator.class), oxox, typeMap);
        IIX0o.x0xO0oo(provider, "provider");
        IIX0o.x0xO0oo(startDestination, "startDestination");
        IIX0o.x0xO0oo(typeMap, "typeMap");
        this.destinations = new ArrayList();
        this.provider = provider;
        this.startDestinationClass = startDestination;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NavGraphBuilder(@OOXIXo NavigatorProvider provider, @OOXIXo Object startDestination, @oOoXoXO oxoX<?> oxox, @OOXIXo Map<Oxx0xo, NavType<?>> typeMap) {
        super(provider.getNavigator(NavGraphNavigator.class), oxox, typeMap);
        IIX0o.x0xO0oo(provider, "provider");
        IIX0o.x0xO0oo(startDestination, "startDestination");
        IIX0o.x0xO0oo(typeMap, "typeMap");
        this.destinations = new ArrayList();
        this.provider = provider;
        this.startDestinationObject = startDestination;
    }
}
