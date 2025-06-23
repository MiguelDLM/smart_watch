package androidx.navigation;

import Oox.oOoXoXO;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import kotlin.sequences.ooOOo0oXI;

@XX({"SMAP\nNavController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NavController.kt\nandroidx/navigation/NavController$handleDeepLink$2\n+ 2 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,2927:1\n2159#2,2:2928\n*S KotlinDebug\n*F\n+ 1 NavController.kt\nandroidx/navigation/NavController$handleDeepLink$2\n*L\n1509#1:2928,2\n*E\n"})
public final class NavController$handleDeepLink$2 extends Lambda implements oOoXoXO<NavOptionsBuilder, oXIO0o0XI> {
    final /* synthetic */ NavDestination $node;
    final /* synthetic */ NavController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavController$handleDeepLink$2(NavDestination navDestination, NavController navController) {
        super(1);
        this.$node = navDestination;
        this.this$0 = navController;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((NavOptionsBuilder) obj);
        return oXIO0o0XI.f19155oIX0oI;
    }

    public final void invoke(NavOptionsBuilder navOptionsBuilder) {
        IIX0o.x0xO0oo(navOptionsBuilder, "$this$navOptions");
        navOptionsBuilder.anim(AnonymousClass1.INSTANCE);
        NavDestination navDestination = this.$node;
        if (navDestination instanceof NavGraph) {
            ooOOo0oXI<NavDestination> hierarchy = NavDestination.Companion.getHierarchy(navDestination);
            NavController navController = this.this$0;
            for (NavDestination next : hierarchy) {
                NavDestination currentDestination = navController.getCurrentDestination();
                if (IIX0o.Oxx0IOOO(next, currentDestination != null ? currentDestination.getParent() : null)) {
                    return;
                }
            }
            if (NavController.deepLinkSaveState) {
                navOptionsBuilder.popUpTo(NavGraph.Companion.findStartDestination(this.this$0.getGraph()).getId(), (oOoXoXO<? super PopUpToBuilder, oXIO0o0XI>) AnonymousClass2.INSTANCE);
            }
        }
    }
}
