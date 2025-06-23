package com.baidu.navisdk.pronavi.ui.newnavi.bottom;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.model.datastruct.m;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.jar.JarUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import oOIx.oxoX;

/* loaded from: classes7.dex */
public final class RGNewRoadArcView extends View {

    /* renamed from: a, reason: collision with root package name */
    private float f7921a;
    private float b;
    private float c;
    private float d;
    private float e;
    private double f;
    private float g;
    private float h;
    private float i;
    private int j;
    private final List<m> k;
    private int l;
    private Paint m;
    private Paint n;
    private final Paint[] o;
    private Paint p;
    private Bitmap q;
    private final RectF r;
    private int s;
    private int t;
    private int u;

    /* loaded from: classes7.dex */
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
    public RGNewRoadArcView(@OOXIXo Context context) {
        this(context, null);
        IIX0o.x0xO0oo(context, "context");
    }

    private final RectF a(float f, int i) {
        float f2 = this.c;
        float f3 = i;
        return new RectF(f2 - (f - f3), this.i, (f3 + f) - f2, f);
    }

    private final void b(Canvas canvas, RectF rectF) {
        Paint paint = new Paint();
        paint.setColor(Color.parseColor("#FF1FCEAA"));
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(this.c);
        canvas.drawArc(rectF, this.f7921a, this.b, false, paint);
    }

    private final float c(float f) {
        return (this.b * f) / this.e;
    }

    private final void d(Canvas canvas, RectF rectF) {
        float cutCarPointRightPosition = getCutCarPointRightPosition();
        int size = this.k.size();
        float f = 0.0f;
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            m mVar = this.k.get(i2);
            int i3 = mVar.c;
            int i4 = this.j;
            if (i3 <= i4) {
                i = i3;
            } else {
                float a2 = a(mVar.c - Math.max(i4, i), this.e - cutCarPointRightPosition);
                float max = Math.max(cutCarPointRightPosition, f);
                float f2 = max + a2;
                if (this.k.size() != 1) {
                    float d = d(max);
                    float c = c(a2);
                    Paint paint = this.o[mVar.b];
                    IIX0o.ooOOo0oXI(paint);
                    canvas.drawArc(rectF, d, c, false, paint);
                } else {
                    float d2 = d(max);
                    float f3 = this.b;
                    Paint paint2 = this.o[mVar.b];
                    IIX0o.ooOOo0oXI(paint2);
                    canvas.drawArc(rectF, d2, f3, false, paint2);
                }
                i = mVar.c;
                f = f2;
            }
        }
    }

    private final void e() {
        Paint paint = this.n;
        if (paint != null) {
            paint.setAntiAlias(true);
        }
        Paint paint2 = this.m;
        if (paint2 != null) {
            paint2.setStrokeJoin(Paint.Join.ROUND);
            paint2.setStrokeCap(Paint.Cap.ROUND);
            paint2.setStyle(Paint.Style.STROKE);
            paint2.setAntiAlias(true);
            paint2.setStrokeWidth(this.c);
            paint2.setColor(m.a(0));
        }
        Paint paint3 = this.p;
        if (paint3 != null) {
            paint3.setStrokeJoin(Paint.Join.BEVEL);
            paint3.setStrokeCap(Paint.Cap.SQUARE);
            paint3.setStyle(Paint.Style.STROKE);
            paint3.setAntiAlias(true);
            paint3.setStrokeWidth(this.c);
            paint3.setColor(com.baidu.navisdk.ui.util.b.b(R.color.bnav_arc_road_condition_pass_bg));
        }
        int length = this.o.length;
        for (int i = 0; i < length; i++) {
            Paint paint4 = this.o[i];
            if (paint4 != null) {
                paint4.setStrokeJoin(Paint.Join.BEVEL);
                paint4.setStrokeCap(Paint.Cap.SQUARE);
                paint4.setStyle(Paint.Style.STROKE);
                paint4.setAntiAlias(true);
                paint4.setStrokeWidth(this.c);
                paint4.setColor(m.a(i));
            }
        }
    }

    private final float getCutCarPointLeftPosition() {
        float f = this.e;
        float f2 = (float) (f * this.f);
        if (f2 < 0) {
            return 0.0f;
        }
        if (f2 > f) {
            return f;
        }
        return f2;
    }

    private final float getCutCarPointRightPosition() {
        float f = this.e;
        float f2 = (float) (f * this.f);
        if (f2 < 0) {
            return 0.0f;
        }
        if (f2 > f) {
            return f;
        }
        return f2;
    }

    private final float getCutCarPointXPosition() {
        int i = this.t;
        float f = (float) (i * this.f);
        float f2 = i;
        if (f < 0) {
            return 0.0f;
        }
        if (f > f2) {
            return f2;
        }
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNJModelRoadConditionView", "getCutCarPointXPosition: x 111 = " + f);
        }
        return f;
    }

    public static /* synthetic */ void getType$annotations() {
    }

    public final int getCarCurrentAddDist() {
        return this.j;
    }

    public final int getType() {
        return this.u;
    }

    public final int getViewHeight() {
        return this.s;
    }

    @Override // android.view.View
    public void onDraw(@OOXIXo Canvas canvas) {
        IIX0o.x0xO0oo(canvas, "canvas");
        super.onDraw(canvas);
        int i = this.t;
        if (i > 0 && this.s > 0) {
            RectF a2 = a(this.d, i / 2);
            b(canvas, a2);
            if (c()) {
                d(canvas, a2);
            } else {
                a(canvas, a2);
            }
            g gVar = g.COMMON_UI;
            if (gVar.d()) {
                gVar.e("BNJModelRoadConditionView", "onDraw-> mCurCarProgress=" + this.f + ", mType:" + this.u + ",height: " + this.s);
            }
            c(canvas, a2);
            a(canvas);
            return;
        }
        g gVar2 = g.COMMON;
        if (gVar2.d()) {
            gVar2.e("BNJModelRoadConditionView", "onDraw-> width= " + this.t + ", height= " + this.s);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        long measuredHeight = getMeasuredHeight();
        this.t = getMeasuredWidth();
        this.s = (int) measuredHeight;
        float f = 2;
        float sin = (float) ((r1 / 2) / Math.sin(Math.toRadians(this.b / f)));
        this.d = sin;
        this.e = sin * this.b;
        Math.tan(Math.toRadians(r0 / f));
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNJModelRoadConditionView", "onMeasure: startAngle = " + this.f7921a + ", angleLength = " + this.b + ", arcLength = " + this.e + ", arcRadius = " + this.d + ", arcLength = " + this.e);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @SuppressLint({"Recycle", "CustomViewStyleable"})
    public RGNewRoadArcView(@OOXIXo Context context, @oOoXoXO AttributeSet attributeSet) {
        super(context, attributeSet);
        IIX0o.x0xO0oo(context, "context");
        this.f7921a = 260.0f;
        this.b = 20.0f;
        this.c = 15.0f;
        this.d = 4060.0f;
        this.e = 81200.0f;
        this.g = 60.0f;
        this.h = 15.0f;
        this.k = new ArrayList();
        this.o = new Paint[5];
        this.r = new RectF();
        a(context);
        b();
        e();
        setBackground(null);
    }

    private final void c(Canvas canvas, RectF rectF) {
        float cutCarPointLeftPosition = getCutCarPointLeftPosition();
        float f = this.f7921a;
        float c = c(cutCarPointLeftPosition);
        Paint paint = this.p;
        IIX0o.ooOOo0oXI(paint);
        canvas.drawArc(rectF, f, c, false, paint);
    }

    private final void a() {
        if (this.k.isEmpty()) {
            return;
        }
        int i = this.k.get(r0.size() - 1).c;
        this.l = i;
        int Ox0O2 = (int) oxoX.Ox0O(i * this.f);
        this.j = Ox0O2;
        this.l -= Ox0O2;
    }

    private final boolean c() {
        return this.k.size() > 0;
    }

    private final void a(Canvas canvas, RectF rectF) {
        float f = this.f7921a;
        float f2 = this.b;
        Paint paint = this.m;
        IIX0o.ooOOo0oXI(paint);
        canvas.drawArc(rectF, f, f2, false, paint);
    }

    private final float a(float f, float f2, float f3, float f4) {
        float a2 = a((float) Math.abs(f + (f4 * Math.cos((f3 * 3.141592653589793d) / 180))));
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNJModelRoadConditionView", "getCutPointX: x1 = " + a2);
        }
        return a2;
    }

    private final float b(float f, float f2, float f3, float f4) {
        float b = b((float) (f2 + (f4 * Math.sin((f3 * 3.141592653589793d) / 180))));
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNJModelRoadConditionView", "getCutPointY: y1 2222 = " + b);
        }
        return b;
    }

    private final float a(float f) {
        float f2 = this.g;
        float f3 = f2 / 2;
        float f4 = (this.t - f2) + this.h;
        if (f < f3) {
            return 0.0f;
        }
        return f > f4 ? f4 : f - f3;
    }

    private final float b(float f) {
        return Math.max(Math.min(f, this.i - this.c), 0.0f);
    }

    private final void b() {
        this.n = new Paint();
        this.m = new Paint();
        this.p = new Paint();
        int length = this.o.length;
        for (int i = 0; i < length; i++) {
            this.o[i] = new Paint();
        }
    }

    private final void a(Canvas canvas) {
        float d = d(getCutCarPointLeftPosition());
        try {
            float width = getWidth() >> 1;
            float f = this.d;
            float a2 = a(width, f, d, f);
            float width2 = getWidth() >> 1;
            float f2 = this.d;
            float b = b(width2, f2, d, f2);
            RectF rectF = this.r;
            float f3 = a2 - this.h;
            rectF.left = f3;
            rectF.top = b;
            float f4 = this.g;
            rectF.right = f3 + f4;
            rectF.bottom = b + f4;
            Bitmap bitmap = this.q;
            if (bitmap != null) {
                canvas.drawBitmap(bitmap, (Rect) null, rectF, this.m);
            }
        } catch (Exception e) {
            if (LogUtil.LOGGABLE) {
                LogUtil.printException("BNJModelRoadConditionView_onDraw", e);
            }
        }
    }

    private final float d(float f) {
        return this.f7921a + ((this.b * f) / this.e);
    }

    private final void d() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BNJModelRoadConditionView", "resetRoadConditionData-> ");
        }
        this.k.clear();
    }

    private final void a(Context context) {
        this.q = BitmapFactory.decodeResource(getResources(), R.drawable.nsdk_drawable_bottom_carpoint);
        this.c = JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_new_road_condition_arc_width);
        this.g = JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_new_car_point_length);
        this.h = JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_new_car_point_margin);
        this.i = this.g / 2;
    }

    private final float a(int i, float f) {
        int i2 = this.l;
        if (i2 <= 0) {
            return 0.0f;
        }
        return (f * i) / i2;
    }

    public final void a(double d) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BNJModelRoadConditionView", "updateCarProgress-> carProgress=" + d + ",mType: " + this.u);
        }
        this.f = d;
        a();
    }

    public final void a(boolean z) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNJModelRoadConditionView", "updateDayType: dayStyle = " + z);
        }
        e();
    }

    public final void a(int i) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNJModelRoadConditionView", "updateType: " + this.u + ", newType:" + i);
        }
        this.u = i;
        a();
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
            this.k.clear();
            this.k.addAll(list);
            a();
        } else {
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("BNJModelRoadConditionView", "updateRoadConditionData-> null == data || data.size() == 0");
            }
            d();
        }
    }
}
