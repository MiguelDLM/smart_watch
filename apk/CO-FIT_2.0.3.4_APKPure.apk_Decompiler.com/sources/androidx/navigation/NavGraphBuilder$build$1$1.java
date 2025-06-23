package androidx.navigation;

import Oox.oOoXoXO;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Lambda;

public final class NavGraphBuilder$build$1$1 extends Lambda implements oOoXoXO<NavDestination, String> {
    public static final NavGraphBuilder$build$1$1 INSTANCE = new NavGraphBuilder$build$1$1();

    public NavGraphBuilder$build$1$1() {
        super(1);
    }

    public final String invoke(NavDestination navDestination) {
        IIX0o.x0xO0oo(navDestination, "it");
        String route = navDestination.getRoute();
        IIX0o.ooOOo0oXI(route);
        return route;
    }
}
