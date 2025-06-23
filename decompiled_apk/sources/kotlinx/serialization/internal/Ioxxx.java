package kotlinx.serialization.internal;

@kotlin.o0
/* loaded from: classes6.dex */
public final class Ioxxx<T> implements kotlinx.serialization.Oxx0IOOO<T> {

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public final kotlinx.serialization.descriptors.XO f30635II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public final kotlinx.serialization.Oxx0IOOO<T> f30636oIX0oI;

    public Ioxxx(@OXOo.OOXIXo kotlinx.serialization.Oxx0IOOO<T> serializer) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(serializer, "serializer");
        this.f30636oIX0oI = serializer;
        this.f30635II0xO0 = new oXIO0o0XI(serializer.oIX0oI());
    }

    @Override // kotlinx.serialization.Oxx0xo
    public void II0xO0(@OXOo.OOXIXo xIXoO0Xx.II0XooXoX encoder, @OXOo.oOoXoXO T t) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(encoder, "encoder");
        if (t != null) {
            encoder.encodeNotNullMark();
            encoder.encodeSerializableValue(this.f30636oIX0oI, t);
        } else {
            encoder.encodeNull();
        }
    }

    public boolean equals(@OXOo.oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && Ioxxx.class == obj.getClass() && kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.f30636oIX0oI, ((Ioxxx) obj).f30636oIX0oI)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f30636oIX0oI.hashCode();
    }

    @Override // kotlinx.serialization.Oxx0IOOO, kotlinx.serialization.Oxx0xo, kotlinx.serialization.I0Io
    @OXOo.OOXIXo
    public kotlinx.serialization.descriptors.XO oIX0oI() {
        return this.f30635II0xO0;
    }

    @Override // kotlinx.serialization.I0Io
    @OXOo.oOoXoXO
    public T oxoX(@OXOo.OOXIXo xIXoO0Xx.XO decoder) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(decoder, "decoder");
        if (decoder.decodeNotNullMark()) {
            return (T) decoder.decodeSerializableValue(this.f30636oIX0oI);
        }
        return (T) decoder.decodeNull();
    }
}
