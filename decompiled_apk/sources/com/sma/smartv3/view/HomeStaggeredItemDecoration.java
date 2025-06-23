package com.sma.smartv3.view;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.SizeUtils;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class HomeStaggeredItemDecoration extends RecyclerView.ItemDecoration {
    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@OXOo.OOXIXo Rect outRect, @OXOo.OOXIXo View view, @OXOo.OOXIXo RecyclerView parent, @OXOo.OOXIXo RecyclerView.State state) {
        IIX0o.x0xO0oo(outRect, "outRect");
        IIX0o.x0xO0oo(view, "view");
        IIX0o.x0xO0oo(parent, "parent");
        IIX0o.x0xO0oo(state, "state");
        parent.getChildAdapterPosition(view);
        int dp2px = SizeUtils.dp2px(6.0f);
        if (view.getWidth() < parent.getWidth()) {
            outRect.left = dp2px;
            outRect.right = dp2px;
        }
    }
}
