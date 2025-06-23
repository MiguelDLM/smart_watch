package com.baidu.mapclient.liteapp.custom;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.Scroller;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.baidu.mapclient.liteapp.custom.BNScrollView;
import com.szabh.navi.R;

/* loaded from: classes7.dex */
public class BNScrollLayout extends FrameLayout {
    private static final float DRAG_SPEED_MULTIPLIER = 1.2f;
    private static final int DRAG_SPEED_SLOP = 30;
    private static final int FLING_VELOCITY_SLOP = 80;
    private static final int MAX_SCROLL_DURATION = 400;
    private static final int MIN_SCROLL_DURATION = 100;
    private static final int MOTION_DISTANCE_SLOP = 10;
    private static final float SCROLL_TO_CLOSE_OFFSET_FACTOR = 0.5f;
    private static final float SCROLL_TO_EXIT_OFFSET_FACTOR = 0.8f;
    private final AbsListView.OnScrollListener associatedListViewListener;
    private final RecyclerView.OnScrollListener associatedRecyclerViewListener;
    private InnerStatus currentInnerStatus;
    private int exitOffset;
    private GestureDetector gestureDetector;
    private final GestureDetector.OnGestureListener gestureListener;
    private boolean isAllowHorizontalScroll;
    private boolean isAllowPointerIntercepted;
    private boolean isCurrentPointerIntercepted;
    private boolean isDraggable;
    private boolean isEnable;
    private boolean isSupportExit;
    private float lastDownX;
    private float lastDownY;
    private Status lastFlingStatus;
    private float lastX;
    private float lastY;
    private BNScrollView.OnScrollChangedListener mOnScrollChangedListener;
    private BNScrollView mScrollView;
    private int maxOffset;
    public int minOffset;
    private OnScrollChangedListener onScrollChangedListener;
    private Scroller scroller;

    /* loaded from: classes7.dex */
    public enum InnerStatus {
        EXIT,
        OPENED,
        CLOSED,
        MOVING,
        SCROLLING
    }

    /* loaded from: classes7.dex */
    public interface OnScrollChangedListener {
        void onChildScroll(int i);

        void onScrollFinished(Status status);

        void onScrollProgressChanged(float f);
    }

    /* loaded from: classes7.dex */
    public enum Status {
        EXIT,
        OPENED,
        CLOSED
    }

    public BNScrollLayout(Context context) {
        super(context);
        GestureDetector.SimpleOnGestureListener simpleOnGestureListener = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.mapclient.liteapp.custom.BNScrollLayout.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (f2 > 80.0f) {
                    Status status = BNScrollLayout.this.lastFlingStatus;
                    Status status2 = Status.OPENED;
                    if (status.equals(status2) && (-BNScrollLayout.this.getScrollY()) > BNScrollLayout.this.maxOffset) {
                        BNScrollLayout.this.lastFlingStatus = Status.EXIT;
                        BNScrollLayout.this.scrollToExit();
                    } else {
                        BNScrollLayout.this.scrollToOpen();
                        BNScrollLayout.this.lastFlingStatus = status2;
                    }
                    return true;
                }
                if (f2 < 80.0f && BNScrollLayout.this.getScrollY() <= (-BNScrollLayout.this.maxOffset)) {
                    BNScrollLayout.this.scrollToOpen();
                    BNScrollLayout.this.lastFlingStatus = Status.OPENED;
                    return true;
                }
                if (f2 < 80.0f && BNScrollLayout.this.getScrollY() > (-BNScrollLayout.this.maxOffset)) {
                    BNScrollLayout.this.scrollToClose();
                    BNScrollLayout.this.lastFlingStatus = Status.CLOSED;
                    return true;
                }
                return false;
            }
        };
        this.gestureListener = simpleOnGestureListener;
        this.associatedListViewListener = new AbsListView.OnScrollListener() { // from class: com.baidu.mapclient.liteapp.custom.BNScrollLayout.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                BNScrollLayout.this.updateListViewScrollState(absListView);
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                BNScrollLayout.this.updateListViewScrollState(absListView);
            }
        };
        this.associatedRecyclerViewListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.mapclient.liteapp.custom.BNScrollLayout.3
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                BNScrollLayout.this.updateRecyclerViewScrollState(recyclerView);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                BNScrollLayout.this.updateRecyclerViewScrollState(recyclerView);
            }
        };
        this.lastFlingStatus = Status.CLOSED;
        this.isEnable = true;
        this.isSupportExit = false;
        this.isAllowHorizontalScroll = true;
        this.isDraggable = true;
        this.isAllowPointerIntercepted = true;
        this.isCurrentPointerIntercepted = false;
        this.currentInnerStatus = InnerStatus.OPENED;
        this.maxOffset = 0;
        this.minOffset = 0;
        this.exitOffset = 0;
        this.scroller = new Scroller(getContext(), null, true);
        this.gestureDetector = new GestureDetector(getContext(), simpleOnGestureListener);
        this.mOnScrollChangedListener = new BNScrollView.OnScrollChangedListener() { // from class: com.baidu.mapclient.liteapp.custom.BNScrollLayout.4
            @Override // com.baidu.mapclient.liteapp.custom.BNScrollView.OnScrollChangedListener
            public void onScrollChanged(int i, int i2, int i3, int i4) {
                if (BNScrollLayout.this.mScrollView == null) {
                    return;
                }
                if (BNScrollLayout.this.onScrollChangedListener != null) {
                    BNScrollLayout.this.onScrollChangedListener.onChildScroll(i4);
                }
                if (BNScrollLayout.this.mScrollView.getScrollY() == 0) {
                    BNScrollLayout.this.setDraggable(true);
                } else {
                    BNScrollLayout.this.setDraggable(false);
                }
            }
        };
    }

    private void completeMove() {
        float f = -((this.maxOffset - this.minOffset) * 0.5f);
        if (getScrollY() > f) {
            scrollToClose();
            return;
        }
        if (this.isSupportExit) {
            int i = this.exitOffset;
            float f2 = -(((i - r2) * 0.8f) + this.maxOffset);
            if (getScrollY() <= f && getScrollY() > f2) {
                scrollToOpen();
                return;
            } else {
                scrollToExit();
                return;
            }
        }
        scrollToOpen();
    }

    private boolean disposeEdgeValue(int i) {
        if (this.isSupportExit) {
            if (i <= 0 && getScrollY() >= (-this.minOffset)) {
                return true;
            }
            if (i >= 0 && getScrollY() <= (-this.exitOffset)) {
                return true;
            }
            return false;
        }
        if (i <= 0 && getScrollY() >= (-this.minOffset)) {
            return true;
        }
        if (i >= 0 && getScrollY() <= (-this.maxOffset)) {
            return true;
        }
        return false;
    }

    private void initFromAttributes(Context context, AttributeSet attributeSet) {
        int dimensionPixelOffset;
        int dimensionPixelOffset2;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BNScrollLayout);
        int i = R.styleable.BNScrollLayout_maxOffset;
        if (obtainStyledAttributes.hasValue(i) && (dimensionPixelOffset2 = obtainStyledAttributes.getDimensionPixelOffset(i, this.maxOffset)) != getScreenHeight()) {
            this.maxOffset = getScreenHeight() - dimensionPixelOffset2;
        }
        int i2 = R.styleable.BNScrollLayout_minOffset;
        if (obtainStyledAttributes.hasValue(i2)) {
            this.minOffset = obtainStyledAttributes.getDimensionPixelOffset(i2, this.minOffset);
        }
        int i3 = R.styleable.BNScrollLayout_exitOffset;
        if (obtainStyledAttributes.hasValue(i3) && (dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(i3, getScreenHeight())) != getScreenHeight()) {
            this.exitOffset = getScreenHeight() - dimensionPixelOffset;
        }
        int i4 = R.styleable.BNScrollLayout_allowHorizontalScroll;
        if (obtainStyledAttributes.hasValue(i4)) {
            this.isAllowHorizontalScroll = obtainStyledAttributes.getBoolean(i4, true);
        }
        int i5 = R.styleable.BNScrollLayout_isSupportExit;
        if (obtainStyledAttributes.hasValue(i5)) {
            this.isSupportExit = obtainStyledAttributes.getBoolean(i5, true);
        }
        int i6 = R.styleable.BNScrollLayout_mode;
        if (obtainStyledAttributes.hasValue(i6)) {
            int integer = obtainStyledAttributes.getInteger(i6, 0);
            if (integer != 0) {
                if (integer != 1) {
                    if (integer != 2) {
                        setToClosed();
                    } else {
                        setToExit();
                    }
                } else {
                    setToClosed();
                }
            } else {
                setToOpen();
            }
        }
        obtainStyledAttributes.recycle();
    }

    private void onScrollFinished(Status status) {
        OnScrollChangedListener onScrollChangedListener = this.onScrollChangedListener;
        if (onScrollChangedListener != null) {
            onScrollChangedListener.onScrollFinished(status);
        }
    }

    private void onScrollProgressChanged(float f) {
        OnScrollChangedListener onScrollChangedListener = this.onScrollChangedListener;
        if (onScrollChangedListener != null) {
            onScrollChangedListener.onScrollProgressChanged(f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateListViewScrollState(AbsListView absListView) {
        if (absListView.getChildCount() == 0) {
            setDraggable(true);
        } else if (absListView.getFirstVisiblePosition() == 0 && absListView.getChildAt(0).getTop() == absListView.getPaddingTop()) {
            setDraggable(true);
        } else {
            setDraggable(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRecyclerViewScrollState(RecyclerView recyclerView) {
        if (recyclerView.getChildCount() == 0) {
            setDraggable(true);
            return;
        }
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        int[] iArr = new int[1];
        if (!(layoutManager instanceof LinearLayoutManager) && !(layoutManager instanceof GridLayoutManager)) {
            if (layoutManager instanceof StaggeredGridLayoutManager) {
                iArr = ((StaggeredGridLayoutManager) layoutManager).findFirstVisibleItemPositions(null);
            }
        } else {
            iArr[0] = ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
        }
        if (iArr[0] == 0 && recyclerView.getChildAt(0).getTop() == recyclerView.getPaddingTop()) {
            setDraggable(true);
        } else {
            setDraggable(false);
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (!this.scroller.isFinished() && this.scroller.computeScrollOffset()) {
            int currY = this.scroller.getCurrY();
            scrollTo(0, currY);
            if (currY != (-this.minOffset) && currY != (-this.maxOffset) && (!this.isSupportExit || currY != (-this.exitOffset))) {
                invalidate();
            } else {
                this.scroller.abortAnimation();
            }
        }
    }

    public Status getCurrentStatus() {
        int ordinal = this.currentInnerStatus.ordinal();
        if (ordinal != 0) {
            if (ordinal != 1) {
                if (ordinal != 2) {
                    return Status.OPENED;
                }
                return Status.CLOSED;
            }
            return Status.OPENED;
        }
        return Status.EXIT;
    }

    public int getScreenHeight() {
        int i = 0;
        Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        int i2 = displayMetrics.heightPixels;
        try {
            Point point = new Point();
            Display.class.getMethod("getRealSize", Point.class).invoke(defaultDisplay, point);
            i2 = point.y;
        } catch (Exception e) {
            e.printStackTrace();
        }
        Resources resources = getContext().getResources();
        int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            i = resources.getDimensionPixelSize(identifier);
        }
        return i2 - i;
    }

    public boolean isAllowHorizontalScroll() {
        return this.isAllowHorizontalScroll;
    }

    public boolean isDraggable() {
        return this.isDraggable;
    }

    public boolean isSupportExit() {
        return this.isSupportExit;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.isEnable) {
            return false;
        }
        if (!this.isDraggable && this.currentInnerStatus == InnerStatus.CLOSED) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                        return false;
                    }
                } else {
                    if (!this.isAllowPointerIntercepted) {
                        return false;
                    }
                    if (this.isCurrentPointerIntercepted) {
                        return true;
                    }
                    int y = (int) (motionEvent.getY() - this.lastDownY);
                    int x = (int) (motionEvent.getX() - this.lastDownX);
                    if (Math.abs(y) < 10) {
                        return false;
                    }
                    if (Math.abs(y) < Math.abs(x) && this.isAllowHorizontalScroll) {
                        this.isAllowPointerIntercepted = false;
                        this.isCurrentPointerIntercepted = false;
                        return false;
                    }
                    InnerStatus innerStatus = this.currentInnerStatus;
                    if (innerStatus == InnerStatus.CLOSED) {
                        if (y < 0) {
                            return false;
                        }
                    } else if (innerStatus == InnerStatus.OPENED && !this.isSupportExit && y > 0) {
                        return false;
                    }
                    this.isCurrentPointerIntercepted = true;
                    return true;
                }
            }
            this.isAllowPointerIntercepted = true;
            this.isCurrentPointerIntercepted = false;
            if (this.currentInnerStatus == InnerStatus.MOVING) {
                return true;
            }
        } else {
            this.lastX = motionEvent.getX();
            float y2 = motionEvent.getY();
            this.lastY = y2;
            this.lastDownX = this.lastX;
            this.lastDownY = y2;
            this.isAllowPointerIntercepted = true;
            this.isCurrentPointerIntercepted = false;
            if (!this.scroller.isFinished()) {
                this.scroller.forceFinished(true);
                this.currentInnerStatus = InnerStatus.MOVING;
                this.isCurrentPointerIntercepted = true;
                return true;
            }
        }
        return false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.isCurrentPointerIntercepted) {
            return false;
        }
        this.gestureDetector.onTouchEvent(motionEvent);
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                        return false;
                    }
                } else {
                    int y = (int) ((motionEvent.getY() - this.lastY) * DRAG_SPEED_MULTIPLIER);
                    int signum = ((int) Math.signum(y)) * Math.min(Math.abs(y), 30);
                    if (disposeEdgeValue(signum)) {
                        return true;
                    }
                    this.currentInnerStatus = InnerStatus.MOVING;
                    int scrollY = getScrollY() - signum;
                    int i = this.minOffset;
                    if (scrollY >= (-i)) {
                        scrollTo(0, -i);
                    } else {
                        int i2 = this.maxOffset;
                        if (scrollY <= (-i2) && !this.isSupportExit) {
                            scrollTo(0, -i2);
                        } else {
                            scrollTo(0, scrollY);
                        }
                    }
                    this.lastY = motionEvent.getY();
                    return true;
                }
            }
            if (this.currentInnerStatus != InnerStatus.MOVING) {
                return false;
            }
            completeMove();
            return true;
        }
        this.lastY = motionEvent.getY();
        return true;
    }

    @Override // android.view.View
    public void scrollTo(int i, int i2) {
        super.scrollTo(i, i2);
        int i3 = this.maxOffset;
        if (i3 == this.minOffset) {
            return;
        }
        if ((-i2) <= i3) {
            onScrollProgressChanged((r1 - r0) / (i3 - r0));
        } else {
            onScrollProgressChanged((r1 - i3) / (i3 - this.exitOffset));
        }
        if (i2 == (-this.minOffset)) {
            InnerStatus innerStatus = this.currentInnerStatus;
            InnerStatus innerStatus2 = InnerStatus.CLOSED;
            if (innerStatus != innerStatus2) {
                this.currentInnerStatus = innerStatus2;
                onScrollFinished(Status.CLOSED);
                return;
            }
            return;
        }
        if (i2 == (-this.maxOffset)) {
            InnerStatus innerStatus3 = this.currentInnerStatus;
            InnerStatus innerStatus4 = InnerStatus.OPENED;
            if (innerStatus3 != innerStatus4) {
                this.currentInnerStatus = innerStatus4;
                onScrollFinished(Status.OPENED);
                return;
            }
            return;
        }
        if (this.isSupportExit && i2 == (-this.exitOffset)) {
            InnerStatus innerStatus5 = this.currentInnerStatus;
            InnerStatus innerStatus6 = InnerStatus.EXIT;
            if (innerStatus5 != innerStatus6) {
                this.currentInnerStatus = innerStatus6;
                onScrollFinished(Status.EXIT);
            }
        }
    }

    public void scrollToClose() {
        if (this.currentInnerStatus == InnerStatus.CLOSED || this.maxOffset == this.minOffset) {
            return;
        }
        int i = -getScrollY();
        int i2 = this.minOffset;
        int i3 = i - i2;
        if (i3 == 0) {
            return;
        }
        this.currentInnerStatus = InnerStatus.SCROLLING;
        this.scroller.startScroll(0, getScrollY(), 0, i3, Math.abs((i3 * 300) / (this.maxOffset - i2)) + 100);
        invalidate();
    }

    public void scrollToExit() {
        if (!this.isSupportExit || this.currentInnerStatus == InnerStatus.EXIT || this.exitOffset == this.maxOffset) {
            return;
        }
        int i = -getScrollY();
        int i2 = this.exitOffset;
        int i3 = i - i2;
        if (i3 == 0) {
            return;
        }
        this.currentInnerStatus = InnerStatus.SCROLLING;
        this.scroller.startScroll(0, getScrollY(), 0, i3, Math.abs((i3 * 300) / (i2 - this.maxOffset)) + 100);
        invalidate();
    }

    public void scrollToOpen() {
        if (this.currentInnerStatus == InnerStatus.OPENED || this.maxOffset == this.minOffset) {
            return;
        }
        int i = -getScrollY();
        int i2 = this.maxOffset;
        int i3 = i - i2;
        if (i3 == 0) {
            return;
        }
        this.currentInnerStatus = InnerStatus.SCROLLING;
        this.scroller.startScroll(0, getScrollY(), 0, i3, Math.abs((i3 * 300) / (i2 - this.minOffset)) + 100);
        invalidate();
    }

    public void setAllowHorizontalScroll(boolean z) {
        this.isAllowHorizontalScroll = z;
    }

    public void setAssociatedListView(AbsListView absListView) {
        absListView.setOnScrollListener(this.associatedListViewListener);
        updateListViewScrollState(absListView);
    }

    public void setAssociatedRecyclerView(RecyclerView recyclerView) {
        recyclerView.addOnScrollListener(this.associatedRecyclerViewListener);
        updateRecyclerViewScrollState(recyclerView);
    }

    public void setAssociatedScrollView(BNScrollView bNScrollView) {
        this.mScrollView = bNScrollView;
        bNScrollView.setScrollbarFadingEnabled(false);
        this.mScrollView.setOnScrollChangeListener(this.mOnScrollChangedListener);
    }

    public void setDraggable(boolean z) {
        this.isDraggable = z;
    }

    public void setEnable(boolean z) {
        this.isEnable = z;
    }

    public void setExitOffset(int i) {
        this.exitOffset = getScreenHeight() - i;
    }

    public void setIsSupportExit(boolean z) {
        this.isSupportExit = z;
    }

    public void setMaxOffset(int i) {
        this.maxOffset = getScreenHeight() - i;
    }

    public void setMinOffset(int i) {
        this.minOffset = i;
    }

    public void setOnScrollChangedListener(OnScrollChangedListener onScrollChangedListener) {
        this.onScrollChangedListener = onScrollChangedListener;
    }

    public void setToClosed() {
        scrollTo(0, -this.minOffset);
        this.currentInnerStatus = InnerStatus.CLOSED;
        this.lastFlingStatus = Status.CLOSED;
    }

    public void setToExit() {
        if (!this.isSupportExit) {
            return;
        }
        scrollTo(0, -this.exitOffset);
        this.currentInnerStatus = InnerStatus.EXIT;
    }

    public void setToOpen() {
        scrollTo(0, -this.maxOffset);
        this.currentInnerStatus = InnerStatus.OPENED;
        this.lastFlingStatus = Status.OPENED;
    }

    public void showOrHide() {
        InnerStatus innerStatus = this.currentInnerStatus;
        if (innerStatus == InnerStatus.OPENED) {
            scrollToClose();
        } else if (innerStatus == InnerStatus.CLOSED) {
            scrollToOpen();
        }
    }

    public BNScrollLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        GestureDetector.SimpleOnGestureListener simpleOnGestureListener = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.mapclient.liteapp.custom.BNScrollLayout.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (f2 > 80.0f) {
                    Status status = BNScrollLayout.this.lastFlingStatus;
                    Status status2 = Status.OPENED;
                    if (status.equals(status2) && (-BNScrollLayout.this.getScrollY()) > BNScrollLayout.this.maxOffset) {
                        BNScrollLayout.this.lastFlingStatus = Status.EXIT;
                        BNScrollLayout.this.scrollToExit();
                    } else {
                        BNScrollLayout.this.scrollToOpen();
                        BNScrollLayout.this.lastFlingStatus = status2;
                    }
                    return true;
                }
                if (f2 < 80.0f && BNScrollLayout.this.getScrollY() <= (-BNScrollLayout.this.maxOffset)) {
                    BNScrollLayout.this.scrollToOpen();
                    BNScrollLayout.this.lastFlingStatus = Status.OPENED;
                    return true;
                }
                if (f2 < 80.0f && BNScrollLayout.this.getScrollY() > (-BNScrollLayout.this.maxOffset)) {
                    BNScrollLayout.this.scrollToClose();
                    BNScrollLayout.this.lastFlingStatus = Status.CLOSED;
                    return true;
                }
                return false;
            }
        };
        this.gestureListener = simpleOnGestureListener;
        this.associatedListViewListener = new AbsListView.OnScrollListener() { // from class: com.baidu.mapclient.liteapp.custom.BNScrollLayout.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                BNScrollLayout.this.updateListViewScrollState(absListView);
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                BNScrollLayout.this.updateListViewScrollState(absListView);
            }
        };
        this.associatedRecyclerViewListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.mapclient.liteapp.custom.BNScrollLayout.3
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                BNScrollLayout.this.updateRecyclerViewScrollState(recyclerView);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                BNScrollLayout.this.updateRecyclerViewScrollState(recyclerView);
            }
        };
        this.lastFlingStatus = Status.CLOSED;
        this.isEnable = true;
        this.isSupportExit = false;
        this.isAllowHorizontalScroll = true;
        this.isDraggable = true;
        this.isAllowPointerIntercepted = true;
        this.isCurrentPointerIntercepted = false;
        this.currentInnerStatus = InnerStatus.OPENED;
        this.maxOffset = 0;
        this.minOffset = 0;
        this.exitOffset = 0;
        this.scroller = new Scroller(getContext(), null, true);
        this.gestureDetector = new GestureDetector(getContext(), simpleOnGestureListener);
        this.mOnScrollChangedListener = new BNScrollView.OnScrollChangedListener() { // from class: com.baidu.mapclient.liteapp.custom.BNScrollLayout.4
            @Override // com.baidu.mapclient.liteapp.custom.BNScrollView.OnScrollChangedListener
            public void onScrollChanged(int i, int i2, int i3, int i4) {
                if (BNScrollLayout.this.mScrollView == null) {
                    return;
                }
                if (BNScrollLayout.this.onScrollChangedListener != null) {
                    BNScrollLayout.this.onScrollChangedListener.onChildScroll(i4);
                }
                if (BNScrollLayout.this.mScrollView.getScrollY() == 0) {
                    BNScrollLayout.this.setDraggable(true);
                } else {
                    BNScrollLayout.this.setDraggable(false);
                }
            }
        };
        initFromAttributes(context, attributeSet);
    }

    public BNScrollLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        GestureDetector.SimpleOnGestureListener simpleOnGestureListener = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.mapclient.liteapp.custom.BNScrollLayout.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (f2 > 80.0f) {
                    Status status = BNScrollLayout.this.lastFlingStatus;
                    Status status2 = Status.OPENED;
                    if (status.equals(status2) && (-BNScrollLayout.this.getScrollY()) > BNScrollLayout.this.maxOffset) {
                        BNScrollLayout.this.lastFlingStatus = Status.EXIT;
                        BNScrollLayout.this.scrollToExit();
                    } else {
                        BNScrollLayout.this.scrollToOpen();
                        BNScrollLayout.this.lastFlingStatus = status2;
                    }
                    return true;
                }
                if (f2 < 80.0f && BNScrollLayout.this.getScrollY() <= (-BNScrollLayout.this.maxOffset)) {
                    BNScrollLayout.this.scrollToOpen();
                    BNScrollLayout.this.lastFlingStatus = Status.OPENED;
                    return true;
                }
                if (f2 < 80.0f && BNScrollLayout.this.getScrollY() > (-BNScrollLayout.this.maxOffset)) {
                    BNScrollLayout.this.scrollToClose();
                    BNScrollLayout.this.lastFlingStatus = Status.CLOSED;
                    return true;
                }
                return false;
            }
        };
        this.gestureListener = simpleOnGestureListener;
        this.associatedListViewListener = new AbsListView.OnScrollListener() { // from class: com.baidu.mapclient.liteapp.custom.BNScrollLayout.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i22, int i3) {
                BNScrollLayout.this.updateListViewScrollState(absListView);
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                BNScrollLayout.this.updateListViewScrollState(absListView);
            }
        };
        this.associatedRecyclerViewListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.mapclient.liteapp.custom.BNScrollLayout.3
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                super.onScrollStateChanged(recyclerView, i2);
                BNScrollLayout.this.updateRecyclerViewScrollState(recyclerView);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i2, int i22) {
                super.onScrolled(recyclerView, i2, i22);
                BNScrollLayout.this.updateRecyclerViewScrollState(recyclerView);
            }
        };
        this.lastFlingStatus = Status.CLOSED;
        this.isEnable = true;
        this.isSupportExit = false;
        this.isAllowHorizontalScroll = true;
        this.isDraggable = true;
        this.isAllowPointerIntercepted = true;
        this.isCurrentPointerIntercepted = false;
        this.currentInnerStatus = InnerStatus.OPENED;
        this.maxOffset = 0;
        this.minOffset = 0;
        this.exitOffset = 0;
        this.scroller = new Scroller(getContext(), null, true);
        this.gestureDetector = new GestureDetector(getContext(), simpleOnGestureListener);
        this.mOnScrollChangedListener = new BNScrollView.OnScrollChangedListener() { // from class: com.baidu.mapclient.liteapp.custom.BNScrollLayout.4
            @Override // com.baidu.mapclient.liteapp.custom.BNScrollView.OnScrollChangedListener
            public void onScrollChanged(int i2, int i22, int i3, int i4) {
                if (BNScrollLayout.this.mScrollView == null) {
                    return;
                }
                if (BNScrollLayout.this.onScrollChangedListener != null) {
                    BNScrollLayout.this.onScrollChangedListener.onChildScroll(i4);
                }
                if (BNScrollLayout.this.mScrollView.getScrollY() == 0) {
                    BNScrollLayout.this.setDraggable(true);
                } else {
                    BNScrollLayout.this.setDraggable(false);
                }
            }
        };
        initFromAttributes(context, attributeSet);
    }
}
