package com.baidu.platform.comapi.walknavi.e.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ d f9732a;

    public e(d dVar) {
        this.f9732a = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            Thread.sleep(200L);
            com.baidu.platform.comapi.walknavi.e.a.e.a.a().b();
        } catch (Exception e) {
            com.baidu.platform.comapi.walknavi.e.a.g.a.a("statistic exception when destroy: " + e.getMessage());
        }
    }
}
