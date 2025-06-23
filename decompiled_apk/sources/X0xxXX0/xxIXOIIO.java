package X0xxXX0;

import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBiddingNotice;
import java.util.Map;

/* loaded from: classes11.dex */
public class xxIXOIIO implements ATBiddingNotice {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public oOoIIO0.Oxx0IOOO f3706oIX0oI;

    public xxIXOIIO(oOoIIO0.Oxx0IOOO oxx0IOOO) {
        this.f3706oIX0oI = oxx0IOOO;
    }

    public void I0Io(String str, double d, Map<String, Object> map) {
        String str2;
        if (this.f3706oIX0oI != null) {
            str.hashCode();
            char c = 65535;
            switch (str.hashCode()) {
                case 50:
                    if (str.equals("2")) {
                        c = 0;
                        break;
                    }
                    break;
                case 48627:
                    if (str.equals("102")) {
                        c = 1;
                        break;
                    }
                    break;
                case 48628:
                    if (str.equals("103")) {
                        c = 2;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    str2 = oOoIIO0.oIX0oI.f32053X0o0xo;
                    break;
                case 1:
                case 2:
                    str2 = oOoIIO0.oIX0oI.f32047II0xO0;
                    break;
                default:
                    str2 = oOoIIO0.oIX0oI.f32055oI0IIXIo;
                    break;
            }
            this.f3706oIX0oI.II0XooXoX((int) d, str2, oOoIIO0.oIX0oI.f32055oI0IIXIo);
            this.f3706oIX0oI = null;
        }
    }

    public ATAdConst.CURRENCY oIX0oI() {
        return ATAdConst.CURRENCY.RMB_CENT;
    }

    public void oxoX(double d, double d2, Map<String, Object> map) {
        oOoIIO0.Oxx0IOOO oxx0IOOO = this.f3706oIX0oI;
        if (oxx0IOOO != null) {
            oxx0IOOO.II0xO0((int) d2);
            this.f3706oIX0oI = null;
        }
    }

    public void II0xO0(boolean z, double d) {
    }
}
