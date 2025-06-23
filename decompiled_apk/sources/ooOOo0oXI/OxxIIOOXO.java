package ooOOo0oXI;

import com.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.ArrayList;
import java.util.List;
import x0XOIxOo.oIX0oI;

/* loaded from: classes.dex */
public class OxxIIOOXO implements I0Io, oIX0oI.II0xO0 {

    /* renamed from: I0Io, reason: collision with root package name */
    public final List<oIX0oI.II0xO0> f32354I0Io = new ArrayList();

    /* renamed from: II0xO0, reason: collision with root package name */
    public final boolean f32355II0xO0;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public final x0XOIxOo.oIX0oI<?, Float> f32356Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public final x0XOIxOo.oIX0oI<?, Float> f32357X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public final x0XOIxOo.oIX0oI<?, Float> f32358XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final String f32359oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public final ShapeTrimPath.Type f32360oxoX;

    public OxxIIOOXO(com.airbnb.lottie.model.layer.oIX0oI oix0oi, ShapeTrimPath shapeTrimPath) {
        this.f32359oIX0oI = shapeTrimPath.I0Io();
        this.f32355II0xO0 = shapeTrimPath.Oxx0IOOO();
        this.f32360oxoX = shapeTrimPath.XO();
        x0XOIxOo.oIX0oI<Float, Float> oIX0oI2 = shapeTrimPath.X0o0xo().oIX0oI();
        this.f32357X0o0xo = oIX0oI2;
        x0XOIxOo.oIX0oI<Float, Float> oIX0oI3 = shapeTrimPath.II0xO0().oIX0oI();
        this.f32358XO = oIX0oI3;
        x0XOIxOo.oIX0oI<Float, Float> oIX0oI4 = shapeTrimPath.oxoX().oIX0oI();
        this.f32356Oxx0IOOO = oIX0oI4;
        oix0oi.xxIXOIIO(oIX0oI2);
        oix0oi.xxIXOIIO(oIX0oI3);
        oix0oi.xxIXOIIO(oIX0oI4);
        oIX0oI2.oIX0oI(this);
        oIX0oI3.oIX0oI(this);
        oIX0oI4.oIX0oI(this);
    }

    public x0XOIxOo.oIX0oI<?, Float> II0XooXoX() {
        return this.f32357X0o0xo;
    }

    public void II0xO0(oIX0oI.II0xO0 iI0xO0) {
        this.f32354I0Io.add(iI0xO0);
    }

    public x0XOIxOo.oIX0oI<?, Float> Oxx0IOOO() {
        return this.f32356Oxx0IOOO;
    }

    public x0XOIxOo.oIX0oI<?, Float> XO() {
        return this.f32358XO;
    }

    @Override // ooOOo0oXI.I0Io
    public String getName() {
        return this.f32359oIX0oI;
    }

    @Override // x0XOIxOo.oIX0oI.II0xO0
    public void oxoX() {
        for (int i = 0; i < this.f32354I0Io.size(); i++) {
            this.f32354I0Io.get(i).oxoX();
        }
    }

    public boolean xoIox() {
        return this.f32355II0xO0;
    }

    public ShapeTrimPath.Type xxIXOIIO() {
        return this.f32360oxoX;
    }

    @Override // ooOOo0oXI.I0Io
    public void X0o0xo(List<I0Io> list, List<I0Io> list2) {
    }
}
