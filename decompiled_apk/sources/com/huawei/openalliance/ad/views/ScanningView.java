package com.huawei.openalliance.ad.views;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;
import com.huawei.hms.ads.eg;
import com.huawei.hms.ads.fb;
import com.huawei.hms.ads.splash.R;

/* loaded from: classes10.dex */
public class ScanningView extends View {
    private Bitmap B;
    private Bitmap C;
    private PorterDuffXfermode D;
    private Paint F;
    private int I;
    private float L;
    private Paint S;

    /* renamed from: a, reason: collision with root package name */
    private float f17434a;
    private float b;
    private ValueAnimator c;
    private Animator.AnimatorListener d;

    public ScanningView(Context context) {
        super(context);
        Z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(this.f17434a, this.b);
        this.c = ofFloat;
        ofFloat.setInterpolator(new eg(0.33f, 0.0f, 0.67f, 1.0f));
        this.c.setDuration(2500L);
        this.c.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.huawei.openalliance.ad.views.ScanningView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ScanningView.this.L = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                ScanningView.this.postInvalidate();
            }
        });
        this.c.addListener(new AnimatorListenerAdapter() { // from class: com.huawei.openalliance.ad.views.ScanningView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                ScanningView.this.setVisibility(8);
                if (ScanningView.this.d != null) {
                    ScanningView.this.d.onAnimationCancel(animator);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ScanningView.this.setVisibility(8);
                if (ScanningView.this.d != null) {
                    ScanningView.this.d.onAnimationEnd(animator);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ScanningView.this.setVisibility(0);
                if (ScanningView.this.d != null) {
                    ScanningView.this.d.onAnimationStart(animator);
                }
            }
        });
    }

    private void I() {
        this.C = BitmapFactory.decodeResource(getResources(), this.I);
    }

    private void Z() {
        Paint paint = new Paint(1);
        this.S = paint;
        paint.setDither(true);
        this.S.setFilterBitmap(true);
        Paint paint2 = new Paint(1);
        this.F = paint2;
        paint2.setDither(true);
        this.F.setStyle(Paint.Style.FILL);
        this.F.setColor(-1);
        this.F.setFilterBitmap(true);
        this.D = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (this.B == null) {
            return;
        }
        try {
            int saveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), this.S, 31);
            canvas.drawBitmap(this.C, 0.0f, this.L, this.S);
            this.S.setXfermode(this.D);
            canvas.drawBitmap(this.B, 0.0f, 0.0f, this.S);
            this.S.setXfermode(null);
            canvas.restoreToCount(saveLayer);
        } catch (Throwable th) {
            fb.I("ScanningView", "draw exception: %s", th.getClass().getSimpleName());
        }
        super.draw(canvas);
    }

    public Bitmap getSrcBitmap() {
        return this.B;
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        I();
        float f = i2;
        this.f17434a = f;
        this.L = f;
        this.b = -i2;
    }

    public void setAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.d = animatorListener;
    }

    public void setSrcBitmap(Bitmap bitmap) {
        this.B = bitmap;
    }

    public ScanningView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void V() {
        ValueAnimator valueAnimator = this.c;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.c.cancel();
        }
        this.L = this.f17434a;
        postInvalidate();
    }

    public ScanningView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Z();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ScanningView);
        this.I = obtainStyledAttributes.getResourceId(R.styleable.ScanningView_lightImage, R.drawable.hiad_arrow_scan);
        obtainStyledAttributes.recycle();
    }

    public void Code() {
        if (this.B == null) {
            fb.V("ScanningView", "start, mSrcBitmap is null");
        } else {
            post(new Runnable() { // from class: com.huawei.openalliance.ad.views.ScanningView.3
                @Override // java.lang.Runnable
                public void run() {
                    if (ScanningView.this.c == null) {
                        ScanningView.this.B();
                    } else if (ScanningView.this.c.isRunning()) {
                        ScanningView.this.c.cancel();
                    }
                    ScanningView.this.c.start();
                }
            });
        }
    }
}
