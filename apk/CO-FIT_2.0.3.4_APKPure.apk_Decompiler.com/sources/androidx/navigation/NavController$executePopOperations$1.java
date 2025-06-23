package androidx.navigation;

import Oox.oOoXoXO;
import kotlin.collections.xxIXOIIO;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.oXIO0o0XI;

public final class NavController$executePopOperations$1 extends Lambda implements oOoXoXO<NavBackStackEntry, oXIO0o0XI> {
    final /* synthetic */ Ref.BooleanRef $popped;
    final /* synthetic */ Ref.BooleanRef $receivedPop;
    final /* synthetic */ boolean $saveState;
    final /* synthetic */ xxIXOIIO<NavBackStackEntryState> $savedState;
    final /* synthetic */ NavController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavController$executePopOperations$1(Ref.BooleanRef booleanRef, Ref.BooleanRef booleanRef2, NavController navController, boolean z, xxIXOIIO<NavBackStackEntryState> xxixoiio) {
        super(1);
        this.$receivedPop = booleanRef;
        this.$popped = booleanRef2;
        this.this$0 = navController;
        this.$saveState = z;
        this.$savedState = xxixoiio;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((NavBackStackEntry) obj);
        return oXIO0o0XI.f19155oIX0oI;
    }

    public final void invoke(NavBackStackEntry navBackStackEntry) {
        IIX0o.x0xO0oo(navBackStackEntry, "entry");
        this.$receivedPop.element = true;
        this.$popped.element = true;
        this.this$0.popEntryFromBackStack(navBackStackEntry, this.$saveState, this.$savedState);
    }
}
