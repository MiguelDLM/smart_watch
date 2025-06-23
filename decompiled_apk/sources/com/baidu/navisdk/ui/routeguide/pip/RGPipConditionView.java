package com.baidu.navisdk.ui.routeguide.pip;

import XIXIX.OOXIXo;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.model.datastruct.m;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.common.g;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes8.dex */
public class RGPipConditionView extends View {

    /* renamed from: a, reason: collision with root package name */
    private int f9079a;
    private int b;
    private final float c;
    private final float d;
    private final RectF e;
    private double f;
    private int g;
    private int h;
    private List<m> i;
    private Paint j;
    private Paint[] k;
    private Paint l;
    private Bitmap m;

    public RGPipConditionView(Context context) {
        this(context, null);
    }

    private void b() {
        Paint paint = new Paint();
        this.j = paint;
        paint.setAntiAlias(true);
        this.j.setStrokeWidth(this.d);
        Paint paint2 = new Paint();
        this.l = paint2;
        paint2.setColor(-3158065);
        this.l.setStrokeWidth(this.d);
        this.k[0] = new Paint();
        this.k[0].setColor(m.b(0));
        this.k[0].setStrokeWidth(this.d);
        this.k[1] = new Paint();
        this.k[1].setColor(m.b(1));
        this.k[1].setStrokeWidth(this.d);
        this.k[2] = new Paint();
        this.k[2].setColor(m.b(2));
        this.k[2].setStrokeWidth(this.d);
        this.k[3] = new Paint();
        this.k[3].setColor(m.b(3));
        this.k[3].setStrokeWidth(this.d);
        this.k[4] = new Paint();
        this.k[4].setColor(m.b(4));
        this.k[4].setStrokeWidth(this.d);
    }

    private boolean c() {
        List<m> list = this.i;
        if (list != null && list.size() > 0) {
            return true;
        }
        return false;
    }

    public void a(double d) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGPipConditionView", "updateCarProgress-> carProgress=" + d);
        }
        this.f = d;
        a();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f = this.b;
        float f2 = this.c;
        float f3 = f - f2;
        float f4 = (float) (f3 * this.f);
        float f5 = f4 + f2;
        if (f5 > 0.0f) {
            f2 = f5;
        }
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGPipConditionView", "drawLineStar: " + f2);
        }
        if (c() && !BNRoutePlaner.getInstance().B()) {
            int i = 0;
            for (int i2 = 0; i2 < this.i.size(); i2++) {
                m mVar = this.i.get(i2);
                int i3 = mVar.c;
                int i4 = this.h;
                if (i3 <= i4) {
                    i = i3;
                } else {
                    float a2 = a(mVar.c - Math.max(i4, i), f3);
                    float max = Math.max(f4, f2);
                    float f6 = a2 + max;
                    float f7 = this.f9079a / 2.0f;
                    canvas.drawLine(max, f7, f6, f7, this.k[mVar.b]);
                    i = mVar.c;
                    f2 = f6;
                }
            }
        } else {
            float f8 = this.f9079a / 2.0f;
            canvas.drawLine(this.c, f8, this.b, f8, this.k[0]);
        }
        float f9 = this.f9079a / 2.0f;
        canvas.drawLine(0.0f, f9, f4, f9, this.l);
        try {
            RectF rectF = this.e;
            rectF.left = f4;
            rectF.top = 0.0f;
            float f10 = this.c;
            rectF.right = f4 + f10;
            rectF.bottom = f10;
            canvas.drawBitmap(this.m, (Rect) null, rectF, this.j);
            canvas.save();
            canvas.restore();
        } catch (Exception e) {
            if (LogUtil.LOGGABLE) {
                LogUtil.printException("RGPipConditionView_onDraw", e);
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.f9079a = getMeasuredHeight();
        this.b = getMeasuredWidth();
    }

    public RGPipConditionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f9079a = 0;
        this.b = 0;
        this.c = ScreenUtil.getInstance().dip2px(14);
        this.d = ScreenUtil.getInstance().dip2px(3);
        this.e = new RectF();
        this.f = OOXIXo.f3760XO;
        this.g = 0;
        this.h = 0;
        this.i = new ArrayList();
        this.j = null;
        this.k = new Paint[5];
        this.l = null;
        this.m = null;
        b();
        this.m = com.baidu.navisdk.ui.util.b.a(R.drawable.bnav_pip_car_icon_condition);
        setBackgroundDrawable(null);
    }

    public void a(List<m> list) {
        if (LogUtil.LOGGABLE) {
            StringBuilder sb = new StringBuilder("updateRoadConditionData-> data= ");
            if (list != null) {
                for (m mVar : list) {
                    sb.append("\n\t----");
                    sb.append(mVar.toString());
                }
                LogUtil.e("RGPipConditionView", sb.toString());
            }
        }
        if (list != null && list.size() != 0) {
            List<m> list2 = this.i;
            if (list2 != null) {
                list2.clear();
                this.i.addAll(list);
                a();
                return;
            }
            return;
        }
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGPipConditionView", "updateRoadConditionData-> null == data || data.size() == 0");
        }
    }

    private void a() {
        List<m> list = this.i;
        if (list == null || list.isEmpty()) {
            return;
        }
        int i = this.i.get(r0.size() - 1).c;
        this.g = i;
        this.h = (int) Math.round(i * this.f);
    }

    private float a(int i, float f) {
        int i2 = this.g;
        if (i2 <= 0) {
            return 0.0f;
        }
        return (f * i) / i2;
    }
}
