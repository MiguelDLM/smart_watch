package androidx.fragment.app.strictmode;

import OXOo.OOXIXo;
import androidx.fragment.app.Fragment;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes.dex */
public final class SetRetainInstanceUsageViolation extends RetainInstanceUsageViolation {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SetRetainInstanceUsageViolation(@OOXIXo Fragment fragment) {
        super(fragment, "Attempting to set retain instance for fragment " + fragment);
        IIX0o.x0xO0oo(fragment, "fragment");
    }
}
