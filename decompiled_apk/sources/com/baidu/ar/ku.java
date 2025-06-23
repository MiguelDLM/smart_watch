package com.baidu.ar;

import android.app.ActivityManager;
import android.content.Context;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.util.Log;
import com.baidu.ar.util.SystemInfoUtil;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.regex.Pattern;

/* loaded from: classes7.dex */
public class ku {
    public static String Dw = "";
    public static String name = "";
    public static String value = "";

    /* loaded from: classes7.dex */
    class a implements FileFilter {
        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return Pattern.matches("cpu[0-9]", file.getName());
        }
    }

    public static long getAvailMemory(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo.availMem / 1048576;
    }

    public static String getCpuName() {
        BufferedReader bufferedReader;
        Throwable th;
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader2;
        try {
            try {
                inputStreamReader = new InputStreamReader(new FileInputStream("/proc/cpuinfo"), Charset.forName("utf-8"));
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                bufferedReader2 = new BufferedReader(inputStreamReader);
                try {
                    String[] split = bufferedReader2.readLine().split(":\\s+", 2);
                    for (int i = 0; i < split.length; i++) {
                    }
                    String str = split[1];
                    try {
                        bufferedReader2.close();
                    } catch (IOException e) {
                        e.printStackTrace(System.out);
                    }
                    try {
                        inputStreamReader.close();
                    } catch (IOException e2) {
                        e2.printStackTrace(System.out);
                    }
                    return str;
                } catch (Exception e3) {
                    e = e3;
                    e.printStackTrace(System.out);
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e4) {
                            e4.printStackTrace(System.out);
                        }
                    }
                    if (inputStreamReader != null) {
                        try {
                            inputStreamReader.close();
                        } catch (IOException e5) {
                            e5.printStackTrace(System.out);
                        }
                    }
                    return null;
                }
            } catch (Exception e6) {
                e = e6;
                bufferedReader2 = null;
            } catch (Throwable th3) {
                bufferedReader = null;
                th = th3;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e7) {
                        e7.printStackTrace(System.out);
                    }
                }
                if (inputStreamReader == null) {
                    throw th;
                }
                try {
                    inputStreamReader.close();
                    throw th;
                } catch (IOException e8) {
                    e8.printStackTrace(System.out);
                    throw th;
                }
            }
        } catch (Exception e9) {
            e = e9;
            inputStreamReader = null;
            bufferedReader2 = null;
        } catch (Throwable th4) {
            bufferedReader = null;
            th = th4;
            inputStreamReader = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Throwable, java.io.IOException] */
    /* JADX WARN: Type inference failed for: r1v15, types: [java.lang.Throwable, java.io.IOException] */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.lang.Throwable, java.io.IOException] */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.io.PrintStream] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.io.Reader, java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r3v12, types: [java.io.PrintStream] */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.io.PrintStream] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x0040 -> B:13:0x006f). Please report as a decompilation issue!!! */
    public static String getCurCpuFreq() {
        ?? r2;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        Exception e;
        String str = SystemInfoUtil.NA;
        BufferedReader bufferedReader3 = null;
        try {
            try {
                try {
                    r2 = new InputStreamReader(new FileInputStream("/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq"), Charset.forName("utf-8"));
                } catch (Throwable th) {
                    th = th;
                    bufferedReader3 = bufferedReader;
                }
            } catch (Exception e2) {
                bufferedReader2 = null;
                e = e2;
                r2 = 0;
            } catch (Throwable th2) {
                th = th2;
                r2 = 0;
            }
            try {
                bufferedReader2 = new BufferedReader(r2);
                try {
                    str = String.valueOf(Integer.parseInt(bufferedReader2.readLine().trim().trim()) / 1000);
                    try {
                        bufferedReader2.close();
                        bufferedReader = bufferedReader2;
                    } catch (IOException e3) {
                        ?? r3 = System.out;
                        e3.printStackTrace(r3);
                        bufferedReader = r3;
                    }
                    r2.close();
                } catch (Exception e4) {
                    e = e4;
                    e.printStackTrace(System.out);
                    bufferedReader = bufferedReader2;
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                            bufferedReader = bufferedReader2;
                        } catch (IOException e5) {
                            ?? r32 = System.out;
                            e5.printStackTrace(r32);
                            bufferedReader = r32;
                        }
                    }
                    if (r2 != 0) {
                        r2.close();
                    }
                    return str;
                }
            } catch (Exception e6) {
                bufferedReader2 = null;
                e = e6;
            } catch (Throwable th3) {
                th = th3;
                if (bufferedReader3 != null) {
                    try {
                        bufferedReader3.close();
                    } catch (IOException e7) {
                        e7.printStackTrace(System.out);
                    }
                }
                if (r2 == 0) {
                    throw th;
                }
                try {
                    r2.close();
                    throw th;
                } catch (IOException e8) {
                    e8.printStackTrace(System.out);
                    throw th;
                }
            }
        } catch (IOException e9) {
            r2 = System.out;
            e9.printStackTrace(r2);
        }
        return str;
    }

    public static String getMaxCpuFreq() {
        String str;
        try {
            InputStream inputStream = new ProcessBuilder("/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq").start().getInputStream();
            byte[] bArr = new byte[24];
            String str2 = "";
            while (inputStream.read(bArr) != -1) {
                str2 = str2 + new String(bArr, "utf-8");
            }
            inputStream.close();
            str = String.valueOf(Integer.parseInt(str2.trim()) / 1000);
        } catch (Exception e) {
            e.printStackTrace(System.out);
            str = SystemInfoUtil.NA;
        }
        return String.valueOf(str);
    }

    public static String getMinCpuFreq() {
        String str;
        try {
            InputStream inputStream = new ProcessBuilder("/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_min_freq").start().getInputStream();
            byte[] bArr = new byte[24];
            String str2 = "";
            while (inputStream.read(bArr) != -1) {
                str2 = str2 + new String(bArr, "utf-8");
            }
            inputStream.close();
            str = String.valueOf(Integer.parseInt(str2.trim()) / 1000);
        } catch (Exception unused) {
            str = SystemInfoUtil.NA;
        }
        return str.trim();
    }

    public static int getNumCores() {
        try {
            File[] listFiles = new File("/sys/devices/system/cpu/").listFiles(new a());
            Log.d("bdar", "CPU Count: " + listFiles.length);
            return listFiles.length;
        } catch (Exception e) {
            Log.d("bdar", "CPU Count: Failed.");
            e.printStackTrace(System.out);
            return 1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00b2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static long getRamMemory(android.content.Context r10) {
        /*
            java.lang.String r10 = "/proc/meminfo"
            r0 = 0
            java.io.InputStreamReader r1 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L7d
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L7d
            r2.<init>(r10)     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L7d
            java.lang.String r10 = "utf-8"
            java.nio.charset.Charset r10 = java.nio.charset.Charset.forName(r10)     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L7d
            r1.<init>(r2, r10)     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L7d
            java.io.BufferedReader r10 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L73
            r2 = 8192(0x2000, float:1.148E-41)
            r10.<init>(r1, r2)     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L73
            java.lang.String r0 = r10.readLine()     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L4f
            java.lang.String r2 = "\\s+"
            java.lang.String[] r2 = r0.split(r2)     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L4f
            int r3 = r2.length     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L4f
            r4 = 0
        L27:
            if (r4 >= r3) goto L51
            r5 = r2[r4]     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L4f
            java.lang.String r6 = "bdar:"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L4f
            r7.<init>()     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L4f
            r7.append(r0)     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L4f
            java.lang.String r8 = ", "
            r7.append(r8)     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L4f
            r7.append(r5)     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L4f
            java.lang.String r5 = "\t"
            r7.append(r5)     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L4f
            java.lang.String r5 = r7.toString()     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L4f
            android.util.Log.i(r6, r5)     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L4f
            int r4 = r4 + 1
            goto L27
        L4c:
            r0 = move-exception
            goto La4
        L4f:
            r0 = move-exception
            goto L81
        L51:
            r0 = 1
            r0 = r2[r0]     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L4f
            int r0 = java.lang.Integer.parseInt(r0)     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L4f
            long r2 = (long) r0
            r10.close()     // Catch: java.io.IOException -> L5d
            goto L63
        L5d:
            r10 = move-exception
            java.io.PrintStream r0 = java.lang.System.out
            r10.printStackTrace(r0)
        L63:
            r1.close()     // Catch: java.io.IOException -> L67
            goto La0
        L67:
            r10 = move-exception
            java.io.PrintStream r0 = java.lang.System.out
            r10.printStackTrace(r0)
            goto La0
        L6e:
            r10 = move-exception
            r9 = r0
            r0 = r10
            r10 = r9
            goto La4
        L73:
            r10 = move-exception
            r9 = r0
            r0 = r10
            r10 = r9
            goto L81
        L78:
            r10 = move-exception
            r1 = r0
            r0 = r10
            r10 = r1
            goto La4
        L7d:
            r10 = move-exception
            r1 = r0
            r0 = r10
            r10 = r1
        L81:
            java.io.PrintStream r2 = java.lang.System.out     // Catch: java.lang.Throwable -> L4c
            r0.printStackTrace(r2)     // Catch: java.lang.Throwable -> L4c
            if (r10 == 0) goto L92
            r10.close()     // Catch: java.io.IOException -> L8c
            goto L92
        L8c:
            r10 = move-exception
            java.io.PrintStream r0 = java.lang.System.out
            r10.printStackTrace(r0)
        L92:
            if (r1 == 0) goto L9e
            r1.close()     // Catch: java.io.IOException -> L98
            goto L9e
        L98:
            r10 = move-exception
            java.io.PrintStream r0 = java.lang.System.out
            r10.printStackTrace(r0)
        L9e:
            r2 = 0
        La0:
            r0 = 1024(0x400, double:5.06E-321)
            long r2 = r2 / r0
            return r2
        La4:
            if (r10 == 0) goto Lb0
            r10.close()     // Catch: java.io.IOException -> Laa
            goto Lb0
        Laa:
            r10 = move-exception
            java.io.PrintStream r2 = java.lang.System.out
            r10.printStackTrace(r2)
        Lb0:
            if (r1 == 0) goto Lbc
            r1.close()     // Catch: java.io.IOException -> Lb6
            goto Lbc
        Lb6:
            r10 = move-exception
            java.io.PrintStream r1 = java.lang.System.out
            r10.printStackTrace(r1)
        Lbc:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.ar.ku.getRamMemory(android.content.Context):long");
    }

    public static long[] getRomMemroy() {
        long blockSize = new StatFs(Environment.getDataDirectory().getPath()).getBlockSize();
        return new long[]{(r1.getBlockCount() * blockSize) / 1048576, (blockSize * r1.getAvailableBlocks()) / 1048576};
    }

    public static long getSDAvailableSizeByM() {
        if ("mounted".equals(Environment.getExternalStorageState())) {
            try {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                return (statFs.getBlockSize() * statFs.getAvailableBlocks()) / 1048576;
            } catch (Exception e) {
                e.printStackTrace(System.out);
            }
        }
        return 0L;
    }

    public static long getSDCardTotalSize() {
        try {
            if (!"mounted".equals(Environment.getExternalStorageState())) {
                return 0L;
            }
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return (statFs.getBlockSize() * statFs.getBlockCount()) / 1048576;
        } catch (Throwable th) {
            th.printStackTrace(System.out);
            return 0L;
        }
    }

    public static boolean hj() {
        return Build.VERSION.SDK_INT >= 26;
    }

    public static boolean hk() {
        return "Nexus 5X".equals(Build.MODEL);
    }

    public static boolean isHasGyroscope(Context context) {
        return ((SensorManager) context.getSystemService("sensor")).getDefaultSensor(4) != null;
    }

    public static boolean isNexus6P() {
        String str = Build.MODEL;
        return "Nexus 6P".equals(str) || "AOSP on angler".equals(str);
    }

    public static boolean x(Context context) {
        String str = Build.MODEL;
        return "RLIAN00".equalsIgnoreCase(str) || "RLIN29".equalsIgnoreCase(str) || "TAH-AN00".equalsIgnoreCase(str) || "TAHN29".equalsIgnoreCase(str) || "TAH-AN00m".equalsIgnoreCase(str) || "RLI-N29".equalsIgnoreCase(str) || "TAH-N29".equalsIgnoreCase(str) || "RHA-AN00m".equalsIgnoreCase(str);
    }
}
