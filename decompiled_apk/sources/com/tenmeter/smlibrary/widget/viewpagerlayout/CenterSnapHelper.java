package com.tenmeter.smlibrary.widget.viewpagerlayout;

import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import androidx.recyclerview.widget.RecyclerView;
import com.tenmeter.smlibrary.widget.viewpagerlayout.ViewPagerLayoutManager;

/* loaded from: classes13.dex */
public class CenterSnapHelper extends RecyclerView.OnFlingListener {
    Scroller mGravityScroller;
    RecyclerView mRecyclerView;
    private boolean snapToCenter = false;
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.tenmeter.smlibrary.widget.viewpagerlayout.CenterSnapHelper.1
        boolean mScrolled = false;

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            ViewPagerLayoutManager viewPagerLayoutManager = (ViewPagerLayoutManager) recyclerView.getLayoutManager();
            ViewPagerLayoutManager.OnPageChangeListener onPageChangeListener = viewPagerLayoutManager.onPageChangeListener;
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageScrollStateChanged(i);
            }
            if (i == 0 && this.mScrolled) {
                this.mScrolled = false;
                if (!CenterSnapHelper.this.snapToCenter) {
                    CenterSnapHelper.this.snapToCenter = true;
                    CenterSnapHelper.this.snapToCenterView(viewPagerLayoutManager, onPageChangeListener);
                } else {
                    CenterSnapHelper.this.snapToCenter = false;
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            if (i != 0 || i2 != 0) {
                this.mScrolled = true;
            }
        }
    };

    public void attachToRecyclerView(RecyclerView recyclerView) throws IllegalStateException {
        RecyclerView recyclerView2 = this.mRecyclerView;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            destroyCallbacks();
        }
        this.mRecyclerView = recyclerView;
        if (recyclerView != null) {
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (!(layoutManager instanceof ViewPagerLayoutManager)) {
                return;
            }
            setupCallbacks();
            this.mGravityScroller = new Scroller(this.mRecyclerView.getContext(), new DecelerateInterpolator());
            ViewPagerLayoutManager viewPagerLayoutManager = (ViewPagerLayoutManager) layoutManager;
            snapToCenterView(viewPagerLayoutManager, viewPagerLayoutManager.onPageChangeListener);
        }
    }

    public void destroyCallbacks() {
        this.mRecyclerView.removeOnScrollListener(this.mScrollListener);
        this.mRecyclerView.setOnFlingListener(null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnFlingListener
    public boolean onFling(int i, int i2) {
        int i3;
        int i4;
        ViewPagerLayoutManager viewPagerLayoutManager = (ViewPagerLayoutManager) this.mRecyclerView.getLayoutManager();
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
            int finalY = (int) ((this.mGravityScroller.getFinalY() / viewPagerLayoutManager.mInterval) / viewPagerLayoutManager.getDistanceRatio());
            RecyclerView recyclerView = this.mRecyclerView;
            if (viewPagerLayoutManager.getReverseLayout()) {
                i4 = (-currentPositionOffset) - finalY;
            } else {
                i4 = currentPositionOffset + finalY;
            }
            ScrollHelper.smoothScrollToPosition(recyclerView, viewPagerLayoutManager, i4);
            return true;
        }
        if (viewPagerLayoutManager.mOrientation == 0 && Math.abs(i) > minFlingVelocity) {
            int currentPositionOffset2 = viewPagerLayoutManager.getCurrentPositionOffset();
            int finalX = (int) ((this.mGravityScroller.getFinalX() / viewPagerLayoutManager.mInterval) / viewPagerLayoutManager.getDistanceRatio());
            RecyclerView recyclerView2 = this.mRecyclerView;
            if (viewPagerLayoutManager.getReverseLayout()) {
                i3 = (-currentPositionOffset2) - finalX;
            } else {
                i3 = currentPositionOffset2 + finalX;
            }
            ScrollHelper.smoothScrollToPosition(recyclerView2, viewPagerLayoutManager, i3);
        }
        return true;
    }

    public void setupCallbacks() throws IllegalStateException {
        if (this.mRecyclerView.getOnFlingListener() == null) {
            this.mRecyclerView.addOnScrollListener(this.mScrollListener);
            this.mRecyclerView.setOnFlingListener(this);
            return;
        }
        throw new IllegalStateException("An instance of OnFlingListener already set.");
    }

    public void snapToCenterView(ViewPagerLayoutManager viewPagerLayoutManager, ViewPagerLayoutManager.OnPageChangeListener onPageChangeListener) {
        int offsetToCenter = viewPagerLayoutManager.getOffsetToCenter();
        if (offsetToCenter != 0) {
            if (viewPagerLayoutManager.getOrientation() == 1) {
                this.mRecyclerView.smoothScrollBy(0, offsetToCenter);
            } else {
                this.mRecyclerView.smoothScrollBy(offsetToCenter, 0);
            }
        } else {
            this.snapToCenter = false;
        }
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageSelected(viewPagerLayoutManager.getCurrentPosition());
        }
    }
}
