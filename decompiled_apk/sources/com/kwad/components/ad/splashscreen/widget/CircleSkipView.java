package com.kwad.components.ad.splashscreen.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.splashscreen.local.SplashSkipViewModel;
import com.kwad.components.ad.splashscreen.widget.SkipView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.widget.KSFrameLayout;

/* loaded from: classes11.dex */
public class CircleSkipView extends KSFrameLayout implements b {
    private float FT;
    private float FU;
    private int FV;
    private ValueAnimator FW;
    private boolean FX;
    private SkipView.a FY;
    private long FZ;
    private float Ga;
    private Paint mPaint;
    private RectF mRectF;
    private int padding;
    private int radius;
    private boolean sC;

    public CircleSkipView(@NonNull Context context) {
        this(context, null, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(int i) {
        SkipView.a aVar = this.FY;
        if (aVar != null) {
            aVar.Y(i);
        }
    }

    private void ab(Context context) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        ac(context);
        addView(ad(context), layoutParams);
        setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.splashscreen.widget.CircleSkipView.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (CircleSkipView.this.FY != null) {
                    CircleSkipView.this.FY.lb();
                }
            }
        });
    }

    private void ac(Context context) {
        this.FV = com.kwad.sdk.c.a.a.a(context, 2.0f);
        int a2 = com.kwad.sdk.c.a.a.a(context, 32.0f);
        int i = this.FV;
        this.radius = a2 - i;
        this.padding = i / 2;
        int i2 = this.padding;
        int i3 = this.radius;
        this.mRectF = new RectF(i2, i2, i3 + i2, i3 + i2);
    }

    private static TextView ad(Context context) {
        TextView textView = new TextView(context);
        textView.setText(context.getString(R.string.ksad_skip_text));
        textView.setTextColor(-1);
        textView.setTextSize(12.0f);
        return textView;
    }

    private void mi() {
        this.FX = true;
        ValueAnimator valueAnimator = this.FW;
        if (valueAnimator != null) {
            valueAnimator.setCurrentPlayTime(this.FZ);
            this.FW.start();
        }
    }

    private void mj() {
        this.FX = false;
        ValueAnimator valueAnimator = this.FW;
        if (valueAnimator != null) {
            this.FZ = valueAnimator.getCurrentPlayTime();
            this.FW.cancel();
        }
    }

    private void setAnimationPaint(Paint paint) {
        paint.reset();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(this.FV);
        paint.setColor(-1);
    }

    private void setBgCirclePaint(Paint paint) {
        paint.reset();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.parseColor("#4D000000"));
        paint.setAntiAlias(true);
    }

    private void setOuterCirclePaint(Paint paint) {
        paint.reset();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(this.FV);
        paint.setColor(Color.parseColor("#33FFFFFF"));
        paint.setAntiAlias(true);
    }

    @Override // com.kwad.components.ad.splashscreen.widget.b
    public final void A(AdInfo adInfo) {
        mj();
    }

    @Override // com.kwad.components.ad.splashscreen.widget.b
    public final void B(AdInfo adInfo) {
        mi();
    }

    @Override // com.kwad.components.ad.splashscreen.widget.b
    public final int aa(int i) {
        getLayoutParams().height = com.kwad.sdk.c.a.a.a(getContext(), 35.0f);
        return getWidth();
    }

    @Override // com.kwad.components.ad.splashscreen.widget.b
    public final void bf() {
        mj();
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        setBgCirclePaint(this.mPaint);
        canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, (Math.min(getWidth(), getHeight()) / 2.0f) - this.FV, this.mPaint);
        setOuterCirclePaint(this.mPaint);
        canvas.drawArc(this.mRectF, 0.0f, 360.0f, false, this.mPaint);
        if (this.FX) {
            setAnimationPaint(this.mPaint);
            canvas.drawArc(this.mRectF, this.FT, -this.FU, false, this.mPaint);
        }
        super.dispatchDraw(canvas);
    }

    @Override // com.kwad.components.ad.splashscreen.widget.b
    public void setOnViewListener(SkipView.a aVar) {
        this.FY = aVar;
    }

    public CircleSkipView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void c(final int i, final boolean z) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.FW = ofFloat;
        ofFloat.setDuration(i);
        this.FW.setInterpolator(new LinearInterpolator());
        this.FW.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.splashscreen.widget.CircleSkipView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                if (CircleSkipView.this.Ga == 1.0f && CircleSkipView.this.FY != null) {
                    CircleSkipView.this.FY.lc();
                }
            }
        });
        this.FW.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.splashscreen.widget.CircleSkipView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                CircleSkipView.this.Ga = floatValue;
                CircleSkipView circleSkipView = CircleSkipView.this;
                circleSkipView.X((int) ((i / 1000) * circleSkipView.Ga));
                if (z) {
                    CircleSkipView.a(CircleSkipView.this, true);
                    float f = floatValue * 360.0f;
                    CircleSkipView.this.FT = 270.0f - f;
                    CircleSkipView.this.FU = 360.0f - f;
                    CircleSkipView.this.invalidate();
                }
            }
        });
    }

    public CircleSkipView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mPaint = new Paint();
        this.FT = 270.0f;
        this.FU = 360.0f;
        this.radius = 0;
        this.FV = 0;
        this.FX = false;
        this.FZ = 0L;
        this.Ga = 0.0f;
        this.padding = 0;
        this.sC = true;
        ab(context);
    }

    public static /* synthetic */ boolean a(CircleSkipView circleSkipView, boolean z) {
        circleSkipView.FX = true;
        return true;
    }

    @Override // com.kwad.components.ad.splashscreen.widget.b
    public final void a(SplashSkipViewModel splashSkipViewModel, AdInfo adInfo) {
        this.sC = com.kwad.sdk.core.response.b.a.cy(adInfo);
        boolean cz = com.kwad.sdk.core.response.b.a.cz(adInfo);
        if (this.sC) {
            setVisibility(0);
        }
        c(splashSkipViewModel.skipSecond * 1000, cz);
    }
}
