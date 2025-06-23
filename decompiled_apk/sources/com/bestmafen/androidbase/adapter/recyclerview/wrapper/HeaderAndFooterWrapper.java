package com.bestmafen.androidbase.adapter.recyclerview.wrapper;

import IoOoX.oIX0oI;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.SparseArrayCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bestmafen.androidbase.adapter.recyclerview.base.ViewHolder;

/* loaded from: classes8.dex */
public class HeaderAndFooterWrapper<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int BASE_ITEM_TYPE_FOOTER = 200000;
    private static final int BASE_ITEM_TYPE_HEADER = 100000;
    private RecyclerView.Adapter mInnerAdapter;
    private SparseArrayCompat<View> mHeaderViews = new SparseArrayCompat<>();
    private SparseArrayCompat<View> mFootViews = new SparseArrayCompat<>();

    /* loaded from: classes8.dex */
    public class oIX0oI implements oIX0oI.II0xO0 {
        public oIX0oI() {
        }

        @Override // IoOoX.oIX0oI.II0xO0
        public int oIX0oI(GridLayoutManager gridLayoutManager, GridLayoutManager.SpanSizeLookup spanSizeLookup, int i) {
            int itemViewType = HeaderAndFooterWrapper.this.getItemViewType(i);
            if (HeaderAndFooterWrapper.this.mHeaderViews.get(itemViewType) != null) {
                return gridLayoutManager.getSpanCount();
            }
            if (HeaderAndFooterWrapper.this.mFootViews.get(itemViewType) != null) {
                return gridLayoutManager.getSpanCount();
            }
            if (spanSizeLookup != null) {
                return spanSizeLookup.getSpanSize(i);
            }
            return 1;
        }
    }

    public HeaderAndFooterWrapper(RecyclerView.Adapter adapter) {
        this.mInnerAdapter = adapter;
    }

    private int getRealItemCount() {
        return this.mInnerAdapter.getItemCount();
    }

    private boolean isFooterViewPos(int i) {
        if (i >= getHeadersCount() + getRealItemCount()) {
            return true;
        }
        return false;
    }

    private boolean isHeaderViewPos(int i) {
        if (i < getHeadersCount()) {
            return true;
        }
        return false;
    }

    public void addFootView(View view) {
        SparseArrayCompat<View> sparseArrayCompat = this.mFootViews;
        sparseArrayCompat.put(sparseArrayCompat.size() + BASE_ITEM_TYPE_FOOTER, view);
    }

    public void addHeaderView(View view) {
        SparseArrayCompat<View> sparseArrayCompat = this.mHeaderViews;
        sparseArrayCompat.put(sparseArrayCompat.size() + 100000, view);
    }

    public int getFootersCount() {
        return this.mFootViews.size();
    }

    public int getHeadersCount() {
        return this.mHeaderViews.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return getHeadersCount() + getFootersCount() + getRealItemCount();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (isHeaderViewPos(i)) {
            return this.mHeaderViews.keyAt(i);
        }
        if (isFooterViewPos(i)) {
            return this.mFootViews.keyAt((i - getHeadersCount()) - getRealItemCount());
        }
        return this.mInnerAdapter.getItemViewType(i - getHeadersCount());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        IoOoX.oIX0oI.oIX0oI(this.mInnerAdapter, recyclerView, new oIX0oI());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        if (isHeaderViewPos(i) || isFooterViewPos(i)) {
            return;
        }
        this.mInnerAdapter.onBindViewHolder(viewHolder, i - getHeadersCount());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (this.mHeaderViews.get(i) != null) {
            return ViewHolder.createViewHolder(viewGroup.getContext(), this.mHeaderViews.get(i));
        }
        if (this.mFootViews.get(i) != null) {
            return ViewHolder.createViewHolder(viewGroup.getContext(), this.mFootViews.get(i));
        }
        return this.mInnerAdapter.onCreateViewHolder(viewGroup, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        this.mInnerAdapter.onViewAttachedToWindow(viewHolder);
        int layoutPosition = viewHolder.getLayoutPosition();
        if (isHeaderViewPos(layoutPosition) || isFooterViewPos(layoutPosition)) {
            IoOoX.oIX0oI.II0xO0(viewHolder);
        }
    }
}
