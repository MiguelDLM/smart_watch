package androidx.core.view;

import OXOo.OOXIXo;
import Oox.oOoXoXO;
import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.ooOOo0oXI;

public final class ViewGroupKt$descendants$1$1 extends Lambda implements oOoXoXO<View, Iterator<? extends View>> {
    public static final ViewGroupKt$descendants$1$1 INSTANCE = new ViewGroupKt$descendants$1$1();

    public ViewGroupKt$descendants$1$1() {
        super(1);
    }

    @OXOo.oOoXoXO
    public final Iterator<View> invoke(@OOXIXo View view) {
        ooOOo0oXI<View> children;
        ViewGroup viewGroup = view instanceof ViewGroup ? (ViewGroup) view : null;
        if (viewGroup == null || (children = ViewGroupKt.getChildren(viewGroup)) == null) {
            return null;
        }
        return children.iterator();
    }
}
