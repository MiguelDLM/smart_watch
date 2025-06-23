package androidx.navigation;

import Oox.oIX0oI;
import kotlin.jvm.internal.Lambda;

public final class NavController$navInflater$2 extends Lambda implements oIX0oI<NavInflater> {
    final /* synthetic */ NavController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavController$navInflater$2(NavController navController) {
        super(0);
        this.this$0 = navController;
    }

    public final NavInflater invoke() {
        NavInflater access$getInflater$p = this.this$0.inflater;
        return access$getInflater$p == null ? new NavInflater(this.this$0.getContext(), this.this$0._navigatorProvider) : access$getInflater$p;
    }
}
