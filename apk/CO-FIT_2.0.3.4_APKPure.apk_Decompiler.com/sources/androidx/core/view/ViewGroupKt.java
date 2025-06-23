package androidx.core.view;

import OXOo.OOXIXo;
import Oox.oOoXoXO;
import Oox.x0xO0oo;
import X0.IIXOooo;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Px;
import java.util.Iterator;
import kotlin.oXIO0o0XI;
import kotlin.sequences.ooOOo0oXI;

public final class ViewGroupKt {
    public static final boolean contains(@OOXIXo ViewGroup viewGroup, @OOXIXo View view) {
        if (viewGroup.indexOfChild(view) != -1) {
            return true;
        }
        return false;
    }

    public static final void forEach(@OOXIXo ViewGroup viewGroup, @OOXIXo oOoXoXO<? super View, oXIO0o0XI> oooxoxo) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            oooxoxo.invoke(viewGroup.getChildAt(i));
        }
    }

    public static final void forEachIndexed(@OOXIXo ViewGroup viewGroup, @OOXIXo x0xO0oo<? super Integer, ? super View, oXIO0o0XI> x0xo0oo) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            x0xo0oo.invoke(Integer.valueOf(i), viewGroup.getChildAt(i));
        }
    }

    @OOXIXo
    public static final View get(@OOXIXo ViewGroup viewGroup, int i) {
        View childAt = viewGroup.getChildAt(i);
        if (childAt != null) {
            return childAt;
        }
        throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + viewGroup.getChildCount());
    }

    @OOXIXo
    public static final ooOOo0oXI<View> getChildren(@OOXIXo ViewGroup viewGroup) {
        return new ViewGroupKt$children$1(viewGroup);
    }

    @OOXIXo
    public static final ooOOo0oXI<View> getDescendants(@OOXIXo ViewGroup viewGroup) {
        return new ViewGroupKt$special$$inlined$Sequence$1(viewGroup);
    }

    @OOXIXo
    public static final X0.oOoXoXO getIndices(@OOXIXo ViewGroup viewGroup) {
        return IIXOooo.X00xOoXI(0, viewGroup.getChildCount());
    }

    public static final int getSize(@OOXIXo ViewGroup viewGroup) {
        return viewGroup.getChildCount();
    }

    public static final boolean isEmpty(@OOXIXo ViewGroup viewGroup) {
        if (viewGroup.getChildCount() == 0) {
            return true;
        }
        return false;
    }

    public static final boolean isNotEmpty(@OOXIXo ViewGroup viewGroup) {
        if (viewGroup.getChildCount() != 0) {
            return true;
        }
        return false;
    }

    @OOXIXo
    public static final Iterator<View> iterator(@OOXIXo ViewGroup viewGroup) {
        return new ViewGroupKt$iterator$1(viewGroup);
    }

    public static final void minusAssign(@OOXIXo ViewGroup viewGroup, @OOXIXo View view) {
        viewGroup.removeView(view);
    }

    public static final void plusAssign(@OOXIXo ViewGroup viewGroup, @OOXIXo View view) {
        viewGroup.addView(view);
    }

    public static final void setMargins(@OOXIXo ViewGroup.MarginLayoutParams marginLayoutParams, @Px int i) {
        marginLayoutParams.setMargins(i, i, i, i);
    }

    public static final void updateMargins(@OOXIXo ViewGroup.MarginLayoutParams marginLayoutParams, @Px int i, @Px int i2, @Px int i3, @Px int i4) {
        marginLayoutParams.setMargins(i, i2, i3, i4);
    }

    public static /* synthetic */ void updateMargins$default(ViewGroup.MarginLayoutParams marginLayoutParams, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = marginLayoutParams.leftMargin;
        }
        if ((i5 & 2) != 0) {
            i2 = marginLayoutParams.topMargin;
        }
        if ((i5 & 4) != 0) {
            i3 = marginLayoutParams.rightMargin;
        }
        if ((i5 & 8) != 0) {
            i4 = marginLayoutParams.bottomMargin;
        }
        marginLayoutParams.setMargins(i, i2, i3, i4);
    }

    public static final void updateMarginsRelative(@OOXIXo ViewGroup.MarginLayoutParams marginLayoutParams, @Px int i, @Px int i2, @Px int i3, @Px int i4) {
        marginLayoutParams.setMarginStart(i);
        marginLayoutParams.topMargin = i2;
        marginLayoutParams.setMarginEnd(i3);
        marginLayoutParams.bottomMargin = i4;
    }

    public static /* synthetic */ void updateMarginsRelative$default(ViewGroup.MarginLayoutParams marginLayoutParams, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = marginLayoutParams.getMarginStart();
        }
        if ((i5 & 2) != 0) {
            i2 = marginLayoutParams.topMargin;
        }
        if ((i5 & 4) != 0) {
            i3 = marginLayoutParams.getMarginEnd();
        }
        if ((i5 & 8) != 0) {
            i4 = marginLayoutParams.bottomMargin;
        }
        marginLayoutParams.setMarginStart(i);
        marginLayoutParams.topMargin = i2;
        marginLayoutParams.setMarginEnd(i3);
        marginLayoutParams.bottomMargin = i4;
    }
}
