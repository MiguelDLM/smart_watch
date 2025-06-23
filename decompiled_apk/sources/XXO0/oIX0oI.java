package XXO0;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/* loaded from: classes6.dex */
public class oIX0oI {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public Properties f4094oIX0oI;

    /* loaded from: classes6.dex */
    public class I0Io {

        /* renamed from: I0Io, reason: collision with root package name */
        public static final String f4095I0Io = ")";

        /* renamed from: II0xO0, reason: collision with root package name */
        public static final String f4096II0xO0 = "(";

        /* renamed from: oxoX, reason: collision with root package name */
        public static final String f4097oxoX = ",";

        public I0Io() {
        }
    }

    /* loaded from: classes6.dex */
    public static class II0xO0 {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public static final oIX0oI f4099oIX0oI = new oIX0oI();
    }

    public static oIX0oI I0Io() {
        return II0xO0.f4099oIX0oI;
    }

    public String[] II0xO0(char c) {
        String oIX0oI2 = oIX0oI(c);
        if (oIX0oI2 != null) {
            return oIX0oI2.substring(oIX0oI2.indexOf(I0Io.f4096II0xO0) + 1, oIX0oI2.lastIndexOf(I0Io.f4095I0Io)).split(",");
        }
        return null;
    }

    public final void Oxx0IOOO(Properties properties) {
        this.f4094oIX0oI = properties;
    }

    public final void X0o0xo() {
        try {
            Oxx0IOOO(new Properties());
            oxoX().load(xxIXOIIO.oIX0oI("/pinyindb/unicode_to_hanyu_pinyin.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public final boolean XO(String str) {
        if (str != null && !str.equals("(none0)") && str.startsWith(I0Io.f4096II0xO0) && str.endsWith(I0Io.f4095I0Io)) {
            return true;
        }
        return false;
    }

    public final String oIX0oI(char c) {
        String property = oxoX().getProperty(Integer.toHexString(c).toUpperCase());
        if (!XO(property)) {
            return null;
        }
        return property;
    }

    public final Properties oxoX() {
        return this.f4094oIX0oI;
    }

    public oIX0oI() {
        this.f4094oIX0oI = null;
        X0o0xo();
    }
}
