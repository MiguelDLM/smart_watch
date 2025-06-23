package oO0IXx;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes13.dex */
public class XIxXXX0x0 implements xxX {

    /* renamed from: II0xO0, reason: collision with root package name */
    public String[] f31911II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public List<String[]> f31912oIX0oI;

    public List<String[]> II0xO0() {
        List<String[]> list = this.f31912oIX0oI;
        if (list == null) {
            return Collections.emptyList();
        }
        return list;
    }

    @Override // oO0IXx.xxX
    public void XO(com.univocity.parsers.common.oO oOVar) {
        this.f31911II0xO0 = oOVar.X0o0xo();
    }

    public String[] oIX0oI() {
        return this.f31911II0xO0;
    }

    @Override // oO0IXx.xxX
    public void oO(com.univocity.parsers.common.oO oOVar) {
        this.f31912oIX0oI = new ArrayList(100);
    }

    @Override // oO0IXx.xxX
    public void x0XOIxOo(String[] strArr, com.univocity.parsers.common.oO oOVar) {
        this.f31912oIX0oI.add(strArr);
    }
}
