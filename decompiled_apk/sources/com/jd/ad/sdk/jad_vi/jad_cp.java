package com.jd.ad.sdk.jad_vi;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.jd.ad.sdk.fdt.utils.ANEProxy;
import com.jd.ad.sdk.logger.Logger;
import java.nio.charset.Charset;

/* loaded from: classes10.dex */
public class jad_cp extends com.jd.ad.sdk.jad_qd.jad_an {
    public static jad_cp jad_bo;

    public jad_cp(Context context, String str, int i) {
        super(context, str, i);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x003a -> B:6:0x0048). Please report as a decompilation issue!!! */
    public synchronized void jad_an(jad_dq jad_dqVar, String str) {
        if (jad_dqVar != null) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    getWritableDatabase();
                    if (!jad_bo()) {
                        return;
                    }
                    ContentValues jad_bo2 = jad_bo(jad_dqVar, str);
                    int i = jad_dqVar.jad_an;
                    if (i > 0) {
                        this.jad_an.update("events", jad_bo2, "_id=?", new String[]{String.valueOf(i)});
                    } else {
                        this.jad_an.insert("events", null, jad_bo2);
                    }
                } catch (Throwable th) {
                    Logger.w("Exception while saving events: ", th);
                }
            }
        }
    }

    public final ContentValues jad_bo(jad_dq jad_dqVar, String str) {
        ContentValues contentValues;
        try {
            contentValues = new ContentValues(4);
        } catch (Exception e) {
            e = e;
            contentValues = null;
        }
        try {
            String jSONObject = jad_dqVar.jad_an().toString();
            if (!TextUtils.isEmpty(jSONObject)) {
                String ja = ANEProxy.ja(jSONObject);
                if (TextUtils.isEmpty(ja)) {
                    return contentValues;
                }
                byte[] bytes = ja.getBytes(Charset.forName("UTF-8"));
                if (bytes != null && bytes.length > 0) {
                    contentValues.put(NotificationCompat.CATEGORY_EVENT, new String(bytes));
                    if (!TextUtils.isEmpty(str)) {
                        contentValues.put(ContentProviderManager.PLUGIN_PROCESS_NAME, str);
                    }
                }
                return contentValues;
            }
        } catch (Exception e2) {
            e = e2;
            Logger.w("Exception while add event: ", e.getMessage());
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
            this.jad_an.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (_id INTEGER PRIMARY KEY AUTOINCREMENT,%s ,%s)", "events", NotificationCompat.CATEGORY_EVENT, ContentProviderManager.PLUGIN_PROCESS_NAME));
        } catch (Exception e) {
            com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.CACHE_CREATE_DB_ERROR;
            jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(e.getMessage()));
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (_id INTEGER PRIMARY KEY AUTOINCREMENT,%s,%s)", "events", NotificationCompat.CATEGORY_EVENT, ContentProviderManager.PLUGIN_PROCESS_NAME));
        } catch (Exception e) {
            com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.CACHE_CREATE_DB_ERROR;
            jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(e.getMessage()));
        }
        this.jad_an = sQLiteDatabase;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS events");
        onCreate(sQLiteDatabase);
    }

    public synchronized Cursor jad_an(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            getReadableDatabase();
            if (!jad_bo()) {
                return null;
            }
            return this.jad_an.query("events", null, "process_name =?", new String[]{str}, null, null, null);
        } catch (Throwable th) {
            Logger.w("Exception while loading events: ", th.getMessage());
            return null;
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
            java.lang.String r1 = "events"
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
            java.lang.String r4 = "Exception while clearing event: "
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
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_vi.jad_cp.jad_an(java.lang.String, java.lang.String[]):void");
    }
}
