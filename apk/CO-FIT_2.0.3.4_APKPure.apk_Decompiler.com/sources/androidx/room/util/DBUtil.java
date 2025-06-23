package androidx.room.util;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.xxIXOIIO;
import android.database.AbstractWindowedCursor;
import android.database.Cursor;
import android.os.Build;
import android.os.CancellationSignal;
import androidx.annotation.RestrictTo;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteCompat;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.facebook.appevents.UserDataStore;
import java.io.Closeable;
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
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
@XX({"SMAP\nDBUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DBUtil.kt\nandroidx/room/util/DBUtil\n+ 2 CursorUtil.kt\nandroidx/room/util/CursorUtil\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,214:1\n145#2,7:215\n145#2,7:224\n1855#3,2:222\n*S KotlinDebug\n*F\n+ 1 DBUtil.kt\nandroidx/room/util/DBUtil\n*L\n100#1:215,7\n121#1:224,7\n107#1:222,2\n*E\n"})
public final class DBUtil {
    @oOoXoXO
    public static final CancellationSignal createCancellationSignal() {
        return SupportSQLiteCompat.Api16Impl.createCancellationSignal();
    }

    public static final void dropFtsSyncTriggers(@OOXIXo SupportSQLiteDatabase supportSQLiteDatabase) {
        IIX0o.x0xO0oo(supportSQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
        List xxIXOIIO2 = oI0IIXIo.xxIXOIIO();
        Closeable query = supportSQLiteDatabase.query("SELECT name FROM sqlite_master WHERE type = 'trigger'");
        try {
            Cursor cursor = (Cursor) query;
            while (cursor.moveToNext()) {
                xxIXOIIO2.add(cursor.getString(0));
            }
            oXIO0o0XI oxio0o0xi = oXIO0o0XI.f19155oIX0oI;
            II0xO0.oIX0oI(query, (Throwable) null);
            for (String str : oI0IIXIo.oIX0oI(xxIXOIIO2)) {
                IIX0o.oO(str, "triggerName");
                if (OxI.IOOoXo0Ix(str, "room_fts_content_sync_", false, 2, (Object) null)) {
                    supportSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS " + str);
                }
            }
        } catch (Throwable th) {
            II0xO0.oIX0oI(query, th);
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0043, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0044, code lost:
        kotlin.io.II0xO0.oIX0oI(r2, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0047, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void foreignKeyCheck(@OXOo.OOXIXo androidx.sqlite.db.SupportSQLiteDatabase r2, @OXOo.OOXIXo java.lang.String r3) {
        /*
            java.lang.String r0 = "db"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r2, r0)
            java.lang.String r0 = "tableName"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r3, r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "PRAGMA foreign_key_check(`"
            r0.append(r1)
            r0.append(r3)
            java.lang.String r3 = "`)"
            r0.append(r3)
            java.lang.String r3 = r0.toString()
            android.database.Cursor r2 = r2.query((java.lang.String) r3)
            java.io.Closeable r2 = (java.io.Closeable) r2
            r3 = r2
            android.database.Cursor r3 = (android.database.Cursor) r3     // Catch:{ all -> 0x0036 }
            int r0 = r3.getCount()     // Catch:{ all -> 0x0036 }
            if (r0 > 0) goto L_0x0038
            kotlin.oXIO0o0XI r3 = kotlin.oXIO0o0XI.f19155oIX0oI     // Catch:{ all -> 0x0036 }
            r3 = 0
            kotlin.io.II0xO0.oIX0oI(r2, r3)
            return
        L_0x0036:
            r3 = move-exception
            goto L_0x0042
        L_0x0038:
            java.lang.String r3 = processForeignKeyCheckFailure(r3)     // Catch:{ all -> 0x0036 }
            android.database.sqlite.SQLiteConstraintException r0 = new android.database.sqlite.SQLiteConstraintException     // Catch:{ all -> 0x0036 }
            r0.<init>(r3)     // Catch:{ all -> 0x0036 }
            throw r0     // Catch:{ all -> 0x0036 }
        L_0x0042:
            throw r3     // Catch:{ all -> 0x0043 }
        L_0x0043:
            r0 = move-exception
            kotlin.io.II0xO0.oIX0oI(r2, r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.util.DBUtil.foreignKeyCheck(androidx.sqlite.db.SupportSQLiteDatabase, java.lang.String):void");
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
            String string = cursor.getString(3);
            if (!linkedHashMap.containsKey(string)) {
                IIX0o.oO(string, "constraintIndex");
                String string2 = cursor.getString(2);
                IIX0o.oO(string2, "cursor.getString(2)");
                linkedHashMap.put(string, string2);
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
            sb.append("\tParent Table = ");
            sb.append((String) entry.getValue());
            sb.append(", Foreign Key Constraint Index = ");
            sb.append((String) entry.getKey());
            sb.append("\n");
        }
        String sb2 = sb.toString();
        IIX0o.oO(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    @kotlin.OOXIXo(message = "This is only used in the generated code and shouldn't be called directly.")
    @OOXIXo
    public static final Cursor query(@OOXIXo RoomDatabase roomDatabase, @OOXIXo SupportSQLiteQuery supportSQLiteQuery, boolean z) {
        IIX0o.x0xO0oo(roomDatabase, UserDataStore.DATE_OF_BIRTH);
        IIX0o.x0xO0oo(supportSQLiteQuery, "sqLiteQuery");
        return query(roomDatabase, supportSQLiteQuery, z, (CancellationSignal) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003e, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003f, code lost:
        kotlin.io.II0xO0.oIX0oI(r8, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0042, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final int readVersion(@OXOo.OOXIXo java.io.File r8) throws java.io.IOException {
        /*
            java.lang.String r0 = "databaseFile"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r8, r0)
            java.io.FileInputStream r0 = new java.io.FileInputStream
            r0.<init>(r8)
            java.nio.channels.FileChannel r8 = r0.getChannel()
            r0 = 4
            java.nio.ByteBuffer r7 = java.nio.ByteBuffer.allocate(r0)     // Catch:{ all -> 0x0033 }
            r4 = 4
            r6 = 1
            r2 = 60
            r1 = r8
            r1.tryLock(r2, r4, r6)     // Catch:{ all -> 0x0033 }
            r1 = 60
            r8.position(r1)     // Catch:{ all -> 0x0033 }
            int r1 = r8.read(r7)     // Catch:{ all -> 0x0033 }
            if (r1 != r0) goto L_0x0035
            r7.rewind()     // Catch:{ all -> 0x0033 }
            int r0 = r7.getInt()     // Catch:{ all -> 0x0033 }
            r1 = 0
            kotlin.io.II0xO0.oIX0oI(r8, r1)
            return r0
        L_0x0033:
            r0 = move-exception
            goto L_0x003d
        L_0x0035:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0033 }
            java.lang.String r1 = "Bad database header, unable to read 4 bytes at offset 60"
            r0.<init>(r1)     // Catch:{ all -> 0x0033 }
            throw r0     // Catch:{ all -> 0x0033 }
        L_0x003d:
            throw r0     // Catch:{ all -> 0x003e }
        L_0x003e:
            r1 = move-exception
            kotlin.io.II0xO0.oIX0oI(r8, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.util.DBUtil.readVersion(java.io.File):int");
    }

    @OOXIXo
    public static final Cursor query(@OOXIXo RoomDatabase roomDatabase, @OOXIXo SupportSQLiteQuery supportSQLiteQuery, boolean z, @oOoXoXO CancellationSignal cancellationSignal) {
        IIX0o.x0xO0oo(roomDatabase, UserDataStore.DATE_OF_BIRTH);
        IIX0o.x0xO0oo(supportSQLiteQuery, "sqLiteQuery");
        Cursor query = roomDatabase.query(supportSQLiteQuery, cancellationSignal);
        if (!z || !(query instanceof AbstractWindowedCursor)) {
            return query;
        }
        AbstractWindowedCursor abstractWindowedCursor = (AbstractWindowedCursor) query;
        int count = abstractWindowedCursor.getCount();
        return (Build.VERSION.SDK_INT < 23 || (abstractWindowedCursor.hasWindow() ? abstractWindowedCursor.getWindow().getNumRows() : count) < count) ? CursorUtil.copyAndClose(query) : query;
    }
}
