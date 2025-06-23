package com.baidu.mshield.x0.d;

import XXO0.oIX0oI;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.baidu.mshield.x0.b.d;

/* loaded from: classes7.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static a f6412a;
    public C0147a d;
    public SQLiteDatabase e;
    public String b = "msvolcano.db";
    public int c = 1;
    public String f = "msal";
    public String g = "CREATE TABLE IF NOT EXISTS " + this.f + oIX0oI.I0Io.f4096II0xO0 + "a TEXT PRIMARY KEY ON CONFLICT ABORT,b INTEGER,c TEXT)";

    /* renamed from: com.baidu.mshield.x0.d.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0147a extends SQLiteOpenHelper {
        public C0147a(Context context) {
            super(context, a.this.b, (SQLiteDatabase.CursorFactory) null, a.this.c);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL(a.this.g);
            } catch (Throwable th) {
                d.a(th);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    public a(Context context) {
        try {
            context.getApplicationContext();
            C0147a c0147a = new C0147a(context.getApplicationContext());
            this.d = c0147a;
            this.e = c0147a.getWritableDatabase();
        } catch (Throwable th) {
            d.a(th);
        }
    }

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (a.class) {
            try {
                if (f6412a == null) {
                    f6412a = new a(context);
                }
                aVar = f6412a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return aVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0029, code lost:
    
        if (r9.isClosed() == false) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean b(java.lang.String r11) {
        /*
            r10 = this;
            android.database.sqlite.SQLiteDatabase r0 = r10.e
            r8 = 0
            if (r0 != 0) goto L6
            return r8
        L6:
            r9 = 0
            java.lang.String r1 = r10.f     // Catch: java.lang.Throwable -> L21
            java.lang.String r3 = "a=?"
            java.lang.String[] r4 = new java.lang.String[]{r11}     // Catch: java.lang.Throwable -> L21
            r6 = 0
            r7 = 0
            r2 = 0
            r5 = 0
            android.database.Cursor r9 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L21
            if (r9 == 0) goto L23
            int r11 = r9.getCount()     // Catch: java.lang.Throwable -> L21
            if (r11 <= 0) goto L23
            r8 = 1
            goto L23
        L21:
            r11 = move-exception
            goto L2c
        L23:
            if (r9 == 0) goto L3a
            boolean r11 = r9.isClosed()
            if (r11 != 0) goto L3a
            goto L37
        L2c:
            com.baidu.mshield.x0.b.d.a(r11)     // Catch: java.lang.Throwable -> L3b
            if (r9 == 0) goto L3a
            boolean r11 = r9.isClosed()
            if (r11 != 0) goto L3a
        L37:
            r9.close()
        L3a:
            return r8
        L3b:
            r11 = move-exception
            if (r9 == 0) goto L47
            boolean r0 = r9.isClosed()
            if (r0 != 0) goto L47
            r9.close()
        L47:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mshield.x0.d.a.b(java.lang.String):boolean");
    }

    public int a(com.baidu.mshield.x0.b.a aVar) {
        int i = 0;
        if (aVar != null && this.e != null) {
            try {
                String b = d.b(aVar.f6400a);
                if (TextUtils.isEmpty(b)) {
                    return 0;
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("a", b);
                contentValues.put("b", Integer.valueOf(aVar.b));
                contentValues.put("c", Long.valueOf(aVar.c));
                if (b(b)) {
                    i = this.e.update(this.f, contentValues, "a= ?", new String[]{b});
                } else {
                    i = (int) this.e.insert(this.f, null, contentValues);
                }
            } catch (Throwable th) {
                d.a(th);
            }
        }
        return i;
    }

    public com.baidu.mshield.x0.b.a a(String str) {
        com.baidu.mshield.x0.b.a aVar;
        Throwable th;
        Cursor cursor;
        String b;
        boolean isClosed;
        com.baidu.mshield.x0.b.a aVar2 = null;
        if (this.e == null) {
            return null;
        }
        try {
            b = d.b(str);
        } catch (Throwable th2) {
            aVar = null;
            th = th2;
            cursor = null;
        }
        if (TextUtils.isEmpty(b)) {
            return null;
        }
        cursor = this.e.query(this.f, null, "a=?", new String[]{b}, null, null, null);
        if (cursor != null) {
            try {
                if (cursor.getCount() > 0) {
                    while (cursor.moveToNext()) {
                        aVar = new com.baidu.mshield.x0.b.a();
                        try {
                            aVar.f6400a = d.a(cursor.getString(cursor.getColumnIndex("a")));
                            aVar.b = cursor.getInt(cursor.getColumnIndex("b"));
                            aVar.c = Long.parseLong(cursor.getString(cursor.getColumnIndex("c")));
                            aVar2 = aVar;
                        } catch (Throwable th3) {
                            th = th3;
                            try {
                                d.a(th);
                                if (cursor == null || cursor.isClosed()) {
                                    return aVar;
                                }
                                aVar2 = aVar;
                                return aVar2;
                            } finally {
                                if (cursor != null && !cursor.isClosed()) {
                                    cursor.close();
                                }
                            }
                        }
                    }
                }
            } catch (Throwable th4) {
                com.baidu.mshield.x0.b.a aVar3 = aVar2;
                th = th4;
                aVar = aVar3;
            }
        }
        if (cursor == null) {
            return aVar2;
        }
        if (isClosed) {
            return aVar2;
        }
        return aVar2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0065, code lost:
    
        if (r1.isClosed() == false) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.List<com.baidu.mshield.x0.b.a> a() {
        /*
            r10 = this;
            android.database.sqlite.SQLiteDatabase r0 = r10.e
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            android.database.sqlite.SQLiteDatabase r2 = r10.e     // Catch: java.lang.Throwable -> L5d
            java.lang.String r3 = r10.f     // Catch: java.lang.Throwable -> L5d
            java.lang.String r9 = "b DESC"
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r1 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L5d
            if (r1 == 0) goto L5f
            int r2 = r1.getCount()     // Catch: java.lang.Throwable -> L5d
            if (r2 <= 0) goto L5f
        L22:
            boolean r2 = r1.moveToNext()     // Catch: java.lang.Throwable -> L5d
            if (r2 == 0) goto L5f
            com.baidu.mshield.x0.b.a r2 = new com.baidu.mshield.x0.b.a     // Catch: java.lang.Throwable -> L5d
            r2.<init>()     // Catch: java.lang.Throwable -> L5d
            java.lang.String r3 = "a"
            int r3 = r1.getColumnIndex(r3)     // Catch: java.lang.Throwable -> L5d
            java.lang.String r3 = r1.getString(r3)     // Catch: java.lang.Throwable -> L5d
            java.lang.String r3 = com.baidu.mshield.x0.b.d.a(r3)     // Catch: java.lang.Throwable -> L5d
            r2.f6400a = r3     // Catch: java.lang.Throwable -> L5d
            java.lang.String r3 = "b"
            int r3 = r1.getColumnIndex(r3)     // Catch: java.lang.Throwable -> L5d
            int r3 = r1.getInt(r3)     // Catch: java.lang.Throwable -> L5d
            r2.b = r3     // Catch: java.lang.Throwable -> L5d
            java.lang.String r3 = "c"
            int r3 = r1.getColumnIndex(r3)     // Catch: java.lang.Throwable -> L5d
            java.lang.String r3 = r1.getString(r3)     // Catch: java.lang.Throwable -> L5d
            long r3 = java.lang.Long.parseLong(r3)     // Catch: java.lang.Throwable -> L5d
            r2.c = r3     // Catch: java.lang.Throwable -> L5d
            r0.add(r2)     // Catch: java.lang.Throwable -> L5d
            goto L22
        L5d:
            r2 = move-exception
            goto L68
        L5f:
            if (r1 == 0) goto L76
            boolean r2 = r1.isClosed()
            if (r2 != 0) goto L76
            goto L73
        L68:
            com.baidu.mshield.x0.b.d.a(r2)     // Catch: java.lang.Throwable -> L77
            if (r1 == 0) goto L76
            boolean r2 = r1.isClosed()
            if (r2 != 0) goto L76
        L73:
            r1.close()
        L76:
            return r0
        L77:
            r0 = move-exception
            if (r1 == 0) goto L83
            boolean r2 = r1.isClosed()
            if (r2 != 0) goto L83
            r1.close()
        L83:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mshield.x0.d.a.a():java.util.List");
    }
}
