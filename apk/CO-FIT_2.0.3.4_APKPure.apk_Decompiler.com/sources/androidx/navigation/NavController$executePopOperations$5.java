package androidx.navigation;

import Oox.oOoXoXO;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Lambda;

public final class NavController$executePopOperations$5 extends Lambda implements oOoXoXO<NavDestination, NavDestination> {
    public static final NavController$executePopOperations$5 INSTANCE = new NavController$executePopOperations$5();

    public NavController$executePopOperations$5() {
        super(1);
    }

    public final NavDestination invoke(NavDestination navDestination) {
        IIX0o.x0xO0oo(navDestination, "destination");
        NavGraph parent = navDestination.getParent();
        if (parent == null || parent.getStartDestinationId() != navDestination.getId()) {
            return null;
        }
        return navDestination.getParent();
    }
}
