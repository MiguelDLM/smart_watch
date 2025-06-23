package XOxoX;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.openalliance.ad.constant.x;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes13.dex */
public class I0Io {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static String f3984oIX0oI;

    public static String I0Io(String str) {
        try {
            return String.format("%032x", new BigInteger(1, MessageDigest.getInstance("MD5").digest(str.getBytes())));
        } catch (Exception unused) {
            return "";
        }
    }

    public static String II0xO0(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception e) {
            oIX0oI.oIX0oI("TANX_EXPOSE_UTIL", "getVersionName: exception" + e.getMessage());
            return "";
        }
    }

    public static String Oxx0IOOO(Context context) {
        if (context != null) {
            try {
                return context.getPackageName();
            } catch (Exception e) {
                oIX0oI.oIX0oI("TANX_EXPOSE_UTIL", "getVersionName: exception" + e.getMessage());
                return "";
            }
        }
        return "";
    }

    public static String X0o0xo(Map<String, Object> map) {
        if (map == null) {
            return null;
        }
        return new JSONObject(map).toString();
    }

    public static Map<String, Object> XO(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        Iterator<String> keys = jSONObject.keys();
        HashMap hashMap = new HashMap();
        while (keys.hasNext()) {
            String next = keys.next();
            Object opt = jSONObject.opt(next);
            if (!TextUtils.isEmpty(next) && opt != null) {
                hashMap.put(next, opt);
            }
        }
        return hashMap;
    }

    public static String oIX0oI() {
        String I0Io2;
        String X0o0xo2;
        if (!TextUtils.isEmpty(f3984oIX0oI)) {
            return f3984oIX0oI;
        }
        xIx.II0xO0 xxIXOIIO2 = xIx.I0Io.I0Io().xxIXOIIO();
        if (xxIXOIIO2 != null) {
            if (TextUtils.isEmpty(xxIXOIIO2.I0Io())) {
                I0Io2 = Oxx0IOOO(xIx.I0Io.I0Io().X0o0xo());
            } else {
                I0Io2 = xxIXOIIO2.I0Io();
            }
            if (TextUtils.isEmpty(xxIXOIIO2.X0o0xo())) {
                X0o0xo2 = II0xO0(xIx.I0Io.I0Io().X0o0xo());
            } else {
                X0o0xo2 = xxIXOIIO2.X0o0xo();
            }
            if (!TextUtils.isEmpty(I0Io2) && !TextUtils.isEmpty(X0o0xo2)) {
                f3984oIX0oI = I0Io2 + x.aL + X0o0xo2 + ";Android;" + Build.VERSION.RELEASE + x.aL + Build.MODEL;
                if (oIX0oI.f3985oIX0oI) {
                    oIX0oI.oIX0oI("TANX_EXPOSE_UTIL", "getUserAgent: mUserAgent = " + f3984oIX0oI);
                }
                return f3984oIX0oI;
            }
            return "";
        }
        return "";
    }

    public static String oxoX(String str, JSONObject jSONObject) {
        if (str != null && jSONObject != null) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                String optString = jSONObject.optString(next);
                if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(optString)) {
                    str = str.replace(next, optString);
                }
            }
        }
        return str;
    }
}
