package androidx.room;

import OXOo.OOXIXo;
import android.database.sqlite.SQLiteConstraintException;
import androidx.annotation.RestrictTo;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.oI0IIXIo;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.text.StringsKt__StringsKt;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
@XX({"SMAP\nEntityUpsertionAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EntityUpsertionAdapter.kt\nandroidx/room/EntityUpsertionAdapter\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,224:1\n13579#2,2:225\n13579#2,2:229\n1855#3,2:227\n1855#3,2:231\n*S KotlinDebug\n*F\n+ 1 EntityUpsertionAdapter.kt\nandroidx/room/EntityUpsertionAdapter\n*L\n78#1:225,2\n151#1:229,2\n89#1:227,2\n165#1:231,2\n*E\n"})
public final class EntityUpsertionAdapter<T> {
    @OOXIXo
    private final EntityInsertionAdapter<T> insertionAdapter;
    @OOXIXo
    private final EntityDeletionOrUpdateAdapter<T> updateAdapter;

    public EntityUpsertionAdapter(@OOXIXo EntityInsertionAdapter<T> entityInsertionAdapter, @OOXIXo EntityDeletionOrUpdateAdapter<T> entityDeletionOrUpdateAdapter) {
        IIX0o.x0xO0oo(entityInsertionAdapter, "insertionAdapter");
        IIX0o.x0xO0oo(entityDeletionOrUpdateAdapter, "updateAdapter");
        this.insertionAdapter = entityInsertionAdapter;
        this.updateAdapter = entityDeletionOrUpdateAdapter;
    }

    private final void checkUniquenessException(SQLiteConstraintException sQLiteConstraintException) {
        String message = sQLiteConstraintException.getMessage();
        if (message == null) {
            throw sQLiteConstraintException;
        } else if (!StringsKt__StringsKt.ooO0oXxI(message, "unique", true) && !StringsKt__StringsKt.o00xOoIO(message, "2067", false, 2, (Object) null) && !StringsKt__StringsKt.o00xOoIO(message, "1555", false, 2, (Object) null)) {
            throw sQLiteConstraintException;
        }
    }

    public final void upsert(T t) {
        try {
            this.insertionAdapter.insert(t);
        } catch (SQLiteConstraintException e) {
            checkUniquenessException(e);
            this.updateAdapter.handle(t);
        }
    }

    public final long upsertAndReturnId(T t) {
        try {
            return this.insertionAdapter.insertAndReturnId(t);
        } catch (SQLiteConstraintException e) {
            checkUniquenessException(e);
            this.updateAdapter.handle(t);
            return -1;
        }
    }

    @OOXIXo
    public final long[] upsertAndReturnIdsArray(@OOXIXo T[] tArr) {
        long j;
        IIX0o.x0xO0oo(tArr, "entities");
        int length = tArr.length;
        long[] jArr = new long[length];
        for (int i = 0; i < length; i++) {
            try {
                j = this.insertionAdapter.insertAndReturnId(tArr[i]);
            } catch (SQLiteConstraintException e) {
                checkUniquenessException(e);
                this.updateAdapter.handle(tArr[i]);
                j = -1;
            }
            jArr[i] = j;
        }
        return jArr;
    }

    @OOXIXo
    public final Long[] upsertAndReturnIdsArrayBox(@OOXIXo T[] tArr) {
        long j;
        IIX0o.x0xO0oo(tArr, "entities");
        int length = tArr.length;
        Long[] lArr = new Long[length];
        for (int i = 0; i < length; i++) {
            try {
                j = this.insertionAdapter.insertAndReturnId(tArr[i]);
            } catch (SQLiteConstraintException e) {
                checkUniquenessException(e);
                this.updateAdapter.handle(tArr[i]);
                j = -1;
            }
            lArr[i] = Long.valueOf(j);
        }
        return lArr;
    }

    @OOXIXo
    public final List<Long> upsertAndReturnIdsList(@OOXIXo T[] tArr) {
        IIX0o.x0xO0oo(tArr, "entities");
        List xxIXOIIO2 = oI0IIXIo.xxIXOIIO();
        for (T t : tArr) {
            try {
                xxIXOIIO2.add(Long.valueOf(this.insertionAdapter.insertAndReturnId(t)));
            } catch (SQLiteConstraintException e) {
                checkUniquenessException(e);
                this.updateAdapter.handle(t);
                xxIXOIIO2.add(-1L);
            }
        }
        return oI0IIXIo.oIX0oI(xxIXOIIO2);
    }

    public final void upsert(@OOXIXo T[] tArr) {
        IIX0o.x0xO0oo(tArr, "entities");
        for (T t : tArr) {
            try {
                this.insertionAdapter.insert(t);
            } catch (SQLiteConstraintException e) {
                checkUniquenessException(e);
                this.updateAdapter.handle(t);
            }
        }
    }

    @OOXIXo
    public final long[] upsertAndReturnIdsArray(@OOXIXo Collection<? extends T> collection) {
        long j;
        IIX0o.x0xO0oo(collection, "entities");
        Iterator<? extends T> it = collection.iterator();
        int size = collection.size();
        long[] jArr = new long[size];
        for (int i = 0; i < size; i++) {
            Object next = it.next();
            try {
                j = this.insertionAdapter.insertAndReturnId(next);
            } catch (SQLiteConstraintException e) {
                checkUniquenessException(e);
                this.updateAdapter.handle(next);
                j = -1;
            }
            jArr[i] = j;
        }
        return jArr;
    }

    @OOXIXo
    public final Long[] upsertAndReturnIdsArrayBox(@OOXIXo Collection<? extends T> collection) {
        long j;
        IIX0o.x0xO0oo(collection, "entities");
        Iterator<? extends T> it = collection.iterator();
        int size = collection.size();
        Long[] lArr = new Long[size];
        for (int i = 0; i < size; i++) {
            Object next = it.next();
            try {
                j = this.insertionAdapter.insertAndReturnId(next);
            } catch (SQLiteConstraintException e) {
                checkUniquenessException(e);
                this.updateAdapter.handle(next);
                j = -1;
            }
            lArr[i] = Long.valueOf(j);
        }
        return lArr;
    }

    public final void upsert(@OOXIXo Iterable<? extends T> iterable) {
        IIX0o.x0xO0oo(iterable, "entities");
        for (Object next : iterable) {
            try {
                this.insertionAdapter.insert(next);
            } catch (SQLiteConstraintException e) {
                checkUniquenessException(e);
                this.updateAdapter.handle(next);
            }
        }
    }

    @OOXIXo
    public final List<Long> upsertAndReturnIdsList(@OOXIXo Collection<? extends T> collection) {
        IIX0o.x0xO0oo(collection, "entities");
        List xxIXOIIO2 = oI0IIXIo.xxIXOIIO();
        for (Object next : collection) {
            try {
                xxIXOIIO2.add(Long.valueOf(this.insertionAdapter.insertAndReturnId(next)));
            } catch (SQLiteConstraintException e) {
                checkUniquenessException(e);
                this.updateAdapter.handle(next);
                xxIXOIIO2.add(-1L);
            }
        }
        return oI0IIXIo.oIX0oI(xxIXOIIO2);
    }
}
