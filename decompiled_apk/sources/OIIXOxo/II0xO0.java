package OIIXOxo;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import xIoXXXIXo.IIXOooo;
import xIoXXXIXo.OxI;

/* loaded from: classes6.dex */
public class II0xO0 {
    public II0xO0(OxI oxI, OutputStream outputStream, String str, boolean z) throws IOException {
        int i;
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, (str == null || !str.equals("UnicodeBig")) ? "UTF8" : str));
            while (i < oxI.IIXOooo()) {
                IIXOooo o002 = oxI.o00(i);
                i = (z && o002.X0o0xo().X00IoxXI()) ? i + 1 : 0;
                bufferedWriter.write("*** " + o002.getName() + " ****");
                bufferedWriter.newLine();
                for (int i2 = 0; i2 < o002.OxxIIOOXO(); i2++) {
                    xIoXXXIXo.I0Io[] x0o2 = o002.x0o(i2);
                    if (x0o2.length > 0) {
                        if (!z || !x0o2[0].isHidden()) {
                            bufferedWriter.write(x0o2[0].IIX0o());
                        }
                        for (int i3 = 1; i3 < x0o2.length; i3++) {
                            bufferedWriter.write(44);
                            if (!z || !x0o2[i3].isHidden()) {
                                bufferedWriter.write(x0o2[i3].IIX0o());
                            }
                        }
                    }
                    bufferedWriter.newLine();
                }
            }
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (UnsupportedEncodingException e) {
            System.err.println(e.toString());
        }
    }
}
