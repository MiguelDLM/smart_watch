package com.baidu.platform.comapi.wnplatform.n;

import XIXIX.OOXIXo;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.wnplatform.model.datastruct.WLocData;
import com.baidu.platform.comapi.wnplatform.p.c;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/* loaded from: classes8.dex */
public class a extends com.baidu.platform.comapi.walknavi.a {

    /* renamed from: a, reason: collision with root package name */
    private static final String f9942a = "a";
    private static String b;
    private static final Long j = -1L;
    private File c;
    private BufferedReader d;
    private int n;
    private boolean e = false;
    private int f = 0;
    private C0542a g = null;
    private com.baidu.platform.comapi.wnplatform.c.b h = null;
    private Object i = new Object();
    private boolean k = true;
    private Long l = 0L;
    private Long m = 600L;
    private Handler o = new b(this);

    /* renamed from: com.baidu.platform.comapi.wnplatform.n.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0542a extends Thread {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f9943a;
        private volatile boolean b;

        public void a() {
            this.b = false;
            interrupt();
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            WLocData c = this.f9943a.c();
            while (this.b && c != null) {
                try {
                    if (this.f9943a.k) {
                        com.baidu.platform.comapi.wnplatform.d.a.a(a.f9942a, "[文件时间戳]读取轨迹记录点成功，延时" + this.f9943a.m + "ms执行");
                        Thread.sleep(800L);
                    } else {
                        com.baidu.platform.comapi.wnplatform.d.a.a(a.f9942a, "[用户设定]读取轨迹记录点成功，延时" + this.f9943a.n + "ms执行");
                        Thread.sleep(800L);
                    }
                } catch (InterruptedException unused) {
                    com.baidu.platform.comapi.wnplatform.d.a.a(a.f9942a, "TrackThread sleep InterruptedException IN");
                }
                Message obtainMessage = this.f9943a.o.obtainMessage(1);
                obtainMessage.obj = c;
                this.f9943a.o.sendMessage(obtainMessage);
                c = this.f9943a.c();
                if (c == null) {
                    com.baidu.platform.comapi.wnplatform.d.a.a(a.f9942a, "轨迹点为空，轨迹导航停止");
                    this.f9943a.d = null;
                    a.f(this.f9943a);
                    c = this.f9943a.c();
                }
            }
        }
    }

    public a() {
        b = c.a() + "/WNavi/track/track.txt";
    }

    public static /* synthetic */ int f(a aVar) {
        int i = aVar.f;
        aVar.f = i + 1;
        return i;
    }

    @Override // com.baidu.platform.comapi.walknavi.a
    public boolean ready() {
        com.baidu.platform.comapi.walknavi.b.a().K().d(3);
        return true;
    }

    @Override // com.baidu.platform.comapi.walknavi.a
    public void release() {
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized WLocData c() {
        String readLine;
        File file;
        File[] listFiles;
        try {
            try {
                if (this.d == null && (file = this.c) != null && file.exists() && (listFiles = this.c.listFiles()) != null && listFiles.length > 0) {
                    int length = listFiles.length;
                    int i = this.f;
                    if (i < length) {
                        File file2 = listFiles[i];
                        if (file2.isFile()) {
                            String name = file2.getName();
                            com.baidu.platform.comapi.wnplatform.d.a.a(f9942a, "GPS Data fileName = " + name);
                            if (!TextUtils.isEmpty(name) && name.endsWith(".txt")) {
                                this.d = new BufferedReader(new FileReader(file2));
                            }
                        }
                    } else {
                        this.f = 0;
                    }
                }
                readLine = this.d.readLine();
                com.baidu.platform.comapi.wnplatform.d.a.a(f9942a, "line = " + readLine);
            } catch (Exception unused) {
                return null;
            }
        } catch (Throwable th) {
            throw th;
        }
        return a(readLine, true);
    }

    private void d() {
        synchronized (this.i) {
            this.c = null;
            this.d = null;
            this.f = 0;
        }
    }

    public void a() {
        if (this.e) {
            C0542a c0542a = this.g;
            if (c0542a != null && c0542a.isAlive()) {
                com.baidu.platform.comapi.wnplatform.d.a.a(f9942a, "用户中断轨迹复现");
                this.g.a();
                this.l = 0L;
                this.g = null;
            }
            d();
        }
    }

    private WLocData a(String str, boolean z) {
        double d;
        float f;
        double d2;
        float f2;
        float f3;
        WLocData wLocData = new WLocData();
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split(",");
        if (split == null && split.length <= 0) {
            return null;
        }
        int parseInt = Integer.parseInt(split[0]);
        if (parseInt == 2) {
            if (split.length == 7) {
                d = Double.parseDouble(split[1]);
                d2 = Double.parseDouble(split[2]);
                f = Float.parseFloat(split[3]);
                f3 = Float.parseFloat(split[4]);
                f2 = Float.parseFloat(split[5]);
                this.m = j;
            } else if (split.length == 8) {
                Integer.parseInt(split[0]);
                d = Double.parseDouble(split[1]);
                double parseDouble = Double.parseDouble(split[2]);
                f = Float.parseFloat(split[3]);
                f3 = Float.parseFloat(split[4]);
                float parseFloat = Float.parseFloat(split[5]);
                this.m = Long.valueOf(Long.parseLong(split[7]));
                f2 = parseFloat;
                d2 = parseDouble;
            } else if (split.length == 9) {
                Integer.parseInt(split[0]);
                d = Double.parseDouble(split[1]);
                d2 = Double.parseDouble(split[2]);
                float parseFloat2 = Float.parseFloat(split[3]);
                float parseFloat3 = Float.parseFloat(split[4]);
                float parseFloat4 = Float.parseFloat(split[5]);
                if (z) {
                    long parseLong = Long.parseLong(split[8]);
                    this.m = Long.valueOf(Math.abs(parseLong - this.l.longValue()));
                    this.l = Long.valueOf(parseLong);
                    com.baidu.platform.comapi.wnplatform.d.a.a(f9942a, "[文件时间戳] stampTime：" + parseLong + "mRecordInternalTime:" + this.m);
                }
                f = parseFloat2;
                f2 = parseFloat4;
                f3 = parseFloat3;
            }
            wLocData.accuracy = f2;
            GeoPoint a2 = com.baidu.platform.comapi.wnplatform.p.b.a(d, d2);
            wLocData.longitude = a2.getLongitudeE6() / 100000.0d;
            wLocData.latitude = a2.getLatitudeE6() / 100000.0d;
            wLocData.speed = f;
            wLocData.direction = f3;
            com.baidu.platform.comapi.wnplatform.d.a.a(f9942a, wLocData.toString());
            return wLocData;
        }
        if (2 == parseInt || parseInt == 0) {
            if (split.length == 2) {
                this.m = j;
            } else if (split.length == 3) {
                this.m = Long.valueOf(Long.parseLong(split[2]));
            }
        }
        d = OOXIXo.f3760XO;
        f = 0.0f;
        d2 = 0.0d;
        f2 = 0.0f;
        f3 = 0.0f;
        wLocData.accuracy = f2;
        GeoPoint a22 = com.baidu.platform.comapi.wnplatform.p.b.a(d, d2);
        wLocData.longitude = a22.getLongitudeE6() / 100000.0d;
        wLocData.latitude = a22.getLatitudeE6() / 100000.0d;
        wLocData.speed = f;
        wLocData.direction = f3;
        com.baidu.platform.comapi.wnplatform.d.a.a(f9942a, wLocData.toString());
        return wLocData;
    }

    public void a(com.baidu.platform.comapi.wnplatform.c.b bVar) {
        this.h = bVar;
    }
}
