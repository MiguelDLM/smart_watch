package OoIXo;

import jxl.read.biff.xoxXI;

/* loaded from: classes6.dex */
public abstract class OI0 extends Xx000oIo implements xoIox {

    /* renamed from: I0Io, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f2087I0Io = XxIIOXIXx.X0o0xo.Oxx0IOOO(OI0.class);

    /* renamed from: oxoX, reason: collision with root package name */
    public static final int f2088oxoX = 8228;

    public OI0(xII xii) {
        super(xii);
    }

    @Override // OoIXo.xoIox
    public final byte[] I0Io() {
        byte[] xo0x2 = xo0x();
        int length = xo0x2.length;
        if (xo0x2.length > 8224) {
            xo0x2 = xXOx(xo0x2);
            length = 8224;
        }
        byte[] bArr = new byte[xo0x2.length + 4];
        System.arraycopy(xo0x2, 0, bArr, 4, xo0x2.length);
        oo0xXOI0I.XO(XoX(), bArr, 0);
        oo0xXOI0I.XO(length, bArr, 2);
        return bArr;
    }

    public final byte[] xXOx(byte[] bArr) {
        int length = ((bArr.length - 8224) / 8224) + 1;
        byte[] bArr2 = new byte[bArr.length + (length * 4)];
        System.arraycopy(bArr, 0, bArr2, 0, 8224);
        int i = 8224;
        int i2 = 8224;
        for (int i3 = 0; i3 < length; i3++) {
            int min = Math.min(bArr.length - i, 8224);
            oo0xXOI0I.XO(xII.f2528xoXoI.f2535oIX0oI, bArr2, i2);
            oo0xXOI0I.XO(min, bArr2, i2 + 2);
            System.arraycopy(bArr, i, bArr2, i2 + 4, min);
            i += min;
            i2 += min + 4;
        }
        return bArr2;
    }

    public abstract byte[] xo0x();

    public OI0(xoxXI xoxxi) {
        super(xoxxi);
    }
}
