package androidx.fragment.app.strictmode;

import OXOo.OOXIXo;
import androidx.fragment.app.Fragment;
import kotlin.jvm.internal.IIX0o;

public final class GetTargetFragmentUsageViolation extends TargetFragmentUsageViolation {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetTargetFragmentUsageViolation(@OOXIXo Fragment fragment) {
        super(fragment, "Attempting to get target fragment from fragment " + fragment);
        IIX0o.x0xO0oo(fragment, "fragment");
    }
}
