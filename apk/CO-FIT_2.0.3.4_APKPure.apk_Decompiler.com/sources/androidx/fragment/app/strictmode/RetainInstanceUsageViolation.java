package androidx.fragment.app.strictmode;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import androidx.fragment.app.Fragment;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

public abstract class RetainInstanceUsageViolation extends Violation {
    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RetainInstanceUsageViolation(Fragment fragment, String str, int i, IIXOooo iIXOooo) {
        this(fragment, (i & 2) != 0 ? null : str);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RetainInstanceUsageViolation(@OOXIXo Fragment fragment, @oOoXoXO String str) {
        super(fragment, str);
        IIX0o.x0xO0oo(fragment, "fragment");
    }
}
