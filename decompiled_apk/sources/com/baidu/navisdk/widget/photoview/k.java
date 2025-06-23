package com.baidu.navisdk.widget.photoview;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.OverScroller;

/* loaded from: classes8.dex */
public class k implements View.OnTouchListener, View.OnLayoutChangeListener {
    private static float E = 3.0f;
    private static float F = 1.75f;
    private static float G = 1.0f;
    private static int H = 200;
    private static int I = 1;
    private float A;
    private ImageView h;
    private GestureDetector i;
    private com.baidu.navisdk.widget.photoview.b j;
    private com.baidu.navisdk.widget.photoview.d p;
    private com.baidu.navisdk.widget.photoview.f q;
    private com.baidu.navisdk.widget.photoview.e r;
    private j s;
    private View.OnClickListener t;
    private View.OnLongClickListener u;
    private g v;
    private h w;
    private i x;
    private f y;

    /* renamed from: a, reason: collision with root package name */
    private Interpolator f9426a = new AccelerateDecelerateInterpolator();
    private int b = H;
    private float c = G;
    private float d = F;
    private float e = E;
    private boolean f = true;
    private boolean g = false;
    private final Matrix k = new Matrix();
    private final Matrix l = new Matrix();
    private final Matrix m = new Matrix();
    private final RectF n = new RectF();
    private final float[] o = new float[9];
    private int z = 2;
    private boolean B = true;
    private ImageView.ScaleType C = ImageView.ScaleType.FIT_CENTER;
    private com.baidu.navisdk.widget.photoview.c D = new a();

    /* loaded from: classes8.dex */
    public class b extends GestureDetector.SimpleOnGestureListener {
        public b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (k.this.w == null || k.this.f() > k.G || motionEvent.getPointerCount() > k.I || motionEvent.getPointerCount() > k.I) {
                return false;
            }
            return k.this.w.onFling(motionEvent, motionEvent2, f, f2);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (k.this.u != null) {
                k.this.u.onLongClick(k.this.h);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements GestureDetector.OnDoubleTapListener {
        public c() {
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            try {
                float f = k.this.f();
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                if (f < k.this.d()) {
                    k kVar = k.this;
                    kVar.a(kVar.d(), x, y, true);
                } else {
                    k kVar2 = k.this;
                    kVar2.a(kVar2.e(), x, y, true);
                }
            } catch (ArrayIndexOutOfBoundsException unused) {
            }
            return true;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTapEvent(MotionEvent motionEvent) {
            return false;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (k.this.t != null) {
                k.this.t.onClick(k.this.h);
            }
            RectF a2 = k.this.a();
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (k.this.s != null) {
                k.this.s.a(k.this.h, x, y);
            }
            if (a2 != null) {
                if (a2.contains(x, y)) {
                    float width = (x - a2.left) / a2.width();
                    float height = (y - a2.top) / a2.height();
                    if (k.this.q != null) {
                        k.this.q.a(k.this.h, width, height);
                        return true;
                    }
                    return true;
                }
                if (k.this.r != null) {
                    k.this.r.a(k.this.h);
                    return false;
                }
                return false;
            }
            return false;
        }
    }

    /* loaded from: classes8.dex */
    public static /* synthetic */ class d {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f9430a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            f9430a = iArr;
            try {
                iArr[ImageView.ScaleType.FIT_CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9430a[ImageView.ScaleType.FIT_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f9430a[ImageView.ScaleType.FIT_END.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f9430a[ImageView.ScaleType.FIT_XY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final float f9431a;
        private final float b;
        private final long c = System.currentTimeMillis();
        private final float d;
        private final float e;

        public e(float f, float f2, float f3, float f4) {
            this.f9431a = f3;
            this.b = f4;
            this.d = f;
            this.e = f2;
        }

        private float a() {
            return k.this.f9426a.getInterpolation(Math.min(1.0f, (((float) (System.currentTimeMillis() - this.c)) * 1.0f) / k.this.b));
        }

        @Override // java.lang.Runnable
        public void run() {
            float a2 = a();
            float f = this.d;
            k.this.D.a((f + ((this.e - f) * a2)) / k.this.f(), this.f9431a, this.b);
            if (a2 < 1.0f) {
                com.baidu.navisdk.widget.photoview.a.a(k.this.h, this);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final OverScroller f9432a;
        private int b;
        private int c;

        public f(Context context) {
            this.f9432a = new OverScroller(context);
        }

        public void a() {
            this.f9432a.forceFinished(true);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.f9432a.isFinished() && this.f9432a.computeScrollOffset()) {
                int currX = this.f9432a.getCurrX();
                int currY = this.f9432a.getCurrY();
                k.this.m.postTranslate(this.b - currX, this.c - currY);
                k.this.l();
                this.b = currX;
                this.c = currY;
                com.baidu.navisdk.widget.photoview.a.a(k.this.h, this);
            }
        }

        public void a(int i, int i2, int i3, int i4) {
            int i5;
            int i6;
            int i7;
            int i8;
            RectF a2 = k.this.a();
            if (a2 == null) {
                return;
            }
            int round = Math.round(-a2.left);
            float f = i;
            if (f < a2.width()) {
                i6 = Math.round(a2.width() - f);
                i5 = 0;
            } else {
                i5 = round;
                i6 = i5;
            }
            int round2 = Math.round(-a2.top);
            float f2 = i2;
            if (f2 < a2.height()) {
                i8 = Math.round(a2.height() - f2);
                i7 = 0;
            } else {
                i7 = round2;
                i8 = i7;
            }
            this.b = round;
            this.c = round2;
            if (round == i6 && round2 == i8) {
                return;
            }
            this.f9432a.fling(round, round2, i3, i4, i5, i6, i7, i8, 0, 0);
        }
    }

    public k(ImageView imageView) {
        this.h = imageView;
        imageView.setOnTouchListener(this);
        imageView.addOnLayoutChangeListener(this);
        if (imageView.isInEditMode()) {
            return;
        }
        this.A = 0.0f;
        this.j = new com.baidu.navisdk.widget.photoview.b(imageView.getContext(), this.D);
        GestureDetector gestureDetector = new GestureDetector(imageView.getContext(), new b());
        this.i = gestureDetector;
        gestureDetector.setOnDoubleTapListener(new c());
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        if (i != i5 || i2 != i6 || i3 != i7 || i4 != i8) {
            a(this.h.getDrawable());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b2  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouch(android.view.View r11, android.view.MotionEvent r12) {
        /*
            r10 = this;
            boolean r0 = r10.B
            r1 = 0
            if (r0 == 0) goto Lbe
            r0 = r11
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            boolean r0 = com.baidu.navisdk.widget.photoview.l.a(r0)
            if (r0 == 0) goto Lbe
            int r0 = r12.getAction()
            r2 = 1
            if (r0 == 0) goto L6e
            if (r0 == r2) goto L1b
            r3 = 3
            if (r0 == r3) goto L1b
            goto L7a
        L1b:
            float r0 = r10.f()
            float r3 = r10.c
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 >= 0) goto L45
            android.graphics.RectF r0 = r10.a()
            if (r0 == 0) goto L7a
            com.baidu.navisdk.widget.photoview.k$e r9 = new com.baidu.navisdk.widget.photoview.k$e
            float r5 = r10.f()
            float r6 = r10.c
            float r7 = r0.centerX()
            float r8 = r0.centerY()
            r3 = r9
            r4 = r10
            r3.<init>(r5, r6, r7, r8)
            r11.post(r9)
        L43:
            r11 = 1
            goto L7b
        L45:
            float r0 = r10.f()
            float r3 = r10.e
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 <= 0) goto L7a
            android.graphics.RectF r0 = r10.a()
            if (r0 == 0) goto L7a
            com.baidu.navisdk.widget.photoview.k$e r9 = new com.baidu.navisdk.widget.photoview.k$e
            float r5 = r10.f()
            float r6 = r10.e
            float r7 = r0.centerX()
            float r8 = r0.centerY()
            r3 = r9
            r4 = r10
            r3.<init>(r5, r6, r7, r8)
            r11.post(r9)
            goto L43
        L6e:
            android.view.ViewParent r11 = r11.getParent()
            if (r11 == 0) goto L77
            r11.requestDisallowInterceptTouchEvent(r2)
        L77:
            r10.k()
        L7a:
            r11 = 0
        L7b:
            com.baidu.navisdk.widget.photoview.b r0 = r10.j
            if (r0 == 0) goto Lb2
            boolean r11 = r0.b()
            com.baidu.navisdk.widget.photoview.b r0 = r10.j
            boolean r0 = r0.a()
            com.baidu.navisdk.widget.photoview.b r3 = r10.j
            boolean r3 = r3.a(r12)
            if (r11 != 0) goto L9b
            com.baidu.navisdk.widget.photoview.b r11 = r10.j
            boolean r11 = r11.b()
            if (r11 != 0) goto L9b
            r11 = 1
            goto L9c
        L9b:
            r11 = 0
        L9c:
            if (r0 != 0) goto La8
            com.baidu.navisdk.widget.photoview.b r0 = r10.j
            boolean r0 = r0.a()
            if (r0 != 0) goto La8
            r0 = 1
            goto La9
        La8:
            r0 = 0
        La9:
            if (r11 == 0) goto Lae
            if (r0 == 0) goto Lae
            r1 = 1
        Lae:
            r10.g = r1
            r1 = r3
            goto Lb3
        Lb2:
            r1 = r11
        Lb3:
            android.view.GestureDetector r11 = r10.i
            if (r11 == 0) goto Lbe
            boolean r11 = r11.onTouchEvent(r12)
            if (r11 == 0) goto Lbe
            r1 = 1
        Lbe:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.widget.photoview.k.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    private void k() {
        f fVar = this.y;
        if (fVar != null) {
            fVar.a();
            this.y = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        if (m()) {
            b(n());
        }
    }

    private boolean m() {
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        RectF a2 = a(n());
        if (a2 == null) {
            return false;
        }
        float height = a2.height();
        float width = a2.width();
        float a3 = a(this.h);
        float f7 = 0.0f;
        if (height <= a3) {
            int i = d.f9430a[this.C.ordinal()];
            if (i != 2) {
                if (i != 3) {
                    a3 = (a3 - height) / 2.0f;
                    f3 = a2.top;
                } else {
                    a3 -= height;
                    f3 = a2.top;
                }
                f4 = a3 - f3;
            } else {
                f2 = a2.top;
                f4 = -f2;
            }
        } else {
            f2 = a2.top;
            if (f2 <= 0.0f) {
                f3 = a2.bottom;
                if (f3 >= a3) {
                    f4 = 0.0f;
                }
                f4 = a3 - f3;
            }
            f4 = -f2;
        }
        float b2 = b(this.h);
        if (width <= b2) {
            int i2 = d.f9430a[this.C.ordinal()];
            if (i2 != 2) {
                if (i2 != 3) {
                    f5 = (b2 - width) / 2.0f;
                    f6 = a2.left;
                } else {
                    f5 = b2 - width;
                    f6 = a2.left;
                }
                f7 = f5 - f6;
            } else {
                f7 = -a2.left;
            }
            this.z = 2;
        } else {
            float f8 = a2.left;
            if (f8 > 0.0f) {
                this.z = 0;
                f7 = -f8;
            } else {
                float f9 = a2.right;
                if (f9 < b2) {
                    f7 = b2 - f9;
                    this.z = 1;
                } else {
                    this.z = -1;
                }
            }
        }
        this.m.postTranslate(f7, f4);
        return true;
    }

    private Matrix n() {
        this.l.set(this.k);
        this.l.postConcat(this.m);
        return this.l;
    }

    private void o() {
        this.m.reset();
        d(this.A);
        b(n());
        m();
    }

    public float c() {
        return this.e;
    }

    public void d(float f2) {
        this.m.postRotate(f2 % 360.0f);
        l();
    }

    public void e(float f2) {
        this.m.setRotate(f2 % 360.0f);
        l();
    }

    public float f() {
        return (float) Math.sqrt(((float) Math.pow(a(this.m, 0), 2.0d)) + ((float) Math.pow(a(this.m, 3), 2.0d)));
    }

    public ImageView.ScaleType g() {
        return this.C;
    }

    public void h() {
        if (this.B) {
            a(this.h.getDrawable());
        } else {
            o();
        }
    }

    public void b(float f2) {
        l.a(this.c, f2, this.e);
        this.d = f2;
    }

    public void c(float f2) {
        l.a(f2, this.d, this.e);
        this.c = f2;
    }

    public void a(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.i.setOnDoubleTapListener(onDoubleTapListener);
    }

    public float d() {
        return this.d;
    }

    public float e() {
        return this.c;
    }

    public void a(g gVar) {
        this.v = gVar;
    }

    public void b(boolean z) {
        this.B = z;
        h();
    }

    public void f(float f2) {
        a(f2, false);
    }

    public void a(h hVar) {
        this.w = hVar;
    }

    public RectF a() {
        m();
        return a(n());
    }

    public Matrix b() {
        return this.l;
    }

    private void b(Matrix matrix) {
        RectF a2;
        this.h.setImageMatrix(matrix);
        if (this.p == null || (a2 = a(matrix)) == null) {
            return;
        }
        this.p.a(a2);
    }

    public void a(boolean z) {
        this.f = z;
    }

    public void a(float f2) {
        l.a(this.c, this.d, f2);
        this.e = f2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b(ImageView imageView) {
        return (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.u = onLongClickListener;
    }

    /* loaded from: classes8.dex */
    public class a implements com.baidu.navisdk.widget.photoview.c {
        public a() {
        }

        @Override // com.baidu.navisdk.widget.photoview.c
        public void a(float f, float f2) {
            if (k.this.j.b()) {
                return;
            }
            if (k.this.x != null) {
                k.this.x.a(f, f2);
            }
            k.this.m.postTranslate(f, f2);
            k.this.l();
            ViewParent parent = k.this.h.getParent();
            if (!k.this.f || k.this.j.b() || k.this.g) {
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
            } else if ((k.this.z == 2 || ((k.this.z == 0 && f >= 1.0f) || (k.this.z == 1 && f <= -1.0f))) && parent != null) {
                parent.requestDisallowInterceptTouchEvent(false);
            }
        }

        @Override // com.baidu.navisdk.widget.photoview.c
        public void a(float f, float f2, float f3, float f4) {
            k kVar = k.this;
            kVar.y = new f(kVar.h.getContext());
            f fVar = k.this.y;
            k kVar2 = k.this;
            int b = kVar2.b(kVar2.h);
            k kVar3 = k.this;
            fVar.a(b, kVar3.a(kVar3.h), (int) f3, (int) f4);
            k.this.h.post(k.this.y);
        }

        @Override // com.baidu.navisdk.widget.photoview.c
        public void a(float f, float f2, float f3) {
            if (k.this.f() < k.this.e || f < 1.0f) {
                if (k.this.f() > k.this.c || f > 1.0f) {
                    if (k.this.v != null) {
                        k.this.v.a(f, f2, f3);
                    }
                    k.this.m.postScale(f, f, f2, f3);
                    k.this.l();
                }
            }
        }
    }

    public void a(View.OnClickListener onClickListener) {
        this.t = onClickListener;
    }

    public void a(com.baidu.navisdk.widget.photoview.d dVar) {
        this.p = dVar;
    }

    public void a(com.baidu.navisdk.widget.photoview.f fVar) {
        this.q = fVar;
    }

    public void a(com.baidu.navisdk.widget.photoview.e eVar) {
        this.r = eVar;
    }

    public void a(j jVar) {
        this.s = jVar;
    }

    public void a(i iVar) {
        this.x = iVar;
    }

    public void a(float f2, boolean z) {
        a(f2, this.h.getRight() / 2, this.h.getBottom() / 2, z);
    }

    public void a(float f2, float f3, float f4, boolean z) {
        if (f2 < this.c || f2 > this.e) {
            throw new IllegalArgumentException("Scale must be within the range of minScale and maxScale");
        }
        if (z) {
            this.h.post(new e(f(), f2, f3, f4));
        } else {
            this.m.setScale(f2, f2, f3, f4);
            l();
        }
    }

    public void a(ImageView.ScaleType scaleType) {
        if (!l.a(scaleType) || scaleType == this.C) {
            return;
        }
        this.C = scaleType;
        h();
    }

    public void a(int i) {
        this.b = i;
    }

    private float a(Matrix matrix, int i) {
        matrix.getValues(this.o);
        return this.o[i];
    }

    private RectF a(Matrix matrix) {
        if (this.h.getDrawable() == null) {
            return null;
        }
        this.n.set(0.0f, 0.0f, r0.getIntrinsicWidth(), r0.getIntrinsicHeight());
        matrix.mapRect(this.n);
        return this.n;
    }

    private void a(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        float b2 = b(this.h);
        float a2 = a(this.h);
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        this.k.reset();
        float f2 = intrinsicWidth;
        float f3 = b2 / f2;
        float f4 = intrinsicHeight;
        float f5 = a2 / f4;
        ImageView.ScaleType scaleType = this.C;
        if (scaleType == ImageView.ScaleType.CENTER) {
            this.k.postTranslate((b2 - f2) / 2.0f, (a2 - f4) / 2.0f);
        } else if (scaleType == ImageView.ScaleType.CENTER_CROP) {
            float max = Math.max(f3, f5);
            this.k.postScale(max, max);
            this.k.postTranslate((b2 - (f2 * max)) / 2.0f, (a2 - (f4 * max)) / 2.0f);
        } else if (scaleType == ImageView.ScaleType.CENTER_INSIDE) {
            float min = Math.min(1.0f, Math.min(f3, f5));
            this.k.postScale(min, min);
            this.k.postTranslate((b2 - (f2 * min)) / 2.0f, (a2 - (f4 * min)) / 2.0f);
        } else {
            RectF rectF = new RectF(0.0f, 0.0f, f2, f4);
            RectF rectF2 = new RectF(0.0f, 0.0f, b2, a2);
            if (((int) this.A) % 180 != 0) {
                rectF = new RectF(0.0f, 0.0f, f4, f2);
            }
            int i = d.f9430a[this.C.ordinal()];
            if (i == 1) {
                this.k.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
            } else if (i == 2) {
                this.k.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.START);
            } else if (i == 3) {
                this.k.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.END);
            } else if (i == 4) {
                this.k.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.FILL);
            }
        }
        o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(ImageView imageView) {
        return (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
    }
}
