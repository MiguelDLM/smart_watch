package androidx.room;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.io.Closeable;
import java.util.Set;
import kotlin.collections.oX;
import kotlin.io.II0xO0;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nInvalidationTracker.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InvalidationTracker.kt\nandroidx/room/InvalidationTracker$refreshRunnable$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 CursorUtil.kt\nandroidx/room/util/CursorUtil\n*L\n1#1,840:1\n1855#2,2:841\n145#3,7:843\n*S KotlinDebug\n*F\n+ 1 InvalidationTracker.kt\nandroidx/room/InvalidationTracker$refreshRunnable$1\n*L\n399#1:841,2\n408#1:843,7\n*E\n"})
public final class InvalidationTracker$refreshRunnable$1 implements Runnable {
    final /* synthetic */ InvalidationTracker this$0;

    public InvalidationTracker$refreshRunnable$1(InvalidationTracker invalidationTracker) {
        this.this$0 = invalidationTracker;
    }

    private final Set<Integer> checkUpdatedTable() {
        InvalidationTracker invalidationTracker = this.this$0;
        Set oxoX2 = oX.oxoX();
        Closeable query$default = RoomDatabase.query$default(invalidationTracker.getDatabase$room_runtime_release(), new SimpleSQLiteQuery(InvalidationTracker.SELECT_UPDATED_TABLES_SQL), (CancellationSignal) null, 2, (Object) null);
        try {
            Cursor cursor = (Cursor) query$default;
            while (cursor.moveToNext()) {
                oxoX2.add(Integer.valueOf(cursor.getInt(0)));
            }
            oXIO0o0XI oxio0o0xi = oXIO0o0XI.f19155oIX0oI;
            II0xO0.oIX0oI(query$default, (Throwable) null);
            Set<Integer> oIX0oI2 = oX.oIX0oI(oxoX2);
            if (!oIX0oI2.isEmpty()) {
                if (this.this$0.getCleanupStatement$room_runtime_release() != null) {
                    SupportSQLiteStatement cleanupStatement$room_runtime_release = this.this$0.getCleanupStatement$room_runtime_release();
                    if (cleanupStatement$room_runtime_release != null) {
                        cleanupStatement$room_runtime_release.executeUpdateDelete();
                    } else {
                        throw new IllegalArgumentException("Required value was null.");
                    }
                } else {
                    throw new IllegalStateException("Required value was null.");
                }
            }
            return oIX0oI2;
        } catch (Throwable th) {
            II0xO0.oIX0oI(query$default, th);
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0080, code lost:
        if (r0 != null) goto L_0x0082;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0082, code lost:
        r0.decrementCountAndScheduleClose();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00a6, code lost:
        if (r0 == null) goto L_0x00c0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00bd, code lost:
        if (r0 == null) goto L_0x00c0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00c4, code lost:
        if (r2.isEmpty() != false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00c6, code lost:
        r0 = r4.this$0.getObserverMap$room_runtime_release();
        r1 = r4.this$0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00ce, code lost:
        monitor-enter(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:?, code lost:
        r1 = r1.getObserverMap$room_runtime_release().iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00db, code lost:
        if (r1.hasNext() == false) goto L_0x00ef;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00dd, code lost:
        ((androidx.room.InvalidationTracker.ObserverWrapper) ((java.util.Map.Entry) r1.next()).getValue()).notifyByTableInvalidStatus$room_runtime_release(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00ed, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00ef, code lost:
        r1 = kotlin.oXIO0o0XI.f19155oIX0oI;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00f1, code lost:
        monitor-exit(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00f4, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r4 = this;
            androidx.room.InvalidationTracker r0 = r4.this$0
            androidx.room.RoomDatabase r0 = r0.getDatabase$room_runtime_release()
            java.util.concurrent.locks.Lock r0 = r0.getCloseLock$room_runtime_release()
            r0.lock()
            androidx.room.InvalidationTracker r1 = r4.this$0     // Catch:{ IllegalStateException -> 0x008b, SQLiteException -> 0x0089 }
            boolean r1 = r1.ensureInitialization$room_runtime_release()     // Catch:{ IllegalStateException -> 0x008b, SQLiteException -> 0x0089 }
            if (r1 != 0) goto L_0x0024
            r0.unlock()
            androidx.room.InvalidationTracker r0 = r4.this$0
            androidx.room.AutoCloser r0 = r0.autoCloser
            if (r0 == 0) goto L_0x0023
            r0.decrementCountAndScheduleClose()
        L_0x0023:
            return
        L_0x0024:
            androidx.room.InvalidationTracker r1 = r4.this$0     // Catch:{ IllegalStateException -> 0x008b, SQLiteException -> 0x0089 }
            java.util.concurrent.atomic.AtomicBoolean r1 = r1.getPendingRefresh()     // Catch:{ IllegalStateException -> 0x008b, SQLiteException -> 0x0089 }
            r2 = 1
            r3 = 0
            boolean r1 = r1.compareAndSet(r2, r3)     // Catch:{ IllegalStateException -> 0x008b, SQLiteException -> 0x0089 }
            if (r1 != 0) goto L_0x0041
            r0.unlock()
            androidx.room.InvalidationTracker r0 = r4.this$0
            androidx.room.AutoCloser r0 = r0.autoCloser
            if (r0 == 0) goto L_0x0040
            r0.decrementCountAndScheduleClose()
        L_0x0040:
            return
        L_0x0041:
            androidx.room.InvalidationTracker r1 = r4.this$0     // Catch:{ IllegalStateException -> 0x008b, SQLiteException -> 0x0089 }
            androidx.room.RoomDatabase r1 = r1.getDatabase$room_runtime_release()     // Catch:{ IllegalStateException -> 0x008b, SQLiteException -> 0x0089 }
            boolean r1 = r1.inTransaction()     // Catch:{ IllegalStateException -> 0x008b, SQLiteException -> 0x0089 }
            if (r1 == 0) goto L_0x005c
            r0.unlock()
            androidx.room.InvalidationTracker r0 = r4.this$0
            androidx.room.AutoCloser r0 = r0.autoCloser
            if (r0 == 0) goto L_0x005b
            r0.decrementCountAndScheduleClose()
        L_0x005b:
            return
        L_0x005c:
            androidx.room.InvalidationTracker r1 = r4.this$0     // Catch:{ IllegalStateException -> 0x008b, SQLiteException -> 0x0089 }
            androidx.room.RoomDatabase r1 = r1.getDatabase$room_runtime_release()     // Catch:{ IllegalStateException -> 0x008b, SQLiteException -> 0x0089 }
            androidx.sqlite.db.SupportSQLiteOpenHelper r1 = r1.getOpenHelper()     // Catch:{ IllegalStateException -> 0x008b, SQLiteException -> 0x0089 }
            androidx.sqlite.db.SupportSQLiteDatabase r1 = r1.getWritableDatabase()     // Catch:{ IllegalStateException -> 0x008b, SQLiteException -> 0x0089 }
            r1.beginTransactionNonExclusive()     // Catch:{ IllegalStateException -> 0x008b, SQLiteException -> 0x0089 }
            java.util.Set r2 = r4.checkUpdatedTable()     // Catch:{ all -> 0x008d }
            r1.setTransactionSuccessful()     // Catch:{ all -> 0x008d }
            r1.endTransaction()     // Catch:{ IllegalStateException -> 0x008b, SQLiteException -> 0x0089 }
            r0.unlock()
            androidx.room.InvalidationTracker r0 = r4.this$0
            androidx.room.AutoCloser r0 = r0.autoCloser
            if (r0 == 0) goto L_0x00c0
        L_0x0082:
            r0.decrementCountAndScheduleClose()
            goto L_0x00c0
        L_0x0086:
            r1 = move-exception
            goto L_0x00f6
        L_0x0089:
            r1 = move-exception
            goto L_0x0092
        L_0x008b:
            r1 = move-exception
            goto L_0x00a9
        L_0x008d:
            r2 = move-exception
            r1.endTransaction()     // Catch:{ IllegalStateException -> 0x008b, SQLiteException -> 0x0089 }
            throw r2     // Catch:{ IllegalStateException -> 0x008b, SQLiteException -> 0x0089 }
        L_0x0092:
            java.lang.String r2 = "ROOM"
            java.lang.String r3 = "Cannot run invalidation tracker. Is the db closed?"
            android.util.Log.e(r2, r3, r1)     // Catch:{ all -> 0x0086 }
            java.util.Set r2 = kotlin.collections.Xo0.OOXIXo()     // Catch:{ all -> 0x0086 }
            r0.unlock()
            androidx.room.InvalidationTracker r0 = r4.this$0
            androidx.room.AutoCloser r0 = r0.autoCloser
            if (r0 == 0) goto L_0x00c0
            goto L_0x0082
        L_0x00a9:
            java.lang.String r2 = "ROOM"
            java.lang.String r3 = "Cannot run invalidation tracker. Is the db closed?"
            android.util.Log.e(r2, r3, r1)     // Catch:{ all -> 0x0086 }
            java.util.Set r2 = kotlin.collections.Xo0.OOXIXo()     // Catch:{ all -> 0x0086 }
            r0.unlock()
            androidx.room.InvalidationTracker r0 = r4.this$0
            androidx.room.AutoCloser r0 = r0.autoCloser
            if (r0 == 0) goto L_0x00c0
            goto L_0x0082
        L_0x00c0:
            boolean r0 = r2.isEmpty()
            if (r0 != 0) goto L_0x00f5
            androidx.room.InvalidationTracker r0 = r4.this$0
            androidx.arch.core.internal.SafeIterableMap r0 = r0.getObserverMap$room_runtime_release()
            androidx.room.InvalidationTracker r1 = r4.this$0
            monitor-enter(r0)
            androidx.arch.core.internal.SafeIterableMap r1 = r1.getObserverMap$room_runtime_release()     // Catch:{ all -> 0x00ed }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x00ed }
        L_0x00d7:
            boolean r3 = r1.hasNext()     // Catch:{ all -> 0x00ed }
            if (r3 == 0) goto L_0x00ef
            java.lang.Object r3 = r1.next()     // Catch:{ all -> 0x00ed }
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3     // Catch:{ all -> 0x00ed }
            java.lang.Object r3 = r3.getValue()     // Catch:{ all -> 0x00ed }
            androidx.room.InvalidationTracker$ObserverWrapper r3 = (androidx.room.InvalidationTracker.ObserverWrapper) r3     // Catch:{ all -> 0x00ed }
            r3.notifyByTableInvalidStatus$room_runtime_release(r2)     // Catch:{ all -> 0x00ed }
            goto L_0x00d7
        L_0x00ed:
            r1 = move-exception
            goto L_0x00f3
        L_0x00ef:
            kotlin.oXIO0o0XI r1 = kotlin.oXIO0o0XI.f19155oIX0oI     // Catch:{ all -> 0x00ed }
            monitor-exit(r0)
            goto L_0x00f5
        L_0x00f3:
            monitor-exit(r0)
            throw r1
        L_0x00f5:
            return
        L_0x00f6:
            r0.unlock()
            androidx.room.InvalidationTracker r0 = r4.this$0
            androidx.room.AutoCloser r0 = r0.autoCloser
            if (r0 == 0) goto L_0x0104
            r0.decrementCountAndScheduleClose()
        L_0x0104:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.InvalidationTracker$refreshRunnable$1.run():void");
    }
}
