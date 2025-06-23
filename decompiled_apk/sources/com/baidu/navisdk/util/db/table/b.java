package com.baidu.navisdk.util.db.table;

import android.content.ContentValues;
import android.database.Cursor;

/* loaded from: classes8.dex */
public class b extends a<com.baidu.navisdk.util.db.object.b> {
    public static final Object e = new Object();

    @Override // com.baidu.navisdk.util.db.table.a
    public String c() {
        return "routeplan_id";
    }

    @Override // com.baidu.navisdk.util.db.table.a
    public String d() {
        return "route_plan_node";
    }

    @Override // com.baidu.navisdk.util.db.table.a
    public Object e() {
        return e;
    }

    @Override // com.baidu.navisdk.util.db.table.a
    public com.baidu.navisdk.util.db.object.b a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        int columnIndex = cursor.getColumnIndex("name");
        int columnIndex2 = cursor.getColumnIndex("description");
        int columnIndex3 = cursor.getColumnIndex("is_from");
        int columnIndex4 = cursor.getColumnIndex("latitude");
        int columnIndex5 = cursor.getColumnIndex("longitude");
        int columnIndex6 = cursor.getColumnIndex("poi_origin_uid");
        int columnIndex7 = cursor.getColumnIndex("routeplan_id");
        int columnIndex8 = cursor.getColumnIndex("arg1");
        int columnIndex9 = cursor.getColumnIndex("arg2");
        com.baidu.navisdk.util.db.object.b bVar = new com.baidu.navisdk.util.db.object.b(cursor.getInt(columnIndex4), cursor.getInt(columnIndex5), cursor.getInt(columnIndex3), cursor.getString(columnIndex), cursor.getString(columnIndex2), cursor.getString(columnIndex6));
        bVar.setId(cursor.getInt(columnIndex7));
        bVar.a(cursor.getInt(columnIndex8));
        bVar.b(cursor.getInt(columnIndex9));
        return bVar;
    }

    @Override // com.baidu.navisdk.util.db.table.a
    public ContentValues a(com.baidu.navisdk.util.db.object.b bVar) {
        ContentValues contentValues = new ContentValues();
        if (bVar == null) {
            return contentValues;
        }
        contentValues.put("name", bVar.mName);
        contentValues.put("description", bVar.mDescription);
        contentValues.put("is_from", Integer.valueOf(bVar.mFrom));
        contentValues.put("latitude", Integer.valueOf(bVar.getLatitudeE6()));
        contentValues.put("longitude", Integer.valueOf(bVar.getLongitudeE6()));
        contentValues.put("arg1", Integer.valueOf(bVar.a()));
        contentValues.put("arg2", Integer.valueOf(bVar.b()));
        String str = bVar.mUID;
        if (str != null && str.trim().length() > 0) {
            contentValues.put("poi_origin_uid", bVar.mUID);
        } else {
            contentValues.put("poi_origin_uid", "");
        }
        return contentValues;
    }
}
