package androidx.navigation;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigator;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.oI0IIXIo;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.XX;
import kotlinx.coroutines.flow.IIXOooo;

@XX({"SMAP\nNavGraphNavigator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NavGraphNavigator.kt\nandroidx/navigation/NavGraphNavigator\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,128:1\n1#2:129\n*E\n"})
@Navigator.Name(NotificationCompat.CATEGORY_NAVIGATION)
/* loaded from: classes.dex */
public class NavGraphNavigator extends Navigator<NavGraph> {

    @OOXIXo
    private final NavigatorProvider navigatorProvider;

    public NavGraphNavigator(@OOXIXo NavigatorProvider navigatorProvider) {
        IIX0o.x0xO0oo(navigatorProvider, "navigatorProvider");
        this.navigatorProvider = navigatorProvider;
    }

    @OOXIXo
    public final IIXOooo<List<NavBackStackEntry>> getBackStack() {
        return getState().getBackStack();
    }

    @Override // androidx.navigation.Navigator
    public void navigate(@OOXIXo List<NavBackStackEntry> entries, @oOoXoXO NavOptions navOptions, @oOoXoXO Navigator.Extras extras) {
        IIX0o.x0xO0oo(entries, "entries");
        Iterator<NavBackStackEntry> it = entries.iterator();
        while (it.hasNext()) {
            navigate(it.next(), navOptions, extras);
        }
    }

    @Override // androidx.navigation.Navigator
    @OOXIXo
    public NavGraph createDestination() {
        return new NavGraph(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v6, types: [android.os.Bundle, T] */
    /* JADX WARN: Type inference failed for: r5v1, types: [android.os.Bundle, T] */
    private final void navigate(NavBackStackEntry navBackStackEntry, NavOptions navOptions, Navigator.Extras extras) {
        NavDestination navDestination;
        NavDestination destination = navBackStackEntry.getDestination();
        IIX0o.x0XOIxOo(destination, "null cannot be cast to non-null type androidx.navigation.NavGraph");
        NavGraph navGraph = (NavGraph) destination;
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
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
                        ?? bundle = new Bundle();
                        bundle.putAll(matchingArgs);
                        T t = objectRef.element;
                        if (((Bundle) t) != null) {
                            bundle.putAll((Bundle) t);
                        }
                        objectRef.element = bundle;
                    }
                }
                if (!navDestination.getArguments().isEmpty()) {
                    List<String> missingRequiredArguments = NavArgumentKt.missingRequiredArguments(navDestination.getArguments(), new Oox.oOoXoXO<String, Boolean>() { // from class: androidx.navigation.NavGraphNavigator$navigate$missingRequiredArgs$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // Oox.oOoXoXO
                        public final Boolean invoke(String key) {
                            IIX0o.x0xO0oo(key, "key");
                            Bundle bundle2 = objectRef.element;
                            boolean z = true;
                            if (bundle2 != null && bundle2.containsKey(key)) {
                                z = false;
                            }
                            return Boolean.valueOf(z);
                        }
                    });
                    if (!missingRequiredArguments.isEmpty()) {
                        throw new IllegalArgumentException(("Cannot navigate to startDestination " + navDestination + ". Missing required arguments [" + missingRequiredArguments + ']').toString());
                    }
                }
            }
            this.navigatorProvider.getNavigator(navDestination.getNavigatorName()).navigate(oI0IIXIo.OOXIXo(getState().createBackStackEntry(navDestination, navDestination.addInDefaultArgs((Bundle) objectRef.element))), navOptions, extras);
            return;
        }
        throw new IllegalArgumentException("navigation destination " + navGraph.getStartDestDisplayName() + " is not a direct child of this NavGraph");
    }
}
