package androidx.navigation;

import Oox.oOoXoXO;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Lambda;

public final class NavGraph$Companion$childHierarchy$1 extends Lambda implements oOoXoXO<NavDestination, NavDestination> {
    public static final NavGraph$Companion$childHierarchy$1 INSTANCE = new NavGraph$Companion$childHierarchy$1();

    public NavGraph$Companion$childHierarchy$1() {
        super(1);
    }

    public final NavDestination invoke(NavDestination navDestination) {
        IIX0o.x0xO0oo(navDestination, "it");
        if (!(navDestination instanceof NavGraph)) {
            return null;
        }
        NavGraph navGraph = (NavGraph) navDestination;
        return navGraph.findNode(navGraph.getStartDestinationId());
    }
}
