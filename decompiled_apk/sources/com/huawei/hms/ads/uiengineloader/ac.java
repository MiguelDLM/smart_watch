package com.huawei.hms.ads.uiengineloader;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

/* loaded from: classes10.dex */
public final class ac {

    /* renamed from: a, reason: collision with root package name */
    public static final int f17331a = 0;
    private static final String b = "ExtractNativeUtils";
    private static final int c = -1;
    private static final int d = 128;
    private static final int e = 50;
    private static final int f = 52428800;
    private static final Pattern g = Pattern.compile("lib/([^/]+)/(.*\\.so)$");

    /* loaded from: classes10.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        String f17332a;
        ZipEntry b;
        String c;

        private a(ZipEntry zipEntry, String str, String str2) {
            this.b = zipEntry;
            this.f17332a = str;
            this.c = str2;
        }

        public /* synthetic */ a(ZipEntry zipEntry, String str, String str2, byte b) {
            this(zipEntry, str, str2);
        }
    }

    public static int a(File file, String str) {
        af.b(b, "begin extractNativeLibrary");
        int i = 0;
        ZipFile zipFile = null;
        try {
            try {
                ZipFile zipFile2 = new ZipFile(file);
                try {
                    try {
                        Enumeration<? extends ZipEntry> entries = zipFile2.entries();
                        HashMap hashMap = new HashMap();
                        int a2 = a(entries, (HashMap<String, HashSet<a>>) hashMap, 0);
                        if (a2 == -1) {
                            af.d(b, "Unsafe zip name!");
                            aj.a(zipFile2);
                            return -1;
                        }
                        if (a2 > 50) {
                            af.d(b, "the total number is larger than the max");
                            aj.a(zipFile2);
                            return -1;
                        }
                        Iterator it = hashMap.keySet().iterator();
                        int i2 = 0;
                        while (it.hasNext()) {
                            try {
                                Set<a> set = (Set) hashMap.get((String) it.next());
                                if (set == null) {
                                    af.d(b, "Get nativeZipEntries failed.");
                                    aj.a(zipFile2);
                                    return -1;
                                }
                                for (a aVar : set) {
                                    String str2 = str + File.separator + aVar.c;
                                    ad.a(str2);
                                    new File(str2).setExecutable(true, false);
                                    i2 = a(zipFile2, aVar, str2);
                                    if (i2 != 0) {
                                        aj.a(zipFile2);
                                        return i2;
                                    }
                                    new File(str2, aVar.f17332a).setReadable(true, false);
                                }
                            } catch (IOException unused) {
                                zipFile = zipFile2;
                                i = i2;
                                af.d(b, "catch IOException");
                                aj.a(zipFile);
                                return i;
                            }
                        }
                        aj.a(zipFile2);
                        return i2;
                    } catch (Throwable th) {
                        th = th;
                        zipFile = zipFile2;
                        aj.a(zipFile);
                        throw th;
                    }
                } catch (IOException unused2) {
                    zipFile = zipFile2;
                }
            } catch (IOException unused3) {
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static int a(Enumeration enumeration, HashMap<String, HashSet<a>> hashMap, int i) {
        while (enumeration.hasMoreElements()) {
            Object nextElement = enumeration.nextElement();
            if (nextElement != null && (nextElement instanceof ZipEntry)) {
                ZipEntry zipEntry = (ZipEntry) nextElement;
                String name = zipEntry.getName();
                if (name.contains("../")) {
                    af.d(b, "Unsafe zip name!");
                    return -1;
                }
                Matcher matcher = g.matcher(name);
                if (matcher.matches()) {
                    String group = matcher.group(1);
                    String group2 = matcher.group(2);
                    HashSet<a> hashSet = hashMap.get(group);
                    if (hashSet == null) {
                        hashSet = new HashSet<>();
                        hashMap.put(group, hashSet);
                    }
                    hashSet.add(new a(zipEntry, group2, group, (byte) 0));
                    i++;
                }
            }
        }
        return i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0027, code lost:
    
        com.huawei.hms.ads.uiengineloader.af.d(com.huawei.hms.ads.uiengineloader.ac.b, "so file too big , " + r9.c + " , " + r9.f17332a);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int a(java.util.zip.ZipFile r8, com.huawei.hms.ads.uiengineloader.ac.a r9, java.lang.String r10) {
        /*
            java.lang.String r0 = "ExtractNativeUtils"
            r1 = 4096(0x1000, float:5.74E-42)
            r2 = -1
            r3 = 0
            byte[] r1 = new byte[r1]     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L5e java.io.FileNotFoundException -> L70
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L5e java.io.FileNotFoundException -> L70
            java.io.File r5 = new java.io.File     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L5e java.io.FileNotFoundException -> L70
            java.lang.String r6 = r9.f17332a     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L5e java.io.FileNotFoundException -> L70
            r5.<init>(r10, r6)     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L5e java.io.FileNotFoundException -> L70
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L5e java.io.FileNotFoundException -> L70
            java.util.zip.ZipEntry r10 = r9.b     // Catch: java.lang.Throwable -> L45 java.io.IOException -> L55 java.io.FileNotFoundException -> L58
            java.io.InputStream r3 = r8.getInputStream(r10)     // Catch: java.lang.Throwable -> L45 java.io.IOException -> L55 java.io.FileNotFoundException -> L58
            r8 = 0
            r10 = 0
        L1c:
            int r5 = r3.read(r1)     // Catch: java.lang.Throwable -> L45 java.io.IOException -> L55 java.io.FileNotFoundException -> L58
            if (r5 <= 0) goto L4d
            int r10 = r10 + r5
            r6 = 52428800(0x3200000, float:4.7019774E-37)
            if (r10 <= r6) goto L49
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L45 java.io.IOException -> L55 java.io.FileNotFoundException -> L58
            java.lang.String r10 = "so file too big , "
            r8.<init>(r10)     // Catch: java.lang.Throwable -> L45 java.io.IOException -> L55 java.io.FileNotFoundException -> L58
            java.lang.String r10 = r9.c     // Catch: java.lang.Throwable -> L45 java.io.IOException -> L55 java.io.FileNotFoundException -> L58
            r8.append(r10)     // Catch: java.lang.Throwable -> L45 java.io.IOException -> L55 java.io.FileNotFoundException -> L58
            java.lang.String r10 = " , "
            r8.append(r10)     // Catch: java.lang.Throwable -> L45 java.io.IOException -> L55 java.io.FileNotFoundException -> L58
            java.lang.String r9 = r9.f17332a     // Catch: java.lang.Throwable -> L45 java.io.IOException -> L55 java.io.FileNotFoundException -> L58
            r8.append(r9)     // Catch: java.lang.Throwable -> L45 java.io.IOException -> L55 java.io.FileNotFoundException -> L58
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Throwable -> L45 java.io.IOException -> L55 java.io.FileNotFoundException -> L58
            com.huawei.hms.ads.uiengineloader.af.d(r0, r8)     // Catch: java.lang.Throwable -> L45 java.io.IOException -> L55 java.io.FileNotFoundException -> L58
            goto L4e
        L45:
            r8 = move-exception
            r9 = r3
            r3 = r4
            goto L75
        L49:
            r4.write(r1, r8, r5)     // Catch: java.lang.Throwable -> L45 java.io.IOException -> L55 java.io.FileNotFoundException -> L58
            goto L1c
        L4d:
            r2 = 0
        L4e:
            com.huawei.hms.ads.uiengineloader.aj.a(r4)
            com.huawei.hms.ads.uiengineloader.aj.a(r3)
            goto L74
        L55:
            r8 = r3
            r3 = r4
            goto L5f
        L58:
            r8 = r3
            r3 = r4
            goto L71
        L5b:
            r8 = move-exception
            r9 = r3
            goto L75
        L5e:
            r8 = r3
        L5f:
            java.lang.String r9 = "IOException"
        L61:
            com.huawei.hms.ads.uiengineloader.af.d(r0, r9)     // Catch: java.lang.Throwable -> L6b
            com.huawei.hms.ads.uiengineloader.aj.a(r3)
            com.huawei.hms.ads.uiengineloader.aj.a(r8)
            goto L74
        L6b:
            r9 = move-exception
            r7 = r9
            r9 = r8
            r8 = r7
            goto L75
        L70:
            r8 = r3
        L71:
            java.lang.String r9 = "FileNotFoundException"
            goto L61
        L74:
            return r2
        L75:
            com.huawei.hms.ads.uiengineloader.aj.a(r3)
            com.huawei.hms.ads.uiengineloader.aj.a(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.ads.uiengineloader.ac.a(java.util.zip.ZipFile, com.huawei.hms.ads.uiengineloader.ac$a, java.lang.String):int");
    }

    public static int a(ZipFile zipFile, Set<a> set, String str) {
        af.b(b, "begin extractNativeLibrary ");
        int i = 0;
        for (a aVar : set) {
            File file = new File(str);
            if (!file.exists()) {
                ad.a(str);
            }
            file.setExecutable(true, false);
            int a2 = a(zipFile, aVar, str);
            if (a2 != 0) {
                return a2;
            }
            File file2 = new File(str, aVar.f17332a);
            if (Build.VERSION.SDK_INT < 23) {
                String a3 = ad.a(file2);
                if (!TextUtils.isEmpty(a3) && a3.length() > 128) {
                    af.c(b, file2.getName() + "  too long,  length > 128");
                    return -1;
                }
            }
            file2.setReadable(true, false);
            i = a2;
        }
        return i;
    }

    public static void a(Enumeration enumeration, Set<a> set, String str) throws ZipException {
        while (enumeration.hasMoreElements()) {
            Object nextElement = enumeration.nextElement();
            if (nextElement != null && (nextElement instanceof ZipEntry)) {
                ZipEntry zipEntry = (ZipEntry) nextElement;
                String name = zipEntry.getName();
                if (name.contains("../")) {
                    throw new ZipException("Unsafe zip name!");
                }
                Matcher matcher = g.matcher(name);
                if (matcher.matches()) {
                    String group = matcher.group(1);
                    String group2 = matcher.group(2);
                    if (group.equals(str)) {
                        set.add(new a(zipEntry, group2, group, (byte) 0));
                    }
                }
            }
        }
    }

    public static boolean a(Context context, String str) {
        if (Build.VERSION.SDK_INT <= 23) {
            af.b(b, "The android version is below android 6.");
            return true;
        }
        try {
            if ((context.getPackageManager().getPackageArchiveInfo(str, 128).applicationInfo.flags & 268435456) == 268435456) {
                af.b(b, "The extract-native-flag has set, need to extract.");
                return true;
            }
            af.b(b, "The extract-native-flag has not set, No need to extract.");
            return false;
        } catch (Exception unused) {
            af.c(b, "Get package name failed: name not found.");
            return true;
        }
    }
}
