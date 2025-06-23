package com.airbnb.lottie.model.content;

import IXxxXO.II0xO0;
import Oo.X0o0xo;
import Oo.x0xO0oo;
import android.graphics.PointF;
import com.airbnb.lottie.model.layer.oIX0oI;
import com.airbnb.lottie.xoIox;
import ooOOo0oXI.I0Io;
import ooOOo0oXI.oO;

public class PolystarShape implements II0xO0 {

    /* renamed from: I0Io  reason: collision with root package name */
    public final X0o0xo f854I0Io;

    /* renamed from: II0XooXoX  reason: collision with root package name */
    public final X0o0xo f855II0XooXoX;

    /* renamed from: II0xO0  reason: collision with root package name */
    public final Type f856II0xO0;

    /* renamed from: Oxx0IOOO  reason: collision with root package name */
    public final X0o0xo f857Oxx0IOOO;

    /* renamed from: X0o0xo  reason: collision with root package name */
    public final X0o0xo f858X0o0xo;

    /* renamed from: XO  reason: collision with root package name */
    public final X0o0xo f859XO;

    /* renamed from: oIX0oI  reason: collision with root package name */
    public final String f860oIX0oI;

    /* renamed from: oxoX  reason: collision with root package name */
    public final x0xO0oo<PointF, PointF> f861oxoX;

    /* renamed from: xoIox  reason: collision with root package name */
    public final boolean f862xoIox;

    /* renamed from: xxIXOIIO  reason: collision with root package name */
    public final X0o0xo f863xxIXOIIO;

    public enum Type {
        STAR(1),
        POLYGON(2);
        
        private final int value;

        private Type(int i) {
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
        this.f860oIX0oI = str;
        this.f856II0xO0 = type;
        this.f854I0Io = x0o0xo;
        this.f861oxoX = x0xo0oo;
        this.f858X0o0xo = x0o0xo2;
        this.f859XO = x0o0xo3;
        this.f857Oxx0IOOO = x0o0xo4;
        this.f855II0XooXoX = x0o0xo5;
        this.f863xxIXOIIO = x0o0xo6;
        this.f862xoIox = z;
    }

    public X0o0xo I0Io() {
        return this.f855II0XooXoX;
    }

    public x0xO0oo<PointF, PointF> II0XooXoX() {
        return this.f861oxoX;
    }

    public X0o0xo II0xO0() {
        return this.f859XO;
    }

    public boolean OOXIXo() {
        return this.f862xoIox;
    }

    public X0o0xo Oxx0IOOO() {
        return this.f854I0Io;
    }

    public X0o0xo X0o0xo() {
        return this.f857Oxx0IOOO;
    }

    public X0o0xo XO() {
        return this.f863xxIXOIIO;
    }

    public I0Io oIX0oI(xoIox xoiox, oIX0oI oix0oi) {
        return new oO(xoiox, oix0oi, this);
    }

    public String oxoX() {
        return this.f860oIX0oI;
    }

    public Type xoIox() {
        return this.f856II0xO0;
    }

    public X0o0xo xxIXOIIO() {
        return this.f858X0o0xo;
    }
}
