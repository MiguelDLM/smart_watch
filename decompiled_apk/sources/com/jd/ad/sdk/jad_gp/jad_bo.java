package com.jd.ad.sdk.jad_gp;

import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;

/* loaded from: classes10.dex */
public final class jad_bo<K, V> extends ArrayMap<K, V> {
    public int jad_an;

    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public void clear() {
        this.jad_an = 0;
        super.clear();
    }

    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public int hashCode() {
        if (this.jad_an == 0) {
            this.jad_an = super.hashCode();
        }
        return this.jad_an;
    }

    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public V put(K k, V v) {
        this.jad_an = 0;
        return (V) super.put(k, v);
    }

    @Override // androidx.collection.SimpleArrayMap
    public void putAll(SimpleArrayMap<? extends K, ? extends V> simpleArrayMap) {
        this.jad_an = 0;
        super.putAll(simpleArrayMap);
    }

    @Override // androidx.collection.SimpleArrayMap
    public V removeAt(int i) {
        this.jad_an = 0;
        return (V) super.removeAt(i);
    }

    @Override // androidx.collection.SimpleArrayMap
    public V setValueAt(int i, V v) {
        this.jad_an = 0;
        return (V) super.setValueAt(i, v);
    }
}
