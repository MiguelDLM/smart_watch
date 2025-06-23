package com.baidu.navisdk.ui.widget.loadmore;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.LayoutRes;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import com.baidu.navisdk.util.common.g;

/* loaded from: classes8.dex */
public class BNSwipeRefreshLayout extends FrameLayout implements NestedScrollingParent {
    private static final int ACTION_LOAD_MORE = 1;
    private static final int ACTION_PULL_REFRESH = 0;
    private static final int GUIDANCE_VIEW_HEIGHT_DEFAULT = 80;
    public static final int NOT_OVER_TRIGGER_POINT = 1;
    public static final int OVER_TRIGGER_POINT = 2;
    public static final int START = 3;
    public static final String TAG = "BNSwipeRefreshLayout";
    private final BNSwipeView footerView;
    private float guidanceViewFlowHeight;
    private float guidanceViewHeight;
    private final BNSwipeView headerView;
    private boolean isConfirm;
    private boolean isNeedTranslateTargetY;
    private int mCurrentAction;
    private boolean mPullLoadEnable;
    private boolean mPullRefreshEnable;
    private volatile boolean mRefreshing;
    private ValueAnimator mResetFootViewValueAnimator;
    private ValueAnimator mStartLoadMoreAnimator;
    private View mTargetView;
    private BNSwipeRefreshListener onRefreshListener;
    private NestedScrollingParentHelper parentHelper;

    /* loaded from: classes8.dex */
    public static class BNSwipeAnimatorListener implements Animator.AnimatorListener {
        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* loaded from: classes8.dex */
    public interface BNSwipeRefreshListener {
        void onLoadMorePullStateChange(float f, int i);

        void onLoading();

        void onRefresh();

        void onRefreshPulStateChange(float f, int i);
    }

    public BNSwipeRefreshLayout(Context context) {
        super(context);
        this.headerView = new BNSwipeView(getContext());
        this.footerView = new BNSwipeView(getContext());
        this.mPullRefreshEnable = true;
        this.mPullLoadEnable = true;
        this.mRefreshing = false;
        this.guidanceViewHeight = 0.0f;
        this.guidanceViewFlowHeight = 0.0f;
        this.mCurrentAction = -1;
        this.isConfirm = false;
        this.isNeedTranslateTargetY = true;
        initView(context, null);
    }

    private void handlerAction() {
        FrameLayout.LayoutParams layoutParams;
        g gVar = g.COMMON_UI;
        gVar.c(TAG, "--handlerAction,mRefreshing:" + this.mRefreshing + ",guidanceViewHeight:" + this.guidanceViewHeight + ",guidanceViewFlowHeight:" + this.guidanceViewFlowHeight);
        if (this.mRefreshing) {
            return;
        }
        this.isConfirm = false;
        if (this.mPullRefreshEnable && this.mCurrentAction == 0) {
            ViewGroup.LayoutParams layoutParams2 = this.headerView.getLayoutParams();
            if (layoutParams2 instanceof FrameLayout.LayoutParams) {
                layoutParams = (FrameLayout.LayoutParams) layoutParams2;
                int i = layoutParams.height;
                if (i >= this.guidanceViewHeight) {
                    startRefresh(i);
                    BNSwipeRefreshListener bNSwipeRefreshListener = this.onRefreshListener;
                    if (bNSwipeRefreshListener != null) {
                        bNSwipeRefreshListener.onRefreshPulStateChange(1.0f, 3);
                    }
                } else if (i > 0) {
                    resetHeaderView(i);
                } else {
                    resetRefreshState();
                }
                if (!this.mPullLoadEnable && this.mCurrentAction == 1) {
                    ViewGroup.LayoutParams layoutParams3 = this.footerView.getLayoutParams();
                    if (layoutParams3 instanceof FrameLayout.LayoutParams) {
                        layoutParams = (FrameLayout.LayoutParams) layoutParams3;
                    }
                    if (layoutParams != null) {
                        gVar.c(TAG, "--handlerAction,lp.height:" + layoutParams.height + ",guidanceViewHeight:" + this.guidanceViewHeight + ",guidanceViewFlowHeight:" + this.guidanceViewFlowHeight);
                        int i2 = layoutParams.height;
                        if (i2 >= this.guidanceViewHeight) {
                            startLoadMore(i2);
                            BNSwipeRefreshListener bNSwipeRefreshListener2 = this.onRefreshListener;
                            if (bNSwipeRefreshListener2 != null) {
                                bNSwipeRefreshListener2.onLoadMorePullStateChange(1.0f, 3);
                                return;
                            }
                            return;
                        }
                        if (i2 > 0) {
                            resetFootView(i2);
                            return;
                        } else {
                            resetLoadMoreState();
                            return;
                        }
                    }
                    return;
                }
            }
        }
        layoutParams = null;
        if (!this.mPullLoadEnable) {
        }
    }

    private void initView(Context context, AttributeSet attributeSet) {
        if (getChildCount() <= 1) {
            this.parentHelper = new NestedScrollingParentHelper(this);
            float dipToPx = dipToPx(context, 80.0f);
            this.guidanceViewHeight = dipToPx;
            this.guidanceViewFlowHeight = dipToPx * 1.5f;
            return;
        }
        throw new RuntimeException("WXSwipeLayout should not have more than one child");
    }

    private boolean moveGuidanceView(float f) {
        if (this.mRefreshing) {
            return false;
        }
        FrameLayout.LayoutParams layoutParams = null;
        if (!canChildScrollUp() && this.mPullRefreshEnable && this.mCurrentAction == 0) {
            ViewGroup.LayoutParams layoutParams2 = this.headerView.getLayoutParams();
            if (layoutParams2 instanceof FrameLayout.LayoutParams) {
                layoutParams = (FrameLayout.LayoutParams) layoutParams2;
            }
            if (layoutParams == null) {
                return false;
            }
            int i = (int) (layoutParams.height + f);
            layoutParams.height = i;
            if (i < 0) {
                layoutParams.height = 0;
            }
            float f2 = layoutParams.height;
            float f3 = this.guidanceViewFlowHeight;
            if (f2 > f3) {
                layoutParams.height = (int) f3;
            }
            BNSwipeRefreshListener bNSwipeRefreshListener = this.onRefreshListener;
            if (bNSwipeRefreshListener != null) {
                float f4 = layoutParams.height;
                float f5 = this.guidanceViewHeight;
                if (f4 >= f5) {
                    bNSwipeRefreshListener.onRefreshPulStateChange(f4 / f5, 2);
                } else {
                    bNSwipeRefreshListener.onRefreshPulStateChange(f4 / f5, 1);
                }
            }
            if (layoutParams.height == 0) {
                this.isConfirm = false;
                this.mCurrentAction = -1;
            }
            this.headerView.setLayoutParams(layoutParams);
            this.headerView.setProgressRotation(layoutParams.height / this.guidanceViewFlowHeight);
            moveTargetView(layoutParams.height);
            return true;
        }
        if (canChildScrollDown() || !this.mPullLoadEnable || this.mCurrentAction != 1) {
            return false;
        }
        ViewGroup.LayoutParams layoutParams3 = this.footerView.getLayoutParams();
        if (layoutParams3 instanceof FrameLayout.LayoutParams) {
            layoutParams = (FrameLayout.LayoutParams) layoutParams3;
        }
        if (layoutParams == null) {
            return false;
        }
        g gVar = g.COMMON_UI;
        gVar.c(TAG, "--moveGuidanceView,lp.height:" + layoutParams.height + ",guidanceViewHeight:" + this.guidanceViewHeight + ",guidanceViewFlowHeight:" + this.guidanceViewFlowHeight);
        int i2 = (int) (((float) layoutParams.height) - f);
        layoutParams.height = i2;
        if (i2 < 0) {
            layoutParams.height = 0;
        }
        float f6 = layoutParams.height;
        float f7 = this.guidanceViewFlowHeight;
        if (f6 > f7) {
            layoutParams.height = (int) f7;
        }
        BNSwipeRefreshListener bNSwipeRefreshListener2 = this.onRefreshListener;
        if (bNSwipeRefreshListener2 != null) {
            float f8 = layoutParams.height;
            float f9 = this.guidanceViewHeight;
            if (f8 >= f9) {
                bNSwipeRefreshListener2.onLoadMorePullStateChange(f8 / f9, 2);
            } else {
                bNSwipeRefreshListener2.onLoadMorePullStateChange(f8 / f9, 1);
            }
        }
        if (layoutParams.height == 0) {
            this.isConfirm = false;
            this.mCurrentAction = -1;
            gVar.c(TAG, "--moveGuidanceView,mCurrentAction:-1");
        }
        this.footerView.setLayoutParams(layoutParams);
        this.footerView.setProgressRotation(layoutParams.height / this.guidanceViewFlowHeight);
        moveTargetView(-layoutParams.height);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void moveTargetView(float f) {
        if (this.isNeedTranslateTargetY) {
            this.mTargetView.setTranslationY(f);
        }
    }

    private void resetFootView(int i) {
        g.COMMON_UI.c(TAG, "--resetFootView,headerViewHeight:" + i + ",resetFootViewValueAnimator:" + this.mResetFootViewValueAnimator);
        this.footerView.stopAnimation();
        this.footerView.setStartEndTrim(0.5f, 1.25f);
        ValueAnimator valueAnimator = this.mResetFootViewValueAnimator;
        if (valueAnimator != null) {
            valueAnimator.removeAllUpdateListeners();
            this.mResetFootViewValueAnimator.removeAllListeners();
            this.mResetFootViewValueAnimator.cancel();
            this.mResetFootViewValueAnimator.setFloatValues(i, 0.0f);
        } else {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(i, 0.0f);
            this.mResetFootViewValueAnimator = ofFloat;
            ofFloat.setDuration(300L);
        }
        this.mResetFootViewValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.navisdk.ui.widget.loadmore.BNSwipeRefreshLayout.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                FrameLayout.LayoutParams layoutParams;
                ViewGroup.LayoutParams layoutParams2 = BNSwipeRefreshLayout.this.footerView.getLayoutParams();
                if (layoutParams2 instanceof FrameLayout.LayoutParams) {
                    layoutParams = (FrameLayout.LayoutParams) layoutParams2;
                } else {
                    layoutParams = null;
                }
                if (layoutParams == null) {
                    return;
                }
                layoutParams.height = (int) ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                BNSwipeRefreshLayout.this.footerView.setLayoutParams(layoutParams);
                BNSwipeRefreshLayout.this.moveTargetView(-layoutParams.height);
            }
        });
        this.mResetFootViewValueAnimator.addListener(new BNSwipeAnimatorListener() { // from class: com.baidu.navisdk.ui.widget.loadmore.BNSwipeRefreshLayout.8
            @Override // com.baidu.navisdk.ui.widget.loadmore.BNSwipeRefreshLayout.BNSwipeAnimatorListener, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                g.COMMON_UI.c(BNSwipeRefreshLayout.TAG, "--resetFootView,onAnimationEnd,animation:" + animator);
                BNSwipeRefreshLayout.this.resetLoadMoreState();
            }
        });
        this.mResetFootViewValueAnimator.start();
    }

    private void resetFootViewResetAnimImmediately() {
        g.COMMON_UI.c(TAG, "--resetFootViewResetAnimImmediately,resetFootViewValueAnimatort:" + this.mResetFootViewValueAnimator);
        this.footerView.stopAnimation();
        this.footerView.setStartEndTrim(0.5f, 1.25f);
        ValueAnimator valueAnimator = this.mResetFootViewValueAnimator;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.mResetFootViewValueAnimator.removeAllUpdateListeners();
            this.mResetFootViewValueAnimator.cancel();
        }
    }

    private void resetHeaderView(int i) {
        this.headerView.stopAnimation();
        this.headerView.setStartEndTrim(0.0f, 0.75f);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(i, 0.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.navisdk.ui.widget.loadmore.BNSwipeRefreshLayout.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                FrameLayout.LayoutParams layoutParams;
                ViewGroup.LayoutParams layoutParams2 = BNSwipeRefreshLayout.this.headerView.getLayoutParams();
                if (layoutParams2 instanceof FrameLayout.LayoutParams) {
                    layoutParams = (FrameLayout.LayoutParams) layoutParams2;
                } else {
                    layoutParams = null;
                }
                if (layoutParams == null) {
                    return;
                }
                layoutParams.height = (int) ((Float) valueAnimator.getAnimatedValue()).floatValue();
                BNSwipeRefreshLayout.this.headerView.setLayoutParams(layoutParams);
                BNSwipeRefreshLayout.this.moveTargetView(layoutParams.height);
            }
        });
        ofFloat.addListener(new BNSwipeAnimatorListener() { // from class: com.baidu.navisdk.ui.widget.loadmore.BNSwipeRefreshLayout.4
            @Override // com.baidu.navisdk.ui.widget.loadmore.BNSwipeRefreshLayout.BNSwipeAnimatorListener, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                BNSwipeRefreshLayout.this.resetRefreshState();
            }
        });
        ofFloat.setDuration(300L);
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetLoadMoreState() {
        g.COMMON_UI.c(TAG, "--resetLoadMoreState");
        this.mRefreshing = false;
        this.isConfirm = false;
        this.mCurrentAction = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetRefreshState() {
        this.mRefreshing = false;
        this.isConfirm = false;
        this.mCurrentAction = -1;
    }

    private void setGuidanceView() {
        addView(this.headerView, new FrameLayout.LayoutParams(-1, 0));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, 0);
        layoutParams.gravity = 80;
        addView(this.footerView, layoutParams);
    }

    private void startLoadMore(int i) {
        g.COMMON_UI.c(TAG, "--startLoadMore,headerViewHeight:" + i);
        this.mRefreshing = true;
        resetFootViewResetAnimImmediately();
        ValueAnimator valueAnimator = this.mStartLoadMoreAnimator;
        if (valueAnimator != null) {
            valueAnimator.removeAllUpdateListeners();
            this.mStartLoadMoreAnimator.removeAllListeners();
            this.mStartLoadMoreAnimator.cancel();
            this.mStartLoadMoreAnimator.setFloatValues(i, this.guidanceViewHeight);
        } else {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(i, this.guidanceViewHeight);
            this.mStartLoadMoreAnimator = ofFloat;
            ofFloat.setDuration(300L);
        }
        this.mStartLoadMoreAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.navisdk.ui.widget.loadmore.BNSwipeRefreshLayout.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                FrameLayout.LayoutParams layoutParams;
                ViewGroup.LayoutParams layoutParams2 = BNSwipeRefreshLayout.this.footerView.getLayoutParams();
                if (layoutParams2 instanceof FrameLayout.LayoutParams) {
                    layoutParams = (FrameLayout.LayoutParams) layoutParams2;
                } else {
                    layoutParams = null;
                }
                if (layoutParams == null) {
                    return;
                }
                layoutParams.height = (int) ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                BNSwipeRefreshLayout.this.footerView.setLayoutParams(layoutParams);
                BNSwipeRefreshLayout.this.moveTargetView(-layoutParams.height);
            }
        });
        this.mStartLoadMoreAnimator.addListener(new BNSwipeAnimatorListener() { // from class: com.baidu.navisdk.ui.widget.loadmore.BNSwipeRefreshLayout.6
            @Override // com.baidu.navisdk.ui.widget.loadmore.BNSwipeRefreshLayout.BNSwipeAnimatorListener, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                g.COMMON_UI.c(BNSwipeRefreshLayout.TAG, "--startLoadMore,onAnimationEnd,animation:" + animator);
                BNSwipeRefreshLayout.this.footerView.startAnimation();
                if (BNSwipeRefreshLayout.this.onRefreshListener != null) {
                    BNSwipeRefreshLayout.this.onRefreshListener.onLoading();
                }
            }
        });
        this.mStartLoadMoreAnimator.start();
    }

    private void startRefresh(int i) {
        this.mRefreshing = true;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(i, this.guidanceViewHeight);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.navisdk.ui.widget.loadmore.BNSwipeRefreshLayout.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                FrameLayout.LayoutParams layoutParams;
                ViewGroup.LayoutParams layoutParams2 = BNSwipeRefreshLayout.this.headerView.getLayoutParams();
                if (layoutParams2 instanceof FrameLayout.LayoutParams) {
                    layoutParams = (FrameLayout.LayoutParams) layoutParams2;
                } else {
                    layoutParams = null;
                }
                if (layoutParams == null) {
                    return;
                }
                layoutParams.height = (int) ((Float) valueAnimator.getAnimatedValue()).floatValue();
                BNSwipeRefreshLayout.this.headerView.setLayoutParams(layoutParams);
                BNSwipeRefreshLayout.this.moveTargetView(layoutParams.height);
            }
        });
        ofFloat.addListener(new BNSwipeAnimatorListener() { // from class: com.baidu.navisdk.ui.widget.loadmore.BNSwipeRefreshLayout.2
            @Override // com.baidu.navisdk.ui.widget.loadmore.BNSwipeRefreshLayout.BNSwipeAnimatorListener, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                BNSwipeRefreshLayout.this.headerView.startAnimation();
                if (BNSwipeRefreshLayout.this.onRefreshListener != null) {
                    BNSwipeRefreshLayout.this.onRefreshListener.onRefresh();
                }
            }
        });
        ofFloat.setDuration(300L);
        ofFloat.start();
    }

    public boolean canChildScrollDown() {
        View view = this.mTargetView;
        if (view == null) {
            return false;
        }
        return ViewCompat.canScrollVertically(view, 1);
    }

    public boolean canChildScrollUp() {
        View view = this.mTargetView;
        if (view == null) {
            return false;
        }
        return ViewCompat.canScrollVertically(view, -1);
    }

    public float dipToPx(Context context, float f) {
        return TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }

    public void finishLoadMore() {
        int measuredHeight;
        g.COMMON_UI.c(TAG, "--finishLoadMore,mCurrentAction:" + this.mCurrentAction + ",ACTION_LOAD_MORE:1");
        if (this.mCurrentAction == 1) {
            BNSwipeView bNSwipeView = this.footerView;
            if (bNSwipeView == null) {
                measuredHeight = 0;
            } else {
                measuredHeight = bNSwipeView.getMeasuredHeight();
            }
            resetFootView(measuredHeight);
        }
    }

    public void finishRefresh() {
        int measuredHeight;
        if (this.mCurrentAction == 0) {
            BNSwipeView bNSwipeView = this.headerView;
            if (bNSwipeView == null) {
                measuredHeight = 0;
            } else {
                measuredHeight = bNSwipeView.getMeasuredHeight();
            }
            resetHeaderView(measuredHeight);
        }
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.parentHelper.getNestedScrollAxes();
    }

    public boolean isLoadMoreEnable() {
        return this.mPullLoadEnable;
    }

    public boolean isRefreshEnable() {
        return this.mPullRefreshEnable;
    }

    public boolean isRefreshing() {
        return this.mRefreshing;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mTargetView = getChildAt(0);
        setGuidanceView();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeView(this.headerView);
        removeView(this.footerView);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.mPullRefreshEnable && !this.mPullLoadEnable) {
            return false;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(View view, float f, float f2) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        if ((!this.mPullRefreshEnable && !this.mPullLoadEnable) || Math.abs(i2) > 200) {
            return;
        }
        if (!this.isConfirm) {
            if (i2 < 0 && !canChildScrollUp()) {
                this.mCurrentAction = 0;
                this.isConfirm = true;
            } else if (i2 > 0 && !canChildScrollDown()) {
                this.mCurrentAction = 1;
                this.isConfirm = true;
            }
        }
        g.COMMON_UI.c(TAG, "--onNestedPreScroll,mCurrentAction:" + this.mCurrentAction);
        if (moveGuidanceView(-i2)) {
            iArr[1] = iArr[1] + i2;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.parentHelper.onNestedScrollAccepted(view, view2, i);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(View view, View view2, int i) {
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(View view) {
        this.parentHelper.onStopNestedScroll(view);
        handlerAction();
    }

    public void setFooterView(@LayoutRes int i) {
        this.footerView.setGuidanceView(i);
    }

    public void setGuidanceViewHeight(int i, int i2) {
        this.guidanceViewHeight = i;
        this.guidanceViewFlowHeight = i2;
    }

    public void setHeaderView(@LayoutRes int i) {
        this.headerView.setGuidanceView(i);
    }

    public void setLoadMoreEnable(boolean z) {
        this.mPullLoadEnable = z;
    }

    public void setNeedTranslateTargetY(boolean z) {
        this.isNeedTranslateTargetY = z;
    }

    public void setOnRefreshListener(BNSwipeRefreshListener bNSwipeRefreshListener) {
        this.onRefreshListener = bNSwipeRefreshListener;
    }

    public void setRefreshEnable(boolean z) {
        this.mPullRefreshEnable = z;
    }

    public void setFooterView(View view) {
        this.footerView.setGuidanceView(view);
    }

    public void setHeaderView(View view) {
        this.headerView.setGuidanceView(view);
    }

    public BNSwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.headerView = new BNSwipeView(getContext());
        this.footerView = new BNSwipeView(getContext());
        this.mPullRefreshEnable = true;
        this.mPullLoadEnable = true;
        this.mRefreshing = false;
        this.guidanceViewHeight = 0.0f;
        this.guidanceViewFlowHeight = 0.0f;
        this.mCurrentAction = -1;
        this.isConfirm = false;
        this.isNeedTranslateTargetY = true;
        initView(context, attributeSet);
    }

    public BNSwipeRefreshLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.headerView = new BNSwipeView(getContext());
        this.footerView = new BNSwipeView(getContext());
        this.mPullRefreshEnable = true;
        this.mPullLoadEnable = true;
        this.mRefreshing = false;
        this.guidanceViewHeight = 0.0f;
        this.guidanceViewFlowHeight = 0.0f;
        this.mCurrentAction = -1;
        this.isConfirm = false;
        this.isNeedTranslateTargetY = true;
        initView(context, attributeSet);
    }

    @TargetApi(21)
    public BNSwipeRefreshLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.headerView = new BNSwipeView(getContext());
        this.footerView = new BNSwipeView(getContext());
        this.mPullRefreshEnable = true;
        this.mPullLoadEnable = true;
        this.mRefreshing = false;
        this.guidanceViewHeight = 0.0f;
        this.guidanceViewFlowHeight = 0.0f;
        this.mCurrentAction = -1;
        this.isConfirm = false;
        this.isNeedTranslateTargetY = true;
        initView(context, attributeSet);
    }
}
