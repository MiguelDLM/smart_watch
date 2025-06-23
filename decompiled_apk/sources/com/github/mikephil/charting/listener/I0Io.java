package com.github.mikephil.charting.listener;

import XIXIX.OOXIXo;
import XIXIX.Oxx0IOOO;
import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import com.github.mikephil.charting.charts.PieRadarChartBase;
import com.github.mikephil.charting.listener.ChartTouchListener;
import java.util.ArrayList;

/* loaded from: classes9.dex */
public class I0Io extends ChartTouchListener<PieRadarChartBase<?>> {

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public Oxx0IOOO f16050XI0IXoo;

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    public float f16051XIxXXX0x0;

    /* renamed from: XxX0x0xxx, reason: collision with root package name */
    public long f16052XxX0x0xxx;

    /* renamed from: xXxxox0I, reason: collision with root package name */
    public float f16053xXxxox0I;

    /* renamed from: xxX, reason: collision with root package name */
    public ArrayList<oIX0oI> f16054xxX;

    /* loaded from: classes9.dex */
    public class oIX0oI {

        /* renamed from: II0xO0, reason: collision with root package name */
        public float f16056II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public long f16057oIX0oI;

        public oIX0oI(long j, float f) {
            this.f16057oIX0oI = j;
            this.f16056II0xO0 = f;
        }
    }

    public I0Io(PieRadarChartBase<?> pieRadarChartBase) {
        super(pieRadarChartBase);
        this.f16050XI0IXoo = Oxx0IOOO.I0Io(0.0f, 0.0f);
        this.f16051XIxXXX0x0 = 0.0f;
        this.f16054xxX = new ArrayList<>();
        this.f16052XxX0x0xxx = 0L;
        this.f16053xXxxox0I = 0.0f;
    }

    public final float II0XooXoX() {
        if (this.f16054xxX.isEmpty()) {
            return 0.0f;
        }
        boolean z = false;
        oIX0oI oix0oi = this.f16054xxX.get(0);
        ArrayList<oIX0oI> arrayList = this.f16054xxX;
        oIX0oI oix0oi2 = arrayList.get(arrayList.size() - 1);
        oIX0oI oix0oi3 = oix0oi;
        for (int size = this.f16054xxX.size() - 1; size >= 0; size--) {
            oix0oi3 = this.f16054xxX.get(size);
            if (oix0oi3.f16056II0xO0 != oix0oi2.f16056II0xO0) {
                break;
            }
        }
        float f = ((float) (oix0oi2.f16057oIX0oI - oix0oi.f16057oIX0oI)) / 1000.0f;
        if (f == 0.0f) {
            f = 0.1f;
        }
        if (oix0oi2.f16056II0xO0 >= oix0oi3.f16056II0xO0) {
            z = true;
        }
        if (Math.abs(r1 - r6) > 270.0d) {
            z = !z;
        }
        float f2 = oix0oi2.f16056II0xO0;
        float f3 = oix0oi.f16056II0xO0;
        if (f2 - f3 > 180.0d) {
            oix0oi.f16056II0xO0 = (float) (f3 + 360.0d);
        } else if (f3 - f2 > 180.0d) {
            oix0oi2.f16056II0xO0 = (float) (f2 + 360.0d);
        }
        float abs = Math.abs((oix0oi2.f16056II0xO0 - oix0oi.f16056II0xO0) / f);
        if (!z) {
            return -abs;
        }
        return abs;
    }

    public final void OOXIXo(float f, float f2) {
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        this.f16054xxX.add(new oIX0oI(currentAnimationTimeMillis, ((PieRadarChartBase) this.f16049oI0IIXIo).oxXx0IX(f, f2)));
        for (int size = this.f16054xxX.size(); size - 2 > 0 && currentAnimationTimeMillis - this.f16054xxX.get(0).f16057oIX0oI > 1000; size--) {
            this.f16054xxX.remove(0);
        }
    }

    public void oOoXoXO(float f, float f2) {
        this.f16051XIxXXX0x0 = ((PieRadarChartBase) this.f16049oI0IIXIo).oxXx0IX(f, f2) - ((PieRadarChartBase) this.f16049oI0IIXIo).getRawRotationAngle();
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        this.f16048XO = ChartTouchListener.ChartGesture.LONG_PRESS;
        II0xO0 onChartGestureListener = ((PieRadarChartBase) this.f16049oI0IIXIo).getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.oxoX(motionEvent);
        }
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        this.f16048XO = ChartTouchListener.ChartGesture.SINGLE_TAP;
        II0xO0 onChartGestureListener = ((PieRadarChartBase) this.f16049oI0IIXIo).getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.I0Io(motionEvent);
        }
        if (!((PieRadarChartBase) this.f16049oI0IIXIo).oOXoIIIo()) {
            return false;
        }
        X0o0xo(((PieRadarChartBase) this.f16049oI0IIXIo).o00(motionEvent.getX(), motionEvent.getY()), motionEvent);
        return true;
    }

    @Override // android.view.View.OnTouchListener
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (!this.f16047Oxx0xo.onTouchEvent(motionEvent) && ((PieRadarChartBase) this.f16049oI0IIXIo).I0X0x0oIo()) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        if (((PieRadarChartBase) this.f16049oI0IIXIo).xI()) {
                            OOXIXo(x, y);
                        }
                        if (this.f16046Oo == 0) {
                            Oxx0IOOO oxx0IOOO = this.f16050XI0IXoo;
                            if (ChartTouchListener.oIX0oI(x, oxx0IOOO.f3771IXxxXO, y, oxx0IOOO.f3772Oxx0xo) > OOXIXo.X0o0xo(8.0f)) {
                                this.f16048XO = ChartTouchListener.ChartGesture.ROTATE;
                                this.f16046Oo = 6;
                                ((PieRadarChartBase) this.f16049oI0IIXIo).oI0IIXIo();
                                II0xO0(motionEvent);
                            }
                        }
                        if (this.f16046Oo == 6) {
                            x0XOIxOo(x, y);
                            ((PieRadarChartBase) this.f16049oI0IIXIo).invalidate();
                        }
                        II0xO0(motionEvent);
                    }
                } else {
                    if (((PieRadarChartBase) this.f16049oI0IIXIo).xI()) {
                        ooOOo0oXI();
                        OOXIXo(x, y);
                        float II0XooXoX2 = II0XooXoX();
                        this.f16053xXxxox0I = II0XooXoX2;
                        if (II0XooXoX2 != 0.0f) {
                            this.f16052XxX0x0xxx = AnimationUtils.currentAnimationTimeMillis();
                            OOXIXo.oo(this.f16049oI0IIXIo);
                        }
                    }
                    ((PieRadarChartBase) this.f16049oI0IIXIo).xoXoI();
                    this.f16046Oo = 0;
                    II0xO0(motionEvent);
                }
            } else {
                Oxx0IOOO(motionEvent);
                ooOOo0oXI();
                xoIox();
                if (((PieRadarChartBase) this.f16049oI0IIXIo).xI()) {
                    OOXIXo(x, y);
                }
                oOoXoXO(x, y);
                Oxx0IOOO oxx0IOOO2 = this.f16050XI0IXoo;
                oxx0IOOO2.f3771IXxxXO = x;
                oxx0IOOO2.f3772Oxx0xo = y;
            }
        }
        return true;
    }

    public void ooOOo0oXI() {
        this.f16053xXxxox0I = 0.0f;
    }

    public void x0XOIxOo(float f, float f2) {
        T t = this.f16049oI0IIXIo;
        ((PieRadarChartBase) t).setRotationAngle(((PieRadarChartBase) t).oxXx0IX(f, f2) - this.f16051XIxXXX0x0);
    }

    public final void xoIox() {
        this.f16054xxX.clear();
    }

    public void xxIXOIIO() {
        if (this.f16053xXxxox0I == 0.0f) {
            return;
        }
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        this.f16053xXxxox0I *= ((PieRadarChartBase) this.f16049oI0IIXIo).getDragDecelerationFrictionCoef();
        float f = ((float) (currentAnimationTimeMillis - this.f16052XxX0x0xxx)) / 1000.0f;
        T t = this.f16049oI0IIXIo;
        ((PieRadarChartBase) t).setRotationAngle(((PieRadarChartBase) t).getRotationAngle() + (this.f16053xXxxox0I * f));
        this.f16052XxX0x0xxx = currentAnimationTimeMillis;
        if (Math.abs(this.f16053xXxxox0I) >= 0.001d) {
            OOXIXo.oo(this.f16049oI0IIXIo);
        } else {
            ooOOo0oXI();
        }
    }
}
