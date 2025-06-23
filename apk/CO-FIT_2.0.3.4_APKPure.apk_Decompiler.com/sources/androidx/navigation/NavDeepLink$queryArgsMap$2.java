package androidx.navigation;

import Oox.oIX0oI;
import androidx.navigation.NavDeepLink;
import java.util.Map;
import kotlin.jvm.internal.Lambda;

public final class NavDeepLink$queryArgsMap$2 extends Lambda implements oIX0oI<Map<String, NavDeepLink.ParamQuery>> {
    final /* synthetic */ NavDeepLink this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavDeepLink$queryArgsMap$2(NavDeepLink navDeepLink) {
        super(0);
        this.this$0 = navDeepLink;
    }

    public final Map<String, NavDeepLink.ParamQuery> invoke() {
        return this.this$0.parseQuery();
    }
}
