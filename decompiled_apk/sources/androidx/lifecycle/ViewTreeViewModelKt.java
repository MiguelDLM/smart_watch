package androidx.lifecycle;

import android.view.View;
import kotlin.DeprecationLevel;
import kotlin.XX;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes.dex */
public final class ViewTreeViewModelKt {
    @kotlin.OOXIXo(level = DeprecationLevel.HIDDEN, message = "Replaced by View.findViewTreeViewModelStoreOwner in ViewTreeViewModelStoreOwner", replaceWith = @XX(expression = "View.findViewTreeViewModelStoreOwner", imports = {"androidx.lifecycle.ViewTreeViewModelStoreOwner"}))
    public static final /* synthetic */ ViewModelStoreOwner findViewTreeViewModelStoreOwner(View view) {
        IIX0o.x0xO0oo(view, "view");
        return ViewTreeViewModelStoreOwner.get(view);
    }
}
