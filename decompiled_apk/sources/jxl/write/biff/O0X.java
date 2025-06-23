package jxl.write.biff;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes6.dex */
public class O0X extends OoIXo.OI0 {

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static int f28653oOoXoXO = 8224;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public ArrayList f28654II0XooXoX;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public int f28655OOXIXo;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public int f28656Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public String f28657X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public boolean f28658XO;

    /* renamed from: xoIox, reason: collision with root package name */
    public byte[] f28659xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public ArrayList f28660xxIXOIIO;

    public O0X() {
        super(OoIXo.xII.f2528xoXoI);
        this.f28655OOXIXo = 0;
        this.f28654II0XooXoX = new ArrayList(50);
        this.f28660xxIXOIIO = new ArrayList(50);
    }

    public int I0X0x0oIo() {
        return this.f28655OOXIXo;
    }

    public int XX0(String str) {
        int length = (str.length() * 2) + 3;
        if (this.f28655OOXIXo >= f28653oOoXoXO - 5) {
            return str.length();
        }
        this.f28660xxIXOIIO.add(new Integer(str.length()));
        int i = this.f28655OOXIXo;
        int i2 = length + i;
        int i3 = f28653oOoXoXO;
        if (i2 < i3) {
            this.f28654II0XooXoX.add(str);
            this.f28655OOXIXo += length;
            return 0;
        }
        int i4 = (i3 - 3) - i;
        if (i4 % 2 != 0) {
            i4--;
        }
        int i5 = i4 / 2;
        this.f28654II0XooXoX.add(str.substring(0, i5));
        this.f28655OOXIXo += (i5 * 2) + 3;
        return str.length() - i5;
    }

    public int oX(String str, boolean z) {
        int length;
        int i;
        this.f28658XO = z;
        this.f28656Oxx0IOOO = str.length();
        if (!this.f28658XO) {
            length = (str.length() * 2) + 1;
        } else {
            length = (str.length() * 2) + 3;
        }
        int i2 = f28653oOoXoXO;
        if (length <= i2) {
            this.f28657X0o0xo = str;
            this.f28655OOXIXo += length;
            return 0;
        }
        if (this.f28658XO) {
            i = i2 - 4;
        } else {
            i = i2 - 2;
        }
        int i3 = i / 2;
        this.f28657X0o0xo = str.substring(0, i3);
        this.f28655OOXIXo = f28653oOoXoXO - 1;
        return str.length() - i3;
    }

    @Override // OoIXo.OI0
    public byte[] xo0x() {
        int i;
        byte[] bArr = new byte[this.f28655OOXIXo];
        this.f28659xoIox = bArr;
        int i2 = 0;
        if (this.f28658XO) {
            OoIXo.oo0xXOI0I.XO(this.f28656Oxx0IOOO, bArr, 0);
            this.f28659xoIox[2] = 1;
            i = 3;
        } else {
            bArr[0] = 1;
            i = 1;
        }
        OoIXo.IO.X0o0xo(this.f28657X0o0xo, this.f28659xoIox, i);
        int length = i + (this.f28657X0o0xo.length() * 2);
        Iterator it = this.f28654II0XooXoX.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            OoIXo.oo0xXOI0I.XO(((Integer) this.f28660xxIXOIIO.get(i2)).intValue(), this.f28659xoIox, length);
            byte[] bArr2 = this.f28659xoIox;
            bArr2[length + 2] = 1;
            OoIXo.IO.X0o0xo(str, bArr2, length + 3);
            length += (str.length() * 2) + 3;
            i2++;
        }
        return this.f28659xoIox;
    }
}
