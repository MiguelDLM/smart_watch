package androidx.lifecycle;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.xxIXOIIO;
import android.view.View;
import androidx.lifecycle.viewmodel.R;
import kotlin.jvm.internal.IIX0o;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;

@xxIXOIIO(name = "ViewTreeViewModelStoreOwner")
public final class ViewTreeViewModelStoreOwner {
    @oOoXoXO
    @xxIXOIIO(name = "get")
    public static final ViewModelStoreOwner get(@OOXIXo View view) {
        IIX0o.x0xO0oo(view, "<this>");
        return (ViewModelStoreOwner) SequencesKt___SequencesKt.xOOOX(SequencesKt___SequencesKt.IOoo(SequencesKt__SequencesKt.x0XOIxOo(view, ViewTreeViewModelStoreOwner$findViewTreeViewModelStoreOwner$1.INSTANCE), ViewTreeViewModelStoreOwner$findViewTreeViewModelStoreOwner$2.INSTANCE));
    }

    @xxIXOIIO(name = "set")
    public static final void set(@OOXIXo View view, @oOoXoXO ViewModelStoreOwner viewModelStoreOwner) {
        IIX0o.x0xO0oo(view, "<this>");
        view.setTag(R.id.view_tree_view_model_store_owner, viewModelStoreOwner);
    }
}
