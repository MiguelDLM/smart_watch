package xIXoO0Xx;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import kotlin.jvm.internal.IIX0o;
import kotlinx.serialization.Oxx0xo;

/* loaded from: classes6.dex */
public interface II0XooXoX {
    @OOXIXo
    X0o0xo beginCollection(@OOXIXo kotlinx.serialization.descriptors.XO xo2, int i);

    @OOXIXo
    X0o0xo beginStructure(@OOXIXo kotlinx.serialization.descriptors.XO xo2);

    void encodeBoolean(boolean z);

    void encodeByte(byte b);

    void encodeChar(char c);

    void encodeDouble(double d);

    void encodeEnum(@OOXIXo kotlinx.serialization.descriptors.XO xo2, int i);

    void encodeFloat(float f);

    @OOXIXo
    II0XooXoX encodeInline(@OOXIXo kotlinx.serialization.descriptors.XO xo2);

    void encodeInt(int i);

    void encodeLong(long j);

    @kotlinx.serialization.oxoX
    void encodeNotNullMark();

    @kotlinx.serialization.oxoX
    void encodeNull();

    @kotlinx.serialization.oxoX
    <T> void encodeNullableSerializableValue(@OOXIXo Oxx0xo<? super T> oxx0xo, @oOoXoXO T t);

    <T> void encodeSerializableValue(@OOXIXo Oxx0xo<? super T> oxx0xo, T t);

    void encodeShort(short s);

    void encodeString(@OOXIXo String str);

    @OOXIXo
    kotlinx.serialization.modules.X0o0xo getSerializersModule();

    /* loaded from: classes6.dex */
    public static final class oIX0oI {
        @kotlinx.serialization.oxoX
        public static <T> void I0Io(@OOXIXo II0XooXoX iI0XooXoX, @OOXIXo Oxx0xo<? super T> serializer, @oOoXoXO T t) {
            IIX0o.x0xO0oo(serializer, "serializer");
            if (serializer.oIX0oI().I0Io()) {
                iI0XooXoX.encodeSerializableValue(serializer, t);
            } else if (t == null) {
                iI0XooXoX.encodeNull();
            } else {
                iI0XooXoX.encodeNotNullMark();
                iI0XooXoX.encodeSerializableValue(serializer, t);
            }
        }

        @OOXIXo
        public static X0o0xo oIX0oI(@OOXIXo II0XooXoX iI0XooXoX, @OOXIXo kotlinx.serialization.descriptors.XO descriptor, int i) {
            IIX0o.x0xO0oo(descriptor, "descriptor");
            return iI0XooXoX.beginStructure(descriptor);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static <T> void oxoX(@OOXIXo II0XooXoX iI0XooXoX, @OOXIXo Oxx0xo<? super T> serializer, T t) {
            IIX0o.x0xO0oo(serializer, "serializer");
            serializer.II0xO0(iI0XooXoX, t);
        }

        @kotlinx.serialization.oxoX
        public static void II0xO0(@OOXIXo II0XooXoX iI0XooXoX) {
        }
    }
}
