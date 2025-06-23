package androidx.navigation;

import Oox.oOoXoXO;
import android.os.Bundle;
import java.util.List;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.oXIO0o0XI;

public final class NavController$navigate$5 extends Lambda implements oOoXoXO<NavBackStackEntry, oXIO0o0XI> {
    final /* synthetic */ Bundle $finalArgs;
    final /* synthetic */ Ref.BooleanRef $navigated;
    final /* synthetic */ NavDestination $node;
    final /* synthetic */ NavController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavController$navigate$5(Ref.BooleanRef booleanRef, NavController navController, NavDestination navDestination, Bundle bundle) {
        super(1);
        this.$navigated = booleanRef;
        this.this$0 = navController;
        this.$node = navDestination;
        this.$finalArgs = bundle;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((NavBackStackEntry) obj);
        return oXIO0o0XI.f19155oIX0oI;
    }

    public final void invoke(NavBackStackEntry navBackStackEntry) {
        IIX0o.x0xO0oo(navBackStackEntry, "it");
        this.$navigated.element = true;
        NavController.addEntryToBackStack$default(this.this$0, this.$node, this.$finalArgs, navBackStackEntry, (List) null, 8, (Object) null);
    }
}
