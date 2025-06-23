package xo;

import android.util.Log;

/* loaded from: classes13.dex */
public final class xxIXOIIO {

    /* renamed from: II0xO0, reason: collision with root package name */
    public static boolean f34940II0xO0 = false;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final String f34941oIX0oI = "TanxSDK-OnlyId";

    public static void I0Io(String str, String str2) {
        if (!f34940II0xO0) {
            return;
        }
        if (str2 == null) {
            str2 = "<null>";
        }
        Log.d("TanxSDK-OnlyId - " + str, str2);
    }

    public static void II0xO0(Object obj) {
        if (!f34940II0xO0) {
            return;
        }
        if (obj == null) {
            obj = "<null>";
        }
        Log.d(f34941oIX0oI, obj.toString());
    }

    public static void oIX0oI(boolean z) {
        f34940II0xO0 = z;
    }
}
