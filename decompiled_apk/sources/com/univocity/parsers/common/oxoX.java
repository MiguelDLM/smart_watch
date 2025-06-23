package com.univocity.parsers.common;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.univocity.parsers.common.OOXIXo;
import java.util.Map;
import oO0IXx.xoXoI;
import oO0IXx.xxX;

/* loaded from: classes13.dex */
public abstract class oxoX<F extends OOXIXo> extends X0o0xo<F> {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public boolean f27085IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public long f27086Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public long f27087Oxx0xo;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public boolean f27088oI0IIXIo;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public xxX f27091ooOOo0oXI;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public boolean f27093x0xO0oo;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public Boolean f27090oOoXoXO = null;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public boolean f27092x0XOIxOo = true;

    /* renamed from: oO, reason: collision with root package name */
    public int f27089oO = 1048576;

    public oxoX() {
        this.f27093x0xO0oo = Runtime.getRuntime().availableProcessors() > 1;
        this.f27086Oo = -1L;
        this.f27085IXxxXO = false;
        this.f27087Oxx0xo = 0L;
        this.f27088oI0IIXIo = false;
    }

    public void I0oOoX(int i) {
        this.f27089oO = i;
    }

    @Override // com.univocity.parsers.common.X0o0xo
    public OXIOoo0X0.OOXIXo<?> II0XooXoX() {
        if (OI0()) {
            return null;
        }
        return super.II0XooXoX();
    }

    public boolean IO() {
        Boolean bool = this.f27090oOoXoXO;
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public void Io(boolean z) {
        if (z && OI0()) {
            throw new IllegalArgumentException("Cannot reorder columns when using a row processor that manipulates nested rows.");
        }
        this.f27092x0XOIxOo = z;
    }

    public boolean IoOoX() {
        return this.f27093x0xO0oo;
    }

    public final boolean OI0() {
        xxX xxx2 = this.f27091ooOOo0oXI;
        if (xxx2 instanceof oO0IXx.xxIXOIIO) {
            return ((oO0IXx.xxIXOIIO) xxx2).oIX0oI();
        }
        return false;
    }

    @Override // com.univocity.parsers.common.X0o0xo
    public OXIOoo0X0.xoIox Oxx0IOOO() {
        if (OI0()) {
            return null;
        }
        return super.Oxx0IOOO();
    }

    @Override // com.univocity.parsers.common.X0o0xo
    public void Oxx0xo() {
        xxX xxx2 = this.f27091ooOOo0oXI;
        if (xxx2 instanceof oO0IXx.Oxx0IOOO) {
            Class xxX2 = ((oO0IXx.Oxx0IOOO) xxx2).xxX();
            OIxOX.X0o0xo XO2 = x0OOI.oIX0oI.XO(xxX2);
            String[] strArr = I0Io.f27012oIX0oI;
            boolean oIX0oI2 = x0OOI.oIX0oI.oIX0oI(xxX2);
            boolean z = !oIX0oI2;
            if (XO2 != null) {
                if (XO2.sequence().length > 0) {
                    strArr = XO2.sequence();
                }
                z = XO2.extract();
            }
            if (this.f27090oOoXoXO == null) {
                XX(z);
            }
            if (xoIox() == null && strArr.length > 0 && !this.f27090oOoXoXO.booleanValue()) {
                O0xOxO(strArr);
            }
            if (II0XooXoX() == null) {
                if (oIX0oI2) {
                    IIXOooo(x0OOI.oIX0oI.x0xO0oo(xxX2));
                } else if (strArr.length > 0 && x0OOI.oIX0oI.I0Io(xxX2)) {
                    OxxIIOOXO(strArr);
                }
            }
        }
    }

    public boolean X00IoxXI() {
        return this.f27088oI0IIXIo;
    }

    public x0oox0.I0Io XOxIOxOx() {
        if (this.f27093x0xO0oo) {
            if (this.f27085IXxxXO) {
                return new I00O.II0xO0(xxIXOIIO().Oxx0IOOO(), xI(), 10);
            }
            return new I00O.II0xO0(xxIXOIIO().X0o0xo(), xxIXOIIO().Oxx0IOOO(), xI(), 10);
        }
        if (this.f27085IXxxXO) {
            return new x0oox0.X0o0xo(xxIXOIIO().Oxx0IOOO(), xI());
        }
        return new x0oox0.X0o0xo(xxIXOIIO().X0o0xo(), xxIXOIIO().Oxx0IOOO(), xI());
    }

    public void XX(boolean z) {
        this.f27090oOoXoXO = Boolean.valueOf(z);
    }

    public void XoX(long j) {
        this.f27086Oo = j;
    }

    public boolean Xx000oIo() {
        if (!OI0() && this.f27092x0XOIxOo) {
            return true;
        }
        return false;
    }

    public void o0(boolean z) {
        this.f27088oI0IIXIo = z;
    }

    @Override // com.univocity.parsers.common.X0o0xo
    public void oIX0oI(Map<String, Object> map) {
        String name;
        Object valueOf;
        super.oIX0oI(map);
        map.put("Header extraction enabled", this.f27090oOoXoXO);
        xxX xxx2 = this.f27091ooOOo0oXI;
        if (xxx2 == null) {
            name = "none";
        } else {
            name = xxx2.getClass().getName();
        }
        map.put("Row processor", name);
        map.put("Column reordering enabled", Boolean.valueOf(this.f27092x0XOIxOo));
        map.put("Input buffer size", Integer.valueOf(this.f27089oO));
        map.put("Input reading on separate thread", Boolean.valueOf(this.f27093x0xO0oo));
        long j = this.f27086Oo;
        if (j == -1) {
            valueOf = TtmlNode.COMBINE_ALL;
        } else {
            valueOf = Long.valueOf(j);
        }
        map.put("Number of records to read", valueOf);
        map.put("Line separator detection enabled", Boolean.valueOf(this.f27085IXxxXO));
    }

    public xxX oOXoIIIo() {
        xxX xxx2 = this.f27091ooOOo0oXI;
        if (xxx2 == null) {
            return xoXoI.f31964oIX0oI;
        }
        return xxx2;
    }

    public final long oo() {
        return this.f27087Oxx0xo;
    }

    public long oo0xXOI0I() {
        return this.f27086Oo;
    }

    public final void oxXx0IX(long j) {
        if (j >= 0) {
            this.f27087Oxx0xo = j;
            return;
        }
        throw new IllegalArgumentException("Number of rows to skip from the input must be 0 or greater");
    }

    public final void oxxXoxO(boolean z) {
        this.f27085IXxxXO = z;
    }

    public x0oox0.II0xO0 x0o() {
        return new x0oox0.oxoX(ooOOo0oXI(), oO());
    }

    public int xI() {
        return this.f27089oO;
    }

    public final boolean xII() {
        return this.f27085IXxxXO;
    }

    public void xXOx(xxX xxx2) {
        this.f27091ooOOo0oXI = xxx2;
    }

    public void xo0x(boolean z) {
        this.f27093x0xO0oo = z;
    }
}
