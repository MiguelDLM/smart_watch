package jxl.write.biff;

/* loaded from: classes6.dex */
public class O0Xx extends OoIXo.XxX0x0xxx {

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f28661x0xO0oo = XxIIOXIXx.X0o0xo.Oxx0IOOO(O0Xx.class);

    /* loaded from: classes6.dex */
    public static class oIX0oI {
    }

    public O0Xx(String str) {
        XoI0Ixx0(O0Xx(Xo0(str, "E0", "E+0")));
    }

    public final String O0Xx(String str) {
        int indexOf = str.indexOf(35);
        int indexOf2 = str.indexOf(48);
        if (indexOf == -1 && indexOf2 == -1) {
            return "#.###";
        }
        if (indexOf != 0 && indexOf2 != 0 && indexOf != 1 && indexOf2 != 1) {
            if (indexOf == -1) {
                indexOf = Integer.MAX_VALUE;
            }
            if (indexOf2 == -1) {
                indexOf2 = Integer.MAX_VALUE;
            }
            int min = Math.min(indexOf, indexOf2);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str.charAt(0));
            stringBuffer.append(str.substring(min));
            str = stringBuffer.toString();
        }
        int lastIndexOf = str.lastIndexOf(35);
        int lastIndexOf2 = str.lastIndexOf(48);
        if (lastIndexOf != str.length() && lastIndexOf2 != str.length()) {
            int max = Math.max(lastIndexOf, lastIndexOf2);
            while (true) {
                max++;
                if (str.length() <= max || (str.charAt(max) != ')' && str.charAt(max) != '%')) {
                    break;
                }
            }
            return str.substring(0, max);
        }
        return str;
    }

    public O0Xx(String str, oIX0oI oix0oi) {
        XoI0Ixx0(Xo0(str, "E0", "E+0"));
    }
}
