package com.tenmeter.smlibrary.widget.viewpagerlayout;

import android.os.Handler;
import android.os.Looper;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes13.dex */
class AutoPlaySnapHelper extends CenterSnapHelper {
    static final int LEFT = 1;
    static final int RIGHT = 2;
    static final int TIME_INTERVAL = 2000;
    private Runnable autoPlayRunnable;
    private int direction;
    private Handler handler;
    private boolean runnableAdded;
    private int timeInterval;

    public AutoPlaySnapHelper(int i, int i2) {
        checkTimeInterval(i);
        checkDirection(i2);
        this.handler = new Handler(Looper.getMainLooper());
        this.timeInterval = i;
        this.direction = i2;
    }

    private void checkDirection(int i) {
        if (i != 1 && i != 2) {
            throw new IllegalArgumentException("direction should be one of left or right");
        }
    }

    private void checkTimeInterval(int i) {
        if (i > 0) {
        } else {
            throw new IllegalArgumentException("time interval should greater than 0");
        }
    }

    @Override // com.tenmeter.smlibrary.widget.viewpagerlayout.CenterSnapHelper
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
            final RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (!(layoutManager instanceof ViewPagerLayoutManager)) {
                return;
            }
            setupCallbacks();
            this.mGravityScroller = new Scroller(this.mRecyclerView.getContext(), new DecelerateInterpolator());
            ViewPagerLayoutManager viewPagerLayoutManager = (ViewPagerLayoutManager) layoutManager;
            snapToCenterView(viewPagerLayoutManager, viewPagerLayoutManager.onPageChangeListener);
            viewPagerLayoutManager.setInfinite(true);
            Runnable runnable = new Runnable() { // from class: com.tenmeter.smlibrary.widget.viewpagerlayout.AutoPlaySnapHelper.1
                @Override // java.lang.Runnable
                public void run() {
                    int i;
                    int i2;
                    int currentPositionOffset = ((ViewPagerLayoutManager) layoutManager).getCurrentPositionOffset();
                    if (((ViewPagerLayoutManager) layoutManager).getReverseLayout()) {
                        i = -1;
                    } else {
                        i = 1;
                    }
                    int i3 = currentPositionOffset * i;
                    AutoPlaySnapHelper autoPlaySnapHelper = AutoPlaySnapHelper.this;
                    RecyclerView recyclerView3 = autoPlaySnapHelper.mRecyclerView;
                    ViewPagerLayoutManager viewPagerLayoutManager2 = (ViewPagerLayoutManager) layoutManager;
                    if (autoPlaySnapHelper.direction == 2) {
                        i2 = i3 + 1;
                    } else {
                        i2 = i3 - 1;
                    }
                    ScrollHelper.smoothScrollToPosition(recyclerView3, viewPagerLayoutManager2, i2);
                    AutoPlaySnapHelper.this.handler.postDelayed(AutoPlaySnapHelper.this.autoPlayRunnable, AutoPlaySnapHelper.this.timeInterval);
                }
            };
            this.autoPlayRunnable = runnable;
            this.handler.postDelayed(runnable, this.timeInterval);
            this.runnableAdded = true;
        }
    }

    @Override // com.tenmeter.smlibrary.widget.viewpagerlayout.CenterSnapHelper
    public void destroyCallbacks() {
        super.destroyCallbacks();
        if (this.runnableAdded) {
            this.handler.removeCallbacks(this.autoPlayRunnable);
            this.runnableAdded = false;
        }
    }

    public void pause() {
        if (this.runnableAdded) {
            this.handler.removeCallbacks(this.autoPlayRunnable);
            this.runnableAdded = false;
        }
    }

    public void setDirection(int i) {
        checkDirection(i);
        this.direction = i;
    }

    public void setTimeInterval(int i) {
        checkTimeInterval(i);
        this.timeInterval = i;
    }

    public void start() {
        if (!this.runnableAdded) {
            this.handler.postDelayed(this.autoPlayRunnable, this.timeInterval);
            this.runnableAdded = true;
        }
    }
}
