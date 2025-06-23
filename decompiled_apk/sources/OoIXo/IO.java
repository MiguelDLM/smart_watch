package OoIXo;

import java.io.UnsupportedEncodingException;

/* loaded from: classes6.dex */
public final class IO {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f2056oIX0oI = XxIIOXIXx.X0o0xo.Oxx0IOOO(IO.class);

    /* renamed from: II0xO0, reason: collision with root package name */
    public static String f2055II0xO0 = "UnicodeLittle";

    public static byte[] I0Io(String str, xIoXXXIXo.O0xOxO o0xOxO) {
        try {
            return str.getBytes(o0xOxO.XO());
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    public static final String II0XooXoX(String str, String str2, String str3) {
        int indexOf = str.indexOf(str2);
        while (indexOf != -1) {
            StringBuffer stringBuffer = new StringBuffer(str.substring(0, indexOf));
            stringBuffer.append(str3);
            stringBuffer.append(str.substring(str2.length() + indexOf));
            str = stringBuffer.toString();
            indexOf = str.indexOf(str2, indexOf + str3.length());
        }
        return str;
    }

    public static byte[] II0xO0(String str) {
        return str.getBytes();
    }

    public static String Oxx0IOOO(byte[] bArr, int i, int i2) {
        int i3 = i * 2;
        try {
            byte[] bArr2 = new byte[i3];
            System.arraycopy(bArr, i2, bArr2, 0, i3);
            return new String(bArr2, f2055II0xO0);
        } catch (UnsupportedEncodingException unused) {
            return "";
        }
    }

    public static void X0o0xo(String str, byte[] bArr, int i) {
        byte[] XO2 = XO(str);
        System.arraycopy(XO2, 0, bArr, i, XO2.length);
    }

    public static byte[] XO(String str) {
        try {
            byte[] bytes = str.getBytes(f2055II0xO0);
            if (bytes.length == (str.length() * 2) + 2) {
                int length = bytes.length - 2;
                byte[] bArr = new byte[length];
                System.arraycopy(bytes, 2, bArr, 0, length);
                return bArr;
            }
            return bytes;
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    public static void oIX0oI(String str, byte[] bArr, int i) {
        byte[] II0xO02 = II0xO0(str);
        System.arraycopy(II0xO02, 0, bArr, i, II0xO02.length);
    }

    public static String oxoX(byte[] bArr, int i, int i2, xIoXXXIXo.O0xOxO o0xOxO) {
        if (i == 0) {
            return "";
        }
        try {
            return new String(bArr, i2, i, o0xOxO.XO());
        } catch (UnsupportedEncodingException e) {
            f2056oIX0oI.ooOOo0oXI(e.toString());
            return "";
        }
    }
}
