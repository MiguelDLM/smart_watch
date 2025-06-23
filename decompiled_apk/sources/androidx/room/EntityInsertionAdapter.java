package androidx.room;

import androidx.annotation.RestrictTo;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nEntityInsertionAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EntityInsertionAdapter.kt\nandroidx/room/EntityInsertionAdapter\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,229:1\n13579#2,2:230\n13644#2,3:237\n13579#2,2:240\n1855#3,2:232\n1864#3,3:234\n1855#3,2:242\n*S KotlinDebug\n*F\n+ 1 EntityInsertionAdapter.kt\nandroidx/room/EntityInsertionAdapter\n*L\n65#1:230,2\n137#1:237,3\n199#1:240,2\n82#1:232,2\n117#1:234,3\n219#1:242,2\n*E\n"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public abstract class EntityInsertionAdapter<T> extends SharedSQLiteStatement {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EntityInsertionAdapter(@OXOo.OOXIXo RoomDatabase database) {
        super(database);
        IIX0o.x0xO0oo(database, "database");
    }

    public abstract void bind(@OXOo.OOXIXo SupportSQLiteStatement supportSQLiteStatement, T t);

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

    @OXOo.OOXIXo
    public final long[] insertAndReturnIdsArray(@OXOo.OOXIXo Collection<? extends T> entities) {
        IIX0o.x0xO0oo(entities, "entities");
        SupportSQLiteStatement acquire = acquire();
        try {
            long[] jArr = new long[entities.size()];
            int i = 0;
            for (T t : entities) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt__CollectionsKt.XoX();
                }
                bind(acquire, t);
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

    @OXOo.OOXIXo
    public final Long[] insertAndReturnIdsArrayBox(@OXOo.OOXIXo Collection<? extends T> entities) {
        IIX0o.x0xO0oo(entities, "entities");
        SupportSQLiteStatement acquire = acquire();
        Iterator<? extends T> it = entities.iterator();
        try {
            int size = entities.size();
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

    @OXOo.OOXIXo
    public final List<Long> insertAndReturnIdsList(@OXOo.OOXIXo T[] entities) {
        IIX0o.x0xO0oo(entities, "entities");
        SupportSQLiteStatement acquire = acquire();
        try {
            List xxIXOIIO2 = kotlin.collections.oI0IIXIo.xxIXOIIO();
            for (T t : entities) {
                bind(acquire, t);
                xxIXOIIO2.add(Long.valueOf(acquire.executeInsert()));
            }
            List<Long> oIX0oI2 = kotlin.collections.oI0IIXIo.oIX0oI(xxIXOIIO2);
            release(acquire);
            return oIX0oI2;
        } catch (Throwable th) {
            release(acquire);
            throw th;
        }
    }

    public final void insert(@OXOo.OOXIXo T[] entities) {
        IIX0o.x0xO0oo(entities, "entities");
        SupportSQLiteStatement acquire = acquire();
        try {
            for (T t : entities) {
                bind(acquire, t);
                acquire.executeInsert();
            }
        } finally {
            release(acquire);
        }
    }

    @OXOo.OOXIXo
    public final long[] insertAndReturnIdsArray(@OXOo.OOXIXo T[] entities) {
        IIX0o.x0xO0oo(entities, "entities");
        SupportSQLiteStatement acquire = acquire();
        try {
            long[] jArr = new long[entities.length];
            int length = entities.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                int i3 = i2 + 1;
                bind(acquire, entities[i]);
                jArr[i2] = acquire.executeInsert();
                i++;
                i2 = i3;
            }
            return jArr;
        } finally {
            release(acquire);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @OXOo.OOXIXo
    public final Long[] insertAndReturnIdsArrayBox(@OXOo.OOXIXo T[] entities) {
        IIX0o.x0xO0oo(entities, "entities");
        SupportSQLiteStatement acquire = acquire();
        Iterator oIX0oI2 = kotlin.jvm.internal.II0XooXoX.oIX0oI(entities);
        try {
            int length = entities.length;
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

    @OXOo.OOXIXo
    public final List<Long> insertAndReturnIdsList(@OXOo.OOXIXo Collection<? extends T> entities) {
        IIX0o.x0xO0oo(entities, "entities");
        SupportSQLiteStatement acquire = acquire();
        try {
            List xxIXOIIO2 = kotlin.collections.oI0IIXIo.xxIXOIIO();
            Iterator<T> it = entities.iterator();
            while (it.hasNext()) {
                bind(acquire, it.next());
                xxIXOIIO2.add(Long.valueOf(acquire.executeInsert()));
            }
            List<Long> oIX0oI2 = kotlin.collections.oI0IIXIo.oIX0oI(xxIXOIIO2);
            release(acquire);
            return oIX0oI2;
        } catch (Throwable th) {
            release(acquire);
            throw th;
        }
    }

    public final void insert(@OXOo.OOXIXo Iterable<? extends T> entities) {
        IIX0o.x0xO0oo(entities, "entities");
        SupportSQLiteStatement acquire = acquire();
        try {
            Iterator<? extends T> it = entities.iterator();
            while (it.hasNext()) {
                bind(acquire, it.next());
                acquire.executeInsert();
            }
        } finally {
            release(acquire);
        }
    }
}
