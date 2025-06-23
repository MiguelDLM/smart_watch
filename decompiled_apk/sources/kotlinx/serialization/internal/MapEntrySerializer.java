package kotlinx.serialization.internal;

import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.util.Map;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.xxIXOIIO;

@kotlin.o0
/* loaded from: classes6.dex */
public final class MapEntrySerializer<K, V> extends oxxXoxO<K, V, Map.Entry<? extends K, ? extends V>> {

    /* renamed from: I0Io, reason: collision with root package name */
    @OXOo.OOXIXo
    public final kotlinx.serialization.descriptors.XO f30640I0Io;

    /* loaded from: classes6.dex */
    public static final class oIX0oI<K, V> implements Map.Entry<K, V>, OI0IXox.oIX0oI {

        /* renamed from: Oo, reason: collision with root package name */
        public final V f30641Oo;

        /* renamed from: XO, reason: collision with root package name */
        public final K f30642XO;

        public oIX0oI(K k, V v) {
            this.f30642XO = k;
            this.f30641Oo = v;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ oIX0oI X0o0xo(oIX0oI oix0oi, Object obj, Object obj2, int i, Object obj3) {
            if ((i & 1) != 0) {
                obj = oix0oi.f30642XO;
            }
            if ((i & 2) != 0) {
                obj2 = oix0oi.f30641Oo;
            }
            return oix0oi.oxoX(obj, obj2);
        }

        public final V II0xO0() {
            return this.f30641Oo;
        }

        @Override // java.util.Map.Entry
        public boolean equals(@OXOo.oOoXoXO Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof oIX0oI)) {
                return false;
            }
            oIX0oI oix0oi = (oIX0oI) obj;
            return kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.f30642XO, oix0oi.f30642XO) && kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.f30641Oo, oix0oi.f30641Oo);
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f30642XO;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f30641Oo;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K k = this.f30642XO;
            int hashCode = (k == null ? 0 : k.hashCode()) * 31;
            V v = this.f30641Oo;
            return hashCode + (v != null ? v.hashCode() : 0);
        }

        public final K oIX0oI() {
            return this.f30642XO;
        }

        @OXOo.OOXIXo
        public final oIX0oI<K, V> oxoX(K k, V v) {
            return new oIX0oI<>(k, v);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @OXOo.OOXIXo
        public String toString() {
            return "MapEntry(key=" + this.f30642XO + ", value=" + this.f30641Oo + HexStringBuilder.COMMENT_END_CHAR;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MapEntrySerializer(@OXOo.OOXIXo final kotlinx.serialization.Oxx0IOOO<K> keySerializer, @OXOo.OOXIXo final kotlinx.serialization.Oxx0IOOO<V> valueSerializer) {
        super(keySerializer, valueSerializer, null);
        kotlin.jvm.internal.IIX0o.x0xO0oo(keySerializer, "keySerializer");
        kotlin.jvm.internal.IIX0o.x0xO0oo(valueSerializer, "valueSerializer");
        this.f30640I0Io = SerialDescriptorsKt.X0o0xo("kotlin.collections.Map.Entry", xxIXOIIO.I0Io.f30608oIX0oI, new kotlinx.serialization.descriptors.XO[0], new Oox.oOoXoXO<kotlinx.serialization.descriptors.oIX0oI, kotlin.oXIO0o0XI>() { // from class: kotlinx.serialization.internal.MapEntrySerializer$descriptor$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(kotlinx.serialization.descriptors.oIX0oI oix0oi) {
                invoke2(oix0oi);
                return kotlin.oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OXOo.OOXIXo kotlinx.serialization.descriptors.oIX0oI buildSerialDescriptor) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(buildSerialDescriptor, "$this$buildSerialDescriptor");
                kotlinx.serialization.descriptors.oIX0oI.II0xO0(buildSerialDescriptor, "key", keySerializer.oIX0oI(), null, false, 12, null);
                kotlinx.serialization.descriptors.oIX0oI.II0xO0(buildSerialDescriptor, "value", valueSerializer.oIX0oI(), null, false, 12, null);
            }
        });
    }

    @Override // kotlinx.serialization.internal.oxxXoxO
    /* renamed from: OOXIXo, reason: merged with bridge method [inline-methods] */
    public K XO(@OXOo.OOXIXo Map.Entry<? extends K, ? extends V> entry) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(entry, "<this>");
        return entry.getKey();
    }

    @Override // kotlinx.serialization.Oxx0IOOO, kotlinx.serialization.Oxx0xo, kotlinx.serialization.I0Io
    @OXOo.OOXIXo
    public kotlinx.serialization.descriptors.XO oIX0oI() {
        return this.f30640I0Io;
    }

    @Override // kotlinx.serialization.internal.oxxXoxO
    /* renamed from: oOoXoXO, reason: merged with bridge method [inline-methods] */
    public V II0XooXoX(@OXOo.OOXIXo Map.Entry<? extends K, ? extends V> entry) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(entry, "<this>");
        return entry.getValue();
    }

    @Override // kotlinx.serialization.internal.oxxXoxO
    @OXOo.OOXIXo
    /* renamed from: ooOOo0oXI, reason: merged with bridge method [inline-methods] */
    public Map.Entry<K, V> xoIox(K k, V v) {
        return new oIX0oI(k, v);
    }
}
