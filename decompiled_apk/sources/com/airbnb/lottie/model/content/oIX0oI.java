package com.airbnb.lottie.model.content;

import IXxxXO.II0xO0;
import Oo.Oxx0IOOO;
import Oo.X0o0xo;
import Oo.XO;
import Oo.xxIXOIIO;
import androidx.annotation.Nullable;
import com.airbnb.lottie.model.content.ShapeStroke;
import com.airbnb.lottie.xoIox;
import java.util.List;
import ooOOo0oXI.I0Io;

/* loaded from: classes.dex */
public class oIX0oI implements II0xO0 {

    /* renamed from: I0Io, reason: collision with root package name */
    public final XO f4876I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public final ShapeStroke.LineCapType f4877II0XooXoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    public final GradientType f4878II0xO0;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public final List<X0o0xo> f4879OOXIXo;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public final X0o0xo f4880Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public final xxIXOIIO f4881X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public final xxIXOIIO f4882XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final String f4883oIX0oI;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    @Nullable
    public final X0o0xo f4884oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public final boolean f4885ooOOo0oXI;

    /* renamed from: oxoX, reason: collision with root package name */
    public final Oxx0IOOO f4886oxoX;

    /* renamed from: xoIox, reason: collision with root package name */
    public final float f4887xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public final ShapeStroke.LineJoinType f4888xxIXOIIO;

    public oIX0oI(String str, GradientType gradientType, XO xo2, Oxx0IOOO oxx0IOOO, xxIXOIIO xxixoiio, xxIXOIIO xxixoiio2, X0o0xo x0o0xo, ShapeStroke.LineCapType lineCapType, ShapeStroke.LineJoinType lineJoinType, float f, List<X0o0xo> list, @Nullable X0o0xo x0o0xo2, boolean z) {
        this.f4883oIX0oI = str;
        this.f4878II0xO0 = gradientType;
        this.f4876I0Io = xo2;
        this.f4886oxoX = oxx0IOOO;
        this.f4881X0o0xo = xxixoiio;
        this.f4882XO = xxixoiio2;
        this.f4880Oxx0IOOO = x0o0xo;
        this.f4877II0XooXoX = lineCapType;
        this.f4888xxIXOIIO = lineJoinType;
        this.f4887xoIox = f;
        this.f4879OOXIXo = list;
        this.f4884oOoXoXO = x0o0xo2;
        this.f4885ooOOo0oXI = z;
    }

    @Nullable
    public X0o0xo I0Io() {
        return this.f4884oOoXoXO;
    }

    public List<X0o0xo> II0XooXoX() {
        return this.f4879OOXIXo;
    }

    public ShapeStroke.LineCapType II0xO0() {
        return this.f4877II0XooXoX;
    }

    public Oxx0IOOO OOXIXo() {
        return this.f4886oxoX;
    }

    public ShapeStroke.LineJoinType Oxx0IOOO() {
        return this.f4888xxIXOIIO;
    }

    public XO X0o0xo() {
        return this.f4876I0Io;
    }

    public GradientType XO() {
        return this.f4878II0xO0;
    }

    @Override // IXxxXO.II0xO0
    public I0Io oIX0oI(xoIox xoiox, com.airbnb.lottie.model.layer.oIX0oI oix0oi) {
        return new ooOOo0oXI.xxIXOIIO(xoiox, oix0oi, this);
    }

    public xxIXOIIO oOoXoXO() {
        return this.f4881X0o0xo;
    }

    public X0o0xo ooOOo0oXI() {
        return this.f4880Oxx0IOOO;
    }

    public xxIXOIIO oxoX() {
        return this.f4882XO;
    }

    public boolean x0XOIxOo() {
        return this.f4885ooOOo0oXI;
    }

    public String xoIox() {
        return this.f4883oIX0oI;
    }

    public float xxIXOIIO() {
        return this.f4887xoIox;
    }
}
