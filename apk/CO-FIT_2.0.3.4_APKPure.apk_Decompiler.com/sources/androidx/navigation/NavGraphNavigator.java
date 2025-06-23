package androidx.navigation;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.os.Bundle;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigator;
import java.util.List;
import kotlin.collections.oI0IIXIo;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.XX;
import kotlinx.coroutines.flow.IIXOooo;

@XX({"SMAP\nNavGraphNavigator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NavGraphNavigator.kt\nandroidx/navigation/NavGraphNavigator\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,128:1\n1#2:129\n*E\n"})
@Navigator.Name("navigation")
public class NavGraphNavigator extends Navigator<NavGraph> {
    @OOXIXo
    private final NavigatorProvider navigatorProvider;

    public NavGraphNavigator(@OOXIXo NavigatorProvider navigatorProvider2) {
        IIX0o.x0xO0oo(navigatorProvider2, "navigatorProvider");
        this.navigatorProvider = navigatorProvider2;
    }

    @OOXIXo
    public final IIXOooo<List<NavBackStackEntry>> getBackStack() {
        return getState().getBackStack();
    }

    public void navigate(@OOXIXo List<NavBackStackEntry> list, @oOoXoXO NavOptions navOptions, @oOoXoXO Navigator.Extras extras) {
        IIX0o.x0xO0oo(list, "entries");
        for (NavBackStackEntry navigate : list) {
            navigate(navigate, navOptions, extras);
        }
    }

    @OOXIXo
    public NavGraph createDestination() {
        return new NavGraph(this);
    }

    private final void navigate(NavBackStackEntry navBackStackEntry, NavOptions navOptions, Navigator.Extras extras) {
        NavDestination navDestination;
        NavDestination destination = navBackStackEntry.getDestination();
        IIX0o.x0XOIxOo(destination, "null cannot be cast to non-null type androidx.navigation.NavGraph");
        NavGraph navGraph = (NavGraph) destination;
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = navBackStackEntry.getArguments();
        int startDestinationId = navGraph.getStartDestinationId();
        String startDestinationRoute = navGraph.getStartDestinationRoute();
        if (startDestinationId == 0 && startDestinationRoute == null) {
            throw new IllegalStateException(("no start destination defined via app:startDestination for " + navGraph.getDisplayName()).toString());
        }
        if (startDestinationRoute != null) {
            navDestination = navGraph.findNode(startDestinationRoute, false);
        } else {
            navDestination = navGraph.getNodes().get(startDestinationId);
        }
        if (navDestination != null) {
            if (startDestinationRoute != null) {
                if (!IIX0o.Oxx0IOOO(startDestinationRoute, navDestination.getRoute())) {
                    NavDestination.DeepLinkMatch matchRoute = navDestination.matchRoute(startDestinationRoute);
                    Bundle matchingArgs = matchRoute != null ? matchRoute.getMatchingArgs() : null;
                    if (matchingArgs != null && !matchingArgs.isEmpty()) {
                        T bundle = new Bundle();
                        bundle.putAll(matchingArgs);
                        T t = objectRef.element;
                        if (((Bundle) t) != null) {
                            bundle.putAll((Bundle) t);
                        }
                        objectRef.element = bundle;
                    }
                }
                if (!navDestination.getArguments().isEmpty()) {
                    List<String> missingRequiredArguments = NavArgumentKt.missingRequiredArguments(navDestination.getArguments(), new NavGraphNavigator$navigate$missingRequiredArgs$1(objectRef));
                    if (!missingRequiredArguments.isEmpty()) {
                        throw new IllegalArgumentException(("Cannot navigate to startDestination " + navDestination + ". Missing required arguments [" + missingRequiredArguments + ']').toString());
                    }
                }
            }
            this.navigatorProvider.getNavigator(navDestination.getNavigatorName()).navigate(oI0IIXIo.OOXIXo(getState().createBackStackEntry(navDestination, navDestination.addInDefaultArgs((Bundle) objectRef.element))), navOptions, extras);
            return;
        }
        String startDestDisplayName = navGraph.getStartDestDisplayName();
        throw new IllegalArgumentException("navigation destination " + startDestDisplayName + " is not a direct child of this NavGraph");
    }
}
