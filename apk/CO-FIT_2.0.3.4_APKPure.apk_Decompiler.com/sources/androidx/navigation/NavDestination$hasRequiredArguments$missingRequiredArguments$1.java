package androidx.navigation;

import Oox.oOoXoXO;
import android.os.Bundle;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Lambda;

public final class NavDestination$hasRequiredArguments$missingRequiredArguments$1 extends Lambda implements oOoXoXO<String, Boolean> {
    final /* synthetic */ Bundle $matchingArgs;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavDestination$hasRequiredArguments$missingRequiredArguments$1(Bundle bundle) {
        super(1);
        this.$matchingArgs = bundle;
    }

    public final Boolean invoke(String str) {
        IIX0o.x0xO0oo(str, "key");
        return Boolean.valueOf(!this.$matchingArgs.containsKey(str));
    }
}
