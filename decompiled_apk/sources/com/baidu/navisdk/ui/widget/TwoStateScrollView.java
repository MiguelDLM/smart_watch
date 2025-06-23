package com.baidu.navisdk.ui.widget;

import XIXIX.OOXIXo;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Scroller;
import com.baidu.navisdk.util.common.g;

/* loaded from: classes8.dex */
public class TwoStateScrollView extends LinearLayout {
    private static final String TAG = "com.baidu.navisdk.ui.widget.TwoStateScrollView";
    public int blankSpaceHeight;
    public int bottomMargin;
    boolean enableBg;
    boolean enableBottomAnim;
    boolean enableTitleAnim;
    public int foldableHeight;
    private boolean gotoFlag;
    public boolean hasActionDown;
    boolean hasMoveScroll;
    private boolean heightsInited;
    protected boolean isNotInterruptBlankTouchEvent;
    public boolean isScrolling;
    private int mBottomAnimHeight;
    private View mBottomView;
    private int mBottomViewHeight;
    private EventCatchListener mEventCatchListener;
    public int mLastY;
    private OnStatusChangeListener mOnStatusChangeListener;
    private OnUpdateStatusValueListener mOnUpdateStatusValueListener;
    private int mScrollEnd;
    public int mScrollStart;
    public Scroller mScroller;
    private int mTitleAnimHeight;
    private View mTitleContainer;
    private VelocityTracker mVelocityTracker;
    private View mViewBg;
    public boolean needScroll;
    private boolean needStatusChangeAlways;
    public int persistantHeight;
    public DragState status;
    boolean statusChange;
    public int topMargin;

    /* loaded from: classes8.dex */
    public enum DragState {
        TOP,
        BOTTOM
    }

    /* loaded from: classes8.dex */
    public interface EventCatchListener {
        void onEventCatch(MotionEvent motionEvent);
    }

    /* loaded from: classes8.dex */
    public interface OnStatusChangeListener {
        void onStatusChange(DragState dragState);
    }

    /* loaded from: classes8.dex */
    public interface OnUpdateStatusValueListener {
        void onUpdateStatusValue(int i);
    }

    public TwoStateScrollView(Context context) {
        this(context, null);
        this.mScroller = new Scroller(context);
    }

    private void checkBottomAnimHeight() {
        int i = this.mBottomAnimHeight;
        int i2 = this.blankSpaceHeight;
        if (i > i2) {
            this.mBottomAnimHeight = i2;
        }
    }

    private void checkTitleAnimHeight() {
        int i = this.mTitleAnimHeight;
        int i2 = this.blankSpaceHeight;
        if (i > i2) {
            this.mTitleAnimHeight = i2;
        }
    }

    private int getVelocity() {
        this.mVelocityTracker.computeCurrentVelocity(1000);
        return (int) this.mVelocityTracker.getYVelocity();
    }

    private void onScrollChanged(int i) {
        int i2;
        View view;
        View view2;
        int i3;
        g gVar = g.UGC;
        if (gVar.d()) {
            gVar.e(TAG, "onScrollChanged: currScrollY --> " + i);
        }
        OnUpdateStatusValueListener onUpdateStatusValueListener = this.mOnUpdateStatusValueListener;
        if (onUpdateStatusValueListener != null) {
            onUpdateStatusValueListener.onUpdateStatusValue((int) ((((r4 + i) * 1.0d) / this.foldableHeight) * 100.0d));
        }
        if (i <= 0) {
            i2 = -i;
        } else {
            i2 = 0;
        }
        boolean z = this.enableTitleAnim;
        double d = OOXIXo.f3760XO;
        if (z && this.mTitleContainer != null && (i3 = this.mTitleAnimHeight) > 0) {
            double d2 = 1.0d - ((i2 * 1.0d) / i3);
            if (gVar.d()) {
                gVar.e(TAG, "onScrollChanged: remainingPercentage --> " + d2);
            }
            if (d2 < OOXIXo.f3760XO) {
                d2 = 0.0d;
            }
            this.mTitleContainer.setAlpha((float) d2);
            this.mTitleContainer.invalidate();
        }
        if (this.enableBg && (view2 = this.mViewBg) != null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            layoutParams.height = getMeasuredHeight() - i2;
            this.mViewBg.setLayoutParams(layoutParams);
        }
        if (this.enableBottomAnim && (view = this.mBottomView) != null && this.mBottomViewHeight > 0) {
            view.setVisibility(0);
            double d3 = 1.0d - ((i2 * 1.0d) / this.mBottomAnimHeight);
            if (gVar.d()) {
                gVar.e(TAG, "onScrollChanged: remainingPercentage2 --> " + d3);
            }
            if (d3 >= OOXIXo.f3760XO) {
                d = d3;
            }
            int i4 = (int) (d * this.mBottomViewHeight);
            if (gVar.d()) {
                gVar.e(TAG, "onScrollChanged: marginBottom --> " + i4 + ", bottomBarMarginB: " + (this.mBottomViewHeight - i4));
            }
            ViewGroup.LayoutParams layoutParams2 = this.mBottomView.getLayoutParams();
            if (layoutParams2 != null && (layoutParams2 instanceof ViewGroup.MarginLayoutParams)) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams2;
                marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, -(this.mBottomViewHeight - i4));
                this.mBottomView.setLayoutParams(layoutParams2);
                this.mBottomView.invalidate();
                setBottomMargin(i4);
                invalidate();
            }
        }
    }

    private void recycleVelocity() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        super.computeScroll();
        if (this.mScroller.computeScrollOffset()) {
            int currY = this.mScroller.getCurrY();
            scrollTo(0, currY);
            g gVar = g.UGC;
            if (gVar.d()) {
                gVar.e(TAG, "computeScroll: scrollTo: y --> " + currY);
            }
            invalidate();
            onScrollChanged(currY);
            return;
        }
        if (this.statusChange) {
            if (getScrollY() < (-this.foldableHeight) / 2) {
                OnStatusChangeListener onStatusChangeListener = this.mOnStatusChangeListener;
                if (onStatusChangeListener != null && !this.gotoFlag) {
                    onStatusChangeListener.onStatusChange(DragState.BOTTOM);
                }
                this.status = DragState.BOTTOM;
            } else {
                OnStatusChangeListener onStatusChangeListener2 = this.mOnStatusChangeListener;
                if (onStatusChangeListener2 != null && !this.gotoFlag) {
                    onStatusChangeListener2.onStatusChange(DragState.TOP);
                }
                this.status = DragState.TOP;
            }
            g gVar2 = g.UGC;
            if (gVar2.d()) {
                gVar2.e(TAG, "computeScroll: onStatusChange --> status: " + this.status + ", gotoFlag: " + this.gotoFlag + ", scrollY: " + getScrollY());
            }
            this.statusChange = false;
        }
        this.isScrolling = false;
        if (this.hasMoveScroll) {
            g gVar3 = g.UGC;
            if (gVar3.d()) {
                gVar3.e(TAG, "computeScroll: hasMoveScroll --> " + this.hasMoveScroll + ", status: " + this.status);
            }
            if (this.status == DragState.BOTTOM) {
                scrollTo(0, -this.foldableHeight);
                onScrollChanged(-this.foldableHeight);
            } else {
                scrollTo(0, 0);
                onScrollChanged(0);
            }
            this.hasMoveScroll = false;
            if (this.needStatusChangeAlways) {
                this.statusChange = true;
            }
        }
        this.gotoFlag = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        super.dispatchTouchEvent(motionEvent);
        EventCatchListener eventCatchListener = this.mEventCatchListener;
        if (eventCatchListener != null) {
            eventCatchListener.onEventCatch(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public DragState getCurStatus() {
        return this.status;
    }

    public int getFoldableHeight() {
        return this.foldableHeight;
    }

    public int getTopMargin() {
        return this.topMargin;
    }

    public boolean goToBottom() {
        return goToBottom(250);
    }

    public boolean goToTop() {
        return goToTop(250);
    }

    public void obtainVelocity(MotionEvent motionEvent) {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.needScroll) {
            return super.onTouchEvent(motionEvent);
        }
        if (this.isScrolling) {
            super.onTouchEvent(motionEvent);
            g gVar = g.UGC;
            if (gVar.d()) {
                gVar.e(TAG, "onTouchEvent: isScrolling --> " + this.isScrolling);
            }
            return true;
        }
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction();
        obtainVelocity(motionEvent);
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    if (!this.mScroller.isFinished()) {
                        this.mScroller.abortAnimation();
                    }
                    int i = this.mLastY - y;
                    int scrollY = getScrollY();
                    g gVar2 = g.UGC;
                    if (gVar2.d()) {
                        gVar2.e(TAG, "onTouchEvent: --> ACTION_MOVE: dy:" + i + ", scrollY " + scrollY);
                    }
                    if (i > 0 && i + scrollY > 0) {
                        if (gVar2.d()) {
                            gVar2.e(TAG, "onTouchEvent: --> break ACTION_MOVE 1: dy: " + i + ", scrollY: " + scrollY);
                        }
                    } else if ((-scrollY) - i > this.foldableHeight) {
                        if (gVar2.d()) {
                            gVar2.e(TAG, "onTouchEvent: --> break ACTION_MOVE 2: dy: " + i + ", scrollY: " + scrollY);
                        }
                    } else {
                        onScrollChanged(scrollY);
                        scrollBy(0, i);
                        this.mLastY = y;
                    }
                }
            } else if (this.hasActionDown) {
                this.hasActionDown = false;
                int scrollY2 = getScrollY();
                this.mScrollEnd = scrollY2;
                int i2 = scrollY2 - this.mScrollStart;
                g gVar3 = g.UGC;
                if (gVar3.d()) {
                    gVar3.e(TAG, "onTouchEvent: --> ACTION_UP: mScrollEnd: " + this.mScrollEnd + ", mScrollStart: " + this.mScrollStart + ", dScrollY: " + i2);
                }
                DragState dragState = this.status;
                DragState dragState2 = DragState.TOP;
                if (dragState == dragState2) {
                    int i3 = -(this.mScrollEnd - this.mScrollStart);
                    int i4 = this.foldableHeight;
                    if (i3 > i4 / 3) {
                        int i5 = -(i4 + i2);
                        if (gVar3.d()) {
                            gVar3.e(TAG, "onTouchEvent: startScroll 1 --> from: " + getScrollY() + ", scrollDistance: " + i5);
                        }
                        if (i5 != 0) {
                            this.mScroller.startScroll(0, getScrollY(), 0, i5);
                            this.status = DragState.BOTTOM;
                            this.statusChange = true;
                            this.hasMoveScroll = true;
                            this.isScrolling = true;
                            postInvalidate();
                            recycleVelocity();
                        }
                    } else {
                        int i6 = -i2;
                        if (gVar3.d()) {
                            gVar3.e(TAG, "onTouchEvent: startScroll 2 --> from: " + getScrollY() + ", scrollDistance: " + i6);
                        }
                        if (i6 != 0) {
                            this.mScroller.startScroll(0, getScrollY(), 0, i6);
                            this.hasMoveScroll = true;
                            this.isScrolling = true;
                            postInvalidate();
                            recycleVelocity();
                        }
                    }
                } else {
                    int i7 = this.mScrollEnd - this.mScrollStart;
                    int i8 = this.foldableHeight;
                    if (i7 > i8 / 3) {
                        int i9 = i8 - i2;
                        if (gVar3.d()) {
                            gVar3.e(TAG, "onTouchEvent: startScroll 3 --> from: " + getScrollY() + ", scrollDistance: " + i9);
                        }
                        if (i9 != 0) {
                            this.status = dragState2;
                            this.statusChange = true;
                            this.hasMoveScroll = true;
                            this.mScroller.startScroll(0, getScrollY(), 0, i9);
                            this.isScrolling = true;
                            postInvalidate();
                            recycleVelocity();
                        }
                    } else {
                        int i10 = -i2;
                        if (gVar3.d()) {
                            gVar3.e(TAG, "onTouchEvent: startScroll 4 --> from: " + getScrollY() + ", scrollDistance: " + i10);
                        }
                        if (i10 != 0) {
                            this.mScroller.startScroll(0, getScrollY(), 0, i10);
                            this.hasMoveScroll = true;
                            this.isScrolling = true;
                            postInvalidate();
                            recycleVelocity();
                        }
                    }
                }
            }
        } else {
            int scrollY3 = getScrollY();
            this.mScrollStart = scrollY3;
            if (scrollY3 < (-this.foldableHeight) / 2) {
                this.status = DragState.BOTTOM;
            } else {
                this.status = DragState.TOP;
            }
            g gVar4 = g.UGC;
            if (gVar4.d()) {
                gVar4.e(TAG, "onTouchEvent: --> ACTION_DOWN: status:" + this.status + ", mScrollStart " + this.mScrollStart);
            }
            if (this.status == DragState.BOTTOM) {
                if (y < this.blankSpaceHeight) {
                    if (this.isNotInterruptBlankTouchEvent) {
                        return super.onTouchEvent(motionEvent);
                    }
                    if (gVar4.d()) {
                        gVar4.e(TAG, "onTouchEvent: --> return status_bottom: " + y);
                    }
                    return false;
                }
            } else if (y < (getMeasuredHeight() - this.persistantHeight) - this.foldableHeight) {
                if (gVar4.d()) {
                    gVar4.e(TAG, "onTouchEvent: --> return status_top: " + y);
                }
                return false;
            }
            this.hasActionDown = true;
            this.mLastY = y;
        }
        return true;
    }

    public void setBottomMargin(int i) {
        this.bottomMargin = i;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null && (layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, i);
            setLayoutParams(layoutParams);
        }
    }

    public void setBottomView(View view, int i, int i2) {
        this.mBottomView = view;
        this.mBottomViewHeight = i;
        this.mBottomAnimHeight = i2;
        if (this.heightsInited) {
            checkBottomAnimHeight();
        }
    }

    public void setEnableBg(boolean z) {
        this.enableBg = z;
    }

    public void setEnableBottomAnim(boolean z) {
        this.enableBottomAnim = z;
    }

    public void setHeights(int i, int i2) {
        this.persistantHeight = i;
        int i3 = i2 - i;
        this.blankSpaceHeight = i3;
        this.foldableHeight = i3;
        checkTitleAnimHeight();
        checkBottomAnimHeight();
        this.heightsInited = true;
        g gVar = g.UGC;
        if (gVar.d()) {
            gVar.e(TAG, "setHeights: --> foldableHeight: " + this.foldableHeight + ", persistantHeight: " + i + ", blankSpaceHeight: " + this.blankSpaceHeight);
        }
    }

    public void setNeedStatusChangeAlways(boolean z) {
        this.needStatusChangeAlways = z;
    }

    public void setNotInterruptBlankTouchEvent(boolean z) {
        this.isNotInterruptBlankTouchEvent = z;
    }

    public void setOnEventCatchListener(EventCatchListener eventCatchListener) {
        this.mEventCatchListener = eventCatchListener;
    }

    public void setOnStatusChangeListener(OnStatusChangeListener onStatusChangeListener) {
        this.mOnStatusChangeListener = onStatusChangeListener;
    }

    public void setOnUpdateStatusValueListener(OnUpdateStatusValueListener onUpdateStatusValueListener) {
        this.mOnUpdateStatusValueListener = onUpdateStatusValueListener;
    }

    public void setScrollSupport(boolean z) {
        this.needScroll = z;
        g gVar = g.UGC;
        if (gVar.d()) {
            gVar.e(TAG, "setScrollSupport : needScroll --> " + z);
        }
    }

    public void setTitleAnimEnabled(boolean z) {
        this.enableTitleAnim = z;
    }

    public void setTitleView(View view, int i) {
        this.mTitleContainer = view;
        this.mTitleAnimHeight = i;
        if (this.heightsInited) {
            checkTitleAnimHeight();
        }
    }

    public void setTopMargin(int i) {
        this.topMargin = i;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null && (layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, i, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
            setLayoutParams(layoutParams);
        }
    }

    public void setViewBg(View view) {
        this.mViewBg = view;
    }

    public boolean goToBottom(int i) {
        g gVar = g.UGC;
        if (gVar.d()) {
            gVar.e(TAG, "goToBottom: " + i);
        }
        if (!this.heightsInited) {
            if (gVar.d()) {
                gVar.e(TAG, "goToBottom: heightsInited --> " + this.heightsInited);
            }
            return false;
        }
        if (this.status == DragState.BOTTOM) {
            if (gVar.d()) {
                gVar.e(TAG, "goToBottom: status already --> " + this.status);
            }
            return false;
        }
        Scroller scroller = this.mScroller;
        if (scroller != null) {
            scroller.startScroll(0, getScrollY(), 0, -this.foldableHeight, i);
            this.statusChange = true;
            this.isScrolling = true;
            this.gotoFlag = true;
            this.hasMoveScroll = true;
            postInvalidate();
        }
        return true;
    }

    public boolean goToTop(int i) {
        g gVar = g.UGC;
        if (gVar.d()) {
            gVar.e(TAG, "goToTop: " + i);
        }
        if (!this.heightsInited) {
            if (gVar.d()) {
                gVar.e(TAG, "gotoTop: heightsInited --> " + this.heightsInited);
            }
            return false;
        }
        if (this.status == DragState.TOP) {
            if (gVar.d()) {
                gVar.e(TAG, "gotoTop: status already --> " + this.status);
            }
            return false;
        }
        Scroller scroller = this.mScroller;
        if (scroller != null) {
            scroller.startScroll(0, getScrollY(), 0, this.foldableHeight, i);
            this.statusChange = true;
            this.isScrolling = true;
            this.gotoFlag = true;
            this.hasMoveScroll = true;
            postInvalidate();
        }
        return true;
    }

    public TwoStateScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.foldableHeight = 0;
        this.heightsInited = false;
        this.statusChange = false;
        this.needScroll = false;
        this.hasMoveScroll = false;
        this.enableTitleAnim = false;
        this.enableBg = false;
        this.enableBottomAnim = false;
        this.gotoFlag = false;
        this.needStatusChangeAlways = false;
        this.hasActionDown = false;
        this.topMargin = 0;
        this.bottomMargin = 0;
        this.status = DragState.TOP;
        this.mEventCatchListener = null;
        this.mScroller = new Scroller(context);
    }

    public TwoStateScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.foldableHeight = 0;
        this.heightsInited = false;
        this.statusChange = false;
        this.needScroll = false;
        this.hasMoveScroll = false;
        this.enableTitleAnim = false;
        this.enableBg = false;
        this.enableBottomAnim = false;
        this.gotoFlag = false;
        this.needStatusChangeAlways = false;
        this.hasActionDown = false;
        this.topMargin = 0;
        this.bottomMargin = 0;
        this.status = DragState.TOP;
        this.mEventCatchListener = null;
        this.mScroller = new Scroller(context);
    }
}
