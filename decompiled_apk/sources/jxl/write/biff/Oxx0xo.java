package jxl.write.biff;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes6.dex */
public class Oxx0xo extends OoIXo.OI0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public int f28687II0XooXoX;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public ArrayList f28688Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public int f28689X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public int f28690XO;

    public Oxx0xo(int i) {
        super(OoIXo.xII.f2455Oxx0xo);
        this.f28689X0o0xo = i;
        this.f28688Oxx0IOOO = new ArrayList(10);
    }

    public void I0X0x0oIo(int i) {
        this.f28690XO = i;
    }

    public void XX0(int i) {
        this.f28688Oxx0IOOO.add(new Integer(i));
    }

    public void oX(int i) {
        this.f28687II0XooXoX = i;
    }

    @Override // OoIXo.OI0
    public byte[] xo0x() {
        int i = 4;
        byte[] bArr = new byte[(this.f28688Oxx0IOOO.size() * 2) + 4];
        OoIXo.oo0xXOI0I.oIX0oI(this.f28687II0XooXoX - this.f28689X0o0xo, bArr, 0);
        int i2 = this.f28690XO;
        Iterator it = this.f28688Oxx0IOOO.iterator();
        while (it.hasNext()) {
            int intValue = ((Integer) it.next()).intValue();
            OoIXo.oo0xXOI0I.XO(intValue - i2, bArr, i);
            i += 2;
            i2 = intValue;
        }
        return bArr;
    }
}
