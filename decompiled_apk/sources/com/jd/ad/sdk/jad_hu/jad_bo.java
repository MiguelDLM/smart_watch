package com.jd.ad.sdk.jad_hu;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.jd.ad.sdk.fdt.utils.ANEProxy;
import com.jd.ad.sdk.logger.Logger;
import java.util.List;

/* loaded from: classes10.dex */
public class jad_bo extends com.jd.ad.sdk.jad_qd.jad_an {
    public static jad_bo jad_bo;

    /* loaded from: classes10.dex */
    public class jad_an implements Runnable {
        public final /* synthetic */ List jad_an;

        public jad_an(List list) {
            this.jad_an = list;
        }

        /* JADX WARN: Code restructure failed: missing block: B:29:0x0064, code lost:
        
            if (r1.inTransaction() != false) goto L37;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x0080, code lost:
        
            r1 = r0.jad_an;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x007e, code lost:
        
            if (r1.inTransaction() != false) goto L37;
         */
        /* JADX WARN: Finally extract failed */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                r6 = this;
                com.jd.ad.sdk.jad_hu.jad_bo r0 = com.jd.ad.sdk.jad_hu.jad_bo.this
                java.util.List r1 = r6.jad_an
                monitor-enter(r0)
                if (r1 == 0) goto L9d
                int r2 = r1.size()     // Catch: java.lang.Throwable -> L25 java.lang.Exception -> L28
                if (r2 != 0) goto Lf
                goto L9d
            Lf:
                r0.getWritableDatabase()     // Catch: java.lang.Throwable -> L55
                boolean r2 = r0.jad_bo()     // Catch: java.lang.Throwable -> L55
                if (r2 != 0) goto L2a
                android.database.sqlite.SQLiteDatabase r1 = r0.jad_an     // Catch: java.lang.Throwable -> L25 java.lang.Exception -> L28
                if (r1 == 0) goto L9d
                boolean r1 = r1.inTransaction()     // Catch: java.lang.Throwable -> L25 java.lang.Exception -> L28
                if (r1 == 0) goto L9d
                android.database.sqlite.SQLiteDatabase r1 = r0.jad_an     // Catch: java.lang.Throwable -> L25 java.lang.Exception -> L28
                goto L82
            L25:
                r1 = move-exception
                goto L9b
            L28:
                r1 = move-exception
                goto L97
            L2a:
                android.database.sqlite.SQLiteDatabase r2 = r0.jad_an     // Catch: java.lang.Throwable -> L55
                r2.beginTransaction()     // Catch: java.lang.Throwable -> L55
                java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Throwable -> L55
            L33:
                boolean r2 = r1.hasNext()     // Catch: java.lang.Throwable -> L55
                if (r2 == 0) goto L57
                java.lang.Object r2 = r1.next()     // Catch: java.lang.Throwable -> L55
                java.lang.Integer r2 = (java.lang.Integer) r2     // Catch: java.lang.Throwable -> L55
                int r2 = r2.intValue()     // Catch: java.lang.Throwable -> L55
                android.database.sqlite.SQLiteDatabase r3 = r0.jad_an     // Catch: java.lang.Throwable -> L55
                java.lang.String r4 = "lottieTemplate"
                java.lang.String r5 = "_id=?"
                java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch: java.lang.Throwable -> L55
                java.lang.String[] r2 = new java.lang.String[]{r2}     // Catch: java.lang.Throwable -> L55
                r3.delete(r4, r5, r2)     // Catch: java.lang.Throwable -> L55
                goto L33
            L55:
                r1 = move-exception
                goto L67
            L57:
                android.database.sqlite.SQLiteDatabase r1 = r0.jad_an     // Catch: java.lang.Throwable -> L55
                r1.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L55
                android.database.sqlite.SQLiteDatabase r1 = r0.jad_an     // Catch: java.lang.Throwable -> L25 java.lang.Exception -> L28
                if (r1 == 0) goto L9d
                boolean r1 = r1.inTransaction()     // Catch: java.lang.Throwable -> L25 java.lang.Exception -> L28
                if (r1 == 0) goto L9d
                goto L80
            L67:
                java.lang.String r2 = "Exception while clearing templates:"
                java.lang.String r1 = r1.getMessage()     // Catch: java.lang.Throwable -> L86
                r3 = 1
                java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L86
                r4 = 0
                r3[r4] = r1     // Catch: java.lang.Throwable -> L86
                com.jd.ad.sdk.logger.Logger.w(r2, r3)     // Catch: java.lang.Throwable -> L86
                android.database.sqlite.SQLiteDatabase r1 = r0.jad_an     // Catch: java.lang.Throwable -> L25 java.lang.Exception -> L28
                if (r1 == 0) goto L9d
                boolean r1 = r1.inTransaction()     // Catch: java.lang.Throwable -> L25 java.lang.Exception -> L28
                if (r1 == 0) goto L9d
            L80:
                android.database.sqlite.SQLiteDatabase r1 = r0.jad_an     // Catch: java.lang.Throwable -> L25 java.lang.Exception -> L28
            L82:
                r1.endTransaction()     // Catch: java.lang.Throwable -> L25 java.lang.Exception -> L28
                goto L9d
            L86:
                r1 = move-exception
                android.database.sqlite.SQLiteDatabase r2 = r0.jad_an     // Catch: java.lang.Throwable -> L25 java.lang.Exception -> L28
                if (r2 == 0) goto L96
                boolean r2 = r2.inTransaction()     // Catch: java.lang.Throwable -> L25 java.lang.Exception -> L28
                if (r2 == 0) goto L96
                android.database.sqlite.SQLiteDatabase r2 = r0.jad_an     // Catch: java.lang.Throwable -> L25 java.lang.Exception -> L28
                r2.endTransaction()     // Catch: java.lang.Throwable -> L25 java.lang.Exception -> L28
            L96:
                throw r1     // Catch: java.lang.Throwable -> L25 java.lang.Exception -> L28
            L97:
                r1.printStackTrace()     // Catch: java.lang.Throwable -> L25
                goto L9d
            L9b:
                monitor-exit(r0)
                throw r1
            L9d:
                monitor-exit(r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_hu.jad_bo.jad_an.run():void");
        }
    }

    public jad_bo(Context context, String str, int i) {
        super(context, str, i);
    }

    public static synchronized jad_bo jad_an(Context context, String str, int i) {
        jad_bo jad_boVar;
        synchronized (jad_bo.class) {
            try {
                if (jad_bo == null) {
                    jad_bo = new jad_bo(context, str, i);
                }
                jad_boVar = jad_bo;
            } catch (Throwable th) {
                throw th;
            }
        }
        return jad_boVar;
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
            contentValues.put("appIdPid", jad_cpVar.jad_bo);
            contentValues.put("templateID", Integer.valueOf(jad_cpVar.jad_cp));
            contentValues.put("templateJSON", ANEProxy.ja(jad_cpVar.jad_er));
            contentValues.put("templateUpdateTimeStamp", jad_cpVar.jad_dq);
            contentValues.put("timeStampInterval", jad_cpVar.jad_fs);
        } catch (Exception e2) {
            e = e2;
            Logger.w("Exception while add templates:", e.getMessage());
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
            this.jad_an.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (_id INTEGER PRIMARY KEY AUTOINCREMENT,  %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT)", "lottieTemplate", "appIdPid", "templateID", "templateUpdateTimeStamp", "templateJSON", "timeStampInterval"));
        } catch (Exception e) {
            StringBuilder jad_an2 = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("dynamic render template sql create error:");
            jad_an2.append(Log.getStackTraceString(e));
            Logger.d(jad_an2.toString());
            com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.CACHE_DYNAMIC_RENDER_CREATE_TEMPLATE_DB_ERROR;
            com.jd.ad.sdk.jad_vi.jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(e.getMessage()));
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (_id INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT, %s INTEGER, %s TEXT, %s TEXT, %s TEXT)", "lottieTemplate", "appIdPid", "templateID", "templateUpdateTimeStamp", "templateJSON", "timeStampInterval"));
        } catch (Exception e) {
            StringBuilder jad_an2 = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("dynamic render template sql create error:");
            jad_an2.append(Log.getStackTraceString(e));
            Logger.d(jad_an2.toString());
            com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.CACHE_DYNAMIC_RENDER_CREATE_TEMPLATE_DB_ERROR;
            com.jd.ad.sdk.jad_vi.jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(e.getMessage()));
        }
        this.jad_an = sQLiteDatabase;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS lottieTemplate");
        onCreate(sQLiteDatabase);
    }

    public synchronized void jad_an(jad_cp jad_cpVar) {
        if (jad_cpVar != null) {
            try {
                getWritableDatabase();
                if (!jad_bo()) {
                    return;
                }
                ContentValues jad_bo2 = jad_bo(jad_cpVar);
                int i = jad_cpVar.jad_an;
                if (i > 0) {
                    this.jad_an.update("lottieTemplate", jad_bo2, "_id=?", new String[]{String.valueOf(i)});
                } else {
                    this.jad_an.insert("lottieTemplate", null, jad_bo2);
                }
            } finally {
                Logger.w("Exception while saving template: ", th.getMessage());
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x00ba, code lost:
    
        if (r2.isClosed() == false) goto L36;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized java.util.List<com.jd.ad.sdk.jad_hu.jad_cp> jad_an(java.lang.String r14) {
        /*
            Method dump skipped, instructions count: 267
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_hu.jad_bo.jad_an(java.lang.String):java.util.List");
    }
}
