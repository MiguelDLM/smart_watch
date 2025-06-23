package androidx.navigation;

import Oox.oOoXoXO;
import android.os.Bundle;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

public final class NavGraphNavigator$navigate$missingRequiredArgs$1 extends Lambda implements oOoXoXO<String, Boolean> {
    final /* synthetic */ Ref.ObjectRef<Bundle> $args;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavGraphNavigator$navigate$missingRequiredArgs$1(Ref.ObjectRef<Bundle> objectRef) {
        super(1);
        this.$args = objectRef;
    }

    public final Boolean invoke(String str) {
        IIX0o.x0xO0oo(str, "key");
        T t = this.$args.element;
        boolean z = true;
        if (t != null && ((Bundle) t).containsKey(str)) {
            z = false;
        }
        return Boolean.valueOf(z);
    }
}
