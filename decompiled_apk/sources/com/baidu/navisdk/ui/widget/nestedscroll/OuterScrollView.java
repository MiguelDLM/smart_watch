package com.baidu.navisdk.ui.widget.nestedscroll;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.LinearLayout;
import android.widget.OverScroller;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.core.widget.NestedScrollView;
import com.baidu.baidumaps.common.util.ScreenUtils;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.framework.message.a;
import com.baidu.navisdk.framework.message.bean.t;
import com.baidu.navisdk.j;
import com.baidu.navisdk.model.datastruct.p;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

/* loaded from: classes8.dex */
public class OuterScrollView extends NestedScrollView implements a.InterfaceC0201a {
    private static final int ONE_LEVEL_VEL = 1000;
    private static final String TAG = "OuterScrollView";
    private static final int TWO_LEVEL_VEL = 10000;
    private BlankLinearLayout blankLayout;
    private LinearLayout contentLayout;
    protected boolean enablePageScrollStatus;
    private boolean isDownOnMap;
    protected boolean isStartNestFling;
    protected boolean isSupport3Status;
    protected Field lastScrollYField;
    protected int mBottomStatusContentHeight;
    protected FlingHelper mFlingHelper;
    protected OnScrollChangeListener mListener;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private OnScrollViewTouchListener mOnScrollViewTouchListener;
    private int mOrientation;
    private int mScreenHeight;
    protected int mSpecialStatusContentHeight;
    protected p mStatus;
    protected int mTopStatusContentHeight;
    protected VelocityTracker mVelocityTracker;
    protected boolean scrollAvailable;
    protected int scroll_height;
    protected Field scrollerField;
    protected int view_height;

    /* renamed from: com.baidu.navisdk.ui.widget.nestedscroll.OuterScrollView$2, reason: invalid class name */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$baidu$navisdk$model$datastruct$ScrollStatus;

        static {
            int[] iArr = new int[p.values().length];
            $SwitchMap$com$baidu$navisdk$model$datastruct$ScrollStatus = iArr;
            try {
                iArr[p.BOTTOM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$navisdk$model$datastruct$ScrollStatus[p.TOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$baidu$navisdk$model$datastruct$ScrollStatus[p.SPECIFIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes8.dex */
    public static abstract class OnScrollChangeListener {
        public void onScroll(int i) {
        }

        public void onScrollEnd() {
        }

        public void onScrollProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        }

        public void onScrollStart() {
        }

        public void onStatusChanged(p pVar, p pVar2) {
        }
    }

    /* loaded from: classes8.dex */
    public static abstract class OnScrollViewTouchListener {
        public void onScrollViewContentTouchDown() {
        }

        public void onScrollViewContentTouchUp() {
        }

        public void onScrollViewTouchDown() {
        }

        public void onScrollViewTouchUp() {
        }
    }

    public OuterScrollView(Context context) {
        super(context);
        this.scrollAvailable = true;
        this.isDownOnMap = false;
        this.mStatus = p.BOTTOM;
        this.scroll_height = 0;
        this.view_height = 0;
        this.isStartNestFling = false;
        this.enablePageScrollStatus = true;
        this.isSupport3Status = false;
        this.mOrientation = 1;
        init(context);
    }

    private boolean canMoveMap(MotionEvent motionEvent, View view) {
        boolean isPointInsideView = isPointInsideView(motionEvent.getY(), view);
        if (motionEvent.getAction() == 0) {
            this.isDownOnMap = isPointInsideView;
        }
        if (motionEvent.getAction() == 1) {
            this.isDownOnMap = false;
        }
        if (!this.isDownOnMap || !isPointInsideView || motionEvent.getAction() == 1) {
            return false;
        }
        return true;
    }

    private int getBottomToSpecialMidValue() {
        return getScrollToBottomValue() + ((getScrollToSpecialValue() - getScrollToBottomValue()) / 2);
    }

    private int getBottomToTopMidValue() {
        return getScrollToBottomValue() + ((getScrollToTopValue() - getScrollToBottomValue()) / 2);
    }

    private int getScreenHeight() {
        if (j.d()) {
            if (this.mOrientation == 1) {
                return ScreenUtils.getViewScreenHeight(getContext());
            }
            return this.mScreenHeight;
        }
        if (this.mOrientation == 1) {
            return ScreenUtil.getInstance().getHeightPixels();
        }
        return this.mScreenHeight;
    }

    private int getSpecialToTopMidValue() {
        return getScrollToSpecialValue() + ((getScrollToTopValue() - getScrollToSpecialValue()) / 2);
    }

    private void initVelocityTrackerIfNotExists() {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
    }

    private boolean isPointInsideView(float f, View view) {
        view.getHitRect(new Rect());
        if (f > r0.top && f < r0.bottom - getScrollY()) {
            return true;
        }
        return false;
    }

    private void recycleVelocityTracker() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    public void abortAnimation() {
        Object obj;
        try {
            if (this.scrollerField == null) {
                this.scrollerField = FlingHelper.getDeclaredField(this, "mScroller");
            }
            Field field = this.scrollerField;
            if (field != null) {
                obj = field.get(this);
            } else {
                obj = null;
            }
            if (obj == null) {
                return;
            }
            obj.getClass().getMethod("abortAnimation", null).invoke(obj, null);
        } catch (IllegalAccessException e) {
            if (LogUtil.LOGGABLE) {
                LogUtil.printException("OuterScrollView abortAnimation IllegalAccessException!", e);
            }
        } catch (NoSuchMethodException e2) {
            if (LogUtil.LOGGABLE) {
                LogUtil.printException("OuterScrollView abortAnimation NoSuchMethodException!", e2);
            }
        } catch (InvocationTargetException e3) {
            if (LogUtil.LOGGABLE) {
                LogUtil.printException("OuterScrollView abortAnimation InvocationTargetException!", e3);
            }
        }
    }

    public p calculateNextStatus(int i, int i2) {
        if (this.isSupport3Status) {
            return calculateNextWhen3Status(i, i2);
        }
        return calculateNextWhen2Status(i, i2);
    }

    public p calculateNextWhen2Status(int i, int i2) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(TAG, "calculateNextStatus() --> velocityY = " + i + ", scrollY = " + i2 + ", bottomToTopMidValue = " + getBottomToTopMidValue() + ", mStatus = " + this.mStatus);
        }
        int i3 = AnonymousClass2.$SwitchMap$com$baidu$navisdk$model$datastruct$ScrollStatus[this.mStatus.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                return p.BOTTOM;
            }
            if (i <= 1000 && i2 >= getBottomToTopMidValue()) {
                if (i2 > getScrollToTopValue()) {
                    return p.TOP;
                }
                return p.TOP;
            }
            return p.BOTTOM;
        }
        if ((i < 0 && Math.abs(i) > 1000) || i2 > getBottomToTopMidValue()) {
            return p.TOP;
        }
        return p.BOTTOM;
    }

    public p calculateNextWhen3Status(int i, int i2) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(TAG, "calculateNextStatus() --> velocityY = " + i + ", scrollY = " + i2 + ", bottomToSpecialMidValue = " + getBottomToSpecialMidValue() + ", specialToTopMidValue = " + getSpecialToTopMidValue() + ", mStatus = " + this.mStatus);
        }
        int i3 = AnonymousClass2.$SwitchMap$com$baidu$navisdk$model$datastruct$ScrollStatus[this.mStatus.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    return p.BOTTOM;
                }
                if (i <= 1000 && i2 >= getBottomToSpecialMidValue()) {
                    if ((i < 0 && Math.abs(i) > 1000) || i2 > getSpecialToTopMidValue()) {
                        return p.TOP;
                    }
                    return p.SPECIFIC;
                }
                return p.BOTTOM;
            }
            if (i <= 10000 && i2 >= getBottomToSpecialMidValue()) {
                if (i <= 1000 && i2 >= getSpecialToTopMidValue()) {
                    return p.TOP;
                }
                return p.SPECIFIC;
            }
            return p.BOTTOM;
        }
        if ((i < 0 && Math.abs(i) > 10000) || i2 > getSpecialToTopMidValue()) {
            return p.TOP;
        }
        if ((i < 0 && Math.abs(i) > 1000) || i2 > getBottomToSpecialMidValue()) {
            return p.SPECIFIC;
        }
        return p.BOTTOM;
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.View, androidx.core.view.ScrollingView
    public int computeVerticalScrollRange() {
        int childCount = getChildCount();
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (childCount == 0) {
            return height;
        }
        int i = 0;
        int bottom = getChildAt(0).getBottom();
        int scrollY = getScrollY();
        int max = Math.max(0, bottom - height);
        if (scrollY < 0) {
            bottom -= scrollY;
        } else if (scrollY > max) {
            bottom += scrollY - max;
        }
        this.scroll_height = bottom;
        BlankLinearLayout blankLinearLayout = this.blankLayout;
        if (blankLinearLayout != null) {
            i = blankLinearLayout.getMeasuredHeight();
            LinearLayout linearLayout = this.contentLayout;
            if (linearLayout != null && linearLayout.getChildAt(1) != null) {
                i += this.contentLayout.getChildAt(1).getMeasuredHeight();
            }
        }
        if (i > 0) {
            this.scroll_height = i;
        }
        return this.scroll_height;
    }

    @Override // androidx.core.widget.NestedScrollView
    public void fling(int i) {
        Object obj;
        int i2;
        int i3;
        int scrollToBottomValue;
        int scrollToBottomValue2;
        if (!this.enablePageScrollStatus) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e(TAG, "fling() --> 1 --> velocityY = " + i);
            }
            super.fling(i);
            return;
        }
        if (this.scrollerField == null) {
            this.scrollerField = FlingHelper.getDeclaredField(this, "mScroller");
        }
        if (this.lastScrollYField == null) {
            this.lastScrollYField = FlingHelper.getDeclaredField(this, "mLastScrollerY");
        }
        try {
            Field field = this.scrollerField;
            OverScroller overScroller = null;
            if (field != null) {
                obj = field.get(this);
            } else {
                obj = null;
            }
            if (obj instanceof OverScroller) {
                overScroller = (OverScroller) obj;
            }
            if (overScroller != null && this.lastScrollYField != null) {
                try {
                    if (getChildCount() > 0) {
                        startNestedScroll(2, 1);
                        if (this.enablePageScrollStatus) {
                            p pVar = this.mStatus;
                            if (pVar == p.TOP) {
                                scrollToBottomValue = getScrollToTopValue();
                                scrollToBottomValue2 = getScrollToTopValue();
                            } else if (this.isSupport3Status && pVar == p.SPECIFIC) {
                                scrollToBottomValue = getScrollToSpecialValue();
                                scrollToBottomValue2 = getScrollToSpecialValue();
                            } else {
                                scrollToBottomValue = getScrollToBottomValue();
                                scrollToBottomValue2 = getScrollToBottomValue();
                            }
                            i2 = scrollToBottomValue;
                            i3 = scrollToBottomValue2;
                        } else {
                            i2 = Integer.MIN_VALUE;
                            i3 = Integer.MAX_VALUE;
                        }
                        if (LogUtil.LOGGABLE) {
                            LogUtil.e(TAG, "fling() --> getScrollX = " + getScrollX() + ", getScrollY = " + getScrollY() + " velocityY = " + i + ", minY = " + i2 + ", maxY = " + i3);
                        }
                        overScroller.fling(getScrollX(), getScrollY(), 0, i, 0, 0, i2, i3, 0, 0);
                        this.lastScrollYField.set(this, Integer.valueOf(getScrollY()));
                        ViewCompat.postInvalidateOnAnimation(this);
                        return;
                    }
                    return;
                } catch (IllegalAccessException e) {
                    if (LogUtil.LOGGABLE) {
                        LogUtil.printException("OuterScrollView fling  IllegalAccessException!", e);
                    }
                    if (LogUtil.LOGGABLE) {
                        LogUtil.e(TAG, "fling() --> 3 --> velocityY = " + i);
                    }
                    super.fling(i);
                    return;
                }
            }
            if (LogUtil.LOGGABLE) {
                LogUtil.e(TAG, "fling() --> 4 --> velocityY = " + i);
            }
            super.fling(i);
        } catch (IllegalAccessException e2) {
            if (LogUtil.LOGGABLE) {
                LogUtil.printException("OuterScrollView fling  IllegalAccessException!", e2);
            }
            if (LogUtil.LOGGABLE) {
                LogUtil.e(TAG, "fling() --> 2 --> velocityY = " + i);
            }
            super.fling(i);
        }
    }

    public LinearLayout getContentLayout() {
        return this.contentLayout;
    }

    public int getMaxScrollVal() {
        return getScrollToTopValue() - getScrollToBottomValue();
    }

    public String getName() {
        return "OuterScrollView-OnEvent";
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(TAG, "getNestedScrollAxes");
        }
        return super.getNestedScrollAxes();
    }

    public int getScrollToBottomValue() {
        return 0;
    }

    public int getScrollToSpecialValue() {
        int i = this.mSpecialStatusContentHeight;
        if (i == 0) {
            return getMaxScrollVal() / 2;
        }
        return i - this.mBottomStatusContentHeight;
    }

    public int getScrollToTopValue() {
        return this.mTopStatusContentHeight - this.mBottomStatusContentHeight;
    }

    public float getSpecialStatusPercent() {
        int maxScrollVal = getMaxScrollVal();
        if (maxScrollVal == 0) {
            return 0.5f;
        }
        return (getScrollToSpecialValue() * 1.0f) / (maxScrollVal * 1.0f);
    }

    public p getStatus() {
        return this.mStatus;
    }

    public void init(Context context) {
        this.mOrientation = context.getResources().getConfiguration().orientation;
        LayoutInflater.from(getContext()).inflate(R.layout.nsdk_layout_out_scroll_view, this);
        this.blankLayout = (BlankLinearLayout) findViewById(R.id.ll_blank);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.ll_content);
        this.contentLayout = linearLayout;
        linearLayout.setMinimumHeight(getScreenHeight());
        this.mFlingHelper = new FlingHelper(context);
        this.mMaximumVelocity = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
        this.mMinimumVelocity = ViewConfiguration.get(context).getScaledMinimumFlingVelocity();
    }

    public boolean isNeedStopScroll(int i) {
        if (this.scroll_height - this.view_height == i) {
            return true;
        }
        return false;
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        a.a().a(this, t.class, new Class[0]);
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        this.mOrientation = configuration.orientation;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a.a().a((a.InterfaceC0201a) this);
        recycleVelocityTracker();
    }

    @Override // com.baidu.navisdk.framework.message.a.InterfaceC0201a
    public void onEvent(Object obj) {
        View childAt;
        if (obj instanceof t) {
            BlankLinearLayout blankLinearLayout = this.blankLayout;
            if (blankLinearLayout != null) {
                blankLinearLayout.requestLayout();
            }
            LinearLayout linearLayout = this.contentLayout;
            if (linearLayout != null && (childAt = linearLayout.getChildAt(1)) != null) {
                childAt.requestLayout();
            }
            if (this.mStatus == p.TOP) {
                post(new Runnable() { // from class: com.baidu.navisdk.ui.widget.nestedscroll.OuterScrollView.1
                    @Override // java.lang.Runnable
                    public void run() {
                        OuterScrollView outerScrollView = OuterScrollView.this;
                        if (outerScrollView.mStatus == p.TOP) {
                            outerScrollView.scrollTo(0, outerScrollView.getScrollToTopValue());
                        }
                    }
                });
            }
        }
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean canMoveMap;
        if (LogUtil.LOGGABLE) {
            LogUtil.e(TAG, "onInterceptTouchEvent() --> event = " + motionEvent);
        }
        BlankLinearLayout blankLinearLayout = this.blankLayout;
        if (blankLinearLayout == null) {
            canMoveMap = false;
        } else {
            canMoveMap = canMoveMap(motionEvent, blankLinearLayout);
        }
        if (!canMoveMap && this.mOnScrollViewTouchListener != null) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1) {
                    this.mOnScrollViewTouchListener.onScrollViewContentTouchUp();
                }
            } else {
                this.mOnScrollViewTouchListener.onScrollViewContentTouchDown();
            }
        }
        if (this.mOnScrollViewTouchListener != null) {
            int action2 = motionEvent.getAction();
            if (action2 != 0) {
                if (action2 == 1) {
                    this.mOnScrollViewTouchListener.onScrollViewTouchUp();
                }
            } else {
                this.mOnScrollViewTouchListener.onScrollViewTouchDown();
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.core.widget.NestedScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.view_height = i4 - i2;
        }
    }

    @Override // androidx.core.widget.NestedScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int screenHeight = getScreenHeight();
        int i3 = this.mBottomStatusContentHeight;
        this.blankLayout.setMinHeight(screenHeight - i3);
        super.onMeasure(i, i2);
        int i4 = this.mBottomStatusContentHeight;
        if (i4 != i3) {
            this.blankLayout.setMinHeight(screenHeight - i4);
            super.onMeasure(i, i2);
        }
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(@NonNull View view, float f, float f2, boolean z) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(TAG, "onNestedFling() --> target = " + view + ", velocityX = " + f + ", velocityY = " + f2 + ", consumed = " + z);
        }
        return super.onNestedFling(view, f, f2, z);
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(@NonNull View view, float f, float f2) {
        int maxScrollVal;
        p pVar;
        if (LogUtil.LOGGABLE) {
            LogUtil.e(TAG, "onNestedPreFling() --> target = " + view + ", velocityX = " + f + ", velocityY = " + f2);
        }
        p pVar2 = this.mStatus;
        p pVar3 = p.SPECIFIC;
        if (pVar2 != pVar3) {
            if (f2 > 0.0f && view.canScrollVertically(1)) {
                return false;
            }
            if (f2 < 0.0f && view.canScrollVertically(-1)) {
                return false;
            }
        }
        this.isStartNestFling = true;
        if (view.getScrollY() != 0 && (pVar = this.mStatus) != p.BOTTOM && pVar != pVar3) {
            return super.onNestedPreFling(view, f, f2);
        }
        if (this.enablePageScrollStatus) {
            int i = -((int) f2);
            p calculateNextStatus = calculateNextStatus(i, getScrollY());
            if (calculateNextStatus != p.NULL) {
                updateStatus(calculateNextStatus, true, i);
            }
        } else {
            if (f2 < 0.0f) {
                maxScrollVal = getScrollY();
            } else {
                maxScrollVal = getMaxScrollVal() - getScrollY();
            }
            int max = ((int) Math.max(Math.abs(f2), Math.abs(this.mFlingHelper.getVelocityByDistance(maxScrollVal)))) + 500;
            if (f2 < 0.0f) {
                max = -max;
            }
            fling(max);
        }
        return true;
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(@NonNull View view, int i, int i2, @NonNull int[] iArr) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(TAG, "onNestedPreScroll() --> target = " + view + ", dx = " + i + ", dy = " + i2 + ", consumed = " + Arrays.toString(iArr));
        }
        boolean z = i2 > 0 && getScrollY() < getScrollToTopValue();
        boolean z2 = i2 < 0 && getScrollY() >= 0 && !view.canScrollVertically(-1);
        if (z || z2) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e(TAG, "onNestedPreScroll() --> scroll scrollview!");
            }
            scrollBy(0, i2);
            iArr[1] = i2;
        }
        super.onNestedPreScroll(view, i, i2, iArr);
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(@NonNull View view, int i, int i2, int i3, int i4) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(TAG, "onNestedScroll() --> target = " + view + ", dxConsumed = " + i + ", dyConsumed = " + i2 + ", dxUnconsumed = " + i3 + ", dyUnconsumed = " + i4);
        }
        super.onNestedScroll(view, i, i2, i3, i4);
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(@NonNull View view, @NonNull View view2, int i) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(TAG, "onNestedScrollAccepted() --> child = " + view + ", target = " + view2 + ", axes = " + i);
        }
        super.onNestedScrollAccepted(view, view2, i);
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.View
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        float f;
        OnScrollChangeListener onScrollChangeListener = this.mListener;
        if (onScrollChangeListener != null) {
            onScrollChangeListener.onScroll(i2);
            int maxScrollVal = getMaxScrollVal();
            OnScrollChangeListener onScrollChangeListener2 = this.mListener;
            if (maxScrollVal == 0) {
                f = 0.0f;
            } else {
                f = (i2 * 1.0f) / (maxScrollVal * 1.0f);
            }
            onScrollChangeListener2.onScrollProgress(f);
        }
        boolean isNeedStopScroll = isNeedStopScroll(i2);
        if (i2 == 0 || isNeedStopScroll) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e(TAG, "onScrollChanged abortAnimation " + i2 + ",scroll_height: " + this.scroll_height + ", view_height:" + this.view_height);
            }
            abortAnimation();
        }
        super.onScrollChanged(i, i2, i3, i4);
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mScreenHeight = i2;
        this.blankLayout.setMinHeight(i2 - this.mBottomStatusContentHeight);
        this.contentLayout.setMinimumHeight(i2);
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(@NonNull View view, @NonNull View view2, int i) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(TAG, "onStartNestedScroll() --> child = " + view + ", target = " + view2 + ", axes = " + i + ", scrollAvailable = " + this.scrollAvailable);
        }
        if (this.scrollAvailable && getScrollY() == getMaxScrollVal()) {
            return super.onStartNestedScroll(view, view2, i);
        }
        return false;
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(@NonNull View view) {
        p calculateNextStatus;
        if (LogUtil.LOGGABLE) {
            LogUtil.e(TAG, "onStopNestedScroll() --> target = " + view + ", isStartNestFling = " + this.isStartNestFling);
        }
        if (this.isStartNestFling) {
            this.isStartNestFling = false;
        } else if (this.enablePageScrollStatus && (calculateNextStatus = calculateNextStatus(0, getScrollY())) != p.NULL) {
            updateStatus(calculateNextStatus, true);
        }
        super.onStopNestedScroll(view);
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean canMoveMap;
        if (LogUtil.LOGGABLE) {
            LogUtil.e(TAG, "onTouchEvent() --> scrollAvailable = " + this.scrollAvailable + ", event = " + motionEvent);
        }
        if (!this.scrollAvailable) {
            return false;
        }
        int action = motionEvent.getAction();
        if (this.mOnScrollViewTouchListener != null) {
            int action2 = motionEvent.getAction();
            if (action2 != 0) {
                if (action2 == 1) {
                    this.mOnScrollViewTouchListener.onScrollViewTouchUp();
                }
            } else {
                this.mOnScrollViewTouchListener.onScrollViewTouchDown();
            }
        }
        BlankLinearLayout blankLinearLayout = this.blankLayout;
        if (blankLinearLayout == null) {
            canMoveMap = false;
        } else {
            canMoveMap = canMoveMap(motionEvent, blankLinearLayout);
        }
        if (canMoveMap) {
            return false;
        }
        if (this.mOnScrollViewTouchListener != null) {
            int action3 = motionEvent.getAction();
            if (action3 != 0) {
                if (action3 == 1) {
                    this.mOnScrollViewTouchListener.onScrollViewContentTouchUp();
                }
            } else {
                this.mOnScrollViewTouchListener.onScrollViewContentTouchDown();
            }
        }
        initVelocityTrackerIfNotExists();
        this.mVelocityTracker.addMovement(motionEvent);
        if (action != 1) {
            if (action == 3) {
                recycleVelocityTracker();
            }
        } else {
            if (this.enablePageScrollStatus) {
                this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                int yVelocity = (int) this.mVelocityTracker.getYVelocity();
                p calculateNextStatus = calculateNextStatus(yVelocity, getScrollY());
                if (calculateNextStatus != p.NULL) {
                    updateStatus(calculateNextStatus, true, yVelocity);
                }
                recycleVelocityTracker();
                return true;
            }
            recycleVelocityTracker();
        }
        return super.onTouchEvent(motionEvent);
    }

    public void removeBlankViewClickListener() {
        BlankLinearLayout blankLinearLayout = this.blankLayout;
        if (blankLinearLayout != null) {
            blankLinearLayout.setClickable(false);
        }
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.View
    public void scrollTo(int i, int i2) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(TAG, "scrollTo --> x = " + i + ", y = " + i2 + ", getScrollToBottomValue() = " + getScrollToBottomValue() + ", getScrollToTopValue() = " + getScrollToTopValue());
        }
        if (i2 < getScrollToBottomValue()) {
            i2 = getScrollToBottomValue();
        }
        if (i2 > getScrollToTopValue()) {
            i2 = getScrollToTopValue();
        }
        super.scrollTo(i, i2);
    }

    public void setBlankViewClickListener(View.OnClickListener onClickListener) {
        boolean z;
        BlankLinearLayout blankLinearLayout = this.blankLayout;
        if (blankLinearLayout != null) {
            blankLinearLayout.setOnClickListener(onClickListener);
            BlankLinearLayout blankLinearLayout2 = this.blankLayout;
            if (onClickListener != null) {
                z = true;
            } else {
                z = false;
            }
            blankLinearLayout2.setClickable(z);
        }
    }

    public void setBottomStatusContentHeight(int i) {
        this.mBottomStatusContentHeight = i;
    }

    public void setEnablePageScrollStatus(boolean z) {
        this.enablePageScrollStatus = z;
    }

    public void setScrollAvailable(boolean z) {
        this.scrollAvailable = z;
    }

    public void setScrollChangeListener(OnScrollChangeListener onScrollChangeListener) {
        this.mListener = onScrollChangeListener;
    }

    public void setScrollViewTouchListener(OnScrollViewTouchListener onScrollViewTouchListener) {
        this.mOnScrollViewTouchListener = onScrollViewTouchListener;
    }

    public void setSpecialStatusContentHeight(int i) {
        this.mSpecialStatusContentHeight = i;
    }

    public void setStatus(p pVar) {
        this.mStatus = pVar;
    }

    public void setSupport3Status(boolean z) {
        this.isSupport3Status = z;
    }

    public void setTopStatusContentHeight(int i) {
        this.mTopStatusContentHeight = i;
    }

    public void updateStatus(p pVar, boolean z) {
        updateStatus(pVar, z, 0);
    }

    public void updateStatus(p pVar, boolean z, int i) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(TAG, "updateStatus() --> status = " + pVar + ", smooth = " + z + ", velocityY = " + i);
        }
        OnScrollChangeListener onScrollChangeListener = this.mListener;
        if (onScrollChangeListener != null) {
            onScrollChangeListener.onStatusChanged(this.mStatus, pVar);
        }
        this.mStatus = pVar;
        int i2 = AnonymousClass2.$SwitchMap$com$baidu$navisdk$model$datastruct$ScrollStatus[pVar.ordinal()];
        if (i2 == 1) {
            if (z) {
                int scrollY = getScrollY() - getScrollToBottomValue();
                if (i < 0) {
                    i = 0;
                }
                int velocityByDistance = this.mFlingHelper.getVelocityByDistance(scrollY);
                int i3 = -Math.max(Math.abs(i), Math.abs(velocityByDistance + 500));
                if (LogUtil.LOGGABLE) {
                    LogUtil.e(TAG, "updateBottomStatus --> velocityY = " + i + ", scrollDistance = " + scrollY + ", needVelocity = " + velocityByDistance + ", finalVelocity = " + i3);
                }
                if (velocityByDistance > 0) {
                    fling(i3);
                    return;
                }
                return;
            }
            scrollTo(0, getScrollToBottomValue());
            return;
        }
        if (i2 == 2) {
            if (z) {
                int scrollToTopValue = getScrollToTopValue() - getScrollY();
                if (i < 0) {
                    i = 0;
                }
                int velocityByDistance2 = this.mFlingHelper.getVelocityByDistance(scrollToTopValue);
                int max = Math.max(Math.abs(i), Math.abs(velocityByDistance2 + 500));
                if (LogUtil.LOGGABLE) {
                    LogUtil.e(TAG, "updateTopStatus --> velocityY = " + i + ", scrollDistance = " + scrollToTopValue + ", needVelocity = " + velocityByDistance2 + ", finalVelocity = " + max);
                }
                if (velocityByDistance2 > 0) {
                    fling(max);
                    return;
                }
                return;
            }
            scrollTo(0, getScrollToTopValue());
            return;
        }
        if (i2 != 3) {
            return;
        }
        if (z) {
            int scrollY2 = getScrollY() - getScrollToSpecialValue();
            int abs = Math.abs(scrollY2);
            if ((scrollY2 >= 0 && i < 0) || (scrollY2 < 0 && i > 0)) {
                i = 0;
            }
            int velocityByDistance3 = this.mFlingHelper.getVelocityByDistance(abs);
            int max2 = Math.max(Math.abs(i), Math.abs(velocityByDistance3 + 500));
            if (scrollY2 >= 0) {
                max2 = -max2;
            }
            if (LogUtil.LOGGABLE) {
                LogUtil.e(TAG, "updateSpecialStatus --> velocityY = " + i + ", scrollDistance = " + abs + ", needVelocity = " + velocityByDistance3 + ", finalVelocity = " + max2);
            }
            if (velocityByDistance3 > 0) {
                fling(max2);
                return;
            }
            return;
        }
        scrollTo(0, getScrollToSpecialValue());
    }

    @Override // androidx.core.widget.NestedScrollView, androidx.core.view.NestedScrollingParent3
    public void onNestedScroll(@NonNull View view, int i, int i2, int i3, int i4, int i5, @NonNull int[] iArr) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(TAG, "onNestedScroll() --> target = " + view + ", dxConsumed = " + i + ", dyConsumed = " + i2 + ", dxUnconsumed = " + i3 + ", dyUnconsumed = " + i4);
        }
        iArr[0] = iArr[0] + i3;
        iArr[1] = iArr[1] + i4;
        super.onNestedScroll(view, i, i2, i3, i5, i4);
    }

    @Override // androidx.core.widget.NestedScrollView, androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(@NonNull View view, @NonNull View view2, int i, int i2) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(TAG, "onStartNestedScroll() --> child = " + view + ", target = " + view2 + ", axes = " + i + ", scrollAvailable = " + this.scrollAvailable);
        }
        if (i2 == 0 && this.scrollAvailable && getScrollY() == getMaxScrollVal()) {
            return super.onStartNestedScroll(view, view2, i, i2);
        }
        return false;
    }

    @Override // androidx.core.widget.NestedScrollView, androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(@NonNull View view, int i) {
        p calculateNextStatus;
        if (i != 0) {
            return;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e(TAG, "onStopNestedScroll() --> target = " + view + ", isStartNestFling = " + this.isStartNestFling);
        }
        if (this.isStartNestFling) {
            this.isStartNestFling = false;
        } else if (this.enablePageScrollStatus && (calculateNextStatus = calculateNextStatus(0, getScrollY())) != p.NULL) {
            updateStatus(calculateNextStatus, true);
        }
        super.onStopNestedScroll(view, i);
    }

    public OuterScrollView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.scrollAvailable = true;
        this.isDownOnMap = false;
        this.mStatus = p.BOTTOM;
        this.scroll_height = 0;
        this.view_height = 0;
        this.isStartNestFling = false;
        this.enablePageScrollStatus = true;
        this.isSupport3Status = false;
        this.mOrientation = 1;
        init(context);
    }

    @Override // androidx.core.widget.NestedScrollView, androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(@NonNull View view, int i, int i2, @NonNull int[] iArr, int i3) {
        if (i3 != 0) {
            return;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e(TAG, "onNestedPreScroll() --> target = " + view + ", dx = " + i + ", dy = " + i2 + ", consumed = " + Arrays.toString(iArr));
        }
        boolean z = i2 > 0 && getScrollY() < getScrollToTopValue();
        boolean z2 = i2 < 0 && getScrollY() >= 0 && !view.canScrollVertically(-1);
        if (!z && !z2) {
            super.onNestedPreScroll(view, i, i2, iArr, i3);
            return;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e(TAG, "onNestedPreScroll() --> scroll scrollview!");
        }
        scrollBy(0, i2);
        iArr[1] = i2;
    }

    public OuterScrollView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.scrollAvailable = true;
        this.isDownOnMap = false;
        this.mStatus = p.BOTTOM;
        this.scroll_height = 0;
        this.view_height = 0;
        this.isStartNestFling = false;
        this.enablePageScrollStatus = true;
        this.isSupport3Status = false;
        this.mOrientation = 1;
        init(context);
    }
}
