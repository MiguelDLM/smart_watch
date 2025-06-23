package kotlinx.serialization.internal;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@kotlin.o0
/* loaded from: classes6.dex */
public final class oOXoIIIo<K, V> extends O0Xx<K, V, Map<K, ? extends V>, HashMap<K, V>> {

    /* renamed from: I0Io, reason: collision with root package name */
    @OXOo.OOXIXo
    public final kotlinx.serialization.descriptors.XO f30729I0Io;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public oOXoIIIo(@OXOo.OOXIXo kotlinx.serialization.Oxx0IOOO<K> kSerializer, @OXOo.OOXIXo kotlinx.serialization.Oxx0IOOO<V> vSerializer) {
        super(kSerializer, vSerializer, null);
        kotlin.jvm.internal.IIX0o.x0xO0oo(kSerializer, "kSerializer");
        kotlin.jvm.internal.IIX0o.x0xO0oo(vSerializer, "vSerializer");
        this.f30729I0Io = new IoOoX(kSerializer.oIX0oI(), vSerializer.oIX0oI());
    }

    @Override // kotlinx.serialization.internal.oIX0oI
    @OXOo.OOXIXo
    /* renamed from: O0xOxO, reason: merged with bridge method [inline-methods] */
    public Iterator<Map.Entry<K, V>> xxIXOIIO(@OXOo.OOXIXo Map<K, ? extends V> map) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        return map.entrySet().iterator();
    }

    @Override // kotlinx.serialization.internal.oIX0oI
    /* renamed from: OxI, reason: merged with bridge method [inline-methods] */
    public void II0XooXoX(@OXOo.OOXIXo HashMap<K, V> hashMap, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(hashMap, "<this>");
    }

    @Override // kotlinx.serialization.internal.oIX0oI
    /* renamed from: X0IIOO, reason: merged with bridge method [inline-methods] */
    public int xoIox(@OXOo.OOXIXo Map<K, ? extends V> map) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        return map.size();
    }

    @Override // kotlinx.serialization.internal.O0Xx
    /* renamed from: XI0IXoo, reason: merged with bridge method [inline-methods] */
    public void oI0IIXIo(@OXOo.OOXIXo HashMap<K, V> hashMap, int i, K k, V v) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(hashMap, "<this>");
        hashMap.put(k, v);
    }

    @Override // kotlinx.serialization.internal.oIX0oI
    @OXOo.OOXIXo
    /* renamed from: XIxXXX0x0, reason: merged with bridge method [inline-methods] */
    public HashMap<K, V> x0xO0oo(@OXOo.OOXIXo Map<K, ? extends V> map) {
        HashMap<K, V> hashMap;
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        if (map instanceof HashMap) {
            hashMap = (HashMap) map;
        } else {
            hashMap = null;
        }
        if (hashMap == null) {
            return new HashMap<>(map);
        }
        return hashMap;
    }

    @Override // kotlinx.serialization.internal.oIX0oI
    /* renamed from: o00, reason: merged with bridge method [inline-methods] */
    public int Oxx0IOOO(@OXOo.OOXIXo HashMap<K, V> hashMap) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(hashMap, "<this>");
        return hashMap.size() * 2;
    }

    @Override // kotlinx.serialization.internal.O0Xx, kotlinx.serialization.Oxx0IOOO, kotlinx.serialization.Oxx0xo, kotlinx.serialization.I0Io
    @OXOo.OOXIXo
    public kotlinx.serialization.descriptors.XO oIX0oI() {
        return this.f30729I0Io;
    }

    @Override // kotlinx.serialization.internal.oIX0oI
    @OXOo.OOXIXo
    /* renamed from: xoXoI, reason: merged with bridge method [inline-methods] */
    public HashMap<K, V> XO() {
        return new HashMap<>();
    }

    @Override // kotlinx.serialization.internal.oIX0oI
    @OXOo.OOXIXo
    /* renamed from: xxX, reason: merged with bridge method [inline-methods] */
    public Map<K, V> Oo(@OXOo.OOXIXo HashMap<K, V> hashMap) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(hashMap, "<this>");
        return hashMap;
    }
}
