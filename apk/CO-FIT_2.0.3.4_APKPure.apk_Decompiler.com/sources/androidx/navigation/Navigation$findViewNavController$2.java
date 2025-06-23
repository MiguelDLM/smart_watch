package androidx.navigation;

import Oox.oOoXoXO;
import android.view.View;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Lambda;

public final class Navigation$findViewNavController$2 extends Lambda implements oOoXoXO<View, NavController> {
    public static final Navigation$findViewNavController$2 INSTANCE = new Navigation$findViewNavController$2();

    public Navigation$findViewNavController$2() {
        super(1);
    }

    public final NavController invoke(View view) {
        IIX0o.x0xO0oo(view, "it");
        return Navigation.INSTANCE.getViewNavController(view);
    }
}
