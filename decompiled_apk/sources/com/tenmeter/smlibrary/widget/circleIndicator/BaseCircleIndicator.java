package com.tenmeter.smlibrary.widget.circleIndicator;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.tenmeter.smlibrary.R;

/* loaded from: classes13.dex */
class BaseCircleIndicator extends LinearLayout {
    private static final int DEFAULT_INDICATOR_WIDTH = 5;
    protected Animator mAnimatorIn;
    protected Animator mAnimatorOut;
    protected Animator mImmediateAnimatorIn;
    protected Animator mImmediateAnimatorOut;
    protected int mIndicatorBackgroundResId;
    private IndicatorCreatedListener mIndicatorCreatedListener;
    protected int mIndicatorHeight;
    protected int mIndicatorMargin;
    protected ColorStateList mIndicatorTintColor;
    protected ColorStateList mIndicatorTintUnselectedColor;
    protected int mIndicatorUnselectedBackgroundResId;
    protected int mIndicatorWidth;
    protected int mLastPosition;

    /* loaded from: classes13.dex */
    public interface IndicatorCreatedListener {
        void onIndicatorCreated(View view, int i);
    }

    /* loaded from: classes13.dex */
    public static class ReverseInterpolator implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return Math.abs(1.0f - f);
        }
    }

    public BaseCircleIndicator(Context context) {
        super(context);
        this.mIndicatorMargin = -1;
        this.mIndicatorWidth = -1;
        this.mIndicatorHeight = -1;
        this.mLastPosition = -1;
        init(context, null);
    }

    private void bindIndicatorBackground(View view, int i, ColorStateList colorStateList) {
        if (colorStateList != null) {
            Drawable wrap = DrawableCompat.wrap(ContextCompat.getDrawable(getContext(), i).mutate());
            DrawableCompat.setTintList(wrap, colorStateList);
            ViewCompat.setBackground(view, wrap);
            return;
        }
        view.setBackgroundResource(i);
    }

    private Config handleTypedArray(Context context, AttributeSet attributeSet) {
        Config config = new Config();
        if (attributeSet == null) {
            return config;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SMBaseCircleIndicator);
        config.width = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SMBaseCircleIndicator_sm_ci_width, -1);
        config.height = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SMBaseCircleIndicator_sm_ci_height, -1);
        config.margin = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SMBaseCircleIndicator_sm_ci_margin, -1);
        config.animatorResId = obtainStyledAttributes.getResourceId(R.styleable.SMBaseCircleIndicator_sm_ci_animator, R.animator.scale_with_alpha);
        config.animatorReverseResId = obtainStyledAttributes.getResourceId(R.styleable.SMBaseCircleIndicator_sm_ci_animator_reverse, 0);
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.SMBaseCircleIndicator_sm_ci_drawable, R.drawable.white_radius);
        config.backgroundResId = resourceId;
        config.unselectedBackgroundId = obtainStyledAttributes.getResourceId(R.styleable.SMBaseCircleIndicator_sm_ci_drawable_unselected, resourceId);
        config.orientation = obtainStyledAttributes.getInt(R.styleable.SMBaseCircleIndicator_sm_ci_orientation, -1);
        config.gravity = obtainStyledAttributes.getInt(R.styleable.SMBaseCircleIndicator_sm_ci_gravity, -1);
        obtainStyledAttributes.recycle();
        return config;
    }

    private void init(Context context, AttributeSet attributeSet) {
        initialize(handleTypedArray(context, attributeSet));
        if (isInEditMode()) {
            createIndicators(3, 1);
        }
    }

    public void addIndicator(int i) {
        View view = new View(getContext());
        LinearLayout.LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
        generateDefaultLayoutParams.width = this.mIndicatorWidth;
        generateDefaultLayoutParams.height = this.mIndicatorHeight;
        if (i == 0) {
            int i2 = this.mIndicatorMargin;
            generateDefaultLayoutParams.leftMargin = i2;
            generateDefaultLayoutParams.rightMargin = i2;
        } else {
            int i3 = this.mIndicatorMargin;
            generateDefaultLayoutParams.topMargin = i3;
            generateDefaultLayoutParams.bottomMargin = i3;
        }
        addView(view, generateDefaultLayoutParams);
    }

    public void animatePageSelected(int i) {
        View childAt;
        if (this.mLastPosition == i) {
            return;
        }
        if (this.mAnimatorIn.isRunning()) {
            this.mAnimatorIn.end();
            this.mAnimatorIn.cancel();
        }
        if (this.mAnimatorOut.isRunning()) {
            this.mAnimatorOut.end();
            this.mAnimatorOut.cancel();
        }
        int i2 = this.mLastPosition;
        if (i2 >= 0 && (childAt = getChildAt(i2)) != null) {
            bindIndicatorBackground(childAt, this.mIndicatorUnselectedBackgroundResId, this.mIndicatorTintUnselectedColor);
            this.mAnimatorIn.setTarget(childAt);
            this.mAnimatorIn.start();
        }
        View childAt2 = getChildAt(i);
        if (childAt2 != null) {
            bindIndicatorBackground(childAt2, this.mIndicatorBackgroundResId, this.mIndicatorTintColor);
            this.mAnimatorOut.setTarget(childAt2);
            this.mAnimatorOut.start();
        }
        this.mLastPosition = i;
    }

    public void changeIndicatorBackground() {
        int childCount = getChildCount();
        if (childCount <= 0) {
            return;
        }
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (i == this.mLastPosition) {
                bindIndicatorBackground(childAt, this.mIndicatorBackgroundResId, this.mIndicatorTintColor);
            } else {
                bindIndicatorBackground(childAt, this.mIndicatorUnselectedBackgroundResId, this.mIndicatorTintUnselectedColor);
            }
        }
    }

    public void changeIndicatorResource(int i) {
        changeIndicatorResource(i, i);
    }

    public Animator createAnimatorIn(Config config) {
        if (config.animatorReverseResId == 0) {
            Animator loadAnimator = AnimatorInflater.loadAnimator(getContext(), config.animatorResId);
            loadAnimator.setInterpolator(new ReverseInterpolator());
            return loadAnimator;
        }
        return AnimatorInflater.loadAnimator(getContext(), config.animatorReverseResId);
    }

    public Animator createAnimatorOut(Config config) {
        return AnimatorInflater.loadAnimator(getContext(), config.animatorResId);
    }

    public void createIndicators(int i, int i2) {
        if (this.mImmediateAnimatorOut.isRunning()) {
            this.mImmediateAnimatorOut.end();
            this.mImmediateAnimatorOut.cancel();
        }
        if (this.mImmediateAnimatorIn.isRunning()) {
            this.mImmediateAnimatorIn.end();
            this.mImmediateAnimatorIn.cancel();
        }
        int childCount = getChildCount();
        if (i < childCount) {
            removeViews(i, childCount - i);
        } else if (i > childCount) {
            int i3 = i - childCount;
            int orientation = getOrientation();
            for (int i4 = 0; i4 < i3; i4++) {
                addIndicator(orientation);
            }
        }
        for (int i5 = 0; i5 < i; i5++) {
            View childAt = getChildAt(i5);
            if (i2 == i5) {
                bindIndicatorBackground(childAt, this.mIndicatorBackgroundResId, this.mIndicatorTintColor);
                this.mImmediateAnimatorOut.setTarget(childAt);
                this.mImmediateAnimatorOut.start();
                this.mImmediateAnimatorOut.end();
            } else {
                bindIndicatorBackground(childAt, this.mIndicatorUnselectedBackgroundResId, this.mIndicatorTintUnselectedColor);
                this.mImmediateAnimatorIn.setTarget(childAt);
                this.mImmediateAnimatorIn.start();
                this.mImmediateAnimatorIn.end();
            }
            IndicatorCreatedListener indicatorCreatedListener = this.mIndicatorCreatedListener;
            if (indicatorCreatedListener != null) {
                indicatorCreatedListener.onIndicatorCreated(childAt, i5);
            }
        }
        this.mLastPosition = i2;
    }

    public void initialize(Config config) {
        int i;
        int i2 = 1;
        int applyDimension = (int) (TypedValue.applyDimension(1, 5.0f, getResources().getDisplayMetrics()) + 0.5f);
        int i3 = config.width;
        if (i3 < 0) {
            i3 = applyDimension;
        }
        this.mIndicatorWidth = i3;
        int i4 = config.height;
        if (i4 < 0) {
            i4 = applyDimension;
        }
        this.mIndicatorHeight = i4;
        int i5 = config.margin;
        if (i5 >= 0) {
            applyDimension = i5;
        }
        this.mIndicatorMargin = applyDimension;
        this.mAnimatorOut = createAnimatorOut(config);
        Animator createAnimatorOut = createAnimatorOut(config);
        this.mImmediateAnimatorOut = createAnimatorOut;
        createAnimatorOut.setDuration(0L);
        this.mAnimatorIn = createAnimatorIn(config);
        Animator createAnimatorIn = createAnimatorIn(config);
        this.mImmediateAnimatorIn = createAnimatorIn;
        createAnimatorIn.setDuration(0L);
        int i6 = config.backgroundResId;
        if (i6 == 0) {
            i = R.drawable.white_radius;
        } else {
            i = i6;
        }
        this.mIndicatorBackgroundResId = i;
        int i7 = config.unselectedBackgroundId;
        if (i7 != 0) {
            i6 = i7;
        }
        this.mIndicatorUnselectedBackgroundResId = i6;
        if (config.orientation != 1) {
            i2 = 0;
        }
        setOrientation(i2);
        int i8 = config.gravity;
        if (i8 < 0) {
            i8 = 17;
        }
        setGravity(i8);
    }

    public void setIndicatorCreatedListener(IndicatorCreatedListener indicatorCreatedListener) {
        this.mIndicatorCreatedListener = indicatorCreatedListener;
    }

    public void tintIndicator(int i) {
        tintIndicator(i, i);
    }

    public void changeIndicatorResource(int i, int i2) {
        this.mIndicatorBackgroundResId = i;
        this.mIndicatorUnselectedBackgroundResId = i2;
        changeIndicatorBackground();
    }

    public void tintIndicator(int i, int i2) {
        this.mIndicatorTintColor = ColorStateList.valueOf(i);
        this.mIndicatorTintUnselectedColor = ColorStateList.valueOf(i2);
        changeIndicatorBackground();
    }

    public BaseCircleIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIndicatorMargin = -1;
        this.mIndicatorWidth = -1;
        this.mIndicatorHeight = -1;
        this.mLastPosition = -1;
        init(context, attributeSet);
    }

    public BaseCircleIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mIndicatorMargin = -1;
        this.mIndicatorWidth = -1;
        this.mIndicatorHeight = -1;
        this.mLastPosition = -1;
        init(context, attributeSet);
    }

    @TargetApi(21)
    public BaseCircleIndicator(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mIndicatorMargin = -1;
        this.mIndicatorWidth = -1;
        this.mIndicatorHeight = -1;
        this.mLastPosition = -1;
        init(context, attributeSet);
    }
}
