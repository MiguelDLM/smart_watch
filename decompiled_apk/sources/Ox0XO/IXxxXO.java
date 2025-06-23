package Ox0XO;

/* loaded from: classes6.dex */
public class IXxxXO implements OoOoXO0.oI0IIXIo {

    /* renamed from: I0Io, reason: collision with root package name */
    public int f2858I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public byte[] f2859II0xO0;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public int f2860Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public byte[] f2861X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public int f2862XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public String f2863oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public int f2864oxoX;

    public IXxxXO(String str, byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4) {
        this.f2863oIX0oI = str;
        this.f2859II0xO0 = bArr;
        this.f2858I0Io = i;
        this.f2864oxoX = i2;
        this.f2861X0o0xo = bArr2;
        this.f2862XO = i3;
        this.f2860Oxx0IOOO = i4;
    }

    @Override // OoOoXO0.oI0IIXIo
    public int I0Io() {
        return this.f2864oxoX;
    }

    @Override // OoOoXO0.oI0IIXIo
    public byte[] II0xO0() {
        return this.f2859II0xO0;
    }

    public String Oxx0IOOO() {
        return this.f2863oIX0oI;
    }

    @Override // OoOoXO0.oI0IIXIo
    public int X0o0xo() {
        return this.f2862XO;
    }

    @Override // OoOoXO0.oI0IIXIo
    public byte[] XO() {
        return this.f2861X0o0xo;
    }

    @Override // OoOoXO0.oI0IIXIo
    public int oIX0oI() {
        if (this.f2861X0o0xo == null) {
            return 0;
        }
        return this.f2860Oxx0IOOO;
    }

    @Override // OoOoXO0.oI0IIXIo
    public int oxoX() {
        return this.f2858I0Io;
    }
}
