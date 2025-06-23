package com.baidu.navisdk.ui.widget.ptrrecyclerview.header;

import android.graphics.Rect;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes8.dex */
public class Header extends BaseHeader {
    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, int i, RecyclerView recyclerView) {
        if (i == 0) {
            rect.set(0, this.mHeaderHeight, 0, 0);
        }
    }
}
