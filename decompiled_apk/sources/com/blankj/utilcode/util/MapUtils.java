package com.blankj.utilcode.util;

import android.util.Pair;
import com.baidu.ar.m;
import com.bumptech.glide.load.engine.bitmap_recycle.PrettyPrintTreeMap;
import com.kwad.sdk.utils.LruHashMap;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import org.apache.commons.logging.impl.WeakHashtable;

/* loaded from: classes8.dex */
public class MapUtils {

    /* loaded from: classes8.dex */
    public interface Closure<K, V> {
        void execute(K k, V v);
    }

    /* loaded from: classes8.dex */
    public interface Transformer<K1, V1, K2, V2> {
        Pair<K2, V2> transform(K1 k1, V1 v1);
    }

    private MapUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static <K, V> void forAllDo(Map<K, V> map, Closure<K, V> closure) {
        if (map != null && closure != null) {
            for (Map.Entry<K, V> entry : map.entrySet()) {
                closure.execute(entry.getKey(), entry.getValue());
            }
        }
    }

    public static boolean isEmpty(Map map) {
        if (map != null && map.size() != 0) {
            return false;
        }
        return true;
    }

    public static boolean isNotEmpty(Map map) {
        return !isEmpty(map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SafeVarargs
    public static <K, V> HashMap<K, V> newHashMap(Pair<K, V>... pairArr) {
        m.AnonymousClass3 anonymousClass3 = (HashMap<K, V>) new HashMap();
        if (pairArr != null && pairArr.length != 0) {
            for (Pair<K, V> pair : pairArr) {
                if (pair != null) {
                    anonymousClass3.put(pair.first, pair.second);
                }
            }
        }
        return anonymousClass3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SafeVarargs
    public static <K, V> Hashtable<K, V> newHashTable(Pair<K, V>... pairArr) {
        WeakHashtable weakHashtable = (Hashtable<K, V>) new Hashtable();
        if (pairArr != null && pairArr.length != 0) {
            for (Pair<K, V> pair : pairArr) {
                if (pair != null) {
                    weakHashtable.put(pair.first, pair.second);
                }
            }
        }
        return weakHashtable;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SafeVarargs
    public static <K, V> LinkedHashMap<K, V> newLinkedHashMap(Pair<K, V>... pairArr) {
        LruHashMap lruHashMap = (LinkedHashMap<K, V>) new LinkedHashMap();
        if (pairArr != null && pairArr.length != 0) {
            for (Pair<K, V> pair : pairArr) {
                if (pair != null) {
                    lruHashMap.put(pair.first, pair.second);
                }
            }
        }
        return lruHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SafeVarargs
    public static <K, V> TreeMap<K, V> newTreeMap(Comparator<K> comparator, Pair<K, V>... pairArr) {
        if (comparator != null) {
            PrettyPrintTreeMap prettyPrintTreeMap = (TreeMap<K, V>) new TreeMap(comparator);
            if (pairArr != null && pairArr.length != 0) {
                for (Pair<K, V> pair : pairArr) {
                    if (pair != null) {
                        prettyPrintTreeMap.put(pair.first, pair.second);
                    }
                }
            }
            return prettyPrintTreeMap;
        }
        throw new IllegalArgumentException("comparator must not be null");
    }

    @SafeVarargs
    public static <K, V> Map<K, V> newUnmodifiableMap(Pair<K, V>... pairArr) {
        return Collections.unmodifiableMap(newHashMap(pairArr));
    }

    public static int size(Map map) {
        if (map == null) {
            return 0;
        }
        return map.size();
    }

    public static String toString(Map map) {
        if (map == null) {
            return "null";
        }
        return map.toString();
    }

    public static <K1, V1, K2, V2> Map<K2, V2> transform(Map<K1, V1> map, final Transformer<K1, V1, K2, V2> transformer) {
        if (map != null && transformer != null) {
            try {
                final Map<K2, V2> map2 = (Map) map.getClass().newInstance();
                forAllDo(map, new Closure<K1, V1>() { // from class: com.blankj.utilcode.util.MapUtils.1
                    @Override // com.blankj.utilcode.util.MapUtils.Closure
                    public void execute(K1 k1, V1 v1) {
                        Pair transform = Transformer.this.transform(k1, v1);
                        map2.put(transform.first, transform.second);
                    }
                });
                return map2;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }
}
