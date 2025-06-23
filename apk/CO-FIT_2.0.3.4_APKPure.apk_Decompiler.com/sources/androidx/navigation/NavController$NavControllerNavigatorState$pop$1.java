package androidx.navigation;

import Oox.oIX0oI;
import androidx.navigation.NavController;
import kotlin.jvm.internal.Lambda;
import kotlin.oXIO0o0XI;

public final class NavController$NavControllerNavigatorState$pop$1 extends Lambda implements oIX0oI<oXIO0o0XI> {
    final /* synthetic */ NavBackStackEntry $popUpTo;
    final /* synthetic */ boolean $saveState;
    final /* synthetic */ NavController.NavControllerNavigatorState this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavController$NavControllerNavigatorState$pop$1(NavController.NavControllerNavigatorState navControllerNavigatorState, NavBackStackEntry navBackStackEntry, boolean z) {
        super(0);
        this.this$0 = navControllerNavigatorState;
        this.$popUpTo = navBackStackEntry;
        this.$saveState = z;
    }

    public final void invoke() {
        NavController$NavControllerNavigatorState$pop$1.super.pop(this.$popUpTo, this.$saveState);
    }
}
