package com.baidu.navisdk.widget.photoview;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private int f9424a = -1;
    private int b = 0;
    private final ScaleGestureDetector c;
    private VelocityTracker d;
    private boolean e;
    private float f;
    private float g;
    private final float h;
    private final float i;
    private c j;

    /* loaded from: classes8.dex */
    public class a implements ScaleGestureDetector.OnScaleGestureListener {
        public a() {
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            float scaleFactor = scaleGestureDetector.getScaleFactor();
            if (!Float.isNaN(scaleFactor) && !Float.isInfinite(scaleFactor)) {
                b.this.j.a(scaleFactor, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
                return true;
            }
            return false;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        }
    }

    public b(Context context, c cVar) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.i = viewConfiguration.getScaledMinimumFlingVelocity();
        this.h = viewConfiguration.getScaledTouchSlop();
        this.j = cVar;
        this.c = new ScaleGestureDetector(context, new a());
    }

    private float b(MotionEvent motionEvent) {
        try {
            return motionEvent.getX(this.b);
        } catch (Exception unused) {
            return motionEvent.getX();
        }
    }

    private float c(MotionEvent motionEvent) {
        try {
            return motionEvent.getY(this.b);
        } catch (Exception unused) {
            return motionEvent.getY();
        }
    }

    private boolean d(MotionEvent motionEvent) {
        boolean z;
        int i;
        int action = motionEvent.getAction() & 255;
        int i2 = 0;
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                        if (action == 6) {
                            int a2 = l.a(motionEvent.getAction());
                            if (motionEvent.getPointerId(a2) == this.f9424a) {
                                if (a2 == 0) {
                                    i = 1;
                                } else {
                                    i = 0;
                                }
                                this.f9424a = motionEvent.getPointerId(i);
                                this.f = motionEvent.getX(i);
                                this.g = motionEvent.getY(i);
                            }
                        }
                    } else {
                        this.f9424a = -1;
                        VelocityTracker velocityTracker = this.d;
                        if (velocityTracker != null) {
                            velocityTracker.recycle();
                            this.d = null;
                        }
                    }
                } else {
                    float b = b(motionEvent);
                    float c = c(motionEvent);
                    float f = b - this.f;
                    float f2 = c - this.g;
                    if (!this.e) {
                        if (Math.sqrt((f * f) + (f2 * f2)) >= this.h) {
                            z = true;
                        } else {
                            z = false;
                        }
                        this.e = z;
                    }
                    if (this.e) {
                        this.j.a(f, f2);
                        this.f = b;
                        this.g = c;
                        VelocityTracker velocityTracker2 = this.d;
                        if (velocityTracker2 != null) {
                            velocityTracker2.addMovement(motionEvent);
                        }
                    }
                }
            } else {
                this.f9424a = -1;
                if (this.e && this.d != null) {
                    this.f = b(motionEvent);
                    this.g = c(motionEvent);
                    this.d.addMovement(motionEvent);
                    this.d.computeCurrentVelocity(1000);
                    float xVelocity = this.d.getXVelocity();
                    float yVelocity = this.d.getYVelocity();
                    if (Math.max(Math.abs(xVelocity), Math.abs(yVelocity)) >= this.i) {
                        this.j.a(this.f, this.g, -xVelocity, -yVelocity);
                    }
                }
                VelocityTracker velocityTracker3 = this.d;
                if (velocityTracker3 != null) {
                    velocityTracker3.recycle();
                    this.d = null;
                }
            }
        } else {
            this.f9424a = motionEvent.getPointerId(0);
            VelocityTracker obtain = VelocityTracker.obtain();
            this.d = obtain;
            if (obtain != null) {
                obtain.addMovement(motionEvent);
            }
            this.f = b(motionEvent);
            this.g = c(motionEvent);
            this.e = false;
        }
        int i3 = this.f9424a;
        if (i3 != -1) {
            i2 = i3;
        }
        this.b = motionEvent.findPointerIndex(i2);
        return true;
    }

    public boolean a() {
        return this.e;
    }

    public boolean a(MotionEvent motionEvent) {
        try {
            this.c.onTouchEvent(motionEvent);
            return d(motionEvent);
        } catch (IllegalArgumentException unused) {
            return true;
        }
    }

    public boolean b() {
        return this.c.isInProgress();
    }
}
