package com.tenmeter.smlibrary.widget.viewpagerlayout;

import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes13.dex */
public class PageSnapHelper extends CenterSnapHelper {
    @Override // com.tenmeter.smlibrary.widget.viewpagerlayout.CenterSnapHelper, androidx.recyclerview.widget.RecyclerView.OnFlingListener
    public boolean onFling(int i, int i2) {
        int i3;
        int i4;
        ViewPagerLayoutManager viewPagerLayoutManager = (ViewPagerLayoutManager) this.mRecyclerView.getLayoutManager();
        int i5 = 0;
        if (viewPagerLayoutManager == null || this.mRecyclerView.getAdapter() == null) {
            return false;
        }
        if (!viewPagerLayoutManager.getInfinite() && (viewPagerLayoutManager.mOffset == viewPagerLayoutManager.getMaxOffset() || viewPagerLayoutManager.mOffset == viewPagerLayoutManager.getMinOffset())) {
            return false;
        }
        int minFlingVelocity = this.mRecyclerView.getMinFlingVelocity();
        this.mGravityScroller.fling(0, 0, i, i2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        if (viewPagerLayoutManager.mOrientation == 1 && Math.abs(i2) > minFlingVelocity) {
            int currentPositionOffset = viewPagerLayoutManager.getCurrentPositionOffset();
            if (this.mGravityScroller.getFinalY() * viewPagerLayoutManager.getDistanceRatio() > viewPagerLayoutManager.mInterval) {
                i5 = 1;
            }
            RecyclerView recyclerView = this.mRecyclerView;
            if (viewPagerLayoutManager.getReverseLayout()) {
                i4 = (-currentPositionOffset) - i5;
            } else {
                i4 = currentPositionOffset + i5;
            }
            ScrollHelper.smoothScrollToPosition(recyclerView, viewPagerLayoutManager, i4);
            return true;
        }
        if (viewPagerLayoutManager.mOrientation == 0 && Math.abs(i) > minFlingVelocity) {
            int currentPositionOffset2 = viewPagerLayoutManager.getCurrentPositionOffset();
            if (this.mGravityScroller.getFinalX() * viewPagerLayoutManager.getDistanceRatio() > viewPagerLayoutManager.mInterval) {
                i5 = 1;
            }
            RecyclerView recyclerView2 = this.mRecyclerView;
            if (viewPagerLayoutManager.getReverseLayout()) {
                i3 = (-currentPositionOffset2) - i5;
            } else {
                i3 = currentPositionOffset2 + i5;
            }
            ScrollHelper.smoothScrollToPosition(recyclerView2, viewPagerLayoutManager, i3);
        }
        return true;
    }
}
