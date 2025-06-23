package Xo;

import XOxoX.oIX0oI;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;
import o0oIxXOx.XIxXXX0x0;

/* loaded from: classes13.dex */
public class II0xO0 extends SQLiteOpenHelper {
    public II0xO0(Context context) {
        super(context, "tanx_ad_expose_sdk.db", (SQLiteDatabase.CursorFactory) null, 1);
    }

    public synchronized void I0Io(com.tanx.exposer.achieve.II0xO0 iI0xO0) {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("monitor_type", iI0xO0.oOoXoXO().name());
            contentValues.put("monitor_url", iI0xO0.OOXIXo());
            contentValues.put("monitor_original_url", iI0xO0.xxIXOIIO());
            contentValues.put("monitor_url_host", iI0xO0.oO());
            contentValues.put("monitor_url_hash", iI0xO0.x0XOIxOo());
            if (iI0xO0.xoIox() != null) {
                contentValues.put("monitor_extra_params", iI0xO0.xoIox().toString());
            }
            contentValues.put("retry_times", Integer.valueOf(iI0xO0.II0XooXoX().intValue()));
            contentValues.put("max_retry_times", Integer.valueOf(iI0xO0.I0Io()));
            contentValues.put(XIxXXX0x0.f31178xoIox, iI0xO0.II0xO0());
            contentValues.put("expire_time", Long.valueOf(iI0xO0.oIX0oI()));
            long insert = writableDatabase.insert("retry_monitor_info", null, contentValues);
            iI0xO0.X0o0xo(insert);
            if (oIX0oI.f3985oIX0oI) {
                oIX0oI.oIX0oI("RetryMonitorDbHelper", "insert: index = " + insert + ", exposeDate = " + iI0xO0.II0xO0());
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void II0xO0(long j) {
        if (j < 0) {
            return;
        }
        try {
            long delete = getWritableDatabase().delete("retry_monitor_info", "id = ?", new String[]{String.valueOf(j)});
            if (oIX0oI.f3985oIX0oI) {
                oIX0oI.oIX0oI("RetryMonitorDbHelper", "delete: id = " + j + ", deleteRows = " + delete);
            }
        } finally {
        }
    }

    public synchronized List<com.tanx.exposer.achieve.II0xO0> oIX0oI(String str) {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            Cursor query = getReadableDatabase().query("retry_monitor_info", null, "date = ?", new String[]{str}, null, null, null, null);
            while (query != null) {
                try {
                    try {
                        if (!query.moveToNext()) {
                            break;
                        }
                        com.tanx.exposer.achieve.II0xO0 iI0xO0 = new com.tanx.exposer.achieve.II0xO0(query);
                        arrayList.add(iI0xO0);
                        if (oIX0oI.f3985oIX0oI) {
                            oIX0oI.oIX0oI("RetryMonitorDbHelper", "query: add retryMonitorInfo = " + iI0xO0);
                        }
                    } catch (Exception e) {
                        oIX0oI.II0xO0("RetryMonitorDbHelper", "query exception, date = " + str, e);
                    }
                } catch (Throwable th) {
                    query.close();
                    throw th;
                }
            }
            if (query != null) {
                query.close();
            }
            if (oIX0oI.f3985oIX0oI) {
                oIX0oI.oIX0oI("RetryMonitorDbHelper", "query: exposeDate = " + str + ", retryMonitorInfoList = " + arrayList);
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return arrayList;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        if (oIX0oI.f3985oIX0oI) {
            oIX0oI.oIX0oI("RetryMonitorDbHelper", "onCreate: createRetryTableSql = CREATE TABLE IF NOT EXISTS retry_monitor_info ( id INTEGER PRIMARY KEY AUTOINCREMENT, monitor_type VARCHAR(10), monitor_url TEXT, monitor_original_url TEXT, monitor_url_hash TEXT, monitor_url_host TEXT, monitor_extra_params TEXT, retry_times INTEGER, max_retry_times INTEGER, date VARCHAR(12),expire_time INTEGER)");
        }
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS retry_monitor_info ( id INTEGER PRIMARY KEY AUTOINCREMENT, monitor_type VARCHAR(10), monitor_url TEXT, monitor_original_url TEXT, monitor_url_hash TEXT, monitor_url_host TEXT, monitor_extra_params TEXT, retry_times INTEGER, max_retry_times INTEGER, date VARCHAR(12),expire_time INTEGER)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (oIX0oI.f3985oIX0oI) {
            oIX0oI.oIX0oI("RetryMonitorDbHelper", "onUpgrade: oldVer = " + i + ", newVer = " + i2);
        }
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS retry_monitor_info");
        onCreate(sQLiteDatabase);
    }

    public synchronized void oxoX(String str, int i) {
        try {
            long delete = getWritableDatabase().delete("retry_monitor_info", "date != ? or retry_times >= ?", new String[]{str, String.valueOf(i)});
            if (oIX0oI.f3985oIX0oI) {
                oIX0oI.oIX0oI("RetryMonitorDbHelper", "delete: deletedRows = " + delete + ", date = " + str + ", maxRetryTimes = " + i);
            }
        } catch (Throwable th) {
            oIX0oI.II0xO0("RetryMonitorDbHelper", "delete by date exception.", th);
        }
    }
}
