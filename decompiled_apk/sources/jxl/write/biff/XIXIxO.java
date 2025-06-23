package jxl.write.biff;

/* loaded from: classes6.dex */
public class XIXIxO extends OoIXo.OI0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public boolean f28697II0XooXoX;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public boolean f28698OOXIXo;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public String f28699Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public String f28700X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public String f28701XO;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public boolean f28702oOoXoXO;

    /* renamed from: xoIox, reason: collision with root package name */
    public boolean f28703xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public boolean f28704xxIXOIIO;

    public XIXIxO(String str, String str2, String str3, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        super(OoIXo.xII.f2439O0IxXx);
        this.f28700X0o0xo = str;
        this.f28701XO = str2;
        this.f28699Oxx0IOOO = str3;
        this.f28697II0XooXoX = z;
        this.f28704xxIXOIIO = z2;
        this.f28703xoIox = z3;
        this.f28698OOXIXo = z4;
        this.f28702oOoXoXO = z5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // OoIXo.OI0
    public byte[] xo0x() {
        int length = (this.f28700X0o0xo.length() * 2) + 6;
        if (this.f28701XO.length() > 0) {
            length += (this.f28701XO.length() * 2) + 1;
        }
        if (this.f28699Oxx0IOOO.length() > 0) {
            length += (this.f28699Oxx0IOOO.length() * 2) + 1;
        }
        byte[] bArr = new byte[length + 1];
        boolean z = this.f28697II0XooXoX;
        boolean z2 = z;
        if (this.f28704xxIXOIIO) {
            z2 = (z ? 1 : 0) | 2;
        }
        boolean z3 = z2;
        if (this.f28703xoIox) {
            z3 = (z2 ? 1 : 0) | 4;
        }
        boolean z4 = z3;
        if (this.f28698OOXIXo) {
            z4 = (z3 ? 1 : 0) | '\b';
        }
        int i = z4;
        if (this.f28702oOoXoXO) {
            i = (z4 ? 1 : 0) | 16;
        }
        bArr[0] = (byte) i;
        bArr[2] = (byte) this.f28700X0o0xo.length();
        bArr[3] = (byte) this.f28701XO.length();
        bArr[4] = (byte) this.f28699Oxx0IOOO.length();
        bArr[5] = 1;
        OoIXo.IO.X0o0xo(this.f28700X0o0xo, bArr, 6);
        int length2 = this.f28700X0o0xo.length() * 2;
        int i2 = length2 + 6;
        if (this.f28701XO.length() > 0) {
            int i3 = length2 + 7;
            bArr[i2] = 1;
            OoIXo.IO.X0o0xo(this.f28701XO, bArr, i3);
            i2 = (this.f28701XO.length() * 2) + i3;
        }
        if (this.f28699Oxx0IOOO.length() > 0) {
            bArr[i2] = 1;
            OoIXo.IO.X0o0xo(this.f28699Oxx0IOOO, bArr, i2 + 1);
            this.f28699Oxx0IOOO.length();
        }
        return bArr;
    }
}
