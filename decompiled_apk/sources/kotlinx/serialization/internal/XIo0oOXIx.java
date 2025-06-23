package kotlinx.serialization.internal;

import kotlinx.serialization.SerializationException;

@kotlin.o0
/* loaded from: classes6.dex */
public final class XIo0oOXIx implements kotlinx.serialization.Oxx0IOOO {

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final XIo0oOXIx f30700oIX0oI = new XIo0oOXIx();

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final kotlinx.serialization.descriptors.XO f30699II0xO0 = OO0x0xX.f30653oIX0oI;

    @Override // kotlinx.serialization.Oxx0xo
    /* renamed from: Oxx0IOOO, reason: merged with bridge method [inline-methods] */
    public void II0xO0(@OXOo.OOXIXo xIXoO0Xx.II0XooXoX encoder, @OXOo.OOXIXo Void value) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(encoder, "encoder");
        kotlin.jvm.internal.IIX0o.x0xO0oo(value, "value");
        throw new SerializationException("'kotlin.Nothing' cannot be serialized");
    }

    @Override // kotlinx.serialization.I0Io
    @OXOo.OOXIXo
    /* renamed from: XO, reason: merged with bridge method [inline-methods] */
    public Void oxoX(@OXOo.OOXIXo xIXoO0Xx.XO decoder) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(decoder, "decoder");
        throw new SerializationException("'kotlin.Nothing' does not have instances");
    }

    @Override // kotlinx.serialization.Oxx0IOOO, kotlinx.serialization.Oxx0xo, kotlinx.serialization.I0Io
    @OXOo.OOXIXo
    public kotlinx.serialization.descriptors.XO oIX0oI() {
        return f30699II0xO0;
    }
}
