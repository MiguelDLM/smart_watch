package androidx.savedstate;

import android.view.View;
import kotlin.DeprecationLevel;
import kotlin.OOXIXo;
import kotlin.XX;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes.dex */
public final class ViewKt {
    @OOXIXo(level = DeprecationLevel.HIDDEN, message = "Replaced by View.findViewTreeSavedStateRegistryOwner() from savedstate module", replaceWith = @XX(expression = "findViewTreeSavedStateRegistryOwner()", imports = {"androidx.savedstate.findViewTreeSavedStateRegistryOwner"}))
    public static final /* synthetic */ SavedStateRegistryOwner findViewTreeSavedStateRegistryOwner(View view) {
        IIX0o.x0xO0oo(view, "<this>");
        return ViewTreeSavedStateRegistryOwner.get(view);
    }
}
