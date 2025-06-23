package androidx.navigation;

import Oox.oOoXoXO;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Lambda;

public final class NavDestination$addDeepLink$missingRequiredArguments$1 extends Lambda implements oOoXoXO<String, Boolean> {
    final /* synthetic */ NavDeepLink $navDeepLink;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavDestination$addDeepLink$missingRequiredArguments$1(NavDeepLink navDeepLink) {
        super(1);
        this.$navDeepLink = navDeepLink;
    }

    public final Boolean invoke(String str) {
        IIX0o.x0xO0oo(str, "key");
        return Boolean.valueOf(!this.$navDeepLink.getArgumentsNames$navigation_common_release().contains(str));
    }
}
