package com.github.doyaaaaaken.kotlincsv.dsl.context;

import IoOoo.II0xO0;
import OO.I0Io;
import OO.oIX0oI;
import OXOo.OOXIXo;
import Oox.oOoXoXO;
import kotlin.jvm.internal.IIX0o;
import kotlin.oXIO0o0XI;

@II0xO0
/* loaded from: classes9.dex */
public final class CsvWriterContext implements I0Io {

    /* renamed from: XO, reason: collision with root package name */
    public boolean f15784XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OOXIXo
    public String f15785oIX0oI = "UTF-8";

    /* renamed from: II0xO0, reason: collision with root package name */
    public char f15781II0xO0 = ',';

    /* renamed from: I0Io, reason: collision with root package name */
    @OOXIXo
    public String f15780I0Io = "";

    /* renamed from: oxoX, reason: collision with root package name */
    @OOXIXo
    public String f15786oxoX = "\r\n";

    /* renamed from: X0o0xo, reason: collision with root package name */
    public boolean f15783X0o0xo = true;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    @OOXIXo
    public final oIX0oI f15782Oxx0IOOO = new oIX0oI();

    @Override // OO.I0Io
    @OOXIXo
    public String I0Io() {
        return this.f15780I0Io;
    }

    public final void II0XooXoX(@OOXIXo oOoXoXO<? super oIX0oI, oXIO0o0XI> init) {
        IIX0o.x0xO0oo(init, "init");
        init.invoke(Oxx0IOOO());
    }

    @Override // OO.I0Io
    @OOXIXo
    public String II0xO0() {
        return this.f15785oIX0oI;
    }

    public void OOXIXo(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.f15786oxoX = str;
    }

    @Override // OO.I0Io
    @OOXIXo
    public oIX0oI Oxx0IOOO() {
        return this.f15782Oxx0IOOO;
    }

    @Override // OO.I0Io
    public boolean X0o0xo() {
        return this.f15783X0o0xo;
    }

    @Override // OO.I0Io
    @OOXIXo
    public String XO() {
        return this.f15786oxoX;
    }

    @Override // OO.I0Io
    public char oIX0oI() {
        return this.f15781II0xO0;
    }

    public void oOoXoXO(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.f15780I0Io = str;
    }

    public void ooOOo0oXI(boolean z) {
        this.f15783X0o0xo = z;
    }

    @Override // OO.I0Io
    public boolean oxoX() {
        return this.f15784XO;
    }

    public void x0XOIxOo(boolean z) {
        this.f15784XO = z;
    }

    public void xoIox(char c) {
        this.f15781II0xO0 = c;
    }

    public void xxIXOIIO(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.f15785oIX0oI = str;
    }
}
