package androidx.lifecycle;

import android.view.View;
import androidx.lifecycle.runtime.R;
import kotlin.jvm.internal.IIX0o;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;

@XO0OX.xxIXOIIO(name = "ViewTreeLifecycleOwner")
/* loaded from: classes.dex */
public final class ViewTreeLifecycleOwner {
    @XO0OX.xxIXOIIO(name = "get")
    @OXOo.oOoXoXO
    public static final LifecycleOwner get(@OXOo.OOXIXo View view) {
        IIX0o.x0xO0oo(view, "<this>");
        return (LifecycleOwner) SequencesKt___SequencesKt.xOOOX(SequencesKt___SequencesKt.IOoo(SequencesKt__SequencesKt.x0XOIxOo(view, new Oox.oOoXoXO<View, View>() { // from class: androidx.lifecycle.ViewTreeLifecycleOwner$findViewTreeLifecycleOwner$1
            @Override // Oox.oOoXoXO
            @OXOo.oOoXoXO
            public final View invoke(@OXOo.OOXIXo View currentView) {
                IIX0o.x0xO0oo(currentView, "currentView");
                Object parent = currentView.getParent();
                if (parent instanceof View) {
                    return (View) parent;
                }
                return null;
            }
        }), new Oox.oOoXoXO<View, LifecycleOwner>() { // from class: androidx.lifecycle.ViewTreeLifecycleOwner$findViewTreeLifecycleOwner$2
            @Override // Oox.oOoXoXO
            @OXOo.oOoXoXO
            public final LifecycleOwner invoke(@OXOo.OOXIXo View viewParent) {
                IIX0o.x0xO0oo(viewParent, "viewParent");
                Object tag = viewParent.getTag(R.id.view_tree_lifecycle_owner);
                if (tag instanceof LifecycleOwner) {
                    return (LifecycleOwner) tag;
                }
                return null;
            }
        }));
    }

    @XO0OX.xxIXOIIO(name = "set")
    public static final void set(@OXOo.OOXIXo View view, @OXOo.oOoXoXO LifecycleOwner lifecycleOwner) {
        IIX0o.x0xO0oo(view, "<this>");
        view.setTag(R.id.view_tree_lifecycle_owner, lifecycleOwner);
    }
}
