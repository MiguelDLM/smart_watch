package com.baidu.navisdk.ui.widget.listener;

import android.graphics.Canvas;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes8.dex */
public class ItemTouchCallback extends ItemTouchHelper.Callback {
    private final ItemTouchAdapter itemTouchAdapter;
    private OnDragListener onDragListener;

    /* loaded from: classes8.dex */
    public interface ItemTouchAdapter {
        boolean isItemForbidMove(@NonNull RecyclerView.ViewHolder viewHolder);

        boolean isItemForbidSwipe(@NonNull RecyclerView.ViewHolder viewHolder);

        void onFinishDrag(@NonNull RecyclerView.ViewHolder viewHolder);

        void onMove(@NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder2);

        void onStartDrag(@Nullable RecyclerView.ViewHolder viewHolder);

        void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder);
    }

    /* loaded from: classes8.dex */
    public interface OnDragListener {
        void onFinishDrag(@NonNull RecyclerView.ViewHolder viewHolder);

        void onStartDrag(@Nullable RecyclerView.ViewHolder viewHolder);
    }

    public ItemTouchCallback(@NonNull ItemTouchAdapter itemTouchAdapter) {
        this.itemTouchAdapter = itemTouchAdapter;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void clearView(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
        super.clearView(recyclerView, viewHolder);
        ItemTouchAdapter itemTouchAdapter = this.itemTouchAdapter;
        if (itemTouchAdapter != null) {
            itemTouchAdapter.onFinishDrag(viewHolder);
        }
        OnDragListener onDragListener = this.onDragListener;
        if (onDragListener != null) {
            onDragListener.onFinishDrag(viewHolder);
        }
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
        int i;
        if (recyclerView.getLayoutManager() instanceof GridLayoutManager) {
            i = 15;
        } else {
            i = 3;
        }
        if (this.itemTouchAdapter.isItemForbidMove(viewHolder)) {
            i = 0;
        }
        this.itemTouchAdapter.isItemForbidSwipe(viewHolder);
        return ItemTouchHelper.Callback.makeMovementFlags(i, 0);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean isItemViewSwipeEnabled() {
        return super.isItemViewSwipeEnabled();
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean isLongPressDragEnabled() {
        return super.isLongPressDragEnabled();
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onChildDraw(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float f, float f2, int i, boolean z) {
        if (i == 1) {
            viewHolder.itemView.setAlpha(1.0f - (Math.abs(f) / viewHolder.itemView.getWidth()));
            viewHolder.itemView.setTranslationX(f);
            return;
        }
        super.onChildDraw(canvas, recyclerView, viewHolder, f, f2, i, z);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder2) {
        this.itemTouchAdapter.onMove(viewHolder, viewHolder2);
        return true;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onSelectedChanged(@Nullable RecyclerView.ViewHolder viewHolder, int i) {
        if (i != 0) {
            ItemTouchAdapter itemTouchAdapter = this.itemTouchAdapter;
            if (itemTouchAdapter != null) {
                itemTouchAdapter.onStartDrag(viewHolder);
            }
            OnDragListener onDragListener = this.onDragListener;
            if (onDragListener != null) {
                onDragListener.onStartDrag(viewHolder);
            }
        }
        super.onSelectedChanged(viewHolder, i);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        this.itemTouchAdapter.onSwiped(viewHolder);
    }

    public ItemTouchCallback setOnDragListener(OnDragListener onDragListener) {
        this.onDragListener = onDragListener;
        return this;
    }
}
