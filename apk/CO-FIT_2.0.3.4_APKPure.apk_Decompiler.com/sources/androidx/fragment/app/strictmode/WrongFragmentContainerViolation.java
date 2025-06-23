package androidx.fragment.app.strictmode;

import OXOo.OOXIXo;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import kotlin.jvm.internal.IIX0o;

public final class WrongFragmentContainerViolation extends Violation {
    @OOXIXo
    private final ViewGroup container;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WrongFragmentContainerViolation(@OOXIXo Fragment fragment, @OOXIXo ViewGroup viewGroup) {
        super(fragment, "Attempting to add fragment " + fragment + " to container " + viewGroup + " which is not a FragmentContainerView");
        IIX0o.x0xO0oo(fragment, "fragment");
        IIX0o.x0xO0oo(viewGroup, TtmlNode.RUBY_CONTAINER);
        this.container = viewGroup;
    }

    @OOXIXo
    public final ViewGroup getContainer() {
        return this.container;
    }
}
