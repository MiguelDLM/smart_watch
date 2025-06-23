package ooOOo0oXI;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.List;
import x0XOIxOo.oIX0oI;

/* loaded from: classes.dex */
public class x0xO0oo implements oIX0oI.II0xO0, OOXIXo, x0XOIxOo {

    /* renamed from: I0Io, reason: collision with root package name */
    public final String f32426I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public final x0XOIxOo.oIX0oI<?, Float> f32427II0XooXoX;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public final x0XOIxOo.oIX0oI<?, PointF> f32429Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public final com.airbnb.lottie.xoIox f32430X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public final x0XOIxOo.oIX0oI<?, PointF> f32431XO;

    /* renamed from: oxoX, reason: collision with root package name */
    public final boolean f32433oxoX;

    /* renamed from: xoIox, reason: collision with root package name */
    public boolean f32434xoIox;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final Path f32432oIX0oI = new Path();

    /* renamed from: II0xO0, reason: collision with root package name */
    public final RectF f32428II0xO0 = new RectF();

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public II0xO0 f32435xxIXOIIO = new II0xO0();

    public x0xO0oo(com.airbnb.lottie.xoIox xoiox, com.airbnb.lottie.model.layer.oIX0oI oix0oi, IXxxXO.X0o0xo x0o0xo) {
        this.f32426I0Io = x0o0xo.I0Io();
        this.f32433oxoX = x0o0xo.XO();
        this.f32430X0o0xo = xoiox;
        x0XOIxOo.oIX0oI<PointF, PointF> oIX0oI2 = x0o0xo.oxoX().oIX0oI();
        this.f32431XO = oIX0oI2;
        x0XOIxOo.oIX0oI<PointF, PointF> oIX0oI3 = x0o0xo.X0o0xo().oIX0oI();
        this.f32429Oxx0IOOO = oIX0oI3;
        x0XOIxOo.oIX0oI<Float, Float> oIX0oI4 = x0o0xo.II0xO0().oIX0oI();
        this.f32427II0XooXoX = oIX0oI4;
        oix0oi.xxIXOIIO(oIX0oI2);
        oix0oi.xxIXOIIO(oIX0oI3);
        oix0oi.xxIXOIIO(oIX0oI4);
        oIX0oI2.oIX0oI(this);
        oIX0oI3.oIX0oI(this);
        oIX0oI4.oIX0oI(this);
    }

    private void II0xO0() {
        this.f32434xoIox = false;
        this.f32430X0o0xo.invalidateSelf();
    }

    @Override // x0xO0oo.X0o0xo
    public void Oxx0IOOO(x0xO0oo.oxoX oxox, int i, List<x0xO0oo.oxoX> list, x0xO0oo.oxoX oxox2) {
        IIXOooo.xxIXOIIO.ooOOo0oXI(oxox, i, list, oxox2, this);
    }

    @Override // ooOOo0oXI.I0Io
    public void X0o0xo(List<I0Io> list, List<I0Io> list2) {
        for (int i = 0; i < list.size(); i++) {
            I0Io i0Io = list.get(i);
            if (i0Io instanceof OxxIIOOXO) {
                OxxIIOOXO oxxIIOOXO = (OxxIIOOXO) i0Io;
                if (oxxIIOOXO.xxIXOIIO() == ShapeTrimPath.Type.SIMULTANEOUSLY) {
                    this.f32435xxIXOIIO.oIX0oI(oxxIIOOXO);
                    oxxIIOOXO.II0xO0(this);
                }
            }
        }
    }

    @Override // x0xO0oo.X0o0xo
    public <T> void XO(T t, @Nullable xoXoI.xoIox<T> xoiox) {
        if (t == com.airbnb.lottie.oO.f4987xoIox) {
            this.f32429Oxx0IOOO.x0XOIxOo(xoiox);
        } else if (t == com.airbnb.lottie.oO.f4981oOoXoXO) {
            this.f32431XO.x0XOIxOo(xoiox);
        } else if (t == com.airbnb.lottie.oO.f4965OOXIXo) {
            this.f32427II0XooXoX.x0XOIxOo(xoiox);
        }
    }

    @Override // ooOOo0oXI.I0Io
    public String getName() {
        return this.f32426I0Io;
    }

    @Override // ooOOo0oXI.x0XOIxOo
    public Path getPath() {
        float x0xO0oo2;
        if (this.f32434xoIox) {
            return this.f32432oIX0oI;
        }
        this.f32432oIX0oI.reset();
        if (this.f32433oxoX) {
            this.f32434xoIox = true;
            return this.f32432oIX0oI;
        }
        PointF II0XooXoX2 = this.f32429Oxx0IOOO.II0XooXoX();
        float f = II0XooXoX2.x / 2.0f;
        float f2 = II0XooXoX2.y / 2.0f;
        x0XOIxOo.oIX0oI<?, Float> oix0oi = this.f32427II0XooXoX;
        if (oix0oi == null) {
            x0xO0oo2 = 0.0f;
        } else {
            x0xO0oo2 = ((x0XOIxOo.I0Io) oix0oi).x0xO0oo();
        }
        float min = Math.min(f, f2);
        if (x0xO0oo2 > min) {
            x0xO0oo2 = min;
        }
        PointF II0XooXoX3 = this.f32431XO.II0XooXoX();
        this.f32432oIX0oI.moveTo(II0XooXoX3.x + f, (II0XooXoX3.y - f2) + x0xO0oo2);
        this.f32432oIX0oI.lineTo(II0XooXoX3.x + f, (II0XooXoX3.y + f2) - x0xO0oo2);
        if (x0xO0oo2 > 0.0f) {
            RectF rectF = this.f32428II0xO0;
            float f3 = II0XooXoX3.x;
            float f4 = x0xO0oo2 * 2.0f;
            float f5 = II0XooXoX3.y;
            rectF.set((f3 + f) - f4, (f5 + f2) - f4, f3 + f, f5 + f2);
            this.f32432oIX0oI.arcTo(this.f32428II0xO0, 0.0f, 90.0f, false);
        }
        this.f32432oIX0oI.lineTo((II0XooXoX3.x - f) + x0xO0oo2, II0XooXoX3.y + f2);
        if (x0xO0oo2 > 0.0f) {
            RectF rectF2 = this.f32428II0xO0;
            float f6 = II0XooXoX3.x;
            float f7 = II0XooXoX3.y;
            float f8 = x0xO0oo2 * 2.0f;
            rectF2.set(f6 - f, (f7 + f2) - f8, (f6 - f) + f8, f7 + f2);
            this.f32432oIX0oI.arcTo(this.f32428II0xO0, 90.0f, 90.0f, false);
        }
        this.f32432oIX0oI.lineTo(II0XooXoX3.x - f, (II0XooXoX3.y - f2) + x0xO0oo2);
        if (x0xO0oo2 > 0.0f) {
            RectF rectF3 = this.f32428II0xO0;
            float f9 = II0XooXoX3.x;
            float f10 = II0XooXoX3.y;
            float f11 = x0xO0oo2 * 2.0f;
            rectF3.set(f9 - f, f10 - f2, (f9 - f) + f11, (f10 - f2) + f11);
            this.f32432oIX0oI.arcTo(this.f32428II0xO0, 180.0f, 90.0f, false);
        }
        this.f32432oIX0oI.lineTo((II0XooXoX3.x + f) - x0xO0oo2, II0XooXoX3.y - f2);
        if (x0xO0oo2 > 0.0f) {
            RectF rectF4 = this.f32428II0xO0;
            float f12 = II0XooXoX3.x;
            float f13 = x0xO0oo2 * 2.0f;
            float f14 = II0XooXoX3.y;
            rectF4.set((f12 + f) - f13, f14 - f2, f12 + f, (f14 - f2) + f13);
            this.f32432oIX0oI.arcTo(this.f32428II0xO0, 270.0f, 90.0f, false);
        }
        this.f32432oIX0oI.close();
        this.f32435xxIXOIIO.II0xO0(this.f32432oIX0oI);
        this.f32434xoIox = true;
        return this.f32432oIX0oI;
    }

    @Override // x0XOIxOo.oIX0oI.II0xO0
    public void oxoX() {
        II0xO0();
    }
}
