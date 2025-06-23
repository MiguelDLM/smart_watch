package com.baidu.navisdk.module.newguide.widgets;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes7.dex */
public class a extends RecyclerView.ItemDecoration {

    /* renamed from: a, reason: collision with root package name */
    private final int f7364a;
    private final int b;
    private final int c;

    public a(int i, int i2, int i3) {
        this.f7364a = i;
        this.b = i2;
        this.c = i3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int i;
        int i2;
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        int i3 = this.f7364a;
        if (childAdapterPosition % i3 > 0 && (i2 = this.c) > 0) {
            rect.left = i2;
        }
        if (childAdapterPosition >= i3 && (i = this.b) > 0) {
            rect.top = i;
        }
    }
}
