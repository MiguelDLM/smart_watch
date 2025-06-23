package OoIXo;

/* loaded from: classes6.dex */
public class X00IoxXI implements xIoXXXIXo.OxxIIOOXO {

    /* renamed from: I0Io, reason: collision with root package name */
    public int f2176I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public int f2177II0xO0;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public int f2178X0o0xo;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public xIoXXXIXo.IIXOooo f2179oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public int f2180oxoX;

    public X00IoxXI(xIoXXXIXo.IIXOooo iIXOooo, int i, int i2, int i3, int i4) {
        this.f2179oIX0oI = iIXOooo;
        this.f2176I0Io = i2;
        this.f2178X0o0xo = i4;
        this.f2177II0xO0 = i;
        this.f2180oxoX = i3;
    }

    @Override // xIoXXXIXo.OxxIIOOXO
    public int I0Io() {
        return -1;
    }

    public void II0XooXoX(int i) {
        int i2 = this.f2180oxoX;
        if (i > i2) {
            return;
        }
        int i3 = this.f2177II0xO0;
        if (i < i3) {
            this.f2177II0xO0 = i3 - 1;
        }
        if (i < i2) {
            this.f2180oxoX = i2 - 1;
        }
    }

    @Override // xIoXXXIXo.OxxIIOOXO
    public xIoXXXIXo.I0Io II0xO0() {
        if (this.f2180oxoX < this.f2179oIX0oI.XoI0Ixx0() && this.f2178X0o0xo < this.f2179oIX0oI.OxxIIOOXO()) {
            return this.f2179oIX0oI.XX(this.f2180oxoX, this.f2178X0o0xo);
        }
        return new O0xOxO(this.f2180oxoX, this.f2178X0o0xo);
    }

    public boolean Oxx0IOOO(X00IoxXI x00IoxXI) {
        if (x00IoxXI == this) {
            return true;
        }
        if (this.f2178X0o0xo >= x00IoxXI.f2176I0Io && this.f2176I0Io <= x00IoxXI.f2178X0o0xo && this.f2180oxoX >= x00IoxXI.f2177II0xO0 && this.f2177II0xO0 <= x00IoxXI.f2180oxoX) {
            return true;
        }
        return false;
    }

    public void X0o0xo(int i) {
        int i2 = this.f2180oxoX;
        if (i > i2) {
            return;
        }
        int i3 = this.f2177II0xO0;
        if (i <= i3) {
            this.f2177II0xO0 = i3 + 1;
        }
        if (i <= i2) {
            this.f2180oxoX = i2 + 1;
        }
    }

    public void XO(int i) {
        int i2 = this.f2178X0o0xo;
        if (i > i2) {
            return;
        }
        int i3 = this.f2176I0Io;
        if (i <= i3) {
            this.f2176I0Io = i3 + 1;
        }
        if (i <= i2) {
            this.f2178X0o0xo = i2 + 1;
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof X00IoxXI)) {
            return false;
        }
        X00IoxXI x00IoxXI = (X00IoxXI) obj;
        if (this.f2177II0xO0 == x00IoxXI.f2177II0xO0 && this.f2180oxoX == x00IoxXI.f2180oxoX && this.f2176I0Io == x00IoxXI.f2176I0Io && this.f2178X0o0xo == x00IoxXI.f2178X0o0xo) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((65535 ^ this.f2176I0Io) ^ this.f2178X0o0xo) ^ this.f2177II0xO0) ^ this.f2180oxoX;
    }

    @Override // xIoXXXIXo.OxxIIOOXO
    public xIoXXXIXo.I0Io oIX0oI() {
        if (this.f2177II0xO0 < this.f2179oIX0oI.XoI0Ixx0() && this.f2176I0Io < this.f2179oIX0oI.OxxIIOOXO()) {
            return this.f2179oIX0oI.XX(this.f2177II0xO0, this.f2176I0Io);
        }
        return new O0xOxO(this.f2177II0xO0, this.f2176I0Io);
    }

    @Override // xIoXXXIXo.OxxIIOOXO
    public int oxoX() {
        return -1;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        oOoXoXO.oxoX(this.f2177II0xO0, this.f2176I0Io, stringBuffer);
        stringBuffer.append('-');
        oOoXoXO.oxoX(this.f2180oxoX, this.f2178X0o0xo, stringBuffer);
        return stringBuffer.toString();
    }

    public void xxIXOIIO(int i) {
        int i2 = this.f2178X0o0xo;
        if (i > i2) {
            return;
        }
        int i3 = this.f2176I0Io;
        if (i < i3) {
            this.f2176I0Io = i3 - 1;
        }
        if (i < i2) {
            this.f2178X0o0xo = i2 - 1;
        }
    }

    public X00IoxXI(X00IoxXI x00IoxXI, xIoXXXIXo.IIXOooo iIXOooo) {
        this.f2179oIX0oI = iIXOooo;
        this.f2176I0Io = x00IoxXI.f2176I0Io;
        this.f2178X0o0xo = x00IoxXI.f2178X0o0xo;
        this.f2177II0xO0 = x00IoxXI.f2177II0xO0;
        this.f2180oxoX = x00IoxXI.f2180oxoX;
    }
}
