package androidx.navigation;

import Oox.oIX0oI;
import kotlin.Pair;
import kotlin.jvm.internal.Lambda;

public final class NavDeepLink$fragRegex$2 extends Lambda implements oIX0oI<String> {
    final /* synthetic */ NavDeepLink this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavDeepLink$fragRegex$2(NavDeepLink navDeepLink) {
        super(0);
        this.this$0 = navDeepLink;
    }

    public final String invoke() {
        Pair access$getFragArgsAndRegex = this.this$0.getFragArgsAndRegex();
        if (access$getFragArgsAndRegex != null) {
            return (String) access$getFragArgsAndRegex.getSecond();
        }
        return null;
    }
}
