package com.huawei.hms.ads.identifier;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.hms.ads.identifier.AdvertisingIdClient;
import com.huawei.hms.ads.identifier.d;
import java.io.Closeable;

/* loaded from: classes10.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static final Uri f17298a = new Uri.Builder().scheme("content").authority("com.huawei.hwid.pps.apiprovider").path("/oaid_scp/get").build();
    private static final Uri b = new Uri.Builder().scheme("content").authority("com.huawei.hwid.pps.apiprovider").path("/oaid/query").build();

    public static AdvertisingIdClient.Info a(final Context context) {
        if (context == null || !a(context, f17298a)) {
            return null;
        }
        String string = Settings.Global.getString(context.getContentResolver(), "pps_oaid_c");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        final d.a a2 = d.a.a(context);
        String a3 = a2.a();
        if (TextUtils.isEmpty(a3)) {
            Log.d("InfoProviderUtil", "scp is empty");
            e.f17304a.execute(new Runnable() { // from class: com.huawei.hms.ads.identifier.b.1
                @Override // java.lang.Runnable
                public void run() {
                    if (d.a.this.c()) {
                        Log.d("InfoProviderUtil", "within key update interval.");
                        return;
                    }
                    d.a.this.b();
                    d.a.this.a(b.e(context));
                }
            });
            if (a2.e()) {
                return new AdvertisingIdClient.Info("00000000-0000-0000-0000-000000000000", true);
            }
            a2.d();
            return null;
        }
        String a4 = d.a(string, a3);
        if (!TextUtils.isEmpty(a4)) {
            return new AdvertisingIdClient.Info(a4, "00000000-0000-0000-0000-000000000000".equalsIgnoreCase(a4));
        }
        Log.d("InfoProviderUtil", "decrypt oaid failed.");
        e.f17304a.execute(new Runnable() { // from class: com.huawei.hms.ads.identifier.b.2
            @Override // java.lang.Runnable
            public void run() {
                a2.a(b.e(context));
            }
        });
        return null;
    }

    public static AdvertisingIdClient.Info b(Context context) {
        if (context == null || !c(context)) {
            return new AdvertisingIdClient.Info("00000000-0000-0000-0000-000000000000", true);
        }
        try {
            Cursor query = context.getContentResolver().query(b, null, null, null, null);
            if (query != null && query.moveToFirst()) {
                int columnIndexOrThrow = query.getColumnIndexOrThrow("oaid");
                int columnIndexOrThrow2 = query.getColumnIndexOrThrow("limit_track");
                String string = query.getString(columnIndexOrThrow);
                AdvertisingIdClient.Info info = new AdvertisingIdClient.Info(string, "00000000-0000-0000-0000-000000000000".equalsIgnoreCase(string) ? true : Boolean.valueOf(query.getString(columnIndexOrThrow2)).booleanValue());
                e.a(query);
                return info;
            }
            AdvertisingIdClient.Info info2 = new AdvertisingIdClient.Info("00000000-0000-0000-0000-000000000000", true);
            e.a(query);
            return info2;
        } catch (Throwable th) {
            try {
                Log.w("InfoProviderUtil", "query oaid via provider ex: " + th.getClass().getSimpleName());
                e.a((Closeable) null);
                return new AdvertisingIdClient.Info("00000000-0000-0000-0000-000000000000", true);
            } catch (Throwable th2) {
                e.a((Closeable) null);
                throw th2;
            }
        }
    }

    public static boolean c(Context context) {
        return a(context, b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String e(Context context) {
        if (context == null) {
            return "";
        }
        Cursor cursor = null;
        try {
            cursor = context.getContentResolver().query(f17298a, null, null, null, null);
            if (cursor != null && cursor.moveToFirst()) {
                return cursor.getString(cursor.getColumnIndexOrThrow("op_wk"));
            }
            return "";
        } catch (Throwable th) {
            try {
                Log.w("InfoProviderUtil", "get remote key ex: " + th.getClass().getSimpleName());
                return "";
            } finally {
                e.a(cursor);
            }
        }
    }

    private static boolean a(Context context, Uri uri) {
        Integer b2;
        if (context == null || uri == null || (b2 = e.b(context)) == null || 30462100 > b2.intValue()) {
            return false;
        }
        return e.a(context, uri);
    }
}
