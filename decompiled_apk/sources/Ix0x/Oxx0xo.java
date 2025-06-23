package Ix0x;

/* loaded from: classes13.dex */
public class Oxx0xo extends OOXIXo {

    /* renamed from: IIXOooo, reason: collision with root package name */
    public static Oxx0xo f996IIXOooo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public int f997OxxIIOOXO;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public byte[] f998oI0IIXIo;

    public static Oxx0xo OOXIxO0() {
        Oxx0xo oxx0xo = f996IIXOooo;
        if (oxx0xo == null) {
            Oxx0xo oxx0xo2 = new Oxx0xo();
            f996IIXOooo = oxx0xo2;
            return oxx0xo2;
        }
        return oxx0xo;
    }

    @Override // Ix0x.OOXIXo, Ix0x.II0XooXoX
    public double I0Io() {
        return (this.f998oI0IIXIo[17] & 255) / Math.pow(10.0d, this.f997OxxIIOOXO);
    }

    @Override // Ix0x.OOXIXo, Ix0x.II0XooXoX
    public double Ioxxx() {
        byte[] bArr = this.f998oI0IIXIo;
        double pow = ((bArr[8] & 255) | ((bArr[7] & 255) << 8)) / Math.pow(10.0d, this.f997OxxIIOOXO);
        if (pow < 5.0d) {
            return XIXIX.OOXIXo.f3760XO;
        }
        return pow;
    }

    @Override // Ix0x.OOXIXo, Ix0x.II0XooXoX
    public double X0o0xo() {
        byte[] bArr = this.f998oI0IIXIo;
        return ((bArr[12] & 255) | ((bArr[11] & 255) << 8)) / Math.pow(10.0d, this.f997OxxIIOOXO);
    }

    @Override // Ix0x.II0XooXoX
    public int Xo0() {
        byte[] bArr = this.f998oI0IIXIo;
        return (bArr[14] & 255) | ((bArr[13] & 255) << 8);
    }

    @Override // Ix0x.OOXIXo, Ix0x.II0XooXoX
    public double ox() {
        byte[] bArr = this.f998oI0IIXIo;
        return ((bArr[10] & 255) | ((bArr[9] & 255) << 8)) / Math.pow(10.0d, this.f997OxxIIOOXO);
    }

    @Override // Ix0x.OOXIXo, Ix0x.II0XooXoX
    public int x0xO() {
        byte[] bArr = this.f998oI0IIXIo;
        int i = ((bArr[16] & 255) | ((bArr[15] & 255) << 8)) / 10;
        if (i < 1) {
            return 1;
        }
        return i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x000f, code lost:
    
        if (r0 != 2) goto L10;
     */
    @Override // Ix0x.II0XooXoX
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public Ix0x.II0XooXoX xxX(com.vtrump.vtble.Scale.ScaleUserInfo r3, byte[] r4) {
        /*
            r2 = this;
            r2.f998oI0IIXIo = r4
            r0 = 4
            r0 = r4[r0]
            r0 = r0 & 6
            r2.f997OxxIIOOXO = r0
            r1 = 1
            if (r0 == 0) goto L12
            if (r0 == r1) goto L15
            r1 = 2
            if (r0 == r1) goto L12
            goto L18
        L12:
            r2.f997OxxIIOOXO = r1
            goto L18
        L15:
            r0 = 0
            r2.f997OxxIIOOXO = r0
        L18:
            super.xxX(r3, r4)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: Ix0x.Oxx0xo.xxX(com.vtrump.vtble.Scale.ScaleUserInfo, byte[]):Ix0x.II0XooXoX");
    }
}
