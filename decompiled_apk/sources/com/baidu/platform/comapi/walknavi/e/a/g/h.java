package com.baidu.platform.comapi.walknavi.e.a.g;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import com.baidu.ar.util.SystemInfoUtil;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes8.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public static String f9741a = "";
    public static String b = "";
    public static String c = "";

    public static long a(Context context) {
        FileReader fileReader;
        Throwable th;
        BufferedReader bufferedReader;
        long j;
        BufferedReader bufferedReader2 = null;
        try {
            fileReader = new FileReader("/proc/meminfo");
            try {
                bufferedReader = new BufferedReader(fileReader, 8192);
                try {
                    String readLine = bufferedReader.readLine();
                    String[] split = readLine.split("\\s+");
                    for (String str : split) {
                        a.a(readLine + ", " + str + "\t");
                    }
                    j = Integer.parseInt(split[1]);
                    try {
                        bufferedReader.close();
                    } catch (IOException unused) {
                    }
                    try {
                        fileReader.close();
                    } catch (IOException unused2) {
                        return j / 1024;
                    }
                } catch (Exception unused3) {
                    bufferedReader2 = bufferedReader;
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException unused4) {
                        }
                    }
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (IOException unused5) {
                        }
                    }
                    j = 0;
                    return j / 1024;
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException unused6) {
                        }
                    }
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                            throw th;
                        } catch (IOException unused7) {
                            throw th;
                        }
                    }
                    throw th;
                }
            } catch (Exception unused8) {
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
            }
        } catch (Exception unused9) {
            fileReader = null;
        } catch (Throwable th4) {
            fileReader = null;
            th = th4;
            bufferedReader = null;
        }
    }

    public static long b(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo.availMem / 1048576;
    }

    public static String c() {
        BufferedReader bufferedReader;
        Throwable th;
        FileReader fileReader;
        try {
            fileReader = new FileReader("/proc/cpuinfo");
            try {
                bufferedReader = new BufferedReader(fileReader);
                try {
                    String[] split = bufferedReader.readLine().split(":\\s+", 2);
                    for (int i = 0; i < split.length; i++) {
                    }
                    String str = split[1];
                    try {
                        bufferedReader.close();
                    } catch (IOException unused) {
                    }
                    try {
                        fileReader.close();
                    } catch (IOException unused2) {
                    }
                    return str;
                } catch (Exception unused3) {
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException unused4) {
                        }
                    }
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (IOException unused5) {
                        }
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException unused6) {
                        }
                    }
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                            throw th;
                        } catch (IOException unused7) {
                            throw th;
                        }
                    }
                    throw th;
                }
            } catch (Exception unused8) {
                bufferedReader = null;
            } catch (Throwable th3) {
                bufferedReader = null;
                th = th3;
            }
        } catch (Exception unused9) {
            fileReader = null;
            bufferedReader = null;
        } catch (Throwable th4) {
            bufferedReader = null;
            th = th4;
            fileReader = null;
        }
    }

    public static int d() {
        try {
            File[] listFiles = new File("/sys/devices/system/cpu/").listFiles(new i());
            a.a("CPU Count: " + listFiles.length);
            return listFiles.length;
        } catch (Exception unused) {
            a.a("CPU Count: Failed.");
            return 1;
        }
    }

    public static String e() {
        String str;
        try {
            InputStream inputStream = new ProcessBuilder("/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_min_freq").start().getInputStream();
            byte[] bArr = new byte[24];
            String str2 = "";
            while (inputStream.read(bArr) != -1) {
                str2 = str2 + new String(bArr);
            }
            inputStream.close();
            str = String.valueOf(Integer.parseInt(str2.trim()) / 1000);
        } catch (Exception unused) {
            str = SystemInfoUtil.NA;
        }
        return str.trim();
    }

    public static String f() {
        String str;
        try {
            InputStream inputStream = new ProcessBuilder("/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq").start().getInputStream();
            byte[] bArr = new byte[24];
            String str2 = "";
            while (inputStream.read(bArr) != -1) {
                str2 = str2 + new String(bArr);
            }
            inputStream.close();
            str = String.valueOf(Integer.parseInt(str2.trim()) / 1000);
        } catch (Exception unused) {
            str = SystemInfoUtil.NA;
        }
        return String.valueOf(str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0050, code lost:
    
        if (r2 == null) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String g() {
        /*
            java.lang.String r0 = "N/A"
            r1 = 0
            java.io.FileReader r2 = new java.io.FileReader     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L39
            java.lang.String r3 = "/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq"
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L39
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L32 java.lang.Exception -> L34
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L32 java.lang.Exception -> L34
            java.lang.String r1 = r3.readLine()     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L2f
            java.lang.String r0 = r1.trim()     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L2f
            java.lang.String r1 = r0.trim()     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L2f
            int r1 = java.lang.Integer.parseInt(r1)     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L2f
            int r1 = r1 / 1000
            java.lang.String r0 = java.lang.String.valueOf(r1)     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L2f
            r3.close()     // Catch: java.io.IOException -> L28
        L28:
            r2.close()     // Catch: java.io.IOException -> L53
            goto L53
        L2c:
            r0 = move-exception
            r1 = r3
            goto L3c
        L2f:
            r1 = r3
            goto L49
        L32:
            r0 = move-exception
            goto L3c
        L34:
            goto L49
        L36:
            r0 = move-exception
            r2 = r1
            goto L3c
        L39:
            r2 = r1
            goto L49
        L3c:
            if (r1 == 0) goto L43
            r1.close()     // Catch: java.io.IOException -> L42
            goto L43
        L42:
        L43:
            if (r2 == 0) goto L48
            r2.close()     // Catch: java.io.IOException -> L48
        L48:
            throw r0
        L49:
            if (r1 == 0) goto L50
            r1.close()     // Catch: java.io.IOException -> L4f
            goto L50
        L4f:
        L50:
            if (r2 == 0) goto L53
            goto L28
        L53:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.platform.comapi.walknavi.e.a.g.h.g():java.lang.String");
    }

    public static long[] b() {
        long[] jArr = new long[2];
        if ("mounted".equals(Environment.getExternalStorageState())) {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            long blockSize = statFs.getBlockSize();
            long blockCount = statFs.getBlockCount();
            long availableBlocks = statFs.getAvailableBlocks();
            jArr[0] = (blockCount * blockSize) / 1048576;
            jArr[1] = (blockSize * availableBlocks) / 1048576;
        }
        return jArr;
    }

    public static long[] a() {
        long blockSize = new StatFs(Environment.getDataDirectory().getPath()).getBlockSize();
        return new long[]{(r1.getBlockCount() * blockSize) / 1048576, (blockSize * r1.getAvailableBlocks()) / 1048576};
    }
}
