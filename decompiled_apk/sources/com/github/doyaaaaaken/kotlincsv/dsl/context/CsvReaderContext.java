package com.github.doyaaaaaken.kotlincsv.dsl.context;

import IoOoo.II0xO0;
import OXOo.OOXIXo;
import com.github.doyaaaaaken.kotlincsv.util.logger.LoggerNop;
import kotlin.jvm.internal.IIX0o;
import xoIxX.oIX0oI;

@II0xO0
/* loaded from: classes9.dex */
public final class CsvReaderContext implements OO.II0xO0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public boolean f15771II0XooXoX;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public boolean f15773Oxx0IOOO;

    /* renamed from: XO, reason: collision with root package name */
    public boolean f15775XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OOXIXo
    public oIX0oI f15776oIX0oI = LoggerNop.f15798oIX0oI;

    /* renamed from: II0xO0, reason: collision with root package name */
    @OOXIXo
    public String f15772II0xO0 = "UTF-8";

    /* renamed from: I0Io, reason: collision with root package name */
    public char f15770I0Io = '\"';

    /* renamed from: oxoX, reason: collision with root package name */
    public char f15777oxoX = ',';

    /* renamed from: X0o0xo, reason: collision with root package name */
    public char f15774X0o0xo = '\"';

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    @OOXIXo
    public InsufficientFieldsRowBehaviour f15779xxIXOIIO = InsufficientFieldsRowBehaviour.ERROR;

    /* renamed from: xoIox, reason: collision with root package name */
    @OOXIXo
    public ExcessFieldsRowBehaviour f15778xoIox = ExcessFieldsRowBehaviour.ERROR;

    @Override // OO.II0xO0
    public boolean I0Io() {
        return this.f15775XO;
    }

    @Override // OO.II0xO0
    @OOXIXo
    public InsufficientFieldsRowBehaviour II0XooXoX() {
        return this.f15779xxIXOIIO;
    }

    @Override // OO.II0xO0
    @OOXIXo
    public String II0xO0() {
        return this.f15772II0xO0;
    }

    public void IXxxXO(boolean z) {
        this.f15775XO = z;
    }

    public void OOXIXo(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.f15772II0xO0 = str;
    }

    public void Oo(char c) {
        this.f15770I0Io = c;
    }

    @Override // OO.II0xO0
    public char Oxx0IOOO() {
        return this.f15774X0o0xo;
    }

    public void Oxx0xo(boolean z) {
        this.f15773Oxx0IOOO = z;
    }

    @Override // OO.II0xO0
    @OOXIXo
    public ExcessFieldsRowBehaviour X0o0xo() {
        return this.f15778xoIox;
    }

    @Override // OO.II0xO0
    public boolean XO() {
        return this.f15771II0XooXoX;
    }

    @Override // OO.II0xO0
    @OOXIXo
    public oIX0oI getLogger() {
        return this.f15776oIX0oI;
    }

    @Override // OO.II0xO0
    public char oIX0oI() {
        return this.f15777oxoX;
    }

    public void oO(@OOXIXo InsufficientFieldsRowBehaviour insufficientFieldsRowBehaviour) {
        IIX0o.x0xO0oo(insufficientFieldsRowBehaviour, "<set-?>");
        this.f15779xxIXOIIO = insufficientFieldsRowBehaviour;
    }

    public void oOoXoXO(char c) {
        this.f15777oxoX = c;
    }

    public void ooOOo0oXI(char c) {
        this.f15774X0o0xo = c;
    }

    @Override // OO.II0xO0
    public boolean oxoX() {
        return this.f15773Oxx0IOOO;
    }

    public void x0XOIxOo(@OOXIXo ExcessFieldsRowBehaviour excessFieldsRowBehaviour) {
        IIX0o.x0xO0oo(excessFieldsRowBehaviour, "<set-?>");
        this.f15778xoIox = excessFieldsRowBehaviour;
    }

    public void x0xO0oo(@OOXIXo oIX0oI oix0oi) {
        IIX0o.x0xO0oo(oix0oi, "<set-?>");
        this.f15776oIX0oI = oix0oi;
    }

    public void xoIox(boolean z) {
        this.f15771II0XooXoX = z;
    }

    @Override // OO.II0xO0
    public char xxIXOIIO() {
        return this.f15770I0Io;
    }
}
