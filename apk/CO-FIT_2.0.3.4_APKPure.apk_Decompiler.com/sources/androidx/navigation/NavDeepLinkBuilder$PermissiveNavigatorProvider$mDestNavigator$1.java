package androidx.navigation;

import android.os.Bundle;
import androidx.navigation.Navigator;
import kotlin.jvm.internal.IIX0o;

public final class NavDeepLinkBuilder$PermissiveNavigatorProvider$mDestNavigator$1 extends Navigator<NavDestination> {
    public NavDestination createDestination() {
        return new NavDestination("permissive");
    }

    public NavDestination navigate(NavDestination navDestination, Bundle bundle, NavOptions navOptions, Navigator.Extras extras) {
        IIX0o.x0xO0oo(navDestination, "destination");
        throw new IllegalStateException("navigate is not supported");
    }

    public boolean popBackStack() {
        throw new IllegalStateException("popBackStack is not supported");
    }
}
