package com.bestmafen.androidbase.adapter.recyclerview.wrapper;

import IoOoX.oIX0oI;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bestmafen.androidbase.adapter.recyclerview.base.ViewHolder;

/* loaded from: classes8.dex */
public class EmptyWrapper<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int ITEM_TYPE_EMPTY = 2147483646;
    private int mEmptyLayoutId;
    private View mEmptyView;
    private RecyclerView.Adapter mInnerAdapter;

    /* loaded from: classes8.dex */
    public class oIX0oI implements oIX0oI.II0xO0 {
        public oIX0oI() {
        }

        @Override // IoOoX.oIX0oI.II0xO0
        public int oIX0oI(GridLayoutManager gridLayoutManager, GridLayoutManager.SpanSizeLookup spanSizeLookup, int i) {
            if (EmptyWrapper.this.isEmpty()) {
                return gridLayoutManager.getSpanCount();
            }
            if (spanSizeLookup != null) {
                return spanSizeLookup.getSpanSize(i);
            }
            return 1;
        }
    }

    public EmptyWrapper(RecyclerView.Adapter adapter) {
        this.mInnerAdapter = adapter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isEmpty() {
        if ((this.mEmptyView != null || this.mEmptyLayoutId != 0) && this.mInnerAdapter.getItemCount() == 0) {
            return true;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (isEmpty()) {
            return 1;
        }
        return this.mInnerAdapter.getItemCount();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (isEmpty()) {
            return ITEM_TYPE_EMPTY;
        }
        return this.mInnerAdapter.getItemViewType(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        IoOoX.oIX0oI.oIX0oI(this.mInnerAdapter, recyclerView, new oIX0oI());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        if (isEmpty()) {
            return;
        }
        this.mInnerAdapter.onBindViewHolder(viewHolder, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (isEmpty()) {
            if (this.mEmptyView != null) {
                return ViewHolder.createViewHolder(viewGroup.getContext(), this.mEmptyView);
            }
            return ViewHolder.createViewHolder(viewGroup.getContext(), viewGroup, this.mEmptyLayoutId);
        }
        return this.mInnerAdapter.onCreateViewHolder(viewGroup, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        this.mInnerAdapter.onViewAttachedToWindow(viewHolder);
        if (isEmpty()) {
            IoOoX.oIX0oI.II0xO0(viewHolder);
        }
    }

    public void setEmptyView(View view) {
        this.mEmptyView = view;
    }

    public void setEmptyView(int i) {
        this.mEmptyLayoutId = i;
    }
}
