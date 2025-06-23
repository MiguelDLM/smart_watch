package com.baidu.navisdk.util.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.baidu.navisdk.util.common.LogUtil;

/* loaded from: classes8.dex */
public class a extends SQLiteOpenHelper {
    public a(Context context) {
        super(context, "navi.common.db", (SQLiteDatabase.CursorFactory) null, 1);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        LogUtil.e(b.class.getName(), "db create!");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS route_plan_node(routeplan_id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,description TEXT,latitude INTEGER DEFAULT 0,longitude INTEGER DEFAULT 0,is_from INTEGER DEFAULT 0, poi_origin_uid TEXT,arg1 INTEGER DEFAULT 0,arg2 INTEGER DEFAULT 0);");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        LogUtil.e(b.class.getName(), "Upgrading database from version " + i + " to " + i2 + ", which will destroy all old data");
    }
}
