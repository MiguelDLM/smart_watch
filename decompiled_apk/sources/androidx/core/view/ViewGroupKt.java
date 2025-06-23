package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Px;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class ViewGroupKt {
    public static final boolean contains(@OXOo.OOXIXo ViewGroup viewGroup, @OXOo.OOXIXo View view) {
        if (viewGroup.indexOfChild(view) != -1) {
            return true;
        }
        return false;
    }

    public static final void forEach(@OXOo.OOXIXo ViewGroup viewGroup, @OXOo.OOXIXo Oox.oOoXoXO<? super View, kotlin.oXIO0o0XI> oooxoxo) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            oooxoxo.invoke(viewGroup.getChildAt(i));
        }
    }

    public static final void forEachIndexed(@OXOo.OOXIXo ViewGroup viewGroup, @OXOo.OOXIXo Oox.x0xO0oo<? super Integer, ? super View, kotlin.oXIO0o0XI> x0xo0oo) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            x0xo0oo.invoke(Integer.valueOf(i), viewGroup.getChildAt(i));
        }
    }

    @OXOo.OOXIXo
    public static final View get(@OXOo.OOXIXo ViewGroup viewGroup, int i) {
        View childAt = viewGroup.getChildAt(i);
        if (childAt != null) {
            return childAt;
        }
        throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + viewGroup.getChildCount());
    }

    @OXOo.OOXIXo
    public static final kotlin.sequences.ooOOo0oXI<View> getChildren(@OXOo.OOXIXo final ViewGroup viewGroup) {
        return new kotlin.sequences.ooOOo0oXI<View>() { // from class: androidx.core.view.ViewGroupKt$children$1
            @Override // kotlin.sequences.ooOOo0oXI
            @OXOo.OOXIXo
            public Iterator<View> iterator() {
                return ViewGroupKt.iterator(viewGroup);
            }
        };
    }

    @OXOo.OOXIXo
    public static final kotlin.sequences.ooOOo0oXI<View> getDescendants(@OXOo.OOXIXo final ViewGroup viewGroup) {
        return new kotlin.sequences.ooOOo0oXI<View>() { // from class: androidx.core.view.ViewGroupKt$special$$inlined$Sequence$1
            @Override // kotlin.sequences.ooOOo0oXI
            @OXOo.OOXIXo
            public Iterator<View> iterator() {
                return new TreeIterator(ViewGroupKt.getChildren(viewGroup).iterator(), new Oox.oOoXoXO<View, Iterator<? extends View>>() { // from class: androidx.core.view.ViewGroupKt$descendants$1$1
                    @Override // Oox.oOoXoXO
                    @OXOo.oOoXoXO
                    public final Iterator<View> invoke(@OXOo.OOXIXo View view) {
                        kotlin.sequences.ooOOo0oXI<View> children;
                        ViewGroup viewGroup2 = view instanceof ViewGroup ? (ViewGroup) view : null;
                        if (viewGroup2 == null || (children = ViewGroupKt.getChildren(viewGroup2)) == null) {
                            return null;
                        }
                        return children.iterator();
                    }
                });
            }
        };
    }

    @OXOo.OOXIXo
    public static final X0.oOoXoXO getIndices(@OXOo.OOXIXo ViewGroup viewGroup) {
        return X0.IIXOooo.X00xOoXI(0, viewGroup.getChildCount());
    }

    public static final int getSize(@OXOo.OOXIXo ViewGroup viewGroup) {
        return viewGroup.getChildCount();
    }

    public static final boolean isEmpty(@OXOo.OOXIXo ViewGroup viewGroup) {
        if (viewGroup.getChildCount() == 0) {
            return true;
        }
        return false;
    }

    public static final boolean isNotEmpty(@OXOo.OOXIXo ViewGroup viewGroup) {
        if (viewGroup.getChildCount() != 0) {
            return true;
        }
        return false;
    }

    @OXOo.OOXIXo
    public static final Iterator<View> iterator(@OXOo.OOXIXo ViewGroup viewGroup) {
        return new ViewGroupKt$iterator$1(viewGroup);
    }

    public static final void minusAssign(@OXOo.OOXIXo ViewGroup viewGroup, @OXOo.OOXIXo View view) {
        viewGroup.removeView(view);
    }

    public static final void plusAssign(@OXOo.OOXIXo ViewGroup viewGroup, @OXOo.OOXIXo View view) {
        viewGroup.addView(view);
    }

    public static final void setMargins(@OXOo.OOXIXo ViewGroup.MarginLayoutParams marginLayoutParams, @Px int i) {
        marginLayoutParams.setMargins(i, i, i, i);
    }

    public static final void updateMargins(@OXOo.OOXIXo ViewGroup.MarginLayoutParams marginLayoutParams, @Px int i, @Px int i2, @Px int i3, @Px int i4) {
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

    public static final void updateMarginsRelative(@OXOo.OOXIXo ViewGroup.MarginLayoutParams marginLayoutParams, @Px int i, @Px int i2, @Px int i3, @Px int i4) {
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
