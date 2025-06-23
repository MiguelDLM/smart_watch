package com.huawei.openalliance.ad.utils;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/* loaded from: classes10.dex */
public abstract class ad {
    public static String Code(List<String> list, String str) {
        if (Code(list)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            sb.append(str);
        }
        return sb.toString();
    }

    public static Set<String> Code(List<String> list, boolean z) {
        if (Code(list)) {
            return null;
        }
        HashSet hashSet = new HashSet();
        if (z) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                hashSet.add(it.next().toUpperCase(Locale.ENGLISH));
            }
        } else {
            hashSet.addAll(list);
        }
        return hashSet;
    }

    public static <T> boolean Code(Collection<T> collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean Code(int[] iArr) {
        return iArr == null || iArr.length == 0;
    }

    public static <T> boolean Code(T[] tArr) {
        return tArr == null || tArr.length == 0;
    }
}
