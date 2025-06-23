package com.alimm.tanx.core.view.player.cache.videocache.sourcestorage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.alimm.tanx.core.view.player.cache.videocache.Preconditions;
import com.alimm.tanx.core.view.player.cache.videocache.SourceInfo;

class DatabaseSourceInfoStorage extends SQLiteOpenHelper implements SourceInfoStorage {
    private static final String[] ALL_COLUMNS = {COLUMN_ID, "url", COLUMN_LENGTH, COLUMN_MIME};
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_LENGTH = "length";
    private static final String COLUMN_MIME = "mime";
    private static final String COLUMN_URL = "url";
    private static final String CREATE_SQL = "CREATE TABLE SourceInfo (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,url TEXT NOT NULL,mime TEXT,length INTEGER);";
    private static final String TABLE = "SourceInfo";

    public DatabaseSourceInfoStorage(Context context) {
        super(context, "AndroidVideoCache.db", (SQLiteDatabase.CursorFactory) null, 1);
        Preconditions.checkNotNull(context);
    }

    private SourceInfo convert(Cursor cursor) {
        return new SourceInfo(cursor.getString(cursor.getColumnIndexOrThrow("url")), cursor.getLong(cursor.getColumnIndexOrThrow(COLUMN_LENGTH)), cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_MIME)));
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0035  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.alimm.tanx.core.view.player.cache.videocache.SourceInfo get(java.lang.String r11) {
        /*
            r10 = this;
            com.alimm.tanx.core.view.player.cache.videocache.Preconditions.checkNotNull(r11)
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r10.getReadableDatabase()     // Catch:{ all -> 0x002f }
            java.lang.String r2 = "SourceInfo"
            java.lang.String[] r3 = ALL_COLUMNS     // Catch:{ all -> 0x002f }
            java.lang.String r4 = "url=?"
            java.lang.String[] r5 = new java.lang.String[]{r11}     // Catch:{ all -> 0x002f }
            r7 = 0
            r8 = 0
            r6 = 0
            android.database.Cursor r11 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x002f }
            if (r11 == 0) goto L_0x0029
            boolean r1 = r11.moveToFirst()     // Catch:{ all -> 0x0027 }
            if (r1 != 0) goto L_0x0022
            goto L_0x0029
        L_0x0022:
            com.alimm.tanx.core.view.player.cache.videocache.SourceInfo r0 = r10.convert((android.database.Cursor) r11)     // Catch:{ all -> 0x0027 }
            goto L_0x0029
        L_0x0027:
            r0 = move-exception
            goto L_0x0033
        L_0x0029:
            if (r11 == 0) goto L_0x002e
            r11.close()
        L_0x002e:
            return r0
        L_0x002f:
            r11 = move-exception
            r9 = r0
            r0 = r11
            r11 = r9
        L_0x0033:
            if (r11 == 0) goto L_0x0038
            r11.close()
        L_0x0038:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alimm.tanx.core.view.player.cache.videocache.sourcestorage.DatabaseSourceInfoStorage.get(java.lang.String):com.alimm.tanx.core.view.player.cache.videocache.SourceInfo");
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        Preconditions.checkNotNull(sQLiteDatabase);
        sQLiteDatabase.execSQL(CREATE_SQL);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        throw new IllegalStateException("Should not be called. There is no any migration");
    }

    public void put(String str, SourceInfo sourceInfo) {
        boolean z = false;
        Preconditions.checkAllNotNull(str, sourceInfo);
        if (get(str) != null) {
            z = true;
        }
        ContentValues convert = convert(sourceInfo);
        if (z) {
            getWritableDatabase().update(TABLE, convert, "url=?", new String[]{str});
        } else {
            getWritableDatabase().insert(TABLE, (String) null, convert);
        }
    }

    public void release() {
        close();
    }

    private ContentValues convert(SourceInfo sourceInfo) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("url", sourceInfo.url);
        contentValues.put(COLUMN_LENGTH, Long.valueOf(sourceInfo.length));
        contentValues.put(COLUMN_MIME, sourceInfo.mime);
        return contentValues;
    }
}
