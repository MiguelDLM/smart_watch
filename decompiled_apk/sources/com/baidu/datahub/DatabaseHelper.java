package com.baidu.datahub;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/* loaded from: classes7.dex */
public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String CREATE_TABLE_DRIVER_STATUS = "create table driverStatus(orderId text,companyServerId text,driverId text,orderState integer,waypoints text,pathplan_points text)";
    public static final String CREATE_TABLE_ORDER = "create table orderInfo (orderId text,companyServerId text,driverId text,orderState integer,cur_point text,start_point text,start_poiid text,start_name text,end_point text,end_poiid text,end_name text,cuid text,remark text)";
    public static final String CREATE_TABLE_ORDER_CARPOOL = "create table orderInfo (orderId text,companyServerId text,driverId text,orderState integer,cur_point text,start_point text,start_poiid text,start_name text,end_point text,end_poiid text,end_name text,cuid text,remark text,order_type integer,parent_order_id text,coord_type text,previous_order_id text)";
    public static final String CREATE_TABLE_ORDER_OLD = "create table orderInfo (orderId text,companyServerId text,driverId text,orderState integer,cur_point text,start_point text,start_poiid text,start_name text,end_point text,end_poiid text,end_name text,cuid text)";
    public static final String CREATE_TABLE_PARENT_ORDEER_INFO = "create table parentOrderInfo(orderId text,companyServerId text,driverId text,orderState integer,order_type integer)";
    public static final String CREATE_TABLE_ROUTE = "create table routeInfo(orderId text,companyServerId text,driverId text,orderState integer,sessionId text,curRouteMD5 text,modify_time integer)";
    public static final String CREATE_TABLE_ROUTE_CARPOOL = "create table routeInfo(orderId text,companyServerId text,driverId text,orderState integer,sessionId text,curRouteMD5 text,modify_time integer,order_type integer,sub_orders_seq text,parent_order_id text,end_name text,end_point text,end_poiid text,waypoints text,pathplan_points text)";

    public DatabaseHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
        super(context, str, cursorFactory, i);
    }

    private void downgradeToVersion2(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(" drop table if exists orderInfo");
        sQLiteDatabase.execSQL(CREATE_TABLE_ORDER);
        sQLiteDatabase.execSQL("alter table routeInfo rename to routeInfo_backup");
        sQLiteDatabase.execSQL(CREATE_TABLE_ROUTE);
        sQLiteDatabase.execSQL("insert into routeInfo select orderId,companyServerId,driverId,orderState,sessionId,curRouteMD5,modify_time from routeInfo_backup");
        sQLiteDatabase.execSQL("drop table routeInfo_backup");
    }

    private void downgradeToVersion3(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("alter table orderInfo rename to orderInfo_backup");
        sQLiteDatabase.execSQL(CREATE_TABLE_ORDER_CARPOOL);
        sQLiteDatabase.execSQL("insert into orderInfo select orderId,companyServerId,driverId,orderState,cur_point,start_point,start_poiid,start_name,end_point,end_poiid,end_name,remark,order_type,parent_order_id from orderInfo_backup");
        sQLiteDatabase.execSQL("drop table orderInfo_backup");
        sQLiteDatabase.execSQL("alter table routeInfo rename to routeInfo_backup");
        sQLiteDatabase.execSQL(CREATE_TABLE_ROUTE_CARPOOL);
        sQLiteDatabase.execSQL("insert into routeInfo select orderId,companyServerId,driverId,orderState,sessionId,curRouteMD5,modify_time,order_type,sub_orders_seq,parent_order_id from routeInfo_backup");
        sQLiteDatabase.execSQL("drop table routeInfo_backup");
        sQLiteDatabase.execSQL("alter table parentOrderInfo rename to parentOrderInfo_backup");
        sQLiteDatabase.execSQL(CREATE_TABLE_PARENT_ORDEER_INFO);
        sQLiteDatabase.execSQL("insert into parentOrderInfo select orderId,companyServerId,driverId,orderState,order_type from parentOrderInfo_backup");
        sQLiteDatabase.execSQL("drop table parentOrderInfo_backup");
    }

    private void downgradeToVersion4(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("alter table orderInfo rename to orderInfo_backup");
        sQLiteDatabase.execSQL(CREATE_TABLE_ORDER_CARPOOL);
        sQLiteDatabase.execSQL("insert into orderInfo select orderId,companyServerId,driverId,orderState,cur_point,start_point,start_poiid,start_name,end_point,end_poiid,end_name,remark,order_type,parent_order_id,coord_type from orderInfo_backup");
        sQLiteDatabase.execSQL("drop table orderInfo_backup");
        sQLiteDatabase.execSQL("alter table routeInfo rename to routeInfo_backup");
        sQLiteDatabase.execSQL(CREATE_TABLE_ROUTE_CARPOOL);
        sQLiteDatabase.execSQL("insert into routeInfo select orderId,companyServerId,driverId,orderState,sessionId,curRouteMD5,modify_time,order_type,sub_orders_seq,parent_order_id from routeInfo_backup");
        sQLiteDatabase.execSQL("drop table routeInfo_backup");
        sQLiteDatabase.execSQL("alter table parentOrderInfo rename to parentOrderInfo_backup");
        sQLiteDatabase.execSQL(CREATE_TABLE_PARENT_ORDEER_INFO);
        sQLiteDatabase.execSQL("insert into parentOrderInfo select orderId,companyServerId,driverId,orderState,order_type from parentOrderInfo_backup");
        sQLiteDatabase.execSQL("drop table parentOrderInfo_backup");
    }

    private void upgradeFromVersion1(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(" drop table if exists orderInfo");
        sQLiteDatabase.execSQL(CREATE_TABLE_ORDER_CARPOOL);
        sQLiteDatabase.execSQL("alter table routeInfo add column order_type integer default 0");
        sQLiteDatabase.execSQL("alter table routeInfo add column sub_orders_seq text");
        sQLiteDatabase.execSQL("alter table routeInfo add column parent_order_id text");
        sQLiteDatabase.execSQL(CREATE_TABLE_DRIVER_STATUS);
        sQLiteDatabase.execSQL("alter table orderInfo add column previous_order_id text");
        sQLiteDatabase.execSQL("alter table routeInfo add column end_name text");
        sQLiteDatabase.execSQL("alter table routeInfo add column end_point text");
        sQLiteDatabase.execSQL("alter table routeInfo add column end_poiid text");
        sQLiteDatabase.execSQL("alter table routeInfo add column waypoints text");
        sQLiteDatabase.execSQL("alter table routeInfo add column pathplan_points text");
        sQLiteDatabase.execSQL("alter table driverStatus add column pathplan_points text");
    }

    private void upgradeFromVersion2(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("alter table orderInfo add column order_type default 0");
        sQLiteDatabase.execSQL("alter table orderInfo add column parent_order_id text");
        sQLiteDatabase.execSQL("alter table orderInfo add column coord_type text");
        sQLiteDatabase.execSQL("alter table routeInfo add column order_type integer default 0");
        sQLiteDatabase.execSQL("alter table routeInfo add column sub_orders_seq text");
        sQLiteDatabase.execSQL("alter table routeInfo add column parent_order_id text");
        sQLiteDatabase.execSQL(CREATE_TABLE_DRIVER_STATUS);
        sQLiteDatabase.execSQL("alter table orderInfo add column previous_order_id text");
        sQLiteDatabase.execSQL("alter table routeInfo add column end_name text");
        sQLiteDatabase.execSQL("alter table routeInfo add column end_point text");
        sQLiteDatabase.execSQL("alter table routeInfo add column end_poiid text");
        sQLiteDatabase.execSQL("alter table routeInfo add column waypoints text");
        sQLiteDatabase.execSQL("alter table routeInfo add column pathplan_points text");
        sQLiteDatabase.execSQL("alter table driverStatus add column pathplan_points text");
    }

    private void upgradeFromVersion3(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("alter table orderInfo add column coord_type text");
        sQLiteDatabase.execSQL(CREATE_TABLE_DRIVER_STATUS);
        sQLiteDatabase.execSQL("alter table orderInfo add column previous_order_id text");
        sQLiteDatabase.execSQL("alter table routeInfo add column end_name text");
        sQLiteDatabase.execSQL("alter table routeInfo add column end_point text");
        sQLiteDatabase.execSQL("alter table routeInfo add column end_poiid text");
        sQLiteDatabase.execSQL("alter table routeInfo add column waypoints text");
        sQLiteDatabase.execSQL("alter table routeInfo add column pathplan_points text");
        sQLiteDatabase.execSQL("alter table driverStatus add column pathplan_points text");
    }

    private void upgradeFromVersion4(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(CREATE_TABLE_DRIVER_STATUS);
        sQLiteDatabase.execSQL("alter table orderInfo add column previous_order_id text");
        sQLiteDatabase.execSQL("alter table routeInfo add column end_name text");
        sQLiteDatabase.execSQL("alter table routeInfo add column end_point text");
        sQLiteDatabase.execSQL("alter table routeInfo add column end_poiid text");
        sQLiteDatabase.execSQL("alter table routeInfo add column waypoints text");
        sQLiteDatabase.execSQL("alter table routeInfo add column pathplan_points text");
        sQLiteDatabase.execSQL("alter table driverStatus add column pathplan_points text");
    }

    private void upgradeFromVersion5(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("alter table routeInfo add column pathplan_points text");
        sQLiteDatabase.execSQL("alter table driverStatus add column pathplan_points text");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(CREATE_TABLE_ORDER_CARPOOL);
        sQLiteDatabase.execSQL(CREATE_TABLE_ROUTE_CARPOOL);
        sQLiteDatabase.execSQL(CREATE_TABLE_PARENT_ORDEER_INFO);
        sQLiteDatabase.execSQL(CREATE_TABLE_DRIVER_STATUS);
        Log.d("DatabaseHelper", "DatabaseHelper onCreate");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        try {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 == 4) {
                        downgradeToVersion4(sQLiteDatabase);
                    }
                } else {
                    downgradeToVersion3(sQLiteDatabase);
                }
            } else {
                downgradeToVersion2(sQLiteDatabase);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("DatabaseHelper", "onDowngrade exception");
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        try {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i == 5) {
                                upgradeFromVersion5(sQLiteDatabase);
                            }
                        } else {
                            upgradeFromVersion4(sQLiteDatabase);
                        }
                    } else {
                        upgradeFromVersion3(sQLiteDatabase);
                    }
                } else {
                    upgradeFromVersion2(sQLiteDatabase);
                }
            } else {
                upgradeFromVersion1(sQLiteDatabase);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("DatabaseHelper", "onDowngrade exception");
        }
    }
}
