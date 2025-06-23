package jxl.biff.formula;

/* loaded from: classes6.dex */
public class XxX0x0xxx extends O0Xx {
    @Override // jxl.biff.formula.OI0
    public void Oxx0IOOO() {
    }

    @Override // jxl.biff.formula.OI0
    public void XO(StringBuffer stringBuffer) {
        OI0[] OxxIIOOXO2 = OxxIIOOXO();
        if (OxxIIOOXO2.length == 1) {
            OxxIIOOXO2[0].XO(stringBuffer);
        } else if (OxxIIOOXO2.length == 2) {
            OxxIIOOXO2[1].XO(stringBuffer);
            stringBuffer.append(':');
            OxxIIOOXO2[0].XO(stringBuffer);
        }
    }

    @Override // jxl.biff.formula.O0Xx, jxl.biff.formula.o0
    public int read(byte[] bArr, int i) {
        IIXOooo(OoIXo.oo0xXOI0I.I0Io(bArr[i + 4], bArr[i + 5]));
        return 6;
    }
}
