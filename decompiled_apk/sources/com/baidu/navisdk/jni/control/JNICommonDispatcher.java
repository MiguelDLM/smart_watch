package com.baidu.navisdk.jni.control;

import XIXIX.OOXIXo;
import XXO0.oIX0oI;
import android.app.ActivityManager;
import android.content.Context;
import android.media.AudioManager;
import android.os.Debug;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.navisdk.comapi.commontool.BNPowerSaver;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.debug.SDKDebugFileUtil;
import com.baidu.navisdk.framework.interfaces.a;
import com.baidu.navisdk.framework.interfaces.c;
import com.baidu.navisdk.framework.interfaces.k;
import com.baidu.navisdk.module.abtest.model.j;
import com.baidu.navisdk.preset.model.d;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.a0;
import com.baidu.navisdk.util.common.l;
import com.baidu.navisdk.util.statistic.userop.b;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes7.dex */
public class JNICommonDispatcher {
    private static double aCpu;
    private static HashMap<Long, Double> hm = new HashMap<>();
    private static double o_aCpu;
    private static double o_pCpu;
    private static double pCpu;
    private static double p_jif;

    public static boolean BNJniAddABTestStatistics(int i, String str, String str2) {
        a a2 = c.p().a();
        if (a2 != null) {
            ((j) a2.g(i)).d(str, str2);
            return true;
        }
        return false;
    }

    public static boolean BNJniAddUserOp(String str, String str2, String str3, String str4) {
        try {
            b r = b.r();
            if (TextUtils.isEmpty(str2)) {
                str2 = null;
            }
            if (TextUtils.isEmpty(str3)) {
                str3 = null;
            }
            if (TextUtils.isEmpty(str4)) {
                str4 = null;
            }
            r.a(str, str2, str3, str4);
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    public static boolean BNJniPushABTestStatistics(int i) {
        a a2 = c.p().a();
        if (a2 != null) {
            a2.j(i);
            return true;
        }
        return false;
    }

    public static String GetNaviBatteryMonitorInfo() {
        String str;
        String str2;
        if (LogUtil.LOGGABLE) {
            LogUtil.e("Common", "GetNaviBatteryMonitorInfo");
        }
        Context a2 = com.baidu.navisdk.framework.a.c().a();
        if (a2 == null) {
            str = "";
        } else {
            String str3 = ((("" + String.valueOf(BNPowerSaver.getInstance().a())) + ",") + String.valueOf(((AudioManager) a2.getSystemService(MimeTypes.BASE_TYPE_AUDIO)).getStreamVolume(3))) + ",";
            int a3 = l.a(a2);
            if (l.b(a2) == 1) {
                a3 = -1;
            }
            String str4 = (((str3 + String.valueOf(a3)) + ",") + String.valueOf(EnvironmentUtil.getNetStatus(a2))) + ",";
            int myPid = Process.myPid();
            long[] pss = getPSS(a2, myPid);
            if (pss.length >= 3) {
                str2 = (str4 + String.valueOf(pss[2] / 1024)) + ",";
            } else {
                str2 = str4 + "0,";
            }
            str = (str2 + "0,") + getProcessCpu(myPid);
        }
        if (str.length() >= 4096) {
            return "";
        }
        return str;
    }

    public static void closeReader(BufferedReader bufferedReader) {
        if (bufferedReader != null) {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static double div(double d, double d2, int i) {
        try {
            return new BigDecimal(Double.toString(d)).divide(new BigDecimal(Double.toString(d2)), i, 1).doubleValue();
        } catch (Exception e) {
            e.printStackTrace();
            return OOXIXo.f3760XO;
        }
    }

    public static String getAppMonitorInfo() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("Common", "getAppMonitorInfo");
        }
        if (com.baidu.navisdk.framework.a.c().a() == null) {
            return "";
        }
        int myPid = Process.myPid();
        String processCpuUsage = getProcessCpuUsage(myPid);
        String str = "" + processCpuUsage;
        return (str + String.valueOf(getPSS(com.baidu.navisdk.framework.a.c().a(), myPid)[2])) + ",0,0,0,0";
    }

    public static ArrayList<String> getCpuAction() {
        BufferedReader bufferedReader;
        if (LogUtil.LOGGABLE) {
            LogUtil.e("Common", "getCpuAction");
        }
        ArrayList<String> arrayList = new ArrayList<>();
        File file = new File("/proc/stat");
        if (file.exists() && file.canRead()) {
            BufferedReader bufferedReader2 = null;
            try {
                try {
                    bufferedReader = new BufferedReader(new FileReader(file), 8192);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (FileNotFoundException e) {
                e = e;
            } catch (IOException e2) {
                e = e2;
            }
            try {
                String readLine = bufferedReader.readLine();
                if (readLine != null && !readLine.isEmpty() && readLine.indexOf(IAdInterListener.AdProdType.PRODUCT_CPU) != -1) {
                    String[] split = readLine.trim().split(" ");
                    for (int i = 0; i < split.length; i++) {
                        if (split[i].indexOf(IAdInterListener.AdProdType.PRODUCT_CPU) == -1 && split[i].indexOf(" ") == -1 && !split[i].isEmpty()) {
                            arrayList.add(split[i]);
                        }
                    }
                }
            } catch (FileNotFoundException e3) {
                e = e3;
                bufferedReader2 = bufferedReader;
                e.printStackTrace();
                bufferedReader = bufferedReader2;
                closeReader(bufferedReader);
                return arrayList;
            } catch (IOException e4) {
                e = e4;
                bufferedReader2 = bufferedReader;
                e.printStackTrace();
                bufferedReader = bufferedReader2;
                closeReader(bufferedReader);
                return arrayList;
            } catch (Throwable th2) {
                th = th2;
                bufferedReader2 = bufferedReader;
                closeReader(bufferedReader2);
                throw th;
            }
            closeReader(bufferedReader);
            return arrayList;
        }
        return arrayList;
    }

    public static int[] getNavigationHwContextState() {
        return com.baidu.navisdk.preset.viaduct.a.a();
    }

    public static long[] getPSS(Context context, int i) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("Common", "getPSS");
        }
        long[] jArr = new long[4];
        for (int i2 = 0; i2 < 4; i2++) {
            jArr[i2] = 0;
        }
        if (i >= 0) {
            Debug.MemoryInfo[] processMemoryInfo = ((ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY)).getProcessMemoryInfo(new int[]{i});
            if (processMemoryInfo != null && processMemoryInfo.length >= 1) {
                Debug.MemoryInfo memoryInfo = processMemoryInfo[0];
                jArr[0] = memoryInfo.nativePss;
                jArr[1] = memoryInfo.dalvikPss;
                jArr[2] = memoryInfo.getTotalPss();
                jArr[3] = memoryInfo.getTotalSharedDirty();
            }
        }
        return jArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00fb A[LOOP:3: B:50:0x00f5->B:52:0x00fb, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String getProcessCpu(int r18) {
        /*
            Method dump skipped, instructions count: 350
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.jni.control.JNICommonDispatcher.getProcessCpu(int):java.lang.String");
    }

    public static String[] getProcessCpuAction(int i) {
        BufferedReader bufferedReader;
        IOException e;
        if (LogUtil.LOGGABLE) {
            LogUtil.e("Common", "getProcessCpuAction");
        }
        String str = "/proc/" + i + "/stat";
        String[] strArr = new String[3];
        for (int i2 = 0; i2 < 3; i2++) {
            strArr[i2] = "0";
        }
        File file = new File(str);
        if (file.exists() && file.canRead()) {
            BufferedReader bufferedReader2 = null;
            try {
                bufferedReader = new BufferedReader(new FileReader(file), 8192);
                try {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null && !readLine.isEmpty()) {
                            String[] split = readLine.trim().split(" ");
                            if (split.length >= 15) {
                                strArr[0] = split[1];
                                strArr[1] = split[13];
                                strArr[2] = split[14];
                            }
                        }
                    } catch (IOException e2) {
                        e = e2;
                        e.printStackTrace();
                        closeReader(bufferedReader);
                        return strArr;
                    }
                } catch (Throwable th) {
                    BufferedReader bufferedReader3 = bufferedReader;
                    th = th;
                    bufferedReader2 = bufferedReader3;
                    closeReader(bufferedReader2);
                    throw th;
                }
            } catch (IOException e3) {
                bufferedReader = null;
                e = e3;
            } catch (Throwable th2) {
                th = th2;
                closeReader(bufferedReader2);
                throw th;
            }
            closeReader(bufferedReader);
            return strArr;
        }
        return strArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0127 A[LOOP:2: B:49:0x0121->B:51:0x0127, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String getProcessCpuUsage(int r23) {
        /*
            Method dump skipped, instructions count: 385
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.jni.control.JNICommonDispatcher.getProcessCpuUsage(int):java.lang.String");
    }

    public static void getProcessThreadAction(ArrayList<ThreadData> arrayList, int i) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("Common", "getProcessThreadAction");
        }
        String str = "/proc/" + i + "/task";
        File file = new File(str);
        if (file.exists() && file.canRead()) {
            for (File file2 : file.listFiles()) {
                if (file2.isDirectory()) {
                    String name = file2.getName();
                    BufferedReader bufferedReader = null;
                    try {
                        BufferedReader bufferedReader2 = new BufferedReader(new FileReader(new File(str + "/" + name + "/stat")), 512);
                        try {
                            String readLine = bufferedReader2.readLine();
                            if (readLine != null && !readLine.isEmpty()) {
                                String trim = readLine.trim();
                                ThreadData threadData = new ThreadData();
                                threadData.threadId = Long.parseLong(name);
                                int indexOf = trim.indexOf(oIX0oI.I0Io.f4096II0xO0);
                                int indexOf2 = trim.indexOf(oIX0oI.I0Io.f4095I0Io);
                                if (indexOf != -1 && indexOf2 != -1) {
                                    String substring = trim.substring(indexOf + 1, indexOf2);
                                    threadData.threadName = substring;
                                    threadData.threadName = substring.replace('#', TokenParser.SP);
                                    String[] split = trim.split(" ");
                                    if (split.length >= 15) {
                                        threadData.tcpu = Double.valueOf(split[13]).doubleValue() + Double.valueOf(split[14]).doubleValue();
                                    } else {
                                        threadData.tcpu = OOXIXo.f3760XO;
                                    }
                                    arrayList.add(threadData);
                                }
                            }
                        } catch (IOException unused) {
                        } catch (Throwable th) {
                            th = th;
                            bufferedReader = bufferedReader2;
                            closeReader(bufferedReader);
                            throw th;
                        }
                        bufferedReader = bufferedReader2;
                    } catch (IOException unused2) {
                    } catch (Throwable th2) {
                        th = th2;
                    }
                    closeReader(bufferedReader);
                }
            }
        }
    }

    public static boolean sendCurrentTrafficState(long j, int i, int i2) {
        String g = a0.g();
        if (LogUtil.LOGGABLE) {
            LogUtil.e("hwloc", "车道状态 timestamp:" + j + " curlane:" + i + " totallane:" + i2);
        }
        com.baidu.navisdk.framework.message.a.a().a(new com.baidu.navisdk.preset.model.b(g, j, i, i2));
        return true;
    }

    public static boolean sendMapMatchingResult(double d, double d2, double d3, double d4, float f, int i, int i2, boolean z, boolean z2, long j, boolean z3) {
        com.baidu.navisdk.preset.model.a aVar = new com.baidu.navisdk.preset.model.a(j, Math.round(d * 100000.0d) / 100000.0d, Math.round(d2 * 100000.0d) / 100000.0d, Math.round(d3 * 100000.0d) / 100000.0d, Math.round(d4 * 100000.0d) / 100000.0d, f, i, i2, z, z2, z3);
        if (BNSettingManager.isShowJavaLog()) {
            SDKDebugFileUtil.get(SDKDebugFileUtil.HUAWEI_MM_LOCATION).asyncAdd(aVar.toString());
        }
        if (!com.baidu.navisdk.util.logic.b.b().a()) {
            return true;
        }
        com.baidu.navisdk.framework.message.a.a().d(aVar);
        return true;
    }

    public static boolean sendMapMatchingResultForOS(long j, float f, float f2, double d, double d2, double d3, double d4, float f3) {
        k k = c.p().k();
        if (k != null) {
            k.a(j, f, f2, d, d2, d3, d4, f3);
            return true;
        }
        return true;
    }

    public static boolean sendNavigationDelayMsg(int i, long j, int i2) {
        String g = a0.g();
        String valueOf = String.valueOf(j);
        if (LogUtil.LOGGABLE) {
            LogUtil.e("huawei", "引擎调用上层接口 - sendNavigationDelayMsg，type:" + i + ", timestamp: " + j + ", distanceToCrossroad: " + i2 + ", packageName: " + g);
        }
        com.baidu.navisdk.framework.message.a.a().a(new com.baidu.navisdk.preset.model.c(g, i, valueOf, i2));
        return true;
    }

    public static boolean sendTurnState(long j, int i) {
        String g = a0.g();
        if (LogUtil.LOGGABLE) {
            LogUtil.e("hwloc", "车道转弯状态 timestamp:" + j + " turn:" + i);
        }
        com.baidu.navisdk.framework.message.a.a().a(new d(g, j, i));
        return true;
    }
}
