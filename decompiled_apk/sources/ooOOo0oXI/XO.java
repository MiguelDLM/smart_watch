package ooOOo0oXI;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.List;
import x0XOIxOo.oIX0oI;

/* loaded from: classes.dex */
public class XO implements x0XOIxOo, oIX0oI.II0xO0, OOXIXo {

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final float f32361xxIXOIIO = 0.55228f;

    /* renamed from: I0Io, reason: collision with root package name */
    public final com.airbnb.lottie.xoIox f32362I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public boolean f32363II0XooXoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    public final String f32364II0xO0;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public final x0XOIxOo.oIX0oI<?, PointF> f32366X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public final IXxxXO.oIX0oI f32367XO;

    /* renamed from: oxoX, reason: collision with root package name */
    public final x0XOIxOo.oIX0oI<?, PointF> f32369oxoX;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final Path f32368oIX0oI = new Path();

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public II0xO0 f32365Oxx0IOOO = new II0xO0();

    public XO(com.airbnb.lottie.xoIox xoiox, com.airbnb.lottie.model.layer.oIX0oI oix0oi, IXxxXO.oIX0oI oix0oi2) {
        this.f32364II0xO0 = oix0oi2.II0xO0();
        this.f32362I0Io = xoiox;
        x0XOIxOo.oIX0oI<PointF, PointF> oIX0oI2 = oix0oi2.oxoX().oIX0oI();
        this.f32369oxoX = oIX0oI2;
        x0XOIxOo.oIX0oI<PointF, PointF> oIX0oI3 = oix0oi2.I0Io().oIX0oI();
        this.f32366X0o0xo = oIX0oI3;
        this.f32367XO = oix0oi2;
        oix0oi.xxIXOIIO(oIX0oI2);
        oix0oi.xxIXOIIO(oIX0oI3);
        oIX0oI2.oIX0oI(this);
        oIX0oI3.oIX0oI(this);
    }

    public final void II0xO0() {
        this.f32363II0XooXoX = false;
        this.f32362I0Io.invalidateSelf();
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
                    this.f32365Oxx0IOOO.oIX0oI(oxxIIOOXO);
                    oxxIIOOXO.II0xO0(this);
                }
            }
        }
    }

    @Override // x0xO0oo.X0o0xo
    public <T> void XO(T t, @Nullable xoXoI.xoIox<T> xoiox) {
        if (t == com.airbnb.lottie.oO.f4989xxIXOIIO) {
            this.f32369oxoX.x0XOIxOo(xoiox);
        } else if (t == com.airbnb.lottie.oO.f4981oOoXoXO) {
            this.f32366X0o0xo.x0XOIxOo(xoiox);
        }
    }

    @Override // ooOOo0oXI.I0Io
    public String getName() {
        return this.f32364II0xO0;
    }

    @Override // ooOOo0oXI.x0XOIxOo
    public Path getPath() {
        if (this.f32363II0XooXoX) {
            return this.f32368oIX0oI;
        }
        this.f32368oIX0oI.reset();
        if (this.f32367XO.X0o0xo()) {
            this.f32363II0XooXoX = true;
            return this.f32368oIX0oI;
        }
        PointF II0XooXoX2 = this.f32369oxoX.II0XooXoX();
        float f = II0XooXoX2.x / 2.0f;
        float f2 = II0XooXoX2.y / 2.0f;
        float f3 = f * 0.55228f;
        float f4 = 0.55228f * f2;
        this.f32368oIX0oI.reset();
        if (this.f32367XO.XO()) {
            float f5 = -f2;
            this.f32368oIX0oI.moveTo(0.0f, f5);
            float f6 = 0.0f - f3;
            float f7 = -f;
            float f8 = 0.0f - f4;
            this.f32368oIX0oI.cubicTo(f6, f5, f7, f8, f7, 0.0f);
            float f9 = f4 + 0.0f;
            this.f32368oIX0oI.cubicTo(f7, f9, f6, f2, 0.0f, f2);
            float f10 = f3 + 0.0f;
            this.f32368oIX0oI.cubicTo(f10, f2, f, f9, f, 0.0f);
            this.f32368oIX0oI.cubicTo(f, f8, f10, f5, 0.0f, f5);
        } else {
            float f11 = -f2;
            this.f32368oIX0oI.moveTo(0.0f, f11);
            float f12 = f3 + 0.0f;
            float f13 = 0.0f - f4;
            this.f32368oIX0oI.cubicTo(f12, f11, f, f13, f, 0.0f);
            float f14 = f4 + 0.0f;
            this.f32368oIX0oI.cubicTo(f, f14, f12, f2, 0.0f, f2);
            float f15 = 0.0f - f3;
            float f16 = -f;
            this.f32368oIX0oI.cubicTo(f15, f2, f16, f14, f16, 0.0f);
            this.f32368oIX0oI.cubicTo(f16, f13, f15, f11, 0.0f, f11);
        }
        PointF II0XooXoX3 = this.f32366X0o0xo.II0XooXoX();
        this.f32368oIX0oI.offset(II0XooXoX3.x, II0XooXoX3.y);
        this.f32368oIX0oI.close();
        this.f32365Oxx0IOOO.II0xO0(this.f32368oIX0oI);
        this.f32363II0XooXoX = true;
        return this.f32368oIX0oI;
    }

    @Override // x0XOIxOo.oIX0oI.II0xO0
    public void oxoX() {
        II0xO0();
    }
}
