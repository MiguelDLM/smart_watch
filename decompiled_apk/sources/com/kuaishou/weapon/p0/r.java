package com.kuaishou.weapon.p0;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* loaded from: classes11.dex */
public class r {
    private static r c;
    private static Application d;

    /* renamed from: a, reason: collision with root package name */
    public boolean f18409a;
    private String e;
    private static Random f = new Random();
    private static Map<String, s> g = new ConcurrentHashMap();
    private static Map<String, s> h = new ConcurrentHashMap();
    public static List<Integer> b = new ArrayList();

    private r() {
    }

    public static r a(Context context, boolean z) {
        try {
            if (c == null) {
                d = (Application) context.getApplicationContext();
                c = new r();
            }
        } catch (Throwable unused) {
        }
        return c;
    }

    public static boolean e(String str) {
        try {
            File file = new File(str);
            if (file.exists() && !file.isDirectory()) {
                file.delete();
            }
            if (!file.exists()) {
                file.mkdirs();
                return true;
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public boolean b(String str) {
        s sVar = h.get(str);
        if (sVar == null) {
            return false;
        }
        g.remove(sVar.e);
        h.remove(str);
        dn.c(sVar.m);
        Application application = d;
        if (application == null) {
            return true;
        }
        dn.c(application.getFileStreamPath(sVar.c).getAbsolutePath());
        return true;
    }

    public s c(String str) {
        try {
            return g.get(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public s d(String str) {
        try {
            return h.get(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static r a() {
        return c;
    }

    public boolean a(s sVar, boolean z) {
        this.f18409a = z;
        this.e = sVar.d;
        return a(sVar);
    }

    public Map<String, s> b() {
        return h;
    }

    private synchronized boolean a(s sVar) {
        boolean z;
        if (sVar != null) {
            if (!TextUtils.isEmpty(sVar.e)) {
                s sVar2 = g.get(sVar.e);
                if (sVar2 != null) {
                    if (sVar2.d.equals(sVar.d)) {
                        return true;
                    }
                    a(sVar2.e);
                }
                try {
                    sVar.f = d;
                    if (sVar.p == 1) {
                        try {
                            try {
                                if (!TextUtils.isEmpty(sVar.c) && !TextUtils.isEmpty(sVar.e)) {
                                    sVar.m = d.getFilesDir().getCanonicalPath() + bi.j + sVar.f18410a;
                                    String str = sVar.m + "/dex";
                                    String str2 = sVar.m + "/lib/" + this.e;
                                    dn.c(sVar.m + "/lib");
                                    String str3 = str2 + "/" + f.nextInt();
                                    e(str);
                                    dn.a(str, Boolean.FALSE);
                                    e(str3);
                                    a(sVar, str3, str, false);
                                    h.put(sVar.c, sVar);
                                    g.put(sVar.e, sVar);
                                } else {
                                    throw new RuntimeException("apkPackageName or apkPkgPath is null");
                                }
                            } catch (Throwable unused) {
                                return false;
                            }
                        } catch (Throwable unused2) {
                            a(sVar.e);
                            z = true;
                        }
                    }
                    z = false;
                    if (sVar.p != 1 || z) {
                        PackageInfo packageInfo = sVar.r;
                        if (packageInfo == null || TextUtils.isEmpty(packageInfo.packageName) || TextUtils.isEmpty(packageInfo.versionName)) {
                            packageInfo = d.getPackageManager().getPackageArchiveInfo(sVar.e, 1);
                        }
                        if (!TextUtils.isEmpty(packageInfo.packageName) && packageInfo.packageName.startsWith("com.kuaishou.weapon")) {
                            if (sVar.p != 1 && sVar.b != 1 && !((Boolean) a(sVar.j, sVar.e).first).booleanValue()) {
                                return false;
                            }
                            sVar.c = packageInfo.packageName;
                            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                            sVar.o = applicationInfo.className;
                            sVar.d = packageInfo.versionName;
                            sVar.l = packageInfo.activities;
                            sVar.q = applicationInfo.theme;
                            sVar.m = d.getFilesDir().getCanonicalPath() + bi.j + sVar.f18410a;
                            String str4 = sVar.m + "/dex";
                            String str5 = sVar.m + "/lib/" + this.e;
                            dn.c(sVar.m + "/lib");
                            String str6 = str5 + "/" + f.nextInt();
                            e(str4);
                            dn.a(str4, Boolean.FALSE);
                            e(str6);
                            a(sVar, str6, str4, true);
                            h.put(sVar.c, sVar);
                            g.put(sVar.e, sVar);
                            b.add(Integer.valueOf(sVar.f18410a));
                        } else {
                            throw new Exception("weapon package name check failed");
                        }
                    }
                    return true;
                } catch (Throwable unused3) {
                    a(sVar.e);
                    return false;
                }
            }
        }
        return false;
    }

    private Pair<Boolean, String> a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            File file = new File(str2);
            if (!dn.a(file)) {
                return new Pair<>(Boolean.FALSE, "");
            }
            String a2 = f.a(file);
            if (TextUtils.isEmpty(a2)) {
                return new Pair<>(Boolean.FALSE, "");
            }
            if (!a2.equalsIgnoreCase(str)) {
                return new Pair<>(Boolean.FALSE, a2);
            }
            return new Pair<>(Boolean.TRUE, "");
        }
        return new Pair<>(Boolean.FALSE, "");
    }

    public boolean a(String str) {
        s sVar = g.get(str);
        if (sVar == null) {
            return false;
        }
        g.remove(str);
        h.remove(sVar.c);
        dn.c(sVar.m);
        Application application = d;
        if (application == null) {
            return true;
        }
        dn.c(application.getFileStreamPath(sVar.c).getAbsolutePath());
        return true;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:27|(1:249)(15:31|32|33|34|(5:36|37|(4:39|40|41|(1:43)(1:231))(1:239)|44|(3:53|54|55))(2:244|245)|58|59|60|61|63|64|65|(3:66|67|(4:69|70|71|73)(1:165))|166|167)|168|169|(1:205)(8:174|175|176|177|178|(3:179|180|(4:182|183|184|186)(1:196))|197|198)|191|192|55|24|25) */
    /* JADX WARN: Can't wrap try/catch for region: R(8:31|(2:32|33)|34|(7:(5:36|37|(4:39|40|41|(1:43)(1:231))(1:239)|44|(3:53|54|55))(2:244|245)|63|64|65|(3:66|67|(4:69|70|71|73)(1:165))|166|167)|58|59|60|61) */
    /* JADX WARN: Can't wrap try/catch for region: R(9:31|32|33|34|(7:(5:36|37|(4:39|40|41|(1:43)(1:231))(1:239)|44|(3:53|54|55))(2:244|245)|63|64|65|(3:66|67|(4:69|70|71|73)(1:165))|166|167)|58|59|60|61) */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x0369, code lost:
    
        r0 = android.os.Build.CPU_ABI2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x036f, code lost:
    
        if (r13.contains(r0) == false) goto L188;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x0371, code lost:
    
        r14 = r26 + "/" + r0 + ":" + java.lang.System.getProperty("java.library.path");
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x02f1, code lost:
    
        if (r18 != null) goto L127;
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x02b1, code lost:
    
        if (r18 != null) goto L127;
     */
    /* JADX WARN: Code restructure failed: missing block: B:208:0x0229, code lost:
    
        r3 = null;
        r18 = r18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:255:0x0243, code lost:
    
        if (r18 == null) goto L171;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x02d3, code lost:
    
        if (r18 != null) goto L127;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0245, code lost:
    
        r18.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x02f5, code lost:
    
        r0 = android.os.Build.CPU_ABI;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0301, code lost:
    
        if (r13.contains(r0) == false) goto L251;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0303, code lost:
    
        r0 = r26 + "/" + r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0315, code lost:
    
        r1 = android.os.Build.CPU_ABI2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x031b, code lost:
    
        if (r13.contains(r1) == false) goto L179;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x031d, code lost:
    
        r16 = r26 + "/" + r1;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:112:0x03f6 A[Catch: all -> 0x046c, TryCatch #5 {all -> 0x046c, blocks: (B:109:0x03d5, B:110:0x03e8, B:112:0x03f6, B:114:0x0400, B:122:0x044a, B:123:0x046b, B:119:0x040a), top: B:108:0x03d5, inners: #26 }] */
    /* JADX WARN: Removed duplicated region for block: B:125:0x046c A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x02e9  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x02ee  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x02a9  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x02ae  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x046f  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0474  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0479  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x006d A[Catch: all -> 0x00a7, IOException -> 0x0190, EOFException -> 0x0195, FileNotFoundException | ZipException -> 0x019a, TryCatch #3 {all -> 0x00a7, blocks: (B:25:0x0067, B:27:0x006d, B:29:0x0083, B:31:0x0089, B:34:0x0090, B:37:0x0096, B:41:0x00a0, B:44:0x00bc, B:46:0x00c2, B:48:0x00c8, B:50:0x00ce, B:58:0x00e5, B:61:0x00f4, B:193:0x022d, B:195:0x0233), top: B:24:0x0067 }] */
    /* JADX WARN: Removed duplicated region for block: B:283:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x02cb  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x02d0  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0397  */
    /* JADX WARN: Type inference failed for: r11v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v12, types: [java.util.zip.ZipFile] */
    /* JADX WARN: Type inference failed for: r11v16, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r11v17 */
    /* JADX WARN: Type inference failed for: r11v18 */
    /* JADX WARN: Type inference failed for: r11v19 */
    /* JADX WARN: Type inference failed for: r11v21 */
    /* JADX WARN: Type inference failed for: r11v31 */
    /* JADX WARN: Type inference failed for: r11v44 */
    /* JADX WARN: Type inference failed for: r11v45 */
    /* JADX WARN: Type inference failed for: r11v46 */
    /* JADX WARN: Type inference failed for: r11v49 */
    /* JADX WARN: Type inference failed for: r11v50 */
    /* JADX WARN: Type inference failed for: r11v51 */
    /* JADX WARN: Type inference failed for: r11v8, types: [java.util.zip.ZipFile] */
    /* JADX WARN: Type inference failed for: r11v9, types: [java.util.zip.ZipFile] */
    /* JADX WARN: Type inference failed for: r18v10 */
    /* JADX WARN: Type inference failed for: r18v11 */
    /* JADX WARN: Type inference failed for: r18v12 */
    /* JADX WARN: Type inference failed for: r18v13 */
    /* JADX WARN: Type inference failed for: r18v14 */
    /* JADX WARN: Type inference failed for: r18v15 */
    /* JADX WARN: Type inference failed for: r18v16 */
    /* JADX WARN: Type inference failed for: r18v17 */
    /* JADX WARN: Type inference failed for: r18v18 */
    /* JADX WARN: Type inference failed for: r18v19 */
    /* JADX WARN: Type inference failed for: r18v20 */
    /* JADX WARN: Type inference failed for: r18v22 */
    /* JADX WARN: Type inference failed for: r18v23 */
    /* JADX WARN: Type inference failed for: r18v24 */
    /* JADX WARN: Type inference failed for: r18v25 */
    /* JADX WARN: Type inference failed for: r18v26 */
    /* JADX WARN: Type inference failed for: r18v27 */
    /* JADX WARN: Type inference failed for: r18v28 */
    /* JADX WARN: Type inference failed for: r18v3 */
    /* JADX WARN: Type inference failed for: r18v31 */
    /* JADX WARN: Type inference failed for: r18v32 */
    /* JADX WARN: Type inference failed for: r18v33 */
    /* JADX WARN: Type inference failed for: r18v34 */
    /* JADX WARN: Type inference failed for: r18v4 */
    /* JADX WARN: Type inference failed for: r18v5 */
    /* JADX WARN: Type inference failed for: r18v6 */
    /* JADX WARN: Type inference failed for: r18v7 */
    /* JADX WARN: Type inference failed for: r18v8 */
    /* JADX WARN: Type inference failed for: r18v9, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a(com.kuaishou.weapon.p0.s r25, java.lang.String r26, java.lang.String r27, boolean r28) {
        /*
            Method dump skipped, instructions count: 1149
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.r.a(com.kuaishou.weapon.p0.s, java.lang.String, java.lang.String, boolean):void");
    }

    private void a(s sVar, String str, String str2, HashSet<String> hashSet, byte[] bArr, StringBuilder sb, boolean z) {
        File file;
        String str3;
        ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(sVar.e));
        FileOutputStream fileOutputStream = null;
        while (true) {
            try {
                ZipEntry nextEntry = zipInputStream.getNextEntry();
                if (nextEntry == null) {
                    break;
                }
                String name = nextEntry.getName();
                if (!name.contains("../")) {
                    if (name.startsWith("lib/") && !nextEntry.isDirectory()) {
                        String str4 = Build.CPU_ABI;
                        try {
                            str3 = Build.CPU_ABI2;
                        } catch (Throwable unused) {
                            str3 = null;
                        }
                        if (!name.contains(str4)) {
                            if (!TextUtils.isEmpty(str3) && name.contains(str3)) {
                            }
                            if (name.contains("armeabi")) {
                                if (!"armeabi-v7a".equalsIgnoreCase(str4)) {
                                    if (!TextUtils.isEmpty(str3) && "armeabi-v7a".equalsIgnoreCase(str3)) {
                                    }
                                }
                            }
                        }
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(str);
                        sb2.append(name.substring(3).replace(".so", str2 + ".so"));
                        String sb3 = sb2.toString();
                        String substring = sb3.substring(0, sb3.lastIndexOf(47));
                        hashSet.add(substring.substring(substring.lastIndexOf(47) + 1));
                        e(substring);
                        File file2 = new File(sb3);
                        file2.delete();
                        file2.createNewFile();
                        FileOutputStream fileOutputStream2 = new FileOutputStream(sb3);
                        while (true) {
                            try {
                                int read = zipInputStream.read(bArr);
                                if (read <= 0) {
                                    break;
                                } else {
                                    fileOutputStream2.write(bArr, 0, read);
                                }
                            } catch (Throwable th) {
                                th = th;
                                fileOutputStream = fileOutputStream2;
                                zipInputStream.close();
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                                throw th;
                            }
                        }
                        fileOutputStream2.close();
                        dn.a(sb3, Boolean.TRUE);
                        fileOutputStream = fileOutputStream2;
                    }
                    try {
                        if (name.endsWith(".dex") && !nextEntry.isDirectory() && z) {
                            String str5 = sVar.m;
                            e(str5);
                            file = new File(str5, sVar.f18410a + HelpFormatter.DEFAULT_OPT_PREFIX + sVar.d + ".dex");
                            try {
                                file.delete();
                                file.createNewFile();
                                FileOutputStream fileOutputStream3 = new FileOutputStream(file);
                                while (true) {
                                    try {
                                        int read2 = zipInputStream.read(bArr);
                                        if (read2 <= 0) {
                                            break;
                                        } else {
                                            fileOutputStream3.write(bArr, 0, read2);
                                        }
                                    } catch (Throwable unused2) {
                                        fileOutputStream = fileOutputStream3;
                                        if (file != null && file.exists()) {
                                            file.delete();
                                        }
                                        zipInputStream.closeEntry();
                                    }
                                }
                                fileOutputStream3.close();
                                if (sb.length() > 0) {
                                    sb.setLength(0);
                                }
                                sb.append(file.getAbsolutePath());
                                dn.a(sb.toString(), Boolean.TRUE);
                                fileOutputStream = fileOutputStream3;
                            } catch (Throwable unused3) {
                            }
                        }
                    } catch (Throwable unused4) {
                        file = null;
                    }
                    zipInputStream.closeEntry();
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        zipInputStream.close();
        if (fileOutputStream != null) {
            fileOutputStream.close();
        }
    }
}
