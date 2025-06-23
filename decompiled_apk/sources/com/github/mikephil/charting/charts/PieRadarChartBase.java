package com.github.mikephil.charting.charts;

import IIxOXoOo0.X0o0xo;
import Ioxxx.II0xO0;
import XIXIX.Oxx0IOOO;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.listener.I0Io;
import o0xxxXXxX.OOXIXo;

/* loaded from: classes9.dex */
public abstract class PieRadarChartBase<T extends OOXIXo<? extends X0o0xo<? extends Entry>>> extends Chart<T> {

    /* renamed from: I0X0x0oIo, reason: collision with root package name */
    public boolean f15919I0X0x0oIo;

    /* renamed from: XX0, reason: collision with root package name */
    public float f15920XX0;

    /* renamed from: oX, reason: collision with root package name */
    public float f15921oX;

    /* renamed from: xXOx, reason: collision with root package name */
    public float f15922xXOx;

    /* loaded from: classes9.dex */
    public static /* synthetic */ class II0xO0 {

        /* renamed from: I0Io, reason: collision with root package name */
        public static final /* synthetic */ int[] f15923I0Io;

        /* renamed from: II0xO0, reason: collision with root package name */
        public static final /* synthetic */ int[] f15924II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public static final /* synthetic */ int[] f15925oIX0oI;

        static {
            int[] iArr = new int[Legend.LegendOrientation.values().length];
            f15923I0Io = iArr;
            try {
                iArr[Legend.LegendOrientation.VERTICAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f15923I0Io[Legend.LegendOrientation.HORIZONTAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[Legend.LegendHorizontalAlignment.values().length];
            f15924II0xO0 = iArr2;
            try {
                iArr2[Legend.LegendHorizontalAlignment.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f15924II0xO0[Legend.LegendHorizontalAlignment.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f15924II0xO0[Legend.LegendHorizontalAlignment.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr3 = new int[Legend.LegendVerticalAlignment.values().length];
            f15925oIX0oI = iArr3;
            try {
                iArr3[Legend.LegendVerticalAlignment.TOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f15925oIX0oI[Legend.LegendVerticalAlignment.BOTTOM.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes9.dex */
    public class oIX0oI implements ValueAnimator.AnimatorUpdateListener {
        public oIX0oI() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            PieRadarChartBase.this.postInvalidate();
        }
    }

    public PieRadarChartBase(Context context) {
        super(context);
        this.f15922xXOx = 270.0f;
        this.f15920XX0 = 270.0f;
        this.f15919I0X0x0oIo = true;
        this.f15921oX = 0.0f;
    }

    public boolean I0X0x0oIo() {
        return this.f15919I0X0x0oIo;
    }

    @Override // com.github.mikephil.charting.charts.Chart
    public void X00IoxXI() {
        if (this.f15871Oo == null) {
            return;
        }
        oO();
        if (this.f15876X0IIOO != null) {
            this.f15892xXxxox0I.oIX0oI(this.f15871Oo);
        }
        x0xO0oo();
    }

    public void XX0(Oxx0IOOO oxx0IOOO, float f, float f2, Oxx0IOOO oxx0IOOO2) {
        double d = f;
        double d2 = f2;
        oxx0IOOO2.f3771IXxxXO = (float) (oxx0IOOO.f3771IXxxXO + (Math.cos(Math.toRadians(d2)) * d));
        oxx0IOOO2.f3772Oxx0xo = (float) (oxx0IOOO.f3772Oxx0xo + (d * Math.sin(Math.toRadians(d2))));
    }

    public float XoX(float f, float f2) {
        float f3;
        float f4;
        Oxx0IOOO centerOffsets = getCenterOffsets();
        float f5 = centerOffsets.f3771IXxxXO;
        if (f > f5) {
            f3 = f - f5;
        } else {
            f3 = f5 - f;
        }
        float f6 = centerOffsets.f3772Oxx0xo;
        if (f2 > f6) {
            f4 = f2 - f6;
        } else {
            f4 = f6 - f2;
        }
        float sqrt = (float) Math.sqrt(Math.pow(f3, 2.0d) + Math.pow(f4, 2.0d));
        Oxx0IOOO.II0XooXoX(centerOffsets);
        return sqrt;
    }

    @Override // android.view.View
    public void computeScroll() {
        ChartTouchListener chartTouchListener = this.f15878XIxXXX0x0;
        if (chartTouchListener instanceof I0Io) {
            ((I0Io) chartTouchListener).xxIXOIIO();
        }
    }

    public float getDiameter() {
        RectF Oo2 = this.f15890xI.Oo();
        Oo2.left += getExtraLeftOffset();
        Oo2.top += getExtraTopOffset();
        Oo2.right -= getExtraRightOffset();
        Oo2.bottom -= getExtraBottomOffset();
        return Math.min(Oo2.width(), Oo2.height());
    }

    @Override // OOXIxO0.X0o0xo
    public int getMaxVisibleCount() {
        return this.f15871Oo.IXxxXO();
    }

    public float getMinOffset() {
        return this.f15921oX;
    }

    public abstract float getRadius();

    public float getRawRotationAngle() {
        return this.f15920XX0;
    }

    public abstract float getRequiredBaseOffset();

    public abstract float getRequiredLegendOffset();

    public float getRotationAngle() {
        return this.f15922xXOx;
    }

    @Override // OOXIxO0.X0o0xo
    public float getYChartMax() {
        return 0.0f;
    }

    @Override // OOXIxO0.X0o0xo
    public float getYChartMin() {
        return 0.0f;
    }

    @Override // com.github.mikephil.charting.charts.Chart
    public void oO() {
    }

    @SuppressLint({"NewApi"})
    public void oX(int i, float f, float f2, II0xO0.xxX xxx2) {
        setRotationAngle(f);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "rotationAngle", f, f2);
        ofFloat.setDuration(i);
        ofFloat.setInterpolator(xxx2);
        ofFloat.addUpdateListener(new oIX0oI());
        ofFloat.start();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        ChartTouchListener chartTouchListener;
        if (this.f15872OxI && (chartTouchListener = this.f15878XIxXXX0x0) != null) {
            return chartTouchListener.onTouch(this, motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // com.github.mikephil.charting.charts.Chart
    public void ooXIXxIX() {
        super.ooXIXxIX();
        this.f15878XIxXXX0x0 = new I0Io(this);
    }

    public float oxXx0IX(float f, float f2) {
        Oxx0IOOO centerOffsets = getCenterOffsets();
        double d = f - centerOffsets.f3771IXxxXO;
        double d2 = f2 - centerOffsets.f3772Oxx0xo;
        float degrees = (float) Math.toDegrees(Math.acos(d2 / Math.sqrt((d * d) + (d2 * d2))));
        if (f > centerOffsets.f3771IXxxXO) {
            degrees = 360.0f - degrees;
        }
        float f3 = degrees + 90.0f;
        if (f3 > 360.0f) {
            f3 -= 360.0f;
        }
        Oxx0IOOO.II0XooXoX(centerOffsets);
        return f3;
    }

    public void setMinOffset(float f) {
        this.f15921oX = f;
    }

    public void setRotationAngle(float f) {
        this.f15920XX0 = f;
        this.f15922xXOx = XIXIX.OOXIXo.O0xOxO(f);
    }

    public void setRotationEnabled(boolean z) {
        this.f15919I0X0x0oIo = z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x007d, code lost:
    
        if (r2 != 2) goto L19;
     */
    @Override // com.github.mikephil.charting.charts.Chart
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void x0xO0oo() {
        /*
            Method dump skipped, instructions count: 540
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.charts.PieRadarChartBase.x0xO0oo():void");
    }

    public Oxx0IOOO xXOx(Oxx0IOOO oxx0IOOO, float f, float f2) {
        Oxx0IOOO I0Io2 = Oxx0IOOO.I0Io(0.0f, 0.0f);
        XX0(oxx0IOOO, f, f2, I0Io2);
        return I0Io2;
    }

    public abstract int xo0x(float f);

    public PieRadarChartBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15922xXOx = 270.0f;
        this.f15920XX0 = 270.0f;
        this.f15919I0X0x0oIo = true;
        this.f15921oX = 0.0f;
    }

    public PieRadarChartBase(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f15922xXOx = 270.0f;
        this.f15920XX0 = 270.0f;
        this.f15919I0X0x0oIo = true;
        this.f15921oX = 0.0f;
    }
}
