package ooOOo0oXI;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import androidx.annotation.Nullable;
import com.airbnb.lottie.model.content.ShapeStroke;

/* loaded from: classes.dex */
public class oI0IIXIo extends oIX0oI {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public final x0XOIxOo.oIX0oI<Integer, Integer> f32370IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public final boolean f32371Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    @Nullable
    public x0XOIxOo.oIX0oI<ColorFilter, ColorFilter> f32372Oxx0xo;

    /* renamed from: oO, reason: collision with root package name */
    public final com.airbnb.lottie.model.layer.oIX0oI f32373oO;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public final String f32374x0xO0oo;

    public oI0IIXIo(com.airbnb.lottie.xoIox xoiox, com.airbnb.lottie.model.layer.oIX0oI oix0oi, ShapeStroke shapeStroke) {
        super(xoiox, oix0oi, shapeStroke.II0xO0().toPaintCap(), shapeStroke.X0o0xo().toPaintJoin(), shapeStroke.Oxx0IOOO(), shapeStroke.xxIXOIIO(), shapeStroke.xoIox(), shapeStroke.XO(), shapeStroke.oxoX());
        this.f32373oO = oix0oi;
        this.f32374x0xO0oo = shapeStroke.II0XooXoX();
        this.f32371Oo = shapeStroke.OOXIXo();
        x0XOIxOo.oIX0oI<Integer, Integer> oIX0oI2 = shapeStroke.I0Io().oIX0oI();
        this.f32370IXxxXO = oIX0oI2;
        oIX0oI2.oIX0oI(this);
        oix0oi.xxIXOIIO(oIX0oI2);
    }

    @Override // ooOOo0oXI.oIX0oI, ooOOo0oXI.X0o0xo
    public void I0Io(Canvas canvas, Matrix matrix, int i) {
        if (this.f32371Oo) {
            return;
        }
        this.f32388xxIXOIIO.setColor(((x0XOIxOo.II0xO0) this.f32370IXxxXO).x0xO0oo());
        x0XOIxOo.oIX0oI<ColorFilter, ColorFilter> oix0oi = this.f32372Oxx0xo;
        if (oix0oi != null) {
            this.f32388xxIXOIIO.setColorFilter(oix0oi.II0XooXoX());
        }
        super.I0Io(canvas, matrix, i);
    }

    @Override // ooOOo0oXI.oIX0oI, x0xO0oo.X0o0xo
    public <T> void XO(T t, @Nullable xoXoI.xoIox<T> xoiox) {
        super.XO(t, xoiox);
        if (t == com.airbnb.lottie.oO.f4961II0xO0) {
            this.f32370IXxxXO.x0XOIxOo(xoiox);
            return;
        }
        if (t == com.airbnb.lottie.oO.f4976XxX0x0xxx) {
            x0XOIxOo.oIX0oI<ColorFilter, ColorFilter> oix0oi = this.f32372Oxx0xo;
            if (oix0oi != null) {
                this.f32373oO.XIxXXX0x0(oix0oi);
            }
            if (xoiox == null) {
                this.f32372Oxx0xo = null;
                return;
            }
            x0XOIxOo.x0xO0oo x0xo0oo = new x0XOIxOo.x0xO0oo(xoiox);
            this.f32372Oxx0xo = x0xo0oo;
            x0xo0oo.oIX0oI(this);
            this.f32373oO.xxIXOIIO(this.f32370IXxxXO);
        }
    }

    @Override // ooOOo0oXI.I0Io
    public String getName() {
        return this.f32374x0xO0oo;
    }
}
