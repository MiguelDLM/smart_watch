package androidx.activity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.xxIXOIIO;
import android.view.View;
import android.view.ViewParent;
import androidx.core.viewtree.ViewTree;
import kotlin.jvm.internal.IIX0o;

@xxIXOIIO(name = "ViewTreeOnBackPressedDispatcherOwner")
public final class ViewTreeOnBackPressedDispatcherOwner {
    @oOoXoXO
    @xxIXOIIO(name = "get")
    public static final OnBackPressedDispatcherOwner get(@OOXIXo View view) {
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
            ViewParent parentOrViewTreeDisjointParent = ViewTree.getParentOrViewTreeDisjointParent(view);
            if (parentOrViewTreeDisjointParent instanceof View) {
                view = (View) parentOrViewTreeDisjointParent;
            } else {
                view = null;
            }
        }
        return null;
    }

    @xxIXOIIO(name = "set")
    public static final void set(@OOXIXo View view, @OOXIXo OnBackPressedDispatcherOwner onBackPressedDispatcherOwner) {
        IIX0o.x0xO0oo(view, "<this>");
        IIX0o.x0xO0oo(onBackPressedDispatcherOwner, "onBackPressedDispatcherOwner");
        view.setTag(R.id.view_tree_on_back_pressed_dispatcher_owner, onBackPressedDispatcherOwner);
    }
}
