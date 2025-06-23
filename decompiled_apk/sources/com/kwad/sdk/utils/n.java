package com.kwad.sdk.utils;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.service.ServiceProvider;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashSet;

/* loaded from: classes11.dex */
public final class n {
    public static com.kwad.sdk.k.a.d aPI;

    /* loaded from: classes11.dex */
    public static class a extends com.kwad.sdk.k.a.a {
        public a() {
            LP();
        }

        private void LP() {
            ArrayList arrayList = new ArrayList();
            this.aNY = arrayList;
            arrayList.add(new com.kwad.sdk.k.a.a(this.enabled) { // from class: com.kwad.sdk.utils.n.a.1
                @Override // com.kwad.sdk.k.a.a
                public final boolean bO(Context context) {
                    int i;
                    String str = Build.PRODUCT;
                    if (!str.contains("sdk") && !str.contains("Andy") && !str.contains("ttVM_Hdragon") && !str.contains("google_sdk") && !str.contains("Droid4X") && !str.contains("nox") && !str.contains("sdk_x86") && !str.contains("sdk_google") && !str.contains("vbox86p") && !str.contains("aries")) {
                        i = 0;
                    } else {
                        i = 1;
                    }
                    String str2 = Build.MANUFACTURER;
                    if (str2.equals("unknown") || str2.equals("Genymotion") || str2.contains("Andy") || str2.contains("MIT") || str2.contains("nox") || str2.contains("TiantianVM")) {
                        i++;
                    }
                    String str3 = Build.BRAND;
                    if (str3.equals("generic") || str3.equals("generic_x86") || str3.equals("TTVM") || str3.contains("Andy")) {
                        i++;
                    }
                    String str4 = Build.DEVICE;
                    if (str4.contains("generic") || str4.contains("generic_x86") || str4.contains("Andy") || str4.contains("ttVM_Hdragon") || str4.contains("Droid4X") || str4.contains("nox") || str4.contains("generic_x86_64") || str4.contains("vbox86p") || str4.contains("aries")) {
                        i++;
                    }
                    String str5 = Build.MODEL;
                    if (str5.equals("sdk") || str5.contains("Emulator") || str5.equals("google_sdk") || str5.contains("Droid4X") || str5.contains("TiantianVM") || str5.contains("Andy") || str5.equals("Android SDK built for x86_64") || str5.equals("Android SDK built for x86")) {
                        i++;
                    }
                    String str6 = Build.HARDWARE;
                    if (str6.equals("goldfish") || str6.equals("vbox86") || str6.contains("nox") || str6.contains("ttVM_x86")) {
                        i++;
                    }
                    String str7 = Build.FINGERPRINT;
                    if (str7.contains("generic/sdk/generic") || str7.contains("generic_x86/sdk_x86/generic_x86") || str7.contains("Andy") || str7.contains("ttVM_Hdragon") || str7.contains("generic_x86_64") || str7.contains("generic/google_sdk/generic") || str7.contains("vbox86p") || str7.contains("generic/vbox86p/vbox86p")) {
                        i++;
                    }
                    try {
                        StringBuilder sb = new StringBuilder();
                        sb.append(Environment.getExternalStorageDirectory().toString());
                        char c = File.separatorChar;
                        sb.append(c);
                        sb.append("windows");
                        sb.append(c);
                        sb.append("BstSharedFolder");
                        if (new File(sb.toString()).exists()) {
                            i += 10;
                        }
                    } catch (Exception unused) {
                    }
                    if (i > 3) {
                        return true;
                    }
                    return false;
                }
            });
            this.aNY.add(new com.kwad.sdk.k.a.a(this.enabled) { // from class: com.kwad.sdk.utils.n.a.2
                @Override // com.kwad.sdk.k.a.a
                public final boolean bO(Context context) {
                    return "1".equals(bi.get("ro.kernel.qemu"));
                }
            });
        }
    }

    /* loaded from: classes11.dex */
    public static class b extends com.kwad.sdk.k.a.a {
    }

    /* loaded from: classes11.dex */
    public static class c extends com.kwad.sdk.k.a.a {
    }

    /* loaded from: classes11.dex */
    public static class d extends com.kwad.sdk.k.a.a {
        public d() {
            LP();
        }

        private void LP() {
            ArrayList arrayList = new ArrayList();
            this.aNY = arrayList;
            arrayList.add(new com.kwad.sdk.k.a.a(this.enabled) { // from class: com.kwad.sdk.utils.n.d.1
                @Override // com.kwad.sdk.k.a.a
                public final boolean bO(Context context) {
                    return new File("/system/app/Superuser.apk").exists();
                }
            });
            this.aNY.add(new com.kwad.sdk.k.a.a(this.enabled) { // from class: com.kwad.sdk.utils.n.d.2
                @Override // com.kwad.sdk.k.a.a
                public final boolean bO(Context context) {
                    String[] strArr = {"/system/bin/", "/system/xbin/", "/system/sbin/", "/sbin/", "/vendor/bin/"};
                    for (int i = 0; i < 5; i++) {
                        if (new File(strArr[i] + com.kuaishou.weapon.p0.bi.y).exists()) {
                            return true;
                        }
                    }
                    return false;
                }
            });
            this.aNY.add(new com.kwad.sdk.k.a.a(this.enabled) { // from class: com.kwad.sdk.utils.n.d.3
                @Override // com.kwad.sdk.k.a.a
                public final boolean bO(Context context) {
                    if (!TextUtils.isEmpty(n.g(new String[]{"/system/xbin/which", com.kuaishou.weapon.p0.bi.y}))) {
                        return true;
                    }
                    return false;
                }
            });
            this.aNY.add(new com.kwad.sdk.k.a.a(this.enabled) { // from class: com.kwad.sdk.utils.n.d.4
                @Override // com.kwad.sdk.k.a.a
                public final boolean bO(Context context) {
                    Charset forName = Charset.forName("UTF-8");
                    File file = new File("/data/su_test");
                    try {
                        q.a(file, "ok", forName, false);
                        return q.a(file, forName).equals("ok");
                    } catch (Throwable unused) {
                        return false;
                    }
                }
            });
        }
    }

    /* loaded from: classes11.dex */
    public static class e extends com.kwad.sdk.k.a.a {
        public e() {
            LP();
        }

        private void LP() {
            ArrayList arrayList = new ArrayList();
            this.aNY = arrayList;
            arrayList.add(new com.kwad.sdk.k.a.a(this.enabled) { // from class: com.kwad.sdk.utils.n.e.1
                @Override // com.kwad.sdk.k.a.a
                public final boolean bO(Context context) {
                    if (!al.an(context, "de.robv.android.xposed.installer") && !al.an(context, "com.saurik.substrate")) {
                        return false;
                    }
                    return true;
                }
            });
            this.aNY.add(new com.kwad.sdk.k.a.a(this.enabled) { // from class: com.kwad.sdk.utils.n.e.2
                @Override // com.kwad.sdk.k.a.a
                public final boolean bO(Context context) {
                    try {
                        throw new Exception("empty");
                    } catch (Exception e) {
                        boolean z = false;
                        int i = 0;
                        for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                            String className = stackTraceElement.getClassName();
                            String methodName = stackTraceElement.getMethodName();
                            if (className.equals("com.android.internal.os.ZygoteInit") && (i = i + 1) == 2) {
                                z = true;
                            }
                            if (className.equals("com.saurik.substrate.MS$2") && methodName.equals("invoked")) {
                                Log.wtf("HookDetection", "A method on the stack trace has been hooked using Substrate.");
                                z = true;
                            }
                            if (className.equals(com.kuaishou.weapon.p0.an.b) && methodName.equals("main")) {
                                z = true;
                            }
                            if (className.equals(com.kuaishou.weapon.p0.an.b) && methodName.equals("handleHookedMethod")) {
                                z = true;
                            }
                        }
                        return z;
                    }
                }
            });
            this.aNY.add(new com.kwad.sdk.k.a.a(this.enabled) { // from class: com.kwad.sdk.utils.n.e.3
                @Override // com.kwad.sdk.k.a.a
                public final boolean bO(Context context) {
                    FileReader fileReader;
                    boolean z = false;
                    BufferedReader bufferedReader = null;
                    try {
                        HashSet<String> hashSet = new HashSet();
                        fileReader = new FileReader("/proc/" + Process.myPid() + "/maps");
                        try {
                            BufferedReader bufferedReader2 = new BufferedReader(fileReader);
                            while (true) {
                                try {
                                    String readLine = bufferedReader2.readLine();
                                    if (readLine == null) {
                                        break;
                                    }
                                    if (!readLine.endsWith(".so") && !readLine.endsWith(".jar")) {
                                    }
                                    hashSet.add(readLine.substring(readLine.lastIndexOf(" ") + 1));
                                } catch (Exception unused) {
                                    bufferedReader = bufferedReader2;
                                    com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                                    com.kwad.sdk.crash.utils.b.closeQuietly(fileReader);
                                    return z;
                                } catch (Throwable th) {
                                    th = th;
                                    bufferedReader = bufferedReader2;
                                    com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                                    com.kwad.sdk.crash.utils.b.closeQuietly(fileReader);
                                    throw th;
                                }
                            }
                            for (String str : hashSet) {
                                if (str.contains("com.saurik.substrate")) {
                                    Log.wtf("HookDetection", "Substrate shared object found: " + str);
                                    z = true;
                                }
                                if (str.contains("XposedBridge.jar")) {
                                    Log.wtf("HookDetection", "Xposed JAR found: " + str);
                                    z = true;
                                }
                            }
                            com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader2);
                        } catch (Exception unused2) {
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } catch (Exception unused3) {
                        fileReader = null;
                    } catch (Throwable th3) {
                        th = th3;
                        fileReader = null;
                    }
                    com.kwad.sdk.crash.utils.b.closeQuietly(fileReader);
                    return z;
                }
            });
        }
    }

    @WorkerThread
    public static synchronized com.kwad.sdk.k.a.d LO() {
        synchronized (n.class) {
            if (!((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).zj()) {
                return null;
            }
            com.kwad.sdk.k.a.d dVar = aPI;
            if (dVar != null) {
                return dVar;
            }
            Context applicationContext = ServiceProvider.getContext().getApplicationContext();
            com.kwad.sdk.k.a.d dVar2 = new com.kwad.sdk.k.a.d(applicationContext);
            boolean bN = new d().bN(applicationContext);
            boolean bN2 = new e().bN(applicationContext);
            boolean bN3 = new b().bN(applicationContext);
            boolean bN4 = new a().bN(applicationContext);
            boolean bN5 = new c().bN(applicationContext);
            dVar2.bJ(bN);
            dVar2.bK(bN2);
            dVar2.bL(bN3);
            dVar2.bN(bN4);
            dVar2.bO(bN5);
            aPI = dVar2;
            return dVar2;
        }
    }

    public static String g(String[] strArr) {
        try {
            return com.kwad.sdk.crash.utils.h.c(Runtime.getRuntime().exec(strArr).getInputStream());
        } catch (Exception unused) {
            return null;
        }
    }
}
