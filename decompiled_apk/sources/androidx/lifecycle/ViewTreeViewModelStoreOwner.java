package androidx.lifecycle;

import android.view.View;
import androidx.lifecycle.viewmodel.R;
import kotlin.jvm.internal.IIX0o;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;

@XO0OX.xxIXOIIO(name = "ViewTreeViewModelStoreOwner")
/* loaded from: classes.dex */
public final class ViewTreeViewModelStoreOwner {
    @XO0OX.xxIXOIIO(name = "get")
    @OXOo.oOoXoXO
    public static final ViewModelStoreOwner get(@OXOo.OOXIXo View view) {
        IIX0o.x0xO0oo(view, "<this>");
        return (ViewModelStoreOwner) SequencesKt___SequencesKt.xOOOX(SequencesKt___SequencesKt.IOoo(SequencesKt__SequencesKt.x0XOIxOo(view, new Oox.oOoXoXO<View, View>() { // from class: androidx.lifecycle.ViewTreeViewModelStoreOwner$findViewTreeViewModelStoreOwner$1
            @Override // Oox.oOoXoXO
            @OXOo.oOoXoXO
            public final View invoke(@OXOo.OOXIXo View view2) {
                IIX0o.x0xO0oo(view2, "view");
                Object parent = view2.getParent();
                if (parent instanceof View) {
                    return (View) parent;
                }
                return null;
            }
        }), new Oox.oOoXoXO<View, ViewModelStoreOwner>() { // from class: androidx.lifecycle.ViewTreeViewModelStoreOwner$findViewTreeViewModelStoreOwner$2
            @Override // Oox.oOoXoXO
            @OXOo.oOoXoXO
            public final ViewModelStoreOwner invoke(@OXOo.OOXIXo View view2) {
                IIX0o.x0xO0oo(view2, "view");
                Object tag = view2.getTag(R.id.view_tree_view_model_store_owner);
                if (tag instanceof ViewModelStoreOwner) {
                    return (ViewModelStoreOwner) tag;
                }
                return null;
            }
        }));
    }

    @XO0OX.xxIXOIIO(name = "set")
    public static final void set(@OXOo.OOXIXo View view, @OXOo.oOoXoXO ViewModelStoreOwner viewModelStoreOwner) {
        IIX0o.x0xO0oo(view, "<this>");
        view.setTag(R.id.view_tree_view_model_store_owner, viewModelStoreOwner);
    }
}
