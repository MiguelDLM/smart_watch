package oO0IXx;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes13.dex */
public class OxI extends O0xOxO {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public List<Object[]> f31883II0XooXoX;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public String[] f31884xxIXOIIO;

    @Override // oO0IXx.O0xOxO
    public void O0xOxO(Object[] objArr, com.univocity.parsers.common.oO oOVar) {
        this.f31883II0XooXoX.add(objArr);
    }

    public List<Object[]> X0IIOO() {
        List<Object[]> list = this.f31883II0XooXoX;
        if (list == null) {
            return Collections.emptyList();
        }
        return list;
    }

    @Override // oO0IXx.O0xOxO, oO0IXx.xxX
    public void XO(com.univocity.parsers.common.oO oOVar) {
        super.XO(oOVar);
        this.f31884xxIXOIIO = oOVar.X0o0xo();
    }

    public String[] getHeaders() {
        return this.f31884xxIXOIIO;
    }

    @Override // oO0IXx.O0xOxO, oO0IXx.xxX
    public void oO(com.univocity.parsers.common.oO oOVar) {
        super.oO(oOVar);
        this.f31883II0XooXoX = new ArrayList(100);
    }
}
