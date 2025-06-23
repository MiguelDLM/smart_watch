package OIIXOxo;

import OoIXo.IO;
import OoIXo.xII;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import jxl.read.biff.BiffException;
import jxl.read.biff.XIxXXX0x0;
import jxl.read.biff.xoxXI;
import xIoXXXIXo.O0xOxO;

/* loaded from: classes6.dex */
public class OOXIXo {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public jxl.read.biff.I0Io f1635oIX0oI;

    public OOXIXo(File file) throws IOException, BiffException {
        O0xOxO o0xOxO = new O0xOxO();
        FileInputStream fileInputStream = new FileInputStream(file);
        this.f1635oIX0oI = new jxl.read.biff.I0Io(new XIxXXX0x0(fileInputStream, o0xOxO));
        oIX0oI(o0xOxO);
        fileInputStream.close();
    }

    public final void oIX0oI(O0xOxO o0xOxO) throws IOException {
        xoxXI xoxxi = null;
        boolean z = false;
        while (this.f1635oIX0oI.II0xO0() && !z) {
            xoxxi = this.f1635oIX0oI.I0Io();
            if (xoxxi.X0o0xo() == xII.f2470XOxIOxOx) {
                z = true;
            }
        }
        if (!z) {
            System.err.println("Warning:  could not find write access record");
            return;
        }
        byte[] I0Io2 = xoxxi.I0Io();
        System.out.println(IO.oxoX(I0Io2, I0Io2.length, 0, o0xOxO));
    }
}
