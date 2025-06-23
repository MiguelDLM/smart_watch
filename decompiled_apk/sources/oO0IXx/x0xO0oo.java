package oO0IXx;

import com.univocity.parsers.common.processor.RowPlacement;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes13.dex */
public abstract class x0xO0oo extends IXxxXO {

    /* renamed from: OOXIXo, reason: collision with root package name */
    public final List<Oxx0xo> f31961OOXIXo;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public String[] f31962oOoXoXO;

    public x0xO0oo(RowPlacement rowPlacement, OxI oxI) {
        super(rowPlacement, oxI);
        this.f31961OOXIXo = new ArrayList();
    }

    @Override // oO0IXx.IXxxXO
    public void XI0IXoo(Oxx0xo oxx0xo, com.univocity.parsers.common.oO oOVar) {
        this.f31961OOXIXo.add(oxx0xo);
    }

    @Override // oO0IXx.IXxxXO, oO0IXx.O0xOxO, oO0IXx.xxX
    public void XO(com.univocity.parsers.common.oO oOVar) {
        this.f31962oOoXoXO = oOVar.X0o0xo();
        super.XO(oOVar);
    }

    public String[] getHeaders() {
        return this.f31962oOoXoXO;
    }

    public List<Oxx0xo> xxX() {
        return this.f31961OOXIXo;
    }

    public x0xO0oo(OxI oxI) {
        super(oxI);
        this.f31961OOXIXo = new ArrayList();
    }
}
