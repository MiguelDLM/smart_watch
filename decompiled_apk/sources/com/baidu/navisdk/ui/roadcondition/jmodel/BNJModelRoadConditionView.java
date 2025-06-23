package com.baidu.navisdk.ui.roadcondition.jmodel;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.k;
import com.baidu.navisdk.model.datastruct.m;
import com.baidu.navisdk.ui.util.b;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.g;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import oOIx.oxoX;

/* loaded from: classes8.dex */
public final class BNJModelRoadConditionView extends View {

    /* renamed from: a, reason: collision with root package name */
    private float f8412a;
    private float b;
    private float c;
    private float d;
    private double e;
    private int f;
    private final List<m> g;
    private int h;
    private Paint i;
    private final Paint[] j;
    private Paint k;
    private Bitmap l;
    private Canvas m;
    private int n;
    private int o;
    private int p;
    private int q;
    private Drawable r;
    private Bitmap s;
    private final Rect t;
    private final RectF u;
    private final RectF v;
    private final Xfermode w;
    private int x;

    /* loaded from: classes8.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(IIXOooo iIXOooo) {
            this();
        }
    }

    static {
        new a(null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BNJModelRoadConditionView(@OOXIXo Context context) {
        this(context, null);
        IIX0o.x0xO0oo(context, "context");
    }

    private final void a(Context context) {
        context.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_3dp);
        Rect rect = this.t;
        rect.left = 0;
        rect.right = this.q;
        float f = this.f8412a;
        rect.top = (int) f;
        rect.bottom = (int) (this.c + f);
    }

    private final void b(Canvas canvas) {
        try {
            RectF rectF = this.u;
            rectF.left = 0.0f;
            rectF.top = this.f8412a;
            rectF.right = this.q;
            rectF.bottom = this.b;
            Paint paint = this.i;
            IIX0o.ooOOo0oXI(paint);
            canvas.drawRoundRect(rectF, 14.0f, 14.0f, paint);
            Paint paint2 = this.i;
            IIX0o.ooOOo0oXI(paint2);
            paint2.setXfermode(this.w);
            Bitmap bitmap = this.l;
            IIX0o.ooOOo0oXI(bitmap);
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, this.i);
            Paint paint3 = this.i;
            IIX0o.ooOOo0oXI(paint3);
            paint3.setXfermode(null);
            canvas.saveLayer(0.0f, 0.0f, this.q, this.p, this.i);
        } catch (Exception e) {
            if (LogUtil.LOGGABLE) {
                LogUtil.printException("BNJModelRoadConditionView_onDraw", e);
            }
        }
    }

    private final void c(Canvas canvas) {
        float cutCarPointLeftPosition = getCutCarPointLeftPosition();
        try {
            RectF rectF = this.v;
            rectF.left = cutCarPointLeftPosition;
            rectF.top = 0.0f;
            rectF.right = cutCarPointLeftPosition + this.d;
            rectF.bottom = this.p;
            Bitmap bitmap = this.s;
            if (bitmap != null) {
                canvas.drawBitmap(bitmap, (Rect) null, rectF, this.i);
            }
            canvas.restore();
        } catch (Exception e) {
            if (LogUtil.LOGGABLE) {
                LogUtil.printException("BNJModelRoadConditionView_onDraw", e);
            }
        }
    }

    private final void d(Canvas canvas) {
        Drawable drawable = this.r;
        IIX0o.ooOOo0oXI(drawable);
        drawable.setBounds(this.t);
        Drawable drawable2 = this.r;
        IIX0o.ooOOo0oXI(drawable2);
        drawable2.draw(canvas);
        canvas.saveLayer(0.0f, 0.0f, this.q, this.p, this.i);
    }

    private final void e(Canvas canvas) {
        float cutCarPointLeftPosition = getCutCarPointLeftPosition();
        Canvas canvas2 = this.m;
        IIX0o.ooOOo0oXI(canvas2);
        float f = this.f8412a;
        float f2 = cutCarPointLeftPosition + (this.d / 2);
        float f3 = this.b;
        Paint paint = this.k;
        IIX0o.ooOOo0oXI(paint);
        canvas2.drawRoundRect(0.0f, f, f2, f3, 14.0f, 14.0f, paint);
    }

    private final void f(Canvas canvas) {
        getCutCarPointLeftPosition();
        float cutCarPointRightPosition = getCutCarPointRightPosition();
        int size = this.g.size();
        float f = 0.0f;
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            m mVar = this.g.get(i2);
            int i3 = mVar.c;
            int i4 = this.f;
            if (i3 <= i4) {
                i = i3;
            } else {
                float a2 = a(mVar.c - Math.max(i4, i), this.q - cutCarPointRightPosition);
                float max = Math.max(cutCarPointRightPosition, f);
                float f2 = a2 + max;
                if (this.g.size() != 1) {
                    Canvas canvas2 = this.m;
                    IIX0o.ooOOo0oXI(canvas2);
                    float f3 = this.f8412a;
                    float f4 = this.c + f3;
                    Paint paint = this.j[mVar.b];
                    IIX0o.ooOOo0oXI(paint);
                    canvas2.drawRect(max, f3, f2, f4, paint);
                } else {
                    Canvas canvas3 = this.m;
                    IIX0o.ooOOo0oXI(canvas3);
                    float f5 = this.f8412a;
                    float f6 = this.q;
                    float f7 = this.c + f5;
                    Paint paint2 = this.j[mVar.b];
                    IIX0o.ooOOo0oXI(paint2);
                    canvas3.drawRect(max, f5, f6, f7, paint2);
                }
                i = mVar.c;
                f = f2;
            }
        }
    }

    private final float getCutCarPointLeftPosition() {
        int i = this.q;
        double d = i * this.e;
        float f = (float) (d - (r3 / 2));
        float f2 = i - this.d;
        if (f < 0) {
            return 0.0f;
        }
        if (f > f2) {
            return f2;
        }
        return f;
    }

    private final float getCutCarPointRightPosition() {
        int i = this.q;
        float f = (float) ((i * this.e) + (this.d / 2));
        if (f < 0) {
            return 0.0f;
        }
        float f2 = i;
        if (f > f2) {
            return f2;
        }
        return f;
    }

    public static /* synthetic */ void getType$annotations() {
    }

    public final int getCarCurrentAddDist() {
        return this.f;
    }

    public final int getType() {
        return this.x;
    }

    public final int getViewHeight() {
        return this.p;
    }

    @Override // android.view.View
    public void onDraw(@OOXIXo Canvas canvas) {
        int i;
        IIX0o.x0xO0oo(canvas, "canvas");
        super.onDraw(canvas);
        int i2 = this.q;
        if (i2 > 0 && (i = this.p) > 0) {
            Bitmap bitmap = this.l;
            if (bitmap == null || this.m == null || i2 != this.n || i != this.o) {
                if (k.f6861a && bitmap != null) {
                    IIX0o.ooOOo0oXI(bitmap);
                    if (!bitmap.isRecycled()) {
                        Bitmap bitmap2 = this.l;
                        IIX0o.ooOOo0oXI(bitmap2);
                        bitmap2.recycle();
                    }
                }
                this.l = null;
                int i3 = this.q;
                this.n = i3;
                int i4 = this.p;
                this.o = i4;
                Bitmap createBitmap = Bitmap.createBitmap(i3, i4, Bitmap.Config.ARGB_8888);
                this.l = createBitmap;
                IIX0o.ooOOo0oXI(createBitmap);
                createBitmap.eraseColor(0);
                Bitmap bitmap3 = this.l;
                IIX0o.ooOOo0oXI(bitmap3);
                this.m = new Canvas(bitmap3);
            }
            if (this.l != null && this.m != null) {
                Rect rect = this.t;
                rect.left = 0;
                rect.top = (int) this.f8412a;
                rect.right = this.q;
                rect.bottom = (int) this.b;
                d(canvas);
                if (f()) {
                    f(canvas);
                } else {
                    a(canvas);
                }
                g gVar = g.COMMON_UI;
                if (gVar.d()) {
                    gVar.e("BNJModelRoadConditionView", "onDraw-> mCurCarProgress=" + this.e + ", mType:" + this.x + ",height: " + this.p);
                }
                e(canvas);
                b(canvas);
                c(canvas);
                return;
            }
            g gVar2 = g.PRO_NAV;
            if (gVar2.d()) {
                gVar2.e("BNJModelRoadConditionView", "onDraw-> mCacheBitmap= " + this.l + ", mCacheCanvas= " + this.m);
                return;
            }
            return;
        }
        g gVar3 = g.COMMON;
        if (gVar3.d()) {
            gVar3.e("BNJModelRoadConditionView", "onDraw-> width= " + this.q + ", height= " + this.p);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        long measuredHeight = getMeasuredHeight();
        long measuredWidth = getMeasuredWidth();
        long j = measuredHeight * measuredWidth * 16;
        long j2 = 10000;
        if (measuredHeight <= j2 && measuredWidth <= j2 && j <= Integer.MAX_VALUE) {
            this.q = (int) measuredWidth;
            this.p = (int) measuredHeight;
            this.b = this.c + this.f8412a;
            return;
        }
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNJModelRoadConditionView", "---> BNRoadConditionView: cacheBitmapSize is " + j + ", cacheBitmapSize exceeds 32 bits ");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @SuppressLint({"Recycle", "CustomViewStyleable"})
    public BNJModelRoadConditionView(@OOXIXo Context context, @oOoXoXO AttributeSet attributeSet) {
        super(context, attributeSet);
        int resourceId;
        IIX0o.x0xO0oo(context, "context");
        this.f8412a = 10.0f;
        this.b = 10.0f;
        this.c = 20.0f;
        this.d = 68.0f;
        this.g = new ArrayList();
        this.j = new Paint[5];
        this.t = new Rect();
        this.u = new RectF();
        this.v = new RectF();
        this.w = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BNHorizontalRoadConditionLayout);
        IIX0o.oO(obtainStyledAttributes, "context.obtainStyledAttr…ontalRoadConditionLayout)");
        int i = R.styleable.BNHorizontalRoadConditionLayout_nsdk_bn_horizontal_car_src;
        if (obtainStyledAttributes.hasValue(i) && (resourceId = obtainStyledAttributes.getResourceId(i, -1)) > 0) {
            this.s = b.a(resourceId);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.BNHorizontalRoadConditionLayout_nsdk_bn_horizontal_bg_height)) {
            this.c = obtainStyledAttributes.getDimensionPixelOffset(r0, 20);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.BNHorizontalRoadConditionLayout_nsdk_bn_horizontal_bg_margin_top)) {
            this.f8412a = obtainStyledAttributes.getDimensionPixelOffset(r0, 10);
        }
        int i2 = R.styleable.BNHorizontalRoadConditionLayout_nsdk_bn_horizontal_car_height;
        if (obtainStyledAttributes.hasValue(i2)) {
            obtainStyledAttributes.getDimensionPixelOffset(i2, 40);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.BNHorizontalRoadConditionLayout_nsdk_bn_horizontal_car_width)) {
            this.d = obtainStyledAttributes.getDimensionPixelOffset(r0, 68);
        }
        obtainStyledAttributes.recycle();
        e();
        a(context);
        this.r = getBackground();
        setBackgroundDrawable(null);
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            StringBuilder sb = new StringBuilder();
            sb.append("graphics.Bitmap 初始化 -> viewHash= ");
            sb.append(hashCode());
            sb.append(",BitmapHash = ");
            Bitmap bitmap = this.s;
            sb.append(bitmap != null ? bitmap.hashCode() : 0);
            gVar.e("BNJModelRoadConditionView", sb.toString());
        }
    }

    private final void a(Canvas canvas) {
        Canvas canvas2 = this.m;
        IIX0o.ooOOo0oXI(canvas2);
        float f = this.f8412a;
        float f2 = this.q;
        float f3 = this.b;
        Paint paint = this.j[0];
        IIX0o.ooOOo0oXI(paint);
        canvas2.drawRect(0.0f, f, f2, f3, paint);
    }

    private final void d() {
        if (this.g.isEmpty()) {
            return;
        }
        int i = this.g.get(r0.size() - 1).c;
        this.h = i;
        int Ox0O2 = (int) oxoX.Ox0O(i * this.e);
        this.f = Ox0O2;
        this.h -= Ox0O2;
    }

    private final void e() {
        Paint paint = new Paint();
        this.i = paint;
        IIX0o.ooOOo0oXI(paint);
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.k = paint2;
        IIX0o.ooOOo0oXI(paint2);
        paint2.setColor(Color.parseColor("#FFCFCFCF"));
        this.j[0] = new Paint();
        Paint paint3 = this.j[0];
        IIX0o.ooOOo0oXI(paint3);
        paint3.setColor(m.a(0));
        this.j[1] = new Paint();
        Paint paint4 = this.j[1];
        IIX0o.ooOOo0oXI(paint4);
        paint4.setColor(m.a(1));
        this.j[2] = new Paint();
        Paint paint5 = this.j[2];
        IIX0o.ooOOo0oXI(paint5);
        paint5.setColor(m.a(2));
        this.j[3] = new Paint();
        Paint paint6 = this.j[3];
        IIX0o.ooOOo0oXI(paint6);
        paint6.setColor(m.a(3));
        this.j[4] = new Paint();
        Paint paint7 = this.j[4];
        IIX0o.ooOOo0oXI(paint7);
        paint7.setColor(m.a(4));
    }

    public final void c() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BNJModelRoadConditionView", "resetRoadConditionData-> ");
        }
        this.g.clear();
    }

    private final float a(int i, float f) {
        int i2 = this.h;
        if (i2 <= 0) {
            return 0.0f;
        }
        return (f * i) / i2;
    }

    public final void a(double d) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BNJModelRoadConditionView", "updateCarProgress-> carProgress=" + d + ",mType: " + this.x);
        }
        this.e = d;
        d();
    }

    public final void a(int i) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNJModelRoadConditionView", "updateType: " + this.x + ", newType:" + i);
        }
        this.x = i;
        d();
    }

    public final void b() {
        Bitmap bitmap = this.l;
        if (bitmap != null) {
            if (k.f6861a && Build.VERSION.SDK_INT < 28) {
                IIX0o.ooOOo0oXI(bitmap);
                bitmap.recycle();
            }
            this.l = null;
        }
        if (this.r != null) {
            this.r = null;
        }
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            StringBuilder sb = new StringBuilder();
            sb.append("graphics.Bitmap recycle -> viewHash= ");
            sb.append(hashCode());
            sb.append(",BitmapHash = ");
            Bitmap bitmap2 = this.s;
            sb.append(bitmap2 == null ? "null" : Integer.valueOf(bitmap2.hashCode()));
            gVar.e("BNJModelRoadConditionView", sb.toString());
        }
        Bitmap bitmap3 = this.s;
        if (bitmap3 != null) {
            if (k.f6861a && Build.VERSION.SDK_INT < 28) {
                IIX0o.ooOOo0oXI(bitmap3);
                bitmap3.recycle();
            }
            this.s = null;
        }
    }

    public final void a(@oOoXoXO List<? extends m> list) {
        if (LogUtil.LOGGABLE) {
            StringBuilder sb = new StringBuilder("updateRoadConditionData-> data= ");
            if (list != null) {
                for (m mVar : list) {
                    sb.append("\n\t----");
                    sb.append(mVar.toString());
                }
                LogUtil.e("BNJModelRoadConditionView", sb.toString());
            }
        }
        if (list != null && !list.isEmpty()) {
            this.g.clear();
            this.g.addAll(list);
            d();
        } else {
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("BNJModelRoadConditionView", "updateRoadConditionData-> null == data || data.size() == 0");
            }
        }
    }

    private final boolean f() {
        return this.g.size() > 0;
    }

    public final void a() {
        b();
        this.g.clear();
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BNJModelRoadConditionView", "dispose: clear RoadConditionData-> ");
        }
        if (getParent() != null) {
            ViewParent parent = getParent();
            if (parent == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
            }
            ((ViewGroup) parent).removeView(this);
        }
    }
}
