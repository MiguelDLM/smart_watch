package com.tencent.connect.avatar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

/* loaded from: classes13.dex */
public class c extends ImageView {

    /* renamed from: IIXOooo, reason: collision with root package name */
    public boolean f26698IIXOooo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public int f26699IXxxXO;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public PointF f26700O0xOxO;

    /* renamed from: Oo, reason: collision with root package name */
    public Matrix f26701Oo;

    /* renamed from: OxI, reason: collision with root package name */
    public final String f26702OxI;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public float f26703Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public Bitmap f26704OxxIIOOXO;

    /* renamed from: X0IIOO, reason: collision with root package name */
    public PointF f26705X0IIOO;

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public float f26706XI0IXoo;

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    public float f26707XIxXXX0x0;

    /* renamed from: XO, reason: collision with root package name */
    public Matrix f26708XO;

    /* renamed from: XxX0x0xxx, reason: collision with root package name */
    public Rect f26709XxX0x0xxx;

    /* renamed from: o00, reason: collision with root package name */
    public float f26710o00;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public float f26711oI0IIXIo;

    /* renamed from: xoXoI, reason: collision with root package name */
    public float f26712xoXoI;

    /* renamed from: xxX, reason: collision with root package name */
    public boolean f26713xxX;

    /* loaded from: classes13.dex */
    public class oIX0oI implements Runnable {

        /* renamed from: com.tencent.connect.avatar.c$oIX0oI$oIX0oI, reason: collision with other inner class name */
        /* loaded from: classes13.dex */
        public class RunnableC1085oIX0oI implements Runnable {
            public RunnableC1085oIX0oI() {
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.clearAnimation();
                c.this.Oxx0IOOO();
            }
        }

        public oIX0oI() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Thread.sleep(300L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            c.this.post(new RunnableC1085oIX0oI());
            c.this.f26698IIXOooo = false;
        }
    }

    public c(Context context) {
        super(context);
        this.f26708XO = new Matrix();
        this.f26701Oo = new Matrix();
        this.f26699IXxxXO = 0;
        this.f26703Oxx0xo = 1.0f;
        this.f26711oI0IIXIo = 1.0f;
        this.f26698IIXOooo = false;
        this.f26702OxI = "TouchView";
        this.f26700O0xOxO = new PointF();
        this.f26705X0IIOO = new PointF();
        this.f26706XI0IXoo = 1.0f;
        this.f26707XIxXXX0x0 = 0.0f;
        this.f26713xxX = false;
        Rect rect = new Rect();
        this.f26709XxX0x0xxx = rect;
        getDrawingRect(rect);
        II0xO0();
    }

    public final void I0Io(PointF pointF) {
        if (this.f26704OxxIIOOXO == null) {
            return;
        }
        float[] fArr = new float[9];
        this.f26708XO.getValues(fArr);
        float f = fArr[2];
        float f2 = fArr[5];
        float f3 = fArr[0];
        float width = this.f26704OxxIIOOXO.getWidth() * f3;
        float height = this.f26704OxxIIOOXO.getHeight() * f3;
        Rect rect = this.f26709XxX0x0xxx;
        float f4 = rect.left - f;
        float f5 = 1.0f;
        if (f4 <= 1.0f) {
            f4 = 1.0f;
        }
        float f6 = (f + width) - rect.right;
        if (f6 <= 1.0f) {
            f6 = 1.0f;
        }
        float width2 = (rect.width() * f4) / (f6 + f4);
        Rect rect2 = this.f26709XxX0x0xxx;
        float f7 = width2 + rect2.left;
        float f8 = rect2.top - f2;
        float f9 = (f2 + height) - rect2.bottom;
        if (f8 <= 1.0f) {
            f8 = 1.0f;
        }
        if (f9 > 1.0f) {
            f5 = f9;
        }
        pointF.set(f7, ((rect2.height() * f8) / (f5 + f8)) + this.f26709XxX0x0xxx.top);
    }

    public final void II0XooXoX() {
        if (this.f26704OxxIIOOXO == null) {
            return;
        }
        this.f26708XO.getValues(r0);
        float max = Math.max(this.f26709XxX0x0xxx.width() / this.f26704OxxIIOOXO.getWidth(), this.f26709XxX0x0xxx.height() / this.f26704OxxIIOOXO.getHeight());
        this.f26712xoXoI = this.f26709XxX0x0xxx.left - (((this.f26704OxxIIOOXO.getWidth() * max) - this.f26709XxX0x0xxx.width()) / 2.0f);
        float height = this.f26709XxX0x0xxx.top - (((this.f26704OxxIIOOXO.getHeight() * max) - this.f26709XxX0x0xxx.height()) / 2.0f);
        this.f26710o00 = height;
        float[] fArr = {max, 0.0f, this.f26712xoXoI, 0.0f, max, height};
        this.f26708XO.setValues(fArr);
        float min = Math.min(2048.0f / this.f26704OxxIIOOXO.getWidth(), 2048.0f / this.f26704OxxIIOOXO.getHeight());
        this.f26703Oxx0xo = min;
        this.f26711oI0IIXIo = max;
        if (min < max) {
            this.f26703Oxx0xo = max;
        }
        setImageMatrix(this.f26708XO);
    }

    public final void II0xO0() {
    }

    public final void Oxx0IOOO() {
        boolean z;
        Animation animation;
        if (this.f26704OxxIIOOXO == null) {
            return;
        }
        float width = this.f26709XxX0x0xxx.width();
        float height = this.f26709XxX0x0xxx.height();
        float[] fArr = new float[9];
        this.f26708XO.getValues(fArr);
        float f = fArr[2];
        float f2 = fArr[5];
        float f3 = fArr[0];
        float f4 = this.f26703Oxx0xo;
        if (f3 > f4) {
            float f5 = f4 / f3;
            this.f26707XIxXXX0x0 = f5;
            Matrix matrix = this.f26708XO;
            PointF pointF = this.f26705X0IIOO;
            matrix.postScale(f5, f5, pointF.x, pointF.y);
            setImageMatrix(this.f26708XO);
            float f6 = this.f26707XIxXXX0x0;
            float f7 = 1.0f / f6;
            float f8 = 1.0f / f6;
            PointF pointF2 = this.f26705X0IIOO;
            animation = new ScaleAnimation(f7, 1.0f, f8, 1.0f, pointF2.x, pointF2.y);
        } else {
            float f9 = this.f26711oI0IIXIo;
            if (f3 < f9) {
                float f10 = f9 / f3;
                this.f26707XIxXXX0x0 = f10;
                Matrix matrix2 = this.f26708XO;
                PointF pointF3 = this.f26705X0IIOO;
                matrix2.postScale(f10, f10, pointF3.x, pointF3.y);
                float f11 = this.f26707XIxXXX0x0;
                PointF pointF4 = this.f26705X0IIOO;
                animation = new ScaleAnimation(1.0f, f11, 1.0f, f11, pointF4.x, pointF4.y);
            } else {
                float width2 = this.f26704OxxIIOOXO.getWidth() * f3;
                float height2 = this.f26704OxxIIOOXO.getHeight() * f3;
                Rect rect = this.f26709XxX0x0xxx;
                int i = rect.left;
                float f12 = i - f;
                int i2 = rect.top;
                float f13 = i2 - f2;
                if (f12 < 0.0f) {
                    f = i;
                    z = true;
                } else {
                    z = false;
                }
                if (f13 < 0.0f) {
                    f2 = i2;
                    z = true;
                }
                float f14 = height2 - f13;
                if (width2 - f12 < width) {
                    f = i - (width2 - width);
                    z = true;
                }
                if (f14 < height) {
                    f2 = i2 - (height2 - height);
                    z = true;
                }
                if (z) {
                    float f15 = fArr[2] - f;
                    float f16 = fArr[5] - f2;
                    fArr[2] = f;
                    fArr[5] = f2;
                    this.f26708XO.setValues(fArr);
                    setImageMatrix(this.f26708XO);
                    animation = new TranslateAnimation(f15, 0.0f, f16, 0.0f);
                } else {
                    setImageMatrix(this.f26708XO);
                    animation = null;
                }
            }
        }
        if (animation != null) {
            this.f26698IIXOooo = true;
            animation.setDuration(300L);
            startAnimation(animation);
            new Thread(new oIX0oI()).start();
        }
    }

    public final float oIX0oI(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() < 2) {
            return 0.0f;
        }
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0019, code lost:
    
        if (r0 != 6) goto L28;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            boolean r0 = r5.f26698IIXOooo
            r1 = 1
            if (r0 == 0) goto L6
            return r1
        L6:
            int r0 = r6.getAction()
            r0 = r0 & 255(0xff, float:3.57E-43)
            if (r0 == 0) goto L90
            if (r0 == r1) goto L89
            r2 = 1092616192(0x41200000, float:10.0)
            r3 = 2
            if (r0 == r3) goto L37
            r4 = 5
            if (r0 == r4) goto L1d
            r6 = 6
            if (r0 == r6) goto L89
            goto Laf
        L1d:
            float r6 = r5.oIX0oI(r6)
            r5.f26706XI0IXoo = r6
            int r6 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r6 <= 0) goto Laf
            android.graphics.Matrix r6 = r5.f26701Oo
            android.graphics.Matrix r0 = r5.f26708XO
            r6.set(r0)
            android.graphics.PointF r6 = r5.f26705X0IIOO
            r5.I0Io(r6)
            r5.f26699IXxxXO = r3
            goto Laf
        L37:
            int r0 = r5.f26699IXxxXO
            if (r0 != r1) goto L5f
            android.graphics.Matrix r0 = r5.f26708XO
            android.graphics.Matrix r2 = r5.f26701Oo
            r0.set(r2)
            float r0 = r6.getX()
            android.graphics.PointF r2 = r5.f26700O0xOxO
            float r2 = r2.x
            float r0 = r0 - r2
            float r6 = r6.getY()
            android.graphics.PointF r2 = r5.f26700O0xOxO
            float r2 = r2.y
            float r6 = r6 - r2
            android.graphics.Matrix r2 = r5.f26708XO
            r2.postTranslate(r0, r6)
            android.graphics.Matrix r6 = r5.f26708XO
            r5.setImageMatrix(r6)
            goto Laf
        L5f:
            if (r0 != r3) goto Laf
            android.graphics.Matrix r0 = r5.f26708XO
            r0.set(r0)
            float r6 = r5.oIX0oI(r6)
            int r0 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r0 <= 0) goto L83
            android.graphics.Matrix r0 = r5.f26708XO
            android.graphics.Matrix r2 = r5.f26701Oo
            r0.set(r2)
            float r0 = r5.f26706XI0IXoo
            float r6 = r6 / r0
            android.graphics.Matrix r0 = r5.f26708XO
            android.graphics.PointF r2 = r5.f26705X0IIOO
            float r3 = r2.x
            float r2 = r2.y
            r0.postScale(r6, r6, r3, r2)
        L83:
            android.graphics.Matrix r6 = r5.f26708XO
            r5.setImageMatrix(r6)
            goto Laf
        L89:
            r5.Oxx0IOOO()
            r6 = 0
            r5.f26699IXxxXO = r6
            goto Laf
        L90:
            android.graphics.Matrix r0 = r5.f26708XO
            android.graphics.Matrix r2 = r5.getImageMatrix()
            r0.set(r2)
            android.graphics.Matrix r0 = r5.f26701Oo
            android.graphics.Matrix r2 = r5.f26708XO
            r0.set(r2)
            android.graphics.PointF r0 = r5.f26700O0xOxO
            float r2 = r6.getX()
            float r6 = r6.getY()
            r0.set(r2, r6)
            r5.f26699IXxxXO = r1
        Laf:
            r5.f26713xxX = r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.connect.avatar.c.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void oxoX(Rect rect) {
        this.f26709XxX0x0xxx = rect;
        if (this.f26704OxxIIOOXO != null) {
            II0XooXoX();
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        this.f26704OxxIIOOXO = bitmap;
        if (bitmap != null) {
            this.f26704OxxIIOOXO = bitmap;
        }
    }
}
