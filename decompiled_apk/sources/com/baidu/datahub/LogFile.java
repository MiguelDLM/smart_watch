package com.baidu.datahub;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes7.dex */
public class LogFile {
    private static final char DEBUG = 'd';
    private static final char ERROR = 'e';
    private static final char INFO = 'i';
    private static String TAG = "LogFile";
    private static final char VERBOSE = 'v';
    private static final char WARN = 'w';
    private static SimpleDateFormat dataFormat2;
    private static SimpleDateFormat dateFormat;
    private static String logPath;

    static {
        Locale locale = Locale.CHINA;
        dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss", locale);
        dataFormat2 = new SimpleDateFormat("yyyy-MM-dd", locale);
    }

    public static void d(String str, String str2) {
        writeToFile(DEBUG, str, str2);
    }

    public static void e(String str, String str2) {
        writeToFile(ERROR, str, str2);
    }

    private static String getFilePath(Context context) {
        if ("mounted".equals(Environment.getExternalStorageState())) {
            File externalFilesDir = context.getExternalFilesDir(null);
            if (externalFilesDir == null) {
                return "";
            }
            return externalFilesDir.getPath();
        }
        return context.getFilesDir().getPath();
    }

    public static void i(String str, String str2) {
        writeToFile(INFO, str, str2);
    }

    public static void init(Context context) {
        String str = getFilePath(context) + "/Logs";
        logPath = str;
        Log.e(TAG, str);
    }

    public static void v(String str, String str2) {
        writeToFile(VERBOSE, str, str2);
    }

    public static void w(String str, String str2) {
        writeToFile(WARN, str, str2);
    }

    private static void writeToFile(char c, String str, String str2) {
        BufferedWriter bufferedWriter;
        if (logPath == null) {
            Log.e(TAG, "logPath == null ，未初始化LogFile");
            return;
        }
        String str3 = logPath + "/log_" + dataFormat2.format(new Date()) + ".log";
        String str4 = dateFormat.format(new Date()) + " " + c + " " + str + " " + str2 + "\n";
        File file = new File(logPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        BufferedWriter bufferedWriter2 = null;
        try {
            try {
                try {
                    bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(str3, true)));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (FileNotFoundException e2) {
                e = e2;
            } catch (IOException e3) {
                e = e3;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            bufferedWriter.write(str4);
            bufferedWriter.close();
        } catch (FileNotFoundException e4) {
            e = e4;
            bufferedWriter2 = bufferedWriter;
            e.printStackTrace();
            if (bufferedWriter2 != null) {
                bufferedWriter2.close();
            }
        } catch (IOException e5) {
            e = e5;
            bufferedWriter2 = bufferedWriter;
            e.printStackTrace();
            if (bufferedWriter2 != null) {
                bufferedWriter2.close();
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedWriter2 = bufferedWriter;
            if (bufferedWriter2 != null) {
                try {
                    bufferedWriter2.close();
                } catch (IOException e6) {
                    e6.printStackTrace();
                }
            }
            throw th;
        }
    }
}
