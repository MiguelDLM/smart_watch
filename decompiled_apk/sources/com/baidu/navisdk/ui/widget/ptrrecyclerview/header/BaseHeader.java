package com.baidu.navisdk.ui.widget.ptrrecyclerview.header;

import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes8.dex */
public class BaseHeader extends RecyclerView.ItemDecoration {
    protected int mHeaderHeight;

    public int getHeight() {
        return this.mHeaderHeight;
    }

    public void setHeight(int i) {
        this.mHeaderHeight = i;
    }
}
