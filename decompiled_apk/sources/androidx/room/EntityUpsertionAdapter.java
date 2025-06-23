package androidx.room;

import android.database.sqlite.SQLiteConstraintException;
import androidx.annotation.RestrictTo;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.text.StringsKt__StringsKt;

@XX({"SMAP\nEntityUpsertionAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EntityUpsertionAdapter.kt\nandroidx/room/EntityUpsertionAdapter\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,224:1\n13579#2,2:225\n13579#2,2:229\n1855#3,2:227\n1855#3,2:231\n*S KotlinDebug\n*F\n+ 1 EntityUpsertionAdapter.kt\nandroidx/room/EntityUpsertionAdapter\n*L\n78#1:225,2\n151#1:229,2\n89#1:227,2\n165#1:231,2\n*E\n"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public final class EntityUpsertionAdapter<T> {

    @OXOo.OOXIXo
    private final EntityInsertionAdapter<T> insertionAdapter;

    @OXOo.OOXIXo
    private final EntityDeletionOrUpdateAdapter<T> updateAdapter;

    public EntityUpsertionAdapter(@OXOo.OOXIXo EntityInsertionAdapter<T> insertionAdapter, @OXOo.OOXIXo EntityDeletionOrUpdateAdapter<T> updateAdapter) {
        IIX0o.x0xO0oo(insertionAdapter, "insertionAdapter");
        IIX0o.x0xO0oo(updateAdapter, "updateAdapter");
        this.insertionAdapter = insertionAdapter;
        this.updateAdapter = updateAdapter;
    }

    private final void checkUniquenessException(SQLiteConstraintException sQLiteConstraintException) {
        String message = sQLiteConstraintException.getMessage();
        if (message != null) {
            if (!StringsKt__StringsKt.ooO0oXxI(message, "unique", true) && !StringsKt__StringsKt.o00xOoIO(message, "2067", false, 2, null) && !StringsKt__StringsKt.o00xOoIO(message, "1555", false, 2, null)) {
                throw sQLiteConstraintException;
            }
            return;
        }
        throw sQLiteConstraintException;
    }

    public final void upsert(T t) {
        try {
            this.insertionAdapter.insert((EntityInsertionAdapter<T>) t);
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
            return -1L;
        }
    }

    @OXOo.OOXIXo
    public final long[] upsertAndReturnIdsArray(@OXOo.OOXIXo T[] entities) {
        long j;
        IIX0o.x0xO0oo(entities, "entities");
        int length = entities.length;
        long[] jArr = new long[length];
        for (int i = 0; i < length; i++) {
            try {
                j = this.insertionAdapter.insertAndReturnId(entities[i]);
            } catch (SQLiteConstraintException e) {
                checkUniquenessException(e);
                this.updateAdapter.handle(entities[i]);
                j = -1;
            }
            jArr[i] = j;
        }
        return jArr;
    }

    @OXOo.OOXIXo
    public final Long[] upsertAndReturnIdsArrayBox(@OXOo.OOXIXo T[] entities) {
        long j;
        IIX0o.x0xO0oo(entities, "entities");
        int length = entities.length;
        Long[] lArr = new Long[length];
        for (int i = 0; i < length; i++) {
            try {
                j = this.insertionAdapter.insertAndReturnId(entities[i]);
            } catch (SQLiteConstraintException e) {
                checkUniquenessException(e);
                this.updateAdapter.handle(entities[i]);
                j = -1;
            }
            lArr[i] = Long.valueOf(j);
        }
        return lArr;
    }

    @OXOo.OOXIXo
    public final List<Long> upsertAndReturnIdsList(@OXOo.OOXIXo T[] entities) {
        IIX0o.x0xO0oo(entities, "entities");
        List xxIXOIIO2 = kotlin.collections.oI0IIXIo.xxIXOIIO();
        for (T t : entities) {
            try {
                xxIXOIIO2.add(Long.valueOf(this.insertionAdapter.insertAndReturnId(t)));
            } catch (SQLiteConstraintException e) {
                checkUniquenessException(e);
                this.updateAdapter.handle(t);
                xxIXOIIO2.add(-1L);
            }
        }
        return kotlin.collections.oI0IIXIo.oIX0oI(xxIXOIIO2);
    }

    public final void upsert(@OXOo.OOXIXo T[] entities) {
        IIX0o.x0xO0oo(entities, "entities");
        for (T t : entities) {
            try {
                this.insertionAdapter.insert((EntityInsertionAdapter<T>) t);
            } catch (SQLiteConstraintException e) {
                checkUniquenessException(e);
                this.updateAdapter.handle(t);
            }
        }
    }

    @OXOo.OOXIXo
    public final long[] upsertAndReturnIdsArray(@OXOo.OOXIXo Collection<? extends T> entities) {
        long j;
        IIX0o.x0xO0oo(entities, "entities");
        Iterator<? extends T> it = entities.iterator();
        int size = entities.size();
        long[] jArr = new long[size];
        for (int i = 0; i < size; i++) {
            T next = it.next();
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

    @OXOo.OOXIXo
    public final Long[] upsertAndReturnIdsArrayBox(@OXOo.OOXIXo Collection<? extends T> entities) {
        long j;
        IIX0o.x0xO0oo(entities, "entities");
        Iterator<? extends T> it = entities.iterator();
        int size = entities.size();
        Long[] lArr = new Long[size];
        for (int i = 0; i < size; i++) {
            T next = it.next();
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

    public final void upsert(@OXOo.OOXIXo Iterable<? extends T> entities) {
        IIX0o.x0xO0oo(entities, "entities");
        for (T t : entities) {
            try {
                this.insertionAdapter.insert((EntityInsertionAdapter<T>) t);
            } catch (SQLiteConstraintException e) {
                checkUniquenessException(e);
                this.updateAdapter.handle(t);
            }
        }
    }

    @OXOo.OOXIXo
    public final List<Long> upsertAndReturnIdsList(@OXOo.OOXIXo Collection<? extends T> entities) {
        IIX0o.x0xO0oo(entities, "entities");
        List xxIXOIIO2 = kotlin.collections.oI0IIXIo.xxIXOIIO();
        for (T t : entities) {
            try {
                xxIXOIIO2.add(Long.valueOf(this.insertionAdapter.insertAndReturnId(t)));
            } catch (SQLiteConstraintException e) {
                checkUniquenessException(e);
                this.updateAdapter.handle(t);
                xxIXOIIO2.add(-1L);
            }
        }
        return kotlin.collections.oI0IIXIo.oIX0oI(xxIXOIIO2);
    }
}
