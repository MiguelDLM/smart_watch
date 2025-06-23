package OIIXOxo;

import X0xOO.O0xOxO;
import X0xOO.OxxIIOOXO;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import jxl.read.biff.I0;
import xIoXXXIXo.OxI;

/* loaded from: classes6.dex */
public class oxoX {
    public oxoX(OxI oxI, OutputStream outputStream, String str) throws IOException {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, (str == null || !str.equals("UnicodeBig")) ? "UTF8" : str));
            for (int i = 0; i < oxI.IIXOooo(); i++) {
                I0 i0 = (I0) oxI.o00(i);
                bufferedWriter.write(i0.getName());
                bufferedWriter.newLine();
                bufferedWriter.newLine();
                OxxIIOOXO xxIO2 = i0.xxIO();
                if (xxIO2 != null) {
                    new O0xOxO(xxIO2, bufferedWriter).oIX0oI();
                }
                bufferedWriter.newLine();
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (UnsupportedEncodingException e) {
            System.err.println(e.toString());
        }
    }
}
