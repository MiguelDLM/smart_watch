package xIXoO0Xx;

import OXOo.OOXIXo;
import Oox.oOoXoXO;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes6.dex */
public final class Oxx0IOOO {
    public static final <T> T II0xO0(@OOXIXo XO xo2, @OOXIXo kotlinx.serialization.descriptors.XO descriptor, @OOXIXo oOoXoXO<? super oxoX, ? extends T> block) {
        IIX0o.x0xO0oo(xo2, "<this>");
        IIX0o.x0xO0oo(descriptor, "descriptor");
        IIX0o.x0xO0oo(block, "block");
        oxoX beginStructure = xo2.beginStructure(descriptor);
        T invoke = block.invoke(beginStructure);
        beginStructure.endStructure(descriptor);
        return invoke;
    }

    @OXOo.oOoXoXO
    public static final <T> T oIX0oI(@OOXIXo XO xo2, @OOXIXo kotlinx.serialization.I0Io<? extends T> deserializer, @OOXIXo Oox.oIX0oI<? extends T> block) {
        IIX0o.x0xO0oo(xo2, "<this>");
        IIX0o.x0xO0oo(deserializer, "deserializer");
        IIX0o.x0xO0oo(block, "block");
        if (!deserializer.oIX0oI().I0Io() && !xo2.decodeNotNullMark()) {
            return (T) xo2.decodeNull();
        }
        return block.invoke();
    }
}
