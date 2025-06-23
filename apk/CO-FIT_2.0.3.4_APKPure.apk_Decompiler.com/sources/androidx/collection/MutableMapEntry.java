package androidx.collection;

import OI0IXox.Oxx0IOOO;
import OXOo.OOXIXo;
import java.util.Map;
import kotlin.jvm.internal.IIX0o;

final class MutableMapEntry<K, V> implements Map.Entry<K, V>, Oxx0IOOO.oIX0oI {
    private final int index;
    @OOXIXo
    private final Object[] keys;
    @OOXIXo
    private final Object[] values;

    public MutableMapEntry(@OOXIXo Object[] objArr, @OOXIXo Object[] objArr2, int i) {
        IIX0o.x0xO0oo(objArr, "keys");
        IIX0o.x0xO0oo(objArr2, "values");
        this.keys = objArr;
        this.values = objArr2;
        this.index = i;
    }

    public static /* synthetic */ void getKey$annotations() {
    }

    public static /* synthetic */ void getValue$annotations() {
    }

    public final int getIndex() {
        return this.index;
    }

    public K getKey() {
        return this.keys[this.index];
    }

    @OOXIXo
    public final Object[] getKeys() {
        return this.keys;
    }

    public V getValue() {
        return this.values[this.index];
    }

    @OOXIXo
    public final Object[] getValues() {
        return this.values;
    }

    public V setValue(V v) {
        V[] vArr = this.values;
        int i = this.index;
        V v2 = vArr[i];
        vArr[i] = v;
        return v2;
    }
}
