package androidx.room.util;

import OXOo.OOXIXo;
import Oox.oOoXoXO;
import XO0OX.xxIXOIIO;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.os.Build;
import android.util.Log;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import java.io.Closeable;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.io.II0xO0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.text.OxI;

@xxIXOIIO(name = "CursorUtil")
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
@XX({"SMAP\nCursorUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CursorUtil.kt\nandroidx/room/util/CursorUtil\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,184:1\n145#1,7:185\n13644#2,3:192\n1#3:195\n*S KotlinDebug\n*F\n+ 1 CursorUtil.kt\nandroidx/room/util/CursorUtil\n*L\n39#1:185,7\n127#1:192,3\n*E\n"})
public final class CursorUtil {
    @OOXIXo
    public static final Cursor copyAndClose(@OOXIXo Cursor cursor) {
        IIX0o.x0xO0oo(cursor, "c");
        Closeable closeable = cursor;
        try {
            Cursor cursor2 = (Cursor) closeable;
            MatrixCursor matrixCursor = new MatrixCursor(cursor2.getColumnNames(), cursor2.getCount());
            while (cursor2.moveToNext()) {
                Object[] objArr = new Object[cursor2.getColumnCount()];
                int columnCount = cursor.getColumnCount();
                for (int i = 0; i < columnCount; i++) {
                    int type = cursor2.getType(i);
                    if (type == 0) {
                        objArr[i] = null;
                    } else if (type == 1) {
                        objArr[i] = Long.valueOf(cursor2.getLong(i));
                    } else if (type == 2) {
                        objArr[i] = Double.valueOf(cursor2.getDouble(i));
                    } else if (type == 3) {
                        objArr[i] = cursor2.getString(i);
                    } else if (type == 4) {
                        objArr[i] = cursor2.getBlob(i);
                    } else {
                        throw new IllegalStateException();
                    }
                }
                matrixCursor.addRow(objArr);
            }
            II0xO0.oIX0oI(closeable, (Throwable) null);
            return matrixCursor;
        } catch (Throwable th) {
            II0xO0.oIX0oI(closeable, th);
            throw th;
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

    public static final int getColumnIndex(@OOXIXo Cursor cursor, @OOXIXo String str) {
        IIX0o.x0xO0oo(cursor, "c");
        IIX0o.x0xO0oo(str, "name");
        int columnIndex = cursor.getColumnIndex(str);
        if (columnIndex >= 0) {
            return columnIndex;
        }
        int columnIndex2 = cursor.getColumnIndex('`' + str + '`');
        if (columnIndex2 >= 0) {
            return columnIndex2;
        }
        return findColumnIndexBySuffix(cursor, str);
    }

    public static final int getColumnIndexOrThrow(@OOXIXo Cursor cursor, @OOXIXo String str) {
        String str2;
        IIX0o.x0xO0oo(cursor, "c");
        IIX0o.x0xO0oo(str, "name");
        int columnIndex = getColumnIndex(cursor, str);
        if (columnIndex >= 0) {
            return columnIndex;
        }
        try {
            String[] columnNames = cursor.getColumnNames();
            IIX0o.oO(columnNames, "c.columnNames");
            str2 = ArraysKt___ArraysKt.OIx0IoOx0(columnNames, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (oOoXoXO) null, 63, (Object) null);
        } catch (Exception e) {
            Log.d("RoomCursorUtil", "Cannot collect column names for debug purposes", e);
            str2 = "unknown";
        }
        throw new IllegalArgumentException("column '" + str + "' does not exist. Available columns: " + str2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0028, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001e, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001f, code lost:
        kotlin.jvm.internal.xxX.oxoX(1);
        kotlin.io.II0xO0.oIX0oI(r2, r3);
        kotlin.jvm.internal.xxX.I0Io(1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <R> R useCursor(@OXOo.OOXIXo android.database.Cursor r2, @OXOo.OOXIXo Oox.oOoXoXO<? super android.database.Cursor, ? extends R> r3) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r2, r0)
            java.lang.String r0 = "block"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r3, r0)
            java.io.Closeable r2 = (java.io.Closeable) r2
            r0 = 1
            java.lang.Object r3 = r3.invoke(r2)     // Catch:{ all -> 0x001c }
            kotlin.jvm.internal.xxX.oxoX(r0)
            r1 = 0
            kotlin.io.II0xO0.oIX0oI(r2, r1)
            kotlin.jvm.internal.xxX.I0Io(r0)
            return r3
        L_0x001c:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x001e }
        L_0x001e:
            r1 = move-exception
            kotlin.jvm.internal.xxX.oxoX(r0)
            kotlin.io.II0xO0.oIX0oI(r2, r3)
            kotlin.jvm.internal.xxX.I0Io(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.util.CursorUtil.useCursor(android.database.Cursor, Oox.oOoXoXO):java.lang.Object");
    }

    @OOXIXo
    public static final Cursor wrapMappedColumns(@OOXIXo Cursor cursor, @OOXIXo String[] strArr, @OOXIXo int[] iArr) {
        IIX0o.x0xO0oo(cursor, "cursor");
        IIX0o.x0xO0oo(strArr, "columnNames");
        IIX0o.x0xO0oo(iArr, "mapping");
        if (strArr.length == iArr.length) {
            return new CursorUtil$wrapMappedColumns$2(cursor, strArr, iArr);
        }
        throw new IllegalStateException("Expected columnNames.length == mapping.length");
    }

    @VisibleForTesting
    public static final int findColumnIndexBySuffix(@OOXIXo String[] strArr, @OOXIXo String str) {
        IIX0o.x0xO0oo(strArr, "columnNames");
        IIX0o.x0xO0oo(str, "name");
        String str2 = '.' + str;
        String str3 = '.' + str + '`';
        int length = strArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            String str4 = strArr[i];
            int i3 = i2 + 1;
            if (str4.length() >= str.length() + 2) {
                if (OxI.XO0o(str4, str2, false, 2, (Object) null)) {
                    return i2;
                }
                if (str4.charAt(0) == '`' && OxI.XO0o(str4, str3, false, 2, (Object) null)) {
                    return i2;
                }
            }
            i++;
            i2 = i3;
        }
        return -1;
    }
}
