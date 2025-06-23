package androidx.lifecycle;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.xxIXOIIO;
import android.view.View;
import androidx.lifecycle.runtime.R;
import kotlin.jvm.internal.IIX0o;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;

@xxIXOIIO(name = "ViewTreeLifecycleOwner")
public final class ViewTreeLifecycleOwner {
    @oOoXoXO
    @xxIXOIIO(name = "get")
    public static final LifecycleOwner get(@OOXIXo View view) {
        IIX0o.x0xO0oo(view, "<this>");
        return (LifecycleOwner) SequencesKt___SequencesKt.xOOOX(SequencesKt___SequencesKt.IOoo(SequencesKt__SequencesKt.x0XOIxOo(view, ViewTreeLifecycleOwner$findViewTreeLifecycleOwner$1.INSTANCE), ViewTreeLifecycleOwner$findViewTreeLifecycleOwner$2.INSTANCE));
    }

    @xxIXOIIO(name = "set")
    public static final void set(@OOXIXo View view, @oOoXoXO LifecycleOwner lifecycleOwner) {
        IIX0o.x0xO0oo(view, "<this>");
        view.setTag(R.id.view_tree_lifecycle_owner, lifecycleOwner);
    }
}
