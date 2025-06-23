package com.kwad.sdk.api.loader;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public final class i {
    private static File anG;
    private static final String anH;

    static {
        String str;
        if (yn()) {
            str = "dynamic_apk";
        } else {
            str = "dynamic.apk";
        }
        anH = str;
    }

    private static File aP(Context context) {
        if (anG == null) {
            anG = i(new File(context.getApplicationInfo().dataDir, "ksad_dynamic"));
        }
        return anG;
    }

    public static void h(File file) {
        if (file == null) {
            return;
        }
        if (file.isFile()) {
            file.delete();
            return;
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                h(file2);
            }
        }
        file.delete();
    }

    private static File i(File file) {
        if (file.exists() && file.isFile()) {
            file.delete();
        }
        if (file.exists() && file.isDirectory()) {
            return file;
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        if (file.exists() && file.isDirectory()) {
            return file;
        }
        if (!com.kwad.sdk.api.a.md.booleanValue()) {
            return file;
        }
        throw new RuntimeException("Can not ensureDir:" + file);
    }

    public static void j(File file) {
        try {
            h(file);
        } catch (Exception unused) {
        }
    }

    public static File r(Context context, String str) {
        return new File(aP(context), "dynamic-" + System.currentTimeMillis() + HelpFormatter.DEFAULT_OPT_PREFIX + str + com.huawei.hms.ads.dynamicloader.b.b);
    }

    public static String s(Context context, String str) {
        return i(new File(aP(context), "apk-" + str)).getPath();
    }

    public static File t(Context context, String str) {
        return i(new File(aP(context), "apk-" + str));
    }

    public static String u(Context context, String str) {
        return new File(s(context, str), anH).getPath();
    }

    public static String v(Context context, String str) {
        return i(new File(s(context, str), "dex")).getPath();
    }

    public static String w(Context context, String str) {
        return i(new File(s(context, str), "libs")).getPath();
    }

    public static void x(final Context context, final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.kwad.sdk.api.a.a.a(new com.kwad.sdk.api.a.b() { // from class: com.kwad.sdk.api.loader.i.1
            @Override // com.kwad.sdk.api.a.b
            public final void doTask() {
                try {
                    File[] listFiles = i.t(context, str).getParentFile().listFiles();
                    if (listFiles != null && listFiles.length > 0) {
                        for (File file : listFiles) {
                            if (h.K(str, file.getName().substring(file.getName().indexOf(HelpFormatter.DEFAULT_OPT_PREFIX) + 1))) {
                                i.h(file);
                            }
                        }
                    }
                } catch (Exception unused) {
                }
            }
        });
    }

    private static boolean yn() {
        int i = Build.VERSION.SDK_INT;
        if (i != 30 && i != 31 && i != 32) {
            return false;
        }
        return true;
    }
}
