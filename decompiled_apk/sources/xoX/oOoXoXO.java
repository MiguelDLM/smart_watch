package xoX;

import XxXX.X0o0xo;
import com.tencent.open.utils.oIX0oI;

/* loaded from: classes13.dex */
public class oOoXoXO {
    public static int II0xO0(String str) {
        int II0xO02;
        if (X0o0xo.oIX0oI() == null || (II0xO02 = oIX0oI.oxoX(X0o0xo.oIX0oI(), str).II0xO0("Common_BusinessReportFrequency")) == 0) {
            return 100;
        }
        return II0xO02;
    }

    public static int oIX0oI() {
        int II0xO02 = oIX0oI.oxoX(X0o0xo.oIX0oI(), null).II0xO0("Common_HttpRetryCount");
        if (II0xO02 == 0) {
            return 2;
        }
        return II0xO02;
    }
}
