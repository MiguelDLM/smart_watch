package androidx.fragment.app.strictmode;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import androidx.fragment.app.Fragment;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes.dex */
public abstract class Violation extends RuntimeException {

    @OOXIXo
    private final Fragment fragment;

    public /* synthetic */ Violation(Fragment fragment, String str, int i, IIXOooo iIXOooo) {
        this(fragment, (i & 2) != 0 ? null : str);
    }

    @OOXIXo
    public final Fragment getFragment() {
        return this.fragment;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Violation(@OOXIXo Fragment fragment, @oOoXoXO String str) {
        super(str);
        IIX0o.x0xO0oo(fragment, "fragment");
        this.fragment = fragment;
    }
}
