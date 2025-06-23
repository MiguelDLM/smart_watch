package XOx;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import java.util.Enumeration;
import java.util.Properties;
import oxO.X0o0xo;
import oxO.oxoX;

/* loaded from: classes6.dex */
public class oIX0oI {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final String f3944I0Io;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static /* synthetic */ Class f3945Oxx0IOOO = null;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final String f3946X0o0xo = "==============";

    /* renamed from: XO, reason: collision with root package name */
    public static final String f3947XO;

    /* renamed from: oxoX, reason: collision with root package name */
    public static final oxoX f3948oxoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    public Ox0XO.II0xO0 f3949II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public String f3950oIX0oI;

    static {
        Class<?> cls = f3945Oxx0IOOO;
        if (cls == null) {
            try {
                cls = Class.forName("Ox0XO.II0xO0");
                f3945Oxx0IOOO = cls;
            } catch (ClassNotFoundException e) {
                throw new NoClassDefFoundError(e.getMessage());
            }
        }
        String name = cls.getName();
        f3944I0Io = name;
        f3948oxoX = X0o0xo.oIX0oI(X0o0xo.f33551oIX0oI, name);
        f3947XO = System.getProperty("line.separator", "\n");
    }

    public oIX0oI(String str, Ox0XO.II0xO0 iI0xO0) {
        this.f3950oIX0oI = str;
        this.f3949II0xO0 = iI0xO0;
        f3948oxoX.xoIox(str);
    }

    public static String Oxx0IOOO(Properties properties, String str) {
        StringBuffer stringBuffer = new StringBuffer();
        Enumeration<?> propertyNames = properties.propertyNames();
        String str2 = f3947XO;
        StringBuffer stringBuffer2 = new StringBuffer(String.valueOf(str2));
        stringBuffer2.append(f3946X0o0xo);
        stringBuffer2.append(" ");
        stringBuffer2.append(str);
        stringBuffer2.append(" ");
        stringBuffer2.append(f3946X0o0xo);
        stringBuffer2.append(str2);
        stringBuffer.append(stringBuffer2.toString());
        while (propertyNames.hasMoreElements()) {
            String str3 = (String) propertyNames.nextElement();
            StringBuffer stringBuffer3 = new StringBuffer(String.valueOf(xoIox(str3, 28, TokenParser.SP)));
            stringBuffer3.append(":  ");
            stringBuffer3.append(properties.get(str3));
            stringBuffer3.append(f3947XO);
            stringBuffer.append(stringBuffer3.toString());
        }
        StringBuffer stringBuffer4 = new StringBuffer("==========================================");
        stringBuffer4.append(f3947XO);
        stringBuffer.append(stringBuffer4.toString());
        return stringBuffer.toString();
    }

    public static String xoIox(String str, int i, char c) {
        if (str.length() >= i) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer(i);
        stringBuffer.append(str);
        int length = i - str.length();
        while (true) {
            length--;
            if (length < 0) {
                return stringBuffer.toString();
            }
            stringBuffer.append(c);
        }
    }

    public void I0Io() {
        II0xO0();
        X0o0xo();
        oxoX();
        oIX0oI();
    }

    public void II0XooXoX() {
        f3948oxoX.xxIXOIIO(f3944I0Io, "dumpSystemProperties", Oxx0IOOO(System.getProperties(), "SystemProperties").toString());
    }

    public void II0xO0() {
        Ox0XO.II0xO0 iI0xO0 = this.f3949II0xO0;
        if (iI0xO0 != null) {
            Properties X0IIOO2 = iI0xO0.X0IIOO();
            oxoX oxox = f3948oxoX;
            String str = f3944I0Io;
            StringBuffer stringBuffer = new StringBuffer(String.valueOf(this.f3950oIX0oI));
            stringBuffer.append(" : ClientComms");
            oxox.xxIXOIIO(str, "dumpClientComms", Oxx0IOOO(X0IIOO2, stringBuffer.toString()).toString());
        }
    }

    public void X0o0xo() {
        Ox0XO.II0xO0 iI0xO0 = this.f3949II0xO0;
        if (iI0xO0 != null) {
            Properties II0xO02 = iI0xO0.O0xOxO().II0xO0();
            oxoX oxox = f3948oxoX;
            String str = f3944I0Io;
            StringBuffer stringBuffer = new StringBuffer(String.valueOf(this.f3950oIX0oI));
            stringBuffer.append(" : Connect Options");
            oxox.xxIXOIIO(str, "dumpConOptions", Oxx0IOOO(II0xO02, stringBuffer.toString()).toString());
        }
    }

    public void XO() {
        f3948oxoX.xoXoI();
    }

    public void oIX0oI() {
        xxIXOIIO();
        II0XooXoX();
        XO();
    }

    public void oxoX() {
        Ox0XO.II0xO0 iI0xO0 = this.f3949II0xO0;
        if (iI0xO0 != null && iI0xO0.OxI() != null) {
            Properties ooOOo0oXI2 = this.f3949II0xO0.OxI().ooOOo0oXI();
            oxoX oxox = f3948oxoX;
            String str = f3944I0Io;
            StringBuffer stringBuffer = new StringBuffer(String.valueOf(this.f3950oIX0oI));
            stringBuffer.append(" : ClientState");
            oxox.xxIXOIIO(str, "dumpClientState", Oxx0IOOO(ooOOo0oXI2, stringBuffer.toString()).toString());
        }
    }

    public void xxIXOIIO() {
        StringBuffer stringBuffer = new StringBuffer();
        String str = f3947XO;
        StringBuffer stringBuffer2 = new StringBuffer(String.valueOf(str));
        stringBuffer2.append(f3946X0o0xo);
        stringBuffer2.append(" Version Info ");
        stringBuffer2.append(f3946X0o0xo);
        stringBuffer2.append(str);
        stringBuffer.append(stringBuffer2.toString());
        StringBuffer stringBuffer3 = new StringBuffer(String.valueOf(xoIox("Version", 20, TokenParser.SP)));
        stringBuffer3.append(":  ");
        stringBuffer3.append(Ox0XO.II0xO0.f2814IXxxXO);
        stringBuffer3.append(str);
        stringBuffer.append(stringBuffer3.toString());
        StringBuffer stringBuffer4 = new StringBuffer(String.valueOf(xoIox("Build Level", 20, TokenParser.SP)));
        stringBuffer4.append(":  ");
        stringBuffer4.append(Ox0XO.II0xO0.f2817Oxx0xo);
        stringBuffer4.append(str);
        stringBuffer.append(stringBuffer4.toString());
        StringBuffer stringBuffer5 = new StringBuffer("==========================================");
        stringBuffer5.append(str);
        stringBuffer.append(stringBuffer5.toString());
        f3948oxoX.xxIXOIIO(f3944I0Io, "dumpVersion", stringBuffer.toString());
    }
}
