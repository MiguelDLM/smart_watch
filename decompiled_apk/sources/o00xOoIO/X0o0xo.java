package o00xOoIO;

import com.univocity.parsers.csv.UnescapedQuoteHandling;
import java.util.Map;

/* loaded from: classes13.dex */
public class X0o0xo extends com.univocity.parsers.common.oxoX<II0xO0> {

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public String f31062OxxIIOOXO = null;

    /* renamed from: IIXOooo, reason: collision with root package name */
    public boolean f31059IIXOooo = true;

    /* renamed from: xoXoI, reason: collision with root package name */
    public boolean f31067xoXoI = true;

    /* renamed from: o00, reason: collision with root package name */
    public boolean f31066o00 = false;

    /* renamed from: OxI, reason: collision with root package name */
    public boolean f31061OxI = false;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public boolean f31060O0xOxO = true;

    /* renamed from: X0IIOO, reason: collision with root package name */
    public boolean f31063X0IIOO = false;

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public boolean f31064XI0IXoo = false;

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    public UnescapedQuoteHandling f31065XIxXXX0x0 = null;

    public final void I0X0x0oIo() {
        x0xO(true);
        O00XxXI(true);
        oxxXoxO(true);
    }

    public final boolean I0oOIX() {
        return this.f31061OxI;
    }

    @Deprecated
    public boolean IoOoo() {
        UnescapedQuoteHandling unescapedQuoteHandling;
        if ((!this.f31067xoXoI || !OO()) && (unescapedQuoteHandling = this.f31065XIxXXX0x0) != UnescapedQuoteHandling.STOP_AT_DELIMITER && unescapedQuoteHandling != UnescapedQuoteHandling.SKIP_VALUE) {
            return false;
        }
        return true;
    }

    public final void Ioxxx(boolean z) {
        this.f31061OxI = z;
    }

    public final void O00XxXI(boolean z) {
        this.f31064XI0IXoo = z;
    }

    public boolean O0Xx() {
        return this.f31066o00;
    }

    @Deprecated
    public boolean OO() {
        UnescapedQuoteHandling unescapedQuoteHandling;
        if (!this.f31059IIXOooo && ((unescapedQuoteHandling = this.f31065XIxXXX0x0) == null || unescapedQuoteHandling == UnescapedQuoteHandling.RAISE_ERROR)) {
            return false;
        }
        return true;
    }

    public void OO0x0xX(String str) {
        this.f31062OxxIIOOXO = str;
    }

    public void XIo0oOXIx(boolean z) {
        this.f31066o00 = z;
    }

    @Override // com.univocity.parsers.common.X0o0xo
    /* renamed from: XX0, reason: merged with bridge method [inline-methods] */
    public II0xO0 I0Io() {
        return new II0xO0();
    }

    @Deprecated
    public void XX0xXo(boolean z) {
        this.f31059IIXOooo = z;
    }

    public UnescapedQuoteHandling Xo0() {
        return this.f31065XIxXXX0x0;
    }

    public final boolean XoI0Ixx0() {
        return this.f31063X0IIOO;
    }

    @Deprecated
    public void o0xxxXXxX(boolean z) {
        if (z) {
            this.f31059IIXOooo = true;
        }
        this.f31067xoXoI = z;
    }

    @Override // com.univocity.parsers.common.oxoX, com.univocity.parsers.common.X0o0xo
    public void oIX0oI(Map<String, Object> map) {
        super.oIX0oI(map);
        map.put("Empty value", this.f31062OxxIIOOXO);
        map.put("Unescaped quote handling", this.f31065XIxXXX0x0);
        map.put("Escape unquoted values", Boolean.valueOf(this.f31066o00));
        map.put("Keep escape sequences", Boolean.valueOf(this.f31061OxI));
        map.put("Normalize escaped line separators", Boolean.valueOf(this.f31060O0xOxO));
        map.put("Autodetect column delimiter", Boolean.valueOf(this.f31063X0IIOO));
        map.put("Autodetect quotes", Boolean.valueOf(this.f31064XI0IXoo));
    }

    public String oX() {
        return this.f31062OxxIIOOXO;
    }

    public void ox(UnescapedQuoteHandling unescapedQuoteHandling) {
        this.f31065XIxXXX0x0 = unescapedQuoteHandling;
    }

    @Override // com.univocity.parsers.common.oxoX
    public x0oox0.II0xO0 x0o() {
        return new x0oox0.oxoX(ooOOo0oXI(), this.f31062OxxIIOOXO);
    }

    public final void x0xO(boolean z) {
        this.f31063X0IIOO = z;
    }

    public final boolean xoIxX() {
        return this.f31064XI0IXoo;
    }

    public boolean xoxXI() {
        return this.f31060O0xOxO;
    }

    public void xxIO(boolean z) {
        this.f31060O0xOxO = z;
    }
}
