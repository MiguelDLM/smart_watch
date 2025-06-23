package com.baidu.navisdk.ui.widget.recyclerview;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes8.dex */
public class RecycleViewDivider extends RecyclerView.ItemDecoration {
    private static final int[] ATTRS = {R.attr.listDivider};
    private Drawable mDivider;
    private int mDividerHeight;
    private int mOrientation;
    private Paint mPaint;
    private int mRectHeight;

    public RecycleViewDivider(Context context, int i) {
        this.mDividerHeight = 2;
        this.mRectHeight = 2;
        if (i != 1 && i != 0) {
            throw new IllegalArgumentException("请输入正确的参数！");
        }
        this.mOrientation = i;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(ATTRS);
        this.mDivider = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
    }

    public void drawHorizontal(Canvas canvas, RecyclerView recyclerView) {
        int paddingTop = recyclerView.getPaddingTop();
        int measuredHeight = recyclerView.getMeasuredHeight() - recyclerView.getPaddingBottom();
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            if (shouAddDivider(recyclerView.getChildAdapterPosition(childAt))) {
                int right = childAt.getRight() + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) childAt.getLayoutParams())).rightMargin;
                int i2 = this.mRectHeight;
                int i3 = this.mDividerHeight;
                int i4 = right + ((i2 - i3) / 2);
                int i5 = i3 + i4;
                Drawable drawable = this.mDivider;
                if (drawable != null) {
                    drawable.setBounds(i4, paddingTop, i5, measuredHeight);
                    this.mDivider.draw(canvas);
                }
                Paint paint = this.mPaint;
                if (paint != null) {
                    canvas.drawRect(i4, paddingTop, i5, measuredHeight, paint);
                }
            }
        }
    }

    public void drawVertical(Canvas canvas, RecyclerView recyclerView) {
        int paddingLeft = recyclerView.getPaddingLeft();
        int measuredWidth = recyclerView.getMeasuredWidth() - recyclerView.getPaddingRight();
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            if (shouAddDivider(recyclerView.getChildAdapterPosition(childAt))) {
                int bottom = childAt.getBottom() + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) childAt.getLayoutParams())).bottomMargin;
                int i2 = this.mRectHeight;
                int i3 = this.mDividerHeight;
                int i4 = bottom + ((i2 - i3) / 2);
                int i5 = i3 + i4;
                Drawable drawable = this.mDivider;
                if (drawable != null) {
                    drawable.setBounds(paddingLeft, i4, measuredWidth, i5);
                    this.mDivider.draw(canvas);
                }
                Paint paint = this.mPaint;
                if (paint != null) {
                    canvas.drawRect(paddingLeft, i4, measuredWidth, i5, paint);
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        super.getItemOffsets(rect, view, recyclerView, state);
        if (shouAddDivider(recyclerView.getChildAdapterPosition(view))) {
            if (this.mOrientation == 1) {
                rect.set(0, 0, 0, this.mRectHeight);
            } else {
                rect.set(0, 0, this.mRectHeight, 0);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        super.onDraw(canvas, recyclerView, state);
        if (this.mOrientation == 1) {
            drawVertical(canvas, recyclerView);
        } else {
            drawHorizontal(canvas, recyclerView);
        }
    }

    public boolean shouAddDivider(int i) {
        return true;
    }

    public RecycleViewDivider(Context context, int i, int i2) {
        this(context, i);
        Drawable drawable = ContextCompat.getDrawable(context, i2);
        this.mDivider = drawable;
        this.mDividerHeight = drawable.getIntrinsicHeight();
    }

    public RecycleViewDivider(Context context, int i, int i2, int i3) {
        this(context, i, i2, i3, i2);
    }

    public RecycleViewDivider(Context context, int i, int i2, int i3, int i4) {
        this(context, i);
        this.mDividerHeight = i2;
        this.mRectHeight = i4;
        Paint paint = new Paint(1);
        this.mPaint = paint;
        paint.setColor(i3);
        this.mPaint.setStyle(Paint.Style.FILL);
    }
}
