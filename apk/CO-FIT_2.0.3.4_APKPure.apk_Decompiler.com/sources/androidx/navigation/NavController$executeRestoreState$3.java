package androidx.navigation;

import Oox.oOoXoXO;
import android.os.Bundle;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.oXIO0o0XI;

public final class NavController$executeRestoreState$3 extends Lambda implements oOoXoXO<NavBackStackEntry, oXIO0o0XI> {
    final /* synthetic */ Bundle $args;
    final /* synthetic */ List<NavBackStackEntry> $entries;
    final /* synthetic */ Ref.IntRef $lastNavigatedIndex;
    final /* synthetic */ Ref.BooleanRef $navigated;
    final /* synthetic */ NavController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavController$executeRestoreState$3(Ref.BooleanRef booleanRef, List<NavBackStackEntry> list, Ref.IntRef intRef, NavController navController, Bundle bundle) {
        super(1);
        this.$navigated = booleanRef;
        this.$entries = list;
        this.$lastNavigatedIndex = intRef;
        this.this$0 = navController;
        this.$args = bundle;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((NavBackStackEntry) obj);
        return oXIO0o0XI.f19155oIX0oI;
    }

    public final void invoke(NavBackStackEntry navBackStackEntry) {
        List<NavBackStackEntry> list;
        IIX0o.x0xO0oo(navBackStackEntry, "entry");
        this.$navigated.element = true;
        int indexOf = this.$entries.indexOf(navBackStackEntry);
        if (indexOf != -1) {
            int i = indexOf + 1;
            list = this.$entries.subList(this.$lastNavigatedIndex.element, i);
            this.$lastNavigatedIndex.element = i;
        } else {
            list = CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        this.this$0.addEntryToBackStack(navBackStackEntry.getDestination(), this.$args, navBackStackEntry, list);
    }
}
