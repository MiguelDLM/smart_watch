package com.tencent.bugly.proguard;

import XXO0.oIX0oI;
import android.content.Context;
import android.text.TextUtils;
import com.alimm.tanx.core.constant.AdClickConstants;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* loaded from: classes13.dex */
public final class be {

    /* renamed from: a, reason: collision with root package name */
    private static List<File> f26593a = new ArrayList();

    public static String a(String str) {
        if (str == null) {
            return "";
        }
        String[] split = str.split("\n");
        if (split == null || split.length == 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        for (String str2 : split) {
            if (!str2.contains("java.lang.Thread.getStackTrace(")) {
                sb.append(str2);
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    private static String b(String str, String str2) {
        BufferedReader b = ap.b(str, "reg_record.txt");
        if (b == null) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            String readLine = b.readLine();
            if (readLine != null && readLine.startsWith(str2)) {
                int i = 18;
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    String readLine2 = b.readLine();
                    if (readLine2 == null) {
                        break;
                    }
                    if (i2 % 4 == 0) {
                        if (i2 > 0) {
                            sb.append("\n");
                        }
                        sb.append("  ");
                    } else {
                        if (readLine2.length() > 16) {
                            i = 28;
                        }
                        sb.append("                ".substring(0, i - i3));
                    }
                    i3 = readLine2.length();
                    sb.append(readLine2);
                    i2++;
                }
                sb.append("\n");
                return sb.toString();
            }
            try {
                b.close();
            } catch (Exception e) {
                al.a(e);
            }
            return null;
        } catch (Throwable th) {
            try {
                al.a(th);
                try {
                    b.close();
                } catch (Exception e2) {
                    al.a(e2);
                }
                return null;
            } finally {
                try {
                    b.close();
                } catch (Exception e3) {
                    al.a(e3);
                }
            }
        }
    }

    private static String c(String str, String str2) {
        BufferedReader b = ap.b(str, "map_record.txt");
        if (b == null) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            String readLine = b.readLine();
            if (readLine != null && readLine.startsWith(str2)) {
                while (true) {
                    String readLine2 = b.readLine();
                    if (readLine2 == null) {
                        break;
                    }
                    sb.append("  ");
                    sb.append(readLine2);
                    sb.append("\n");
                }
                return sb.toString();
            }
            try {
                b.close();
            } catch (Exception e) {
                al.a(e);
            }
            return null;
        } catch (Throwable th) {
            try {
                al.a(th);
                try {
                    b.close();
                } catch (Exception e2) {
                    al.a(e2);
                }
                return null;
            } finally {
                try {
                    b.close();
                } catch (Exception e3) {
                    al.a(e3);
                }
            }
        }
    }

    private static Map<String, Integer> d(String str) {
        if (str == null) {
            return null;
        }
        try {
            HashMap hashMap = new HashMap();
            for (String str2 : str.split(",")) {
                String[] split = str2.split(":");
                if (split.length != 2) {
                    al.e("error format at %s", str2);
                    return null;
                }
                hashMap.put(split[0], Integer.valueOf(Integer.parseInt(split[1])));
            }
            return hashMap;
        } catch (Exception e) {
            al.e("error format intStateStr %s", str);
            e.printStackTrace();
            return null;
        }
    }

    private static <KeyT, ValueT> ValueT a(Map<KeyT, ValueT> map, KeyT keyt, ValueT valuet) {
        ValueT valuet2;
        try {
            valuet2 = map.get(keyt);
        } catch (Exception e) {
            al.a(e);
        }
        return valuet2 != null ? valuet2 : valuet;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0026, code lost:
    
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0032, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x002f, code lost:
    
        if (r1 == null) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String a(java.io.BufferedInputStream r4) throws java.io.IOException {
        /*
            r0 = 0
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L2a
            r2 = 1024(0x400, float:1.435E-42)
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L2a
        L8:
            int r2 = r4.read()     // Catch: java.lang.Throwable -> L20
            r3 = -1
            if (r2 == r3) goto L26
            if (r2 != 0) goto L22
            java.lang.String r4 = new java.lang.String     // Catch: java.lang.Throwable -> L20
            byte[] r2 = r1.toByteArray()     // Catch: java.lang.Throwable -> L20
            java.lang.String r3 = "UTf-8"
            r4.<init>(r2, r3)     // Catch: java.lang.Throwable -> L20
            r1.close()
            return r4
        L20:
            r4 = move-exception
            goto L2c
        L22:
            r1.write(r2)     // Catch: java.lang.Throwable -> L20
            goto L8
        L26:
            r1.close()
            goto L32
        L2a:
            r4 = move-exception
            r1 = r0
        L2c:
            com.tencent.bugly.proguard.al.a(r4)     // Catch: java.lang.Throwable -> L33
            if (r1 == 0) goto L32
            goto L26
        L32:
            return r0
        L33:
            r4 = move-exception
            if (r1 == 0) goto L39
            r1.close()
        L39:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.be.a(java.io.BufferedInputStream):java.lang.String");
    }

    /* JADX WARN: Type inference failed for: r7v3, types: [boolean] */
    public static CrashDetailBean a(Context context, String str, NativeExceptionHandler nativeExceptionHandler) {
        BufferedInputStream bufferedInputStream;
        String str2;
        String a2;
        BufferedInputStream bufferedInputStream2 = null;
        if (context != null && str != null && nativeExceptionHandler != null) {
            File file = new File(str, "rqd_record.eup");
            if (file.exists()) {
                ?? canRead = file.canRead();
                try {
                    if (canRead != 0) {
                        try {
                            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                            try {
                                String a3 = a(bufferedInputStream);
                                if (a3 != null && a3.equals("NATIVE_RQD_REPORT")) {
                                    HashMap hashMap = new HashMap();
                                    loop0: while (true) {
                                        str2 = null;
                                        while (true) {
                                            a2 = a(bufferedInputStream);
                                            if (a2 == null) {
                                                break loop0;
                                            }
                                            if (str2 == null) {
                                                str2 = a2;
                                            }
                                        }
                                        hashMap.put(str2, a2);
                                    }
                                    if (str2 != null) {
                                        al.e("record not pair! drop! %s", str2);
                                        try {
                                            bufferedInputStream.close();
                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        }
                                        return null;
                                    }
                                    CrashDetailBean a4 = a(context, hashMap, nativeExceptionHandler);
                                    try {
                                        bufferedInputStream.close();
                                    } catch (IOException e2) {
                                        e2.printStackTrace();
                                    }
                                    return a4;
                                }
                                al.e("record read fail! %s", a3);
                                try {
                                    bufferedInputStream.close();
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                }
                                return null;
                            } catch (IOException e4) {
                                e = e4;
                                e.printStackTrace();
                                if (bufferedInputStream != null) {
                                    try {
                                        bufferedInputStream.close();
                                    } catch (IOException e5) {
                                        e5.printStackTrace();
                                    }
                                }
                                return null;
                            }
                        } catch (IOException e6) {
                            e = e6;
                            bufferedInputStream = null;
                        } catch (Throwable th) {
                            th = th;
                            if (bufferedInputStream2 != null) {
                                try {
                                    bufferedInputStream2.close();
                                } catch (IOException e7) {
                                    e7.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedInputStream2 = canRead;
                }
            }
            return null;
        }
        al.e("get eup record file args error", new Object[0]);
        return null;
    }

    public static void c(String str) {
        File[] listFiles;
        if (str == null) {
            return;
        }
        try {
            File file = new File(str);
            if (file.canRead() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File file2 : listFiles) {
                    if (file2.canRead() && file2.canWrite() && file2.length() == 0) {
                        file2.delete();
                        al.c("Delete empty record file %s", file2.getAbsoluteFile());
                    }
                }
            }
        } catch (Throwable th) {
            al.a(th);
        }
    }

    public static String b(String str) {
        if (str == null) {
            return null;
        }
        File file = new File(str, "backup_record.txt");
        if (file.exists()) {
            return file.getAbsolutePath();
        }
        return null;
    }

    private static long b(Map<String, String> map) {
        String str = map.get(AdClickConstants.ACTIVITY_LAUNCH_TIME);
        if (str == null) {
            return -1L;
        }
        al.c("[Native record info] launchTime: %s", str);
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e) {
            if (al.a(e)) {
                return -1L;
            }
            e.printStackTrace();
            return -1L;
        }
    }

    public static String a(String str, String str2) {
        if (str == null || str2 == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        String b = b(str, str2);
        if (b != null && !b.isEmpty()) {
            sb.append("Register infos:\n");
            sb.append(b);
        }
        String c = c(str, str2);
        if (c != null && !c.isEmpty()) {
            if (sb.length() > 0) {
                sb.append("\n");
            }
            sb.append("System SO infos:\n");
            sb.append(c);
        }
        return sb.toString();
    }

    public static void a(boolean z, String str) {
        if (str != null) {
            f26593a.add(new File(str, "rqd_record.eup"));
            f26593a.add(new File(str, "reg_record.txt"));
            f26593a.add(new File(str, "map_record.txt"));
            f26593a.add(new File(str, "backup_record.txt"));
            if (z) {
                c(str);
            }
        }
        List<File> list = f26593a;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (File file : f26593a) {
            if (file.exists() && file.canWrite()) {
                file.delete();
                al.c("Delete record file %s", file.getAbsoluteFile());
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.lang.String] */
    public static String a(String str, int i, String str2, boolean z) {
        BufferedReader bufferedReader = null;
        if (str != null && i > 0) {
            File file = new File(str);
            if (file.exists() && file.canRead()) {
                al.a("Read system log from native record file(length: %s bytes): %s", Long.valueOf(file.length()), file.getAbsolutePath());
                f26593a.add(file);
                al.c("Add this record file to list for cleaning lastly.", new Object[0]);
                if (str2 == null) {
                    return ap.a(new File(str), i, z);
                }
                String sb = new StringBuilder();
                try {
                    try {
                        BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
                        while (true) {
                            try {
                                String readLine = bufferedReader2.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                if (Pattern.compile(str2 + "[ ]*:").matcher(readLine).find()) {
                                    sb.append(readLine);
                                    sb.append("\n");
                                }
                                if (i > 0 && sb.length() > i) {
                                    if (z) {
                                        sb.delete(i, sb.length());
                                        break;
                                    }
                                    sb.delete(0, sb.length() - i);
                                }
                            } catch (Throwable th) {
                                th = th;
                                bufferedReader = bufferedReader2;
                                try {
                                    al.a(th);
                                    sb.append("\n[error:" + th.toString() + "]");
                                    String sb2 = sb.toString();
                                    if (bufferedReader == null) {
                                        return sb2;
                                    }
                                    bufferedReader.close();
                                    sb = sb2;
                                    return sb;
                                } catch (Throwable th2) {
                                    if (bufferedReader != null) {
                                        try {
                                            bufferedReader.close();
                                        } catch (Exception e) {
                                            al.a(e);
                                        }
                                    }
                                    throw th2;
                                }
                            }
                        }
                        String sb3 = sb.toString();
                        bufferedReader2.close();
                        sb = sb3;
                    } catch (Exception e2) {
                        al.a(e2);
                        return sb;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
                return sb;
            }
        }
        return null;
    }

    private static Map<String, String> a(Map<String, String> map) {
        String str = map.get("key-value");
        if (str == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (String str2 : str.split("\n")) {
            String[] split = str2.split("=");
            if (split.length == 2) {
                hashMap.put(split[0], split[1]);
            }
        }
        return hashMap;
    }

    private static CrashDetailBean a(Context context, Map<String, String> map, NativeExceptionHandler nativeExceptionHandler) {
        String str;
        String str2;
        boolean z;
        if (aa.a(context) == null) {
            al.e("abnormal com info not created", new Object[0]);
        } else {
            String str3 = map.get("intStateStr");
            if (str3 != null && str3.trim().length() > 0) {
                Map<String, Integer> d = d(map.get("intStateStr"));
                if (d == null) {
                    al.e("parse intSateMap fail", Integer.valueOf(map.size()));
                    return null;
                }
                try {
                    d.get("sino").intValue();
                    d.get("sud").intValue();
                    String str4 = map.get("soVersion");
                    if (!TextUtils.isEmpty(str4)) {
                        String str5 = (String) a(map, "codeMsg", "unknown");
                        String str6 = (String) a(map, "signalName", "unknown");
                        map.get("errnoMsg");
                        String str7 = (String) a(map, "stack", "unknown");
                        String str8 = map.get("jstack");
                        if (str8 != null) {
                            str7 = str7 + "java:\n" + str8;
                        }
                        Integer num = d.get("sico");
                        if (num == null || num.intValue() <= 0) {
                            str = str5;
                            str2 = str6;
                        } else {
                            str2 = str6 + oIX0oI.I0Io.f4096II0xO0 + str5 + oIX0oI.I0Io.f4095I0Io;
                            str = "KERNEL";
                        }
                        String str9 = map.get("nativeLog");
                        byte[] a2 = (str9 == null || str9.isEmpty()) ? null : ap.a(str9, "BuglyNativeLog.txt");
                        String str10 = (String) a(map, "sendingProcess", "unknown");
                        Integer num2 = d.get("spd");
                        if (num2 != null) {
                            str10 = str10 + oIX0oI.I0Io.f4096II0xO0 + num2 + oIX0oI.I0Io.f4095I0Io;
                        }
                        String str11 = str10;
                        String str12 = (String) a(map, "threadName", "unknown");
                        Integer num3 = d.get("et");
                        if (num3 != null) {
                            str12 = str12 + oIX0oI.I0Io.f4096II0xO0 + num3 + oIX0oI.I0Io.f4095I0Io;
                        }
                        String str13 = str12;
                        String str14 = (String) a(map, "processName", "unknown");
                        Integer num4 = d.get("ep");
                        if (num4 != null) {
                            str14 = str14 + oIX0oI.I0Io.f4096II0xO0 + num4 + oIX0oI.I0Io.f4095I0Io;
                        }
                        CrashDetailBean packageCrashDatas = nativeExceptionHandler.packageCrashDatas(str14, str13, (d.get("ets").intValue() * 1000) + (d.get("etms").intValue() / 1000), str2, (String) a(map, "errorAddr", "unknown"), a(str7), str, str11, (String) a(map, "tombPath", "unknown"), map.get("sysLogPath"), map.get("jniLogPath"), str4, a2, a(map), false, false);
                        if (packageCrashDatas != null) {
                            String str15 = (String) a(map, com.huawei.openalliance.ad.constant.aw.r, packageCrashDatas.m);
                            packageCrashDatas.m = str15;
                            al.c("[Native record info] userId: %s", str15);
                            String str16 = (String) a(map, "sysLog", packageCrashDatas.w);
                            packageCrashDatas.w = str16;
                            String str17 = (String) a(map, "appVersion", str16);
                            packageCrashDatas.f = str17;
                            al.c("[Native record info] appVersion: %s", str17);
                            String str18 = map.get("isAppForeground");
                            if (str18 != null) {
                                al.c("[Native record info] isAppForeground: %s", str18);
                                z = str18.equalsIgnoreCase("true");
                            } else {
                                z = false;
                            }
                            packageCrashDatas.R = z;
                            packageCrashDatas.Q = b(map);
                            packageCrashDatas.z = null;
                            packageCrashDatas.k = true;
                        }
                        return packageCrashDatas;
                    }
                    al.e("error format at version", new Object[0]);
                    return null;
                } catch (Throwable th) {
                    al.e("error format", new Object[0]);
                    th.printStackTrace();
                    return null;
                }
            }
            al.e("no intStateStr", new Object[0]);
        }
        return null;
    }
}
