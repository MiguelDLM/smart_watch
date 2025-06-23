package androidx.navigation;

import Oox.oOoXoXO;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Lambda;

public final class NavController$executePopOperations$3 extends Lambda implements oOoXoXO<NavDestination, Boolean> {
    final /* synthetic */ NavController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavController$executePopOperations$3(NavController navController) {
        super(1);
        this.this$0 = navController;
    }

    public final Boolean invoke(NavDestination navDestination) {
        IIX0o.x0xO0oo(navDestination, "destination");
        return Boolean.valueOf(!this.this$0.backStackMap.containsKey(Integer.valueOf(navDestination.getId())));
    }
}
