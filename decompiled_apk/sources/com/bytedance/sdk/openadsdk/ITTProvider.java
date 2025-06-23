package com.bytedance.sdk.openadsdk;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

/* loaded from: classes8.dex */
public interface ITTProvider {
    int delete(Uri uri, String str, String[] strArr);

    String getTableName();

    String getType(Uri uri);

    void init();

    void injectContext(Context context);

    Uri insert(Uri uri, ContentValues contentValues);

    Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2);

    int update(Uri uri, ContentValues contentValues, String str, String[] strArr);
}
