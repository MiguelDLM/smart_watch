package androidx.fragment.app.strictmode;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import kotlin.jvm.internal.IIX0o;

public final class FragmentTagUsageViolation extends Violation {
    @oOoXoXO
    private final ViewGroup parentContainer;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FragmentTagUsageViolation(@OOXIXo Fragment fragment, @oOoXoXO ViewGroup viewGroup) {
        super(fragment, "Attempting to use <fragment> tag to add fragment " + fragment + " to container " + viewGroup);
        IIX0o.x0xO0oo(fragment, "fragment");
        this.parentContainer = viewGroup;
    }

    @oOoXoXO
    public final ViewGroup getParentContainer() {
        return this.parentContainer;
    }
}
