package androidx.room.util;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.xxIXOIIO;
import android.database.AbstractWindowedCursor;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.os.Build;
import android.os.CancellationSignal;
import androidx.annotation.RestrictTo;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteCompat;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteQuery;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.oI0IIXIo;
import kotlin.io.II0xO0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import kotlin.text.OxI;

@xxIXOIIO(name = "DBUtil")
@XX({"SMAP\nDBUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DBUtil.kt\nandroidx/room/util/DBUtil\n+ 2 CursorUtil.kt\nandroidx/room/util/CursorUtil\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,214:1\n145#2,7:215\n145#2,7:224\n1855#3,2:222\n*S KotlinDebug\n*F\n+ 1 DBUtil.kt\nandroidx/room/util/DBUtil\n*L\n100#1:215,7\n121#1:224,7\n107#1:222,2\n*E\n"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public final class DBUtil {
    @oOoXoXO
    public static final CancellationSignal createCancellationSignal() {
        return SupportSQLiteCompat.Api16Impl.createCancellationSignal();
    }

    public static final void dropFtsSyncTriggers(@OOXIXo SupportSQLiteDatabase db) {
        IIX0o.x0xO0oo(db, "db");
        List xxIXOIIO2 = oI0IIXIo.xxIXOIIO();
        Cursor query = db.query("SELECT name FROM sqlite_master WHERE type = 'trigger'");
        try {
            Cursor cursor = query;
            while (cursor.moveToNext()) {
                xxIXOIIO2.add(cursor.getString(0));
            }
            oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
            II0xO0.oIX0oI(query, null);
            for (String triggerName : oI0IIXIo.oIX0oI(xxIXOIIO2)) {
                IIX0o.oO(triggerName, "triggerName");
                if (OxI.IOOoXo0Ix(triggerName, "room_fts_content_sync_", false, 2, null)) {
                    db.execSQL("DROP TRIGGER IF EXISTS " + triggerName);
                }
            }
        } finally {
        }
    }

    public static final void foreignKeyCheck(@OOXIXo SupportSQLiteDatabase db, @OOXIXo String tableName) {
        IIX0o.x0xO0oo(db, "db");
        IIX0o.x0xO0oo(tableName, "tableName");
        Cursor query = db.query("PRAGMA foreign_key_check(`" + tableName + "`)");
        try {
            Cursor cursor = query;
            if (cursor.getCount() <= 0) {
                oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
                II0xO0.oIX0oI(query, null);
                return;
            }
            throw new SQLiteConstraintException(processForeignKeyCheckFailure(cursor));
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                II0xO0.oIX0oI(query, th);
                throw th2;
            }
        }
    }

    private static final String processForeignKeyCheckFailure(Cursor cursor) {
        StringBuilder sb = new StringBuilder();
        int count = cursor.getCount();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        while (cursor.moveToNext()) {
            if (cursor.isFirst()) {
                sb.append("Foreign key violation(s) detected in '");
                sb.append(cursor.getString(0));
                sb.append("'.\n");
            }
            String constraintIndex = cursor.getString(3);
            if (!linkedHashMap.containsKey(constraintIndex)) {
                IIX0o.oO(constraintIndex, "constraintIndex");
                String string = cursor.getString(2);
                IIX0o.oO(string, "cursor.getString(2)");
                linkedHashMap.put(constraintIndex, string);
            }
        }
        sb.append("Number of different violations discovered: ");
        sb.append(linkedHashMap.keySet().size());
        sb.append("\n");
        sb.append("Number of rows in violation: ");
        sb.append(count);
        sb.append("\n");
        sb.append("Violation(s) detected in the following constraint(s):\n");
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) entry.getValue();
            sb.append("\tParent Table = ");
            sb.append(str2);
            sb.append(", Foreign Key Constraint Index = ");
            sb.append(str);
            sb.append("\n");
        }
        String sb2 = sb.toString();
        IIX0o.oO(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    @kotlin.OOXIXo(message = "This is only used in the generated code and shouldn't be called directly.")
    @OOXIXo
    public static final Cursor query(@OOXIXo RoomDatabase db, @OOXIXo SupportSQLiteQuery sqLiteQuery, boolean z) {
        IIX0o.x0xO0oo(db, "db");
        IIX0o.x0xO0oo(sqLiteQuery, "sqLiteQuery");
        return query(db, sqLiteQuery, z, null);
    }

    public static final int readVersion(@OOXIXo File databaseFile) throws IOException {
        IIX0o.x0xO0oo(databaseFile, "databaseFile");
        FileChannel channel = new FileInputStream(databaseFile).getChannel();
        try {
            ByteBuffer allocate = ByteBuffer.allocate(4);
            channel.tryLock(60L, 4L, true);
            channel.position(60L);
            if (channel.read(allocate) == 4) {
                allocate.rewind();
                int i = allocate.getInt();
                II0xO0.oIX0oI(channel, null);
                return i;
            }
            throw new IOException("Bad database header, unable to read 4 bytes at offset 60");
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                II0xO0.oIX0oI(channel, th);
                throw th2;
            }
        }
    }

    @OOXIXo
    public static final Cursor query(@OOXIXo RoomDatabase db, @OOXIXo SupportSQLiteQuery sqLiteQuery, boolean z, @oOoXoXO CancellationSignal cancellationSignal) {
        IIX0o.x0xO0oo(db, "db");
        IIX0o.x0xO0oo(sqLiteQuery, "sqLiteQuery");
        Cursor query = db.query(sqLiteQuery, cancellationSignal);
        if (!z || !(query instanceof AbstractWindowedCursor)) {
            return query;
        }
        AbstractWindowedCursor abstractWindowedCursor = (AbstractWindowedCursor) query;
        int count = abstractWindowedCursor.getCount();
        return (Build.VERSION.SDK_INT < 23 || (abstractWindowedCursor.hasWindow() ? abstractWindowedCursor.getWindow().getNumRows() : count) < count) ? CursorUtil.copyAndClose(query) : query;
    }
}
