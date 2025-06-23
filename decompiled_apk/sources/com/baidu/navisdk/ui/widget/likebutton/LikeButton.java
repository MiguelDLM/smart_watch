package com.baidu.navisdk.ui.widget.likebutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Property;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.core.content.ContextCompat;
import com.baidu.navisdk.embed.R;

/* loaded from: classes8.dex */
public class LikeButton extends FrameLayout {
    private float animationScaleFactor;
    private AnimatorSet animatorSet;
    private int circleEndColor;
    private int circleStartColor;
    private CircleView circleView;
    private Icon currentIcon;
    private int dotPrimaryColor;
    private int dotSecondaryColor;
    private DotsView dotsView;
    private ImageView icon;
    private boolean isChecked;
    private boolean isEnabled;
    private Drawable likeDrawable;
    private OnLikeListener likeListener;
    private Drawable unLikeDrawable;
    private static final DecelerateInterpolator DECCELERATE_INTERPOLATOR = new DecelerateInterpolator();
    private static final AccelerateDecelerateInterpolator ACCELERATE_DECELERATE_INTERPOLATOR = new AccelerateDecelerateInterpolator();
    private static final OvershootInterpolator OVERSHOOT_INTERPOLATOR = new OvershootInterpolator(4.0f);

    public LikeButton(Context context) {
        this(context, null);
    }

    private Drawable getDrawableFromResource(TypedArray typedArray, int i) {
        int resourceId = typedArray.getResourceId(i, -1);
        if (-1 != resourceId) {
            return ContextCompat.getDrawable(getContext(), resourceId);
        }
        return null;
    }

    private void init(Context context, AttributeSet attributeSet, int i) {
        LayoutInflater.from(getContext()).inflate(R.layout.nsdk_likeview, (ViewGroup) this, true);
        this.icon = (ImageView) findViewById(R.id.icon);
        this.dotsView = (DotsView) findViewById(R.id.dots);
        this.circleView = (CircleView) findViewById(R.id.circle);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.LikeButton, i, 0);
        Drawable drawableFromResource = getDrawableFromResource(obtainStyledAttributes, R.styleable.LikeButton_nsdk_bn_like_drawable);
        this.likeDrawable = drawableFromResource;
        if (drawableFromResource != null) {
            setLikeDrawable(drawableFromResource);
        }
        Drawable drawableFromResource2 = getDrawableFromResource(obtainStyledAttributes, R.styleable.LikeButton_nsdk_bn_unlike_drawable);
        this.unLikeDrawable = drawableFromResource2;
        if (drawableFromResource2 != null) {
            setUnlikeDrawable(drawableFromResource2);
        }
        int color = obtainStyledAttributes.getColor(R.styleable.LikeButton_nsdk_bn_circle_start_color, 0);
        this.circleStartColor = color;
        if (color != 0) {
            this.circleView.setStartColor(color);
        }
        int color2 = obtainStyledAttributes.getColor(R.styleable.LikeButton_nsdk_bn_circle_end_color, 0);
        this.circleEndColor = color2;
        if (color2 != 0) {
            this.circleView.setEndColor(color2);
        }
        this.dotPrimaryColor = obtainStyledAttributes.getColor(R.styleable.LikeButton_nsdk_bn_dots_primary_color, 0);
        int color3 = obtainStyledAttributes.getColor(R.styleable.LikeButton_nsdk_bn_dots_secondary_color, 0);
        this.dotSecondaryColor = color3;
        int i2 = this.dotPrimaryColor;
        if (i2 != 0 && color3 != 0) {
            this.dotsView.setColors(i2, color3);
        }
        if (this.likeDrawable == null && this.unLikeDrawable == null && this.currentIcon != null) {
            setIcon();
        }
        setEnabled(obtainStyledAttributes.getBoolean(R.styleable.LikeButton_nsdk_bn_is_enabled, true));
        Boolean valueOf = Boolean.valueOf(obtainStyledAttributes.getBoolean(R.styleable.LikeButton_nsdk_bn_liked, false));
        setAnimationScaleFactor(obtainStyledAttributes.getFloat(R.styleable.LikeButton_nsdk_bn_anim_scale_factor, 3.0f));
        setLiked(valueOf);
        obtainStyledAttributes.recycle();
    }

    public boolean isLiked() {
        return this.isChecked;
    }

    public void setAnimationScaleFactor(float f) {
        this.animationScaleFactor = f;
    }

    public void setCircleEndColorRes(@ColorRes int i) {
        int color = ContextCompat.getColor(getContext(), i);
        this.circleEndColor = color;
        this.circleView.setEndColor(color);
    }

    public void setCircleStartColorInt(@ColorInt int i) {
        this.circleStartColor = i;
        this.circleView.setStartColor(i);
    }

    public void setCircleStartColorRes(@ColorRes int i) {
        int color = ContextCompat.getColor(getContext(), i);
        this.circleStartColor = color;
        this.circleView.setStartColor(color);
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        this.isEnabled = z;
    }

    public void setExplodingDotColorsInt(@ColorInt int i, @ColorInt int i2) {
        this.dotsView.setColors(i, i2);
    }

    public void setExplodingDotColorsRes(@ColorRes int i, @ColorRes int i2) {
        this.dotsView.setColors(ContextCompat.getColor(getContext(), i), ContextCompat.getColor(getContext(), i2));
    }

    public void setIcon() {
        setLikeDrawableRes(this.currentIcon.getOnIconResourceId());
        setUnlikeDrawableRes(this.currentIcon.getOffIconResourceId());
        this.icon.setImageDrawable(this.unLikeDrawable);
    }

    public void setLikeDrawable(Drawable drawable) {
        this.likeDrawable = drawable;
        if (this.isChecked) {
            this.icon.setImageDrawable(drawable);
        }
    }

    public void setLikeDrawableRes(@DrawableRes int i) {
        Drawable drawable = ContextCompat.getDrawable(getContext(), i);
        this.likeDrawable = drawable;
        if (this.isChecked) {
            this.icon.setImageDrawable(drawable);
        }
    }

    public void setLiked(Boolean bool) {
        if (bool.booleanValue()) {
            this.isChecked = true;
            this.icon.setImageDrawable(this.likeDrawable);
        } else {
            this.isChecked = false;
            this.icon.setImageDrawable(this.unLikeDrawable);
        }
    }

    public void setOnLikeListener(OnLikeListener onLikeListener) {
        this.likeListener = onLikeListener;
    }

    public void setUnlikeDrawable(Drawable drawable) {
        this.unLikeDrawable = drawable;
        if (!this.isChecked) {
            this.icon.setImageDrawable(drawable);
        }
    }

    public void setUnlikeDrawableRes(@DrawableRes int i) {
        Drawable drawable = ContextCompat.getDrawable(getContext(), i);
        this.unLikeDrawable = drawable;
        if (!this.isChecked) {
            this.icon.setImageDrawable(drawable);
        }
    }

    public void trigger(boolean z, boolean z2) {
        Drawable drawable;
        if (!z2) {
            setLiked(Boolean.valueOf(z));
            return;
        }
        this.isChecked = z;
        ImageView imageView = this.icon;
        if (z) {
            drawable = this.likeDrawable;
        } else {
            drawable = this.unLikeDrawable;
        }
        imageView.setImageDrawable(drawable);
        OnLikeListener onLikeListener = this.likeListener;
        if (onLikeListener != null) {
            if (this.isChecked) {
                onLikeListener.liked(this);
            } else {
                onLikeListener.unLiked(this);
            }
        }
        AnimatorSet animatorSet = this.animatorSet;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        if (this.isChecked) {
            this.icon.animate().cancel();
            this.icon.setScaleX(0.0f);
            this.icon.setScaleY(0.0f);
            this.circleView.setInnerCircleRadiusProgress(0.0f);
            this.circleView.setOuterCircleRadiusProgress(0.0f);
            this.dotsView.setCurrentProgress(0.0f);
            this.animatorSet = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.circleView, CircleView.OUTER_CIRCLE_RADIUS_PROGRESS, 0.1f, 1.0f);
            ofFloat.setDuration(250L);
            DecelerateInterpolator decelerateInterpolator = DECCELERATE_INTERPOLATOR;
            ofFloat.setInterpolator(decelerateInterpolator);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.circleView, CircleView.INNER_CIRCLE_RADIUS_PROGRESS, 0.1f, 1.0f);
            ofFloat2.setDuration(200L);
            ofFloat2.setStartDelay(200L);
            ofFloat2.setInterpolator(decelerateInterpolator);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.icon, (Property<ImageView, Float>) ImageView.SCALE_Y, 0.2f, 1.0f);
            ofFloat3.setDuration(350L);
            ofFloat3.setStartDelay(250L);
            OvershootInterpolator overshootInterpolator = OVERSHOOT_INTERPOLATOR;
            ofFloat3.setInterpolator(overshootInterpolator);
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.icon, (Property<ImageView, Float>) ImageView.SCALE_X, 0.2f, 1.0f);
            ofFloat4.setDuration(350L);
            ofFloat4.setStartDelay(250L);
            ofFloat4.setInterpolator(overshootInterpolator);
            ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.dotsView, DotsView.DOTS_PROGRESS, 0.0f, 1.0f);
            ofFloat5.setDuration(900L);
            ofFloat5.setStartDelay(50L);
            ofFloat5.setInterpolator(ACCELERATE_DECELERATE_INTERPOLATOR);
            this.animatorSet.playTogether(ofFloat, ofFloat2, ofFloat3, ofFloat4, ofFloat5);
            this.animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.navisdk.ui.widget.likebutton.LikeButton.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    LikeButton.this.circleView.setInnerCircleRadiusProgress(0.0f);
                    LikeButton.this.circleView.setOuterCircleRadiusProgress(0.0f);
                    LikeButton.this.dotsView.setCurrentProgress(0.0f);
                    LikeButton.this.icon.setScaleX(1.0f);
                    LikeButton.this.icon.setScaleY(1.0f);
                }
            });
            this.animatorSet.start();
        }
    }

    public LikeButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        if (isInEditMode()) {
            return;
        }
        init(context, attributeSet, i);
    }
}
