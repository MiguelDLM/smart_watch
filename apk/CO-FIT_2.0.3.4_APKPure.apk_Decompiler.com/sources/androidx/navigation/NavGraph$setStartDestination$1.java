package androidx.navigation;

import Oox.oOoXoXO;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Lambda;

public final class NavGraph$setStartDestination$1 extends Lambda implements oOoXoXO<NavDestination, String> {
    public static final NavGraph$setStartDestination$1 INSTANCE = new NavGraph$setStartDestination$1();

    public NavGraph$setStartDestination$1() {
        super(1);
    }

    public final String invoke(NavDestination navDestination) {
        IIX0o.x0xO0oo(navDestination, "startDestination");
        String route = navDestination.getRoute();
        IIX0o.ooOOo0oXI(route);
        return route;
    }
}
