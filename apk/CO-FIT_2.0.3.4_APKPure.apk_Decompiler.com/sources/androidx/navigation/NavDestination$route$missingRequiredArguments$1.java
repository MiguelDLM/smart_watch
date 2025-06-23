package androidx.navigation;

import Oox.oOoXoXO;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Lambda;

public final class NavDestination$route$missingRequiredArguments$1 extends Lambda implements oOoXoXO<String, Boolean> {
    final /* synthetic */ NavDeepLink $tempDeepLink;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavDestination$route$missingRequiredArguments$1(NavDeepLink navDeepLink) {
        super(1);
        this.$tempDeepLink = navDeepLink;
    }

    public final Boolean invoke(String str) {
        IIX0o.x0xO0oo(str, "key");
        return Boolean.valueOf(!this.$tempDeepLink.getArgumentsNames$navigation_common_release().contains(str));
    }
}
