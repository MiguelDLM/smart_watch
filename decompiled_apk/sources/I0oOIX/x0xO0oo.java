package I0oOIX;

import com.garmin.fit.Decode;
import com.garmin.fit.Fit;
import com.garmin.fit.OIx00oxx;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;

/* loaded from: classes9.dex */
public class x0xO0oo {

    /* renamed from: I0Io, reason: collision with root package name */
    public OIx00oxx f86I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public final String f87II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final String f88oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public FileInputStream f89oxoX;

    public x0xO0oo() {
        this.f86I0Io = new OIx00oxx();
        this.f89oxoX = null;
        this.f88oIX0oI = null;
        this.f87II0xO0 = null;
    }

    public static boolean II0XooXoX(String[] strArr) {
        if (strArr.length == 1) {
            return true;
        }
        return false;
    }

    public static void X0o0xo(String[] strArr) throws IOException {
        if (!II0XooXoX(strArr)) {
            XO();
            return;
        }
        File file = new File(strArr[0]);
        if (!file.exists()) {
            System.out.println("Input file does not exist: " + strArr[0]);
            return;
        }
        if (!file.getName().toLowerCase().endsWith(".fit")) {
            System.out.println("Input file is not a .fit file: " + strArr[0]);
            return;
        }
        new x0xO0oo(strArr[0]).Oxx0IOOO();
    }

    public static void XO() {
        System.out.println("Usage: java -jar ActivityRepairTool.jar <filename>");
    }

    public final String I0Io() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f88oIX0oI.substring(0, r1.length() - 4));
        sb.append("_repaired.fit");
        return sb.toString();
    }

    public final void II0xO0() {
        try {
            this.f89oxoX.close();
        } catch (IOException unused) {
            System.err.println("Error closing Input File Stream.");
        }
    }

    public void Oxx0IOOO() {
        PrintStream printStream;
        StringBuilder sb;
        oO oOVar = new oO();
        try {
            try {
                this.f89oxoX = new FileInputStream(this.f88oIX0oI);
                Decode decode = new Decode();
                decode.oIX0oI(oOVar);
                decode.oO(this.f89oxoX);
            } catch (Exception unused) {
                System.out.println("Error while decoding file. Attempting to repair file...");
            }
            if (!oOVar.oOoXoXO()) {
                System.out.println("File can not be repaired.");
                return;
            }
            try {
                try {
                    File file = new File(this.f87II0xO0);
                    file.delete();
                    OIx00oxx oIx00oxx = new OIx00oxx(file, Fit.ProtocolVersion.V2_0);
                    this.f86I0Io = oIx00oxx;
                    oOVar.oIX0oI(oIx00oxx);
                    oOVar.I0Io();
                    oIX0oI();
                    printStream = System.out;
                    sb = new StringBuilder();
                } catch (Exception unused2) {
                    printStream = System.out;
                    printStream.println("Error in repair.\n");
                    oIX0oI();
                    sb = new StringBuilder();
                }
                sb.append("Repair complete. Repaired .fit file can be found at: ");
                sb.append(this.f87II0xO0);
                printStream.println(sb.toString());
            } catch (Throwable th) {
                oIX0oI();
                System.out.println("Repair complete. Repaired .fit file can be found at: " + this.f87II0xO0);
                throw th;
            }
        } finally {
            II0xO0();
        }
    }

    public final void oIX0oI() {
        try {
            OIx00oxx oIx00oxx = this.f86I0Io;
            if (oIx00oxx != null) {
                oIx00oxx.oIX0oI();
            }
        } catch (Exception unused) {
            System.err.println("Error closing File Encoder.");
        }
    }

    public String oxoX() {
        return this.f87II0xO0;
    }

    public x0xO0oo(String str) {
        this.f86I0Io = new OIx00oxx();
        this.f89oxoX = null;
        this.f88oIX0oI = str;
        this.f87II0xO0 = I0Io();
    }
}
