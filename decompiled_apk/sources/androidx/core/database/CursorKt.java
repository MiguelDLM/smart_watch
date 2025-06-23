package androidx.core.database;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.database.Cursor;

/* loaded from: classes.dex */
public final class CursorKt {
    @oOoXoXO
    public static final byte[] getBlobOrNull(@OOXIXo Cursor cursor, int i) {
        if (cursor.isNull(i)) {
            return null;
        }
        return cursor.getBlob(i);
    }

    @oOoXoXO
    public static final Double getDoubleOrNull(@OOXIXo Cursor cursor, int i) {
        if (cursor.isNull(i)) {
            return null;
        }
        return Double.valueOf(cursor.getDouble(i));
    }

    @oOoXoXO
    public static final Float getFloatOrNull(@OOXIXo Cursor cursor, int i) {
        if (cursor.isNull(i)) {
            return null;
        }
        return Float.valueOf(cursor.getFloat(i));
    }

    @oOoXoXO
    public static final Integer getIntOrNull(@OOXIXo Cursor cursor, int i) {
        if (cursor.isNull(i)) {
            return null;
        }
        return Integer.valueOf(cursor.getInt(i));
    }

    @oOoXoXO
    public static final Long getLongOrNull(@OOXIXo Cursor cursor, int i) {
        if (cursor.isNull(i)) {
            return null;
        }
        return Long.valueOf(cursor.getLong(i));
    }

    @oOoXoXO
    public static final Short getShortOrNull(@OOXIXo Cursor cursor, int i) {
        if (cursor.isNull(i)) {
            return null;
        }
        return Short.valueOf(cursor.getShort(i));
    }

    @oOoXoXO
    public static final String getStringOrNull(@OOXIXo Cursor cursor, int i) {
        if (cursor.isNull(i)) {
            return null;
        }
        return cursor.getString(i);
    }
}
