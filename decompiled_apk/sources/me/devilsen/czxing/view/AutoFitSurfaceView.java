package me.devilsen.czxing.view;

import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import oI00o.II0xO0;
import oI00o.X0o0xo;

/* loaded from: classes6.dex */
public class AutoFitSurfaceView extends SurfaceView {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public float f30854IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public long f30855Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public oIX0oI f30856Oxx0xo;

    /* renamed from: XO, reason: collision with root package name */
    public float f30857XO;

    /* loaded from: classes6.dex */
    public interface oIX0oI {
        void II0xO0(float f);

        void oIX0oI(float f, float f2);

        void oxoX();
    }

    public AutoFitSurfaceView(Context context) {
        this(context, null);
    }

    public void II0xO0(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.f30857XO = i / i2;
            getHolder().setFixedSize(i, i2);
            requestLayout();
            return;
        }
        throw new IllegalArgumentException("Size cannot be negative");
    }

    public final void oIX0oI(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action != 2) {
            if (action == 5) {
                this.f30854IXxxXO = X0o0xo.oIX0oI(motionEvent);
            }
        } else {
            float oIX0oI2 = X0o0xo.oIX0oI(motionEvent) - this.f30854IXxxXO;
            oIX0oI oix0oi = this.f30856Oxx0xo;
            if (oix0oi != null && oIX0oI2 != 0.0f) {
                oix0oi.II0xO0(oIX0oI2);
            }
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        float f = this.f30857XO;
        if (f == 0.0f) {
            setMeasuredDimension(size, size2);
            return;
        }
        if (size <= size2) {
            f = 1.0f / f;
        }
        float f2 = size;
        float f3 = size2 * f;
        if (f2 < f3) {
            size = (int) f3;
        } else {
            size2 = (int) (f2 / f);
        }
        II0xO0.oIX0oI("Measured dimensions set: " + size + " x " + size2);
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() == 1) {
            int action = motionEvent.getAction() & 255;
            if (action == 0) {
                long uptimeMillis = SystemClock.uptimeMillis();
                if (uptimeMillis - this.f30855Oo < 300) {
                    oIX0oI oix0oi = this.f30856Oxx0xo;
                    if (oix0oi != null) {
                        oix0oi.oxoX();
                    }
                    this.f30855Oo = 0L;
                    return true;
                }
                this.f30855Oo = uptimeMillis;
            } else if (action == 1) {
                oIX0oI oix0oi2 = this.f30856Oxx0xo;
                if (oix0oi2 != null) {
                    oix0oi2.oIX0oI(motionEvent.getX(), motionEvent.getY());
                }
                II0xO0.oIX0oI("手指触摸，触发对焦测光");
            }
        } else if (motionEvent.getPointerCount() == 2) {
            oIX0oI(motionEvent);
        }
        return true;
    }

    public void setOnTouchListener(oIX0oI oix0oi) {
        this.f30856Oxx0xo = oix0oi;
    }

    public AutoFitSurfaceView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AutoFitSurfaceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f30854IXxxXO = 1.0f;
    }
}
