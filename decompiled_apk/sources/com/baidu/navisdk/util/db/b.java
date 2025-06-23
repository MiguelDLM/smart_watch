package com.baidu.navisdk.util.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.util.common.LogUtil;
import java.util.ArrayList;

/* loaded from: classes8.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static SQLiteDatabase f9255a;
    private static com.baidu.navisdk.util.db.a b;
    private static final Object c = new Object();
    private static int d;
    private static HandlerThread e;
    private static Looper f;
    private static Handler g;

    /* loaded from: classes8.dex */
    public class a extends Handler {

        /* renamed from: a, reason: collision with root package name */
        ArrayList<RoutePlanNode> f9256a;
        InterfaceC0494b b;

        public a(Looper looper) {
            super(looper);
            this.f9256a = null;
            this.b = null;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            this.f9256a = null;
            switch (message.what) {
                case 33:
                    this.b = (InterfaceC0494b) message.obj;
                    com.baidu.navisdk.util.db.model.a.d().c();
                    InterfaceC0494b interfaceC0494b = this.b;
                    if (interfaceC0494b != null) {
                        interfaceC0494b.a();
                        return;
                    }
                    return;
                case 34:
                    this.f9256a = (ArrayList) message.obj;
                    com.baidu.navisdk.util.db.model.a.d().a(this.f9256a);
                    return;
                case 35:
                    com.baidu.navisdk.util.db.model.a.d().a((RoutePlanNode) message.obj);
                    return;
                case 36:
                    com.baidu.navisdk.util.db.model.a.d().a();
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: com.baidu.navisdk.util.db.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0494b {
        void a();
    }

    private b() {
    }

    public static void a(Context context) {
        if (b == null) {
            b = new com.baidu.navisdk.util.db.a(context);
            try {
                HandlerThread handlerThread = new HandlerThread("DBManager");
                e = handlerThread;
                handlerThread.start();
                f = e.getLooper();
                g = new a(f);
            } catch (Throwable unused) {
                LogUtil.e("DBManager", "onCreateView: LogUtil -->> Failed to onCreateView db!");
            }
        }
    }

    public static SQLiteDatabase b() {
        return f9255a;
    }

    public static boolean c() {
        com.baidu.navisdk.util.db.a aVar;
        try {
            synchronized (c) {
                try {
                    if (f9255a == null && (aVar = b) != null) {
                        f9255a = aVar.getWritableDatabase();
                    }
                    d++;
                } finally {
                }
            }
            return true;
        } catch (SQLiteException | Exception unused) {
            return false;
        }
    }

    public static void a() {
        synchronized (c) {
            try {
                int i = d - 1;
                d = i;
                if (i <= 0) {
                    d = 0;
                    SQLiteDatabase sQLiteDatabase = f9255a;
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                        f9255a = null;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void a(ArrayList<RoutePlanNode> arrayList) {
        Handler handler = g;
        if (handler == null) {
            return;
        }
        Message obtainMessage = handler.obtainMessage();
        obtainMessage.what = 34;
        obtainMessage.obj = arrayList;
        g.sendMessage(obtainMessage);
    }

    public static void a(RoutePlanNode routePlanNode) {
        Handler handler = g;
        if (handler == null) {
            return;
        }
        Message obtainMessage = handler.obtainMessage();
        obtainMessage.what = 35;
        obtainMessage.obj = routePlanNode;
        g.sendMessage(obtainMessage);
    }
}
