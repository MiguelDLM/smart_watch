package androidx.collection;

import OI0IXox.Oxx0IOOO;
import OXOo.OOXIXo;
import java.util.Map;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes.dex */
final class MutableMapEntry<K, V> implements Map.Entry<K, V>, Oxx0IOOO.oIX0oI {
    private final int index;

    @OOXIXo
    private final Object[] keys;

    @OOXIXo
    private final Object[] values;

    public MutableMapEntry(@OOXIXo Object[] keys, @OOXIXo Object[] values, int i) {
        IIX0o.x0xO0oo(keys, "keys");
        IIX0o.x0xO0oo(values, "values");
        this.keys = keys;
        this.values = values;
        this.index = i;
    }

    public static /* synthetic */ void getKey$annotations() {
    }

    public static /* synthetic */ void getValue$annotations() {
    }

    public final int getIndex() {
        return this.index;
    }

    @Override // java.util.Map.Entry
    public K getKey() {
        return (K) this.keys[this.index];
    }

    @OOXIXo
    public final Object[] getKeys() {
        return this.keys;
    }

    @Override // java.util.Map.Entry
    public V getValue() {
        return (V) this.values[this.index];
    }

    @OOXIXo
    public final Object[] getValues() {
        return this.values;
    }

    @Override // java.util.Map.Entry
    public V setValue(V v) {
        Object[] objArr = this.values;
        int i = this.index;
        V v2 = (V) objArr[i];
        objArr[i] = v;
        return v2;
    }
}
