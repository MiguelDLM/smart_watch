package androidx.savedstate;

import OXOo.OOXIXo;
import Oox.oOoXoXO;
import android.view.View;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Lambda;

public final class ViewTreeSavedStateRegistryOwner$findViewTreeSavedStateRegistryOwner$2 extends Lambda implements oOoXoXO<View, SavedStateRegistryOwner> {
    public static final ViewTreeSavedStateRegistryOwner$findViewTreeSavedStateRegistryOwner$2 INSTANCE = new ViewTreeSavedStateRegistryOwner$findViewTreeSavedStateRegistryOwner$2();

    public ViewTreeSavedStateRegistryOwner$findViewTreeSavedStateRegistryOwner$2() {
        super(1);
    }

    @OXOo.oOoXoXO
    public final SavedStateRegistryOwner invoke(@OOXIXo View view) {
        IIX0o.x0xO0oo(view, ViewHierarchyConstants.VIEW_KEY);
        Object tag = view.getTag(R.id.view_tree_saved_state_registry_owner);
        if (tag instanceof SavedStateRegistryOwner) {
            return (SavedStateRegistryOwner) tag;
        }
        return null;
    }
}
