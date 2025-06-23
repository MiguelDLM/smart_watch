package com.airbnb.lottie.model.content;

import IXxxXO.II0xO0;
import Oo.X0o0xo;
import Oo.x0xO0oo;
import android.graphics.PointF;
import com.airbnb.lottie.xoIox;
import ooOOo0oXI.I0Io;
import ooOOo0oXI.oO;

/* loaded from: classes.dex */
public class PolystarShape implements II0xO0 {

    /* renamed from: I0Io, reason: collision with root package name */
    public final X0o0xo f4848I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public final X0o0xo f4849II0XooXoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    public final Type f4850II0xO0;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public final X0o0xo f4851Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public final X0o0xo f4852X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public final X0o0xo f4853XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final String f4854oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public final x0xO0oo<PointF, PointF> f4855oxoX;

    /* renamed from: xoIox, reason: collision with root package name */
    public final boolean f4856xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public final X0o0xo f4857xxIXOIIO;

    /* loaded from: classes.dex */
    public enum Type {
        STAR(1),
        POLYGON(2);

        private final int value;

        Type(int i) {
            this.value = i;
        }

        public static Type forValue(int i) {
            for (Type type : values()) {
                if (type.value == i) {
                    return type;
                }
            }
            return null;
        }
    }

    public PolystarShape(String str, Type type, X0o0xo x0o0xo, x0xO0oo<PointF, PointF> x0xo0oo, X0o0xo x0o0xo2, X0o0xo x0o0xo3, X0o0xo x0o0xo4, X0o0xo x0o0xo5, X0o0xo x0o0xo6, boolean z) {
        this.f4854oIX0oI = str;
        this.f4850II0xO0 = type;
        this.f4848I0Io = x0o0xo;
        this.f4855oxoX = x0xo0oo;
        this.f4852X0o0xo = x0o0xo2;
        this.f4853XO = x0o0xo3;
        this.f4851Oxx0IOOO = x0o0xo4;
        this.f4849II0XooXoX = x0o0xo5;
        this.f4857xxIXOIIO = x0o0xo6;
        this.f4856xoIox = z;
    }

    public X0o0xo I0Io() {
        return this.f4849II0XooXoX;
    }

    public x0xO0oo<PointF, PointF> II0XooXoX() {
        return this.f4855oxoX;
    }

    public X0o0xo II0xO0() {
        return this.f4853XO;
    }

    public boolean OOXIXo() {
        return this.f4856xoIox;
    }

    public X0o0xo Oxx0IOOO() {
        return this.f4848I0Io;
    }

    public X0o0xo X0o0xo() {
        return this.f4851Oxx0IOOO;
    }

    public X0o0xo XO() {
        return this.f4857xxIXOIIO;
    }

    @Override // IXxxXO.II0xO0
    public I0Io oIX0oI(xoIox xoiox, com.airbnb.lottie.model.layer.oIX0oI oix0oi) {
        return new oO(xoiox, oix0oi, this);
    }

    public String oxoX() {
        return this.f4854oIX0oI;
    }

    public Type xoIox() {
        return this.f4850II0xO0;
    }

    public X0o0xo xxIXOIIO() {
        return this.f4852X0o0xo;
    }
}
