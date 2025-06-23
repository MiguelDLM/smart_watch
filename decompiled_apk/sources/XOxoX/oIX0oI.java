package XOxoX;

import android.text.TextUtils;
import android.util.Log;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes13.dex */
public class oIX0oI {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static boolean f3985oIX0oI = false;

    public static void I0Io(String str, Map<String, Object> map) {
        if (f3985oIX0oI) {
            new JSONObject(map);
            Log.d("TanxExposerSDK", "[" + str + "] " + new JSONObject(map).toString());
        }
    }

    public static void II0xO0(String str, String str2, Throwable th) {
        if (f3985oIX0oI) {
            Log.d("TanxExposerSDK", "[" + str + "] " + str2, th);
        }
    }

    public static void X0o0xo(boolean z) {
        f3985oIX0oI = z;
    }

    public static String XO(String str, String... strArr) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(str);
        sb.append("] ");
        for (String str2 : strArr) {
            if (!TextUtils.isEmpty(str2)) {
                sb.append(str2);
            }
        }
        return sb.toString();
    }

    public static void oIX0oI(String str, String str2) {
        if (f3985oIX0oI) {
            Log.d("TanxExposerSDK", "[" + str + "] " + str2);
        }
    }

    public static void oxoX(String str, String... strArr) {
        if (f3985oIX0oI) {
            Log.d("TanxExposerSDK", XO(str, strArr));
        }
    }
}
