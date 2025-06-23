package jxl.write.biff;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes6.dex */
public class IIX0 extends OoIXo.OI0 {

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static int f28574OOXIXo = 8216;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public ArrayList f28575II0XooXoX;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public ArrayList f28576Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public int f28577X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public int f28578XO;

    /* renamed from: xoIox, reason: collision with root package name */
    public int f28579xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public byte[] f28580xxIXOIIO;

    public IIX0(int i, int i2) {
        super(OoIXo.xII.f2487oI0IIXIo);
        this.f28577X0o0xo = i;
        this.f28578XO = i2;
        this.f28579xoIox = 0;
        this.f28576Oxx0IOOO = new ArrayList(50);
        this.f28575II0XooXoX = new ArrayList(50);
    }

    public int I0X0x0oIo() {
        return this.f28579xoIox + 8;
    }

    public int XX0(String str) {
        int length = (str.length() * 2) + 3;
        if (this.f28579xoIox >= f28574OOXIXo - 5) {
            if (str.length() > 0) {
                return str.length();
            }
            return -1;
        }
        this.f28575II0XooXoX.add(new Integer(str.length()));
        int i = this.f28579xoIox;
        int i2 = length + i;
        int i3 = f28574OOXIXo;
        if (i2 < i3) {
            this.f28576Oxx0IOOO.add(str);
            this.f28579xoIox += length;
            return 0;
        }
        int i4 = (i3 - 3) - i;
        if (i4 % 2 != 0) {
            i4--;
        }
        int i5 = i4 / 2;
        this.f28576Oxx0IOOO.add(str.substring(0, i5));
        this.f28579xoIox += (i5 * 2) + 3;
        return str.length() - i5;
    }

    @Override // OoIXo.OI0
    public byte[] xo0x() {
        int i = 8;
        byte[] bArr = new byte[this.f28579xoIox + 8];
        this.f28580xxIXOIIO = bArr;
        int i2 = 0;
        OoIXo.oo0xXOI0I.oIX0oI(this.f28577X0o0xo, bArr, 0);
        OoIXo.oo0xXOI0I.oIX0oI(this.f28578XO, this.f28580xxIXOIIO, 4);
        Iterator it = this.f28576Oxx0IOOO.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            OoIXo.oo0xXOI0I.XO(((Integer) this.f28575II0XooXoX.get(i2)).intValue(), this.f28580xxIXOIIO, i);
            byte[] bArr2 = this.f28580xxIXOIIO;
            bArr2[i + 2] = 1;
            OoIXo.IO.X0o0xo(str, bArr2, i + 3);
            i += (str.length() * 2) + 3;
            i2++;
        }
        return this.f28580xxIXOIIO;
    }
}
