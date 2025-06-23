package com.baidu.tts;

import android.database.sqlite.SQLiteDatabase;

/* loaded from: classes8.dex */
public class k1 {

    /* renamed from: a, reason: collision with root package name */
    public SQLiteDatabase f10118a;
    public a b;

    /* loaded from: classes8.dex */
    public interface a {
        boolean a(SQLiteDatabase sQLiteDatabase);
    }

    public k1(SQLiteDatabase sQLiteDatabase, a aVar) {
        this.f10118a = sQLiteDatabase;
        this.b = aVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0022, code lost:
    
        if (r0 != null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x002c, code lost:
    
        r0.endTransaction();
        r3.f10118a.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002a, code lost:
    
        if (r0 == null) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean a() {
        /*
            r3 = this;
            com.baidu.tts.k1$a r0 = r3.b
            r1 = 0
            if (r0 == 0) goto L42
            android.database.sqlite.SQLiteDatabase r0 = r3.f10118a
            if (r0 == 0) goto L42
            r0.beginTransaction()     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L1e
            com.baidu.tts.k1$a r0 = r3.b     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L1e
            android.database.sqlite.SQLiteDatabase r2 = r3.f10118a     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L1e
            boolean r1 = r0.a(r2)     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L1e
            if (r1 == 0) goto L20
            android.database.sqlite.SQLiteDatabase r0 = r3.f10118a     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L1e
            r0.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L1e
            goto L20
        L1c:
            r0 = move-exception
            goto L35
        L1e:
            r0 = move-exception
            goto L25
        L20:
            android.database.sqlite.SQLiteDatabase r0 = r3.f10118a
            if (r0 == 0) goto L42
            goto L2c
        L25:
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L1c
            android.database.sqlite.SQLiteDatabase r0 = r3.f10118a
            if (r0 == 0) goto L42
        L2c:
            r0.endTransaction()
            android.database.sqlite.SQLiteDatabase r0 = r3.f10118a
            r0.close()
            goto L42
        L35:
            android.database.sqlite.SQLiteDatabase r1 = r3.f10118a
            if (r1 == 0) goto L41
            r1.endTransaction()
            android.database.sqlite.SQLiteDatabase r1 = r3.f10118a
            r1.close()
        L41:
            throw r0
        L42:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.tts.k1.a():boolean");
    }
}
