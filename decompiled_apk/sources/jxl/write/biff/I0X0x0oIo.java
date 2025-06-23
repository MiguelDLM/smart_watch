package jxl.write.biff;

import java.util.ArrayList;

/* loaded from: classes6.dex */
public class I0X0x0oIo extends OoIXo.OI0 {

    /* renamed from: X0o0xo, reason: collision with root package name */
    public ArrayList f28561X0o0xo;

    public I0X0x0oIo(ArrayList arrayList) {
        super(OoIXo.xII.f2491oOo);
        this.f28561X0o0xo = arrayList;
    }

    @Override // OoIXo.OI0
    public byte[] xo0x() {
        int i = 2;
        byte[] bArr = new byte[(this.f28561X0o0xo.size() * 8) + 2];
        OoIXo.oo0xXOI0I.XO(this.f28561X0o0xo.size(), bArr, 0);
        for (int i2 = 0; i2 < this.f28561X0o0xo.size(); i2++) {
            xIoXXXIXo.OxxIIOOXO oxxIIOOXO = (xIoXXXIXo.OxxIIOOXO) this.f28561X0o0xo.get(i2);
            xIoXXXIXo.I0Io oIX0oI2 = oxxIIOOXO.oIX0oI();
            xIoXXXIXo.I0Io II0xO02 = oxxIIOOXO.II0xO0();
            OoIXo.oo0xXOI0I.XO(oIX0oI2.II0xO0(), bArr, i);
            OoIXo.oo0xXOI0I.XO(II0xO02.II0xO0(), bArr, i + 2);
            OoIXo.oo0xXOI0I.XO(oIX0oI2.oIX0oI(), bArr, i + 4);
            OoIXo.oo0xXOI0I.XO(II0xO02.oIX0oI(), bArr, i + 6);
            i += 8;
        }
        return bArr;
    }
}
