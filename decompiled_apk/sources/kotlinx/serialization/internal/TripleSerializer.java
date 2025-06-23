package kotlinx.serialization.internal;

import kotlin.Triple;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import xIXoO0Xx.oxoX;

@kotlin.o0
/* loaded from: classes6.dex */
public final class TripleSerializer<A, B, C> implements kotlinx.serialization.Oxx0IOOO<Triple<? extends A, ? extends B, ? extends C>> {

    /* renamed from: I0Io, reason: collision with root package name */
    @OXOo.OOXIXo
    public final kotlinx.serialization.Oxx0IOOO<C> f30687I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public final kotlinx.serialization.Oxx0IOOO<B> f30688II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public final kotlinx.serialization.Oxx0IOOO<A> f30689oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    @OXOo.OOXIXo
    public final kotlinx.serialization.descriptors.XO f30690oxoX;

    public TripleSerializer(@OXOo.OOXIXo kotlinx.serialization.Oxx0IOOO<A> aSerializer, @OXOo.OOXIXo kotlinx.serialization.Oxx0IOOO<B> bSerializer, @OXOo.OOXIXo kotlinx.serialization.Oxx0IOOO<C> cSerializer) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(aSerializer, "aSerializer");
        kotlin.jvm.internal.IIX0o.x0xO0oo(bSerializer, "bSerializer");
        kotlin.jvm.internal.IIX0o.x0xO0oo(cSerializer, "cSerializer");
        this.f30689oIX0oI = aSerializer;
        this.f30688II0xO0 = bSerializer;
        this.f30687I0Io = cSerializer;
        this.f30690oxoX = SerialDescriptorsKt.I0Io("kotlin.Triple", new kotlinx.serialization.descriptors.XO[0], new Oox.oOoXoXO<kotlinx.serialization.descriptors.oIX0oI, kotlin.oXIO0o0XI>(this) { // from class: kotlinx.serialization.internal.TripleSerializer$descriptor$1
            final /* synthetic */ TripleSerializer<A, B, C> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(kotlinx.serialization.descriptors.oIX0oI oix0oi) {
                invoke2(oix0oi);
                return kotlin.oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OXOo.OOXIXo kotlinx.serialization.descriptors.oIX0oI buildClassSerialDescriptor) {
                kotlinx.serialization.Oxx0IOOO oxx0IOOO;
                kotlinx.serialization.Oxx0IOOO oxx0IOOO2;
                kotlinx.serialization.Oxx0IOOO oxx0IOOO3;
                kotlin.jvm.internal.IIX0o.x0xO0oo(buildClassSerialDescriptor, "$this$buildClassSerialDescriptor");
                oxx0IOOO = this.this$0.f30689oIX0oI;
                kotlinx.serialization.descriptors.oIX0oI.II0xO0(buildClassSerialDescriptor, "first", oxx0IOOO.oIX0oI(), null, false, 12, null);
                oxx0IOOO2 = this.this$0.f30688II0xO0;
                kotlinx.serialization.descriptors.oIX0oI.II0xO0(buildClassSerialDescriptor, "second", oxx0IOOO2.oIX0oI(), null, false, 12, null);
                oxx0IOOO3 = this.this$0.f30687I0Io;
                kotlinx.serialization.descriptors.oIX0oI.II0xO0(buildClassSerialDescriptor, "third", oxx0IOOO3.oIX0oI(), null, false, 12, null);
            }
        });
    }

    @Override // kotlinx.serialization.I0Io
    @OXOo.OOXIXo
    /* renamed from: OOXIXo, reason: merged with bridge method [inline-methods] */
    public Triple<A, B, C> oxoX(@OXOo.OOXIXo xIXoO0Xx.XO decoder) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(decoder, "decoder");
        xIXoO0Xx.oxoX beginStructure = decoder.beginStructure(oIX0oI());
        if (beginStructure.decodeSequentially()) {
            return xxIXOIIO(beginStructure);
        }
        return xoIox(beginStructure);
    }

    @Override // kotlinx.serialization.Oxx0IOOO, kotlinx.serialization.Oxx0xo, kotlinx.serialization.I0Io
    @OXOo.OOXIXo
    public kotlinx.serialization.descriptors.XO oIX0oI() {
        return this.f30690oxoX;
    }

    @Override // kotlinx.serialization.Oxx0xo
    /* renamed from: oOoXoXO, reason: merged with bridge method [inline-methods] */
    public void II0xO0(@OXOo.OOXIXo xIXoO0Xx.II0XooXoX encoder, @OXOo.OOXIXo Triple<? extends A, ? extends B, ? extends C> value) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(encoder, "encoder");
        kotlin.jvm.internal.IIX0o.x0xO0oo(value, "value");
        xIXoO0Xx.X0o0xo beginStructure = encoder.beginStructure(oIX0oI());
        beginStructure.encodeSerializableElement(oIX0oI(), 0, this.f30689oIX0oI, value.getFirst());
        beginStructure.encodeSerializableElement(oIX0oI(), 1, this.f30688II0xO0, value.getSecond());
        beginStructure.encodeSerializableElement(oIX0oI(), 2, this.f30687I0Io, value.getThird());
        beginStructure.endStructure(oIX0oI());
    }

    public final Triple<A, B, C> xoIox(xIXoO0Xx.oxoX oxox) {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        Object obj6;
        obj = o0oIxOo.f30726oIX0oI;
        obj2 = o0oIxOo.f30726oIX0oI;
        obj3 = o0oIxOo.f30726oIX0oI;
        while (true) {
            int decodeElementIndex = oxox.decodeElementIndex(oIX0oI());
            if (decodeElementIndex != -1) {
                if (decodeElementIndex != 0) {
                    if (decodeElementIndex != 1) {
                        if (decodeElementIndex == 2) {
                            obj3 = oxoX.II0xO0.oxoX(oxox, oIX0oI(), 2, this.f30687I0Io, null, 8, null);
                        } else {
                            throw new SerializationException("Unexpected index " + decodeElementIndex);
                        }
                    } else {
                        obj2 = oxoX.II0xO0.oxoX(oxox, oIX0oI(), 1, this.f30688II0xO0, null, 8, null);
                    }
                } else {
                    obj = oxoX.II0xO0.oxoX(oxox, oIX0oI(), 0, this.f30689oIX0oI, null, 8, null);
                }
            } else {
                oxox.endStructure(oIX0oI());
                obj4 = o0oIxOo.f30726oIX0oI;
                if (obj != obj4) {
                    obj5 = o0oIxOo.f30726oIX0oI;
                    if (obj2 != obj5) {
                        obj6 = o0oIxOo.f30726oIX0oI;
                        if (obj3 != obj6) {
                            return new Triple<>(obj, obj2, obj3);
                        }
                        throw new SerializationException("Element 'third' is missing");
                    }
                    throw new SerializationException("Element 'second' is missing");
                }
                throw new SerializationException("Element 'first' is missing");
            }
        }
    }

    public final Triple<A, B, C> xxIXOIIO(xIXoO0Xx.oxoX oxox) {
        Object oxoX2 = oxoX.II0xO0.oxoX(oxox, oIX0oI(), 0, this.f30689oIX0oI, null, 8, null);
        Object oxoX3 = oxoX.II0xO0.oxoX(oxox, oIX0oI(), 1, this.f30688II0xO0, null, 8, null);
        Object oxoX4 = oxoX.II0xO0.oxoX(oxox, oIX0oI(), 2, this.f30687I0Io, null, 8, null);
        oxox.endStructure(oIX0oI());
        return new Triple<>(oxoX2, oxoX3, oxoX4);
    }
}
