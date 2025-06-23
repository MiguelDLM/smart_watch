package com.baidu.navisdk.ui.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.LinearLayout;
import android.widget.Scroller;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.function.b;
import com.baidu.navisdk.util.common.LogUtil;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes8.dex */
public class CustomLinearScrollView extends LinearLayout {
    public static final int STATUS_BOTTOM = 1;
    public static final int STATUS_TOP = 0;
    private static final String TAG = "CustomLinearScrollView";
    private int bottomHight;
    private int button;
    private boolean hasMoveScroll;
    private boolean interruptCurTouchEvent;
    private boolean isBreakCallback;
    private boolean isScrolling;
    private EventCatchListener mEventCatchListener;
    private int mFirstInitStatus;
    boolean mIsBeingDragged;
    public boolean mLastEventIsScroll;
    private int mLastY;
    private int mScrollEnd;
    private int mScrollStart;
    private Scroller mScroller;
    private List<OnStatusChangeListener> mStatusChangeListeners;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;
    private boolean needScroll;
    private int status;
    private boolean statusChange;
    private int topHight;

    /* loaded from: classes8.dex */
    public interface EventCatchListener {
        void onEventCatch(MotionEvent motionEvent);
    }

    /* loaded from: classes8.dex */
    public interface OnStatusChangeListener {
        void onProgressChange(int i);

        void onStatusChange(int i);
    }

    public CustomLinearScrollView(Context context) {
        this(context, null);
        initScroller(context);
    }

    private int getVelocity() {
        this.mVelocityTracker.computeCurrentVelocity(1000);
        return (int) this.mVelocityTracker.getYVelocity();
    }

    private void initScroller(Context context) {
        this.mScroller = new Scroller(context);
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    private void obtainVelocity(MotionEvent motionEvent) {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
    }

    private void recycleVelocity() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    private void startScroll(int i, int i2, int i3, int i4) {
        Scroller scroller = this.mScroller;
        if (scroller != null) {
            scroller.startScroll(i, i2, i3, i4);
        }
    }

    public void addOnStatusChangeListener(OnStatusChangeListener onStatusChangeListener) {
        if (!this.mStatusChangeListeners.contains(onStatusChangeListener)) {
            this.mStatusChangeListeners.add(onStatusChangeListener);
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        super.computeScroll();
        if (this.mScroller.computeScrollOffset()) {
            scrollTo(0, this.mScroller.getCurrY());
            invalidate();
            return;
        }
        LogUtil.e(TAG, "computeScroll statusChange :" + this.statusChange);
        if (this.statusChange) {
            if (getScrollY() < (-this.bottomHight) / 2) {
                if (!this.mStatusChangeListeners.isEmpty() && !this.isBreakCallback) {
                    for (int i = 0; i < this.mStatusChangeListeners.size(); i++) {
                        OnStatusChangeListener onStatusChangeListener = this.mStatusChangeListeners.get(i);
                        onStatusChangeListener.onStatusChange(1);
                        onStatusChangeListener.onProgressChange(100);
                    }
                }
                this.status = 1;
                LogUtil.e(TAG, "STATUS_BOTTOM");
            } else {
                if (!this.mStatusChangeListeners.isEmpty() && !this.isBreakCallback) {
                    for (int i2 = 0; i2 < this.mStatusChangeListeners.size(); i2++) {
                        OnStatusChangeListener onStatusChangeListener2 = this.mStatusChangeListeners.get(i2);
                        onStatusChangeListener2.onStatusChange(0);
                        onStatusChangeListener2.onProgressChange(0);
                    }
                }
                this.status = 0;
                LogUtil.e(TAG, "STATUS_TOP");
            }
            this.statusChange = false;
        } else if (!this.mIsBeingDragged) {
            if (getScrollY() < (-this.bottomHight) / 2) {
                if (!this.mStatusChangeListeners.isEmpty() && !this.isBreakCallback) {
                    for (int i3 = 0; i3 < this.mStatusChangeListeners.size(); i3++) {
                        OnStatusChangeListener onStatusChangeListener3 = this.mStatusChangeListeners.get(i3);
                        if (this.status != 1) {
                            LogUtil.e(TAG, "statusChange STATUS_BOTTOM");
                            onStatusChangeListener3.onStatusChange(1);
                        }
                        onStatusChangeListener3.onProgressChange(100);
                    }
                }
                this.status = 1;
                LogUtil.e(TAG, "STATUS_BOTTOM");
            } else {
                if (!this.mStatusChangeListeners.isEmpty() && !this.isBreakCallback) {
                    for (int i4 = 0; i4 < this.mStatusChangeListeners.size(); i4++) {
                        OnStatusChangeListener onStatusChangeListener4 = this.mStatusChangeListeners.get(i4);
                        if (this.status != 0) {
                            LogUtil.e(TAG, "statusChange STATUS_TOP");
                            onStatusChangeListener4.onStatusChange(0);
                        }
                        onStatusChangeListener4.onProgressChange(0);
                    }
                }
                this.status = 0;
                LogUtil.e(TAG, "STATUS_TOP");
            }
        }
        this.isScrolling = false;
        if (this.hasMoveScroll) {
            if (this.status == 1) {
                scrollTo(0, -this.bottomHight);
            } else {
                scrollTo(0, 0);
            }
            this.hasMoveScroll = false;
        }
        this.isBreakCallback = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.interruptCurTouchEvent = false;
        }
        EventCatchListener eventCatchListener = this.mEventCatchListener;
        if (eventCatchListener != null) {
            eventCatchListener.onEventCatch(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public int getCurStatus() {
        if (this.bottomHight == 0) {
            return this.mFirstInitStatus;
        }
        return this.status;
    }

    public void gotoBottom() {
        if (b.FUNC_SETTING_BOTTOM_BAR.a() && BNSettingManager.isBottomBarOpen()) {
            gotoBottom(true, true);
        }
    }

    public void gotoBottomWithOutAnim() {
        gotoBottom(false, true);
    }

    public boolean gotoTop() {
        if (b.FUNC_SETTING_BOTTOM_BAR.a() && BNSettingManager.isBottomBarOpen()) {
            return gotoTop(true, true);
        }
        return false;
    }

    public boolean gotoTopWithOutAnim() {
        if (!b.FUNC_SETTING_BOTTOM_BAR.a() || !BNSettingManager.isBottomBarOpen()) {
            return false;
        }
        return gotoTop(false, true);
    }

    public boolean isScrolling() {
        return this.isScrolling;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptHoverEvent(MotionEvent motionEvent) {
        return this.mIsBeingDragged;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (b.FUNC_SETTING_BOTTOM_BAR.a() && BNSettingManager.isBottomBarOpen()) {
            if (!this.needScroll) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            int action = motionEvent.getAction();
            if (action == 2 && this.mIsBeingDragged) {
                return true;
            }
            int i = action & 255;
            if (i != 0) {
                if (i == 2 && Math.abs(((int) motionEvent.getY()) - this.mLastY) > this.mTouchSlop) {
                    this.mIsBeingDragged = true;
                    return true;
                }
            } else {
                this.mLastY = (int) motionEvent.getY();
                int scrollY = getScrollY();
                this.mScrollStart = scrollY;
                if (scrollY < (-this.bottomHight) / 2) {
                    this.status = 1;
                } else {
                    this.status = 0;
                }
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.bottomHight == 0) {
            try {
                this.bottomHight = findViewById(R.id.sub_scroll_layout).getHeight();
                View findViewById = findViewById(R.id.sub_fade_layer);
                if (findViewById != null) {
                    this.button = findViewById.getHeight();
                } else {
                    this.button = 0;
                }
                this.topHight = getHeight() - this.button;
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (this.mFirstInitStatus == 1) {
                gotoBottom(false, true);
            }
            if (LogUtil.LOGGABLE) {
                LogUtil.e("CustomLinearScrollView: onLayout", " bottomHight:" + this.bottomHight + " button:" + this.button + "topHight: " + this.topHight);
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0043, code lost:
    
        if (r2 != 3) goto L68;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r11) {
        /*
            Method dump skipped, instructions count: 482
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.ui.widget.CustomLinearScrollView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void removeOnStatusChangeListener(OnStatusChangeListener onStatusChangeListener) {
        if (this.mStatusChangeListeners.contains(onStatusChangeListener)) {
            this.mStatusChangeListeners.remove(onStatusChangeListener);
        }
    }

    public void setInitScrollStatus(int i) {
        this.mFirstInitStatus = i;
    }

    public void setOnEventCatchListener(EventCatchListener eventCatchListener) {
        this.mEventCatchListener = eventCatchListener;
    }

    public void setScrollSupport(boolean z) {
        LogUtil.e(TAG, "setScrollSupport needScroll:" + z);
        this.needScroll = z;
    }

    public CustomLinearScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mStatusChangeListeners = new ArrayList();
        this.bottomHight = 0;
        this.status = 0;
        this.statusChange = false;
        this.needScroll = true;
        this.hasMoveScroll = false;
        this.mLastEventIsScroll = false;
        this.mFirstInitStatus = 1;
        this.isBreakCallback = false;
        this.mIsBeingDragged = false;
        this.mEventCatchListener = null;
        initScroller(context);
    }

    private void gotoBottom(boolean z, boolean z2) {
        if (LogUtil.LOGGABLE) {
            StringBuilder sb = new StringBuilder();
            sb.append("gotoBottom return : mScroller ： ");
            sb.append(this.mScroller == null);
            sb.append(" bottomHight = ");
            sb.append(this.bottomHight);
            LogUtil.e(TAG, sb.toString());
        }
        if (this.mScroller != null && this.bottomHight != 0) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e(TAG, "gotoBottom showAnim:" + z + " needCallback" + z2 + ", getScrollY() = " + getScrollY());
            }
            int scrollY = (-this.bottomHight) - getScrollY();
            if (scrollY == 0) {
                LogUtil.e(TAG, "gotoBottom retuen : already on the bottom!");
                return;
            }
            if (z) {
                startScroll(0, getScrollY(), 0, scrollY);
            } else {
                startScroll(0, getScrollY(), 0, scrollY, 0);
                if (z2 && !this.mStatusChangeListeners.isEmpty()) {
                    for (int i = 0; i < this.mStatusChangeListeners.size(); i++) {
                        OnStatusChangeListener onStatusChangeListener = this.mStatusChangeListeners.get(i);
                        onStatusChangeListener.onStatusChange(1);
                        onStatusChangeListener.onProgressChange(100);
                    }
                }
            }
            this.status = 1;
            this.interruptCurTouchEvent = true;
            this.statusChange = true;
            this.isScrolling = true;
            this.isBreakCallback = !z2;
            this.hasMoveScroll = true;
            this.mLastEventIsScroll = false;
            postInvalidate();
            return;
        }
        LogUtil.e(TAG, "mScroller == null ");
    }

    private boolean gotoTop(boolean z, boolean z2) {
        if (this.status == 0) {
            LogUtil.e(TAG, "status == STATUS_TOP,return");
            return false;
        }
        if (this.mScroller == null) {
            LogUtil.e(TAG, "mScroller == null,return");
            return false;
        }
        if (this.bottomHight == 0) {
            LogUtil.e(TAG, "bottomHight == 0,return");
            return false;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e(TAG, "gotoTop showAnim:" + z + " needCallback" + z2 + " getScrollY：" + getScrollY() + " bottomHight：" + this.bottomHight);
        }
        if (z) {
            startScroll(0, getScrollY(), 0, this.bottomHight);
        } else {
            startScroll(0, getScrollY(), 0, this.bottomHight, 0);
        }
        this.status = 0;
        this.statusChange = true;
        this.isScrolling = true;
        this.isBreakCallback = !z2;
        this.hasMoveScroll = true;
        this.mLastEventIsScroll = false;
        postInvalidate();
        return true;
    }

    private void startScroll(int i, int i2, int i3, int i4, int i5) {
        Scroller scroller = this.mScroller;
        if (scroller != null) {
            scroller.startScroll(i, i2, i3, i4, i5);
        }
    }

    @TargetApi(11)
    public CustomLinearScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mStatusChangeListeners = new ArrayList();
        this.bottomHight = 0;
        this.status = 0;
        this.statusChange = false;
        this.needScroll = true;
        this.hasMoveScroll = false;
        this.mLastEventIsScroll = false;
        this.mFirstInitStatus = 1;
        this.isBreakCallback = false;
        this.mIsBeingDragged = false;
        this.mEventCatchListener = null;
        initScroller(context);
    }
}
