package com.airbnb.lottie.model.content;

import IXxxXO.II0xO0;
import Oo.X0o0xo;
import com.airbnb.lottie.model.layer.oIX0oI;
import com.airbnb.lottie.xoIox;
import ooOOo0oXI.I0Io;
import ooOOo0oXI.OxxIIOOXO;
import org.apache.commons.text.ooOOo0oXI;

public class ShapeTrimPath implements II0xO0 {

    /* renamed from: I0Io  reason: collision with root package name */
    public final X0o0xo f876I0Io;

    /* renamed from: II0xO0  reason: collision with root package name */
    public final Type f877II0xO0;

    /* renamed from: X0o0xo  reason: collision with root package name */
    public final X0o0xo f878X0o0xo;

    /* renamed from: XO  reason: collision with root package name */
    public final boolean f879XO;

    /* renamed from: oIX0oI  reason: collision with root package name */
    public final String f880oIX0oI;

    /* renamed from: oxoX  reason: collision with root package name */
    public final X0o0xo f881oxoX;

    public enum Type {
        SIMULTANEOUSLY,
        INDIVIDUALLY;

        public static Type forId(int i) {
            if (i == 1) {
                return SIMULTANEOUSLY;
            }
            if (i == 2) {
                return INDIVIDUALLY;
            }
            throw new IllegalArgumentException("Unknown trim path type " + i);
        }
    }

    public ShapeTrimPath(String str, Type type, X0o0xo x0o0xo, X0o0xo x0o0xo2, X0o0xo x0o0xo3, boolean z) {
        this.f880oIX0oI = str;
        this.f877II0xO0 = type;
        this.f876I0Io = x0o0xo;
        this.f881oxoX = x0o0xo2;
        this.f878X0o0xo = x0o0xo3;
        this.f879XO = z;
    }

    public String I0Io() {
        return this.f880oIX0oI;
    }

    public X0o0xo II0xO0() {
        return this.f881oxoX;
    }

    public boolean Oxx0IOOO() {
        return this.f879XO;
    }

    public X0o0xo X0o0xo() {
        return this.f876I0Io;
    }

    public Type XO() {
        return this.f877II0xO0;
    }

    public I0Io oIX0oI(xoIox xoiox, oIX0oI oix0oi) {
        return new OxxIIOOXO(oix0oi, this);
    }

    public X0o0xo oxoX() {
        return this.f878X0o0xo;
    }

    public String toString() {
        return "Trim Path: {start: " + this.f876I0Io + ", end: " + this.f881oxoX + ", offset: " + this.f878X0o0xo + ooOOo0oXI.f22054oOoXoXO;
    }
}
