package IxI;

import com.univocity.parsers.common.oxoX;
import com.univocity.parsers.fixed.FieldAlignment;
import java.util.HashMap;
import java.util.Map;
import x0oox0.II0xO0;

/* loaded from: classes13.dex */
public class xxIXOIIO extends oxoX<Oxx0IOOO> {

    /* renamed from: IIXOooo, reason: collision with root package name */
    public boolean f1083IIXOooo;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public final Map<String, XO> f1084O0xOxO;

    /* renamed from: OxI, reason: collision with root package name */
    public final Map<String, XO> f1085OxI;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public boolean f1086OxxIIOOXO;

    /* renamed from: o00, reason: collision with root package name */
    public final XO f1087o00;

    /* renamed from: xoXoI, reason: collision with root package name */
    public boolean f1088xoXoI;

    public xxIXOIIO(XO xo2) {
        this.f1086OxxIIOOXO = false;
        this.f1083IIXOooo = false;
        this.f1088xoXoI = true;
        this.f1085OxI = new HashMap();
        this.f1084O0xOxO = new HashMap();
        if (xo2 != null) {
            this.f1087o00 = xo2;
            String[] ooOOo0oXI2 = xo2.ooOOo0oXI();
            if (ooOOo0oXI2 != null) {
                O0xOxO(ooOOo0oXI2);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Field lengths cannot be null");
    }

    public void I0X0x0oIo(String str, XO xo2) {
        ooOOo0oXI.XO(str, xo2, this.f1084O0xOxO);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public char[] I0oOIX() {
        XO xo2 = this.f1087o00;
        if (xo2 == null) {
            return null;
        }
        return xo2.oO((Oxx0IOOO) xxIXOIIO());
    }

    public boolean IoOoo() {
        return this.f1083IIXOooo;
    }

    public void Ioxxx(boolean z) {
        this.f1088xoXoI = z;
    }

    public int[] O0Xx() {
        XO xo2 = this.f1087o00;
        if (xo2 == null) {
            return null;
        }
        return xo2.oOoXoXO();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ooOOo0oXI[] OO() {
        return ooOOo0oXI.I0Io(this.f1084O0xOxO, (Oxx0IOOO) xxIXOIIO());
    }

    public void OO0x0xX(boolean z) {
        this.f1083IIXOooo = z;
    }

    public void XIo0oOXIx(boolean z) {
        this.f1086OxxIIOOXO = z;
    }

    public void XX0(String str, XO xo2) {
        ooOOo0oXI.X0o0xo(str, xo2, this.f1085OxI);
    }

    @Override // com.univocity.parsers.common.X0o0xo
    /* renamed from: Xo0, reason: merged with bridge method [inline-methods] */
    public Oxx0IOOO I0Io() {
        return new Oxx0IOOO();
    }

    public FieldAlignment[] XoI0Ixx0() {
        XO xo2 = this.f1087o00;
        if (xo2 == null) {
            return null;
        }
        return xo2.OOXIXo();
    }

    @Override // com.univocity.parsers.common.oxoX, com.univocity.parsers.common.X0o0xo
    public void oIX0oI(Map<String, Object> map) {
        String xo2;
        super.oIX0oI(map);
        map.put("Skip trailing characters until new line", Boolean.valueOf(this.f1086OxxIIOOXO));
        map.put("Record ends on new line", Boolean.valueOf(this.f1083IIXOooo));
        XO xo3 = this.f1087o00;
        if (xo3 == null) {
            xo2 = "<null>";
        } else {
            xo2 = xo3.toString();
        }
        map.put("Field lengths", xo2);
        map.put("Lookahead formats", this.f1085OxI);
        map.put("Lookbehind formats", this.f1084O0xOxO);
    }

    public final int[] oX() {
        return ooOOo0oXI.oIX0oI(this.f1087o00, this.f1085OxI, this.f1084O0xOxO);
    }

    @Override // com.univocity.parsers.common.X0o0xo
    public int ooOOo0oXI() {
        int ooOOo0oXI2 = super.ooOOo0oXI();
        int i = 0;
        for (int i2 : oX()) {
            i += i2 + 2;
        }
        if (ooOOo0oXI2 <= i) {
            return i;
        }
        return ooOOo0oXI2;
    }

    @Override // com.univocity.parsers.common.X0o0xo
    public int x0XOIxOo() {
        int x0XOIxOo2 = super.x0XOIxOo();
        int length = oX().length;
        if (x0XOIxOo2 <= length) {
            return length;
        }
        return x0XOIxOo2;
    }

    @Override // com.univocity.parsers.common.oxoX
    public II0xO0 x0o() {
        return new x0oox0.oxoX(ooOOo0oXI(), oO());
    }

    public boolean x0xO() {
        return this.f1088xoXoI;
    }

    public boolean xoIxX() {
        return this.f1086OxxIIOOXO;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ooOOo0oXI[] xoxXI() {
        return ooOOo0oXI.I0Io(this.f1085OxI, (Oxx0IOOO) xxIXOIIO());
    }

    public xxIXOIIO() {
        this.f1086OxxIIOOXO = false;
        this.f1083IIXOooo = false;
        this.f1088xoXoI = true;
        this.f1085OxI = new HashMap();
        this.f1084O0xOxO = new HashMap();
        this.f1087o00 = null;
    }
}
