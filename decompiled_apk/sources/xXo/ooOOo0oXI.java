package xXo;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/* loaded from: classes13.dex */
public class ooOOo0oXI extends oI0IIXIo<BigDecimal> {
    public ooOOo0oXI(BigDecimal bigDecimal, String str, String... strArr) {
        super(bigDecimal, str, strArr);
    }

    @Override // xXo.oI0IIXIo
    public void oOoXoXO(DecimalFormat decimalFormat) {
        decimalFormat.setParseBigDecimal(true);
    }

    public ooOOo0oXI(BigDecimal bigDecimal, String str) {
        super(bigDecimal, str);
    }

    public ooOOo0oXI(String... strArr) {
        super((Number) null, (String) null, strArr);
    }

    public ooOOo0oXI(DecimalFormat... decimalFormatArr) {
        super(decimalFormatArr);
    }

    public ooOOo0oXI() {
    }
}
