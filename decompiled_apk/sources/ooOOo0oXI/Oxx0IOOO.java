package ooOOo0oXI;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import x0XOIxOo.oIX0oI;

/* loaded from: classes.dex */
public class Oxx0IOOO implements X0o0xo, oIX0oI.II0xO0, OOXIXo {

    /* renamed from: I0Io, reason: collision with root package name */
    public final com.airbnb.lottie.model.layer.oIX0oI f32337I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public final x0XOIxOo.oIX0oI<Integer, Integer> f32338II0XooXoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    public final Paint f32339II0xO0;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public final x0XOIxOo.oIX0oI<Integer, Integer> f32340Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public final boolean f32341X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public final List<x0XOIxOo> f32342XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final Path f32343oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public final String f32344oxoX;

    /* renamed from: xoIox, reason: collision with root package name */
    public final com.airbnb.lottie.xoIox f32345xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    @Nullable
    public x0XOIxOo.oIX0oI<ColorFilter, ColorFilter> f32346xxIXOIIO;

    public Oxx0IOOO(com.airbnb.lottie.xoIox xoiox, com.airbnb.lottie.model.layer.oIX0oI oix0oi, IXxxXO.II0XooXoX iI0XooXoX) {
        Path path = new Path();
        this.f32343oIX0oI = path;
        this.f32339II0xO0 = new oOoXoXO.oIX0oI(1);
        this.f32342XO = new ArrayList();
        this.f32337I0Io = oix0oi;
        this.f32344oxoX = iI0XooXoX.oxoX();
        this.f32341X0o0xo = iI0XooXoX.XO();
        this.f32345xoIox = xoiox;
        if (iI0XooXoX.II0xO0() != null && iI0XooXoX.X0o0xo() != null) {
            path.setFillType(iI0XooXoX.I0Io());
            x0XOIxOo.oIX0oI<Integer, Integer> oIX0oI2 = iI0XooXoX.II0xO0().oIX0oI();
            this.f32340Oxx0IOOO = oIX0oI2;
            oIX0oI2.oIX0oI(this);
            oix0oi.xxIXOIIO(oIX0oI2);
            x0XOIxOo.oIX0oI<Integer, Integer> oIX0oI3 = iI0XooXoX.X0o0xo().oIX0oI();
            this.f32338II0XooXoX = oIX0oI3;
            oIX0oI3.oIX0oI(this);
            oix0oi.xxIXOIIO(oIX0oI3);
            return;
        }
        this.f32340Oxx0IOOO = null;
        this.f32338II0XooXoX = null;
    }

    @Override // ooOOo0oXI.X0o0xo
    public void I0Io(Canvas canvas, Matrix matrix, int i) {
        if (this.f32341X0o0xo) {
            return;
        }
        com.airbnb.lottie.X0o0xo.oIX0oI("FillContent#draw");
        this.f32339II0xO0.setColor(((x0XOIxOo.II0xO0) this.f32340Oxx0IOOO).x0xO0oo());
        this.f32339II0xO0.setAlpha(IIXOooo.xxIXOIIO.oxoX((int) ((((i / 255.0f) * this.f32338II0XooXoX.II0XooXoX().intValue()) / 100.0f) * 255.0f), 0, 255));
        x0XOIxOo.oIX0oI<ColorFilter, ColorFilter> oix0oi = this.f32346xxIXOIIO;
        if (oix0oi != null) {
            this.f32339II0xO0.setColorFilter(oix0oi.II0XooXoX());
        }
        this.f32343oIX0oI.reset();
        for (int i2 = 0; i2 < this.f32342XO.size(); i2++) {
            this.f32343oIX0oI.addPath(this.f32342XO.get(i2).getPath(), matrix);
        }
        canvas.drawPath(this.f32343oIX0oI, this.f32339II0xO0);
        com.airbnb.lottie.X0o0xo.II0xO0("FillContent#draw");
    }

    @Override // x0xO0oo.X0o0xo
    public void Oxx0IOOO(x0xO0oo.oxoX oxox, int i, List<x0xO0oo.oxoX> list, x0xO0oo.oxoX oxox2) {
        IIXOooo.xxIXOIIO.ooOOo0oXI(oxox, i, list, oxox2, this);
    }

    @Override // ooOOo0oXI.I0Io
    public void X0o0xo(List<I0Io> list, List<I0Io> list2) {
        for (int i = 0; i < list2.size(); i++) {
            I0Io i0Io = list2.get(i);
            if (i0Io instanceof x0XOIxOo) {
                this.f32342XO.add((x0XOIxOo) i0Io);
            }
        }
    }

    @Override // x0xO0oo.X0o0xo
    public <T> void XO(T t, @Nullable xoXoI.xoIox<T> xoiox) {
        if (t == com.airbnb.lottie.oO.f4979oIX0oI) {
            this.f32340Oxx0IOOO.x0XOIxOo(xoiox);
            return;
        }
        if (t == com.airbnb.lottie.oO.f4983oxoX) {
            this.f32338II0XooXoX.x0XOIxOo(xoiox);
            return;
        }
        if (t == com.airbnb.lottie.oO.f4976XxX0x0xxx) {
            x0XOIxOo.oIX0oI<ColorFilter, ColorFilter> oix0oi = this.f32346xxIXOIIO;
            if (oix0oi != null) {
                this.f32337I0Io.XIxXXX0x0(oix0oi);
            }
            if (xoiox == null) {
                this.f32346xxIXOIIO = null;
                return;
            }
            x0XOIxOo.x0xO0oo x0xo0oo = new x0XOIxOo.x0xO0oo(xoiox);
            this.f32346xxIXOIIO = x0xo0oo;
            x0xo0oo.oIX0oI(this);
            this.f32337I0Io.xxIXOIIO(this.f32346xxIXOIIO);
        }
    }

    @Override // ooOOo0oXI.I0Io
    public String getName() {
        return this.f32344oxoX;
    }

    @Override // ooOOo0oXI.X0o0xo
    public void oIX0oI(RectF rectF, Matrix matrix, boolean z) {
        this.f32343oIX0oI.reset();
        for (int i = 0; i < this.f32342XO.size(); i++) {
            this.f32343oIX0oI.addPath(this.f32342XO.get(i).getPath(), matrix);
        }
        this.f32343oIX0oI.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // x0XOIxOo.oIX0oI.II0xO0
    public void oxoX() {
        this.f32345xoIox.invalidateSelf();
    }
}
