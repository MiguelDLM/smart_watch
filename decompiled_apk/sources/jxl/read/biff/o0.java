package jxl.read.biff;

import com.baidu.mobads.sdk.internal.cb;
import java.util.ArrayList;

/* loaded from: classes6.dex */
public class o0 extends OoIXo.Xx000oIo {

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f28319OOXIXo = 12;

    /* renamed from: oO, reason: collision with root package name */
    public static final int f28320oO = 41;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final int f28321oOoXoXO = 32;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final int f28322ooOOo0oXI = 58;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final int f28323x0XOIxOo = 59;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public static final int f28324x0xO0oo = 16;

    /* renamed from: I0Io, reason: collision with root package name */
    public String f28327I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public ArrayList f28328II0XooXoX;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public boolean f28329Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public int f28330X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public int f28331XO;

    /* renamed from: oxoX, reason: collision with root package name */
    public OoIXo.Oxx0IOOO f28332oxoX;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f28326xxIXOIIO = XxIIOXIXx.X0o0xo.Oxx0IOOO(o0.class);

    /* renamed from: xoIox, reason: collision with root package name */
    public static II0xO0 f28325xoIox = new II0xO0();

    /* loaded from: classes6.dex */
    public class I0Io {

        /* renamed from: I0Io, reason: collision with root package name */
        public int f28333I0Io;

        /* renamed from: II0xO0, reason: collision with root package name */
        public int f28334II0xO0;

        /* renamed from: X0o0xo, reason: collision with root package name */
        public int f28335X0o0xo;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public int f28337oIX0oI;

        /* renamed from: oxoX, reason: collision with root package name */
        public int f28338oxoX;

        public I0Io(int i, int i2, int i3, int i4, int i5) {
            this.f28337oIX0oI = i2;
            this.f28334II0xO0 = i3;
            this.f28333I0Io = i4;
            this.f28338oxoX = i5;
            this.f28335X0o0xo = i;
        }

        public int I0Io() {
            return this.f28334II0xO0;
        }

        public int II0xO0() {
            return this.f28337oIX0oI;
        }

        public int X0o0xo() {
            return this.f28338oxoX;
        }

        public int oIX0oI() {
            return this.f28335X0o0xo;
        }

        public int oxoX() {
            return this.f28333I0Io;
        }
    }

    /* loaded from: classes6.dex */
    public static class II0xO0 {
        public II0xO0() {
        }
    }

    public o0(xoxXI xoxxi, xIoXXXIXo.O0xOxO o0xOxO, int i) {
        super(xoxxi);
        byte b;
        this.f28331XO = 0;
        this.f28330X0o0xo = i;
        this.f28329Oxx0IOOO = true;
        try {
            this.f28328II0XooXoX = new ArrayList();
            byte[] I0Io2 = oxXx0IX().I0Io();
            int I0Io3 = OoIXo.oo0xXOI0I.I0Io(I0Io2[0], I0Io2[1]);
            byte b2 = I0Io2[3];
            this.f28331XO = OoIXo.oo0xXOI0I.I0Io(I0Io2[8], I0Io2[9]);
            if ((I0Io3 & 32) != 0) {
                this.f28332oxoX = OoIXo.Oxx0IOOO.oIX0oI(I0Io2[15]);
            } else {
                this.f28327I0Io = OoIXo.IO.oxoX(I0Io2, b2, 15, o0xOxO);
            }
            if ((I0Io3 & 12) != 0) {
                return;
            }
            int i2 = b2 + 15;
            byte b3 = I0Io2[i2];
            if (b3 == 58) {
                int I0Io4 = OoIXo.oo0xXOI0I.I0Io(I0Io2[b2 + 16], I0Io2[b2 + 17]);
                int I0Io5 = OoIXo.oo0xXOI0I.I0Io(I0Io2[b2 + 18], I0Io2[b2 + 19]);
                int I0Io6 = OoIXo.oo0xXOI0I.I0Io(I0Io2[b2 + 20], I0Io2[b2 + 21]);
                int i3 = I0Io6 & 255;
                XxIIOXIXx.oIX0oI.oIX0oI((I0Io6 & 786432) == 0);
                this.f28328II0XooXoX.add(new I0Io(I0Io4, i3, I0Io5, i3, I0Io5));
                return;
            }
            if (b3 == 59) {
                for (int i4 = i2; i4 < I0Io2.length; i4 += 11) {
                    int I0Io7 = OoIXo.oo0xXOI0I.I0Io(I0Io2[i4 + 1], I0Io2[i4 + 2]);
                    int I0Io8 = OoIXo.oo0xXOI0I.I0Io(I0Io2[i4 + 3], I0Io2[i4 + 4]);
                    int I0Io9 = OoIXo.oo0xXOI0I.I0Io(I0Io2[i4 + 5], I0Io2[i4 + 6]);
                    int I0Io10 = OoIXo.oo0xXOI0I.I0Io(I0Io2[i4 + 7], I0Io2[i4 + 8]);
                    int i5 = I0Io10 & 255;
                    XxIIOXIXx.oIX0oI.oIX0oI((I0Io10 & 786432) == 0);
                    int I0Io11 = OoIXo.oo0xXOI0I.I0Io(I0Io2[i4 + 9], I0Io2[i4 + 10]);
                    int i6 = I0Io11 & 255;
                    XxIIOXIXx.oIX0oI.oIX0oI((I0Io11 & 786432) == 0);
                    this.f28328II0XooXoX.add(new I0Io(I0Io7, i5, I0Io8, i6, I0Io9));
                }
                return;
            }
            if (b3 == 41) {
                if (i2 < I0Io2.length && b3 != 58 && b3 != 59) {
                    if (b3 == 41) {
                        i2 = b2 + 18;
                    } else if (b3 == 16) {
                        i2 = b2 + 16;
                    }
                }
                int i7 = i2;
                while (i7 < I0Io2.length) {
                    int I0Io12 = OoIXo.oo0xXOI0I.I0Io(I0Io2[i7 + 1], I0Io2[i7 + 2]);
                    int I0Io13 = OoIXo.oo0xXOI0I.I0Io(I0Io2[i7 + 3], I0Io2[i7 + 4]);
                    int I0Io14 = OoIXo.oo0xXOI0I.I0Io(I0Io2[i7 + 5], I0Io2[i7 + 6]);
                    int I0Io15 = OoIXo.oo0xXOI0I.I0Io(I0Io2[i7 + 7], I0Io2[i7 + 8]);
                    int i8 = I0Io15 & 255;
                    XxIIOXIXx.oIX0oI.oIX0oI((I0Io15 & 786432) == 0);
                    int I0Io16 = OoIXo.oo0xXOI0I.I0Io(I0Io2[i7 + 9], I0Io2[i7 + 10]);
                    int i9 = I0Io16 & 255;
                    XxIIOXIXx.oIX0oI.oIX0oI((I0Io16 & 786432) == 0);
                    int i10 = i7;
                    this.f28328II0XooXoX.add(new I0Io(I0Io12, i8, I0Io13, i9, I0Io14));
                    i7 = i10 + 11;
                    if (i7 < I0Io2.length && (b = I0Io2[i7]) != 58 && b != 59) {
                        if (b == 41) {
                            i7 = i10 + 14;
                        } else if (b == 16) {
                            i7 = i10 + 12;
                        }
                    }
                }
                return;
            }
            String str = this.f28327I0Io;
            if (str == null) {
                str = this.f28332oxoX.II0xO0();
            }
            f28326xxIXOIIO.ooOOo0oXI("Cannot read name ranges for " + str + " - setting to empty");
            this.f28328II0XooXoX.add(new I0Io(0, 0, 0, 0, 0));
        } catch (Throwable unused) {
            f28326xxIXOIIO.ooOOo0oXI("Cannot read name");
            this.f28327I0Io = cb.l;
        }
    }

    public I0Io[] I0X0x0oIo() {
        return (I0Io[]) this.f28328II0XooXoX.toArray(new I0Io[this.f28328II0XooXoX.size()]);
    }

    public void O0Xx(int i) {
        this.f28331XO = i;
    }

    public int XX0() {
        return this.f28330X0o0xo;
    }

    public boolean Xo0() {
        return this.f28329Oxx0IOOO;
    }

    public boolean XoI0Ixx0() {
        if (this.f28331XO == 0) {
            return true;
        }
        return false;
    }

    public String getName() {
        return this.f28327I0Io;
    }

    public int oX() {
        return this.f28331XO;
    }

    public byte[] xXOx() {
        return oxXx0IX().I0Io();
    }

    public OoIXo.Oxx0IOOO xo0x() {
        return this.f28332oxoX;
    }

    public o0(xoxXI xoxxi, xIoXXXIXo.O0xOxO o0xOxO, int i, II0xO0 iI0xO0) {
        super(xoxxi);
        byte b;
        this.f28331XO = 0;
        this.f28330X0o0xo = i;
        this.f28329Oxx0IOOO = false;
        try {
            this.f28328II0XooXoX = new ArrayList();
            byte[] I0Io2 = oxXx0IX().I0Io();
            byte b2 = I0Io2[3];
            this.f28331XO = OoIXo.oo0xXOI0I.I0Io(I0Io2[8], I0Io2[9]);
            this.f28327I0Io = OoIXo.IO.oxoX(I0Io2, b2, 14, o0xOxO);
            int i2 = b2 + 14;
            if (i2 >= I0Io2.length) {
                return;
            }
            byte b3 = I0Io2[i2];
            if (b3 == 58) {
                int I0Io3 = OoIXo.oo0xXOI0I.I0Io(I0Io2[b2 + 25], I0Io2[b2 + 26]);
                int I0Io4 = OoIXo.oo0xXOI0I.I0Io(I0Io2[b2 + 29], I0Io2[b2 + 30]);
                byte b4 = I0Io2[b2 + 31];
                this.f28328II0XooXoX.add(new I0Io(I0Io3, b4, I0Io4, b4, I0Io4));
                return;
            }
            if (b3 == 59) {
                for (int i3 = i2; i3 < I0Io2.length; i3 += 21) {
                    this.f28328II0XooXoX.add(new I0Io(OoIXo.oo0xXOI0I.I0Io(I0Io2[i3 + 11], I0Io2[i3 + 12]), I0Io2[i3 + 19], OoIXo.oo0xXOI0I.I0Io(I0Io2[i3 + 15], I0Io2[i3 + 16]), I0Io2[i3 + 20], OoIXo.oo0xXOI0I.I0Io(I0Io2[i3 + 17], I0Io2[i3 + 18])));
                }
                return;
            }
            if (b3 == 41) {
                if (i2 < I0Io2.length && b3 != 58 && b3 != 59) {
                    if (b3 == 41) {
                        i2 = b2 + 17;
                    } else if (b3 == 16) {
                        i2 = b2 + 15;
                    }
                }
                while (true) {
                    int i4 = i2;
                    while (i4 < I0Io2.length) {
                        this.f28328II0XooXoX.add(new I0Io(OoIXo.oo0xXOI0I.I0Io(I0Io2[i4 + 11], I0Io2[i4 + 12]), I0Io2[i4 + 19], OoIXo.oo0xXOI0I.I0Io(I0Io2[i4 + 15], I0Io2[i4 + 16]), I0Io2[i4 + 20], OoIXo.oo0xXOI0I.I0Io(I0Io2[i4 + 17], I0Io2[i4 + 18])));
                        i2 = i4 + 21;
                        if (i2 < I0Io2.length && (b = I0Io2[i2]) != 58 && b != 59) {
                            if (b == 41) {
                                i4 += 24;
                            } else {
                                i4 = b == 16 ? i4 + 22 : i4;
                            }
                        }
                    }
                    return;
                }
            }
        } catch (Throwable unused) {
            f28326xxIXOIIO.ooOOo0oXI("Cannot read name.");
            this.f28327I0Io = cb.l;
        }
    }
}
