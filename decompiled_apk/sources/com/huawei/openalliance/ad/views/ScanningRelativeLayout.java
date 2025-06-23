package com.huawei.openalliance.ad.views;

import android.animation.Keyframe;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.huawei.hms.ads.eg;
import com.huawei.hms.ads.fb;
import com.huawei.hms.ads.splash.R;
import com.huawei.openalliance.ad.constant.bn;
import com.huawei.openalliance.ad.utils.bc;
import com.huawei.openalliance.ad.utils.w;
import java.lang.ref.WeakReference;

/* loaded from: classes10.dex */
public class ScanningRelativeLayout extends AutoScaleSizeRelativeLayout {
    private int B;
    private int C;
    private Paint D;
    private Bitmap F;
    private Paint L;
    private Bitmap S;

    /* renamed from: a, reason: collision with root package name */
    private float f17433a;
    private float b;
    private float c;
    private ValueAnimator d;
    private PorterDuffXfermode e;

    /* loaded from: classes10.dex */
    public static class a implements ValueAnimator.AnimatorUpdateListener {
        private WeakReference<ScanningRelativeLayout> Code;

        public a(ScanningRelativeLayout scanningRelativeLayout) {
            this.Code = new WeakReference<>(scanningRelativeLayout);
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ScanningRelativeLayout scanningRelativeLayout = this.Code.get();
            if (scanningRelativeLayout == null || valueAnimator == null) {
                return;
            }
            scanningRelativeLayout.setLeft(((Float) valueAnimator.getAnimatedValue()).floatValue());
            scanningRelativeLayout.postInvalidate();
        }
    }

    public ScanningRelativeLayout(Context context) {
        super(context);
        B();
    }

    private void B() {
        fb.V("ScanningRelativeLayout", "init");
        try {
            Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), this.B);
            this.F = decodeResource;
            if (decodeResource != null && bc.I()) {
                Matrix matrix = new Matrix();
                matrix.postScale(-1.0f, 1.0f);
                Bitmap bitmap = this.F;
                this.F = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), this.F.getHeight(), matrix, false);
            }
            float f = -this.F.getWidth();
            this.b = f;
            this.f17433a = f;
            Paint paint = new Paint(1);
            this.L = paint;
            paint.setDither(true);
            this.L.setFilterBitmap(true);
            Paint paint2 = new Paint(1);
            this.D = paint2;
            paint2.setDither(true);
            this.D.setStyle(Paint.Style.FILL);
            this.D.setColor(-1);
            this.D.setFilterBitmap(true);
            this.e = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
        } catch (Throwable th) {
            fb.I("ScanningRelativeLayout", "init exception: %s", th.getClass().getSimpleName());
        }
    }

    private void C() {
        if (getWidth() <= 0 || getHeight() <= 0) {
            return;
        }
        try {
            this.S = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
            new Canvas(this.S).drawRoundRect(new RectF(0.0f, 0.0f, getWidth(), getHeight()), w.V(getContext(), this.C), w.V(getContext(), this.C), this.D);
        } catch (Throwable th) {
            fb.I("ScanningRelativeLayout", "createBitMapException: %s", th.getClass().getSimpleName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S() {
        try {
            ValueAnimator ofPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(bc.I() ? PropertyValuesHolder.ofKeyframe(View.TRANSLATION_X, Keyframe.ofFloat(0.0f, this.c), Keyframe.ofFloat(1.0f, this.b)) : PropertyValuesHolder.ofKeyframe(View.TRANSLATION_X, Keyframe.ofFloat(0.0f, this.b), Keyframe.ofFloat(1.0f, this.c)));
            this.d = ofPropertyValuesHolder;
            ofPropertyValuesHolder.setInterpolator(new eg(0.2f, 0.0f, 0.2f, 1.0f));
            this.d.setDuration(1500L);
            this.d.addUpdateListener(new a(this));
        } catch (Throwable th) {
            fb.I("ScanningRelativeLayout", "init animator exception: %s", th.getClass().getSimpleName());
        }
    }

    public void I() {
        fb.V("ScanningRelativeLayout", "stop");
        try {
            ValueAnimator valueAnimator = this.d;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.d.cancel();
            }
        } catch (Throwable th) {
            fb.I("ScanningRelativeLayout", "cancel animation exception: %s", th.getClass().getSimpleName());
        }
        this.f17433a = this.b;
        postInvalidate();
    }

    public void V() {
        fb.V("ScanningRelativeLayout", "start");
        post(new Runnable() { // from class: com.huawei.openalliance.ad.views.ScanningRelativeLayout.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (ScanningRelativeLayout.this.d == null) {
                        ScanningRelativeLayout.this.S();
                    } else if (ScanningRelativeLayout.this.d.isRunning()) {
                        ScanningRelativeLayout.this.d.cancel();
                    }
                    ScanningRelativeLayout.this.d.start();
                } catch (Throwable th) {
                    fb.I("ScanningRelativeLayout", "start scan exception: %s", th.getClass().getSimpleName());
                }
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.S == null) {
            return;
        }
        try {
            canvas.drawBitmap(this.F, this.f17433a, 0.0f, this.L);
            int saveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), this.L, 31);
            this.L.setXfermode(this.e);
            canvas.drawBitmap(this.S, 0.0f, 0.0f, this.L);
            this.L.setXfermode(null);
            canvas.restoreToCount(saveLayer);
        } catch (Throwable th) {
            fb.I("ScanningRelativeLayout", "dispatchDraw exception: %s", th.getClass().getSimpleName());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.d;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return;
        }
        this.d.cancel();
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        C();
        this.c = i;
    }

    public void setLeft(float f) {
        this.f17433a = f;
    }

    public void setRadius(int i) {
        this.C = i;
        setRectCornerRadius(w.V(getContext(), i));
    }

    public ScanningRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void Code() {
        fb.V("ScanningRelativeLayout", bn.b.Code);
        try {
            ValueAnimator valueAnimator = this.d;
            if (valueAnimator == null) {
                S();
            } else if (valueAnimator.isRunning()) {
                this.d.cancel();
            }
        } catch (Throwable th) {
            fb.I("ScanningRelativeLayout", "prepare scan exception: %s", th.getClass().getSimpleName());
        }
    }

    public ScanningRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ScanningRelativeLayout);
        this.B = obtainStyledAttributes.getResourceId(R.styleable.ScanningRelativeLayout_layoutScanImage, R.drawable.hiad_scan);
        this.C = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.ScanningRelativeLayout_layoutRadius, 36);
        obtainStyledAttributes.recycle();
        B();
    }
}
