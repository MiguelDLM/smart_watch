package kotlinx.serialization.internal;

import java.util.Iterator;
import java.util.Map;
import xIXoO0Xx.oxoX;

@kotlin.jvm.internal.XX({"SMAP\nCollectionSerializers.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CollectionSerializers.kt\nkotlinx/serialization/internal/MapLikeSerializer\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Encoding.kt\nkotlinx/serialization/encoding/EncodingKt\n+ 4 Iterators.kt\nkotlin/collections/CollectionsKt__IteratorsKt\n*L\n1#1,283:1\n1#2:284\n488#3,2:285\n490#3,2:289\n32#4,2:287\n*S KotlinDebug\n*F\n+ 1 CollectionSerializers.kt\nkotlinx/serialization/internal/MapLikeSerializer\n*L\n118#1:285,2\n118#1:289,2\n121#1:287,2\n*E\n"})
@kotlinx.serialization.XO
/* loaded from: classes6.dex */
public abstract class O0Xx<Key, Value, Collection, Builder extends Map<Key, Value>> extends oIX0oI<Map.Entry<? extends Key, ? extends Value>, Collection, Builder> {

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public final kotlinx.serialization.Oxx0IOOO<Value> f30646II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public final kotlinx.serialization.Oxx0IOOO<Key> f30647oIX0oI;

    public /* synthetic */ O0Xx(kotlinx.serialization.Oxx0IOOO oxx0IOOO, kotlinx.serialization.Oxx0IOOO oxx0IOOO2, kotlin.jvm.internal.IIXOooo iIXOooo) {
        this(oxx0IOOO, oxx0IOOO2);
    }

    @Override // kotlinx.serialization.internal.oIX0oI, kotlinx.serialization.Oxx0xo
    public void II0xO0(@OXOo.OOXIXo xIXoO0Xx.II0XooXoX encoder, Collection collection) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(encoder, "encoder");
        int xoIox2 = xoIox(collection);
        kotlinx.serialization.descriptors.XO oIX0oI2 = oIX0oI();
        xIXoO0Xx.X0o0xo beginCollection = encoder.beginCollection(oIX0oI2, xoIox2);
        Iterator<Map.Entry<? extends Key, ? extends Value>> xxIXOIIO2 = xxIXOIIO(collection);
        int i = 0;
        while (xxIXOIIO2.hasNext()) {
            Map.Entry<? extends Key, ? extends Value> next = xxIXOIIO2.next();
            Key key = next.getKey();
            Value value = next.getValue();
            int i2 = i + 1;
            beginCollection.encodeSerializableElement(oIX0oI(), i, IXxxXO(), key);
            i += 2;
            beginCollection.encodeSerializableElement(oIX0oI(), i2, Oxx0xo(), value);
        }
        beginCollection.endStructure(oIX0oI2);
    }

    @Override // kotlinx.serialization.internal.oIX0oI
    /* renamed from: IIXOooo, reason: merged with bridge method [inline-methods] */
    public final void ooOOo0oXI(@OXOo.OOXIXo xIXoO0Xx.oxoX decoder, int i, @OXOo.OOXIXo Builder builder, boolean z) {
        int i2;
        Object oxoX2;
        kotlin.jvm.internal.IIX0o.x0xO0oo(decoder, "decoder");
        kotlin.jvm.internal.IIX0o.x0xO0oo(builder, "builder");
        Object oxoX3 = oxoX.II0xO0.oxoX(decoder, oIX0oI(), i, this.f30647oIX0oI, null, 8, null);
        if (z) {
            i2 = decoder.decodeElementIndex(oIX0oI());
            if (i2 != i + 1) {
                throw new IllegalArgumentException(("Value must follow key in a map, index for key: " + i + ", returned index for value: " + i2).toString());
            }
        } else {
            i2 = i + 1;
        }
        int i3 = i2;
        if (builder.containsKey(oxoX3) && !(this.f30646II0xO0.oIX0oI().oIX0oI() instanceof kotlinx.serialization.descriptors.X0o0xo)) {
            oxoX2 = decoder.decodeSerializableElement(oIX0oI(), i3, this.f30646II0xO0, kotlin.collections.o0.oo(builder, oxoX3));
        } else {
            oxoX2 = oxoX.II0xO0.oxoX(decoder, oIX0oI(), i3, this.f30646II0xO0, null, 8, null);
        }
        builder.put(oxoX3, oxoX2);
    }

    @OXOo.OOXIXo
    public final kotlinx.serialization.Oxx0IOOO<Key> IXxxXO() {
        return this.f30647oIX0oI;
    }

    @OXOo.OOXIXo
    public final kotlinx.serialization.Oxx0IOOO<Value> Oxx0xo() {
        return this.f30646II0xO0;
    }

    @Override // kotlinx.serialization.internal.oIX0oI
    /* renamed from: OxxIIOOXO, reason: merged with bridge method [inline-methods] */
    public final void oOoXoXO(@OXOo.OOXIXo xIXoO0Xx.oxoX decoder, @OXOo.OOXIXo Builder builder, int i, int i2) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(decoder, "decoder");
        kotlin.jvm.internal.IIX0o.x0xO0oo(builder, "builder");
        if (i2 >= 0) {
            X0.xoIox OIx00oxx2 = X0.IIXOooo.OIx00oxx(X0.IIXOooo.X00xOoXI(0, i2 * 2), 2);
            int oxoX2 = OIx00oxx2.oxoX();
            int X0o0xo2 = OIx00oxx2.X0o0xo();
            int XO2 = OIx00oxx2.XO();
            if ((XO2 <= 0 || oxoX2 > X0o0xo2) && (XO2 >= 0 || X0o0xo2 > oxoX2)) {
                return;
            }
            while (true) {
                ooOOo0oXI(decoder, i + oxoX2, builder, false);
                if (oxoX2 != X0o0xo2) {
                    oxoX2 += XO2;
                } else {
                    return;
                }
            }
        } else {
            throw new IllegalArgumentException("Size must be known in advance when using READ_ALL");
        }
    }

    public abstract void oI0IIXIo(@OXOo.OOXIXo Builder builder, int i, Key key, Value value);

    @Override // kotlinx.serialization.Oxx0IOOO, kotlinx.serialization.Oxx0xo, kotlinx.serialization.I0Io
    @OXOo.OOXIXo
    public abstract kotlinx.serialization.descriptors.XO oIX0oI();

    public O0Xx(kotlinx.serialization.Oxx0IOOO<Key> oxx0IOOO, kotlinx.serialization.Oxx0IOOO<Value> oxx0IOOO2) {
        super(null);
        this.f30647oIX0oI = oxx0IOOO;
        this.f30646II0xO0 = oxx0IOOO2;
    }
}
