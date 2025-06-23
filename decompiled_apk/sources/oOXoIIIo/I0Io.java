package oOXoIIIo;

import OXOo.OOXIXo;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes8.dex */
public final class I0Io {
    public static final boolean II0xO0(int i) {
        if (i != 0) {
            return true;
        }
        return false;
    }

    @OOXIXo
    public static final ViewGroup oIX0oI(@OOXIXo View view) {
        IIX0o.x0xO0oo(view, "<this>");
        ViewParent parent = view.getParent();
        IIX0o.x0XOIxOo(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        return (ViewGroup) parent;
    }

    public static final int I0Io(boolean z) {
        return z ? 1 : 0;
    }
}
