package com.tenmeter.smlibrary.widget.decoration;

import android.graphics.Rect;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes13.dex */
public class GridSpaceItemDecoration extends RecyclerView.ItemDecoration {
    private int spanCount;

    public GridSpaceItemDecoration(int i) {
        this.spanCount = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
        if (recyclerView.getChildLayoutPosition(view) % this.spanCount == 0) {
            rect.left = 0;
        }
    }
}
