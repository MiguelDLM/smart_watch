package androidx.navigation;

import Oox.oOoXoXO;
import android.view.View;
import android.view.ViewParent;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Lambda;

public final class Navigation$findViewNavController$1 extends Lambda implements oOoXoXO<View, View> {
    public static final Navigation$findViewNavController$1 INSTANCE = new Navigation$findViewNavController$1();

    public Navigation$findViewNavController$1() {
        super(1);
    }

    public final View invoke(View view) {
        IIX0o.x0xO0oo(view, "it");
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            return (View) parent;
        }
        return null;
    }
}
