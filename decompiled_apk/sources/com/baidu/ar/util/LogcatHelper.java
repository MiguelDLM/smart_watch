package com.baidu.ar.util;

import android.content.Context;
import android.os.Process;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes7.dex */
public class LogcatHelper {
    private static LogcatHelper sInatance;
    private static String sPath;
    private a mLogDumper = null;
    private int mPId;

    /* loaded from: classes7.dex */
    public class a extends Thread {
        private Process CV;
        private BufferedReader CW = null;
        private boolean CX = true;
        String CY;
        private String CZ;
        private FileOutputStream Da;

        public a(String str, String str2) {
            this.CY = null;
            this.Da = null;
            this.CZ = str;
            try {
                this.Da = new FileOutputStream(new File(str2, "Log-" + LogcatHelper.this.getDateToString(System.currentTimeMillis()) + ".log"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            this.CY = "logcat *:e *:i -s 'huangyn1' | grep \"(" + LogcatHelper.this.mPId + ")\"";
        }

        public void he() {
            this.CX = false;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            FileOutputStream fileOutputStream;
            String readLine;
            try {
                try {
                    this.CV = Runtime.getRuntime().exec(this.CY);
                    this.CW = new BufferedReader(new InputStreamReader(this.CV.getInputStream()), 1024);
                    while (this.CX && (readLine = this.CW.readLine()) != null && this.CX) {
                        if (readLine.length() != 0 && this.Da != null && readLine.contains(this.CZ)) {
                            this.Da.write((readLine + "\n").getBytes());
                        }
                    }
                    Process process = this.CV;
                    if (process != null) {
                        process.destroy();
                        this.CV = null;
                    }
                    BufferedReader bufferedReader = this.CW;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                            this.CW = null;
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    fileOutputStream = this.Da;
                } catch (Throwable th) {
                    Process process2 = this.CV;
                    if (process2 != null) {
                        process2.destroy();
                        this.CV = null;
                    }
                    BufferedReader bufferedReader2 = this.CW;
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                            this.CW = null;
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                    FileOutputStream fileOutputStream2 = this.Da;
                    if (fileOutputStream2 == null) {
                        throw th;
                    }
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                    this.Da = null;
                    throw th;
                }
            } catch (IOException e4) {
                e4.printStackTrace();
                Process process3 = this.CV;
                if (process3 != null) {
                    process3.destroy();
                    this.CV = null;
                }
                BufferedReader bufferedReader3 = this.CW;
                if (bufferedReader3 != null) {
                    try {
                        bufferedReader3.close();
                        this.CW = null;
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
                FileOutputStream fileOutputStream3 = this.Da;
                if (fileOutputStream3 == null) {
                    return;
                }
                try {
                    fileOutputStream3.close();
                } catch (IOException e6) {
                    e = e6;
                    e.printStackTrace();
                    this.Da = null;
                }
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e7) {
                    e = e7;
                    e.printStackTrace();
                    this.Da = null;
                }
                this.Da = null;
            }
        }
    }

    private LogcatHelper(Context context) {
        init(context);
        this.mPId = Process.myPid();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getDateToString(long j) {
        return new SimpleDateFormat("yyyy年MM月dd日-HH:mm:ss").format(new Date(j));
    }

    public static LogcatHelper getInstance(Context context) {
        if (sInatance == null) {
            sInatance = new LogcatHelper(context);
        }
        return sInatance;
    }

    public void init(Context context) {
        String str;
        File externalFilesDir = context.getExternalFilesDir(null);
        if (externalFilesDir == null) {
            str = context.getFilesDir().getAbsolutePath() + File.separator + "Navigation";
        } else {
            str = externalFilesDir.getAbsolutePath() + File.separator + "Navigation";
        }
        sPath = str;
        File file = new File(sPath);
        if (file.exists()) {
            return;
        }
        file.mkdirs();
    }

    public void start() {
        if (this.mLogDumper == null) {
            this.mLogDumper = new a(String.valueOf(this.mPId), sPath);
        }
        this.mLogDumper.start();
    }

    public void stop() {
        a aVar = this.mLogDumper;
        if (aVar != null) {
            aVar.he();
            this.mLogDumper = null;
        }
    }
}
