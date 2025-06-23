package X0xOO;

/* loaded from: classes6.dex */
public class Oxx0IOOO {

    /* renamed from: I0Io, reason: collision with root package name */
    public II0XooXoX f3344I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public int f3345II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public int f3346oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public byte[] f3347oxoX;

    public Oxx0IOOO(int i, int i2, II0XooXoX iI0XooXoX, byte[] bArr) {
        this.f3346oIX0oI = i;
        this.f3345II0xO0 = i2;
        this.f3344I0Io = iI0XooXoX;
        byte[] bArr2 = new byte[i2];
        this.f3347oxoX = bArr2;
        System.arraycopy(bArr, i, bArr2, 0, i2);
    }

    public byte[] oIX0oI() {
        return this.f3347oxoX;
    }
}
