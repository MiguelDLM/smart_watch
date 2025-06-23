package kotlinx.serialization.internal;

import kotlin.jvm.internal.Ref;
import kotlinx.serialization.SerializationException;
import xIXoO0Xx.oxoX;

@kotlin.jvm.internal.XX({"SMAP\nAbstractPolymorphicSerializer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbstractPolymorphicSerializer.kt\nkotlinx/serialization/internal/AbstractPolymorphicSerializer\n+ 2 Encoding.kt\nkotlinx/serialization/encoding/EncodingKt\n+ 3 Platform.common.kt\nkotlinx/serialization/internal/Platform_commonKt\n+ 4 Decoding.kt\nkotlinx/serialization/encoding/DecodingKt\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,115:1\n475#2,2:116\n477#2,2:119\n83#3:118\n570#4,2:121\n572#4,2:124\n1#5:123\n*S KotlinDebug\n*F\n+ 1 AbstractPolymorphicSerializer.kt\nkotlinx/serialization/internal/AbstractPolymorphicSerializer\n*L\n33#1:116,2\n33#1:119,2\n35#1:118\n39#1:121,2\n39#1:124,2\n*E\n"})
@kotlinx.serialization.XO
/* loaded from: classes6.dex */
public abstract class II0xO0<T> implements kotlinx.serialization.Oxx0IOOO<T> {
    @kotlinx.serialization.XO
    @OXOo.oOoXoXO
    public kotlinx.serialization.I0Io<T> II0XooXoX(@OXOo.OOXIXo xIXoO0Xx.oxoX decoder, @OXOo.oOoXoXO String str) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(decoder, "decoder");
        return decoder.getSerializersModule().X0o0xo(xoIox(), str);
    }

    @Override // kotlinx.serialization.Oxx0xo
    public final void II0xO0(@OXOo.OOXIXo xIXoO0Xx.II0XooXoX encoder, @OXOo.OOXIXo T value) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(encoder, "encoder");
        kotlin.jvm.internal.IIX0o.x0xO0oo(value, "value");
        kotlinx.serialization.Oxx0xo<? super T> II0xO02 = kotlinx.serialization.OOXIXo.II0xO0(this, encoder, value);
        kotlinx.serialization.descriptors.XO oIX0oI2 = oIX0oI();
        xIXoO0Xx.X0o0xo beginStructure = encoder.beginStructure(oIX0oI2);
        beginStructure.encodeStringElement(oIX0oI(), 0, II0xO02.oIX0oI().xxIXOIIO());
        kotlinx.serialization.descriptors.XO oIX0oI3 = oIX0oI();
        kotlin.jvm.internal.IIX0o.x0XOIxOo(II0xO02, "null cannot be cast to non-null type kotlinx.serialization.SerializationStrategy<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
        beginStructure.encodeSerializableElement(oIX0oI3, 1, II0xO02, value);
        beginStructure.endStructure(oIX0oI2);
    }

    public final T Oxx0IOOO(xIXoO0Xx.oxoX oxox) {
        return (T) oxoX.II0xO0.oxoX(oxox, oIX0oI(), 1, kotlinx.serialization.OOXIXo.oIX0oI(this, oxox, oxox.decodeStringElement(oIX0oI(), 0)), null, 8, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.I0Io
    @OXOo.OOXIXo
    public final T oxoX(@OXOo.OOXIXo xIXoO0Xx.XO decoder) {
        T t;
        kotlin.jvm.internal.IIX0o.x0xO0oo(decoder, "decoder");
        kotlinx.serialization.descriptors.XO oIX0oI2 = oIX0oI();
        xIXoO0Xx.oxoX beginStructure = decoder.beginStructure(oIX0oI2);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        if (beginStructure.decodeSequentially()) {
            t = (T) Oxx0IOOO(beginStructure);
        } else {
            t = null;
            while (true) {
                int decodeElementIndex = beginStructure.decodeElementIndex(oIX0oI());
                if (decodeElementIndex != -1) {
                    if (decodeElementIndex != 0) {
                        if (decodeElementIndex != 1) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("Invalid index in polymorphic deserialization of ");
                            String str = (String) objectRef.element;
                            if (str == null) {
                                str = "unknown class";
                            }
                            sb.append(str);
                            sb.append("\n Expected 0, 1 or DECODE_DONE(-1), but found ");
                            sb.append(decodeElementIndex);
                            throw new SerializationException(sb.toString());
                        }
                        T t2 = objectRef.element;
                        if (t2 != 0) {
                            objectRef.element = t2;
                            t = (T) oxoX.II0xO0.oxoX(beginStructure, oIX0oI(), decodeElementIndex, kotlinx.serialization.OOXIXo.oIX0oI(this, beginStructure, (String) t2), null, 8, null);
                        } else {
                            throw new IllegalArgumentException("Cannot read polymorphic value before its type token");
                        }
                    } else {
                        objectRef.element = (T) beginStructure.decodeStringElement(oIX0oI(), decodeElementIndex);
                    }
                } else if (t != null) {
                    kotlin.jvm.internal.IIX0o.x0XOIxOo(t, "null cannot be cast to non-null type T of kotlinx.serialization.internal.AbstractPolymorphicSerializer.deserialize$lambda$3");
                } else {
                    throw new IllegalArgumentException(("Polymorphic value has not been read for class " + ((String) objectRef.element)).toString());
                }
            }
        }
        beginStructure.endStructure(oIX0oI2);
        return t;
    }

    @OXOo.OOXIXo
    public abstract kotlin.reflect.oxoX<T> xoIox();

    @kotlinx.serialization.XO
    @OXOo.oOoXoXO
    public kotlinx.serialization.Oxx0xo<T> xxIXOIIO(@OXOo.OOXIXo xIXoO0Xx.II0XooXoX encoder, @OXOo.OOXIXo T value) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(encoder, "encoder");
        kotlin.jvm.internal.IIX0o.x0xO0oo(value, "value");
        return encoder.getSerializersModule().XO(xoIox(), value);
    }
}
