package com.baidu.navisdk.util.statistic;

import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import com.baidu.navisdk.util.common.LogUtil;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* loaded from: classes8.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    long f9365a;
    long b;
    long c;
    long d;
    String e;

    /* loaded from: classes8.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private static c f9366a = new c();
    }

    public static c d() {
        return b.f9366a;
    }

    public void a() {
        this.c = SystemClock.elapsedRealtime();
        LogUtil.e("CpuStat", "end jiffies=" + this.d);
        this.d = a(this.e);
    }

    public long b() {
        long j = this.c - this.f9365a;
        if (j <= 0) {
            return 0L;
        }
        return ((this.d - this.b) * 3600000) / j;
    }

    public void c() {
        this.f9365a = SystemClock.elapsedRealtime();
        this.b = a(this.e);
        LogUtil.e("CpuStat", "start jiffies=" + this.b);
    }

    private c() {
        this.e = "/proc/" + Process.myPid() + "/stat";
    }

    private long a(String str) {
        long j = 0;
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(str, "r");
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.setLength(0);
            while (true) {
                String readLine = randomAccessFile.readLine();
                if (readLine == null) {
                    break;
                }
                stringBuffer.append(readLine + "\n");
            }
            String[] split = stringBuffer.toString().split(" ");
            if (split.length > 0) {
                j = Long.parseLong(split[14]) + Long.parseLong(split[13]);
            }
            randomAccessFile.close();
        } catch (FileNotFoundException e) {
            Log.e("", "FileNotFoundException: " + e.getMessage());
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return j;
    }
}
