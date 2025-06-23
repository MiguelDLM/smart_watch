package xIXoO0Xx;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IO;
import kotlinx.serialization.Oxx0xo;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.internal.x0xO;
import xIXoO0Xx.II0XooXoX;
import xIXoO0Xx.X0o0xo;

@kotlinx.serialization.oxoX
/* loaded from: classes6.dex */
public abstract class II0xO0 implements II0XooXoX, X0o0xo {
    @Override // xIXoO0Xx.II0XooXoX
    @OOXIXo
    public X0o0xo beginCollection(@OOXIXo kotlinx.serialization.descriptors.XO xo2, int i) {
        return II0XooXoX.oIX0oI.oIX0oI(this, xo2, i);
    }

    @Override // xIXoO0Xx.II0XooXoX
    @OOXIXo
    public X0o0xo beginStructure(@OOXIXo kotlinx.serialization.descriptors.XO descriptor) {
        IIX0o.x0xO0oo(descriptor, "descriptor");
        return this;
    }

    @Override // xIXoO0Xx.II0XooXoX
    public void encodeBoolean(boolean z) {
        encodeValue(Boolean.valueOf(z));
    }

    @Override // xIXoO0Xx.X0o0xo
    public final void encodeBooleanElement(@OOXIXo kotlinx.serialization.descriptors.XO descriptor, int i, boolean z) {
        IIX0o.x0xO0oo(descriptor, "descriptor");
        if (encodeElement(descriptor, i)) {
            encodeBoolean(z);
        }
    }

    @Override // xIXoO0Xx.II0XooXoX
    public void encodeByte(byte b) {
        encodeValue(Byte.valueOf(b));
    }

    @Override // xIXoO0Xx.X0o0xo
    public final void encodeByteElement(@OOXIXo kotlinx.serialization.descriptors.XO descriptor, int i, byte b) {
        IIX0o.x0xO0oo(descriptor, "descriptor");
        if (encodeElement(descriptor, i)) {
            encodeByte(b);
        }
    }

    @Override // xIXoO0Xx.II0XooXoX
    public void encodeChar(char c) {
        encodeValue(Character.valueOf(c));
    }

    @Override // xIXoO0Xx.X0o0xo
    public final void encodeCharElement(@OOXIXo kotlinx.serialization.descriptors.XO descriptor, int i, char c) {
        IIX0o.x0xO0oo(descriptor, "descriptor");
        if (encodeElement(descriptor, i)) {
            encodeChar(c);
        }
    }

    @Override // xIXoO0Xx.II0XooXoX
    public void encodeDouble(double d) {
        encodeValue(Double.valueOf(d));
    }

    @Override // xIXoO0Xx.X0o0xo
    public final void encodeDoubleElement(@OOXIXo kotlinx.serialization.descriptors.XO descriptor, int i, double d) {
        IIX0o.x0xO0oo(descriptor, "descriptor");
        if (encodeElement(descriptor, i)) {
            encodeDouble(d);
        }
    }

    public boolean encodeElement(@OOXIXo kotlinx.serialization.descriptors.XO descriptor, int i) {
        IIX0o.x0xO0oo(descriptor, "descriptor");
        return true;
    }

    @Override // xIXoO0Xx.II0XooXoX
    public void encodeEnum(@OOXIXo kotlinx.serialization.descriptors.XO enumDescriptor, int i) {
        IIX0o.x0xO0oo(enumDescriptor, "enumDescriptor");
        encodeValue(Integer.valueOf(i));
    }

    @Override // xIXoO0Xx.II0XooXoX
    public void encodeFloat(float f) {
        encodeValue(Float.valueOf(f));
    }

    @Override // xIXoO0Xx.X0o0xo
    public final void encodeFloatElement(@OOXIXo kotlinx.serialization.descriptors.XO descriptor, int i, float f) {
        IIX0o.x0xO0oo(descriptor, "descriptor");
        if (encodeElement(descriptor, i)) {
            encodeFloat(f);
        }
    }

    @Override // xIXoO0Xx.II0XooXoX
    @OOXIXo
    public II0XooXoX encodeInline(@OOXIXo kotlinx.serialization.descriptors.XO descriptor) {
        IIX0o.x0xO0oo(descriptor, "descriptor");
        return this;
    }

    @Override // xIXoO0Xx.X0o0xo
    @OOXIXo
    public final II0XooXoX encodeInlineElement(@OOXIXo kotlinx.serialization.descriptors.XO descriptor, int i) {
        IIX0o.x0xO0oo(descriptor, "descriptor");
        if (encodeElement(descriptor, i)) {
            return encodeInline(descriptor.X0o0xo(i));
        }
        return x0xO.f30750oIX0oI;
    }

    @Override // xIXoO0Xx.II0XooXoX
    public void encodeInt(int i) {
        encodeValue(Integer.valueOf(i));
    }

    @Override // xIXoO0Xx.X0o0xo
    public final void encodeIntElement(@OOXIXo kotlinx.serialization.descriptors.XO descriptor, int i, int i2) {
        IIX0o.x0xO0oo(descriptor, "descriptor");
        if (encodeElement(descriptor, i)) {
            encodeInt(i2);
        }
    }

    @Override // xIXoO0Xx.II0XooXoX
    public void encodeLong(long j) {
        encodeValue(Long.valueOf(j));
    }

    @Override // xIXoO0Xx.X0o0xo
    public final void encodeLongElement(@OOXIXo kotlinx.serialization.descriptors.XO descriptor, int i, long j) {
        IIX0o.x0xO0oo(descriptor, "descriptor");
        if (encodeElement(descriptor, i)) {
            encodeLong(j);
        }
    }

    @Override // xIXoO0Xx.II0XooXoX
    @kotlinx.serialization.oxoX
    public void encodeNotNullMark() {
        II0XooXoX.oIX0oI.II0xO0(this);
    }

    @Override // xIXoO0Xx.II0XooXoX
    public void encodeNull() {
        throw new SerializationException("'null' is not supported by default");
    }

    @Override // xIXoO0Xx.X0o0xo
    public <T> void encodeNullableSerializableElement(@OOXIXo kotlinx.serialization.descriptors.XO descriptor, int i, @OOXIXo Oxx0xo<? super T> serializer, @oOoXoXO T t) {
        IIX0o.x0xO0oo(descriptor, "descriptor");
        IIX0o.x0xO0oo(serializer, "serializer");
        if (encodeElement(descriptor, i)) {
            encodeNullableSerializableValue(serializer, t);
        }
    }

    @Override // xIXoO0Xx.II0XooXoX
    @kotlinx.serialization.oxoX
    public <T> void encodeNullableSerializableValue(@OOXIXo Oxx0xo<? super T> oxx0xo, @oOoXoXO T t) {
        II0XooXoX.oIX0oI.I0Io(this, oxx0xo, t);
    }

    @Override // xIXoO0Xx.X0o0xo
    public <T> void encodeSerializableElement(@OOXIXo kotlinx.serialization.descriptors.XO descriptor, int i, @OOXIXo Oxx0xo<? super T> serializer, T t) {
        IIX0o.x0xO0oo(descriptor, "descriptor");
        IIX0o.x0xO0oo(serializer, "serializer");
        if (encodeElement(descriptor, i)) {
            encodeSerializableValue(serializer, t);
        }
    }

    @Override // xIXoO0Xx.II0XooXoX
    public <T> void encodeSerializableValue(@OOXIXo Oxx0xo<? super T> oxx0xo, T t) {
        II0XooXoX.oIX0oI.oxoX(this, oxx0xo, t);
    }

    @Override // xIXoO0Xx.II0XooXoX
    public void encodeShort(short s) {
        encodeValue(Short.valueOf(s));
    }

    @Override // xIXoO0Xx.X0o0xo
    public final void encodeShortElement(@OOXIXo kotlinx.serialization.descriptors.XO descriptor, int i, short s) {
        IIX0o.x0xO0oo(descriptor, "descriptor");
        if (encodeElement(descriptor, i)) {
            encodeShort(s);
        }
    }

    @Override // xIXoO0Xx.II0XooXoX
    public void encodeString(@OOXIXo String value) {
        IIX0o.x0xO0oo(value, "value");
        encodeValue(value);
    }

    @Override // xIXoO0Xx.X0o0xo
    public final void encodeStringElement(@OOXIXo kotlinx.serialization.descriptors.XO descriptor, int i, @OOXIXo String value) {
        IIX0o.x0xO0oo(descriptor, "descriptor");
        IIX0o.x0xO0oo(value, "value");
        if (encodeElement(descriptor, i)) {
            encodeString(value);
        }
    }

    public void encodeValue(@OOXIXo Object value) {
        IIX0o.x0xO0oo(value, "value");
        throw new SerializationException("Non-serializable " + IO.oxoX(value.getClass()) + " is not supported by " + IO.oxoX(getClass()) + " encoder");
    }

    @Override // xIXoO0Xx.X0o0xo
    public void endStructure(@OOXIXo kotlinx.serialization.descriptors.XO descriptor) {
        IIX0o.x0xO0oo(descriptor, "descriptor");
    }

    @Override // xIXoO0Xx.X0o0xo
    @kotlinx.serialization.oxoX
    public boolean shouldEncodeElementDefault(@OOXIXo kotlinx.serialization.descriptors.XO xo2, int i) {
        return X0o0xo.oIX0oI.oIX0oI(this, xo2, i);
    }
}
