package com.baidu.navisdk.asr;

import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.navisdk.util.common.g;
import java.util.Arrays;

/* loaded from: classes7.dex */
public class f {

    /* loaded from: classes7.dex */
    public class a extends com.baidu.navisdk.util.worker.f<String, String> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Runnable f6548a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, String str2, Runnable runnable) {
            super(str, str2);
            this.f6548a = runnable;
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            this.f6548a.run();
            return null;
        }
    }

    public static com.baidu.navisdk.framework.interfaces.asr.a a(String str) {
        if (TextUtils.isEmpty(str)) {
            d.B().b();
            return null;
        }
        return e.a(str);
    }

    public static boolean b() {
        int checkSelfPermission;
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                checkSelfPermission = com.baidu.navisdk.framework.a.c().a().checkSelfPermission("android.permission.RECORD_AUDIO");
                if (checkSelfPermission == 0) {
                    return true;
                }
                return false;
            } catch (Exception e) {
                g gVar = g.ASR;
                if (gVar.e()) {
                    gVar.g("XDVoiceBNAsrUtils", "isHasRecordAudioPermission() error, e =" + e.toString());
                }
                return false;
            }
        }
        return true;
    }

    public static boolean c() {
        if (Build.VERSION.SDK_INT < 23) {
            String str = Build.BRAND;
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (str.toLowerCase().equals("smartisan") || str.toLowerCase().equals("xiaomi") || str.toLowerCase().equals("oppo") || str.toLowerCase().equals("vivo") || str.toLowerCase().equals("lenovo") || str.toLowerCase().equals("meizu")) {
                return true;
            }
        }
        return false;
    }

    public static void d() {
        g gVar = g.ASR;
        if (gVar.e()) {
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            if (stackTrace.length >= 5) {
                gVar.a("XDVoice", "XD", "XDCallStack", Arrays.asList(stackTrace).subList(2, 5));
            }
        }
    }

    public static void a(Runnable runnable) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            runnable.run();
        } else {
            com.baidu.navisdk.util.worker.c.a().a((com.baidu.navisdk.util.worker.f) new a("Asr-UI", null, runnable), new com.baidu.navisdk.util.worker.e(2, 0));
        }
    }

    public static boolean a() {
        return d.B().q() && com.baidu.navisdk.module.cloudconfig.f.c().c.v == 0 && b() && !c();
    }
}
