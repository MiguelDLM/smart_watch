package androidx.lifecycle;

import OXOo.OOXIXo;
import Oox.oOoXoXO;
import android.view.View;
import androidx.lifecycle.viewmodel.R;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Lambda;

public final class ViewTreeViewModelStoreOwner$findViewTreeViewModelStoreOwner$2 extends Lambda implements oOoXoXO<View, ViewModelStoreOwner> {
    public static final ViewTreeViewModelStoreOwner$findViewTreeViewModelStoreOwner$2 INSTANCE = new ViewTreeViewModelStoreOwner$findViewTreeViewModelStoreOwner$2();

    public ViewTreeViewModelStoreOwner$findViewTreeViewModelStoreOwner$2() {
        super(1);
    }

    @OXOo.oOoXoXO
    public final ViewModelStoreOwner invoke(@OOXIXo View view) {
        IIX0o.x0xO0oo(view, ViewHierarchyConstants.VIEW_KEY);
        Object tag = view.getTag(R.id.view_tree_view_model_store_owner);
        if (tag instanceof ViewModelStoreOwner) {
            return (ViewModelStoreOwner) tag;
        }
        return null;
    }
}
