package kotlinx.serialization.internal;

import java.util.Iterator;
import xIXoO0Xx.oxoX;

@kotlin.jvm.internal.XX({"SMAP\nCollectionSerializers.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CollectionSerializers.kt\nkotlinx/serialization/internal/CollectionLikeSerializer\n+ 2 Encoding.kt\nkotlinx/serialization/encoding/EncodingKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,283:1\n488#2,4:284\n1#3:288\n*S KotlinDebug\n*F\n+ 1 CollectionSerializers.kt\nkotlinx/serialization/internal/CollectionLikeSerializer\n*L\n66#1:284,4\n*E\n"})
@kotlin.o0
/* loaded from: classes6.dex */
public abstract class IIXOooo<Element, Collection, Builder> extends oIX0oI<Element, Collection, Builder> {

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public final kotlinx.serialization.Oxx0IOOO<Element> f30628oIX0oI;

    public /* synthetic */ IIXOooo(kotlinx.serialization.Oxx0IOOO oxx0IOOO, kotlin.jvm.internal.IIXOooo iIXOooo) {
        this(oxx0IOOO);
    }

    @Override // kotlinx.serialization.internal.oIX0oI, kotlinx.serialization.Oxx0xo
    public void II0xO0(@OXOo.OOXIXo xIXoO0Xx.II0XooXoX encoder, Collection collection) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(encoder, "encoder");
        int xoIox2 = xoIox(collection);
        kotlinx.serialization.descriptors.XO oIX0oI2 = oIX0oI();
        xIXoO0Xx.X0o0xo beginCollection = encoder.beginCollection(oIX0oI2, xoIox2);
        Iterator<Element> xxIXOIIO2 = xxIXOIIO(collection);
        for (int i = 0; i < xoIox2; i++) {
            beginCollection.encodeSerializableElement(oIX0oI(), i, this.f30628oIX0oI, xxIXOIIO2.next());
        }
        beginCollection.endStructure(oIX0oI2);
    }

    public abstract void Oxx0xo(Builder builder, int i, Element element);

    @Override // kotlinx.serialization.Oxx0IOOO, kotlinx.serialization.Oxx0xo, kotlinx.serialization.I0Io
    @OXOo.OOXIXo
    public abstract kotlinx.serialization.descriptors.XO oIX0oI();

    @Override // kotlinx.serialization.internal.oIX0oI
    public final void oOoXoXO(@OXOo.OOXIXo xIXoO0Xx.oxoX decoder, Builder builder, int i, int i2) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(decoder, "decoder");
        if (i2 >= 0) {
            for (int i3 = 0; i3 < i2; i3++) {
                ooOOo0oXI(decoder, i + i3, builder, false);
            }
            return;
        }
        throw new IllegalArgumentException("Size must be known in advance when using READ_ALL");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.internal.oIX0oI
    public void ooOOo0oXI(@OXOo.OOXIXo xIXoO0Xx.oxoX decoder, int i, Builder builder, boolean z) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(decoder, "decoder");
        Oxx0xo(builder, i, oxoX.II0xO0.oxoX(decoder, oIX0oI(), i, this.f30628oIX0oI, null, 8, null));
    }

    public IIXOooo(kotlinx.serialization.Oxx0IOOO<Element> oxx0IOOO) {
        super(null);
        this.f30628oIX0oI = oxx0IOOO;
    }
}
