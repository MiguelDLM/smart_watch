package kotlinx.serialization.internal;

import kotlinx.serialization.SerializationException;
import xIXoO0Xx.oxoX;

@kotlin.jvm.internal.XX({"SMAP\nTuples.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Tuples.kt\nkotlinx/serialization/internal/KeyValueSerializer\n+ 2 Decoding.kt\nkotlinx/serialization/encoding/DecodingKt\n*L\n1#1,168:1\n570#2,4:169\n*S KotlinDebug\n*F\n+ 1 Tuples.kt\nkotlinx/serialization/internal/KeyValueSerializer\n*L\n35#1:169,4\n*E\n"})
@kotlin.o0
/* loaded from: classes6.dex */
public abstract class oxxXoxO<K, V, R> implements kotlinx.serialization.Oxx0IOOO<R> {

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public final kotlinx.serialization.Oxx0IOOO<V> f30743II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public final kotlinx.serialization.Oxx0IOOO<K> f30744oIX0oI;

    public /* synthetic */ oxxXoxO(kotlinx.serialization.Oxx0IOOO oxx0IOOO, kotlinx.serialization.Oxx0IOOO oxx0IOOO2, kotlin.jvm.internal.IIXOooo iIXOooo) {
        this(oxx0IOOO, oxx0IOOO2);
    }

    public abstract V II0XooXoX(R r);

    @Override // kotlinx.serialization.Oxx0xo
    public void II0xO0(@OXOo.OOXIXo xIXoO0Xx.II0XooXoX encoder, R r) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(encoder, "encoder");
        xIXoO0Xx.X0o0xo beginStructure = encoder.beginStructure(oIX0oI());
        beginStructure.encodeSerializableElement(oIX0oI(), 0, this.f30744oIX0oI, XO(r));
        beginStructure.encodeSerializableElement(oIX0oI(), 1, this.f30743II0xO0, II0XooXoX(r));
        beginStructure.endStructure(oIX0oI());
    }

    @OXOo.OOXIXo
    public final kotlinx.serialization.Oxx0IOOO<K> Oxx0IOOO() {
        return this.f30744oIX0oI;
    }

    public abstract K XO(R r);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.I0Io
    public R oxoX(@OXOo.OOXIXo xIXoO0Xx.XO decoder) {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        R r;
        kotlin.jvm.internal.IIX0o.x0xO0oo(decoder, "decoder");
        kotlinx.serialization.descriptors.XO oIX0oI2 = oIX0oI();
        xIXoO0Xx.oxoX beginStructure = decoder.beginStructure(oIX0oI2);
        if (!beginStructure.decodeSequentially()) {
            obj = o0oIxOo.f30726oIX0oI;
            obj2 = o0oIxOo.f30726oIX0oI;
            Object obj5 = obj;
            Object obj6 = obj2;
            while (true) {
                int decodeElementIndex = beginStructure.decodeElementIndex(oIX0oI());
                if (decodeElementIndex == -1) {
                    obj3 = o0oIxOo.f30726oIX0oI;
                    if (obj5 != obj3) {
                        obj4 = o0oIxOo.f30726oIX0oI;
                        if (obj6 != obj4) {
                            r = (R) xoIox(obj5, obj6);
                        } else {
                            throw new SerializationException("Element 'value' is missing");
                        }
                    } else {
                        throw new SerializationException("Element 'key' is missing");
                    }
                } else if (decodeElementIndex != 0) {
                    if (decodeElementIndex == 1) {
                        obj6 = oxoX.II0xO0.oxoX(beginStructure, oIX0oI(), 1, xxIXOIIO(), null, 8, null);
                    } else {
                        throw new SerializationException("Invalid index: " + decodeElementIndex);
                    }
                } else {
                    obj5 = oxoX.II0xO0.oxoX(beginStructure, oIX0oI(), 0, Oxx0IOOO(), null, 8, null);
                }
            }
        } else {
            r = (R) xoIox(oxoX.II0xO0.oxoX(beginStructure, oIX0oI(), 0, Oxx0IOOO(), null, 8, null), oxoX.II0xO0.oxoX(beginStructure, oIX0oI(), 1, xxIXOIIO(), null, 8, null));
        }
        beginStructure.endStructure(oIX0oI2);
        return r;
    }

    public abstract R xoIox(K k, V v);

    @OXOo.OOXIXo
    public final kotlinx.serialization.Oxx0IOOO<V> xxIXOIIO() {
        return this.f30743II0xO0;
    }

    public oxxXoxO(kotlinx.serialization.Oxx0IOOO<K> oxx0IOOO, kotlinx.serialization.Oxx0IOOO<V> oxx0IOOO2) {
        this.f30744oIX0oI = oxx0IOOO;
        this.f30743II0xO0 = oxx0IOOO2;
    }
}
