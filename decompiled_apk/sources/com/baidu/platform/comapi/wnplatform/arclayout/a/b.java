package com.baidu.platform.comapi.wnplatform.arclayout.a;

import android.graphics.Paint;
import android.graphics.Path;
import androidx.core.view.ViewCompat;

/* loaded from: classes8.dex */
public class b implements com.baidu.platform.comapi.wnplatform.arclayout.a.a {

    /* renamed from: a, reason: collision with root package name */
    protected final Path f9891a = new Path();
    private final Paint b;
    private a c;

    /* loaded from: classes8.dex */
    public interface a {
        Path a(int i, int i2);

        boolean a();
    }

    public b() {
        Paint paint = new Paint(1);
        this.b = paint;
        this.c = null;
        paint.setColor(ViewCompat.MEASURED_STATE_MASK);
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(1.0f);
    }

    public void a(a aVar) {
        this.c = aVar;
    }

    @Override // com.baidu.platform.comapi.wnplatform.arclayout.a.a
    public Paint b() {
        return this.b;
    }

    @Override // com.baidu.platform.comapi.wnplatform.arclayout.a.a
    public boolean c() {
        a aVar = this.c;
        return aVar != null && aVar.a();
    }

    @Override // com.baidu.platform.comapi.wnplatform.arclayout.a.a
    public Path a(int i, int i2) {
        return this.f9891a;
    }

    @Override // com.baidu.platform.comapi.wnplatform.arclayout.a.a
    public void b(int i, int i2) {
        this.f9891a.reset();
        Path c = c(i, i2);
        if (c != null) {
            this.f9891a.set(c);
        }
    }

    public Path c(int i, int i2) {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.a(i, i2);
        }
        return null;
    }

    @Override // com.baidu.platform.comapi.wnplatform.arclayout.a.a
    public Path a() {
        return this.f9891a;
    }
}
