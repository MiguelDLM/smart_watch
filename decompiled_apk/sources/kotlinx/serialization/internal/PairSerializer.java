package kotlinx.serialization.internal;

import kotlin.Pair;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;

@kotlin.o0
/* loaded from: classes6.dex */
public final class PairSerializer<K, V> extends oxxXoxO<K, V, Pair<? extends K, ? extends V>> {

    /* renamed from: I0Io, reason: collision with root package name */
    @OXOo.OOXIXo
    public final kotlinx.serialization.descriptors.XO f30672I0Io;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PairSerializer(@OXOo.OOXIXo final kotlinx.serialization.Oxx0IOOO<K> keySerializer, @OXOo.OOXIXo final kotlinx.serialization.Oxx0IOOO<V> valueSerializer) {
        super(keySerializer, valueSerializer, null);
        kotlin.jvm.internal.IIX0o.x0xO0oo(keySerializer, "keySerializer");
        kotlin.jvm.internal.IIX0o.x0xO0oo(valueSerializer, "valueSerializer");
        this.f30672I0Io = SerialDescriptorsKt.I0Io("kotlin.Pair", new kotlinx.serialization.descriptors.XO[0], new Oox.oOoXoXO<kotlinx.serialization.descriptors.oIX0oI, kotlin.oXIO0o0XI>() { // from class: kotlinx.serialization.internal.PairSerializer$descriptor$1
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
            public final void invoke2(@OXOo.OOXIXo kotlinx.serialization.descriptors.oIX0oI buildClassSerialDescriptor) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(buildClassSerialDescriptor, "$this$buildClassSerialDescriptor");
                kotlinx.serialization.descriptors.oIX0oI.II0xO0(buildClassSerialDescriptor, "first", keySerializer.oIX0oI(), null, false, 12, null);
                kotlinx.serialization.descriptors.oIX0oI.II0xO0(buildClassSerialDescriptor, "second", valueSerializer.oIX0oI(), null, false, 12, null);
            }
        });
    }

    @Override // kotlinx.serialization.internal.oxxXoxO
    /* renamed from: OOXIXo, reason: merged with bridge method [inline-methods] */
    public K XO(@OXOo.OOXIXo Pair<? extends K, ? extends V> pair) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(pair, "<this>");
        return pair.getFirst();
    }

    @Override // kotlinx.serialization.Oxx0IOOO, kotlinx.serialization.Oxx0xo, kotlinx.serialization.I0Io
    @OXOo.OOXIXo
    public kotlinx.serialization.descriptors.XO oIX0oI() {
        return this.f30672I0Io;
    }

    @Override // kotlinx.serialization.internal.oxxXoxO
    /* renamed from: oOoXoXO, reason: merged with bridge method [inline-methods] */
    public V II0XooXoX(@OXOo.OOXIXo Pair<? extends K, ? extends V> pair) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(pair, "<this>");
        return pair.getSecond();
    }

    @Override // kotlinx.serialization.internal.oxxXoxO
    @OXOo.OOXIXo
    /* renamed from: ooOOo0oXI, reason: merged with bridge method [inline-methods] */
    public Pair<K, V> xoIox(K k, V v) {
        return kotlin.Xo0.oIX0oI(k, v);
    }
}
