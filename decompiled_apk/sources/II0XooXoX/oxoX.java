package II0XooXoX;

import android.os.Build;
import java.nio.charset.Charset;
import java.util.Base64;
import oI0.XO;

/* loaded from: classes.dex */
public class oxoX {
    public static byte[] II0xO0(String str) {
        byte[] bytes;
        XO.oIX0oI("decode data ==> " + str);
        String replaceAll = str.replaceAll("[\\t\\n\\r]", "");
        XO.oIX0oI("decode result ====> " + replaceAll);
        oI0.X0o0xo x0o0xo = new oI0.X0o0xo(0, oI0.X0o0xo.f31330XO);
        Charset charset = IoX.oIX0oI.f810oIX0oI;
        if (replaceAll == null) {
            bytes = null;
        } else {
            bytes = replaceAll.getBytes(charset);
        }
        if (bytes != null && bytes.length != 0) {
            XO.oIX0oI oix0oi = new XO.oIX0oI();
            x0o0xo.oxoX(bytes, 0, bytes.length, oix0oi);
            x0o0xo.oxoX(bytes, 0, -1, oix0oi);
            int i = oix0oi.f31337I0Io;
            byte[] bArr = new byte[i];
            x0o0xo.oIX0oI(bArr, 0, i, oix0oi);
            return bArr;
        }
        return bytes;
    }

    public static String oIX0oI(byte[] bArr) {
        String str;
        Base64.Encoder encoder;
        String encodeToString;
        if (Build.VERSION.SDK_INT >= 26) {
            encoder = Base64.getEncoder();
            encodeToString = encoder.encodeToString(bArr);
            return encodeToString;
        }
        oI0.X0o0xo x0o0xo = new oI0.X0o0xo(0, oI0.X0o0xo.f31330XO);
        if (bArr != null && bArr.length != 0) {
            XO.oIX0oI oix0oi = new XO.oIX0oI();
            x0o0xo.X0o0xo(bArr, 0, bArr.length, oix0oi);
            x0o0xo.X0o0xo(bArr, 0, -1, oix0oi);
            int i = oix0oi.f31337I0Io - oix0oi.f31343oxoX;
            byte[] bArr2 = new byte[i];
            x0o0xo.oIX0oI(bArr2, 0, i, oix0oi);
            bArr = bArr2;
        }
        Charset charset = IoX.oIX0oI.f810oIX0oI;
        if (bArr == null) {
            str = null;
        } else {
            str = new String(bArr, charset);
        }
        XO.oIX0oI("encodeToString ==> " + str);
        return str;
    }
}
