package com.baidu.navisdk.ui.widget;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.common.g;

/* loaded from: classes8.dex */
public class LoadingAnimViewNew extends FrameLayout {
    public int backAnimId;
    private AnimatorSet backAnimSet;
    private View backCircle;
    public int backColor;
    public int backWidth;
    public int centerAnimId;
    private ImageView centerImage;
    private AnimatorSet centerImageAnimSet;
    public int centerImageId;
    private Drawable centerImageSrc;
    private int centerImageWidth;
    private final Context context;
    private boolean isAttachToWindow;
    public boolean isAutoStart;
    private boolean isNeedReapte;

    public LoadingAnimViewNew(Context context) {
        this(context, null);
    }

    private void init(Context context, @Nullable AttributeSet attributeSet, int i) {
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.nsdk_layout_route_result_loading_view, this);
        this.backCircle = findViewById(R.id.back_circle);
        this.centerImage = (ImageView) findViewById(R.id.center_image);
        setInitAttr(attributeSet, i);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(this.backColor);
        this.backCircle.setBackgroundDrawable(gradientDrawable);
        this.centerImageSrc = getResources().getDrawable(this.centerImageId);
        this.centerImage.setImageDrawable(getResources().getDrawable(this.centerImageId));
    }

    private void playAnim() {
        try {
            AnimatorSet animatorSet = (AnimatorSet) AnimatorInflater.loadAnimator(this.context, this.centerAnimId);
            this.centerImageAnimSet = animatorSet;
            animatorSet.setTarget(this.centerImage);
            this.centerImageAnimSet.setStartDelay(300L);
            this.centerImageAnimSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.navisdk.ui.widget.LoadingAnimViewNew.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (LoadingAnimViewNew.this.isNeedReapte && LoadingAnimViewNew.this.backAnimSet != null) {
                        LoadingAnimViewNew.this.backAnimSet.start();
                    }
                }
            });
            AnimatorSet animatorSet2 = (AnimatorSet) AnimatorInflater.loadAnimator(this.context, this.backAnimId);
            this.backAnimSet = animatorSet2;
            animatorSet2.setTarget(this.backCircle);
            this.backAnimSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.navisdk.ui.widget.LoadingAnimViewNew.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (LoadingAnimViewNew.this.isNeedReapte && LoadingAnimViewNew.this.centerImageAnimSet != null) {
                        LoadingAnimViewNew.this.centerImageAnimSet.start();
                    }
                }
            });
        } catch (Exception e) {
            g gVar = g.COMMON;
            if (gVar.d()) {
                gVar.a("LoadingAnimViewNew playAnim exception!", e);
            }
        }
    }

    private void setViewSize(int i, int i2) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.centerImage.getLayoutParams());
        layoutParams.height = i2;
        layoutParams.width = i2;
        layoutParams.gravity = 17;
        this.centerImage.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(this.backCircle.getLayoutParams());
        layoutParams2.height = i;
        layoutParams2.width = i;
        layoutParams2.gravity = 17;
        this.backCircle.setLayoutParams(layoutParams2);
    }

    private void stopAnim() {
        AnimatorSet animatorSet = this.backAnimSet;
        if (animatorSet != null) {
            animatorSet.removeAllListeners();
            this.backAnimSet.cancel();
            this.backAnimSet = null;
        }
        AnimatorSet animatorSet2 = this.centerImageAnimSet;
        if (animatorSet2 != null) {
            animatorSet2.removeAllListeners();
            this.centerImageAnimSet.cancel();
            this.centerImageAnimSet = null;
        }
    }

    public boolean isRunning() {
        AnimatorSet animatorSet = this.backAnimSet;
        if (animatorSet == null || this.centerImageAnimSet == null) {
            return false;
        }
        if (!animatorSet.isRunning() && !this.centerImageAnimSet.isRunning()) {
            return false;
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.isAttachToWindow = true;
        if (this.isAutoStart && isShown()) {
            start();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.isAttachToWindow = false;
        if (this.isAutoStart) {
            stop();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        setExactlySize(i, i2);
        super.onMeasure(i, i2);
        int min = Math.min(this.centerImageSrc.getIntrinsicWidth(), this.centerImageSrc.getIntrinsicHeight());
        this.centerImageWidth = min;
        setViewSize(this.backWidth, min);
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NonNull View view, int i) {
        super.onVisibilityChanged(view, i);
        if (this.isAutoStart && this.isAttachToWindow) {
            if (i == 0 && isShown()) {
                start();
            } else {
                stop();
            }
        }
    }

    public void setExactlySize(int i, int i2) {
        this.backWidth = Math.min(getMeasuredHeight(), getMeasuredWidth()) / 2;
    }

    public void setInitAttr(@Nullable AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = this.context.obtainStyledAttributes(attributeSet, R.styleable.RouteResultLoadingAnim, i, 0);
        this.backColor = obtainStyledAttributes.getColor(R.styleable.RouteResultLoadingAnim_nsdk_backColor, Color.parseColor("#5088FF"));
        this.centerImageId = obtainStyledAttributes.getResourceId(R.styleable.RouteResultLoadingAnim_nsdk_centerImage, R.drawable.dialog_loading_45);
        this.isAutoStart = obtainStyledAttributes.getBoolean(R.styleable.RouteResultLoadingAnim_nsdk_autoStart, true);
        this.centerAnimId = obtainStyledAttributes.getResourceId(R.styleable.RouteResultLoadingAnim_nsdk_centerAnim, R.anim.normal_center_image_set);
        this.backAnimId = obtainStyledAttributes.getResourceId(R.styleable.RouteResultLoadingAnim_nsdk_backAnim, R.anim.normal_back_circle_set);
        obtainStyledAttributes.recycle();
    }

    public void start() {
        if (!this.isNeedReapte) {
            playAnim();
            this.isNeedReapte = true;
            AnimatorSet animatorSet = this.backAnimSet;
            if (animatorSet != null) {
                animatorSet.start();
            }
        }
    }

    public void stop() {
        if (this.isNeedReapte) {
            this.isNeedReapte = false;
            stopAnim();
        }
    }

    public LoadingAnimViewNew(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LoadingAnimViewNew(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isAttachToWindow = false;
        this.context = context;
        init(context, attributeSet, i);
    }
}
