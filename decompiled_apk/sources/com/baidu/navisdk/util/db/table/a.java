package com.baidu.navisdk.util.db.table;

import android.content.ContentValues;
import android.database.Cursor;
import com.baidu.navisdk.util.db.object.a;
import java.util.ArrayList;

/* loaded from: classes8.dex */
public abstract class a<T extends com.baidu.navisdk.util.db.object.a> {
    private String b = d();

    /* renamed from: a, reason: collision with root package name */
    private Object f9260a = e();
    private String c = c();
    private String d = this.c + "=?";

    public abstract ContentValues a(T t);

    public abstract T a(Cursor cursor);

    public void a(int i) {
        synchronized (this.f9260a) {
            try {
                if (com.baidu.navisdk.util.db.b.c()) {
                    com.baidu.navisdk.util.db.b.b().delete(this.b, this.d, new String[]{i + ""});
                    com.baidu.navisdk.util.db.b.a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public int b(T t) {
        synchronized (this.f9260a) {
            if (t != null) {
                try {
                    if (com.baidu.navisdk.util.db.b.c()) {
                        t.setId((int) com.baidu.navisdk.util.db.b.b().insert(this.b, null, a((a<T>) t)));
                        com.baidu.navisdk.util.db.b.a();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return -1;
    }

    public abstract String c();

    public abstract String d();

    public abstract Object e();

    public void a(String str, String[] strArr) {
        synchronized (this.f9260a) {
            try {
                if (com.baidu.navisdk.util.db.b.c()) {
                    com.baidu.navisdk.util.db.b.b().delete(this.b, str, strArr);
                    com.baidu.navisdk.util.db.b.a();
                }
            } catch (Exception unused) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:9:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.ArrayList<T> b(android.database.Cursor r5) {
        /*
            r4 = this;
            r0 = 0
            if (r5 == 0) goto L2f
            boolean r1 = r5.moveToFirst()     // Catch: java.lang.Exception -> L27
            if (r1 == 0) goto L2f
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch: java.lang.Exception -> L27
            int r2 = r5.getCount()     // Catch: java.lang.Exception -> L27
            r1.<init>(r2)     // Catch: java.lang.Exception -> L27
        L12:
            boolean r0 = r5.isAfterLast()     // Catch: java.lang.Exception -> L23
            if (r0 != 0) goto L25
            com.baidu.navisdk.util.db.object.a r0 = r4.a(r5)     // Catch: java.lang.Exception -> L23
            r1.add(r0)     // Catch: java.lang.Exception -> L23
            r5.moveToNext()     // Catch: java.lang.Exception -> L23
            goto L12
        L23:
            r0 = move-exception
            goto L2b
        L25:
            r0 = r1
            goto L2f
        L27:
            r1 = move-exception
            r3 = r1
            r1 = r0
            r0 = r3
        L2b:
            r0.printStackTrace()
            goto L25
        L2f:
            if (r5 == 0) goto L34
            r5.close()
        L34:
            if (r0 != 0) goto L3c
            java.util.ArrayList r0 = new java.util.ArrayList
            r5 = 0
            r0.<init>(r5)
        L3c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.util.db.table.a.b(android.database.Cursor):java.util.ArrayList");
    }

    public ArrayList<T> a(String str, String[] strArr, String str2, String str3) {
        synchronized (this.f9260a) {
            try {
                if (!com.baidu.navisdk.util.db.b.c()) {
                    return null;
                }
                ArrayList<T> b = b(com.baidu.navisdk.util.db.b.b().query(this.b, null, str, strArr, null, null, str2 + " " + str3));
                com.baidu.navisdk.util.db.b.a();
                return b;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void b() {
        com.baidu.navisdk.util.db.b.a();
    }

    public void a() {
        com.baidu.navisdk.util.db.b.c();
    }
}
