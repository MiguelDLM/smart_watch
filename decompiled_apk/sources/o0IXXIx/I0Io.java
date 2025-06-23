package o0IXXIx;

import android.util.Base64;

/* loaded from: classes11.dex */
public class I0Io {
    public static String oIX0oI(String str) {
        try {
            return new String(Base64.decode(str, 0));
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
