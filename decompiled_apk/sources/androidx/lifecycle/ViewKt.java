package androidx.lifecycle;

import android.view.View;
import kotlin.DeprecationLevel;
import kotlin.XX;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes.dex */
public final class ViewKt {
    @kotlin.OOXIXo(level = DeprecationLevel.HIDDEN, message = "Replaced by View.findViewTreeLifecycleOwner() from lifecycle module", replaceWith = @XX(expression = "findViewTreeLifecycleOwner()", imports = {"androidx.lifecycle.findViewTreeLifecycleOwner"}))
    public static final /* synthetic */ LifecycleOwner findViewTreeLifecycleOwner(View view) {
        IIX0o.x0xO0oo(view, "<this>");
        return ViewTreeLifecycleOwner.get(view);
    }
}
