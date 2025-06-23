package androidx.savedstate;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.xxIXOIIO;
import android.view.View;
import kotlin.jvm.internal.IIX0o;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;

@xxIXOIIO(name = "ViewTreeSavedStateRegistryOwner")
public final class ViewTreeSavedStateRegistryOwner {
    @oOoXoXO
    @xxIXOIIO(name = "get")
    public static final SavedStateRegistryOwner get(@OOXIXo View view) {
        IIX0o.x0xO0oo(view, "<this>");
        return (SavedStateRegistryOwner) SequencesKt___SequencesKt.xOOOX(SequencesKt___SequencesKt.IOoo(SequencesKt__SequencesKt.x0XOIxOo(view, ViewTreeSavedStateRegistryOwner$findViewTreeSavedStateRegistryOwner$1.INSTANCE), ViewTreeSavedStateRegistryOwner$findViewTreeSavedStateRegistryOwner$2.INSTANCE));
    }

    @xxIXOIIO(name = "set")
    public static final void set(@OOXIXo View view, @oOoXoXO SavedStateRegistryOwner savedStateRegistryOwner) {
        IIX0o.x0xO0oo(view, "<this>");
        view.setTag(R.id.view_tree_saved_state_registry_owner, savedStateRegistryOwner);
    }
}
