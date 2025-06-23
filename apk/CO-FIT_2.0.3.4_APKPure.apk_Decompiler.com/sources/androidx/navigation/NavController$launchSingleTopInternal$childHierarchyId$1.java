package androidx.navigation;

import Oox.oOoXoXO;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Lambda;

public final class NavController$launchSingleTopInternal$childHierarchyId$1 extends Lambda implements oOoXoXO<NavDestination, Integer> {
    public static final NavController$launchSingleTopInternal$childHierarchyId$1 INSTANCE = new NavController$launchSingleTopInternal$childHierarchyId$1();

    public NavController$launchSingleTopInternal$childHierarchyId$1() {
        super(1);
    }

    public final Integer invoke(NavDestination navDestination) {
        IIX0o.x0xO0oo(navDestination, "it");
        return Integer.valueOf(navDestination.getId());
    }
}
