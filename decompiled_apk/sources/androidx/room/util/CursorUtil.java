package androidx.room.util;

import OXOo.OOXIXo;
import Oox.oOoXoXO;
import XO0OX.xxIXOIIO;
import android.database.Cursor;
import android.database.CursorWrapper;
import android.database.MatrixCursor;
import android.os.Build;
import android.util.Log;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.io.II0xO0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.jvm.internal.xxX;
import kotlin.text.OxI;

@xxIXOIIO(name = "CursorUtil")
@XX({"SMAP\nCursorUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CursorUtil.kt\nandroidx/room/util/CursorUtil\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,184:1\n145#1,7:185\n13644#2,3:192\n1#3:195\n*S KotlinDebug\n*F\n+ 1 CursorUtil.kt\nandroidx/room/util/CursorUtil\n*L\n39#1:185,7\n127#1:192,3\n*E\n"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public final class CursorUtil {
    @OOXIXo
    public static final Cursor copyAndClose(@OOXIXo Cursor c) {
        IIX0o.x0xO0oo(c, "c");
        Cursor cursor = c;
        try {
            Cursor cursor2 = cursor;
            MatrixCursor matrixCursor = new MatrixCursor(cursor2.getColumnNames(), cursor2.getCount());
            while (cursor2.moveToNext()) {
                Object[] objArr = new Object[cursor2.getColumnCount()];
                int columnCount = c.getColumnCount();
                for (int i = 0; i < columnCount; i++) {
                    int type = cursor2.getType(i);
                    if (type != 0) {
                        if (type != 1) {
                            if (type != 2) {
                                if (type != 3) {
                                    if (type == 4) {
                                        objArr[i] = cursor2.getBlob(i);
                                    } else {
                                        throw new IllegalStateException();
                                    }
                                } else {
                                    objArr[i] = cursor2.getString(i);
                                }
                            } else {
                                objArr[i] = Double.valueOf(cursor2.getDouble(i));
                            }
                        } else {
                            objArr[i] = Long.valueOf(cursor2.getLong(i));
                        }
                    } else {
                        objArr[i] = null;
                    }
                }
                matrixCursor.addRow(objArr);
            }
            II0xO0.oIX0oI(cursor, null);
            return matrixCursor;
        } finally {
        }
    }

    private static final int findColumnIndexBySuffix(Cursor cursor, String str) {
        if (Build.VERSION.SDK_INT > 25 || str.length() == 0) {
            return -1;
        }
        String[] columnNames = cursor.getColumnNames();
        IIX0o.oO(columnNames, "columnNames");
        return findColumnIndexBySuffix(columnNames, str);
    }

    public static final int getColumnIndex(@OOXIXo Cursor c, @OOXIXo String name) {
        IIX0o.x0xO0oo(c, "c");
        IIX0o.x0xO0oo(name, "name");
        int columnIndex = c.getColumnIndex(name);
        if (columnIndex >= 0) {
            return columnIndex;
        }
        int columnIndex2 = c.getColumnIndex('`' + name + '`');
        if (columnIndex2 < 0) {
            return findColumnIndexBySuffix(c, name);
        }
        return columnIndex2;
    }

    public static final int getColumnIndexOrThrow(@OOXIXo Cursor c, @OOXIXo String name) {
        String str;
        IIX0o.x0xO0oo(c, "c");
        IIX0o.x0xO0oo(name, "name");
        int columnIndex = getColumnIndex(c, name);
        if (columnIndex >= 0) {
            return columnIndex;
        }
        try {
            String[] columnNames = c.getColumnNames();
            IIX0o.oO(columnNames, "c.columnNames");
            str = ArraysKt___ArraysKt.OIx0IoOx0(columnNames, null, null, null, 0, null, null, 63, null);
        } catch (Exception e) {
            Log.d("RoomCursorUtil", "Cannot collect column names for debug purposes", e);
            str = "unknown";
        }
        throw new IllegalArgumentException("column '" + name + "' does not exist. Available columns: " + str);
    }

    public static final <R> R useCursor(@OOXIXo Cursor cursor, @OOXIXo oOoXoXO<? super Cursor, ? extends R> block) {
        IIX0o.x0xO0oo(cursor, "<this>");
        IIX0o.x0xO0oo(block, "block");
        Cursor cursor2 = cursor;
        try {
            R invoke = block.invoke(cursor2);
            xxX.oxoX(1);
            II0xO0.oIX0oI(cursor2, null);
            xxX.I0Io(1);
            return invoke;
        } finally {
        }
    }

    @OOXIXo
    public static final Cursor wrapMappedColumns(@OOXIXo final Cursor cursor, @OOXIXo final String[] columnNames, @OOXIXo final int[] mapping) {
        IIX0o.x0xO0oo(cursor, "cursor");
        IIX0o.x0xO0oo(columnNames, "columnNames");
        IIX0o.x0xO0oo(mapping, "mapping");
        if (columnNames.length == mapping.length) {
            return new CursorWrapper(cursor) { // from class: androidx.room.util.CursorUtil$wrapMappedColumns$2
                @Override // android.database.CursorWrapper, android.database.Cursor
                public int getColumnIndex(@OOXIXo String columnName) {
                    IIX0o.x0xO0oo(columnName, "columnName");
                    String[] strArr = columnNames;
                    int[] iArr = mapping;
                    int length = strArr.length;
                    int i = 0;
                    int i2 = 0;
                    while (i < length) {
                        int i3 = i2 + 1;
                        if (OxI.oX0I0O(strArr[i], columnName, true)) {
                            return iArr[i2];
                        }
                        i++;
                        i2 = i3;
                    }
                    return super.getColumnIndex(columnName);
                }
            };
        }
        throw new IllegalStateException("Expected columnNames.length == mapping.length");
    }

    @VisibleForTesting
    public static final int findColumnIndexBySuffix(@OOXIXo String[] columnNames, @OOXIXo String name) {
        IIX0o.x0xO0oo(columnNames, "columnNames");
        IIX0o.x0xO0oo(name, "name");
        String str = '.' + name;
        String str2 = '.' + name + '`';
        int length = columnNames.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            String str3 = columnNames[i];
            int i3 = i2 + 1;
            if (str3.length() >= name.length() + 2) {
                if (OxI.XO0o(str3, str, false, 2, null)) {
                    return i2;
                }
                if (str3.charAt(0) == '`' && OxI.XO0o(str3, str2, false, 2, null)) {
                    return i2;
                }
            }
            i++;
            i2 = i3;
        }
        return -1;
    }
}
