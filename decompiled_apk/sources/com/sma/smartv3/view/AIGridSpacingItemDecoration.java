package com.sma.smartv3.view;

import android.graphics.Rect;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class AIGridSpacingItemDecoration extends RecyclerView.ItemDecoration {
    private final int spacing;
    private final int spanCount;

    public AIGridSpacingItemDecoration(int i, int i2) {
        this.spanCount = i;
        this.spacing = i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@OXOo.OOXIXo Rect outRect, int i, @OXOo.OOXIXo RecyclerView recyclerView) {
        IIX0o.x0xO0oo(outRect, "outRect");
        IIX0o.x0xO0oo(recyclerView, "recyclerView");
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        IIX0o.x0XOIxOo(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
        GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
        int i2 = this.spanCount;
        int i3 = i % i2;
        if (i >= i2 && gridLayoutManager.canScrollVertically()) {
            outRect.top = this.spacing;
        }
        if (i3 > 0) {
            outRect.left = this.spacing;
        }
    }
}
