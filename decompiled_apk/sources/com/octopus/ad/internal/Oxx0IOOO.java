package com.octopus.ad.internal;

import x0.ooXIXxIX;
import x0.xI;

/* loaded from: classes11.dex */
public class Oxx0IOOO extends ooXIXxIX {

    /* renamed from: I0Io, reason: collision with root package name */
    public final String f18611I0Io;

    /* renamed from: oxoX, reason: collision with root package name */
    public ooXIXxIX.II0xO0 f18612oxoX;

    public Oxx0IOOO(String str) {
        super(false);
        this.f18611I0Io = str;
    }

    @Override // x0.ooXIXxIX
    public void II0XooXoX(xI xIVar) {
        ooXIXxIX.II0xO0 iI0xO0 = this.f18612oxoX;
        if (iI0xO0 != null && xIVar != null) {
            iI0xO0.oIX0oI(xIVar.X0o0xo(), xIVar.oxoX());
        }
    }

    @Override // x0.ooXIXxIX
    public String Oxx0IOOO() {
        return this.f18611I0Io;
    }

    public Oxx0IOOO xoIox(ooXIXxIX.II0xO0 iI0xO0) {
        this.f18612oxoX = iI0xO0;
        return this;
    }
}
