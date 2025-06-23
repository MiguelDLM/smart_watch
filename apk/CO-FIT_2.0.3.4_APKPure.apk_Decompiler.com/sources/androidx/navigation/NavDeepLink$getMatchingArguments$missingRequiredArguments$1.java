package androidx.navigation;

import Oox.oOoXoXO;
import android.os.Bundle;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Lambda;

public final class NavDeepLink$getMatchingArguments$missingRequiredArguments$1 extends Lambda implements oOoXoXO<String, Boolean> {
    final /* synthetic */ Bundle $bundle;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavDeepLink$getMatchingArguments$missingRequiredArguments$1(Bundle bundle) {
        super(1);
        this.$bundle = bundle;
    }

    public final Boolean invoke(String str) {
        IIX0o.x0xO0oo(str, "argName");
        return Boolean.valueOf(!this.$bundle.containsKey(str));
    }
}
