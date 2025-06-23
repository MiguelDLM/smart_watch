package com.univocity.parsers.common;

import com.univocity.parsers.common.OOXIXo;
import java.util.Map;
import oO0IXx.xXxxox0I;

/* loaded from: classes13.dex */
public abstract class XO<F extends OOXIXo> extends X0o0xo<F> {

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public xXxxox0I<?> f27062oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public Boolean f27063ooOOo0oXI = null;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public String f27064x0XOIxOo = "";

    /* renamed from: oO, reason: collision with root package name */
    public boolean f27061oO = false;

    public void IO(xXxxox0I<?> xxxxox0i) {
        this.f27062oOoXoXO = xxxxox0i;
    }

    public final boolean IoOoX() {
        Boolean bool = this.f27063ooOOo0oXI;
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    @Override // com.univocity.parsers.common.X0o0xo
    public void Oxx0xo() {
        boolean z;
        xXxxox0I<?> xxxxox0i = this.f27062oOoXoXO;
        if (xxxxox0i instanceof oO0IXx.II0XooXoX) {
            Class xxX2 = ((oO0IXx.II0XooXoX) xxxxox0i).xxX();
            OIxOX.X0o0xo XO2 = x0OOI.oIX0oI.XO(xxX2);
            String[] X0o0xo2 = x0OOI.oIX0oI.X0o0xo(xxX2);
            if (XO2 != null) {
                if (XO2.sequence().length > 0) {
                    X0o0xo2 = XO2.sequence();
                }
                z = XO2.write();
            } else {
                z = false;
            }
            if (this.f27063ooOOo0oXI == null) {
                this.f27063ooOOo0oXI = Boolean.valueOf(z);
            }
            if (xoIox() == null && X0o0xo2.length > 0) {
                O0xOxO(X0o0xo2);
            }
        }
    }

    public final void X00IoxXI(boolean z) {
        this.f27063ooOOo0oXI = Boolean.valueOf(z);
    }

    public final void Xx000oIo(boolean z) {
        this.f27061oO = z;
    }

    @Override // com.univocity.parsers.common.X0o0xo
    public void oIX0oI(Map<String, Object> map) {
        String name;
        super.oIX0oI(map);
        map.put("Empty value", this.f27064x0XOIxOo);
        map.put("Header writing enabled", this.f27063ooOOo0oXI);
        xXxxox0I<?> xxxxox0i = this.f27062oOoXoXO;
        if (xxxxox0i == null) {
            name = "none";
        } else {
            name = xxxxox0i.getClass().getName();
        }
        map.put("Row processor", name);
    }

    public void oOXoIIIo(String str) {
        this.f27064x0XOIxOo = str;
    }

    public xXxxox0I<?> oo() {
        return this.f27062oOoXoXO;
    }

    public final boolean oo0xXOI0I() {
        return this.f27061oO;
    }

    public String xI() {
        return this.f27064x0XOIxOo;
    }
}
