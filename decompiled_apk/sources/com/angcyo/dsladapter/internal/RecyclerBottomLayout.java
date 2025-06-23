package com.angcyo.dsladapter.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes7.dex */
public final class RecyclerBottomLayout extends FrameLayout {

    /* renamed from: XO, reason: collision with root package name */
    public int f5394XO;

    public /* synthetic */ RecyclerBottomLayout(Context context, AttributeSet attributeSet, int i, IIXOooo iIXOooo) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    public static final void II0xO0(ViewParent viewParent, RecyclerView.LayoutParams layoutParams, RecyclerBottomLayout this$0) {
        IIX0o.x0xO0oo(layoutParams, "$layoutParams");
        IIX0o.x0xO0oo(this$0, "this$0");
        RecyclerView.Adapter adapter = ((RecyclerView) viewParent).getAdapter();
        if (adapter != null) {
            adapter.notifyItemChanged(layoutParams.getViewAdapterPosition());
        } else {
            this$0.requestLayout();
        }
    }

    public final int get_layoutMeasureHeight() {
        return this.f5394XO;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x005e  */
    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onLayout(boolean r9, int r10, int r11, int r12, int r13) {
        /*
            r8 = this;
            android.view.ViewParent r0 = r8.getParent()
            boolean r1 = r0 instanceof androidx.recyclerview.widget.RecyclerView
            if (r1 == 0) goto L6c
            r1 = r0
            androidx.recyclerview.widget.RecyclerView r1 = (androidx.recyclerview.widget.RecyclerView) r1
            int r2 = r1.getScrollState()
            if (r2 == 0) goto L15
            super.onLayout(r9, r10, r11, r12, r13)
            return
        L15:
            android.view.ViewGroup$LayoutParams r2 = r8.getLayoutParams()
            java.lang.String r3 = "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams"
            kotlin.jvm.internal.IIX0o.x0XOIxOo(r2, r3)
            androidx.recyclerview.widget.RecyclerView$LayoutParams r2 = (androidx.recyclerview.widget.RecyclerView.LayoutParams) r2
            int r3 = r1.getMeasuredHeight()
            int r1 = r1.computeVerticalScrollOffset()
            if (r1 != 0) goto L6c
            if (r11 >= r3) goto L6c
            if (r13 <= r11) goto L6c
            int r1 = r2.bottomMargin
            int r4 = r13 + r1
            if (r4 == r3) goto L6c
            int r3 = r3 - r11
            int r3 = r3 - r1
            int r4 = r8.f5394XO
            r5 = 0
            r6 = 1
            if (r4 <= 0) goto L51
            int r7 = r2.topMargin
            int r7 = r3 - r7
            int r7 = r7 - r1
            if (r7 <= r4) goto L44
            r5 = 1
        L44:
            if (r5 != 0) goto L4f
            int r1 = r8.getMeasuredHeight()
            if (r4 == r1) goto L4f
            int r3 = r8.f5394XO
            goto L5c
        L4f:
            r6 = r5
            goto L5c
        L51:
            int r4 = r2.topMargin
            int r4 = r3 - r4
            int r4 = r4 - r1
            int r1 = r13 - r11
            if (r4 <= r1) goto L4f
            r5 = 1
            goto L4f
        L5c:
            if (r6 == 0) goto L6c
            r2.height = r3
            r8.setLayoutParams(r2)
            com.angcyo.dsladapter.internal.x0XOIxOo r9 = new com.angcyo.dsladapter.internal.x0XOIxOo
            r9.<init>()
            r8.post(r9)
            goto L6f
        L6c:
            super.onLayout(r9, r10, r11, r12, r13)
        L6f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.angcyo.dsladapter.internal.RecyclerBottomLayout.onLayout(boolean, int, int, int, int):void");
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (View.MeasureSpec.getMode(i2) != 1073741824) {
            this.f5394XO = getMeasuredHeight();
        }
    }

    public final void set_layoutMeasureHeight(int i) {
        this.f5394XO = i;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecyclerBottomLayout(@OXOo.OOXIXo Context context, @OXOo.oOoXoXO AttributeSet attributeSet) {
        super(context, attributeSet);
        IIX0o.x0xO0oo(context, "context");
        this.f5394XO = -1;
    }
}
