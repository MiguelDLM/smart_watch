package com.microsoft.cognitiveservices.speech.util;

import com.microsoft.cognitiveservices.speech.util.KeyedItem;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes11.dex */
public final class KeyedItemHashMap<T extends KeyedItem> implements Map<String, T> {
    private HashMap<String, T> map = new HashMap<>();

    @Override // java.util.Map
    public void clear() {
        this.map.clear();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return this.map.containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return this.map.containsValue(obj);
    }

    @Override // java.util.Map
    public Set<Map.Entry<String, T>> entrySet() {
        return this.map.entrySet();
    }

    @Override // java.util.Map
    public T get(Object obj) {
        return this.map.get(String.valueOf(obj));
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    @Override // java.util.Map
    public Set<String> keySet() {
        return this.map.keySet();
    }

    public T put(T t) {
        return this.map.put(t.getId(), t);
    }

    @Override // java.util.Map
    public void putAll(Map<? extends String, ? extends T> map) {
        this.map.putAll(map);
    }

    @Override // java.util.Map
    public T remove(Object obj) {
        return this.map.remove(((KeyedItem) obj).getId());
    }

    @Override // java.util.Map
    public int size() {
        return this.map.size();
    }

    @Override // java.util.Map
    public Collection<T> values() {
        return this.map.values();
    }

    @Override // java.util.Map
    public T put(String str, T t) {
        return this.map.put(t.getId(), t);
    }
}
