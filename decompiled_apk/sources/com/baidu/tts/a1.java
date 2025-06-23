package com.baidu.tts;

import android.util.Log;
import com.baidu.tts.tools.ResourceTools;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes8.dex */
public class a1 extends v0 {
    public String b;
    public String c;
    public SimpleDateFormat d;
    public SimpleDateFormat e;

    public a1(b1 b1Var) {
        super(b1Var);
        this.b = ResourceTools.getAppExtDir() + "log/";
        this.c = "bdtts";
        this.d = new SimpleDateFormat("yyyy_MM_dd");
        this.e = new SimpleDateFormat("MM-dd_HH-mm-ss_SSS");
    }

    @Override // com.baidu.tts.v0
    public int a(x0 x0Var) {
        if (x0Var == null) {
            Log.e("StorageLoggerCloseState", "invalid params!");
            return -1;
        }
        String str = this.b + this.d.format(new Date());
        String str2 = this.c;
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, String.format("%s_%s.log", str2, this.e.format(new Date())));
        Log.w("StorageLoggerCloseState", "new log file=" + file2.getName());
        b1 b1Var = this.f10179a;
        b1Var.f10040a = file2;
        c1 c1Var = b1Var.d;
        b1Var.b = c1Var;
        return c1Var.a(x0Var);
    }
}
