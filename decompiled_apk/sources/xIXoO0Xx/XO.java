package xIXoO0Xx;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

/* loaded from: classes6.dex */
public interface XO {

    @XX({"SMAP\nDecoding.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Decoding.kt\nkotlinx/serialization/encoding/Decoder$DefaultImpls\n+ 2 Decoding.kt\nkotlinx/serialization/encoding/DecodingKt\n*L\n1#1,575:1\n270#2,2:576\n*S KotlinDebug\n*F\n+ 1 Decoding.kt\nkotlinx/serialization/encoding/Decoder$DefaultImpls\n*L\n263#1:576,2\n*E\n"})
    /* loaded from: classes6.dex */
    public static final class oIX0oI {
        public static <T> T II0xO0(@OOXIXo XO xo2, @OOXIXo kotlinx.serialization.I0Io<? extends T> deserializer) {
            IIX0o.x0xO0oo(deserializer, "deserializer");
            return deserializer.oxoX(xo2);
        }

        @kotlinx.serialization.oxoX
        @oOoXoXO
        public static <T> T oIX0oI(@OOXIXo XO xo2, @OOXIXo kotlinx.serialization.I0Io<? extends T> deserializer) {
            IIX0o.x0xO0oo(deserializer, "deserializer");
            if (!deserializer.oIX0oI().I0Io() && !xo2.decodeNotNullMark()) {
                return (T) xo2.decodeNull();
            }
            return (T) xo2.decodeSerializableValue(deserializer);
        }
    }

    @OOXIXo
    oxoX beginStructure(@OOXIXo kotlinx.serialization.descriptors.XO xo2);

    boolean decodeBoolean();

    byte decodeByte();

    char decodeChar();

    double decodeDouble();

    int decodeEnum(@OOXIXo kotlinx.serialization.descriptors.XO xo2);

    float decodeFloat();

    @OOXIXo
    XO decodeInline(@OOXIXo kotlinx.serialization.descriptors.XO xo2);

    int decodeInt();

    long decodeLong();

    @kotlinx.serialization.oxoX
    boolean decodeNotNullMark();

    @kotlinx.serialization.oxoX
    @oOoXoXO
    Void decodeNull();

    @kotlinx.serialization.oxoX
    @oOoXoXO
    <T> T decodeNullableSerializableValue(@OOXIXo kotlinx.serialization.I0Io<? extends T> i0Io);

    <T> T decodeSerializableValue(@OOXIXo kotlinx.serialization.I0Io<? extends T> i0Io);

    short decodeShort();

    @OOXIXo
    String decodeString();

    @OOXIXo
    kotlinx.serialization.modules.X0o0xo getSerializersModule();
}
