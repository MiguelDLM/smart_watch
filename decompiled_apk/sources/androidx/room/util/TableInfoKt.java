package androidx.room.util;

import OXOo.OOXIXo;
import android.database.Cursor;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.OI0;
import kotlin.collections.o0;
import kotlin.collections.oI0IIXIo;
import kotlin.collections.oX;
import kotlin.io.II0xO0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nTableInfo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TableInfo.kt\nandroidx/room/util/TableInfoKt\n+ 2 CursorUtil.kt\nandroidx/room/util/CursorUtil\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,646:1\n145#2,2:647\n148#2,2:654\n151#2:660\n145#2,7:661\n145#2,7:668\n145#2,7:675\n766#3:649\n857#3,2:650\n1855#3,2:652\n857#3,2:656\n1855#3,2:658\n*S KotlinDebug\n*F\n+ 1 TableInfo.kt\nandroidx/room/util/TableInfoKt\n*L\n477#1:647,2\n477#1:654,2\n477#1:660\n542#1:661,7\n580#1:668,7\n613#1:675,7\n497#1:649\n497#1:650,2\n499#1:652,2\n497#1:656,2\n499#1:658,2\n*E\n"})
/* loaded from: classes.dex */
public final class TableInfoKt {
    private static final Map<String, TableInfo.Column> readColumns(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
        boolean z;
        Cursor query = supportSQLiteDatabase.query("PRAGMA table_info(`" + str + "`)");
        try {
            Cursor cursor = query;
            if (cursor.getColumnCount() <= 0) {
                Map<String, TableInfo.Column> O0xOxO2 = o0.O0xOxO();
                II0xO0.oIX0oI(query, null);
                return O0xOxO2;
            }
            int columnIndex = cursor.getColumnIndex("name");
            int columnIndex2 = cursor.getColumnIndex("type");
            int columnIndex3 = cursor.getColumnIndex("notnull");
            int columnIndex4 = cursor.getColumnIndex("pk");
            int columnIndex5 = cursor.getColumnIndex("dflt_value");
            Map Oxx0IOOO2 = OI0.Oxx0IOOO();
            while (cursor.moveToNext()) {
                String name = cursor.getString(columnIndex);
                String type = cursor.getString(columnIndex2);
                if (cursor.getInt(columnIndex3) != 0) {
                    z = true;
                } else {
                    z = false;
                }
                int i = cursor.getInt(columnIndex4);
                String string = cursor.getString(columnIndex5);
                IIX0o.oO(name, "name");
                IIX0o.oO(type, "type");
                Oxx0IOOO2.put(name, new TableInfo.Column(name, type, z, i, string, 2));
            }
            Map<String, TableInfo.Column> oxoX2 = OI0.oxoX(Oxx0IOOO2);
            II0xO0.oIX0oI(query, null);
            return oxoX2;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                II0xO0.oIX0oI(query, th);
                throw th2;
            }
        }
    }

    private static final List<TableInfo.ForeignKeyWithSequence> readForeignKeyFieldMappings(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex("id");
        int columnIndex2 = cursor.getColumnIndex("seq");
        int columnIndex3 = cursor.getColumnIndex(TypedValues.TransitionType.S_FROM);
        int columnIndex4 = cursor.getColumnIndex("to");
        List xxIXOIIO2 = oI0IIXIo.xxIXOIIO();
        while (cursor.moveToNext()) {
            int i = cursor.getInt(columnIndex);
            int i2 = cursor.getInt(columnIndex2);
            String string = cursor.getString(columnIndex3);
            IIX0o.oO(string, "cursor.getString(fromColumnIndex)");
            String string2 = cursor.getString(columnIndex4);
            IIX0o.oO(string2, "cursor.getString(toColumnIndex)");
            xxIXOIIO2.add(new TableInfo.ForeignKeyWithSequence(i, i2, string, string2));
        }
        return CollectionsKt___CollectionsKt.oIxOXo(oI0IIXIo.oIX0oI(xxIXOIIO2));
    }

    private static final Set<TableInfo.ForeignKey> readForeignKeys(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
        Cursor query = supportSQLiteDatabase.query("PRAGMA foreign_key_list(`" + str + "`)");
        try {
            Cursor cursor = query;
            int columnIndex = cursor.getColumnIndex("id");
            int columnIndex2 = cursor.getColumnIndex("seq");
            int columnIndex3 = cursor.getColumnIndex("table");
            int columnIndex4 = cursor.getColumnIndex("on_delete");
            int columnIndex5 = cursor.getColumnIndex("on_update");
            List<TableInfo.ForeignKeyWithSequence> readForeignKeyFieldMappings = readForeignKeyFieldMappings(cursor);
            cursor.moveToPosition(-1);
            Set oxoX2 = oX.oxoX();
            while (cursor.moveToNext()) {
                if (cursor.getInt(columnIndex2) == 0) {
                    int i = cursor.getInt(columnIndex);
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList<TableInfo.ForeignKeyWithSequence> arrayList3 = new ArrayList();
                    for (Object obj : readForeignKeyFieldMappings) {
                        if (((TableInfo.ForeignKeyWithSequence) obj).getId() == i) {
                            arrayList3.add(obj);
                        }
                    }
                    for (TableInfo.ForeignKeyWithSequence foreignKeyWithSequence : arrayList3) {
                        arrayList.add(foreignKeyWithSequence.getFrom());
                        arrayList2.add(foreignKeyWithSequence.getTo());
                    }
                    String string = cursor.getString(columnIndex3);
                    IIX0o.oO(string, "cursor.getString(tableColumnIndex)");
                    String string2 = cursor.getString(columnIndex4);
                    IIX0o.oO(string2, "cursor.getString(onDeleteColumnIndex)");
                    String string3 = cursor.getString(columnIndex5);
                    IIX0o.oO(string3, "cursor.getString(onUpdateColumnIndex)");
                    oxoX2.add(new TableInfo.ForeignKey(string, string2, string3, arrayList, arrayList2));
                }
            }
            Set<TableInfo.ForeignKey> oIX0oI2 = oX.oIX0oI(oxoX2);
            II0xO0.oIX0oI(query, null);
            return oIX0oI2;
        } finally {
        }
    }

    private static final TableInfo.Index readIndex(SupportSQLiteDatabase supportSQLiteDatabase, String str, boolean z) {
        String str2;
        Cursor query = supportSQLiteDatabase.query("PRAGMA index_xinfo(`" + str + "`)");
        try {
            Cursor cursor = query;
            int columnIndex = cursor.getColumnIndex("seqno");
            int columnIndex2 = cursor.getColumnIndex("cid");
            int columnIndex3 = cursor.getColumnIndex("name");
            int columnIndex4 = cursor.getColumnIndex("desc");
            if (columnIndex != -1 && columnIndex2 != -1 && columnIndex3 != -1 && columnIndex4 != -1) {
                TreeMap treeMap = new TreeMap();
                TreeMap treeMap2 = new TreeMap();
                while (cursor.moveToNext()) {
                    if (cursor.getInt(columnIndex2) >= 0) {
                        int i = cursor.getInt(columnIndex);
                        String columnName = cursor.getString(columnIndex3);
                        if (cursor.getInt(columnIndex4) > 0) {
                            str2 = "DESC";
                        } else {
                            str2 = "ASC";
                        }
                        Integer valueOf = Integer.valueOf(i);
                        IIX0o.oO(columnName, "columnName");
                        treeMap.put(valueOf, columnName);
                        treeMap2.put(Integer.valueOf(i), str2);
                    }
                }
                Collection values = treeMap.values();
                IIX0o.oO(values, "columnsMap.values");
                List oOo0o = CollectionsKt___CollectionsKt.oOo0o(values);
                Collection values2 = treeMap2.values();
                IIX0o.oO(values2, "ordersMap.values");
                TableInfo.Index index = new TableInfo.Index(str, z, oOo0o, CollectionsKt___CollectionsKt.oOo0o(values2));
                II0xO0.oIX0oI(query, null);
                return index;
            }
            II0xO0.oIX0oI(query, null);
            return null;
        } finally {
        }
    }

    private static final Set<TableInfo.Index> readIndices(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
        Cursor query = supportSQLiteDatabase.query("PRAGMA index_list(`" + str + "`)");
        try {
            Cursor cursor = query;
            int columnIndex = cursor.getColumnIndex("name");
            int columnIndex2 = cursor.getColumnIndex("origin");
            int columnIndex3 = cursor.getColumnIndex("unique");
            if (columnIndex != -1 && columnIndex2 != -1 && columnIndex3 != -1) {
                Set oxoX2 = oX.oxoX();
                while (cursor.moveToNext()) {
                    if (IIX0o.Oxx0IOOO("c", cursor.getString(columnIndex2))) {
                        String name = cursor.getString(columnIndex);
                        boolean z = true;
                        if (cursor.getInt(columnIndex3) != 1) {
                            z = false;
                        }
                        IIX0o.oO(name, "name");
                        TableInfo.Index readIndex = readIndex(supportSQLiteDatabase, name, z);
                        if (readIndex == null) {
                            II0xO0.oIX0oI(query, null);
                            return null;
                        }
                        oxoX2.add(readIndex);
                    }
                }
                Set<TableInfo.Index> oIX0oI2 = oX.oIX0oI(oxoX2);
                II0xO0.oIX0oI(query, null);
                return oIX0oI2;
            }
            II0xO0.oIX0oI(query, null);
            return null;
        } finally {
        }
    }

    @OOXIXo
    public static final TableInfo readTableInfo(@OOXIXo SupportSQLiteDatabase database, @OOXIXo String tableName) {
        IIX0o.x0xO0oo(database, "database");
        IIX0o.x0xO0oo(tableName, "tableName");
        return new TableInfo(tableName, readColumns(database, tableName), readForeignKeys(database, tableName), readIndices(database, tableName));
    }
}
