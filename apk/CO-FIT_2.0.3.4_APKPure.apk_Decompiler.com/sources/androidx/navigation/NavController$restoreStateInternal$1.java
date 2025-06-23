package androidx.navigation;

import Oox.oOoXoXO;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Lambda;

public final class NavController$restoreStateInternal$1 extends Lambda implements oOoXoXO<String, Boolean> {
    final /* synthetic */ String $backStackId;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavController$restoreStateInternal$1(String str) {
        super(1);
        this.$backStackId = str;
    }

    public final Boolean invoke(String str) {
        return Boolean.valueOf(IIX0o.Oxx0IOOO(str, this.$backStackId));
    }
}
