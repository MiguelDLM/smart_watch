package androidx.savedstate;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.xxIXOIIO;
import android.view.View;
import kotlin.jvm.internal.IIX0o;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;

@xxIXOIIO(name = "ViewTreeSavedStateRegistryOwner")
/* loaded from: classes.dex */
public final class ViewTreeSavedStateRegistryOwner {
    @xxIXOIIO(name = "get")
    @oOoXoXO
    public static final SavedStateRegistryOwner get(@OOXIXo View view) {
        IIX0o.x0xO0oo(view, "<this>");
        return (SavedStateRegistryOwner) SequencesKt___SequencesKt.xOOOX(SequencesKt___SequencesKt.IOoo(SequencesKt__SequencesKt.x0XOIxOo(view, new Oox.oOoXoXO<View, View>() { // from class: androidx.savedstate.ViewTreeSavedStateRegistryOwner$findViewTreeSavedStateRegistryOwner$1
            @Override // Oox.oOoXoXO
            @oOoXoXO
            public final View invoke(@OOXIXo View view2) {
                IIX0o.x0xO0oo(view2, "view");
                Object parent = view2.getParent();
                if (parent instanceof View) {
                    return (View) parent;
                }
                return null;
            }
        }), new Oox.oOoXoXO<View, SavedStateRegistryOwner>() { // from class: androidx.savedstate.ViewTreeSavedStateRegistryOwner$findViewTreeSavedStateRegistryOwner$2
            @Override // Oox.oOoXoXO
            @oOoXoXO
            public final SavedStateRegistryOwner invoke(@OOXIXo View view2) {
                IIX0o.x0xO0oo(view2, "view");
                Object tag = view2.getTag(R.id.view_tree_saved_state_registry_owner);
                if (tag instanceof SavedStateRegistryOwner) {
                    return (SavedStateRegistryOwner) tag;
                }
                return null;
            }
        }));
    }

    @xxIXOIIO(name = "set")
    public static final void set(@OOXIXo View view, @oOoXoXO SavedStateRegistryOwner savedStateRegistryOwner) {
        IIX0o.x0xO0oo(view, "<this>");
        view.setTag(R.id.view_tree_saved_state_registry_owner, savedStateRegistryOwner);
    }
}
