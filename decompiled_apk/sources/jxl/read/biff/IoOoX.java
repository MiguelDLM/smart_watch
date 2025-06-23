package jxl.read.biff;

import com.tenmeter.smlibrary.utils.FileUtils;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/* loaded from: classes6.dex */
public class IoOoX extends OoIXo.Xx000oIo implements xIoXXXIXo.oO {

    /* renamed from: oO, reason: collision with root package name */
    public static final II0xO0 f28198oO;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f28199oOoXoXO = XxIIOXIXx.X0o0xo.Oxx0IOOO(IoOoX.class);

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final II0xO0 f28200ooOOo0oXI;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final II0xO0 f28201x0XOIxOo;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public static final II0xO0 f28202x0xO0oo;

    /* renamed from: I0Io, reason: collision with root package name */
    public int f28203I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public File f28204II0XooXoX;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public II0xO0 f28205OOXIXo;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public URL f28206Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public int f28207X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public int f28208XO;

    /* renamed from: oxoX, reason: collision with root package name */
    public int f28209oxoX;

    /* renamed from: xoIox, reason: collision with root package name */
    public OoIXo.X00IoxXI f28210xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public String f28211xxIXOIIO;

    /* loaded from: classes6.dex */
    public static class II0xO0 {
        public II0xO0() {
        }
    }

    static {
        f28200ooOOo0oXI = new II0xO0();
        f28201x0XOIxOo = new II0xO0();
        f28198oO = new II0xO0();
        f28202x0xO0oo = new II0xO0();
    }

    public IoOoX(xoxXI xoxxi, xIoXXXIXo.IIXOooo iIXOooo, xIoXXXIXo.O0xOxO o0xOxO) {
        super(xoxxi);
        boolean z;
        int i;
        boolean z2;
        int i2;
        this.f28205OOXIXo = f28202x0xO0oo;
        byte[] I0Io2 = oxXx0IX().I0Io();
        this.f28203I0Io = OoIXo.oo0xXOI0I.I0Io(I0Io2[0], I0Io2[1]);
        this.f28209oxoX = OoIXo.oo0xXOI0I.I0Io(I0Io2[2], I0Io2[3]);
        this.f28207X0o0xo = OoIXo.oo0xXOI0I.I0Io(I0Io2[4], I0Io2[5]);
        int I0Io3 = OoIXo.oo0xXOI0I.I0Io(I0Io2[6], I0Io2[7]);
        this.f28208XO = I0Io3;
        this.f28210xoIox = new OoIXo.X00IoxXI(iIXOooo, this.f28207X0o0xo, this.f28203I0Io, I0Io3, this.f28209oxoX);
        int oxoX2 = OoIXo.oo0xXOI0I.oxoX(I0Io2[28], I0Io2[29], I0Io2[30], I0Io2[31]);
        if ((oxoX2 & 20) != 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            i = (OoIXo.oo0xXOI0I.oxoX(I0Io2[32], I0Io2[33], I0Io2[34], I0Io2[35]) * 2) + 4;
        } else {
            i = 0;
        }
        int i3 = 32 + i;
        if ((oxoX2 & 128) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            i2 = (OoIXo.oo0xXOI0I.oxoX(I0Io2[i3], I0Io2[i + 33], I0Io2[i + 34], I0Io2[i + 35]) * 2) + 4;
        } else {
            i2 = 0;
        }
        int i4 = i3 + i2;
        if ((oxoX2 & 3) == 3) {
            this.f28205OOXIXo = f28200ooOOo0oXI;
            if (I0Io2[i4] == 3) {
                this.f28205OOXIXo = f28201x0XOIxOo;
            }
        } else if ((oxoX2 & 1) != 0) {
            this.f28205OOXIXo = f28201x0XOIxOo;
            if (I0Io2[i4] == -32) {
                this.f28205OOXIXo = f28200ooOOo0oXI;
            }
        } else if ((oxoX2 & 8) != 0) {
            this.f28205OOXIXo = f28198oO;
        }
        II0xO0 iI0xO0 = this.f28205OOXIXo;
        if (iI0xO0 == f28200ooOOo0oXI) {
            String str = null;
            try {
                try {
                    str = OoIXo.IO.Oxx0IOOO(I0Io2, (OoIXo.oo0xXOI0I.oxoX(I0Io2[i4 + 16], I0Io2[i4 + 17], I0Io2[i4 + 18], I0Io2[i4 + 19]) / 2) - 1, i4 + 20);
                    this.f28206Oxx0IOOO = new URL(str);
                    return;
                } catch (MalformedURLException unused) {
                    return;
                }
            } catch (MalformedURLException unused2) {
                f28199oOoXoXO.ooOOo0oXI("URL " + str + " is malformed.  Trying a file");
                try {
                    this.f28205OOXIXo = f28201x0XOIxOo;
                    this.f28204II0XooXoX = new File(str);
                } catch (Exception unused3) {
                    f28199oOoXoXO.ooOOo0oXI("Cannot set to file.  Setting a default URL");
                    this.f28205OOXIXo = f28200ooOOo0oXI;
                    this.f28206Oxx0IOOO = new URL("http://www.andykhan.com/jexcelapi/index.html");
                }
                return;
            } catch (Throwable th) {
                StringBuffer stringBuffer = new StringBuffer();
                StringBuffer stringBuffer2 = new StringBuffer();
                xIoXXXIXo.XO.Oxx0IOOO(this.f28207X0o0xo, this.f28203I0Io, stringBuffer);
                xIoXXXIXo.XO.Oxx0IOOO(this.f28208XO, this.f28209oxoX, stringBuffer2);
                stringBuffer.insert(0, "Exception when parsing URL ");
                stringBuffer.append('\"');
                stringBuffer.append(stringBuffer2.toString());
                stringBuffer.append("\".  Using default.");
                f28199oOoXoXO.x0XOIxOo(stringBuffer, th);
                this.f28206Oxx0IOOO = new URL("http://www.andykhan.com/jexcelapi/index.html");
                return;
            }
        }
        if (iI0xO0 == f28201x0XOIxOo) {
            try {
                int I0Io4 = OoIXo.oo0xXOI0I.I0Io(I0Io2[i4 + 16], I0Io2[i4 + 17]);
                String oxoX3 = OoIXo.IO.oxoX(I0Io2, OoIXo.oo0xXOI0I.oxoX(I0Io2[i4 + 18], I0Io2[i4 + 19], I0Io2[i4 + 20], I0Io2[i4 + 21]) - 1, i4 + 22, o0xOxO);
                StringBuffer stringBuffer3 = new StringBuffer();
                for (int i5 = 0; i5 < I0Io4; i5++) {
                    stringBuffer3.append("..\\");
                }
                stringBuffer3.append(oxoX3);
                this.f28204II0XooXoX = new File(stringBuffer3.toString());
                return;
            } catch (Throwable th2) {
                f28199oOoXoXO.ooOOo0oXI("Exception when parsing file " + th2.getClass().getName() + FileUtils.FILE_EXTENSION_SEPARATOR);
                this.f28204II0XooXoX = new File(FileUtils.FILE_EXTENSION_SEPARATOR);
                return;
            }
        }
        if (iI0xO0 == f28198oO) {
            this.f28211xxIXOIIO = OoIXo.IO.Oxx0IOOO(I0Io2, OoIXo.oo0xXOI0I.oxoX(I0Io2[32], I0Io2[33], I0Io2[34], I0Io2[35]) - 1, 36);
        } else {
            f28199oOoXoXO.ooOOo0oXI("Cannot determine link type");
        }
    }

    @Override // xIoXXXIXo.oO
    public xIoXXXIXo.OxxIIOOXO II0XooXoX() {
        return this.f28210xoIox;
    }

    @Override // xIoXXXIXo.oO
    public int II0xO0() {
        return this.f28203I0Io;
    }

    @Override // xIoXXXIXo.oO
    public URL IIXOooo() {
        return this.f28206Oxx0IOOO;
    }

    @Override // xIoXXXIXo.oO
    public File Oo() {
        return this.f28204II0XooXoX;
    }

    @Override // xIoXXXIXo.oO
    public int Oxx0xo() {
        return this.f28209oxoX;
    }

    @Override // xIoXXXIXo.oO
    public int Xx000oIo() {
        return this.f28208XO;
    }

    @Override // xIoXXXIXo.oO
    public int oIX0oI() {
        return this.f28207X0o0xo;
    }

    @Override // xIoXXXIXo.oO
    public boolean ooOOo0oXI() {
        if (this.f28205OOXIXo == f28201x0XOIxOo) {
            return true;
        }
        return false;
    }

    @Override // xIoXXXIXo.oO
    public boolean ooXIXxIX() {
        if (this.f28205OOXIXo == f28198oO) {
            return true;
        }
        return false;
    }

    @Override // OoIXo.Xx000oIo
    public xoxXI oxXx0IX() {
        return super.oxXx0IX();
    }

    @Override // xIoXXXIXo.oO
    public boolean x0XOIxOo() {
        if (this.f28205OOXIXo == f28200ooOOo0oXI) {
            return true;
        }
        return false;
    }

    public String xo0x() {
        return this.f28211xxIXOIIO;
    }
}
