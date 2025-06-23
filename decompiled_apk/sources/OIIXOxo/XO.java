package OIIXOxo;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import xIoXXXIXo.IIXOooo;
import xIoXXXIXo.OxI;

/* loaded from: classes6.dex */
public class XO {
    public XO(OxI oxI, OutputStream outputStream, String str) throws IOException {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, (str == null || !str.equals("UnicodeBig")) ? "UTF8" : str));
            for (int i = 0; i < oxI.IIXOooo(); i++) {
                IIXOooo o002 = oxI.o00(i);
                bufferedWriter.write(o002.getName());
                bufferedWriter.newLine();
                for (int i2 = 0; i2 < o002.OxxIIOOXO(); i2++) {
                    for (xIoXXXIXo.I0Io i0Io : o002.x0o(i2)) {
                        if (i0Io.XO() != null) {
                            xIoXXXIXo.oxoX XO2 = i0Io.XO();
                            StringBuffer stringBuffer = new StringBuffer();
                            xIoXXXIXo.XO.Oxx0IOOO(i0Io.oIX0oI(), i0Io.II0xO0(), stringBuffer);
                            bufferedWriter.write("Cell " + stringBuffer.toString() + " contents:  " + i0Io.IIX0o());
                            bufferedWriter.flush();
                            StringBuilder sb = new StringBuilder();
                            sb.append(" comment: ");
                            sb.append(XO2.II0xO0());
                            bufferedWriter.write(sb.toString());
                            bufferedWriter.flush();
                            bufferedWriter.newLine();
                        }
                    }
                }
            }
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (UnsupportedEncodingException e) {
            System.err.println(e.toString());
        }
    }
}
