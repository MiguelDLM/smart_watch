package com.baidu.navisdk.ui.roadcondition.view;

import XIXIX.OOXIXo;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.k;
import com.baidu.navisdk.model.datastruct.m;
import com.baidu.navisdk.ui.util.b;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.g;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes8.dex */
public class BNRoadConditionView extends View {

    /* renamed from: a, reason: collision with root package name */
    private float f8413a;
    private float b;
    private float c;
    private float d;
    private float e;
    private double f;
    private int g;
    private List<m> h;
    private int i;
    private Paint j;
    private Paint[] k;
    private Paint l;
    private Bitmap m;
    private Canvas n;
    private int o;
    private int p;
    private int q;
    private int r;
    private NinePatchDrawable s;
    private Bitmap t;
    private final Rect u;
    private final RectF v;
    private final RectF w;
    private final Xfermode x;
    private int y;
    private float z;

    public BNRoadConditionView(Context context) {
        super(context);
        this.f8413a = 16.0f;
        this.b = 13.34f;
        this.c = 54.6f;
        this.d = 0.0f;
        this.e = 6.0f;
        this.f = OOXIXo.f3760XO;
        this.g = 0;
        this.h = new ArrayList();
        this.i = 0;
        this.j = null;
        this.k = new Paint[5];
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = 0;
        this.p = 0;
        this.q = 0;
        this.r = 0;
        this.s = null;
        this.t = null;
        this.u = new Rect();
        this.v = new RectF();
        this.w = new RectF();
        this.x = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
        this.y = 0;
        this.z = 0.0f;
        f();
        a(context);
        this.s = (NinePatchDrawable) getBackground();
        this.t = b.a(R.drawable.nsdk_drawable_roadcondition_carpoint);
        setBackgroundDrawable(null);
    }

    private void a(Context context) {
        this.f8413a = context.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_8dp);
        this.c = context.getResources().getDimensionPixelOffset(R.dimen.bn_rg_road_condition_car_size);
        this.b = context.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_7dp);
        this.e = context.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_3dp);
        Rect rect = this.u;
        rect.left = 0;
        rect.top = 0;
    }

    private float e() {
        if (this.y == 1) {
            return this.q - this.c;
        }
        float f = this.q - this.c;
        return (float) (((f - r1) * (1.0d - this.f)) + this.b);
    }

    private void f() {
        Paint paint = new Paint();
        this.j = paint;
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.l = paint2;
        paint2.setColor(-3158065);
        this.k[0] = new Paint();
        this.k[0].setColor(m.b(0));
        this.k[1] = new Paint();
        this.k[1].setColor(m.b(1));
        this.k[2] = new Paint();
        this.k[2].setColor(m.b(2));
        this.k[3] = new Paint();
        this.k[3].setColor(m.b(3));
        this.k[4] = new Paint();
        this.k[4].setColor(m.b(4));
    }

    private boolean g() {
        List<m> list = this.h;
        if (list != null && list.size() > 0) {
            return true;
        }
        return false;
    }

    public void b() {
        c();
        this.h.clear();
        if (getParent() != null) {
            ((ViewGroup) getParent()).removeView(this);
        }
    }

    public void c(int i) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNRoadConditionView", "updateType: " + this.y + ", newType:" + i);
        }
        this.y = i;
        a();
    }

    public void d() {
        if (this.h != null) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("BNRoadConditionView", "resetRoadConditionData-> ");
            }
            this.h.clear();
        }
    }

    public int getCarCurrentAddDist() {
        return this.g;
    }

    public int getShowJamIconHeight() {
        if (this.y == 1) {
            return (int) (this.q - this.c);
        }
        float f = this.q - this.c;
        return (int) (((f - r1) * (1.0d - this.f)) + this.b);
    }

    public int getType() {
        return this.y;
    }

    public int getViewHeight() {
        return this.q;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        float f;
        float f2;
        float f3;
        float f4;
        super.onDraw(canvas);
        int i2 = this.r;
        if (i2 > 0 && (i = this.q) > 0) {
            Bitmap bitmap = this.m;
            int i3 = 0;
            if (bitmap == null || this.n == null || i2 != this.o || i != this.p) {
                if (k.f6861a && bitmap != null && !bitmap.isRecycled()) {
                    this.m.recycle();
                }
                this.m = null;
                int i4 = this.r;
                this.o = i4;
                int i5 = this.q;
                this.p = i5;
                Bitmap createBitmap = Bitmap.createBitmap(i4, i5, Bitmap.Config.ARGB_4444);
                this.m = createBitmap;
                createBitmap.eraseColor(0);
                this.n = new Canvas(this.m);
            }
            if (this.m != null && this.n != null) {
                float f5 = this.q - this.c;
                int i6 = this.r;
                float f6 = i6 - this.f8413a;
                Rect rect = this.u;
                rect.right = i6;
                rect.bottom = (int) (this.b + f5);
                this.s.setBounds(rect);
                this.s.draw(canvas);
                canvas.saveLayer(0.0f, 0.0f, this.r, this.q, this.j, 31);
                int i7 = 1;
                if (this.y == 1) {
                    f = f5;
                } else {
                    f = (float) (((f5 - r2) * (1.0d - this.f)) + this.b);
                }
                if (g()) {
                    float f7 = f5;
                    int i8 = 0;
                    while (i3 < this.h.size()) {
                        m mVar = this.h.get(i3);
                        int i9 = mVar.c;
                        int i10 = this.g;
                        if (i9 <= i10) {
                            i8 = i9;
                            f4 = f6;
                        } else {
                            float a2 = a(mVar.c - Math.max(i10, i8), f5);
                            float min = Math.min(f, f7);
                            f7 = min - a2;
                            if (this.h.size() != i7) {
                                f4 = f6;
                                this.n.drawRect(this.f8413a, f7, f4, min, this.k[mVar.b]);
                            } else {
                                f4 = f6;
                                this.n.drawRect(this.f8413a, this.b, f4, min, this.k[mVar.b]);
                            }
                            i8 = mVar.c;
                        }
                        i3++;
                        f6 = f4;
                        i7 = 1;
                    }
                    f2 = f6;
                } else {
                    f2 = f6;
                    this.n.drawRect(this.f8413a, this.b, f6, f5, this.k[0]);
                }
                g gVar = g.COMMON_UI;
                if (gVar.d()) {
                    gVar.e("BNRoadConditionView", "onDraw-> mCurCarProgress=" + this.f + ", curCarPointH=" + f + ", mType:" + this.y + ",height: " + this.q);
                }
                if (this.y == 0) {
                    this.n.drawRect(this.f8413a, f, f2, f5, this.l);
                }
                try {
                    RectF rectF = this.v;
                    float f8 = this.f8413a;
                    rectF.left = f8;
                    rectF.top = this.b;
                    rectF.right = f2;
                    rectF.bottom = f5;
                    int i11 = this.r;
                    canvas.drawRoundRect(rectF, (i11 - (f8 * 2.0f)) / 2.0f, (i11 - (f8 * 2.0f)) / 2.0f, this.j);
                    this.j.setXfermode(this.x);
                    canvas.drawBitmap(this.m, 0.0f, 0.0f, this.j);
                    this.j.setXfermode(null);
                    f3 = f;
                } catch (Exception e) {
                    e = e;
                    f3 = f;
                }
                try {
                    canvas.saveLayer(0.0f, 0.0f, this.r, this.q, this.j, 31);
                } catch (Exception e2) {
                    e = e2;
                    if (LogUtil.LOGGABLE) {
                        LogUtil.printException("BNRoadConditionView_onDraw", e);
                    }
                    RectF rectF2 = this.w;
                    float f9 = this.d;
                    rectF2.left = f9;
                    float f10 = this.e;
                    rectF2.top = f3 - f10;
                    rectF2.right = this.r - f9;
                    rectF2.bottom = (this.c + f3) - f10;
                    canvas.drawBitmap(this.t, (Rect) null, rectF2, this.j);
                    canvas.restore();
                    return;
                }
                try {
                    RectF rectF22 = this.w;
                    float f92 = this.d;
                    rectF22.left = f92;
                    float f102 = this.e;
                    rectF22.top = f3 - f102;
                    rectF22.right = this.r - f92;
                    rectF22.bottom = (this.c + f3) - f102;
                    canvas.drawBitmap(this.t, (Rect) null, rectF22, this.j);
                    canvas.restore();
                    return;
                } catch (Exception e3) {
                    if (LogUtil.LOGGABLE) {
                        LogUtil.printException("BNRoadConditionView_onDraw", e3);
                        return;
                    }
                    return;
                }
            }
            g gVar2 = g.PRO_NAV;
            if (gVar2.d()) {
                gVar2.e("BNRoadConditionView", "onDraw-> mCacheBitmap= " + this.m + ", mCacheCanvas= " + this.n);
                return;
            }
            return;
        }
        g gVar3 = g.COMMON;
        if (gVar3.d()) {
            gVar3.e("BNRoadConditionView", "onDraw-> width= " + this.r + ", height= " + this.q);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        long measuredHeight = getMeasuredHeight();
        long measuredWidth = getMeasuredWidth();
        long j = measuredHeight * measuredWidth * 16;
        if (measuredHeight <= 10000 && measuredWidth <= 10000 && j <= 2147483647L) {
            this.r = (int) measuredWidth;
            this.q = (int) measuredHeight;
            this.d = (int) ((r1 - this.c) / 2.0f);
            return;
        }
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNRoadConditionView", "---> BNRoadConditionView: cacheBitmapSize is " + j + ", cacheBitmapSize exceeds 32 bits ");
        }
    }

    public boolean b(int i) {
        return (this.z - this.e) + ((float) i) <= ((float) this.q);
    }

    public void c() {
        Bitmap bitmap = this.m;
        if (bitmap != null) {
            if (k.f6861a && Build.VERSION.SDK_INT < 28) {
                bitmap.recycle();
            }
            this.m = null;
        }
        if (this.s != null) {
            this.s = null;
        }
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            StringBuilder sb = new StringBuilder();
            sb.append("graphics.Bitmap recycle -> viewHash= ");
            sb.append(hashCode());
            sb.append(",BitmapHash = ");
            Bitmap bitmap2 = this.t;
            sb.append(bitmap2 == null ? "null" : Integer.valueOf(bitmap2.hashCode()));
            gVar.e("BNRoadConditionView", sb.toString());
        }
        Bitmap bitmap3 = this.t;
        if (bitmap3 != null) {
            if (k.f6861a && Build.VERSION.SDK_INT < 28) {
                bitmap3.recycle();
            }
            this.t = null;
        }
    }

    private float a(int i, float f) {
        int i2 = this.i;
        if (i2 <= 0) {
            return 0.0f;
        }
        return ((f - this.b) * i) / i2;
    }

    public void a(double d) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BNRoadConditionView", "updateCarProgress-> carProgress=" + d + ",mType: " + this.y);
        }
        this.f = d;
        a();
    }

    public void a(List<m> list) {
        if (LogUtil.LOGGABLE) {
            StringBuilder sb = new StringBuilder("updateRoadConditionData-> data= ");
            if (list != null) {
                for (m mVar : list) {
                    sb.append("\n\t----");
                    sb.append(mVar.toString());
                }
                LogUtil.e("BNRoadConditionView", sb.toString());
            }
        }
        if (list != null && list.size() != 0) {
            List<m> list2 = this.h;
            if (list2 != null) {
                list2.clear();
                this.h.addAll(list);
                a();
                return;
            }
            return;
        }
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNRoadConditionView", "updateRoadConditionData-> null == data || data.size() == 0");
        }
    }

    public void a() {
        List<m> list = this.h;
        if (list != null && !list.isEmpty()) {
            List<m> list2 = this.h;
            int i = list2.get(list2.size() - 1).c;
            this.i = i;
            int round = (int) Math.round(i * this.f);
            this.g = round;
            if (this.y == 1) {
                this.i -= round;
            }
        }
        this.z = e();
    }

    public int a(int i) {
        g gVar = g.COMMON_UI;
        if (gVar.d()) {
            gVar.e("BNRoadConditionView", "calcJamIconBottom showAddDist: " + i + ",mCurCarAddDist: " + this.g);
        }
        if (this.y == 1) {
            i -= this.g;
        }
        return (int) (a(i, this.q - this.c) + this.c);
    }

    public BNRoadConditionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8413a = 16.0f;
        this.b = 13.34f;
        this.c = 54.6f;
        this.d = 0.0f;
        this.e = 6.0f;
        this.f = OOXIXo.f3760XO;
        this.g = 0;
        this.h = new ArrayList();
        this.i = 0;
        this.j = null;
        this.k = new Paint[5];
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = 0;
        this.p = 0;
        this.q = 0;
        this.r = 0;
        this.s = null;
        this.t = null;
        this.u = new Rect();
        this.v = new RectF();
        this.w = new RectF();
        this.x = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
        this.y = 0;
        this.z = 0.0f;
        f();
        a(context);
        this.s = (NinePatchDrawable) getBackground();
        this.t = b.a(R.drawable.nsdk_drawable_roadcondition_carpoint);
        setBackgroundDrawable(null);
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNRoadConditionView", "graphics.Bitmap 初始化 -> viewHash= " + hashCode() + ",BitmapHash = " + this.t.hashCode());
        }
    }
}
