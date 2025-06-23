package com.baidu.xclient.gdid.c;

import android.content.Context;
import android.content.Intent;
import com.baidu.xclient.gdid.e.d;

/* loaded from: classes8.dex */
public class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Intent f10228a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ b c;

    public c(b bVar, Intent intent, Context context) {
        this.c = bVar;
        this.f10228a = intent;
        this.b = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        try {
            Intent intent = this.f10228a;
            if (intent == null) {
                return;
            }
            String action = intent.getAction();
            if (b.f10227a.equals(action)) {
                com.baidu.xclient.gdid.c.a().a(false, true);
                return;
            }
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
                z = this.c.b;
                if (z) {
                    this.c.b = false;
                } else if (d.a(this.b)) {
                    com.baidu.xclient.gdid.c.a().a(false, false);
                }
            }
        } catch (Throwable th) {
            d.a(th);
        }
    }
}
