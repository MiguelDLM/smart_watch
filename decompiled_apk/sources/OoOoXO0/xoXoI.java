package OoOoXO0;

import java.io.UnsupportedEncodingException;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;

/* loaded from: classes6.dex */
public class xoXoI {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final String f2665I0Io = "/";

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f2666II0XooXoX = 1;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final String f2667Oxx0IOOO = "#+";

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final String f2668X0o0xo = "+";

    /* renamed from: XO, reason: collision with root package name */
    public static final String f2669XO = "/#";

    /* renamed from: oxoX, reason: collision with root package name */
    public static final String f2670oxoX = "#";

    /* renamed from: xoIox, reason: collision with root package name */
    public static final char f2671xoIox = 0;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f2672xxIXOIIO = 65535;

    /* renamed from: II0xO0, reason: collision with root package name */
    public String f2673II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public Ox0XO.II0xO0 f2674oIX0oI;

    public xoXoI(String str, Ox0XO.II0xO0 iI0xO0) {
        this.f2674oIX0oI = iI0xO0;
        this.f2673II0xO0 = str;
    }

    public static boolean I0Io(String str, String str2) throws IllegalStateException, IllegalArgumentException {
        int length = str2.length();
        int length2 = str.length();
        XO(str, true);
        XO(str2, false);
        if (str.equals(str2)) {
            return true;
        }
        int i = 0;
        int i2 = 0;
        while (i < length2 && i2 < length && ((str2.charAt(i2) != '/' || str.charAt(i) == '/') && (str.charAt(i) == '+' || str.charAt(i) == '#' || str.charAt(i) == str2.charAt(i2)))) {
            if (str.charAt(i) == '+') {
                int i3 = i2 + 1;
                while (i3 < length && str2.charAt(i3) != '/') {
                    i3 = i2 + 2;
                    i2++;
                }
            } else if (str.charAt(i) == '#') {
                i2 = length - 1;
            }
            i++;
            i2++;
        }
        if (i2 == length && i == length2) {
            return true;
        }
        return false;
    }

    public static void Oxx0IOOO(String str) {
        char c;
        char c2;
        char charAt = f2668X0o0xo.charAt(0);
        char charAt2 = "/".charAt(0);
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        int i = 0;
        while (i < length) {
            int i2 = i - 1;
            if (i2 >= 0) {
                c = charArray[i2];
            } else {
                c = 0;
            }
            int i3 = i + 1;
            if (i3 < length) {
                c2 = charArray[i3];
            } else {
                c2 = 0;
            }
            if (charArray[i] == charAt && ((c != charAt2 && c != 0) || (c2 != charAt2 && c2 != 0))) {
                throw new IllegalArgumentException(String.format("Invalid usage of single-level wildcard in topic string '%s'!", str));
            }
            i = i3;
        }
    }

    public static void XO(String str, boolean z) throws IllegalStateException, IllegalArgumentException {
        try {
            int length = str.getBytes("UTF-8").length;
            if (length >= 1 && length <= 65535) {
                if (z) {
                    if (XOx.II0xO0.oxoX(str, new String[]{f2670oxoX, f2668X0o0xo})) {
                        return;
                    }
                    if (XOx.II0xO0.I0Io(str, f2670oxoX) <= 1 && (!str.contains(f2670oxoX) || str.endsWith(f2669XO))) {
                        Oxx0IOOO(str);
                        return;
                    } else {
                        StringBuffer stringBuffer = new StringBuffer("Invalid usage of multi-level wildcard in topic string: ");
                        stringBuffer.append(str);
                        throw new IllegalArgumentException(stringBuffer.toString());
                    }
                }
                if (!XOx.II0xO0.oIX0oI(str, f2667Oxx0IOOO)) {
                    return;
                } else {
                    throw new IllegalArgumentException("The topic name MUST NOT contain any wildcard characters (#+)");
                }
            }
            throw new IllegalArgumentException(String.format("Invalid topic length, should be in range[%d, %d]!", new Integer(1), new Integer(65535)));
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException(e);
        }
    }

    public String II0xO0() {
        return this.f2673II0xO0;
    }

    public IXxxXO X0o0xo(byte[] bArr, int i, boolean z) throws MqttException, MqttPersistenceException {
        Oxx0xo oxx0xo = new Oxx0xo(bArr);
        oxx0xo.setQos(i);
        oxx0xo.setRetained(z);
        return oxoX(oxx0xo);
    }

    public final IXIIo.oO oIX0oI(Oxx0xo oxx0xo) {
        return new IXIIo.oO(II0xO0(), oxx0xo);
    }

    public IXxxXO oxoX(Oxx0xo oxx0xo) throws MqttException, MqttPersistenceException {
        IXxxXO iXxxXO = new IXxxXO(this.f2674oIX0oI.o00().getClientId());
        iXxxXO.oIX0oI(oxx0xo);
        this.f2674oIX0oI.OI0(oIX0oI(oxx0xo), iXxxXO);
        iXxxXO.f2606oIX0oI.xI();
        return iXxxXO;
    }

    public String toString() {
        return II0xO0();
    }
}
