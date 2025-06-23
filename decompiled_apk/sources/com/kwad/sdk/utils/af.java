package com.kwad.sdk.utils;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;

/* loaded from: classes11.dex */
public final class af {
    private static String aQw;
    private static boolean aQx;

    public static String cu(Context context) {
        Cursor cursor;
        if (TextUtils.isEmpty(aQw) && !aQx && au.MQ()) {
            try {
                cursor = context.getContentResolver().query(Uri.parse("content://com.xiaomi.market.provider.DirectMailProvider"), null, null, null, null);
                try {
                    aQw = k(cursor);
                } catch (Throwable unused) {
                }
            } catch (Throwable unused2) {
                cursor = null;
            }
            com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
            aQx = TextUtils.isEmpty(aQw);
            return aQw;
        }
        return aQw;
    }

    public static boolean cv(Context context) {
        Cursor cursor;
        boolean z = false;
        if (!au.MQ()) {
            return false;
        }
        try {
            cursor = context.getContentResolver().query(Uri.parse("content://com.xiaomi.market.provider.DirectMailProvider"), null, null, null, null);
        } catch (Throwable unused) {
            cursor = null;
        }
        try {
            z = l(cursor);
        } catch (Throwable unused2) {
            try {
                com.kwad.sdk.core.e.c.e("MiMarketHelper", "isSupportMiMarket2 failed");
                if (!z) {
                    com.kwad.sdk.core.e.c.i("MiMarketHelper", "is Miui but not support MiMarket2.0");
                }
                return z;
            } finally {
                com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
            }
        }
        if (!z && au.MQ()) {
            com.kwad.sdk.core.e.c.i("MiMarketHelper", "is Miui but not support MiMarket2.0");
        }
        return z;
    }

    public static boolean gJ(String str) {
        if (!str.startsWith("market://details") && !str.startsWith("mimarket://details")) {
            return false;
        }
        return true;
    }

    private static String k(Cursor cursor) {
        int columnIndex;
        if (cursor != null && !cursor.isClosed()) {
            cursor.moveToFirst();
            int columnIndex2 = cursor.getColumnIndex("support");
            if ((columnIndex2 > 0 && cursor.getInt(columnIndex2) == 0) || (columnIndex = cursor.getColumnIndex("detailStyle")) <= 0) {
                return "";
            }
            return cursor.getString(columnIndex);
        }
        com.kwad.sdk.core.e.c.i("MiMarketHelper", "cursor is null");
        return "";
    }

    private static boolean l(Cursor cursor) {
        if (cursor != null && !cursor.isClosed()) {
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex("support");
            if (columnIndex < 0) {
                return false;
            }
            return cursor.getString(columnIndex).equals("true");
        }
        com.kwad.sdk.core.e.c.i("MiMarketHelper", "isSupportMiMarket2: cursor is null");
        return false;
    }
}
