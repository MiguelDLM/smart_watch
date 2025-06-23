package kotlinx.serialization.internal;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

@kotlin.o0
/* loaded from: classes6.dex */
public final class oxXx0IX<K, V> extends O0Xx<K, V, Map<K, ? extends V>, LinkedHashMap<K, V>> {

    /* renamed from: I0Io, reason: collision with root package name */
    @OXOo.OOXIXo
    public final kotlinx.serialization.descriptors.XO f30742I0Io;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public oxXx0IX(@OXOo.OOXIXo kotlinx.serialization.Oxx0IOOO<K> kSerializer, @OXOo.OOXIXo kotlinx.serialization.Oxx0IOOO<V> vSerializer) {
        super(kSerializer, vSerializer, null);
        kotlin.jvm.internal.IIX0o.x0xO0oo(kSerializer, "kSerializer");
        kotlin.jvm.internal.IIX0o.x0xO0oo(vSerializer, "vSerializer");
        this.f30742I0Io = new XoX(kSerializer.oIX0oI(), vSerializer.oIX0oI());
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
    public void II0XooXoX(@OXOo.OOXIXo LinkedHashMap<K, V> linkedHashMap, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(linkedHashMap, "<this>");
    }

    @Override // kotlinx.serialization.internal.oIX0oI
    /* renamed from: X0IIOO, reason: merged with bridge method [inline-methods] */
    public int xoIox(@OXOo.OOXIXo Map<K, ? extends V> map) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        return map.size();
    }

    @Override // kotlinx.serialization.internal.O0Xx
    /* renamed from: XI0IXoo, reason: merged with bridge method [inline-methods] */
    public void oI0IIXIo(@OXOo.OOXIXo LinkedHashMap<K, V> linkedHashMap, int i, K k, V v) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(linkedHashMap, "<this>");
        linkedHashMap.put(k, v);
    }

    @Override // kotlinx.serialization.internal.oIX0oI
    @OXOo.OOXIXo
    /* renamed from: XIxXXX0x0, reason: merged with bridge method [inline-methods] */
    public LinkedHashMap<K, V> x0xO0oo(@OXOo.OOXIXo Map<K, ? extends V> map) {
        LinkedHashMap<K, V> linkedHashMap;
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        if (map instanceof LinkedHashMap) {
            linkedHashMap = (LinkedHashMap) map;
        } else {
            linkedHashMap = null;
        }
        if (linkedHashMap == null) {
            return new LinkedHashMap<>(map);
        }
        return linkedHashMap;
    }

    @Override // kotlinx.serialization.internal.oIX0oI
    /* renamed from: o00, reason: merged with bridge method [inline-methods] */
    public int Oxx0IOOO(@OXOo.OOXIXo LinkedHashMap<K, V> linkedHashMap) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(linkedHashMap, "<this>");
        return linkedHashMap.size() * 2;
    }

    @Override // kotlinx.serialization.internal.O0Xx, kotlinx.serialization.Oxx0IOOO, kotlinx.serialization.Oxx0xo, kotlinx.serialization.I0Io
    @OXOo.OOXIXo
    public kotlinx.serialization.descriptors.XO oIX0oI() {
        return this.f30742I0Io;
    }

    @Override // kotlinx.serialization.internal.oIX0oI
    @OXOo.OOXIXo
    /* renamed from: xoXoI, reason: merged with bridge method [inline-methods] */
    public LinkedHashMap<K, V> XO() {
        return new LinkedHashMap<>();
    }

    @Override // kotlinx.serialization.internal.oIX0oI
    @OXOo.OOXIXo
    /* renamed from: xxX, reason: merged with bridge method [inline-methods] */
    public Map<K, V> Oo(@OXOo.OOXIXo LinkedHashMap<K, V> linkedHashMap) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(linkedHashMap, "<this>");
        return linkedHashMap;
    }
}
