package O0Xx;

import com.garmin.fit.IIxOXoOo0;
import com.garmin.fit.IXIxx0;
import com.garmin.fit.X0xII0I;
import com.garmin.fit.oIXoXx0;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.io.ByteArrayOutputStream;
import java.util.Iterator;

/* loaded from: classes9.dex */
public class OOXIXo extends xoIox implements IXIxx0 {
    public OOXIXo(ByteArrayOutputStream byteArrayOutputStream) {
        super(byteArrayOutputStream);
    }

    @Override // com.garmin.fit.IXIxx0
    public void II0xO0(oIXoXx0 oixoxx0) {
        if (oixoxx0.x0OIX00oO().equals("unknown") && this.f1459X0o0xo) {
            return;
        }
        if (this.f1458Oxx0IOOO) {
            oixoxx0.xxOXOOoIX();
        }
        if (this.f1456II0XooXoX) {
            o00(oixoxx0);
        }
        for (X0xII0I x0xII0I : oixoxx0.XIXIxO()) {
            if (!this.f1459X0o0xo || !x0xII0I.getName().equals("unknown")) {
                int xoIox2 = oixoxx0.xoIox(x0xII0I.OooI());
                String oO2 = oO(x0xII0I, xoIox2);
                String str = oixoxx0.x0OIX00oO() + FileUtils.FILE_EXTENSION_SEPARATOR + x0xII0I.OO(xoIox2);
                String x0XOIxOo2 = x0XOIxOo(x0xII0I.x0OIX00oO(xoIox2), x0xII0I.OIx00oxx().name());
                if (!x0XOIxOo2.isEmpty()) {
                    str = str + "[" + x0XOIxOo2 + "]";
                }
                this.f1461oIX0oI.oxoX(str, oO2);
            }
        }
        for (IIxOXoOo0 iIxOXoOo0 : oixoxx0.x0XOIxOo()) {
            if (iIxOXoOo0.xOOxIO() || !this.f1459X0o0xo) {
                String oO3 = oO(iIxOXoOo0, 65535);
                String str2 = oixoxx0.x0OIX00oO() + ".developer." + ((int) iIxOXoOo0.OIx00oxx()) + FileUtils.FILE_EXTENSION_SEPARATOR + iIxOXoOo0.getName();
                String ooOOo0oXI2 = ooOOo0oXI(iIxOXoOo0.OIOoIIOIx());
                if (ooOOo0oXI2 != null && !ooOOo0oXI2.isEmpty()) {
                    str2 = str2 + "[" + ooOOo0oXI2 + "]";
                }
                this.f1461oIX0oI.oxoX(str2, oO3);
            }
        }
        this.f1461oIX0oI.XO();
    }

    public void OxI(int i) {
        this.f1461oIX0oI.X0o0xo(i);
    }

    public void o00(oIXoXx0 oixoxx0) {
        String x0OIX00oO2 = oixoxx0.x0OIX00oO();
        Iterator<String> it = this.f1461oIX0oI.I0Io().iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (next.substring(0, next.indexOf(FileUtils.FILE_EXTENSION_SEPARATOR)).equals(x0OIX00oO2)) {
                this.f1461oIX0oI.oxoX(next, "");
            }
        }
    }
}
