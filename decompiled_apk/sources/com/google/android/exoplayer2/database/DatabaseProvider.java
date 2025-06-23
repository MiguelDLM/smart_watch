package com.google.android.exoplayer2.database;

import android.database.sqlite.SQLiteDatabase;

/* loaded from: classes9.dex */
public interface DatabaseProvider {
    public static final String TABLE_PREFIX = "ExoPlayer";

    SQLiteDatabase getReadableDatabase();

    SQLiteDatabase getWritableDatabase();
}
