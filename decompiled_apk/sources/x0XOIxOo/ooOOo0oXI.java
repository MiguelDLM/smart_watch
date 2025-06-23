package x0XOIxOo;

import android.graphics.PointF;
import androidx.annotation.Nullable;
import java.util.Collections;

/* loaded from: classes.dex */
public class ooOOo0oXI extends oIX0oI<PointF, PointF> {

    /* renamed from: OOXIXo, reason: collision with root package name */
    public final oIX0oI<Float, Float> f33997OOXIXo;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public final oIX0oI<Float, Float> f33998oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    @Nullable
    public xoXoI.xoIox<Float> f33999ooOOo0oXI;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    @Nullable
    public xoXoI.xoIox<Float> f34000x0XOIxOo;

    /* renamed from: xoIox, reason: collision with root package name */
    public final PointF f34001xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public final PointF f34002xxIXOIIO;

    public ooOOo0oXI(oIX0oI<Float, Float> oix0oi, oIX0oI<Float, Float> oix0oi2) {
        super(Collections.emptyList());
        this.f34002xxIXOIIO = new PointF();
        this.f34001xoIox = new PointF();
        this.f33997OOXIXo = oix0oi;
        this.f33998oOoXoXO = oix0oi2;
        ooOOo0oXI(XO());
    }

    public void IXxxXO(@Nullable xoXoI.xoIox<Float> xoiox) {
        xoXoI.xoIox<Float> xoiox2 = this.f33999ooOOo0oXI;
        if (xoiox2 != null) {
            xoiox2.I0Io(null);
        }
        this.f33999ooOOo0oXI = xoiox;
        if (xoiox != null) {
            xoiox.I0Io(this);
        }
    }

    @Override // x0XOIxOo.oIX0oI
    /* renamed from: Oo, reason: merged with bridge method [inline-methods] */
    public PointF xxIXOIIO(xoXoI.oIX0oI<PointF> oix0oi, float f) {
        Float f2;
        xoXoI.oIX0oI<Float> II0xO02;
        float floatValue;
        xoXoI.oIX0oI<Float> II0xO03;
        float floatValue2;
        Float f3 = null;
        if (this.f33999ooOOo0oXI != null && (II0xO03 = this.f33997OOXIXo.II0xO0()) != null) {
            float oxoX2 = this.f33997OOXIXo.oxoX();
            Float f4 = II0xO03.f35165II0XooXoX;
            xoXoI.xoIox<Float> xoiox = this.f33999ooOOo0oXI;
            float f5 = II0xO03.f35168Oxx0IOOO;
            if (f4 == null) {
                floatValue2 = f5;
            } else {
                floatValue2 = f4.floatValue();
            }
            f2 = xoiox.II0xO0(f5, floatValue2, II0xO03.f35166II0xO0, II0xO03.f35164I0Io, f, f, oxoX2);
        } else {
            f2 = null;
        }
        if (this.f34000x0XOIxOo != null && (II0xO02 = this.f33998oOoXoXO.II0xO0()) != null) {
            float oxoX3 = this.f33998oOoXoXO.oxoX();
            Float f6 = II0xO02.f35165II0XooXoX;
            xoXoI.xoIox<Float> xoiox2 = this.f34000x0XOIxOo;
            float f7 = II0xO02.f35168Oxx0IOOO;
            if (f6 == null) {
                floatValue = f7;
            } else {
                floatValue = f6.floatValue();
            }
            f3 = xoiox2.II0xO0(f7, floatValue, II0xO02.f35166II0xO0, II0xO02.f35164I0Io, f, f, oxoX3);
        }
        if (f2 == null) {
            this.f34001xoIox.set(this.f34002xxIXOIIO.x, 0.0f);
        } else {
            this.f34001xoIox.set(f2.floatValue(), 0.0f);
        }
        if (f3 == null) {
            PointF pointF = this.f34001xoIox;
            pointF.set(pointF.x, this.f34002xxIXOIIO.y);
        } else {
            PointF pointF2 = this.f34001xoIox;
            pointF2.set(pointF2.x, f3.floatValue());
        }
        return this.f34001xoIox;
    }

    public void Oxx0xo(@Nullable xoXoI.xoIox<Float> xoiox) {
        xoXoI.xoIox<Float> xoiox2 = this.f34000x0XOIxOo;
        if (xoiox2 != null) {
            xoiox2.I0Io(null);
        }
        this.f34000x0XOIxOo = xoiox;
        if (xoiox != null) {
            xoiox.I0Io(this);
        }
    }

    @Override // x0XOIxOo.oIX0oI
    public void ooOOo0oXI(float f) {
        this.f33997OOXIXo.ooOOo0oXI(f);
        this.f33998oOoXoXO.ooOOo0oXI(f);
        this.f34002xxIXOIIO.set(this.f33997OOXIXo.II0XooXoX().floatValue(), this.f33998oOoXoXO.II0XooXoX().floatValue());
        for (int i = 0; i < this.f33973oIX0oI.size(); i++) {
            this.f33973oIX0oI.get(i).oxoX();
        }
    }

    @Override // x0XOIxOo.oIX0oI
    /* renamed from: x0xO0oo, reason: merged with bridge method [inline-methods] */
    public PointF II0XooXoX() {
        return xxIXOIIO(null, 0.0f);
    }
}
