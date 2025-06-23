package X0xOO;

import java.util.Arrays;

/* loaded from: classes6.dex */
public class II0XooXoX {

    /* renamed from: II0xO0, reason: collision with root package name */
    public String f3297II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public byte[] f3298oIX0oI;

    /* renamed from: I0Io, reason: collision with root package name */
    public static II0XooXoX[] f3292I0Io = new II0XooXoX[0];

    /* renamed from: oxoX, reason: collision with root package name */
    public static II0XooXoX f3296oxoX = new II0XooXoX(73, 72, 68, 82, "IHDR");

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static II0XooXoX f3294X0o0xo = new II0XooXoX(73, 69, 78, 68, "IEND");

    /* renamed from: XO, reason: collision with root package name */
    public static II0XooXoX f3295XO = new II0XooXoX(112, 72, 89, 115, "pHYs");

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static II0XooXoX f3293Oxx0IOOO = new II0XooXoX(255, 255, 255, 255, "UNKNOWN");

    public II0XooXoX(int i, int i2, int i3, int i4, String str) {
        this.f3298oIX0oI = new byte[]{(byte) i, (byte) i2, (byte) i3, (byte) i4};
        this.f3297II0xO0 = str;
        II0XooXoX[] iI0XooXoXArr = f3292I0Io;
        II0XooXoX[] iI0XooXoXArr2 = new II0XooXoX[iI0XooXoXArr.length + 1];
        System.arraycopy(iI0XooXoXArr, 0, iI0XooXoXArr2, 0, iI0XooXoXArr.length);
        iI0XooXoXArr2[f3292I0Io.length] = this;
        f3292I0Io = iI0XooXoXArr2;
    }

    public static II0XooXoX oIX0oI(byte b, byte b2, byte b3, byte b4) {
        int i = 0;
        byte[] bArr = {b, b2, b3, b4};
        II0XooXoX iI0XooXoX = f3293Oxx0IOOO;
        boolean z = false;
        while (true) {
            II0XooXoX[] iI0XooXoXArr = f3292I0Io;
            if (i >= iI0XooXoXArr.length || z) {
                break;
            }
            if (Arrays.equals(iI0XooXoXArr[i].f3298oIX0oI, bArr)) {
                iI0XooXoX = f3292I0Io[i];
                z = true;
            }
            i++;
        }
        return iI0XooXoX;
    }

    public String II0xO0() {
        return this.f3297II0xO0;
    }
}
