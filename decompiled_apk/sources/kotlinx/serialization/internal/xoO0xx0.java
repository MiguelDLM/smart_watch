package kotlinx.serialization.internal;

import java.util.Iterator;
import kotlinx.serialization.internal.I0;

@kotlin.jvm.internal.XX({"SMAP\nCollectionSerializers.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CollectionSerializers.kt\nkotlinx/serialization/internal/PrimitiveArraySerializer\n+ 2 Encoding.kt\nkotlinx/serialization/encoding/EncodingKt\n*L\n1#1,283:1\n488#2,4:284\n*S KotlinDebug\n*F\n+ 1 CollectionSerializers.kt\nkotlinx/serialization/internal/PrimitiveArraySerializer\n*L\n174#1:284,4\n*E\n"})
@kotlin.o0
/* loaded from: classes6.dex */
public abstract class xoO0xx0<Element, Array, Builder extends I0<Array>> extends IIXOooo<Element, Array, Builder> {

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public final kotlinx.serialization.descriptors.XO f30768II0xO0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xoO0xx0(@OXOo.OOXIXo kotlinx.serialization.Oxx0IOOO<Element> primitiveSerializer) {
        super(primitiveSerializer, null);
        kotlin.jvm.internal.IIX0o.x0xO0oo(primitiveSerializer, "primitiveSerializer");
        this.f30768II0xO0 = new ooOx(primitiveSerializer.oIX0oI());
    }

    @Override // kotlinx.serialization.internal.IIXOooo, kotlinx.serialization.internal.oIX0oI, kotlinx.serialization.Oxx0xo
    public final void II0xO0(@OXOo.OOXIXo xIXoO0Xx.II0XooXoX encoder, Array array) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(encoder, "encoder");
        int xoIox2 = xoIox(array);
        kotlinx.serialization.descriptors.XO xo2 = this.f30768II0xO0;
        xIXoO0Xx.X0o0xo beginCollection = encoder.beginCollection(xo2, xoIox2);
        X0IIOO(beginCollection, array, xoIox2);
        beginCollection.endStructure(xo2);
    }

    @Override // kotlinx.serialization.internal.oIX0oI
    /* renamed from: IIXOooo, reason: merged with bridge method [inline-methods] */
    public final void II0XooXoX(@OXOo.OOXIXo Builder builder, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(builder, "<this>");
        builder.II0xO0(i);
    }

    @Override // kotlinx.serialization.internal.oIX0oI
    /* renamed from: O0xOxO, reason: merged with bridge method [inline-methods] */
    public final Array Oo(@OXOo.OOXIXo Builder builder) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(builder, "<this>");
        return (Array) builder.oIX0oI();
    }

    public abstract void OxI(@OXOo.OOXIXo xIXoO0Xx.oxoX oxox, int i, @OXOo.OOXIXo Builder builder, boolean z);

    @Override // kotlinx.serialization.internal.oIX0oI
    /* renamed from: OxxIIOOXO, reason: merged with bridge method [inline-methods] */
    public final int Oxx0IOOO(@OXOo.OOXIXo Builder builder) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(builder, "<this>");
        return builder.oxoX();
    }

    public abstract void X0IIOO(@OXOo.OOXIXo xIXoO0Xx.X0o0xo x0o0xo, Array array, int i);

    @Override // kotlinx.serialization.internal.IIXOooo
    /* renamed from: o00, reason: merged with bridge method [inline-methods] */
    public final void Oxx0xo(@OXOo.OOXIXo Builder builder, int i, Element element) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(builder, "<this>");
        throw new IllegalStateException("This method lead to boxing and must not be used, use Builder.append instead");
    }

    @Override // kotlinx.serialization.internal.oIX0oI
    @OXOo.OOXIXo
    /* renamed from: oI0IIXIo, reason: merged with bridge method [inline-methods] */
    public final Builder XO() {
        return (Builder) x0xO0oo(xoXoI());
    }

    @Override // kotlinx.serialization.internal.IIXOooo, kotlinx.serialization.Oxx0IOOO, kotlinx.serialization.Oxx0xo, kotlinx.serialization.I0Io
    @OXOo.OOXIXo
    public final kotlinx.serialization.descriptors.XO oIX0oI() {
        return this.f30768II0xO0;
    }

    @Override // kotlinx.serialization.internal.oIX0oI, kotlinx.serialization.I0Io
    public final Array oxoX(@OXOo.OOXIXo xIXoO0Xx.XO decoder) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(decoder, "decoder");
        return OOXIXo(decoder, null);
    }

    public abstract Array xoXoI();

    @Override // kotlinx.serialization.internal.oIX0oI
    @OXOo.OOXIXo
    public final Iterator<Element> xxIXOIIO(Array array) {
        throw new IllegalStateException("This method lead to boxing and must not be used, use writeContents instead");
    }
}
