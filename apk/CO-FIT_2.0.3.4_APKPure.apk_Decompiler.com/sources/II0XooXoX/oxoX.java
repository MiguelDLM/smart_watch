package II0XooXoX;

import IoX.oIX0oI;
import android.os.Build;
import java.nio.charset.Charset;
import java.util.Base64;
import oI0.X0o0xo;
import oI0.XO;

public class oxoX {
    public static byte[] II0xO0(String str) {
        byte[] bArr;
        XO.oIX0oI("decode data ==> " + str);
        String replaceAll = str.replaceAll("[\\t\\n\\r]", "");
        XO.oIX0oI("decode result ====> " + replaceAll);
        X0o0xo x0o0xo = new X0o0xo(0, X0o0xo.f20851XO);
        Charset charset = oIX0oI.f15318oIX0oI;
        if (replaceAll == null) {
            bArr = null;
        } else {
            bArr = replaceAll.getBytes(charset);
        }
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        XO.oIX0oI oix0oi = new XO.oIX0oI();
        x0o0xo.oxoX(bArr, 0, bArr.length, oix0oi);
        x0o0xo.oxoX(bArr, 0, -1, oix0oi);
        int i = oix0oi.f20858I0Io;
        byte[] bArr2 = new byte[i];
        x0o0xo.oIX0oI(bArr2, 0, i, oix0oi);
        return bArr2;
    }

    public static String oIX0oI(byte[] bArr) {
        String str;
        if (Build.VERSION.SDK_INT >= 26) {
            return Base64.getEncoder().encodeToString(bArr);
        }
        X0o0xo x0o0xo = new X0o0xo(0, X0o0xo.f20851XO);
        if (!(bArr == null || bArr.length == 0)) {
            XO.oIX0oI oix0oi = new XO.oIX0oI();
            x0o0xo.X0o0xo(bArr, 0, bArr.length, oix0oi);
            x0o0xo.X0o0xo(bArr, 0, -1, oix0oi);
            int i = oix0oi.f20858I0Io - oix0oi.f20864oxoX;
            byte[] bArr2 = new byte[i];
            x0o0xo.oIX0oI(bArr2, 0, i, oix0oi);
            bArr = bArr2;
        }
        Charset charset = oIX0oI.f15318oIX0oI;
        if (bArr == null) {
            str = null;
        } else {
            str = new String(bArr, charset);
        }
        XO.oIX0oI("encodeToString ==> " + str);
        return str;
    }
}
