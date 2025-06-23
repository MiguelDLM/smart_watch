package com.baidu.tts;

import android.util.Log;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes8.dex */
public class c1 extends v0 {
    public Date b;
    public SimpleDateFormat c;
    public final String d;

    public c1(b1 b1Var) {
        super(b1Var);
        this.d = System.getProperty("line.separator");
        this.b = new Date();
        this.c = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss.SSS");
    }

    @Override // com.baidu.tts.v0
    public int a(x0 x0Var) {
        IOException e;
        FileWriter fileWriter;
        if (x0Var == null) {
            Log.e("StorageLoggerOpenState", "invalid params!");
            return -1;
        }
        File file = this.f10179a.f10040a;
        if (file == null) {
            Log.e("StorageLoggerOpenState", "logfile null!");
            return -2;
        }
        if (file.length() >= 1048576) {
            Log.w("StorageLoggerOpenState", "write new log file");
            b1 b1Var = this.f10179a;
            a1 a1Var = b1Var.c;
            b1Var.b = a1Var;
            return a1Var.a(x0Var);
        }
        StringBuilder sb = new StringBuilder();
        this.b.setTime(x0Var.d);
        sb.append(this.c.format(this.b));
        sb.append("---");
        sb.append(x0Var.b);
        sb.append("---");
        sb.append(x0Var.c);
        sb.append(this.d);
        try {
            fileWriter = new FileWriter(this.f10179a.f10040a, true);
        } catch (IOException e2) {
            e = e2;
            fileWriter = null;
        }
        try {
            fileWriter.append((CharSequence) sb.toString());
            fileWriter.flush();
            fileWriter.close();
            return 0;
        } catch (IOException e3) {
            e = e3;
            Log.e("StorageLoggerOpenState", "log write exception! e=" + e.getMessage());
            e.printStackTrace();
            if (fileWriter != null) {
                try {
                    fileWriter.flush();
                    fileWriter.close();
                    return -3;
                } catch (IOException e4) {
                    Log.e("StorageLoggerOpenState", "log flush exception! e=" + e4.getMessage());
                    return -3;
                }
            }
            return -3;
        }
    }
}
