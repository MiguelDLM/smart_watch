package O0Xx;

import com.garmin.fit.Fit;
import com.garmin.fit.Profile;
import com.garmin.fit.X0xII0I;
import com.garmin.fit.XOxxooXI;
import java.io.ByteArrayOutputStream;

/* loaded from: classes9.dex */
public class xoIox {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public II0XooXoX f1461oIX0oI;

    /* renamed from: II0xO0, reason: collision with root package name */
    public boolean f1457II0xO0 = false;

    /* renamed from: I0Io, reason: collision with root package name */
    public boolean f1455I0Io = false;

    /* renamed from: oxoX, reason: collision with root package name */
    public boolean f1462oxoX = false;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public boolean f1459X0o0xo = false;

    /* renamed from: XO, reason: collision with root package name */
    public boolean f1460XO = false;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public boolean f1458Oxx0IOOO = false;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public boolean f1456II0XooXoX = false;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public boolean f1463xxIXOIIO = false;

    public xoIox(ByteArrayOutputStream byteArrayOutputStream) {
        this.f1461oIX0oI = new II0XooXoX(byteArrayOutputStream);
    }

    public void II0XooXoX(boolean z) {
        this.f1459X0o0xo = z;
    }

    public boolean IIXOooo() {
        return this.f1463xxIXOIIO;
    }

    public boolean IXxxXO() {
        return this.f1462oxoX;
    }

    public void OOXIXo(boolean z) {
        this.f1463xxIXOIIO = z;
    }

    public boolean Oo() {
        return this.f1455I0Io;
    }

    public void Oxx0IOOO(boolean z) {
        this.f1462oxoX = z;
    }

    public boolean Oxx0xo() {
        return this.f1459X0o0xo;
    }

    public boolean OxxIIOOXO() {
        return this.f1458Oxx0IOOO;
    }

    public void X0o0xo(boolean z) {
        this.f1457II0xO0 = z;
    }

    public void XO(boolean z) {
        this.f1455I0Io = z;
    }

    public boolean oI0IIXIo() {
        return this.f1456II0XooXoX;
    }

    public void oIX0oI() {
        this.f1461oIX0oI.II0xO0();
    }

    public String oO(XOxxooXI xOxxooXI, int i) {
        Profile.Type type;
        Object oI2 = xOxxooXI.oI(0, i);
        StringBuilder sb = new StringBuilder();
        try {
            type = ((X0xII0I) xOxxooXI).OIx00oxx();
        } catch (ClassCastException unused) {
            type = Profile.Type.ENUM;
        }
        for (int i2 = 0; i2 < xOxxooXI.x0xO(); i2++) {
            if (oI2 != null && (!this.f1460XO || !oI2.equals(Fit.f11214oXxOI0oIx.get(Integer.valueOf(xOxxooXI.o0oIxOo(i)))))) {
                oI2 = xOxxooXI.oI(i2, i);
                if (this.f1457II0xO0 && xOxxooXI.o0oIxOo(i) == 13) {
                    sb.append(String.format("0x%02x", oI2));
                } else if (this.f1463xxIXOIIO && xOxxooXI.OIOoIIOIx().equals("semicircles")) {
                    sb.append(String.format("%.8f", Double.valueOf(xoxXI.I0Io.II0xO0(Integer.parseInt(oI2.toString())))));
                } else if (this.f1455I0Io && type.name().equalsIgnoreCase("DATE_TIME")) {
                    sb.append(xoxXI.II0xO0.oIX0oI(((Long) oI2).longValue()));
                } else if (this.f1462oxoX && type.ordinal() > Profile.Type.BOOL.ordinal()) {
                    sb.append(Profile.oIX0oI(type, ((Number) oI2).longValue()));
                } else {
                    sb.append(oI2.toString());
                }
                if (i2 != xOxxooXI.x0xO() - 1) {
                    sb.append('|');
                }
            }
        }
        return "\"" + sb.toString().replaceAll("\"", "\"\"") + "\"";
    }

    public void oOoXoXO(boolean z) {
        this.f1460XO = z;
    }

    public String ooOOo0oXI(String str) {
        return x0XOIxOo(str, null);
    }

    public String x0XOIxOo(String str, String str2) {
        if (this.f1463xxIXOIIO && str.equalsIgnoreCase("semicircles")) {
            return "degrees";
        }
        if (this.f1455I0Io && str2 != null && str2.equalsIgnoreCase("DATE_TIME")) {
            return "";
        }
        return str;
    }

    public boolean x0xO0oo() {
        return this.f1457II0xO0;
    }

    public void xoIox(boolean z) {
        this.f1458Oxx0IOOO = z;
    }

    public boolean xoXoI() {
        return this.f1460XO;
    }

    public void xxIXOIIO(boolean z) {
        this.f1456II0XooXoX = z;
    }
}
