package xIXoO0Xx;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IO;
import kotlin.jvm.internal.XX;
import kotlinx.serialization.SerializationException;
import xIXoO0Xx.XO;
import xIXoO0Xx.oxoX;

@kotlinx.serialization.oxoX
@XX({"SMAP\nAbstractDecoder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbstractDecoder.kt\nkotlinx/serialization/encoding/AbstractDecoder\n+ 2 Decoding.kt\nkotlinx/serialization/encoding/DecodingKt\n*L\n1#1,81:1\n270#2,2:82\n*S KotlinDebug\n*F\n+ 1 AbstractDecoder.kt\nkotlinx/serialization/encoding/AbstractDecoder\n*L\n77#1:82,2\n*E\n"})
/* loaded from: classes6.dex */
public abstract class oIX0oI implements XO, oxoX {
    public static /* synthetic */ Object decodeSerializableValue$default(oIX0oI oix0oi, kotlinx.serialization.I0Io i0Io, Object obj, int i, Object obj2) {
        if (obj2 == null) {
            if ((i & 2) != 0) {
                obj = null;
            }
            return oix0oi.decodeSerializableValue(i0Io, obj);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decodeSerializableValue");
    }

    @Override // xIXoO0Xx.XO
    @OOXIXo
    public oxoX beginStructure(@OOXIXo kotlinx.serialization.descriptors.XO descriptor) {
        IIX0o.x0xO0oo(descriptor, "descriptor");
        return this;
    }

    @Override // xIXoO0Xx.XO
    public boolean decodeBoolean() {
        Object decodeValue = decodeValue();
        IIX0o.x0XOIxOo(decodeValue, "null cannot be cast to non-null type kotlin.Boolean");
        return ((Boolean) decodeValue).booleanValue();
    }

    @Override // xIXoO0Xx.oxoX
    public final boolean decodeBooleanElement(@OOXIXo kotlinx.serialization.descriptors.XO descriptor, int i) {
        IIX0o.x0xO0oo(descriptor, "descriptor");
        return decodeBoolean();
    }

    @Override // xIXoO0Xx.XO
    public byte decodeByte() {
        Object decodeValue = decodeValue();
        IIX0o.x0XOIxOo(decodeValue, "null cannot be cast to non-null type kotlin.Byte");
        return ((Byte) decodeValue).byteValue();
    }

    @Override // xIXoO0Xx.oxoX
    public final byte decodeByteElement(@OOXIXo kotlinx.serialization.descriptors.XO descriptor, int i) {
        IIX0o.x0xO0oo(descriptor, "descriptor");
        return decodeByte();
    }

    @Override // xIXoO0Xx.XO
    public char decodeChar() {
        Object decodeValue = decodeValue();
        IIX0o.x0XOIxOo(decodeValue, "null cannot be cast to non-null type kotlin.Char");
        return ((Character) decodeValue).charValue();
    }

    @Override // xIXoO0Xx.oxoX
    public final char decodeCharElement(@OOXIXo kotlinx.serialization.descriptors.XO descriptor, int i) {
        IIX0o.x0xO0oo(descriptor, "descriptor");
        return decodeChar();
    }

    @Override // xIXoO0Xx.oxoX
    public int decodeCollectionSize(@OOXIXo kotlinx.serialization.descriptors.XO xo2) {
        return oxoX.II0xO0.oIX0oI(this, xo2);
    }

    @Override // xIXoO0Xx.XO
    public double decodeDouble() {
        Object decodeValue = decodeValue();
        IIX0o.x0XOIxOo(decodeValue, "null cannot be cast to non-null type kotlin.Double");
        return ((Double) decodeValue).doubleValue();
    }

    @Override // xIXoO0Xx.oxoX
    public final double decodeDoubleElement(@OOXIXo kotlinx.serialization.descriptors.XO descriptor, int i) {
        IIX0o.x0xO0oo(descriptor, "descriptor");
        return decodeDouble();
    }

    @Override // xIXoO0Xx.XO
    public int decodeEnum(@OOXIXo kotlinx.serialization.descriptors.XO enumDescriptor) {
        IIX0o.x0xO0oo(enumDescriptor, "enumDescriptor");
        Object decodeValue = decodeValue();
        IIX0o.x0XOIxOo(decodeValue, "null cannot be cast to non-null type kotlin.Int");
        return ((Integer) decodeValue).intValue();
    }

    @Override // xIXoO0Xx.XO
    public float decodeFloat() {
        Object decodeValue = decodeValue();
        IIX0o.x0XOIxOo(decodeValue, "null cannot be cast to non-null type kotlin.Float");
        return ((Float) decodeValue).floatValue();
    }

    @Override // xIXoO0Xx.oxoX
    public final float decodeFloatElement(@OOXIXo kotlinx.serialization.descriptors.XO descriptor, int i) {
        IIX0o.x0xO0oo(descriptor, "descriptor");
        return decodeFloat();
    }

    @Override // xIXoO0Xx.XO
    @OOXIXo
    public XO decodeInline(@OOXIXo kotlinx.serialization.descriptors.XO descriptor) {
        IIX0o.x0xO0oo(descriptor, "descriptor");
        return this;
    }

    @Override // xIXoO0Xx.oxoX
    @OOXIXo
    public XO decodeInlineElement(@OOXIXo kotlinx.serialization.descriptors.XO descriptor, int i) {
        IIX0o.x0xO0oo(descriptor, "descriptor");
        return decodeInline(descriptor.X0o0xo(i));
    }

    @Override // xIXoO0Xx.XO
    public int decodeInt() {
        Object decodeValue = decodeValue();
        IIX0o.x0XOIxOo(decodeValue, "null cannot be cast to non-null type kotlin.Int");
        return ((Integer) decodeValue).intValue();
    }

    @Override // xIXoO0Xx.oxoX
    public final int decodeIntElement(@OOXIXo kotlinx.serialization.descriptors.XO descriptor, int i) {
        IIX0o.x0xO0oo(descriptor, "descriptor");
        return decodeInt();
    }

    @Override // xIXoO0Xx.XO
    public long decodeLong() {
        Object decodeValue = decodeValue();
        IIX0o.x0XOIxOo(decodeValue, "null cannot be cast to non-null type kotlin.Long");
        return ((Long) decodeValue).longValue();
    }

    @Override // xIXoO0Xx.oxoX
    public final long decodeLongElement(@OOXIXo kotlinx.serialization.descriptors.XO descriptor, int i) {
        IIX0o.x0xO0oo(descriptor, "descriptor");
        return decodeLong();
    }

    @Override // xIXoO0Xx.XO
    public boolean decodeNotNullMark() {
        return true;
    }

    @Override // xIXoO0Xx.XO
    @oOoXoXO
    public Void decodeNull() {
        return null;
    }

    @Override // xIXoO0Xx.oxoX
    @oOoXoXO
    public final <T> T decodeNullableSerializableElement(@OOXIXo kotlinx.serialization.descriptors.XO descriptor, int i, @OOXIXo kotlinx.serialization.I0Io<? extends T> deserializer, @oOoXoXO T t) {
        IIX0o.x0xO0oo(descriptor, "descriptor");
        IIX0o.x0xO0oo(deserializer, "deserializer");
        if (!deserializer.oIX0oI().I0Io() && !decodeNotNullMark()) {
            return (T) decodeNull();
        }
        return (T) decodeSerializableValue(deserializer, t);
    }

    @Override // xIXoO0Xx.XO
    @kotlinx.serialization.oxoX
    @oOoXoXO
    public <T> T decodeNullableSerializableValue(@OOXIXo kotlinx.serialization.I0Io<? extends T> i0Io) {
        return (T) XO.oIX0oI.oIX0oI(this, i0Io);
    }

    @Override // xIXoO0Xx.oxoX
    @kotlinx.serialization.oxoX
    public boolean decodeSequentially() {
        return oxoX.II0xO0.I0Io(this);
    }

    @Override // xIXoO0Xx.oxoX
    public <T> T decodeSerializableElement(@OOXIXo kotlinx.serialization.descriptors.XO descriptor, int i, @OOXIXo kotlinx.serialization.I0Io<? extends T> deserializer, @oOoXoXO T t) {
        IIX0o.x0xO0oo(descriptor, "descriptor");
        IIX0o.x0xO0oo(deserializer, "deserializer");
        return (T) decodeSerializableValue(deserializer, t);
    }

    @Override // xIXoO0Xx.XO
    public <T> T decodeSerializableValue(@OOXIXo kotlinx.serialization.I0Io<? extends T> i0Io) {
        return (T) XO.oIX0oI.II0xO0(this, i0Io);
    }

    @Override // xIXoO0Xx.XO
    public short decodeShort() {
        Object decodeValue = decodeValue();
        IIX0o.x0XOIxOo(decodeValue, "null cannot be cast to non-null type kotlin.Short");
        return ((Short) decodeValue).shortValue();
    }

    @Override // xIXoO0Xx.oxoX
    public final short decodeShortElement(@OOXIXo kotlinx.serialization.descriptors.XO descriptor, int i) {
        IIX0o.x0xO0oo(descriptor, "descriptor");
        return decodeShort();
    }

    @Override // xIXoO0Xx.XO
    @OOXIXo
    public String decodeString() {
        Object decodeValue = decodeValue();
        IIX0o.x0XOIxOo(decodeValue, "null cannot be cast to non-null type kotlin.String");
        return (String) decodeValue;
    }

    @Override // xIXoO0Xx.oxoX
    @OOXIXo
    public final String decodeStringElement(@OOXIXo kotlinx.serialization.descriptors.XO descriptor, int i) {
        IIX0o.x0xO0oo(descriptor, "descriptor");
        return decodeString();
    }

    @OOXIXo
    public Object decodeValue() {
        throw new SerializationException(IO.oxoX(getClass()) + " can't retrieve untyped values");
    }

    @Override // xIXoO0Xx.oxoX
    public void endStructure(@OOXIXo kotlinx.serialization.descriptors.XO descriptor) {
        IIX0o.x0xO0oo(descriptor, "descriptor");
    }

    public <T> T decodeSerializableValue(@OOXIXo kotlinx.serialization.I0Io<? extends T> deserializer, @oOoXoXO T t) {
        IIX0o.x0xO0oo(deserializer, "deserializer");
        return (T) decodeSerializableValue(deserializer);
    }
}
