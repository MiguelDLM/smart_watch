package com.l4digital.fastscroll;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.l4digital.fastscroll.FastScroller;

/* loaded from: classes11.dex */
public class FastScrollRecyclerView extends RecyclerView {
    private FastScroller fastScroller;

    public FastScrollRecyclerView(@NonNull Context context) {
        super(context);
        layout(context, null);
        setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
    }

    private void layout(Context context, AttributeSet attributeSet) {
        FastScroller fastScroller = new FastScroller(context, attributeSet);
        this.fastScroller = fastScroller;
        fastScroller.setId(R.id.fast_scroller);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.fastScroller.IXxxXO(this);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        this.fastScroller.oI0IIXIo();
        super.onDetachedFromWindow();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.RecyclerView
    public void setAdapter(@Nullable RecyclerView.Adapter adapter) {
        super.setAdapter(adapter);
        if (adapter instanceof FastScroller.xxIXOIIO) {
            this.fastScroller.setSectionIndexer((FastScroller.xxIXOIIO) adapter);
        } else if (adapter == 0) {
            this.fastScroller.setSectionIndexer(null);
        }
    }

    public void setBubbleColor(@ColorInt int i) {
        this.fastScroller.setBubbleColor(i);
    }

    public void setBubbleTextColor(@ColorInt int i) {
        this.fastScroller.setBubbleTextColor(i);
    }

    public void setBubbleTextSize(int i) {
        this.fastScroller.setBubbleTextSize(i);
    }

    public void setBubbleVisible(boolean z) {
        this.fastScroller.setBubbleVisible(z);
    }

    public void setFastScrollEnabled(boolean z) {
        this.fastScroller.setEnabled(z);
    }

    public void setFastScrollListener(@Nullable FastScroller.II0XooXoX iI0XooXoX) {
        this.fastScroller.setFastScrollListener(iI0XooXoX);
    }

    public void setHandleColor(@ColorInt int i) {
        this.fastScroller.setHandleColor(i);
    }

    public void setHideScrollbar(boolean z) {
        this.fastScroller.setHideScrollbar(z);
    }

    public void setSectionIndexer(@Nullable FastScroller.xxIXOIIO xxixoiio) {
        this.fastScroller.setSectionIndexer(xxixoiio);
    }

    public void setTrackColor(@ColorInt int i) {
        this.fastScroller.setTrackColor(i);
    }

    public void setTrackVisible(boolean z) {
        this.fastScroller.setTrackVisible(z);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        this.fastScroller.setVisibility(i);
    }

    public FastScrollRecyclerView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FastScrollRecyclerView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        layout(context, attributeSet);
    }
}
