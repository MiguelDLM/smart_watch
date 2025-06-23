package com.tencent.bugly.proguard;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes13.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f26638a = false;
    private static w b;
    private static x c;

    /* loaded from: classes13.dex */
    public class oIX0oI extends Thread {

        /* renamed from: IIXOooo, reason: collision with root package name */
        public String f26640IIXOooo;

        /* renamed from: IXxxXO, reason: collision with root package name */
        public String f26641IXxxXO;

        /* renamed from: O0xOxO, reason: collision with root package name */
        public String f26642O0xOxO;

        /* renamed from: OxI, reason: collision with root package name */
        public String f26644OxI;

        /* renamed from: Oxx0xo, reason: collision with root package name */
        public ContentValues f26645Oxx0xo;

        /* renamed from: OxxIIOOXO, reason: collision with root package name */
        public String[] f26646OxxIIOOXO;

        /* renamed from: X0IIOO, reason: collision with root package name */
        public String f26647X0IIOO;

        /* renamed from: XI0IXoo, reason: collision with root package name */
        public String f26648XI0IXoo;

        /* renamed from: XIxXXX0x0, reason: collision with root package name */
        public String[] f26649XIxXXX0x0;

        /* renamed from: XxX0x0xxx, reason: collision with root package name */
        public String f26651XxX0x0xxx;

        /* renamed from: o00, reason: collision with root package name */
        public String f26652o00;

        /* renamed from: oI0IIXIo, reason: collision with root package name */
        public boolean f26653oI0IIXIo;

        /* renamed from: xXxxox0I, reason: collision with root package name */
        public byte[] f26654xXxxox0I;

        /* renamed from: xoXoI, reason: collision with root package name */
        public String[] f26655xoXoI;

        /* renamed from: xxX, reason: collision with root package name */
        public int f26656xxX;

        /* renamed from: XO, reason: collision with root package name */
        public int f26650XO = 4;

        /* renamed from: Oo, reason: collision with root package name */
        public v f26643Oo = null;

        public oIX0oI() {
        }

        public final void oIX0oI(int i, String str, byte[] bArr) {
            this.f26656xxX = i;
            this.f26651XxX0x0xxx = str;
            this.f26654xXxxox0I = bArr;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            switch (this.f26650XO) {
                case 1:
                    w.this.a(this.f26641IXxxXO, this.f26645Oxx0xo, this.f26643Oo);
                    return;
                case 2:
                    w.this.a(this.f26641IXxxXO, this.f26648XI0IXoo, this.f26649XIxXXX0x0, this.f26643Oo);
                    return;
                case 3:
                    Cursor a2 = w.this.a(this.f26653oI0IIXIo, this.f26641IXxxXO, this.f26646OxxIIOOXO, this.f26640IIXOooo, this.f26655xoXoI, this.f26652o00, this.f26644OxI, this.f26642O0xOxO, this.f26647X0IIOO, this.f26643Oo);
                    if (a2 != null) {
                        a2.close();
                        return;
                    }
                    return;
                case 4:
                    w.this.a(this.f26656xxX, this.f26651XxX0x0xxx, this.f26654xXxxox0I, this.f26643Oo);
                    return;
                case 5:
                    w.this.a(this.f26656xxX, this.f26643Oo);
                    return;
                case 6:
                    w.this.a(this.f26656xxX, this.f26651XxX0x0xxx, this.f26643Oo);
                    return;
                default:
                    return;
            }
        }
    }

    private w(Context context, List<o> list) {
        c = new x(context, list);
    }

    private synchronized boolean b(y yVar) {
        ContentValues d;
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabase = c.getWritableDatabase();
            if (sQLiteDatabase == null || (d = d(yVar)) == null) {
                return false;
            }
            long replace = sQLiteDatabase.replace("t_pf", "_id", d);
            if (replace >= 0) {
                al.c("[Database] insert %s success.", "t_pf");
                yVar.f26658a = replace;
                if (f26638a) {
                    sQLiteDatabase.close();
                }
                return true;
            }
            if (f26638a) {
                sQLiteDatabase.close();
            }
            return false;
        } catch (Throwable th) {
            try {
                if (!al.a(th)) {
                    th.printStackTrace();
                }
                if (f26638a && sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
                return false;
            } finally {
                if (f26638a && sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
            }
        }
    }

    private static ContentValues c(y yVar) {
        if (yVar == null) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            long j = yVar.f26658a;
            if (j > 0) {
                contentValues.put("_id", Long.valueOf(j));
            }
            contentValues.put("_tp", Integer.valueOf(yVar.b));
            contentValues.put("_pc", yVar.c);
            contentValues.put("_th", yVar.d);
            contentValues.put("_tm", Long.valueOf(yVar.e));
            byte[] bArr = yVar.g;
            if (bArr != null) {
                contentValues.put("_dt", bArr);
            }
            return contentValues;
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    private static ContentValues d(y yVar) {
        if (yVar != null && !ap.b(yVar.f)) {
            try {
                ContentValues contentValues = new ContentValues();
                long j = yVar.f26658a;
                if (j > 0) {
                    contentValues.put("_id", Long.valueOf(j));
                }
                contentValues.put("_tp", yVar.f);
                contentValues.put("_tm", Long.valueOf(yVar.e));
                byte[] bArr = yVar.g;
                if (bArr != null) {
                    contentValues.put("_dt", bArr);
                }
                return contentValues;
            } catch (Throwable th) {
                if (!al.a(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    public static synchronized w a(Context context, List<o> list) {
        w wVar;
        synchronized (w.class) {
            try {
                if (b == null) {
                    b = new w(context, list);
                }
                wVar = b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return wVar;
    }

    public static synchronized w a() {
        w wVar;
        synchronized (w.class) {
            wVar = b;
        }
        return wVar;
    }

    public final Cursor a(String str, String[] strArr, String str2) {
        return a(str, strArr, str2, (String) null, (String) null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x00af, code lost:
    
        if (r2 != null) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x00b1, code lost:
    
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00cd, code lost:
    
        if (r2 != null) goto L43;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private synchronized java.util.List<com.tencent.bugly.proguard.y> c(int r13) {
        /*
            Method dump skipped, instructions count: 227
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.w.c(int):java.util.List");
    }

    public final Cursor a(String str, String[] strArr, String str2, String str3, String str4) {
        return a(false, str, strArr, str2, null, null, null, str3, str4, null);
    }

    public final int a(String str, String str2) {
        return a(str, str2, (String[]) null, (v) null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x004e, code lost:
    
        if (0 != 0) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized long a(java.lang.String r9, android.content.ContentValues r10, com.tencent.bugly.proguard.v r11) {
        /*
            r8 = this;
            r11 = 0
            r0 = 1
            monitor-enter(r8)
            r1 = -1
            r3 = 0
            com.tencent.bugly.proguard.x r4 = com.tencent.bugly.proguard.w.c     // Catch: java.lang.Throwable -> L26
            android.database.sqlite.SQLiteDatabase r3 = r4.getWritableDatabase()     // Catch: java.lang.Throwable -> L26
            if (r3 == 0) goto L32
            if (r10 == 0) goto L32
            java.lang.String r4 = "_id"
            long r4 = r3.replace(r9, r4, r10)     // Catch: java.lang.Throwable -> L26
            r6 = 0
            int r10 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r10 < 0) goto L28
            java.lang.String r10 = "[Database] insert %s success."
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> L26
            r0[r11] = r9     // Catch: java.lang.Throwable -> L26
            com.tencent.bugly.proguard.al.c(r10, r0)     // Catch: java.lang.Throwable -> L26
            goto L31
        L26:
            r9 = move-exception
            goto L3e
        L28:
            java.lang.String r10 = "[Database] replace %s error."
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> L26
            r0[r11] = r9     // Catch: java.lang.Throwable -> L26
            com.tencent.bugly.proguard.al.d(r10, r0)     // Catch: java.lang.Throwable -> L26
        L31:
            r1 = r4
        L32:
            boolean r9 = com.tencent.bugly.proguard.w.f26638a     // Catch: java.lang.Throwable -> L3c
            if (r9 == 0) goto L51
            if (r3 == 0) goto L51
        L38:
            r3.close()     // Catch: java.lang.Throwable -> L3c
            goto L51
        L3c:
            r9 = move-exception
            goto L5d
        L3e:
            boolean r10 = com.tencent.bugly.proguard.al.a(r9)     // Catch: java.lang.Throwable -> L48
            if (r10 != 0) goto L4a
            r9.printStackTrace()     // Catch: java.lang.Throwable -> L48
            goto L4a
        L48:
            r9 = move-exception
            goto L53
        L4a:
            boolean r9 = com.tencent.bugly.proguard.w.f26638a     // Catch: java.lang.Throwable -> L3c
            if (r9 == 0) goto L51
            if (r3 == 0) goto L51
            goto L38
        L51:
            monitor-exit(r8)
            return r1
        L53:
            boolean r10 = com.tencent.bugly.proguard.w.f26638a     // Catch: java.lang.Throwable -> L3c
            if (r10 == 0) goto L5c
            if (r3 == 0) goto L5c
            r3.close()     // Catch: java.lang.Throwable -> L3c
        L5c:
            throw r9     // Catch: java.lang.Throwable -> L3c
        L5d:
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L3c
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.w.a(java.lang.String, android.content.ContentValues, com.tencent.bugly.proguard.v):long");
    }

    public final synchronized void b(int i) {
        String concat;
        SQLiteDatabase writableDatabase = c.getWritableDatabase();
        if (writableDatabase != null) {
            if (i >= 0) {
                try {
                    concat = "_tp = ".concat(String.valueOf(i));
                } catch (Throwable th) {
                    try {
                        if (!al.a(th)) {
                            th.printStackTrace();
                        }
                        if (f26638a) {
                            writableDatabase.close();
                            return;
                        }
                    } finally {
                        if (f26638a) {
                            writableDatabase.close();
                        }
                    }
                }
            } else {
                concat = null;
            }
            al.c("[Database] deleted %s data %d", "t_lr", Integer.valueOf(writableDatabase.delete("t_lr", concat, null)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized Cursor a(boolean z, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6, v vVar) {
        Cursor cursor;
        cursor = null;
        try {
            SQLiteDatabase writableDatabase = c.getWritableDatabase();
            if (writableDatabase != null) {
                cursor = writableDatabase.query(z, str, strArr, str2, strArr2, str3, str4, str5, str6);
            }
        } catch (Throwable th) {
            try {
                if (!al.a(th)) {
                    th.printStackTrace();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return cursor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x002e, code lost:
    
        if (r0 != null) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized int a(java.lang.String r3, java.lang.String r4, java.lang.String[] r5, com.tencent.bugly.proguard.v r6) {
        /*
            r2 = this;
            monitor-enter(r2)
            r6 = 0
            r0 = 0
            com.tencent.bugly.proguard.x r1 = com.tencent.bugly.proguard.w.c     // Catch: java.lang.Throwable -> L10
            android.database.sqlite.SQLiteDatabase r0 = r1.getWritableDatabase()     // Catch: java.lang.Throwable -> L10
            if (r0 == 0) goto L12
            int r6 = r0.delete(r3, r4, r5)     // Catch: java.lang.Throwable -> L10
            goto L12
        L10:
            r3 = move-exception
            goto L1e
        L12:
            boolean r3 = com.tencent.bugly.proguard.w.f26638a     // Catch: java.lang.Throwable -> L1c
            if (r3 == 0) goto L31
            if (r0 == 0) goto L31
        L18:
            r0.close()     // Catch: java.lang.Throwable -> L1c
            goto L31
        L1c:
            r3 = move-exception
            goto L3d
        L1e:
            boolean r4 = com.tencent.bugly.proguard.al.a(r3)     // Catch: java.lang.Throwable -> L28
            if (r4 != 0) goto L2a
            r3.printStackTrace()     // Catch: java.lang.Throwable -> L28
            goto L2a
        L28:
            r3 = move-exception
            goto L33
        L2a:
            boolean r3 = com.tencent.bugly.proguard.w.f26638a     // Catch: java.lang.Throwable -> L1c
            if (r3 == 0) goto L31
            if (r0 == 0) goto L31
            goto L18
        L31:
            monitor-exit(r2)
            return r6
        L33:
            boolean r4 = com.tencent.bugly.proguard.w.f26638a     // Catch: java.lang.Throwable -> L1c
            if (r4 == 0) goto L3c
            if (r0 == 0) goto L3c
            r0.close()     // Catch: java.lang.Throwable -> L1c
        L3c:
            throw r3     // Catch: java.lang.Throwable -> L1c
        L3d:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L1c
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.w.a(java.lang.String, java.lang.String, java.lang.String[], com.tencent.bugly.proguard.v):int");
    }

    private static y b(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            y yVar = new y();
            yVar.f26658a = cursor.getLong(cursor.getColumnIndex("_id"));
            yVar.e = cursor.getLong(cursor.getColumnIndex("_tm"));
            yVar.f = cursor.getString(cursor.getColumnIndex("_tp"));
            yVar.g = cursor.getBlob(cursor.getColumnIndex("_dt"));
            return yVar;
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public final boolean a(int i, String str, byte[] bArr, boolean z) {
        if (!z) {
            oIX0oI oix0oi = new oIX0oI();
            oix0oi.oIX0oI(i, str, bArr);
            ak.a().a(oix0oi);
            return true;
        }
        return a(i, str, bArr, (v) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i, String str, byte[] bArr, v vVar) {
        try {
            y yVar = new y();
            yVar.f26658a = i;
            yVar.f = str;
            yVar.e = System.currentTimeMillis();
            yVar.g = bArr;
            return b(yVar);
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
            return false;
        }
    }

    public final Map<String, byte[]> a(int i, v vVar) {
        HashMap hashMap = null;
        try {
            List<y> c2 = c(i);
            if (c2 == null) {
                return null;
            }
            HashMap hashMap2 = new HashMap();
            try {
                for (y yVar : c2) {
                    byte[] bArr = yVar.g;
                    if (bArr != null) {
                        hashMap2.put(yVar.f, bArr);
                    }
                }
                return hashMap2;
            } catch (Throwable th) {
                th = th;
                hashMap = hashMap2;
                if (al.a(th)) {
                    return hashMap;
                }
                th.printStackTrace();
                return hashMap;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final synchronized boolean a(y yVar) {
        ContentValues c2;
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabase = c.getWritableDatabase();
            if (sQLiteDatabase == null || (c2 = c(yVar)) == null) {
                return false;
            }
            long replace = sQLiteDatabase.replace("t_lr", "_id", c2);
            if (replace >= 0) {
                al.c("[Database] insert %s success.", "t_lr");
                yVar.f26658a = replace;
                if (f26638a) {
                    sQLiteDatabase.close();
                }
                return true;
            }
            if (f26638a) {
                sQLiteDatabase.close();
            }
            return false;
        } catch (Throwable th) {
            try {
                if (!al.a(th)) {
                    th.printStackTrace();
                }
                if (f26638a && sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
                return false;
            } finally {
                if (f26638a && sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
            }
        }
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00b5 A[Catch: all -> 0x00b9, TRY_LEAVE, TryCatch #2 {all -> 0x00b9, blocks: (B:48:0x00af, B:50:0x00b5), top: B:47:0x00af, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00bd A[Catch: all -> 0x0033, TRY_ENTER, TryCatch #1 {all -> 0x0033, blocks: (B:4:0x0002, B:12:0x002f, B:13:0x0036, B:15:0x003a, B:40:0x00a3, B:42:0x00aa, B:53:0x00bd, B:54:0x00c0, B:56:0x00c4, B:59:0x00ca, B:60:0x00cd, B:62:0x00d1, B:63:0x00d4, B:48:0x00af, B:50:0x00b5), top: B:3:0x0002, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00c4 A[Catch: all -> 0x0033, TryCatch #1 {all -> 0x0033, blocks: (B:4:0x0002, B:12:0x002f, B:13:0x0036, B:15:0x003a, B:40:0x00a3, B:42:0x00aa, B:53:0x00bd, B:54:0x00c0, B:56:0x00c4, B:59:0x00ca, B:60:0x00cd, B:62:0x00d1, B:63:0x00d4, B:48:0x00af, B:50:0x00b5), top: B:3:0x0002, inners: #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized java.util.List<com.tencent.bugly.proguard.y> a(int r13) {
        /*
            Method dump skipped, instructions count: 217
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.w.a(int):java.util.List");
    }

    public final synchronized void a(List<y> list) {
        if (list != null) {
            try {
                if (list.size() != 0) {
                    SQLiteDatabase writableDatabase = c.getWritableDatabase();
                    if (writableDatabase != null) {
                        StringBuilder sb = new StringBuilder();
                        for (y yVar : list) {
                            sb.append(" or _id = ");
                            sb.append(yVar.f26658a);
                        }
                        String sb2 = sb.toString();
                        if (sb2.length() > 0) {
                            sb2 = sb2.substring(4);
                        }
                        sb.setLength(0);
                        try {
                            al.c("[Database] deleted %s data %d", "t_lr", Integer.valueOf(writableDatabase.delete("t_lr", sb2, null)));
                        } catch (Throwable th) {
                            try {
                                if (!al.a(th)) {
                                    th.printStackTrace();
                                }
                                if (f26638a) {
                                    writableDatabase.close();
                                }
                            } finally {
                                if (f26638a) {
                                    writableDatabase.close();
                                }
                            }
                        }
                    }
                }
            } finally {
            }
        }
    }

    private static y a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            y yVar = new y();
            yVar.f26658a = cursor.getLong(cursor.getColumnIndex("_id"));
            yVar.b = cursor.getInt(cursor.getColumnIndex("_tp"));
            yVar.c = cursor.getString(cursor.getColumnIndex("_pc"));
            yVar.d = cursor.getString(cursor.getColumnIndex("_th"));
            yVar.e = cursor.getLong(cursor.getColumnIndex("_tm"));
            yVar.g = cursor.getBlob(cursor.getColumnIndex("_dt"));
            return yVar;
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean a(int i, String str, v vVar) {
        String str2;
        boolean z = false;
        synchronized (this) {
            SQLiteDatabase sQLiteDatabase = null;
            try {
                SQLiteDatabase writableDatabase = c.getWritableDatabase();
                if (writableDatabase != null) {
                    try {
                        if (ap.b(str)) {
                            str2 = "_id = ".concat(String.valueOf(i));
                        } else {
                            str2 = "_id = " + i + " and _tp = \"" + str + "\"";
                        }
                        int delete = writableDatabase.delete("t_pf", str2, null);
                        al.c("[Database] deleted %s data %d", "t_pf", Integer.valueOf(delete));
                        z = delete > 0;
                    } catch (Throwable th) {
                        th = th;
                        sQLiteDatabase = writableDatabase;
                        try {
                            if (!al.a(th)) {
                                th.printStackTrace();
                            }
                            return z;
                        } finally {
                            if (f26638a && sQLiteDatabase != null) {
                                sQLiteDatabase.close();
                            }
                        }
                    }
                }
                if (f26638a && writableDatabase != null) {
                    writableDatabase.close();
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return z;
    }
}
