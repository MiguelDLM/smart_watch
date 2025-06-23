package OoIXo;

import androidx.core.internal.view.SupportMenu;

/* loaded from: classes6.dex */
public final class oo0xXOI0I {
    public static int I0Io(byte b, byte b2) {
        return (b & 255) | ((b2 & 255) << 8);
    }

    public static byte[] II0xO0(int i) {
        byte[] bArr = new byte[4];
        int i2 = 65535 & i;
        int i3 = (i & SupportMenu.CATEGORY_MASK) >> 16;
        XO(i2, bArr, 0);
        XO(i3, bArr, 2);
        return bArr;
    }

    public static byte[] Oxx0IOOO(int i) {
        return new byte[]{(byte) (i & 255), (byte) ((i & 65280) >> 8)};
    }

    public static short X0o0xo(byte b, byte b2) {
        return (short) (((short) (b & 255)) | (((short) (b2 & 255)) << 8));
    }

    public static void XO(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) (i & 255);
        bArr[i2 + 1] = (byte) ((i & 65280) >> 8);
    }

    public static void oIX0oI(int i, byte[] bArr, int i2) {
        byte[] II0xO02 = II0xO0(i);
        bArr[i2] = II0xO02[0];
        bArr[i2 + 1] = II0xO02[1];
        bArr[i2 + 2] = II0xO02[2];
        bArr[i2 + 3] = II0xO02[3];
    }

    public static int oxoX(byte b, byte b2, byte b3, byte b4) {
        return I0Io(b, b2) | (I0Io(b3, b4) << 16);
    }
}
