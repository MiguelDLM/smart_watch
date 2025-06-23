package androidx.navigation;

import Oox.oOoXoXO;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Lambda;
import kotlin.oXIO0o0XI;

public final class Navigator$onLaunchSingleTop$1 extends Lambda implements oOoXoXO<NavOptionsBuilder, oXIO0o0XI> {
    public static final Navigator$onLaunchSingleTop$1 INSTANCE = new Navigator$onLaunchSingleTop$1();

    public Navigator$onLaunchSingleTop$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((NavOptionsBuilder) obj);
        return oXIO0o0XI.f19155oIX0oI;
    }

    public final void invoke(NavOptionsBuilder navOptionsBuilder) {
        IIX0o.x0xO0oo(navOptionsBuilder, "$this$navOptions");
        navOptionsBuilder.setLaunchSingleTop(true);
    }
}
