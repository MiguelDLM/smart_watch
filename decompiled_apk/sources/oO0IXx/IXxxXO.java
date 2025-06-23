package oO0IXx;

import com.univocity.parsers.common.processor.RowPlacement;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes13.dex */
public abstract class IXxxXO extends O0xOxO {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public final OxI f31880II0XooXoX;

    /* renamed from: xoIox, reason: collision with root package name */
    public final boolean f31881xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public Oxx0xo f31882xxIXOIIO;

    public IXxxXO(RowPlacement rowPlacement, OxI oxI) {
        com.univocity.parsers.common.I0Io.x0xO0oo("Row processor for reading detail rows", oxI);
        this.f31880II0XooXoX = oxI;
        this.f31881xoIox = rowPlacement == RowPlacement.TOP;
    }

    @Override // oO0IXx.O0xOxO
    public final void O0xOxO(Object[] objArr, com.univocity.parsers.common.oO oOVar) {
        if (this.f31882xxIXOIIO == null) {
            Oxx0xo oxx0xo = new Oxx0xo();
            this.f31882xxIXOIIO = oxx0xo;
            oxx0xo.XO(objArr);
            if (this.f31881xoIox) {
                return;
            }
        }
        XIxXXX0x0(objArr, oOVar);
    }

    public abstract boolean X0IIOO(String[] strArr, com.univocity.parsers.common.oO oOVar);

    public abstract void XI0IXoo(Oxx0xo oxx0xo, com.univocity.parsers.common.oO oOVar);

    public final void XIxXXX0x0(Object[] objArr, com.univocity.parsers.common.oO oOVar) {
        List<Object[]> X0IIOO2 = this.f31880II0XooXoX.X0IIOO();
        this.f31882xxIXOIIO.X0o0xo(new ArrayList(X0IIOO2));
        if (!this.f31881xoIox) {
            this.f31882xxIXOIIO.XO(objArr);
        }
        if (this.f31882xxIXOIIO.oxoX() != null) {
            XI0IXoo(this.f31882xxIXOIIO.clone(), oOVar);
            this.f31882xxIXOIIO.oIX0oI();
        }
        X0IIOO2.clear();
        if (this.f31881xoIox) {
            this.f31882xxIXOIIO.XO(objArr);
        }
    }

    @Override // oO0IXx.O0xOxO, oO0IXx.xxX
    public void XO(com.univocity.parsers.common.oO oOVar) {
        super.XO(oOVar);
        this.f31880II0XooXoX.XO(oOVar);
        if (this.f31881xoIox) {
            XIxXXX0x0(null, oOVar);
        }
    }

    @Override // oO0IXx.O0xOxO, oO0IXx.xxX
    public void oO(com.univocity.parsers.common.oO oOVar) {
        this.f31880II0XooXoX.oO(oOVar);
    }

    @Override // oO0IXx.O0xOxO, oO0IXx.xxX
    public final void x0XOIxOo(String[] strArr, com.univocity.parsers.common.oO oOVar) {
        if (X0IIOO(strArr, oOVar)) {
            super.x0XOIxOo(strArr, oOVar);
        } else {
            if (this.f31881xoIox && this.f31882xxIXOIIO == null) {
                return;
            }
            this.f31880II0XooXoX.x0XOIxOo(strArr, oOVar);
        }
    }

    public IXxxXO(OxI oxI) {
        this(RowPlacement.TOP, oxI);
    }
}
