package com.ss.android.downloadlib.d;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.alimm.tanx.core.ad.event.track.expose.ExposeManager;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.ss.android.downloadlib.addownload.k;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public class c {
    private static volatile c b;

    /* renamed from: a, reason: collision with root package name */
    private SQLiteDatabase f26099a;

    private c() {
        try {
            this.f26099a = new b(k.a()).getWritableDatabase();
        } catch (Throwable th) {
            com.ss.android.downloadlib.e.c.a().a(th, "ClickEventHelper");
        }
    }

    public static c a() {
        if (b == null) {
            synchronized (c.class) {
                try {
                    if (b == null) {
                        b = new c();
                    }
                } finally {
                }
            }
        }
        return b;
    }

    public boolean b() {
        return com.ss.android.socialbase.downloader.g.a.c().a("click_event_switch", 0) == 1;
    }

    public boolean c() {
        return com.ss.android.socialbase.downloader.g.a.c().a("click_event_switch", 0) == 2;
    }

    private void c(long j, String str) {
        SQLiteDatabase sQLiteDatabase = this.f26099a;
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen() || j <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String optString = new JSONObject(str).optString(ExposeManager.UtArgsNames.reqId);
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            this.f26099a.delete("click_event", "time < ? AND ad_id = ? AND req_id = ?", new String[]{String.valueOf(System.currentTimeMillis() - 1209600000), String.valueOf(j), optString});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean b(long j, String str) {
        SQLiteDatabase sQLiteDatabase = this.f26099a;
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen() || j <= 0 || TextUtils.isEmpty(str)) {
            return false;
        }
        Cursor cursor = null;
        try {
            try {
                String optString = new JSONObject(str).optString(ExposeManager.UtArgsNames.reqId);
                if (TextUtils.isEmpty(optString)) {
                    return false;
                }
                cursor = this.f26099a.query("click_event", b.f26098a, "time > ? AND ad_id = ? AND req_id = ?", new String[]{String.valueOf(System.currentTimeMillis() - 1209600000), String.valueOf(j), optString}, null, null, null, null);
                boolean z = cursor.getCount() > 0;
                cursor.close();
                return z;
            } catch (Exception e) {
                e.printStackTrace();
                if (cursor != null) {
                    cursor.close();
                }
                return false;
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public void a(long j, String str) {
        String optString;
        SQLiteDatabase sQLiteDatabase = this.f26099a;
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen() || j <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            optString = new JSONObject(str).optString(ExposeManager.UtArgsNames.reqId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (TextUtils.isEmpty(optString)) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(MediationConstant.EXTRA_ADID, Long.valueOf(j));
        contentValues.put(ExposeManager.UtArgsNames.reqId, optString);
        contentValues.put("time", Long.valueOf(System.currentTimeMillis()));
        this.f26099a.insert("click_event", null, contentValues);
        c(j, str);
    }
}
