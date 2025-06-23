package com.airbnb.lottie.model.content;

import IXxxXO.II0xO0;
import Oo.X0o0xo;
import com.airbnb.lottie.xoIox;
import ooOOo0oXI.I0Io;
import ooOOo0oXI.OxxIIOOXO;
import org.apache.commons.text.ooOOo0oXI;

/* loaded from: classes.dex */
public class ShapeTrimPath implements II0xO0 {

    /* renamed from: I0Io, reason: collision with root package name */
    public final X0o0xo f4870I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public final Type f4871II0xO0;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public final X0o0xo f4872X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public final boolean f4873XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final String f4874oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public final X0o0xo f4875oxoX;

    /* loaded from: classes.dex */
    public enum Type {
        SIMULTANEOUSLY,
        INDIVIDUALLY;

        public static Type forId(int i) {
            if (i != 1) {
                if (i == 2) {
                    return INDIVIDUALLY;
                }
                throw new IllegalArgumentException("Unknown trim path type " + i);
            }
            return SIMULTANEOUSLY;
        }
    }

    public ShapeTrimPath(String str, Type type, X0o0xo x0o0xo, X0o0xo x0o0xo2, X0o0xo x0o0xo3, boolean z) {
        this.f4874oIX0oI = str;
        this.f4871II0xO0 = type;
        this.f4870I0Io = x0o0xo;
        this.f4875oxoX = x0o0xo2;
        this.f4872X0o0xo = x0o0xo3;
        this.f4873XO = z;
    }

    public String I0Io() {
        return this.f4874oIX0oI;
    }

    public X0o0xo II0xO0() {
        return this.f4875oxoX;
    }

    public boolean Oxx0IOOO() {
        return this.f4873XO;
    }

    public X0o0xo X0o0xo() {
        return this.f4870I0Io;
    }

    public Type XO() {
        return this.f4871II0xO0;
    }

    @Override // IXxxXO.II0xO0
    public I0Io oIX0oI(xoIox xoiox, com.airbnb.lottie.model.layer.oIX0oI oix0oi) {
        return new OxxIIOOXO(oix0oi, this);
    }

    public X0o0xo oxoX() {
        return this.f4872X0o0xo;
    }

    public String toString() {
        return "Trim Path: {start: " + this.f4870I0Io + ", end: " + this.f4875oxoX + ", offset: " + this.f4872X0o0xo + ooOOo0oXI.f33074oOoXoXO;
    }
}
