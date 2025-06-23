package androidx.core.viewtree;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.xxIXOIIO;
import android.view.View;
import android.view.ViewParent;
import kotlin.jvm.internal.IIX0o;

@xxIXOIIO(name = "ViewTree")
/* loaded from: classes.dex */
public final class ViewTree {
    @oOoXoXO
    public static final ViewParent getParentOrViewTreeDisjointParent(@OOXIXo View view) {
        IIX0o.x0xO0oo(view, "<this>");
        ViewParent parent = view.getParent();
        if (parent != null) {
            return parent;
        }
        Object tag = view.getTag(R.id.view_tree_disjoint_parent);
        if (tag instanceof ViewParent) {
            return (ViewParent) tag;
        }
        return null;
    }

    public static final void setViewTreeDisjointParent(@OOXIXo View view, @oOoXoXO ViewParent viewParent) {
        IIX0o.x0xO0oo(view, "<this>");
        view.setTag(R.id.view_tree_disjoint_parent, viewParent);
    }
}
