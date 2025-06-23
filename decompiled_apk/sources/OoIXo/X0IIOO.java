package OoIXo;

import com.tenmeter.smlibrary.utils.FileUtils;

/* loaded from: classes6.dex */
public class X0IIOO {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f2185oIX0oI = XxIIOXIXx.X0o0xo.Oxx0IOOO(X0IIOO.class);

    /* renamed from: II0xO0, reason: collision with root package name */
    public static byte f2182II0xO0 = 1;

    /* renamed from: I0Io, reason: collision with root package name */
    public static byte f2181I0Io = 2;

    /* renamed from: oxoX, reason: collision with root package name */
    public static byte f2186oxoX = 3;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static byte f2183X0o0xo = 4;

    /* renamed from: XO, reason: collision with root package name */
    public static byte f2184XO = 5;

    public static byte[] I0Io(String str, xIoXXXIXo.O0xOxO o0xOxO) {
        xxIXOIIO xxixoiio = new xxIXOIIO();
        xxixoiio.oIX0oI(f2184XO);
        xxixoiio.oIX0oI((byte) str.length());
        xxixoiio.II0xO0(IO.I0Io(str, o0xOxO));
        return xxixoiio.oxoX();
    }

    public static byte[] II0xO0(String str, xIoXXXIXo.O0xOxO o0xOxO) {
        int i;
        int max;
        String substring;
        int i2;
        xxIXOIIO xxixoiio = new xxIXOIIO();
        if (str.charAt(1) == ':') {
            xxixoiio.oIX0oI(f2182II0xO0);
            xxixoiio.oIX0oI((byte) str.charAt(0));
            i = 2;
        } else {
            if (str.charAt(0) == '\\' || str.charAt(0) == '/') {
                xxixoiio.oIX0oI(f2181I0Io);
            }
            i = 0;
        }
        while (true) {
            if (str.charAt(i) != '\\' && str.charAt(i) != '/') {
                break;
            }
            i++;
        }
        while (i < str.length()) {
            int indexOf = str.indexOf(47, i);
            int indexOf2 = str.indexOf(92, i);
            if (indexOf != -1 && indexOf2 != -1) {
                max = Math.min(indexOf, indexOf2);
            } else if (indexOf != -1 && indexOf2 != -1) {
                max = 0;
            } else {
                max = Math.max(indexOf, indexOf2);
            }
            if (max == -1) {
                substring = str.substring(i);
                i2 = str.length();
            } else {
                substring = str.substring(i, max);
                i2 = max + 1;
            }
            if (!substring.equals(FileUtils.FILE_EXTENSION_SEPARATOR)) {
                if (substring.equals("..")) {
                    xxixoiio.oIX0oI(f2183X0o0xo);
                } else {
                    xxixoiio.II0xO0(IO.I0Io(substring, o0xOxO));
                }
            }
            if (i2 < str.length()) {
                xxixoiio.oIX0oI(f2186oxoX);
            }
            i = i2;
        }
        return xxixoiio.oxoX();
    }

    public static byte[] oIX0oI(String str, xIoXXXIXo.O0xOxO o0xOxO) {
        if (str.startsWith("http:")) {
            return I0Io(str, o0xOxO);
        }
        return II0xO0(str, o0xOxO);
    }
}
