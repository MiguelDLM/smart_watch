package oO0IXx;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes13.dex */
public class XO<T> extends Oxx0IOOO<T> {

    /* renamed from: Oo, reason: collision with root package name */
    public String[] f31913Oo;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public List<T> f31914x0xO0oo;

    public XO(Class<T> cls) {
        super(cls);
    }

    @Override // oO0IXx.Oxx0IOOO, oO0IXx.xxX
    public void XO(com.univocity.parsers.common.oO oOVar) {
        this.f31913Oo = oOVar.X0o0xo();
        super.XO(oOVar);
    }

    public String[] getHeaders() {
        return this.f31913Oo;
    }

    @Override // oO0IXx.Oxx0IOOO, oO0IXx.xxX
    public void oO(com.univocity.parsers.common.oO oOVar) {
        super.oO(oOVar);
        this.f31914x0xO0oo = new ArrayList();
    }

    public List<T> x0o() {
        List<T> list = this.f31914x0xO0oo;
        if (list == null) {
            return Collections.emptyList();
        }
        return list;
    }

    @Override // oO0IXx.Oxx0IOOO
    public void xII(T t, com.univocity.parsers.common.oO oOVar) {
        this.f31914x0xO0oo.add(t);
    }
}
