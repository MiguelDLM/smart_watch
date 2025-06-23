package O0Xx;

import com.garmin.fit.Decode;
import com.garmin.fit.Fit;
import com.garmin.fit.FitRuntimeException;
import com.garmin.fit.IIX0o;
import com.garmin.fit.oX0I0O;
import com.garmin.fit.plugins.ActivityFileValidationResult;
import com.garmin.fit.plugins.OI0;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashSet;

/* loaded from: classes9.dex */
public class Oxx0IOOO {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public X0o0xo f1404II0XooXoX;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public oOoXoXO f1412Oxx0IOOO;

    /* renamed from: XO, reason: collision with root package name */
    public xxIXOIIO f1417XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public boolean f1420oIX0oI = false;

    /* renamed from: II0xO0, reason: collision with root package name */
    public final int f1405II0xO0 = 2;

    /* renamed from: I0Io, reason: collision with root package name */
    public ByteArrayOutputStream f1403I0Io = null;

    /* renamed from: oxoX, reason: collision with root package name */
    public ByteArrayOutputStream f1424oxoX = null;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public OOXIXo f1416X0o0xo = null;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public int f1429xxIXOIIO = 0;

    /* renamed from: xoIox, reason: collision with root package name */
    public int f1427xoIox = 0;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public final Decode f1409OOXIXo = new Decode();

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public HashSet<String> f1422oOoXoXO = new HashSet<>();

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public HashSet<String> f1423ooOOo0oXI = new HashSet<>();

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public boolean f1425x0XOIxOo = false;

    /* renamed from: oO, reason: collision with root package name */
    public boolean f1421oO = false;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public boolean f1426x0xO0oo = false;

    /* renamed from: Oo, reason: collision with root package name */
    public boolean f1410Oo = false;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public boolean f1407IXxxXO = false;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public boolean f1413Oxx0xo = false;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public boolean f1419oI0IIXIo = false;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public boolean f1414OxxIIOOXO = false;

    /* renamed from: IIXOooo, reason: collision with root package name */
    public boolean f1406IIXOooo = false;

    /* renamed from: xoXoI, reason: collision with root package name */
    public boolean f1428xoXoI = false;

    /* renamed from: o00, reason: collision with root package name */
    public boolean f1418o00 = false;

    /* renamed from: OxI, reason: collision with root package name */
    public boolean f1411OxI = false;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public boolean f1408O0xOxO = false;

    /* renamed from: X0IIOO, reason: collision with root package name */
    public Fit.ProtocolVersion f1415X0IIOO = Fit.ProtocolVersion.V2_0;

    public static void Xx000oIo() {
        PrintStream printStream = System.out;
        printStream.println("Usage: java -jar FitCSVTool.jar <options> <file>");
        printStream.println("      -b <FIT FILE> <CSV FILE>  FIT binary to CSV.");
        printStream.println("      -c <CSV FILE> <FIT FILE>  CSV to FIT binary.");
        printStream.println("      -t Enable file verification tests.");
        printStream.println("      -d Enable debug output.");
        printStream.println("      -i Check integrity of FIT file before decoding.");
        printStream.println("      -s Show invalid fields in the CSV file.");
        printStream.println("      -se Show invalid fields in the CSV file as empty cells.");
        printStream.println("      -u Hide unknown data and report statistics on how much is hidden.");
        printStream.println("      -x Print byte values as hexadecimal.");
        printStream.println("      -deg Print semicircle values as degrees.");
        printStream.println("      -iso8601 Print date-time values as ISO 8601 formatted strings.");
        printStream.println("      -ex Changes the behaviour of the --defn and --data options to");
        printStream.println("          filter out the messages listed. The default behaviour without");
        printStream.println("          this flag is to exclude all messages except those listed");
        printStream.println("          after the --defn and the --data options.");
        printStream.println("      -pN Encode file using Protocol Version <N>. Default: 2");
        printStream.println("      -e Print enum values as their corresponding String labels when");
        printStream.println("          possible. Note: CSV files generated with this option will not");
        printStream.println("          be able to be converted back into .FIT files.");
        printStream.println("      -re Remove expanded fields from CSV output. This removes fields");
        printStream.println("          that have been generated through component expansion and");
        printStream.println("          which do not exist in the source .FIT file");
        printStream.println("      --defn <MESSAGE_STRING_0,MESSAGE_STRING_1,...> Narrows down the");
        printStream.println("          definitions output to CSV. Use 'none' for no definitions");
        printStream.println("          When this option is used only the message definitions");
        printStream.println("          in the comma separated list will be written to the CSV.");
        printStream.println("          eg. --defn file_capabilities,record,file_creator");
        printStream.println("          Note: This option is only compatible with the -b option.");
        printStream.println("      --data <MESSAGE_STRING_0,MESSAGE_STRING_1,...> Narrows down the");
        printStream.println("          data output to CSV. When this option is used only the data");
        printStream.println("          in the comma separated list will be written to the csv.");
        printStream.println("          eg. --data file_capabilities,record,file_creator");
        printStream.println("          Note: This option is only compatible with the -b option.");
        printStream.println("      -g Preserve gaps caused by data dropouts. ");
        printStream.println("          Note: This option is only compatible with the --data option");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0266 A[ADDED_TO_REGION, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void oOXoIIIo(java.lang.String[] r16) {
        /*
            Method dump skipped, instructions count: 1037
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: O0Xx.Oxx0IOOO.oOXoIIIo(java.lang.String[]):void");
    }

    public ByteArrayOutputStream I0Io(ByteArrayInputStream byteArrayInputStream) throws Exception {
        IIX0o iIX0o = new IIX0o(this.f1415X0IIOO);
        try {
            if (XO.oxoX(byteArrayInputStream, iIX0o, iIX0o, this.f1415X0IIOO)) {
                byte[] oIX0oI2 = iIX0o.oIX0oI();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                this.f1403I0Io = byteArrayOutputStream;
                byteArrayOutputStream.write(oIX0oI2);
                return this.f1403I0Io;
            }
            throw new FitRuntimeException("FIT encoding error.");
        } catch (Throwable th) {
            byte[] oIX0oI3 = iIX0o.oIX0oI();
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            this.f1403I0Io = byteArrayOutputStream2;
            byteArrayOutputStream2.write(oIX0oI3);
            throw th;
        }
    }

    public final void I0oOoX() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.f1424oxoX = byteArrayOutputStream;
        OOXIXo oOXIXo = new OOXIXo(byteArrayOutputStream);
        this.f1416X0o0xo = oOXIXo;
        if (this.f1425x0XOIxOo) {
            oOXIXo.X0o0xo(true);
        }
        if (this.f1421oO) {
            this.f1416X0o0xo.XO(true);
        }
        if (this.f1419oI0IIXIo) {
            this.f1416X0o0xo.oOoXoXO(true);
        }
        if (this.f1414OxxIIOOXO) {
            this.f1416X0o0xo.II0XooXoX(true);
        }
        if (this.f1428xoXoI) {
            this.f1416X0o0xo.Oxx0IOOO(true);
        }
        if (this.f1411OxI) {
            this.f1416X0o0xo.xoIox(true);
        }
        if (this.f1426x0xO0oo) {
            this.f1416X0o0xo.OOXIXo(true);
        }
        if (this.f1418o00) {
            this.f1416X0o0xo.xxIXOIIO(true);
        }
    }

    public void II0XooXoX(boolean z) {
        this.f1428xoXoI = z;
    }

    public final void II0xO0() {
        OOXIXo oOXIXo = this.f1416X0o0xo;
        if (oOXIXo != null) {
            oOXIXo.oIX0oI();
        }
    }

    public boolean IIX0o() {
        return this.f1418o00;
    }

    public int IIXOooo() {
        return this.f1429xxIXOIIO;
    }

    public final void IO() {
        this.f1412Oxx0IOOO.X0o0xo(this.f1417XO);
        this.f1412Oxx0IOOO.oIX0oI(this.f1417XO);
        this.f1409OOXIXo.oxoX(this.f1412Oxx0IOOO);
        this.f1409OOXIXo.oIX0oI(this.f1412Oxx0IOOO);
    }

    public ByteArrayOutputStream IXxxXO() {
        return this.f1403I0Io;
    }

    public void Io(HashSet<String> hashSet) {
        this.f1422oOoXoXO = hashSet;
    }

    public boolean IoOoX() {
        return this.f1410Oo;
    }

    public boolean O0xOxO() {
        return this.f1407IXxxXO;
    }

    public void OI0(boolean z) {
        this.f1408O0xOxO = z;
    }

    public void OOXIXo(boolean z) {
        this.f1414OxxIIOOXO = z;
    }

    public void Oo(boolean z) {
        this.f1410Oo = z;
    }

    public boolean OxI() {
        return this.f1425x0XOIxOo;
    }

    public void Oxx0IOOO(boolean z) {
        this.f1421oO = z;
    }

    public HashSet<String> Oxx0xo() {
        return this.f1423ooOOo0oXI;
    }

    public HashSet<String> OxxIIOOXO() {
        return this.f1422oOoXoXO;
    }

    public final void X00IoxXI(String str) {
        if (this.f1420oIX0oI) {
            System.out.println(str);
        }
    }

    public boolean X0IIOO() {
        return this.f1421oO;
    }

    public void X0o0xo(boolean z) {
        this.f1425x0XOIxOo = z;
    }

    public boolean XI0IXoo() {
        return this.f1428xoXoI;
    }

    public boolean XIxXXX0x0() {
        return this.f1408O0xOxO;
    }

    public void XO(boolean z) {
        this.f1407IXxxXO = z;
    }

    public void XOxIOxOx(HashSet<String> hashSet) {
        this.f1423ooOOo0oXI = hashSet;
    }

    public final void XX() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.f1403I0Io = byteArrayOutputStream;
        xxIXOIIO xxixoiio = new xxIXOIIO(byteArrayOutputStream);
        this.f1417XO = xxixoiio;
        if (this.f1425x0XOIxOo) {
            xxixoiio.X0o0xo(true);
        }
        if (this.f1421oO) {
            this.f1417XO.XO(true);
        }
        if (this.f1419oI0IIXIo) {
            this.f1417XO.oOoXoXO(true);
        }
        if (this.f1414OxxIIOOXO) {
            this.f1417XO.II0XooXoX(true);
        }
        if (this.f1428xoXoI) {
            this.f1417XO.Oxx0IOOO(true);
        }
        if (this.f1411OxI) {
            this.f1417XO.xoIox(true);
        }
        if (this.f1426x0xO0oo) {
            this.f1417XO.OOXIXo(true);
        }
    }

    public boolean XxX0x0xxx() {
        return this.f1406IIXOooo;
    }

    public void o0(Fit.ProtocolVersion protocolVersion) {
        this.f1415X0IIOO = protocolVersion;
    }

    public Fit.ProtocolVersion o00() {
        return this.f1415X0IIOO;
    }

    public ByteArrayOutputStream oI0IIXIo() {
        return this.f1424oxoX;
    }

    public final void oIX0oI() {
        this.f1417XO.oIX0oI();
    }

    public void oO(boolean z) {
        this.f1413Oxx0xo = z;
    }

    public void oOoXoXO(boolean z) {
        this.f1418o00 = z;
    }

    public boolean oo() {
        return this.f1419oI0IIXIo;
    }

    public boolean oo0xXOI0I() {
        return this.f1413Oxx0xo;
    }

    public void ooOOo0oXI(boolean z) {
        this.f1411OxI = z;
    }

    public boolean ooXIXxIX() {
        return this.f1411OxI;
    }

    public ByteArrayOutputStream oxoX(ByteArrayInputStream byteArrayInputStream) throws Exception {
        if (this.f1407IXxxXO) {
            if (!this.f1409OOXIXo.XO(byteArrayInputStream)) {
                if (this.f1409OOXIXo.II0XooXoX()) {
                    X00IoxXI("FIT file integrity failure. Invalid file size in header.");
                    X00IoxXI("Trying to continue...");
                } else {
                    throw new FitRuntimeException("FIT file integrity failure.");
                }
            }
            byteArrayInputStream.reset();
        }
        if (this.f1410Oo) {
            x0o(byteArrayInputStream);
        }
        try {
            try {
                XX();
                if (this.f1406IIXOooo) {
                    I0oOoX();
                }
                if (this.f1413Oxx0xo) {
                    this.f1409OOXIXo.OxxIIOOXO();
                }
                this.f1412Oxx0IOOO = new oOoXoXO();
                this.f1404II0XooXoX = new X0o0xo();
                if (this.f1408O0xOxO) {
                    this.f1412Oxx0IOOO.II0XooXoX(this.f1422oOoXoXO);
                    this.f1412Oxx0IOOO.XO(this.f1423ooOOo0oXI);
                } else {
                    this.f1412Oxx0IOOO.xxIXOIIO(this.f1422oOoXoXO);
                    this.f1412Oxx0IOOO.Oxx0IOOO(this.f1423ooOOo0oXI);
                }
                IO();
                xII();
                while (this.f1409OOXIXo.X0o0xo(byteArrayInputStream)) {
                    try {
                        this.f1409OOXIXo.oO(byteArrayInputStream);
                        this.f1409OOXIXo.oOoXoXO();
                    } catch (FitRuntimeException e) {
                        if (this.f1409OOXIXo.II0XooXoX()) {
                            this.f1409OOXIXo.oOoXoXO();
                        } else {
                            throw e;
                        }
                    }
                }
                OOXIXo oOXIXo = this.f1416X0o0xo;
                if (oOXIXo != null) {
                    oOXIXo.OxI(this.f1404II0XooXoX.II0XooXoX());
                }
                this.f1404II0XooXoX.I0Io();
                this.f1429xxIXOIIO = this.f1417XO.OxI();
                this.f1427xoIox = this.f1417XO.O0xOxO();
                oIX0oI();
                II0xO0();
                return this.f1403I0Io;
            } catch (IOException e2) {
                if (xxX()) {
                    e2.printStackTrace(System.out);
                }
                throw e2;
            }
        } catch (Throwable th) {
            this.f1429xxIXOIIO = this.f1417XO.OxI();
            this.f1427xoIox = this.f1417XO.O0xOxO();
            oIX0oI();
            II0xO0();
            throw th;
        }
    }

    public void x0XOIxOo(boolean z) {
        this.f1426x0xO0oo = z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v18, types: [java.util.Iterator] */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.util.Iterator] */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.util.Iterator] */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v1, types: [com.garmin.fit.XxI, com.garmin.fit.plugins.OI0] */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14, types: [java.io.PrintStream] */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.io.PrintStream] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.io.PrintStream] */
    /* JADX WARN: Type inference failed for: r3v6, types: [com.garmin.fit.plugins.OI0] */
    /* JADX WARN: Type inference failed for: r4v10, types: [com.garmin.fit.oX0I0O] */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.lang.StringBuilder] */
    public final void x0o(ByteArrayInputStream byteArrayInputStream) {
        ?? r1 = "Message Count: ";
        PrintStream printStream = System.out;
        printStream.println("Running FIT verification tests...");
        ?? oi0 = new OI0();
        try {
            try {
                try {
                    new oX0I0O().II0xO0(byteArrayInputStream, oi0);
                    if (oi0.IIxOXoOo0().size() == 0) {
                        oi0.X0xII0I();
                    }
                    printStream.println("Message Count: " + oi0.OOXIxO0());
                    r1 = oi0.IIxOXoOo0().iterator();
                    while (r1.hasNext()) {
                        ActivityFileValidationResult activityFileValidationResult = (ActivityFileValidationResult) r1.next();
                        oi0 = System.out;
                        oi0.println(activityFileValidationResult);
                        if (activityFileValidationResult.oIX0oI() != null) {
                            oi0.println("\t" + activityFileValidationResult.oIX0oI());
                        }
                    }
                } catch (Exception e) {
                    PrintStream printStream2 = System.out;
                    printStream2.println("Exception decoding file: " + e.getMessage());
                    if (oi0.IIxOXoOo0().size() == 0) {
                        oi0.X0xII0I();
                    }
                    printStream2.println("Message Count: " + oi0.OOXIxO0());
                    r1 = oi0.IIxOXoOo0().iterator();
                    while (r1.hasNext()) {
                        ActivityFileValidationResult activityFileValidationResult2 = (ActivityFileValidationResult) r1.next();
                        oi0 = System.out;
                        oi0.println(activityFileValidationResult2);
                        if (activityFileValidationResult2.oIX0oI() != null) {
                            oi0.println("\t" + activityFileValidationResult2.oIX0oI());
                        }
                    }
                }
            } catch (FitRuntimeException e2) {
                PrintStream printStream3 = System.out;
                printStream3.println("FitRuntimeException decoding file: " + e2.getMessage());
                if (oi0.IIxOXoOo0().size() == 0) {
                    oi0.X0xII0I();
                }
                printStream3.println("Message Count: " + oi0.OOXIxO0());
                r1 = oi0.IIxOXoOo0().iterator();
                while (r1.hasNext()) {
                    ActivityFileValidationResult activityFileValidationResult3 = (ActivityFileValidationResult) r1.next();
                    oi0 = System.out;
                    oi0.println(activityFileValidationResult3);
                    if (activityFileValidationResult3.oIX0oI() != null) {
                        oi0.println("\t" + activityFileValidationResult3.oIX0oI());
                    }
                }
            }
            byteArrayInputStream.reset();
        } catch (Throwable th) {
            if (oi0.IIxOXoOo0().size() == 0) {
                oi0.X0xII0I();
            }
            PrintStream printStream4 = System.out;
            ?? sb = new StringBuilder();
            sb.append(r1);
            sb.append(oi0.OOXIxO0());
            printStream4.println(sb.toString());
            for (ActivityFileValidationResult activityFileValidationResult4 : oi0.IIxOXoOo0()) {
                PrintStream printStream5 = System.out;
                printStream5.println(activityFileValidationResult4);
                if (activityFileValidationResult4.oIX0oI() != null) {
                    printStream5.println("\t" + activityFileValidationResult4.oIX0oI());
                }
            }
            byteArrayInputStream.reset();
            throw th;
        }
    }

    public void x0xO0oo(boolean z) {
        this.f1419oI0IIXIo = z;
        if (z) {
            this.f1413Oxx0xo = true;
        }
    }

    public boolean xI() {
        return this.f1426x0xO0oo;
    }

    public final void xII() {
        X0o0xo x0o0xo;
        if (this.f1416X0o0xo != null && (x0o0xo = this.f1404II0XooXoX) != null) {
            this.f1412Oxx0IOOO.oIX0oI(x0o0xo);
            this.f1404II0XooXoX.oIX0oI(this.f1416X0o0xo);
        }
    }

    public boolean xXxxox0I() {
        return this.f1414OxxIIOOXO;
    }

    public void xoIox(boolean z) {
        this.f1406IIXOooo = z;
    }

    public int xoXoI() {
        return this.f1427xoIox;
    }

    public void xxIXOIIO(boolean z) {
        Fit.f11206oIX0oI = z;
    }

    public boolean xxX() {
        return Fit.f11206oIX0oI;
    }
}
