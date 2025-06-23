package okhttp3.internal.connection;

import OXOo.OOXIXo;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.IIX0o;
import okhttp3.Route;

/* loaded from: classes6.dex */
public final class RouteDatabase {

    @OOXIXo
    private final Set<Route> failedRoutes = new LinkedHashSet();

    public final synchronized void connected(@OOXIXo Route route) {
        IIX0o.x0xO0oo(route, "route");
        this.failedRoutes.remove(route);
    }

    public final synchronized void failed(@OOXIXo Route failedRoute) {
        IIX0o.x0xO0oo(failedRoute, "failedRoute");
        this.failedRoutes.add(failedRoute);
    }

    public final synchronized boolean shouldPostpone(@OOXIXo Route route) {
        IIX0o.x0xO0oo(route, "route");
        return this.failedRoutes.contains(route);
    }
}
