package com.google.android.flexbox;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/* loaded from: classes9.dex */
public class FlexboxItemDecoration extends RecyclerView.ItemDecoration {
    public static final int BOTH = 3;
    public static final int HORIZONTAL = 1;
    private static final int[] LIST_DIVIDER_ATTRS = {android.R.attr.listDivider};
    public static final int VERTICAL = 2;
    private Drawable mDrawable;
    private int mOrientation;

    public FlexboxItemDecoration(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(LIST_DIVIDER_ATTRS);
        this.mDrawable = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
        setOrientation(3);
    }

    private void drawHorizontalDecorations(Canvas canvas, RecyclerView parent) {
        int top;
        int intrinsicHeight;
        int left;
        int right;
        int i;
        int i2;
        int i3;
        if (!needsHorizontalDecoration()) {
            return;
        }
        FlexboxLayoutManager flexboxLayoutManager = (FlexboxLayoutManager) parent.getLayoutManager();
        int flexDirection = flexboxLayoutManager.getFlexDirection();
        int left2 = parent.getLeft() - parent.getPaddingLeft();
        int right2 = parent.getRight() + parent.getPaddingRight();
        int childCount = parent.getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = parent.getChildAt(i4);
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) childAt.getLayoutParams();
            if (flexDirection == 3) {
                intrinsicHeight = childAt.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                top = this.mDrawable.getIntrinsicHeight() + intrinsicHeight;
            } else {
                top = childAt.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                intrinsicHeight = top - this.mDrawable.getIntrinsicHeight();
            }
            if (flexboxLayoutManager.isMainAxisDirectionHorizontal()) {
                if (flexboxLayoutManager.isLayoutRtl()) {
                    i2 = Math.min(childAt.getRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + this.mDrawable.getIntrinsicWidth(), right2);
                    i3 = childAt.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                    this.mDrawable.setBounds(i3, intrinsicHeight, i2, top);
                    this.mDrawable.draw(canvas);
                } else {
                    left = Math.max((childAt.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) - this.mDrawable.getIntrinsicWidth(), left2);
                    right = childAt.getRight();
                    i = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                }
            } else {
                left = childAt.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                right = childAt.getRight();
                i = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
            }
            int i5 = left;
            i2 = right + i;
            i3 = i5;
            this.mDrawable.setBounds(i3, intrinsicHeight, i2, top);
            this.mDrawable.draw(canvas);
        }
    }

    private void drawVerticalDecorations(Canvas canvas, RecyclerView parent) {
        int left;
        int intrinsicWidth;
        int max;
        int bottom;
        int i;
        int i2;
        if (!needsVerticalDecoration()) {
            return;
        }
        FlexboxLayoutManager flexboxLayoutManager = (FlexboxLayoutManager) parent.getLayoutManager();
        int top = parent.getTop() - parent.getPaddingTop();
        int bottom2 = parent.getBottom() + parent.getPaddingBottom();
        int childCount = parent.getChildCount();
        int flexDirection = flexboxLayoutManager.getFlexDirection();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = parent.getChildAt(i3);
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) childAt.getLayoutParams();
            if (flexboxLayoutManager.isLayoutRtl()) {
                intrinsicWidth = childAt.getRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                left = this.mDrawable.getIntrinsicWidth() + intrinsicWidth;
            } else {
                left = childAt.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                intrinsicWidth = left - this.mDrawable.getIntrinsicWidth();
            }
            if (flexboxLayoutManager.isMainAxisDirectionHorizontal()) {
                max = childAt.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                bottom = childAt.getBottom();
                i = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
            } else if (flexDirection == 3) {
                int min = Math.min(childAt.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + this.mDrawable.getIntrinsicHeight(), bottom2);
                max = childAt.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                i2 = min;
                this.mDrawable.setBounds(intrinsicWidth, max, left, i2);
                this.mDrawable.draw(canvas);
            } else {
                max = Math.max((childAt.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) - this.mDrawable.getIntrinsicHeight(), top);
                bottom = childAt.getBottom();
                i = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
            }
            i2 = bottom + i;
            this.mDrawable.setBounds(intrinsicWidth, max, left, i2);
            this.mDrawable.draw(canvas);
        }
    }

    private boolean isFirstItemInLine(int position, List<FlexLine> flexLines, FlexboxLayoutManager layoutManager) {
        int positionToFlexLineIndex = layoutManager.getPositionToFlexLineIndex(position);
        if ((positionToFlexLineIndex != -1 && positionToFlexLineIndex < layoutManager.getFlexLinesInternal().size() && layoutManager.getFlexLinesInternal().get(positionToFlexLineIndex).mFirstIndex == position) || position == 0) {
            return true;
        }
        if (flexLines.size() != 0 && flexLines.get(flexLines.size() - 1).mLastIndex == position - 1) {
            return true;
        }
        return false;
    }

    private boolean needsHorizontalDecoration() {
        if ((this.mOrientation & 1) > 0) {
            return true;
        }
        return false;
    }

    private boolean needsVerticalDecoration() {
        if ((this.mOrientation & 2) > 0) {
            return true;
        }
        return false;
    }

    private void setOffsetAlongCrossAxis(Rect outRect, int position, FlexboxLayoutManager layoutManager, List<FlexLine> flexLines) {
        if (flexLines.size() == 0 || layoutManager.getPositionToFlexLineIndex(position) == 0) {
            return;
        }
        if (layoutManager.isMainAxisDirectionHorizontal()) {
            if (!needsHorizontalDecoration()) {
                outRect.top = 0;
                outRect.bottom = 0;
                return;
            } else {
                outRect.top = this.mDrawable.getIntrinsicHeight();
                outRect.bottom = 0;
                return;
            }
        }
        if (!needsVerticalDecoration()) {
            return;
        }
        if (layoutManager.isLayoutRtl()) {
            outRect.right = this.mDrawable.getIntrinsicWidth();
            outRect.left = 0;
        } else {
            outRect.left = this.mDrawable.getIntrinsicWidth();
            outRect.right = 0;
        }
    }

    private void setOffsetAlongMainAxis(Rect outRect, int position, FlexboxLayoutManager layoutManager, List<FlexLine> flexLines, int flexDirection) {
        if (isFirstItemInLine(position, flexLines, layoutManager)) {
            return;
        }
        if (layoutManager.isMainAxisDirectionHorizontal()) {
            if (!needsVerticalDecoration()) {
                outRect.left = 0;
                outRect.right = 0;
                return;
            } else if (layoutManager.isLayoutRtl()) {
                outRect.right = this.mDrawable.getIntrinsicWidth();
                outRect.left = 0;
                return;
            } else {
                outRect.left = this.mDrawable.getIntrinsicWidth();
                outRect.right = 0;
                return;
            }
        }
        if (!needsHorizontalDecoration()) {
            outRect.top = 0;
            outRect.bottom = 0;
        } else if (flexDirection == 3) {
            outRect.bottom = this.mDrawable.getIntrinsicHeight();
            outRect.top = 0;
        } else {
            outRect.top = this.mDrawable.getIntrinsicHeight();
            outRect.bottom = 0;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, RecyclerView parent, @NonNull RecyclerView.State state) {
        int childAdapterPosition = parent.getChildAdapterPosition(view);
        if (childAdapterPosition == 0) {
            return;
        }
        if (!needsHorizontalDecoration() && !needsVerticalDecoration()) {
            outRect.set(0, 0, 0, 0);
            return;
        }
        FlexboxLayoutManager flexboxLayoutManager = (FlexboxLayoutManager) parent.getLayoutManager();
        List<FlexLine> flexLines = flexboxLayoutManager.getFlexLines();
        setOffsetAlongMainAxis(outRect, childAdapterPosition, flexboxLayoutManager, flexLines, flexboxLayoutManager.getFlexDirection());
        setOffsetAlongCrossAxis(outRect, childAdapterPosition, flexboxLayoutManager, flexLines);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(@NonNull Canvas canvas, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        drawHorizontalDecorations(canvas, parent);
        drawVerticalDecorations(canvas, parent);
    }

    public void setDrawable(Drawable drawable) {
        if (drawable != null) {
            this.mDrawable = drawable;
            return;
        }
        throw new IllegalArgumentException("Drawable cannot be null.");
    }

    public void setOrientation(int orientation) {
        this.mOrientation = orientation;
    }
}
