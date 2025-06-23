package com.alibaba.sdk.android.oss.common;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.os.StatFs;
import android.provider.MediaStore;
import com.alibaba.sdk.android.oss.ClientConfiguration;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.google.android.exoplayer2.upstream.cache.CacheDataSink;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OSSLogToFileUtils {
    private static final String LOG_DIR_NAME = "OSSLog";
    /* access modifiers changed from: private */
    public static long LOG_MAX_SIZE = CacheDataSink.DEFAULT_FRAGMENT_SIZE;
    /* access modifiers changed from: private */
    public static OSSLogToFileUtils instance;
    private static LogThreadPoolManager logService = LogThreadPoolManager.newInstance();
    private static Context sContext;
    /* access modifiers changed from: private */
    public static File sLogFile;
    /* access modifiers changed from: private */
    public static SimpleDateFormat sLogSDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static Uri sLogUri;
    private boolean useSdCard = true;

    public static class WriteCall implements Runnable {
        private Object mStr;

        public WriteCall(Object obj) {
            this.mStr = obj;
        }

        private PrintWriter printEx(PrintWriter printWriter) {
            printWriter.println("crash_time：" + OSSLogToFileUtils.sLogSDF.format(new Date()));
            ((Throwable) this.mStr).printStackTrace(printWriter);
            return printWriter;
        }

        public void run() {
            if (OSSLogToFileUtils.sLogFile != null) {
                OSSLogToFileUtils.getInstance();
                if (OSSLogToFileUtils.getLogFileSize(OSSLogToFileUtils.sLogFile) > OSSLogToFileUtils.LOG_MAX_SIZE) {
                    OSSLogToFileUtils.getInstance().resetLogFile();
                }
                try {
                    PrintWriter printWriter = new PrintWriter(new FileWriter(OSSLogToFileUtils.sLogFile, true), true);
                    if (this.mStr instanceof Throwable) {
                        printEx(printWriter);
                    } else {
                        printWriter.println(OSSLogToFileUtils.getInstance().getFunctionInfo((StackTraceElement[]) null) + " - " + this.mStr.toString());
                    }
                    printWriter.println("------>end of log");
                    printWriter.println();
                    printWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private OSSLogToFileUtils() {
    }

    /* access modifiers changed from: private */
    public String getFunctionInfo(StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr != null) {
            return null;
        }
        return "[" + sLogSDF.format(new Date()) + "]";
    }

    public static OSSLogToFileUtils getInstance() {
        if (instance == null) {
            synchronized (OSSLogToFileUtils.class) {
                try {
                    if (instance == null) {
                        instance = new OSSLogToFileUtils();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return instance;
    }

    public static long getLocalLogFileSize() {
        return getLogFileSize(sLogFile);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0083  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.io.File getLogFile() {
        /*
            r11 = this;
            r0 = 0
            r1 = 0
            boolean r2 = r11.useSdCard     // Catch:{ Exception -> 0x004d }
            java.lang.String r3 = "OSSLog"
            r4 = 1
            r5 = 1024(0x400, double:5.06E-321)
            if (r2 == 0) goto L_0x004f
            java.lang.String r2 = android.os.Environment.getExternalStorageState()     // Catch:{ Exception -> 0x004d }
            java.lang.String r7 = "mounted"
            boolean r2 = r2.equals(r7)     // Catch:{ Exception -> 0x004d }
            if (r2 == 0) goto L_0x004f
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x004d }
            r7 = 29
            if (r2 >= r7) goto L_0x004f
            long r7 = r11.readSDCardSpace()     // Catch:{ Exception -> 0x004d }
            long r9 = LOG_MAX_SIZE     // Catch:{ Exception -> 0x004d }
            long r9 = r9 / r5
            int r2 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r2 <= 0) goto L_0x0029
            goto L_0x002a
        L_0x0029:
            r4 = 0
        L_0x002a:
            java.io.File r2 = new java.io.File     // Catch:{ Exception -> 0x004d }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x004d }
            r5.<init>()     // Catch:{ Exception -> 0x004d }
            java.io.File r6 = android.os.Environment.getExternalStorageDirectory()     // Catch:{ Exception -> 0x004d }
            java.lang.String r6 = r6.getPath()     // Catch:{ Exception -> 0x004d }
            r5.append(r6)     // Catch:{ Exception -> 0x004d }
            java.lang.String r6 = java.io.File.separator     // Catch:{ Exception -> 0x004d }
            r5.append(r6)     // Catch:{ Exception -> 0x004d }
            r5.append(r3)     // Catch:{ Exception -> 0x004d }
            java.lang.String r3 = r5.toString()     // Catch:{ Exception -> 0x004d }
            r2.<init>(r3)     // Catch:{ Exception -> 0x004d }
        L_0x004b:
            r0 = r4
            goto L_0x0081
        L_0x004d:
            goto L_0x0080
        L_0x004f:
            long r7 = r11.readSystemSpace()     // Catch:{ Exception -> 0x004d }
            long r9 = LOG_MAX_SIZE     // Catch:{ Exception -> 0x004d }
            long r9 = r9 / r5
            int r2 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r2 <= 0) goto L_0x005b
            goto L_0x005c
        L_0x005b:
            r4 = 0
        L_0x005c:
            java.io.File r2 = new java.io.File     // Catch:{ Exception -> 0x004d }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x004d }
            r5.<init>()     // Catch:{ Exception -> 0x004d }
            android.content.Context r6 = sContext     // Catch:{ Exception -> 0x004d }
            java.io.File r6 = r6.getFilesDir()     // Catch:{ Exception -> 0x004d }
            java.lang.String r6 = r6.getPath()     // Catch:{ Exception -> 0x004d }
            r5.append(r6)     // Catch:{ Exception -> 0x004d }
            java.lang.String r6 = java.io.File.separator     // Catch:{ Exception -> 0x004d }
            r5.append(r6)     // Catch:{ Exception -> 0x004d }
            r5.append(r3)     // Catch:{ Exception -> 0x004d }
            java.lang.String r3 = r5.toString()     // Catch:{ Exception -> 0x004d }
            r2.<init>(r3)     // Catch:{ Exception -> 0x004d }
            goto L_0x004b
        L_0x0080:
            r2 = r1
        L_0x0081:
            if (r0 == 0) goto L_0x00af
            boolean r0 = r2.exists()
            if (r0 != 0) goto L_0x008c
            r2.mkdirs()
        L_0x008c:
            java.io.File r1 = new java.io.File
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = r2.getPath()
            r0.append(r2)
            java.lang.String r2 = "/logs.csv"
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            boolean r0 = r1.exists()
            if (r0 != 0) goto L_0x00af
            r11.createNewFile(r1)
        L_0x00af:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.oss.common.OSSLogToFileUtils.getLogFile():java.io.File");
    }

    public static long getLogFileSize(File file) {
        if (file == null || !file.exists()) {
            return 0;
        }
        return file.length();
    }

    private Uri getLogUri() {
        ContentResolver contentResolver = sContext.getContentResolver();
        Uri queryLogUri = queryLogUri();
        if (queryLogUri == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("_display_name", "logs.csv");
            contentValues.put("mime_type", "file/csv");
            contentValues.put("title", "logs.csv");
            contentValues.put("relative_path", "Documents/OSSLog");
            queryLogUri = contentResolver.insert(MediaStore.Files.getContentUri("external"), contentValues);
            try {
                contentResolver.openFileDescriptor(queryLogUri, IAdInterListener.AdReqParam.WIDTH);
            } catch (Exception unused) {
                return null;
            }
        }
        return queryLogUri;
    }

    public static void init(Context context, ClientConfiguration clientConfiguration) {
        File file;
        OSSLog.logDebug("init ...", false);
        if (clientConfiguration != null) {
            LOG_MAX_SIZE = clientConfiguration.getMaxLogSize();
        }
        if (sContext == null || instance == null || (file = sLogFile) == null || !file.exists()) {
            sContext = context.getApplicationContext();
            instance = getInstance();
            logService.addExecuteTask(new Runnable() {
                public void run() {
                    File unused = OSSLogToFileUtils.sLogFile = OSSLogToFileUtils.instance.getLogFile();
                    if (OSSLogToFileUtils.sLogFile != null) {
                        OSSLog.logInfo("LogFilePath is: " + OSSLogToFileUtils.sLogFile.getPath(), false);
                        if (OSSLogToFileUtils.LOG_MAX_SIZE < OSSLogToFileUtils.getLogFileSize(OSSLogToFileUtils.sLogFile)) {
                            OSSLog.logInfo("init reset log file", false);
                            OSSLogToFileUtils.instance.resetLogFile();
                        }
                    }
                }
            });
            return;
        }
        OSSLog.logDebug("LogToFileUtils has been init ...", false);
    }

    private Uri queryLogUri() {
        ContentResolver contentResolver = sContext.getContentResolver();
        Uri contentUri = MediaStore.Files.getContentUri("external");
        Uri uri = contentUri;
        Cursor query = contentResolver.query(uri, new String[]{"_id"}, "relative_path like ? AND _display_name=?", new String[]{"Documents/OSSLog%", "logs.csv"}, (String) null);
        if (query == null || !query.moveToFirst()) {
            return null;
        }
        Uri withAppendedId = ContentUris.withAppendedId(contentUri, query.getLong(0));
        query.close();
        return withAppendedId;
    }

    private long readSDCardSpace() {
        long j = 0;
        if ("mounted".equals(Environment.getExternalStorageState())) {
            try {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                j = statFs.getAvailableBlocksLong() * ((long) statFs.getBlockSize());
            } catch (Exception unused) {
            }
        }
        OSSLog.logDebug("sd卡存储空间:" + String.valueOf(j) + "kb", false);
        return j;
    }

    private long readSystemSpace() {
        long j;
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            j = (statFs.getAvailableBlocksLong() * ((long) statFs.getBlockSize())) / 1024;
        } catch (Exception unused) {
            j = 0;
        }
        OSSLog.logDebug("内部存储空间:" + String.valueOf(j) + "kb", false);
        return j;
    }

    public static void reset() {
        sContext = null;
        instance = null;
        sLogFile = null;
    }

    public void createNewFile(File file) {
        try {
            file.createNewFile();
        } catch (Exception e) {
            OSSLog.logError("Create log file failure !!! " + e.toString(), false);
        }
    }

    public void deleteLogFile() {
        File file = new File(sLogFile.getParent() + "/logs.csv");
        if (file.exists()) {
            OSSLog.logDebug("delete Log File ... ", false);
            file.delete();
        }
    }

    public void deleteLogFileDir() {
        deleteLogFile();
        File file = new File(sLogFile.getParent());
        if (file.exists()) {
            OSSLog.logDebug("delete Log FileDir ... ", false);
            file.delete();
        }
    }

    public void resetLogFile() {
        OSSLog.logDebug("Reset Log File ... ", false);
        if (!sLogFile.getParentFile().exists()) {
            OSSLog.logDebug("Reset Log make File dir ... ", false);
            sLogFile.getParentFile().mkdir();
        }
        File file = new File(sLogFile.getParent() + "/logs.csv");
        if (file.exists()) {
            file.delete();
        }
        createNewFile(file);
    }

    public void setUseSdCard(boolean z) {
        this.useSdCard = z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002c, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x002e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void write(java.lang.Object r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = com.alibaba.sdk.android.oss.common.OSSLog.isEnableLog()     // Catch:{ all -> 0x001e }
            if (r0 == 0) goto L_0x002d
            android.content.Context r0 = sContext     // Catch:{ all -> 0x001e }
            if (r0 == 0) goto L_0x002b
            com.alibaba.sdk.android.oss.common.OSSLogToFileUtils r0 = instance     // Catch:{ all -> 0x001e }
            if (r0 == 0) goto L_0x002b
            java.io.File r0 = sLogFile     // Catch:{ all -> 0x001e }
            if (r0 != 0) goto L_0x0014
            goto L_0x002b
        L_0x0014:
            boolean r0 = r0.exists()     // Catch:{ all -> 0x001e }
            if (r0 != 0) goto L_0x0020
            r1.resetLogFile()     // Catch:{ all -> 0x001e }
            goto L_0x0020
        L_0x001e:
            r2 = move-exception
            goto L_0x002f
        L_0x0020:
            com.alibaba.sdk.android.oss.common.OSSLogToFileUtils$WriteCall r0 = new com.alibaba.sdk.android.oss.common.OSSLogToFileUtils$WriteCall     // Catch:{ all -> 0x001e }
            r0.<init>(r2)     // Catch:{ all -> 0x001e }
            com.alibaba.sdk.android.oss.common.LogThreadPoolManager r2 = logService     // Catch:{ all -> 0x001e }
            r2.addExecuteTask(r0)     // Catch:{ all -> 0x001e }
            goto L_0x002d
        L_0x002b:
            monitor-exit(r1)
            return
        L_0x002d:
            monitor-exit(r1)
            return
        L_0x002f:
            monitor-exit(r1)     // Catch:{ all -> 0x001e }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.oss.common.OSSLogToFileUtils.write(java.lang.Object):void");
    }
}
