package jxl.write.biff;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes6.dex */
public class xXxxox0I extends OoIXo.OI0 {

    /* renamed from: X0o0xo, reason: collision with root package name */
    public byte[] f29028X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public ArrayList f29029XO;

    /* loaded from: classes6.dex */
    public static class oIX0oI {

        /* renamed from: I0Io, reason: collision with root package name */
        public int f29030I0Io;

        /* renamed from: II0xO0, reason: collision with root package name */
        public int f29031II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public int f29032oIX0oI;

        public oIX0oI(int i, int i2, int i3) {
            this.f29032oIX0oI = i;
            this.f29031II0xO0 = i2;
            this.f29030I0Io = i3;
        }

        public void II0xO0(int i) {
            if (this.f29031II0xO0 == i) {
                this.f29031II0xO0 = 0;
            }
            if (this.f29030I0Io == i) {
                this.f29030I0Io = 0;
            }
            int i2 = this.f29031II0xO0;
            if (i2 > i) {
                this.f29031II0xO0 = i2 - 1;
            }
            int i3 = this.f29030I0Io;
            if (i3 > i) {
                this.f29030I0Io = i3 - 1;
            }
        }

        public void oIX0oI(int i) {
            int i2 = this.f29031II0xO0;
            if (i2 >= i) {
                this.f29031II0xO0 = i2 + 1;
            }
            int i3 = this.f29030I0Io;
            if (i3 >= i) {
                this.f29030I0Io = i3 + 1;
            }
        }
    }

    public xXxxox0I(jxl.read.biff.XI0IXoo xI0IXoo) {
        super(OoIXo.xII.f2418II0XooXoX);
        this.f29029XO = new ArrayList(xI0IXoo.I0X0x0oIo());
        for (int i = 0; i < xI0IXoo.I0X0x0oIo(); i++) {
            this.f29029XO.add(new oIX0oI(xI0IXoo.oX(i), xI0IXoo.xXOx(i), xI0IXoo.XX0(i)));
        }
    }

    public int I0X0x0oIo(int i, int i2) {
        Iterator it = this.f29029XO.iterator();
        boolean z = false;
        int i3 = 0;
        while (it.hasNext() && !z) {
            oIX0oI oix0oi = (oIX0oI) it.next();
            if (oix0oi.f29032oIX0oI == i && oix0oi.f29031II0xO0 == i2) {
                z = true;
            } else {
                i3++;
            }
        }
        if (!z) {
            this.f29029XO.add(new oIX0oI(i, i2, i2));
            return this.f29029XO.size() - 1;
        }
        return i3;
    }

    public void O0Xx(int i) {
        Iterator it = this.f29029XO.iterator();
        while (it.hasNext()) {
            ((oIX0oI) it.next()).II0xO0(i);
        }
    }

    public int XX0(int i) {
        return ((oIX0oI) this.f29029XO.get(i)).f29031II0xO0;
    }

    public int Xo0(int i) {
        return ((oIX0oI) this.f29029XO.get(i)).f29032oIX0oI;
    }

    public void XoI0Ixx0(int i) {
        Iterator it = this.f29029XO.iterator();
        while (it.hasNext()) {
            ((oIX0oI) it.next()).oIX0oI(i);
        }
    }

    public int oX(int i) {
        return ((oIX0oI) this.f29029XO.get(i)).f29030I0Io;
    }

    @Override // OoIXo.OI0
    public byte[] xo0x() {
        int i = 2;
        byte[] bArr = new byte[(this.f29029XO.size() * 6) + 2];
        OoIXo.oo0xXOI0I.XO(this.f29029XO.size(), bArr, 0);
        Iterator it = this.f29029XO.iterator();
        while (it.hasNext()) {
            oIX0oI oix0oi = (oIX0oI) it.next();
            OoIXo.oo0xXOI0I.XO(oix0oi.f29032oIX0oI, bArr, i);
            OoIXo.oo0xXOI0I.XO(oix0oi.f29031II0xO0, bArr, i + 2);
            OoIXo.oo0xXOI0I.XO(oix0oi.f29030I0Io, bArr, i + 4);
            i += 6;
        }
        return bArr;
    }

    public xXxxox0I() {
        super(OoIXo.xII.f2418II0XooXoX);
        this.f29029XO = new ArrayList();
    }
}
