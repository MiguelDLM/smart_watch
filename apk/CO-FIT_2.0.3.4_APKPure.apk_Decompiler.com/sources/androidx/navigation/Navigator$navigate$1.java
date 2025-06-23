package androidx.navigation;

import Oox.oOoXoXO;
import androidx.navigation.Navigator;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Lambda;

public final class Navigator$navigate$1 extends Lambda implements oOoXoXO<NavBackStackEntry, NavBackStackEntry> {
    final /* synthetic */ NavOptions $navOptions;
    final /* synthetic */ Navigator.Extras $navigatorExtras;
    final /* synthetic */ Navigator<D> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Navigator$navigate$1(Navigator<D> navigator, NavOptions navOptions, Navigator.Extras extras) {
        super(1);
        this.this$0 = navigator;
        this.$navOptions = navOptions;
        this.$navigatorExtras = extras;
    }

    public final NavBackStackEntry invoke(NavBackStackEntry navBackStackEntry) {
        IIX0o.x0xO0oo(navBackStackEntry, "backStackEntry");
        NavDestination destination = navBackStackEntry.getDestination();
        if (!(destination instanceof NavDestination)) {
            destination = null;
        }
        if (destination == null) {
            return null;
        }
        NavDestination navigate = this.this$0.navigate(destination, navBackStackEntry.getArguments(), this.$navOptions, this.$navigatorExtras);
        if (navigate == null) {
            return null;
        }
        return IIX0o.Oxx0IOOO(navigate, destination) ? navBackStackEntry : this.this$0.getState().createBackStackEntry(navigate, navigate.addInDefaultArgs(navBackStackEntry.getArguments()));
    }
}
