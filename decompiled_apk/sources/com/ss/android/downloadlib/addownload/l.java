package com.ss.android.downloadlib.addownload;

import android.os.SystemClock;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    private static final String f26055a = "l";

    /* loaded from: classes11.dex */
    public class a implements Runnable {
        private final com.ss.android.downloadad.api.a.b b;

        public a(com.ss.android.downloadad.api.a.b bVar) {
            this.b = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                try {
                    this.b.j(true);
                    l.this.b(this.b);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } finally {
                this.b.j(false);
            }
        }
    }

    /* loaded from: classes11.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private static l f26057a = new l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.ss.android.downloadad.api.a.b bVar) {
        JSONObject jSONObject = new JSONObject();
        int a2 = com.ss.android.downloadlib.g.e.a(bVar);
        int b2 = com.ss.android.downloadlib.g.e.b(bVar);
        if (com.ss.android.downloadlib.g.e.e(bVar) && com.ss.android.downloadlib.g.e.d(bVar)) {
            com.ss.android.downloadlib.g.l.a().a(f26055a, "tryListenInstallFinishEvent", "上层库开启二级线程轮询检测策略");
            a(bVar, a2, b2, jSONObject);
        } else {
            com.ss.android.downloadlib.g.l.a().a(f26055a, "tryListenInstallFinishEvent", "采用原有默认轮询策略");
            b(bVar, 15, 20000, jSONObject);
        }
    }

    private l() {
    }

    public static l a() {
        return b.f26057a;
    }

    public void a(com.ss.android.downloadad.api.a.b bVar) {
        com.ss.android.downloadlib.g.l.a().a(f26055a, "tryListenInstallFinish", "开始通过轮询线程监听安装完成事件");
        com.ss.android.downloadlib.d.a().c(new a(bVar));
    }

    private void a(com.ss.android.downloadad.api.a.b bVar, int i, int i2, JSONObject jSONObject) {
        int f;
        if (bVar.K() == 4) {
            f = k.j().optInt("market_install_finish_check_time", 600);
        } else {
            f = com.ss.android.downloadlib.g.e.f(bVar);
        }
        int i3 = ((f * 1000) / 20000) + 1;
        com.ss.android.downloadlib.g.l a2 = com.ss.android.downloadlib.g.l.a();
        String str = f26055a;
        a2.a(str, "realListenInstallFinishEventOpt", "一级轮询次数，即广播生效期内的轮询次数为:" + i3);
        if (b(bVar, i3, 20000, jSONObject)) {
            return;
        }
        if (f * 1000 < com.ss.android.downloadlib.g.e.g(bVar)) {
            com.ss.android.downloadlib.g.l.a().a(str, "tryListenInstallFinishEventOpt", "广播生效时间外，一级轮询完成且没有检测到安装完成事件，开始二级检测");
            if (b(bVar, i, i2, jSONObject)) {
                return;
            }
            com.ss.android.downloadlib.g.l.a().a(str, "tryListenInstallFinishEventOpt", "监听时间结束,依然没有监听到安装完成事件");
            return;
        }
        com.ss.android.downloadlib.g.l.a().a(str, "tryListenInstallFinishEventOpt", "一级轮询时间小于广播监听时间,且未监听到安装完成事件");
    }

    private boolean b(com.ss.android.downloadad.api.a.b bVar, int i, int i2, JSONObject jSONObject) {
        com.ss.android.downloadlib.g.l.a().a(f26055a, "realListenInstallFinishEvent", "开始轮询检测,轮询时间间隔为" + i2 + ",轮询次数为" + i);
        long j = (long) i2;
        SystemClock.sleep(j);
        while (i > 0) {
            if (com.ss.android.downloadlib.g.m.b(bVar)) {
                com.ss.android.downloadlib.a.a().a(bVar.e());
                com.ss.android.downloadlib.g.l.a().a(f26055a, "realListenInstallFinishEvent", "检测到安装成功，当前剩余的轮询次数为" + i);
                return true;
            }
            i--;
            if (i == 0) {
                return false;
            }
            SystemClock.sleep(j);
        }
        return false;
    }
}
