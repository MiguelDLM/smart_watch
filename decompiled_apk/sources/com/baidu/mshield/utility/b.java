package com.baidu.mshield.utility;

import android.content.Context;
import android.os.Message;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes7.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static Lock f6389a = new ReentrantLock();
    public static b b = null;
    public com.baidu.mshield.rp.e.a c;

    public b(Context context) {
        this.c = new com.baidu.mshield.rp.e.a(context);
    }

    public static b a(Context context) {
        b bVar = b;
        if (bVar != null) {
            return bVar;
        }
        try {
            f6389a.lock();
            if (b == null) {
                b = new b(context);
            }
            b bVar2 = b;
            f6389a.unlock();
            return bVar2;
        } catch (Throwable th) {
            f6389a.unlock();
            throw th;
        }
    }

    public void b() {
        Message message = new Message();
        message.what = 2;
        this.c.a(message);
    }

    public void c() {
        Message message = new Message();
        message.what = 8;
        this.c.a(message);
    }

    public void d() {
        Message message = new Message();
        message.what = 6;
        this.c.a(message);
    }

    public void e() {
        Message message = new Message();
        message.what = 9;
        this.c.a(message);
    }

    public void a() {
        this.c.a();
    }

    public void a(boolean z) {
        this.c.a(z);
    }

    public void a(com.baidu.mshield.rp.c.a aVar) {
        Message message = new Message();
        message.what = 1;
        message.obj = aVar;
        this.c.a(message);
    }

    public void a(com.baidu.mshield.rp.a.a aVar) {
        Message message = new Message();
        message.what = 3;
        message.obj = aVar;
        this.c.a(message);
    }

    public void a(String str) {
        Message message = new Message();
        message.what = 11;
        message.obj = str;
        this.c.a(message);
    }
}
