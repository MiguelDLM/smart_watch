package o0oIxXOx;

import XXO0.oIX0oI;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import java.io.PrintStream;
import java.util.Locale;
import org.apache.commons.lang3.xXOx;

/* loaded from: classes6.dex */
public final class oO extends oIX0oI {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final oO f31188I0Io = new oO();

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final String f31189II0XooXoX = "version";

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final String f31190Oxx0IOOO = "runtime";

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final String f31191X0o0xo = "locale";

    /* renamed from: XO, reason: collision with root package name */
    public static final String f31192XO = "os";

    /* renamed from: oxoX, reason: collision with root package name */
    public static final String f31193oxoX = "hardware";

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final String f31194xxIXOIIO = "vm";

    public static void x0XOIxOo(String[] strArr) {
        PrintStream printStream = System.out;
        printStream.println(oO.class);
        oO oOVar = f31188I0Io;
        printStream.printf("%s = %s%n", "version", oOVar.lookup("version"));
        printStream.printf("%s = %s%n", f31190Oxx0IOOO, oOVar.lookup(f31190Oxx0IOOO));
        printStream.printf("%s = %s%n", f31194xxIXOIIO, oOVar.lookup(f31194xxIXOIIO));
        printStream.printf("%s = %s%n", f31192XO, oOVar.lookup(f31192XO));
        printStream.printf("%s = %s%n", "hardware", oOVar.lookup("hardware"));
        printStream.printf("%s = %s%n", f31191X0o0xo, oOVar.lookup(f31191X0o0xo));
    }

    public String II0XooXoX() {
        return "default locale: " + Locale.getDefault() + ", platform encoding: " + OOXIXo("file.encoding");
    }

    public final String OOXIXo(String str) {
        return XIxXXX0x0.f31169XO.lookup(str);
    }

    public String Oxx0IOOO() {
        return "processors: " + Runtime.getRuntime().availableProcessors() + ", architecture: " + OOXIXo("os.arch") + oOoXoXO(HelpFormatter.DEFAULT_OPT_PREFIX, "sun.arch.data.model") + oOoXoXO(", instruction sets: ", "sun.cpu.isalist");
    }

    @Override // o0oIxXOx.OxxIIOOXO
    public String lookup(String str) {
        if (str == null) {
            return null;
        }
        char c = 65535;
        switch (str.hashCode()) {
            case -1097462182:
                if (str.equals(f31191X0o0xo)) {
                    c = 0;
                    break;
                }
                break;
            case 3556:
                if (str.equals(f31192XO)) {
                    c = 1;
                    break;
                }
                break;
            case 3767:
                if (str.equals(f31194xxIXOIIO)) {
                    c = 2;
                    break;
                }
                break;
            case 116909544:
                if (str.equals("hardware")) {
                    c = 3;
                    break;
                }
                break;
            case 351608024:
                if (str.equals("version")) {
                    c = 4;
                    break;
                }
                break;
            case 1550962648:
                if (str.equals(f31190Oxx0IOOO)) {
                    c = 5;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return II0XooXoX();
            case 1:
                return xxIXOIIO();
            case 2:
                return ooOOo0oXI();
            case 3:
                return Oxx0IOOO();
            case 4:
                return "Java version " + OOXIXo("java.version");
            case 5:
                return xoIox();
            default:
                throw new IllegalArgumentException(str);
        }
    }

    public final String oOoXoXO(String str, String str2) {
        String OOXIXo2 = OOXIXo(str2);
        if (xXOx.XIXIX(OOXIXo2)) {
            return "";
        }
        return str + OOXIXo2;
    }

    public String ooOOo0oXI() {
        return OOXIXo("java.vm.name") + " (build " + OOXIXo("java.vm.version") + ", " + OOXIXo("java.vm.info") + oIX0oI.I0Io.f4095I0Io;
    }

    public String xoIox() {
        return OOXIXo("java.runtime.name") + " (build " + OOXIXo("java.runtime.version") + ") from " + OOXIXo("java.vendor");
    }

    public String xxIXOIIO() {
        return OOXIXo("os.name") + " " + OOXIXo("os.version") + oOoXoXO(" ", "sun.os.patch.level") + ", architecture: " + OOXIXo("os.arch") + oOoXoXO(HelpFormatter.DEFAULT_OPT_PREFIX, "sun.arch.data.model");
    }
}
