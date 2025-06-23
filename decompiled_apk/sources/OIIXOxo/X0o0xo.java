package OIIXOxo;

import X0xOO.IIXOooo;
import X0xOO.O0xOxO;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import jxl.read.biff.IIX0;
import xIoXXXIXo.OxI;

/* loaded from: classes6.dex */
public class X0o0xo {
    public X0o0xo(OxI oxI, OutputStream outputStream, String str) throws IOException {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, (str == null || !str.equals("UnicodeBig")) ? "UTF8" : str));
            IIXOooo X00IoxXI2 = ((IIX0) oxI).X00IoxXI();
            if (X00IoxXI2 != null) {
                new O0xOxO(X00IoxXI2, bufferedWriter).oIX0oI();
            }
            bufferedWriter.newLine();
            bufferedWriter.newLine();
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (UnsupportedEncodingException e) {
            System.err.println(e.toString());
        }
    }
}
