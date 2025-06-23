package ooOOo0oXI;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import x0XOIxOo.oIX0oI;

/* loaded from: classes.dex */
public class IXxxXO implements X0o0xo, x0XOIxOo, xoIox, oIX0oI.II0xO0, OOXIXo {

    /* renamed from: I0Io, reason: collision with root package name */
    public final com.airbnb.lottie.xoIox f32327I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public final x0XOIxOo.oIX0oI<Float, Float> f32328II0XooXoX;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public final x0XOIxOo.oIX0oI<Float, Float> f32330Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public final String f32331X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public final boolean f32332XO;

    /* renamed from: oxoX, reason: collision with root package name */
    public final com.airbnb.lottie.model.layer.oIX0oI f32334oxoX;

    /* renamed from: xoIox, reason: collision with root package name */
    public oxoX f32335xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public final x0XOIxOo.oO f32336xxIXOIIO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final Matrix f32333oIX0oI = new Matrix();

    /* renamed from: II0xO0, reason: collision with root package name */
    public final Path f32329II0xO0 = new Path();

    public IXxxXO(com.airbnb.lottie.xoIox xoiox, com.airbnb.lottie.model.layer.oIX0oI oix0oi, IXxxXO.XO xo2) {
        this.f32327I0Io = xoiox;
        this.f32334oxoX = oix0oi;
        this.f32331X0o0xo = xo2.I0Io();
        this.f32332XO = xo2.XO();
        x0XOIxOo.oIX0oI<Float, Float> oIX0oI2 = xo2.II0xO0().oIX0oI();
        this.f32330Oxx0IOOO = oIX0oI2;
        oix0oi.xxIXOIIO(oIX0oI2);
        oIX0oI2.oIX0oI(this);
        x0XOIxOo.oIX0oI<Float, Float> oIX0oI3 = xo2.oxoX().oIX0oI();
        this.f32328II0XooXoX = oIX0oI3;
        oix0oi.xxIXOIIO(oIX0oI3);
        oIX0oI3.oIX0oI(this);
        x0XOIxOo.oO II0xO02 = xo2.X0o0xo().II0xO0();
        this.f32336xxIXOIIO = II0xO02;
        II0xO02.oIX0oI(oix0oi);
        II0xO02.II0xO0(this);
    }

    @Override // ooOOo0oXI.X0o0xo
    public void I0Io(Canvas canvas, Matrix matrix, int i) {
        float floatValue = this.f32330Oxx0IOOO.II0XooXoX().floatValue();
        float floatValue2 = this.f32328II0XooXoX.II0XooXoX().floatValue();
        float floatValue3 = this.f32336xxIXOIIO.xxIXOIIO().II0XooXoX().floatValue() / 100.0f;
        float floatValue4 = this.f32336xxIXOIIO.X0o0xo().II0XooXoX().floatValue() / 100.0f;
        for (int i2 = ((int) floatValue) - 1; i2 >= 0; i2--) {
            this.f32333oIX0oI.set(matrix);
            float f = i2;
            this.f32333oIX0oI.preConcat(this.f32336xxIXOIIO.Oxx0IOOO(f + floatValue2));
            this.f32335xoIox.I0Io(canvas, this.f32333oIX0oI, (int) (i * IIXOooo.xxIXOIIO.OOXIXo(floatValue3, floatValue4, f / floatValue)));
        }
    }

    @Override // ooOOo0oXI.xoIox
    public void II0xO0(ListIterator<I0Io> listIterator) {
        if (this.f32335xoIox != null) {
            return;
        }
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        ArrayList arrayList = new ArrayList();
        while (listIterator.hasPrevious()) {
            arrayList.add(listIterator.previous());
            listIterator.remove();
        }
        Collections.reverse(arrayList);
        this.f32335xoIox = new oxoX(this.f32327I0Io, this.f32334oxoX, "Repeater", this.f32332XO, arrayList, null);
    }

    @Override // x0xO0oo.X0o0xo
    public void Oxx0IOOO(x0xO0oo.oxoX oxox, int i, List<x0xO0oo.oxoX> list, x0xO0oo.oxoX oxox2) {
        IIXOooo.xxIXOIIO.ooOOo0oXI(oxox, i, list, oxox2, this);
    }

    @Override // ooOOo0oXI.I0Io
    public void X0o0xo(List<I0Io> list, List<I0Io> list2) {
        this.f32335xoIox.X0o0xo(list, list2);
    }

    @Override // x0xO0oo.X0o0xo
    public <T> void XO(T t, @Nullable xoXoI.xoIox<T> xoiox) {
        if (this.f32336xxIXOIIO.I0Io(t, xoiox)) {
            return;
        }
        if (t == com.airbnb.lottie.oO.f4969Oxx0xo) {
            this.f32330Oxx0IOOO.x0XOIxOo(xoiox);
        } else if (t == com.airbnb.lottie.oO.f4978oI0IIXIo) {
            this.f32328II0XooXoX.x0XOIxOo(xoiox);
        }
    }

    @Override // ooOOo0oXI.I0Io
    public String getName() {
        return this.f32331X0o0xo;
    }

    @Override // ooOOo0oXI.x0XOIxOo
    public Path getPath() {
        Path path = this.f32335xoIox.getPath();
        this.f32329II0xO0.reset();
        float floatValue = this.f32330Oxx0IOOO.II0XooXoX().floatValue();
        float floatValue2 = this.f32328II0XooXoX.II0XooXoX().floatValue();
        for (int i = ((int) floatValue) - 1; i >= 0; i--) {
            this.f32333oIX0oI.set(this.f32336xxIXOIIO.Oxx0IOOO(i + floatValue2));
            this.f32329II0xO0.addPath(path, this.f32333oIX0oI);
        }
        return this.f32329II0xO0;
    }

    @Override // ooOOo0oXI.X0o0xo
    public void oIX0oI(RectF rectF, Matrix matrix, boolean z) {
        this.f32335xoIox.oIX0oI(rectF, matrix, z);
    }

    @Override // x0XOIxOo.oIX0oI.II0xO0
    public void oxoX() {
        this.f32327I0Io.invalidateSelf();
    }
}
