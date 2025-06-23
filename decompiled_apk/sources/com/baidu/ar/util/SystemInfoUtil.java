package com.baidu.ar.util;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.baidu.ar.kf;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: classes7.dex */
public class SystemInfoUtil {
    public static final String COLON = ":";
    public static final String COMMA = ",";
    private static StringBuilder Dc = null;
    private static StringBuilder Dd = null;
    public static final String LINE_END = "\r\n";
    public static final String NA = "N/A";
    public static StringBuilder sValueBuilder;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public class a implements FileFilter {
        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return Pattern.matches("cpu[0-9]", file.getName());
        }
    }

    public static boolean checkFlashFeature(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.camera.flash");
    }

    public static List<String> getAllInfos(Context context, GL10 gl10) {
        Dc = new StringBuilder();
        Dd = new StringBuilder();
        sValueBuilder = new StringBuilder();
        long[] romMemroy = getRomMemroy();
        long sDCardTotalSize = getSDCardTotalSize();
        long sDAvailableSizeByM = getSDAvailableSizeByM();
        Dc.append("基本信息：\n");
        getBaseInfo(context);
        Dc.append("\n存储：\n");
        getLogStr("可用/内存大小", getAvailMemory(context) + "/" + getRamMemory(context) + "MB");
        getLogStr("可用/ROM存储", romMemroy[1] + "/" + romMemroy[0] + "MB");
        getLogStr("可用/SDCard存储", sDAvailableSizeByM + "/" + sDCardTotalSize + "MB");
        StringBuilder sb = new StringBuilder();
        sb.append((int) (Runtime.getRuntime().maxMemory() / 1048576));
        sb.append("MB");
        getLogStr("Heap Size", sb.toString());
        Dc.append("\nCPU信息：\n");
        getLogStr("CPU名称", getCpuName());
        getLogStr("核心数", String.valueOf(getNumCores()));
        getLogStr("最低频率", getMinCpuFreq() + "MHz");
        getLogStr("最高频率", getMaxCpuFreq() + "MHz");
        getLogStr("当前频率", getCurCpuFreq() + "MHz");
        Dc.append("\nGPU信息：\n");
        getGPUInfo(gl10);
        ArrayList arrayList = new ArrayList();
        arrayList.add(Dc.toString());
        arrayList.add(Dd.toString());
        arrayList.add(sValueBuilder.toString());
        return arrayList;
    }

    public static String getAppName(Context context) {
        try {
            return context.getResources().getString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.labelRes);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static long getAvailMemory(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo.availMem / 1048576;
    }

    public static void getBaseInfo(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float f = context.getResources().getDisplayMetrics().densityDpi;
        getLogStr("手机厂商", Build.BRAND);
        getLogStr("手机型号", Build.MODEL);
        getLogStr("SDK版本", Build.VERSION.SDK);
        getLogStr("系统版本", Build.VERSION.RELEASE);
        getLogStr("屏幕分辨率", displayMetrics.widthPixels + "*" + displayMetrics.heightPixels);
        StringBuilder sb = new StringBuilder();
        sb.append(f);
        sb.append("dpi");
        getLogStr("屏幕密度", sb.toString());
    }

    public static String getCpuName() {
        BufferedReader bufferedReader;
        Throwable th;
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader2;
        try {
            try {
                inputStreamReader = new InputStreamReader(new FileInputStream("/proc/cpuinfo"), StandardCharsets.UTF_8);
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                bufferedReader2 = new BufferedReader(inputStreamReader);
                try {
                    String str = bufferedReader2.readLine().split(":\\s+", 2)[1];
                    try {
                        bufferedReader2.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        inputStreamReader.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    return str;
                } catch (Exception e3) {
                    e = e3;
                    e.printStackTrace();
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    if (inputStreamReader != null) {
                        try {
                            inputStreamReader.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
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
                        e7.printStackTrace();
                    }
                }
                if (inputStreamReader == null) {
                    throw th;
                }
                try {
                    inputStreamReader.close();
                    throw th;
                } catch (IOException e8) {
                    e8.printStackTrace();
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

    /* JADX WARN: Removed duplicated region for block: B:34:0x006f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0065 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x0039 -> B:12:0x0062). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String getCurCpuFreq() {
        /*
            java.lang.String r0 = "N/A"
            r1 = 0
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4c
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4c
            java.lang.String r4 = "/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq"
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4c
            java.nio.charset.Charset r4 = java.nio.charset.StandardCharsets.UTF_8     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4c
            r2.<init>(r3, r4)     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4c
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L44
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L44
            java.lang.String r1 = r3.readLine()     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L40
            java.lang.String r0 = r1.trim()     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L40
            java.lang.String r1 = r0.trim()     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L40
            int r1 = java.lang.Integer.parseInt(r1)     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L40
            int r1 = r1 / 1000
            java.lang.String r0 = java.lang.String.valueOf(r1)     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L40
            r3.close()     // Catch: java.io.IOException -> L30
            goto L34
        L30:
            r1 = move-exception
            r1.printStackTrace()
        L34:
            r2.close()     // Catch: java.io.IOException -> L38
            goto L62
        L38:
            r1 = move-exception
            r1.printStackTrace()
            goto L62
        L3d:
            r0 = move-exception
            r1 = r3
            goto L63
        L40:
            r1 = move-exception
            goto L50
        L42:
            r0 = move-exception
            goto L63
        L44:
            r3 = move-exception
            r5 = r3
            r3 = r1
            r1 = r5
            goto L50
        L49:
            r0 = move-exception
            r2 = r1
            goto L63
        L4c:
            r2 = move-exception
            r3 = r1
            r1 = r2
            r2 = r3
        L50:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L3d
            if (r3 == 0) goto L5d
            r3.close()     // Catch: java.io.IOException -> L59
            goto L5d
        L59:
            r1 = move-exception
            r1.printStackTrace()
        L5d:
            if (r2 == 0) goto L62
            r2.close()     // Catch: java.io.IOException -> L38
        L62:
            return r0
        L63:
            if (r1 == 0) goto L6d
            r1.close()     // Catch: java.io.IOException -> L69
            goto L6d
        L69:
            r1 = move-exception
            r1.printStackTrace()
        L6d:
            if (r2 == 0) goto L77
            r2.close()     // Catch: java.io.IOException -> L73
            goto L77
        L73:
            r1 = move-exception
            r1.printStackTrace()
        L77:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.ar.util.SystemInfoUtil.getCurCpuFreq():java.lang.String");
    }

    public static void getGPUInfo(GL10 gl10) {
        getLogStr("GL_VENDOR", gl10.glGetString(7936));
        getLogStr("GL_RENDERER", gl10.glGetString(7937));
        getLogStr("GL_VERSION", gl10.glGetString(7938));
    }

    public static void getLogStr(String str, String str2) {
        if (!TextUtils.isEmpty(Dd.toString())) {
            Dd.append(",");
        }
        Dd.append(TextUtils.isEmpty(str) ? NA : str);
        if (!TextUtils.isEmpty(sValueBuilder.toString())) {
            sValueBuilder.append(",");
        }
        sValueBuilder.append(TextUtils.isEmpty(str2) ? NA : str2);
        StringBuilder sb = Dc;
        if (TextUtils.isEmpty(str)) {
            str = NA;
        }
        sb.append(str);
        sb.append(": ");
        if (TextUtils.isEmpty(str2)) {
            str2 = NA;
        }
        sb.append(str2);
        sb.append("\n");
    }

    public static String getMaxCpuFreq() {
        StringBuilder sb;
        StringBuilder sb2 = new StringBuilder();
        try {
            InputStream inputStream = new ProcessBuilder("/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq").start().getInputStream();
            byte[] bArr = new byte[24];
            while (inputStream.read(bArr) != -1) {
                sb2.append(new String(bArr, StandardCharsets.UTF_8));
            }
            inputStream.close();
            sb = new StringBuilder(String.valueOf(Integer.parseInt(sb2.toString().trim()) / 1000));
        } catch (Exception e) {
            e.printStackTrace();
            sb = new StringBuilder(NA);
        }
        return sb.toString();
    }

    public static String getMinCpuFreq() {
        StringBuilder sb;
        StringBuilder sb2 = new StringBuilder();
        try {
            InputStream inputStream = new ProcessBuilder("/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_min_freq").start().getInputStream();
            byte[] bArr = new byte[24];
            while (inputStream.read(bArr) != -1) {
                sb2.append(new String(bArr, StandardCharsets.UTF_8));
            }
            inputStream.close();
            sb = new StringBuilder(Integer.parseInt(sb2.toString().trim()) / 1000);
        } catch (Exception unused) {
            sb = new StringBuilder(NA);
        }
        return sb.toString().trim();
    }

    public static int getNumCores() {
        try {
            File[] listFiles = new File("/sys/devices/system/cpu/").listFiles(new a());
            kf.cj("CPU Count: " + listFiles.length);
            return listFiles.length;
        } catch (Exception e) {
            kf.cj("CPU Count: Failed.");
            e.printStackTrace();
            return 1;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v14 */
    /* JADX WARN: Type inference failed for: r9v20 */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v6, types: [java.io.BufferedReader] */
    public static long getRamMemory(Context context) {
        InputStreamReader inputStreamReader;
        Throwable th;
        ?? r9;
        Exception e;
        BufferedReader bufferedReader;
        long j;
        try {
            try {
                inputStreamReader = new InputStreamReader(new FileInputStream("/proc/meminfo"), StandardCharsets.UTF_8);
            } catch (Throwable th2) {
                th = th2;
                r9 = "/proc/meminfo";
            }
            try {
                bufferedReader = new BufferedReader(inputStreamReader, 8192);
                try {
                    String readLine = bufferedReader.readLine();
                    String[] split = readLine.split("\\s+");
                    for (String str : split) {
                        kf.ck(readLine + ", " + str + "\t");
                    }
                    j = Integer.parseInt(split[1]);
                    try {
                        bufferedReader.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    try {
                        inputStreamReader.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                } catch (Exception e4) {
                    e = e4;
                    e.printStackTrace();
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                    if (inputStreamReader != null) {
                        try {
                            inputStreamReader.close();
                        } catch (IOException e6) {
                            e6.printStackTrace();
                        }
                    }
                    j = 0;
                    return j / 1024;
                }
            } catch (Exception e7) {
                e = e7;
                bufferedReader = null;
            } catch (Throwable th3) {
                th = th3;
                r9 = 0;
                if (r9 != 0) {
                    try {
                        r9.close();
                    } catch (IOException e8) {
                        e8.printStackTrace();
                    }
                }
                if (inputStreamReader == null) {
                    throw th;
                }
                try {
                    inputStreamReader.close();
                    throw th;
                } catch (IOException e9) {
                    e9.printStackTrace();
                    throw th;
                }
            }
        } catch (Exception e10) {
            inputStreamReader = null;
            e = e10;
            bufferedReader = null;
        } catch (Throwable th4) {
            inputStreamReader = null;
            th = th4;
            r9 = 0;
        }
        return j / 1024;
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
                e.printStackTrace();
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
            th.printStackTrace();
            return 0L;
        }
    }

    public static boolean isHasGyroscope(Context context) {
        return ((SensorManager) context.getSystemService("sensor")).getDefaultSensor(4) != null;
    }

    public static boolean isNexus6P() {
        String str = Build.MODEL;
        return "Nexus 6P".equals(str) || "AOSP on angler".equals(str);
    }

    public static boolean isScreenOrientationLandscape(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }
}
