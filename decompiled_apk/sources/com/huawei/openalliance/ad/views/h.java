package com.huawei.openalliance.ad.views;

import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* loaded from: classes10.dex */
public class h extends g {
    private float D;
    private float L;

    /* renamed from: a, reason: collision with root package name */
    private Path f17439a;
    private RectF b;
    private RectF c;
    private Rect d;
    private float e;

    public h(Drawable drawable, int i, int i2) {
        super(drawable, i, i2);
        this.f17439a = new Path();
        this.b = new RectF();
        this.c = new RectF();
        I();
    }

    private void B(float f) {
        this.f17439a.reset();
        this.f17439a.addArc(this.b, 90.0f, 180.0f);
        float f2 = this.d.right - this.e;
        if (Float.compare(Code(), V()) != 0) {
            Path path = this.f17439a;
            Rect rect = this.d;
            path.addRect(this.e + rect.left, rect.top, f2, rect.bottom, Path.Direction.CCW);
        }
        float V = Float.compare(Code(), 0.0f) != 0 ? ((f - V()) / Code()) * this.e : 0.0f;
        Rect rect2 = this.d;
        this.c.set(f2 - V, rect2.top, f2 + V, rect2.bottom);
        this.f17439a.addArc(this.c, 270.0f, 180.0f);
    }

    private float C(float f) {
        return f / 2.0f;
    }

    private void I() {
        Rect bounds = getBounds();
        this.d = bounds;
        Code(bounds.left, bounds.top, r1 + bounds.height(), this.d.bottom);
        this.e = C(this.d.height());
    }

    private void Z(float f) {
        this.f17439a.reset();
        this.f17439a.addArc(this.b, 90.0f, 180.0f);
        Rect rect = this.d;
        float f2 = rect.left + this.e;
        float width = rect.width() * f;
        Rect rect2 = this.d;
        this.f17439a.addRect(f2, rect2.top, width + rect2.left, rect2.bottom, Path.Direction.CCW);
    }

    public float Code() {
        return this.D;
    }

    public float V() {
        return this.L;
    }

    @Override // com.huawei.openalliance.ad.views.g, android.graphics.drawable.Drawable
    public void setBounds(int i, int i2, int i3, int i4) {
        super.setBounds(i, i2, i3, i4);
        Code(i, i2, i3, i4);
        int i5 = i3 - i;
        if (i5 != 0) {
            Code(this.e / i5);
            V(1.0f - Code());
        }
    }

    private void Code(float f) {
        this.D = f;
    }

    private void I(float f) {
        this.f17439a.reset();
        this.f17439a.addArc(this.b, 90.0f, 180.0f);
        float Code = Float.compare(Code(), 0.0f) != 0 ? (f / Code()) * this.e : 0.0f;
        Rect rect = this.d;
        RectF rectF = this.c;
        Rect rect2 = this.d;
        rectF.set(rect2.left + Code, rect2.top, (rect.left + rect.height()) - Code, rect2.bottom);
        this.f17439a.addArc(this.c, 270.0f, -180.0f);
    }

    @Override // com.huawei.openalliance.ad.views.g
    public Path V(int i) {
        float f = i / 10000.0f;
        if (Float.compare(f, Code()) < 0) {
            I(f);
        } else if (Float.compare(f, V()) < 0) {
            Z(f);
        } else {
            B(f);
        }
        return this.f17439a;
    }

    private void V(float f) {
        this.L = f;
    }

    public void Code(float f, float f2, float f3, float f4) {
        this.b.set(f, f2, f3, f4);
    }

    public void Code(int i, int i2, int i3, int i4) {
        this.d.set(i, i2, i3, i4);
        Code(i, i2, i + r4, i4);
        this.e = C(i4 - i2);
    }
}
