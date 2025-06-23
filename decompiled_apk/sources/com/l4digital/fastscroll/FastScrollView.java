package com.l4digital.fastscroll;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.l4digital.fastscroll.FastScroller;

/* loaded from: classes11.dex */
public class FastScrollView extends FrameLayout {

    /* renamed from: Oo, reason: collision with root package name */
    public RecyclerView f18476Oo;

    /* renamed from: XO, reason: collision with root package name */
    public FastScroller f18477XO;

    public FastScrollView(@NonNull Context context) {
        super(context);
        oIX0oI(context, null);
        setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
    }

    @NonNull
    public FastScroller getFastScroller() {
        return this.f18477XO;
    }

    @NonNull
    public RecyclerView getRecyclerView() {
        return this.f18476Oo;
    }

    public final void oIX0oI(Context context, AttributeSet attributeSet) {
        FastScroller fastScroller = new FastScroller(context, attributeSet);
        this.f18477XO = fastScroller;
        fastScroller.setId(R.id.fast_scroller);
        RecyclerView recyclerView = new RecyclerView(context, attributeSet);
        this.f18476Oo = recyclerView;
        recyclerView.setId(R.id.recycler_view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        addView(this.f18476Oo);
        this.f18476Oo.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f18477XO.IXxxXO(this.f18476Oo);
        setNestedScrollingEnabled(true);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        this.f18477XO.oI0IIXIo();
        removeAllViews();
        super.onDetachedFromWindow();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setAdapter(@Nullable RecyclerView.Adapter adapter) {
        this.f18476Oo.setAdapter(adapter);
        if (adapter instanceof FastScroller.xxIXOIIO) {
            this.f18477XO.setSectionIndexer((FastScroller.xxIXOIIO) adapter);
        } else if (adapter == 0) {
            this.f18477XO.setSectionIndexer(null);
        }
    }

    public void setLayoutManager(@NonNull RecyclerView.LayoutManager layoutManager) {
        this.f18476Oo.setLayoutManager(layoutManager);
    }

    public FastScrollView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FastScrollView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        oIX0oI(context, attributeSet);
    }
}
