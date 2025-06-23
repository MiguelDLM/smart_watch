package XxXX;

import android.content.Context;
import android.content.SharedPreferences;
import java.lang.ref.WeakReference;
import java.net.URL;

/* loaded from: classes13.dex */
public class XO {

    /* renamed from: II0xO0, reason: collision with root package name */
    public static XO f4224II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public volatile WeakReference<SharedPreferences> f4225oIX0oI = null;

    public static synchronized XO oIX0oI() {
        XO xo2;
        synchronized (XO.class) {
            try {
                if (f4224II0xO0 == null) {
                    f4224II0xO0 = new XO();
                }
                xo2 = f4224II0xO0;
            } catch (Throwable th) {
                throw th;
            }
        }
        return xo2;
    }

    public String II0xO0(Context context, String str) {
        if (this.f4225oIX0oI == null || this.f4225oIX0oI.get() == null) {
            this.f4225oIX0oI = new WeakReference<>(context.getSharedPreferences("ServerPrefs", 0));
        }
        try {
            String host = new URL(str).getHost();
            if (host == null) {
                xx0.xxIXOIIO.II0XooXoX("openSDK_LOG.ServerSetting", "Get host error. url=" + str);
                return str;
            }
            String string = this.f4225oIX0oI.get().getString(host, null);
            if (string != null && !host.equals(string)) {
                String replace = str.replace(host, string);
                xx0.xxIXOIIO.IXxxXO("openSDK_LOG.ServerSetting", "return environment url : " + replace);
                return replace;
            }
            xx0.xxIXOIIO.IXxxXO("openSDK_LOG.ServerSetting", "host=" + host + ", envHost=" + string);
            return str;
        } catch (Exception e) {
            xx0.xxIXOIIO.II0XooXoX("openSDK_LOG.ServerSetting", "getEnvUrl url=" + str + "error.: " + e.getMessage());
            return str;
        }
    }
}
