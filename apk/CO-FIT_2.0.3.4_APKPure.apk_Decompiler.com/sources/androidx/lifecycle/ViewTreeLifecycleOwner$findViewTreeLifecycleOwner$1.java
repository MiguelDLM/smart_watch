package androidx.lifecycle;

import OXOo.OOXIXo;
import Oox.oOoXoXO;
import android.view.View;
import android.view.ViewParent;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Lambda;

public final class ViewTreeLifecycleOwner$findViewTreeLifecycleOwner$1 extends Lambda implements oOoXoXO<View, View> {
    public static final ViewTreeLifecycleOwner$findViewTreeLifecycleOwner$1 INSTANCE = new ViewTreeLifecycleOwner$findViewTreeLifecycleOwner$1();

    public ViewTreeLifecycleOwner$findViewTreeLifecycleOwner$1() {
        super(1);
    }

    @OXOo.oOoXoXO
    public final View invoke(@OOXIXo View view) {
        IIX0o.x0xO0oo(view, "currentView");
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            return (View) parent;
        }
        return null;
    }
}
