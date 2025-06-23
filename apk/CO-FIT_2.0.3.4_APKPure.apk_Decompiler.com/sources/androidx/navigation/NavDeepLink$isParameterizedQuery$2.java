package androidx.navigation;

import Oox.oIX0oI;
import android.net.Uri;
import kotlin.jvm.internal.Lambda;

public final class NavDeepLink$isParameterizedQuery$2 extends Lambda implements oIX0oI<Boolean> {
    final /* synthetic */ NavDeepLink this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavDeepLink$isParameterizedQuery$2(NavDeepLink navDeepLink) {
        super(0);
        this.this$0 = navDeepLink;
    }

    public final Boolean invoke() {
        return Boolean.valueOf((this.this$0.getUriPattern() == null || Uri.parse(this.this$0.getUriPattern()).getQuery() == null) ? false : true);
    }
}
