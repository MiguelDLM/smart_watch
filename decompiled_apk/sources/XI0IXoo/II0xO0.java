package XI0IXoo;

import android.content.Context;
import android.os.SystemClock;
import com.aliyun.sls.android.producer.Log;
import com.aliyun.sls.android.producer.LogProducerHttpTool;
import com.baidu.navisdk.ui.widget.BNWebViewClient;
import com.kuaishou.weapon.p0.g;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes.dex */
public class II0xO0 {

    /* renamed from: II0xO0, reason: collision with root package name */
    public static long f3710II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static long f3711oIX0oI;

    /* loaded from: classes.dex */
    public static class oIX0oI implements Runnable {

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ String[] f3712Oo;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ String f3713XO;

        public oIX0oI(String str, String[] strArr) {
            this.f3713XO = str;
            this.f3712Oo = strArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            LogProducerHttpTool.android_http_post(this.f3713XO, "GET", this.f3712Oo, new byte[0]);
        }
    }

    public static long I0Io(String str) {
        try {
            return Long.parseLong(str);
        } catch (Throwable unused) {
            return System.currentTimeMillis();
        }
    }

    public static long II0xO0() {
        if (0 == f3710II0xO0) {
            return System.currentTimeMillis() / 1000;
        }
        return f3711oIX0oI + ((SystemClock.elapsedRealtime() - f3710II0xO0) / 1000);
    }

    public static void X0o0xo(long j) {
        f3711oIX0oI = j;
        f3710II0xO0 = SystemClock.elapsedRealtime();
    }

    public static void oIX0oI(Log log) {
        Map<String, String> content;
        String str;
        if (log == null || (content = log.getContent()) == null || content.size() == 0 || !content.containsKey("local_timestamp")) {
            return;
        }
        Date date = new Date();
        String str2 = content.get("local_timestamp");
        if (str2.length() < 10) {
            str = String.valueOf(System.currentTimeMillis());
        } else {
            str = str2.substring(0, 10) + String.valueOf(date.getTime()).substring(10);
        }
        date.setTime(I0Io(str));
        content.put("local_time_fixed", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS", Locale.getDefault()).format(date));
        content.put("local_timestamp_fixed", str);
    }

    public static void oxoX(Context context, String str, String str2) {
        if (context != null && context.getPackageManager().checkPermission(g.f18396a, context.getPackageName()) != 0) {
            return;
        }
        if (str.contains("http")) {
            str = str.substring(str.indexOf("://") + 3);
        }
        XI0IXoo.oIX0oI.II0xO0(new oIX0oI(BNWebViewClient.URL_HTTPS_PREFIX + str2 + FileUtils.FILE_EXTENSION_SEPARATOR + str + "/servertime", new String[]{"x-log-apiversion", "0.6.0"}));
    }
}
