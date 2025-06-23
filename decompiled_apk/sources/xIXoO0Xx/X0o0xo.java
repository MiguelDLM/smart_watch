package xIXoO0Xx;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import kotlin.jvm.internal.IIX0o;
import kotlinx.serialization.Oxx0xo;

/* loaded from: classes6.dex */
public interface X0o0xo {

    /* loaded from: classes6.dex */
    public static final class oIX0oI {
        @kotlinx.serialization.oxoX
        public static boolean oIX0oI(@OOXIXo X0o0xo x0o0xo, @OOXIXo kotlinx.serialization.descriptors.XO descriptor, int i) {
            IIX0o.x0xO0oo(descriptor, "descriptor");
            return true;
        }
    }

    void encodeBooleanElement(@OOXIXo kotlinx.serialization.descriptors.XO xo2, int i, boolean z);

    void encodeByteElement(@OOXIXo kotlinx.serialization.descriptors.XO xo2, int i, byte b);

    void encodeCharElement(@OOXIXo kotlinx.serialization.descriptors.XO xo2, int i, char c);

    void encodeDoubleElement(@OOXIXo kotlinx.serialization.descriptors.XO xo2, int i, double d);

    void encodeFloatElement(@OOXIXo kotlinx.serialization.descriptors.XO xo2, int i, float f);

    @OOXIXo
    II0XooXoX encodeInlineElement(@OOXIXo kotlinx.serialization.descriptors.XO xo2, int i);

    void encodeIntElement(@OOXIXo kotlinx.serialization.descriptors.XO xo2, int i, int i2);

    void encodeLongElement(@OOXIXo kotlinx.serialization.descriptors.XO xo2, int i, long j);

    @kotlinx.serialization.oxoX
    <T> void encodeNullableSerializableElement(@OOXIXo kotlinx.serialization.descriptors.XO xo2, int i, @OOXIXo Oxx0xo<? super T> oxx0xo, @oOoXoXO T t);

    <T> void encodeSerializableElement(@OOXIXo kotlinx.serialization.descriptors.XO xo2, int i, @OOXIXo Oxx0xo<? super T> oxx0xo, T t);

    void encodeShortElement(@OOXIXo kotlinx.serialization.descriptors.XO xo2, int i, short s);

    void encodeStringElement(@OOXIXo kotlinx.serialization.descriptors.XO xo2, int i, @OOXIXo String str);

    void endStructure(@OOXIXo kotlinx.serialization.descriptors.XO xo2);

    @OOXIXo
    kotlinx.serialization.modules.X0o0xo getSerializersModule();

    @kotlinx.serialization.oxoX
    boolean shouldEncodeElementDefault(@OOXIXo kotlinx.serialization.descriptors.XO xo2, int i);
}
