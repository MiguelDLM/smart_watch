package jxl.read.biff;

import java.util.ArrayList;

/* loaded from: classes6.dex */
public final class xoxXI {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final XxIIOXIXx.X0o0xo f28532II0XooXoX = XxIIOXIXx.X0o0xo.Oxx0IOOO(xoxXI.class);

    /* renamed from: I0Io, reason: collision with root package name */
    public int f28533I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public OoIXo.xII f28534II0xO0;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public ArrayList f28535Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public XIxXXX0x0 f28536X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public byte[] f28537XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public int f28538oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public int f28539oxoX;

    public xoxXI(byte[] bArr, int i, XIxXXX0x0 xIxXXX0x0) {
        this.f28538oIX0oI = OoIXo.oo0xXOI0I.I0Io(bArr[i], bArr[i + 1]);
        this.f28533I0Io = OoIXo.oo0xXOI0I.I0Io(bArr[i + 2], bArr[i + 3]);
        this.f28536X0o0xo = xIxXXX0x0;
        xIxXXX0x0.oOoXoXO(4);
        this.f28539oxoX = xIxXXX0x0.oxoX();
        this.f28536X0o0xo.oOoXoXO(this.f28533I0Io);
        this.f28534II0xO0 = OoIXo.xII.II0xO0(this.f28538oIX0oI);
    }

    public byte[] I0Io() {
        if (this.f28537XO == null) {
            this.f28537XO = this.f28536X0o0xo.xxIXOIIO(this.f28539oxoX, this.f28533I0Io);
        }
        ArrayList arrayList = this.f28535Oxx0IOOO;
        if (arrayList != null) {
            int size = arrayList.size();
            byte[][] bArr = new byte[size];
            int i = 0;
            for (int i2 = 0; i2 < this.f28535Oxx0IOOO.size(); i2++) {
                byte[] I0Io2 = ((xoxXI) this.f28535Oxx0IOOO.get(i2)).I0Io();
                bArr[i2] = I0Io2;
                i += I0Io2.length;
            }
            byte[] bArr2 = this.f28537XO;
            byte[] bArr3 = new byte[bArr2.length + i];
            System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
            int length = this.f28537XO.length;
            for (int i3 = 0; i3 < size; i3++) {
                byte[] bArr4 = bArr[i3];
                System.arraycopy(bArr4, 0, bArr3, length, bArr4.length);
                length += bArr4.length;
            }
            this.f28537XO = bArr3;
        }
        return this.f28537XO;
    }

    public int II0xO0() {
        return this.f28538oIX0oI;
    }

    public OoIXo.xII X0o0xo() {
        return this.f28534II0xO0;
    }

    public void XO(OoIXo.xII xii) {
        this.f28534II0xO0 = xii;
    }

    public void oIX0oI(xoxXI xoxxi) {
        if (this.f28535Oxx0IOOO == null) {
            this.f28535Oxx0IOOO = new ArrayList();
        }
        this.f28535Oxx0IOOO.add(xoxxi);
    }

    public int oxoX() {
        return this.f28533I0Io;
    }
}
