package com.baidu.navisdk.ui.widget;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes8.dex */
public class DivideGridItemDecoration extends RecyclerView.ItemDecoration {
    private int childCount;
    private final Drawable mDivideDrawable;
    private final DivideParams mDivideParams;
    int spanCount;

    /* loaded from: classes8.dex */
    public static final class SpecialDivideResult {
        boolean isSpecialDivide;
        DivideParams.SpecialDivideParams mSpecialDivideParams;

        private SpecialDivideResult() {
        }
    }

    public DivideGridItemDecoration(DivideParams divideParams, Drawable drawable) {
        this.mDivideParams = divideParams;
        this.mDivideDrawable = drawable;
    }

    private void drawDivide(Canvas canvas, RecyclerView recyclerView) {
        for (int i = 0; i < this.childCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            SpecialDivideResult isSpecialDivide = isSpecialDivide(i);
            drawHorizontalDivide(canvas, childAt, isSpecialDivide);
            drawVerticalDivide(canvas, childAt, isSpecialDivide);
        }
    }

    private void drawHorizontalDivide(Canvas canvas, View view, SpecialDivideResult specialDivideResult) {
        int i;
        int i2;
        DivideParams.SpecialDivideParams specialDivideParams;
        if (specialDivideResult != null && specialDivideResult.isSpecialDivide && (specialDivideParams = specialDivideResult.mSpecialDivideParams) != null) {
            i = specialDivideParams.dividePaddingItemLeft;
            i2 = specialDivideParams.dividePaddingItemRight;
        } else {
            DivideParams divideParams = this.mDivideParams;
            i = divideParams.dividePaddingItemLeft;
            i2 = divideParams.dividePaddingItemRight;
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        int left = (view.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) + i;
        int right = ((view.getRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin) + this.mDivideDrawable.getIntrinsicWidth()) - i2;
        int bottom = view.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        int intrinsicHeight = this.mDivideDrawable.getIntrinsicHeight() + bottom;
        if (left < right && this.mDivideParams.isShowHorizontalDivide) {
            this.mDivideDrawable.setBounds(left, bottom, right, intrinsicHeight);
            this.mDivideDrawable.draw(canvas);
        } else {
            this.mDivideParams.isShowHorizontalDivide = false;
        }
    }

    private void drawVerticalDivide(Canvas canvas, View view, SpecialDivideResult specialDivideResult) {
        int i;
        int i2;
        DivideParams.SpecialDivideParams specialDivideParams;
        if (specialDivideResult != null && specialDivideResult.isSpecialDivide && (specialDivideParams = specialDivideResult.mSpecialDivideParams) != null) {
            i = specialDivideParams.dividePaddingItemTop;
            i2 = specialDivideParams.dividePaddingItemBottom;
        } else {
            DivideParams divideParams = this.mDivideParams;
            i = divideParams.dividePaddingItemTop;
            i2 = divideParams.dividePaddingItemBottom;
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        int top = (view.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) + i;
        int bottom = (view.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) - i2;
        int right = view.getRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
        int intrinsicWidth = this.mDivideDrawable.getIntrinsicWidth() + right;
        if (top < bottom && this.mDivideParams.isShowVerticalDivide) {
            this.mDivideDrawable.setBounds(right, top, intrinsicWidth, bottom);
            this.mDivideDrawable.draw(canvas);
        } else {
            this.mDivideParams.isShowVerticalDivide = false;
        }
    }

    private int getSpanCount(RecyclerView recyclerView) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            return ((GridLayoutManager) layoutManager).getSpanCount();
        }
        if (layoutManager instanceof StaggeredGridLayoutManager) {
            return ((StaggeredGridLayoutManager) layoutManager).getSpanCount();
        }
        return -1;
    }

    private boolean isFirstRaw(RecyclerView recyclerView, int i, int i2, int i3) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            if (i < i2) {
                return true;
            }
            return false;
        }
        if ((layoutManager instanceof StaggeredGridLayoutManager) && i < i2) {
            return true;
        }
        return false;
    }

    private boolean isLastColum(RecyclerView recyclerView, int i, int i2, int i3) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            if ((i + 1) % i2 != 0) {
                return false;
            }
            return true;
        }
        if (!(layoutManager instanceof StaggeredGridLayoutManager)) {
            return false;
        }
        if (((StaggeredGridLayoutManager) layoutManager).getOrientation() == 1) {
            if ((i + 1) % i2 != 0) {
                return false;
            }
            return true;
        }
        if (i < i3 - (i3 % i2)) {
            return false;
        }
        return true;
    }

    private boolean isLastRaw(RecyclerView recyclerView, int i, int i2, int i3) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            int i4 = i3 - 1;
            if (i < i4 - (i4 % i2)) {
                return false;
            }
            return true;
        }
        if (!(layoutManager instanceof StaggeredGridLayoutManager)) {
            return false;
        }
        if (((StaggeredGridLayoutManager) layoutManager).getOrientation() == 1) {
            int i5 = i3 - 1;
            if (i < i5 - (i5 % i2)) {
                return false;
            }
            return true;
        }
        if ((i + 1) % i2 != 0) {
            return false;
        }
        return true;
    }

    private SpecialDivideResult isSpecialDivide(int i) {
        DivideParams divideParams;
        ArrayList<DivideParams.SpecialDivideParams> arrayList;
        int i2;
        int i3;
        SpecialDivideResult specialDivideResult = new SpecialDivideResult();
        specialDivideResult.isSpecialDivide = false;
        if (this.childCount > 0 && (divideParams = this.mDivideParams) != null && (arrayList = divideParams.mSpecialDivideParams) != null && !arrayList.isEmpty()) {
            Iterator<DivideParams.SpecialDivideParams> it = this.mDivideParams.mSpecialDivideParams.iterator();
            while (it.hasNext()) {
                DivideParams.SpecialDivideParams next = it.next();
                int i4 = next.rowNum;
                if (i4 < 0 && (i3 = next.columNum) >= 0) {
                    if (i % this.spanCount == i3) {
                        specialDivideResult.isSpecialDivide = true;
                        specialDivideResult.mSpecialDivideParams = next;
                        return specialDivideResult;
                    }
                } else if (i4 >= 0 && next.columNum < 0) {
                    int i5 = this.spanCount;
                    if (i >= i5 * i4 && i < i5 * (i4 + 1)) {
                        specialDivideResult.isSpecialDivide = true;
                        specialDivideResult.mSpecialDivideParams = next;
                        return specialDivideResult;
                    }
                } else if (i4 >= 0 && (i2 = next.columNum) >= 0) {
                    if (i == (this.spanCount * i4) + i2) {
                        specialDivideResult.isSpecialDivide = true;
                        specialDivideResult.mSpecialDivideParams = next;
                        return specialDivideResult;
                    }
                } else {
                    specialDivideResult.isSpecialDivide = true;
                    specialDivideResult.mSpecialDivideParams = next;
                    break;
                }
            }
        }
        return specialDivideResult;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        if (this.mDivideParams != null && this.mDivideDrawable != null) {
            this.spanCount = getSpanCount(recyclerView);
            int itemCount = recyclerView.getAdapter().getItemCount();
            int viewPosition = ((RecyclerView.LayoutParams) view.getLayoutParams()).getViewPosition();
            if (isLastRaw(recyclerView, viewPosition, this.spanCount, itemCount) && !this.mDivideParams.isShowBottomDivideInLastRow) {
                rect.set(0, 0, this.mDivideDrawable.getIntrinsicWidth(), 0);
                return;
            }
            if (isLastColum(recyclerView, viewPosition, this.spanCount, itemCount) && !this.mDivideParams.isShowRightDivideInLastColumn) {
                rect.set(0, 0, 0, this.mDivideDrawable.getIntrinsicHeight());
                return;
            }
            if (isFirstRaw(recyclerView, viewPosition, this.spanCount, itemCount)) {
                DivideParams divideParams = this.mDivideParams;
                if (divideParams.isShowTopDivideInFirstColumn) {
                    if (divideParams.isShowVerticalDivide) {
                        i3 = this.mDivideDrawable.getIntrinsicHeight();
                    } else {
                        i3 = 0;
                    }
                    if (this.mDivideParams.isShowHorizontalDivide) {
                        i4 = this.mDivideDrawable.getIntrinsicWidth();
                    } else {
                        i4 = 0;
                    }
                    if (this.mDivideParams.isShowVerticalDivide) {
                        i5 = this.mDivideDrawable.getIntrinsicHeight();
                    } else {
                        i5 = 0;
                    }
                    rect.set(0, i3, i4, i5);
                    return;
                }
            }
            if (this.mDivideParams.isShowHorizontalDivide) {
                i = this.mDivideDrawable.getIntrinsicWidth();
            } else {
                i = 0;
            }
            if (this.mDivideParams.isShowVerticalDivide) {
                i2 = this.mDivideDrawable.getIntrinsicHeight();
            } else {
                i2 = 0;
            }
            rect.set(0, 0, i, i2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        if (this.mDivideParams != null && this.mDivideDrawable != null) {
            this.childCount = recyclerView.getChildCount();
            this.spanCount = getSpanCount(recyclerView);
            drawDivide(canvas, recyclerView);
        }
    }

    /* loaded from: classes8.dex */
    public static final class DivideParams {
        int dividePaddingItemBottom;
        int dividePaddingItemLeft;
        int dividePaddingItemRight;
        int dividePaddingItemTop;
        public ArrayList<SpecialDivideParams> mSpecialDivideParams;
        public boolean isShowHorizontalDivide = true;
        public boolean isShowVerticalDivide = true;
        public boolean isShowBottomDivideInLastRow = false;
        public boolean isShowRightDivideInLastColumn = false;
        public boolean isShowTopDivideInFirstColumn = false;

        /* loaded from: classes8.dex */
        public static final class SpecialDivideParams {
            public int columNum;
            public int dividePaddingItemBottom;
            public int dividePaddingItemLeft;
            public int dividePaddingItemRight;
            public int dividePaddingItemTop;
            public int rowNum;
        }

        public DivideParams(int i, int i2) {
            this.dividePaddingItemLeft = i < 0 ? 0 : i;
            this.dividePaddingItemRight = i < 0 ? 0 : i;
            this.dividePaddingItemTop = i2 < 0 ? 0 : i2;
            this.dividePaddingItemBottom = i2 < 0 ? 0 : i2;
        }

        public DivideParams(int i, int i2, int i3, int i4) {
            this.dividePaddingItemLeft = i < 0 ? 0 : i;
            this.dividePaddingItemRight = i2 < 0 ? 0 : i2;
            this.dividePaddingItemTop = i3 < 0 ? 0 : i3;
            this.dividePaddingItemBottom = i4 < 0 ? 0 : i4;
        }
    }
}
