package jxl.write.biff;

/* loaded from: classes6.dex */
public class oIIxXoo extends OoIXo.OI0 {

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final String f28834Oxx0IOOO = "Java Excel API";

    /* renamed from: X0o0xo, reason: collision with root package name */
    public byte[] f28835X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public String f28836XO;

    public oIIxXoo(String str) {
        super(OoIXo.xII.f2470XOxIOxOx);
        this.f28835X0o0xo = new byte[112];
        if (str == null) {
            str = "Java Excel API v" + xIoXXXIXo.OxI.XI0IXoo();
        }
        OoIXo.IO.oIX0oI(str, this.f28835X0o0xo, 0);
        int length = str.length();
        while (true) {
            byte[] bArr = this.f28835X0o0xo;
            if (length < bArr.length) {
                bArr[length] = 32;
                length++;
            } else {
                return;
            }
        }
    }

    @Override // OoIXo.OI0
    public byte[] xo0x() {
        return this.f28835X0o0xo;
    }
}
