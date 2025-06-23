package com.baidu.mobads.sdk.internal.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

/* loaded from: classes7.dex */
public class RLRecyclerView extends SwipeRefreshLayout {

    /* renamed from: a, reason: collision with root package name */
    private RecyclerView f6345a;
    private int[] b;
    private int[] c;
    private int[] d;

    /* loaded from: classes7.dex */
    public static class NormalItemDecoration extends RecyclerView.ItemDecoration {

        /* renamed from: a, reason: collision with root package name */
        private final int f6346a;
        private final int b;
        private final int c;
        private final int d;

        public NormalItemDecoration(int i, int i2, int i3, int i4) {
            this.f6346a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            rect.left = this.f6346a;
            rect.top = this.b;
            rect.right = this.c;
            rect.bottom = this.d;
        }
    }

    public RLRecyclerView(Context context) {
        super(context);
        this.c = new int[2];
        this.d = new int[2];
        a(context);
    }

    private void a(Context context) {
        this.f6345a = new RecyclerView(context);
        addView(this.f6345a, new ViewGroup.LayoutParams(-1, -1));
    }

    private int b(int[] iArr) {
        if (iArr != null && iArr.length > 0) {
            int i = iArr[0];
            for (int i2 : iArr) {
                if (i2 > i) {
                    i = i2;
                }
            }
            return i;
        }
        return -1;
    }

    public void addOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        RecyclerView recyclerView = this.f6345a;
        if (recyclerView != null) {
            recyclerView.addOnScrollListener(onScrollListener);
        }
    }

    public int[] findVisibleItemPositions() {
        RecyclerView recyclerView = this.f6345a;
        if (recyclerView != null) {
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof GridLayoutManager) {
                GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
                this.d[0] = gridLayoutManager.findFirstVisibleItemPosition();
                this.d[1] = gridLayoutManager.findLastVisibleItemPosition();
                return this.d;
            }
            if (layoutManager instanceof LinearLayoutManager) {
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
                this.d[0] = linearLayoutManager.findFirstVisibleItemPosition();
                this.d[1] = linearLayoutManager.findLastVisibleItemPosition();
                return this.d;
            }
            if (layoutManager instanceof StaggeredGridLayoutManager) {
                StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
                if (this.b == null) {
                    this.b = new int[staggeredGridLayoutManager.getSpanCount()];
                }
                staggeredGridLayoutManager.findFirstVisibleItemPositions(this.b);
                this.d[0] = a(this.b);
                staggeredGridLayoutManager.findLastVisibleItemPositions(this.b);
                this.d[1] = b(this.b);
                return this.d;
            }
            return null;
        }
        return null;
    }

    public int getChildAdapterPosition(View view) {
        RecyclerView recyclerView = this.f6345a;
        if (recyclerView != null) {
            return recyclerView.getChildAdapterPosition(view);
        }
        return -1;
    }

    public int[] getLayoutManagerCounts() {
        RecyclerView.LayoutManager layoutManager;
        RecyclerView recyclerView = this.f6345a;
        if (recyclerView != null && (layoutManager = recyclerView.getLayoutManager()) != null) {
            this.c[0] = layoutManager.getItemCount();
            this.c[1] = layoutManager.getChildCount();
            return this.c;
        }
        return null;
    }

    public View getRvChildAt(int i) {
        RecyclerView recyclerView = this.f6345a;
        if (recyclerView != null) {
            return recyclerView.getChildAt(i);
        }
        return null;
    }

    public int getRvChildCount() {
        RecyclerView recyclerView = this.f6345a;
        if (recyclerView != null) {
            return recyclerView.getChildCount();
        }
        return 0;
    }

    public int indexOfRvChild(View view) {
        RecyclerView recyclerView = this.f6345a;
        if (recyclerView != null) {
            return recyclerView.indexOfChild(view);
        }
        return -1;
    }

    public void scrollToPosition(int i) {
        RecyclerView recyclerView = this.f6345a;
        if (recyclerView != null) {
            recyclerView.scrollToPosition(i);
        }
    }

    public void setAdapter(@Nullable RecyclerView.Adapter adapter) {
        RecyclerView recyclerView = this.f6345a;
        if (recyclerView != null) {
            recyclerView.setAdapter(adapter);
        }
    }

    public void setItemDecoration(int i, int i2, int i3, int i4) {
        RecyclerView recyclerView = this.f6345a;
        if (recyclerView != null) {
            recyclerView.addItemDecoration(new NormalItemDecoration(i, i2, i3, i4));
        }
    }

    public void setLayoutManager(int i, int i2, int i3) {
        RecyclerView recyclerView = this.f6345a;
        if (recyclerView != null) {
            if (1 == i) {
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            } else if (2 == i) {
                recyclerView.setLayoutManager(new GridLayoutManager(getContext(), i2));
            } else if (3 == i) {
                recyclerView.setLayoutManager(new StaggeredGridLayoutManager(i2, i3));
            }
        }
    }

    public void setRecyclerViewPadding(int i, int i2, int i3, int i4) {
        RecyclerView recyclerView = this.f6345a;
        if (recyclerView != null) {
            recyclerView.setPadding(i, i2, i3, i4);
        }
    }

    private int a(int[] iArr) {
        if (iArr == null || iArr.length <= 0) {
            return -1;
        }
        int i = iArr[0];
        for (int i2 : iArr) {
            if (i2 < i) {
                i = i2;
            }
        }
        return i;
    }

    public RLRecyclerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = new int[2];
        this.d = new int[2];
        a(context);
    }
}
