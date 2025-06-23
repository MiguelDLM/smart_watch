package oO0IXx;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes13.dex */
public abstract class IIXOooo extends OxxIIOOXO {

    /* renamed from: I0Io, reason: collision with root package name */
    public final HashMap<Class<?>, Object> f31878I0Io;

    /* renamed from: oxoX, reason: collision with root package name */
    public long f31879oxoX;

    public IIXOooo(Class... clsArr) {
        super(clsArr);
        this.f31878I0Io = new HashMap<>();
        this.f31879oxoX = -1L;
    }

    public final void II0XooXoX(com.univocity.parsers.common.oO oOVar) {
        if (!this.f31878I0Io.isEmpty()) {
            Oxx0IOOO(this.f31878I0Io, oOVar);
            this.f31878I0Io.clear();
        }
    }

    @Override // oO0IXx.OxxIIOOXO
    public final void II0xO0(Class<?> cls, Object obj, com.univocity.parsers.common.oO oOVar) {
        if (this.f31879oxoX != oOVar.xoIox() && this.f31879oxoX != -1) {
            II0XooXoX(oOVar);
        }
        this.f31879oxoX = oOVar.xoIox();
        this.f31878I0Io.put(cls, obj);
    }

    public abstract void Oxx0IOOO(Map<Class<?>, Object> map, com.univocity.parsers.common.oO oOVar);

    @Override // oO0IXx.OxxIIOOXO, oO0IXx.xxX
    public void XO(com.univocity.parsers.common.oO oOVar) {
        II0XooXoX(oOVar);
        super.XO(oOVar);
    }

    @Override // oO0IXx.OxxIIOOXO, oO0IXx.xxX
    public void oO(com.univocity.parsers.common.oO oOVar) {
        this.f31879oxoX = -1L;
        this.f31878I0Io.clear();
        super.oO(oOVar);
    }
}
