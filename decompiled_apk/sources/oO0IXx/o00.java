package oO0IXx;

import java.util.List;
import java.util.Map;

/* loaded from: classes13.dex */
public class o00 extends O0xOxO implements OOXIXo<Object> {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public final oOoXoXO<Object> f31922II0XooXoX;

    public o00() {
        this(1000);
    }

    @Override // oO0IXx.OOXIXo
    public final Map<String, List<Object>> I0Io() {
        return this.f31922II0XooXoX.Oxx0IOOO();
    }

    @Override // oO0IXx.OOXIXo
    public List<Object> II0XooXoX(String str) {
        return this.f31922II0XooXoX.X0o0xo(str, Object.class);
    }

    @Override // oO0IXx.OOXIXo
    public List<Object> II0xO0(int i) {
        return this.f31922II0XooXoX.oxoX(i, Object.class);
    }

    @Override // oO0IXx.OOXIXo
    public final void IXxxXO(Map<String, List<Object>> map) {
        this.f31922II0XooXoX.oOoXoXO(map);
    }

    @Override // oO0IXx.O0xOxO
    public void O0xOxO(Object[] objArr, com.univocity.parsers.common.oO oOVar) {
        this.f31922II0XooXoX.oIX0oI(objArr, oOVar);
    }

    @Override // oO0IXx.OOXIXo
    public final void OOXIXo(Map<Integer, List<Object>> map) {
        this.f31922II0XooXoX.OOXIXo(map);
    }

    @Override // oO0IXx.OOXIXo
    public final Map<Integer, List<Object>> Oo() {
        return this.f31922II0XooXoX.XO();
    }

    public <V> List<V> X0IIOO(int i, Class<V> cls) {
        return this.f31922II0XooXoX.oxoX(i, cls);
    }

    public <V> List<V> XI0IXoo(String str, Class<V> cls) {
        return this.f31922II0XooXoX.X0o0xo(str, cls);
    }

    @Override // oO0IXx.OOXIXo
    public final String[] getHeaders() {
        return this.f31922II0XooXoX.xxIXOIIO();
    }

    @Override // oO0IXx.O0xOxO, oO0IXx.xxX
    public void oO(com.univocity.parsers.common.oO oOVar) {
        super.oO(oOVar);
        this.f31922II0XooXoX.ooOOo0oXI();
    }

    @Override // oO0IXx.OOXIXo
    public final List<List<Object>> xxIXOIIO() {
        return this.f31922II0XooXoX.I0Io();
    }

    public o00(int i) {
        this.f31922II0XooXoX = new oOoXoXO<>(i);
    }
}
