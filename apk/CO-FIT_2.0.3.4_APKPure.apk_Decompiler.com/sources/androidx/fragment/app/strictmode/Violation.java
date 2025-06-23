package androidx.fragment.app.strictmode;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import androidx.fragment.app.Fragment;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

public abstract class Violation extends RuntimeException {
    @OOXIXo
    private final Fragment fragment;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Violation(Fragment fragment2, String str, int i, IIXOooo iIXOooo) {
        this(fragment2, (i & 2) != 0 ? null : str);
    }

    @OOXIXo
    public final Fragment getFragment() {
        return this.fragment;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Violation(@OOXIXo Fragment fragment2, @oOoXoXO String str) {
        super(str);
        IIX0o.x0xO0oo(fragment2, "fragment");
        this.fragment = fragment2;
    }
}
