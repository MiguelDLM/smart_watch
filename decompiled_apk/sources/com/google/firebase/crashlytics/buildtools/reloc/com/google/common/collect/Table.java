package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.annotations.GwtCompatible;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.errorprone.annotations.CompatibleWith;
import com.google.firebase.crashlytics.buildtools.reloc.org.checkerframework.checker.nullness.compatqual.NullableDecl;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

@GwtCompatible
/* loaded from: classes10.dex */
public interface Table<R, C, V> {

    /* loaded from: classes10.dex */
    public interface Cell<R, C, V> {
        boolean equals(@NullableDecl Object obj);

        @NullableDecl
        C getColumnKey();

        @NullableDecl
        R getRowKey();

        @NullableDecl
        V getValue();

        int hashCode();
    }

    Set<Cell<R, C, V>> cellSet();

    void clear();

    Map<R, V> column(C c);

    Set<C> columnKeySet();

    Map<C, Map<R, V>> columnMap();

    boolean contains(@CompatibleWith("R") @NullableDecl Object obj, @CompatibleWith("C") @NullableDecl Object obj2);

    boolean containsColumn(@CompatibleWith("C") @NullableDecl Object obj);

    boolean containsRow(@CompatibleWith("R") @NullableDecl Object obj);

    boolean containsValue(@CompatibleWith("V") @NullableDecl Object obj);

    boolean equals(@NullableDecl Object obj);

    V get(@CompatibleWith("R") @NullableDecl Object obj, @CompatibleWith("C") @NullableDecl Object obj2);

    int hashCode();

    boolean isEmpty();

    @CanIgnoreReturnValue
    @NullableDecl
    V put(R r, C c, V v);

    void putAll(Table<? extends R, ? extends C, ? extends V> table);

    @CanIgnoreReturnValue
    @NullableDecl
    V remove(@CompatibleWith("R") @NullableDecl Object obj, @CompatibleWith("C") @NullableDecl Object obj2);

    Map<C, V> row(R r);

    Set<R> rowKeySet();

    Map<R, Map<C, V>> rowMap();

    int size();

    Collection<V> values();
}
