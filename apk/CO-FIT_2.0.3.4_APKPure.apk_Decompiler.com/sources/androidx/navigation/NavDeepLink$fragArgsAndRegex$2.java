package androidx.navigation;

import Oox.oIX0oI;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.Lambda;

public final class NavDeepLink$fragArgsAndRegex$2 extends Lambda implements oIX0oI<Pair<? extends List<String>, ? extends String>> {
    final /* synthetic */ NavDeepLink this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavDeepLink$fragArgsAndRegex$2(NavDeepLink navDeepLink) {
        super(0);
        this.this$0 = navDeepLink;
    }

    public final Pair<List<String>, String> invoke() {
        return this.this$0.parseFragment();
    }
}
