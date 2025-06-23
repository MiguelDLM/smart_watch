package com.jd.ad.sdk.jad_kx;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.jd.ad.sdk.fdt.utils.ANEProxy;
import com.jd.ad.sdk.logger.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes10.dex */
public class jad_an extends com.jd.ad.sdk.jad_qd.jad_an {
    public static jad_an jad_cp;
    public static List<String> jad_dq = new ArrayList();
    public List<String> jad_bo;

    /* renamed from: com.jd.ad.sdk.jad_kx.jad_an$jad_an, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class RunnableC0695jad_an implements Runnable {
        public RunnableC0695jad_an() {
        }

        @Override // java.lang.Runnable
        public void run() {
            jad_an jad_anVar = jad_an.this;
            List<String> list = jad_an.jad_dq;
            synchronized (jad_anVar) {
                jad_anVar.jad_an(list);
            }
        }
    }

    public jad_an(Context context, String str, int i) {
        super(context, str, i);
        this.jad_bo = new ArrayList();
    }

    public static synchronized jad_an jad_dq() {
        jad_an jad_anVar;
        synchronized (jad_an.class) {
            try {
                if (jad_cp == null) {
                    jad_cp = new jad_an(com.jd.ad.sdk.jad_do.jad_bo.jad_an(), "jaddb.db", 2);
                }
                jad_anVar = jad_cp;
            } catch (Throwable th) {
                throw th;
            }
        }
        return jad_anVar;
    }

    public synchronized void jad_an(jad_cp jad_cpVar) {
        try {
            getWritableDatabase();
        } finally {
        }
        if (jad_bo()) {
            ContentValues jad_bo = jad_bo(jad_cpVar);
            int i = jad_cpVar.jad_an;
            if (i > 0) {
                this.jad_an.update("preloadAd", jad_bo, "_id=?", new String[]{String.valueOf(i)});
            } else {
                this.jad_an.insert("preloadAd", null, jad_bo);
            }
        }
    }

    public final ContentValues jad_bo(jad_cp jad_cpVar) {
        ContentValues contentValues;
        try {
            contentValues = new ContentValues();
        } catch (Exception e) {
            e = e;
            contentValues = null;
        }
        try {
            contentValues.put("appIdSlotId", jad_cpVar.jad_cp);
            contentValues.put("rId", jad_cpVar.jad_bo);
            contentValues.put("preloadAdJson", ANEProxy.ja(jad_cpVar.jad_dq));
            contentValues.put("preloadAdCacheTimeStamp", jad_cpVar.jad_er);
        } catch (Exception e2) {
            e = e2;
            Logger.w("Exception while add preload ad data: ", e.getMessage());
            return contentValues;
        }
        return contentValues;
    }

    public void jad_cp() {
        try {
            getWritableDatabase();
            if (!jad_bo()) {
                return;
            }
            this.jad_an.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (_id INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT, %s TEXT, %s TEXT, %s TEXT)", "preloadAd", "appIdSlotId", "rId", "preloadAdJson", "preloadAdCacheTimeStamp"));
        } catch (Exception e) {
            com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.CACHE_PRELOAD_AD_CREATE_DB_TABLE_ERROR;
            com.jd.ad.sdk.jad_vi.jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(e.getMessage()));
        }
    }

    public synchronized Cursor jad_er() {
        try {
            getReadableDatabase();
            if (!jad_bo()) {
                return null;
            }
            return this.jad_an.query("preloadAd", null, null, null, null, null, "preloadAdCacheTimeStamp ASC");
        } catch (Throwable th) {
            try {
                com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.CACHE_PRELOAD_AD_QUERY_DB_TABLE_ERROR;
                com.jd.ad.sdk.jad_vi.jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(th.getMessage()));
                return null;
            } finally {
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        this.jad_an = sQLiteDatabase;
        try {
            sQLiteDatabase.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (_id INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT, %s TEXT,%s TEXT, %s TEXT)", "preloadAd", "appIdSlotId", "rId", "preloadAdJson", "preloadAdCacheTimeStamp"));
        } catch (Exception e) {
            com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.CACHE_PRELOAD_AD_CREATE_DB_TABLE_ERROR;
            com.jd.ad.sdk.jad_vi.jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(e.getMessage()));
        }
        this.jad_an = sQLiteDatabase;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS preloadAd");
        onCreate(sQLiteDatabase);
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x00a8, code lost:
    
        if (r1.isClosed() == false) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized java.util.List<com.jd.ad.sdk.jad_kx.jad_cp> jad_an(java.lang.String r13) {
        /*
            r12 = this;
            monitor-enter(r12)
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch: java.lang.Throwable -> Lab
            r0.<init>()     // Catch: java.lang.Throwable -> Lab
            r1 = 0
            r12.getReadableDatabase()     // Catch: java.lang.Throwable -> L8c
            boolean r2 = r12.jad_bo()     // Catch: java.lang.Throwable -> L8c
            if (r2 != 0) goto L12
            monitor-exit(r12)
            return r0
        L12:
            java.lang.String r6 = "appIdSlotId =?"
            java.lang.String r2 = java.lang.String.valueOf(r13)     // Catch: java.lang.Throwable -> L8c
            java.lang.String[] r7 = new java.lang.String[]{r2}     // Catch: java.lang.Throwable -> L8c
            java.lang.String r10 = "preloadAdCacheTimeStamp ASC"
            android.database.sqlite.SQLiteDatabase r3 = r12.jad_an     // Catch: java.lang.Throwable -> L8c
            java.lang.String r4 = "preloadAd"
            r8 = 0
            r9 = 0
            r5 = 0
            android.database.Cursor r1 = r3.query(r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L8c
            int r2 = r1.getCount()     // Catch: java.lang.Throwable -> L8c
            if (r2 <= 0) goto La4
            r1.moveToFirst()     // Catch: java.lang.Throwable -> L8c
            com.jd.ad.sdk.jad_kx.jad_er r2 = com.jd.ad.sdk.jad_kx.jad_er.jad_an.jad_an     // Catch: java.lang.Throwable -> L8c
            int r2 = r2.jad_bo()     // Catch: java.lang.Throwable -> L8c
            int r2 = r2 * 1000
            long r2 = (long) r2     // Catch: java.lang.Throwable -> L8c
            long r4 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L8c
            long r4 = r4 - r2
        L40:
            boolean r2 = r1.isAfterLast()     // Catch: java.lang.Throwable -> L8c
            if (r2 != 0) goto L99
            java.lang.String r2 = "_id"
            int r2 = r1.getColumnIndex(r2)     // Catch: java.lang.Throwable -> L8c
            int r7 = r1.getInt(r2)     // Catch: java.lang.Throwable -> L8c
            java.lang.String r2 = "preloadAdCacheTimeStamp"
            int r2 = r1.getColumnIndex(r2)     // Catch: java.lang.Throwable -> L8c
            java.lang.String r11 = r1.getString(r2)     // Catch: java.lang.Throwable -> L8c
            java.lang.String r2 = "rId"
            int r2 = r1.getColumnIndex(r2)     // Catch: java.lang.Throwable -> L8c
            java.lang.String r9 = r1.getString(r2)     // Catch: java.lang.Throwable -> L8c
            java.lang.String r2 = "preloadAdJson"
            int r2 = r1.getColumnIndex(r2)     // Catch: java.lang.Throwable -> L8c
            java.lang.String r2 = r1.getString(r2)     // Catch: java.lang.Throwable -> L8c
            java.lang.String r10 = com.jd.ad.sdk.fdt.utils.ANEProxy.jb(r2)     // Catch: java.lang.Throwable -> L8c
            boolean r2 = android.text.TextUtils.isEmpty(r10)     // Catch: java.lang.Throwable -> L8c
            if (r2 != 0) goto L8e
            long r2 = java.lang.Long.parseLong(r11)     // Catch: java.lang.Throwable -> L8c
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 >= 0) goto L81
            goto L8e
        L81:
            com.jd.ad.sdk.jad_kx.jad_cp r2 = new com.jd.ad.sdk.jad_kx.jad_cp     // Catch: java.lang.Throwable -> L8c
            r6 = r2
            r8 = r13
            r6.<init>(r7, r8, r9, r10, r11)     // Catch: java.lang.Throwable -> L8c
            r0.add(r2)     // Catch: java.lang.Throwable -> L8c
            goto L95
        L8c:
            r13 = move-exception
            goto Lad
        L8e:
            java.util.List<java.lang.String> r2 = com.jd.ad.sdk.jad_kx.jad_an.jad_dq     // Catch: java.lang.Throwable -> L8c
            java.util.ArrayList r2 = (java.util.ArrayList) r2     // Catch: java.lang.Throwable -> L8c
            r2.add(r9)     // Catch: java.lang.Throwable -> L8c
        L95:
            r1.moveToNext()     // Catch: java.lang.Throwable -> L8c
            goto L40
        L99:
            r1.close()     // Catch: java.lang.Throwable -> L8c
            com.jd.ad.sdk.jad_kx.jad_an$jad_an r13 = new com.jd.ad.sdk.jad_kx.jad_an$jad_an     // Catch: java.lang.Throwable -> L8c
            r13.<init>()     // Catch: java.lang.Throwable -> L8c
            com.jd.ad.sdk.fdt.thread.WorkExecutor.execute(r13)     // Catch: java.lang.Throwable -> L8c
        La4:
            boolean r13 = r1.isClosed()     // Catch: java.lang.Throwable -> Lab
            if (r13 != 0) goto Lcd
            goto Lca
        Lab:
            r13 = move-exception
            goto Ldc
        Lad:
            java.lang.String r2 = ""
            com.jd.ad.sdk.jad_uh.jad_an r3 = com.jd.ad.sdk.jad_uh.jad_an.CACHE_PRELOAD_AD_QUERY_DB_TABLE_ERROR     // Catch: java.lang.Throwable -> Lcf
            int r4 = r3.jad_an     // Catch: java.lang.Throwable -> Lcf
            java.lang.String r13 = r13.getMessage()     // Catch: java.lang.Throwable -> Lcf
            java.lang.String[] r13 = new java.lang.String[]{r13}     // Catch: java.lang.Throwable -> Lcf
            java.lang.String r13 = r3.jad_an(r13)     // Catch: java.lang.Throwable -> Lcf
            com.jd.ad.sdk.jad_vi.jad_fs.jad_an(r2, r4, r13)     // Catch: java.lang.Throwable -> Lcf
            if (r1 == 0) goto Lcd
            boolean r13 = r1.isClosed()     // Catch: java.lang.Throwable -> Lab
            if (r13 != 0) goto Lcd
        Lca:
            r1.close()     // Catch: java.lang.Throwable -> Lab
        Lcd:
            monitor-exit(r12)
            return r0
        Lcf:
            r13 = move-exception
            if (r1 == 0) goto Ldb
            boolean r0 = r1.isClosed()     // Catch: java.lang.Throwable -> Lab
            if (r0 != 0) goto Ldb
            r1.close()     // Catch: java.lang.Throwable -> Lab
        Ldb:
            throw r13     // Catch: java.lang.Throwable -> Lab
        Ldc:
            monitor-exit(r12)     // Catch: java.lang.Throwable -> Lab
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_kx.jad_an.jad_an(java.lang.String):java.util.List");
    }

    public synchronized Cursor jad_bo(String str) {
        try {
            getReadableDatabase();
            if (!jad_bo()) {
                return null;
            }
            return this.jad_an.query("preloadAd", null, "appIdSlotId =?", new String[]{String.valueOf(str)}, null, null, "preloadAdCacheTimeStamp ASC");
        } catch (Throwable th) {
            try {
                com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.CACHE_PRELOAD_AD_QUERY_DB_TABLE_ERROR;
                com.jd.ad.sdk.jad_vi.jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(th.getMessage()));
                return null;
            } finally {
            }
        }
    }

    public synchronized void jad_an(List<String> list) {
        SQLiteDatabase sQLiteDatabase;
        if (list != null) {
            try {
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (list.size() != 0) {
                try {
                    getWritableDatabase();
                } catch (Throwable th) {
                    try {
                        Logger.w("Exception while clearing preload ad data:", th.getMessage());
                        SQLiteDatabase sQLiteDatabase2 = this.jad_an;
                        if (sQLiteDatabase2 != null && sQLiteDatabase2.inTransaction()) {
                            sQLiteDatabase = this.jad_an;
                        }
                    } finally {
                        SQLiteDatabase sQLiteDatabase3 = this.jad_an;
                        if (sQLiteDatabase3 != null && sQLiteDatabase3.inTransaction()) {
                            this.jad_an.endTransaction();
                        }
                    }
                }
                if (jad_bo()) {
                    this.jad_an.beginTransaction();
                    Iterator<String> it = list.iterator();
                    while (it.hasNext()) {
                        this.jad_an.delete("preloadAd", "rId=?", new String[]{it.next()});
                    }
                    this.jad_an.setTransactionSuccessful();
                    SQLiteDatabase sQLiteDatabase4 = this.jad_an;
                    if (sQLiteDatabase4 != null && sQLiteDatabase4.inTransaction()) {
                        sQLiteDatabase = this.jad_an;
                        sQLiteDatabase.endTransaction();
                    }
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0039, code lost:
    
        if (r3.inTransaction() != false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0056, code lost:
    
        r2.jad_an.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0054, code lost:
    
        if (r3.inTransaction() != false) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void jad_an(java.lang.String r3, java.lang.String[] r4) {
        /*
            r2 = this;
            monitor-enter(r2)
            r2.getWritableDatabase()     // Catch: java.lang.Throwable -> L3c
            boolean r0 = r2.jad_bo()     // Catch: java.lang.Throwable -> L3c
            if (r0 != 0) goto L20
            android.database.sqlite.SQLiteDatabase r3 = r2.jad_an     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L1c
            if (r3 == 0) goto L1e
            boolean r3 = r3.inTransaction()     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L1c
            if (r3 == 0) goto L1e
            android.database.sqlite.SQLiteDatabase r3 = r2.jad_an     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L1c
            r3.endTransaction()     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L1c
            goto L1e
        L1a:
            r3 = move-exception
            goto L72
        L1c:
            r3 = move-exception
            goto L6d
        L1e:
            monitor-exit(r2)
            return
        L20:
            android.database.sqlite.SQLiteDatabase r0 = r2.jad_an     // Catch: java.lang.Throwable -> L3c
            r0.beginTransaction()     // Catch: java.lang.Throwable -> L3c
            android.database.sqlite.SQLiteDatabase r0 = r2.jad_an     // Catch: java.lang.Throwable -> L3c
            java.lang.String r1 = "preloadAd"
            r0.delete(r1, r3, r4)     // Catch: java.lang.Throwable -> L3c
            android.database.sqlite.SQLiteDatabase r3 = r2.jad_an     // Catch: java.lang.Throwable -> L3c
            r3.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L3c
            android.database.sqlite.SQLiteDatabase r3 = r2.jad_an     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L1c
            if (r3 == 0) goto L70
            boolean r3 = r3.inTransaction()     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L1c
            if (r3 == 0) goto L70
            goto L56
        L3c:
            r3 = move-exception
            java.lang.String r4 = "Exception while clearing events: "
            java.lang.String r3 = r3.getMessage()     // Catch: java.lang.Throwable -> L5c
            r0 = 1
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> L5c
            r1 = 0
            r0[r1] = r3     // Catch: java.lang.Throwable -> L5c
            com.jd.ad.sdk.logger.Logger.w(r4, r0)     // Catch: java.lang.Throwable -> L5c
            android.database.sqlite.SQLiteDatabase r3 = r2.jad_an     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L1c
            if (r3 == 0) goto L70
            boolean r3 = r3.inTransaction()     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L1c
            if (r3 == 0) goto L70
        L56:
            android.database.sqlite.SQLiteDatabase r3 = r2.jad_an     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L1c
            r3.endTransaction()     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L1c
            goto L70
        L5c:
            r3 = move-exception
            android.database.sqlite.SQLiteDatabase r4 = r2.jad_an     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L1c
            if (r4 == 0) goto L6c
            boolean r4 = r4.inTransaction()     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L1c
            if (r4 == 0) goto L6c
            android.database.sqlite.SQLiteDatabase r4 = r2.jad_an     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L1c
            r4.endTransaction()     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L1c
        L6c:
            throw r3     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L1c
        L6d:
            r3.printStackTrace()     // Catch: java.lang.Throwable -> L1a
        L70:
            monitor-exit(r2)
            return
        L72:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L1a
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_kx.jad_an.jad_an(java.lang.String, java.lang.String[]):void");
    }
}
