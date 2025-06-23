package androidx.fragment.app.strictmode;

import OXOo.OOXIXo;
import androidx.fragment.app.Fragment;
import kotlin.jvm.internal.IIX0o;

public final class SetTargetFragmentUsageViolation extends TargetFragmentUsageViolation {
    private final int requestCode;
    @OOXIXo
    private final Fragment targetFragment;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SetTargetFragmentUsageViolation(@OOXIXo Fragment fragment, @OOXIXo Fragment fragment2, int i) {
        super(fragment, "Attempting to set target fragment " + fragment2 + " with request code " + i + " for fragment " + fragment);
        IIX0o.x0xO0oo(fragment, "fragment");
        IIX0o.x0xO0oo(fragment2, "targetFragment");
        this.targetFragment = fragment2;
        this.requestCode = i;
    }

    public final int getRequestCode() {
        return this.requestCode;
    }

    @OOXIXo
    public final Fragment getTargetFragment() {
        return this.targetFragment;
    }
}
