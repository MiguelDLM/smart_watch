package androidx.fragment.app.strictmode;

import OXOo.OOXIXo;
import androidx.fragment.app.Fragment;
import kotlin.jvm.internal.IIX0o;

public final class FragmentReuseViolation extends Violation {
    @OOXIXo
    private final String previousFragmentId;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FragmentReuseViolation(@OOXIXo Fragment fragment, @OOXIXo String str) {
        super(fragment, "Attempting to reuse fragment " + fragment + " with previous ID " + str);
        IIX0o.x0xO0oo(fragment, "fragment");
        IIX0o.x0xO0oo(str, "previousFragmentId");
        this.previousFragmentId = str;
    }

    @OOXIXo
    public final String getPreviousFragmentId() {
        return this.previousFragmentId;
    }
}
