package com.kwad.sdk.crash.utils;

import OoOoXO0.xoXoI;
import XXO0.oIX0oI;
import android.content.Context;
import android.os.Debug;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.system.Os;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.location.BDLocation;
import com.facebook.internal.AnalyticsEvents;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.kwad.sdk.crash.model.message.DiskInfo;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.crash.model.message.JavaExceptionMessage;
import com.kwad.sdk.crash.model.message.MemoryInfo;
import com.kwad.sdk.crash.model.message.NativeExceptionMessage;
import com.kwad.sdk.crash.model.message.ThreadInfo;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.AbiUtil;
import com.kwad.sdk.utils.SystemUtil;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.utils.q;
import com.kwad.sdk.utils.s;
import com.sma.smartv3.initializer.IXxxXO;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class g {
    private static final String TAG = "g";
    private static final File aJd = new File("/proc/self/fd");
    private static final File aJe = new File("/proc/self/task");

    private g() {
    }

    public static void E(File file) {
        String[] strArr;
        if (SystemUtil.eh(21)) {
            strArr = new String[]{"logcat", "-v", "threadtime", "-b", "main", "-b", BDLocation.BDLOCATION_GNSS_PROVIDER_FROM_SYSTEM, "-b", "events", "-b", IXxxXO.f20863oI0IIXIo, "-d", "-f", file.getPath()};
        } else {
            strArr = new String[]{"logcat", "-v", "threadtime", "-b", "main", "-b", BDLocation.BDLOCATION_GNSS_PROVIDER_FROM_SYSTEM, "-b", "events", "-d", "-f", file.getPath()};
        }
        try {
            d.a(strArr, 0);
        } catch (IOException e) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e);
        }
    }

    public static void F(File file) {
        if (file == null) {
            return;
        }
        try {
            q.T(file);
        } catch (Exception e) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e);
        }
    }

    public static void G(File file) {
        BufferedWriter bufferedWriter;
        try {
            q.P(file);
            BufferedWriter bufferedWriter2 = null;
            try {
                try {
                    bufferedWriter = new BufferedWriter(new FileWriter(file, true));
                } catch (Throwable th) {
                    th = th;
                }
            } catch (FileNotFoundException e) {
                e = e;
            } catch (IOException e2) {
                e = e2;
            }
            try {
                for (Map.Entry<Thread, StackTraceElement[]> entry : Thread.getAllStackTraces().entrySet()) {
                    String b = b(entry.getValue());
                    if (b.isEmpty()) {
                        b = "(no managed stack frames)\n";
                    }
                    bufferedWriter.write(entry.getKey().getName());
                    bufferedWriter.newLine();
                    bufferedWriter.write(b);
                    bufferedWriter.newLine();
                }
                b.closeQuietly(bufferedWriter);
            } catch (FileNotFoundException e3) {
                e = e3;
                bufferedWriter2 = bufferedWriter;
                com.kwad.sdk.core.e.c.printStackTraceOnly(e);
                b.closeQuietly(bufferedWriter2);
            } catch (IOException e4) {
                e = e4;
                bufferedWriter2 = bufferedWriter;
                com.kwad.sdk.core.e.c.printStackTraceOnly(e);
                b.closeQuietly(bufferedWriter2);
            } catch (Throwable th2) {
                th = th2;
                bufferedWriter2 = bufferedWriter;
                b.closeQuietly(bufferedWriter2);
                throw th;
            }
        } catch (IOException e5) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e5);
        }
    }

    public static void H(File file) {
        try {
            Debug.MemoryInfo memoryInfo = new Debug.MemoryInfo();
            Debug.getMemoryInfo(memoryInfo);
            Object field = s.getField(s.a("android.app.ActivityThread", "currentActivityThread", new Object[0]), "mAppThread");
            ParcelFileDescriptor open = ParcelFileDescriptor.open(file, 1006632960);
            FileDescriptor fileDescriptor = open;
            if (!SystemUtil.eh(26)) {
                fileDescriptor = open.getFileDescriptor();
            }
            if (SystemUtil.eh(24)) {
                Boolean bool = Boolean.FALSE;
                Boolean bool2 = Boolean.TRUE;
                s.callMethod(field, "dumpMemInfo", fileDescriptor, memoryInfo, bool, bool2, bool2, bool, bool, new String[0]);
            } else if (SystemUtil.eh(23)) {
                Boolean bool3 = Boolean.FALSE;
                Boolean bool4 = Boolean.TRUE;
                s.callMethod(field, "dumpMemInfo", fileDescriptor, memoryInfo, bool3, bool4, bool4, bool3, new String[0]);
            } else if (SystemUtil.eh(19)) {
                Boolean bool5 = Boolean.TRUE;
                s.callMethod(field, "dumpMemInfo", fileDescriptor, memoryInfo, Boolean.FALSE, bool5, bool5, new String[0]);
            }
            ParcelFileDescriptor open2 = ParcelFileDescriptor.open(file, 973078528);
            FileDescriptor fileDescriptor2 = open2;
            if (!SystemUtil.eh(26)) {
                fileDescriptor2 = open2.getFileDescriptor();
            }
            s.callMethod(field, "dumpGfxInfo", fileDescriptor2, new String[]{SystemUtil.getProcessName(com.kwad.sdk.crash.e.If().getContext())});
        } catch (Exception e) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e);
        }
    }

    private static int IQ() {
        File[] listFiles;
        File file = aJd;
        aq.checkNotNull(file);
        if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
            return listFiles.length;
        }
        return 0;
    }

    public static void a(ExceptionMessage exceptionMessage, int i) {
        com.kwad.sdk.crash.h Il = com.kwad.sdk.crash.e.If().Il();
        if (Il == null) {
            com.kwad.sdk.core.e.c.d("tag", "getter is null!");
        } else {
            exceptionMessage.mCustomMsg = Il.nB().toString();
        }
    }

    private static double aD(long j) {
        return BigDecimal.valueOf(((float) (j >> 20)) / 1024.0f).setScale(2, 4).floatValue();
    }

    private static String aj(@NonNull String str, String str2) {
        aq.gR(str);
        if (!str.endsWith(str2)) {
            return str;
        }
        return str.substring(0, str.lastIndexOf(str2));
    }

    public static void b(@Nullable Throwable th, @NonNull ExceptionMessage exceptionMessage, @Nullable Context context) {
        if (th != null) {
            b(th, exceptionMessage);
        }
        a(exceptionMessage, context);
        MemoryInfo memoryInfo = new MemoryInfo();
        a(exceptionMessage, memoryInfo, context);
        a(exceptionMessage, new DiskInfo());
        if (exceptionMessage instanceof NativeExceptionMessage) {
            a(exceptionMessage, memoryInfo);
        } else if (exceptionMessage instanceof JavaExceptionMessage) {
            a(th, exceptionMessage);
        }
    }

    private static String bK(Context context) {
        InputStream inputStream = null;
        try {
            inputStream = context.getResources().getAssets().open("apk.json");
            return new JSONObject(h.d(inputStream)).getString("task_id");
        } catch (IOException e) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e);
            return "";
        } catch (JSONException e2) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e2);
            return "";
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(th);
            return "";
        } finally {
            b.closeQuietly(inputStream);
        }
    }

    private static String bL(Context context) {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("BuildConfig Version Name: " + com.kwad.sdk.crash.e.If().getSdkVersion() + "\n");
            sb.append("PackageInfo CodePath: " + context.getPackageCodePath() + "\n");
            sb.append("PackageInfo ResPath: " + context.getPackageResourcePath() + "\n");
            sb.append("DexPath: " + bM(context) + "\n");
        } catch (Exception e) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e);
        }
        return sb.toString();
    }

    private static String bM(Context context) {
        StringBuilder sb = new StringBuilder();
        ClassLoader classLoader = context.getClassLoader();
        if (classLoader != null) {
            String obj = classLoader.toString();
            StringBuilder sb2 = new StringBuilder("ClassLoader ");
            int i = 0;
            sb2.append(0);
            sb2.append(" : ");
            sb2.append(obj);
            sb.append(sb2.toString());
            while (classLoader.getParent() != null) {
                classLoader = classLoader.getParent();
                i++;
                sb.append("\nClassLoader " + i + " : " + classLoader.toString());
            }
            if (obj != null) {
                String[] split = obj.split("\"");
                if (split.length >= 2) {
                    sb.append("\n====path: " + split[1] + ", length: " + fV(split[1]));
                }
            }
        }
        return sb.toString();
    }

    public static void d(File file, File file2) {
        BufferedReader bufferedReader;
        try {
            q.P(file);
            q.P(file2);
            BufferedWriter bufferedWriter = null;
            try {
                try {
                    bufferedReader = new BufferedReader(new FileReader(file));
                    try {
                        BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(file2, true));
                        while (true) {
                            try {
                                String readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                bufferedWriter2.write(readLine);
                                bufferedWriter2.newLine();
                            } catch (FileNotFoundException e) {
                                e = e;
                                bufferedWriter = bufferedWriter2;
                                com.kwad.sdk.core.e.c.printStackTraceOnly(e);
                                b.closeQuietly(bufferedWriter);
                                b.closeQuietly(bufferedReader);
                            } catch (IOException e2) {
                                e = e2;
                                bufferedWriter = bufferedWriter2;
                                com.kwad.sdk.core.e.c.printStackTraceOnly(e);
                                b.closeQuietly(bufferedWriter);
                                b.closeQuietly(bufferedReader);
                            } catch (Throwable th) {
                                th = th;
                                bufferedWriter = bufferedWriter2;
                                b.closeQuietly(bufferedWriter);
                                b.closeQuietly(bufferedReader);
                                throw th;
                            }
                        }
                        b.closeQuietly(bufferedWriter2);
                    } catch (FileNotFoundException e3) {
                        e = e3;
                    } catch (IOException e4) {
                        e = e4;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (FileNotFoundException e5) {
                e = e5;
                bufferedReader = null;
            } catch (IOException e6) {
                e = e6;
                bufferedReader = null;
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
            }
            b.closeQuietly(bufferedReader);
        } catch (IOException e7) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e7);
        }
    }

    private static void e(@NonNull ExceptionMessage exceptionMessage) {
        exceptionMessage.mVirtualApp = com.kwad.sdk.crash.e.If().Ii();
        exceptionMessage.mVersionCode = com.kwad.sdk.crash.e.If().getSdkVersion();
    }

    public static String fT(String str) {
        if (str.contains(FileUtils.FILE_EXTENSION_SEPARATOR)) {
            return str.substring(0, str.lastIndexOf(46));
        }
        return str;
    }

    public static String fU(String str) {
        if (str.contains(oIX0oI.I0Io.f4096II0xO0) && str.contains(oIX0oI.I0Io.f4095I0Io)) {
            return str.substring(str.lastIndexOf(40) + 1, str.lastIndexOf(41));
        }
        return str;
    }

    private static long fV(String str) {
        try {
            File file = new File(str);
            if (!file.exists()) {
                return -1L;
            }
            return file.length();
        } catch (Exception unused) {
            return -1L;
        }
    }

    private static String fW(String str) {
        HashSet hashSet = new HashSet();
        for (String str2 : str.split("\n")) {
            hashSet.add(str2);
        }
        ArrayList arrayList = new ArrayList(hashSet);
        StringBuilder sb = new StringBuilder();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            sb.append((String) it.next());
            sb.append("\n");
        }
        return sb.substring(0);
    }

    public static int getIndex(String str) {
        if (str.contains(HelpFormatter.DEFAULT_OPT_PREFIX)) {
            return Integer.parseInt(str.substring(str.lastIndexOf(45)));
        }
        return -1;
    }

    private static boolean q(@Nullable Throwable th) {
        if (th == null) {
            return false;
        }
        while (th.getCause() != null) {
            th = th.getCause();
        }
        return th instanceof OutOfMemoryError;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String r(Throwable th) {
        StringWriter stringWriter;
        String th2 = th.toString();
        PrintWriter printWriter = null;
        try {
            try {
                stringWriter = new StringWriter();
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Exception e) {
            e = e;
        }
        try {
            printWriter = new PrintWriter(stringWriter);
            f.a(th, printWriter);
            th2 = stringWriter.toString();
            b.closeQuietly(stringWriter);
        } catch (Exception e2) {
            e = e2;
            printWriter = stringWriter;
            com.kwad.sdk.core.e.c.printStackTraceOnly(e);
            b.closeQuietly(printWriter);
            return th2;
        } catch (Throwable th4) {
            th = th4;
            printWriter = stringWriter;
            b.closeQuietly(printWriter);
            throw th;
        }
        return th2;
    }

    private static void a(@NonNull ExceptionMessage exceptionMessage, @Nullable Context context) {
        if (exceptionMessage instanceof JavaExceptionMessage) {
            if (AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN.equals(exceptionMessage.mThreadName)) {
                exceptionMessage.mThreadName = Thread.currentThread().getName();
            }
            exceptionMessage.mTid = Process.myTid();
        }
        if (context != null) {
            String processName = SystemUtil.getProcessName(context);
            if (!TextUtils.isEmpty(processName)) {
                exceptionMessage.mProcessName = processName;
            }
        }
        exceptionMessage.mPid = Process.myPid();
        exceptionMessage.mCurrentTimeStamp = System.currentTimeMillis();
        exceptionMessage.mUsageTimeMills = com.kwad.sdk.crash.e.If().Im();
        exceptionMessage.mAbi = AbiUtil.isArm64(context) ? "arm64" : "arm";
        exceptionMessage.mVersionConflict = TextUtils.equals(exceptionMessage.mVersionCode, ExceptionMessage.getSdkCrashVersionName("1.0", com.kwad.sdk.crash.e.If().Ij()));
        exceptionMessage.mBuildConfigInfo = bL(context);
        e(exceptionMessage);
        b(exceptionMessage, context);
        exceptionMessage.mTaskId = bK(context);
    }

    private static void b(@NonNull Throwable th, @NonNull ExceptionMessage exceptionMessage) {
        String r = r(th);
        if (th instanceof StackOverflowError) {
            r = fW(r);
        }
        exceptionMessage.mCrashDetail = r.replaceAll("[\n\t]", xoXoI.f2670oxoX);
    }

    private static void b(@NonNull ExceptionMessage exceptionMessage, @Nullable Context context) {
        String absolutePath;
        if (context == null) {
            return;
        }
        File parentFile = context.getCacheDir().getParentFile().getParentFile().getParentFile();
        try {
            absolutePath = parentFile.getCanonicalPath();
        } catch (IOException e) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e);
            absolutePath = parentFile.getAbsolutePath();
        }
        if (!com.kwad.sdk.crash.d.aGS.matcher(absolutePath).matches() && !com.kwad.sdk.crash.d.aGT.matcher(absolutePath).matches()) {
            Matcher matcher = com.kwad.sdk.crash.d.aGU.matcher(absolutePath);
            Matcher matcher2 = com.kwad.sdk.crash.d.aGV.matcher(absolutePath);
            if (matcher.matches()) {
                exceptionMessage.mVirtualApp = matcher.group(1);
                return;
            } else if (matcher2.matches()) {
                exceptionMessage.mVirtualApp = matcher2.group(1);
                return;
            } else {
                exceptionMessage.mVirtualApp = absolutePath;
                return;
            }
        }
        exceptionMessage.mVirtualApp = context.getPackageName();
    }

    private static void a(Throwable th, ExceptionMessage exceptionMessage) {
        if (q(th) && exceptionMessage.mCrashType.equals(exceptionMessage.getTypeCommon())) {
            exceptionMessage.mCrashType = exceptionMessage.getTypeHeapOOM();
        }
    }

    private static void a(ExceptionMessage exceptionMessage, MemoryInfo memoryInfo, @Nullable Context context) {
        SystemUtil.a ND = SystemUtil.ND();
        ND.aRy = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        ND.aRu = SystemUtil.NC();
        long pss = Debug.getPss();
        ND.aRx = pss;
        memoryInfo.mTotalMB = (int) (ND.aRu / 1048576);
        memoryInfo.mJavaHeapLimitMB = (int) (com.kwad.sdk.crash.d.aGR / 1048576.0d);
        memoryInfo.mJavaHeapMB = (int) (ND.aRy / 1048576);
        memoryInfo.mVssMB = (int) (ND.aRv / 1024);
        memoryInfo.mRssMB = (int) (ND.aRw / 1024);
        memoryInfo.mPssMB = (int) (pss / 1024);
        memoryInfo.mThreadsCount = ND.mThreadsCount;
        memoryInfo.mFdCount = IQ();
        if (context != null) {
            memoryInfo.mAvailableMB = (int) (SystemUtil.dj(context) / 1048576);
        }
        exceptionMessage.mFdOverflow = "False";
        if (memoryInfo.mFdCount > 800) {
            exceptionMessage.mCrashType = exceptionMessage.getTypeFdOOM();
            exceptionMessage.mFdOverflow = "True";
            File[] listFiles = aJd.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (File file : listFiles) {
                    try {
                        memoryInfo.mFds.add(Os.readlink(file.getPath()));
                    } catch (Exception e) {
                        com.kwad.sdk.core.e.c.printStackTraceOnly(e);
                    }
                }
                Collections.sort(memoryInfo.mFds);
            }
        }
        exceptionMessage.mThreadOverflow = "False";
        if (ND.mThreadsCount > 400) {
            exceptionMessage.mCrashType = exceptionMessage.getTypeThreadOOM();
            exceptionMessage.mThreadOverflow = "True";
            a(memoryInfo);
            Collections.sort(memoryInfo.mAllThreads, new Comparator<ThreadInfo>() { // from class: com.kwad.sdk.crash.utils.g.1
                private static int a(ThreadInfo threadInfo, ThreadInfo threadInfo2) {
                    return threadInfo.mName.compareTo(threadInfo2.mName);
                }

                @Override // java.util.Comparator
                public final /* synthetic */ int compare(ThreadInfo threadInfo, ThreadInfo threadInfo2) {
                    return a(threadInfo, threadInfo2);
                }
            });
        }
        exceptionMessage.mMemoryInfo = memoryInfo.toJson().toString();
    }

    private static String b(StackTraceElement[] stackTraceElementArr) {
        return a(stackTraceElementArr, 0);
    }

    public static boolean b(com.kwad.sdk.crash.model.b bVar) {
        boolean z = (bVar.aHu & 2) != 0 && com.kwad.framework.a.a.aey.booleanValue();
        com.kwad.sdk.core.e.c.d(TAG, "isNativeOpen:" + z);
        return z;
    }

    private static void a(MemoryInfo memoryInfo) {
        File[] listFiles = aJe.listFiles();
        if (listFiles == null) {
            return;
        }
        for (File file : listFiles) {
            ThreadInfo threadInfo = new ThreadInfo();
            try {
                threadInfo.mName = h.I(new File(file, "comm"));
            } catch (IOException e) {
                com.kwad.sdk.core.e.c.printStackTraceOnly(e);
            }
            if (!TextUtils.isEmpty(threadInfo.mName)) {
                threadInfo.mName = aj(threadInfo.mName, "\n");
                memoryInfo.mAllThreads.add(threadInfo);
            }
        }
    }

    private static void a(ExceptionMessage exceptionMessage, MemoryInfo memoryInfo) {
        if (memoryInfo.mPssMB * 2 > memoryInfo.mTotalMB || (!AbiUtil.isArm64(((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext()) && memoryInfo.mVssMB > 3686.4d)) {
            exceptionMessage.mCrashType = exceptionMessage.getTypeHeapOOM();
        }
    }

    private static void a(ExceptionMessage exceptionMessage, DiskInfo diskInfo) {
        File externalStorageDirectory;
        try {
            String path = Environment.getDataDirectory().getPath();
            diskInfo.mDataTotalGB = aD(h.getTotalBytes(path));
            if (!((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ab(1024L)) {
                diskInfo.mDataAvailableGB = aD(h.getAvailableBytes(path));
            }
            if ("mounted".equals(Environment.getExternalStorageState()) && (externalStorageDirectory = Environment.getExternalStorageDirectory()) != null) {
                diskInfo.mExternalStorageTotalGB = aD(h.getTotalBytes(externalStorageDirectory.getPath()));
                if (!((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ab(1024L)) {
                    diskInfo.mExternalStorageAvailableGB = aD(h.getAvailableBytes(externalStorageDirectory.getPath()));
                }
            }
        } catch (Exception e) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e);
        }
        exceptionMessage.mDiskInfo = diskInfo.toJson().toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0010, code lost:
    
        r2 = r0.readLine();
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0014, code lost:
    
        if (r2 == null) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x001a, code lost:
    
        if (r2.isEmpty() == false) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0023, code lost:
    
        r2 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0024, code lost:
    
        r3 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0037, code lost:
    
        com.kwad.sdk.core.e.c.printStackTraceOnly(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003a, code lost:
    
        com.kwad.sdk.crash.utils.b.closeQuietly(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x003d, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0020, code lost:
    
        r2 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0021, code lost:
    
        r3 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0030, code lost:
    
        com.kwad.sdk.core.e.c.printStackTraceOnly(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0033, code lost:
    
        com.kwad.sdk.crash.utils.b.closeQuietly(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0036, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x001d, code lost:
    
        r2 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x001e, code lost:
    
        r3 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x003e, code lost:
    
        com.kwad.sdk.crash.utils.b.closeQuietly(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0041, code lost:
    
        throw r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x000e, code lost:
    
        if (r2 != null) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0026, code lost:
    
        com.kwad.sdk.crash.utils.b.closeQuietly(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0029, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(com.kwad.sdk.crash.report.e r2, java.lang.String r3, java.io.File r4) {
        /*
            com.kwad.sdk.utils.q.P(r4)     // Catch: java.io.IOException -> L42
            r3 = 0
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L2a java.io.IOException -> L2c java.io.FileNotFoundException -> L2e
            java.io.FileReader r1 = new java.io.FileReader     // Catch: java.lang.Throwable -> L2a java.io.IOException -> L2c java.io.FileNotFoundException -> L2e
            r1.<init>(r4)     // Catch: java.lang.Throwable -> L2a java.io.IOException -> L2c java.io.FileNotFoundException -> L2e
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L2a java.io.IOException -> L2c java.io.FileNotFoundException -> L2e
            if (r2 == 0) goto L26
        L10:
            java.lang.String r2 = r0.readLine()     // Catch: java.lang.Throwable -> L1d java.io.IOException -> L20 java.io.FileNotFoundException -> L23
            if (r2 == 0) goto L26
            boolean r2 = r2.isEmpty()     // Catch: java.lang.Throwable -> L1d java.io.IOException -> L20 java.io.FileNotFoundException -> L23
            if (r2 == 0) goto L10
            goto L26
        L1d:
            r2 = move-exception
            r3 = r0
            goto L3e
        L20:
            r2 = move-exception
            r3 = r0
            goto L30
        L23:
            r2 = move-exception
            r3 = r0
            goto L37
        L26:
            com.kwad.sdk.crash.utils.b.closeQuietly(r0)
            return
        L2a:
            r2 = move-exception
            goto L3e
        L2c:
            r2 = move-exception
            goto L30
        L2e:
            r2 = move-exception
            goto L37
        L30:
            com.kwad.sdk.core.e.c.printStackTraceOnly(r2)     // Catch: java.lang.Throwable -> L2a
            com.kwad.sdk.crash.utils.b.closeQuietly(r3)
            return
        L37:
            com.kwad.sdk.core.e.c.printStackTraceOnly(r2)     // Catch: java.lang.Throwable -> L2a
            com.kwad.sdk.crash.utils.b.closeQuietly(r3)
            return
        L3e:
            com.kwad.sdk.crash.utils.b.closeQuietly(r3)
            throw r2
        L42:
            r2 = move-exception
            com.kwad.sdk.core.e.c.printStackTraceOnly(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.crash.utils.g.a(com.kwad.sdk.crash.report.e, java.lang.String, java.io.File):void");
    }

    public static void a(File file, CharSequence charSequence) {
        a(file, charSequence, Charset.defaultCharset(), false);
    }

    public static void a(File file, CharSequence charSequence, boolean z) {
        a(file, charSequence, Charset.defaultCharset(), true);
    }

    private static void a(File file, CharSequence charSequence, Charset charset, boolean z) {
        a(file, charSequence == null ? null : charSequence.toString(), charset, z);
    }

    private static void a(File file, String str, Charset charset, boolean z) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = q.a(file, z);
            h.a(str, fileOutputStream, charset);
            a(fileOutputStream);
        } catch (Exception e) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e);
        } finally {
            b.closeQuietly(fileOutputStream);
        }
    }

    private static boolean a(FileOutputStream fileOutputStream) {
        if (fileOutputStream == null) {
            return true;
        }
        try {
            fileOutputStream.getFD().sync();
            return true;
        } catch (IOException e) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e);
            return false;
        }
    }

    private static String a(StackTraceElement[] stackTraceElementArr, int i) {
        if (stackTraceElementArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            sb.append("at ");
            sb.append(stackTraceElement);
            sb.append('\n');
        }
        return sb.substring(0);
    }

    public static boolean a(com.kwad.sdk.crash.model.b bVar) {
        boolean z = (bVar.aHu & 1) != 0 && com.kwad.framework.a.a.aet.booleanValue();
        com.kwad.sdk.core.e.c.d(TAG, "isAnrOpen:" + z);
        return z;
    }
}
