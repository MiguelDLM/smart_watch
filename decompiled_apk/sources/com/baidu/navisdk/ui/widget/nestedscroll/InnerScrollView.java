package com.baidu.navisdk.ui.widget.nestedscroll;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.core.widget.NestedScrollView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import java.lang.reflect.Field;

/* loaded from: classes8.dex */
public class InnerScrollView extends NestedScrollView {
    private static final String TAG = "InnerScrollView";
    private boolean isRunAnim;
    private Field lastScrollYField;
    private int mBoundHeight;
    private ViewGroup mContainer;
    private int mContentHeight;
    private ViewGroup mContentView;
    private final int mDrag;
    private boolean mDragging;
    private FlingHelper mFlingHelper;
    private View mFooterView;
    private int mInitialTouchX;
    private int mInitialTouchY;
    private int mLastY;
    private int mMaxFlingVelocity;
    private int mMinFlingVelocity;
    private final int[] mNestedOffsets;
    private final int[] mScrollConsumed;
    private final int[] mScrollOffset;
    private int mScrollViewHeight;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;
    private Field scrollerField;

    /* loaded from: classes8.dex */
    public final class ProgressAnimation extends Animation {
        private final int boundHeight;
        private final float endProgress;
        private int scrolledY;
        private final float startProgress;

        @Override // android.view.animation.Animation
        public void applyTransformation(float f, Transformation transformation) {
            float f2 = (f * 1.0f) + 0.0f;
            if (LogUtil.LOGGABLE) {
                LogUtil.e(InnerScrollView.TAG, "applyTransformation: progress = " + f2 + ", getScrollY() = " + InnerScrollView.this.getScrollY());
                StringBuilder sb = new StringBuilder();
                sb.append("applyTransformation: dy = ");
                sb.append((int) (((float) (InnerScrollView.this.getScrollY() - this.boundHeight)) * f2));
                LogUtil.e(InnerScrollView.TAG, sb.toString());
            }
            int i = this.boundHeight;
            int i2 = this.scrolledY;
            int i3 = ((int) (i * f2)) - i2;
            if (f2 == 1.0f) {
                InnerScrollView.this.scrollByWithLimit(0, -(i - i2));
                InnerScrollView.this.isRunAnim = false;
            } else {
                this.scrolledY = i2 + i3;
                InnerScrollView.this.scrollByWithLimit(0, -i3);
            }
        }

        @Override // android.view.animation.Animation
        public void initialize(int i, int i2, int i3, int i4) {
            super.initialize(i, i2, i3, i4);
            setDuration(100L);
            setInterpolator(new AccelerateInterpolator());
        }

        private ProgressAnimation(int i) {
            this.startProgress = 0.0f;
            this.endProgress = 1.0f;
            this.scrolledY = 0;
            InnerScrollView.this.isRunAnim = true;
            this.boundHeight = i;
        }
    }

    public InnerScrollView(@NonNull Context context) {
        super(context);
        this.mBoundHeight = 500;
        this.mScrollOffset = new int[2];
        this.mScrollConsumed = new int[2];
        this.mNestedOffsets = new int[2];
        this.mDrag = 2;
        this.mScrollViewHeight = -1;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(getContext()).inflate(R.layout.nsdk_layout_inner_scroll_view, this);
        setNestedScrollingEnabled(true);
        setFillViewport(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mContainer = (ViewGroup) findViewById(R.id.inner_scroll_container);
        this.mContentView = (ViewGroup) findViewById(R.id.inner_scroll_content);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaxFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mFooterView = new View(context);
        this.mFlingHelper = new FlingHelper(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollByWithLimit(int i, int i2) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(TAG, "scrollByWithLimit() --> dx = " + i + ", dy = " + i2 + ", getScrollX() = " + getScrollX() + ", getScrollY() = " + getScrollY());
        }
        if (i == 0 && i2 == 0) {
            return;
        }
        int scrollX = getScrollX() + i;
        int scrollY = getScrollY() + i2;
        if (scrollY < 0) {
            scrollY = 0;
        } else if (scrollY > getMaxScrollDis()) {
            scrollY = getMaxScrollDis();
        }
        scrollTo(scrollX, scrollY);
    }

    public void addContentLayout(View view) {
        ViewGroup viewGroup = this.mContentView;
        if (viewGroup == null) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e(TAG, "addContentLayout mContentView == null ");
                return;
            }
            return;
        }
        viewGroup.addView(view);
    }

    @Override // androidx.core.widget.NestedScrollView
    public void fling(int i) {
        Object obj;
        int i2;
        int i3;
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
                        int splineFlingDistance = (int) this.mFlingHelper.getSplineFlingDistance(i);
                        if (i > 0 && (this.mContentHeight - getScrollViewHeight()) - getScrollY() <= splineFlingDistance) {
                            int scrollViewHeight = this.mContentHeight - getScrollViewHeight();
                            if (scrollViewHeight < 0) {
                                i2 = 0;
                                i3 = 0;
                            } else {
                                i2 = scrollViewHeight;
                                i3 = i2;
                            }
                        } else {
                            i2 = Integer.MIN_VALUE;
                            i3 = Integer.MAX_VALUE;
                        }
                        if (LogUtil.LOGGABLE) {
                            LogUtil.e(TAG, "fling() --> getScrollX = " + getScrollX() + ", getScrollY = " + getScrollY() + ", velocityY = " + i + ", mContentHeight = " + this.mContentHeight + ", minY = " + i2 + ", maxY = " + i3);
                        }
                        overScroller.fling(getScrollX(), getScrollY(), 0, i, 0, 0, i2, i3, 0, 0);
                        this.lastScrollYField.set(this, Integer.valueOf(getScrollY()));
                        ViewCompat.postInvalidateOnAnimation(this);
                        return;
                    }
                    return;
                } catch (IllegalAccessException e) {
                    if (LogUtil.LOGGABLE) {
                        LogUtil.printException("InnerScrollView fling  IllegalAccessException!", e);
                    }
                    if (LogUtil.LOGGABLE) {
                        LogUtil.e(TAG, "fling() --> 2 --> velocityY = " + i);
                    }
                    super.fling(i);
                    return;
                }
            }
            if (LogUtil.LOGGABLE) {
                LogUtil.e(TAG, "fling() --> 3 --> velocityY = " + i);
            }
            super.fling(i);
        } catch (IllegalAccessException e2) {
            if (LogUtil.LOGGABLE) {
                LogUtil.printException("InnerScrollView fling  IllegalAccessException!", e2);
            }
            if (LogUtil.LOGGABLE) {
                LogUtil.e(TAG, "fling() --> 1 --> velocityY = " + i);
            }
            super.fling(i);
        }
    }

    public ViewGroup getContentLayout() {
        return this.mContentView;
    }

    public int getMaxScrollDis() {
        return getScrollHeight() - getScrollViewHeight();
    }

    public int getScrollHeight() {
        return this.mContentHeight + this.mBoundHeight;
    }

    public int getScrollViewHeight() {
        int i = this.mScrollViewHeight;
        if (i > 0) {
            return i;
        }
        return this.mContentHeight;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        int heightPixels;
        super.onFinishInflate();
        if (this.mBoundHeight <= 0) {
            heightPixels = 0;
        } else {
            heightPixels = ScreenUtil.getInstance().getHeightPixels();
        }
        this.mContainer.addView(this.mFooterView, getChildCount(), new FrameLayout.LayoutParams(-1, heightPixels));
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int i;
        if (LogUtil.LOGGABLE) {
            LogUtil.e(TAG, "onInterceptTouchEvent() --> event = " + motionEvent);
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action == 3) {
                        VelocityTracker velocityTracker = this.mVelocityTracker;
                        if (velocityTracker != null) {
                            velocityTracker.clear();
                        }
                        stopNestedScroll();
                        this.mDragging = false;
                    }
                } else {
                    motionEvent.getX();
                    int y = (int) (motionEvent.getY() + 0.5f);
                    if (!this.mDragging) {
                        int i2 = y - this.mInitialTouchY;
                        int abs = Math.abs(i2);
                        int i3 = this.mTouchSlop;
                        if (abs > i3) {
                            int i4 = this.mInitialTouchY;
                            if (i2 < 0) {
                                i = -1;
                            } else {
                                i = 1;
                            }
                            this.mLastY = i4 + (i3 * i);
                            this.mDragging = true;
                        }
                    }
                }
            } else {
                this.mVelocityTracker.clear();
                stopNestedScroll();
            }
        } else {
            int y2 = (int) (motionEvent.getY() + 0.5f);
            this.mInitialTouchY = y2;
            this.mLastY = y2;
            int[] iArr = this.mNestedOffsets;
            iArr[1] = 0;
            iArr[0] = 0;
            startNestedScroll(2);
        }
        return this.mDragging;
    }

    @Override // androidx.core.widget.NestedScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (LogUtil.LOGGABLE) {
            LogUtil.e(TAG, "onLayout: changed = " + z + ", l = " + i + ", t = " + i2 + ", r = , b = " + i4);
        }
    }

    @Override // androidx.core.widget.NestedScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.mContentView.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), 0);
        this.mContentHeight = this.mContentView.getMeasuredHeight() + getPaddingTop() + getPaddingBottom();
        if (LogUtil.LOGGABLE) {
            LogUtil.e(TAG, "onMeasure --> widthMeasureSpec = " + i + ", heightMeasureSpec = " + i2 + ", contentHeight = " + this.mContentView.getMeasuredHeight() + ", getPaddingLeft() = " + getPaddingLeft() + ", getPaddingRight() = " + getPaddingRight() + ", getPaddingTop() = " + getPaddingTop() + ", getPaddingBottom() = " + getPaddingBottom());
        }
        setMeasuredDimension(i, getScrollViewHeight());
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        boolean z2;
        boolean z3;
        if (LogUtil.LOGGABLE) {
            LogUtil.e(TAG, "onTouchEvent() --> event = " + motionEvent);
        }
        int action = motionEvent.getAction();
        int y = (int) (motionEvent.getY() + 0.5f);
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        if (action == 0) {
            int[] iArr = this.mNestedOffsets;
            iArr[1] = 0;
            iArr[0] = 0;
        }
        int[] iArr2 = this.mNestedOffsets;
        obtain.offsetLocation(iArr2[0], iArr2[1]);
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(obtain);
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action == 3) {
                        this.mDragging = false;
                        VelocityTracker velocityTracker = this.mVelocityTracker;
                        if (velocityTracker != null) {
                            velocityTracker.clear();
                        }
                    }
                } else {
                    int i = this.mLastY - y;
                    Rect rect = new Rect();
                    boolean localVisibleRect = this.mContentView.getLocalVisibleRect(rect);
                    Rect rect2 = new Rect();
                    boolean localVisibleRect2 = this.mFooterView.getLocalVisibleRect(rect2);
                    if (i < 0 && localVisibleRect && rect.top != 0 && getScrollY() > 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (i > 0 && (!localVisibleRect2 || rect2.bottom < this.mBoundHeight)) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (!z && !z2) {
                        z3 = false;
                    } else {
                        z3 = true;
                    }
                    if (dispatchNestedPreScroll(0, i, this.mScrollConsumed, this.mScrollOffset)) {
                        i -= this.mScrollConsumed[1];
                        int[] iArr3 = this.mScrollOffset;
                        obtain.offsetLocation(iArr3[0], iArr3[1]);
                        int[] iArr4 = this.mNestedOffsets;
                        int i2 = iArr4[0];
                        int[] iArr5 = this.mScrollOffset;
                        iArr4[0] = i2 + iArr5[0];
                        iArr4[1] = iArr4[1] + iArr5[1];
                    }
                    if (LogUtil.LOGGABLE) {
                        LogUtil.e(TAG, "onTouchEvent --> contentViewRevealRect = " + rect);
                        LogUtil.e(TAG, "onTouchEvent --> footViewRevealRect = " + rect2);
                        LogUtil.e(TAG, "onTouchEvent --> isFootViewReveal = " + localVisibleRect2 + ", isCouldScrollTop = " + z + ", isCouldScrollBottom = " + z2 + ", isCouldScroll = " + z3);
                    }
                    if (!this.mDragging) {
                        int abs = Math.abs(i);
                        int i3 = this.mTouchSlop;
                        if (abs > i3) {
                            if (i > 0) {
                                i -= i3;
                            } else {
                                i += i3;
                            }
                            this.mDragging = true;
                        }
                    }
                    if (this.mDragging) {
                        this.mLastY = y - this.mScrollOffset[1];
                        if (z3) {
                            if (z2 && !localVisibleRect2) {
                                scrollByWithLimit(0, i);
                            } else {
                                scrollByWithLimit(0, i / 2);
                            }
                        }
                    }
                }
            } else {
                this.mDragging = false;
                this.mContentView.getLocalVisibleRect(new Rect());
                boolean localVisibleRect3 = this.mFooterView.getLocalVisibleRect(new Rect());
                this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaxFlingVelocity);
                int i4 = -((int) this.mVelocityTracker.getYVelocity());
                if (localVisibleRect3) {
                    startAnimation(new ProgressAnimation(getScrollY() - (this.mContentHeight - getScrollViewHeight())));
                } else {
                    float f = i4;
                    if (!dispatchNestedPreFling(0.0f, f)) {
                        dispatchNestedFling(0.0f, f, true);
                        startNestedScroll(2);
                        int i5 = this.mMaxFlingVelocity;
                        fling(Math.max(-i5, Math.min(i4, i5)));
                    }
                }
                stopNestedScroll();
                VelocityTracker velocityTracker2 = this.mVelocityTracker;
                if (velocityTracker2 != null) {
                    velocityTracker2.clear();
                }
            }
            obtain.recycle();
            return true;
        }
        this.mLastY = (int) (y + 0.5f);
        startNestedScroll(2);
        return true;
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.View
    public void scrollTo(int i, int i2) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(TAG, "scrollTo: x = " + i + ", y = " + i2);
        }
        super.scrollTo(0, i2);
    }

    public void setBoundHeight(int i) {
        this.mBoundHeight = i;
        if (i < 0) {
            this.mBoundHeight = 0;
        }
    }

    public void setContentLayoutVisibility(int i) {
        ViewGroup viewGroup = this.mContentView;
        if (viewGroup != null) {
            viewGroup.setVisibility(i);
        }
    }

    public void setScrollViewHeight(int i) {
        this.mScrollViewHeight = i;
    }

    public InnerScrollView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mBoundHeight = 500;
        this.mScrollOffset = new int[2];
        this.mScrollConsumed = new int[2];
        this.mNestedOffsets = new int[2];
        this.mDrag = 2;
        this.mScrollViewHeight = -1;
        init(context);
    }

    public InnerScrollView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mBoundHeight = 500;
        this.mScrollOffset = new int[2];
        this.mScrollConsumed = new int[2];
        this.mNestedOffsets = new int[2];
        this.mDrag = 2;
        this.mScrollViewHeight = -1;
        init(context);
    }
}
