package com.kuaishou.weapon.p0;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

/* loaded from: classes11.dex */
public class ac {
    public boolean a() {
        return Process.myUid() / 100000 != 0;
    }

    public String b(Context context) {
        try {
            return context.getFilesDir().getParentFile().getAbsolutePath();
        } catch (Throwable unused) {
            return "";
        }
    }

    public String c(Context context) {
        try {
            Object invoke = Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", null).invoke(null, null);
            Field declaredField = invoke.getClass().getDeclaredField("mPackages");
            declaredField.setAccessible(true);
            Map map = (Map) declaredField.get(invoke);
            if (map != null && map.size() > 0) {
                for (Object obj : map.keySet()) {
                    if (obj.toString().length() > 1 && !obj.toString().equals(context.getPackageName())) {
                        File file = new File("/data/data" + File.separator + obj.toString());
                        if (file.exists() && file.canWrite()) {
                            return obj.toString();
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:81:0x00ba, code lost:
    
        if (r3 == null) goto L47;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public org.json.JSONArray d(android.content.Context r9) {
        /*
            r8 = this;
            java.lang.String r0 = ".dex"
            java.lang.String r1 = ".so"
            r2 = 0
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> Lb8
            java.io.FileReader r4 = new java.io.FileReader     // Catch: java.lang.Throwable -> Lb8
            java.lang.String r5 = "/proc/self/maps"
            r4.<init>(r5)     // Catch: java.lang.Throwable -> Lb8
            r3.<init>(r4)     // Catch: java.lang.Throwable -> Lb8
            java.util.HashSet r4 = new java.util.HashSet     // Catch: java.lang.Throwable -> L7e
            r4.<init>()     // Catch: java.lang.Throwable -> L7e
            java.lang.String r9 = r9.getPackageName()     // Catch: java.lang.Throwable -> L7e
        L1a:
            java.lang.String r5 = r3.readLine()     // Catch: java.lang.Throwable -> L7e
            if (r5 == 0) goto La5
            java.lang.String r6 = "@Hw"
            boolean r6 = r5.contains(r6)     // Catch: java.lang.Throwable -> L7e
            if (r6 != 0) goto L1a
            java.lang.String r6 = ".apk@classes.dex"
            boolean r6 = r5.contains(r6)     // Catch: java.lang.Throwable -> L7e
            if (r6 != 0) goto L1a
            java.lang.String r6 = "WebViewGoogle"
            boolean r6 = r5.contains(r6)     // Catch: java.lang.Throwable -> L7e
            if (r6 != 0) goto L1a
            java.lang.String r6 = "FeatureFramework"
            boolean r6 = r5.contains(r6)     // Catch: java.lang.Throwable -> L7e
            if (r6 != 0) goto L1a
            java.lang.String r6 = "framework@oppo"
            boolean r6 = r5.contains(r6)     // Catch: java.lang.Throwable -> L7e
            if (r6 != 0) goto L1a
            java.lang.String r6 = "framework@mediatek"
            boolean r6 = r5.contains(r6)     // Catch: java.lang.Throwable -> L7e
            if (r6 != 0) goto L1a
            int r6 = r4.size()     // Catch: java.lang.Throwable -> L7e
            r7 = 15
            if (r6 > r7) goto La5
            boolean r6 = r5.contains(r9)     // Catch: java.lang.Throwable -> L7e
            java.lang.String r7 = "/data/"
            if (r6 != 0) goto L80
            boolean r6 = r5.contains(r7)     // Catch: java.lang.Throwable -> L7e
            if (r6 == 0) goto L80
            boolean r6 = r5.contains(r1)     // Catch: java.lang.Throwable -> L7e
            if (r6 == 0) goto L80
            int r6 = r5.indexOf(r7)     // Catch: java.lang.Throwable -> L7e
            int r7 = r5.indexOf(r1)     // Catch: java.lang.Throwable -> L7e
            int r7 = r7 + 3
            java.lang.String r5 = r5.substring(r6, r7)     // Catch: java.lang.Throwable -> L7e
            r4.add(r5)     // Catch: java.lang.Throwable -> L7e
            goto L1a
        L7e:
            goto Lba
        L80:
            boolean r6 = r5.contains(r9)     // Catch: java.lang.Throwable -> L7e
            if (r6 != 0) goto L1a
            boolean r6 = r5.contains(r7)     // Catch: java.lang.Throwable -> L7e
            if (r6 == 0) goto L1a
            boolean r6 = r5.contains(r0)     // Catch: java.lang.Throwable -> L7e
            if (r6 == 0) goto L1a
            int r6 = r5.indexOf(r7)     // Catch: java.lang.Throwable -> L7e
            int r7 = r5.indexOf(r0)     // Catch: java.lang.Throwable -> L7e
            int r7 = r7 + 4
            java.lang.String r5 = r5.substring(r6, r7)     // Catch: java.lang.Throwable -> L7e
            r4.add(r5)     // Catch: java.lang.Throwable -> L7e
            goto L1a
        La5:
            int r9 = r4.size()     // Catch: java.lang.Throwable -> L7e
            if (r9 <= 0) goto Lb4
            org.json.JSONArray r9 = new org.json.JSONArray     // Catch: java.lang.Throwable -> L7e
            r9.<init>(r4)     // Catch: java.lang.Throwable -> L7e
            r3.close()     // Catch: java.io.IOException -> Lb3
        Lb3:
            return r9
        Lb4:
            r3.close()     // Catch: java.io.IOException -> Lbd
            goto Lbd
        Lb8:
            r3 = r2
        Lba:
            if (r3 == 0) goto Lbd
            goto Lb4
        Lbd:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.ac.d(android.content.Context):org.json.JSONArray");
    }

    public int e(Context context) {
        FileOutputStream fileOutputStream;
        Path path;
        Path readSymbolicLink;
        File file;
        try {
            if (Build.VERSION.SDK_INT < 26) {
                return a(context) ? 1 : 0;
            }
            String absolutePath = context.getFilesDir().getParentFile().getAbsolutePath();
            String str = "fk_w_" + System.currentTimeMillis();
            StringBuilder sb = new StringBuilder();
            sb.append(absolutePath);
            String str2 = File.separator;
            sb.append(str2);
            sb.append(str);
            fileOutputStream = new FileOutputStream(sb.toString());
            try {
                FileDescriptor fd = fileOutputStream.getFD();
                Field declaredField = fd.getClass().getDeclaredField("descriptor");
                declaredField.setAccessible(true);
                declaredField.get(fd);
                Integer num = (Integer) declaredField.get(fd);
                num.intValue();
                path = Paths.get(String.format("/proc/self/fd/%d", num), new String[0]);
                readSymbolicLink = Files.readSymbolicLink(path);
                file = readSymbolicLink.toFile();
                String absolutePath2 = file.getAbsolutePath();
                if (!absolutePath2.substring(absolutePath2.lastIndexOf(str2)).equals(str2 + str)) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception unused) {
                    }
                    return 1;
                }
                boolean canRead = new File(absolutePath2.replace(str, "")).getParentFile().canRead();
                File file2 = new File(absolutePath2);
                if (file2.exists()) {
                    file2.delete();
                }
                if (canRead) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception unused2) {
                    }
                    return 1;
                }
                try {
                    fileOutputStream.close();
                } catch (Exception unused3) {
                }
                return 0;
            } catch (Throwable unused4) {
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception unused5) {
                    }
                }
                return 0;
            }
        } catch (Throwable unused6) {
            fileOutputStream = null;
        }
    }

    public boolean f(Context context) {
        try {
            int i = context.getApplicationInfo().targetSdkVersion;
            Class<?> cls = Class.forName("android.os.SELinux");
            String str = (String) cls.getDeclaredMethod("getContext", null).invoke(cls, null);
            String a2 = a(i, Build.VERSION.SDK_INT);
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (str.startsWith(a2)) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean a(Context context) {
        try {
            return new File(context.getFilesDir().getParentFile().getAbsolutePath() + File.separator + "..").canRead();
        } catch (Throwable unused) {
            return false;
        }
    }

    private String a(int i, int i2) {
        if (i2 < 26) {
            return "u:r:untrusted_app";
        }
        if (i >= i2) {
            return "u:r:untrusted_app:s0";
        }
        if (i >= 26) {
            if (i2 == 27) {
                if (i >= 26) {
                    return "u:r:untrusted_app:s0";
                }
            } else if (i2 == 28 || i2 == 29) {
                if (i >= 26) {
                    return "u:r:untrusted_app_27:s0";
                }
            } else if (i2 == 30) {
                if (i >= 29) {
                    return "u:r:untrusted_app_29:s0";
                }
                return "u:r:untrusted_app_27:s0";
            }
            return "u:r:untrusted_app";
        }
        return "u:r:untrusted_app_25:s0";
    }
}
