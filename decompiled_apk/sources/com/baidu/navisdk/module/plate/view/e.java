package com.baidu.navisdk.module.plate.view;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.navisdk.ui.widget.recyclerview.util.RecyclerViewMetrics;
import java.util.HashMap;

/* loaded from: classes7.dex */
public class e extends RecyclerView.ItemDecoration {

    /* renamed from: a, reason: collision with root package name */
    private HashMap<String, Integer> f7443a;
    private boolean b;

    public e(HashMap hashMap, boolean z) {
        this.f7443a = hashMap;
        this.b = z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        recyclerView.getChildAdapterPosition(view);
        if (this.b) {
            if (this.f7443a.get("left_space") != null) {
                rect.left = this.f7443a.get("left_space").intValue();
            }
            if (this.f7443a.get("right_space") != null) {
                rect.right = this.f7443a.get("right_space").intValue();
            }
            if (this.f7443a.get("bottom_space") != null) {
                rect.bottom = this.f7443a.get("bottom_space").intValue();
            }
            if (this.f7443a.get("top_space") != null) {
                rect.top = this.f7443a.get("top_space").intValue();
                return;
            }
            return;
        }
        if (linearLayoutManager.getOrientation() == 0) {
            if (recyclerView.getChildAdapterPosition(view) == 0) {
                rect.left = RecyclerViewMetrics.dp2px(19.0d);
                rect.right = RecyclerViewMetrics.dp2px(15.0d);
            } else if (recyclerView.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1) {
                rect.right = RecyclerViewMetrics.dp2px(19.0d);
            } else {
                rect.right = RecyclerViewMetrics.dp2px(15.0d);
            }
        }
        if (linearLayoutManager.getOrientation() == 1) {
            if (recyclerView.getChildAdapterPosition(view) == 0) {
                rect.top = 0;
            }
            if (recyclerView.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1) {
                rect.bottom = 0;
            }
        }
    }
}
