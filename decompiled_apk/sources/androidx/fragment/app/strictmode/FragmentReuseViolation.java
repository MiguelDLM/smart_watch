package androidx.fragment.app.strictmode;

import OXOo.OOXIXo;
import androidx.fragment.app.Fragment;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes.dex */
public final class FragmentReuseViolation extends Violation {

    @OOXIXo
    private final String previousFragmentId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FragmentReuseViolation(@OOXIXo Fragment fragment, @OOXIXo String previousFragmentId) {
        super(fragment, "Attempting to reuse fragment " + fragment + " with previous ID " + previousFragmentId);
        IIX0o.x0xO0oo(fragment, "fragment");
        IIX0o.x0xO0oo(previousFragmentId, "previousFragmentId");
        this.previousFragmentId = previousFragmentId;
    }

    @OOXIXo
    public final String getPreviousFragmentId() {
        return this.previousFragmentId;
    }
}
