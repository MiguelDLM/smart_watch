package com.bestmafen.androidbase.adapter.recyclerview.wrapper;

import IoOoX.oIX0oI;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bestmafen.androidbase.adapter.recyclerview.base.ViewHolder;

/* loaded from: classes8.dex */
public class LoadMoreWrapper<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int ITEM_TYPE_LOAD_MORE = 2147483645;
    private RecyclerView.Adapter mInnerAdapter;
    private int mLoadMoreLayoutId;
    private View mLoadMoreView;
    private II0xO0 mOnLoadMoreListener;

    /* loaded from: classes8.dex */
    public interface II0xO0 {
        void oIX0oI();
    }

    /* loaded from: classes8.dex */
    public class oIX0oI implements oIX0oI.II0xO0 {
        public oIX0oI() {
        }

        @Override // IoOoX.oIX0oI.II0xO0
        public int oIX0oI(GridLayoutManager gridLayoutManager, GridLayoutManager.SpanSizeLookup spanSizeLookup, int i) {
            if (LoadMoreWrapper.this.isShowLoadMore(i)) {
                return gridLayoutManager.getSpanCount();
            }
            if (spanSizeLookup != null) {
                return spanSizeLookup.getSpanSize(i);
            }
            return 1;
        }
    }

    public LoadMoreWrapper(RecyclerView.Adapter adapter) {
        this.mInnerAdapter = adapter;
    }

    private boolean hasLoadMore() {
        if (this.mLoadMoreView == null && this.mLoadMoreLayoutId == 0) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isShowLoadMore(int i) {
        if (hasLoadMore() && i >= this.mInnerAdapter.getItemCount()) {
            return true;
        }
        return false;
    }

    private void setFullSpan(RecyclerView.ViewHolder viewHolder) {
        ViewGroup.LayoutParams layoutParams = viewHolder.itemView.getLayoutParams();
        if (layoutParams != null && (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams)) {
            ((StaggeredGridLayoutManager.LayoutParams) layoutParams).setFullSpan(true);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mInnerAdapter.getItemCount() + (hasLoadMore() ? 1 : 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (isShowLoadMore(i)) {
            return 2147483645;
        }
        return this.mInnerAdapter.getItemViewType(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        IoOoX.oIX0oI.oIX0oI(this.mInnerAdapter, recyclerView, new oIX0oI());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        if (isShowLoadMore(i)) {
            II0xO0 iI0xO0 = this.mOnLoadMoreListener;
            if (iI0xO0 != null) {
                iI0xO0.oIX0oI();
                return;
            }
            return;
        }
        this.mInnerAdapter.onBindViewHolder(viewHolder, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 2147483645) {
            if (this.mLoadMoreView != null) {
                return ViewHolder.createViewHolder(viewGroup.getContext(), this.mLoadMoreView);
            }
            return ViewHolder.createViewHolder(viewGroup.getContext(), viewGroup, this.mLoadMoreLayoutId);
        }
        return this.mInnerAdapter.onCreateViewHolder(viewGroup, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        this.mInnerAdapter.onViewAttachedToWindow(viewHolder);
        if (isShowLoadMore(viewHolder.getLayoutPosition())) {
            setFullSpan(viewHolder);
        }
    }

    public LoadMoreWrapper setLoadMoreView(View view) {
        this.mLoadMoreView = view;
        return this;
    }

    public LoadMoreWrapper setOnLoadMoreListener(II0xO0 iI0xO0) {
        if (iI0xO0 != null) {
            this.mOnLoadMoreListener = iI0xO0;
        }
        return this;
    }

    public LoadMoreWrapper setLoadMoreView(int i) {
        this.mLoadMoreLayoutId = i;
        return this;
    }
}
