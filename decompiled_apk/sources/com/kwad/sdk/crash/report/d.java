package com.kwad.sdk.crash.report;

import IXI.oxoX;
import OoOoXO0.xoXoI;
import android.annotation.SuppressLint;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.jieli.watchtesttool.tool.upgrade.OTAManager;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.crash.model.message.MemoryInfo;
import com.kwad.sdk.crash.model.message.ThreadInfo;
import com.kwad.sdk.utils.m;
import com.kwad.sdk.utils.q;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public abstract class d {
    protected String mErrorMessage = "";
    protected e mUploader;

    @SuppressLint({"CheckResult"})
    private static void b(File file, @Nullable CountDownLatch countDownLatch) {
        com.kwad.sdk.crash.report.upload.d.a(file, true, countDownLatch);
    }

    private static String fP(String str) {
        if (str != null && str.contains(HelpFormatter.DEFAULT_OPT_PREFIX)) {
            return str.substring(0, str.lastIndexOf(45));
        }
        return str;
    }

    @SuppressLint({"CheckResult"})
    public final void C(File file) {
        com.kwad.sdk.core.e.c.d("AdExceptionCollector", "reportException dir =" + file);
        File[] listFiles = file.listFiles(new FileFilter() { // from class: com.kwad.sdk.crash.report.d.1
            @Override // java.io.FileFilter
            public final boolean accept(File file2) {
                return file2.getName().endsWith(".dump");
            }
        });
        if (listFiles != null) {
            for (File file2 : listFiles) {
                a(file2, (CountDownLatch) null);
            }
        }
    }

    public abstract ExceptionMessage a(@NonNull File file, File file2, File file3, String str);

    public final void a(e eVar) {
        this.mUploader = eVar;
    }

    public final void a(File file, @Nullable CountDownLatch countDownLatch) {
        File[] fileArr;
        int i = 1;
        int i2 = 0;
        String fT = com.kwad.sdk.crash.utils.g.fT(file.getPath());
        File file2 = new File(fT + oxoX.f655oxoX);
        File file3 = new File(fT + ".log");
        File file4 = new File(fT + ".blog");
        File file5 = new File(fT + ".jtrace");
        File file6 = new File(fT + ".minfo");
        ArrayList arrayList = new ArrayList();
        try {
            ExceptionMessage a2 = a(file, file2, file3, fT);
            if (a2 == null) {
                try {
                    q.delete(file.getPath());
                    q.delete(file3.getPath());
                    q.delete(file4.getPath());
                    q.delete(file2.getPath());
                    q.delete(file5.getPath());
                    q.delete(file6.getPath());
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        q.delete(((File) it.next()).getPath());
                    }
                    com.kwad.sdk.crash.utils.g.F(com.kwad.sdk.crash.handler.b.sBackupDir);
                    return;
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.c.printStackTraceOnly(th);
                    return;
                }
            }
            com.kwad.sdk.core.e.c.d("AdExceptionCollector", "message.mCrashSource=" + a2.mCrashSource);
            if (a2.mCrashSource == 2) {
                try {
                    q.delete(file.getPath());
                    q.delete(file3.getPath());
                    q.delete(file4.getPath());
                    q.delete(file2.getPath());
                    q.delete(file5.getPath());
                    q.delete(file6.getPath());
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        q.delete(((File) it2.next()).getPath());
                    }
                    com.kwad.sdk.crash.utils.g.F(com.kwad.sdk.crash.handler.b.sBackupDir);
                    return;
                } catch (Throwable th2) {
                    com.kwad.sdk.core.e.c.printStackTraceOnly(th2);
                    return;
                }
            }
            this.mUploader.a(a2, countDownLatch);
            if (this instanceof f) {
                com.kwad.sdk.core.e.c.d("AdExceptionCollector", " java crash 不上传文件");
                try {
                    q.delete(file.getPath());
                    q.delete(file3.getPath());
                    q.delete(file4.getPath());
                    q.delete(file2.getPath());
                    q.delete(file5.getPath());
                    q.delete(file6.getPath());
                    Iterator it3 = arrayList.iterator();
                    while (it3.hasNext()) {
                        q.delete(((File) it3.next()).getPath());
                    }
                    com.kwad.sdk.crash.utils.g.F(com.kwad.sdk.crash.handler.b.sBackupDir);
                    return;
                } catch (Throwable th3) {
                    com.kwad.sdk.core.e.c.printStackTraceOnly(th3);
                    return;
                }
            }
            com.kwad.sdk.crash.utils.g.E(file4);
            List<File> arrayList2 = new ArrayList<>();
            Collections.addAll(arrayList2, file3, file4);
            Iterator<File> it4 = arrayList2.iterator();
            while (it4.hasNext()) {
                if (!it4.next().exists()) {
                    it4.remove();
                }
            }
            File file7 = new File(file.getParentFile().getParent(), "custom");
            if (file7.exists()) {
                File[] listFiles = file7.listFiles();
                int length = listFiles.length;
                while (i2 < length) {
                    File file8 = listFiles[i2];
                    if (file8.isDirectory()) {
                        fileArr = listFiles;
                    } else {
                        fileArr = listFiles;
                        if (!file8.getName().startsWith(a2.mLogUUID)) {
                            if (file8.getName().startsWith(fP(a2.mLogUUID))) {
                            }
                            i = 1;
                        }
                        arrayList.add(file8);
                        i = 1;
                    }
                    i2 += i;
                    listFiles = fileArr;
                }
                arrayList2.addAll(arrayList);
            }
            a(a2, arrayList2, countDownLatch);
            try {
                q.delete(file.getPath());
                q.delete(file3.getPath());
                q.delete(file4.getPath());
                q.delete(file2.getPath());
                q.delete(file5.getPath());
                q.delete(file6.getPath());
                Iterator it5 = arrayList.iterator();
                while (it5.hasNext()) {
                    q.delete(((File) it5.next()).getPath());
                }
                com.kwad.sdk.crash.utils.g.F(com.kwad.sdk.crash.handler.b.sBackupDir);
            } catch (Throwable th4) {
                com.kwad.sdk.core.e.c.printStackTraceOnly(th4);
            }
        } catch (Throwable th5) {
            try {
                com.kwad.sdk.core.e.c.printStackTraceOnly(th5);
                com.kwad.sdk.crash.utils.g.r(th5);
                try {
                    q.delete(file.getPath());
                    q.delete(file3.getPath());
                    q.delete(file4.getPath());
                    q.delete(file2.getPath());
                    q.delete(file5.getPath());
                    q.delete(file6.getPath());
                    Iterator it6 = arrayList.iterator();
                    while (it6.hasNext()) {
                        q.delete(((File) it6.next()).getPath());
                    }
                    com.kwad.sdk.crash.utils.g.F(com.kwad.sdk.crash.handler.b.sBackupDir);
                } catch (Throwable th6) {
                    com.kwad.sdk.core.e.c.printStackTraceOnly(th6);
                }
            } catch (Throwable th7) {
                try {
                    q.delete(file.getPath());
                    q.delete(file3.getPath());
                    q.delete(file4.getPath());
                    q.delete(file2.getPath());
                    q.delete(file5.getPath());
                    q.delete(file6.getPath());
                    Iterator it7 = arrayList.iterator();
                    while (it7.hasNext()) {
                        q.delete(((File) it7.next()).getPath());
                    }
                    com.kwad.sdk.crash.utils.g.F(com.kwad.sdk.crash.handler.b.sBackupDir);
                    throw th7;
                } catch (Throwable th8) {
                    com.kwad.sdk.core.e.c.printStackTraceOnly(th8);
                    throw th7;
                }
            }
        }
    }

    public final void b(File file, ExceptionMessage exceptionMessage) {
        StringBuilder sb;
        StringBuilder sb2;
        String str;
        String str2;
        String str3;
        BufferedReader bufferedReader = null;
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
                boolean z = false;
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine != null) {
                            if (!z && readLine.contains("JNI DETECTED ERROR IN APPLICATION")) {
                                exceptionMessage.mJNIError = readLine.substring(readLine.indexOf("JNI DETECTED ERROR IN APPLICATION"));
                                z = true;
                            } else {
                                if (!readLine.contains("Waiting for a blocking GC ") && !readLine.contains("WaitForGcToComplete")) {
                                    if (readLine.contains("dvm_lock_sample")) {
                                        if (TextUtils.isEmpty(exceptionMessage.mLockInfo)) {
                                            sb2 = new StringBuilder();
                                            sb2.append(readLine);
                                            sb2.append("\n");
                                        } else {
                                            sb2 = new StringBuilder();
                                            sb2.append(exceptionMessage.mLockInfo);
                                            sb2.append(readLine);
                                            sb2.append("\n");
                                        }
                                        exceptionMessage.mLockInfo = sb2.toString();
                                    } else if (readLine.contains("Long monitor")) {
                                        if (TextUtils.isEmpty(exceptionMessage.mMonitorInfo)) {
                                            str = readLine + "\n";
                                        } else {
                                            str = exceptionMessage.mMonitorInfo + readLine + "\n";
                                        }
                                        exceptionMessage.mMonitorInfo = str;
                                    } else if (readLine.contains("Slow Looper")) {
                                        if (TextUtils.isEmpty(exceptionMessage.mSlowLooper)) {
                                            str2 = readLine + "\n";
                                        } else {
                                            str2 = exceptionMessage.mSlowLooper + readLine + "\n";
                                        }
                                        exceptionMessage.mSlowLooper = str2;
                                    } else if (readLine.contains("Slow Operation")) {
                                        if (TextUtils.isEmpty(exceptionMessage.mSlowOperation)) {
                                            str3 = readLine + "\n";
                                        } else {
                                            str3 = exceptionMessage.mSlowOperation + readLine + "\n";
                                        }
                                        exceptionMessage.mSlowOperation = str3;
                                    }
                                }
                                if (TextUtils.isEmpty(exceptionMessage.mGCInfo)) {
                                    sb = new StringBuilder();
                                    sb.append(readLine);
                                    sb.append("\n");
                                } else {
                                    sb = new StringBuilder();
                                    sb.append(exceptionMessage.mGCInfo);
                                    sb.append(readLine);
                                    sb.append("\n");
                                }
                                exceptionMessage.mGCInfo = sb.toString();
                            }
                        } else {
                            com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader2);
                            return;
                        }
                    } catch (FileNotFoundException e) {
                        e = e;
                        bufferedReader = bufferedReader2;
                        this.mErrorMessage += e + "\n";
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                        return;
                    } catch (IOException e2) {
                        e = e2;
                        bufferedReader = bufferedReader2;
                        this.mErrorMessage += e + "\n";
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                        return;
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (FileNotFoundException e3) {
            e = e3;
        } catch (IOException e4) {
            e = e4;
        }
    }

    private void a(ExceptionMessage exceptionMessage, @NonNull List<File> list, @Nullable CountDownLatch countDownLatch) {
        com.kwad.sdk.core.e.c.d("AdExceptionCollector", "compressAndUpload");
        File Ia = this.mUploader.Ia();
        if (!Ia.exists()) {
            Ia.mkdir();
        }
        File file = new File(Ia, exceptionMessage.mLogUUID + OTAManager.OTA_ZIP_SUFFIX);
        StringBuilder sb = new StringBuilder("compressAndUpload zipFile=");
        sb.append(file.getPath());
        com.kwad.sdk.core.e.c.d("AdExceptionCollector", sb.toString());
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception e) {
                com.kwad.sdk.core.e.c.printStackTraceOnly(e);
            }
        }
        m.a((File[]) list.toArray(new File[0]), file.getPath());
        if (file.length() > 0) {
            HashMap hashMap = new HashMap();
            hashMap.put("mLogUUID", exceptionMessage.mLogUUID);
            new JSONObject(hashMap);
            b(file, countDownLatch);
            return;
        }
        q.S(file);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(File file, ExceptionMessage exceptionMessage) {
        BufferedReader bufferedReader;
        String readLine;
        String str;
        try {
            MemoryInfo memoryInfo = new MemoryInfo(exceptionMessage.mMemoryInfo);
            ArrayList arrayList = new ArrayList();
            BufferedReader bufferedReader2 = null;
            BufferedReader bufferedReader3 = null;
            try {
                try {
                    bufferedReader = new BufferedReader(new FileReader(file));
                } catch (Throwable th) {
                    th = th;
                }
            } catch (IOException e) {
                e = e;
            }
            try {
                ThreadInfo threadInfo = new ThreadInfo();
                while (true) {
                    readLine = bufferedReader.readLine();
                    if (readLine == 0) {
                        break;
                    }
                    if (readLine.isEmpty()) {
                        arrayList.add(threadInfo);
                        threadInfo = new ThreadInfo();
                    } else {
                        if (!readLine.startsWith("at ") && !readLine.startsWith("(no ")) {
                            threadInfo.mName = readLine;
                        }
                        if (threadInfo.mTrace == null) {
                            str = readLine;
                        } else {
                            str = threadInfo.mTrace + readLine;
                        }
                        threadInfo.mTrace = str;
                        threadInfo.mTrace += xoXoI.f2670oxoX;
                    }
                }
                memoryInfo.mJavaThreads = arrayList;
                exceptionMessage.mMemoryInfo = memoryInfo.toJson().toString();
                com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                bufferedReader2 = readLine;
            } catch (IOException e2) {
                e = e2;
                bufferedReader3 = bufferedReader;
                com.kwad.sdk.core.e.c.printStackTraceOnly(e);
                com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader3);
                bufferedReader2 = bufferedReader3;
            } catch (Throwable th2) {
                th = th2;
                bufferedReader2 = bufferedReader;
                com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader2);
                throw th;
            }
        } catch (Exception e3) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e3);
        }
    }
}
