package X0xOO;

import com.garmin.fit.OOxOOxIO;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes6.dex */
public class xI extends o00 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f3620II0XooXoX = XxIIOXIXx.X0o0xo.Oxx0IOOO(xI.class);

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public ArrayList f3621Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public byte[] f3622X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public int f3623XO;

    public xI(XI0IXoo xI0IXoo) {
        super(xI0IXoo);
        this.f3623XO = X0o0xo();
        Oo();
    }

    @Override // X0xOO.o00, X0xOO.X0IIOO
    public byte[] II0xO0() {
        String str;
        int size = this.f3621Oxx0IOOO.size();
        this.f3623XO = size;
        oOoXoXO(size);
        this.f3622X0o0xo = new byte[this.f3623XO * 6];
        Iterator it = this.f3621Oxx0IOOO.iterator();
        int i = 0;
        while (it.hasNext()) {
            oIX0oI oix0oi = (oIX0oI) it.next();
            int i2 = oix0oi.f3627oIX0oI & OOxOOxIO.f12624oIX0oI;
            if (oix0oi.f3625II0xO0) {
                i2 |= 16384;
            }
            if (oix0oi.f3624I0Io) {
                i2 |= 32768;
            }
            OoIXo.oo0xXOI0I.XO(i2, this.f3622X0o0xo, i);
            OoIXo.oo0xXOI0I.oIX0oI(oix0oi.f3628oxoX, this.f3622X0o0xo, i + 2);
            i += 6;
        }
        Iterator it2 = this.f3621Oxx0IOOO.iterator();
        while (it2.hasNext()) {
            oIX0oI oix0oi2 = (oIX0oI) it2.next();
            if (oix0oi2.f3624I0Io && (str = oix0oi2.f3626X0o0xo) != null) {
                byte[] bArr = new byte[this.f3622X0o0xo.length + (str.length() * 2)];
                byte[] bArr2 = this.f3622X0o0xo;
                System.arraycopy(bArr2, 0, bArr, 0, bArr2.length);
                OoIXo.IO.X0o0xo(oix0oi2.f3626X0o0xo, bArr, this.f3622X0o0xo.length);
                this.f3622X0o0xo = bArr;
            }
        }
        return OOXIXo(this.f3622X0o0xo);
    }

    public final void Oo() {
        boolean z;
        this.f3621Oxx0IOOO = new ArrayList();
        byte[] oIX0oI2 = oIX0oI();
        int i = 0;
        for (int i2 = 0; i2 < this.f3623XO; i2++) {
            int I0Io2 = OoIXo.oo0xXOI0I.I0Io(oIX0oI2[i], oIX0oI2[i + 1]);
            int i3 = I0Io2 & OOxOOxIO.f12624oIX0oI;
            int oxoX2 = OoIXo.oo0xXOI0I.oxoX(oIX0oI2[i + 2], oIX0oI2[i + 3], oIX0oI2[i + 4], oIX0oI2[i + 5]);
            boolean z2 = true;
            if ((I0Io2 & 16384) != 0) {
                z = true;
            } else {
                z = false;
            }
            if ((I0Io2 & 32768) == 0) {
                z2 = false;
            }
            i += 6;
            this.f3621Oxx0IOOO.add(new oIX0oI(i3, z, z2, oxoX2));
        }
        Iterator it = this.f3621Oxx0IOOO.iterator();
        while (it.hasNext()) {
            oIX0oI oix0oi = (oIX0oI) it.next();
            if (oix0oi.f3624I0Io) {
                oix0oi.f3626X0o0xo = OoIXo.IO.Oxx0IOOO(oIX0oI2, oix0oi.f3628oxoX / 2, i);
                i += oix0oi.f3628oxoX;
            }
        }
    }

    public void oO(int i, boolean z, boolean z2, int i2, String str) {
        this.f3621Oxx0IOOO.add(new oIX0oI(i, z, z2, i2, str));
    }

    public void x0XOIxOo(int i, boolean z, boolean z2, int i2) {
        this.f3621Oxx0IOOO.add(new oIX0oI(i, z, z2, i2));
    }

    public oIX0oI x0xO0oo(int i) {
        Iterator it = this.f3621Oxx0IOOO.iterator();
        boolean z = false;
        oIX0oI oix0oi = null;
        while (it.hasNext() && !z) {
            oix0oi = (oIX0oI) it.next();
            if (oix0oi.f3627oIX0oI == i) {
                z = true;
            }
        }
        if (!z) {
            return null;
        }
        return oix0oi;
    }

    public xI() {
        super(XIxXXX0x0.f3425x0XOIxOo);
        this.f3621Oxx0IOOO = new ArrayList();
        ooOOo0oXI(3);
    }

    /* loaded from: classes6.dex */
    public static final class oIX0oI {

        /* renamed from: I0Io, reason: collision with root package name */
        public boolean f3624I0Io;

        /* renamed from: II0xO0, reason: collision with root package name */
        public boolean f3625II0xO0;

        /* renamed from: X0o0xo, reason: collision with root package name */
        public String f3626X0o0xo;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public int f3627oIX0oI;

        /* renamed from: oxoX, reason: collision with root package name */
        public int f3628oxoX;

        public oIX0oI(int i, boolean z, boolean z2, int i2) {
            this.f3627oIX0oI = i;
            this.f3625II0xO0 = z;
            this.f3624I0Io = z2;
            this.f3628oxoX = i2;
        }

        public oIX0oI(int i, boolean z, boolean z2, int i2, String str) {
            this.f3627oIX0oI = i;
            this.f3625II0xO0 = z;
            this.f3624I0Io = z2;
            this.f3628oxoX = i2;
            this.f3626X0o0xo = str;
        }
    }
}
