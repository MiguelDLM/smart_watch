package com.github.mikephil.charting.listener;

import IIxOXoOo0.X0o0xo;
import XI0oooXX.oxoX;
import XIXIX.OOXIXo;
import XIXIX.Oxx0IOOO;
import XIXIX.oOoXoXO;
import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.animation.AnimationUtils;
import com.github.mikephil.charting.charts.BarLineChartBase;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.listener.ChartTouchListener;

/* loaded from: classes9.dex */
public class oIX0oI extends ChartTouchListener<BarLineChartBase<? extends o0xxxXXxX.I0Io<? extends IIxOXoOo0.II0xO0<? extends Entry>>>> {

    /* renamed from: IIX0o, reason: collision with root package name */
    public float f16058IIX0o;

    /* renamed from: IoOoX, reason: collision with root package name */
    public Oxx0IOOO f16059IoOoX;

    /* renamed from: X00IoxXI, reason: collision with root package name */
    public float f16060X00IoxXI;

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public Matrix f16061XI0IXoo;

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    public Matrix f16062XIxXXX0x0;

    /* renamed from: Xx000oIo, reason: collision with root package name */
    public float f16063Xx000oIo;

    /* renamed from: XxX0x0xxx, reason: collision with root package name */
    public Oxx0IOOO f16064XxX0x0xxx;

    /* renamed from: oOXoIIIo, reason: collision with root package name */
    public Oxx0IOOO f16065oOXoIIIo;

    /* renamed from: oo, reason: collision with root package name */
    public long f16066oo;

    /* renamed from: oo0xXOI0I, reason: collision with root package name */
    public VelocityTracker f16067oo0xXOI0I;

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    public float f16068ooXIXxIX;

    /* renamed from: xI, reason: collision with root package name */
    public X0o0xo f16069xI;

    /* renamed from: xXxxox0I, reason: collision with root package name */
    public float f16070xXxxox0I;

    /* renamed from: xxX, reason: collision with root package name */
    public Oxx0IOOO f16071xxX;

    public oIX0oI(BarLineChartBase<? extends o0xxxXXxX.I0Io<? extends IIxOXoOo0.II0xO0<? extends Entry>>> barLineChartBase, Matrix matrix, float f) {
        super(barLineChartBase);
        this.f16061XI0IXoo = new Matrix();
        this.f16062XIxXXX0x0 = new Matrix();
        this.f16071xxX = Oxx0IOOO.I0Io(0.0f, 0.0f);
        this.f16064XxX0x0xxx = Oxx0IOOO.I0Io(0.0f, 0.0f);
        this.f16070xXxxox0I = 1.0f;
        this.f16058IIX0o = 1.0f;
        this.f16068ooXIXxIX = 1.0f;
        this.f16066oo = 0L;
        this.f16059IoOoX = Oxx0IOOO.I0Io(0.0f, 0.0f);
        this.f16065oOXoIIIo = Oxx0IOOO.I0Io(0.0f, 0.0f);
        this.f16061XI0IXoo = matrix;
        this.f16063Xx000oIo = OOXIXo.X0o0xo(f);
        this.f16060X00IoxXI = OOXIXo.X0o0xo(3.5f);
    }

    public static float OOXIXo(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getX(0) - motionEvent.getX(1));
    }

    public static float oI0IIXIo(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    public static float oOoXoXO(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getY(0) - motionEvent.getY(1));
    }

    public static void x0XOIxOo(Oxx0IOOO oxx0IOOO, MotionEvent motionEvent) {
        float x = motionEvent.getX(0) + motionEvent.getX(1);
        float y = motionEvent.getY(0) + motionEvent.getY(1);
        oxx0IOOO.f3771IXxxXO = x / 2.0f;
        oxx0IOOO.f3772Oxx0xo = y / 2.0f;
    }

    public void II0XooXoX() {
        float f;
        Oxx0IOOO oxx0IOOO = this.f16065oOXoIIIo;
        float f2 = 0.0f;
        if (oxx0IOOO.f3771IXxxXO == 0.0f && oxx0IOOO.f3772Oxx0xo == 0.0f) {
            return;
        }
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        this.f16065oOXoIIIo.f3771IXxxXO *= ((BarLineChartBase) this.f16049oI0IIXIo).getDragDecelerationFrictionCoef();
        this.f16065oOXoIIIo.f3772Oxx0xo *= ((BarLineChartBase) this.f16049oI0IIXIo).getDragDecelerationFrictionCoef();
        float f3 = ((float) (currentAnimationTimeMillis - this.f16066oo)) / 1000.0f;
        Oxx0IOOO oxx0IOOO2 = this.f16065oOXoIIIo;
        float f4 = oxx0IOOO2.f3771IXxxXO * f3;
        float f5 = oxx0IOOO2.f3772Oxx0xo * f3;
        Oxx0IOOO oxx0IOOO3 = this.f16059IoOoX;
        float f6 = oxx0IOOO3.f3771IXxxXO + f4;
        oxx0IOOO3.f3771IXxxXO = f6;
        float f7 = oxx0IOOO3.f3772Oxx0xo + f5;
        oxx0IOOO3.f3772Oxx0xo = f7;
        MotionEvent obtain = MotionEvent.obtain(currentAnimationTimeMillis, currentAnimationTimeMillis, 2, f6, f7, 0);
        if (((BarLineChartBase) this.f16049oI0IIXIo).XX0xXo()) {
            f = this.f16059IoOoX.f3771IXxxXO - this.f16071xxX.f3771IXxxXO;
        } else {
            f = 0.0f;
        }
        if (((BarLineChartBase) this.f16049oI0IIXIo).o0xxxXXxX()) {
            f2 = this.f16059IoOoX.f3772Oxx0xo - this.f16071xxX.f3772Oxx0xo;
        }
        oO(obtain, f, f2);
        obtain.recycle();
        this.f16061XI0IXoo = ((BarLineChartBase) this.f16049oI0IIXIo).getViewPortHandler().XOxIOxOx(this.f16061XI0IXoo, this.f16049oI0IIXIo, false);
        this.f16066oo = currentAnimationTimeMillis;
        if (Math.abs(this.f16065oOXoIIIo.f3771IXxxXO) < 0.01d && Math.abs(this.f16065oOXoIIIo.f3772Oxx0xo) < 0.01d) {
            ((BarLineChartBase) this.f16049oI0IIXIo).x0xO0oo();
            ((BarLineChartBase) this.f16049oI0IIXIo).postInvalidate();
            OxxIIOOXO();
            return;
        }
        OOXIXo.oo(this.f16049oI0IIXIo);
    }

    public final void IXxxXO(MotionEvent motionEvent) {
        this.f16062XIxXXX0x0.set(this.f16061XI0IXoo);
        this.f16071xxX.f3771IXxxXO = motionEvent.getX();
        this.f16071xxX.f3772Oxx0xo = motionEvent.getY();
        this.f16069xI = ((BarLineChartBase) this.f16049oI0IIXIo).XoI0Ixx0(motionEvent.getX(), motionEvent.getY());
    }

    public final void Oo(MotionEvent motionEvent) {
        boolean II0xO02;
        boolean oIX0oI2;
        boolean oIX0oI3;
        boolean II0xO03;
        float f;
        if (motionEvent.getPointerCount() >= 2) {
            II0xO0 onChartGestureListener = ((BarLineChartBase) this.f16049oI0IIXIo).getOnChartGestureListener();
            float oI0IIXIo2 = oI0IIXIo(motionEvent);
            if (oI0IIXIo2 > this.f16060X00IoxXI) {
                Oxx0IOOO oxx0IOOO = this.f16064XxX0x0xxx;
                Oxx0IOOO xoIox2 = xoIox(oxx0IOOO.f3771IXxxXO, oxx0IOOO.f3772Oxx0xo);
                oOoXoXO viewPortHandler = ((BarLineChartBase) this.f16049oI0IIXIo).getViewPortHandler();
                int i = this.f16046Oo;
                boolean z = false;
                float f2 = 1.0f;
                if (i == 4) {
                    this.f16048XO = ChartTouchListener.ChartGesture.PINCH_ZOOM;
                    float f3 = oI0IIXIo2 / this.f16068ooXIXxIX;
                    if (f3 < 1.0f) {
                        z = true;
                    }
                    if (z) {
                        oIX0oI3 = viewPortHandler.I0Io();
                    } else {
                        oIX0oI3 = viewPortHandler.oIX0oI();
                    }
                    if (z) {
                        II0xO03 = viewPortHandler.oxoX();
                    } else {
                        II0xO03 = viewPortHandler.II0xO0();
                    }
                    if (((BarLineChartBase) this.f16049oI0IIXIo).I0()) {
                        f = f3;
                    } else {
                        f = 1.0f;
                    }
                    if (((BarLineChartBase) this.f16049oI0IIXIo).ooOx()) {
                        f2 = f3;
                    }
                    if (II0xO03 || oIX0oI3) {
                        this.f16061XI0IXoo.set(this.f16062XIxXXX0x0);
                        this.f16061XI0IXoo.postScale(f, f2, xoIox2.f3771IXxxXO, xoIox2.f3772Oxx0xo);
                        if (onChartGestureListener != null) {
                            onChartGestureListener.Oxx0IOOO(motionEvent, f, f2);
                        }
                    }
                } else if (i == 2 && ((BarLineChartBase) this.f16049oI0IIXIo).I0()) {
                    this.f16048XO = ChartTouchListener.ChartGesture.X_ZOOM;
                    float OOXIXo2 = OOXIXo(motionEvent) / this.f16070xXxxox0I;
                    if (OOXIXo2 < 1.0f) {
                        oIX0oI2 = viewPortHandler.I0Io();
                    } else {
                        oIX0oI2 = viewPortHandler.oIX0oI();
                    }
                    if (oIX0oI2) {
                        this.f16061XI0IXoo.set(this.f16062XIxXXX0x0);
                        this.f16061XI0IXoo.postScale(OOXIXo2, 1.0f, xoIox2.f3771IXxxXO, xoIox2.f3772Oxx0xo);
                        if (onChartGestureListener != null) {
                            onChartGestureListener.Oxx0IOOO(motionEvent, OOXIXo2, 1.0f);
                        }
                    }
                } else if (this.f16046Oo == 3 && ((BarLineChartBase) this.f16049oI0IIXIo).ooOx()) {
                    this.f16048XO = ChartTouchListener.ChartGesture.Y_ZOOM;
                    float oOoXoXO2 = oOoXoXO(motionEvent) / this.f16058IIX0o;
                    if (oOoXoXO2 < 1.0f) {
                        z = true;
                    }
                    if (z) {
                        II0xO02 = viewPortHandler.oxoX();
                    } else {
                        II0xO02 = viewPortHandler.II0xO0();
                    }
                    if (II0xO02) {
                        this.f16061XI0IXoo.set(this.f16062XIxXXX0x0);
                        this.f16061XI0IXoo.postScale(1.0f, oOoXoXO2, xoIox2.f3771IXxxXO, xoIox2.f3772Oxx0xo);
                        if (onChartGestureListener != null) {
                            onChartGestureListener.Oxx0IOOO(motionEvent, 1.0f, oOoXoXO2);
                        }
                    }
                }
                Oxx0IOOO.II0XooXoX(xoIox2);
            }
        }
    }

    public void Oxx0xo(float f) {
        this.f16063Xx000oIo = OOXIXo.X0o0xo(f);
    }

    public void OxxIIOOXO() {
        Oxx0IOOO oxx0IOOO = this.f16065oOXoIIIo;
        oxx0IOOO.f3771IXxxXO = 0.0f;
        oxx0IOOO.f3772Oxx0xo = 0.0f;
    }

    public final void oO(MotionEvent motionEvent, float f, float f2) {
        this.f16048XO = ChartTouchListener.ChartGesture.DRAG;
        this.f16061XI0IXoo.set(this.f16062XIxXXX0x0);
        II0xO0 onChartGestureListener = ((BarLineChartBase) this.f16049oI0IIXIo).getOnChartGestureListener();
        if (ooOOo0oXI()) {
            if (this.f16049oI0IIXIo instanceof HorizontalBarChart) {
                f = -f;
            } else {
                f2 = -f2;
            }
        }
        this.f16061XI0IXoo.postTranslate(f, f2);
        if (onChartGestureListener != null) {
            onChartGestureListener.X0o0xo(motionEvent, f, f2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        float f;
        this.f16048XO = ChartTouchListener.ChartGesture.DOUBLE_TAP;
        II0xO0 onChartGestureListener = ((BarLineChartBase) this.f16049oI0IIXIo).getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.II0XooXoX(motionEvent);
        }
        if (((BarLineChartBase) this.f16049oI0IIXIo).Ioxxx() && ((o0xxxXXxX.I0Io) ((BarLineChartBase) this.f16049oI0IIXIo).getData()).IXxxXO() > 0) {
            Oxx0IOOO xoIox2 = xoIox(motionEvent.getX(), motionEvent.getY());
            T t = this.f16049oI0IIXIo;
            BarLineChartBase barLineChartBase = (BarLineChartBase) t;
            float f2 = 1.0f;
            if (((BarLineChartBase) t).I0()) {
                f = 1.4f;
            } else {
                f = 1.0f;
            }
            if (((BarLineChartBase) this.f16049oI0IIXIo).ooOx()) {
                f2 = 1.4f;
            }
            barLineChartBase.IoIOOxIIo(f, f2, xoIox2.f3771IXxxXO, xoIox2.f3772Oxx0xo);
            if (((BarLineChartBase) this.f16049oI0IIXIo).Xx000oIo()) {
                Log.i("BarlineChartTouch", "Double-Tap, Zooming In, x: " + xoIox2.f3771IXxxXO + ", y: " + xoIox2.f3772Oxx0xo);
            }
            Oxx0IOOO.II0XooXoX(xoIox2);
        }
        return super.onDoubleTap(motionEvent);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        this.f16048XO = ChartTouchListener.ChartGesture.FLING;
        II0xO0 onChartGestureListener = ((BarLineChartBase) this.f16049oI0IIXIo).getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.II0xO0(motionEvent, motionEvent2, f, f2);
        }
        return super.onFling(motionEvent, motionEvent2, f, f2);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        this.f16048XO = ChartTouchListener.ChartGesture.LONG_PRESS;
        II0xO0 onChartGestureListener = ((BarLineChartBase) this.f16049oI0IIXIo).getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.oxoX(motionEvent);
        }
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        this.f16048XO = ChartTouchListener.ChartGesture.SINGLE_TAP;
        II0xO0 onChartGestureListener = ((BarLineChartBase) this.f16049oI0IIXIo).getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.I0Io(motionEvent);
        }
        if (!((BarLineChartBase) this.f16049oI0IIXIo).oOXoIIIo()) {
            return false;
        }
        X0o0xo(((BarLineChartBase) this.f16049oI0IIXIo).o00(motionEvent.getX(), motionEvent.getY()), motionEvent);
        return super.onSingleTapUp(motionEvent);
    }

    @Override // android.view.View.OnTouchListener
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouch(View view, MotionEvent motionEvent) {
        float f;
        VelocityTracker velocityTracker;
        if (this.f16067oo0xXOI0I == null) {
            this.f16067oo0xXOI0I = VelocityTracker.obtain();
        }
        this.f16067oo0xXOI0I.addMovement(motionEvent);
        int i = 3;
        if (motionEvent.getActionMasked() == 3 && (velocityTracker = this.f16067oo0xXOI0I) != null) {
            velocityTracker.recycle();
            this.f16067oo0xXOI0I = null;
        }
        if (this.f16046Oo == 0) {
            this.f16047Oxx0xo.onTouchEvent(motionEvent);
        }
        if (!((BarLineChartBase) this.f16049oI0IIXIo).xxIO() && !((BarLineChartBase) this.f16049oI0IIXIo).I0() && !((BarLineChartBase) this.f16049oI0IIXIo).ooOx()) {
            return true;
        }
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                        if (action != 5) {
                            if (action == 6) {
                                OOXIXo.oOXoIIIo(motionEvent, this.f16067oo0xXOI0I);
                                this.f16046Oo = 5;
                            }
                        } else if (motionEvent.getPointerCount() >= 2) {
                            ((BarLineChartBase) this.f16049oI0IIXIo).oI0IIXIo();
                            IXxxXO(motionEvent);
                            this.f16070xXxxox0I = OOXIXo(motionEvent);
                            this.f16058IIX0o = oOoXoXO(motionEvent);
                            float oI0IIXIo2 = oI0IIXIo(motionEvent);
                            this.f16068ooXIXxIX = oI0IIXIo2;
                            if (oI0IIXIo2 > 10.0f) {
                                if (((BarLineChartBase) this.f16049oI0IIXIo).IIxOXoOo0()) {
                                    this.f16046Oo = 4;
                                } else if (((BarLineChartBase) this.f16049oI0IIXIo).I0() != ((BarLineChartBase) this.f16049oI0IIXIo).ooOx()) {
                                    if (((BarLineChartBase) this.f16049oI0IIXIo).I0()) {
                                        i = 2;
                                    }
                                    this.f16046Oo = i;
                                } else {
                                    if (this.f16070xXxxox0I > this.f16058IIX0o) {
                                        i = 2;
                                    }
                                    this.f16046Oo = i;
                                }
                            }
                            x0XOIxOo(this.f16064XxX0x0xxx, motionEvent);
                        }
                    } else {
                        this.f16046Oo = 0;
                        II0xO0(motionEvent);
                    }
                } else {
                    int i2 = this.f16046Oo;
                    if (i2 == 1) {
                        ((BarLineChartBase) this.f16049oI0IIXIo).oI0IIXIo();
                        float f2 = 0.0f;
                        if (((BarLineChartBase) this.f16049oI0IIXIo).XX0xXo()) {
                            f = motionEvent.getX() - this.f16071xxX.f3771IXxxXO;
                        } else {
                            f = 0.0f;
                        }
                        if (((BarLineChartBase) this.f16049oI0IIXIo).o0xxxXXxX()) {
                            f2 = motionEvent.getY() - this.f16071xxX.f3772Oxx0xo;
                        }
                        oO(motionEvent, f, f2);
                    } else if (i2 != 2 && i2 != 3 && i2 != 4) {
                        if (i2 == 0 && Math.abs(ChartTouchListener.oIX0oI(motionEvent.getX(), this.f16071xxX.f3771IXxxXO, motionEvent.getY(), this.f16071xxX.f3772Oxx0xo)) > this.f16063Xx000oIo && ((BarLineChartBase) this.f16049oI0IIXIo).xxIO()) {
                            if (((BarLineChartBase) this.f16049oI0IIXIo).ox() && ((BarLineChartBase) this.f16049oI0IIXIo).xoIxX()) {
                                if (((BarLineChartBase) this.f16049oI0IIXIo).XI0oooXX()) {
                                    this.f16048XO = ChartTouchListener.ChartGesture.DRAG;
                                    if (((BarLineChartBase) this.f16049oI0IIXIo).XI0oooXX()) {
                                        x0xO0oo(motionEvent);
                                    }
                                }
                            } else {
                                float abs = Math.abs(motionEvent.getX() - this.f16071xxX.f3771IXxxXO);
                                float abs2 = Math.abs(motionEvent.getY() - this.f16071xxX.f3772Oxx0xo);
                                if ((((BarLineChartBase) this.f16049oI0IIXIo).XX0xXo() || abs2 >= abs) && (((BarLineChartBase) this.f16049oI0IIXIo).o0xxxXXxX() || abs2 <= abs)) {
                                    this.f16048XO = ChartTouchListener.ChartGesture.DRAG;
                                    this.f16046Oo = 1;
                                }
                            }
                        }
                    } else {
                        ((BarLineChartBase) this.f16049oI0IIXIo).oI0IIXIo();
                        if (((BarLineChartBase) this.f16049oI0IIXIo).I0() || ((BarLineChartBase) this.f16049oI0IIXIo).ooOx()) {
                            Oo(motionEvent);
                        }
                    }
                }
            } else {
                VelocityTracker velocityTracker2 = this.f16067oo0xXOI0I;
                int pointerId = motionEvent.getPointerId(0);
                velocityTracker2.computeCurrentVelocity(1000, OOXIXo.o00());
                float yVelocity = velocityTracker2.getYVelocity(pointerId);
                float xVelocity = velocityTracker2.getXVelocity(pointerId);
                if ((Math.abs(xVelocity) > OOXIXo.OxI() || Math.abs(yVelocity) > OOXIXo.OxI()) && this.f16046Oo == 1 && ((BarLineChartBase) this.f16049oI0IIXIo).xI()) {
                    OxxIIOOXO();
                    this.f16066oo = AnimationUtils.currentAnimationTimeMillis();
                    this.f16059IoOoX.f3771IXxxXO = motionEvent.getX();
                    this.f16059IoOoX.f3772Oxx0xo = motionEvent.getY();
                    Oxx0IOOO oxx0IOOO = this.f16065oOXoIIIo;
                    oxx0IOOO.f3771IXxxXO = xVelocity;
                    oxx0IOOO.f3772Oxx0xo = yVelocity;
                    OOXIXo.oo(this.f16049oI0IIXIo);
                }
                int i3 = this.f16046Oo;
                if (i3 == 2 || i3 == 3 || i3 == 4 || i3 == 5) {
                    ((BarLineChartBase) this.f16049oI0IIXIo).x0xO0oo();
                    ((BarLineChartBase) this.f16049oI0IIXIo).postInvalidate();
                }
                this.f16046Oo = 0;
                ((BarLineChartBase) this.f16049oI0IIXIo).xoXoI();
                VelocityTracker velocityTracker3 = this.f16067oo0xXOI0I;
                if (velocityTracker3 != null) {
                    velocityTracker3.recycle();
                    this.f16067oo0xXOI0I = null;
                }
                II0xO0(motionEvent);
            }
        } else {
            Oxx0IOOO(motionEvent);
            OxxIIOOXO();
            IXxxXO(motionEvent);
        }
        this.f16061XI0IXoo = ((BarLineChartBase) this.f16049oI0IIXIo).getViewPortHandler().XOxIOxOx(this.f16061XI0IXoo, this.f16049oI0IIXIo, true);
        return true;
    }

    public final boolean ooOOo0oXI() {
        X0o0xo x0o0xo;
        if ((this.f16069xI == null && ((BarLineChartBase) this.f16049oI0IIXIo).x0xO()) || ((x0o0xo = this.f16069xI) != null && ((BarLineChartBase) this.f16049oI0IIXIo).X0o0xo(x0o0xo.OX00O0xII()))) {
            return true;
        }
        return false;
    }

    public final void x0xO0oo(MotionEvent motionEvent) {
        oxoX o002 = ((BarLineChartBase) this.f16049oI0IIXIo).o00(motionEvent.getX(), motionEvent.getY());
        if (o002 != null && !o002.oIX0oI(this.f16045IXxxXO)) {
            this.f16045IXxxXO = o002;
            ((BarLineChartBase) this.f16049oI0IIXIo).xXxxox0I(o002, true);
        }
    }

    public Oxx0IOOO xoIox(float f, float f2) {
        float f3;
        oOoXoXO viewPortHandler = ((BarLineChartBase) this.f16049oI0IIXIo).getViewPortHandler();
        float IO2 = f - viewPortHandler.IO();
        if (ooOOo0oXI()) {
            f3 = -(f2 - viewPortHandler.x0o());
        } else {
            f3 = -((((BarLineChartBase) this.f16049oI0IIXIo).getMeasuredHeight() - f2) - viewPortHandler.X00IoxXI());
        }
        return Oxx0IOOO.I0Io(IO2, f3);
    }

    public Matrix xxIXOIIO() {
        return this.f16061XI0IXoo;
    }
}
