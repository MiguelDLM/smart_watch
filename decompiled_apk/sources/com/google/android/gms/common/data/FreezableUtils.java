package com.google.android.gms.common.data;

import androidx.annotation.NonNull;
import com.jieli.jl_rcsp.tool.datahandles.DataInfoCache;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes9.dex */
public final class FreezableUtils {
    @NonNull
    public static <T, E extends Freezable<T>> ArrayList<T> freeze(@NonNull ArrayList<E> arrayList) {
        DataInfoCache dataInfoCache = (ArrayList<T>) new ArrayList(arrayList.size());
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            dataInfoCache.add(arrayList.get(i).freeze());
        }
        return dataInfoCache;
    }

    @NonNull
    public static <T, E extends Freezable<T>> ArrayList<T> freezeIterable(@NonNull Iterable<E> iterable) {
        DataInfoCache dataInfoCache = (ArrayList<T>) new ArrayList();
        Iterator<E> it = iterable.iterator();
        while (it.hasNext()) {
            dataInfoCache.add(it.next().freeze());
        }
        return dataInfoCache;
    }

    @NonNull
    public static <T, E extends Freezable<T>> ArrayList<T> freeze(@NonNull E[] eArr) {
        DataInfoCache dataInfoCache = (ArrayList<T>) new ArrayList(eArr.length);
        for (E e : eArr) {
            dataInfoCache.add(e.freeze());
        }
        return dataInfoCache;
    }
}
