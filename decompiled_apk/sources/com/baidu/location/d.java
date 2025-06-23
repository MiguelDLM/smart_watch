package com.baidu.location;

import com.baidu.location.e.o;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class d extends Thread {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ LocationClient f5715a;

    public d(LocationClient locationClient) {
        this.f5715a = locationClient;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            if (this.f5715a.D != null) {
                if (o.g(this.f5715a.f) > 0) {
                    this.f5715a.D.a();
                }
                this.f5715a.D.c();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
