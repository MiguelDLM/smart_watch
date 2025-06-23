package oO0IXx;

import java.util.List;
import java.util.Map;

/* loaded from: classes13.dex */
public abstract class II0xO0 implements xxX, I0Io<String> {

    /* renamed from: I0Io, reason: collision with root package name */
    public int f31872I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public final int f31873II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final oOoXoXO<String> f31874oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public int f31875oxoX;

    public II0xO0(int i) {
        this.f31874oIX0oI = new oOoXoXO<>(i);
        this.f31873II0xO0 = i;
    }

    @Override // oO0IXx.OOXIXo
    public final Map<String, List<String>> I0Io() {
        return this.f31874oIX0oI.Oxx0IOOO();
    }

    @Override // oO0IXx.OOXIXo
    public List<String> II0XooXoX(String str) {
        return this.f31874oIX0oI.X0o0xo(str, String.class);
    }

    @Override // oO0IXx.OOXIXo
    public List<String> II0xO0(int i) {
        return this.f31874oIX0oI.oxoX(i, String.class);
    }

    @Override // oO0IXx.OOXIXo
    public final void IXxxXO(Map<String, List<String>> map) {
        this.f31874oIX0oI.oOoXoXO(map);
    }

    @Override // oO0IXx.OOXIXo
    public final void OOXIXo(Map<Integer, List<String>> map) {
        this.f31874oIX0oI.OOXIXo(map);
    }

    @Override // oO0IXx.OOXIXo
    public final Map<Integer, List<String>> Oo() {
        return this.f31874oIX0oI.XO();
    }

    @Override // oO0IXx.I0Io
    public int Oxx0IOOO() {
        return this.f31875oxoX;
    }

    @Override // oO0IXx.xxX
    public void XO(com.univocity.parsers.common.oO oOVar) {
        int i = this.f31872I0Io;
        if (i > 0) {
            ooOOo0oXI(i);
        }
    }

    @Override // oO0IXx.OOXIXo
    public final String[] getHeaders() {
        return this.f31874oIX0oI.xxIXOIIO();
    }

    @Override // oO0IXx.xxX
    public void oO(com.univocity.parsers.common.oO oOVar) {
        this.f31874oIX0oI.ooOOo0oXI();
        this.f31872I0Io = 0;
        this.f31875oxoX = 0;
    }

    @Override // oO0IXx.I0Io
    public abstract void ooOOo0oXI(int i);

    @Override // oO0IXx.xxX
    public void x0XOIxOo(String[] strArr, com.univocity.parsers.common.oO oOVar) {
        this.f31874oIX0oI.oIX0oI(strArr, oOVar);
        int i = this.f31872I0Io + 1;
        this.f31872I0Io = i;
        if (i >= this.f31873II0xO0) {
            ooOOo0oXI(i);
            this.f31872I0Io = 0;
            this.f31874oIX0oI.II0xO0();
            this.f31875oxoX++;
        }
    }

    @Override // oO0IXx.I0Io
    public int xoIox() {
        return this.f31873II0xO0;
    }

    @Override // oO0IXx.OOXIXo
    public final List<List<String>> xxIXOIIO() {
        return this.f31874oIX0oI.I0Io();
    }
}
