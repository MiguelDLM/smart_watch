package com.baidu.location.b;

import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class ao extends Handler {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ an f5630a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ao(an anVar, Looper looper) {
        super(looper);
        this.f5630a = anVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Handler handler;
        Handler handler2;
        int i = message.what;
        if (i == 1) {
            Bundle data = message.getData();
            try {
                Location location = (Location) data.getParcelable("loc");
                data.getInt("satnum");
                if (location != null) {
                    n.a().a(location);
                    return;
                }
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        if (i == 2) {
            am.a(ah.c(), com.baidu.location.c.h.a().r(), ah.d(), ah.a(), ah.e());
            return;
        }
        if (i == 3) {
            am.a(ah.c(), (com.baidu.location.c.p) null, ah.d(), c.a().c(), ah.e());
            return;
        }
        if (i == 4) {
            boolean l = com.baidu.location.c.h.a().l();
            if (com.baidu.location.e.o.b()) {
                l = false;
            }
            if (l) {
                r.a().d();
            }
            try {
                handler = this.f5630a.d;
                if (handler != null) {
                    handler2 = this.f5630a.d;
                    handler2.sendEmptyMessageDelayed(4, com.baidu.location.e.o.Q);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            al.a().b();
            return;
        }
        if (i == 7) {
            am.a().c();
            return;
        }
        if (i == 8 || i == 9) {
            message.getData();
            return;
        }
        if (i != 11) {
            return;
        }
        Bundle data2 = message.getData();
        try {
            al.a().a(X0o0xo.oIX0oI(data2.getParcelable("gnss_navigation_message")), data2.getLong("gps_time"));
        } catch (Exception unused) {
        }
    }
}
