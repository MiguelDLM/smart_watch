package o0IXXIx;

import android.content.Context;
import android.text.TextUtils;
import x0.xII;

/* loaded from: classes11.dex */
public class xxIXOIIO {
    public static String II0xO0(Context context) {
        String str;
        if (context == null || oOoIIO0.x0XOIxOo.xoIox() || (str = (String) xII.xxIXOIIO(context, "__GAID__", oXxOI0oIx.II0xO0.Oxx0IOOO(context))) == null) {
            return "";
        }
        return str;
    }

    public static String oIX0oI(Context context) {
        String X0o0xo2;
        if (oOoIIO0.x0XOIxOo.oIX0oI() != null) {
            String oaid = oOoIIO0.x0XOIxOo.oIX0oI().getOaid();
            if (!TextUtils.isEmpty(oaid)) {
                oXxOI0oIx.X0o0xo.II0xO0("Oaid is Outside Input: " + oaid);
                return oaid;
            }
        }
        if (context == null || oOoIIO0.x0XOIxOo.xoIox() || (X0o0xo2 = oXxOI0oIx.II0xO0.X0o0xo(context)) == null) {
            return "";
        }
        return X0o0xo2;
    }
}
