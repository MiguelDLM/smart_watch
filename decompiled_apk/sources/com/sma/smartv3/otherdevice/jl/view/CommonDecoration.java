package com.sma.smartv3.otherdevice.jl.view;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes12.dex */
public class CommonDecoration extends RecyclerView.ItemDecoration {
    private static final int[] attrs = {R.attr.listDivider};
    private int dividerHeight = 1;
    private Drawable mDivider;
    private int orientation;

    public CommonDecoration(Context context, int orientation) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs);
        Drawable drawable = obtainStyledAttributes.getDrawable(0);
        if (drawable != null) {
            init(orientation, drawable, drawable.getIntrinsicHeight());
        }
        obtainStyledAttributes.recycle();
    }

    private void drawHDeraction(Canvas c, RecyclerView parent) {
        int paddingLeft = parent.getPaddingLeft();
        int width = parent.getWidth() - parent.getPaddingRight();
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = parent.getChildAt(i);
            int bottom = childAt.getBottom() + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) childAt.getLayoutParams())).bottomMargin;
            this.mDivider.setBounds(paddingLeft, bottom, width, this.dividerHeight + bottom);
            this.mDivider.draw(c);
        }
    }

    private void drawVDeraction(Canvas c, RecyclerView parent) {
        int paddingTop = parent.getPaddingTop();
        int height = parent.getHeight() - parent.getPaddingBottom();
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = parent.getChildAt(i);
            int right = childAt.getRight() + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) childAt.getLayoutParams())).rightMargin;
            this.mDivider.setBounds(right, paddingTop, this.dividerHeight + right, height);
            this.mDivider.draw(c);
        }
    }

    private void init(int orientation, Drawable drawable, int height) {
        this.mDivider = drawable;
        this.orientation = orientation;
        this.dividerHeight = height;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        if (this.orientation == 0) {
            outRect.set(0, 0, this.dividerHeight, 0);
        } else {
            outRect.set(0, 0, 0, this.dividerHeight);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        drawHDeraction(c, parent);
        drawVDeraction(c, parent);
    }

    public CommonDecoration(Context context, int orientation, int color, int height) {
        init(orientation, new ColorDrawable(color), height);
    }

    public CommonDecoration(Context context, int orientation, Drawable drawable) {
        init(orientation, drawable, drawable.getIntrinsicHeight());
    }
}
