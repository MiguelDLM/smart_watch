package IxI;

import com.univocity.parsers.fixed.FieldAlignment;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes13.dex */
public class oOoXoXO extends com.univocity.parsers.common.XO<Oxx0IOOO> {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public final Map<String, XO> f1073IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public final Map<String, XO> f1074Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public boolean f1075Oxx0xo;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public FieldAlignment f1076oI0IIXIo;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public XO f1077x0xO0oo;

    public oOoXoXO(XO xo2) {
        this.f1074Oo = new HashMap();
        this.f1073IXxxXO = new HashMap();
        this.f1075Oxx0xo = true;
        this.f1076oI0IIXIo = null;
        xo0x(xo2);
        String[] ooOOo0oXI2 = xo2.ooOOo0oXI();
        if (ooOOo0oXI2 != null) {
            O0xOxO(ooOOo0oXI2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ooOOo0oXI[] I0oOoX() {
        return ooOOo0oXI.I0Io(this.f1074Oo, (Oxx0IOOO) xxIXOIIO());
    }

    public FieldAlignment[] Io() {
        XO xo2 = this.f1077x0xO0oo;
        if (xo2 == null) {
            return null;
        }
        return xo2.OOXIXo();
    }

    public FieldAlignment OI0() {
        return this.f1076oI0IIXIo;
    }

    @Override // com.univocity.parsers.common.X0o0xo
    /* renamed from: XOxIOxOx, reason: merged with bridge method [inline-methods] */
    public Oxx0IOOO I0Io() {
        return new Oxx0IOOO();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public char[] XX() {
        XO xo2 = this.f1077x0xO0oo;
        if (xo2 == null) {
            return null;
        }
        return xo2.oO((Oxx0IOOO) xxIXOIIO());
    }

    public boolean XoX() {
        return this.f1075Oxx0xo;
    }

    public int[] o0() {
        XO xo2 = this.f1077x0xO0oo;
        if (xo2 == null) {
            return null;
        }
        return xo2.oOoXoXO();
    }

    @Override // com.univocity.parsers.common.XO, com.univocity.parsers.common.X0o0xo
    public void oIX0oI(Map<String, Object> map) {
        super.oIX0oI(map);
        map.put("Field lengths", this.f1077x0xO0oo);
        map.put("Lookahead formats", this.f1074Oo);
        map.put("Lookbehind formats", this.f1073IXxxXO);
        map.put("Use default padding for headers", Boolean.valueOf(this.f1075Oxx0xo));
        map.put("Default alignment for headers", this.f1076oI0IIXIo);
    }

    public void oxXx0IX(FieldAlignment fieldAlignment) {
        this.f1076oI0IIXIo = fieldAlignment;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ooOOo0oXI[] oxxXoxO() {
        return ooOOo0oXI.I0Io(this.f1073IXxxXO, (Oxx0IOOO) xxIXOIIO());
    }

    @Override // com.univocity.parsers.common.X0o0xo
    public int x0XOIxOo() {
        int x0XOIxOo2 = super.x0XOIxOo();
        int length = ooOOo0oXI.oIX0oI(this.f1077x0xO0oo, this.f1074Oo, this.f1073IXxxXO).length;
        if (x0XOIxOo2 <= length) {
            return length;
        }
        return x0XOIxOo2;
    }

    public void x0o(String str, XO xo2) {
        ooOOo0oXI.XO(str, xo2, this.f1073IXxxXO);
    }

    public void xII(String str, XO xo2) {
        ooOOo0oXI.X0o0xo(str, xo2, this.f1074Oo);
    }

    public void xXOx(boolean z) {
        this.f1075Oxx0xo = z;
    }

    public final void xo0x(XO xo2) {
        if (xo2 != null) {
            this.f1077x0xO0oo = xo2;
            return;
        }
        throw new IllegalArgumentException("Field lengths cannot be null");
    }

    public oOoXoXO() {
        this.f1074Oo = new HashMap();
        this.f1073IXxxXO = new HashMap();
        this.f1075Oxx0xo = true;
        this.f1076oI0IIXIo = null;
        this.f1077x0xO0oo = null;
    }
}
