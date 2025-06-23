package androidx.room;

import OXOo.OOXIXo;
import androidx.annotation.RestrictTo;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.oI0IIXIo;
import kotlin.jvm.internal.II0XooXoX;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
@XX({"SMAP\nEntityInsertionAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EntityInsertionAdapter.kt\nandroidx/room/EntityInsertionAdapter\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,229:1\n13579#2,2:230\n13644#2,3:237\n13579#2,2:240\n1855#3,2:232\n1864#3,3:234\n1855#3,2:242\n*S KotlinDebug\n*F\n+ 1 EntityInsertionAdapter.kt\nandroidx/room/EntityInsertionAdapter\n*L\n65#1:230,2\n137#1:237,3\n199#1:240,2\n82#1:232,2\n117#1:234,3\n219#1:242,2\n*E\n"})
public abstract class EntityInsertionAdapter<T> extends SharedSQLiteStatement {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EntityInsertionAdapter(@OOXIXo RoomDatabase roomDatabase) {
        super(roomDatabase);
        IIX0o.x0xO0oo(roomDatabase, "database");
    }

    public abstract void bind(@OOXIXo SupportSQLiteStatement supportSQLiteStatement, T t);

    public final void insert(T t) {
        SupportSQLiteStatement acquire = acquire();
        try {
            bind(acquire, t);
            acquire.executeInsert();
        } finally {
            release(acquire);
        }
    }

    public final long insertAndReturnId(T t) {
        SupportSQLiteStatement acquire = acquire();
        try {
            bind(acquire, t);
            return acquire.executeInsert();
        } finally {
            release(acquire);
        }
    }

    @OOXIXo
    public final long[] insertAndReturnIdsArray(@OOXIXo Collection<? extends T> collection) {
        IIX0o.x0xO0oo(collection, "entities");
        SupportSQLiteStatement acquire = acquire();
        try {
            long[] jArr = new long[collection.size()];
            int i = 0;
            for (Object next : collection) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt__CollectionsKt.XoX();
                }
                bind(acquire, next);
                jArr[i] = acquire.executeInsert();
                i = i2;
            }
            release(acquire);
            return jArr;
        } catch (Throwable th) {
            release(acquire);
            throw th;
        }
    }

    @OOXIXo
    public final Long[] insertAndReturnIdsArrayBox(@OOXIXo Collection<? extends T> collection) {
        IIX0o.x0xO0oo(collection, "entities");
        SupportSQLiteStatement acquire = acquire();
        Iterator<? extends T> it = collection.iterator();
        try {
            int size = collection.size();
            Long[] lArr = new Long[size];
            for (int i = 0; i < size; i++) {
                bind(acquire, it.next());
                lArr[i] = Long.valueOf(acquire.executeInsert());
            }
            return lArr;
        } finally {
            release(acquire);
        }
    }

    @OOXIXo
    public final List<Long> insertAndReturnIdsList(@OOXIXo T[] tArr) {
        IIX0o.x0xO0oo(tArr, "entities");
        SupportSQLiteStatement acquire = acquire();
        try {
            List xxIXOIIO2 = oI0IIXIo.xxIXOIIO();
            for (T bind : tArr) {
                bind(acquire, bind);
                xxIXOIIO2.add(Long.valueOf(acquire.executeInsert()));
            }
            List<Long> oIX0oI2 = oI0IIXIo.oIX0oI(xxIXOIIO2);
            release(acquire);
            return oIX0oI2;
        } catch (Throwable th) {
            release(acquire);
            throw th;
        }
    }

    public final void insert(@OOXIXo T[] tArr) {
        IIX0o.x0xO0oo(tArr, "entities");
        SupportSQLiteStatement acquire = acquire();
        try {
            for (T bind : tArr) {
                bind(acquire, bind);
                acquire.executeInsert();
            }
        } finally {
            release(acquire);
        }
    }

    @OOXIXo
    public final long[] insertAndReturnIdsArray(@OOXIXo T[] tArr) {
        IIX0o.x0xO0oo(tArr, "entities");
        SupportSQLiteStatement acquire = acquire();
        try {
            long[] jArr = new long[tArr.length];
            int length = tArr.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                int i3 = i2 + 1;
                bind(acquire, tArr[i]);
                jArr[i2] = acquire.executeInsert();
                i++;
                i2 = i3;
            }
            return jArr;
        } finally {
            release(acquire);
        }
    }

    @OOXIXo
    public final Long[] insertAndReturnIdsArrayBox(@OOXIXo T[] tArr) {
        IIX0o.x0xO0oo(tArr, "entities");
        SupportSQLiteStatement acquire = acquire();
        Iterator oIX0oI2 = II0XooXoX.oIX0oI(tArr);
        try {
            int length = tArr.length;
            Long[] lArr = new Long[length];
            for (int i = 0; i < length; i++) {
                bind(acquire, oIX0oI2.next());
                lArr[i] = Long.valueOf(acquire.executeInsert());
            }
            return lArr;
        } finally {
            release(acquire);
        }
    }

    @OOXIXo
    public final List<Long> insertAndReturnIdsList(@OOXIXo Collection<? extends T> collection) {
        IIX0o.x0xO0oo(collection, "entities");
        SupportSQLiteStatement acquire = acquire();
        try {
            List xxIXOIIO2 = oI0IIXIo.xxIXOIIO();
            for (Object bind : collection) {
                bind(acquire, bind);
                xxIXOIIO2.add(Long.valueOf(acquire.executeInsert()));
            }
            List<Long> oIX0oI2 = oI0IIXIo.oIX0oI(xxIXOIIO2);
            release(acquire);
            return oIX0oI2;
        } catch (Throwable th) {
            release(acquire);
            throw th;
        }
    }

    public final void insert(@OOXIXo Iterable<? extends T> iterable) {
        IIX0o.x0xO0oo(iterable, "entities");
        SupportSQLiteStatement acquire = acquire();
        try {
            for (Object bind : iterable) {
                bind(acquire, bind);
                acquire.executeInsert();
            }
        } finally {
            release(acquire);
        }
    }
}
