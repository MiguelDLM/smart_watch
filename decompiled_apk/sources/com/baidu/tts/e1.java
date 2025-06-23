package com.baidu.tts;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: classes8.dex */
public class e1 {

    /* renamed from: a, reason: collision with root package name */
    public m3 f10078a;
    public f1 b;
    public ReadWriteLock c;
    public Lock d;
    public Lock e;

    public e1(m3 m3Var) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.c = reentrantReadWriteLock;
        this.d = reentrantReadWriteLock.writeLock();
        this.e = this.c.readLock();
        this.f10078a = m3Var;
        this.b = new f1(this.f10078a.b());
    }

    public void a(String str, int i) {
        this.d.lock();
        try {
            String[] strArr = {str, String.valueOf(i)};
            SQLiteDatabase writableDatabase = this.b.getWritableDatabase();
            try {
                writableDatabase.execSQL("replace into fsFileInfo (absPath,state) values (?, ?)", strArr);
            } finally {
                writableDatabase.close();
            }
        } finally {
            this.d.unlock();
        }
    }

    public Map<String, String> b(String str, String[] strArr) {
        this.e.lock();
        try {
            SQLiteDatabase readableDatabase = this.b.getReadableDatabase();
            HashMap hashMap = null;
            try {
                try {
                    Cursor rawQuery = readableDatabase.rawQuery(str, strArr);
                    if (rawQuery != null) {
                        if (rawQuery.moveToFirst()) {
                            HashMap hashMap2 = new HashMap();
                            try {
                                for (String str2 : rawQuery.getColumnNames()) {
                                    hashMap2.put(str2, rawQuery.getString(rawQuery.getColumnIndex(str2)));
                                }
                                hashMap = hashMap2;
                            } catch (Exception e) {
                                e = e;
                                hashMap = hashMap2;
                                e.printStackTrace();
                            }
                        }
                        rawQuery.close();
                    }
                } catch (Exception e2) {
                    e = e2;
                }
                return hashMap;
            } finally {
                if (readableDatabase != null) {
                    readableDatabase.close();
                }
            }
        } finally {
            this.e.unlock();
        }
    }

    public Map<String, String> a(String str) {
        return b("select * from speechModel where id=?", new String[]{str});
    }

    public void a(String str, String str2, String str3) {
        SQLiteDatabase writableDatabase = this.b.getWritableDatabase();
        if (writableDatabase != null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("alter table ");
            stringBuffer.append(str);
            stringBuffer.append(" add ");
            stringBuffer.append(str2);
            stringBuffer.append(" ");
            stringBuffer.append(str3);
            writableDatabase.execSQL(stringBuffer.toString());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x003a, code lost:
    
        if (r2.isClosed() == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0051, code lost:
    
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004f, code lost:
    
        if (r2.isClosed() == false) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean a(java.lang.String r7, java.lang.String r8) {
        /*
            r6 = this;
            java.lang.String r0 = "%"
            r1 = 0
            r2 = 0
            com.baidu.tts.f1 r3 = r6.b     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L32
            android.database.sqlite.SQLiteDatabase r3 = r3.getWritableDatabase()     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L32
            java.lang.String r4 = "select * from sqlite_master where name = ? and sql like ?"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L32
            r5.<init>()     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L32
            r5.append(r0)     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L32
            r5.append(r8)     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L32
            r5.append(r0)     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L32
            java.lang.String r8 = r5.toString()     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L32
            java.lang.String[] r7 = new java.lang.String[]{r7, r8}     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L32
            android.database.Cursor r2 = r3.rawQuery(r4, r7)     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L32
            if (r2 == 0) goto L34
            boolean r7 = r2.moveToFirst()     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L32
            if (r7 == 0) goto L34
            r1 = 1
            goto L34
        L30:
            r7 = move-exception
            goto L3d
        L32:
            goto L49
        L34:
            if (r2 == 0) goto L54
            boolean r7 = r2.isClosed()
            if (r7 != 0) goto L54
            goto L51
        L3d:
            if (r2 == 0) goto L48
            boolean r8 = r2.isClosed()
            if (r8 != 0) goto L48
            r2.close()
        L48:
            throw r7
        L49:
            if (r2 == 0) goto L54
            boolean r7 = r2.isClosed()
            if (r7 != 0) goto L54
        L51:
            r2.close()
        L54:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.tts.e1.a(java.lang.String, java.lang.String):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0050, code lost:
    
        if (r0 == null) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.List<java.util.Map<java.lang.String, java.lang.String>> a(java.lang.String r8, java.lang.String[] r9) {
        /*
            r7 = this;
            java.util.concurrent.locks.Lock r0 = r7.e
            r0.lock()
            r0 = 0
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L4b
            r1.<init>()     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L4b
            com.baidu.tts.f1 r2 = r7.b     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3c
            android.database.sqlite.SQLiteDatabase r0 = r2.getReadableDatabase()     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3c
            android.database.Cursor r8 = r0.rawQuery(r8, r9)     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3c
            if (r8 == 0) goto L52
            boolean r9 = r8.moveToFirst()     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3c
            if (r9 == 0) goto L47
            java.lang.String[] r9 = r8.getColumnNames()     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3c
        L21:
            java.util.HashMap r2 = new java.util.HashMap     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3c
            r2.<init>()     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3c
            int r3 = r9.length     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3c
            r4 = 0
        L28:
            if (r4 >= r3) goto L3e
            r5 = r9[r4]     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3c
            int r6 = r8.getColumnIndex(r5)     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3c
            java.lang.String r6 = r8.getString(r6)     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3c
            r2.put(r5, r6)     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3c
            int r4 = r4 + 1
            goto L28
        L3a:
            r8 = move-exception
            goto L5e
        L3c:
            r8 = move-exception
            goto L4d
        L3e:
            r1.add(r2)     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3c
            boolean r2 = r8.moveToNext()     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3c
            if (r2 != 0) goto L21
        L47:
            r8.close()     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3c
            goto L52
        L4b:
            r8 = move-exception
            r1 = r0
        L4d:
            r8.printStackTrace()     // Catch: java.lang.Throwable -> L3a
            if (r0 == 0) goto L58
        L52:
            r0.close()     // Catch: java.lang.Throwable -> L56
            goto L58
        L56:
            r8 = move-exception
            goto L64
        L58:
            java.util.concurrent.locks.Lock r8 = r7.e
            r8.unlock()
            return r1
        L5e:
            if (r0 == 0) goto L63
            r0.close()     // Catch: java.lang.Throwable -> L56
        L63:
            throw r8     // Catch: java.lang.Throwable -> L56
        L64:
            java.util.concurrent.locks.Lock r9 = r7.e
            r9.unlock()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.tts.e1.a(java.lang.String, java.lang.String[]):java.util.List");
    }
}
