package OoIXo;

/* loaded from: classes6.dex */
public class xxIXOIIO {

    /* renamed from: oxoX, reason: collision with root package name */
    public static final int f2553oxoX = 1024;

    /* renamed from: I0Io, reason: collision with root package name */
    public int f2554I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public byte[] f2555II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public int f2556oIX0oI;

    public xxIXOIIO() {
        this(1024);
    }

    public final void I0Io(int i) {
        while (true) {
            int i2 = this.f2554I0Io;
            int i3 = i2 + i;
            byte[] bArr = this.f2555II0xO0;
            if (i3 >= bArr.length) {
                byte[] bArr2 = new byte[bArr.length + this.f2556oIX0oI];
                System.arraycopy(bArr, 0, bArr2, 0, i2);
                this.f2555II0xO0 = bArr2;
            } else {
                return;
            }
        }
    }

    public void II0xO0(byte[] bArr) {
        I0Io(bArr.length);
        System.arraycopy(bArr, 0, this.f2555II0xO0, this.f2554I0Io, bArr.length);
        this.f2554I0Io += bArr.length;
    }

    public void oIX0oI(byte b) {
        I0Io(1);
        byte[] bArr = this.f2555II0xO0;
        int i = this.f2554I0Io;
        bArr[i] = b;
        this.f2554I0Io = i + 1;
    }

    public byte[] oxoX() {
        int i = this.f2554I0Io;
        byte[] bArr = new byte[i];
        System.arraycopy(this.f2555II0xO0, 0, bArr, 0, i);
        return bArr;
    }

    public xxIXOIIO(int i) {
        this.f2556oIX0oI = i;
        this.f2555II0xO0 = new byte[1024];
        this.f2554I0Io = 0;
    }
}
