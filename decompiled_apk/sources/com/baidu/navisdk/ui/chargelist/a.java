package com.baidu.navisdk.ui.chargelist;

import android.graphics.Rect;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.baidumaps.common.util.ScreenUtils;

/* loaded from: classes8.dex */
public class a extends RecyclerView.ItemDecoration {
    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
        if (((LinearLayoutManager) recyclerView.getLayoutManager()).getOrientation() == 0) {
            rect.set(ScreenUtils.dip2px(4), 0, 0, 0);
        } else {
            super.getItemOffsets(rect, view, recyclerView, state);
        }
    }
}
