package OIIXOxo;

import java.io.PrintStream;
import xIoXXXIXo.OxI;
import xIoXXXIXo.OxxIIOOXO;

/* loaded from: classes6.dex */
public class I0Io {

    /* renamed from: I0Io, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f1630I0Io = XxIIOXIXx.X0o0xo.Oxx0IOOO(I0Io.class);

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final int f1631II0xO0 = 14;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final int f1632oIX0oI = 13;

    /* JADX WARN: Removed duplicated region for block: B:26:0x0175 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01fa A[Catch: all -> 0x0204, TRY_ENTER, TryCatch #0 {all -> 0x0204, blocks: (B:64:0x01fa, B:68:0x0209, B:71:0x0215, B:74:0x022c, B:77:0x0243, B:80:0x025a, B:83:0x0270, B:86:0x027f, B:89:0x028c, B:91:0x0290, B:92:0x0295, B:94:0x02a0, B:96:0x02ad, B:97:0x02c0, B:101:0x02b9), top: B:62:0x01f8 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0207  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void I0Io(java.lang.String[] r21) {
        /*
            Method dump skipped, instructions count: 721
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: OIIXOxo.I0Io.I0Io(java.lang.String[]):void");
    }

    public static void II0xO0(OxI oxI) {
        f1630I0Io.xxIXOIIO("Find test");
        xIoXXXIXo.I0Io oI0IIXIo2 = oxI.oI0IIXIo("named1");
        if (oI0IIXIo2 != null) {
            f1630I0Io.xxIXOIIO("named1 contents:  " + oI0IIXIo2.IIX0o());
        }
        xIoXXXIXo.I0Io oI0IIXIo3 = oxI.oI0IIXIo("named2");
        if (oI0IIXIo3 != null) {
            f1630I0Io.xxIXOIIO("named2 contents:  " + oI0IIXIo3.IIX0o());
        }
        xIoXXXIXo.I0Io oI0IIXIo4 = oxI.oI0IIXIo("namedrange");
        if (oI0IIXIo4 != null) {
            f1630I0Io.xxIXOIIO("named2 contents:  " + oI0IIXIo4.IIX0o());
        }
        OxxIIOOXO[] Oxx0xo2 = oxI.Oxx0xo("namedrange");
        if (Oxx0xo2 != null) {
            xIoXXXIXo.I0Io oIX0oI2 = Oxx0xo2[0].oIX0oI();
            f1630I0Io.xxIXOIIO("namedrange top left contents:  " + oIX0oI2.IIX0o());
            xIoXXXIXo.I0Io II0xO02 = Oxx0xo2[0].II0xO0();
            f1630I0Io.xxIXOIIO("namedrange bottom right contents:  " + II0xO02.IIX0o());
        }
        OxxIIOOXO[] Oxx0xo3 = oxI.Oxx0xo("nonadjacentrange");
        if (Oxx0xo3 != null) {
            for (int i = 0; i < Oxx0xo3.length; i++) {
                xIoXXXIXo.I0Io oIX0oI3 = Oxx0xo3[i].oIX0oI();
                f1630I0Io.xxIXOIIO("nonadjacent top left contents:  " + oIX0oI3.IIX0o());
                xIoXXXIXo.I0Io II0xO03 = Oxx0xo3[i].II0xO0();
                f1630I0Io.xxIXOIIO("nonadjacent bottom right contents:  " + II0xO03.IIX0o());
            }
        }
        OxxIIOOXO[] Oxx0xo4 = oxI.Oxx0xo("horizontalnonadjacentrange");
        if (Oxx0xo4 != null) {
            for (int i2 = 0; i2 < Oxx0xo4.length; i2++) {
                xIoXXXIXo.I0Io oIX0oI4 = Oxx0xo4[i2].oIX0oI();
                f1630I0Io.xxIXOIIO("horizontalnonadjacent top left contents:  " + oIX0oI4.IIX0o());
                xIoXXXIXo.I0Io II0xO04 = Oxx0xo4[i2].II0xO0();
                f1630I0Io.xxIXOIIO("horizontalnonadjacent bottom right contents:  " + II0xO04.IIX0o());
            }
        }
    }

    public static void oIX0oI() {
        PrintStream printStream = System.err;
        printStream.println("Command format:  Demo [-unicode] [-csv] [-hide] excelfile");
        printStream.println("                 Demo -xml [-format]  excelfile");
        printStream.println("                 Demo -readwrite|-rw excelfile output");
        printStream.println("                 Demo -biffdump | -bd | -wa | -write | -formulas | -features | -escher | -escherdg excelfile");
        printStream.println("                 Demo -ps excelfile [property] [output]");
        printStream.println("                 Demo -version | -logtest | -h | -help");
    }
}
