package com.jieli.jl_rcsp.util;

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
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes10.dex */
public class JL_Log {
    public static long FILE_SIZE_LIMIT = 314572800;
    public static final int LEVEL_DEBUG = 2;
    public static final int LEVEL_ERROR = 5;
    public static final int LEVEL_INFO = 3;
    public static final int LEVEL_VERBOSE = 1;
    public static final int LEVEL_WARN = 4;
    public static int SAVE_LOG_LEVEL = 1;

    /* renamed from: a, reason: collision with root package name */
    public static String f18228a = "JL";
    public static final String b = "logcat";
    public static boolean c = true;
    public static boolean d = false;
    public static boolean e = false;

    @SuppressLint({"StaticFieldLeak"})
    public static Context f = null;
    public static String g = null;

    @SuppressLint({"ConstantLocale"})
    public static final SimpleDateFormat h = new SimpleDateFormat("yyyyMMddHHmmss.SSS", Locale.ENGLISH);

    @SuppressLint({"StaticFieldLeak"})
    public static SaveLogFileThread i = null;
    public static boolean isLogCrash = true;
    public static ILogOutput j;

    /* loaded from: classes10.dex */
    public interface ILogOutput {
        void output(String str);
    }

    /* loaded from: classes10.dex */
    public static class SaveLogFileThread extends Thread {

        /* renamed from: a, reason: collision with root package name */
        public final LinkedBlockingQueue<byte[]> f18229a;
        public final Context b;
        public volatile boolean c;
        public volatile boolean d;
        public long e;
        public FileOutputStream f;

        public SaveLogFileThread(Context context) {
            super("SaveLogFileThread");
            this.f18229a = new LinkedBlockingQueue<>();
            this.b = context;
        }

        public void addLog(byte[] bArr) {
            if (bArr != null) {
                try {
                    this.f18229a.put(bArr);
                    a();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public synchronized void closeSaveFile() {
            this.d = false;
            a();
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            FileOutputStream fileOutputStream;
            this.d = a(this.b);
            synchronized (this.f18229a) {
                while (this.d) {
                    if (this.f18229a.isEmpty()) {
                        this.c = true;
                        try {
                            this.f18229a.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        this.c = false;
                        byte[] poll = this.f18229a.poll();
                        if (poll != null && (fileOutputStream = this.f) != null) {
                            try {
                                fileOutputStream.write(poll);
                                this.e += poll.length;
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                            if (this.e >= JL_Log.FILE_SIZE_LIMIT) {
                                try {
                                    this.f.close();
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                }
                                this.d = a(this.b);
                            }
                        }
                    }
                }
            }
            this.d = false;
            this.c = false;
            this.f18229a.clear();
            FileOutputStream fileOutputStream2 = this.f;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
            SaveLogFileThread unused = JL_Log.i = null;
        }

        @Override // java.lang.Thread
        public synchronized void start() {
            boolean z;
            this.e = 0L;
            if (this.b != null) {
                z = true;
            } else {
                z = false;
            }
            this.d = z;
            super.start();
        }

        public final void a() {
            if (this.c) {
                synchronized (this.f18229a) {
                    this.f18229a.notify();
                }
            }
        }

        public final boolean a(Context context) {
            if (context == null) {
                return false;
            }
            if (TextUtils.isEmpty(JL_Log.g)) {
                String unused = JL_Log.g = JL_Log.getSaveLogPath(context);
            }
            try {
                this.f = new FileOutputStream(JL_Log.g + "/" + JL_Log.b() + JL_Log.c() + ".txt", true);
                this.e = 0L;
                return true;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return false;
            }
        }
    }

    public static void addLogOutput(String str) {
        if (e && str != null) {
            if (i == null) {
                a(f);
                SystemClock.sleep(20L);
            }
            i.addLog(str.getBytes());
        }
    }

    public static /* synthetic */ String b() {
        return f();
    }

    public static /* synthetic */ String c() {
        return e();
    }

    public static void configureLog(Context context, boolean z, boolean z2) {
        c = z;
        e = z2;
        if (z2) {
            f = context;
            if (isLogCrash && context != null) {
                try {
                    CrashHandler.getInstance().init(f);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            a(context);
            return;
        }
        f = null;
        d();
    }

    public static void d(String str, String str2) {
        a(2, str, str2);
    }

    public static void e(String str, String str2) {
        a(5, str, str2);
    }

    public static String f() {
        if (TextUtils.isEmpty(f18228a)) {
            return "app_log_";
        }
        return f18228a + "_log_";
    }

    public static boolean getSaveLogFile() {
        return e;
    }

    public static String getSaveLogPath(Context context) {
        return a(context, "logcat");
    }

    public static void i(String str, String str2) {
        a(3, str, str2);
    }

    public static boolean isLog() {
        return c;
    }

    public static void setLogOutput(ILogOutput iLogOutput) {
        j = iLogOutput;
    }

    public static void setTagPrefix(String str) {
        f18228a = str;
    }

    public static void setUseTest(boolean z) {
        d = z;
    }

    public static void v(String str, String str2) {
        a(1, str, str2);
    }

    public static void w(String str, String str2) {
        a(4, str, str2);
    }

    public static String b(String str) {
        return f18228a + ":" + str;
    }

    public static void d(String str, String str2, String str3) {
        d(str, a(str2, str3));
    }

    public static void e(String str, String str2, String str3) {
        e(str, a(str2, str3));
    }

    public static void i(String str, String str2, String str3) {
        i(str, a(str2, str3));
    }

    public static void v(String str, String str2, String str3) {
        v(str, a(str2, str3));
    }

    public static void w(String str, String str2, String str3) {
        w(str, a(str2, str3));
    }

    public static void b(int i2, String str, String str2) {
        String a2 = a(a(i2), str, str2);
        ILogOutput iLogOutput = j;
        if (iLogOutput != null) {
            iLogOutput.output(a2);
        } else {
            if (i2 < SAVE_LOG_LEVEL) {
                return;
            }
            addLogOutput(a2);
        }
    }

    public static void d() {
        SaveLogFileThread saveLogFileThread = i;
        if (saveLogFileThread != null) {
            saveLogFileThread.closeSaveFile();
            i = null;
        }
    }

    public static String e() {
        return h.format(Calendar.getInstance().getTime());
    }

    public static void a(Context context) {
        SaveLogFileThread saveLogFileThread = i;
        if (saveLogFileThread == null || !saveLogFileThread.d) {
            SaveLogFileThread saveLogFileThread2 = new SaveLogFileThread(context);
            i = saveLogFileThread2;
            saveLogFileThread2.start();
        }
    }

    public static String a(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append(e());
        sb.append("   ");
        sb.append(str);
        sb.append("   ");
        if (str2 == null) {
            str2 = "null";
        }
        sb.append(str2);
        sb.append(" :  ");
        if (str3 == null) {
            str3 = "null";
        }
        sb.append(str3);
        sb.append("\n");
        return sb.toString();
    }

    public static String a(String str, String str2) {
        return String.format(Locale.ENGLISH, "[%s] >>> %s", str, str2);
    }

    public static String a(int i2) {
        if (i2 == 1) {
            return t.c;
        }
        if (i2 == 2) {
            return "d";
        }
        if (i2 == 3) {
            return "i";
        }
        if (i2 == 4) {
            return IAdInterListener.AdReqParam.WIDTH;
        }
        if (i2 != 5) {
            return "";
        }
        return e.TAG;
    }

    public static void a(int i2, String str, String str2) {
        String b2 = b(str);
        if (c) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 != 4) {
                            if (i2 != 5) {
                                return;
                            }
                            if (d) {
                                TestLog.e(b2, str2);
                            } else {
                                Log.e(b2, str2);
                            }
                        } else if (d) {
                            TestLog.w(b2, str2);
                        } else {
                            Log.w(b2, str2);
                        }
                    } else if (d) {
                        TestLog.i(b2, str2);
                    } else {
                        Log.i(b2, str2);
                    }
                } else if (d) {
                    TestLog.d(b2, str2);
                } else {
                    Log.d(b2, str2);
                }
            } else if (d) {
                TestLog.v(b2, str2);
            } else {
                Log.v(b2, str2);
            }
        }
        b(i2, b2, str2);
    }

    public static String a(Context context, String... strArr) {
        File externalFilesDir;
        if (context == null || strArr == null || strArr.length == 0 || (externalFilesDir = context.getExternalFilesDir(null)) == null || !externalFilesDir.exists()) {
            return null;
        }
        StringBuilder sb = new StringBuilder(externalFilesDir.getPath());
        int i2 = 0;
        if (sb.toString().endsWith("/")) {
            sb = new StringBuilder(sb.substring(0, sb.lastIndexOf("/")));
        }
        int length = strArr.length;
        while (true) {
            if (i2 >= length) {
                break;
            }
            String str = strArr[i2];
            sb.append("/");
            sb.append(str);
            File file = new File(sb.toString());
            if ((!file.exists() || file.isFile()) && !file.mkdir()) {
                w("jieli", "createFilePath", "create dir failed. filePath = " + ((Object) sb));
                break;
            }
            i2++;
        }
        return sb.toString();
    }
}
