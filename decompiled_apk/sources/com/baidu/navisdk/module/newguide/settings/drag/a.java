package com.baidu.navisdk.module.newguide.settings.drag;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes7.dex */
public class a extends ItemTouchHelper.Callback {

    /* renamed from: a, reason: collision with root package name */
    private Drawable f7257a = null;
    private int b = -1;
    private InterfaceC0253a c;
    private b d;

    /* renamed from: com.baidu.navisdk.module.newguide.settings.drag.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0253a {
        void a(int i, int i2);

        boolean a(int i);

        void b(int i);

        boolean c(int i);
    }

    /* loaded from: classes7.dex */
    public interface b {
        void C();

        void v0();
    }

    public a(@NonNull InterfaceC0253a interfaceC0253a) {
        this.c = interfaceC0253a;
    }

    public a a(b bVar) {
        this.d = bVar;
        return this;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        super.clearView(recyclerView, viewHolder);
        viewHolder.itemView.setAlpha(1.0f);
        Drawable drawable = this.f7257a;
        if (drawable != null) {
            viewHolder.itemView.setBackgroundDrawable(drawable);
        }
        int i = this.b;
        if (i != -1) {
            viewHolder.itemView.setBackgroundColor(i);
        }
        b bVar = this.d;
        if (bVar != null) {
            bVar.C();
        }
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        int i;
        int adapterPosition = viewHolder.getAdapterPosition();
        if (recyclerView.getLayoutManager() instanceof GridLayoutManager) {
            i = 15;
        } else {
            i = 3;
        }
        if (this.c.c(adapterPosition)) {
            i = 0;
        }
        this.c.a(adapterPosition);
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
    public void onChildDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float f, float f2, int i, boolean z) {
        if (i == 1) {
            viewHolder.itemView.setAlpha(1.0f - (Math.abs(f) / viewHolder.itemView.getWidth()));
            viewHolder.itemView.setTranslationX(f);
            return;
        }
        super.onChildDraw(canvas, recyclerView, viewHolder, f, f2, i, z);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
        this.c.a(viewHolder.getAdapterPosition(), viewHolder2.getAdapterPosition());
        return true;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int i) {
        if (i != 0) {
            if (this.f7257a == null && this.b == -1) {
                Drawable background = viewHolder.itemView.getBackground();
                if (background == null) {
                    this.b = 0;
                } else {
                    this.f7257a = background;
                }
            }
            viewHolder.itemView.setBackgroundColor(-3355444);
            b bVar = this.d;
            if (bVar != null) {
                bVar.v0();
            }
        }
        super.onSelectedChanged(viewHolder, i);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int i) {
        this.c.b(viewHolder.getAdapterPosition());
    }
}
