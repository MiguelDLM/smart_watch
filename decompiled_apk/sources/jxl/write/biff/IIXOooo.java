package jxl.write.biff;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

/* loaded from: classes6.dex */
public abstract class IIXOooo extends oOoXoXO {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static final int f28589IXxxXO = 25569;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public static final long f28591Oxx0xo = 86400000;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public static final int f28592OxxIIOOXO = 61;

    /* renamed from: oO, reason: collision with root package name */
    public Date f28594oO;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public double f28595x0XOIxOo;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public boolean f28596x0xO0oo;

    /* renamed from: Oo, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f28590Oo = XxIIOXIXx.X0o0xo.Oxx0IOOO(IIXOooo.class);

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public static final oIXoXx0.IIXOooo f28593oI0IIXIo = new oIXoXx0.IIXOooo(oIXoXx0.xxIXOIIO.f31725II0xO0);

    /* loaded from: classes6.dex */
    public static final class oIX0oI {
    }

    public IIXOooo(int i, int i2, Date date) {
        this(i, i2, date, (oI0X0.X0o0xo) f28593oI0IIXIo, false);
    }

    @Override // xIoXXXIXo.I0Io
    public String IIX0o() {
        return this.f28594oO.toString();
    }

    public boolean IXxxXO() {
        return this.f28596x0xO0oo;
    }

    public final void O00XxXI(boolean z) {
        long j;
        long j2;
        if (z) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(this.f28594oO);
            j = calendar.get(15);
            j2 = calendar.get(16);
        } else {
            j = 0;
            j2 = 0;
        }
        double time = (((this.f28594oO.getTime() + j) + j2) / 8.64E7d) + 25569.0d;
        this.f28595x0XOIxOo = time;
        boolean z2 = this.f28596x0xO0oo;
        if (!z2 && time < 61.0d) {
            this.f28595x0XOIxOo = time - 1.0d;
        }
        if (z2) {
            this.f28595x0XOIxOo = this.f28595x0XOIxOo - ((int) r0);
        }
    }

    public void XI0oooXX(Date date, oIX0oI oix0oi) {
        this.f28594oO = date;
        O00XxXI(false);
    }

    @Override // xIoXXXIXo.I0Io
    public xIoXXXIXo.Oxx0IOOO getType() {
        return xIoXXXIXo.Oxx0IOOO.f34239oOoXoXO;
    }

    public Date oo0xXOI0I() {
        return this.f28594oO;
    }

    public void ox(Date date) {
        this.f28594oO = date;
        O00XxXI(true);
    }

    public DateFormat x0o() {
        return null;
    }

    @Override // jxl.write.biff.oOoXoXO, OoIXo.OI0
    public byte[] xo0x() {
        byte[] xo0x2 = super.xo0x();
        byte[] bArr = new byte[xo0x2.length + 8];
        System.arraycopy(xo0x2, 0, bArr, 0, xo0x2.length);
        OoIXo.OxI.oIX0oI(this.f28595x0XOIxOo, bArr, xo0x2.length);
        return bArr;
    }

    public IIXOooo(int i, int i2, Date date, oIX0oI oix0oi) {
        this(i, i2, date, (oI0X0.X0o0xo) f28593oI0IIXIo, false);
    }

    public IIXOooo(int i, int i2, Date date, oI0X0.X0o0xo x0o0xo) {
        super(OoIXo.xII.f2458X0IIOO, i, i2, x0o0xo);
        this.f28594oO = date;
        O00XxXI(true);
    }

    public IIXOooo(int i, int i2, Date date, oI0X0.X0o0xo x0o0xo, oIX0oI oix0oi) {
        super(OoIXo.xII.f2458X0IIOO, i, i2, x0o0xo);
        this.f28594oO = date;
        O00XxXI(false);
    }

    public IIXOooo(int i, int i2, Date date, oI0X0.X0o0xo x0o0xo, boolean z) {
        super(OoIXo.xII.f2458X0IIOO, i, i2, x0o0xo);
        this.f28594oO = date;
        this.f28596x0xO0oo = z;
        O00XxXI(false);
    }

    public IIXOooo(xIoXXXIXo.xxIXOIIO xxixoiio) {
        super(OoIXo.xII.f2458X0IIOO, xxixoiio);
        this.f28594oO = xxixoiio.oo0xXOI0I();
        this.f28596x0xO0oo = xxixoiio.IXxxXO();
        O00XxXI(false);
    }

    public IIXOooo(int i, int i2, IIXOooo iIXOooo) {
        super(OoIXo.xII.f2458X0IIOO, i, i2, iIXOooo);
        this.f28595x0XOIxOo = iIXOooo.f28595x0XOIxOo;
        this.f28596x0xO0oo = iIXOooo.f28596x0xO0oo;
        this.f28594oO = iIXOooo.f28594oO;
    }
}
