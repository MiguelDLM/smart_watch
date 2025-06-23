package com.sma.smartv3.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;
import com.google.android.material.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Vector;

/* loaded from: classes12.dex */
public class AnchorBottomSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    private static final int DEFAULT_ANCHOR_POINT = 700;
    private static final float HIDE_FRICTION = 0.1f;
    private static final float HIDE_THRESHOLD = 0.5f;
    public static final int STATE_ANCHOR_POINT = 3;
    public static final int STATE_COLLAPSED = 5;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_EXPANDED = 4;
    public static final int STATE_HIDDEN = 6;
    public static final int STATE_SETTLING = 2;
    private int mActivePointerId;
    private int mAnchorPoint;
    private Vector<II0xO0> mCallback;
    private boolean mCollapsible;
    private final ViewDragHelper.Callback mDragCallback;
    private boolean mHideable;
    private boolean mIgnoreEvents;
    private int mInitialY;
    private int mLastStableState;
    private int mMaxOffset;
    private int mMinOffset;
    private float mMinimumVelocity;
    private boolean mNestedScrolled;
    private WeakReference<View> mNestedScrollingChildRef;
    private int mParentHeight;
    private int mPeekHeight;
    private AnchorBottomSheetBehavior<V>.I0Io mScrollVelocityTracker;
    private int mState;
    private boolean mTouchingScrollingChild;
    private ViewDragHelper mViewDragHelper;
    private WeakReference<V> mViewRef;

    /* loaded from: classes12.dex */
    public static abstract class II0xO0 {
        public abstract void II0xO0(@NonNull View bottomSheet, int newState);

        public abstract void oIX0oI(@NonNull View bottomSheet, float slideOffset);
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes12.dex */
    public @interface X0o0xo {
    }

    /* loaded from: classes12.dex */
    public class oIX0oI extends ViewDragHelper.Callback {
        public oIX0oI() {
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionHorizontal(View child, int left, int dx) {
            return child.getLeft();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionVertical(View child, int top, int dy) {
            return oIX0oI(top, AnchorBottomSheetBehavior.this.mMinOffset, AnchorBottomSheetBehavior.this.mHideable ? AnchorBottomSheetBehavior.this.mParentHeight : AnchorBottomSheetBehavior.this.mMaxOffset);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int getViewVerticalDragRange(View child) {
            int i;
            int i2;
            if (AnchorBottomSheetBehavior.this.mHideable) {
                i = AnchorBottomSheetBehavior.this.mParentHeight;
                i2 = AnchorBottomSheetBehavior.this.mMinOffset;
            } else {
                i = AnchorBottomSheetBehavior.this.mMaxOffset;
                i2 = AnchorBottomSheetBehavior.this.mMinOffset;
            }
            return i - i2;
        }

        public int oIX0oI(int amount, int low, int high) {
            return amount < low ? low : amount > high ? high : amount;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewDragStateChanged(int state) {
            if (state == 1) {
                AnchorBottomSheetBehavior.this.setStateInternal(1);
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewPositionChanged(View changedView, int left, int top, int dx, int dy) {
            AnchorBottomSheetBehavior.this.dispatchOnSlide(top);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewReleased(View releasedChild, float xvel, float yvel) {
            int i;
            int i2 = 4;
            if (yvel < 0.0f) {
                i = AnchorBottomSheetBehavior.this.mMinOffset;
            } else if (AnchorBottomSheetBehavior.this.mHideable && AnchorBottomSheetBehavior.this.shouldHide(releasedChild, yvel)) {
                i = AnchorBottomSheetBehavior.this.mParentHeight;
                i2 = 6;
            } else {
                if (yvel != 0.0f) {
                    i = AnchorBottomSheetBehavior.this.mMaxOffset;
                } else {
                    int top = releasedChild.getTop();
                    if (Math.abs(top - AnchorBottomSheetBehavior.this.mMinOffset) < Math.abs(top - AnchorBottomSheetBehavior.this.mMaxOffset)) {
                        i = AnchorBottomSheetBehavior.this.mMinOffset;
                    } else {
                        i = AnchorBottomSheetBehavior.this.mMaxOffset;
                    }
                }
                i2 = 5;
            }
            if (!AnchorBottomSheetBehavior.this.mCollapsible && i2 == 5) {
                i = AnchorBottomSheetBehavior.this.mAnchorPoint;
                i2 = 3;
            }
            if (AnchorBottomSheetBehavior.this.mViewDragHelper.settleCapturedViewAt(releasedChild.getLeft(), i)) {
                AnchorBottomSheetBehavior.this.setStateInternal(2);
                ViewCompat.postOnAnimation(releasedChild, new oxoX(releasedChild, i2));
            } else {
                AnchorBottomSheetBehavior.this.setStateInternal(i2);
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean tryCaptureView(View child, int pointerId) {
            View view;
            if (AnchorBottomSheetBehavior.this.mState == 1 || AnchorBottomSheetBehavior.this.mTouchingScrollingChild) {
                return false;
            }
            if ((AnchorBottomSheetBehavior.this.mState == 4 && AnchorBottomSheetBehavior.this.mActivePointerId == pointerId && (view = (View) AnchorBottomSheetBehavior.this.mNestedScrollingChildRef.get()) != null && view.canScrollVertically(-1)) || AnchorBottomSheetBehavior.this.mViewRef == null || AnchorBottomSheetBehavior.this.mViewRef.get() != child) {
                return false;
            }
            return true;
        }
    }

    /* loaded from: classes12.dex */
    public class oxoX implements Runnable {

        /* renamed from: Oo, reason: collision with root package name */
        public final int f24769Oo;

        /* renamed from: XO, reason: collision with root package name */
        public final View f24770XO;

        public oxoX(View view, int targetState) {
            this.f24770XO = view;
            this.f24769Oo = targetState;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (AnchorBottomSheetBehavior.this.mViewDragHelper == null || !AnchorBottomSheetBehavior.this.mViewDragHelper.continueSettling(true)) {
                AnchorBottomSheetBehavior.this.setStateInternal(this.f24769Oo);
            } else {
                ViewCompat.postOnAnimation(this.f24770XO, this);
            }
        }
    }

    public AnchorBottomSheetBehavior() {
        this.mState = 3;
        this.mLastStableState = 3;
        this.mScrollVelocityTracker = new I0Io(this, null);
        this.mDragCallback = new oIX0oI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchOnSlide(int top) {
        V v = this.mViewRef.get();
        if (v != null && this.mCallback != null) {
            if (top > this.mMaxOffset) {
                notifyOnSlideToListeners(v, (r1 - top) / this.mPeekHeight);
            } else {
                notifyOnSlideToListeners(v, (r1 - top) / (r1 - this.mMinOffset));
            }
        }
    }

    private View findScrollingChild(View view) {
        if (view instanceof NestedScrollingChild) {
            return view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View findScrollingChild = findScrollingChild(viewGroup.getChildAt(i));
                if (findScrollingChild != null) {
                    return findScrollingChild;
                }
            }
            return null;
        }
        return null;
    }

    public static <V extends View> AnchorBottomSheetBehavior<V> from(V view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) layoutParams).getBehavior();
            if (behavior instanceof AnchorBottomSheetBehavior) {
                return (AnchorBottomSheetBehavior) behavior;
            }
            throw new IllegalArgumentException("The view is not associated with AnchorBottomSheetBehavior");
        }
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }

    private void notifyOnSlideToListeners(@NonNull View bottomSheet, float slideOffset) {
        Iterator<II0xO0> it = this.mCallback.iterator();
        while (it.hasNext()) {
            it.next().oIX0oI(bottomSheet, slideOffset);
        }
    }

    private void notifyStateChangedToListeners(@NonNull View bottomSheet, int newState) {
        Iterator<II0xO0> it = this.mCallback.iterator();
        while (it.hasNext()) {
            it.next().II0xO0(bottomSheet, newState);
        }
    }

    private void reset() {
        this.mActivePointerId = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStateInternal(int state) {
        if (this.mState == state) {
            return;
        }
        this.mState = state;
        V v = this.mViewRef.get();
        if (v != null && this.mCallback != null) {
            notifyStateChangedToListeners(v, state);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean shouldHide(View child, float yvel) {
        if (child.getTop() < this.mMaxOffset || Math.abs((child.getTop() + (yvel * 0.1f)) - this.mMaxOffset) / this.mPeekHeight <= 0.5f) {
            return false;
        }
        return true;
    }

    public void addBottomSheetCallback(II0xO0 callback) {
        if (this.mCallback == null) {
            this.mCallback = new Vector<>();
        }
        this.mCallback.add(callback);
    }

    public int getAnchorPoint() {
        return this.mAnchorPoint;
    }

    public final int getPeekHeight() {
        return this.mPeekHeight;
    }

    public final int getState() {
        return this.mState;
    }

    public boolean isCollapsible() {
        return this.mCollapsible;
    }

    public boolean isHideable() {
        return this.mHideable;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(CoordinatorLayout parent, V child, MotionEvent event) {
        boolean z;
        if (!child.isShown()) {
            this.mIgnoreEvents = true;
            return false;
        }
        int actionMasked = event.getActionMasked();
        if (actionMasked == 0) {
            reset();
        }
        if (actionMasked != 0) {
            if (actionMasked == 1 || actionMasked == 3) {
                this.mTouchingScrollingChild = false;
                this.mActivePointerId = -1;
                if (this.mIgnoreEvents) {
                    this.mIgnoreEvents = false;
                    return false;
                }
            }
        } else {
            this.mScrollVelocityTracker.oIX0oI();
            int x = (int) event.getX();
            this.mInitialY = (int) event.getY();
            if (this.mState == 3) {
                this.mActivePointerId = event.getPointerId(event.getActionIndex());
                this.mTouchingScrollingChild = true;
            } else {
                View view = this.mNestedScrollingChildRef.get();
                if (view != null && parent.isPointInChildBounds(view, x, this.mInitialY)) {
                    this.mActivePointerId = event.getPointerId(event.getActionIndex());
                    this.mTouchingScrollingChild = true;
                }
            }
            if (this.mActivePointerId == -1 && !parent.isPointInChildBounds(child, x, this.mInitialY)) {
                z = true;
            } else {
                z = false;
            }
            this.mIgnoreEvents = z;
        }
        if (!this.mIgnoreEvents && this.mViewDragHelper.shouldInterceptTouchEvent(event)) {
            return true;
        }
        View view2 = this.mNestedScrollingChildRef.get();
        if (actionMasked != 2 || view2 == null || this.mIgnoreEvents || this.mState == 1 || parent.isPointInChildBounds(view2, (int) event.getX(), (int) event.getY()) || Math.abs(this.mInitialY - event.getY()) <= this.mViewDragHelper.getTouchSlop()) {
            return false;
        }
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout parent, V child, int layoutDirection) {
        int i = this.mState;
        if (i != 1 && i != 2) {
            if (parent.getFitsSystemWindows() && !child.getFitsSystemWindows()) {
                child.setFitsSystemWindows(true);
            }
            parent.onLayoutChild(child, layoutDirection);
        }
        int height = parent.getHeight();
        this.mParentHeight = height;
        int max = Math.max(0, height - child.getHeight());
        this.mMinOffset = max;
        int max2 = Math.max(this.mParentHeight - this.mPeekHeight, max);
        this.mMaxOffset = max2;
        int i2 = this.mState;
        if (i2 == 3) {
            ViewCompat.offsetTopAndBottom(child, this.mAnchorPoint);
        } else if (i2 == 4) {
            ViewCompat.offsetTopAndBottom(child, this.mMinOffset);
        } else if (this.mHideable && i2 == 6) {
            ViewCompat.offsetTopAndBottom(child, this.mParentHeight);
        } else if (i2 == 5) {
            ViewCompat.offsetTopAndBottom(child, max2);
        }
        if (this.mViewDragHelper == null) {
            this.mViewDragHelper = ViewDragHelper.create(parent, this.mDragCallback);
        }
        this.mViewRef = new WeakReference<>(child);
        this.mNestedScrollingChildRef = new WeakReference<>(findScrollingChild(child));
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, V child, View target, float velocityX, float velocityY) {
        if (target == this.mNestedScrollingChildRef.get() && (this.mState != 4 || super.onNestedPreFling(coordinatorLayout, child, target, velocityX, velocityY))) {
            return true;
        }
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, V child, View target, int dx, int dy, int[] consumed, int type) {
        if (target != this.mNestedScrollingChildRef.get()) {
            return;
        }
        this.mScrollVelocityTracker.I0Io(dy);
        int top = child.getTop();
        int i = top - dy;
        int i2 = this.mLastStableState;
        if ((i2 == 5 && i < this.mAnchorPoint) || (i2 == 4 && i > this.mAnchorPoint)) {
            consumed[1] = dy;
            ViewCompat.offsetTopAndBottom(child, this.mAnchorPoint - top);
            dispatchOnSlide(child.getTop());
            this.mNestedScrolled = true;
            return;
        }
        if (dy > 0) {
            int i3 = this.mMinOffset;
            if (i < i3) {
                int i4 = top - i3;
                consumed[1] = i4;
                ViewCompat.offsetTopAndBottom(child, -i4);
                setStateInternal(4);
            } else {
                consumed[1] = dy;
                ViewCompat.offsetTopAndBottom(child, -dy);
                setStateInternal(1);
            }
        } else if (dy < 0 && !ViewCompat.canScrollVertically(target, -1)) {
            int i5 = this.mMaxOffset;
            if (i > i5 && !this.mHideable) {
                int i6 = top - i5;
                consumed[1] = i6;
                ViewCompat.offsetTopAndBottom(child, -i6);
                setStateInternal(5);
            } else {
                boolean z = this.mCollapsible;
                if (z || (!z && this.mAnchorPoint - i >= 0)) {
                    consumed[1] = dy;
                    ViewCompat.offsetTopAndBottom(child, -dy);
                    setStateInternal(1);
                }
            }
        }
        dispatchOnSlide(child.getTop());
        this.mNestedScrolled = true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onRestoreInstanceState(CoordinatorLayout parent, V child, Parcelable state) {
        SavedState savedState = (SavedState) state;
        super.onRestoreInstanceState(parent, child, savedState.getSuperState());
        int i = savedState.f24766XO;
        if (i != 1 && i != 2) {
            this.mState = i;
        } else {
            this.mState = 5;
        }
        this.mLastStableState = this.mState;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public Parcelable onSaveInstanceState(CoordinatorLayout parent, V child) {
        return new SavedState(super.onSaveInstanceState(parent, child), this.mState);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V child, View directTargetChild, View target, int nestedScrollAxes, int type) {
        this.mNestedScrolled = false;
        if ((nestedScrollAxes & 2) == 0) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0095  */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onStopNestedScroll(androidx.coordinatorlayout.widget.CoordinatorLayout r10, V r11, android.view.View r12, int r13) {
        /*
            r9 = this;
            int r10 = r11.getTop()
            int r13 = r9.mMinOffset
            r0 = 4
            if (r10 != r13) goto Lf
            r9.setStateInternal(r0)
            r9.mLastStableState = r0
            return
        Lf:
            java.lang.ref.WeakReference<android.view.View> r10 = r9.mNestedScrollingChildRef
            java.lang.Object r10 = r10.get()
            if (r12 != r10) goto L9b
            boolean r10 = r9.mNestedScrolled
            if (r10 != 0) goto L1d
            goto L9b
        L1d:
            com.sma.smartv3.view.AnchorBottomSheetBehavior<V>$I0Io r10 = r9.mScrollVelocityTracker
            float r10 = r10.II0xO0()
            float r12 = r9.mMinimumVelocity
            r13 = 5
            r1 = 3
            int r2 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r2 <= 0) goto L3b
            int r10 = r9.mLastStableState
            if (r10 != r13) goto L33
            int r10 = r9.mAnchorPoint
        L31:
            r0 = 3
            goto L7a
        L33:
            if (r10 != r1) goto L38
            int r10 = r9.mMinOffset
            goto L7a
        L38:
            int r10 = r9.mMinOffset
            goto L7a
        L3b:
            float r12 = -r12
            r2 = 1
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 >= 0) goto L58
            int r10 = r9.mLastStableState
            if (r10 != r0) goto L48
            int r10 = r9.mAnchorPoint
            goto L31
        L48:
            boolean r12 = r9.mCollapsible
            if (r12 != r2) goto L55
            if (r10 != r1) goto L52
            int r10 = r9.mMaxOffset
        L50:
            r0 = 5
            goto L7a
        L52:
            int r10 = r9.mMaxOffset
            goto L50
        L55:
            int r10 = r9.mAnchorPoint
            goto L31
        L58:
            int r10 = r11.getTop()
            double r3 = (double) r10
            int r10 = r9.mAnchorPoint
            double r5 = (double) r10
            r7 = 4608308318706860032(0x3ff4000000000000, double:1.25)
            double r5 = r5 * r7
            int r12 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r12 <= 0) goto L6f
            boolean r12 = r9.mCollapsible
            if (r12 != r2) goto L6f
            int r10 = r9.mMaxOffset
            goto L50
        L6f:
            double r12 = (double) r10
            r5 = 4602678819172646912(0x3fe0000000000000, double:0.5)
            double r12 = r12 * r5
            int r2 = (r3 > r12 ? 1 : (r3 == r12 ? 0 : -1))
            if (r2 >= 0) goto L31
            int r10 = r9.mMinOffset
        L7a:
            r9.mLastStableState = r0
            androidx.customview.widget.ViewDragHelper r12 = r9.mViewDragHelper
            int r13 = r11.getLeft()
            boolean r10 = r12.smoothSlideViewTo(r11, r13, r10)
            if (r10 == 0) goto L95
            r10 = 2
            r9.setStateInternal(r10)
            com.sma.smartv3.view.AnchorBottomSheetBehavior$oxoX r10 = new com.sma.smartv3.view.AnchorBottomSheetBehavior$oxoX
            r10.<init>(r11, r0)
            androidx.core.view.ViewCompat.postOnAnimation(r11, r10)
            goto L98
        L95:
            r9.setStateInternal(r0)
        L98:
            r10 = 0
            r9.mNestedScrolled = r10
        L9b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.view.AnchorBottomSheetBehavior.onStopNestedScroll(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.View, int):void");
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onTouchEvent(CoordinatorLayout parent, V child, MotionEvent event) {
        if (!child.isShown()) {
            return false;
        }
        int actionMasked = event.getActionMasked();
        if (this.mState == 1 && actionMasked == 0) {
            return true;
        }
        if (this.mLastStableState == 3 && actionMasked == 2 && event.getY() > this.mInitialY && !this.mCollapsible) {
            reset();
            return false;
        }
        if (this.mViewDragHelper == null) {
            this.mViewDragHelper = ViewDragHelper.create(parent, this.mDragCallback);
        }
        this.mViewDragHelper.processTouchEvent(event);
        if (actionMasked == 0) {
            reset();
        }
        if (actionMasked == 2 && !this.mIgnoreEvents && Math.abs(this.mInitialY - event.getY()) > this.mViewDragHelper.getTouchSlop()) {
            this.mViewDragHelper.captureChildView(child, event.getPointerId(event.getActionIndex()));
        }
        return !this.mIgnoreEvents;
    }

    public void setAnchorPoint(int anchorPoint) {
        this.mAnchorPoint = anchorPoint;
    }

    public void setCollapsible(boolean collapsible) {
        this.mCollapsible = collapsible;
    }

    public void setHideable(boolean hideable) {
        this.mHideable = hideable;
    }

    public final void setPeekHeight(int peekHeight) {
        this.mPeekHeight = Math.max(0, peekHeight);
        this.mMaxOffset = this.mParentHeight - peekHeight;
    }

    public final void setState(int state) {
        V v;
        int i;
        if (state == this.mState) {
            return;
        }
        if (state == 5 || state == 4 || state == 3 || (this.mHideable && state == 6)) {
            this.mState = state;
            this.mLastStableState = state;
        }
        WeakReference<V> weakReference = this.mViewRef;
        if (weakReference == null) {
            v = null;
        } else {
            v = weakReference.get();
        }
        if (v == null) {
            return;
        }
        if (state == 5) {
            i = this.mMaxOffset;
        } else if (state == 3) {
            i = this.mAnchorPoint;
        } else if (state == 4) {
            i = this.mMinOffset;
        } else if (this.mHideable && state == 6) {
            i = this.mParentHeight;
        } else {
            throw new IllegalArgumentException("Illegal state argument: " + state);
        }
        setStateInternal(2);
        if (this.mViewDragHelper.smoothSlideViewTo(v, v.getLeft(), i)) {
            ViewCompat.postOnAnimation(v, new oxoX(v, state));
        }
    }

    /* loaded from: classes12.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new oIX0oI();

        /* renamed from: XO, reason: collision with root package name */
        public final int f24766XO;

        /* loaded from: classes12.dex */
        public class oIX0oI implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: II0xO0, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel source) {
                return new SavedState(source);
            }
        }

        public SavedState(Parcel source) {
            super(source);
            this.f24766XO = source.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel out, int flags) {
            super.writeToParcel(out, flags);
            out.writeInt(this.f24766XO);
        }

        public SavedState(Parcelable superState, int state) {
            super(superState);
            this.f24766XO = state;
        }
    }

    /* loaded from: classes12.dex */
    public class I0Io {

        /* renamed from: II0xO0, reason: collision with root package name */
        public float f24764II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public long f24765oIX0oI;

        public I0Io() {
            this.f24765oIX0oI = 0L;
            this.f24764II0xO0 = 0.0f;
        }

        public void I0Io(int dy) {
            long currentTimeMillis = System.currentTimeMillis();
            long j = this.f24765oIX0oI;
            if (j != 0) {
                this.f24764II0xO0 = (dy / ((float) (currentTimeMillis - j))) * 1000.0f;
            }
            this.f24765oIX0oI = currentTimeMillis;
        }

        public float II0xO0() {
            return this.f24764II0xO0;
        }

        public void oIX0oI() {
            this.f24765oIX0oI = 0L;
            this.f24764II0xO0 = 0.0f;
        }

        public /* synthetic */ I0Io(AnchorBottomSheetBehavior anchorBottomSheetBehavior, oIX0oI oix0oi) {
            this();
        }
    }

    public AnchorBottomSheetBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mState = 3;
        this.mLastStableState = 3;
        this.mScrollVelocityTracker = new I0Io(this, null);
        this.mDragCallback = new oIX0oI();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.BottomSheetBehavior_Layout);
        setPeekHeight(obtainStyledAttributes.getDimensionPixelSize(9, 0));
        setHideable(obtainStyledAttributes.getBoolean(8, false));
        obtainStyledAttributes.recycle();
        this.mAnchorPoint = 700;
        this.mCollapsible = true;
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attrs, com.sma.smartv3.R.styleable.AnchorBottomSheetBehavior);
        if (attrs != null) {
            this.mAnchorPoint = (int) obtainStyledAttributes2.getDimension(0, 0.0f);
            this.mState = obtainStyledAttributes2.getInt(1, 3);
        }
        obtainStyledAttributes2.recycle();
        this.mMinimumVelocity = ViewConfiguration.get(context).getScaledMinimumFlingVelocity();
    }
}
