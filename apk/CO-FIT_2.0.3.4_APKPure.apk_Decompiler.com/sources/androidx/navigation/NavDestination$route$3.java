package androidx.navigation;

import Oox.oIX0oI;
import androidx.navigation.NavDeepLink;
import kotlin.jvm.internal.Lambda;

public final class NavDestination$route$3 extends Lambda implements oIX0oI<NavDeepLink> {
    final /* synthetic */ String $tempRoute;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavDestination$route$3(String str) {
        super(0);
        this.$tempRoute = str;
    }

    public final NavDeepLink invoke() {
        return new NavDeepLink.Builder().setUriPattern(this.$tempRoute).build();
    }
}
