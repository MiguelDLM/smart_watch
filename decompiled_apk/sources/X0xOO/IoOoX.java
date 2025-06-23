package X0xOO;

import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;

/* loaded from: classes6.dex */
public class IoOoX {

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static byte[] f3325xxIXOIIO = {-119, 80, 78, 71, 13, 10, 26, 10};

    /* renamed from: I0Io, reason: collision with root package name */
    public Oxx0IOOO f3326I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public int f3327II0XooXoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    public Oxx0IOOO f3328II0xO0;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public int f3329Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public int f3330X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public int f3331XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public byte[] f3332oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public int f3333oxoX;

    public IoOoX(byte[] bArr) {
        this.f3332oIX0oI = bArr;
    }

    public static void XO(String[] strArr) {
        try {
            File file = new File(strArr[0]);
            byte[] bArr = new byte[(int) file.length()];
            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.read(bArr);
            fileInputStream.close();
            new IoOoX(bArr).Oxx0IOOO();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final int I0Io(byte b, byte b2, byte b3, byte b4) {
        return ((b & 255) << 24) | ((b2 & 255) << 16) | ((b3 & 255) << 8) | (b4 & 255);
    }

    public int II0xO0() {
        if (this.f3327II0XooXoX == 1) {
            return this.f3329Oxx0IOOO;
        }
        return 0;
    }

    public void Oxx0IOOO() {
        int length = f3325xxIXOIIO.length;
        byte[] bArr = new byte[length];
        System.arraycopy(this.f3332oIX0oI, 0, bArr, 0, length);
        if (!Arrays.equals(f3325xxIXOIIO, bArr)) {
            return;
        }
        int i = 8;
        while (true) {
            byte[] bArr2 = this.f3332oIX0oI;
            if (i >= bArr2.length) {
                break;
            }
            int I0Io2 = I0Io(bArr2[i], bArr2[i + 1], bArr2[i + 2], bArr2[i + 3]);
            byte[] bArr3 = this.f3332oIX0oI;
            II0XooXoX oIX0oI2 = II0XooXoX.oIX0oI(bArr3[i + 4], bArr3[i + 5], bArr3[i + 6], bArr3[i + 7]);
            if (oIX0oI2 == II0XooXoX.f3296oxoX) {
                this.f3328II0xO0 = new Oxx0IOOO(i + 8, I0Io2, oIX0oI2, this.f3332oIX0oI);
            } else if (oIX0oI2 == II0XooXoX.f3295XO) {
                this.f3326I0Io = new Oxx0IOOO(i + 8, I0Io2, oIX0oI2, this.f3332oIX0oI);
            }
            i += I0Io2 + 12;
        }
        byte[] oIX0oI3 = this.f3328II0xO0.oIX0oI();
        this.f3333oxoX = I0Io(oIX0oI3[0], oIX0oI3[1], oIX0oI3[2], oIX0oI3[3]);
        this.f3330X0o0xo = I0Io(oIX0oI3[4], oIX0oI3[5], oIX0oI3[6], oIX0oI3[7]);
        Oxx0IOOO oxx0IOOO = this.f3326I0Io;
        if (oxx0IOOO != null) {
            byte[] oIX0oI4 = oxx0IOOO.oIX0oI();
            this.f3327II0XooXoX = oIX0oI4[8];
            this.f3329Oxx0IOOO = I0Io(oIX0oI4[0], oIX0oI4[1], oIX0oI4[2], oIX0oI4[3]);
            this.f3331XO = I0Io(oIX0oI4[4], oIX0oI4[5], oIX0oI4[6], oIX0oI4[7]);
        }
    }

    public int X0o0xo() {
        return this.f3333oxoX;
    }

    public int oIX0oI() {
        return this.f3330X0o0xo;
    }

    public int oxoX() {
        if (this.f3327II0XooXoX == 1) {
            return this.f3331XO;
        }
        return 0;
    }
}
