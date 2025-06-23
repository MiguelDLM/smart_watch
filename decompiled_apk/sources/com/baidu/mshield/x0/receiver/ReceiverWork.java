package com.baidu.mshield.x0.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.mshield.x0.EngineImpl;
import com.baidu.mshield.x0.b.b;
import com.baidu.mshield.x0.b.d;
import java.util.List;

/* loaded from: classes7.dex */
public class ReceiverWork extends BroadcastReceiver {
    public static void a(Context context, Intent intent) {
        try {
            if (!EngineImpl.isUnload && intent != null && "com.baidu.mshield.x0.alarm.action".equals(intent.getAction())) {
                long a2 = b.a(context) * 60000;
                new com.baidu.mshield.x0.j.a(context).c(System.currentTimeMillis() + a2);
                b.a(context, a2);
                List<com.baidu.mshield.x0.b.a> a3 = com.baidu.mshield.x0.d.a.a(context).a();
                long currentTimeMillis = System.currentTimeMillis() + 300000;
                for (com.baidu.mshield.x0.b.a aVar : a3) {
                    com.baidu.mshield.b.c.a.b("rec t:" + d.a(aVar.c, "yyyy-MM-dd HH:mm:ss") + " ac:" + aVar.f6400a);
                    if (currentTimeMillis >= aVar.c) {
                        com.baidu.mshield.x0.i.a.a(context, aVar.f6400a);
                    }
                }
            }
        } catch (Throwable th) {
            d.a(th);
        }
    }

    public static void b(Context context, Intent intent) {
        if (EngineImpl.isUnload) {
            return;
        }
        com.baidu.mshield.x0.i.a.a(context, intent);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        com.baidu.mshield.x0.b.a.d.a().a(new a(this, context, intent));
    }
}
