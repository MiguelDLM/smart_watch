package com.baidu.navisdk.module.tingphone.control;

import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.m0;
import com.baidu.navisdk.util.common.n;
import com.baidu.navisdk.vi.VDeviceAPI;
import java.io.File;

/* loaded from: classes7.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final String f7568a = "a";

    public static /* synthetic */ boolean a() {
        return e();
    }

    public static /* synthetic */ boolean b() {
        return c();
    }

    private static boolean c() {
        String f = f();
        String str = f7568a;
        LogUtil.e(str, "module path = " + f);
        if (TextUtils.isEmpty(f)) {
            LogUtil.e(str, "module path is null or empty");
            return false;
        }
        File file = new File(f);
        if (!file.exists()) {
            LogUtil.e(str, "module path tingphone floder no exist");
            return false;
        }
        return a(file);
    }

    public static void d() {
        n.d().a(new C0293a());
        n.d().a(20, 0, 0, null, 3000L);
    }

    private static boolean e() {
        String g = g();
        String str = f7568a;
        LogUtil.e(str, "sdcard path = " + g);
        if (TextUtils.isEmpty(g)) {
            LogUtil.e(str, "sdcard path is null or empty");
            return false;
        }
        File file = new File(g);
        if (!file.exists()) {
            LogUtil.e(str, "sdcard tingphone floder no exist");
            return false;
        }
        return a(file);
    }

    private static String f() {
        File externalFilesDir;
        Context a2 = com.baidu.navisdk.framework.a.c().a();
        if (a2 == null || (externalFilesDir = a2.getExternalFilesDir(VDeviceAPI.APP_NAME_BAIDU_MAP)) == null) {
            return null;
        }
        String absolutePath = externalFilesDir.getAbsolutePath();
        if (TextUtils.isEmpty(absolutePath)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(absolutePath);
        String str = File.separator;
        sb.append(str);
        sb.append("bnav");
        sb.append(str);
        sb.append("tingphone");
        return sb.toString();
    }

    private static String g() {
        String c = m0.j().c();
        if (TextUtils.isEmpty(c)) {
            return null;
        }
        return c + File.separator + "tingphone";
    }

    private static boolean a(File file) {
        if (file == null) {
            return false;
        }
        if (file.isDirectory()) {
            String[] list = file.list();
            if (list == null) {
                return false;
            }
            for (String str : list) {
                if (!a(new File(file, str))) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    /* renamed from: com.baidu.navisdk.module.tingphone.control.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0293a extends n.b {
        @Override // com.baidu.navisdk.util.common.n.b
        public void a(Message message) {
            if (message.what == 20) {
                try {
                    a.a();
                    a.b();
                } catch (Throwable unused) {
                }
            }
        }

        @Override // com.baidu.navisdk.util.common.n.b
        public String b() {
            return "TingPhone";
        }

        @Override // com.baidu.navisdk.util.common.n.b
        public void a() {
            a(20);
        }
    }
}
