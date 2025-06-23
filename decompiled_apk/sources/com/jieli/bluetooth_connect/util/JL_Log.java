package com.jieli.bluetooth_connect.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.kuaishou.weapon.p0.t;
import com.kwad.sdk.m.e;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes10.dex */
public class JL_Log {
    private static final String DIR_LOGCAT = "logcat";
    public static final int LEVEL_DEBUG = 2;
    public static final int LEVEL_ERROR = 5;
    public static final int LEVEL_INFO = 3;
    public static final int LEVEL_VERBOSE = 1;
    public static final int LEVEL_WARN = 4;
    public static int LOG_FILE_SIZE_LIMIT = 62914560;
    public static int SAVE_LOG_LEVEL = 1;
    private static final String TAG_PREFIX = "bt:";
    private static boolean isLog = true;
    private static boolean isSaveLogFile = false;
    private static ILogOutput logOutput;

    @SuppressLint({"StaticFieldLeak"})
    private static Context mContext;

    @SuppressLint({"StaticFieldLeak"})
    private static SaveLogFileThread mSaveLogFileThread;
    private static String saveLogFilePath;

    @SuppressLint({"ConstantLocale"})
    private static final SimpleDateFormat yyyyMMdd_HHmmssSSS = new SimpleDateFormat("yyyyMMddHHmmss.SSS", Locale.ENGLISH);

    /* loaded from: classes10.dex */
    public interface ILogOutput {
        void output(String logcat);
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes10.dex */
    public @interface LogLevel {
    }

    /* loaded from: classes10.dex */
    public static class SaveLogFileThread extends Thread {
        private long fileSize;
        private volatile boolean isSaving;
        private volatile boolean isWaiting;
        private final Context mContext;
        private FileOutputStream mLogFileOutputStream;
        private final LinkedBlockingQueue<byte[]> mQueue;

        public SaveLogFileThread(Context context) {
            super("SaveLogFileThread");
            this.mQueue = new LinkedBlockingQueue<>();
            this.mContext = context;
        }

        private boolean createFile(Context context) {
            if (context == null) {
                return false;
            }
            if (TextUtils.isEmpty(JL_Log.saveLogFilePath)) {
                String unused = JL_Log.saveLogFilePath = JL_Log.getSaveLogPath(context);
            }
            try {
                this.mLogFileOutputStream = new FileOutputStream(JL_Log.saveLogFilePath + "/bluetooth_log_app_" + JL_Log.access$300() + ".txt", true);
                this.fileSize = 0L;
                return true;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return false;
            }
        }

        private void wakeupSaveThread() {
            if (this.isWaiting) {
                synchronized (this.mQueue) {
                    this.mQueue.notify();
                }
            }
        }

        public void addLog(byte[] data) {
            if (data != null) {
                try {
                    this.mQueue.put(data);
                    wakeupSaveThread();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public synchronized void closeSaveFile() {
            this.isSaving = false;
            wakeupSaveThread();
        }

        /* JADX WARN: Code restructure failed: missing block: B:20:0x0050, code lost:
        
            r7.mLogFileOutputStream.close();
         */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0071 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                r7 = this;
                android.content.Context r0 = r7.mContext
                boolean r0 = r7.createFile(r0)
                r7.isSaving = r0
                java.util.concurrent.LinkedBlockingQueue<byte[]> r0 = r7.mQueue
                monitor-enter(r0)
            Lb:
                boolean r1 = r7.isSaving     // Catch: java.lang.Throwable -> L21
                r2 = 0
                if (r1 == 0) goto L62
                java.util.concurrent.LinkedBlockingQueue<byte[]> r1 = r7.mQueue     // Catch: java.lang.Throwable -> L21
                boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L21
                if (r1 == 0) goto L28
                r1 = 1
                r7.isWaiting = r1     // Catch: java.lang.Throwable -> L21
                java.util.concurrent.LinkedBlockingQueue<byte[]> r1 = r7.mQueue     // Catch: java.lang.Throwable -> L21 java.lang.InterruptedException -> L23
                r1.wait()     // Catch: java.lang.Throwable -> L21 java.lang.InterruptedException -> L23
                goto Lb
            L21:
                r1 = move-exception
                goto L7f
            L23:
                r1 = move-exception
                r1.printStackTrace()     // Catch: java.lang.Throwable -> L21
                goto Lb
            L28:
                r7.isWaiting = r2     // Catch: java.lang.Throwable -> L21
                java.util.concurrent.LinkedBlockingQueue<byte[]> r1 = r7.mQueue     // Catch: java.lang.Throwable -> L21
                java.lang.Object r1 = r1.poll()     // Catch: java.lang.Throwable -> L21
                byte[] r1 = (byte[]) r1     // Catch: java.lang.Throwable -> L21
                if (r1 == 0) goto Lb
                java.io.FileOutputStream r3 = r7.mLogFileOutputStream     // Catch: java.lang.Throwable -> L21
                if (r3 == 0) goto Lb
                r3.write(r1)     // Catch: java.lang.Throwable -> L21 java.io.IOException -> L43
                long r3 = r7.fileSize     // Catch: java.lang.Throwable -> L21 java.io.IOException -> L43
                int r1 = r1.length     // Catch: java.lang.Throwable -> L21 java.io.IOException -> L43
                long r5 = (long) r1     // Catch: java.lang.Throwable -> L21 java.io.IOException -> L43
                long r3 = r3 + r5
                r7.fileSize = r3     // Catch: java.lang.Throwable -> L21 java.io.IOException -> L43
                goto L47
            L43:
                r1 = move-exception
                r1.printStackTrace()     // Catch: java.lang.Throwable -> L21
            L47:
                long r3 = r7.fileSize     // Catch: java.lang.Throwable -> L21
                int r1 = com.jieli.bluetooth_connect.util.JL_Log.LOG_FILE_SIZE_LIMIT     // Catch: java.lang.Throwable -> L21
                long r5 = (long) r1
                int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r1 < 0) goto Lb
                java.io.FileOutputStream r1 = r7.mLogFileOutputStream     // Catch: java.lang.Throwable -> L21 java.io.IOException -> L56
                r1.close()     // Catch: java.lang.Throwable -> L21 java.io.IOException -> L56
                goto L5a
            L56:
                r1 = move-exception
                r1.printStackTrace()     // Catch: java.lang.Throwable -> L21
            L5a:
                android.content.Context r1 = r7.mContext     // Catch: java.lang.Throwable -> L21
                boolean r1 = r7.createFile(r1)     // Catch: java.lang.Throwable -> L21
                r7.isSaving = r1     // Catch: java.lang.Throwable -> L21
            L62:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L21
                r7.isSaving = r2
                r7.isWaiting = r2
                java.util.concurrent.LinkedBlockingQueue<byte[]> r0 = r7.mQueue
                r0.clear()
                java.io.FileOutputStream r0 = r7.mLogFileOutputStream
                r1 = 0
                if (r0 == 0) goto L7b
                r0.close()     // Catch: java.io.IOException -> L75
                goto L79
            L75:
                r0 = move-exception
                r0.printStackTrace()
            L79:
                r7.mLogFileOutputStream = r1
            L7b:
                com.jieli.bluetooth_connect.util.JL_Log.access$102(r1)
                return
            L7f:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L21
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.jieli.bluetooth_connect.util.JL_Log.SaveLogFileThread.run():void");
        }

        @Override // java.lang.Thread
        public synchronized void start() {
            boolean z;
            this.fileSize = 0L;
            if (this.mContext != null) {
                z = true;
            } else {
                z = false;
            }
            this.isSaving = z;
            super.start();
        }
    }

    public static /* synthetic */ String access$300() {
        return currentTimeString();
    }

    public static void addLogOutput(String logcat) {
        if (!isSaveLogFile) {
            return;
        }
        if (mSaveLogFileThread == null) {
            openLogFileStream(mContext);
            SystemClock.sleep(20L);
        }
        mSaveLogFileThread.addLog(logcat.getBytes());
    }

    private static void closeLogFile() {
        SaveLogFileThread saveLogFileThread = mSaveLogFileThread;
        if (saveLogFileThread != null) {
            saveLogFileThread.closeSaveFile();
            mSaveLogFileThread = null;
        }
    }

    public static String createFilePath(Context context, String... dirNames) {
        File externalFilesDir;
        if (context == null || dirNames == null || dirNames.length == 0 || (externalFilesDir = context.getExternalFilesDir(null)) == null || !externalFilesDir.exists()) {
            return null;
        }
        StringBuilder sb = new StringBuilder(externalFilesDir.getPath());
        int i = 0;
        if (sb.toString().endsWith("/")) {
            sb = new StringBuilder(sb.substring(0, sb.lastIndexOf("/")));
        }
        int length = dirNames.length;
        while (true) {
            if (i >= length) {
                break;
            }
            String str = dirNames[i];
            sb.append("/");
            sb.append(str);
            File file = new File(sb.toString());
            if ((!file.exists() || file.isFile()) && !file.mkdir()) {
                w("jieli", "createFilePath", "create dir failed. filePath = " + ((Object) sb));
                break;
            }
            i++;
        }
        return sb.toString();
    }

    private static String currentTimeString() {
        return yyyyMMdd_HHmmssSSS.format(Calendar.getInstance().getTime());
    }

    public static void d(String tag, String content) {
        logFormat(2, tag, content);
    }

    public static void e(String tag, String content) {
        logFormat(5, tag, content);
    }

    private static String formatLog(String level, String tag, String message) {
        StringBuilder sb = new StringBuilder();
        sb.append(currentTimeString());
        sb.append("   ");
        sb.append(level);
        sb.append("   ");
        if (tag == null) {
            tag = "null";
        }
        sb.append(tag);
        sb.append(" :  ");
        if (message == null) {
            message = "null";
        }
        sb.append(message);
        sb.append("\n");
        return sb.toString();
    }

    private static String formatMethod(String method, String content) {
        return String.format(Locale.ENGLISH, "[%s] >>> %s", method, content);
    }

    private static String formatTag(String tag) {
        return TAG_PREFIX + tag;
    }

    private static String getLevelString(int level) {
        if (level != 1) {
            if (level != 2) {
                if (level != 3) {
                    if (level != 4) {
                        if (level != 5) {
                            return "";
                        }
                        return e.TAG;
                    }
                    return IAdInterListener.AdReqParam.WIDTH;
                }
                return "i";
            }
            return "d";
        }
        return t.c;
    }

    public static boolean getSaveLogFile() {
        return isSaveLogFile;
    }

    public static String getSaveLogPath(Context context) {
        return createFilePath(context, "logcat");
    }

    public static void i(String tag, String content) {
        logFormat(3, tag, content);
    }

    public static boolean isLog() {
        return isLog;
    }

    private static void logFormat(int level, String tag, String content) {
        String formatTag = formatTag(tag);
        if (isLog) {
            if (level != 1) {
                if (level != 2) {
                    if (level != 3) {
                        if (level != 4) {
                            if (level != 5) {
                                return;
                            } else {
                                Log.e(formatTag, content);
                            }
                        } else {
                            Log.w(formatTag, content);
                        }
                    } else {
                        Log.i(formatTag, content);
                    }
                } else {
                    Log.d(formatTag, content);
                }
            } else {
                Log.v(formatTag, content);
            }
        }
        saveLogInFile(level, formatTag, content);
    }

    private static void openLogFileStream(Context context) {
        SaveLogFileThread saveLogFileThread = mSaveLogFileThread;
        if (saveLogFileThread == null || !saveLogFileThread.isSaving) {
            SaveLogFileThread saveLogFileThread2 = new SaveLogFileThread(context);
            mSaveLogFileThread = saveLogFileThread2;
            saveLogFileThread2.start();
        }
    }

    private static void saveLogInFile(int level, String tag, String content) {
        String formatLog = formatLog(getLevelString(level), tag, content);
        ILogOutput iLogOutput = logOutput;
        if (iLogOutput != null) {
            iLogOutput.output(formatLog);
        } else {
            if (level < SAVE_LOG_LEVEL) {
                return;
            }
            addLogOutput(formatLog);
        }
    }

    public static void setIsSaveLogFile(boolean isSaveFile, Context context) {
        isSaveLogFile = isSaveFile;
        if (isSaveFile) {
            mContext = context;
            openLogFileStream(context);
        } else {
            mContext = null;
            closeLogFile();
        }
    }

    public static void setLog(boolean log) {
        isLog = log;
    }

    public static void setLogOutput(ILogOutput logOutput2) {
        logOutput = logOutput2;
    }

    public static void v(String tag, String content) {
        logFormat(1, tag, content);
    }

    public static void w(String tag, String content) {
        logFormat(4, tag, content);
    }

    public static void d(String tag, String method, String content) {
        d(tag, formatMethod(method, content));
    }

    public static void e(String tag, String method, String content) {
        e(tag, formatMethod(method, content));
    }

    public static void i(String tag, String method, String content) {
        i(tag, formatMethod(method, content));
    }

    public static void v(String tag, String method, String content) {
        v(tag, formatMethod(method, content));
    }

    public static void w(String tag, String method, String content) {
        w(tag, formatMethod(method, content));
    }
}
