package androidx.lifecycle;

import OXOo.OOXIXo;
import Oox.oOoXoXO;
import android.view.View;
import androidx.lifecycle.runtime.R;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Lambda;

public final class ViewTreeLifecycleOwner$findViewTreeLifecycleOwner$2 extends Lambda implements oOoXoXO<View, LifecycleOwner> {
    public static final ViewTreeLifecycleOwner$findViewTreeLifecycleOwner$2 INSTANCE = new ViewTreeLifecycleOwner$findViewTreeLifecycleOwner$2();

    public ViewTreeLifecycleOwner$findViewTreeLifecycleOwner$2() {
        super(1);
    }

    @OXOo.oOoXoXO
    public final LifecycleOwner invoke(@OOXIXo View view) {
        IIX0o.x0xO0oo(view, "viewParent");
        Object tag = view.getTag(R.id.view_tree_lifecycle_owner);
        if (tag instanceof LifecycleOwner) {
            return (LifecycleOwner) tag;
        }
        return null;
    }
}
