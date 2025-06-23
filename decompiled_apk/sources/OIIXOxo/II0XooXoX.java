package OIIXOxo;

import OoIXo.X0o0xo;
import XXO0.oIX0oI;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import jxl.read.biff.BiffException;
import jxl.read.biff.x0xO0oo;
import xIoXXXIXo.O0xOxO;

/* loaded from: classes6.dex */
public class II0XooXoX {

    /* renamed from: II0xO0, reason: collision with root package name */
    public x0xO0oo f1633II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public BufferedWriter f1634oIX0oI;

    public II0XooXoX(File file, String str, OutputStream outputStream) throws IOException, BiffException {
        this.f1634oIX0oI = new BufferedWriter(new OutputStreamWriter(outputStream));
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bArr = new byte[1048576];
        int read = fileInputStream.read(bArr);
        int i = read;
        while (read != -1) {
            if (i >= bArr.length) {
                byte[] bArr2 = new byte[bArr.length + 1048576];
                System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                bArr = bArr2;
            }
            read = fileInputStream.read(bArr, i, bArr.length - i);
            i += read;
        }
        this.f1633II0xO0 = new x0xO0oo(bArr, new O0xOxO());
        fileInputStream.close();
        if (str == null) {
            II0xO0();
        } else {
            oIX0oI(str, outputStream);
        }
    }

    public void II0xO0() throws IOException {
        int X0o0xo2 = this.f1633II0xO0.X0o0xo();
        for (int i = 0; i < X0o0xo2; i++) {
            X0o0xo.oIX0oI XO2 = this.f1633II0xO0.XO(i);
            this.f1634oIX0oI.write(Integer.toString(i));
            this.f1634oIX0oI.write(") ");
            this.f1634oIX0oI.write(XO2.f2224oIX0oI);
            this.f1634oIX0oI.write("(type ");
            this.f1634oIX0oI.write(Integer.toString(XO2.f2220II0xO0));
            this.f1634oIX0oI.write(" size ");
            this.f1634oIX0oI.write(Integer.toString(XO2.f2222X0o0xo));
            this.f1634oIX0oI.write(" prev ");
            this.f1634oIX0oI.write(Integer.toString(XO2.f2223XO));
            this.f1634oIX0oI.write(" next ");
            this.f1634oIX0oI.write(Integer.toString(XO2.f2221Oxx0IOOO));
            this.f1634oIX0oI.write(" child ");
            this.f1634oIX0oI.write(Integer.toString(XO2.f2219II0XooXoX));
            this.f1634oIX0oI.write(" start block ");
            this.f1634oIX0oI.write(Integer.toString(XO2.f2225oxoX));
            this.f1634oIX0oI.write(oIX0oI.I0Io.f4095I0Io);
            this.f1634oIX0oI.newLine();
        }
        this.f1634oIX0oI.flush();
        this.f1634oIX0oI.close();
    }

    public void oIX0oI(String str, OutputStream outputStream) throws IOException, BiffException {
        if (str.equalsIgnoreCase("SummaryInformation")) {
            str = OoIXo.X0o0xo.f2205o00;
        } else if (str.equalsIgnoreCase("DocumentSummaryInformation")) {
            str = OoIXo.X0o0xo.f2195OxI;
        } else if (str.equalsIgnoreCase("CompObj")) {
            str = OoIXo.X0o0xo.f2192O0xOxO;
        }
        outputStream.write(this.f1633II0xO0.OOXIXo(str));
    }
}
