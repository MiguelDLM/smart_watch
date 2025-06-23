package androidx.activity;

import android.view.View;
import androidx.core.viewtree.ViewTree;
import kotlin.jvm.internal.IIX0o;

@XO0OX.xxIXOIIO(name = "ViewTreeOnBackPressedDispatcherOwner")
/* loaded from: classes.dex */
public final class ViewTreeOnBackPressedDispatcherOwner {
    @XO0OX.xxIXOIIO(name = "get")
    @OXOo.oOoXoXO
    public static final OnBackPressedDispatcherOwner get(@OXOo.OOXIXo View view) {
        OnBackPressedDispatcherOwner onBackPressedDispatcherOwner;
        IIX0o.x0xO0oo(view, "<this>");
        while (view != null) {
            Object tag = view.getTag(R.id.view_tree_on_back_pressed_dispatcher_owner);
            if (tag instanceof OnBackPressedDispatcherOwner) {
                onBackPressedDispatcherOwner = (OnBackPressedDispatcherOwner) tag;
            } else {
                onBackPressedDispatcherOwner = null;
            }
            if (onBackPressedDispatcherOwner != null) {
                return onBackPressedDispatcherOwner;
            }
            Object parentOrViewTreeDisjointParent = ViewTree.getParentOrViewTreeDisjointParent(view);
            if (parentOrViewTreeDisjointParent instanceof View) {
                view = (View) parentOrViewTreeDisjointParent;
            } else {
                view = null;
            }
        }
        return null;
    }

    @XO0OX.xxIXOIIO(name = "set")
    public static final void set(@OXOo.OOXIXo View view, @OXOo.OOXIXo OnBackPressedDispatcherOwner onBackPressedDispatcherOwner) {
        IIX0o.x0xO0oo(view, "<this>");
        IIX0o.x0xO0oo(onBackPressedDispatcherOwner, "onBackPressedDispatcherOwner");
        view.setTag(R.id.view_tree_on_back_pressed_dispatcher_owner, onBackPressedDispatcherOwner);
    }
}
