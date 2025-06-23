package androidx.core.database.sqlite;

import OXOo.OOXIXo;
import Oox.oOoXoXO;
import android.database.sqlite.SQLiteDatabase;
import kotlin.jvm.internal.xxX;

public final class SQLiteDatabaseKt {
    public static final <T> T transaction(@OOXIXo SQLiteDatabase sQLiteDatabase, boolean z, @OOXIXo oOoXoXO<? super SQLiteDatabase, ? extends T> oooxoxo) {
        if (z) {
            sQLiteDatabase.beginTransaction();
        } else {
            sQLiteDatabase.beginTransactionNonExclusive();
        }
        try {
            T invoke = oooxoxo.invoke(sQLiteDatabase);
            sQLiteDatabase.setTransactionSuccessful();
            return invoke;
        } finally {
            xxX.oxoX(1);
            sQLiteDatabase.endTransaction();
            xxX.I0Io(1);
        }
    }

    public static /* synthetic */ Object transaction$default(SQLiteDatabase sQLiteDatabase, boolean z, oOoXoXO oooxoxo, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if (z) {
            sQLiteDatabase.beginTransaction();
        } else {
            sQLiteDatabase.beginTransactionNonExclusive();
        }
        try {
            Object invoke = oooxoxo.invoke(sQLiteDatabase);
            sQLiteDatabase.setTransactionSuccessful();
            return invoke;
        } finally {
            xxX.oxoX(1);
            sQLiteDatabase.endTransaction();
            xxX.I0Io(1);
        }
    }
}
